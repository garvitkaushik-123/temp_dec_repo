package com.fyber.inneractive.sdk.activities;

import android.view.View;
import android.webkit.WebView;

/* loaded from: classes4.dex */
public final class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1015a;

    public j(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1015a = inneractiveInternalBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView = this.f1015a.e;
        if (webView == null || !webView.canGoForward()) {
            return;
        }
        this.f1015a.e.goForward();
    }
}
