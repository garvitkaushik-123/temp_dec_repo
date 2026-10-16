package com.ironsource.adapters.facebook;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BidderTokenProvider;
import com.facebook.ads.CacheFlag;
import com.ironsource.adapters.facebook.banner.FacebookBannerAdapter;
import com.ironsource.adapters.facebook.interstitial.FacebookInterstitialAdapter;
import com.ironsource.adapters.facebook.nativead.FacebookNativeAdAdapter;
import com.ironsource.adapters.facebook.rewardedvideo.FacebookRewardedVideoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterNetworkData;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: classes6.dex */
public class FacebookAdapter extends AbstractAdapter implements AudienceNetworkAds.InitListener {
    private static final String GitHash = "51ef770";
    private static final String MEDIATION_NAME = "ironSource";
    protected static final String META_NETWORK_NAME = "Facebook";
    private static final String NETWORK_DATA_CACHE_FLAG = "CacheFlag";
    private static final String VERSION = "4.3.52";
    protected final String ALL_PLACEMENT_IDS;
    protected final String FACEBOOK_INTERSTITIAL_CACHE_FLAG;
    protected final String META_INTERSTITIAL_CACHE_FLAG;
    protected final String META_MIXED_AUDIENCE;
    protected final String PLACEMENT_ID;
    protected static EnumSet<CacheFlag> mInterstitialFacebookCacheFlags = EnumSet.allOf(CacheFlag.class);
    protected static HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();
    protected static InitState mInitState = InitState.INIT_STATE_NONE;
    protected static AtomicBoolean mWasInitCalled = new AtomicBoolean(false);

    public enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS,
        INIT_STATE_FAILED
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return false;
    }

    public static FacebookAdapter startAdapter(String str) {
        return new FacebookAdapter(str);
    }

    private FacebookAdapter(String str) {
        super(str);
        this.PLACEMENT_ID = "placementId";
        this.ALL_PLACEMENT_IDS = "placementIds";
        this.FACEBOOK_INTERSTITIAL_CACHE_FLAG = "facebook_is_cacheflag";
        this.META_INTERSTITIAL_CACHE_FLAG = "meta_is_cacheflag";
        this.META_MIXED_AUDIENCE = "meta_mixed_audience";
        IronLog.INTERNAL.verbose();
        setRewardedVideoAdapter(new FacebookRewardedVideoAdapter(this));
        setInterstitialAdapter(new FacebookInterstitialAdapter(this));
        setBannerAdapter(new FacebookBannerAdapter(this));
        setNativeAdAdapter(new FacebookNativeAdAdapter(this));
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData(META_NETWORK_NAME, "4.3.52");
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.3.52";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return getAdapterSDKVersion();
    }

    public static String getAdapterSDKVersion() {
        return "6.21.0";
    }

    public void initSDK(String str) {
        if (mInitState == InitState.INIT_STATE_NONE || mInitState == InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            List<String> asList = Arrays.asList(str.split(","));
            IronLog.ADAPTER_API.verbose("Initialize Meta with placement ids = " + asList.toString());
            AudienceNetworkAds.buildInitSettings(ContextProvider.getInstance().getApplicationContext()).withInitListener(this).withMediationService(getMediationServiceInfo()).withPlacementIds(asList).initialize();
        }
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitListener
    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        IronLog.ADAPTER_CALLBACK.verbose("init SDK is completed with status: " + initResult.isSuccess() + ", " + initResult.getMessage());
        if (initResult.isSuccess()) {
            mInitState = InitState.INIT_STATE_SUCCESS;
            Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
            while (it.hasNext()) {
                it.next().onNetworkInitCallbackSuccess();
            }
        } else {
            mInitState = InitState.INIT_STATE_FAILED;
            Iterator<INetworkInitCallbackListener> it2 = initCallbackListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onNetworkInitCallbackFailed(initResult.getMessage());
            }
        }
        initCallbackListeners.clear();
    }

    public InitState getInitState() {
        return mInitState;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setMetaData(String str, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        String lowerCase = StringUtils.toLowerCase(str);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "meta_mixed_audience":
                String str2 = list.get(0);
                IronLog.ADAPTER_API.verbose("key = " + str + ", value = " + str2);
                String formatValueForType = MetaDataUtils.formatValueForType(str2, MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
                if (isValidMixedAudienceMetaData(formatValueForType)) {
                    setMixedAudience(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
                    break;
                }
                break;
            case "meta_is_cacheflag":
            case "facebook_is_cacheflag":
                processCacheFlags(str, list);
                break;
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface
    public void setNetworkData(AdapterNetworkData adapterNetworkData) {
        JSONArray jSONArray = (JSONArray) adapterNetworkData.dataByKeyIgnoreCase(NETWORK_DATA_CACHE_FLAG, JSONArray.class);
        if (jSONArray != null) {
            processCacheFlags(jSONArray);
        }
    }

    private void processCacheFlags(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optString(i));
        }
        processCacheFlags(NETWORK_DATA_CACHE_FLAG, arrayList);
    }

    private void processCacheFlags(String str, List<String> list) {
        IronLog.ADAPTER_API.verbose("key = " + str + ", values = " + list);
        mInterstitialFacebookCacheFlags.clear();
        try {
            for (String str2 : list) {
                CacheFlag facebookCacheFlag = getFacebookCacheFlag(str2);
                IronLog.ADAPTER_API.verbose("flag for value " + str2 + " is " + facebookCacheFlag.name());
                mInterstitialFacebookCacheFlags.add(facebookCacheFlag);
            }
        } catch (Exception unused) {
            IronLog.INTERNAL.error("flag is unknown or all, set all as default");
            mInterstitialFacebookCacheFlags = getFacebookAllCacheFlags();
        }
        IronLog.ADAPTER_API.verbose("all flags:" + mInterstitialFacebookCacheFlags.toString());
    }

    private CacheFlag getFacebookCacheFlag(String str) {
        IronLog.ADAPTER_API.verbose("value = " + str);
        return CacheFlag.valueOf(StringUtils.toUpperCase(str));
    }

    private EnumSet<CacheFlag> getFacebookAllCacheFlags() {
        IronLog.ADAPTER_API.verbose();
        return EnumSet.allOf(CacheFlag.class);
    }

    private void setMixedAudience(boolean z) {
        IronLog.ADAPTER_API.verbose("isMixedAudience = " + z);
        AdSettings.setMixedAudience(z);
    }

    private boolean isValidMixedAudienceMetaData(String str) {
        return !TextUtils.isEmpty(str);
    }

    private String getMediationServiceInfo() {
        String format = String.format("%s_%s:%s", MEDIATION_NAME, LevelPlay.getSdkVersion(), "4.3.52");
        IronLog.INTERNAL.verbose("mediationServiceInfo = " + format);
        return format;
    }

    public static boolean isNoFillError(AdError adError) {
        return adError.getErrorCode() == 1001;
    }

    public Map<String, Object> getBiddingData() {
        if (mInitState == InitState.INIT_STATE_FAILED) {
            IronLog.INTERNAL.verbose("returning null as token since init failed");
            return null;
        }
        String bidderToken = BidderTokenProvider.getBidderToken(ContextProvider.getInstance().getApplicationContext());
        if (TextUtils.isEmpty(bidderToken)) {
            bidderToken = "";
        }
        IronLog.ADAPTER_API.verbose("token = " + bidderToken);
        HashMap hashMap = new HashMap();
        hashMap.put("token", bidderToken);
        return hashMap;
    }

    public EnumSet<CacheFlag> getCacheFlags() {
        return mInterstitialFacebookCacheFlags;
    }

    public String getPlacementIdKey() {
        return "placementId";
    }

    public String getAllPlacementIdsKey() {
        return "placementIds";
    }
}
