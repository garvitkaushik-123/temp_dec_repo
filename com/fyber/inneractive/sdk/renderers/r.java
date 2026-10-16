package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.a0;
import com.fyber.inneractive.sdk.flow.l0;
import com.fyber.inneractive.sdk.flow.o0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.x0;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.e0;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.util.r1;
import com.fyber.inneractive.sdk.util.t1;
import com.fyber.inneractive.sdk.web.g0;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class r implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f1723a;

    public r(s sVar) {
        this.f1723a = sVar;
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final b0 a(String str, e1 e1Var) {
        s sVar = this.f1723a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a(sVar));
        Context w = this.f1723a.w();
        s sVar2 = this.f1723a;
        com.fyber.inneractive.sdk.interfaces.e eVar = sVar2.k;
        if (eVar != null) {
            w = sVar2.c(eVar.getLayout());
        }
        s sVar3 = this.f1723a;
        if (!sVar3.f) {
            return new b0(e0.FAILED, new Exception("No context or no native click detected"));
        }
        x xVar = sVar3.b;
        com.fyber.inneractive.sdk.response.e eVar2 = xVar == null ? null : ((o0) xVar).b;
        if (eVar2 != null) {
            a0.a(eVar2);
        }
        a0.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, this.f1723a.F == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_DISPLAY);
        return this.f1723a.a(w, str, e1Var, com.fyber.inneractive.sdk.util.g.DISPLAY);
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void b() {
        s sVar = this.f1723a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onResize", IAlog.a(sVar));
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void c() {
        s sVar = this.f1723a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a(sVar));
        s sVar2 = this.f1723a;
        sVar2.C = true;
        sVar2.N();
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void d() {
        s sVar = this.f1723a;
        sVar.a(sVar.w(), Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void onClose() {
        s sVar = this.f1723a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a(sVar));
        s sVar2 = this.f1723a;
        if (sVar2.C) {
            sVar2.C = false;
            sVar2.N();
            return;
        }
        if (sVar2.F == UnitDisplayType.REWARDED) {
            sVar2.M();
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f1723a.k;
        if (eVar != null) {
            eVar.dismissAd(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void b(boolean z) {
        if (z) {
            s sVar = this.f1723a;
            if (!sVar.s) {
                sVar.s = true;
                com.fyber.inneractive.sdk.interfaces.e eVar = sVar.k;
                if (eVar != null) {
                    sVar.c(eVar.isCloseButtonDisplay());
                }
            }
            s sVar2 = this.f1723a;
            if (!sVar2.q) {
                sVar2.q = true;
                t1 t1Var = new t1(TimeUnit.MILLISECONDS, sVar2.r);
                sVar2.m = t1Var;
                t1Var.e = new l0(sVar2);
                r1 r1Var = new r1(t1Var);
                t1Var.c = r1Var;
                t1Var.d = false;
                r1Var.sendEmptyMessage(1932593528);
            }
            com.fyber.inneractive.sdk.interfaces.e eVar2 = this.f1723a.k;
            if (eVar2 == null || !eVar2.isCloseButtonDisplay()) {
                return;
            }
            s sVar3 = this.f1723a;
            sVar3.p = false;
            com.fyber.inneractive.sdk.interfaces.e eVar3 = sVar3.k;
            if (eVar3 != null) {
                eVar3.disableCloseButton();
            }
            com.fyber.inneractive.sdk.util.a aVar = sVar3.u;
            aVar.d = 0L;
            aVar.e = 0L;
            aVar.f = 0L;
            aVar.b = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a() {
        this.f1723a.a(new WebViewRendererProcessHasGoneError());
        this.f1723a.destroy();
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a(String str, String str2) {
        s sVar = this.f1723a;
        sVar.getClass();
        IAlog.a("%sweb view callback: onSuspiciousNoUserWebActionDetected", IAlog.a(sVar));
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f1723a.k;
        if (eVar == null || eVar.getLayout() == null) {
            return;
        }
        s sVar2 = this.f1723a;
        if (!sVar2.D) {
            com.fyber.inneractive.sdk.network.b0.a(sVar2.k.getLayout().getContext(), str, str2, this.f1723a.b);
            s sVar3 = this.f1723a;
            sVar3.D = true;
            sVar3.getClass();
            IAlog.a("%sreporting auto redirect", IAlog.a(sVar3));
            return;
        }
        sVar2.getClass();
        IAlog.a("%sredirect already reported for this ad", IAlog.a(sVar2));
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a(boolean z) {
        String str;
        if (z) {
            s sVar = this.f1723a;
            if (!sVar.x) {
                sVar.x = true;
                if (sVar.b != null) {
                    IAmraidWebViewController iAmraidWebViewController = sVar.y;
                    if (iAmraidWebViewController != null) {
                        iAmraidWebViewController.l();
                    }
                    com.fyber.inneractive.sdk.response.e eVar = ((o0) sVar.b).b;
                    if (eVar != null && (str = eVar.k) != null && str.trim().length() > 0) {
                        IAlog.e("%sfiring impression!", IAlog.a(sVar));
                        IAlog.d("AD_IMPRESSION", new Object[0]);
                        x0.b(str);
                    }
                    com.fyber.inneractive.sdk.web.m mVar = sVar.y.b;
                    if (mVar != null) {
                        mVar.a("var forceReflow = function(elem){ elem = elem || document.documentElement; elem.style.zIndex = 2147483646; var width = elem.style.width, px = elem.offsetWidth+1; elem.style.width = px+'px'; setTimeout(function(){ elem.style.zIndex = 2147483646; elem.style.width = width; elem = null; }, 0); }; forceReflow(document.documentElement);");
                    }
                    a0.a(com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION, sVar.F == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_DISPLAY);
                    sVar.C();
                    sVar.H();
                }
            }
        }
        s sVar2 = this.f1723a;
        sVar2.getClass();
        IAlog.a("%sweb view callback: onVisibilityChanged: %s", IAlog.a(sVar2), Boolean.valueOf(z));
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void a(boolean z, Orientation orientation) {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f1723a.k;
        if (eVar != null) {
            eVar.setActivityOrientation(z, orientation);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final boolean a(String str) {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f1723a.k;
        if (eVar == null || eVar.getLayout() == null) {
            return false;
        }
        s sVar = this.f1723a;
        Context c = sVar.c(sVar.k.getLayout());
        boolean startRichMediaIntent = InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(c, str);
        if (startRichMediaIntent) {
            this.f1723a.a(c, Float.NaN, Float.NaN);
        }
        return startRichMediaIntent;
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void a(IAmraidWebViewController.MraidVideoFailedToDisplayError mraidVideoFailedToDisplayError) {
        this.f1723a.d(false);
        s sVar = this.f1723a;
        InneractiveUnitController.EventsListener eventsListener = sVar.c;
        if (eventsListener != null) {
            ((InneractiveFullscreenAdEventsListener) eventsListener).onAdEnteredErrorState(sVar.f1175a, mraidVideoFailedToDisplayError);
        }
    }
}
