package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import android.text.TextUtils;
import com.explorestack.protobuf.StringValue;
import io.bidmachine.AdsFormat;
import io.bidmachine.TrackEventType;
import io.bidmachine.ads.networks.gam_dynamic.versions.VersionWrapper;
import io.bidmachine.core.Logger;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.tracking.EventData;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
class WaterfallLoader implements Runnable {
    final Queue<Waterfall.Configuration.AdUnit> adUnitQueue;
    private final AdsFormat adsFormat;
    private final Context applicationContext;
    final int cacheSize;
    private final GAMAdManager gamAdManager;
    private final GAMEventTracker gamEventTracker;
    private final GAMNetwork gamNetwork;
    private final Listener listener;
    private final NetworkParams networkParams;
    private final Tag tag;
    private final TaskExecutor taskExecutor;
    private final VersionWrapper versionWrapper;
    private final String waterfallId;
    final Queue<Waterfall.Result.AdUnit> adUnitResultQueue = new ConcurrentLinkedQueue();
    final AtomicBoolean isLoading = new AtomicBoolean(false);

    public interface Listener {
        void onAdLoaded();

        void onWaterfallLoadCompleted(Queue<Waterfall.Result.AdUnit> adUnitResultQueue);
    }

    public WaterfallLoader(Context context, NetworkParams networkParams, AdsFormat adsFormat, VersionWrapper versionWrapper, GAMNetwork gamNetwork, GAMAdManager gamAdManager, GAMEventTracker gamEventTracker, TaskExecutor taskExecutor, String waterfallId, List<Waterfall.Configuration.AdUnit> adUnitList, int cacheSize, Listener listener) {
        this.tag = new Tag(networkParams.getNetworkName() + "WaterfallLoader");
        this.applicationContext = context.getApplicationContext();
        this.networkParams = networkParams;
        this.adsFormat = adsFormat;
        this.versionWrapper = versionWrapper;
        this.gamNetwork = gamNetwork;
        this.gamAdManager = gamAdManager;
        this.gamEventTracker = gamEventTracker;
        this.taskExecutor = taskExecutor;
        this.waterfallId = waterfallId;
        this.adUnitQueue = new ConcurrentLinkedQueue(adUnitList);
        this.cacheSize = cacheSize;
        this.listener = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        load();
    }

    void load() {
        if (this.isLoading.compareAndSet(false, true)) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallLoader$$ExternalSyntheticLambda5
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return WaterfallLoader.this.m9678x484eb551();
                }
            });
            trackEvent(TrackEventType.WaterfallLoadStart);
            loadNextAdUnit(null);
        }
    }

    /* renamed from: lambda$load$0$io-bidmachine-ads-networks-gam_dynamic-WaterfallLoader, reason: not valid java name */
    /* synthetic */ String m9678x484eb551() {
        return String.format("(%s) Polling started (waterfallId - %s, ad unit count - %s)", this.adsFormat, this.waterfallId, Integer.valueOf(this.adUnitQueue.size()));
    }

    void loadNextAdUnit(Long sleepTimeAfterMs) {
        if (this.adUnitQueue.isEmpty()) {
            processLoadCompleted();
            return;
        }
        final Waterfall.Configuration.AdUnit poll = this.adUnitQueue.poll();
        if (poll == null) {
            loadNextAdUnit(sleepTimeAfterMs);
            return;
        }
        final long calculateLoadingDelayMs = calculateLoadingDelayMs(poll, sleepTimeAfterMs);
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallLoader$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return WaterfallLoader.this.m9679x4e747bf6(calculateLoadingDelayMs);
            }
        });
        if (this.taskExecutor.execute(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallLoader$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                WaterfallLoader.this.m9682x52177493(poll);
            }
        }, calculateLoadingDelayMs)) {
            return;
        }
        processLoadCompleted();
    }

    /* renamed from: lambda$loadNextAdUnit$1$io-bidmachine-ads-networks-gam_dynamic-WaterfallLoader, reason: not valid java name */
    /* synthetic */ String m9679x4e747bf6(long j) {
        return String.format("(%s) Execution ad unit load started after %s ms", this.adsFormat, Long.valueOf(j));
    }

    /* renamed from: lambda$loadNextAdUnit$4$io-bidmachine-ads-networks-gam_dynamic-WaterfallLoader, reason: not valid java name */
    /* synthetic */ void m9682x52177493(Waterfall.Configuration.AdUnit adUnit) {
        Waterfall.Configuration.AdUnit adUnit2;
        InternalAd findCheapestIdleAd = this.gamAdManager.findCheapestIdleAd(this.adsFormat);
        if (findCheapestIdleAd != null && adUnit.getPrice() <= findCheapestIdleAd.getAdUnit().getPrice() && this.gamAdManager.getLoadedAdCount(this.adsFormat) >= this.cacheSize) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallLoader$$ExternalSyntheticLambda3
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    return WaterfallLoader.this.m9680x4faaced5();
                }
            });
            addAdUnitResult(adUnit, Waterfall.Result.AdUnit.Status.STATUS_SKIPPED, null, null);
            Iterator<Waterfall.Configuration.AdUnit> it = this.adUnitQueue.iterator();
            while (it.hasNext()) {
                addAdUnitResult(it.next(), Waterfall.Result.AdUnit.Status.STATUS_SKIPPED, null, null);
            }
            processLoadCompleted();
            return;
        }
        try {
            adUnit2 = adUnit;
            try {
                InternalAd createAd = this.versionWrapper.createAd(this.networkParams, this.taskExecutor, this.adsFormat, adUnit2, new AdListener());
                if (createAd == null) {
                    Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallLoader$$ExternalSyntheticLambda4
                        @Override // io.bidmachine.utils.lazy.LazyValue
                        public final Object get() {
                            return WaterfallLoader.this.m9681x50e121b4();
                        }
                    });
                    addAdUnitResult(adUnit2, Waterfall.Result.AdUnit.Status.STATUS_SKIPPED, null, BMError.internal("Can't create InternalAd"));
                    loadNextAdUnit(null);
                } else {
                    if (!TextUtils.isEmpty(this.waterfallId)) {
                        createAd.setCustomParam("gam_waterfall_id", this.waterfallId);
                        createAd.setCustomParam("gam_ad_unit_id", adUnit2.getAdUnitId());
                    }
                    createAd.load(this.applicationContext, new AdLoadListener());
                    trackEvent(TrackEventType.AdUnitLoadStart, createAd);
                }
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                Logger.w(th2);
                addAdUnitResult(adUnit2, Waterfall.Result.AdUnit.Status.STATUS_SKIPPED, null, BMError.throwable("Exception loading InternalAd object", th2));
                loadNextAdUnit(null);
            }
        } catch (Throwable th3) {
            th = th3;
            adUnit2 = adUnit;
        }
    }

    /* renamed from: lambda$loadNextAdUnit$2$io-bidmachine-ads-networks-gam_dynamic-WaterfallLoader, reason: not valid java name */
    /* synthetic */ String m9680x4faaced5() {
        return String.format("(%s) Stop polling. Waterfall already filled with expensive ads", this.adsFormat);
    }

    /* renamed from: lambda$loadNextAdUnit$3$io-bidmachine-ads-networks-gam_dynamic-WaterfallLoader, reason: not valid java name */
    /* synthetic */ String m9681x50e121b4() {
        return String.format("(%s) Can't create InternalAd", this.adsFormat);
    }

    long calculateLoadingDelayMs(Waterfall.Configuration.AdUnit adUnit, Long sleepTimeAfterMs) {
        long sleepTimeBeforeMs = getSleepTimeBeforeMs(adUnit);
        return sleepTimeAfterMs != null ? sleepTimeBeforeMs + sleepTimeAfterMs.longValue() : sleepTimeBeforeMs;
    }

    void addAdUnitResult(Waterfall.Configuration.AdUnit adUnit, Waterfall.Result.AdUnit.Status adUnitStatus, InternalAdLoadData internalAdLoadData, BMError bmError) {
        this.adUnitResultQueue.add(create(adUnit, adUnitStatus, internalAdLoadData, bmError));
    }

    void processLoadCompleted() {
        Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.WaterfallLoader$$ExternalSyntheticLambda2
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return WaterfallLoader.this.m9683xff0c6ebc();
            }
        });
        trackEvent(TrackEventType.WaterfallLoadFinish);
        this.isLoading.set(false);
        this.listener.onWaterfallLoadCompleted(this.adUnitResultQueue);
    }

    /* renamed from: lambda$processLoadCompleted$5$io-bidmachine-ads-networks-gam_dynamic-WaterfallLoader, reason: not valid java name */
    /* synthetic */ String m9683xff0c6ebc() {
        StringBuilder sb = new StringBuilder(String.format("(%s) Polling completed (waterfallId - %s, ad unit count - %s)", this.adsFormat, this.waterfallId, Integer.valueOf(this.adUnitResultQueue.size())));
        Iterator<Waterfall.Result.AdUnit> it = this.adUnitResultQueue.iterator();
        while (it.hasNext()) {
            sb.append(String.format("\n> %s", GAMUtils.toString(it.next())));
        }
        return sb.toString();
    }

    void removeAdFromCaches(InternalAd internalAd) {
        if (this.gamAdManager.removeAdFromCaches(internalAd)) {
            this.gamNetwork.cacheWaterfall(internalAd.getAdsFormat(), true);
        }
    }

    void trackEvent(TrackEventType trackEventType) {
        trackEvent(trackEventType, null, null, null);
    }

    void trackEvent(TrackEventType trackEventType, InternalAd internalAd) {
        trackEvent(trackEventType, internalAd.getAdUnit(), internalAd, null);
    }

    void trackEvent(TrackEventType trackEventType, Waterfall.Configuration.AdUnit adUnit, InternalAd internalAd, BMError bmError) {
        EventData networkName = new EventData().setNetworkName(this.networkParams.getNetworkKey());
        if (adUnit != null) {
            networkName.setPrice(Double.valueOf(adUnit.getPrice()));
        }
        if (internalAd != null) {
            networkName.setCustomParams(internalAd.getCustomParamsMap());
        }
        if (!TextUtils.isEmpty(this.waterfallId)) {
            networkName.setCustomParam("gam_waterfall_id", this.waterfallId);
        }
        this.gamEventTracker.trackEvent(trackEventType, this.adsFormat, networkName, bmError);
    }

    long getSleepTimeBeforeMs(Waterfall.Configuration.AdUnit adUnit) {
        if ((adUnit.hasSleepTimeBefore() ? adUnit.getSleepTimeBefore() : null) != null) {
            return r3.getValue();
        }
        return 0L;
    }

    long getSleepTimeAfterMs(Waterfall.Configuration.AdUnit adUnit) {
        if ((adUnit.hasSleepTimeAfter() ? adUnit.getSleepTimeAfter() : null) != null) {
            return r3.getValue();
        }
        return 0L;
    }

    Waterfall.Result.AdUnit create(Waterfall.Configuration.AdUnit adUnit, Waterfall.Result.AdUnit.Status adUnitStatus, InternalAdLoadData internalAdLoadData, BMError bmError) {
        Waterfall.Result.AdUnit.Builder price = Waterfall.Result.AdUnit.newBuilder().setStatus(adUnitStatus).setPrice(adUnit.getPrice());
        if (adUnit.getAdUnitId() != null) {
            price.setAdUnitId(adUnit.getAdUnitId());
        }
        StringValue serverParams = adUnit.getServerParams();
        if (serverParams != null) {
            price.setServerParams(serverParams);
        }
        if (internalAdLoadData != null) {
            Waterfall.Result.EstimatedPrice price2 = internalAdLoadData.getPrice();
            if (price2 != null) {
                price.setEstimatedPrice(price2);
            }
            String adResponse = internalAdLoadData.getAdResponse();
            if (!TextUtils.isEmpty(adResponse)) {
                price.setAdResponse(StringValue.newBuilder().setValue(adResponse).build());
            }
        }
        if (bmError != null) {
            price.setError(Waterfall.Result.AdUnit.Error.newBuilder().setCode(bmError.getCode()).setDescription(bmError.getMessage()));
        }
        return price.build();
    }

    class AdListener implements InternalAdListener {
        AdListener() {
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdListener
        public void onAdShown(InternalAd internalAd) {
            WaterfallLoader.this.removeAdFromCaches(internalAd);
            WaterfallLoader.this.trackEvent(TrackEventType.AdUnitShown, internalAd);
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdListener
        public void onAdExpired(InternalAd internalAd) {
            WaterfallLoader.this.trackEvent(TrackEventType.AdUnitExpired, internalAd);
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdListener
        public void onAdDestroyed(InternalAd internalAd, boolean isAdReleased) {
            if (!isAdReleased) {
                WaterfallLoader.this.gamAdManager.unReserveAd(internalAd);
            } else {
                WaterfallLoader.this.removeAdFromCaches(internalAd);
            }
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdListener
        public void onPaidEvent(InternalAd internalAd) {
            WaterfallLoader.this.trackEvent(TrackEventType.AdUnitPaidEvent, internalAd);
        }
    }

    class AdLoadListener implements InternalLoadListener {
        AdLoadListener() {
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.InternalLoadListener
        public void onAdLoaded(InternalAd internalAd, InternalAdLoadData internalAdLoadData) {
            WaterfallLoader.this.trackEvent(TrackEventType.AdUnitLoadFinish, internalAd);
            WaterfallLoader.this.trackEvent(TrackEventType.AdUnitWin, internalAd);
            WaterfallLoader.this.addAdUnitResult(internalAd.getAdUnit(), Waterfall.Result.AdUnit.Status.STATUS_SUCCESS, internalAdLoadData, null);
            InternalAd storeOrSwapCheapestIdleAd = WaterfallLoader.this.gamAdManager.storeOrSwapCheapestIdleAd(internalAd, WaterfallLoader.this.cacheSize);
            if (storeOrSwapCheapestIdleAd != null) {
                WaterfallLoader.this.trackEvent(TrackEventType.AdUnitCheapestDequeued, storeOrSwapCheapestIdleAd);
                storeOrSwapCheapestIdleAd.destroy();
            }
            WaterfallLoader.this.listener.onAdLoaded();
            WaterfallLoader.this.loadNextAdUnit(null);
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.InternalLoadListener
        public void onAdLoadFailed(InternalAd internalAd, BMError bmError) {
            Waterfall.Configuration.AdUnit adUnit = internalAd.getAdUnit();
            WaterfallLoader.this.trackEvent(TrackEventType.AdUnitLoadFinish, adUnit, internalAd, bmError);
            WaterfallLoader.this.trackEvent(TrackEventType.AdUnitLoss, internalAd);
            WaterfallLoader.this.addAdUnitResult(adUnit, Waterfall.Result.AdUnit.Status.STATUS_ERROR, null, bmError);
            internalAd.destroy();
            WaterfallLoader waterfallLoader = WaterfallLoader.this;
            waterfallLoader.loadNextAdUnit(Long.valueOf(waterfallLoader.getSleepTimeAfterMs(adUnit)));
        }
    }
}
