package com.fyber.inneractive.sdk.activities;

import android.view.View;
import android.webkit.WebView;

/* loaded from: classes4.dex */
public final class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1014a;

    public i(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1014a = inneractiveInternalBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView = this.f1014a.e;
        if (webView == null || !webView.canGoBack()) {
            return;
        }
        this.f1014a.e.goBack();
    }
}
