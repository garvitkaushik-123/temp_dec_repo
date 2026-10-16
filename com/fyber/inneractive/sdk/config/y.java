package com.fyber.inneractive.sdk.config;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes4.dex */
public final class y extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        if (iAConfigManager.L == webView) {
            iAConfigManager.L = null;
        }
        if (webView == null) {
            return true;
        }
        com.fyber.inneractive.sdk.util.t.a(webView);
        webView.destroy();
        return true;
    }
}
