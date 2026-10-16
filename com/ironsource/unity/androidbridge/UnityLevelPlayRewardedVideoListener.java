package com.ironsource.unity.androidbridge;

/* loaded from: classes6.dex */
public interface UnityLevelPlayRewardedVideoListener {
    void onAdAvailable(String str);

    void onAdClicked(String str, String str2);

    void onAdClosed(String str);

    void onAdOpened(String str);

    void onAdRewarded(String str, String str2);

    void onAdShowFailed(String str, String str2);

    void onAdUnavailable();
}
