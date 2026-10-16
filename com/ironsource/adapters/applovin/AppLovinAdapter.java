package com.ironsource.adapters.applovin;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class AppLovinAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    private static final String GitHash = "a47ca2f";
    private static final String SDK_KEY = "sdkKey";
    private static final String VERSION = "4.3.55";
    private static final String ZONE_ID = "zoneId";
    private static AppLovinSdk mAppLovinSdk;
    private static AppLovinSdkSettings mAppLovinSettings;
    private AppLovinRewardedVideoListener mAppLovinRewardedVideoListener;
    private String mInterstitialZoneId;
    private AppLovinAd mRewardedAppLovinAd;
    private AppLovinIncentivizedInterstitial mRewardedVideoAd;
    private RewardedVideoSmashListener mRewardedVideoSmashListener;
    private String mRewardedVideoZoneId;
    private boolean mShouldNotifyOnRewardedVideoInitCallback;
    protected final ConcurrentHashMap<String, AppLovinBannerListener> mZoneIdToAppLovinBannerListener;
    protected final ConcurrentHashMap<String, AppLovinInterstitialListener> mZoneIdToAppLovinInterstitialListener;
    protected final ConcurrentHashMap<String, AppLovinAdView> mZoneIdToBannerAd;
    protected final ConcurrentHashMap<String, FrameLayout.LayoutParams> mZoneIdToBannerLayout;
    protected final ConcurrentHashMap<String, AppLovinAdSize> mZoneIdToBannerSize;
    protected final ConcurrentHashMap<String, BannerSmashListener> mZoneIdToBannerSmashListener;
    private final ConcurrentHashMap<String, Boolean> mZoneIdToInterstitialAdReadyStatus;
    protected final ConcurrentHashMap<String, InterstitialSmashListener> mZoneIdToInterstitialSmashListener;
    private static final AppLovinAdHolder<AppLovinAd> mInterstitialAds = new AppLovinAdHolder<>();
    private static final AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
    private static InitState mInitState = InitState.INIT_STATE_NONE;
    private static final HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();

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

    public static AppLovinAdapter startAdapter(String str) {
        return new AppLovinAdapter(str);
    }

    private AppLovinAdapter(String str) {
        super(str);
        this.mShouldNotifyOnRewardedVideoInitCallback = false;
        IronLog.INTERNAL.verbose();
        this.mZoneIdToAppLovinInterstitialListener = new ConcurrentHashMap<>();
        this.mZoneIdToInterstitialSmashListener = new ConcurrentHashMap<>();
        this.mZoneIdToInterstitialAdReadyStatus = new ConcurrentHashMap<>();
        this.mZoneIdToAppLovinBannerListener = new ConcurrentHashMap<>();
        this.mZoneIdToBannerSmashListener = new ConcurrentHashMap<>();
        this.mZoneIdToBannerLayout = new ConcurrentHashMap<>();
        this.mZoneIdToBannerAd = new ConcurrentHashMap<>();
        this.mZoneIdToBannerSize = new ConcurrentHashMap<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData("AppLovin", "4.3.55");
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.3.55";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return getAdapterSDKVersion();
    }

    public static String getAdapterSDKVersion() {
        return AppLovinSdk.VERSION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initSdk, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$initRewardedVideoWithCallback$1(String str, String str2) {
        if (mInitState == InitState.INIT_STATE_NONE || mInitState == InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            IronLog.ADAPTER_API.verbose("sdkKey = " + str);
            Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            mInitState = InitState.INIT_STATE_IN_PROGRESS;
            try {
                AppLovinSdkInitializationConfiguration build = AppLovinSdkInitializationConfiguration.builder(str).setMediationProvider("ironsource").build();
                AppLovinSdk appLovinSdk = AppLovinSdk.getInstance(applicationContext);
                mAppLovinSdk = appLovinSdk;
                AppLovinSdkSettings settings = appLovinSdk.getSettings();
                settings.setVerboseLogging(isAdaptersDebugEnabled());
                if (!TextUtils.isEmpty(str2)) {
                    IronLog.ADAPTER_API.verbose("setUserIdentifier to " + str2);
                    settings.setUserIdentifier(str2);
                }
                mAppLovinSettings = settings;
                mAppLovinSdk.initialize(build, new AppLovinSdk.SdkInitializationListener() { // from class: com.ironsource.adapters.applovin.AppLovinAdapter$$ExternalSyntheticLambda7
                    @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
                    public final void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                        AppLovinAdapter.this.lambda$initSdk$0(appLovinSdkConfiguration);
                    }
                });
            } catch (Throwable th) {
                initializationFailure(th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSdk$0(AppLovinSdkConfiguration appLovinSdkConfiguration) {
        initializationSuccess();
    }

    private void initializationSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = InitState.INIT_STATE_SUCCESS;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    private void initializationFailure(String str) {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = InitState.INIT_STATE_FAILED;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed("AppLovin sdk init failed - " + str);
        }
        initCallbackListeners.clear();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mRewardedVideoSmashListener;
        if (rewardedVideoSmashListener != null) {
            if (this.mShouldNotifyOnRewardedVideoInitCallback) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideoInternal(this.mRewardedVideoZoneId, rewardedVideoSmashListener);
            }
        }
        Iterator<InterstitialSmashListener> it = this.mZoneIdToInterstitialSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onInterstitialInitSuccess();
        }
        Iterator<BannerSmashListener> it2 = this.mZoneIdToBannerSmashListener.values().iterator();
        while (it2.hasNext()) {
            it2.next().onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String str) {
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mRewardedVideoSmashListener;
        if (rewardedVideoSmashListener != null) {
            if (this.mShouldNotifyOnRewardedVideoInitCallback) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
        Iterator<InterstitialSmashListener> it = this.mZoneIdToInterstitialSmashListener.values().iterator();
        while (it.hasNext()) {
            it.next().onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, "Interstitial"));
        }
        Iterator<BannerSmashListener> it2 = this.mZoneIdToBannerSmashListener.values().iterator();
        while (it2.hasNext()) {
            it2.next().onBannerInitFailed(ErrorBuilder.buildInitFailedError(str, "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String str, final String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String zoneId = getZoneId(jSONObject);
        final String optString = jSONObject.optString(SDK_KEY);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("error - missing param - sdkKey");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing param - sdkKey", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        if (TextUtils.isEmpty(zoneId)) {
            IronLog.INTERNAL.error("Missing param - zoneId");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing param - zoneId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        IronLog.ADAPTER_API.verbose("zoneId = " + zoneId);
        this.mRewardedVideoSmashListener = rewardedVideoSmashListener;
        this.mShouldNotifyOnRewardedVideoInitCallback = true;
        int i = AnonymousClass1.$SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[mInitState.ordinal()];
        if (i == 1 || i == 2) {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.applovin.AppLovinAdapter$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    AppLovinAdapter.this.lambda$initRewardedVideoWithCallback$1(optString, str2);
                }
            });
            return;
        }
        if (i == 3) {
            rewardedVideoSmashListener.onRewardedVideoInitSuccess();
        } else {
            if (i != 4) {
                return;
            }
            IronLog.INTERNAL.verbose("init failed - zoneId = " + zoneId);
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("AppLovin sdk init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
    }

    /* renamed from: com.ironsource.adapters.applovin.AppLovinAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState;

        static {
            int[] iArr = new int[InitState.values().length];
            $SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState = iArr;
            try {
                iArr[InitState.INIT_STATE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[InitState.INIT_STATE_IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[InitState.INIT_STATE_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[InitState.INIT_STATE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String str, final String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String zoneId = getZoneId(jSONObject);
        final String optString = jSONObject.optString(SDK_KEY);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - sdkKey");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        if (TextUtils.isEmpty(zoneId)) {
            IronLog.INTERNAL.error("Missing param - zoneId");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        IronLog.ADAPTER_API.verbose("zoneId = " + zoneId);
        this.mRewardedVideoSmashListener = rewardedVideoSmashListener;
        this.mRewardedVideoZoneId = zoneId;
        int i = AnonymousClass1.$SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[mInitState.ordinal()];
        if (i == 1 || i == 2) {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.applovin.AppLovinAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AppLovinAdapter.this.lambda$initAndLoadRewardedVideo$2(optString, str2);
                }
            });
            return;
        }
        if (i == 3) {
            loadRewardedVideoInternal(zoneId, rewardedVideoSmashListener);
        } else {
            if (i != 4) {
                return;
            }
            IronLog.INTERNAL.verbose("init failed - zoneId = " + zoneId);
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoInternal(getZoneId(jSONObject), rewardedVideoSmashListener);
    }

    private void loadRewardedVideoInternal(String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.ADAPTER_API.verbose("zoneId = " + str);
        this.mRewardedVideoZoneId = str;
        this.mRewardedVideoSmashListener = rewardedVideoSmashListener;
        this.mRewardedVideoAd = new AppLovinIncentivizedInterstitial(str);
        this.mAppLovinRewardedVideoListener = new AppLovinRewardedVideoListener(this, rewardedVideoSmashListener, str);
        mAppLovinSdk.getAdService().loadNextAdForZoneId(str, this.mAppLovinRewardedVideoListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog.ADAPTER_API.verbose("zoneId = " + getZoneId(jSONObject));
        if (isRewardedVideoAvailable(jSONObject)) {
            if (!TextUtils.isEmpty(getDynamicUserId())) {
                mAppLovinSettings.setUserIdentifier(getDynamicUserId());
            }
            AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = this.mRewardedVideoAd;
            AppLovinAd appLovinAd = this.mRewardedAppLovinAd;
            AppLovinRewardedVideoListener appLovinRewardedVideoListener = this.mAppLovinRewardedVideoListener;
            appLovinIncentivizedInterstitial.show(appLovinAd, appLovinRewardedVideoListener, appLovinRewardedVideoListener, appLovinRewardedVideoListener, appLovinRewardedVideoListener);
            return;
        }
        rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        return this.mRewardedVideoAd != null;
    }

    public void setRewardedVideoAd(AppLovinAd appLovinAd) {
        this.mRewardedAppLovinAd = appLovinAd;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitial(String str, final String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String zoneId = getZoneId(jSONObject);
        final String optString = jSONObject.optString(SDK_KEY);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - sdkKey");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing param - sdkKey", "Interstitial"));
            return;
        }
        if (TextUtils.isEmpty(zoneId)) {
            IronLog.INTERNAL.error("Missing param - zoneId");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing param - zoneId", "Interstitial"));
            return;
        }
        IronLog.ADAPTER_API.verbose("zoneId = " + zoneId);
        this.mZoneIdToInterstitialSmashListener.put(zoneId, interstitialSmashListener);
        int i = AnonymousClass1.$SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[mInitState.ordinal()];
        if (i == 1 || i == 2) {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.applovin.AppLovinAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AppLovinAdapter.this.lambda$initInterstitial$3(optString, str2);
                }
            });
            return;
        }
        if (i == 3) {
            interstitialSmashListener.onInterstitialInitSuccess();
        } else {
            if (i != 4) {
                return;
            }
            IronLog.INTERNAL.verbose("init failed - zoneId = " + zoneId);
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("AppLovin sdk init failed", "Interstitial"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        String zoneId = getZoneId(jSONObject);
        IronLog.ADAPTER_API.verbose("zoneId = " + zoneId);
        AppLovinInterstitialListener appLovinInterstitialListener = new AppLovinInterstitialListener(this, interstitialSmashListener, zoneId);
        this.mZoneIdToAppLovinInterstitialListener.put(zoneId, appLovinInterstitialListener);
        if (isInterstitialZoneIdExist(zoneId)) {
            IronLog.INTERNAL.info("Interstitial load request skipped. An interstitial ad with the same configuration is currently in use");
            interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Interstitial load request skipped. An interstitial ad with the same configuration is currently in use"));
        } else {
            this.mInterstitialZoneId = zoneId;
            mAppLovinSdk.getAdService().loadNextAdForZoneId(zoneId, appLovinInterstitialListener);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String zoneId = getZoneId(jSONObject);
        IronLog.ADAPTER_API.verbose("zoneId = " + zoneId);
        if (isInterstitialReady(jSONObject)) {
            AppLovinAd retrieveAd = mInterstitialAds.retrieveAd(this);
            AppLovinInterstitialListener appLovinInterstitialListener = this.mZoneIdToAppLovinInterstitialListener.get(zoneId);
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create();
            create.setAdClickListener(appLovinInterstitialListener);
            create.setAdDisplayListener(appLovinInterstitialListener);
            create.setAdVideoPlaybackListener(appLovinInterstitialListener);
            create.showAndRender(retrieveAd);
        } else {
            AppLovinAdHolder<AppLovinAd> appLovinAdHolder = mInterstitialAds;
            if (appLovinAdHolder != null) {
                appLovinAdHolder.removeAd(this);
            }
            interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
        }
        updateInterstitialAvailability(zoneId, false);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject jSONObject) {
        AppLovinAdHolder<AppLovinAd> appLovinAdHolder = mInterstitialAds;
        if (appLovinAdHolder == null) {
            IronLog.INTERNAL.verbose("mInterstitialAds is null");
            return false;
        }
        String zoneId = getZoneId(jSONObject);
        return appLovinAdHolder.retrieveAd(this) != null && this.mZoneIdToInterstitialAdReadyStatus.containsKey(zoneId) && Boolean.TRUE.equals(this.mZoneIdToInterstitialAdReadyStatus.get(zoneId)) && isInterstitialZoneIdExist(zoneId);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void disposeInterstitialAd(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            str = "";
        } else {
            str = jSONObject.optString(ZONE_ID);
        }
        disposeInterstitialAd(str);
    }

    void disposeInterstitialAd(String str) {
        IronLog.ADAPTER_API.verbose("Dispose interstitial ad of " + getProviderName() + ", zoneId = " + str);
        mInterstitialAds.removeAd(this);
    }

    void updateInterstitialAvailability(String str, boolean z) {
        this.mZoneIdToInterstitialAdReadyStatus.put(str, Boolean.valueOf(z));
    }

    void addAdToInterstitialAdapter(AppLovinAd appLovinAd) {
        mInterstitialAds.storeAd(this, appLovinAd);
    }

    private boolean isInterstitialZoneIdExist(String str) {
        AppLovinAdHolder<AppLovinAd> appLovinAdHolder = mInterstitialAds;
        if (appLovinAdHolder == null) {
            IronLog.INTERNAL.error("mInterstitialAds is null in isInterstitialZoneIdExist");
            return false;
        }
        Iterator<AppLovinAdapter> it = appLovinAdHolder.getAdapters().iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().getInterstitialZoneId())) {
                return true;
            }
        }
        return false;
    }

    private String getInterstitialZoneId() {
        return this.mInterstitialZoneId;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBanners(String str, final String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String zoneId = getZoneId(jSONObject);
        final String optString = jSONObject.optString(SDK_KEY);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - sdkKey");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing param - sdkKey", "Banner"));
            return;
        }
        if (TextUtils.isEmpty(zoneId)) {
            IronLog.INTERNAL.error("Missing param - zoneId");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing param - zoneId", "Banner"));
            return;
        }
        IronLog.ADAPTER_API.verbose("zoneId = " + zoneId);
        this.mZoneIdToBannerSmashListener.put(zoneId, bannerSmashListener);
        int i = AnonymousClass1.$SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[mInitState.ordinal()];
        if (i == 1 || i == 2) {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.applovin.AppLovinAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AppLovinAdapter.this.lambda$initBanners$4(optString, str2);
                }
            });
            return;
        }
        if (i == 3) {
            bannerSmashListener.onBannerInitSuccess();
        } else {
            if (i != 4) {
                return;
            }
            IronLog.INTERNAL.verbose("init failed - zoneId = " + zoneId);
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("AppLovin sdk init failed", "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, final IronSourceBannerLayout ironSourceBannerLayout, final BannerSmashListener bannerSmashListener) {
        final String zoneId = getZoneId(jSONObject);
        IronLog.ADAPTER_API.verbose("zoneId = " + zoneId);
        if (ironSourceBannerLayout == null) {
            IronLog.INTERNAL.error("banner layout is null");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner layout is null"));
            return;
        }
        final AppLovinAdSize calculateBannerSize = calculateBannerSize(ironSourceBannerLayout.getSize(), AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()));
        if (calculateBannerSize == null) {
            IronLog.INTERNAL.error("size not supported, size is null");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getProviderName()));
        } else {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.applovin.AppLovinAdapter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    AppLovinAdapter.this.lambda$loadBanner$5(ironSourceBannerLayout, bannerSmashListener, zoneId, calculateBannerSize);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadBanner$5(IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener, String str, AppLovinAdSize appLovinAdSize) {
        try {
            if (ironSourceBannerLayout == null) {
                IronLog.INTERNAL.verbose("banner is null");
                bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getProviderName()));
                return;
            }
            FrameLayout.LayoutParams bannerLayoutParams = getBannerLayoutParams(ironSourceBannerLayout.getSize());
            AppLovinBannerListener appLovinBannerListener = new AppLovinBannerListener(this, bannerSmashListener, str, bannerLayoutParams);
            AppLovinAdView appLovinAdView = new AppLovinAdView(appLovinAdSize);
            appLovinAdView.setAdDisplayListener(appLovinBannerListener);
            appLovinAdView.setAdClickListener(appLovinBannerListener);
            appLovinAdView.setAdViewEventListener(appLovinBannerListener);
            this.mZoneIdToBannerAd.put(str, appLovinAdView);
            this.mZoneIdToBannerLayout.put(str, bannerLayoutParams);
            this.mZoneIdToAppLovinBannerListener.put(str, appLovinBannerListener);
            this.mZoneIdToBannerSize.put(str, appLovinAdSize);
            mAppLovinSdk.getAdService().loadNextAdForZoneId(str, appLovinBannerListener);
        } catch (Exception e) {
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError(getProviderName() + " loadBanner exception " + e.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject jSONObject) {
        final String zoneId = getZoneId(jSONObject);
        final AppLovinAdView appLovinAdView = this.mZoneIdToBannerAd.get(zoneId);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.applovin.AppLovinAdapter$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AppLovinAdapter.this.lambda$destroyBanner$6(appLovinAdView, zoneId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$destroyBanner$6(AppLovinAdView appLovinAdView, String str) {
        if (appLovinAdView != null) {
            appLovinAdView.destroy();
        }
        this.mZoneIdToBannerAd.remove(str);
        this.mZoneIdToBannerLayout.remove(str);
        this.mZoneIdToAppLovinBannerListener.remove(str);
        this.mZoneIdToBannerSize.remove(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        IronLog.INTERNAL.verbose("adUnit = " + ad_unit);
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.mAppLovinRewardedVideoListener = null;
            this.mRewardedVideoSmashListener = null;
            this.mRewardedVideoAd = null;
            this.mRewardedVideoZoneId = null;
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.mZoneIdToAppLovinInterstitialListener.clear();
            this.mZoneIdToInterstitialAdReadyStatus.clear();
            disposeInterstitialAd(jSONObject);
            this.mZoneIdToInterstitialSmashListener.clear();
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.applovin.AppLovinAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AppLovinAdapter.this.lambda$releaseMemory$7();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseMemory$7() {
        Iterator<AppLovinAdView> it = this.mZoneIdToBannerAd.values().iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.mZoneIdToAppLovinBannerListener.clear();
        this.mZoneIdToBannerSmashListener.clear();
        this.mZoneIdToBannerLayout.clear();
        this.mZoneIdToBannerAd.clear();
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
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(boolean z) {
        IronLog.ADAPTER_API.verbose("consent = " + z);
        AppLovinPrivacySettings.setHasUserConsent(z);
    }

    private void setCCPAValue(boolean z) {
        IronLog.ADAPTER_API.verbose("value = " + z);
        AppLovinPrivacySettings.setDoNotSell(z);
    }

    private AppLovinAdSize calculateBannerSize(ISBannerSize iSBannerSize, boolean z) {
        if (iSBannerSize == null) {
            IronLog.ADAPTER_API.error(getProviderName() + " calculateLayoutParams - bannerSize is null");
            return null;
        }
        String description = iSBannerSize.getDescription();
        description.hashCode();
        switch (description) {
            case "RECTANGLE":
                return AppLovinAdSize.MREC;
            case "LARGE":
            case "BANNER":
                return AppLovinAdSize.BANNER;
            case "SMART":
                return z ? AppLovinAdSize.LEADER : AppLovinAdSize.BANNER;
            case "CUSTOM":
                if (iSBannerSize.getHeight() >= 40 && iSBannerSize.getHeight() <= 60) {
                    return AppLovinAdSize.BANNER;
                }
                break;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0051, code lost:
    
        if (r3.equals("RECTANGLE") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private FrameLayout.LayoutParams getBannerLayoutParams(ISBannerSize iSBannerSize) {
        char c = 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        String description = iSBannerSize.getDescription();
        description.hashCode();
        switch (description.hashCode()) {
            case -387072689:
                break;
            case 72205083:
                if (description.equals("LARGE")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 79011241:
                if (description.equals("SMART")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1951953708:
                if (description.equals("BANNER")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1999208305:
                if (description.equals("CUSTOM")) {
                    c = 4;
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
            case 3:
                layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(applicationContext, 50));
                break;
            case 2:
                if (AdapterUtils.isLargeScreen(applicationContext)) {
                    layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, 728), AdapterUtils.dpToPixels(applicationContext, 90));
                    break;
                } else {
                    layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(applicationContext, 50));
                    break;
                }
            case 4:
                if (iSBannerSize.getHeight() >= 40 && iSBannerSize.getHeight() <= 60) {
                    layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(applicationContext, 50));
                    break;
                }
                break;
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private String getZoneId(JSONObject jSONObject) {
        return jSONObject.optString(ZONE_ID);
    }

    protected String getErrorString(int i) {
        if (i == -1009) {
            return "The device had no network connectivity at the time of an ad request, either due to airplane mode or no service.";
        }
        if (i == -900) {
            return "A postback URL you attempted to dispatch was empty or nil.";
        }
        if (i == -800) {
            return "The AppLovin servers have returned an invalid response";
        }
        if (i == -600) {
            return "The user exited out of the ad early. You may or may not wish to grant a reward depending on your preference.";
        }
        if (i == -500) {
            return "A reward validation requested timed out (usually due to poor connectivity).";
        }
        if (i == -400) {
            return "An unknown server-side error occurred.";
        }
        if (i == -300) {
            return "The developer called for a rewarded video before one was available.";
        }
        if (i == -22) {
            return "The SDK is currently disabled.";
        }
        if (i == -1) {
            return "The system is in unexpected state.";
        }
        if (i == 204) {
            return "No ads are currently eligible for your device.";
        }
        if (i == -1001) {
            return "The network conditions prevented the SDK from receiving an ad.";
        }
        if (i == -1000) {
            return "The request body sent to the server was malformed or invalid.";
        }
        if (i == -8) {
            return "The provided ad token is invalid; ad token must be returned from AppLovin S2S integration.";
        }
        if (i == -7) {
            return "The zone provided is invalid; the zone needs to be added to your AppLovin account or may still be propagating to our servers.";
        }
        if (i == -6) {
            return "There has been a failure to render an ad on screen.";
        }
        switch (i) {
            case AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES /* -203 */:
                return "An attempt to cache HTML content failed; the device may be out of space or the resource was malformed.";
            case AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES /* -202 */:
                return "An attempt to cache a video resource to the filesystem failed; the device may be out of space.";
            case AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES /* -201 */:
                return "An attempt to cache an image resource to the filesystem failed; the device may be out of space.";
            case AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES /* -200 */:
                return "An attempt to cache a resource to the filesystem failed; the device may be out of space.";
            default:
                return "Unknown error";
        }
    }
}
