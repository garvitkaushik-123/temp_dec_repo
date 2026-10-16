package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import com.explorestack.protobuf.ListValue;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.explorestack.protobuf.adcom.Context;
import com.explorestack.protobuf.adcom.DeviceType;
import com.explorestack.protobuf.adcom.OS;
import io.bidmachine.ApiRequest;
import io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingAdapter;
import io.bidmachine.ads.networks.nast.NastAdapter;
import io.bidmachine.ads.networks.vast.VastAdapter;
import io.bidmachine.core.Logger;
import io.bidmachine.core.NetworkRequest;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.InitRequest;
import io.bidmachine.protobuf.InitResponse;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.DeviceUtils;
import io.bidmachine.utils.ProtoUtils;
import io.bidmachine.utils.lazy.LazyValue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
class InitialRequest {
    private final Context applicationContext;
    private final Queue<String> baseUrlQueue;
    private ApiRequest<InitRequest, InitResponse> currentInitRequest;
    private final Queue<String> currentUrlQueue;
    private Listener listener;
    private final String sellerId;
    private static final long MIN_INIT_REQUEST_DELAY_MS = TimeUnit.SECONDS.toMillis(2);
    private static final long MAX_INIT_REQUEST_DELAY_MS = TimeUnit.SECONDS.toMillis(128);
    private long initRequestDelayMs = 0;
    private final TrackingObject trackingObject = new BidMachineTrackingObject();
    private final Runnable initialRunnable = new InitialRunnable(this);

    interface Listener extends NetworkRequest.Callback<InitResponse, BMError> {
    }

    public InitialRequest(Context applicationContext, String sellerId, Queue<String> urlList) {
        this.applicationContext = applicationContext;
        this.sellerId = sellerId;
        this.baseUrlQueue = new LinkedList(urlList);
        this.currentUrlQueue = new LinkedList(urlList);
    }

    void setListener(Listener listener) {
        this.listener = listener;
    }

    void request() {
        this.trackingObject.eventStart(TrackEventType.InitLoading, null);
        Utils.onBackgroundThread(new Runnable() { // from class: io.bidmachine.InitialRequest.1
            @Override // java.lang.Runnable
            public void run() {
                InitialRequest.this.currentInitRequest = new ApiRequest.Builder().url(InitialRequest.this.pollUrl()).setDataBinder(new ApiRequest.ApiInitDataBinder()).setRequestData(InitialRequest.this.createInitRequest()).setCallback(new C05861()).request();
            }

            /* renamed from: io.bidmachine.InitialRequest$1$1, reason: invalid class name and collision with other inner class name */
            class C05861 implements NetworkRequest.Callback<InitResponse, BMError> {
                C05861() {
                }

                @Override // io.bidmachine.core.NetworkRequest.Callback
                public void onSuccess(InitResponse initResponse) {
                    InitialRequest.this.currentInitRequest = null;
                    InitialRequest.this.initRequestDelayMs = 0L;
                    Utils.cancelBackgroundThreadTask(InitialRequest.this.initialRunnable);
                    if (InitialRequest.this.listener != null) {
                        InitialRequest.this.listener.onSuccess(initResponse);
                    }
                    InitialRequest.this.trackingObject.eventFinish(TrackEventType.InitLoading, null, null, null);
                }

                @Override // io.bidmachine.core.NetworkRequest.Callback
                public void onFail(BMError bmError) {
                    final long j;
                    InitialRequest.this.currentInitRequest = null;
                    if (InitialRequest.this.currentUrlQueue.isEmpty()) {
                        j = InitialRequest.this.calculateDelay();
                        Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.InitialRequest$1$1$$ExternalSyntheticLambda0
                            @Override // io.bidmachine.utils.lazy.LazyValue
                            public final Object get() {
                                String format;
                                format = String.format("reschedule init request (%s)", Long.valueOf(j));
                                return format;
                            }
                        });
                        if (InitialRequest.this.listener != null) {
                            InitialRequest.this.listener.onFail(bmError);
                        }
                    } else {
                        j = 0;
                    }
                    Utils.onBackgroundThread(InitialRequest.this.initialRunnable, j);
                    InitialRequest.this.trackingObject.eventFinish(TrackEventType.InitLoading, null, null, bmError);
                }
            }
        });
    }

    void destroy() {
        this.listener = null;
        this.currentInitRequest = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String pollUrl() {
        if (this.currentUrlQueue.isEmpty()) {
            this.currentUrlQueue.addAll(this.baseUrlQueue);
        }
        return this.currentUrlQueue.poll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InitRequest createInitRequest() {
        DeviceType deviceType;
        ConnectionType connectionType;
        AdvertisingDataManager.updateInfo(this.applicationContext);
        BidMachineImpl bidMachineImpl = BidMachineImpl.get();
        UserRestrictionParams userRestrictionParams = bidMachineImpl.getUserRestrictionParams();
        TargetingParams targetingParams = bidMachineImpl.getTargetingParams();
        InitRequest.Builder newBuilder = InitRequest.newBuilder();
        String packageName = this.applicationContext.getPackageName();
        if (packageName != null) {
            newBuilder.setBundle(packageName);
        }
        newBuilder.setSellerId(this.sellerId);
        newBuilder.setOs(OS.OS_ANDROID);
        newBuilder.setOsv(DeviceUtils.getOsVersion());
        String appVersion = Utils.getAppVersion(this.applicationContext);
        if (appVersion != null) {
            newBuilder.setAppVer(appVersion);
        }
        newBuilder.setSdk(BidMachine.NAME);
        newBuilder.setSdkver("3.4.0");
        newBuilder.setIfa(AdvertisingDataManager.getAdvertisingId(this.applicationContext, !userRestrictionParams.canSendIfa()));
        String ifv = bidMachineImpl.getIFV();
        if (!TextUtils.isEmpty(ifv)) {
            newBuilder.setIfv(ifv);
        }
        newBuilder.setBmIfv(bidMachineImpl.obtainBMIFV(this.applicationContext));
        newBuilder.setSessionId(SessionManager.get().getSessionId());
        DeviceInfo obtain = DeviceInfo.obtain(this.applicationContext);
        String str = obtain.manufacturer;
        if (str != null) {
            newBuilder.setMake(str);
        }
        String str2 = obtain.model;
        if (str2 != null) {
            newBuilder.setModel(str2);
        }
        String hwv = obtain.getHWV();
        if (hwv != null) {
            newBuilder.setHwv(hwv);
        }
        if (obtain.isTablet) {
            deviceType = DeviceType.DEVICE_TYPE_TABLET;
        } else {
            deviceType = DeviceType.DEVICE_TYPE_PHONE_DEVICE;
        }
        newBuilder.setDeviceType(deviceType);
        if (userRestrictionParams.canSendDeviceInfo()) {
            connectionType = DeviceUtils.getConnectionType(this.applicationContext);
            newBuilder.setContype(connectionType);
        } else {
            connectionType = null;
        }
        if (userRestrictionParams.canSendGeoPosition()) {
            Context.Geo.Builder createGeoBuilderWithLocation = ProtoUtils.createGeoBuilderWithLocation(this.applicationContext, targetingParams.getDeviceLocation(), null, true);
            targetingParams.build(createGeoBuilderWithLocation);
            newBuilder.setGeo(createGeoBuilderWithLocation);
        }
        newBuilder.setContext(RequestDataRetriever.collectContext(this.applicationContext, bidMachineImpl, userRestrictionParams, targetingParams, connectionType, null));
        newBuilder.setAndroid(createPlatformData(this.applicationContext));
        newBuilder.setExt(createExtension(this.applicationContext));
        return newBuilder.build();
    }

    private InitRequest.AndroidPlatformData createPlatformData(android.content.Context context) {
        PlatformData platformData = PlatformData.get(context);
        final InitRequest.AndroidPlatformData.Builder newBuilder = InitRequest.AndroidPlatformData.newBuilder();
        Integer minSdkVersion = platformData.getMinSdkVersion();
        Objects.requireNonNull(newBuilder);
        Utils.ifNotNull(minSdkVersion, new Executable() { // from class: io.bidmachine.InitialRequest$$ExternalSyntheticLambda0
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                InitRequest.AndroidPlatformData.Builder.this.setMinApiLevel(((Integer) obj).intValue());
            }
        });
        String str = platformData.kotlinVersion;
        Objects.requireNonNull(newBuilder);
        Utils.ifNotNull(str, new Executable() { // from class: io.bidmachine.InitialRequest$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                InitRequest.AndroidPlatformData.Builder.this.setKotlinVersion((String) obj);
            }
        });
        return newBuilder.build();
    }

    private Struct createExtension(android.content.Context context) {
        Struct.Builder newBuilder = Struct.newBuilder();
        newBuilder.putFields("networks_info", Value.newBuilder().setListValue(createNetworkInfoListValue(context)).build());
        return newBuilder.build();
    }

    private ListValue.Builder createNetworkInfoListValue(android.content.Context context) {
        ListValue.Builder newBuilder = ListValue.newBuilder();
        for (NetworkAssetParams networkAssetParams : NetworkAssetManager.getNetworkAssetParamsMap(context).values()) {
            newBuilder.addValues(createNetworkInfoValue(networkAssetParams.getName(), networkAssetParams.getSdkVersion(), networkAssetParams.getAdapterVersion()));
        }
        newBuilder.addValues(createNetworkInfoValue("mraid", "3.4.0", "3.4.0.1"));
        newBuilder.addValues(createNetworkInfoValue(VastAdapter.KEY, "3.4.0", "3.4.0.1"));
        newBuilder.addValues(createNetworkInfoValue(NastAdapter.KEY, "1.0", "3.4.0.1"));
        newBuilder.addValues(createNetworkInfoValue(AdaptiveRenderingAdapter.KEY, "3.4.0", "3.4.0.1"));
        return newBuilder;
    }

    private Value createNetworkInfoValue(String networkName, String networkVersion, String networkAdapterVersion) {
        Value build = Value.newBuilder().setStringValue(networkName).build();
        Value build2 = Value.newBuilder().setStringValue(networkVersion).build();
        return Value.newBuilder().setStructValue(Struct.newBuilder().putFields("network", build).putFields("network_version", build2).putFields("network_adapter_version", Value.newBuilder().setStringValue(networkAdapterVersion).build()).build()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long calculateDelay() {
        long j = this.initRequestDelayMs;
        if (j <= 0) {
            this.initRequestDelayMs = MIN_INIT_REQUEST_DELAY_MS;
        } else {
            long j2 = j * 2;
            this.initRequestDelayMs = j2;
            long j3 = MAX_INIT_REQUEST_DELAY_MS;
            if (j2 >= j3) {
                this.initRequestDelayMs = j3;
            }
        }
        return this.initRequestDelayMs;
    }

    private static class InitialRunnable implements Runnable {
        private final WeakReference<InitialRequest> weakInitialRequest;

        public InitialRunnable(InitialRequest initialRequest) {
            this.weakInitialRequest = new WeakReference<>(initialRequest);
        }

        @Override // java.lang.Runnable
        public void run() {
            InitialRequest initialRequest = this.weakInitialRequest.get();
            if (initialRequest != null) {
                initialRequest.request();
            }
        }
    }
}
