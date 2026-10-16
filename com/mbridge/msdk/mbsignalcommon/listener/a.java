package com.mbridge.msdk.mbsignalcommon.listener;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.c;

/* compiled from: DefaultRVWebViewListener.java */
/* loaded from: classes6.dex */
public class a implements c {
    public void a(Object obj) {
        p0.a("RVWindVaneWebView", "getEndScreenInfo");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public boolean b(WebView webView, String str) {
        p0.a("RVWindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void c(WebView webView, int i) {
        p0.a("RVWindVaneWebView", "onProgressChanged");
    }

    public void a(WebView webView, String str, String str2, int i, int i2) {
        p0.a("RVWindVaneWebView", "loadAds");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void b(WebView webView, int i) {
        p0.a("RVWindVaneWebView", "loadingResourceStatus");
    }

    public void a(Object obj, String str) {
        p0.a("RVWindVaneWebView", "operateComponent");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, String str, Bitmap bitmap) {
        p0.a("RVWindVaneWebView", "onPageStarted");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, int i, String str, String str2) {
        p0.a("RVWindVaneWebView", "onReceivedError");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        p0.a("RVWindVaneWebView", "onReceivedSslError");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, String str) {
        p0.a("RVWindVaneWebView", "onPageFinished");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView, int i) {
        p0.a("RVWindVaneWebView", "readyState");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public void a(WebView webView) {
        p0.a("RVWindVaneWebView", "onRenderProcessGone");
    }
}
