package com.ironsource.mediationsdk;

import com.ironsource.C3260q4;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.AdUnitAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class AbstractAdapter implements RewardedVideoAdapterInterface, InterstitialAdapterInterface, BannerAdapterInterface, NativeAdAdapterInterface, AdapterNetworkDataInterface {
    private static Boolean mAdapterDebug;
    private String mPluginType;
    private final String mProviderName;
    private String mProviderNetworkKey;
    private final Map<IronSource.AD_UNIT, AdUnitAdapterInterface> mAdUnitAdapters = new HashMap();
    protected LoadWhileShowSupportState mLWSSupportState = LoadWhileShowSupportState.NONE;
    protected LoadWhileShowSupportState mBannerLoadWhileShowSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;

    public AbstractAdapter(String str) {
        this.mProviderName = str;
    }

    private BannerAdapterInterface a() {
        return (BannerAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.BANNER);
    }

    private InterstitialAdapterInterface b() {
        return (InterstitialAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.INTERSTITIAL);
    }

    private NativeAdAdapterInterface c() {
        return (NativeAdAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.NATIVE_AD);
    }

    private RewardedVideoAdapterInterface d() {
        return (RewardedVideoAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    public static void postBackgroundThread(Runnable runnable) {
        IronSourceThreadManager.INSTANCE.postAdapterBackgroundTask(runnable);
    }

    public static void postOnUIThread(Runnable runnable) {
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(runnable);
    }

    public void collectBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        BannerAdapterInterface a2 = a();
        if (a2 != null) {
            a2.collectBannerBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> bannerBiddingData = getBannerBiddingData(jSONObject, jSONObject2);
        if (bannerBiddingData != null) {
            biddingDataCallback.onSuccess(bannerBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void collectInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        InterstitialAdapterInterface b = b();
        if (b != null) {
            b.collectInterstitialBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> interstitialBiddingData = getInterstitialBiddingData(jSONObject, jSONObject2);
        if (interstitialBiddingData != null) {
            biddingDataCallback.onSuccess(interstitialBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void collectNativeAdBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        NativeAdAdapterInterface c = c();
        if (c != null) {
            c.collectNativeAdBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> nativeAdBiddingData = getNativeAdBiddingData(jSONObject, jSONObject2);
        if (nativeAdBiddingData != null) {
            biddingDataCallback.onSuccess(nativeAdBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        RewardedVideoAdapterInterface d = d();
        if (d != null) {
            d.collectRewardedVideoBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> rewardedVideoBiddingData = getRewardedVideoBiddingData(jSONObject, jSONObject2);
        if (rewardedVideoBiddingData != null) {
            biddingDataCallback.onSuccess(rewardedVideoBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void destroyBanner(JSONObject jSONObject) {
        BannerAdapterInterface a2 = a();
        if (a2 != null) {
            a2.destroyBanner(jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void destroyNativeAd(JSONObject jSONObject) {
        NativeAdAdapterInterface c = c();
        if (c != null) {
            c.destroyNativeAd(jSONObject);
        }
    }

    public void disposeInterstitialAd(JSONObject jSONObject) {
        InterstitialAdapterInterface b = b();
        if (b != null) {
            b.disposeInterstitialAd(jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void disposeRewardedVideoAd(JSONObject jSONObject) {
        RewardedVideoAdapterInterface d = d();
        if (d != null) {
            d.disposeRewardedVideoAd(jSONObject);
        }
    }

    public void earlyInit(String str, String str2, JSONObject jSONObject) {
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public int getAdaptiveHeight(int i) {
        BannerAdapterInterface a2 = a();
        if (a2 != null) {
            return a2.getAdaptiveHeight(i);
        }
        return -1;
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        BannerAdapterInterface a2 = a();
        if (a2 != null) {
            return a2.getBannerBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public LoadWhileShowSupportState getBannerLoadWhileShowSupportState(JSONObject jSONObject) {
        return this.mBannerLoadWhileShowSupportState;
    }

    public abstract String getCoreSDKVersion();

    public String getDynamicUserId() {
        return p.j().i();
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        InterstitialAdapterInterface b = b();
        if (b != null) {
            return b.getInterstitialBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject jSONObject) {
        return this.mLWSSupportState;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public Map<String, Object> getNativeAdBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        NativeAdAdapterInterface c = c();
        if (c != null) {
            return c.getNativeAdBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    public String getProviderNetworkKey() {
        return this.mProviderNetworkKey;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        RewardedVideoAdapterInterface d = d();
        if (d != null) {
            return d.getRewardedVideoBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public abstract String getVersion();

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        try {
            RewardedVideoAdapterInterface d = d();
            try {
                if (d != null) {
                    d.initAndLoadRewardedVideo(str, str2, jSONObject, jSONObject2, rewardedVideoSmashListener);
                } else if (rewardedVideoSmashListener != null) {
                    rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                }
            } catch (Error e) {
                e = e;
                Error error = e;
                C3260q4.d().a(error);
                IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + error.getMessage());
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        } catch (Error e2) {
            e = e2;
        }
    }

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        try {
            BannerAdapterInterface a2 = a();
            if (a2 != null) {
                a2.initBannerForBidding(str, str2, jSONObject, bannerSmashListener);
            } else if (bannerSmashListener != null) {
                bannerSmashListener.onBannerInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e.getMessage());
            bannerSmashListener.onBannerInitFailed(new IronSourceError(510, "error - " + e.getMessage()));
        }
    }

    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        try {
            BannerAdapterInterface a2 = a();
            if (a2 != null) {
                a2.initBanners(str, str2, jSONObject, bannerSmashListener);
            } else if (bannerSmashListener != null) {
                bannerSmashListener.onBannerInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e.getMessage());
            bannerSmashListener.onBannerInitFailed(new IronSourceError(510, "error - " + e.getMessage()));
        }
    }

    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        try {
            InterstitialAdapterInterface b = b();
            if (b != null) {
                b.initInterstitial(str, str2, jSONObject, interstitialSmashListener);
            } else if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e.getMessage());
            interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, "error - " + e.getMessage()));
        }
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        try {
            InterstitialAdapterInterface b = b();
            if (b != null) {
                b.initInterstitialForBidding(str, str2, jSONObject, interstitialSmashListener);
            } else if (interstitialSmashListener != null) {
                interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e.getMessage());
            interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, "error - " + e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void initNativeAdForBidding(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface c = c();
        if (c != null) {
            c.initNativeAdForBidding(str, str2, jSONObject, nativeAdSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void initNativeAds(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface c = c();
        if (c != null) {
            c.initNativeAds(str, str2, jSONObject, nativeAdSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface d = d();
        if (d != null) {
            d.initRewardedVideoForDemandOnly(str, str2, jSONObject, rewardedVideoSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        try {
            RewardedVideoAdapterInterface d = d();
            if (d != null) {
                d.initRewardedVideoWithCallback(str, str2, jSONObject, rewardedVideoSmashListener);
            } else if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(new IronSourceError(510, "method not implemented"));
            }
        } catch (Error e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("provider -" + this.mProviderName + " error - " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoInitFailed(new IronSourceError(510, "error - " + e.getMessage()));
        }
    }

    protected boolean isAdaptersDebugEnabled() {
        Boolean bool = mAdapterDebug;
        return bool != null && bool.booleanValue();
    }

    public boolean isInterstitialReady(JSONObject jSONObject) {
        InterstitialAdapterInterface b = b();
        if (b != null) {
            return b.isInterstitialReady(jSONObject);
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        RewardedVideoAdapterInterface d = d();
        if (d != null) {
            return d.isRewardedVideoAvailable(jSONObject);
        }
        return false;
    }

    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return true;
    }

    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface a2 = a();
        if (a2 != null) {
            a2.loadBanner(jSONObject, jSONObject2, ironSourceBannerLayout, bannerSmashListener);
        }
    }

    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface a2 = a();
        if (a2 != null) {
            a2.loadBannerForBidding(jSONObject, jSONObject2, str, ironSourceBannerLayout, bannerSmashListener);
        }
    }

    public void loadBannerForDemandOnlyForBidding(JSONObject jSONObject, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface a2 = a();
        if (a2 != null) {
            a2.loadBannerForDemandOnlyForBidding(jSONObject, str, iSDemandOnlyBannerLayout, bannerSmashListener);
        }
    }

    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface b = b();
        if (b != null) {
            b.loadInterstitial(jSONObject, jSONObject2, interstitialSmashListener);
        }
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface b = b();
        if (b != null) {
            b.loadInterstitialForBidding(jSONObject, jSONObject2, str, interstitialSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void loadNativeAd(JSONObject jSONObject, JSONObject jSONObject2, NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface c = c();
        if (c != null) {
            c.loadNativeAd(jSONObject, jSONObject2, nativeAdSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void loadNativeAdForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface c = c();
        if (c != null) {
            c.loadNativeAdForBidding(jSONObject, jSONObject2, str, nativeAdSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface d = d();
        if (d != null) {
            d.loadRewardedVideo(jSONObject, jSONObject2, rewardedVideoSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface d = d();
        if (d != null) {
            d.loadRewardedVideoForBidding(jSONObject, jSONObject2, str, rewardedVideoSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewBound(JSONObject jSONObject) {
        BannerAdapterInterface a2 = a();
        if (a2 != null) {
            a2.onBannerViewBound(jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewWillBind(JSONObject jSONObject) {
        BannerAdapterInterface a2 = a();
        if (a2 != null) {
            a2.onBannerViewWillBind(jSONObject);
        }
    }

    public void onNetworkInitCallbackFailed(String str) {
        Iterator<AdUnitAdapterInterface> it = this.mAdUnitAdapters.values().iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed(str);
        }
    }

    public void onNetworkInitCallbackSuccess() {
        Iterator<AdUnitAdapterInterface> it = this.mAdUnitAdapters.values().iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + ad_unit);
        AdUnitAdapterInterface adUnitAdapterInterface = this.mAdUnitAdapters.get(ad_unit);
        if (adUnitAdapterInterface == null) {
            ironLog.verbose(ad_unit + " adapter is null");
        } else {
            adUnitAdapterInterface.releaseMemory(ad_unit, jSONObject);
        }
    }

    protected void setAdapterDebug(Boolean bool) {
        mAdapterDebug = bool;
    }

    protected void setBannerAdapter(BannerAdapterInterface bannerAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.BANNER, bannerAdapterInterface);
    }

    protected void setConsent(boolean z) {
    }

    protected void setInterstitialAdapter(InterstitialAdapterInterface interstitialAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.INTERSTITIAL, interstitialAdapterInterface);
    }

    protected void setMetaData(String str, List<String> list) {
    }

    protected void setNativeAdAdapter(NativeAdAdapterInterface nativeAdAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.NATIVE_AD, nativeAdAdapterInterface);
    }

    public void setNetworkData(AdapterNetworkData adapterNetworkData) {
        IronLog.INTERNAL.verbose("setNetworkData not implemented | adapter=" + getClass().getSimpleName() + ", networkData=" + adapterNetworkData);
    }

    public void setNewConsent(boolean z) {
        setConsent(z);
    }

    public void setPluginData(String str) {
        this.mPluginType = str;
    }

    public void setProviderNetworkKey(String str) {
        this.mProviderNetworkKey = str;
    }

    protected void setRewardedVideoAdapter(RewardedVideoAdapterInterface rewardedVideoAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.REWARDED_VIDEO, rewardedVideoAdapterInterface);
    }

    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface b = b();
        if (b != null) {
            b.showInterstitial(jSONObject, interstitialSmashListener);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface d = d();
        if (d != null) {
            d.showRewardedVideo(jSONObject, rewardedVideoSmashListener);
        }
    }
}
