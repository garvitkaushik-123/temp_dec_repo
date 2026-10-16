package com.bytedance.sdk.openadsdk.Xb;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: classes3.dex */
public class FC {
    private static void DbA(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            kb.eli("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    private static void eli(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            kb.eli("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
        }
    }

    public static void eli(WebView webView) {
        if (webView == null) {
            return;
        }
        DbA(webView);
        WebSettings settings = webView.getSettings();
        eli(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable th) {
            kb.eli("WebViewSettings", "setJavaScriptEnabled error", th);
        }
        try {
            settings.setSupportZoom(false);
        } catch (Throwable th2) {
            kb.eli("WebViewSettings", "setSupportZoom error", th2);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setSavePassword(false);
        try {
            webView.setLayerType(2, null);
        } catch (Throwable th3) {
            kb.eli("WebViewSettings", "setLayerType error", th3);
        }
        webView.getSettings().setMixedContentMode(0);
    }
}
