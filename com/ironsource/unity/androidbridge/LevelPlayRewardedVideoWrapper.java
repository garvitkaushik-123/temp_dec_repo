package com.ironsource.unity.androidbridge;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;

/* loaded from: classes6.dex */
class LevelPlayRewardedVideoWrapper implements LevelPlayRewardedVideoListener, LevelPlayRewardedVideoManualListener {
    private UnityLevelPlayRewardedVideoManualListener mUnityLevelPlayManualRewardedVideoListener;
    private UnityLevelPlayRewardedVideoListener mUnityLevelPlayRewardedVideoListener;

    public LevelPlayRewardedVideoWrapper() {
        IronSource.setLevelPlayRewardedVideoListener(this);
    }

    public void setIronSourceManualLoadListener(boolean z) {
        if (z) {
            IronSource.setLevelPlayRewardedVideoManualListener(this);
        } else {
            IronSource.setLevelPlayRewardedVideoManualListener(null);
            IronSource.setLevelPlayRewardedVideoListener(this);
        }
    }

    public void setLevelPlayRewardedVideoListener(UnityLevelPlayRewardedVideoListener unityLevelPlayRewardedVideoListener) {
        this.mUnityLevelPlayRewardedVideoListener = unityLevelPlayRewardedVideoListener;
    }

    public void setLevelPlayManualRewardedVideoListener(UnityLevelPlayRewardedVideoManualListener unityLevelPlayRewardedVideoManualListener) {
        this.mUnityLevelPlayManualRewardedVideoListener = unityLevelPlayRewardedVideoManualListener;
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener
    public void onAdAvailable(final AdInfo adInfo) {
        if (this.mUnityLevelPlayRewardedVideoListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayRewardedVideoWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener != null) {
                        LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener.onAdAvailable(AndroidBridgeUtilities.getAdInfoString(adInfo));
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener
    public void onAdUnavailable() {
        if (this.mUnityLevelPlayRewardedVideoListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayRewardedVideoWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener != null) {
                        LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener.onAdUnavailable();
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
    public void onAdOpened(final AdInfo adInfo) {
        if (this.mUnityLevelPlayRewardedVideoListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayRewardedVideoWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener != null) {
                        LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener.onAdOpened(AndroidBridgeUtilities.getAdInfoString(adInfo));
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
    public void onAdShowFailed(final IronSourceError ironSourceError, final AdInfo adInfo) {
        if (this.mUnityLevelPlayRewardedVideoListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayRewardedVideoWrapper.4
                @Override // java.lang.Runnable
                public void run() {
                    if (LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener != null) {
                        LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener.onAdShowFailed(AndroidBridgeUtilities.parseIronSourceError(ironSourceError), AndroidBridgeUtilities.getAdInfoString(adInfo));
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
    public void onAdClicked(Placement placement, final AdInfo adInfo) {
        final String placememtJson = AndroidBridgeUtilities.getPlacememtJson(placement);
        if (this.mUnityLevelPlayRewardedVideoListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayRewardedVideoWrapper.5
                @Override // java.lang.Runnable
                public void run() {
                    if (LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener != null) {
                        LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener.onAdClicked(placememtJson, AndroidBridgeUtilities.getAdInfoString(adInfo));
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
    public void onAdRewarded(Placement placement, final AdInfo adInfo) {
        final String placememtJson = AndroidBridgeUtilities.getPlacememtJson(placement);
        if (this.mUnityLevelPlayRewardedVideoListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayRewardedVideoWrapper.6
                @Override // java.lang.Runnable
                public void run() {
                    if (LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener != null) {
                        LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener.onAdRewarded(placememtJson, AndroidBridgeUtilities.getAdInfoString(adInfo));
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
    public void onAdClosed(final AdInfo adInfo) {
        if (this.mUnityLevelPlayRewardedVideoListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayRewardedVideoWrapper.7
                @Override // java.lang.Runnable
                public void run() {
                    if (LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener != null) {
                        LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener.onAdClosed(AndroidBridgeUtilities.getAdInfoString(adInfo));
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener
    public void onAdReady(final AdInfo adInfo) {
        if (this.mUnityLevelPlayRewardedVideoListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayRewardedVideoWrapper.8
                @Override // java.lang.Runnable
                public void run() {
                    if (LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener != null) {
                        LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayManualRewardedVideoListener.onAdReady(AndroidBridgeUtilities.getAdInfoString(adInfo));
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener
    public void onAdLoadFailed(final IronSourceError ironSourceError) {
        if (this.mUnityLevelPlayRewardedVideoListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayRewardedVideoWrapper.9
                @Override // java.lang.Runnable
                public void run() {
                    if (LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayRewardedVideoListener != null) {
                        LevelPlayRewardedVideoWrapper.this.mUnityLevelPlayManualRewardedVideoListener.onAdLoadFailed(AndroidBridgeUtilities.parseIronSourceError(ironSourceError));
                    }
                }
            });
        }
    }
}
