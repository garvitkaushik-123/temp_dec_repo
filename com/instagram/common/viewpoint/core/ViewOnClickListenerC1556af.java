package com.instagram.common.viewpoint.core;

import android.view.View;
import android.webkit.WebView;

/* renamed from: com.facebook.ads.redexgen.X.af, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1556af implements View.OnClickListener {
    public final /* synthetic */ M6 A00;

    public ViewOnClickListenerC1556af(M6 m6) {
        this.A00 = m6;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView;
        WebView webView2;
        if (WU.A02(this)) {
            return;
        }
        try {
            webView = this.A00.A08;
            if (webView.canGoForward()) {
                webView2 = this.A00.A08;
                webView2.goForward();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
