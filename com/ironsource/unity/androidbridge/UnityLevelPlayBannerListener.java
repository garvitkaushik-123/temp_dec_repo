package com.ironsource.unity.androidbridge;

/* loaded from: classes6.dex */
public interface UnityLevelPlayBannerListener {
    void onAdClicked(String str);

    void onAdLeftApplication(String str);

    void onAdLoadFailed(String str);

    void onAdLoaded(String str);

    void onAdScreenDismissed(String str);

    void onAdScreenPresented(String str);
}
