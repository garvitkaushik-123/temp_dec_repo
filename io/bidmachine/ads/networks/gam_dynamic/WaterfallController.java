package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import android.text.TextUtils;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.UInt32Value;
import com.explorestack.protobuf.UInt64Value;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam_dynamic.WaterfallLoader;
import io.bidmachine.ads.networks.gam_dynamic.WaterfallNetworkRequest;
import io.bidmachine.ads.networks.gam_dynamic.versions.VersionWrapper;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.util.taskmanager.TaskManager;
import io.bidmachine.util.taskmanager.coroutine.NetworkTaskManager;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes7.dex */
class WaterfallController {
    private static final TaskManager TASK_MANAGER = new NetworkTaskManager();
    final AdsFormat adsFormat;
    private final Context applicationContext;
    int cacheSize;
    private final GAMAdManager gamAdManager;
    private final GAMEventTracker gamEventTracker;
    private final GAMNetwork gamNetwork;
    String id;
    int maxRetryDegree;
    private final NetworkParams networkParams;
    long refreshTimeOutMs;
    String refreshUrl;
    int retryBaseSec;
    StringValue serverParams;
    private final Tag tag;
    private final TaskExecutor taskExecutor;
    private final VersionWrapper versionWrapper;
    WaterfallLoader waterfallLoader;
    final List<Waterfall.Configuration.AdUnit> adUnitList = new LinkedList();
    final AtomicBoolean isLoading = new AtomicBoolean(false);
    final AtomicBoolean isPolling = new AtomicBoolean(false);
    final AtomicBoolean isShouldPollAfter = new AtomicBoolean(false);
    final AtomicInteger failedWaterfallLoadAttempts = new AtomicInteger(0);

    public WaterfallController(Context context, NetworkParams networkParams, AdsFormat adsFormat, Waterfall.Configuration waterfallConfiguration, VersionWrapper versionWrapper, GAMNetwork gamNetwork, GAMAdManager gamAdManager, GAMEventTracker gamEventTracker, TaskExecutor taskExecutor) {
        this.tag = new Tag(networkParams.getNetworkName() + "WaterfallController");
        this.applicationContext = context.getApplicationContext();
        this.networkParams = networkParams;
        this.adsFormat = adsFormat;
        this.versionWrapper = versionWrapper;
        this.gamNetwork = gamNetwork;
        this.gamAdManager = gamAdManager;
        this.taskExecutor = taskExecutor;
        this.gamEventTracker = gamEventTracker;
        setWaterfallConfiguration(waterfallConfiguration);
    }

    public void load(boolean isForced) {
        if (!this.isLoading.compareAndSet(false, true)) {
            if (!isForced || this.isPolling.get()) {
                return;
            }
            this.isShouldPollAfter.set(true);
            return;
        }
        this.isPolling.set(true);
        this.failedWaterfallLoadAttempts.set(0);
        loadWaterfall();
    }

    void setWaterfallConfiguration(Waterfall.Configuration waterfallConfiguration) {
        this.id = waterfallConfiguration.getId();
        this.adUnitList.clear();
        List<Waterfall.Configuration.AdUnit> adUnitsList = waterfallConfiguration.getAdUnitsList();
        if (adUnitsList != null && !adUnitsList.isEmpty()) {
            this.adUnitList.addAll(adUnitsList);
            sortDescByPrice(this.adUnitList);
        }
        StringValue refreshUrl = waterfallConfiguration.hasRefreshUrl() ? waterfallConfiguration.getRefreshUrl() : null;
        if (refreshUrl != null) {
            String value = refreshUrl.getValue();
            if (!TextUtils.isEmpty(value) && Utils.isHttpUrl(value)) {
                this.refreshUrl = refreshUrl.getValue();
            }
        }
        UInt32Value cacheSize = waterfallConfiguration.hasCacheSize() ? waterfallConfiguration.getCacheSize() : null;
        this.cacheSize = cacheSize != null ? cacheSize.getValue() : 1;
        UInt32Value retryBase = waterfallConfiguration.hasRetryBase() ? waterfallConfiguration.getRetryBase() : null;
        this.retryBaseSec = retryBase != null ? retryBase.getValue() : 2;
        UInt32Value maxRetryDegree = waterfallConfiguration.hasMaxRetryDegree() ? waterfallConfiguration.getMaxRetryDegree() : null;
        this.maxRetryDegree = maxRetryDegree != null ? maxRetryDegree.getValue() : 5;
        UInt64Value refreshTimeout = waterfallConfiguration.hasRefreshTimeout() ? waterfallConfiguration.getRefreshTimeout() : null;
        this.refreshTimeOutMs = refreshTimeout != null ? refreshTimeout.getValue() : 10000L;
        this.serverParams = waterfallConfiguration.hasServerParams() ? waterfallConfiguration.getServerParams() : null;
    }

    void loadWaterfall() {
        this.isShouldPollAfter.set(false);
        this.waterfallLoader = new WaterfallLoader(this.applicationContext, this.networkParams, this.adsFormat, this.versionWrapper, this.gamNetwork, this.gamAdManager, this.gamEventTracker, this.taskExecutor, this.id, this.adUnitList, this.cacheSize, new WaterfallLoaderListener());
        final long calculateLoadingDelayMs = calculateLoadingDelayMs();
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallController$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return WaterfallController.this.m9672x2b543c4e(calculateLoadingDelayMs);
            }
        });
        if (this.taskExecutor.execute(this.waterfallLoader, calculateLoadingDelayMs)) {
            return;
        }
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallController$$ExternalSyntheticLambda1
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return WaterfallController.this.m9673x315807ad();
            }
        });
        processLoadCompleted();
    }

    /* renamed from: lambda$loadWaterfall$0$io-bidmachine-ads-networks-gam_dynamic-WaterfallController, reason: not valid java name */
    /* synthetic */ String m9672x2b543c4e(long j) {
        return String.format("(%s) Execution waterfall load started after - %s ms (failedAttempts - %s, maxRetryDegree - %s, retryBase - %s sec)", this.adsFormat, Long.valueOf(j), Integer.valueOf(this.failedWaterfallLoadAttempts.get()), Integer.valueOf(this.maxRetryDegree), Integer.valueOf(this.retryBaseSec));
    }

    /* renamed from: lambda$loadWaterfall$1$io-bidmachine-ads-networks-gam_dynamic-WaterfallController, reason: not valid java name */
    /* synthetic */ String m9673x315807ad() {
        return String.format("(%s) Fail to start loading waterfall", this.adsFormat);
    }

    long calculateLoadingDelayMs() {
        return (long) (Math.pow(this.retryBaseSec, Math.min(this.failedWaterfallLoadAttempts.get(), this.maxRetryDegree)) * 1000.0d);
    }

    /* renamed from: lambda$requestNextWaterfall$2$io-bidmachine-ads-networks-gam_dynamic-WaterfallController, reason: not valid java name */
    /* synthetic */ String m9677x52c012ae() {
        return String.format("(%s) Request next waterfall", this.adsFormat);
    }

    void requestNextWaterfall(Queue<Waterfall.Result.AdUnit> adUnitResultQueue) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallController$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return WaterfallController.this.m9677x52c012ae();
            }
        });
        if (TextUtils.isEmpty(this.refreshUrl) || !Utils.isHttpUrl(this.refreshUrl)) {
            onWaterfallRequestFail("Request next waterfall failed (refreshUrl is null or empty or incorrect)");
            return;
        }
        Waterfall.Result.Builder addAllAdUnitResults = Waterfall.Result.newBuilder().setFormat(StringValue.newBuilder().setValue(this.adsFormat.getRemoteName()).build()).addAllAdUnitResults(adUnitResultQueue);
        String str = this.id;
        if (str != null) {
            addAllAdUnitResults.setWaterfallId(str);
        }
        List<Waterfall.Result.CachedAdUnit> cachedAdUnitList = this.gamAdManager.getCachedAdUnitList(this.adsFormat);
        if (cachedAdUnitList != null && !cachedAdUnitList.isEmpty()) {
            addAllAdUnitResults.addAllCachedAdUnits(cachedAdUnitList);
        }
        Struct ext = this.networkParams.getExt(this.applicationContext);
        if (ext != null) {
            addAllAdUnitResults.setExt(ext);
        }
        StringValue stringValue = this.serverParams;
        if (stringValue != null) {
            addAllAdUnitResults.setServerParams(stringValue);
        }
        WaterfallCallback waterfallCallback = new WaterfallCallback();
        WaterfallNetworkRequest waterfallNetworkRequest = new WaterfallNetworkRequest(this.refreshUrl, addAllAdUnitResults.build(), (int) this.refreshTimeOutMs);
        waterfallNetworkRequest.setCallback(waterfallCallback);
        waterfallNetworkRequest.setCancelCallback(waterfallCallback);
        waterfallNetworkRequest.request(TASK_MANAGER);
    }

    /* renamed from: lambda$onWaterfallRequestSuccess$3$io-bidmachine-ads-networks-gam_dynamic-WaterfallController, reason: not valid java name */
    /* synthetic */ String m9675x5bdad050() {
        return String.format("(%s) onWaterfallRequestSuccess", this.adsFormat);
    }

    void onWaterfallRequestSuccess(Waterfall.Configuration waterfallConfiguration) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallController$$ExternalSyntheticLambda6
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return WaterfallController.this.m9675x5bdad050();
            }
        });
        setWaterfallConfiguration(waterfallConfiguration);
        if (!this.isShouldPollAfter.get() && waterfallConfiguration.getShouldBreak()) {
            processLoadCompleted();
        } else {
            loadWaterfall();
        }
    }

    /* renamed from: lambda$onWaterfallRequestFail$4$io-bidmachine-ads-networks-gam_dynamic-WaterfallController, reason: not valid java name */
    /* synthetic */ String m9674x6dfca3a2(String str) {
        return String.format("(%s) onWaterfallRequestFail - %s", this.adsFormat, str);
    }

    void onWaterfallRequestFail(final String errorMessage) {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallController$$ExternalSyntheticLambda5
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return WaterfallController.this.m9674x6dfca3a2(errorMessage);
            }
        });
        loadWaterfall();
    }

    /* renamed from: lambda$processLoadCompleted$5$io-bidmachine-ads-networks-gam_dynamic-WaterfallController, reason: not valid java name */
    /* synthetic */ String m9676xc5f425c5() {
        return String.format("(%s) Loading completed", this.adsFormat);
    }

    void processLoadCompleted() {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallController$$ExternalSyntheticLambda4
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return WaterfallController.this.m9676xc5f425c5();
            }
        });
        clearWaterfall();
        this.isLoading.set(false);
    }

    void clearWaterfall() {
        this.waterfallLoader = null;
    }

    void sortDescByPrice(List<Waterfall.Configuration.AdUnit> adUnitList) {
        Collections.sort(adUnitList, new Comparator() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallController$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return WaterfallController.lambda$sortDescByPrice$6((Waterfall.Configuration.AdUnit) obj, (Waterfall.Configuration.AdUnit) obj2);
            }
        });
    }

    static /* synthetic */ int lambda$sortDescByPrice$6(Waterfall.Configuration.AdUnit adUnit, Waterfall.Configuration.AdUnit adUnit2) {
        return -Double.compare(adUnit.getPrice(), adUnit2.getPrice());
    }

    class WaterfallLoaderListener implements WaterfallLoader.Listener {
        final AtomicBoolean isAdLoaded = new AtomicBoolean(false);

        public WaterfallLoaderListener() {
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.WaterfallLoader.Listener
        public void onAdLoaded() {
            this.isAdLoaded.set(true);
            WaterfallController.this.failedWaterfallLoadAttempts.set(0);
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.WaterfallLoader.Listener
        public void onWaterfallLoadCompleted(Queue<Waterfall.Result.AdUnit> adUnitResultQueue) {
            WaterfallController.this.isPolling.set(false);
            if (!this.isAdLoaded.get()) {
                WaterfallController.this.failedWaterfallLoadAttempts.incrementAndGet();
            }
            WaterfallController.this.requestNextWaterfall(adUnitResultQueue);
        }
    }

    class WaterfallCallback implements WaterfallNetworkRequest.Callback {
        WaterfallCallback() {
        }

        @Override // io.bidmachine.core.NetworkRequest.Callback
        public void onSuccess(Waterfall.Configuration response) {
            if (response != null) {
                WaterfallController.this.onWaterfallRequestSuccess(response);
            } else {
                WaterfallController.this.onWaterfallRequestFail("Configuration response is null");
            }
        }

        @Override // io.bidmachine.core.NetworkRequest.Callback
        public void onFail(BMError bmError) {
            String str;
            WaterfallController waterfallController = WaterfallController.this;
            if (bmError != null) {
                str = bmError.getMessage();
            } else {
                str = "Unknown";
            }
            waterfallController.onWaterfallRequestFail(str);
        }

        @Override // io.bidmachine.core.NetworkRequest.CancelCallback
        public void onCanceled() {
            WaterfallController.this.onWaterfallRequestFail("Request is canceled");
        }
    }
}
