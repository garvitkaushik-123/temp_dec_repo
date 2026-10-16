package com.ironsource.adapters.facebook.banner;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adapter.AbstractBannerAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class FacebookBannerAdapter extends AbstractBannerAdapter<FacebookAdapter> {
    protected ConcurrentHashMap<String, AdView> mPlacementIdToAd;
    private final ConcurrentHashMap<String, BannerSmashListener> mPlacementIdToSmashListener;

    public FacebookBannerAdapter(FacebookAdapter facebookAdapter) {
        super(facebookAdapter);
        this.mPlacementIdToSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToAd = new ConcurrentHashMap<>();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        initBannersInternal(jSONObject, bannerSmashListener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        initBannersInternal(jSONObject, bannerSmashListener);
    }

    private void initBannersInternal(JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String placementIdKey = getAdapter().getPlacementIdKey();
        String allPlacementIdsKey = getAdapter().getAllPlacementIdsKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, placementIdKey);
        String configStringValueFromKey2 = getConfigStringValueFromKey(jSONObject, allPlacementIdsKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(placementIdKey));
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementIdKey), "Banner"));
            return;
        }
        if (TextUtils.isEmpty(configStringValueFromKey2)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(allPlacementIdsKey));
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(allPlacementIdsKey), "Banner"));
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + configStringValueFromKey);
        this.mPlacementIdToSmashListener.put(configStringValueFromKey, bannerSmashListener);
        if (getAdapter().getInitState() == FacebookAdapter.InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("onBannerInitSuccess - placementId = " + configStringValueFromKey);
            bannerSmashListener.onBannerInitSuccess();
        } else if (getAdapter().getInitState() == FacebookAdapter.InitState.INIT_STATE_FAILED) {
            IronLog.INTERNAL.verbose("onBannerInitFailed - placementId = " + configStringValueFromKey);
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Meta SDK init failed", "Banner"));
        } else {
            getAdapter().initSDK(configStringValueFromKey2);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        Iterator<BannerSmashListener> it = this.mPlacementIdToSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        Iterator<BannerSmashListener> it = this.mPlacementIdToSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onBannerInitFailed(ErrorBuilder.buildInitFailedError(str, "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject, null, ironSourceBannerLayout, bannerSmashListener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject, str, ironSourceBannerLayout, bannerSmashListener);
    }

    private void loadBannerInternal(JSONObject jSONObject, final String str, final IronSourceBannerLayout ironSourceBannerLayout, final BannerSmashListener bannerSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        IronLog.ADAPTER_API.verbose("placementId = " + configStringValueFromKey);
        if (ironSourceBannerLayout == null) {
            IronLog.INTERNAL.error("banner is null");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner is null"));
            return;
        }
        final Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        final AdSize calculateBannerSize = calculateBannerSize(ironSourceBannerLayout.getSize(), applicationContext);
        if (calculateBannerSize == null) {
            IronLog.INTERNAL.error("size not supported, size = " + ironSourceBannerLayout.getSize().getDescription());
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getAdapter().getProviderName()));
        } else {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.banner.FacebookBannerAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (calculateBannerSize == null) {
                        IronLog.INTERNAL.error("size not supported, size = " + ironSourceBannerLayout.getSize().getDescription());
                        bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(FacebookBannerAdapter.this.getAdapter().getProviderName()));
                        return;
                    }
                    try {
                        AdView adView = new AdView(applicationContext, configStringValueFromKey, calculateBannerSize);
                        FacebookBannerAdListener facebookBannerAdListener = new FacebookBannerAdListener(FacebookBannerAdapter.this, FacebookBannerAdapter.this.calcLayoutParams(ironSourceBannerLayout.getSize(), applicationContext), configStringValueFromKey, bannerSmashListener);
                        AdView.AdViewLoadConfigBuilder buildLoadAdConfig = adView.buildLoadAdConfig();
                        buildLoadAdConfig.withAdListener(facebookBannerAdListener);
                        String str2 = str;
                        if (str2 != null) {
                            buildLoadAdConfig.withBid(str2);
                        }
                        FacebookBannerAdapter.this.mPlacementIdToAd.put(configStringValueFromKey, adView);
                        adView.loadAd(buildLoadAdConfig.build());
                    } catch (Exception e) {
                        bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Meta loadBanner exception " + e.getMessage()));
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject jSONObject) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        IronLog.ADAPTER_API.verbose("placementId = " + configStringValueFromKey);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.banner.FacebookBannerAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (FacebookBannerAdapter.this.mPlacementIdToAd.containsKey(configStringValueFromKey)) {
                        FacebookBannerAdapter.this.mPlacementIdToAd.get(configStringValueFromKey).destroy();
                        FacebookBannerAdapter.this.mPlacementIdToAd.remove(configStringValueFromKey);
                    }
                } catch (Exception e) {
                    IronLog.INTERNAL.error("destroyBanner failed for placementId - " + configStringValueFromKey + " with an exception = " + e);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        for (final AdView adView : this.mPlacementIdToAd.values()) {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.banner.FacebookBannerAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    AdView adView2 = adView;
                    if (adView2 != null) {
                        adView2.destroy();
                    }
                }
            });
        }
        this.mPlacementIdToAd.clear();
        this.mPlacementIdToSmashListener.clear();
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractBannerAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getAdapter().getBiddingData();
    }

    private AdSize calculateBannerSize(ISBannerSize iSBannerSize, Context context) {
        String description = iSBannerSize.getDescription();
        description.hashCode();
        switch (description) {
            case "RECTANGLE":
                return AdSize.RECTANGLE_HEIGHT_250;
            case "LARGE":
                return AdSize.BANNER_HEIGHT_90;
            case "SMART":
                return AdapterUtils.isLargeScreen(context) ? AdSize.BANNER_HEIGHT_90 : AdSize.BANNER_HEIGHT_50;
            case "BANNER":
                return AdSize.BANNER_HEIGHT_50;
            case "CUSTOM":
                if (iSBannerSize.getHeight() == 50) {
                    return AdSize.BANNER_HEIGHT_50;
                }
                if (iSBannerSize.getHeight() == 90) {
                    return AdSize.BANNER_HEIGHT_90;
                }
                if (iSBannerSize.getHeight() == 250) {
                    return AdSize.RECTANGLE_HEIGHT_250;
                }
                return null;
            default:
                return null;
        }
    }

    protected FrameLayout.LayoutParams calcLayoutParams(ISBannerSize iSBannerSize, Context context) {
        int i;
        if (iSBannerSize.getDescription().equals("RECTANGLE")) {
            i = 300;
        } else {
            i = (iSBannerSize.getDescription().equals("SMART") && AdapterUtils.isLargeScreen(context)) ? 728 : Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, i), -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }
}
