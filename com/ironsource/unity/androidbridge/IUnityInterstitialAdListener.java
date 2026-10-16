package com.ironsource.unity.androidbridge;

/* loaded from: classes6.dex */
interface IUnityInterstitialAdListener {
    void onAdClicked(String str);

    void onAdClosed(String str);

    void onAdDisplayFailed(String str, String str2);

    void onAdDisplayed(String str);

    void onAdInfoChanged(String str);

    void onAdLoadFailed(String str);

    void onAdLoaded(String str);
}
