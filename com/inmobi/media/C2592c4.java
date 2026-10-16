package com.inmobi.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewParent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.c4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2592c4 extends Y1 {
    public final String f;
    public final Lambda g;
    public final Lambda h;
    public final Lambda i;
    public R6 j;
    public O6 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C2592c4(String api, Function0 onUserLandingCompleted, Function1 onLpLifecycleEvent, Function2 fireLandingPageTracker, InterfaceC2971z5 interfaceC2971z5) {
        super(interfaceC2971z5);
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(onUserLandingCompleted, "onUserLandingCompleted");
        Intrinsics.checkNotNullParameter(onLpLifecycleEvent, "onLpLifecycleEvent");
        Intrinsics.checkNotNullParameter(fireLandingPageTracker, "fireLandingPageTracker");
        this.f = api;
        this.g = (Lambda) onUserLandingCompleted;
        this.h = (Lambda) onLpLifecycleEvent;
        this.i = (Lambda) fireLandingPageTracker;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    public final boolean a(WebView webView, String str) {
        String str2;
        Integer num;
        int i;
        InterfaceC2575b4 interfaceC2575b4;
        Fe userLeftApplicationListener;
        if (this.e.get()) {
            return true;
        }
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("EmbeddedBrowserViewClient", AbstractC2673h0.a("onShouldOverrideUrlLoading: ", str));
        }
        if (webView instanceof X1) {
            str2 = str;
            K6 a2 = M6.a(((X1) webView).getLandingPageHandler(), this.f, null, str2, this.j, false, 16);
            num = a2.b;
            i = a2.f2337a;
        } else {
            str2 = str;
            num = null;
            i = 0;
        }
        if (i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            a(3, false, str2, Integer.valueOf(num != null ? num.intValue() : 10));
            return true;
        }
        boolean z = webView instanceof C2677h4;
        if (z) {
            ViewParent parent = ((C2677h4) webView).getParent();
            if ((parent instanceof Y3) && (userLeftApplicationListener = ((Y3) parent).getUserLeftApplicationListener()) != null) {
                userLeftApplicationListener.a();
            }
        }
        ?? r0 = this.h;
        Gb gb = GestureDetectorOnGestureListenerC2634ec.Y0;
        String str3 = this.f;
        gb.getClass();
        r0.invoke(Gb.a(str3, "onNavigatingAway"));
        a(webView);
        if (!AbstractC2968z2.a(str2)) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else if (z) {
                ViewParent parent2 = ((C2677h4) webView).getParent();
                if ((parent2 instanceof Y3) && (interfaceC2575b4 = ((Y3) parent2).d) != null) {
                    C2711j5.a(((C2694i5) interfaceC2575b4).f2596a);
                }
            }
        }
        a(this, 2, false, str2, 8);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("EmbeddedBrowserViewClient", AbstractC2673h0.a("onPageCommitVisible: ", str));
        }
        a(this, 4, true, str, 8);
    }

    @Override // com.inmobi.media.Y1, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("EmbeddedBrowserViewClient", AbstractC2673h0.a("onPageFinished: ", str));
        }
        a(this, 2, true, str, 8);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("EmbeddedBrowserViewClient", AbstractC2673h0.a("onPageStarted: ", str));
        }
        ?? r2 = this.h;
        Gb gb = GestureDetectorOnGestureListenerC2634ec.Y0;
        String str2 = this.f;
        gb.getClass();
        r2.invoke(Gb.a(str2, "onPageStart"));
        a(this, 1, true, str, 8);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, int i, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        a(3, false, failingUrl, Integer.valueOf(i));
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("EmbeddedBrowserViewClient", AbstractC2673h0.a("onReceivedError: ", failingUrl));
        }
    }

    @Override // com.inmobi.media.Y1, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        boolean onRenderProcessGone = super.onRenderProcessGone(view, detail);
        a(3, true, null, 8007);
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("source", "embedded_browser"), TuplesKt.to("isCrashed", Boolean.valueOf(detail.didCrash())));
        Pd pd = Pd.f2401a;
        Pd.b("WebViewRenderProcessGoneEvent", mutableMapOf, Td.f2443a);
        return onRenderProcessGone;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String str;
        Uri url;
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("EmbeddedBrowserViewClient", "shouldOverrideUrlLoading Called");
        }
        if (!L3.G()) {
            return false;
        }
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (str = url.toString()) == null) {
            str = "";
        }
        if (webView == null || str.length() <= 0) {
            return false;
        }
        return a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("EmbeddedBrowserViewClient", "shouldOverrideUrlLoading Called");
        }
        if (webView == null || str == null) {
            return false;
        }
        return a(webView, str);
    }

    public static /* synthetic */ void a(C2592c4 c2592c4, int i, boolean z, String str, int i2) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        c2592c4.a(i, z, str, null);
    }

    /* JADX WARN: Type inference failed for: r9v11, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v15, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v17, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v23, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v7, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r9v9, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    public final void a(int i, boolean z, String str, Integer num) {
        O6 o6 = this.k;
        if (o6 != null) {
            try {
                if (o6.e) {
                    return;
                }
                R6 r6 = o6.f2382a;
                if (r6 != null) {
                    r6.g = "IN_CUSTOM";
                }
                switch (i) {
                    case 1:
                        if (z) {
                            o6.d = str;
                            C2592c4 c2592c4 = o6.b;
                            F6 funnelState = F6.h;
                            c2592c4.getClass();
                            Intrinsics.checkNotNullParameter(funnelState, "funnelState");
                            J6.a(funnelState, r6, (Integer) null, (Function2) c2592c4.i);
                            break;
                        }
                        break;
                    case 2:
                        if (z) {
                            o6.d = str;
                            o6.e = true;
                            if (!o6.c.contains(1)) {
                                C2592c4 c2592c42 = o6.b;
                                F6 funnelState2 = F6.h;
                                R6 r62 = o6.f2382a;
                                c2592c42.getClass();
                                Intrinsics.checkNotNullParameter(funnelState2, "funnelState");
                                J6.a(funnelState2, r62, (Integer) 8006, (Function2) c2592c42.i);
                            }
                            o6.b.g.invoke();
                            C2592c4 c2592c43 = o6.b;
                            F6 funnelState3 = F6.i;
                            R6 r63 = o6.f2382a;
                            c2592c43.getClass();
                            Intrinsics.checkNotNullParameter(funnelState3, "funnelState");
                            J6.a(funnelState3, r63, (Integer) null, (Function2) c2592c43.i);
                            break;
                        }
                        break;
                    case 3:
                        if (z || (str != null && Intrinsics.areEqual(str, o6.d))) {
                            o6.e = true;
                            if (!o6.c.contains(1)) {
                                C2592c4 c2592c44 = o6.b;
                                F6 funnelState4 = F6.h;
                                R6 r64 = o6.f2382a;
                                c2592c44.getClass();
                                Intrinsics.checkNotNullParameter(funnelState4, "funnelState");
                                J6.a(funnelState4, r64, (Integer) 8006, (Function2) c2592c44.i);
                            }
                            C2592c4 c2592c45 = o6.b;
                            F6 funnelState5 = F6.j;
                            R6 r65 = o6.f2382a;
                            Integer valueOf = Integer.valueOf(num != null ? num.intValue() : 8100);
                            c2592c45.getClass();
                            Intrinsics.checkNotNullParameter(funnelState5, "funnelState");
                            J6.a(funnelState5, r65, valueOf, (Function2) c2592c45.i);
                            break;
                        }
                    case 4:
                        if (z) {
                            o6.d = str;
                            break;
                        }
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        o6.e = true;
                        switch (i) {
                            case 5:
                                r3 = 8200;
                                break;
                            case 6:
                                r3 = 8300;
                                break;
                            case 7:
                                r3 = 8400;
                                break;
                            case 8:
                                r3 = 8600;
                                break;
                            case 9:
                                r3 = 8500;
                                break;
                        }
                        int i2 = 4;
                        if (!o6.c.contains(4)) {
                            i2 = 0;
                        }
                        int i3 = r3 + i2;
                        C2592c4 c2592c46 = o6.b;
                        F6 funnelState6 = F6.j;
                        R6 r66 = o6.f2382a;
                        Integer valueOf2 = Integer.valueOf(i3);
                        c2592c46.getClass();
                        Intrinsics.checkNotNullParameter(funnelState6, "funnelState");
                        J6.a(funnelState6, r66, valueOf2, (Function2) c2592c46.i);
                        break;
                }
                o6.c.add(Integer.valueOf(i));
            } catch (Exception e) {
                e.toString();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("EmbeddedBrowserViewClient", "onReceivedError: " + request.getUrl());
        }
        if (request.isForMainFrame()) {
            a(3, true, request.getUrl().toString(), Integer.valueOf(error.getErrorCode()));
        }
    }
}
