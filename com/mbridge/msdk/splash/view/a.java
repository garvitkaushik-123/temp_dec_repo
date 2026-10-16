package com.mbridge.msdk.splash.view;

import android.graphics.Bitmap;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

/* compiled from: SplashWebViewClient.java */
/* loaded from: classes6.dex */
public class a extends b {
    private final String c = "SplashWebViewClient";
    com.mbridge.msdk.splash.middle.a d;

    /* compiled from: SplashWebViewClient.java */
    /* renamed from: com.mbridge.msdk.splash.view.a$a, reason: collision with other inner class name */
    class C0394a implements ValueCallback<String> {
        C0394a() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    public void a(com.mbridge.msdk.splash.middle.a aVar) {
        if (aVar != null) {
            this.d = aVar;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            webView.evaluateJavascript("javascript:" + com.mbridge.msdk.setting.util.a.a().b(), new C0394a());
        } catch (Throwable th) {
            p0.b("SplashWebViewClient", "onPageStarted", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            WindVaneWebView windVaneWebView = (WindVaneWebView) webView;
            if (System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.mbridge.msdk.click.utils.a.d && com.mbridge.msdk.click.utils.a.a(((com.mbridge.msdk.splash.signal.b) windVaneWebView.getObject()).b().get(0), windVaneWebView.getUrl(), com.mbridge.msdk.click.utils.a.b)) {
                return false;
            }
            com.mbridge.msdk.splash.middle.a aVar = this.d;
            if (aVar == null) {
                return true;
            }
            aVar.a(false, str);
            return true;
        } catch (Throwable th) {
            p0.b("SplashWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
