package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.C;
import com.ironsource.A4;
import com.ironsource.Ac;
import com.ironsource.Bc;
import com.ironsource.C1;
import com.ironsource.C2986a4;
import com.ironsource.C3040d4;
import com.ironsource.C3074f4;
import com.ironsource.C3078f8;
import com.ironsource.C3091g4;
import com.ironsource.C3092g5;
import com.ironsource.C3137j0;
import com.ironsource.C3158k4;
import com.ironsource.C3179l8;
import com.ironsource.C3209n4;
import com.ironsource.C3230o8;
import com.ironsource.C3247p8;
import com.ironsource.C3260q4;
import com.ironsource.C3264q8;
import com.ironsource.C3270qe;
import com.ironsource.C3273r1;
import com.ironsource.C3314t8;
import com.ironsource.C3334ub;
import com.ironsource.C3348v8;
import com.ironsource.C3368wb;
import com.ironsource.C3382x8;
import com.ironsource.Cc;
import com.ironsource.D5;
import com.ironsource.F8;
import com.ironsource.InterfaceC2992aa;
import com.ironsource.InterfaceC3006b7;
import com.ironsource.InterfaceC3023c7;
import com.ironsource.InterfaceC3063ea;
import com.ironsource.InterfaceC3141j4;
import com.ironsource.InterfaceC3293s4;
import com.ironsource.InterfaceC3307t1;
import com.ironsource.InterfaceC3327u4;
import com.ironsource.InterfaceC3344v4;
import com.ironsource.InterfaceC3361w4;
import com.ironsource.InterfaceC3378x4;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.InterfaceC3386xc;
import com.ironsource.L;
import com.ironsource.Lc;
import com.ironsource.Mc;
import com.ironsource.Md;
import com.ironsource.N6;
import com.ironsource.Nd;
import com.ironsource.Qf;
import com.ironsource.R7;
import com.ironsource.R9;
import com.ironsource.T9;
import com.ironsource.V4;
import com.ironsource.W4;
import com.ironsource.X3;
import com.ironsource.Xf;
import com.ironsource.Y0;
import com.ironsource.Y1;
import com.ironsource.Y6;
import com.ironsource.Z0;
import com.ironsource.Z3;
import com.ironsource.Z4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.controller.m;
import com.ironsource.sdk.controller.p;
import com.ironsource.sdk.controller.v;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.ug;
import com.ironsource.vg;
import com.unity3d.services.core.di.ServiceProvider;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class v implements com.ironsource.sdk.controller.l, InterfaceC3386xc, DownloadListener {
    private static final String b0 = "about:blank";
    public static int c0 = 0;
    public static String d0 = "is_store";
    public static String e0 = "external_url";
    public static String f0 = "secondary_web_view";
    private static String g0 = "success";
    private static String h0 = "fail";
    private String A;
    private com.ironsource.sdk.controller.d B;
    private Xf C;
    private Z0 D;
    private W4 G;
    private com.ironsource.sdk.controller.o H;
    private com.ironsource.sdk.controller.q I;
    private com.ironsource.sdk.controller.u J;
    private com.ironsource.sdk.controller.i K;
    private com.ironsource.sdk.controller.a L;
    private com.ironsource.sdk.controller.j M;
    private C3273r1 N;
    private A4 O;
    private ug P;
    private com.ironsource.sdk.controller.c Q;
    private X3 R;
    private JSONObject S;
    private l.a T;
    private l.b U;
    private C3209n4 V;
    private boolean W;
    C3091g4 Y;
    final T9 Z;

    /* renamed from: a, reason: collision with root package name */
    private final R7 f3779a;
    private Ac a0;
    private InterfaceC3141j4 b;
    private String f;
    private String g;
    private final C3092g5 h;
    private boolean i;
    private p j;
    private boolean k;
    private CountDownTimer l;
    public CountDownTimer m;
    private final o q;
    private View r;
    private FrameLayout s;
    private WebChromeClient.CustomViewCallback t;
    private FrameLayout u;
    private u v;
    private String w;
    private InterfaceC3378x4 x;
    private InterfaceC3361w4 y;
    private InterfaceC3344v4 z;
    private String c = "v";
    private String d = "IronSource";
    private final String e = "We're sorry, some error occurred. we will investigate it";
    private int n = 50;
    private int o = 50;
    private String p = C3040d4.e.b;
    private Object E = new Object();
    private boolean F = false;
    private final InterfaceC3381x7 X = C3334ub.U().i();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(1);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C3247p8 f3781a;

        b(C3247p8 c3247p8) {
            this.f3781a = c3247p8;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.Q.c("controller html - failed to download - " + this.f3781a.b());
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3782a;

        c(Context context) {
            this.f3782a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.e(this.f3782a);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3783a;

        d(Context context) {
            this.f3783a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.f(this.f3783a);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C3230o8.e f3784a;
        final /* synthetic */ String b;

        e(C3230o8.e eVar, String str) {
            this.f3784a = eVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC3327u4 a2;
            C3230o8.e eVar = this.f3784a;
            if ((eVar == C3230o8.e.RewardedVideo || eVar == C3230o8.e.Interstitial) && (a2 = v.this.a(eVar)) != null) {
                a2.b(this.f3784a, this.b);
            }
        }
    }

    class g implements ug {
        g() {
        }

        @Override // com.ironsource.ug
        public void a(String str, JSONObject jSONObject) {
            v.this.i(v.this.e(str, jSONObject.toString()));
        }
    }

    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f3786a;
        final /* synthetic */ WebView b;
        final /* synthetic */ String c;

        h(JSONObject jSONObject, WebView webView, String str) {
            this.f3786a = jSONObject;
            this.b = webView;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(this.f3786a, this.b);
            v.this.l("about:blank");
            v.this.l(this.c);
        }
    }

    class i extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3787a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Q.c(C3040d4.c.j);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long j, long j2, int i) {
            super(j, j2);
            this.f3787a = i;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(v.this.c, "Loading Controller Timer Finish");
            int i = this.f3787a;
            if (i == 3) {
                v.this.b(new a());
            } else {
                v.this.a(i + 1);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Logger.i(v.this.c, "Loading Controller Timer Tick " + j);
        }
    }

    class j implements s {
        j() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, C3230o8.e eVar, V4 v4) {
            v.this.a(str, eVar, v4);
        }
    }

    class k implements s {
        k() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, C3230o8.e eVar, V4 v4) {
            v.this.a(str, eVar, v4);
        }
    }

    class l implements s {
        l() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, C3230o8.e eVar, V4 v4) {
            v.this.a(str, eVar, v4);
        }
    }

    class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C3230o8.e f3792a;
        final /* synthetic */ V4 b;
        final /* synthetic */ String c;

        m(C3230o8.e eVar, V4 v4, String str) {
            this.f3792a = eVar;
            this.b = v4;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            V4 v4;
            C3230o8.e eVar = C3230o8.e.RewardedVideo;
            C3230o8.e eVar2 = this.f3792a;
            if ((eVar != eVar2 && C3230o8.e.Interstitial != eVar2 && C3230o8.e.Banner != eVar2) || (v4 = this.b) == null || TextUtils.isEmpty(v4.h())) {
                return;
            }
            InterfaceC3327u4 a2 = v.this.a(this.f3792a);
            Log.d(v.this.c, "onAdProductInitFailed (message:" + this.c + ")(" + this.f3792a + ")");
            if (a2 != null) {
                a2.a(this.f3792a, this.b.h(), this.c);
            }
        }
    }

    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(1);
        }
    }

    private class o extends WebChromeClient {
        private o() {
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(v.this.Z.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Logger.i("MyApplication", consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            WebView webView2 = new WebView(webView.getContext());
            webView2.setWebChromeClient(this);
            webView2.setWebViewClient(new q());
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            Logger.i("Test", "onHideCustomView");
            View view = v.this.r;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            v vVar = v.this;
            vVar.s.removeView(vVar.r);
            v vVar2 = v.this;
            vVar2.r = null;
            vVar2.s.setVisibility(8);
            v.this.t.onCustomViewHidden();
            v.this.Z.setVisibility(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Logger.i("Test", "onShowCustomView");
            v.this.Z.setVisibility(8);
            if (v.this.r != null) {
                Logger.i("Test", "mCustomView != null");
                customViewCallback.onCustomViewHidden();
                return;
            }
            Logger.i("Test", "mCustomView == null");
            v.this.s.addView(view);
            v vVar = v.this;
            vVar.r = view;
            vVar.t = customViewCallback;
            vVar.s.setVisibility(0);
        }
    }

    static class p {

        /* renamed from: a, reason: collision with root package name */
        C3230o8.e f3795a;
        String b;

        public p(C3230o8.e eVar, String str) {
            this.f3795a = eVar;
            this.b = str;
        }

        String a() {
            return this.b;
        }

        C3230o8.e b() {
            return this.f3795a;
        }
    }

    private class q extends WebViewClient {
        private q() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(v.this.c, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context p = v.this.p();
            p.startActivity(new OpenUrlActivity.e(new k.b()).a(str).b(false).a(p));
            return true;
        }
    }

    private interface s {
        void a(String str, C3230o8.e eVar, V4 v4);
    }

    static class t {

        /* renamed from: a, reason: collision with root package name */
        String f3821a;
        String b;

        t() {
        }
    }

    public enum u {
        Display,
        Gone
    }

    /* renamed from: com.ironsource.sdk.controller.v$v, reason: collision with other inner class name */
    private class C0305v extends WebViewClient {
        private C0305v() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.i("onPageFinished", str);
            if (str.contains("adUnit") || str.contains(Constants.AD_INDEX_FILE_NAME)) {
                v.this.z();
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.i("onPageStarted", str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            com.ironsource.sdk.controller.c cVar;
            Logger.i("onReceivedError", str2 + " " + str);
            if (str2.contains(C3040d4.f) && (cVar = v.this.Q) != null) {
                cVar.c("controller html - web-view receivedError on loading - " + str + " (errorCode: " + i + ")");
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.e(v.this.c, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            String str = renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system";
            com.ironsource.sdk.controller.c cVar = v.this.Q;
            if (cVar != null) {
                cVar.b(str);
            }
            v.this.v();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z;
            Logger.i("shouldInterceptRequest", str);
            try {
                z = new URL(str).getFile().contains("mraid.js");
            } catch (MalformedURLException e) {
                C3260q4.d().a(e);
                z = false;
            }
            if (z) {
                String str2 = AdPayload.FILE_SCHEME + v.this.A + File.separator + "mraid.js";
                try {
                    new FileInputStream(new File(str2));
                    return new WebResourceResponse("text/javascript", "UTF-8", getClass().getResourceAsStream(str2));
                } catch (FileNotFoundException e2) {
                    C3260q4.d().a(e2);
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.i("shouldOverrideUrlLoading", str);
            try {
                if (v.this.h(str)) {
                    v.this.y();
                    return true;
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public v(Context context, W4 w4, C3091g4 c3091g4, com.ironsource.sdk.controller.c cVar, R7 r7, int i2, C3092g5 c3092g5, String str, l.a aVar, l.b bVar, String str2, String str3) throws Throwable {
        T9 t9 = new T9(context, new InterfaceC3063ea.a());
        this.Z = t9;
        Logger.i(this.c, "C'tor");
        this.Y = c3091g4;
        this.Q = cVar;
        this.f3779a = r7;
        this.G = w4;
        a(context, t9);
        this.A = str;
        this.D = new Z0();
        this.S = new JSONObject();
        this.h = c3092g5;
        this.T = aVar;
        this.U = bVar;
        boolean optBoolean = SDKUtils.getNetworkConfiguration().optBoolean(C3040d4.a.i, false);
        this.W = optBoolean;
        if (optBoolean) {
            this.V = new C3209n4(new C3158k4(SDKUtils.getControllerUrl(), this.A, SDKUtils.getNetworkConfiguration().optBoolean("useWebViewUserAgent", false), new Mc(SDKUtils.getControllerUrl())), new Function1() { // from class: com.ironsource.sdk.controller.v$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object c2;
                    c2 = v.this.c((C3382x8) obj);
                    return c2;
                }
            }, c3092g5, new InterfaceC3293s4.a());
        } else {
            c3092g5.a(this);
            this.B = new com.ironsource.sdk.controller.d(SDKUtils.getNetworkConfiguration(), this.A, SDKUtils.getControllerUrl(), c3092g5);
        }
        o oVar = new o();
        this.q = oVar;
        t9.setWebViewClient(new C0305v());
        t9.setWebChromeClient(oVar);
        vg.a(t9);
        a(t9);
        t9.setDownloadListener(this);
        this.R = c(context);
        b(context);
        b(i2);
        this.f = str2;
        this.g = str3;
        this.b = InterfaceC3141j4.a(FeaturesManager.getInstance().getFeatureFlagHealthCheck());
    }

    private void F() {
    }

    private void a(WebView webView) {
        com.ironsource.sdk.controller.s sVar = new com.ironsource.sdk.controller.s(com.ironsource.sdk.controller.s.a());
        webView.addJavascriptInterface(a(sVar), C3040d4.d);
        webView.addJavascriptInterface(b(sVar), C3040d4.e);
    }

    private X3 c(Context context) {
        return new f(SDKUtils.getControllerConfigAsJSONObject(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] f(String str, String str2) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        boolean z2 = true;
        Map<String, String> map = null;
        if (TextUtils.isEmpty(str)) {
            z = true;
        } else {
            V4 a2 = this.G.a(g(str), str2);
            if (a2 != null) {
                map = a2.g();
                map.put("demandSourceName", a2.f());
                map.put("demandSourceId", a2.h());
            }
            try {
                jSONObject.put(C3040d4.h.m, str);
            } catch (JSONException e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
            }
            z = false;
            try {
                Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
                if (initSDKParams != null) {
                    jSONObject = SDKUtils.mergeJSONObjects(jSONObject, new JSONObject(initSDKParams));
                }
            } catch (Exception e3) {
                C3260q4.d().a(e3);
                IronLog.INTERNAL.error(e3.toString());
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            try {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.f), SDKUtils.encodeString(this.g));
            } catch (JSONException e4) {
                C3260q4.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        }
        if (!TextUtils.isEmpty(this.f)) {
            try {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.g), SDKUtils.encodeString(this.f));
            } catch (JSONException e5) {
                C3260q4.d().a(e5);
                IronLog.INTERNAL.error(e5.toString());
            }
            z2 = z;
        }
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("sdkWebViewCache")) {
                    o(entry.getValue());
                }
                try {
                    jSONObject.put(SDKUtils.encodeString(entry.getKey()), SDKUtils.encodeString(entry.getValue()));
                } catch (JSONException e6) {
                    C3260q4.d().a(e6);
                    IronLog.INTERNAL.error(e6.toString());
                }
            }
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z2)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(new Runnable() { // from class: com.ironsource.sdk.controller.v$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                v.this.j(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str) {
        this.Z.a(new m.b(str, q()).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        try {
            Logger.i(this.c, "load(): " + str);
            this.Z.loadUrl(str);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            Logger.e(this.c, "WebViewController::load: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        Nd nd = new Nd(str);
        String d2 = nd.d("color");
        String d3 = nd.d("adViewId");
        int parseColor = !C3040d4.h.T.equalsIgnoreCase(d2) ? Color.parseColor(d2) : 0;
        if (d3 == null) {
            this.Z.setBackgroundColor(parseColor);
            return;
        }
        WebView presentingView = C3179l8.a().a(d3).getPresentingView();
        if (presentingView != null) {
            presentingView.setBackgroundColor(parseColor);
        }
    }

    public void A() {
        try {
            this.Z.onPause();
        } catch (Throwable th) {
            C3260q4.d().a(th);
            Logger.i(this.c, "WebViewController: onPause() - " + th);
        }
    }

    public void B() {
        this.C = null;
    }

    public void C() {
        this.Z.a();
        this.a0 = null;
    }

    public void D() {
        this.Z.requestFocus();
    }

    public void E() {
        try {
            this.Z.onResume();
        } catch (Throwable th) {
            C3260q4.d().a(th);
            Logger.i(this.c, "WebViewController: onResume() - " + th);
        }
    }

    com.ironsource.sdk.controller.r b(com.ironsource.sdk.controller.s sVar) {
        return new com.ironsource.sdk.controller.r(sVar);
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = C3040d4.c.z;
        }
        i(e(C3040d4.g.a0, a("errMsg", str, "url", str2, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.l
    public void e() {
        i(f(C3040d4.g.t));
    }

    public void g(String str, String str2) {
        i(e(C3040d4.g.W, a(C3040d4.h.p, str2, C3040d4.h.m, str, null, null, null, null, null, false)));
    }

    @Override // com.ironsource.sdk.controller.l
    public C3230o8.c h() {
        return C3230o8.c.Web;
    }

    public void k(String str) {
        i(e(C3040d4.g.w, a("action", str, null, null, null, null, null, null, null, false)));
    }

    public void m(String str) {
        String d2;
        try {
            d2 = C2986a4.d(this.Z.getContext());
            Logger.i(this.c, "device status changed, connection type " + str);
            C3314t8.a(str);
            C3314t8.b(d2);
        } catch (Exception e2) {
            e = e2;
        }
        try {
            i(e(C3040d4.g.x, a("connectionType", str, "rawConnectionType", d2, null, null, null, null, null, false)));
        } catch (Exception e3) {
            e = e3;
            Exception exc = e;
            C3260q4.d().a(exc);
            IronLog.INTERNAL.error("Exception: " + Log.getStackTraceString(exc));
        }
    }

    public void n(String str) {
        this.w = str;
    }

    public ug o() {
        if (this.P == null) {
            this.P = new g();
        }
        return this.P;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        Logger.i(this.c, str + " " + str4);
    }

    public int q() {
        return c0;
    }

    public FrameLayout r() {
        return this.u;
    }

    public String s() {
        return this.w;
    }

    public Z0 t() {
        return this.D;
    }

    public u u() {
        return this.v;
    }

    public void v() {
        if (this.j == null) {
            return;
        }
        n();
        C3230o8.e b2 = this.j.b();
        String a2 = this.j.a();
        if (q(b2.toString())) {
            a(b2, a2);
        }
    }

    public void w() {
        this.q.onHideCustomView();
    }

    public boolean x() {
        return this.r != null;
    }

    public void y() {
        i(f(C3040d4.g.Z));
    }

    public void z() {
        i(f(C3040d4.g.A));
    }

    class f extends X3 {
        f(JSONObject jSONObject, Context context) {
            super(jSONObject, context);
        }

        @Override // com.ironsource.X3, com.ironsource.InterfaceC3296s7
        public void a(String str, JSONObject jSONObject) {
            v vVar = v.this;
            if (vVar.i) {
                vVar.m(str);
            }
        }

        @Override // com.ironsource.X3, com.ironsource.InterfaceC3296s7
        public void b(String str, JSONObject jSONObject) {
            if (jSONObject == null || !v.this.i) {
                return;
            }
            try {
                jSONObject.put("connectionType", str);
                v.this.e(jSONObject);
            } catch (JSONException e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }

        @Override // com.ironsource.X3, com.ironsource.InterfaceC3296s7
        public void a() {
            v vVar = v.this;
            if (vVar.i) {
                vVar.m("none");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Ac ac = this.a0;
        if (ac != null) {
            ac.onCloseRequested();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            Logger.d(this.c, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!str.equalsIgnoreCase(C3230o8.e.Interstitial.toString()) ? !(!str.equalsIgnoreCase(C3230o8.e.RewardedVideo.toString()) ? !str.equalsIgnoreCase(C3230o8.e.Banner.toString()) || this.z == null : this.x == null) : this.y != null) {
            z = true;
        }
        if (!z) {
            Logger.d(this.c, "Trying to trigger a listener - no listener was found for product " + str);
        }
        return z;
    }

    @Override // com.ironsource.sdk.controller.l
    public void b() {
        if (this.W) {
            this.V.b();
            return;
        }
        this.B.a(new C3264q8());
        if (this.B.k()) {
            a(1);
        }
    }

    public void c(String str, String str2) {
        String str3;
        try {
            str3 = str;
        } catch (Exception e2) {
            e = e2;
            str3 = str;
        }
        try {
            i(e(C3040d4.g.p, a(C3040d4.h.b, str3, "path", b(str2), null, null, null, null, null, false)));
        } catch (Exception e3) {
            e = e3;
            Exception exc = e;
            C3260q4.d().a(exc);
            b(str3, str2, exc.getMessage());
        }
    }

    public boolean h(String str) {
        try {
            if (!new C3270qe(str, R9.e().d(), FeaturesManager.getInstance().getFeatureFlagClickCheck().b()).a()) {
                return false;
            }
            Qf.a(p(), str);
            return true;
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            return false;
        }
    }

    public class r {

        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3798a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.f3798a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f3798a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.c, "onRVShowFail(message:" + this.f3798a + ")");
                v.this.x.b(this.b, str);
            }
        }

        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3799a;

            b(String str) {
                this.f3799a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.c, "onInterstitialInitSuccess()");
                v.this.y.a(C3230o8.e.Interstitial, this.f3799a, (Y0) null);
            }
        }

        class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3800a;
            final /* synthetic */ String b;

            c(String str, String str2) {
                this.f3800a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f3800a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.c, "onInterstitialInitFail(message:" + str + ")");
                v.this.y.a(C3230o8.e.Interstitial, this.b, str);
            }
        }

        class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ InterfaceC3327u4 f3801a;
            final /* synthetic */ C3230o8.e b;
            final /* synthetic */ String c;

            d(InterfaceC3327u4 interfaceC3327u4, C3230o8.e eVar, String str) {
                this.f3801a = interfaceC3327u4;
                this.b = eVar;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3801a.a(this.b, this.c);
            }
        }

        class e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3802a;
            final /* synthetic */ JSONObject b;

            e(String str, JSONObject jSONObject) {
                this.f3802a = str;
                this.b = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.y.a(this.f3802a, this.b);
            }
        }

        class f implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3803a;
            final /* synthetic */ String b;

            f(String str, String str2) {
                this.f3803a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f3803a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.y.a(this.b, str);
            }
        }

        class g implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3804a;

            g(String str) {
                this.f3804a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.c, "onBannerInitSuccess()");
                v.this.z.a(C3230o8.e.Banner, this.f3804a, (Y0) null);
            }
        }

        class h implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3805a;
            final /* synthetic */ String b;

            h(String str, String str2) {
                this.f3805a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f3805a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.c, "onBannerInitFail(message:" + str + ")");
                v.this.z.a(C3230o8.e.Banner, this.b, str);
            }
        }

        class i implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3806a;
            final /* synthetic */ C3078f8 b;

            i(String str, C3078f8 c3078f8) {
                this.f3806a = str;
                this.b = c3078f8;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.c, "onBannerLoadSuccess()");
                v.this.z.a(this.f3806a, this.b);
            }
        }

        class j implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3807a;
            final /* synthetic */ String b;

            j(String str, String str2) {
                this.f3807a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.c, "onLoadBannerFail()");
                String str = this.f3807a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.z.c(this.b, str);
            }
        }

        class k implements Runnable {
            k() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.E();
            }
        }

        class l implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3809a;

            l(String str) {
                this.f3809a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (new JSONObject(this.f3809a).has(f.b.b)) {
                        v.this.T.a(f.a.a(this.f3809a));
                    } else {
                        v.this.U.a(C3368wb.a(this.f3809a));
                    }
                } catch (JSONException e) {
                    C3260q4.d().a(e);
                    Logger.e(v.this.c, "failed to parse received message");
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }

        class m implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ C3230o8.e f3810a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;
            final /* synthetic */ JSONObject d;

            m(C3230o8.e eVar, String str, String str2, JSONObject jSONObject) {
                this.f3810a = eVar;
                this.b = str;
                this.c = str2;
                this.d = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                InterfaceC3327u4 a2;
                C3230o8.e eVar = this.f3810a;
                if ((eVar == C3230o8.e.Interstitial || eVar == C3230o8.e.RewardedVideo || eVar == C3230o8.e.Banner) && (a2 = v.this.a(eVar)) != null) {
                    a2.a(this.f3810a, this.b, this.c, this.d);
                }
            }
        }

        class n implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3811a;

            n(String str) {
                this.f3811a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger.i(v.this.c, "omidAPI(" + this.f3811a + ")");
                    v.this.H.a(new Nd(this.f3811a).toString(), r.this.new w());
                } catch (Exception e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                    Logger.i(v.this.c, "omidAPI failed with exception " + e.getMessage());
                }
            }
        }

        class o implements Runnable {
            o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.A();
            }
        }

        class p implements Runnable {
            p() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Z.removeJavascriptInterface(C3040d4.e);
            }
        }

        class q implements Runnable {
            q() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Z.getSettings().setMixedContentMode(0);
            }
        }

        /* renamed from: com.ironsource.sdk.controller.v$r$r, reason: collision with other inner class name */
        class RunnableC0303r implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f3815a;
            final /* synthetic */ String b;
            final /* synthetic */ Y0 c;

            RunnableC0303r(int i, String str, Y0 y0) {
                this.f3815a = i;
                this.b = str;
                this.c = y0;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f3815a <= 0) {
                    v.this.x.c(this.b);
                } else {
                    Log.d(v.this.c, "onRVInitSuccess()");
                    v.this.x.a(C3230o8.e.RewardedVideo, this.b, this.c);
                }
            }
        }

        class s implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3816a;

            s(String str) {
                this.f3816a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    v.this.M.a(new JSONObject(this.f3816a), r.this.new w());
                } catch (Exception e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                    Logger.i(v.this.c, "fileSystemAPI failed with exception " + e.getMessage());
                }
            }
        }

        class t implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3817a;
            final /* synthetic */ String b;
            final /* synthetic */ int c;

            t(String str, String str2, int i) {
                this.f3817a = str;
                this.b = str2;
                this.c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f3817a.equalsIgnoreCase(C3230o8.e.RewardedVideo.toString())) {
                    v.this.x.a(this.b, this.c);
                }
            }
        }

        class u implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3818a;
            final /* synthetic */ int b;

            u(String str, int i) {
                this.f3818a = str;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.y.onInterstitialAdRewarded(this.f3818a, this.b);
            }
        }

        /* renamed from: com.ironsource.sdk.controller.v$r$v, reason: collision with other inner class name */
        class RunnableC0304v implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3819a;
            final /* synthetic */ String b;

            RunnableC0304v(String str, String str2) {
                this.f3819a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f3819a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.c, "onRVInitFail(message:" + str + ")");
                v.this.x.a(C3230o8.e.RewardedVideo, this.b, str);
            }
        }

        public r() {
        }

        private void a(JSONObject jSONObject) {
            try {
                jSONObject.put("controllerSourceData", v.this.B.f());
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                Logger.d(v.this.c, "Unable to add controller source data into controllerConfig");
            }
        }

        private void b(JSONObject jSONObject) {
            try {
                FeaturesManager featuresManager = FeaturesManager.getInstance();
                if (featuresManager.a().isEmpty()) {
                    return;
                }
                jSONObject.put(C3040d4.a.h, new JSONArray((Collection) featuresManager.a()));
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                C3348v8.a(Md.p, new C3264q8().a(D5.A, e2.getMessage()).a());
                Logger.d(v.this.c, "getControllerConfig Error while adding supported features data from FeaturesManager");
            }
        }

        private void c(JSONObject jSONObject) {
            b(jSONObject);
            a(jSONObject, SDKUtils.getTesterParameters());
            if (v.this.W) {
                return;
            }
            a(jSONObject);
        }

        @JavascriptInterface
        public void adClicked(String str) {
            Logger.i(v.this.c, "adClicked(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d(C3040d4.h.m);
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                return;
            }
            C3230o8.e g2 = v.this.g(d2);
            InterfaceC3327u4 a2 = v.this.a(g2);
            if (g2 == null || a2 == null) {
                return;
            }
            v.this.b(new d(a2, g2, fetchDemandSourceId));
        }

        @JavascriptInterface
        public void adCredited(String str) {
            Log.d(v.this.d, "adCredited(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d(C3040d4.h.k);
            int parseInt = d2 != null ? Integer.parseInt(d2) : 0;
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            String d3 = nd.d(C3040d4.h.m);
            if (TextUtils.isEmpty(d3)) {
                Log.d(v.this.d, "adCredited | product type is missing");
            }
            if (C3230o8.e.Interstitial.toString().equalsIgnoreCase(d3)) {
                a(fetchDemandSourceId, parseInt);
            } else if (v.this.q(d3)) {
                v.this.b(new t(d3, fetchDemandSourceId, parseInt));
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String str) {
            Logger.i(v.this.c, "adUnitsReady(" + str + ")");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new Nd(str));
            Y0 y0 = new Y0(str);
            if (!y0.g()) {
                v.this.a(str, false, C3040d4.c.r, (String) null);
                return;
            }
            v.this.a(str, true, (String) null, (String) null);
            String d2 = y0.d();
            if (C3230o8.e.RewardedVideo.toString().equalsIgnoreCase(d2) && v.this.q(d2)) {
                v.this.b(new RunnableC0303r(Integer.parseInt(y0.c()), fetchDemandSourceId, y0));
            }
        }

        @JavascriptInterface
        public void adViewAPI(String str) {
            try {
                Logger.i(v.this.c, "adViewAPI(" + str + ")");
                v.this.L.a(new Nd(str).toString(), new w());
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "adViewAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void androidSandboxApi(final String str) {
            R7.f3025a.b(new Runnable() { // from class: com.ironsource.sdk.controller.v$r$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    v.r.this.b(str);
                }
            });
        }

        @JavascriptInterface
        public void bannerViewAPI(String str) {
            Logger.i(v.this.c, "bannerViewAPI is not supported in this native version, only adview API");
        }

        @JavascriptInterface
        public void cleanAdInstance(String str) {
            C3230o8.e g2;
            try {
                Logger.i(v.this.c, "cleanAdInstance(" + str + ")");
                Nd nd = new Nd(str);
                String d2 = nd.d(C3040d4.h.m);
                String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
                if (TextUtils.isEmpty(fetchDemandSourceId) || (g2 = v.this.g(d2)) == null) {
                    return;
                }
                v.this.G.b(g2, fetchDemandSourceId);
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void clearLastUpdateTimeData(String str) {
            try {
                ArrayList<String> a2 = R9.e().a();
                Nd nd = new Nd(str);
                if (!a2.isEmpty()) {
                    nd.b(C3040d4.h.x0, a2.toString());
                }
                v.this.a(nd.toString(), true, (String) null, (String) null);
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        void d(String str) {
            v.this.i(v.this.a(C3040d4.g.e, str, (String) null, (String) null));
        }

        @JavascriptInterface
        public void deleteFile(String str) {
            try {
                Logger.i(v.this.c, "deleteFile(" + str + ")");
                Nd nd = new Nd(str);
                String d2 = nd.d(C3040d4.h.b);
                String d3 = nd.d("path");
                if (d3 != null && !TextUtils.isEmpty(d2)) {
                    C3382x8 c3382x8 = new C3382x8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, d3), d2);
                    IronSourceStorageUtils.ensurePathSafety(c3382x8, v.this.A);
                    if (!c3382x8.exists()) {
                        v.this.a(str, false, C3040d4.c.f, "1");
                        return;
                    } else {
                        v.this.a(str, IronSourceStorageUtils.deleteFile(c3382x8), (String) null, (String) null);
                        return;
                    }
                }
                v.this.a(str, false, C3040d4.c.g, "1");
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void deleteFolder(String str) {
            try {
                Logger.i(v.this.c, "deleteFolder(" + str + ")");
                String d2 = new Nd(str).d("path");
                if (d2 == null) {
                    v.this.a(str, false, C3040d4.c.g, "1");
                    return;
                }
                C3382x8 c3382x8 = new C3382x8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, d2));
                IronSourceStorageUtils.ensurePathSafety(c3382x8, v.this.A);
                if (!c3382x8.exists()) {
                    v.this.a(str, false, C3040d4.c.e, "1");
                } else {
                    v.this.a(str, IronSourceStorageUtils.deleteFolder(c3382x8.getPath()), (String) null, (String) null);
                }
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void deviceDataAPI(String str) {
            try {
                Logger.i(v.this.c, "deviceDataAPI(" + str + ")");
                v.this.K.a(new Nd(str).toString(), new w());
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "deviceDataAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void displayWebView(String str) {
            Logger.i(v.this.c, "displayWebView(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
            Nd nd = new Nd(str);
            boolean booleanValue = ((Boolean) nd.b("display")).booleanValue();
            String d2 = nd.d(C3040d4.h.m);
            boolean c2 = nd.c(C3040d4.h.u);
            String d3 = nd.d("adViewId");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            boolean c3 = nd.c(C3040d4.h.z0);
            if (!booleanValue) {
                v.this.a(u.Gone);
                v.this.n();
                return;
            }
            v.this.F = nd.c(C3040d4.h.v);
            boolean c4 = nd.c(C3040d4.h.y);
            u u2 = v.this.u();
            u uVar = u.Display;
            if (u2 == uVar) {
                Logger.i(v.this.c, "State: " + v.this.v);
                return;
            }
            v.this.a(uVar);
            Logger.i(v.this.c, "State: " + v.this.v);
            Context p2 = v.this.p();
            String s2 = v.this.s();
            int K = v.this.X.K(p2);
            if (c2) {
                com.ironsource.sdk.controller.h hVar = new com.ironsource.sdk.controller.h(p2);
                hVar.addView(v.this.u);
                hVar.a(v.this);
                return;
            }
            Intent intent = c4 ? new Intent(p2, (Class<?>) InterstitialActivity.class) : new Intent(p2, (Class<?>) ControllerActivity.class);
            C3230o8.e eVar = C3230o8.e.RewardedVideo;
            if (eVar.toString().equalsIgnoreCase(d2)) {
                if ("application".equals(s2)) {
                    s2 = SDKUtils.translateRequestedOrientation(v.this.X.N(p2));
                }
                intent.putExtra(C3040d4.h.m, eVar.toString());
                v.this.D.a(eVar.ordinal());
                v.this.D.f(fetchDemandSourceId);
                if (v.this.q(eVar.toString())) {
                    v.this.x.c(eVar, fetchDemandSourceId);
                }
            } else {
                C3230o8.e eVar2 = C3230o8.e.Interstitial;
                if (eVar2.toString().equalsIgnoreCase(d2)) {
                    if ("application".equals(s2)) {
                        s2 = SDKUtils.translateRequestedOrientation(v.this.X.N(p2));
                    }
                    intent.putExtra(C3040d4.h.m, eVar2.toString());
                }
            }
            if (d3 != null) {
                intent.putExtra("adViewId", d3);
            }
            intent.putExtra(C3040d4.h.z0, c3);
            intent.setFlags(536870912);
            intent.putExtra(C3040d4.h.v, v.this.F);
            intent.putExtra(C3040d4.h.A, s2);
            intent.putExtra(C3040d4.h.B, K);
            v vVar = v.this;
            vVar.j = new p(vVar.g(d2), fetchDemandSourceId);
            p2.startActivity(intent);
        }

        @JavascriptInterface
        public void dsSharedSignalsAPI(String str) {
            try {
                Logger.i(v.this.c, "dsSharedSignalsAPI(" + str + ")");
                v.this.O.a(new Nd(str).toString(), new w());
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "dsSharedSignalsAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void fileSystemAPI(String str) {
            Logger.i(v.this.c, "fileSystemAPI(" + str + ")");
            v.this.a(new s(str));
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005b, code lost:
        
            if (android.text.TextUtils.isEmpty(r0) == false) goto L11;
         */
        @JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void getApplicationInfo(String str) {
            Logger.i(v.this.c, "getApplicationInfo(" + str + ")");
            String e2 = v.this.e(str);
            String d2 = v.this.d(str);
            Nd nd = new Nd(str);
            Object[] f2 = v.this.f(nd.d(C3040d4.h.m), SDKUtils.fetchDemandSourceId(nd));
            String str2 = (String) f2[0];
            if (((Boolean) f2[1]).booleanValue()) {
                if (!TextUtils.isEmpty(d2)) {
                    e2 = d2;
                }
                e2 = null;
            }
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            v.this.i(v.this.a(e2, str2, C3040d4.g.n, C3040d4.g.o));
        }

        @JavascriptInterface
        public void getCachedFilesMap(String str) {
            Logger.i(v.this.c, "getCachedFilesMap(" + str + ")");
            String e2 = v.this.e(str);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            Nd nd = new Nd(str);
            if (!nd.a("path")) {
                v.this.a(str, false, C3040d4.c.s, (String) null);
                return;
            }
            String str2 = (String) nd.b("path");
            if (!IronSourceStorageUtils.isPathExist(v.this.A, str2)) {
                v.this.a(str, false, C3040d4.c.t, (String) null);
                return;
            }
            v.this.i(v.this.a(e2, IronSourceStorageUtils.getCachedFilesMap(v.this.A, str2), C3040d4.g.s, C3040d4.g.r));
        }

        @JavascriptInterface
        public void getConnectivityInfo(String str) {
            String e2;
            Logger.i(v.this.c, "getConnectivityInfo(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d(v.g0);
            String d3 = nd.d(v.h0);
            JSONObject jSONObject = new JSONObject();
            v vVar = v.this;
            X3 x3 = vVar.R;
            if (x3 != null) {
                jSONObject = x3.a(vVar.Z.getContext());
            }
            if (jSONObject.length() > 0) {
                e2 = v.this.e(d2, jSONObject.toString());
            } else {
                e2 = v.this.e(d3, v.this.a("errMsg", C3040d4.c.A, null, null, null, null, null, null, null, false));
            }
            v.this.i(e2);
        }

        @JavascriptInterface
        public void getControllerConfig(String str) {
            Logger.i(v.this.c, "getControllerConfig(" + str + ")");
            String d2 = new Nd(str).d(v.g0);
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
            c(controllerConfigAsJSONObject);
            v.this.i(v.this.e(d2, controllerConfigAsJSONObject.toString()));
        }

        @JavascriptInterface
        public void getDemandSourceState(String str) {
            String d2;
            Logger.i(v.this.c, "getMediationState(" + str + ")");
            Nd nd = new Nd(str);
            String d3 = nd.d("demandSourceName");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            String d4 = nd.d(C3040d4.h.m);
            if (d4 == null || d3 == null) {
                return;
            }
            try {
                C3230o8.e productType = SDKUtils.getProductType(d4);
                if (productType != null) {
                    V4 a2 = v.this.G.a(productType, fetchDemandSourceId);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C3040d4.h.m, d4);
                    jSONObject.put("demandSourceName", d3);
                    jSONObject.put("demandSourceId", fetchDemandSourceId);
                    if (a2 == null || a2.a(-1)) {
                        d2 = v.this.d(str);
                    } else {
                        d2 = v.this.e(str);
                        jSONObject.put("state", a2.j());
                    }
                    a(d2, jSONObject.toString());
                }
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
        
            if (android.text.TextUtils.isEmpty(r0) == false) goto L11;
         */
        @JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void getDeviceStatus(String str) {
            Logger.i(v.this.c, "getDeviceStatus(" + str + ")");
            String e2 = v.this.e(str);
            String d2 = v.this.d(str);
            v vVar = v.this;
            Object[] d3 = vVar.d(vVar.Z.getContext());
            String str2 = (String) d3[0];
            if (((Boolean) d3[1]).booleanValue()) {
                if (!TextUtils.isEmpty(d2)) {
                    e2 = d2;
                }
                e2 = null;
            }
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            v.this.i(v.this.a(e2, str2, C3040d4.g.l, C3040d4.g.m));
        }

        @JavascriptInterface
        public void getDeviceVolume(String str) {
            Logger.i(v.this.c, "getDeviceVolume(" + str + ")");
            try {
                Context context = v.this.Z.getContext();
                float a2 = Z4.b(context).a(context);
                Nd nd = new Nd(str);
                nd.b(C3040d4.i.P, String.valueOf(a2));
                v.this.a(nd.toString(), true, (String) null, (String) null);
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void getInitSummery(String str) {
            Logger.i(v.this.c, "getInitSummery(" + str + ")");
            Nd nd = new Nd(str);
            nd.a(C3040d4.i.r0, v.this.S);
            v.this.a(nd.toString(), true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void getOrientation(String str) {
            C3348v8.a(Md.z, new C3264q8().a(D5.y, str).a());
            String e2 = v.this.e(str);
            String jSONObject = SDKUtils.getOrientation(v.this.Z.getContext()).toString();
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            v.this.i(v.this.a(e2, jSONObject, C3040d4.g.X, C3040d4.g.Y));
        }

        @JavascriptInterface
        public void getUserData(String str) {
            Logger.i(v.this.c, "getUserData(" + str + ")");
            Nd nd = new Nd(str);
            if (!nd.a(C3040d4.h.W)) {
                v.this.a(str, false, C3040d4.c.F, (String) null);
                return;
            }
            String e2 = v.this.e(str);
            String d2 = nd.d(C3040d4.h.W);
            v.this.i(v.this.e(e2, v.this.a(d2, R9.e().a(d2), null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void iabTokenAPI(String str) {
            try {
                Logger.i(v.this.c, "iabTokenAPI(" + str + ")");
                v.this.J.a(new Nd(str).toString(), new w());
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "iabTokenAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void initController(String str) {
            Logger.i(v.this.c, "initController(" + str + ")");
            Nd nd = new Nd(str);
            CountDownTimer countDownTimer = v.this.m;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                v.this.m = null;
            }
            if (nd.a(C3040d4.h.q)) {
                String d2 = nd.d(C3040d4.h.q);
                if (C3040d4.h.s.equalsIgnoreCase(d2)) {
                    v vVar = v.this;
                    vVar.i = true;
                    vVar.Q.d();
                } else if (C3040d4.h.r.equalsIgnoreCase(d2)) {
                    v.this.Q.c();
                } else if (!C3040d4.h.t.equalsIgnoreCase(d2)) {
                    Logger.i(v.this.c, "No STAGE mentioned! should not get here!");
                } else {
                    v.this.Q.c("controller js failed to initialize : " + nd.d("errMsg"));
                }
            }
        }

        @JavascriptInterface
        public void omidAPI(String str) {
            v.this.c(new n(str));
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String str) {
            Logger.i(v.this.c, "onAdWindowsClosed(" + str + ")");
            v.this.D.a();
            v.this.D.f(null);
            v.this.j = null;
            Nd nd = new Nd(str);
            String d2 = nd.d(C3040d4.h.m);
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            C3230o8.e g2 = v.this.g(d2);
            Log.d(v.this.d, "onAdClosed() with type " + g2);
            if (v.this.q(d2)) {
                v.this.a(g2, fetchDemandSourceId);
            }
        }

        @JavascriptInterface
        public void onCleanUpNonDisplayBannersSuccess(String str) {
            Logger.i(v.this.c, "onCleanUpNonDisplayBannersSuccess() value=" + str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String str) {
            Logger.i(v.this.c, "onGetApplicationInfoFail(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String str) {
            Logger.i(v.this.c, "onGetApplicationInfoSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String str) {
            Logger.i(v.this.c, "onGetCachedFilesMapFail(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String str) {
            Logger.i(v.this.c, "onGetCachedFilesMapSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String str) {
            Logger.i(v.this.c, "onGetDeviceStatusFail(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String str) {
            Logger.i(v.this.c, "onGetDeviceStatusSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitBannerFail(String str) {
            Logger.i(v.this.c, "onInitBannerFail(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(v.this.c, "onInitBannerFail failed with no demand source");
                return;
            }
            W4 w4 = v.this.G;
            C3230o8.e eVar = C3230o8.e.Banner;
            V4 a2 = w4.a(eVar, fetchDemandSourceId);
            if (a2 != null) {
                a2.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new h(d2, fetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String str) {
            Logger.i(v.this.c, "onInitBannerSuccess()");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new Nd(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(v.this.c, "onInitBannerSuccess failed with no demand source");
            } else if (v.this.q(C3230o8.e.Banner.toString())) {
                v.this.b(new g(fetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String str) {
            Logger.i(v.this.c, "onInitInterstitialFail(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(v.this.c, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            W4 w4 = v.this.G;
            C3230o8.e eVar = C3230o8.e.Interstitial;
            V4 a2 = w4.a(eVar, fetchDemandSourceId);
            if (a2 != null) {
                a2.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new c(d2, fetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String str) {
            Logger.i(v.this.c, "onInitInterstitialSuccess()");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new Nd(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(v.this.c, "onInitInterstitialSuccess failed with no demand source");
            } else if (v.this.q(C3230o8.e.Interstitial.toString())) {
                v.this.b(new b(fetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String str) {
            Logger.i(v.this.c, "onInitRewardedVideoFail(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            W4 w4 = v.this.G;
            C3230o8.e eVar = C3230o8.e.RewardedVideo;
            V4 a2 = w4.a(eVar, fetchDemandSourceId);
            if (a2 != null) {
                a2.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new RunnableC0304v(d2, fetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onLoadBannerFail(String str) {
            Logger.i(v.this.c, "onLoadBannerFail()");
            Nd nd = new Nd(str);
            String d2 = nd.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            v.this.a(str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(fetchDemandSourceId) && v.this.q(C3230o8.e.Banner.toString())) {
                v.this.b(new j(d2, fetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String str) {
            Logger.i(v.this.c, "onLoadBannerSuccess()");
            Nd nd = new Nd(str);
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            String d2 = nd.d("adViewId");
            v.this.a(str, true, (String) null, (String) null);
            F8 a2 = C3179l8.a().a(d2);
            if (a2 == null) {
                v.this.z.c(fetchDemandSourceId, "not found view for the current adViewId= " + d2);
            } else if (a2 instanceof C3078f8) {
                C3078f8 c3078f8 = (C3078f8) a2;
                if (v.this.q(C3230o8.e.Banner.toString())) {
                    v.this.b(new i(fetchDemandSourceId, c3078f8));
                }
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String str) {
            Logger.i(v.this.c, "onLoadInterstitialFail(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            v.this.a(str, true, (String) null, (String) null);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                return;
            }
            a(fetchDemandSourceId, false);
            if (v.this.q(C3230o8.e.Interstitial.toString())) {
                v.this.b(new f(d2, fetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String str) {
            Logger.i(v.this.c, "onLoadInterstitialSuccess(" + str + ")");
            Nd nd = new Nd(str);
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            JSONObject a2 = nd.a();
            a(fetchDemandSourceId, true);
            v.this.a(str, true, (String) null, (String) null);
            if (v.this.q(C3230o8.e.Interstitial.toString())) {
                v.this.b(new e(fetchDemandSourceId, a2));
            }
        }

        @JavascriptInterface
        public void onReceivedMessage(String str) {
            Logger.i(v.this.c, "onReceivedMessage(" + str + ")");
            R7.f3025a.b(new l(str));
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String str) {
            Logger.i(v.this.c, "onShowInterstitialFail(" + str + ")");
            Nd nd = new Nd(str);
            final String d2 = nd.d("errMsg");
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            v.this.a(str, true, (String) null, (String) null);
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                return;
            }
            final boolean q2 = v.this.q(C3230o8.e.Interstitial.toString());
            v.this.b(new Runnable() { // from class: com.ironsource.sdk.controller.v$r$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    v.r.this.a(q2, d2, fetchDemandSourceId);
                }
            });
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String str) {
            Logger.i(v.this.c, "onShowInterstitialSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
            final String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(new Nd(str));
            if (TextUtils.isEmpty(fetchDemandSourceId)) {
                Logger.i(v.this.c, "onShowInterstitialSuccess called with no demand");
                return;
            }
            Z0 z0 = v.this.D;
            C3230o8.e eVar = C3230o8.e.Interstitial;
            z0.a(eVar.ordinal());
            v.this.D.f(fetchDemandSourceId);
            final boolean q2 = v.this.q(eVar.toString());
            v.this.b(new Runnable() { // from class: com.ironsource.sdk.controller.v$r$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    v.r.this.a(q2, fetchDemandSourceId);
                }
            });
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String str) {
            Logger.i(v.this.c, "onShowRewardedVideoFail(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d("errMsg");
            String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
            if (v.this.q(C3230o8.e.RewardedVideo.toString())) {
                v.this.b(new a(d2, fetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String str) {
            Logger.i(v.this.c, "onShowRewardedVideoSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String str) {
            Log.d(v.this.c, "onVideoStatusChanged(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d(C3040d4.h.m);
            if (v.this.C == null || TextUtils.isEmpty(d2)) {
                return;
            }
            String d3 = nd.d("status");
            if (C3040d4.h.d0.equalsIgnoreCase(d3)) {
                v.this.C.onVideoStarted();
                return;
            }
            if (C3040d4.h.e0.equalsIgnoreCase(d3)) {
                v.this.C.onVideoPaused();
                return;
            }
            if (C3040d4.h.f0.equalsIgnoreCase(d3)) {
                v.this.C.onVideoResumed();
                return;
            }
            if (C3040d4.h.g0.equalsIgnoreCase(d3)) {
                v.this.C.onVideoEnded();
            } else if (C3040d4.h.h0.equalsIgnoreCase(d3)) {
                v.this.C.onVideoStopped();
            } else {
                Logger.i(v.this.c, "onVideoStatusChanged: unknown status: " + d3);
            }
        }

        @JavascriptInterface
        public void openUrl(String str) {
            try {
                Logger.i(v.this.c, "openUrl(" + str + ")");
                Nd nd = new Nd(str);
                p.c a2 = new p.a(nd.d("method"), new Cc(v.this.F, C.ENCODING_PCM_32BIT)).a(nd.c(C3040d4.h.L0) ? v.this.Z.getContext() : v.this.p(), new Bc(nd.d("url"), nd.d("package_name")));
                if (a2 instanceof p.c.a) {
                    v.this.a(str, false, ((p.c.a) a2).b(), (String) null);
                } else {
                    v.this.a(str, true, (String) null, (String) null);
                }
            } catch (Exception e2) {
                v.this.a(str, false, e2.getLocalizedMessage(), (String) null);
            }
        }

        @JavascriptInterface
        public void pauseControllerWebview() {
            v.this.c(new o());
        }

        @JavascriptInterface
        public void permissionsAPI(String str) {
            try {
                Logger.i(v.this.c, "permissionsAPI(" + str + ")");
                v.this.I.a(new Nd(str).toString(), new w());
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "permissionsAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String str) {
            Exception exc;
            String str2;
            try {
                Logger.i(v.this.c, "postAdEventNotification(" + str + ")");
                Nd nd = new Nd(str);
                String d2 = nd.d(C3040d4.h.j0);
                try {
                    if (TextUtils.isEmpty(d2)) {
                        v.this.a(str, false, C3040d4.c.w, (String) null);
                        return;
                    }
                    String d3 = nd.d(C3040d4.h.k0);
                    String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(nd);
                    String str3 = !TextUtils.isEmpty(fetchDemandSourceId) ? fetchDemandSourceId : d3;
                    JSONObject jSONObject = (JSONObject) nd.b(C3040d4.h.l0);
                    String d4 = nd.d(C3040d4.h.m);
                    C3230o8.e g2 = v.this.g(d4);
                    try {
                        if (!v.this.q(d4)) {
                            v.this.a(str, false, C3040d4.c.v, (String) null);
                            return;
                        }
                        String e2 = v.this.e(str);
                        if (TextUtils.isEmpty(e2)) {
                            str2 = str3;
                        } else {
                            str2 = str3;
                            v.this.i(v.this.a(e2, v.this.a(C3040d4.h.m, d4, C3040d4.h.j0, d2, "demandSourceName", d3, "demandSourceId", str2, null, false), C3040d4.g.c0, C3040d4.g.d0));
                        }
                        try {
                            v.this.b(new m(g2, str2, d2, jSONObject));
                        } catch (Exception e3) {
                            e = e3;
                            exc = e;
                            C3260q4.d().a(exc);
                            IronLog.INTERNAL.error(exc.toString());
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                } catch (Exception e5) {
                    exc = e5;
                    C3260q4.d().a(exc);
                    IronLog.INTERNAL.error(exc.toString());
                }
            } catch (Exception e6) {
                e = e6;
            }
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String str) {
            Logger.i(v.this.c, "removeCloseEventHandler(" + str + ")");
            CountDownTimer countDownTimer = v.this.l;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            v.this.k = true;
        }

        @JavascriptInterface
        public void removeMessagingInterface(String str) {
            v.this.c(new p());
        }

        @JavascriptInterface
        public void requestToDestroyBanner(String str) {
            Logger.i(v.this.c, "onCleanUpNonDisplayBannersFail() value=" + str);
        }

        @JavascriptInterface
        public void resumeControllerWebview() {
            v.this.c(new k());
        }

        @JavascriptInterface
        public void saveFile(String str) {
            try {
                Logger.i(v.this.c, "saveFile(" + str + ")");
                Nd nd = new Nd(str);
                String d2 = nd.d("path");
                String d3 = nd.d(C3040d4.h.b);
                if (TextUtils.isEmpty(d3)) {
                    v.this.a(str, false, C3040d4.c.g, "1");
                    return;
                }
                C3382x8 c3382x8 = new C3382x8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, d2), SDKUtils.getFileName(d3));
                IronSourceStorageUtils.ensurePathSafety(c3382x8, v.this.A);
                v vVar = v.this;
                if (vVar.X.a(vVar.A) <= 0) {
                    v.this.a(str, false, C3074f4.A, (String) null);
                    return;
                }
                if (c3382x8.exists()) {
                    v.this.a(str, false, C3074f4.z, (String) null);
                    return;
                }
                if (!Z3.h(v.this.Z.getContext())) {
                    v.this.a(str, false, C3074f4.C, (String) null);
                    return;
                }
                v.this.a(str, true, (String) null, (String) null);
                v.this.h.a(c3382x8, d3, nd.a("connectionTimeout", 0), nd.a("readTimeout", 0));
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void setBackButtonState(String str) {
            Logger.i(v.this.c, "setBackButtonState(" + str + ")");
            R9.e().c(new Nd(str).d("state"));
        }

        @JavascriptInterface
        public void setForceClose(String str) {
            Logger.i(v.this.c, "setForceClose(" + str + ")");
            Nd nd = new Nd(str);
            String d2 = nd.d("width");
            String d3 = nd.d("height");
            v.this.n = Integer.parseInt(d2);
            v.this.o = Integer.parseInt(d3);
            v.this.p = nd.d(C3040d4.h.L);
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String str) {
            Logger.i(v.this.c, "setMixedContentAlwaysAllow(" + str + ")");
            v.this.c(new q());
        }

        @JavascriptInterface
        public void setOrientation(String str) {
            try {
                Logger.i(v.this.c, "setOrientation(" + str + ")");
                String d2 = new Nd(str).d("orientation");
                v.this.n(d2);
                v vVar = v.this;
                if (vVar.a0 != null) {
                    v.this.a0.onOrientationChanged(d2, vVar.X.K(vVar.Z.getContext()));
                }
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String str) {
            Logger.i(v.this.c, "setStoreSearchKeys(" + str + ")");
            R9.e().e(str);
        }

        @JavascriptInterface
        public void setUserData(String str) {
            Logger.i(v.this.c, "setUserData(" + str + ")");
            Nd nd = new Nd(str);
            if (!nd.a(C3040d4.h.W)) {
                v.this.a(str, false, C3040d4.c.F, (String) null);
                return;
            }
            if (!nd.a("value")) {
                v.this.a(str, false, C3040d4.c.G, (String) null);
                return;
            }
            String d2 = nd.d(C3040d4.h.W);
            String d3 = nd.d("value");
            R9.e().a(d2, d3);
            v.this.i(v.this.e(v.this.e(str), v.this.a(d2, d3, null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String str) {
            Logger.i(v.this.c, "setWebviewBackgroundColor(" + str + ")");
            v.this.p(str);
        }

        @JavascriptInterface
        public void stillAlive(String str) {
            Logger.i(v.this.c, "stillAlive(" + str + ")");
            v.this.b.a();
        }

        public class w implements InterfaceC2992aa {
            public w() {
            }

            @Override // com.ironsource.InterfaceC2992aa
            public void a(boolean z, String str, String str2) {
                Nd nd = new Nd();
                nd.b(z ? v.g0 : v.h0, str);
                nd.b("data", str2);
                v.this.a(nd.toString(), z, (String) null, (String) null);
            }

            @Override // com.ironsource.InterfaceC2992aa
            public void a(boolean z, String str, Nd nd) {
                nd.b(z ? v.g0 : v.h0, str);
                v.this.a(nd.toString(), z, (String) null, (String) null);
            }

            @Override // com.ironsource.InterfaceC2992aa
            public void a(boolean z, String str, JSONObject jSONObject) {
                String str2;
                try {
                    if (z) {
                        str2 = v.g0;
                    } else {
                        str2 = v.h0;
                    }
                    jSONObject.put(str2, str);
                    v.this.a(jSONObject.toString(), z, (String) null, (String) null);
                } catch (JSONException e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }

        private void a(JSONObject jSONObject, String str) {
            if (a(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt("testerABGroup", jSONObject2.get("testerABGroup"));
                    jSONObject.putOpt("testFriendlyName", jSONObject2.get("testFriendlyName"));
                } catch (JSONException e2) {
                    C3260q4.d().a(e2);
                    Logger.d(v.this.c, "getControllerConfig Error while parsing Tester AB Group parameters");
                }
            }
        }

        void c(String str) {
            v.this.i(v.this.a(C3040d4.g.d, str, (String) null, (String) null));
        }

        boolean a(String str) {
            if (TextUtils.isEmpty(str) || str.contains(Y1.f)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getString("testerABGroup").isEmpty()) {
                    return false;
                }
                return !jSONObject.getString("testFriendlyName").isEmpty();
            } catch (JSONException e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            try {
                InterfaceC3307t1 a2 = InterfaceC3307t1.a(str);
                v vVar = v.this;
                C3273r1.a a3 = vVar.N.a(vVar.Z.getContext(), a2);
                v.this.i(v.this.e(a3.f(), a3.i().toString()));
            } catch (Exception e2) {
                C3260q4.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        private void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            v.this.i(v.this.e(str, str2));
        }

        private void a(String str, int i2) {
            V4 a2;
            v vVar = v.this;
            C3230o8.e eVar = C3230o8.e.Interstitial;
            if (vVar.q(eVar.toString()) && (a2 = v.this.G.a(eVar, str)) != null && a2.k()) {
                v.this.b(new u(str, i2));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z, String str) {
            if (z) {
                v.this.y.c(C3230o8.e.Interstitial, str);
                v.this.y.b(str);
            }
            a(str, false);
        }

        private void a(String str, boolean z) {
            V4 a2 = v.this.G.a(C3230o8.e.Interstitial, str);
            if (a2 != null) {
                a2.a(z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z, String str, String str2) {
            if (z) {
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.y.d(str2, str);
            }
            a(str2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        return new Nd(str).d(g0);
    }

    public void e(JSONObject jSONObject) {
        Logger.i(this.c, "device connection info changed: " + jSONObject.toString());
        i(e(C3040d4.g.y, a(C3040d4.i.h0, jSONObject.toString(), null, null, null, null, null, null, null, false)));
    }

    public void b(int i2) {
        c0 = i2;
    }

    private void o(String str) {
        if (str.equalsIgnoreCase("0")) {
            this.Z.getSettings().setCacheMode(2);
        } else {
            this.Z.getSettings().setCacheMode(-1);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(V4 v4, Map<String, String> map, InterfaceC3361w4 interfaceC3361w4) {
        a(v4, map);
    }

    com.ironsource.sdk.controller.g a(com.ironsource.sdk.controller.s sVar) {
        return new com.ironsource.sdk.controller.g(new com.ironsource.sdk.controller.b(new r()), sVar);
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(V4 v4) {
        Map<String, String> b2 = v4.b();
        if (b2 != null) {
            i(e(C3040d4.g.T, SDKUtils.flatMapToJsonAsString(b2)));
        }
        this.G.b(C3230o8.e.Interstitial, v4.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C3230o8.e g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C3230o8.e eVar = C3230o8.e.Interstitial;
        if (str.equalsIgnoreCase(eVar.toString())) {
            return eVar;
        }
        C3230o8.e eVar2 = C3230o8.e.RewardedVideo;
        if (str.equalsIgnoreCase(eVar2.toString())) {
            return eVar2;
        }
        C3230o8.e eVar3 = C3230o8.e.Banner;
        if (str.equalsIgnoreCase(eVar3.toString())) {
            return eVar3;
        }
        return null;
    }

    public void a(com.ironsource.sdk.controller.o oVar) {
        this.H = oVar;
    }

    public Context p() {
        return this.Y.a();
    }

    private String d(JSONObject jSONObject) {
        Z4 b2 = Z4.b(this.Z.getContext());
        StringBuilder sb = new StringBuilder();
        String sDKVersion = SDKUtils.getSDKVersion();
        if (!TextUtils.isEmpty(sDKVersion)) {
            sb.append("SDKVersion=").append(sDKVersion).append(C3040d4.i.c);
        }
        String e2 = b2.e();
        if (!TextUtils.isEmpty(e2)) {
            sb.append("deviceOs=").append(e2);
        }
        Uri parse = Uri.parse(SDKUtils.getControllerUrl());
        if (parse != null) {
            String str = parse.getScheme() + ":";
            String host = parse.getHost();
            int port = parse.getPort();
            if (port != -1) {
                host = host + ":" + port;
            }
            sb.append("&protocol=").append(str);
            sb.append("&domain=").append(host);
            if (jSONObject.keys().hasNext()) {
                try {
                    String jSONObject2 = new JSONObject(jSONObject, new String[]{C3040d4.i.Z, C3040d4.i.g}).toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        sb.append(C3040d4.i.c).append("controllerConfig").append(C3040d4.i.b).append(jSONObject2);
                    }
                } catch (JSONException e3) {
                    C3260q4.d().a(e3);
                    IronLog.INTERNAL.error(e3.toString());
                }
            }
            sb.append("&debug=").append(q());
        }
        return sb.toString();
    }

    public void a(com.ironsource.sdk.controller.q qVar) {
        this.I = qVar;
    }

    public void a(com.ironsource.sdk.controller.u uVar) {
        this.J = uVar;
    }

    public void a(com.ironsource.sdk.controller.i iVar) {
        this.K = iVar;
    }

    private void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put(SDKUtils.encodeString("gpi"), Lc.d(this.Z.getContext()));
    }

    public void a(com.ironsource.sdk.controller.a aVar) {
        this.L = aVar;
        aVar.a(o());
    }

    public void a(com.ironsource.sdk.controller.j jVar) {
        this.M = jVar;
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(JSONObject jSONObject) {
        i(e(C3040d4.g.e0, jSONObject != null ? jSONObject.toString() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(C3382x8 c3382x8) {
        this.h.a(this);
        if (c3382x8 != null && c3382x8.exists()) {
            a(c3382x8);
            return null;
        }
        a(new C3382x8(C3040d4.f), new C3247p8(1, "Unable to download Html file"));
        return null;
    }

    public void a(C3273r1 c3273r1) {
        this.N = c3273r1;
    }

    @Override // com.ironsource.sdk.controller.l
    public void g() {
        i(f(C3040d4.g.u));
    }

    private void a(Context context, WebView webView) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.u = new FrameLayout(context);
        this.s = new FrameLayout(context);
        this.s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.s.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(webView);
        this.u.addView(this.s, layoutParams);
        this.u.addView(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        try {
            X3 x3 = this.R;
            if (x3 == null) {
                return;
            }
            x3.b(context);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    private String b(String str) {
        String str2 = this.A + File.separator;
        return str.contains(str2) ? str.substring(str2.length()) : str;
    }

    public void b(String str, String str2, String str3) {
        try {
            try {
                i(e(C3040d4.g.q, a(C3040d4.h.b, str, "path", b(str2), "errMsg", str3, null, null, null, false)));
            } catch (Exception e2) {
                e = e2;
                C3260q4.d().a(e);
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void c(String str) {
        if (str.equals(C3040d4.h.i)) {
            n();
        }
        i(e(C3040d4.g.z, a("action", str, null, null, null, null, null, null, null, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str, String str2) {
        return new m.a(str, str2).a();
    }

    private String c(String str, String str2, String str3) {
        return new m.a(str, null, str2, str3).a();
    }

    void c(Runnable runnable) {
        R7 r7 = this.f3779a;
        if (r7 != null) {
            r7.d(runnable);
        }
    }

    private String b(String str, String str2) {
        return a(str, str2, "errMsg");
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Context context) {
        a(new c(context));
    }

    private void a(WebSettings webSettings) {
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    void b(Runnable runnable) {
        R7 r7 = this.f3779a;
        if (r7 != null) {
            r7.c(runnable);
        }
    }

    public void a(A4 a4) {
        this.O = a4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterfaceC3327u4 a(C3230o8.e eVar) {
        if (eVar == C3230o8.e.Interstitial) {
            return this.y;
        }
        if (eVar == C3230o8.e.RewardedVideo) {
            return this.x;
        }
        if (eVar == C3230o8.e.Banner) {
            return this.z;
        }
        return null;
    }

    public void a(Xf xf) {
        this.C = xf;
    }

    public void a(int i2) {
        String uri;
        if (!this.W && !this.B.m()) {
            Logger.i(this.c, "load(): Mobile Controller HTML Does not exist");
            return;
        }
        JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
        String d2 = d(controllerConfigAsJSONObject);
        Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
        if (initSDKParams != null && initSDKParams.containsKey("sessionid")) {
            d2 = String.format("%s&sessionid=%s", d2, initSDKParams.get("sessionid"));
        }
        if (this.W) {
            uri = this.V.c().toURI().toString();
        } else {
            uri = this.B.g().toURI().toString();
        }
        this.f3779a.d(new h(controllerConfigAsJSONObject, this.Z, uri + "?" + d2));
        this.m = new i(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT, 1000L, i2).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        return new Nd(str).d(h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] d(Context context) {
        Z4 b2 = Z4.b(context);
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        try {
            jSONObject.put(C3040d4.i.z, "none");
            jSONObject.put(C3040d4.i.A, SDKUtils.translateDeviceOrientation(this.X.z(context)));
            String d2 = b2.d();
            if (d2 != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(d2));
            }
            String c2 = b2.c();
            if (c2 != null) {
                jSONObject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(c2));
            } else {
                z = true;
            }
            SDKUtils.loadGoogleAdvertiserInfo(context);
            String advertiserId = SDKUtils.getAdvertiserId();
            if (!TextUtils.isEmpty(advertiserId)) {
                Logger.i(this.c, "add AID");
                jSONObject.put("deviceIds[AID]", SDKUtils.encodeString(advertiserId));
            }
            String limitAdTracking = SDKUtils.getLimitAdTracking();
            if (!TextUtils.isEmpty(limitAdTracking)) {
                Logger.i(this.c, "add LAT");
                jSONObject.put(C3040d4.i.M, Boolean.parseBoolean(limitAdTracking));
            }
            String e2 = b2.e();
            if (e2 != null) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.m), SDKUtils.encodeString(e2));
            } else {
                z = true;
            }
            String f2 = b2.f();
            if (f2 != null) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.n), f2.replaceAll("[^0-9/.]", ""));
            } else {
                z = true;
            }
            String f3 = b2.f();
            if (f3 != null) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.o), SDKUtils.encodeString(f3));
            }
            String valueOf = String.valueOf(b2.a());
            if (valueOf != null) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.p), valueOf);
            } else {
                z = true;
            }
            jSONObject.put(N6.i0, String.valueOf(C3137j0.a()));
            String sDKVersion = SDKUtils.getSDKVersion();
            if (sDKVersion != null) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.q), SDKUtils.encodeString(sDKVersion));
            }
            if (b2.b() != null && b2.b().length() > 0) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.r), SDKUtils.encodeString(b2.b()));
            }
            String b3 = C2986a4.b(context);
            if (b3.equals("none")) {
                z = true;
            } else {
                jSONObject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(b3));
            }
            String d3 = C2986a4.d(context);
            if (d3 != null) {
                jSONObject.put(SDKUtils.encodeString("rawConnectionType"), SDKUtils.encodeString(d3));
            } else {
                z = true;
            }
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.v), C2986a4.e(context));
            jSONObject.put("uxt", IronSourceStorageUtils.isUxt());
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.x), SDKUtils.encodeString(language.toUpperCase(Locale.getDefault())));
            }
            jSONObject.put(C3040d4.i.y, SDKUtils.encodeString(String.valueOf(this.X.a(this.A))));
            String valueOf2 = String.valueOf(this.X.o());
            if (TextUtils.isEmpty(valueOf2)) {
                z = true;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(SDKUtils.encodeString(C3040d4.i.G)).append(C3040d4.i.d).append(SDKUtils.encodeString("width")).append(C3040d4.i.e);
                jSONObject.put(sb.toString(), SDKUtils.encodeString(valueOf2));
            }
            String valueOf3 = String.valueOf(this.X.b());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SDKUtils.encodeString(C3040d4.i.G)).append(C3040d4.i.d).append(SDKUtils.encodeString("height")).append(C3040d4.i.e);
            jSONObject.put(sb2.toString(), SDKUtils.encodeString(valueOf3));
            String g2 = C1.g(this.Z.getContext());
            if (!TextUtils.isEmpty(g2)) {
                jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(g2));
            }
            String valueOf4 = String.valueOf(this.X.r());
            if (!TextUtils.isEmpty(valueOf4)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.K), SDKUtils.encodeString(valueOf4));
            }
            String valueOf5 = String.valueOf(this.X.p());
            if (!TextUtils.isEmpty(valueOf5)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.O), SDKUtils.encodeString(valueOf5));
            }
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.P), Z4.b(context).a(context));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.Y), this.X.k(context));
            jSONObject.put(SDKUtils.encodeString("mcc"), Z3.b(context));
            jSONObject.put(SDKUtils.encodeString("mnc"), Z3.c(context));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.S), Z3.f(context));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.R), SDKUtils.encodeString(Z3.g(context)));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.V), C1.f(context));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.X), C1.d(context));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.W), SDKUtils.encodeString(C1.b(context)));
            String e3 = C1.e(context);
            if (!TextUtils.isEmpty(e3)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.c0), SDKUtils.encodeString(e3));
            }
            c(jSONObject);
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.p0), this.X.t(context));
        } catch (JSONException e4) {
            C3260q4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
        return new Object[]{jSONObject.toString(), Boolean.valueOf(z)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        try {
            X3 x3 = this.R;
            if (x3 == null) {
                return;
            }
            x3.c(context);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    private String f(String str) {
        return new m.a(str).a();
    }

    @Override // com.ironsource.sdk.controller.l
    public void f() {
        a(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, WebView webView) {
        boolean optBoolean = jSONObject.optBoolean("inspectWebview");
        if (optBoolean) {
            WebView.setWebContentsDebuggingEnabled(optBoolean);
        }
    }

    private void a(String str, C3230o8.e eVar, V4 v4, s sVar) {
        if (TextUtils.isEmpty(str)) {
            sVar.a("Application key are missing", eVar, v4);
        } else {
            i(a(eVar, v4).b);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, V4 v4, InterfaceC3378x4 interfaceC3378x4) {
        this.f = str;
        this.g = str2;
        this.x = interfaceC3378x4;
        this.D.i(str);
        this.D.j(str2);
        a(str, C3230o8.e.RewardedVideo, v4, new j());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, V4 v4, InterfaceC3361w4 interfaceC3361w4) {
        this.f = str;
        this.g = str2;
        this.y = interfaceC3361w4;
        this.D.g(str);
        this.D.h(this.g);
        a(this.f, C3230o8.e.Interstitial, v4, new k());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, InterfaceC3361w4 interfaceC3361w4) {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceName", str);
        String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
        this.D.d(str, true);
        i(a(C3040d4.g.E, flatMapToJsonAsString, C3040d4.g.F, C3040d4.g.G));
    }

    private void a(V4 v4, Map<String, String> map) {
        Map<String, String> mergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, v4.b()});
        if (map.containsKey("adm")) {
            this.b.a(new InterfaceC3141j4.d() { // from class: com.ironsource.sdk.controller.v$$ExternalSyntheticLambda0
                @Override // com.ironsource.InterfaceC3141j4.d
                public final void a(InterfaceC3006b7 interfaceC3006b7) {
                    v.this.a(interfaceC3006b7);
                }
            });
        }
        this.D.d(v4.h(), true);
        i(a(C3040d4.g.E, SDKUtils.flatMapToJsonAsString(mergeHashMaps), C3040d4.g.F, C3040d4.g.G));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InterfaceC3006b7 interfaceC3006b7) {
        interfaceC3006b7.a(new InterfaceC3023c7() { // from class: com.ironsource.sdk.controller.v$$ExternalSyntheticLambda2
            @Override // com.ironsource.InterfaceC3023c7
            public final void a(Y6 y6) {
                v.this.a(y6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Y6 y6) {
        try {
            this.Q.a(y6);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            Logger.e(this.c, "handleLoadAd: " + e2);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC3361w4 interfaceC3361w4) {
        i(a(C3230o8.e.Interstitial, jSONObject));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(V4 v4, Map<String, String> map, InterfaceC3361w4 interfaceC3361w4) {
        i(a(C3230o8.e.Interstitial, new JSONObject(SDKUtils.mergeHashMaps(new Map[]{map, v4.b()}))));
    }

    @Override // com.ironsource.sdk.controller.l
    public boolean a(String str) {
        V4 a2 = this.G.a(C3230o8.e.Interstitial, str);
        return a2 != null && a2.d();
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, V4 v4, InterfaceC3344v4 interfaceC3344v4) {
        this.f = str;
        this.g = str2;
        this.z = interfaceC3344v4;
        a(str, C3230o8.e.Banner, v4, new l());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(V4 v4, Map<String, String> map, InterfaceC3344v4 interfaceC3344v4) {
        Map<String, String> mergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, v4.b()});
        if (map != null) {
            i(a(C3040d4.g.N, SDKUtils.flatMapToJsonAsString(mergeHashMaps), C3040d4.g.O, C3040d4.g.R));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(V4 v4) {
        Map<String, String> b2 = v4.b();
        if (b2 != null) {
            i(a(C3040d4.g.S, SDKUtils.flatMapToJsonAsString(b2), C3040d4.g.P, C3040d4.g.Q));
        }
        this.G.b(C3230o8.e.Banner, v4.h());
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC3344v4 interfaceC3344v4) {
        i(a(C3040d4.g.N, jSONObject.toString(), C3040d4.g.O, C3040d4.g.R));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(f.c cVar, l.a aVar) {
        i(a(cVar.e(), cVar.h(), C3040d4.g.U, C3040d4.g.U));
    }

    private t a(C3230o8.e eVar, V4 v4) {
        t tVar = new t();
        if (eVar != C3230o8.e.RewardedVideo && eVar != C3230o8.e.Interstitial && eVar != C3230o8.e.Banner) {
            return tVar;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(C3040d4.i.g, this.f);
        if (!TextUtils.isEmpty(this.g)) {
            hashMap.put(C3040d4.i.f, this.g);
        }
        if (v4 != null) {
            if (v4.g() != null) {
                hashMap.putAll(v4.g());
                hashMap.put(C3040d4.h.y0, String.valueOf(L.f2933a.c(v4.h())));
            }
            hashMap.put("demandSourceName", v4.f());
            hashMap.put("demandSourceId", v4.h());
        }
        String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
        C3040d4.g a2 = C3040d4.g.a(eVar);
        String a3 = a(a2.f3247a, flatMapToJsonAsString, a2.b, a2.c);
        tVar.f3821a = a2.f3247a;
        tVar.b = a3;
        return tVar;
    }

    private String a(C3230o8.e eVar, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("sessionDepth", Integer.toString(jSONObject.optInt("sessionDepth")));
        String optString = jSONObject.optString("demandSourceName");
        String fetchDemandSourceId = SDKUtils.fetchDemandSourceId(jSONObject);
        V4 a2 = this.G.a(eVar, fetchDemandSourceId);
        if (a2 != null) {
            if (a2.g() != null) {
                hashMap.putAll(a2.g());
            }
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put("demandSourceName", optString);
            }
            if (!TextUtils.isEmpty(fetchDemandSourceId)) {
                hashMap.put("demandSourceId", fetchDemandSourceId);
            }
        }
        String flatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(hashMap);
        C3040d4.g b2 = C3040d4.g.b(eVar);
        return a(b2.f3247a, flatMapToJsonAsString, b2.b, b2.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, C3230o8.e eVar, V4 v4) {
        if (q(eVar.toString())) {
            b(new m(eVar, v4, str));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, InterfaceC3378x4 interfaceC3378x4) {
        i(a(C3230o8.e.RewardedVideo, jSONObject));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.S = jSONObject;
        }
    }

    public void a(boolean z, String str) {
        i(e(C3040d4.g.V, a(C3040d4.h.K, str, null, null, null, null, null, null, C3040d4.h.o, z)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2, String str3) {
        String d2 = new Nd(str).d(z ? g0 : h0);
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        i(e(d2, a(b(str, str2), str3)));
    }

    private String a(String str, String str2) {
        return a(str, str2, C3040d4.h.g);
    }

    private String a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                return new JSONObject(str).put(str3, str2).toString();
            } catch (JSONException e2) {
                C3260q4.d().a(e2);
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObject.put(str, SDKUtils.encodeString(str2));
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                jSONObject.put(str3, SDKUtils.encodeString(str4));
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                jSONObject.put(str5, SDKUtils.encodeString(str6));
            }
            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                jSONObject.put(str7, SDKUtils.encodeString(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put(str9, z);
            }
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
        return jSONObject.toString();
    }

    @Override // com.ironsource.InterfaceC3386xc
    public void a(C3382x8 c3382x8) {
        if (this.W && this.V.a(c3382x8)) {
            a(1);
        } else if (c3382x8.getName().contains(C3040d4.f)) {
            this.B.a(new n());
        } else {
            c(c3382x8.getName(), c3382x8.getParent());
        }
    }

    @Override // com.ironsource.InterfaceC3386xc
    public void a(C3382x8 c3382x8, C3247p8 c3247p8) {
        if (this.W && this.V.a(c3382x8)) {
            this.Q.c("controller html - failed to download - " + c3247p8.b());
        } else if (c3382x8.getName().contains(C3040d4.f)) {
            this.B.a(new a(), new b(c3247p8));
        } else {
            b(c3382x8.getName(), c3382x8.getParent(), c3247p8.b());
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Context context) {
        a(new d(context));
    }

    public void a(Ac ac) {
        this.a0 = ac;
        this.Z.a(ac);
    }

    public void a(u uVar) {
        this.v = uVar;
    }

    @Override // com.ironsource.sdk.controller.l
    public void a() {
        this.Z.destroy();
        C3092g5 c3092g5 = this.h;
        if (c3092g5 != null) {
            c3092g5.d();
        }
        X3 x3 = this.R;
        if (x3 != null) {
            x3.b();
        }
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, String str3, String str4) {
        return new m.a(str, str2, str3, str4).a();
    }

    void a(C3230o8.e eVar, String str) {
        b(new e(eVar, str));
    }

    public void a(Z0 z0) {
        synchronized (this.E) {
            if (z0.j() && this.i) {
                Log.d(this.c, "restoreState(state:" + z0 + ")");
                int c2 = z0.c();
                if (c2 != -1) {
                    C3230o8.e eVar = C3230o8.e.RewardedVideo;
                    if (c2 == eVar.ordinal()) {
                        Log.d(this.c, "onRVAdClosed()");
                        String b2 = z0.b();
                        InterfaceC3327u4 a2 = a(eVar);
                        if (a2 != null && !TextUtils.isEmpty(b2)) {
                            a2.b(eVar, b2);
                        }
                    } else {
                        C3230o8.e eVar2 = C3230o8.e.Interstitial;
                        if (c2 == eVar2.ordinal()) {
                            Log.d(this.c, "onInterstitialAdClosed()");
                            String b3 = z0.b();
                            InterfaceC3327u4 a3 = a(eVar2);
                            if (a3 != null && !TextUtils.isEmpty(b3)) {
                                a3.b(eVar2, b3);
                            }
                        }
                    }
                    z0.a(-1);
                    z0.f(null);
                } else {
                    Log.d(this.c, "No ad was opened");
                }
                String d2 = z0.d();
                String f2 = z0.f();
                for (V4 v4 : this.G.a(C3230o8.e.Interstitial)) {
                    if (v4.e() == 2) {
                        Log.d(this.c, "initInterstitial(appKey:" + d2 + ", userId:" + f2 + ", demandSource:" + v4.f() + ")");
                        a(d2, f2, v4, this.y);
                    }
                }
                String g2 = z0.g();
                String h2 = z0.h();
                for (V4 v42 : this.G.a(C3230o8.e.RewardedVideo)) {
                    if (v42.e() == 2) {
                        String f3 = v42.f();
                        Log.d(this.c, "onRVNoMoreOffers()");
                        this.x.c(f3);
                        Log.d(this.c, "initRewardedVideo(appKey:" + g2 + ", userId:" + h2 + ", demandSource:" + f3 + ")");
                        a(g2, h2, v42, this.x);
                    }
                }
                z0.a(false);
            }
            this.D = z0;
        }
    }

    void a(Runnable runnable) {
        R7 r7 = this.f3779a;
        if (r7 != null) {
            r7.b(runnable);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Activity activity) {
        this.Y.a(activity);
    }
}
