package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.a0;
import com.fyber.inneractive.sdk.flow.o0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e0;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.b0;

/* loaded from: classes4.dex */
public final class g implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f1716a;

    public g(k kVar) {
        this.f1716a = kVar;
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final com.fyber.inneractive.sdk.util.b0 a(String str, e1 e1Var) {
        s0 s0Var;
        k kVar = this.f1716a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a(kVar));
        ViewGroup viewGroup = this.f1716a.p;
        Context context = (viewGroup == null || viewGroup.getContext() == null) ? com.fyber.inneractive.sdk.util.o.f1770a : this.f1716a.p.getContext();
        if (context != null) {
            k kVar2 = this.f1716a;
            if (kVar2.f) {
                x xVar = kVar2.b;
                com.fyber.inneractive.sdk.response.e eVar = xVar != null ? ((o0) xVar).b : null;
                if (eVar != null) {
                    a0.a(eVar);
                }
                x xVar2 = this.f1716a.b;
                if (xVar2 != null && (s0Var = ((o0) xVar2).d) != null) {
                    r0 r0Var = (r0) s0Var;
                    if (r0Var.c != null) {
                        a0.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, r0Var.c.b == UnitDisplayType.MRECT ? com.fyber.inneractive.sdk.cache.session.enums.c.RECTANGLE_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.BANNER_DISPLAY);
                    }
                }
                return this.f1716a.a(context, str, e1Var, com.fyber.inneractive.sdk.util.g.DISPLAY);
            }
        }
        return new com.fyber.inneractive.sdk.util.b0(e0.FAILED, new Exception("No context or no native click detected"));
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void a(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void b() {
        this.f1716a.c(true);
        k kVar = this.f1716a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onResize", IAlog.a(kVar));
        k kVar2 = this.f1716a;
        InneractiveUnitController.EventsListener eventsListener = kVar2.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdResized(kVar2.f1175a);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void b(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void c() {
        k kVar = this.f1716a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a(kVar));
        k kVar2 = this.f1716a;
        InneractiveUnitController.EventsListener eventsListener = kVar2.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdExpanded(kVar2.f1175a);
        }
        k kVar3 = this.f1716a;
        kVar3.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a(kVar3));
        this.f1716a.c(true);
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void d() {
        k kVar = this.f1716a;
        kVar.a(kVar.w(), Float.NaN, Float.NaN);
        this.f1716a.D();
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void onClose() {
        k kVar = this.f1716a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a(kVar));
        k kVar2 = this.f1716a;
        InneractiveUnitController.EventsListener eventsListener = kVar2.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdCollapsed(kVar2.f1175a);
        }
        this.f1716a.K();
        k kVar3 = this.f1716a;
        kVar3.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a(kVar3));
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a() {
        this.f1716a.a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a(String str, String str2) {
        k kVar = this.f1716a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onSuspiciousNoUserWebActionDetected", IAlog.a(kVar));
        ViewGroup viewGroup = this.f1716a.p;
        if (viewGroup == null || viewGroup.getContext() == null) {
            return;
        }
        k kVar2 = this.f1716a;
        if (!kVar2.v) {
            com.fyber.inneractive.sdk.network.b0.a(kVar2.p.getContext(), str, str2, this.f1716a.b);
            k kVar3 = this.f1716a;
            kVar3.v = true;
            kVar3.getClass();
            IAlog.a("%sreporting auto redirect", IAlog.a(kVar3));
            return;
        }
        kVar2.getClass();
        IAlog.a("%sredirect already reported for this ad", IAlog.a(kVar2));
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a(boolean z) {
        s0 s0Var;
        l0 l0Var;
        com.fyber.inneractive.sdk.cache.session.enums.c cVar;
        k kVar = this.f1716a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onVisibilityChanged: %s", IAlog.a(kVar), Boolean.valueOf(z));
        if (z) {
            k kVar2 = this.f1716a;
            if (!kVar2.o) {
                IAlog.a("%sonShownForTheFirstTime called", IAlog.a(kVar2));
                x xVar = kVar2.b;
                com.fyber.inneractive.sdk.response.e eVar = xVar != null ? ((o0) xVar).b : null;
                if (eVar != null) {
                    IAmraidWebViewController iAmraidWebViewController = kVar2.m;
                    if (iAmraidWebViewController != null) {
                        iAmraidWebViewController.l();
                    }
                    kVar2.b(eVar);
                    kVar2.C();
                }
                long I = kVar2.I();
                kVar2.k = I;
                if (I != 0) {
                    kVar2.a(true, I);
                }
                x xVar2 = kVar2.b;
                if (xVar2 != null && (s0Var = ((o0) xVar2).d) != null && (l0Var = ((r0) s0Var).c) != null) {
                    com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION;
                    if (l0Var.b == UnitDisplayType.MRECT) {
                        cVar = com.fyber.inneractive.sdk.cache.session.enums.c.RECTANGLE_DISPLAY;
                    } else {
                        cVar = com.fyber.inneractive.sdk.cache.session.enums.c.BANNER_DISPLAY;
                    }
                    a0.a(aVar, cVar);
                }
                this.f1716a.o = true;
                return;
            }
            d dVar = kVar2.y;
            if (dVar != null && !dVar.h && !dVar.g && dVar.f != 0) {
                dVar.f = 0L;
                dVar.g = true;
                dVar.a();
            }
            this.f1716a.K();
            return;
        }
        d dVar2 = this.f1716a.y;
        if (dVar2 != null && dVar2.g) {
            dVar2.g = false;
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar2.j);
        }
        this.f1716a.c(false);
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final boolean a(String str) {
        Context a2 = com.fyber.inneractive.sdk.util.o.a(this.f1716a.x());
        boolean startRichMediaIntent = InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(a2, str);
        if (startRichMediaIntent) {
            k kVar = this.f1716a;
            if (kVar.c != null) {
                kVar.a(a2, Float.NaN, Float.NaN);
            }
        }
        return startRichMediaIntent;
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void a(IAmraidWebViewController.MraidVideoFailedToDisplayError mraidVideoFailedToDisplayError) {
        k kVar = this.f1716a;
        InneractiveUnitController.EventsListener eventsListener = kVar.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdEnteredErrorState(kVar.f1175a, mraidVideoFailedToDisplayError);
        }
    }
}
