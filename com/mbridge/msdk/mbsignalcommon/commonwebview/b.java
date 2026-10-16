package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CommonWebViewClient.java */
/* loaded from: classes6.dex */
public class b extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<WebViewClient> f4552a = new CopyOnWriteArrayList<>();

    public void a(WebViewClient webViewClient) {
        this.f4552a.add(webViewClient);
    }

    public void b(WebViewClient webViewClient) {
        this.f4552a.remove(webViewClient);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().doUpdateVisitedHistory(webView, str, z);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onFormResubmission(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedError(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (webView != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) webView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(webView);
                }
                if (webView instanceof WindVaneWebView) {
                    ((WindVaneWebView) webView).release();
                } else {
                    webView.destroy();
                }
            } catch (Throwable th) {
                p0.b("CommonWebViewClient", th.getMessage());
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onScaleChanged(webView, f, f2);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        while (it.hasNext()) {
            it.next().onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        WebResourceResponse webResourceResponse = null;
        while (it.hasNext()) {
            webResourceResponse = it.next().shouldInterceptRequest(webView, str);
        }
        return webResourceResponse;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = it.next().shouldOverrideKeyEvent(webView, keyEvent);
        }
        return z;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f4552a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean shouldOverrideUrlLoading = it.next().shouldOverrideUrlLoading(webView, str);
            if (shouldOverrideUrlLoading) {
                z = shouldOverrideUrlLoading;
            }
        }
        return z;
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView webView, String str) {
        try {
            Iterator<WebViewClient> it = this.f4552a.iterator();
            while (it.hasNext()) {
                it.next().onPageCommitVisible(webView, str);
            }
        } catch (Exception e) {
            p0.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        try {
            Iterator<WebViewClient> it = this.f4552a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedClientCertRequest(webView, clientCertRequest);
            }
        } catch (Exception e) {
            p0.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            Iterator<WebViewClient> it = this.f4552a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        } catch (Exception e) {
            p0.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        try {
            Iterator<WebViewClient> it = this.f4552a.iterator();
            while (it.hasNext()) {
                it.next().onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            }
        } catch (Exception e) {
            p0.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            Iterator<WebViewClient> it = this.f4552a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedError(webView, webResourceRequest, webResourceError);
            }
        } catch (Exception e) {
            p0.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponse = null;
        try {
            Iterator<WebViewClient> it = this.f4552a.iterator();
            while (it.hasNext()) {
                webResourceResponse = it.next().shouldInterceptRequest(webView, webResourceRequest);
            }
            return webResourceResponse;
        } catch (Exception e) {
            p0.b("CommonWebViewClient", e.getMessage());
            return webResourceResponse;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean z = false;
        try {
            Iterator<WebViewClient> it = this.f4552a.iterator();
            while (it.hasNext()) {
                boolean shouldOverrideUrlLoading = it.next().shouldOverrideUrlLoading(webView, webResourceRequest);
                if (shouldOverrideUrlLoading) {
                    z = shouldOverrideUrlLoading;
                }
            }
            return z;
        } catch (Exception e) {
            p0.b("CommonWebViewClient", e.getMessage());
            return z;
        }
    }
}
