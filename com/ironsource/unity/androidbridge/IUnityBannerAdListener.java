package com.ironsource.unity.androidbridge;

/* loaded from: classes6.dex */
public interface IUnityBannerAdListener {
    void onAdClicked(String str);

    void onAdCollapsed(String str);

    void onAdDisplayFailed(String str, String str2);

    void onAdDisplayed(String str);

    void onAdExpanded(String str);

    void onAdLeftApplication(String str);

    void onAdLoadFailed(String str);

    void onAdLoaded(String str);
}
