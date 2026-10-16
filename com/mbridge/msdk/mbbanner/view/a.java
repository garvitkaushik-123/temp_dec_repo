package com.mbridge.msdk.mbbanner.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.base.b;
import java.util.List;

/* compiled from: BannerWebViewClient.java */
/* loaded from: classes6.dex */
public class a extends b {
    private final String c = "BannerWebViewClient";
    String d;
    List<CampaignEx> e;
    com.mbridge.msdk.mbbanner.common.listener.a f;

    /* compiled from: BannerWebViewClient.java */
    /* renamed from: com.mbridge.msdk.mbbanner.view.a$a, reason: collision with other inner class name */
    class C0354a implements ValueCallback<String> {
        C0354a() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
        }
    }

    public a(String str, List<CampaignEx> list, com.mbridge.msdk.mbbanner.common.listener.a aVar) {
        this.d = str;
        this.e = list;
        this.f = aVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        CampaignEx campaignEx;
        super.onPageStarted(webView, str, bitmap);
        try {
            a(webView, "javascript:" + com.mbridge.msdk.setting.util.a.a().b());
            List<CampaignEx> list = this.e;
            if (list == null || list.isEmpty() || (campaignEx = this.e.get(0)) == null || !campaignEx.isActiveOm()) {
                return;
            }
            a(webView, "javascript:" + MBridgeConstans.OMID_JS_SERVICE_CONTENT);
        } catch (Throwable th) {
            p0.b("BannerWebViewClient", "onPageStarted", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            p0.b("BannerWebViewClient", "Use html to open url.");
            BaseWebView baseWebView = (BaseWebView) webView;
            if (System.currentTimeMillis() - baseWebView.lastTouchTime > com.mbridge.msdk.click.utils.a.d && com.mbridge.msdk.click.utils.a.a(this.e.get(0), baseWebView.getUrl(), com.mbridge.msdk.click.utils.a.b)) {
                return false;
            }
            if (this.e.size() > 1) {
                c.m().d().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.listener.a aVar = this.f;
            if (aVar != null) {
                aVar.a(false, str);
            }
            return true;
        } catch (Throwable th) {
            p0.b("BannerWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }

    private void a(WebView webView, String str) {
        webView.evaluateJavascript(str, new C0354a());
    }
}
