package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.demandOnly.g;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes6.dex */
public interface DemandOnlyIsManagerListener {
    void onInterstitialAdClicked(g gVar);

    void onInterstitialAdClosed(g gVar);

    void onInterstitialAdLoadFailed(IronSourceError ironSourceError, g gVar, long j);

    void onInterstitialAdOpened(g gVar);

    void onInterstitialAdReady(g gVar, long j);

    void onInterstitialAdShowFailed(IronSourceError ironSourceError, g gVar);

    void onInterstitialAdVisible(g gVar);
}
