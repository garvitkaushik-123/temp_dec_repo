package com.mbridge.msdk.mbsignalcommon.listener;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.c;

/* compiled from: DefaultWebViewListener.java */
/* loaded from: classes6.dex */
public class b implements c {
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, String str, Bitmap bitmap) {
        p0.a("WindVaneWebView", "onPageStarted");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public boolean b(WebView webView, String str) {
        p0.a("WindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void c(WebView webView, int i) {
        p0.a("WindVaneWebView", "onProgressChanged");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, int i, String str, String str2) {
        p0.a("WindVaneWebView", "onReceivedError");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void b(WebView webView, int i) {
        p0.a("WindVaneWebView", "loadingResourceStatus");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        p0.a("WindVaneWebView", "onReceivedSslError");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, String str) {
        p0.a("WindVaneWebView", "onPageFinished");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, int i) {
        p0.a("WindVaneWebView", "readyState");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView) {
        p0.a("WindVaneWebView", "onRenderProcessGone");
    }
}
