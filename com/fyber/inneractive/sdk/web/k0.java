package com.fyber.inneractive.sdk.web;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class k0 extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1806a;
    public final int b;
    public final int c;
    public final int d;
    public j e;

    public k0(j jVar, boolean z, int i, int i2, int i3) {
        this.e = jVar;
        this.f1806a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        IAlog.e("Resources to load: %s", str);
        IAlog.d("%s %s", "RESOURCES", str);
        j jVar = this.e;
        if (jVar != null) {
            i iVar = (i) jVar;
            if (TextUtils.isEmpty(str) || !str.startsWith("http://") || com.fyber.inneractive.sdk.util.s.a()) {
                return;
            }
            IAlog.a("%s Found a portential unsecure resource url: %s", IAlog.a(iVar), str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        IAlog.e("onPageFinished - url: %s", str);
        j jVar = this.e;
        if (jVar != null) {
            jVar.a(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        IAlog.e("onPageStarted - url: %s", str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        IAlog.a("onWebViewRenderProcessGone called for web view! %s", webView);
        if (webView != null) {
            com.fyber.inneractive.sdk.util.t.a(webView);
            webView.destroy();
        }
        j jVar = this.e;
        if (jVar == null) {
            return true;
        }
        jVar.a();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        URL url;
        HttpURLConnection httpURLConnection;
        if (this.f1806a && webResourceRequest != null) {
            IAlog.e("shouldInterceptRequest, method = %s", webResourceRequest.getMethod());
            b1 b1Var = b1.c;
            int i = this.b;
            int i2 = this.c;
            int i3 = this.d;
            b1Var.getClass();
            WebResourceResponse webResourceResponse = null;
            if (webResourceRequest.getUrl() != null && webResourceRequest.getUrl().getScheme() != null && webResourceRequest.getUrl().getScheme().startsWith("http") && TextUtils.equals(webResourceRequest.getMethod(), "GET")) {
                c1 c1Var = (c1) b1Var.f1791a.get(new d1(webResourceRequest));
                if (c1Var != null) {
                    webResourceResponse = new WebResourceResponse(c1Var.c, c1Var.d, c1Var.e, c1Var.f, c1Var.b, new ByteArrayInputStream(c1Var.f1793a));
                } else {
                    try {
                        url = new URL(webResourceRequest.getUrl().toString());
                    } catch (MalformedURLException unused) {
                        url = null;
                    }
                    if (url != null) {
                        ByteBuffer byteBuffer = (ByteBuffer) com.fyber.inneractive.sdk.util.f.b.f1757a.poll();
                        if (byteBuffer == null) {
                            byteBuffer = ByteBuffer.allocateDirect(16384);
                        }
                        try {
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                            try {
                                httpURLConnection.setRequestMethod(webResourceRequest.getMethod());
                                httpURLConnection.setInstanceFollowRedirects(false);
                                b1.a(webResourceRequest, httpURLConnection);
                            } catch (Throwable unused2) {
                            }
                        } catch (Throwable unused3) {
                            httpURLConnection = null;
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.setConnectTimeout(i);
                            httpURLConnection.setReadTimeout(i2);
                            c1 c1Var2 = null;
                            while (i3 > 0) {
                                try {
                                    c1Var2 = b1.a(httpURLConnection, byteBuffer);
                                } catch (SocketTimeoutException | UnknownHostException unused4) {
                                } catch (Throwable unused5) {
                                    i3 = 0;
                                }
                                if (c1Var2 != null) {
                                    break;
                                }
                                i3--;
                            }
                            if (c1Var2 != null) {
                                try {
                                    if (c1Var2.a()) {
                                        b1Var.f1791a.put(new d1(webResourceRequest), c1Var2);
                                    }
                                    WebResourceResponse webResourceResponse2 = new WebResourceResponse(c1Var2.c, c1Var2.d, c1Var2.e, c1Var2.f, c1Var2.b, new ByteArrayInputStream(c1Var2.f1793a));
                                    httpURLConnection.disconnect();
                                    com.fyber.inneractive.sdk.util.f.b.f1757a.offer(byteBuffer);
                                    webResourceResponse = webResourceResponse2;
                                } catch (Throwable unused6) {
                                    httpURLConnection.disconnect();
                                }
                            } else {
                                httpURLConnection.disconnect();
                            }
                            com.fyber.inneractive.sdk.util.f.b.f1757a.offer(byteBuffer);
                        }
                    }
                }
            }
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
            IAlog.e("shouldInterceptRequest did not intercept %s", webResourceRequest.getUrl());
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        super.shouldOverrideUrlLoading(webView, str);
        j jVar = this.e;
        return jVar != null && jVar.a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        IAlog.e("%sError: code = %d text = %s WebView = %s", IAlog.a(this), Integer.valueOf(i), str, webView);
        super.onReceivedError(webView, i, str, str2);
        j jVar = this.e;
        if (jVar != null) {
            jVar.d();
        }
    }
}
