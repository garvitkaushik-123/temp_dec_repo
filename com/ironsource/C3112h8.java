package com.ironsource;

import android.webkit.JavascriptInterface;

/* renamed from: com.ironsource.h8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3112h8 {

    /* renamed from: a, reason: collision with root package name */
    private C3162k8 f3333a;

    C3112h8(C3162k8 c3162k8) {
        this.f3333a = c3162k8;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        this.f3333a.handleMessageFromAd(str);
    }
}
