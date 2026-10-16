package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.p0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: CommonWebChromeClient.java */
/* loaded from: classes6.dex */
public class a extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<WebChromeClient> f4551a = new CopyOnWriteArrayList<>();

    public void a(WebChromeClient webChromeClient) {
        this.f4551a.add(webChromeClient);
    }

    public void b(WebChromeClient webChromeClient) {
        this.f4551a.remove(webChromeClient);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        super.getVisitedHistory(valueCallback);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onConsoleMessage(str, i, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 = it.next().onCreateWindow(webView, z, z2, message);
        }
        return z3;
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = it.next().onJsAlert(webView, str, str2, jsResult);
        }
        return z;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = it.next().onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return z;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = it.next().onJsConfirm(webView, str, str2, jsResult);
        }
        return z;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = it.next().onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return z;
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public boolean onJsTimeout() {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = it.next().onJsTimeout();
        }
        return z;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        try {
            Iterator<WebChromeClient> it = this.f4551a.iterator();
            while (it.hasNext()) {
                it.next().onPermissionRequest(permissionRequest);
            }
        } catch (Exception e) {
            p0.b("CommonWebChromeClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        try {
            Iterator<WebChromeClient> it = this.f4551a.iterator();
            while (it.hasNext()) {
                it.next().onPermissionRequestCanceled(permissionRequest);
            }
        } catch (Exception e) {
            p0.b("CommonWebChromeClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        boolean z = false;
        try {
            Iterator<WebChromeClient> it = this.f4551a.iterator();
            while (it.hasNext()) {
                z = it.next().onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            return z;
        } catch (Exception e) {
            p0.b("CommonWebChromeClient", e.getMessage());
            return z;
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = it.next().onConsoleMessage(consoleMessage);
        }
        return z;
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        Iterator<WebChromeClient> it = this.f4551a.iterator();
        while (it.hasNext()) {
            it.next().onShowCustomView(view, i, customViewCallback);
        }
    }
}
