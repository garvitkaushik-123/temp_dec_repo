package com.unity3d.scar.adapter.common;

/* loaded from: classes7.dex */
public interface IScarInterstitialAdListenerWrapper extends IScarAdListenerWrapper {
    void onAdFailedToShow(int i, String str);

    void onAdImpression();

    void onAdLeftApplication();

    void onAdSkipped();
}
