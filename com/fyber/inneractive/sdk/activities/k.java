package com.fyber.inneractive.sdk.activities;

import android.view.View;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1016a;

    public k(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1016a = inneractiveInternalBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView = this.f1016a.e;
        if (webView != null) {
            webView.reload();
            int i = IAlog.f1749a;
            IAlog.d("%s %s", "AD_INTERNAL_BROWSER_REFRESH", this.f1016a.e.getUrl());
        }
    }
}
