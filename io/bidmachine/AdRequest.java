package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.ListValue;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.Placement;
import com.explorestack.protobuf.openrtb.Openrtb;
import com.explorestack.protobuf.openrtb.Request;
import com.explorestack.protobuf.openrtb.Response;
import io.bidmachine.AdPlacementConfig;
import io.bidmachine.AdRequest;
import io.bidmachine.AdRequestParameters;
import io.bidmachine.AdResponseLoader;
import io.bidmachine.ApiRequest;
import io.bidmachine.ProtoTransformer;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.core.Utils;
import io.bidmachine.displays.PlacementBuilder;
import io.bidmachine.measurer.OMSDKSettings;
import io.bidmachine.models.AuctionResult;
import io.bidmachine.models.DataRestrictions;
import io.bidmachine.models.RequestBuilder;
import io.bidmachine.models.RequestParams;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.protobuf.RequestExtension;
import io.bidmachine.protobuf.ResponsePayload;
import io.bidmachine.tracking.EventData;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public abstract class AdRequest<SelfType extends AdRequest, AdRequestParametersType extends AdRequestParameters, UnifiedAdRequestParamsType extends UnifiedAdRequestParams> {
    List<AdRequestListener<SelfType>> adRequestListeners;
    private final AdRequestParametersType adRequestParameters;
    AdResponse adResponse;
    private final AdResponseLoader adResponseLoader;
    final Queue<String> auctionUrlQueue;
    private final String id;
    List<InternalAdRequestListener<SelfType>> internalAdRequestListeners;
    private final AtomicBoolean isApiRequestCanceled;
    private final AtomicBoolean isApiRequestCompleted;
    private final AtomicBoolean isDestroyed;
    private final AtomicBoolean isLoading;
    private final AtomicBoolean isRequestExpired;
    private NetworkAdUnitManager networkAdUnitManager;
    private final Tag tag = new Tag("AdRequest");
    private final Runnable timeOutRunnable;
    private final BidMachineTrackingObject trackingObject;
    private UnifiedAdRequestParamsType unifiedAdRequestParams;

    public interface AdRequestListener<AdRequestType extends AdRequest> {
        void onRequestExpired(AdRequestType request);

        void onRequestFailed(AdRequestType request, BMError error);

        void onRequestSuccess(AdRequestType request, AuctionResult auctionResult);
    }

    interface InternalAdRequestListener<AdRequestType extends AdRequest> {
        void onRequestDestroyed(AdRequestType request);
    }

    protected abstract UnifiedAdRequestParamsType createUnifiedAdRequestParams(AdRequestParametersType adRequestParameters, TargetingParams targetingParams, DataRestrictions dataRestrictions);

    boolean isPlacementBuilderMatch(PlacementBuilder placementBuilder) {
        return true;
    }

    protected void onBeforeSetDisplayPlacementBuilder(Placement.DisplayPlacement.Builder displayPlacementBuilder) {
    }

    protected void onBeforeSetVideoPlacementBuilder(Placement.VideoPlacement.Builder videoPlacementBuilder) {
    }

    protected void onBuildPlacement(Placement.Builder builder) {
    }

    protected BMError verifyRequest() {
        return null;
    }

    protected AdRequest(AdRequestParametersType adRequestParameters) {
        String uuid = UUID.randomUUID().toString();
        this.id = uuid;
        this.isLoading = new AtomicBoolean(false);
        this.isApiRequestCanceled = new AtomicBoolean(false);
        this.isApiRequestCompleted = new AtomicBoolean(false);
        this.isRequestExpired = new AtomicBoolean(false);
        this.isDestroyed = new AtomicBoolean(false);
        this.timeOutRunnable = new Runnable() { // from class: io.bidmachine.AdRequest.1
            @Override // java.lang.Runnable
            public void run() {
                AdResponse receive = AdResponseManager.get().receive(AdRequest.this.adRequestParameters);
                if (receive != null) {
                    AdRequest.this.processApiRequestSuccess(receive);
                } else {
                    AdRequest.this.processApiRequestFail(BMError.TimeoutError, false);
                    AdRequest.this.cancel();
                }
            }
        };
        this.trackingObject = new BidMachineTrackingObject(uuid) { // from class: io.bidmachine.AdRequest.2
            @Override // io.bidmachine.tracking.TrackingObjectImpl, io.bidmachine.tracking.TrackingObject
            public List<String> getTrackingUrls(TrackEventType eventType) {
                AdResponse adResponse = AdRequest.this.getAdResponse();
                if (adResponse != null) {
                    return adResponse.getTrackUrlListByEvent(eventType);
                }
                return super.getTrackingUrls(eventType);
            }

            @Override // io.bidmachine.tracking.TrackingObjectImpl, io.bidmachine.tracking.TrackingObject
            public AdExtension.EventConfiguration getEventConfiguration() {
                AdResponse adResponse = AdRequest.this.getAdResponse();
                if (adResponse != null) {
                    return adResponse.getEventConfiguration();
                }
                return super.getEventConfiguration();
            }
        };
        this.adRequestParameters = adRequestParameters;
        this.adResponseLoader = new AdResponseLoader(uuid);
        this.auctionUrlQueue = new LinkedList();
    }

    protected final AdsType getAdsType() {
        return this.adRequestParameters.getAdsType();
    }

    public AdRequestParametersType getAdRequestParameters() {
        return this.adRequestParameters;
    }

    AdResponse getAdResponse() {
        return this.adResponse;
    }

    Object build(final Context context) {
        Map<String, Double> priceFloors;
        try {
            String sellerId = BidMachineImpl.get().getSellerId();
            if (TextUtils.isEmpty(sellerId)) {
                return BMError.notFound("SellerId");
            }
            BidMachineImpl bidMachineImpl = BidMachineImpl.get();
            SessionManager sessionManager = SessionManager.get();
            AdvertisingDataManager.updateInfo(context);
            TargetingParams targetingParams = (TargetingParams) RequestParams.resolveParams(this.adRequestParameters.getTargetingParams(), bidMachineImpl.getTargetingParams());
            UserRestrictionParams userRestrictionParams = bidMachineImpl.getUserRestrictionParams();
            PriceFloorParams priceFloorParams = this.adRequestParameters.getPriceFloorParams();
            if (priceFloorParams != null && !priceFloorParams.getPriceFloors().isEmpty()) {
                priceFloors = priceFloorParams.getPriceFloors();
            } else {
                priceFloors = bidMachineImpl.getPriceFloorParams().getPriceFloors();
            }
            if (priceFloors.isEmpty()) {
                return BMError.notFound("PriceFloors");
            }
            Request.Builder newBuilder = Request.newBuilder();
            Request.Item.Builder newBuilder2 = Request.Item.newBuilder();
            newBuilder2.setId(UUID.randomUUID().toString());
            newBuilder2.setQty(1);
            for (Map.Entry<String, Double> entry : priceFloors.entrySet()) {
                Request.Item.Deal.Builder newBuilder3 = Request.Item.Deal.newBuilder();
                newBuilder3.setId(entry.getKey());
                newBuilder3.setFlr(entry.getValue().doubleValue());
                newBuilder3.setFlrcur("USD");
                newBuilder2.addDeal(newBuilder3);
            }
            newBuilder.setContext(Any.pack(RequestDataRetriever.collectContext(context, bidMachineImpl, userRestrictionParams, targetingParams, null, getAdsType())));
            newBuilder.setTest(bidMachineImpl.isTestMode());
            newBuilder.addCur("USD");
            newBuilder.setAt(2);
            newBuilder.setTmax(10000);
            Placement.Builder newBuilder4 = Placement.newBuilder();
            newBuilder4.setSsai(0);
            newBuilder4.setSdk(BidMachine.NAME);
            newBuilder4.setSdkver("3.4.0");
            newBuilder4.setSecure(!Utils.canUseCleartextTraffic());
            for (Message.Builder builder : collectPlacementFormats(context, null, this.adRequestParameters.getAdPlacementConfig())) {
                if (builder instanceof Placement.DisplayPlacement.Builder) {
                    Placement.DisplayPlacement.Builder builder2 = (Placement.DisplayPlacement.Builder) builder;
                    onBeforeSetDisplayPlacementBuilder(builder2);
                    newBuilder4.setDisplay(builder2);
                } else if (builder instanceof Placement.VideoPlacement.Builder) {
                    Placement.VideoPlacement.Builder builder3 = (Placement.VideoPlacement.Builder) builder;
                    onBeforeSetVideoPlacementBuilder(builder3);
                    newBuilder4.setVideo(builder3);
                } else {
                    throw new IllegalArgumentException("Unsupported display type: " + builder);
                }
            }
            Struct.Builder newBuilder5 = Struct.newBuilder();
            OMSDKSettings.fillExtension(newBuilder5);
            ListValue.Builder newBuilder6 = ListValue.newBuilder();
            Iterator<AdResponse> it = AdResponseManager.get().peek(this.adRequestParameters).iterator();
            while (it.hasNext()) {
                newBuilder6.addValues(it.next().createBidCacheExtensionValue());
            }
            if (newBuilder6.getValuesCount() > 0) {
                newBuilder5.putFields("bid_cache", Value.newBuilder().setListValue(newBuilder6).build());
            }
            if (newBuilder5.getFieldsCount() > 0) {
                newBuilder4.setExt(newBuilder5);
            }
            onBuildPlacement(newBuilder4);
            newBuilder2.setSpec(Any.pack(newBuilder4.build()));
            newBuilder.addItem(newBuilder2.build());
            Struct.Builder newBuilder7 = Struct.newBuilder();
            Struct privateStruct = ExtraParamsManager.get().getPrivateStruct(context);
            if (privateStruct != null) {
                newBuilder7.putAllFields(privateStruct.getFieldsMap());
            }
            if (newBuilder7.getFieldsCount() > 0) {
                newBuilder.setExt(newBuilder7.build());
            }
            RequestExtension.Builder newBuilder8 = RequestExtension.newBuilder();
            newBuilder8.setSellerId(sellerId);
            String ifv = bidMachineImpl.getIFV();
            if (!TextUtils.isEmpty(ifv)) {
                newBuilder8.setIfv(ifv);
            }
            newBuilder8.setBmIfv(bidMachineImpl.obtainBMIFV(context));
            newBuilder8.setSessionId(sessionManager.getSessionId());
            newBuilder.addExtProto(Any.pack(newBuilder8.build()));
            return newBuilder.build();
        } catch (Throwable th) {
            Logger.w(th);
            return BMError.throwable("Exception creating ad request", th);
        }
    }

    List<Message.Builder> collectPlacementFormats(Context context, List<String> allowedNetworkKeyList, AdPlacementConfig adPlacementConfig) throws IllegalStateException {
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        AdsType adsType = getAdsType();
        adsType.collectPlacements(new SimpleContextProvider(context), this, obtainUnifiedRequestParams(), collectNetworkConfig(context, adsType, allowedNetworkKeyList), arrayList, copyOnWriteArrayList, adPlacementConfig, BidMachineImpl.get().getNetworksLoadingTimeOutSec());
        this.networkAdUnitManager = new NetworkAdUnitManager(copyOnWriteArrayList);
        return arrayList;
    }

    List<NetworkConfig> collectNetworkConfig(Context context, AdsType adsType, List<String> allowedNetworkKeyList) {
        HashMap hashMap = new HashMap();
        List<NetworkConfig> networkConfigList = this.adRequestParameters.getNetworkConfigList();
        if (networkConfigList == null) {
            Utils.putAll(hashMap, NetworkRegistry.copyOrNullInitializedNetworkConfigs(adsType));
        } else {
            hashMap.putAll(NetworkRegistry.createInitNetworkConfigMap());
            for (final NetworkConfig networkConfig : networkConfigList) {
                final String checkAndPutNetwork = NetworkRegistry.checkAndPutNetwork(context, adsType, networkConfig, hashMap);
                if (checkAndPutNetwork != null) {
                    logError(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda8
                        @Override // io.bidmachine.utils.lazy.LazyValue
                        public final Object get() {
                            String format;
                            format = String.format("%s was removed from AdRequest: %s", NetworkConfig.this.getNetworkKey(), checkAndPutNetwork);
                            return format;
                        }
                    });
                }
            }
        }
        if (allowedNetworkKeyList != null) {
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (!allowedNetworkKeyList.contains((String) ((Map.Entry) it.next()).getKey())) {
                    it.remove();
                }
            }
        }
        Utils.putAll(hashMap, NetworkRegistry.copyOrNullInitializedCoreNetworkConfigs(adsType));
        return new ArrayList(hashMap.values());
    }

    public AuctionResult getAuctionResult() {
        AdResponse adResponse = this.adResponse;
        if (adResponse != null) {
            return adResponse.getAuctionResult();
        }
        return null;
    }

    public void request(Context context) {
        if (!BidMachineImpl.get().isInitialized()) {
            processRequestFail(BMError.internal("BidMachine not initialized"));
            return;
        }
        if (isDestroyed()) {
            processRequestFail(BMError.RequestDestroyed);
            return;
        }
        BMError verifyRequest = verifyRequest();
        if (verifyRequest != null) {
            processRequestFail(verifyRequest);
        } else {
            if (isLoading()) {
                return;
            }
            setLoading(true);
            AdRequestExecutor.get().execute(new AnonymousClass3(context.getApplicationContext()));
        }
    }

    /* renamed from: io.bidmachine.AdRequest$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context val$applicationContext;

        AnonymousClass3(final Context val$applicationContext) {
            this.val$applicationContext = val$applicationContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AdRequest.this.cancel();
                AdRequest.this.unsubscribeTimeOut();
                if (AdRequest.this.adResponse != null) {
                    AdRequest.this.adResponse.detachAdRequest(AdRequest.this);
                    AdRequest.this.adResponse = null;
                }
                AdRequest.this.isApiRequestCanceled.set(false);
                AdRequest.this.isApiRequestCompleted.set(false);
                AdRequest.this.subscribeTimeOut();
                AdRequest.this.log(new LazyValue() { // from class: io.bidmachine.AdRequest$3$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        return AdRequest.AnonymousClass3.lambda$run$0();
                    }
                });
                AdRequest.this.trackingObject.eventStart(TrackEventType.AuctionRequest);
                ResponsePayload bidPayload = AdRequest.this.adRequestParameters.getBidPayload();
                if (bidPayload == null) {
                    AdRequest.this.processRequestObject(this.val$applicationContext);
                } else {
                    AdRequest.this.processBidPayload(bidPayload);
                }
            } catch (Throwable th) {
                Logger.w(th);
                AdRequest.this.processRequestFail(BMError.throwable("Exception loading ad request", th));
            }
        }

        static /* synthetic */ String lambda$run$0() {
            return "Request start";
        }
    }

    protected void processBidPayload(ResponsePayload responsePayload) {
        if (responsePayload == ResponsePayload.getDefaultInstance()) {
            processRequestFail(BMError.incorrectContent("BidPayload has invalid content"));
            return;
        }
        if (!isBidPayloadValid(responsePayload)) {
            processRequestFail(BMError.incorrectContent("BidPayload does not match with AdRequest"));
            return;
        }
        Openrtb responseCache = responsePayload.getResponseCache();
        if (responseCache != null && responseCache != Openrtb.getDefaultInstance()) {
            ProtoTransformer.toAdResponse(this.adRequestParameters, obtainNetworkAdUnitManager(), responseCache.getResponse(), new ProtoTransformer.Listener<AdResponse>() { // from class: io.bidmachine.AdRequest.4
                @Override // io.bidmachine.ProtoTransformer.Listener
                public void onSuccess(AdResponse adResponse) {
                    AdRequest.this.processApiRequestSuccess(adResponse);
                }

                @Override // io.bidmachine.ProtoTransformer.Listener
                public void onFail(BMError error) {
                    AdRequest.this.processApiRequestFail(error);
                }
            });
            return;
        }
        String responseCacheUrl = responsePayload.getResponseCacheUrl();
        if (!TextUtils.isEmpty(responseCacheUrl) && Utils.isHttpUrl(responseCacheUrl)) {
            retrieveBody(responseCacheUrl);
        } else {
            processRequestFail(BMError.incorrectContent("BidPayload does not contain Response or URL"));
        }
    }

    boolean isBidPayloadValid(ResponsePayload responsePayload) {
        Placement requestItemSpec = responsePayload.getRequestItemSpec();
        try {
            if (requestItemSpec != Placement.getDefaultInstance()) {
                return this.adRequestParameters.isPlacementObjectValid(requestItemSpec);
            }
            return true;
        } catch (Throwable th) {
            Logger.w(th);
            return false;
        }
    }

    void retrieveBody(String url) {
        processRequestBuilder(new ApiRequest.Builder().setMethod(NetworkRequest.Method.Get).setDataBinder(new ApiRequest.ApiResponseAuctionDataBinder()), url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processRequestObject(Context context) {
        BMError internal;
        prepareUrls();
        Object build = build(context);
        if (build instanceof Request) {
            processRequestBuilder(new ApiRequest.Builder().setRequestData((Request) build).setDataBinder(getAdsType().getBinder()), pollUrl());
            return;
        }
        if (build instanceof BMError) {
            internal = (BMError) build;
        } else {
            internal = BMError.internal("Failed to create ad request");
        }
        processRequestFail(internal);
    }

    void processRequestBuilder(final ApiRequest.Builder<Request, Response> requestBuilder, final String url) {
        if (canSendApiRequest()) {
            requestBuilder.url(url);
            this.adResponseLoader.load(this.adRequestParameters, obtainNetworkAdUnitManager(), requestBuilder, new AdResponseLoader.Listener() { // from class: io.bidmachine.AdRequest.5
                @Override // io.bidmachine.AdResponseLoader.Listener
                public void onSuccess(AdResponse adResponse) {
                    AdRequest.this.setAuctionUrl(url);
                    AdRequest.this.processApiRequestSuccess(adResponse);
                }

                @Override // io.bidmachine.AdResponseLoader.Listener
                public void onFail(BMError bmError) {
                    AdRequest.this.processApiRequestLoadedFail(requestBuilder, bmError);
                }

                @Override // io.bidmachine.AdResponseLoader.Listener
                public void onCancel() {
                    AdRequest.this.processApiRequestCancel();
                }
            });
        }
    }

    private boolean canSendApiRequest() {
        return !isDestroyed();
    }

    private boolean canProcessApiRequestResult() {
        return (isCompleted() || isCanceled() || isDestroyed()) ? false : true;
    }

    void prepareUrls() {
        this.auctionUrlQueue.clear();
        this.auctionUrlQueue.addAll(UrlProvider.getAuctionUrlQueue());
    }

    String pollUrl() {
        if (this.auctionUrlQueue.isEmpty()) {
            this.auctionUrlQueue.addAll(UrlProvider.getAuctionUrlQueue());
        }
        return this.auctionUrlQueue.poll();
    }

    void setAuctionUrl(String auctionUrl) {
        this.auctionUrlQueue.clear();
        this.auctionUrlQueue.add(auctionUrl);
    }

    public void notifyMediationWin() {
        BMError bMError;
        if (isCompleted()) {
            log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return AdRequest.lambda$notifyMediationWin$1();
                }
            });
            if (isDestroyed()) {
                bMError = BMError.RequestDestroyed;
            } else {
                bMError = isExpired() ? BMError.RequestExpired : null;
            }
            this.trackingObject.eventFinish(TrackEventType.MediationWin, getAdsType(), this.adResponse, bMError);
        }
    }

    static /* synthetic */ String lambda$notifyMediationWin$1() {
        return "notifyMediationWin";
    }

    public void notifyMediationLoss() {
        notifyMediationLoss(null, null);
    }

    public void notifyMediationLoss(final String winnerNetworkName, final Double winnerNetworkPrice) {
        BMError bMError;
        if (isCompleted()) {
            log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("notifyMediationLoss (winnerNetworkName - %s, winnerNetworkPrice - %s)", winnerNetworkName, winnerNetworkPrice);
                    return format;
                }
            });
            if (isDestroyed()) {
                bMError = BMError.RequestDestroyed;
            } else {
                bMError = isExpired() ? BMError.RequestExpired : null;
            }
            this.trackingObject.eventFinish(TrackEventType.MediationLoss, getAdsType(), new EventData().setNetworkName(winnerNetworkName).setPrice(winnerNetworkPrice), bMError);
        }
    }

    boolean isLoading() {
        return this.isLoading.get();
    }

    private void setLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    boolean isCompleted() {
        return this.isApiRequestCompleted.get();
    }

    boolean isCanceled() {
        return this.isApiRequestCanceled.get();
    }

    public boolean isDestroyed() {
        return this.isDestroyed.get();
    }

    public void destroy() {
        if (this.isDestroyed.compareAndSet(false, true)) {
            log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda5
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return AdRequest.lambda$destroy$3();
                }
            });
            this.trackingObject.eventFinish(TrackEventType.AuctionRequestDestroy, getAdsType(), this.adResponse, (BMError) null);
            cancel();
            unsubscribeTimeOut();
            this.trackingObject.clear();
            BidMachineFetcher.release(this);
            notifyRequestDestroyed();
            this.unifiedAdRequestParams = null;
            AdResponse adResponse = this.adResponse;
            if (adResponse != null) {
                adResponse.detachAdRequest(this);
                this.adResponse = null;
            }
        }
    }

    static /* synthetic */ String lambda$destroy$3() {
        return "destroy";
    }

    void clearNetworkAdUnits() {
        obtainNetworkAdUnitManager().notifyNetworkClearAuction();
    }

    void cancel() {
        this.adResponseLoader.cancel();
    }

    static /* synthetic */ String lambda$processExpired$4() {
        return "Request expired";
    }

    void processExpired() {
        log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return AdRequest.lambda$processExpired$4();
            }
        });
        this.isRequestExpired.set(true);
        List<AdRequestListener<SelfType>> list = this.adRequestListeners;
        if (list != null) {
            Iterator<AdRequestListener<SelfType>> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRequestExpired(this);
            }
        }
        Iterator<AdRequestListener<?>> it2 = BidMachineImpl.get().getAdRequestListeners().iterator();
        while (it2.hasNext()) {
            it2.next().onRequestExpired(this);
        }
        this.trackingObject.eventFinish(TrackEventType.AuctionRequestExpired, getAdsType(), this.adResponse, (BMError) null);
    }

    public boolean isExpired() {
        return isAdResponseExpired() || this.isRequestExpired.get();
    }

    boolean isAdResponseExpired() {
        AdResponse adResponse = this.adResponse;
        return adResponse != null && adResponse.isExpired();
    }

    public void addListener(AdRequestListener<SelfType> listener) {
        if (listener != null) {
            if (this.adRequestListeners == null) {
                this.adRequestListeners = new CopyOnWriteArrayList();
            }
            this.adRequestListeners.add(listener);
        }
    }

    public void removeListener(AdRequestListener<SelfType> listener) {
        List<AdRequestListener<SelfType>> list = this.adRequestListeners;
        if (list == null || listener == null) {
            return;
        }
        list.remove(listener);
    }

    void addInternalListener(InternalAdRequestListener<SelfType> listener) {
        if (listener != null) {
            if (this.internalAdRequestListeners == null) {
                this.internalAdRequestListeners = new CopyOnWriteArrayList();
            }
            this.internalAdRequestListeners.add(listener);
        }
    }

    void removeInternalListener(InternalAdRequestListener<SelfType> listener) {
        List<InternalAdRequestListener<SelfType>> list = this.internalAdRequestListeners;
        if (list == null || listener == null) {
            return;
        }
        list.remove(listener);
    }

    void notifyRequestDestroyed() {
        List<InternalAdRequestListener<SelfType>> list = this.internalAdRequestListeners;
        if (list != null) {
            Iterator<InternalAdRequestListener<SelfType>> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRequestDestroyed(this);
            }
        }
    }

    int obtainTimeOutMs() {
        Integer timeOutMs;
        int requestTimeOutMs = BidMachineImpl.get().getRequestTimeOutMs();
        return (requestTimeOutMs > 0 || (timeOutMs = this.adRequestParameters.getTimeOutMs()) == null || timeOutMs.intValue() <= 0) ? requestTimeOutMs : timeOutMs.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscribeTimeOut() {
        int obtainTimeOutMs = obtainTimeOutMs();
        if (obtainTimeOutMs > 0) {
            Utils.onBackgroundThread(this.timeOutRunnable, obtainTimeOutMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unsubscribeTimeOut() {
        Utils.cancelBackgroundThreadTask(this.timeOutRunnable);
    }

    void processApiRequestSuccess(final AdResponse adResponse) {
        if (!canProcessApiRequestResult()) {
            adResponse.detachAdRequest(this);
            return;
        }
        setLoading(false);
        this.isApiRequestCompleted.set(true);
        unsubscribeTimeOut();
        log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda7
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("Request success - %s", AdResponse.this);
                return format;
            }
        });
        this.adResponse = adResponse;
        adResponse.attachAdRequest(this);
        List<AdRequestListener<SelfType>> list = this.adRequestListeners;
        if (list != null) {
            Iterator<AdRequestListener<SelfType>> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRequestSuccess(this, adResponse.getAuctionResult());
            }
        }
        Iterator<AdRequestListener<?>> it2 = BidMachineImpl.get().getAdRequestListeners().iterator();
        while (it2.hasNext()) {
            it2.next().onRequestSuccess(this, adResponse.getAuctionResult());
        }
        this.trackingObject.eventFinish(TrackEventType.AuctionRequest, getAdsType(), adResponse, (BMError) null);
    }

    void processApiRequestLoadedFail(ApiRequest.Builder<Request, Response> requestBuilder, BMError bmError) {
        String poll;
        if (canProcessApiRequestResult()) {
            if (bmError != BMError.BMServerNoFill && (poll = this.auctionUrlQueue.poll()) != null) {
                processRequestBuilder(requestBuilder, poll);
            } else {
                processApiRequestFail(bmError);
            }
        }
    }

    void processApiRequestFail(BMError error) {
        processApiRequestFail(error, true);
    }

    void processApiRequestFail(BMError error, boolean needClearAdUnits) {
        if (canProcessApiRequestResult()) {
            setLoading(false);
            this.isApiRequestCompleted.set(true);
            if (error == null) {
                error = BMError.BMServerNoFill;
            }
            processRequestFail(error, needClearAdUnits);
        }
    }

    void processRequestFail(BMError error) {
        processRequestFail(error, true);
    }

    void processRequestFail(final BMError error, boolean needClearAdUnits) {
        log(new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda4
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("Request fail - %s", BMError.this);
                return format;
            }
        });
        unsubscribeTimeOut();
        if (needClearAdUnits) {
            clearNetworkAdUnits();
        }
        List<AdRequestListener<SelfType>> list = this.adRequestListeners;
        if (list != null) {
            Iterator<AdRequestListener<SelfType>> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRequestFailed(this, error);
            }
        }
        Iterator<AdRequestListener<?>> it2 = BidMachineImpl.get().getAdRequestListeners().iterator();
        while (it2.hasNext()) {
            it2.next().onRequestFailed(this, error);
        }
        this.trackingObject.eventFinish(TrackEventType.AuctionRequest, getAdsType(), (EventData) null, error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processApiRequestCancel() {
        if (canProcessApiRequestResult()) {
            setLoading(false);
            this.isApiRequestCanceled.set(true);
            unsubscribeTimeOut();
            this.trackingObject.eventFinish(TrackEventType.AuctionRequestCancel, getAdsType(), (EventData) null, (BMError) null);
            this.trackingObject.clearEvent(TrackEventType.AuctionRequest);
        }
    }

    final UnifiedAdRequestParamsType obtainUnifiedRequestParams() {
        if (this.unifiedAdRequestParams == null) {
            BidMachineImpl bidMachineImpl = BidMachineImpl.get();
            this.unifiedAdRequestParams = createUnifiedAdRequestParams(this.adRequestParameters, (TargetingParams) RequestParams.resolveParams(this.adRequestParameters.getTargetingParams(), bidMachineImpl.getTargetingParams()), bidMachineImpl.getUserRestrictionParams());
        }
        return this.unifiedAdRequestParams;
    }

    private NetworkAdUnitManager obtainNetworkAdUnitManager() {
        if (this.networkAdUnitManager == null) {
            this.networkAdUnitManager = new NetworkAdUnitManager();
        }
        return this.networkAdUnitManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(final LazyValue<String> message) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return AdRequest.this.m9605lambda$log$7$iobidmachineAdRequest(message);
            }
        });
    }

    /* renamed from: lambda$log$7$io-bidmachine-AdRequest, reason: not valid java name */
    /* synthetic */ String m9605lambda$log$7$iobidmachineAdRequest(LazyValue lazyValue) {
        return String.format("%s - %s", this.adRequestParameters.getAdsType(), lazyValue.get());
    }

    private void logError(final LazyValue<String> message) {
        Logger.e(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.AdRequest$$ExternalSyntheticLambda6
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return AdRequest.this.m9606lambda$logError$8$iobidmachineAdRequest(message);
            }
        });
    }

    /* renamed from: lambda$logError$8$io-bidmachine-AdRequest, reason: not valid java name */
    /* synthetic */ String m9606lambda$logError$8$iobidmachineAdRequest(LazyValue lazyValue) {
        return String.format("%s - %s", this.adRequestParameters.getAdsType(), lazyValue.get());
    }

    public String toString() {
        return this.tag.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static abstract class AdRequestBuilderImpl<SelfType extends RequestBuilder, ReturnType extends AdRequest<ReturnType, AdRequestParametersType, ?>, AdRequestParametersType extends AdRequestParameters> implements RequestBuilder<SelfType, ReturnType> {
        ResponsePayload bidPayload;
        CustomParams customParams;
        AdRequestListener<ReturnType> listener;
        List<NetworkConfig> networkConfigList;
        String placementId;
        PriceFloorParams priceFloorParams;
        TargetingParams targetingParams;
        Integer timeOutMs;

        protected abstract ReturnType build(AdRequestParametersType adRequestParametersType);

        protected abstract AdRequestParametersType createAdRequestParameters();

        @Override // io.bidmachine.models.RequestBuilder
        @Deprecated
        public SelfType setSessionAdParams(SessionAdParams sessionAdParams) {
            return this;
        }

        protected AdRequestBuilderImpl() {
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setPriceFloorParams(PriceFloorParams priceFloorParams) {
            this.priceFloorParams = priceFloorParams;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setTargetingParams(TargetingParams userParams) {
            this.targetingParams = userParams;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setNetworks(List<NetworkConfig> networkConfigList) {
            fillNetworkConfigs(networkConfigList);
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setNetworks(String jsonData) {
            ArrayList arrayList;
            ArrayList arrayList2 = null;
            if (!TextUtils.isEmpty(jsonData)) {
                try {
                    arrayList = new ArrayList();
                } catch (Exception e) {
                    e = e;
                }
                try {
                    JSONArray jSONArray = new JSONArray(jsonData);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        NetworkConfig create = NetworkConfigFactory.create(BidMachineImpl.get().getAppContext(), jSONArray.getJSONObject(i));
                        if (create != null) {
                            arrayList.add(create);
                        }
                    }
                    arrayList2 = arrayList;
                } catch (Exception e2) {
                    e = e2;
                    arrayList2 = arrayList;
                    Logger.w(e);
                    fillNetworkConfigs(arrayList2);
                    return this;
                }
            }
            fillNetworkConfigs(arrayList2);
            return this;
        }

        void fillNetworkConfigs(List<NetworkConfig> networkConfigList) {
            if (networkConfigList == null) {
                this.networkConfigList = new ArrayList();
            } else {
                this.networkConfigList = networkConfigList;
            }
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setLoadingTimeOut(Integer timeOutMs) {
            this.timeOutMs = timeOutMs;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setBidPayload(String bidPayload) {
            if (bidPayload == null) {
                this.bidPayload = null;
                return this;
            }
            try {
                this.bidPayload = ResponsePayload.parseFrom(Base64.decode(bidPayload, 0));
            } catch (Throwable th) {
                Logger.w(th);
            }
            if (this.bidPayload == null) {
                this.bidPayload = ResponsePayload.getDefaultInstance();
            }
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setPlacementId(String placementId) {
            this.placementId = placementId;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setListener(AdRequestListener<ReturnType> listener) {
            this.listener = listener;
            return this;
        }

        @Override // io.bidmachine.models.RequestBuilder
        public SelfType setCustomParams(CustomParams customParams) {
            this.customParams = customParams;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.bidmachine.models.RequestBuilder
        public ReturnType build() {
            ReturnType returntype = (ReturnType) BidTokenManager.findPreparedAdRequest(this.bidPayload);
            if (returntype == null) {
                returntype = (ReturnType) build(createAdRequestParameters());
            }
            fillAdRequestParameters(returntype.getAdRequestParameters());
            returntype.addListener(this.listener);
            return returntype;
        }

        private void fillAdRequestParameters(AdRequestParametersType adRequestParams) {
            adRequestParams.setAdPlacementConfig(new AdPlacementConfig.Builder(adRequestParams.getAdsFormat()).withPlacementId(this.placementId).withCustomParams(this.customParams).build());
            adRequestParams.setPriceFloorParams(this.priceFloorParams);
            adRequestParams.setTargetingParams(this.targetingParams);
            adRequestParams.setNetworkConfigList(this.networkConfigList);
            adRequestParams.setTimeOutMs(this.timeOutMs);
            adRequestParams.setBidPayload(this.bidPayload);
        }
    }
}
