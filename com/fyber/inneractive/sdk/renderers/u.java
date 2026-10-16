package com.fyber.inneractive.sdk.renderers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.config.t0;
import com.fyber.inneractive.sdk.config.x0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.g0;
import com.fyber.inneractive.sdk.flow.k0;
import com.fyber.inneractive.sdk.flow.n0;
import com.fyber.inneractive.sdk.flow.q0;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.player.controller.f0;
import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.e0;
import com.fyber.inneractive.sdk.util.e1;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class u extends n0 implements f0, com.fyber.inneractive.sdk.flow.storepromo.observer.a {
    public com.fyber.inneractive.sdk.external.g D;
    public v F;
    public com.fyber.inneractive.sdk.interfaces.e w;
    public com.fyber.inneractive.sdk.player.ui.m x;
    public com.fyber.inneractive.sdk.player.controller.b y;
    public WeakReference z;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public UnitDisplayType E = UnitDisplayType.INTERSTITIAL;
    public boolean G = false;
    public final t H = new t(this);
    public final RelativeLayout.LayoutParams I = new RelativeLayout.LayoutParams(-1, -1);
    public boolean J = false;
    public boolean K = false;

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final boolean B() {
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        return mVar != null && mVar.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final void E() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final boolean G() {
        return this.J;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final int I() {
        Integer a2;
        x xVar = this.b;
        if (xVar != null) {
            r0 r0Var = (r0) xVar;
            if (r0Var.c != null && (a2 = ((com.fyber.inneractive.sdk.config.global.features.r) r0Var.c.a(com.fyber.inneractive.sdk.config.global.features.r.class)).a("close_clickable_area_dp")) != null) {
                return a2.intValue();
            }
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final int J() {
        Integer a2;
        x xVar = this.b;
        if (xVar != null) {
            r0 r0Var = (r0) xVar;
            if (r0Var.c != null && (a2 = ((com.fyber.inneractive.sdk.config.global.features.r) r0Var.c.a(com.fyber.inneractive.sdk.config.global.features.r.class)).a("close_visible_size_dp")) != null) {
                return a2.intValue();
            }
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final long K() {
        int a2;
        long j;
        v vVar;
        if (InneractiveAdManager.isCurrentUserAChild()) {
            if (A()) {
                Integer a3 = ((com.fyber.inneractive.sdk.config.global.features.c) ((r0) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.c.class)).a("end_card_skip_time_sec");
                int intValue = a3 != null ? a3.intValue() : 0;
                if (intValue < 0 || intValue > 5) {
                    intValue = 0;
                }
                if (intValue > 0) {
                    IAlog.a("%s: overriding endcard dismiss time with child mode with %d", IAlog.a(this), Integer.valueOf(intValue));
                    return intValue;
                }
            }
            IAlog.a("%s: overriding endcard dismiss time with child mode with %d", IAlog.a(this), 0);
            return 0L;
        }
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.config.l a4 = iAConfigManager.u.b.a("endcard");
        Object obj = this.y;
        if (obj == null && (vVar = this.F) != null) {
            obj = vVar.f1725a;
        }
        com.fyber.inneractive.sdk.flow.endcard.k i = obj != null ? ((z) obj).i() : null;
        if (i != null) {
            com.fyber.inneractive.sdk.flow.endcard.b a5 = i.b.a();
            a2 = a5 != null ? a5.f : i.f;
        } else {
            a2 = iAConfigManager.u.b.a("vast_endcard_x_delay", 5, 0);
        }
        long j2 = a2;
        if (a4.f1104a.containsKey("endcard_cr") || a4.f1104a.containsKey("endcard_ci")) {
            String str = this.E != UnitDisplayType.REWARDED ? "endcard_ci" : "endcard_cr";
            if (a4.f1104a.containsKey(str)) {
                j = Long.parseLong((String) a4.f1104a.get(str));
                if (j >= 0 && j <= 5) {
                    IAlog.a("%s : overriding endcard dismiss time for type: %s with: %d sec.", IAlog.a(this), this.E, Long.valueOf(j));
                    this.t = true;
                    j2 = j;
                }
            }
            j = j2;
            if (j >= 0) {
                IAlog.a("%s : overriding endcard dismiss time for type: %s with: %d sec.", IAlog.a(this), this.E, Long.valueOf(j));
                this.t = true;
                j2 = j;
            }
        }
        return j2 * 1000;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final boolean L() {
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        return mVar != null && ((com.fyber.inneractive.sdk.player.ui.s) mVar).h();
    }

    public final void M() {
        if (this.B || this.c == null) {
            return;
        }
        this.B = true;
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null && (eVar.wasDismissedByUser() || IAConfigManager.O.u.b.a("endcard").a())) {
            com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_CLOSE;
            x xVar2 = this.b;
            if (xVar2 != null) {
                r0 r0Var = (r0) xVar2;
                if (r0Var.i != null) {
                    String[] strArr = {xVar.a()};
                    com.fyber.inneractive.sdk.player.t tVar = r0Var.i;
                    if (tVar != null) {
                        tVar.a("EVENT_TRACKING", strArr);
                    }
                }
            }
            com.fyber.inneractive.sdk.model.vast.x xVar3 = com.fyber.inneractive.sdk.model.vast.x.EVENT_CLOSE_LINEAR;
            x xVar4 = this.b;
            if (xVar4 != null) {
                r0 r0Var2 = (r0) xVar4;
                if (r0Var2.i != null) {
                    String[] strArr2 = {xVar3.a()};
                    com.fyber.inneractive.sdk.player.t tVar2 = r0Var2.i;
                    if (tVar2 != null) {
                        tVar2.a("EVENT_TRACKING", strArr2);
                    }
                }
            }
        }
        ((InneractiveFullscreenAdEventsListener) this.c).onAdDismissed(this.f1175a);
    }

    public final void N() {
        s0 s0Var;
        x xVar = this.b;
        if (xVar == null || (s0Var = ((r0) xVar).d) == null) {
            return;
        }
        com.fyber.inneractive.sdk.config.r0 r0Var = (com.fyber.inneractive.sdk.config.r0) s0Var;
        if (r0Var.c != null) {
            UnitDisplayType unitDisplayType = r0Var.c.b;
            x0 x0Var = IAConfigManager.O.x;
            com.fyber.inneractive.sdk.cache.session.enums.c cVar = unitDisplayType == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO;
            com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.CLICK;
            com.fyber.inneractive.sdk.cache.session.e eVar = x0Var.f1132a;
            if (eVar != null) {
                com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final boolean b(x xVar) {
        Boolean c;
        com.fyber.inneractive.sdk.config.global.r rVar;
        v vVar;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.config.o oVar = iAConfigManager.u.b;
        oVar.getClass();
        String str = iAConfigManager.d;
        if (!(oVar.b.containsKey(str) ? (com.fyber.inneractive.sdk.config.m) oVar.b.get(str) : new com.fyber.inneractive.sdk.config.m()).f1106a.containsKey("endcard")) {
            Object obj = this.y;
            if (obj == null && (vVar = this.F) != null) {
                obj = vVar.f1725a;
            }
            com.fyber.inneractive.sdk.config.global.features.u uVar = null;
            com.fyber.inneractive.sdk.flow.endcard.k i = obj != null ? ((z) obj).i() : null;
            com.fyber.inneractive.sdk.flow.endcard.b a2 = i != null ? i.b.a() : null;
            if (a2 != null && a2.i() == com.fyber.inneractive.sdk.model.vast.i.Static) {
                x xVar2 = this.b;
                if (xVar2 != null && (rVar = ((r0) xVar2).c) != null) {
                    uVar = (com.fyber.inneractive.sdk.config.global.features.u) rVar.a(com.fyber.inneractive.sdk.config.global.features.u.class);
                }
                UnitDisplayType unitDisplayType = this.E;
                uVar.getClass();
                int i2 = com.fyber.inneractive.sdk.config.global.features.s.f1090a[unitDisplayType.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 && (c = uVar.c("countdown_iv")) != null) {
                        return c.booleanValue();
                    }
                    return false;
                }
                Boolean c2 = uVar.c("countdown_rv");
                if (c2 != null) {
                    return c2.booleanValue();
                }
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void c() {
        if (!this.C) {
            this.u.a(true);
        }
        this.C = true;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.flow.a0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.destroy();
        }
        if (this.A) {
            M();
        }
        com.fyber.inneractive.sdk.player.controller.b bVar = this.y;
        if (bVar != null) {
            ((z) bVar).b(this);
            this.y.destroy();
            this.y = null;
        }
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        if (mVar != null) {
            mVar.destroy();
            this.x = null;
        }
        this.w = null;
        this.z = null;
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void e() {
        N();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void f() {
        this.J = true;
        k0 k0Var = this.v;
        if (k0Var != null) {
            k0Var.cancel();
            this.v = null;
        }
        if (!this.s) {
            this.s = true;
            com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
            if (eVar != null) {
                c(eVar.isCloseButtonDisplay());
            }
        }
        com.fyber.inneractive.sdk.interfaces.e eVar2 = this.w;
        if (eVar2 == null || !eVar2.isCloseButtonDisplay()) {
            return;
        }
        d(true ^ this.t);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void h() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.dismissAd(false);
        }
        a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void i() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.dismissAd(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void j() {
        x0 x0Var = IAConfigManager.O.x;
        com.fyber.inneractive.sdk.cache.session.enums.c cVar = this.E == UnitDisplayType.INTERSTITIAL ? com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO;
        com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION;
        com.fyber.inneractive.sdk.cache.session.e eVar = x0Var.f1132a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
        }
        C();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void k() {
        M();
        InneractiveAdSpot inneractiveAdSpot = this.f1175a;
        if (inneractiveAdSpot == null || !(inneractiveAdSpot instanceof g0)) {
            return;
        }
        ((g0) inneractiveAdSpot).a();
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void m() {
        super.m();
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        if (!aVar.b || aVar.e <= 0) {
            return;
        }
        aVar.f += System.currentTimeMillis() - aVar.e;
        aVar.e = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void onCompleted() {
        WeakReference weakReference;
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) com.fyber.inneractive.sdk.util.t.a(this.z);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onCompleted();
        }
        x0 x0Var = IAConfigManager.O.x;
        UnitDisplayType unitDisplayType = this.E;
        UnitDisplayType unitDisplayType2 = UnitDisplayType.REWARDED;
        com.fyber.inneractive.sdk.cache.session.enums.c cVar = unitDisplayType == unitDisplayType2 ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO;
        com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION;
        com.fyber.inneractive.sdk.cache.session.e eVar = x0Var.f1132a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
        }
        if (this.E == unitDisplayType2) {
            com.fyber.inneractive.sdk.external.g gVar = this.D;
            if (gVar != null) {
                weakReference = ((q0) gVar.f1168a).mAdSpot;
                g0 g0Var = (g0) com.fyber.inneractive.sdk.util.t.a(weakReference);
                InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener = gVar.f1168a.b;
                if (inneractiveFullScreenAdRewardedListener != null && g0Var != null) {
                    inneractiveFullScreenAdRewardedListener.onAdRewarded(g0Var);
                }
            }
            F();
        }
        x xVar = this.b;
        if (xVar == null || ((r0) xVar).i == null) {
            return;
        }
        H();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void onPlayerError() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) com.fyber.inneractive.sdk.util.t.a(this.z);
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.dismissAd(false);
        }
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onPlayerError();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void onProgress(int i, int i2) {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) com.fyber.inneractive.sdk.util.t.a(this.z);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onProgress(i, i2);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void r() {
        super.r();
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        if (aVar.b) {
            aVar.e = System.currentTimeMillis();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean t() {
        com.fyber.inneractive.sdk.player.t tVar;
        com.fyber.inneractive.sdk.player.controller.b bVar;
        com.fyber.inneractive.sdk.interfaces.e eVar;
        com.fyber.inneractive.sdk.player.ui.m mVar;
        com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar2;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar;
        View view;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar2;
        View view2;
        x xVar = this.b;
        if (xVar == null || (tVar = ((r0) xVar).i) == null || (bVar = this.y) == null || (eVar = this.w) == null || (mVar = this.x) == null) {
            return false;
        }
        com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) tVar.f;
        com.fyber.inneractive.sdk.flow.storepromo.b bVar3 = nVar.v;
        if (bVar3 == null || (bVar2 = bVar3.d) == null || (cVar = bVar2.d) == null || cVar.b == null || (view = cVar.f1238a) == null || view.getParent() == null || cVar.b.getVisibility() != 0) {
            if (((com.fyber.inneractive.sdk.player.ui.s) mVar).h()) {
                if (this.p) {
                    eVar.dismissAd(true);
                    return true;
                }
            } else if (bVar.b()) {
                ((z) bVar).f(true);
            }
            return true;
        }
        com.fyber.inneractive.sdk.flow.storepromo.b bVar4 = nVar.v;
        com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar5 = bVar4.d;
        if (bVar5 == null || (cVar2 = bVar5.d) == null || cVar2.b == null || (view2 = cVar2.f1238a) == null || view2.getParent() == null || cVar2.b.getVisibility() != 0) {
            IAlog.f("StorePromoManager: hidePromo: unable hide promo: controller null or not ready", new Object[0]);
            return true;
        }
        bVar4.d.a();
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final void v() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) {
        t0 t0Var;
        super.a(eVar, activity);
        this.w = eVar;
        this.A = false;
        this.B = false;
        this.K = false;
        InneractiveUnitController selectedUnitController = this.f1175a.getSelectedUnitController();
        if (selectedUnitController != null) {
            if (selectedUnitController instanceof InneractiveFullscreenUnitController) {
                InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
                if (selectedContentController != null) {
                    if (selectedContentController instanceof InneractiveFullscreenVideoContentController) {
                        this.z = new WeakReference((InneractiveFullscreenVideoContentController) selectedContentController);
                    } else {
                        IAlog.f("%sContent controller expected to be InneractiveFullscreenVideoContentController and is %s", IAlog.a(this), selectedContentController.getClass().getSimpleName());
                    }
                }
            } else {
                IAlog.f("%sWrong type of unit controller found. Expecting InneractiveFullscreenUnitController", IAlog.a(this));
            }
        }
        s0 s0Var = this.f1175a.getAdContent().d;
        if (s0Var != null && (t0Var = ((com.fyber.inneractive.sdk.config.r0) s0Var).f) != null) {
            this.E = t0Var.j;
        }
        x xVar = this.b;
        if (xVar != null) {
            ((r0) xVar).g();
        }
        x xVar2 = this.b;
        com.fyber.inneractive.sdk.player.t tVar = xVar2 != null ? ((r0) xVar2).i : null;
        Context context = this.w.getLayout().getContext();
        if (tVar != null) {
            com.fyber.inneractive.sdk.player.a aVar = tVar.f;
            if (aVar != null) {
                com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) aVar;
                if (nVar.f1617a != null) {
                    nVar.getClass();
                    e eVar2 = new e(tVar);
                    this.F = eVar2;
                    this.x = eVar2.a(context, ((r0) this.b).c);
                    com.fyber.inneractive.sdk.player.controller.b a2 = this.F.a(this.f1175a, (r0) this.b);
                    this.y = a2;
                    this.F.b();
                    a2.b(false);
                    z zVar = (z) this.y;
                    zVar.g = this;
                    zVar.a(this);
                    ((com.fyber.inneractive.sdk.player.ui.e) this.x).d();
                    this.I.addRule(13);
                    this.w.getLayout().addView((View) this.x, this.I);
                    this.j = ((View) this.x).findViewById(R.id.ia_click_overlay);
                    this.F.a(this.H);
                    this.A = true;
                    return;
                }
            }
            IAlog.f("%sFull screen video ad renderer is not valid.", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Full screen video could not be loaded");
        }
    }

    public final void e(boolean z) {
        if (L() && this.J) {
            return;
        }
        if (z) {
            com.fyber.inneractive.sdk.player.controller.b bVar = this.y;
            com.fyber.inneractive.sdk.flow.endcard.k i = bVar != null ? ((z) bVar).i() : null;
            com.fyber.inneractive.sdk.flow.endcard.o oVar = i != null ? (com.fyber.inneractive.sdk.flow.endcard.o) i.b.a(com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card) : null;
            this.u.a(oVar != null ? oVar.g().toString() : null);
            return;
        }
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        aVar.d = 0L;
        aVar.e = 0L;
        aVar.f = 0L;
        aVar.b = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        if (((r2 == null || (r2 = r2.E) == null || !android.text.TextUtils.equals(r2, "1")) ? false : true) != false) goto L52;
     */
    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(boolean z) {
        com.fyber.inneractive.sdk.model.vast.o oVar;
        ViewGroup viewGroup;
        e(z);
        com.fyber.inneractive.sdk.player.controller.b bVar = this.y;
        com.fyber.inneractive.sdk.flow.endcard.k i = bVar != null ? ((z) bVar).i() : null;
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        if ((mVar == null || (viewGroup = ((com.fyber.inneractive.sdk.player.ui.s) mVar).q) == null || viewGroup.getVisibility() != 0) && !this.G) {
            if (i != null) {
                com.fyber.inneractive.sdk.response.g gVar = i.f1189a.d;
            }
            com.fyber.inneractive.sdk.flow.endcard.b a2 = i != null ? i.a() : null;
            if (a2 != null && (oVar = a2.c.e.f) != null && oVar.d) {
                this.J = false;
                this.p = false;
                com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
                if (eVar != null) {
                    eVar.disableCloseButton();
                }
                com.fyber.inneractive.sdk.util.a aVar = this.u;
                aVar.d = 0L;
                aVar.e = 0L;
                aVar.f = 0L;
                aVar.b = false;
                Runnable runnable = this.l;
                if (runnable != null) {
                    com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
                    this.l = null;
                }
                Runnable runnable2 = this.n;
                if (runnable2 != null) {
                    com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable2);
                    this.n = null;
                }
                H();
                this.F.f1725a.a(a2);
                com.fyber.inneractive.sdk.interfaces.e eVar2 = this.w;
                if (eVar2 != null) {
                    eVar2.secondEndCardWasDisplayed();
                    return;
                }
                return;
            }
            com.fyber.inneractive.sdk.interfaces.e eVar3 = this.w;
            if (eVar3 != null) {
                eVar3.destroy();
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.interfaces.e eVar4 = this.w;
        if (eVar4 != null) {
            eVar4.destroy();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
        this.D = gVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final b0 a(e1 e1Var, com.fyber.inneractive.sdk.util.g gVar) {
        Context context;
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        N();
        if (this.x.getContext() == null) {
            context = com.fyber.inneractive.sdk.util.o.f1770a;
        } else {
            context = this.x.getContext();
        }
        x xVar = this.b;
        return a(context, (xVar == null || (eVar = ((r0) xVar).b) == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).O) == null) ? null : bVar.b, e1Var, gVar);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(boolean z, Orientation orientation) {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.setActivityOrientation(z, orientation);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final boolean b(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.controller.b bVar = this.y;
        if (bVar == null) {
            IAlog.f("Unable to register store promo observer - ui controller unavailable", new Object[0]);
            return false;
        }
        return ((z) bVar).a(aVar);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(String str, String str2) {
        IAlog.a(IAlog.a(this) + "full screen video ad renderer callback: onSuspiciousNoUserWebActionDetected", new Object[0]);
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar == null || eVar.getLayout() == null || this.w.getLayout().getContext() == null) {
            return;
        }
        if (!this.K) {
            com.fyber.inneractive.sdk.network.b0.a(this.w.getLayout().getContext(), str, str2, this.b);
            this.K = true;
            IAlog.a(IAlog.a(this) + "reporting auto redirect", new Object[0]);
            return;
        }
        IAlog.a(IAlog.a(this) + "redirect already reported for this ad", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final b0 a(String str, e1 e1Var, boolean z) {
        v vVar;
        if (this.E == UnitDisplayType.INTERSTITIAL) {
            this.G = true;
        }
        Object obj = this.y;
        if (obj == null && (vVar = this.F) != null) {
            obj = vVar.f1725a;
        }
        com.fyber.inneractive.sdk.flow.endcard.k i = obj != null ? ((z) obj).i() : null;
        com.fyber.inneractive.sdk.flow.endcard.b a2 = i != null ? i.b.a() : null;
        if (a2 != null) {
            N();
            b0 a3 = a(a2.c.f1241a, str, e1Var, a2.g());
            if (a3.f1751a != e0.FAILED) {
                r0 r0Var = a2.c.b;
                String[] strArr = {com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK.toString()};
                com.fyber.inneractive.sdk.player.t tVar = r0Var.i;
                if (tVar != null) {
                    tVar.a("EVENT_TRACKING", strArr);
                }
            }
            return a3;
        }
        return new b0(e0.FAILED, new Exception("No Companion clicked"));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(boolean z) {
        com.fyber.inneractive.sdk.player.t tVar;
        com.fyber.inneractive.sdk.interfaces.e eVar;
        if (z) {
            com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_SKIP;
            x xVar2 = this.b;
            if (xVar2 != null) {
                r0 r0Var = (r0) xVar2;
                if (r0Var.i != null) {
                    String[] strArr = {xVar.a()};
                    com.fyber.inneractive.sdk.player.t tVar2 = r0Var.i;
                    if (tVar2 != null) {
                        tVar2.a("EVENT_TRACKING", strArr);
                    }
                }
            }
        }
        x xVar3 = this.b;
        if (xVar3 == null || (tVar = ((r0) xVar3).i) == null) {
            return;
        }
        tVar.a("TRACKING_COMPLETED", new String[0]);
        H();
        String[] strArr2 = new String[0];
        com.fyber.inneractive.sdk.player.t tVar3 = ((r0) this.b).i;
        if (tVar3 != null) {
            tVar3.a("TRACKING_COMPLETED", strArr2);
        }
        if (IAConfigManager.O.u.b.a("endcard").a() && z && (eVar = this.w) != null) {
            eVar.destroy();
        }
        e(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(View view, String str) {
        if (view != null) {
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(c(view), str);
            a(c(view), Float.NaN, Float.NaN);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(View view) {
        a(c(view), Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final long a(long j) {
        if (this.t) {
            return j;
        }
        long j2 = 12;
        try {
            j2 = Long.parseLong(IAConfigManager.O.u.b.a("vast_endcard_x_fallback_delay", Long.toString(12L)));
        } catch (Throwable unused) {
        }
        return j2 * 1000;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.controller.b bVar = this.y;
        if (bVar == null) {
            IAlog.f("Unable to unregister store promo observer - ui controller unavailable", new Object[0]);
        } else {
            ((z) bVar).b(aVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.observer.a
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.observer.b bVar) {
        if (this.E == UnitDisplayType.INTERSTITIAL) {
            IAlog.a("InneractiveFullscreenVideoAdRenderer: update: StorePromo isClicked: %s", Boolean.valueOf(bVar.b));
            this.G = bVar.b;
        }
    }
}
