package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import io.bidmachine.AdsFormat;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.ads.networks.gam_dynamic.versions.VersionWrapper;
import io.bidmachine.core.Logger;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.Tag;
import io.bidmachine.utils.lazy.LazyValue;
import io.bidmachine.utils.version.Version;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
class GAMNetworkImpl implements GAMNetwork {
    private static final Map<String, GAMAdManager> GAM_AD_MANAGER_MAP = new HashMap();
    private static final Object GAM_AD_MANAGER_MAP_LOCK = new Object();
    final GAMAdManager gamAdManager;
    private final AtomicBoolean isInitialized;
    private final Tag tag;
    private final VersionWrapper versionWrapper;
    final Map<AdsFormat, WaterfallController> waterfallControllerMap;

    GAMNetworkImpl(Context applicationContext, NetworkParams networkParams, Waterfall.Context waterfallContext, VersionWrapper versionWrapper) {
        this(applicationContext, networkParams, waterfallContext, versionWrapper, obtainGamAdManager(networkParams.getNetworkKey()));
    }

    GAMNetworkImpl(Context applicationContext, NetworkParams networkParams, Waterfall.Context waterfallContext, VersionWrapper versionWrapper, GAMAdManager gamAdManager) {
        this.tag = new Tag(networkParams.getNetworkName() + AndroidInitializeBoldSDK.MSG_NETWORK);
        this.isInitialized = new AtomicBoolean(false);
        VersionWrapper versionWrapper2 = versionWrapper;
        this.versionWrapper = versionWrapper2;
        GAMAdManager gAMAdManager = gamAdManager;
        this.gamAdManager = gAMAdManager;
        this.waterfallControllerMap = new EnumMap(AdsFormat.class);
        GAMEventTrackerImpl gAMEventTrackerImpl = new GAMEventTrackerImpl(waterfallContext.getEventConfig());
        TaskExecutorImpl taskExecutorImpl = new TaskExecutorImpl();
        for (Waterfall.Configuration configuration : waterfallContext.getConfigurationsList()) {
            AdsFormat byRemoteName = AdsFormat.byRemoteName(configuration.getFormat());
            if (byRemoteName != null) {
                this.waterfallControllerMap.put(byRemoteName, new WaterfallController(applicationContext, networkParams, byRemoteName, configuration, versionWrapper2, this, gAMAdManager, gAMEventTrackerImpl, taskExecutorImpl));
                versionWrapper2 = versionWrapper;
                gAMAdManager = gamAdManager;
            }
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public String getVersion() {
        try {
            Version version = this.versionWrapper.getVersion();
            if (version != null) {
                return version.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public boolean isInitialized() {
        return this.isInitialized.get();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void init(Context context) {
        if (this.isInitialized.getAndSet(true)) {
            return;
        }
        try {
            this.versionWrapper.initialize(context);
        } catch (Throwable unused) {
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void cache() {
        for (AdsFormat adsFormat : AdsFormat.values()) {
            cacheWaterfall(adsFormat, false);
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void cache(AdsFormat adsFormat) {
        AdsFormat parent;
        if (cacheWaterfall(adsFormat, false) || (parent = adsFormat.getParent()) == null) {
            return;
        }
        cacheWaterfall(parent, false);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public boolean cacheWaterfall(AdsFormat adsFormat, boolean isForced) {
        WaterfallController waterfallController = this.waterfallControllerMap.get(adsFormat);
        if (waterfallController == null) {
            return false;
        }
        waterfallController.load(isForced);
        return true;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public InternalAdData reserveMostExpensiveAd(NetworkAdUnit networkAdUnit, AdsFormat adsFormat) {
        AdsFormat parent;
        InternalAdData reserveMostExpensiveAd = this.gamAdManager.reserveMostExpensiveAd(networkAdUnit, adsFormat);
        return (reserveMostExpensiveAd != null || (parent = adsFormat.getParent()) == null) ? reserveMostExpensiveAd : this.gamAdManager.reserveMostExpensiveAd(networkAdUnit, parent);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void unReserveAd(NetworkAdUnit networkAdUnit) {
        this.gamAdManager.unReserveAd(networkAdUnit);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void loadBanner(final NetworkAdUnit networkAdUnit, InternalBannerAdListener gamListener) {
        InternalAd reservedAd = this.gamAdManager.getReservedAd(networkAdUnit);
        if (reservedAd == null) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMNetworkImpl$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("Fail to load banner (Can't find reserved ad by network ad unit id - %s)", NetworkAdUnit.this.getId());
                    return format;
                }
            });
            onAdLoadFailed(gamListener, null, BMError.internal("Can't find reserved InternalAd by NetworkAdUnit"));
        } else if (reservedAd instanceof InternalBannerAd) {
            reservedAd.setAdPresentListener(gamListener);
            gamListener.onAdLoaded((InternalBannerAd) reservedAd);
        } else {
            onAdLoadFailed(gamListener, reservedAd, BMError.internal("InternalAd object has an incompatible ad type"));
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void loadInterstitial(final NetworkAdUnit networkAdUnit, InternalInterstitialAdListener gamListener) {
        InternalAd reservedAd = this.gamAdManager.getReservedAd(networkAdUnit);
        if (reservedAd == null) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMNetworkImpl$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("Fail to load interstitial (Can't find reserved ad by network ad unit id - %s)", NetworkAdUnit.this.getId());
                    return format;
                }
            });
            onAdLoadFailed(gamListener, null, BMError.internal("Can't find reserved InternalAd by NetworkAdUnit"));
        } else if (reservedAd instanceof InternalInterstitialAd) {
            reservedAd.setAdPresentListener(gamListener);
            gamListener.onAdLoaded((InternalInterstitialAd) reservedAd);
        } else {
            onAdLoadFailed(gamListener, reservedAd, BMError.internal("InternalAd object has an incompatible ad type"));
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.GAMNetwork
    public void loadRewarded(final NetworkAdUnit networkAdUnit, InternalRewardedAdListener gamListener) {
        InternalAd reservedAd = this.gamAdManager.getReservedAd(networkAdUnit);
        if (reservedAd == null) {
            Logger.d(this.tag, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.gam_dynamic.GAMNetworkImpl$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("Fail to load rewarded (Can't find reserved ad by network ad unit id - %s)", NetworkAdUnit.this.getId());
                    return format;
                }
            });
            onAdLoadFailed(gamListener, null, BMError.internal("Can't find reserved InternalAd by NetworkAdUnit"));
        } else if (reservedAd instanceof InternalRewardedAd) {
            reservedAd.setAdPresentListener(gamListener);
            gamListener.onAdLoaded((InternalRewardedAd) reservedAd);
        } else {
            onAdLoadFailed(gamListener, reservedAd, BMError.internal("InternalAd object has an incompatible ad type"));
        }
    }

    void onAdLoadFailed(InternalAdLoadListener<?> gamLoadListener, InternalAd internalAd, BMError bmError) {
        if (internalAd != null) {
            internalAd.destroy();
        }
        if (bmError == null) {
            bmError = BMError.NoFill;
        }
        gamLoadListener.onAdLoadFailed(bmError);
    }

    private static GAMAdManager obtainGamAdManager(String networkName) {
        Map<String, GAMAdManager> map = GAM_AD_MANAGER_MAP;
        GAMAdManager gAMAdManager = map.get(networkName);
        if (gAMAdManager != null) {
            return gAMAdManager;
        }
        synchronized (GAM_AD_MANAGER_MAP_LOCK) {
            GAMAdManager gAMAdManager2 = map.get(networkName);
            if (gAMAdManager2 != null) {
                return gAMAdManager2;
            }
            GAMAdManager gAMAdManager3 = new GAMAdManager(networkName);
            map.put(networkName, gAMAdManager3);
            return gAMAdManager3;
        }
    }

    static void clear() {
        GAM_AD_MANAGER_MAP.clear();
    }
}
