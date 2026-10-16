package com.bytedance.sdk.component.FC;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.FC.eli;
import java.util.List;

/* loaded from: classes3.dex */
public class kb extends WebViewClient {
    private final eli.InterfaceC0132eli DbA;
    private final List<String> Os;
    private final WebViewClient eli;

    public kb(eli.InterfaceC0132eli interfaceC0132eli, WebViewClient webViewClient, List<String> list) {
        this.DbA = interfaceC0132eli;
        this.eli = webViewClient;
        this.Os = list;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return this.eli.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        eli.InterfaceC0132eli interfaceC0132eli;
        if (DbA.eli(this.Os, webResourceRequest.getUrl().toString()) && (interfaceC0132eli = this.DbA) != null) {
            interfaceC0132eli.eli();
        }
        return this.eli.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        eli.InterfaceC0132eli interfaceC0132eli = this.DbA;
        if (interfaceC0132eli != null) {
            interfaceC0132eli.eli();
        }
        return this.eli.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.eli.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        eli.InterfaceC0132eli interfaceC0132eli = this.DbA;
        if (interfaceC0132eli != null) {
            interfaceC0132eli.eli(eli(webView));
        }
        this.eli.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.eli.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.eli.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.eli.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.eli.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.eli.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    private int eli(WebView webView) {
        try {
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            if (copyBackForwardList != null) {
                return copyBackForwardList.getCurrentIndex() + 1;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
