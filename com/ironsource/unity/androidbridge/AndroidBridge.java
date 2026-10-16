package com.ironsource.unity.androidbridge;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.ironsource.adapters.supersonicads.SupersonicConfig;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.ISContainerParams;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.WaterfallConfiguration;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.unity3d.player.UnityPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class AndroidBridge implements InitializationListener, ImpressionDataListener, SegmentListener {
    private static final AndroidBridge mInstance = new AndroidBridge();
    private IronSourceBannerLayout mBanner;
    private FrameLayout mBannerContainer;
    private int mBannerVisibilityState;
    private boolean mIsBannerLoadCalled;
    private boolean mIsBannerLoadedFirst;
    private LevelPlayInterstitialWrapper mLevelPlayInterstitialWrapper;
    private LevelPlayRewardedVideoWrapper mLevelPlayRewardedVideoWrapper;
    private Handler mUIHandler;
    private UnityImpressionDataListener mUnityImpressionDataListener;
    private UnityInitializationListener mUnityInitializationListener;
    private UnityLevelPlayBannerListener mUnityLevelPlayBannerListener;
    private UnitySegmentListener mUnitySegmentListener;

    public void setLanguage(String str) {
    }

    public void setRewardedVideoCustomParams(String str) {
    }

    public static synchronized AndroidBridge getInstance() {
        AndroidBridge androidBridge;
        synchronized (AndroidBridge.class) {
            androidBridge = mInstance;
        }
        return androidBridge;
    }

    private AndroidBridge() {
        IronSource.addImpressionDataListener(this);
        IronSource.setSegmentListener(this);
        this.mLevelPlayRewardedVideoWrapper = new LevelPlayRewardedVideoWrapper();
        this.mLevelPlayInterstitialWrapper = new LevelPlayInterstitialWrapper();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mBannerContainer = null;
        this.mBanner = null;
        this.mIsBannerLoadedFirst = false;
        this.mIsBannerLoadCalled = false;
        this.mBannerVisibilityState = 0;
    }

    public void setUnityInitializationListener(UnityInitializationListener unityInitializationListener) {
        this.mUnityInitializationListener = unityInitializationListener;
    }

    public void setUnityRewardedVideoLevelPlayListener(UnityLevelPlayRewardedVideoListener unityLevelPlayRewardedVideoListener) {
        this.mLevelPlayRewardedVideoWrapper.setLevelPlayRewardedVideoListener(unityLevelPlayRewardedVideoListener);
    }

    public void setUnityRewardedVideoManualLevelPlayListener(UnityLevelPlayRewardedVideoManualListener unityLevelPlayRewardedVideoManualListener) {
        this.mLevelPlayRewardedVideoWrapper.setLevelPlayManualRewardedVideoListener(unityLevelPlayRewardedVideoManualListener);
    }

    public void setUnityInterstitialLevelPlayListener(UnityLevelPlayInterstitialListener unityLevelPlayInterstitialListener) {
        this.mLevelPlayInterstitialWrapper.setInterstitialLevelPlaylistener(unityLevelPlayInterstitialListener);
    }

    public void setUnitySegmentListener(UnitySegmentListener unitySegmentListener) {
        this.mUnitySegmentListener = unitySegmentListener;
    }

    public void setUnityBannerLevelPlayListener(UnityLevelPlayBannerListener unityLevelPlayBannerListener) {
        this.mUnityLevelPlayBannerListener = unityLevelPlayBannerListener;
    }

    public void setUnityImpressionDataListener(UnityImpressionDataListener unityImpressionDataListener) {
        this.mUnityImpressionDataListener = unityImpressionDataListener;
    }

    @Override // com.ironsource.mediationsdk.impressionData.ImpressionDataListener
    public void onImpressionSuccess(final ImpressionData impressionData) {
        if (this.mUnityImpressionDataListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.1
                @Override // java.lang.Runnable
                public void run() {
                    AndroidBridge.this.mUnityImpressionDataListener.onImpressionDataReady(AndroidBridgeUtilities.getImpressionDataString(impressionData));
                    AndroidBridge.this.mUnityImpressionDataListener.onImpressionSuccess(AndroidBridgeUtilities.getImpressionDataString(impressionData));
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InitializationListener
    public void onInitializationComplete() {
        if (this.mUnityInitializationListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.2
                @Override // java.lang.Runnable
                public void run() {
                    AndroidBridge.this.mUnityInitializationListener.onSdkInitializationCompleted();
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.SegmentListener
    public void onSegmentReceived(final String str) {
        try {
            if (this.mUnitySegmentListener != null) {
                AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AndroidBridge.this.mUnitySegmentListener.onSegmentRecieved(str);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Activity getUnityActivity() {
        return UnityPlayer.currentActivity;
    }

    public void setPluginData(String str, String str2, String str3) {
        ConfigFile.getConfigFile().setPluginData(str, str2, str3);
    }

    public String getAdvertiserId() {
        FutureTask futureTask = new FutureTask(new Callable<String>() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.4
            @Override // java.util.concurrent.Callable
            public String call() throws Exception {
                return IronSource.getAdvertiserId(AndroidBridge.this.getUnityActivity());
            }
        });
        futureTask.run();
        try {
            return (String) futureTask.get(1L, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void validateIntegration() {
        IntegrationHelper.validateIntegration(getUnityActivity());
    }

    public void shouldTrackNetworkState(boolean z) {
        IronSource.shouldTrackNetworkState(getUnityActivity(), z);
    }

    public boolean setDynamicUserId(String str) {
        return IronSource.setDynamicUserId(str);
    }

    public void setAdaptersDebug(boolean z) {
        IronSource.setAdaptersDebug(z);
    }

    public void setManualLoadRewardedVideo(boolean z) {
        this.mLevelPlayRewardedVideoWrapper.setIronSourceManualLoadListener(z);
    }

    public void setNetworkData(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            IronSource.setNetworkData(str, new JSONObject(str2));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        IronSource.onResume(getUnityActivity());
    }

    public void onPause() {
        IronSource.onPause(getUnityActivity());
    }

    public void setUserId(String str) {
        IronSource.setUserId(str);
    }

    public void init(String str) {
        IronSource.init(getUnityActivity(), str, this);
    }

    public void init(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (IronSource.AD_UNIT.REWARDED_VIDEO.toString().equalsIgnoreCase(str2)) {
                arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
            } else if (IronSource.AD_UNIT.INTERSTITIAL.toString().equalsIgnoreCase(str2)) {
                arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
            } else if (IronSource.AD_UNIT.BANNER.toString().equalsIgnoreCase(str2)) {
                arrayList.add(IronSource.AD_UNIT.BANNER);
            }
        }
        IronSource.init(getUnityActivity(), str, this, (IronSource.AD_UNIT[]) arrayList.toArray(new IronSource.AD_UNIT[arrayList.size()]));
    }

    public void loadRewardedVideo() {
        IronSource.loadRewardedVideo();
    }

    public void showRewardedVideo() {
        IronSource.showRewardedVideo();
    }

    public void showRewardedVideo(String str) {
        IronSource.showRewardedVideo(str);
    }

    public boolean isRewardedVideoAvailable() {
        return IronSource.isRewardedVideoAvailable();
    }

    public boolean isRewardedVideoPlacementCapped(String str) {
        return IronSource.isRewardedVideoPlacementCapped(str);
    }

    public String getPlacementInfo(String str) {
        Placement rewardedVideoPlacementInfo = IronSource.getRewardedVideoPlacementInfo(str);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(AndroidBridgeConstants.PLACEMENT_NAME, rewardedVideoPlacementInfo.getPlacementName());
            hashMap.put("reward_name", rewardedVideoPlacementInfo.getRewardName());
            hashMap.put("reward_amount", Integer.valueOf(rewardedVideoPlacementInfo.getRewardAmount()));
            return new JSONObject(hashMap).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setRewardedVideoServerParams(String str) {
        IronSource.setRewardedVideoServerParameters(AndroidBridgeUtilities.getHashMapFromJsonString(str));
    }

    public void clearRewardedVideoServerParams() {
        IronSource.clearRewardedVideoServerParameters();
    }

    public void loadInterstitial() {
        IronSource.loadInterstitial();
    }

    public void showInterstitial() {
        IronSource.showInterstitial();
    }

    public void showInterstitial(String str) {
        IronSource.showInterstitial(str);
    }

    public boolean isInterstitialReady() {
        return IronSource.isInterstitialReady();
    }

    public boolean isInterstitialPlacementCapped(String str) {
        return IronSource.isInterstitialPlacementCapped(str);
    }

    public void loadBanner(String str, int i, int i2, int i3, String str2, boolean z, boolean z2, float f, float f2) {
        synchronized (mInstance) {
            if (this.mIsBannerLoadCalled) {
                return;
            }
            this.mIsBannerLoadCalled = true;
            loadAndShowBanner(str, i, i2, i3, str2, z, z2, f, f2);
        }
    }

    /* renamed from: com.ironsource.unity.androidbridge.AndroidBridge$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ float val$containerHeight;
        final /* synthetic */ float val$containerWidth;
        final /* synthetic */ String val$description;
        final /* synthetic */ int val$height;
        final /* synthetic */ boolean val$isAdaptive;
        final /* synthetic */ boolean val$isRespectCutoutsEnabled;
        final /* synthetic */ String val$placementName;
        final /* synthetic */ int val$position;
        final /* synthetic */ int val$width;

        AnonymousClass5(int i, String str, int i2, int i3, boolean z, float f, float f2, boolean z2, String str2) {
            this.val$position = i;
            this.val$description = str;
            this.val$width = i2;
            this.val$height = i3;
            this.val$isAdaptive = z;
            this.val$containerWidth = f;
            this.val$containerHeight = f2;
            this.val$isRespectCutoutsEnabled = z2;
            this.val$placementName = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (AndroidBridge.mInstance) {
                try {
                    int i = 48;
                    if (AndroidBridge.this.mBannerContainer == null) {
                        AndroidBridge.this.mBannerContainer = new FrameLayout(UnityPlayer.currentActivity);
                        AndroidBridge.this.mBannerContainer.setBackgroundColor(0);
                        AndroidBridge.this.mBannerContainer.setVisibility(AndroidBridge.this.mBannerVisibilityState);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams.gravity = this.val$position == 1 ? 48 : 80;
                        UnityPlayer.currentActivity.addContentView(AndroidBridge.this.mBannerContainer, layoutParams);
                    }
                    ISBannerSize bannerSize = AndroidBridge.this.getBannerSize(this.val$description, this.val$width, this.val$height);
                    boolean z = this.val$isAdaptive;
                    if (z) {
                        bannerSize.setAdaptive(z);
                        float f = this.val$containerWidth;
                        float f2 = this.val$containerHeight;
                        if (f <= 0.0f) {
                            f = AndroidBridge.this.getDeviceScreenWidth();
                        }
                        if (f2 <= 0.0f) {
                            f2 = AndroidBridge.this.getMaximalAdaptiveHeight(f);
                        }
                        bannerSize.setContainerParams(new ISContainerParams((int) f, (int) f2));
                    }
                    if (this.val$isRespectCutoutsEnabled) {
                        AndroidBridge.this.mBannerContainer.setFitsSystemWindows(true);
                        AndroidBridge.this.mBannerContainer.setSystemUiVisibility(1280);
                    }
                    AndroidBridge androidBridge = AndroidBridge.this;
                    androidBridge.mBanner = IronSource.createBanner(androidBridge.getUnityActivity(), bannerSize);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    if (this.val$position != 1) {
                        i = 80;
                    }
                    layoutParams2.gravity = i;
                    if (AndroidBridge.this.mBannerContainer != null) {
                        AndroidBridge.this.mBannerContainer.addView(AndroidBridge.this.mBanner, layoutParams2);
                    }
                    AndroidBridge.this.mBanner.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.1
                        @Override // android.view.ViewGroup.OnHierarchyChangeListener
                        public void onChildViewRemoved(View view, View view2) {
                        }

                        @Override // android.view.ViewGroup.OnHierarchyChangeListener
                        public void onChildViewAdded(View view, View view2) {
                            AndroidBridge.this.mUIHandler.post(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    synchronized (AndroidBridge.mInstance) {
                                        if (AndroidBridge.this.mBanner != null) {
                                            AndroidBridge.this.mBanner.setVisibility(AndroidBridge.this.mBannerVisibilityState);
                                        }
                                        if (AndroidBridge.this.mBannerContainer != null) {
                                            AndroidBridge.this.mBannerContainer.requestLayout();
                                        }
                                    }
                                }
                            });
                        }
                    });
                    if (AndroidBridge.this.mUnityLevelPlayBannerListener != null) {
                        AndroidBridge.this.mBanner.setLevelPlayBannerListener(new LevelPlayBannerListener() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.2
                            @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
                            public void onAdLoaded(final AdInfo adInfo) {
                                AndroidBridge.this.mIsBannerLoadedFirst = true;
                                if (AndroidBridge.this.mUnityLevelPlayBannerListener != null) {
                                    AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (AndroidBridge.this.mUnityLevelPlayBannerListener != null) {
                                                AndroidBridge.this.mUnityLevelPlayBannerListener.onAdLoaded(AndroidBridgeUtilities.getAdInfoString(adInfo));
                                            }
                                        }
                                    });
                                }
                            }

                            @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
                            public void onAdLoadFailed(final IronSourceError ironSourceError) {
                                if (!AndroidBridge.this.mIsBannerLoadedFirst) {
                                    AndroidBridge.this.mUIHandler.post(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.2.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            synchronized (AndroidBridge.mInstance) {
                                                if (AndroidBridge.this.mBannerContainer != null) {
                                                    AndroidBridge.this.mBannerContainer.removeAllViews();
                                                }
                                                if (AndroidBridge.this.mBanner != null) {
                                                    AndroidBridge.this.mBanner = null;
                                                }
                                                AndroidBridge.this.mIsBannerLoadCalled = false;
                                            }
                                        }
                                    });
                                }
                                if (AndroidBridge.this.mUnityLevelPlayBannerListener != null) {
                                    AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.2.3
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AndroidBridge.this.mUnityLevelPlayBannerListener.onAdLoadFailed(AndroidBridgeUtilities.parseIronSourceError(ironSourceError));
                                        }
                                    });
                                }
                            }

                            @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
                            public void onAdClicked(final AdInfo adInfo) {
                                AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.2.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AndroidBridge.this.mUnityLevelPlayBannerListener != null) {
                                            AndroidBridge.this.mUnityLevelPlayBannerListener.onAdClicked(AndroidBridgeUtilities.getAdInfoString(adInfo));
                                        }
                                    }
                                });
                            }

                            @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
                            public void onAdLeftApplication(final AdInfo adInfo) {
                                AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.2.5
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AndroidBridge.this.mUnityLevelPlayBannerListener != null) {
                                            AndroidBridge.this.mUnityLevelPlayBannerListener.onAdLeftApplication(AndroidBridgeUtilities.getAdInfoString(adInfo));
                                        }
                                    }
                                });
                            }

                            @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
                            public void onAdScreenPresented(final AdInfo adInfo) {
                                AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.2.6
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AndroidBridge.this.mUnityLevelPlayBannerListener != null) {
                                            AndroidBridge.this.mUnityLevelPlayBannerListener.onAdScreenPresented(AndroidBridgeUtilities.getAdInfoString(adInfo));
                                        }
                                    }
                                });
                            }

                            @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
                            public void onAdScreenDismissed(final AdInfo adInfo) {
                                AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.5.2.7
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AndroidBridge.this.mUnityLevelPlayBannerListener != null) {
                                            AndroidBridge.this.mUnityLevelPlayBannerListener.onAdScreenDismissed(AndroidBridgeUtilities.getAdInfoString(adInfo));
                                        }
                                    }
                                });
                            }
                        });
                    }
                    if (this.val$placementName != null) {
                        IronSource.loadBanner(AndroidBridge.this.mBanner, this.val$placementName);
                    } else {
                        IronSource.loadBanner(AndroidBridge.this.mBanner);
                    }
                } finally {
                }
            }
        }
    }

    private void loadAndShowBanner(String str, int i, int i2, int i3, String str2, boolean z, boolean z2, float f, float f2) {
        this.mUIHandler.post(new AnonymousClass5(i3, str, i, i2, z, f, f2, z2, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ISBannerSize getBannerSize(String str, int i, int i2) {
        if (str.equals("CUSTOM")) {
            return new ISBannerSize(i, i2);
        }
        if (str.equals("SMART")) {
            return ISBannerSize.SMART;
        }
        if (str.equals("RECTANGLE")) {
            return ISBannerSize.RECTANGLE;
        }
        if (str.equals("LARGE")) {
            return ISBannerSize.LARGE;
        }
        return ISBannerSize.BANNER;
    }

    public void destroyBanner() {
        synchronized (mInstance) {
            this.mUIHandler.post(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.6
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AndroidBridge.mInstance) {
                        try {
                            if (AndroidBridge.this.mBannerContainer != null) {
                                AndroidBridge.this.mBannerContainer.removeAllViews();
                            }
                            if (AndroidBridge.this.mBanner != null) {
                                IronSource.destroyBanner(AndroidBridge.this.mBanner);
                                AndroidBridge.this.mBanner = null;
                                AndroidBridge.this.mBannerVisibilityState = 0;
                            }
                            if (AndroidBridge.this.mBannerContainer != null) {
                                AndroidBridge.this.mBannerContainer.setVisibility(0);
                                AndroidBridge.this.mBannerContainer = null;
                            }
                        } catch (Exception unused) {
                        }
                        AndroidBridge.this.mIsBannerLoadCalled = false;
                        AndroidBridge.this.mIsBannerLoadedFirst = false;
                    }
                }
            });
        }
    }

    public void displayBanner() {
        synchronized (mInstance) {
            this.mUIHandler.post(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.7
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AndroidBridge.mInstance) {
                        try {
                            AndroidBridge.this.mBannerVisibilityState = 0;
                            if (AndroidBridge.this.mBannerContainer != null) {
                                AndroidBridge.this.mBanner.setVisibility(0);
                                AndroidBridge.this.mBannerContainer.setVisibility(0);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public void hideBanner() {
        synchronized (mInstance) {
            this.mUIHandler.post(new Runnable() { // from class: com.ironsource.unity.androidbridge.AndroidBridge.8
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AndroidBridge.mInstance) {
                        try {
                            AndroidBridge.this.mBannerVisibilityState = 8;
                            if (AndroidBridge.this.mBannerContainer != null) {
                                AndroidBridge.this.mBanner.setVisibility(8);
                                AndroidBridge.this.mBannerContainer.setVisibility(8);
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public boolean isBannerPlacementCapped(String str) {
        return IronSource.isBannerPlacementCapped(str);
    }

    public float getMaximalAdaptiveHeight(float f) {
        return ISBannerSize.getMaximalAdaptiveHeight((int) f);
    }

    public float getDeviceScreenWidth() {
        WindowManager windowManager;
        Display defaultDisplay;
        Activity unityActivity = getUnityActivity();
        if (unityActivity == null || (windowManager = unityActivity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels / displayMetrics.density;
    }

    public void setSegment(String str) {
        try {
            IronSource.setSegmentListener(this);
            JSONObject jSONObject = new JSONObject(str);
            IronSourceSegment ironSourceSegment = new IronSourceSegment();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equals("age")) {
                    ironSourceSegment.setAge(jSONObject.optInt(next));
                } else if (next.equals("gender")) {
                    ironSourceSegment.setGender(jSONObject.optString(next));
                } else if (next.equals("level")) {
                    ironSourceSegment.setLevel(jSONObject.optInt(next));
                } else if (next.equals(AndroidBridgeConstants.SEGMENT_PAYING)) {
                    ironSourceSegment.setIsPaying(jSONObject.optInt(next) != 0);
                } else if (next.equals(AndroidBridgeConstants.SEGMENT_CREATION_DATE)) {
                    ironSourceSegment.setUserCreationDate(jSONObject.optLong(next));
                } else if (next.equals("segmentName")) {
                    ironSourceSegment.setSegmentName(jSONObject.optString(next));
                } else if (next.equals("iapt")) {
                    ironSourceSegment.setIAPTotal(jSONObject.optDouble(next));
                } else {
                    ironSourceSegment.setCustom(next, jSONObject.optString(next));
                }
            }
            IronSource.setSegment(ironSourceSegment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setConsent(boolean z) {
        IronSource.setConsent(z);
    }

    public void setMetaData(String str, String str2) {
        IronSource.setMetaData(str, str2);
    }

    public void setMetaData(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            arrayList.add(str2);
        }
        IronSource.setMetaData(str, arrayList);
    }

    public void setClientSideCallbacks(boolean z) {
        SupersonicConfig.getConfigObj().setClientSideCallbacks(z);
    }

    public void setWaterfallConfiguration(String str, String str2) {
        try {
            WaterfallConfiguration.WaterfallConfigurationBuilder builder = WaterfallConfiguration.builder();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(AndroidBridgeConstants.WATERFALL_CONFIG_CEILING_KEY)) {
                builder.setCeiling(jSONObject.getDouble(AndroidBridgeConstants.WATERFALL_CONFIG_CEILING_KEY));
            }
            if (jSONObject.has(AndroidBridgeConstants.WATERFALL_CONFIG_FLOOR_KEY)) {
                builder.setFloor(jSONObject.getDouble(AndroidBridgeConstants.WATERFALL_CONFIG_FLOOR_KEY));
            }
            IronSource.setWaterfallConfiguration(builder.build(), IronSource.AD_UNIT.valueOf(str2));
        } catch (JSONException unused) {
            Log.e("LevelPlayAndroidBridge", String.format("Internal exception occurred while parsing configuration parameters for ad unit: %s. Please check the format of the configuration parameters.", str2));
        }
    }

    public void setAdRevenueData(String str, String str2) {
        IronSource.setAdRevenueData(str, new JSONObject(AndroidBridgeUtilities.getHashMapFromJsonString(str2)));
    }

    public void launchTestSuite() {
        IronSource.launchTestSuite(getUnityActivity());
    }
}
