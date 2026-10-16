package com.ironsource.adapters.fyber;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.fyber.inneractive.sdk.external.BidTokenProvider;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterNetworkData;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class FyberAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    private static final String GitHash = "acabf78";
    private static final String META_DATA_DT_COPPA_KEY = "DT_COPPA";
    private static final String META_DATA_DT_IS_CHILD_KEY = "DT_IsChild";
    private static final String NETWORK_DATA_IS_CHILD_KEY = "AudienceIsChild";
    private static final String VERSION = "4.3.40";
    private static Boolean mCCPA = null;
    private static Boolean mConsent = null;
    private static Boolean mDTCOPPA = null;
    private static boolean mDTIsChild = false;
    private static String mUserId;
    private final String APP_ID;
    private final String MEDIATION_NAME;
    private final String SPOT_ID;
    protected InneractiveAdViewUnitController mInneractiveAdViewUnitController;
    private CopyOnWriteArraySet<String> mRewardedVideoSpotIdsForInitCallbacks;
    private ConcurrentHashMap<String, InneractiveAdSpot> mSpotIdToBannerAd;
    private ConcurrentHashMap<String, FyberBannerAdListener> mSpotIdToBannerFyberAdListener;
    protected ConcurrentHashMap<String, IronSourceBannerLayout> mSpotIdToBannerLayout;
    private ConcurrentHashMap<String, BannerSmashListener> mSpotIdToBannerSmashListener;
    private ConcurrentHashMap<String, InneractiveAdSpot> mSpotIdToInterstitialAd;
    private ConcurrentHashMap<String, FyberInterstitialAdListener> mSpotIdToInterstitialFyberAdListener;
    private ConcurrentHashMap<String, InterstitialSmashListener> mSpotIdToInterstitialSmashListener;
    private ConcurrentHashMap<String, InneractiveAdSpot> mSpotIdToRewardedVideoAd;
    private ConcurrentHashMap<String, FyberRewardedVideoAdListener> mSpotIdToRewardedVideoFyberAdListener;
    private ConcurrentHashMap<String, RewardedVideoSmashListener> mSpotIdToRewardedVideoSmashListener;
    private static AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
    private static InitState mInitState = InitState.INIT_STATE_NONE;
    private static HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();

    private enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS,
        INIT_STATE_FAILED
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return false;
    }

    public static FyberAdapter startAdapter(String str) {
        return new FyberAdapter(str);
    }

    private FyberAdapter(String str) {
        super(str);
        this.MEDIATION_NAME = "IronSource";
        this.APP_ID = "appId";
        this.SPOT_ID = "adSpotId";
        IronLog.INTERNAL.verbose();
        this.mSpotIdToRewardedVideoAd = new ConcurrentHashMap<>();
        this.mSpotIdToRewardedVideoSmashListener = new ConcurrentHashMap<>();
        this.mSpotIdToRewardedVideoFyberAdListener = new ConcurrentHashMap<>();
        this.mRewardedVideoSpotIdsForInitCallbacks = new CopyOnWriteArraySet<>();
        this.mSpotIdToInterstitialAd = new ConcurrentHashMap<>();
        this.mSpotIdToInterstitialSmashListener = new ConcurrentHashMap<>();
        this.mSpotIdToInterstitialFyberAdListener = new ConcurrentHashMap<>();
        this.mSpotIdToBannerAd = new ConcurrentHashMap<>();
        this.mSpotIdToBannerSmashListener = new ConcurrentHashMap<>();
        this.mSpotIdToBannerFyberAdListener = new ConcurrentHashMap<>();
        this.mSpotIdToBannerLayout = new ConcurrentHashMap<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData("Fyber", "4.3.40");
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.3.40";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return getAdapterSDKVersion();
    }

    public static String getAdapterSDKVersion() {
        return InneractiveAdManager.getVersion();
    }

    private void initSDK(final String str, final String str2) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.fyber.FyberAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                if (FyberAdapter.mInitState == InitState.INIT_STATE_NONE || FyberAdapter.mInitState == InitState.INIT_STATE_IN_PROGRESS) {
                    FyberAdapter.initCallbackListeners.add(FyberAdapter.this);
                }
                if (FyberAdapter.mWasInitCalled.compareAndSet(false, true)) {
                    IronLog.ADAPTER_API.verbose("appId = " + str);
                    FyberAdapter.mInitState = InitState.INIT_STATE_IN_PROGRESS;
                    FyberAdapter.mUserId = str2;
                    FyberAdapter.this.setIsChildValue(FyberAdapter.mDTIsChild);
                    InneractiveAdManager.initialize(ContextProvider.getInstance().getApplicationContext(), str, new OnFyberMarketplaceInitializedListener() { // from class: com.ironsource.adapters.fyber.FyberAdapter.1.1
                        @Override // com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener
                        public void onFyberMarketplaceInitialized(OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus) {
                            if (fyberInitStatus == OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY) {
                                FyberAdapter.this.initializationSuccess();
                            } else {
                                FyberAdapter.this.initializationFailure();
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializationSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = InitState.INIT_STATE_SUCCESS;
        if (!TextUtils.isEmpty(mUserId)) {
            IronLog.INTERNAL.verbose("setUserID to " + mUserId);
            InneractiveAdManager.setUserId(mUserId);
        }
        Boolean bool = mConsent;
        if (bool != null) {
            setConsent(bool.booleanValue());
        }
        Boolean bool2 = mCCPA;
        if (bool2 != null) {
            setCCPAValue(bool2.booleanValue());
        }
        Boolean bool3 = mDTCOPPA;
        if (bool3 != null) {
            setCOPPAValue(bool3.booleanValue());
        }
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializationFailure() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = InitState.INIT_STATE_FAILED;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed("Fyber sdk init failed");
        }
        initCallbackListeners.clear();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        for (String str : this.mSpotIdToRewardedVideoSmashListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mSpotIdToRewardedVideoSmashListener.get(str);
            if (this.mRewardedVideoSpotIdsForInitCallbacks.contains(str)) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideoInternal(str, null, rewardedVideoSmashListener);
            }
        }
        Iterator<InterstitialSmashListener> it = this.mSpotIdToInterstitialSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onInterstitialInitSuccess();
        }
        Iterator<BannerSmashListener> it2 = this.mSpotIdToBannerSmashListener.values().iterator();
        while (it2.hasNext()) {
            it2.next().onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        for (String str2 : this.mSpotIdToRewardedVideoSmashListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mSpotIdToRewardedVideoSmashListener.get(str2);
            if (this.mRewardedVideoSpotIdsForInitCallbacks.contains(str2)) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
        Iterator<InterstitialSmashListener> it = this.mSpotIdToInterstitialSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, "Interstitial"));
        }
        Iterator<BannerSmashListener> it2 = this.mSpotIdToBannerSmashListener.values().iterator();
        while (it2.hasNext()) {
            it2.next().onBannerInitFailed(ErrorBuilder.buildInitFailedError(str, "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("adSpotId");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - appId");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing param - appId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("Missing param - adSpotId");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - adSpotId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        IronLog.ADAPTER_API.verbose("spotId = " + optString2);
        this.mSpotIdToRewardedVideoSmashListener.put(optString2, rewardedVideoSmashListener);
        this.mRewardedVideoSpotIdsForInitCallbacks.add(optString2);
        int i = AnonymousClass10.$SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[mInitState.ordinal()];
        if (i == 1 || i == 2) {
            initSDK(optString, str2);
            return;
        }
        if (i == 3) {
            rewardedVideoSmashListener.onRewardedVideoInitSuccess();
        } else {
            if (i != 4) {
                return;
            }
            IronLog.INTERNAL.verbose("init failed - spotId = " + optString2);
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Fyber sdk init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
    }

    /* renamed from: com.ironsource.adapters.fyber.FyberAdapter$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState;

        static {
            int[] iArr = new int[InitState.values().length];
            $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState = iArr;
            try {
                iArr[InitState.INIT_STATE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[InitState.INIT_STATE_IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[InitState.INIT_STATE_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[InitState.INIT_STATE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("adSpotId");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - appId");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("Missing param - adSpotId");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        IronLog.ADAPTER_API.verbose("spotId = " + optString2);
        this.mSpotIdToRewardedVideoSmashListener.put(optString2, rewardedVideoSmashListener);
        int i = AnonymousClass10.$SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[mInitState.ordinal()];
        if (i == 1 || i == 2) {
            initSDK(optString, str2);
            return;
        }
        if (i == 3) {
            loadRewardedVideoInternal(optString2, null, rewardedVideoSmashListener);
        } else {
            if (i != 4) {
                return;
            }
            IronLog.INTERNAL.verbose("init failed - spotId = " + optString2);
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoInternal(jSONObject.optString("adSpotId"), str, rewardedVideoSmashListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoInternal(jSONObject.optString("adSpotId"), null, rewardedVideoSmashListener);
    }

    private void loadRewardedVideoInternal(final String str, final String str2, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.ADAPTER_API.verbose("spotId = " + str);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.fyber.FyberAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToRewardedVideoAd.get(str);
                if (inneractiveAdSpot != null) {
                    inneractiveAdSpot.destroy();
                    FyberAdapter.this.mSpotIdToRewardedVideoAd.remove(str);
                }
                InneractiveAdSpot createSpot = InneractiveAdSpotManager.get().createSpot();
                createSpot.addUnitController(new InneractiveFullscreenUnitController());
                FyberAdapter.this.setMediationData(createSpot);
                FyberRewardedVideoAdListener fyberRewardedVideoAdListener = new FyberRewardedVideoAdListener(rewardedVideoSmashListener, str);
                FyberAdapter.this.mSpotIdToRewardedVideoFyberAdListener.put(str, fyberRewardedVideoAdListener);
                createSpot.setRequestListener(fyberRewardedVideoAdListener);
                FyberAdapter.this.mSpotIdToRewardedVideoAd.put(str, createSpot);
                String str3 = str2;
                if (str3 == null) {
                    createSpot.requestAd(new InneractiveAdRequest(str));
                } else {
                    createSpot.loadAd(str3);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(final JSONObject jSONObject, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        final String optString = jSONObject.optString("adSpotId");
        IronLog.ADAPTER_API.verbose("spotId = " + optString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.fyber.FyberAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(FyberAdapter.this.getDynamicUserId())) {
                    IronLog.INTERNAL.verbose("setUserID to " + FyberAdapter.this.getDynamicUserId());
                    InneractiveAdManager.setUserId(FyberAdapter.this.getDynamicUserId());
                }
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToRewardedVideoAd.get(optString);
                if (inneractiveAdSpot != null && FyberAdapter.this.isRewardedVideoAvailable(jSONObject)) {
                    InneractiveFullscreenUnitController inneractiveFullscreenUnitController = (InneractiveFullscreenUnitController) inneractiveAdSpot.getSelectedUnitController();
                    FyberRewardedVideoAdListener fyberRewardedVideoAdListener = (FyberRewardedVideoAdListener) FyberAdapter.this.mSpotIdToRewardedVideoFyberAdListener.get(optString);
                    inneractiveFullscreenUnitController.setRewardedListener(fyberRewardedVideoAdListener);
                    inneractiveFullscreenUnitController.setEventsListener(fyberRewardedVideoAdListener);
                    InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = new InneractiveFullscreenVideoContentController();
                    inneractiveFullscreenVideoContentController.setEventsListener(fyberRewardedVideoAdListener);
                    inneractiveFullscreenUnitController.addContentController(inneractiveFullscreenVideoContentController);
                    inneractiveFullscreenUnitController.show(ContextProvider.getInstance().getCurrentActiveActivity());
                    return;
                }
                rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String optString = jSONObject.optString("adSpotId");
        IronLog.ADAPTER_API.verbose("spotId = " + optString);
        InneractiveAdSpot inneractiveAdSpot = this.mSpotIdToRewardedVideoAd.get(optString);
        return inneractiveAdSpot != null && inneractiveAdSpot.isReady();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        initInterstitial(str, str2, jSONObject, interstitialSmashListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("adSpotId");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("missing param - appId");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing param - appId", "Interstitial"));
            return;
        }
        if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("missing param - adSpotId");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - adSpotId", "Interstitial"));
            return;
        }
        IronLog.ADAPTER_API.verbose("spotId = " + optString2);
        this.mSpotIdToInterstitialSmashListener.put(optString2, interstitialSmashListener);
        int i = AnonymousClass10.$SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[mInitState.ordinal()];
        if (i == 1 || i == 2) {
            initSDK(optString, str2);
            return;
        }
        if (i == 3) {
            interstitialSmashListener.onInterstitialInitSuccess();
        } else {
            if (i != 4) {
                return;
            }
            IronLog.INTERNAL.verbose("init failed - spotId = " + optString2);
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Fyber sdk init failed", "Interstitial"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        loadInterstitialInternal(jSONObject.optString("adSpotId"), str, interstitialSmashListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        loadInterstitialInternal(jSONObject.optString("adSpotId"), null, interstitialSmashListener);
    }

    private void loadInterstitialInternal(final String str, final String str2, final InterstitialSmashListener interstitialSmashListener) {
        IronLog.ADAPTER_API.verbose("spotId = " + str);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.fyber.FyberAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToInterstitialAd.get(str);
                if (inneractiveAdSpot != null) {
                    IronLog.ADAPTER_API.verbose("destroying previous ad with spotId " + str);
                    inneractiveAdSpot.destroy();
                    FyberAdapter.this.mSpotIdToInterstitialAd.remove(str);
                }
                InneractiveAdSpot createSpot = InneractiveAdSpotManager.get().createSpot();
                createSpot.addUnitController(new InneractiveFullscreenUnitController());
                FyberAdapter.this.setMediationData(createSpot);
                FyberInterstitialAdListener fyberInterstitialAdListener = new FyberInterstitialAdListener(interstitialSmashListener, str);
                FyberAdapter.this.mSpotIdToInterstitialFyberAdListener.put(str, fyberInterstitialAdListener);
                createSpot.setRequestListener(fyberInterstitialAdListener);
                FyberAdapter.this.mSpotIdToInterstitialAd.put(str, createSpot);
                String str3 = str2;
                if (str3 == null) {
                    createSpot.requestAd(new InneractiveAdRequest(str));
                } else {
                    createSpot.loadAd(str3);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(final JSONObject jSONObject, final InterstitialSmashListener interstitialSmashListener) {
        final String optString = jSONObject.optString("adSpotId");
        IronLog.ADAPTER_API.verbose("spotId = " + optString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.fyber.FyberAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToInterstitialAd.get(optString);
                if (inneractiveAdSpot != null && FyberAdapter.this.isInterstitialReady(jSONObject)) {
                    InneractiveFullscreenUnitController inneractiveFullscreenUnitController = (InneractiveFullscreenUnitController) inneractiveAdSpot.getSelectedUnitController();
                    inneractiveFullscreenUnitController.setEventsListener((FyberInterstitialAdListener) FyberAdapter.this.mSpotIdToInterstitialFyberAdListener.get(optString));
                    inneractiveFullscreenUnitController.addContentController(new InneractiveFullscreenVideoContentController());
                    IronLog.ADAPTER_API.verbose("showInterstitial - show");
                    inneractiveFullscreenUnitController.show(ContextProvider.getInstance().getCurrentActiveActivity());
                    return;
                }
                interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject jSONObject) {
        String optString = jSONObject.optString("adSpotId");
        IronLog.ADAPTER_API.verbose("spotId = " + optString);
        InneractiveAdSpot inneractiveAdSpot = this.mSpotIdToInterstitialAd.get(optString);
        return inneractiveAdSpot != null && inneractiveAdSpot.isReady();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        initBanners(str, str2, jSONObject, bannerSmashListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("adSpotId");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("missing param - appId");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing param - appId", "Banner"));
            return;
        }
        if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("missing param - adSpotId");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - adSpotId", "Banner"));
            return;
        }
        IronLog.ADAPTER_API.verbose("spotId = " + optString2);
        this.mSpotIdToBannerSmashListener.put(optString2, bannerSmashListener);
        int i = AnonymousClass10.$SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[mInitState.ordinal()];
        if (i == 1 || i == 2) {
            initSDK(optString, str2);
            return;
        }
        if (i == 3) {
            bannerSmashListener.onBannerInitSuccess();
        } else {
            if (i != 4) {
                return;
            }
            IronLog.INTERNAL.verbose("init failed - spotId = " + optString2);
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Fyber sdk init failed", "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject.optString("adSpotId"), ironSourceBannerLayout, bannerSmashListener, str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject.optString("adSpotId"), ironSourceBannerLayout, bannerSmashListener, null);
    }

    private void loadBannerInternal(final String str, final IronSourceBannerLayout ironSourceBannerLayout, final BannerSmashListener bannerSmashListener, final String str2) {
        IronLog.ADAPTER_API.verbose("spotId = " + str);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.fyber.FyberAdapter.6
            @Override // java.lang.Runnable
            public void run() {
                IronSourceBannerLayout ironSourceBannerLayout2 = ironSourceBannerLayout;
                if (ironSourceBannerLayout2 == null || ironSourceBannerLayout2.isDestroyed()) {
                    bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Fyber loadBanner - banner ".concat(ironSourceBannerLayout == null ? "layout is null" : "is destroyed")));
                    return;
                }
                FyberAdapter.this.mSpotIdToBannerLayout.put(str, ironSourceBannerLayout);
                InneractiveAdSpot createSpot = InneractiveAdSpotManager.get().createSpot();
                FyberAdapter.this.setMediationData(createSpot);
                FyberAdapter.this.mInneractiveAdViewUnitController = new InneractiveAdViewUnitController();
                createSpot.addUnitController(FyberAdapter.this.mInneractiveAdViewUnitController);
                FyberBannerAdListener fyberBannerAdListener = new FyberBannerAdListener(FyberAdapter.this, bannerSmashListener, str);
                FyberAdapter.this.mSpotIdToBannerFyberAdListener.put(str, fyberBannerAdListener);
                createSpot.setRequestListener(fyberBannerAdListener);
                FyberAdapter.this.mInneractiveAdViewUnitController.setEventsListener(fyberBannerAdListener);
                FyberAdapter.this.mSpotIdToBannerAd.put(str, createSpot);
                String str3 = str2;
                if (str3 == null) {
                    createSpot.requestAd(new InneractiveAdRequest(str));
                } else {
                    createSpot.loadAd(str3);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject jSONObject) {
        final String optString = jSONObject.optString("adSpotId");
        IronLog.ADAPTER_API.verbose("spotId = " + optString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.fyber.FyberAdapter.7
            @Override // java.lang.Runnable
            public void run() {
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToBannerAd.get(optString);
                if (inneractiveAdSpot != null) {
                    IronLog.ADAPTER_API.verbose("destroying previous ad with spotId " + optString);
                    inneractiveAdSpot.destroy();
                    FyberAdapter.this.mSpotIdToBannerAd.remove(optString);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(final boolean z) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.fyber.FyberAdapter.8
            @Override // java.lang.Runnable
            public void run() {
                if (FyberAdapter.mWasInitCalled.get()) {
                    IronLog.ADAPTER_API.verbose("setConsent - consent = " + z);
                    InneractiveAdManager.setGdprConsent(z);
                } else {
                    FyberAdapter.mConsent = Boolean.valueOf(z);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setMetaData(String str, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        String str2 = list.get(0);
        IronLog.ADAPTER_API.verbose("key = " + str + ", value = " + str2);
        if (MetaDataUtils.isValidCCPAMetaData(str, str2)) {
            setCCPAValue(MetaDataUtils.getMetaDataBooleanValue(str2));
            return;
        }
        String formatValueForType = MetaDataUtils.formatValueForType(str2, MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
        if (MetaDataUtils.isValidMetaData(str, META_DATA_DT_IS_CHILD_KEY, formatValueForType)) {
            setIsChildValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
        } else if (MetaDataUtils.isValidMetaData(str, META_DATA_DT_COPPA_KEY, formatValueForType)) {
            setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface
    public void setNetworkData(AdapterNetworkData adapterNetworkData) {
        Boolean bool = (Boolean) getNetworkDataValueByKey(adapterNetworkData.allData(), NETWORK_DATA_IS_CHILD_KEY, Boolean.class);
        if (bool != null) {
            IronLog.ADAPTER_API.verbose("key = AudienceIsChild, value = " + bool);
            setIsChildValue(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsChildValue(boolean z) {
        if (mInitState == InitState.INIT_STATE_NONE) {
            mDTIsChild = z;
        } else if (mInitState == InitState.INIT_STATE_IN_PROGRESS && z) {
            IronLog.ADAPTER_API.verbose("calling InneractiveAdManager.currentAudienceIsAChild");
            InneractiveAdManager.currentAudienceIsAChild();
        }
    }

    private void setCOPPAValue(boolean z) {
        if (z) {
            if (mInitState == InitState.INIT_STATE_SUCCESS) {
                IronLog.ADAPTER_API.verbose("calling InneractiveAdManager.currentAudienceAppliesToCoppa");
                InneractiveAdManager.currentAudienceAppliesToCoppa();
            } else {
                mDTCOPPA = Boolean.valueOf(z);
            }
        }
    }

    private void setCCPAValue(final boolean z) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.fyber.FyberAdapter.9
            @Override // java.lang.Runnable
            public void run() {
                if (FyberAdapter.mWasInitCalled.get()) {
                    IronLog.ADAPTER_API.verbose("setCCPAValue - value = ".concat(z ? "1YY-" : "1YN-"));
                    InneractiveAdManager.setUSPrivacyString(z ? "1YY-" : "1YN-");
                } else {
                    FyberAdapter.mCCPA = Boolean.valueOf(z);
                }
            }
        });
    }

    private <T> T getNetworkDataValueByKey(JSONObject jSONObject, String str, Class<T> cls) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.equalsIgnoreCase(str)) {
                Object opt = jSONObject.opt(next);
                if (cls.isInstance(opt)) {
                    return cls.cast(opt);
                }
            }
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            Iterator<InneractiveAdSpot> it = this.mSpotIdToRewardedVideoAd.values().iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.mSpotIdToRewardedVideoAd.clear();
            this.mSpotIdToRewardedVideoSmashListener.clear();
            this.mSpotIdToRewardedVideoFyberAdListener.clear();
            this.mRewardedVideoSpotIdsForInitCallbacks.clear();
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            Iterator<InneractiveAdSpot> it2 = this.mSpotIdToInterstitialAd.values().iterator();
            while (it2.hasNext()) {
                it2.next().destroy();
            }
            this.mSpotIdToInterstitialAd.clear();
            this.mSpotIdToInterstitialSmashListener.clear();
            this.mSpotIdToInterstitialFyberAdListener.clear();
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            Iterator<InneractiveAdSpot> it3 = this.mSpotIdToBannerAd.values().iterator();
            while (it3.hasNext()) {
                it3.next().destroy();
            }
            this.mSpotIdToBannerAd.clear();
            this.mSpotIdToBannerLayout.clear();
            this.mSpotIdToBannerSmashListener.clear();
            this.mSpotIdToBannerFyberAdListener.clear();
        }
    }

    private Map<String, Object> getBiddingData() {
        if (mInitState != InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("returning null as token since init did not finish");
            return null;
        }
        String bidderToken = BidTokenProvider.getBidderToken();
        if (TextUtils.isEmpty(bidderToken)) {
            bidderToken = "";
        }
        IronLog.ADAPTER_API.verbose("token = " + bidderToken);
        HashMap hashMap = new HashMap();
        hashMap.put("token", bidderToken);
        return hashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r6.equals("RECTANGLE") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FrameLayout.LayoutParams calculateLayoutParams(ISBannerSize iSBannerSize) {
        FrameLayout.LayoutParams layoutParams;
        if (iSBannerSize == null) {
            IronLog.ADAPTER_API.error("bannerSize is null");
            return null;
        }
        char c = 0;
        new FrameLayout.LayoutParams(0, 0);
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        String description = iSBannerSize.getDescription();
        description.hashCode();
        switch (description.hashCode()) {
            case -387072689:
                break;
            case 79011241:
                if (description.equals("SMART")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1951953708:
                if (description.equals("BANNER")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, 300), AdapterUtils.dpToPixels(applicationContext, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
                break;
            case 1:
                if (AdapterUtils.isLargeScreen(applicationContext)) {
                    layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, 728), AdapterUtils.dpToPixels(applicationContext, 90));
                    break;
                } else {
                    layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(applicationContext, 50));
                    break;
                }
            case 2:
                layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(applicationContext, 50));
                break;
            default:
                return null;
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediationData(InneractiveAdSpot inneractiveAdSpot) {
        inneractiveAdSpot.setMediationName("IronSource");
        inneractiveAdSpot.setMediationVersion("4.3.40");
    }
}
