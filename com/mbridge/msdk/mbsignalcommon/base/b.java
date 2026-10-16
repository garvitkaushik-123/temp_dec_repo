package com.mbridge.msdk.mbsignalcommon.base;

import android.net.http.SslError;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.io.File;

/* compiled from: BaseWebViewClient.java */
/* loaded from: classes6.dex */
public class b extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    private a f4533a;
    private com.mbridge.msdk.mbsignalcommon.windvane.c b;

    protected boolean a(String str, String str2) {
        try {
            return new File(str).getCanonicalFile().getPath().startsWith(new File(str2).getCanonicalFile().getPath());
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.a(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.a(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.a(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        p0.b("BaseWebViewClient", "WebView called onRenderProcessGone");
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
                p0.b("BaseWebViewClient", th.getMessage());
                return true;
            }
        }
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.a(webView);
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar = this.f4533a;
        if (aVar != null && aVar.a(str)) {
            return true;
        }
        com.mbridge.msdk.mbsignalcommon.windvane.c cVar = this.b;
        if (cVar != null) {
            cVar.b(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void a(a aVar) {
        this.f4533a = aVar;
    }

    public a a() {
        return this.f4533a;
    }

    public void a(com.mbridge.msdk.mbsignalcommon.windvane.c cVar) {
        this.b = cVar;
    }
}
