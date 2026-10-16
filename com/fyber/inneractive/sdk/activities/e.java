package com.fyber.inneractive.sdk.activities;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* loaded from: classes4.dex */
public final class e extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1010a;

    public e(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1010a = inneractiveInternalBrowserActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i) {
        this.f1010a.setTitle("Page is Loading...");
        this.f1010a.setProgress(i * 100);
        if (i == 100) {
            this.f1010a.setTitle(webView.getUrl());
        }
    }
}
