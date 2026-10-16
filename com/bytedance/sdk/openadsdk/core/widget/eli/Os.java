package com.bytedance.sdk.openadsdk.core.widget.eli;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.Xb;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class Os {
    private final WeakReference<Context> eli;
    private boolean DbA = true;
    private final boolean Os = true;
    private final boolean aGH = true;
    private final boolean ui = false;
    private final boolean MGA = true;
    private boolean kb = true;

    public static Os eli(Context context) {
        return new Os(context);
    }

    private Os(Context context) {
        this.eli = new WeakReference<>(context);
    }

    public Os eli(boolean z) {
        this.kb = z;
        return this;
    }

    public Os DbA(boolean z) {
        this.DbA = z;
        return this;
    }

    public void eli(WebView webView) {
        if (webView == null || this.eli.get() == null) {
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
        } catch (Exception e) {
            Xb.Os("SSWebSettings", e.getMessage());
        }
        try {
            if (this.DbA) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            Xb.Os("SSWebSettings", th.getMessage());
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setSavePassword(false);
        try {
            if (this.kb) {
                webView.setLayerType(2, null);
            } else {
                webView.setLayerType(0, null);
            }
        } catch (Throwable th2) {
            Xb.Os("SSWebSettings", th2.getMessage());
        }
    }

    public static void DbA(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            Xb.Os(th.toString(), new Object[0]);
        }
    }

    private void eli(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            Xb.Os(th.toString(), new Object[0]);
        }
    }

    public static void eli(com.bytedance.sdk.component.FC.MGA mga) {
        if (mga == null) {
            return;
        }
        int eli = com.bytedance.sdk.openadsdk.bf.eli.eli("clear_web_cache_new", 0);
        if (eli == 0) {
            mga.eli(true);
        } else if (eli == 1) {
            mga.eli(false);
        }
    }
}
