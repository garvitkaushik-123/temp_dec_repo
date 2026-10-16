package com.mbridge.msdk.advanced.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.common.net.HttpHeaders;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import com.mbridge.msdk.advanced.middle.c;
import com.mbridge.msdk.foundation.same.directory.e;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.vungle.ads.internal.model.AdPayload;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.HashMap;

/* compiled from: NativeAdvancedWebViewClient.java */
/* loaded from: classes6.dex */
public class a extends b {
    private final String c = "NativeAdvancedWebViewClient";
    private final String d;
    private final String e;
    String f;
    com.mbridge.msdk.advanced.middle.a g;
    private c h;

    /* compiled from: NativeAdvancedWebViewClient.java */
    /* renamed from: com.mbridge.msdk.advanced.view.a$a, reason: collision with other inner class name */
    class C0320a implements ValueCallback<String> {
        C0320a() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    public a(String str, com.mbridge.msdk.advanced.middle.a aVar, c cVar) {
        com.mbridge.msdk.foundation.same.directory.c cVar2 = com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_VC;
        this.d = e.b(cVar2) != null ? e.b(cVar2) : j0.a("YkRXhr5AWBPfNgzuH7JQ+2Ha");
        this.e = j0.a("Y+xgWkl2");
        this.f = str;
        this.g = aVar;
        this.h = cVar;
    }

    private WebResourceResponse a(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && this.h != null) {
            try {
                String str2 = "";
                if (str.startsWith(C3040d4.h.b) && str.startsWith(this.d)) {
                    str2 = str.replace(AdPayload.FILE_SCHEME, "");
                }
                if (a(str)) {
                    str2 = this.h.a(URLDecoder.decode(Uri.parse(str).getQueryParameter("uri")));
                }
                if (!TextUtils.isEmpty(str2) && a(str2, this.d)) {
                    p0.a("NativeAdvancedWebViewClient", "replace url : " + str2);
                    if (!str2.contains("127.0.0.1") && !str2.startsWith("http")) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                        WebResourceResponse webResourceResponse = new WebResourceResponse("video/mp4", D5.N, new FileInputStream(str2));
                        webResourceResponse.setResponseHeaders(hashMap);
                        return webResourceResponse;
                    }
                    return null;
                }
            } catch (Throwable th) {
                p0.b("NativeAdvancedWebViewClient", th.getMessage());
            }
        }
        return null;
    }

    public void b() {
        if (this.h != null) {
            this.h = null;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            webView.evaluateJavascript("javascript:" + com.mbridge.msdk.setting.util.a.a().b(), new C0320a());
        } catch (Throwable th) {
            p0.b("NativeAdvancedWebViewClient", "onPageStarted", th);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(webView, str);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            try {
                WindVaneWebView windVaneWebView = (WindVaneWebView) webView;
                if (System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.mbridge.msdk.click.utils.a.d) {
                    if (com.mbridge.msdk.click.utils.a.a(((com.mbridge.msdk.advanced.signal.b) windVaneWebView.getObject()).a().get(0), windVaneWebView.getUrl(), com.mbridge.msdk.click.utils.a.b)) {
                        return false;
                    }
                }
            } catch (Exception e) {
                p0.b("NativeAdvancedWebViewClient", e.getMessage());
            }
            p0.b("NativeAdvancedWebViewClient", "Use html to open url.");
            com.mbridge.msdk.advanced.middle.a aVar = this.g;
            if (aVar == null) {
                return true;
            }
            aVar.a(false, str);
            return true;
        } catch (Throwable th) {
            p0.b("NativeAdvancedWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return a(webView, webResourceRequest.getUrl().toString());
    }

    private boolean a(String str) {
        Uri parse;
        String scheme;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (scheme = parse.getScheme()) == null || TextUtils.isEmpty(scheme)) {
            return false;
        }
        return scheme.equals(this.e) || scheme.equals("mb-h5");
    }
}
