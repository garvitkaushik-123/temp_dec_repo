package com.unity3d.ironsourceads.interstitial;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes7.dex */
public interface InterstitialAdLoaderListener {
    void onInterstitialAdLoadFailed(IronSourceError ironSourceError);

    void onInterstitialAdLoaded(InterstitialAd interstitialAd);
}
