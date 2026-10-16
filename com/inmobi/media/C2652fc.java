package com.inmobi.media;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.SystemClock;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.fc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2652fc extends Y1 {
    public final C2782nc f;
    public final Nb g;
    public boolean h;
    public final String i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2652fc(C2782nc c2782nc, InterfaceC2971z5 interfaceC2971z5, Nb onRenderViewProcessGone) {
        super(interfaceC2971z5);
        Intrinsics.checkNotNullParameter(onRenderViewProcessGone, "onRenderViewProcessGone");
        this.f = c2782nc;
        this.g = onRenderViewProcessGone;
        this.i = "redirect";
    }

    public final boolean a(WebView webView, String str) {
        String str2;
        boolean z;
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("RenderViewClient", AbstractC2673h0.a("onShouldOverrideUrlLoading  - url - ", str));
        }
        if (webView instanceof GestureDetectorOnGestureListenerC2634ec) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) webView;
            z = true;
            if (gestureDetectorOnGestureListenerC2634ec.y) {
                webView.loadUrl(str);
                return true;
            }
            if (!gestureDetectorOnGestureListenerC2634ec.a()) {
                gestureDetectorOnGestureListenerC2634ec.a(this.i);
                return true;
            }
            InterfaceC2971z5 interfaceC2971z52 = this.f2489a;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("RenderViewClient", "Placement type:  " + ((int) gestureDetectorOnGestureListenerC2634ec.getPlacementType()) + "  url:" + str);
            }
            InterfaceC2971z5 interfaceC2971z53 = this.f2489a;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).a("RenderViewClient", AbstractC2673h0.a("Override URL loading :", str));
            }
            gestureDetectorOnGestureListenerC2634ec.l();
            str2 = str;
            K6 a2 = M6.a(gestureDetectorOnGestureListenerC2634ec.getLandingPageHandler(), this.i, null, str2, null, false, 24);
            InterfaceC2971z5 interfaceC2971z54 = this.f2489a;
            if (interfaceC2971z54 != null) {
                ((A5) interfaceC2971z54).a("RenderViewClient", "Current Index :" + gestureDetectorOnGestureListenerC2634ec.copyBackForwardList().getCurrentIndex() + " Original Url :" + gestureDetectorOnGestureListenerC2634ec.getOriginalUrl() + " URL: " + str2);
            }
            InterfaceC2971z5 interfaceC2971z55 = this.f2489a;
            if (interfaceC2971z55 != null) {
                ((A5) interfaceC2971z55).c("RenderViewClient", "landingPage process result - " + a2.f2337a);
            }
        } else {
            str2 = str;
            z = false;
        }
        InterfaceC2971z5 interfaceC2971z56 = this.f2489a;
        if (interfaceC2971z56 != null) {
            ((A5) interfaceC2971z56).a("RenderViewClient", "Override URL loading :" + str2 + " returned " + z);
        }
        return z;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("RenderViewClient", AbstractC2673h0.a("Resource loading:", str));
        }
        if (webView instanceof GestureDetectorOnGestureListenerC2634ec) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) webView;
            String url = gestureDetectorOnGestureListenerC2634ec.getUrl();
            if (str == null || url == null || StringsKt.startsWith$default(url, "file:", false, 2, (Object) null)) {
                return;
            }
            a(gestureDetectorOnGestureListenerC2634ec);
        }
    }

    @Override // com.inmobi.media.Y1, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        C2782nc c2782nc = this.f;
        if (c2782nc != null) {
            Map a2 = c2782nc.a();
            long j = c2782nc.c;
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            a2.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
            String a3 = c2782nc.a("WebViewLoadFinished");
            Pd pd = Pd.f2401a;
            Pd.b(a3, a2, Td.f2443a);
        }
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("RenderViewClient", AbstractC2673h0.a("Page load finished:", str));
        }
        if (webView instanceof GestureDetectorOnGestureListenerC2634ec) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) webView;
            a(gestureDetectorOnGestureListenerC2634ec);
            if (Intrinsics.areEqual("Loading", gestureDetectorOnGestureListenerC2634ec.u)) {
                gestureDetectorOnGestureListenerC2634ec.c("window.imaiview.broadcastEvent('ready');");
                gestureDetectorOnGestureListenerC2634ec.c("window.mraidview.broadcastEvent('ready');");
                gestureDetectorOnGestureListenerC2634ec.B();
            }
        }
        InterfaceC2971z5 interfaceC2971z52 = this.f2489a;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a("RenderViewClient", "==== CHECKPOINT REACHED - PAGE FINISHED ====");
        }
        InterfaceC2971z5 interfaceC2971z53 = this.f2489a;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).b();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        C2782nc c2782nc = this.f;
        if (c2782nc != null) {
            Map a2 = c2782nc.a();
            long j = c2782nc.c;
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            a2.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
            String a3 = c2782nc.a("PageStarted");
            Pd pd = Pd.f2401a;
            Pd.b(a3, a2, Td.f2443a);
        }
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("RenderViewClient", AbstractC2673h0.a("Page load started:", str));
        }
        if (webView instanceof GestureDetectorOnGestureListenerC2634ec) {
            InterfaceC2971z5 interfaceC2971z52 = this.f2489a;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("RenderViewClient", "Page load started renderview: " + ((GestureDetectorOnGestureListenerC2634ec) webView).getMarkupType());
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) webView;
            a(gestureDetectorOnGestureListenerC2634ec);
            gestureDetectorOnGestureListenerC2634ec.setAndUpdateViewState("Loading");
        }
        InterfaceC2971z5 interfaceC2971z53 = this.f2489a;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).a("RenderViewClient", "==== CHECKPOINT REACHED - PAGE STARTED ====");
        }
        InterfaceC2971z5 interfaceC2971z54 = this.f2489a;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).b();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, int i, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b("RenderViewClient", "OnReceivedError - errorCode - " + i + ", description - " + description + ", url - " + failingUrl);
        }
        super.onReceivedError(view, i, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b("RenderViewClient", "ReceivedHttpError - error - " + (webResourceResponse != null ? webResourceResponse.getReasonPhrase() : null) + ", statusCode - " + (webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null) + " url - " + (webResourceRequest != null ? webResourceRequest.getUrl() : null) + " isMainFrame - " + (webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isForMainFrame()) : null));
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b("RenderViewClient", "onReceivedSSLError - error - " + (sslError != null ? Integer.valueOf(sslError.getPrimaryError()) : null) + " - url - " + (sslError != null ? sslError.getUrl() : null));
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("RenderViewClient", "shouldOverrideUrlLoading Called");
        }
        if (!L3.G()) {
            return false;
        }
        String uri = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return a(view, uri);
    }

    @Override // com.inmobi.media.Y1, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("RenderViewClient", "onRenderProcessGone detail did crash- " + detail.didCrash() + " priority - " + detail.rendererPriorityAtExit());
        }
        this.g.invoke(Boolean.valueOf(detail.didCrash()));
        return super.onRenderProcessGone(view, detail);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        super.onReceivedError(view, request, error);
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b("RenderViewClient", "OnReceivedError - errorCode - " + error.getErrorCode() + ", description - " + ((Object) error.getDescription()) + ", url - " + request.getUrl() + ", method - " + request.getMethod() + ", isMainFrame - " + request.isForMainFrame());
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("RenderViewClient", AbstractC2673h0.a("shouldOverrideUrlLoading Called ", url));
        }
        return a(view, url);
    }

    public final void a(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        if (this.h || gestureDetectorOnGestureListenerC2634ec.e) {
            return;
        }
        this.h = true;
        InterfaceC2971z5 interfaceC2971z5 = this.f2489a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("RenderViewClient", "Injecting MRAID javascript for two piece creatives.");
        }
        gestureDetectorOnGestureListenerC2634ec.c(gestureDetectorOnGestureListenerC2634ec.getMraidJsString());
    }
}
