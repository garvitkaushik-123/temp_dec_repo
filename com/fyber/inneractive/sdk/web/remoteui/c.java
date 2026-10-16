package com.fyber.inneractive.sdk.web.remoteui;

import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f0;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class c extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public a f1819a;
    public com.fyber.inneractive.sdk.player.ui.remote.a b;

    public c(a aVar, com.fyber.inneractive.sdk.player.ui.remote.a aVar2) {
        this.f1819a = aVar;
        this.b = aVar2;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        IAlog.a("%s: onReceivedError: error: %s errorCode: %d, failing url: %s", "RemoteUiWebViewClient", str, Integer.valueOf(i), str2);
        a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_CONTENT_ERROR, str + " errCode: " + i, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        int statusCode = webResourceResponse != null ? webResourceResponse.getStatusCode() : -1;
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? "" : webResourceRequest.getUrl().toString();
        IAlog.a("%s: onReceivedHttpError: errorCode: %d, failing url: %s", "RemoteUiWebViewClient", Integer.valueOf(statusCode), uri);
        a(com.fyber.inneractive.sdk.network.events.b.HTTP_ERROR, String.valueOf(statusCode), uri);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        String url = sslError != null ? sslError.getUrl() : "";
        IAlog.a("%s: onReceivedSslError: failing url: %s", "RemoteUiWebViewClient", url);
        a(com.fyber.inneractive.sdk.network.events.b.SSL_ERROR, null, url);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (webView == null) {
            a("unknown", renderProcessGoneDetail);
            return true;
        }
        a(webView.toString(), renderProcessGoneDetail);
        webView.destroy();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        IAlog.a("%s: shouldOverrideUrlLoading: url: %s", "RemoteUiWebViewClient", str);
        Uri parse = Uri.parse(str);
        if (parse == null || TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getAuthority()) || TextUtils.isEmpty(parse.getHost())) {
            return true;
        }
        Locale locale = Locale.US;
        if (!"FyRemote://".toLowerCase(locale).contains(parse.getScheme().toLowerCase(locale))) {
            return true;
        }
        HashMap a2 = f0.a(parse);
        String host = parse.getHost();
        com.fyber.inneractive.sdk.player.ui.remote.a aVar = this.b;
        if (aVar == null) {
            return true;
        }
        aVar.a(host, a2);
        return true;
    }

    public final void a(String str, RenderProcessGoneDetail renderProcessGoneDetail) {
        String valueOf = renderProcessGoneDetail != null ? String.valueOf(renderProcessGoneDetail.didCrash()) : "unknown";
        IAlog.a("%s: onRenderProcessGone: handled, webview crashed: %s view: %s", "RemoteUiWebViewClient", valueOf, str);
        a(com.fyber.inneractive.sdk.network.events.b.WEB_VIEW_CRASH_ERROR, "Webview did crash: " + valueOf + " on webview: " + str, null);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        int i;
        String str;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        String str2 = "";
        if (webResourceError != null) {
            if (webResourceError.getDescription() != null) {
                str2 = webResourceError.getDescription().toString();
            }
            i = webResourceError.getErrorCode();
        } else {
            i = -999;
        }
        if (webResourceRequest != null && webResourceRequest.getUrl() != null) {
            str = webResourceRequest.getUrl().toString();
        } else {
            str = "unknown";
        }
        IAlog.a("%s: onReceivedError: error: %s errorCode: %d, failing url: %s", "RemoteUiWebViewClient", str2, Integer.valueOf(i), str);
        a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_CONTENT_ERROR, str2 + " errCode: " + i, str);
    }

    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, String str2) {
        HashMap hashMap;
        if (this.f1819a != null) {
            if (TextUtils.isEmpty(str2)) {
                hashMap = null;
            } else {
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put("failedURL", str2);
                hashMap = hashMap2;
            }
            this.f1819a.a(bVar, str, true, hashMap);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        String uri = url != null ? url.toString() : "unknown";
        if (url != null && !TextUtils.isEmpty(url.getScheme()) && !TextUtils.isEmpty(url.getAuthority()) && !TextUtils.isEmpty(url.getHost())) {
            Locale locale = Locale.US;
            if ("FyRemote://".toLowerCase(locale).contains(url.getScheme().toLowerCase(locale))) {
                HashMap a2 = f0.a(url);
                String host = url.getHost();
                com.fyber.inneractive.sdk.player.ui.remote.a aVar = this.b;
                if (aVar != null) {
                    aVar.a(host, a2);
                }
            }
        }
        IAlog.a("%s: shouldOverrideUrlLoading: url: %s", "RemoteUiWebViewClient", uri);
        return true;
    }
}
