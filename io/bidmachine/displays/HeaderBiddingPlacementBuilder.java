package io.bidmachine.displays;

import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.adcom.Ad;
import io.bidmachine.AdContentType;
import io.bidmachine.AdsType;
import io.bidmachine.BidMachineTrackingObject;
import io.bidmachine.ContextProvider;
import io.bidmachine.HeaderBiddingAdRequestParams;
import io.bidmachine.HeaderBiddingAdapter;
import io.bidmachine.HeaderBiddingCollectParamsCallback;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkAdapter;
import io.bidmachine.NetworkConfig;
import io.bidmachine.NetworkRegistry;
import io.bidmachine.ProtoExtConstants;
import io.bidmachine.TrackEventType;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.displays.HeaderBiddingPlacementBuilder;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingAd;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.tracking.EventData;
import io.bidmachine.tracking.TrackEventInfo;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
class HeaderBiddingPlacementBuilder<UnifiedAdRequestParamsType extends UnifiedAdRequestParams> {
    private static final long DEFAULT_HB_PREPARE_TIMEOUT_SEC = 10;

    HeaderBiddingPlacementBuilder() {
    }

    HeaderBiddingPlacement.Builder createPlacement(ContextProvider contextProvider, UnifiedAdRequestParamsType unifiedadrequestparamstype, AdsType adsType, AdContentType adContentType, Collection<NetworkConfig> collection, List<NetworkAdUnit> list, int i) {
        ArrayList<AdUnitPreloadTask> arrayList = new ArrayList();
        for (NetworkConfig networkConfig : collection) {
            NetworkAdapter adapter = NetworkRegistry.getAdapter(networkConfig.getNetworkKey());
            if ((adapter instanceof HeaderBiddingAdapter) && adapter.isInitialized(contextProvider)) {
                AdContentType adContentType2 = adContentType;
                for (NetworkAdUnit networkAdUnit : networkConfig.createNetworkAdUnitList(adsType, unifiedadrequestparamstype, adContentType2, adapter)) {
                    list.add(networkAdUnit);
                    arrayList.add(new AdUnitPreloadTask(contextProvider, (HeaderBiddingAdapter) adapter, adsType, adContentType2, unifiedadrequestparamstype, networkAdUnit));
                    adContentType2 = adContentType;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            BidMachineTrackingObject bidMachineTrackingObject = new BidMachineTrackingObject();
            bidMachineTrackingObject.eventStart(TrackEventType.HeaderBiddingNetworksPrepare);
            try {
                CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AdUnitPreloadTask) it.next()).execute(countDownLatch);
                }
                try {
                    countDownLatch.await(i > 0 ? i : 10L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    Logger.w(e);
                }
                ArrayList arrayList2 = null;
                for (AdUnitPreloadTask adUnitPreloadTask : arrayList) {
                    HeaderBiddingPlacement.AdUnit adUnit = adUnitPreloadTask.getAdUnit();
                    if (adUnit != null) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(adUnit);
                    } else if (!adUnitPreloadTask.isFinished()) {
                        adUnitPreloadTask.cancel();
                    }
                }
                if (!Utils.isEmpty(arrayList2)) {
                    HeaderBiddingPlacement.Builder newBuilder = HeaderBiddingPlacement.newBuilder();
                    newBuilder.addAllAdUnits(arrayList2);
                    return newBuilder;
                }
            } finally {
                bidMachineTrackingObject.eventFinish(TrackEventType.HeaderBiddingNetworksPrepare, adsType, (EventData) null, (BMError) null);
            }
        }
        return null;
    }

    AdObjectParams createAdObjectParams(Ad ad) {
        HeaderBiddingAd obtainHeaderBiddingAd = obtainHeaderBiddingAd(ad);
        if (obtainHeaderBiddingAd != null) {
            return new HeaderBiddingAdObjectParams(ad, obtainHeaderBiddingAd);
        }
        return null;
    }

    HeaderBiddingAd obtainHeaderBiddingAd(Ad ad) {
        if (ad.hasDisplay()) {
            Ad.Display display = ad.getDisplay();
            r1 = display.hasBanner() ? obtainHeaderBiddingAd(display.getBanner().getExtProtoList()) : null;
            if (r1 == null && display.hasNative()) {
                r1 = obtainHeaderBiddingAd(display.getNative().getExtProtoList());
            }
        }
        return (r1 == null && ad.hasVideo()) ? obtainHeaderBiddingAd(ad.getVideo().getExtProtoList()) : r1;
    }

    private HeaderBiddingAd obtainHeaderBiddingAd(List<Any> extensions) {
        for (Any any : extensions) {
            if (any.is(HeaderBiddingAd.class)) {
                try {
                    return (HeaderBiddingAd) any.unpack(HeaderBiddingAd.class);
                } catch (InvalidProtocolBufferException e) {
                    Logger.w(e);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class AdUnitPreloadTask<UnifiedAdRequestParamsType extends UnifiedAdRequestParams> implements Runnable, HeaderBiddingAdRequestParams, HeaderBiddingCollectParamsCallback {
        private static final Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        private final AdContentType adContentType;
        private final UnifiedAdRequestParamsType adRequestParams;
        private HeaderBiddingPlacement.AdUnit adUnit;
        private final HeaderBiddingAdapter adapter;
        private final AdsType adsType;
        private final ContextProvider contextProvider;
        private final NetworkAdUnit networkAdUnit;
        private CountDownLatch syncLock;
        private boolean isFinished = false;
        private final TrackingObject trackingObject = new BidMachineTrackingObject();

        AdUnitPreloadTask(ContextProvider contextProvider, HeaderBiddingAdapter adapter, AdsType adsType, AdContentType adContentType, UnifiedAdRequestParamsType adRequestParams, NetworkAdUnit networkAdUnit) {
            this.contextProvider = contextProvider;
            this.adapter = adapter;
            this.adsType = adsType;
            this.adContentType = adContentType;
            this.adRequestParams = adRequestParams;
            this.networkAdUnit = networkAdUnit;
        }

        @Override // io.bidmachine.HeaderBiddingAdRequestParams
        public AdsType getAdsType() {
            return this.adsType;
        }

        @Override // io.bidmachine.HeaderBiddingAdRequestParams
        public AdContentType getAdContentType() {
            return this.adContentType;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.adapter.collectHeaderBiddingParams(this.contextProvider, this.adRequestParams, this.networkAdUnit, this, this);
            } catch (Throwable th2) {
                th = th2;
                Logger.w(th);
                onCollectFail(BMError.throwable("Exception collecting header bidding parameters", th));
            }
        }

        @Override // io.bidmachine.HeaderBiddingCollectParamsCallback
        public void onCollectFinished(Map<String, String> params) {
            if (this.isFinished) {
                return;
            }
            this.adUnit = HeaderBiddingPlacement.AdUnit.newBuilder().setBidder(this.adapter.getKey()).setBidderSdkver(this.adapter.obtainNetworkSdkVersion()).putClientParams(ProtoExtConstants.AD_UNIT_ID, this.networkAdUnit.getId()).putAllClientParams(this.networkAdUnit.getMediationConfig()).putAllClientParams(params).build();
            Logger.d(this.adapter.getKey(), (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.displays.HeaderBiddingPlacementBuilder$AdUnitPreloadTask$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return HeaderBiddingPlacementBuilder.AdUnitPreloadTask.this.m9701xedc3bc5f();
                }
            });
            finish();
            this.trackingObject.eventFinish(TrackEventType.HeaderBiddingNetworkPrepare, this.adsType, new EventData().setNetworkName(this.adapter.getKey()), null);
        }

        /* renamed from: lambda$onCollectFinished$0$io-bidmachine-displays-HeaderBiddingPlacementBuilder$AdUnitPreloadTask, reason: not valid java name */
        /* synthetic */ String m9701xedc3bc5f() {
            return String.format("%s (%s) - Header bidding collect finished", this.adsType, this.adContentType);
        }

        @Override // io.bidmachine.HeaderBiddingCollectParamsCallback
        public void onCollectFail(final BMError error) {
            if (this.isFinished) {
                return;
            }
            Logger.d(this.adapter.getKey(), (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.displays.HeaderBiddingPlacementBuilder$AdUnitPreloadTask$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return HeaderBiddingPlacementBuilder.AdUnitPreloadTask.this.m9700xd6114512(error);
                }
            });
            finish();
            this.trackingObject.eventFinish(TrackEventType.HeaderBiddingNetworkPrepare, this.adsType, new EventData().setNetworkName(this.adapter.getKey()), error);
        }

        /* renamed from: lambda$onCollectFail$1$io-bidmachine-displays-HeaderBiddingPlacementBuilder$AdUnitPreloadTask, reason: not valid java name */
        /* synthetic */ String m9700xd6114512(BMError bMError) {
            return String.format("%s (%s) - Header bidding collect fail - %s", this.adsType, this.adContentType, bMError);
        }

        void execute(CountDownLatch syncLock) {
            this.trackingObject.eventStart(TrackEventType.HeaderBiddingNetworkPrepare, new TrackEventInfo().withParameter("HB_NETWORK", this.adapter.getKey()).withParameter("BM_AD_TYPE", this.adsType.getName()));
            this.syncLock = syncLock;
            executor.execute(this);
        }

        void cancel() {
            if (this.isFinished) {
                return;
            }
            Logger.d(this.adapter.getKey(), (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.displays.HeaderBiddingPlacementBuilder$AdUnitPreloadTask$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return HeaderBiddingPlacementBuilder.AdUnitPreloadTask.this.m9699xd1611246();
                }
            });
            finish();
        }

        /* renamed from: lambda$cancel$2$io-bidmachine-displays-HeaderBiddingPlacementBuilder$AdUnitPreloadTask, reason: not valid java name */
        /* synthetic */ String m9699xd1611246() {
            return String.format("%s (%s) - Header bidding collect fail: timeout", this.adsType, this.adContentType);
        }

        HeaderBiddingPlacement.AdUnit getAdUnit() {
            return this.adUnit;
        }

        boolean isFinished() {
            return this.isFinished;
        }

        private void finish() {
            this.isFinished = true;
            this.syncLock.countDown();
        }
    }
}
