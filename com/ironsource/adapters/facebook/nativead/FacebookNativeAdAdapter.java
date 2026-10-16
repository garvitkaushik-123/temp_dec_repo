package com.ironsource.adapters.facebook.nativead;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.NativeAdProperties;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class FacebookNativeAdAdapter extends AbstractNativeAdAdapter<FacebookAdapter> {
    private WeakReference<NativeAd> mAd;
    private NativeAdSmashListener mSmashListener;

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
    }

    public FacebookNativeAdAdapter(FacebookAdapter facebookAdapter) {
        super(facebookAdapter);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void initNativeAds(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener) {
        initNativeAdsInternal(jSONObject, nativeAdSmashListener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void initNativeAdForBidding(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener) {
        initNativeAdsInternal(jSONObject, nativeAdSmashListener);
    }

    private void initNativeAdsInternal(JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener) {
        String placementIdKey = getAdapter().getPlacementIdKey();
        String allPlacementIdsKey = getAdapter().getAllPlacementIdsKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, placementIdKey);
        String configStringValueFromKey2 = getConfigStringValueFromKey(jSONObject, allPlacementIdsKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(placementIdKey));
            nativeAdSmashListener.onNativeAdInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementIdKey), IronSourceConstants.NATIVE_AD_UNIT));
            return;
        }
        if (TextUtils.isEmpty(configStringValueFromKey2)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(allPlacementIdsKey));
            nativeAdSmashListener.onNativeAdInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(allPlacementIdsKey), IronSourceConstants.NATIVE_AD_UNIT));
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + configStringValueFromKey);
        this.mSmashListener = nativeAdSmashListener;
        if (getAdapter().getInitState() == FacebookAdapter.InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("onNativeAdInitSuccess - placementId = " + configStringValueFromKey);
            nativeAdSmashListener.onNativeAdInitSuccess();
        } else if (getAdapter().getInitState() == FacebookAdapter.InitState.INIT_STATE_FAILED) {
            IronLog.INTERNAL.verbose("onNativeAdInitFailed - placementId = " + configStringValueFromKey);
            nativeAdSmashListener.onNativeAdInitFailed(ErrorBuilder.buildInitFailedError("Meta SDK init failed", IronSourceConstants.NATIVE_AD_UNIT));
        } else {
            getAdapter().initSDK(configStringValueFromKey2);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        NativeAdSmashListener nativeAdSmashListener = this.mSmashListener;
        if (nativeAdSmashListener != null) {
            nativeAdSmashListener.onNativeAdInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        NativeAdSmashListener nativeAdSmashListener = this.mSmashListener;
        if (nativeAdSmashListener != null) {
            nativeAdSmashListener.onNativeAdInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.NATIVE_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void loadNativeAd(JSONObject jSONObject, JSONObject jSONObject2, NativeAdSmashListener nativeAdSmashListener) {
        loadNativeAdInternal(jSONObject, null, nativeAdSmashListener);
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void loadNativeAdForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, NativeAdSmashListener nativeAdSmashListener) {
        loadNativeAdInternal(jSONObject, str, nativeAdSmashListener);
    }

    private void loadNativeAdInternal(JSONObject jSONObject, final String str, final NativeAdSmashListener nativeAdSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        IronLog.ADAPTER_API.verbose("placementId = " + configStringValueFromKey);
        final NativeAdProperties nativeAdProperties = getNativeAdProperties(jSONObject);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.nativead.FacebookNativeAdAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Context applicationContext = ContextProvider.getInstance().getApplicationContext();
                    NativeAd nativeAd = new NativeAd(applicationContext, configStringValueFromKey);
                    NativeAdBase.NativeAdLoadConfigBuilder withAdListener = nativeAd.buildLoadAdConfig().withAdListener(new FacebookNativeAdListener(applicationContext, configStringValueFromKey, nativeAdProperties.getAdOptionsPosition(), nativeAdSmashListener));
                    String str2 = str;
                    if (str2 != null) {
                        withAdListener.withBid(str2);
                    }
                    FacebookNativeAdAdapter.this.mAd = new WeakReference(nativeAd);
                    nativeAd.loadAd(withAdListener.build());
                } catch (Exception e) {
                    nativeAdSmashListener.onNativeAdLoadFailed(ErrorBuilder.buildLoadFailedError("Meta loadNative exception " + e.getMessage()));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public void destroyNativeAd(JSONObject jSONObject) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, getAdapter().getPlacementIdKey());
        IronLog.ADAPTER_API.verbose("placementId = " + configStringValueFromKey);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.nativead.FacebookNativeAdAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                if (FacebookNativeAdAdapter.this.mAd == null || FacebookNativeAdAdapter.this.mAd.get() == null) {
                    return;
                }
                try {
                    ((NativeAd) FacebookNativeAdAdapter.this.mAd.get()).destroy();
                    FacebookNativeAdAdapter.this.mAd = null;
                } catch (Exception e) {
                    IronLog.INTERNAL.error("destroyNativeAd failed for placementId - " + configStringValueFromKey + " with an exception = " + e);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractNativeAdAdapter, com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface
    public Map<String, Object> getNativeAdBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getAdapter().getBiddingData();
    }
}
