package com.fyber.inneractive.sdk.activities;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.network.z;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h1;
import com.fyber.inneractive.sdk.util.o0;
import com.fyber.inneractive.sdk.util.t;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class a extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FyberReportAdActivity f1006a;

    public a(FyberReportAdActivity fyberReportAdActivity) {
        this.f1006a = fyberReportAdActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        IAlog.f("Received Error on WebViewClient: Code: %d, Description: %s, failingUrl: %s", Integer.valueOf(i), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        z.a("WebViewRendererProcessGone", "Web view renderer process has gone. Web view destroyed", null, null);
        FyberReportAdActivity fyberReportAdActivity = this.f1006a;
        if (fyberReportAdActivity.b == webView) {
            fyberReportAdActivity.b = null;
        }
        if (webView != null) {
            t.a(webView);
            webView.destroy();
        }
        this.f1006a.finish();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.fyber.inneractive.sdk.flow.h hVar;
        if (str == null) {
            return false;
        }
        if (h1.a(str)) {
            WebView webView2 = this.f1006a.b;
            if (webView2 != null) {
                webView2.loadUrl("chrome://crash");
            }
            return true;
        }
        if (!str.startsWith("fybermarketplace://reportAd?") || (hVar = FyberReportAdActivity.f) == null) {
            return false;
        }
        String substring = str.substring(28);
        com.fyber.inneractive.sdk.flow.g gVar = (com.fyber.inneractive.sdk.flow.g) hVar;
        gVar.getClass();
        w wVar = new w(u.FYBER_REPORT_AD, gVar.b, gVar.c);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, substring);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", PglCryptUtils.KEY_MESSAGE, substring);
        }
        wVar.f.put(jSONObject);
        wVar.g = true;
        wVar.a((String) null);
        WebView webView3 = this.f1006a.b;
        if (webView3 != null) {
            o0.a(webView3, "reportSent();");
        }
        return true;
    }
}
