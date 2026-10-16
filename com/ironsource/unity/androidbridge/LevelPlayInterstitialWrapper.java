package com.ironsource.unity.androidbridge;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;

/* loaded from: classes6.dex */
class LevelPlayInterstitialWrapper implements LevelPlayInterstitialListener {
    private UnityLevelPlayInterstitialListener mUnityLevelPlayInterstitialListener;

    public LevelPlayInterstitialWrapper() {
        IronSource.setLevelPlayInterstitialListener(this);
    }

    public void setInterstitialLevelPlaylistener(UnityLevelPlayInterstitialListener unityLevelPlayInterstitialListener) {
        this.mUnityLevelPlayInterstitialListener = unityLevelPlayInterstitialListener;
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
    public void onAdReady(final AdInfo adInfo) {
        if (this.mUnityLevelPlayInterstitialListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayInterstitialWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    LevelPlayInterstitialWrapper.this.mUnityLevelPlayInterstitialListener.onAdReady(AndroidBridgeUtilities.getAdInfoString(adInfo));
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
    public void onAdLoadFailed(final IronSourceError ironSourceError) {
        if (this.mUnityLevelPlayInterstitialListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayInterstitialWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    LevelPlayInterstitialWrapper.this.mUnityLevelPlayInterstitialListener.onAdLoadFailed(AndroidBridgeUtilities.parseIronSourceError(ironSourceError));
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
    public void onAdOpened(final AdInfo adInfo) {
        if (this.mUnityLevelPlayInterstitialListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayInterstitialWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    LevelPlayInterstitialWrapper.this.mUnityLevelPlayInterstitialListener.onAdOpened(AndroidBridgeUtilities.getAdInfoString(adInfo));
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
    public void onAdShowSucceeded(final AdInfo adInfo) {
        if (this.mUnityLevelPlayInterstitialListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayInterstitialWrapper.4
                @Override // java.lang.Runnable
                public void run() {
                    LevelPlayInterstitialWrapper.this.mUnityLevelPlayInterstitialListener.onAdShowSucceeded(AndroidBridgeUtilities.getAdInfoString(adInfo));
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
    public void onAdShowFailed(final IronSourceError ironSourceError, final AdInfo adInfo) {
        if (this.mUnityLevelPlayInterstitialListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayInterstitialWrapper.5
                @Override // java.lang.Runnable
                public void run() {
                    LevelPlayInterstitialWrapper.this.mUnityLevelPlayInterstitialListener.onAdShowFailed(AndroidBridgeUtilities.parseIronSourceError(ironSourceError), AndroidBridgeUtilities.getAdInfoString(adInfo));
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
    public void onAdClicked(final AdInfo adInfo) {
        if (this.mUnityLevelPlayInterstitialListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayInterstitialWrapper.6
                @Override // java.lang.Runnable
                public void run() {
                    LevelPlayInterstitialWrapper.this.mUnityLevelPlayInterstitialListener.onAdClicked(AndroidBridgeUtilities.getAdInfoString(adInfo));
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
    public void onAdClosed(final AdInfo adInfo) {
        if (this.mUnityLevelPlayInterstitialListener != null) {
            AndroidBridgeUtilities.postBackgroundTask(new Runnable() { // from class: com.ironsource.unity.androidbridge.LevelPlayInterstitialWrapper.7
                @Override // java.lang.Runnable
                public void run() {
                    LevelPlayInterstitialWrapper.this.mUnityLevelPlayInterstitialListener.onAdClosed(AndroidBridgeUtilities.getAdInfoString(adInfo));
                }
            });
        }
    }
}
