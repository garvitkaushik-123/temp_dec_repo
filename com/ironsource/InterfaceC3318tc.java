package com.ironsource;

import org.json.JSONObject;

/* renamed from: com.ironsource.tc, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3318tc extends InterfaceC3268qc {
    void onInterstitialAdRewarded(String str, int i);

    void onInterstitialClick();

    void onInterstitialClose();

    void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject);

    void onInterstitialInitFailed(String str);

    void onInterstitialInitSuccess();

    void onInterstitialLoadFailed(String str);

    void onInterstitialLoadSuccess(B9 b9);

    void onInterstitialOpen();

    void onInterstitialShowFailed(String str);

    void onInterstitialShowSuccess();
}
