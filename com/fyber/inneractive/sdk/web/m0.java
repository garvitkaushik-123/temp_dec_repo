package com.fyber.inneractive.sdk.web;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class m0 extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f1809a;

    public m0(v0 v0Var) {
        this.f1809a = v0Var;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Activity activity = (Activity) com.fyber.inneractive.sdk.util.t.a(this.f1809a.q);
        if (activity != null) {
            activity.finish();
        }
        com.fyber.inneractive.sdk.util.r.b.postDelayed(new l0(this), 1000L);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.endsWith("success")) {
            v0 v0Var = this.f1809a;
            n0 n0Var = v0Var.p;
            if (n0Var != null) {
                com.fyber.inneractive.sdk.util.r.b.removeCallbacks(n0Var);
                v0Var.p = null;
            }
            v0 v0Var2 = this.f1809a;
            v0Var2.getClass();
            IAlog.a("%sInternalStoreWebpageController: onWebviewLoaded - load took %d msec", IAlog.a(v0Var2), Long.valueOf(System.currentTimeMillis() - this.f1809a.o));
            this.f1809a.l = true;
            return true;
        }
        if (!str.startsWith("exit")) {
            return false;
        }
        Activity activity = (Activity) com.fyber.inneractive.sdk.util.t.a(this.f1809a.q);
        if (activity == null) {
            return true;
        }
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("target");
            boolean equals = TextUtils.equals("mail", parse.getAuthority());
            Intent intent = new Intent(equals ? "android.intent.action.SENDTO" : "android.intent.action.VIEW", Uri.parse(queryParameter));
            if (equals) {
                intent = Intent.createChooser(intent, "Choose an application");
            }
            com.fyber.inneractive.sdk.util.f0.a(activity, intent);
        } catch (Throwable th) {
            com.fyber.inneractive.sdk.network.z.a(th, null, null);
        }
        return true;
    }
}
