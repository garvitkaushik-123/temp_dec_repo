package com.ironsource;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3040d4;
import com.ironsource.F8;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.k8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3162k8 implements F8 {
    private static final String g = "loadWithUrl | webView is not null";
    private static final String h = "k8";
    private static final String i = "file://";

    /* renamed from: a, reason: collision with root package name */
    private final String f3400a;
    private String b;
    private WebView c;
    private C3129i8 d;
    private C3044d8 e;
    private Context f;

    /* renamed from: com.ironsource.k8$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3401a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ String c;

        a(String str, JSONObject jSONObject, String str2) {
            this.f3401a = str;
            this.b = jSONObject;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C3162k8.this.c != null) {
                C3348v8.a(Md.q, new C3264q8().a(D5.A, C3162k8.g).a());
            }
            try {
                C3162k8.this.b(this.f3401a);
                C3162k8.this.c.loadUrl(C3162k8.this.a(this.b.getString("urlForWebView")));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", C3162k8.this.f3400a);
                C3162k8.this.d.a(this.c, jSONObject);
            } catch (Exception e) {
                C3260q4.d().a(e);
                C3162k8.this.b(this.f3401a, e.getMessage());
                C3348v8.a(Md.q, new C3264q8().a(D5.A, e.getMessage()).a());
            }
        }
    }

    /* renamed from: com.ironsource.k8$b */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3402a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.f3402a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WebView webView = C3162k8.this.c;
                if (webView != null) {
                    webView.destroy();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", C3162k8.this.f3400a);
                C3129i8 c3129i8 = C3162k8.this.d;
                if (c3129i8 != null) {
                    c3129i8.a(this.f3402a, jSONObject);
                    C3162k8.this.d.b();
                }
                C3162k8 c3162k8 = C3162k8.this;
                c3162k8.d = null;
                c3162k8.f = null;
            } catch (Exception e) {
                C3260q4.d().a(e);
                Log.e(C3162k8.h, "performCleanup | could not destroy ISNAdView webView ID: " + C3162k8.this.f3400a);
                C3348v8.a(Md.r, new C3264q8().a(D5.A, e.getMessage()).a());
                C3162k8.this.b(this.b, e.getMessage());
            }
        }
    }

    /* renamed from: com.ironsource.k8$c */
    class c implements F8.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3403a;

        c(String str) {
            this.f3403a = str;
        }

        @Override // com.ironsource.F8.a
        public void a(String str) {
            Logger.i(C3162k8.h, "ISNAdViewWebPresenter | WebViewClient | reportOnError: " + str);
            C3162k8.this.b(this.f3403a, str);
        }

        @Override // com.ironsource.F8.a
        public void b(String str) {
            Logger.i(C3162k8.h, "ISNAdViewWebPresenter | WebViewClient | onRenderProcessGone: " + str);
            try {
                ((ViewGroup) C3162k8.this.c.getParent()).removeView(C3162k8.this.c);
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            C3162k8.this.d();
        }
    }

    /* renamed from: com.ironsource.k8$d */
    private class d extends WebChromeClient {
        private d() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(C3162k8.this.new d());
            webView2.setWebViewClient(new e());
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }
    }

    /* renamed from: com.ironsource.k8$e */
    private class e extends WebViewClient {
        private e() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(C3162k8.h, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context context = webView.getContext();
            Intent a2 = new OpenUrlActivity.e(new k.b()).a(str).b(false).a(context);
            a2.addFlags(268435456);
            context.startActivity(a2);
            return true;
        }
    }

    public C3162k8(InterfaceC3095g8 interfaceC3095g8, Context context, String str, C3044d8 c3044d8) {
        this.f = context;
        C3129i8 c3129i8 = new C3129i8();
        this.d = c3129i8;
        c3129i8.g(str);
        this.f3400a = str;
        this.d.a(interfaceC3095g8);
        this.e = c3044d8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        a("", "");
    }

    public String a() {
        return this.f3400a;
    }

    public C3129i8 b() {
        return this.d;
    }

    public C3044d8 c() {
        return this.e;
    }

    public void e(String str) {
        this.b = str;
    }

    @Override // com.ironsource.F8
    public WebView getPresentingView() {
        return this.c;
    }

    @JavascriptInterface
    public void handleMessageFromAd(String str) {
        this.d.c(str);
    }

    private String d(String str) {
        String substring = str.substring(str.indexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1);
        return substring.substring(substring.indexOf(RemoteSettings.FORWARD_SLASH_STRING));
    }

    @Override // com.ironsource.F8
    public void a(JSONObject jSONObject, String str, String str2) {
        try {
            this.d.e(str);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            Logger.i(h, "sendHandleGetViewVisibility fail with reason: " + e2.getMessage());
        }
    }

    @Override // com.ironsource.F8
    public void b(JSONObject jSONObject, String str, String str2) {
        R7.f3025a.d(new a(str2, jSONObject, str));
    }

    @Override // com.ironsource.F8
    public void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        try {
            this.d.a(jSONObject.getString("params"), str, str2);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            Logger.i(h, "sendMessageToAd fail message: " + e2.getMessage());
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Logger.i(h, "ISNAdViewWebPresenter | createWebView");
        WebView webView = new WebView(this.f);
        this.c = webView;
        webView.addJavascriptInterface(new C3112h8(this), C3061e8.e);
        this.c.setWebViewClient(new C3145j8(new c(str)));
        this.c.setWebChromeClient(new d());
        vg.a(this.c);
        this.d.a(this.c);
    }

    @Override // com.ironsource.F8
    public synchronized void a(String str, String str2) {
        if (this.f == null) {
            return;
        }
        Logger.i(h, "performCleanup");
        R7.f3025a.d(new b(str, str2));
    }

    private boolean c(String str) {
        return str.startsWith(".");
    }

    @Override // com.ironsource.F8
    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b(str3, C3040d4.c.D);
            return;
        }
        Logger.i(h, "trying to perform WebView Action: " + str);
        try {
            if (str.equals(C3040d4.h.t0)) {
                this.c.onPause();
                this.d.f(str2);
            } else if (str.equals(C3040d4.h.u0)) {
                this.c.onResume();
                this.d.f(str2);
            } else {
                b(str3, C3040d4.c.C);
            }
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            b(str3, C3040d4.c.E);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return c(str) ? "file://" + this.b + d(str) : str;
    }

    public void b(String str, String str2) {
        C3129i8 c3129i8 = this.d;
        if (c3129i8 != null) {
            c3129i8.a(str, str2);
        }
    }
}
