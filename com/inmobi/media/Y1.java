package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public abstract class Y1 extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2971z5 f2489a;
    public boolean c;
    public boolean d;
    public int b = -1;
    public final AtomicBoolean e = new AtomicBoolean(false);

    public Y1(InterfaceC2971z5 interfaceC2971z5) {
        this.f2489a = interfaceC2971z5;
    }

    public final void a(WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.e.set(true);
        view.postDelayed(new Runnable() { // from class: com.inmobi.media.Y1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Y1.a(Y1.this);
            }
        }, 1000L);
    }

    public final void b(WebView webView) {
        String str;
        Z z;
        String b;
        String str2;
        String str3;
        Z z2;
        String m;
        T0 t0;
        int i = this.b;
        if (-1 != i) {
            if (i > 0) {
                this.b = i - 1;
                return;
            }
            if (this.c) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new G9(webView));
            this.c = true;
            if (webView instanceof GestureDetectorOnGestureListenerC2634ec) {
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) webView;
                InterfaceC2971z5 interfaceC2971z5 = gestureDetectorOnGestureListenerC2634ec.i;
                if (interfaceC2971z5 != null) {
                    String str4 = GestureDetectorOnGestureListenerC2634ec.a1;
                    ((A5) interfaceC2971z5).a(str4, Ob.a(gestureDetectorOnGestureListenerC2634ec, str4, "TAG", "sendTelemetryEventForNetworkLoad "));
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String creativeId = gestureDetectorOnGestureListenerC2634ec.getCreativeId();
                if (creativeId != null) {
                    linkedHashMap.put("creativeId", creativeId);
                }
                String impressionId = gestureDetectorOnGestureListenerC2634ec.getImpressionId();
                if (impressionId != null) {
                    linkedHashMap.put("impressionId", impressionId);
                }
                linkedHashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(gestureDetectorOnGestureListenerC2634ec.x0 ? (short) 2212 : (short) 2211));
                C2685hc c2685hc = gestureDetectorOnGestureListenerC2634ec.h;
                if (c2685hc != null && (t0 = c2685hc.i) != null) {
                    linkedHashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - t0.f2432a.c));
                }
                C2685hc c2685hc2 = gestureDetectorOnGestureListenerC2634ec.h;
                if (c2685hc2 != null && (z2 = c2685hc2.f2589a) != null && (m = z2.m()) != null) {
                    linkedHashMap.put("plType", m);
                }
                C2685hc c2685hc3 = gestureDetectorOnGestureListenerC2634ec.h;
                if (c2685hc3 != null && (str3 = c2685hc3.e) != null) {
                    linkedHashMap.put("creativeType", str3);
                }
                C2685hc c2685hc4 = gestureDetectorOnGestureListenerC2634ec.h;
                if (c2685hc4 != null && (str2 = c2685hc4.b) != null) {
                    linkedHashMap.put("markupType", str2);
                }
                C2685hc c2685hc5 = gestureDetectorOnGestureListenerC2634ec.h;
                if (c2685hc5 != null && (z = c2685hc5.f2589a) != null && (b = z.b()) != null) {
                    linkedHashMap.put("adType", b);
                }
                C2685hc c2685hc6 = gestureDetectorOnGestureListenerC2634ec.h;
                if (c2685hc6 != null && (str = c2685hc6.c) != null) {
                    linkedHashMap.put("metadataBlob", str);
                }
                C2685hc c2685hc7 = gestureDetectorOnGestureListenerC2634ec.h;
                if (c2685hc7 != null) {
                    linkedHashMap.put("isRewarded", Boolean.valueOf(c2685hc7.g));
                }
                InterfaceC2971z5 interfaceC2971z52 = gestureDetectorOnGestureListenerC2634ec.i;
                if (interfaceC2971z52 != null) {
                    String str5 = GestureDetectorOnGestureListenerC2634ec.a1;
                    ((A5) interfaceC2971z52).a(str5, Ob.a(gestureDetectorOnGestureListenerC2634ec, str5, "TAG", "processTelemetryEvent "));
                }
                gestureDetectorOnGestureListenerC2634ec.getListener().a("NetworkLoadLimitExceeded", linkedHashMap);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (this.d) {
            this.d = false;
            if (webView != null) {
                webView.clearHistory();
            }
        }
        super.onPageFinished(webView, str);
    }

    public static final void a(Y1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e.set(false);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        WebResourceResponse a2 = qf.a(url, this.f2489a);
        return a2 == null ? super.shouldInterceptRequest(view, url) : a2;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        AbstractC2680h7.a((byte) 1, "BaseWebViewClient", "WebView crash detected, destroying ad");
        view.destroy();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        WebResourceResponse a2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        b(view);
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(request, "<this>");
        if (StringsKt.equals("GET", request.getMethod(), true)) {
            String uri = request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            a2 = qf.a(uri, interfaceC2971z5);
        } else {
            a2 = null;
        }
        return a2 == null ? super.shouldInterceptRequest(view, request) : a2;
    }
}
