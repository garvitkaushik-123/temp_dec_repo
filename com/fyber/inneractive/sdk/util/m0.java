package com.fyber.inneractive.sdk.util;

import android.webkit.WebView;

/* loaded from: classes4.dex */
public final class m0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebView f1766a;

    public m0(WebView webView) {
        this.f1766a = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1766a.getSettings().setDisplayZoomControls(false);
    }
}
