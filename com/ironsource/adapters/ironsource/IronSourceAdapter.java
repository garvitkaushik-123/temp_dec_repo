package com.ironsource.adapters.ironsource;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.ironsource.B9;
import com.ironsource.C3036d0;
import com.ironsource.C3044d8;
import com.ironsource.C3247p8;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.C9;
import com.ironsource.InterfaceC3352vc;
import com.ironsource.K8;
import com.ironsource.Wb;
import com.ironsource.Xb;
import com.ironsource.adapters.ironsource.IronSourceLoadParameters;
import com.ironsource.adapters.ironsource.nativeAd.IronSourceNativeAdAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.utils.SDKUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class IronSourceAdapter extends AbstractAdapter implements ContextProvider.a {
    public static final String IRONSOURCE_BIDDING_TOKEN_KEY = "token";
    public static final String IRONSOURCE_ONE_FLOW_KEY = "isOneFlow";
    private static final int IS_LOAD_EXCEPTION = 1000;
    private static final int IS_SHOW_EXCEPTION = 1001;
    private static final int RV_LOAD_EXCEPTION = 1002;
    private static final int RV_SHOW_EXCEPTION = 1003;
    private static final String VERSION = "8.11.1";
    public final String ADM_KEY;
    private final String DEMAND_SOURCE_NAME;
    private final String DYNAMIC_CONTROLLER_CONFIG;
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE;
    private final String DYNAMIC_CONTROLLER_URL;
    private final String LWS_SUPPORT_STATE;
    private final String SDK_PLUGIN_TYPE;
    private final String SESSION_ID;
    ConcurrentHashMap<String, ArrayList<B9>> mDemandSourceToBnAd;
    ConcurrentHashMap<String, B9> mDemandSourceToISAd;
    ConcurrentHashMap<String, B9> mDemandSourceToRvAd;
    private final Xb mNetworkGlobalDataWriter;
    private final K8 sessionDepthService;
    private static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);
    private static C3036d0 mBaseAdPlayerExtraParams = new C3036d0();

    private IronSourceAdapter(String str) {
        super(str);
        this.DYNAMIC_CONTROLLER_URL = "controllerUrl";
        this.DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
        this.DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
        this.SESSION_ID = "sessionid";
        this.SDK_PLUGIN_TYPE = Wb.a.b;
        this.ADM_KEY = "adm";
        this.DEMAND_SOURCE_NAME = "demandSourceName";
        this.LWS_SUPPORT_STATE = "isSupportedLWS";
        this.mNetworkGlobalDataWriter = new Xb();
        this.sessionDepthService = C3334ub.U().s();
        this.mDemandSourceToRvAd = new ConcurrentHashMap<>();
        this.mDemandSourceToISAd = new ConcurrentHashMap<>();
        this.mDemandSourceToBnAd = new ConcurrentHashMap<>();
        setNativeAdAdapter(new IronSourceNativeAdAdapter(this));
        ContextProvider.getInstance().registerLifeCycleListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        if (r8 != false) goto L37;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private C3044d8 convertBannerSize(Context context, ISBannerSize iSBannerSize) {
        String description = iSBannerSize.getDescription();
        description.hashCode();
        description.hashCode();
        char c = 65535;
        switch (description.hashCode()) {
            case -387072689:
                if (description.equals("RECTANGLE")) {
                    c = 0;
                    break;
                }
                break;
            case 72205083:
                if (description.equals("LARGE")) {
                    c = 1;
                    break;
                }
                break;
            case 79011241:
                if (description.equals("SMART")) {
                    c = 2;
                    break;
                }
                break;
            case 1951953708:
                if (description.equals("BANNER")) {
                    c = 3;
                    break;
                }
                break;
            case 1999208305:
                if (description.equals("CUSTOM")) {
                    c = 4;
                    break;
                }
                break;
        }
        int i = 50;
        int i2 = Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE;
        switch (c) {
            case 0:
                i2 = 300;
                i = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
                break;
            case 1:
                i = 90;
                break;
            case 2:
                boolean isLargeScreen = AdapterUtils.isLargeScreen(context);
                if (isLargeScreen) {
                    i2 = 728;
                    break;
                }
                break;
            case 4:
                int height = iSBannerSize.getHeight();
                if (height == 50 || height == 90) {
                    i = height;
                    break;
                }
        }
        return null;
    }

    private B9 createBannerAdInstance(String str, C3044d8 c3044d8, JSONObject jSONObject, LoadAdData loadAdData, BannerSmashListener bannerSmashListener) {
        IronLog.ADAPTER_API.verbose("creating banner ad instance for " + str);
        return new C9(str, new IronSourceBannerListener(this, bannerSmashListener, str)).a(mBaseAdPlayerExtraParams.a()).a(jSONObject.optInt("instanceType", 2) == 2).c(jSONObject.optBoolean("isOneFlow")).a(c3044d8).b(loadAdData.isMultipleAdObjectsFlow()).b(loadAdData.adUnitId()).a();
    }

    private B9 createInterstitialAdInstance(String str, JSONObject jSONObject, LoadAdData loadAdData, InterstitialSmashListener interstitialSmashListener) {
        boolean optBoolean = jSONObject.optBoolean("isOneFlow");
        boolean z = jSONObject.optInt("instanceType", 2) == 2;
        IronLog.ADAPTER_API.verbose("creating ad instance for " + str + " isBidder=" + z);
        return new C9(str, new IronSourceInterstitialListener(interstitialSmashListener, str)).a(mBaseAdPlayerExtraParams.a()).c(optBoolean).a(z).b(loadAdData.isMultipleAdObjectsFlow()).b(loadAdData.adUnitId()).a();
    }

    private B9 createRewardedVideoAdInstance(String str, boolean z, JSONObject jSONObject, LoadAdData loadAdData, RewardedVideoSmashListener rewardedVideoSmashListener) {
        boolean optBoolean = jSONObject.optBoolean("isOneFlow");
        boolean z2 = jSONObject.optInt("instanceType", 2) == 2;
        IronLog.ADAPTER_API.verbose("creating ad instance for " + str + " isDemandOnly=" + z + " isBidder=" + z2);
        return new C9(str, new IronSourceRewardedVideoListener(rewardedVideoSmashListener, str, z)).a(mBaseAdPlayerExtraParams.a()).c().c(optBoolean).b(loadAdData.isMultipleAdObjectsFlow()).a(z2).b(loadAdData.adUnitId()).a();
    }

    public static String getAdapterSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData("IronSource", "8.11.1");
    }

    private void initInterstitialInternal(String str, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener, String str2) {
        initSDK(str, jSONObject);
        interstitialSmashListener.onInterstitialInitSuccess();
    }

    private void initRewardedVideoInternal(String str, JSONObject jSONObject) {
        initSDK(str, jSONObject);
    }

    private boolean isMultipleAdObjectsFlow(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.optBoolean("isMultipleAdUnits", false);
    }

    private void loadBannerInternal(Activity activity, ISBannerSize iSBannerSize, JSONObject jSONObject, BannerSmashListener bannerSmashListener, String str, LoadAdData loadAdData) {
        BannerSmashListener bannerSmashListener2;
        Exception exc;
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose("demandSourceName: " + demandSourceName);
        try {
            C3044d8 convertBannerSize = convertBannerSize(ContextProvider.getInstance().getApplicationContext(), iSBannerSize);
            if (convertBannerSize == null) {
                try {
                    bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getProviderName()));
                    return;
                } catch (Exception e) {
                    exc = e;
                    bannerSmashListener2 = bannerSmashListener;
                    C3260q4.d().a(exc);
                    bannerSmashListener2.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - " + exc.getMessage()));
                }
            }
            bannerSmashListener2 = bannerSmashListener;
            try {
                IronSourceNetwork.loadAdView(activity, createBannerAdInstance(demandSourceName, convertBannerSize, jSONObject, loadAdData, bannerSmashListener2), new IronSourceLoadParameters.WithLog(new IronSourceLoadParameters.Base(jSONObject, str)).value());
            } catch (Exception e2) {
                e = e2;
                exc = e;
                C3260q4.d().a(exc);
                bannerSmashListener2.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - " + exc.getMessage()));
            }
        } catch (Exception e3) {
            e = e3;
            bannerSmashListener2 = bannerSmashListener;
        }
    }

    private void loadInterstitialAdInternal(String str, String str2, JSONObject jSONObject, LoadAdData loadAdData, InterstitialSmashListener interstitialSmashListener) throws Exception {
        IronSourceLoadParameters.WithLog withLog = new IronSourceLoadParameters.WithLog(new IronSourceLoadParameters.Base(jSONObject, str2));
        B9 b9 = this.mDemandSourceToISAd.get(str);
        if (b9 == null) {
            b9 = createInterstitialAdInstance(str, jSONObject, loadAdData, interstitialSmashListener);
            this.mDemandSourceToISAd.put(str, b9);
        }
        IronSourceNetwork.loadAd(b9, withLog.value());
    }

    private void loadRewardedVideoAdInternal(JSONObject jSONObject, String str, String str2, LoadAdData loadAdData, RewardedVideoSmashListener rewardedVideoSmashListener) throws Exception {
        IronSourceLoadParameters.WithLog withLog = new IronSourceLoadParameters.WithLog(new IronSourceLoadParameters.Base(jSONObject, str2));
        B9 b9 = this.mDemandSourceToRvAd.get(str);
        if (b9 == null) {
            b9 = createRewardedVideoAdInstance(str, withLog.demandOnly(), jSONObject, loadAdData, rewardedVideoSmashListener);
            this.mDemandSourceToRvAd.put(str, b9);
        }
        IronSourceNetwork.loadAd(b9, withLog.value());
    }

    private void showAdInternal(B9 b9, IronSource.AD_UNIT ad_unit) throws Exception {
        int a2 = this.sessionDepthService.a(ad_unit);
        HashMap hashMap = new HashMap();
        hashMap.put("sessionDepth", String.valueOf(a2));
        IronLog.ADAPTER_API.verbose("demandSourceName=" + b9.g() + " showParams=" + hashMap);
        IronSourceNetwork.showAd(ContextProvider.getInstance().getCurrentActiveActivity(), b9, hashMap);
    }

    public static IronSourceAdapter startAdapter(String str) {
        return new IronSourceAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject jSONObject) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName + ": destroyBanner()");
        ArrayList<B9> arrayList = this.mDemandSourceToBnAd.get(demandSourceName);
        if (arrayList != null) {
            try {
                Iterator<B9> it = arrayList.iterator();
                while (it.hasNext()) {
                    IronSourceNetwork.destroyAd(it.next());
                }
                this.mDemandSourceToBnAd.remove(demandSourceName);
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.ADAPTER_API.verbose("destroyBanner failed: " + e.getMessage());
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public void earlyInit(String str, String str2, JSONObject jSONObject) {
        if (p.j().k() == null) {
            IronLog.ADAPTER_API.error("Appkey is null for early init");
        } else {
            IronSourceUtils.sendAutomationLog(getDemandSourceName(jSONObject) + ": earlyInit");
            initSDK(p.j().k(), jSONObject);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return new HashMap();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    public String getDemandSourceName(JSONObject jSONObject) {
        return !TextUtils.isEmpty(jSONObject.optString("demandSourceName")) ? jSONObject.optString("demandSourceName") : getProviderName();
    }

    public HashMap<String, String> getInitParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put(Wb.a.b, pluginType);
        }
        if (!TextUtils.isEmpty(p.j().r())) {
            hashMap.put("sessionid", p.j().r());
        }
        return hashMap;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return new HashMap();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject jSONObject) {
        return (jSONObject == null || !jSONObject.optBoolean("isSupportedLWS")) ? this.mLWSSupportState : LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return new HashMap();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "8.11.1";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.INTERNAL.verbose("demandSourceName: " + getDemandSourceName(jSONObject));
        initRewardedVideoInternal(str, jSONObject);
        loadRewardedVideo(jSONObject, jSONObject2, rewardedVideoSmashListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        IronLog.ADAPTER_API.verbose("demandSourceName: " + getDemandSourceName(jSONObject));
        initSDK(str, jSONObject);
        bannerSmashListener.onBannerInitSuccess();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.INTERNAL.verbose("demandSourceName: " + demandSourceName);
        initInterstitialInternal(str, jSONObject, interstitialSmashListener, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.INTERNAL.verbose("demandSourceName: " + demandSourceName);
        initInterstitialInternal(str, jSONObject, interstitialSmashListener, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.INTERNAL.verbose("demandSourceName: " + getDemandSourceName(jSONObject));
        initRewardedVideoInternal(str, jSONObject);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.INTERNAL.verbose("demandSourceName: " + getDemandSourceName(jSONObject));
        initRewardedVideoInternal(str, jSONObject);
        rewardedVideoSmashListener.onRewardedVideoInitSuccess();
    }

    public void initSDK(String str, JSONObject jSONObject) {
        if (mDidInitSdk.compareAndSet(false, true)) {
            String mediationUserId = IronSourceUtils.getMediationUserId();
            int optInt = jSONObject.optInt("debugMode", 0);
            if (isAdaptersDebugEnabled()) {
                optInt = 3;
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("setting debug mode to " + optInt);
            SDKUtils.setDebugMode(optInt);
            SDKUtils.setControllerUrl(jSONObject.optString("controllerUrl"));
            ironLog.verbose("IronSourceNetwork setting controller url to " + jSONObject.optString("controllerUrl"));
            JSONObject optJSONObject = jSONObject.optJSONObject("controllerConfig");
            String jSONObject2 = optJSONObject != null ? optJSONObject.toString() : "";
            SDKUtils.setControllerConfig(jSONObject2);
            ironLog.verbose("IronSourceNetwork setting controller config to " + jSONObject2);
            HashMap<String, String> initParams = getInitParams();
            mBaseAdPlayerExtraParams.a(initParams);
            String k = p.j().k();
            ironLog.verbose("with appKey=" + k + " userId=" + mediationUserId + " parameters " + initParams);
            IronSourceNetwork.addInitListener(new InterfaceC3352vc() { // from class: com.ironsource.adapters.ironsource.IronSourceAdapter.1
                @Override // com.ironsource.InterfaceC3352vc
                public void onFail(C3247p8 c3247p8) {
                    IronLog.ADAPTER_API.verbose("OnNetworkSDKInitListener fail - code:" + c3247p8.a() + " message:" + c3247p8.b());
                }

                @Override // com.ironsource.InterfaceC3352vc
                public void onSuccess() {
                    IronLog.ADAPTER_API.verbose("OnNetworkSDKInitListener success");
                }
            });
            IronSourceNetwork.initSDK(ContextProvider.getInstance().getApplicationContext(), k, mediationUserId, initParams);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject jSONObject) {
        B9 b9 = this.mDemandSourceToISAd.get(getDemandSourceName(jSONObject));
        return b9 != null && IronSourceNetwork.isAdAvailableForInstance(b9);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        B9 b9 = this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject));
        return b9 != null && IronSourceNetwork.isAdAvailableForInstance(b9);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return false;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        if (ironSourceBannerLayout != null) {
            loadBannerInternal(ContextProvider.getInstance().getCurrentActiveActivity(), ironSourceBannerLayout.getSize(), jSONObject, bannerSmashListener, str, new LoadAdData(jSONObject2));
        } else {
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - banner is null"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForDemandOnlyForBidding(JSONObject jSONObject, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, BannerSmashListener bannerSmashListener) {
        if (iSDemandOnlyBannerLayout != null) {
            loadBannerInternal(iSDemandOnlyBannerLayout.getActivity(), iSDemandOnlyBannerLayout.getSize(), jSONObject, bannerSmashListener, str, new LoadAdData());
        } else {
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - banner is null"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        InterstitialSmashListener interstitialSmashListener2;
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose("demandSourceName: " + demandSourceName);
        try {
            interstitialSmashListener2 = interstitialSmashListener;
        } catch (Exception e) {
            e = e;
            interstitialSmashListener2 = interstitialSmashListener;
        }
        try {
            loadInterstitialAdInternal(demandSourceName, null, jSONObject, new LoadAdData(jSONObject2), interstitialSmashListener2);
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            C3260q4.d().a(exc);
            IronLog.ADAPTER_API.error("exception " + exc.getMessage());
            interstitialSmashListener2.onInterstitialAdLoadFailed(new IronSourceError(1000, exc.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        InterstitialSmashListener interstitialSmashListener2;
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose("demandSourceName: " + demandSourceName);
        try {
            interstitialSmashListener2 = interstitialSmashListener;
        } catch (Exception e) {
            e = e;
            interstitialSmashListener2 = interstitialSmashListener;
        }
        try {
            loadInterstitialAdInternal(demandSourceName, str, jSONObject, new LoadAdData(jSONObject2), interstitialSmashListener2);
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            C3260q4.d().a(exc);
            IronLog.ADAPTER_API.error("for bidding exception " + exc.getMessage());
            interstitialSmashListener2.onInterstitialAdLoadFailed(new IronSourceError(1000, exc.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoSmashListener rewardedVideoSmashListener2;
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose("demandSourceName: " + demandSourceName);
        try {
            rewardedVideoSmashListener2 = rewardedVideoSmashListener;
        } catch (Exception e) {
            e = e;
            rewardedVideoSmashListener2 = rewardedVideoSmashListener;
        }
        try {
            loadRewardedVideoAdInternal(jSONObject, demandSourceName, null, new LoadAdData(jSONObject2), rewardedVideoSmashListener2);
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            C3260q4.d().a(exc);
            IronLog.ADAPTER_API.error("exception " + exc.getMessage());
            rewardedVideoSmashListener2.onRewardedVideoAvailabilityChanged(false);
            rewardedVideoSmashListener2.onRewardedVideoLoadFailed(new IronSourceError(1002, exc.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoSmashListener rewardedVideoSmashListener2;
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose("demandSourceName: " + demandSourceName);
        try {
            rewardedVideoSmashListener2 = rewardedVideoSmashListener;
        } catch (Exception e) {
            e = e;
            rewardedVideoSmashListener2 = rewardedVideoSmashListener;
        }
        try {
            loadRewardedVideoAdInternal(jSONObject, demandSourceName, str, new LoadAdData(jSONObject2), rewardedVideoSmashListener2);
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            C3260q4.d().a(exc);
            IronLog.ADAPTER_API.error("exception " + exc.getMessage());
            rewardedVideoSmashListener2.onRewardedVideoAvailabilityChanged(false);
            rewardedVideoSmashListener2.onRewardedVideoLoadFailed(new IronSourceError(1002, exc.getMessage()));
        }
    }

    @Override // com.ironsource.environment.ContextProvider.a
    public void onPause(Activity activity) {
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onPause");
        IronSourceNetwork.onPause(activity);
    }

    @Override // com.ironsource.environment.ContextProvider.a
    public void onResume(Activity activity) {
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onResume");
        IronSourceNetwork.onResume(activity);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(boolean z) {
        IronLog.ADAPTER_API.verbose("(" + (z ? "true" : "false") + ")");
        this.mNetworkGlobalDataWriter.a(z);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setMetaData(String str, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        mBaseAdPlayerExtraParams.b(str, list.get(0));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose("demandSourceName: " + demandSourceName);
        try {
            showAdInternal(this.mDemandSourceToISAd.get(demandSourceName), IronSource.AD_UNIT.INTERSTITIAL);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.ADAPTER_API.error("exception " + e.getMessage());
            interstitialSmashListener.onInterstitialAdShowFailed(new IronSourceError(1001, e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        try {
            showAdInternal(this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject)), IronSource.AD_UNIT.REWARDED_VIDEO);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.ADAPTER_API.error("exception " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoAdShowFailed(new IronSourceError(1003, e.getMessage()));
        }
    }
}
