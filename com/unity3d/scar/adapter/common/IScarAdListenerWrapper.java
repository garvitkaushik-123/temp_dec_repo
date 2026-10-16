package com.unity3d.scar.adapter.common;

/* loaded from: classes7.dex */
public interface IScarAdListenerWrapper {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(int i, String str);

    void onAdLoaded();

    void onAdOpened();
}
