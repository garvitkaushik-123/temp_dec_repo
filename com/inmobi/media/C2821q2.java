package com.inmobi.media;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.q2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2821q2 extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f2677a = new AtomicBoolean(false);
    public boolean b;
    public final /* synthetic */ C2740l2 c;
    public final /* synthetic */ Handler d;
    public final /* synthetic */ C2836r2 e;

    public C2821q2(C2740l2 c2740l2, C2836r2 c2836r2, Handler handler) {
        this.c = c2740l2;
        this.d = handler;
        this.e = c2836r2;
    }

    public static final void a(C2821q2 this$0, C2740l2 click, Handler handler, C2836r2 this$1, final WebView webView) {
        AdConfig.ImaiConfig imaiConfig;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(click, "$click");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        try {
            imaiConfig = C2933x2.g;
            Thread.sleep((imaiConfig != null ? imaiConfig.getPingInterval() : 0) * 1000);
        } catch (InterruptedException unused) {
        }
        if (this$0.f2677a.get()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(C2933x2.f(), "access$getTAG$p(...)");
        String str = click.b;
        click.i.set(true);
        handler.post(new Runnable() { // from class: com.inmobi.media.q2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2821q2.a(webView);
            }
        });
        this$1.f2690a.a(click, EnumC2790o4.e);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.f2677a.set(true);
        if (this.b || this.c.i.get()) {
            return;
        }
        this.e.f2690a.a(this.c);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(final WebView webView, String str, Bitmap bitmap) {
        this.b = false;
        int i = AbstractC2970z4.f2771a;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue();
        final C2740l2 c2740l2 = this.c;
        final Handler handler = this.d;
        final C2836r2 c2836r2 = this.e;
        scheduledThreadPoolExecutor.submit(new Runnable() { // from class: com.inmobi.media.q2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2821q2.a(C2821q2.this, c2740l2, handler, c2836r2, webView);
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, int i, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        this.b = true;
        this.e.f2690a.a(this.c, EnumC2790o4.e);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        this.b = true;
        this.e.f2690a.a(this.c, EnumC2790o4.e);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        return xf.a(view, detail, "click_mgr");
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        return (this.c.d || Intrinsics.areEqual(request.getUrl().toString(), this.c.b)) ? false : true;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        this.b = true;
        this.e.f2690a.a(this.c, EnumC2790o4.e);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        C2740l2 c2740l2 = this.c;
        return (c2740l2.d || Intrinsics.areEqual(url, c2740l2.b)) ? false : true;
    }

    public static final void a(WebView webView) {
        try {
            uf ufVar = webView instanceof uf ? (uf) webView : null;
            if (ufVar == null || ufVar.f2726a) {
                return;
            }
            ((uf) webView).stopLoading();
        } catch (Throwable th) {
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(th);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
    }
}
