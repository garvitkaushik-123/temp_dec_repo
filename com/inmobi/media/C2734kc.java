package com.inmobi.media;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.kc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2734kc extends AbstractC2669gc {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2750lc f2623a;
    public final /* synthetic */ tf b;
    public final /* synthetic */ Cc c;

    public C2734kc(C2750lc c2750lc, tf tfVar, Cc cc) {
        this.f2623a = c2750lc;
        this.b = tfVar;
        this.c = cc;
    }

    public static final void b(tf webViewFactory, Cc route, C2750lc this$0, GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(webViewFactory, "$webViewFactory");
        Intrinsics.checkNotNullParameter(route, "$route");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        String id = route.f2254a;
        webViewFactory.getClass();
        Intrinsics.checkNotNullParameter(id, "id");
        GestureDetectorOnGestureListenerC2634ec sourceView = (GestureDetectorOnGestureListenerC2634ec) webViewFactory.b.get(id);
        if (sourceView == null) {
            InterfaceC2971z5 logger = this$0.getLogger();
            if (logger != null) {
                ((A5) logger).b(this$0.e1, "Source RenderView not found for id: " + route.f2254a);
                return;
            }
            return;
        }
        Integer a2 = renderView.getWvStateMachine().a(2);
        if (a2 != null) {
            int intValue = a2.intValue();
            InterfaceC2971z5 logger2 = this$0.getLogger();
            if (logger2 != null) {
                ((A5) logger2).b(this$0.e1, "Failed to transition to FIRE_AD_READY state: " + intValue);
            }
            sourceView.a("loadWebView", AbstractC2815pc.a(renderView.getRoute().b, intValue));
            return;
        }
        String targetId = route.b;
        this$0.getClass();
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        InterfaceC2971z5 interfaceC2971z5 = this$0.i;
        if (interfaceC2971z5 != null) {
            String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "fireLoadWebViewSuccess " + this$0);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", targetId);
        C2782nc c2782nc = this$0.W;
        jSONObject.put("latency", c2782nc != null ? c2782nc.h : 0L);
        sourceView.c("window.imraidview.broadcastEvent('webViewLoaded', " + jSONObject + ");");
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(Yd telemetryOnAdImpression) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        AbstractC2669gc listener;
        Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView == null || (listener = adRenderView.getListener()) == null) {
            return;
        }
        listener.a(telemetryOnAdImpression);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void c() {
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void d(GestureDetectorOnGestureListenerC2634ec renderView) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView != null) {
            adRenderView.getListener().d(adRenderView);
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void e(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void f(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void g(final GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        int i = AbstractC2970z4.f2771a;
        ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
        final tf tfVar = this.b;
        final Cc cc = this.c;
        final C2750lc c2750lc = this.f2623a;
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.kc$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2734kc.a(tf.this, cc, c2750lc, renderView);
            }
        };
        executorC2793o7.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC2793o7.f2659a.post(runnable);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void h(final GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        int i = AbstractC2970z4.f2771a;
        ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
        final tf tfVar = this.b;
        final Cc cc = this.c;
        final C2750lc c2750lc = this.f2623a;
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.kc$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C2734kc.b(tf.this, cc, c2750lc, renderView);
            }
        };
        executorC2793o7.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC2793o7.f2659a.post(runnable);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void i(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void j(GestureDetectorOnGestureListenerC2634ec renderView) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView != null) {
            adRenderView.getListener().j(adRenderView);
        }
    }

    public static final void a(tf webViewFactory, Cc route, C2750lc this$0, GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(webViewFactory, "$webViewFactory");
        Intrinsics.checkNotNullParameter(route, "$route");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        String id = route.f2254a;
        webViewFactory.getClass();
        Intrinsics.checkNotNullParameter(id, "id");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) webViewFactory.b.get(id);
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            InterfaceC2971z5 logger = this$0.getLogger();
            if (logger != null) {
                ((A5) logger).b(this$0.e1, "Source RenderView not found for id: " + route.f2254a);
                return;
            }
            return;
        }
        Integer a2 = renderView.getWvStateMachine().a(3);
        if (a2 != null) {
            int intValue = a2.intValue();
            InterfaceC2971z5 logger2 = this$0.getLogger();
            if (logger2 != null) {
                ((A5) logger2).b(this$0.e1, "Failed to transition to FIRE_AD_FAILED state: " + intValue);
            }
            gestureDetectorOnGestureListenerC2634ec.a("loadWebView", AbstractC2815pc.a(renderView.getRoute().b, intValue));
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(HashMap params) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        AbstractC2669gc listener;
        Intrinsics.checkNotNullParameter(params, "params");
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView == null || (listener = adRenderView.getListener()) == null) {
            return;
        }
        listener.a(params);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(String eventType, Map kv) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        AbstractC2669gc listener;
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(kv, "kv");
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView == null || (listener = adRenderView.getListener()) == null) {
            return;
        }
        listener.a(eventType, kv);
    }

    @Override // com.inmobi.media.AbstractC2669gc, com.inmobi.media.Fe
    public final void a() {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        AbstractC2669gc listener;
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView == null || (listener = adRenderView.getListener()) == null) {
            return;
        }
        listener.a();
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(GestureDetectorOnGestureListenerC2634ec renderView, String trackerName, Map macros) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView != null) {
            adRenderView.getListener().a(adRenderView, trackerName, macros);
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(D1 audioStatusInternal) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        AbstractC2669gc listener;
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView == null || (listener = adRenderView.getListener()) == null) {
            return;
        }
        listener.a(audioStatusInternal);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(boolean z) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        AbstractC2669gc listener;
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView == null || (listener = adRenderView.getListener()) == null) {
            return;
        }
        listener.a(z);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(String data) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        AbstractC2669gc listener;
        Intrinsics.checkNotNullParameter(data, "data");
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView == null || (listener = adRenderView.getListener()) == null) {
            return;
        }
        listener.a(data);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(GestureDetectorOnGestureListenerC2634ec renderView, final boolean z) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        int i = AbstractC2970z4.f2771a;
        ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
        final C2750lc c2750lc = this.f2623a;
        final Cc cc = this.c;
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.kc$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C2734kc.a(C2750lc.this, cc, z);
            }
        };
        executorC2793o7.getClass();
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executorC2793o7.f2659a.post(runnable);
    }

    public static final void a(C2750lc this$0, Cc route, boolean z) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(route, "$route");
        if (this$0.getWvStateMachine().a(4) != null) {
            this$0.a("loadWebView", AbstractC2815pc.a(route.b, 307));
        }
        adRenderView = this$0.getAdRenderView();
        if (adRenderView != null) {
            adRenderView.getListener().a(adRenderView, z);
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void b(GestureDetectorOnGestureListenerC2634ec renderView) {
        GestureDetectorOnGestureListenerC2634ec adRenderView;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        adRenderView = this.f2623a.getAdRenderView();
        if (adRenderView != null) {
            adRenderView.getListener().b(adRenderView);
        }
    }
}
