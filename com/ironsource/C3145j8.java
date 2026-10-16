package com.ironsource;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.F8;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;

/* renamed from: com.ironsource.j8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3145j8 extends WebViewClient {
    private static final String b = "j8";

    /* renamed from: a, reason: collision with root package name */
    private final F8.a f3375a;

    public C3145j8(F8.a aVar) {
        this.f3375a = aVar;
    }

    private String a(String str, String str2) {
        return "ISNAdViewWebClient | External Adunit failed to load." + str + " Status code: " + str2;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        try {
            this.f3375a.a(a("onReceivedError", String.valueOf(i)));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        try {
            Logger.e(b, "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            this.f3375a.b(renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system");
            return true;
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return true;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            this.f3375a.a(a("onReceivedHttpError", String.valueOf(webResourceResponse.getStatusCode())));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            this.f3375a.a(a("onReceivedErrorM", String.valueOf(webResourceError.getErrorCode())));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }
}
