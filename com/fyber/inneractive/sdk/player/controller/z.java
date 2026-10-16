package com.fyber.inneractive.sdk.player.controller;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.config.t0;
import com.fyber.inneractive.sdk.config.w0;
import com.fyber.inneractive.sdk.config.x0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.i1;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.fyber.adsession.media.InteractionType;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class z implements b, p, o, com.fyber.inneractive.sdk.player.ui.n {

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.f f1378a;
    public final s0 b;
    public final com.fyber.inneractive.sdk.config.global.r c;
    public final com.fyber.inneractive.sdk.player.ui.s d;
    public x e;
    public f0 g;
    public Runnable j;
    public boolean k;
    public u m;
    public final boolean n;
    public com.fyber.inneractive.sdk.player.ui.g u;
    public final String v;
    public int f = 0;
    public boolean h = false;
    public float i = -0.1f;
    public boolean l = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public com.fyber.inneractive.sdk.ignite.m t = com.fyber.inneractive.sdk.ignite.m.NONE;
    public boolean w = false;
    public boolean y = false;
    public final Skip x = null;

    public z(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.i iVar, s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, String str) {
        q qVar;
        this.f1378a = fVar;
        this.b = s0Var;
        this.c = rVar;
        this.d = iVar;
        this.n = z;
        this.v = str;
        iVar.setListener(this);
        if (fVar == null || (qVar = fVar.f1617a) == null) {
            return;
        }
        if (!qVar.b.contains(this)) {
            qVar.b.add(this);
        }
        q qVar2 = fVar.f1617a;
        if (qVar2.c.contains(this)) {
            return;
        }
        qVar2.c.add(this);
    }

    public static int j() {
        int i;
        try {
            i = Integer.parseInt(IAConfigManager.O.u.b.a("max_rv_tsec", Integer.toString(30)));
        } catch (Throwable unused) {
            i = 30;
        }
        if (i < 1) {
            return 30;
        }
        return i;
    }

    public void a() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.mediaplayer.o oVar) {
    }

    public abstract void b(e1 e1Var);

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public boolean b() {
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null) {
            return false;
        }
        if (this.h || fVar.f1617a == null) {
            return true;
        }
        com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
        if (sVar != null && sVar.i()) {
            return true;
        }
        int c = this.f1378a.f1617a.c();
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
        return com.fyber.inneractive.sdk.player.f.a(c, com.fyber.inneractive.sdk.player.f.a(fVar2), ((com.fyber.inneractive.sdk.player.n) fVar2).s) && !this.h && this.f == 0;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void c(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void d() {
        if (this.o && !this.l) {
            this.l = true;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void destroy() {
        q qVar;
        Application application;
        u uVar = this.m;
        if (uVar != null && (application = com.fyber.inneractive.sdk.util.o.f1770a) != null) {
            application.unregisterActivityLifecycleCallbacks(uVar);
        }
        IAlog.a("%sdestroy called", IAlog.a(this));
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null && (qVar = fVar.f1617a) != null) {
            qVar.b.remove(this);
            this.f1378a.f1617a.c.remove(this);
        }
        f();
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        this.g = null;
    }

    public final void e(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null && (qVar = fVar.f1617a) != null) {
            qVar.b(z);
        }
        this.d.setMuteButtonState(true);
    }

    public void f() {
        if (this.u != null) {
            IAlog.a("%sdestroyTextureView", IAlog.a(this));
        }
    }

    public void g(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null) {
            if (!fVar.g) {
                z();
                return;
            }
            if (z && (qVar = fVar.f1617a) != null) {
                qVar.a(0, true);
                return;
            }
            q qVar2 = fVar.f1617a;
            if (qVar2 != null) {
                com.fyber.inneractive.sdk.player.enums.b bVar = qVar2.e;
                if (bVar == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar == com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                    qVar2.a(1, true);
                } else {
                    qVar2.j();
                }
            }
        }
    }

    public abstract int h();

    public final com.fyber.inneractive.sdk.flow.endcard.k i() {
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null) {
            return ((com.fyber.inneractive.sdk.player.n) fVar).t;
        }
        return null;
    }

    public final float k() {
        try {
            return ((AudioManager) this.d.getContext().getSystemService("audio")).getStreamVolume(3);
        } catch (Throwable unused) {
            return 1.0f;
        }
    }

    public abstract int l();

    public final boolean m() {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        return (fVar == null || (qVar = fVar.f1617a) == null || (!qVar.g() && ((double) k()) != 0.0d)) ? false : true;
    }

    public final void n() {
        this.d.a(true);
        this.d.e(false);
        Runnable runnable = this.j;
        if (runnable == null) {
            if (runnable == null) {
                this.j = new t(this);
            }
            int h = h();
            IAlog.a("%s Starting buffering timeout with %d", IAlog.a(this), Integer.valueOf(h));
            this.d.postDelayed(this.j, h);
        }
    }

    public abstract void o();

    public abstract void p();

    public void q() {
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        this.d.a(false);
        z();
    }

    public abstract void r();

    public void s() {
    }

    public void t() {
        q qVar;
        this.d.a(false);
        this.d.e(false);
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        if (this.f1378a != null && w() && !this.h) {
            int c = this.f1378a.f1617a.c();
            com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
            if (com.fyber.inneractive.sdk.player.f.a(c, com.fyber.inneractive.sdk.player.f.a(fVar), ((com.fyber.inneractive.sdk.player.n) fVar).s)) {
                if (this.f <= 0) {
                    this.d.g(true);
                    g();
                } else {
                    com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
                    if (fVar2 != null && (qVar = fVar2.f1617a) != null) {
                        if (this.f >= qVar.c() / 1000) {
                            this.d.g(false);
                        }
                    }
                    if (!this.p) {
                        this.d.g(true);
                        b(this.f);
                        this.p = true;
                    }
                }
            }
        }
        f0 f0Var = this.g;
        if (f0Var != null && !this.k) {
            this.k = true;
            f0Var.j();
        }
        this.q = false;
    }

    public final void u() {
        com.fyber.inneractive.sdk.player.ui.g gVar;
        com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
        if (sVar != null) {
            sVar.o();
        }
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null && fVar.f1617a != null && (gVar = this.u) != null) {
            gVar.invalidate();
            this.u.requestLayout();
        }
        com.fyber.inneractive.sdk.player.ui.s sVar2 = this.d;
        if (sVar2 != null) {
            sVar2.invalidate();
            this.d.requestLayout();
        }
    }

    public void v() {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || (qVar = fVar.f1617a) == null) {
            return;
        }
        if (qVar.e == com.fyber.inneractive.sdk.player.enums.b.Paused) {
            IAlog.a("%spauseVideo called in bad state! %s", IAlog.a(this), qVar.e);
            return;
        }
        IAlog.a("%spauseVideo %s", IAlog.a(this), this.d);
        TextureView textureView = qVar.j;
        if (textureView == null || textureView.getParent() == null || textureView.getParent() != this.d.getTextureHost()) {
            return;
        }
        qVar.i();
    }

    public abstract boolean w();

    public final void x() {
        Boolean c;
        com.fyber.inneractive.sdk.config.global.r rVar = this.c;
        com.fyber.inneractive.sdk.config.global.features.u uVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.u) rVar.a(com.fyber.inneractive.sdk.config.global.features.u.class) : null;
        boolean booleanValue = (uVar == null || (c = uVar.c("show_cta")) == null) ? true : c.booleanValue();
        f0 f0Var = this.g;
        if (f0Var != null) {
            this.t = f0Var.o();
        }
        com.fyber.inneractive.sdk.ignite.m mVar = this.t;
        this.d.a(mVar == com.fyber.inneractive.sdk.ignite.m.NONE ? booleanValue : true, mVar);
    }

    public final void y() {
        com.fyber.inneractive.sdk.flow.endcard.b bVar;
        String str;
        com.fyber.inneractive.sdk.flow.storepromo.controller.c cVar;
        boolean z;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar2;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar3;
        View view;
        View view2;
        com.fyber.inneractive.sdk.flow.endcard.b bVar2;
        com.fyber.inneractive.sdk.model.vast.o oVar;
        this.d.g();
        com.fyber.inneractive.sdk.flow.endcard.k i = i();
        if (i != null) {
            bVar = i.a();
            com.fyber.inneractive.sdk.flow.endcard.h hVar = i.e;
            com.fyber.inneractive.sdk.flow.endcard.m mVar = i.b;
            hVar.getClass();
            if (mVar.f1198a.size() >= 1) {
                com.fyber.inneractive.sdk.flow.endcard.b a2 = mVar.a();
                com.fyber.inneractive.sdk.model.vast.i iVar = com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card;
                Iterator it = mVar.f1198a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        bVar2 = null;
                        break;
                    } else {
                        bVar2 = (com.fyber.inneractive.sdk.flow.endcard.b) it.next();
                        if (bVar2.i() == iVar) {
                            break;
                        }
                    }
                }
                if (a2 != null && a2.i() != com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card && a2.i() != com.fyber.inneractive.sdk.model.vast.i.Default_End_Card && a2.l() && (oVar = a2.c.e.f) != null && oVar.d && bVar2 != null && bVar2.l()) {
                    hVar.a(a2, bVar2.l());
                    hVar.a(bVar2, true, a2.k());
                } else if (a2 == bVar2 || a2 == null || a2.g() == com.fyber.inneractive.sdk.util.g.DEFAULT_ENDCARD) {
                    hVar.a(a2, false, false);
                } else {
                    hVar.a(a2, false);
                }
            }
        } else {
            bVar = null;
        }
        if (bVar == null) {
            com.fyber.inneractive.sdk.flow.endcard.k i2 = i();
            if (i2 != null) {
                com.fyber.inneractive.sdk.response.g gVar = i2.f1189a.d;
                if (!((gVar == null || (str = gVar.E) == null || !TextUtils.equals(str, "1")) ? false : true)) {
                    return;
                }
            }
            f0 f0Var = this.g;
            if (f0Var != null) {
                f0Var.i();
                return;
            }
            return;
        }
        a(bVar);
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if ((fVar != null ? ((com.fyber.inneractive.sdk.player.n) fVar).v : null) != null) {
            com.fyber.inneractive.sdk.flow.storepromo.b bVar3 = fVar != null ? ((com.fyber.inneractive.sdk.player.n) fVar).v : null;
            com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
            com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar4 = bVar3.d;
            if (bVar4 == null || (cVar = bVar4.c) == null || !(z = cVar.e)) {
                bVar3.f1215a.a();
                bVar3.a();
                bVar3.a((bVar3.d == null ? com.fyber.inneractive.sdk.flow.storepromo.events.a.CONTROLLER_NOT_INITIALIZED : com.fyber.inneractive.sdk.flow.storepromo.events.a.TEMPLATE_NOT_LOADED).name(), (String) null, (String) null);
                return;
            }
            bVar4.i = i;
            if (cVar == null || !z || (cVar2 = bVar4.d) == null || bVar4.g) {
                return;
            }
            if (cVar2.b == null || (view2 = cVar2.f1238a) == null || view2.getParent() == null || cVar2.b.getVisibility() != 0) {
                com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar4 = bVar4.d;
                if (cVar4.b == null || cVar4.f1238a == null) {
                    IAlog.f("StorePromoView: show: missing container or content", new Object[0]);
                    return;
                }
                cVar4.a();
                com.fyber.inneractive.sdk.util.t.a(cVar4.b);
                sVar.addView(cVar4.b);
                cVar4.f1238a.setAnimation(cVar4.c);
                cVar4.b.setVisibility(0);
                com.fyber.inneractive.sdk.flow.storepromo.b bVar5 = cVar4.f;
                if (bVar5 != null) {
                    com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar6 = bVar5.d;
                    com.fyber.inneractive.sdk.flow.storepromo.observer.b bVar7 = new com.fyber.inneractive.sdk.flow.storepromo.observer.b((bVar6 == null || (cVar3 = bVar6.d) == null || cVar3.b == null || (view = cVar3.f1238a) == null || view.getParent() == null || cVar3.b.getVisibility() != 0) ? false : true, bVar5.i);
                    Iterator it2 = bVar5.h.iterator();
                    while (it2.hasNext()) {
                        ((com.fyber.inneractive.sdk.flow.storepromo.observer.a) it2.next()).a(bVar7);
                    }
                    JSONObject jSONObject = new JSONObject();
                    Integer valueOf = Integer.valueOf(bVar5.g);
                    try {
                        jSONObject.put("screenshots", valueOf);
                    } catch (Exception unused) {
                        IAlog.f("Got exception adding param to json object: %s, %s", "screenshots", valueOf);
                    }
                    com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.VAST_EVENT_SP_IMPRESSION;
                    InneractiveAdRequest inneractiveAdRequest = bVar5.c;
                    com.fyber.inneractive.sdk.response.e eVar = bVar5.b;
                    String str2 = bVar5.f;
                    com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(uVar, inneractiveAdRequest, eVar);
                    try {
                        jSONObject.put("templateURL", str2);
                    } catch (Exception unused2) {
                        IAlog.f("Got exception adding param to json object: %s, %s", "templateURL", str2);
                    }
                    wVar.f.put(jSONObject);
                    wVar.a((String) null);
                }
            }
        }
    }

    public void z() {
        boolean z;
        q qVar;
        q qVar2;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null && (((qVar2 = fVar.f1617a) != null && qVar2.e == com.fyber.inneractive.sdk.player.enums.b.Completed) || this.q)) {
            fVar.a();
        }
        boolean a2 = IAConfigManager.O.u.b.a("endcard").a();
        com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
        sVar.e((fVar2 == null || (qVar = fVar2.f1617a) == null || qVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed) && !(((z = this.q) && !a2) || this.r || (z && a2)));
    }

    public final void a(com.fyber.inneractive.sdk.flow.endcard.b bVar) {
        i1 i1Var;
        IAlog.a("IAVideoUIControllerBase: showEndCard: dismiss time: %d sec.", Integer.valueOf(bVar.f));
        if (bVar instanceof com.fyber.inneractive.sdk.flow.endcard.c) {
            com.fyber.inneractive.sdk.flow.endcard.c cVar = (com.fyber.inneractive.sdk.flow.endcard.c) bVar;
            com.fyber.inneractive.sdk.player.ui.b bVar2 = new com.fyber.inneractive.sdk.player.ui.b(a(cVar.d()));
            if (bVar2.f1639a) {
                w wVar = new w(this);
                com.fyber.inneractive.sdk.flow.endcard.a aVar = (com.fyber.inneractive.sdk.flow.endcard.a) cVar.f();
                if ((aVar instanceof com.fyber.inneractive.sdk.flow.endcard.u) && (i1Var = ((com.fyber.inneractive.sdk.flow.endcard.u) aVar).e().f1359a) != null) {
                    i1Var.setListener(wVar);
                }
                this.d.e(false);
                this.d.a(cVar, bVar2);
                ViewGroup viewGroup = this.d.l;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                    return;
                }
                return;
            }
            return;
        }
        if (bVar instanceof com.fyber.inneractive.sdk.flow.endcard.o) {
            com.fyber.inneractive.sdk.flow.endcard.o oVar = (com.fyber.inneractive.sdk.flow.endcard.o) bVar;
            com.fyber.inneractive.sdk.player.ui.b bVar3 = new com.fyber.inneractive.sdk.player.ui.b(a(oVar.d()));
            if (bVar3.f1639a) {
                w wVar2 = new w(this);
                i1 i1Var2 = ((com.fyber.inneractive.sdk.flow.endcard.p) oVar.f()).e().f1359a;
                if (i1Var2 != null) {
                    i1Var2.setListener(wVar2);
                }
                this.d.a(oVar, bVar3);
                return;
            }
            return;
        }
        if (bVar instanceof com.fyber.inneractive.sdk.flow.endcard.d) {
            com.fyber.inneractive.sdk.flow.endcard.d dVar = (com.fyber.inneractive.sdk.flow.endcard.d) bVar;
            com.fyber.inneractive.sdk.player.ui.c d = dVar.d();
            String str = this.v;
            if (str == null) {
                com.fyber.inneractive.sdk.config.global.r rVar = this.c;
                if (rVar != null) {
                    com.fyber.inneractive.sdk.config.global.features.d dVar2 = (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class);
                    dVar2.d(IAConfigManager.O.o);
                    com.fyber.inneractive.sdk.model.vast.a aVar2 = dVar2.e;
                    if (aVar2 != null && aVar2.d) {
                        str = aVar2.f1280a;
                    }
                }
                str = null;
            }
            d.c = str;
            com.fyber.inneractive.sdk.player.ui.b bVar4 = new com.fyber.inneractive.sdk.player.ui.b(a(d));
            if (bVar4.f1639a) {
                this.d.e(false);
                this.d.a(dVar, bVar4);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.n
    public void c() {
        IAlog.a("%sonVideoViewDetachedFromWindow", IAlog.a(this));
        f();
    }

    public final void f(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        com.fyber.inneractive.sdk.config.global.features.c cVar;
        t0 t0Var;
        s0 s0Var = this.b;
        boolean z2 = (s0Var == null || (t0Var = ((r0) s0Var).f) == null || t0Var.j != UnitDisplayType.REWARDED) ? false : true;
        if (InneractiveAdManager.isCurrentUserAChild() && z2 && this.d != null && (fVar = this.f1378a) != null && (qVar = fVar.f1617a) != null) {
            int b = qVar.b() / 1000;
            int j = j();
            if ((this.f1378a.f1617a.c() / 1000) - b <= 0 || b < j) {
                Context context = this.d.getContext();
                com.fyber.inneractive.sdk.config.global.r rVar = this.c;
                if (rVar != null) {
                    com.fyber.inneractive.sdk.config.global.features.c cVar2 = (com.fyber.inneractive.sdk.config.global.features.c) rVar.a(com.fyber.inneractive.sdk.config.global.features.c.class);
                    cVar2.getClass();
                    if (new ArrayList(cVar2.c.values()).size() > 0) {
                        cVar = (com.fyber.inneractive.sdk.config.global.features.c) this.c.a(com.fyber.inneractive.sdk.config.global.features.c.class);
                        new e0(context, cVar, new v(this, z)).b.show();
                        return;
                    }
                }
                cVar = null;
                new e0(context, cVar, new v(this, z)).b.show();
                return;
            }
        }
        d(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00cd, code lost:
    
        if (r1.e == com.fyber.inneractive.sdk.player.enums.b.Completed) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d4, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d8, code lost:
    
        if (r5.r != false) goto L64;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        t0 t0Var;
        f0 f0Var;
        com.fyber.inneractive.sdk.player.f fVar2;
        q qVar2;
        q qVar3;
        com.fyber.inneractive.sdk.measurement.f fVar3;
        s0 s0Var;
        t0 t0Var2;
        this.q = true;
        x0 x0Var = IAConfigManager.O.x;
        if (z && x0Var != null && (s0Var = this.b) != null && (t0Var2 = ((r0) s0Var).f) != null) {
            x0Var.a(t0Var2.j, "LAST_VAST_SKIPED", "1");
        }
        com.fyber.inneractive.sdk.player.f fVar4 = this.f1378a;
        if (fVar4 != null && (qVar3 = fVar4.f1617a) != null) {
            qVar3.k();
            this.f1378a.f1617a.i();
            if (z && (fVar3 = this.f1378a.e) != null && fVar3.c != null) {
                IAlog.a("%s skipped", "OMVideo");
                try {
                    fVar3.c.skipped();
                } catch (Throwable th) {
                    fVar3.a(th);
                }
            }
        }
        if (!this.d.h()) {
            this.d.a(false);
            Runnable runnable = this.j;
            if (runnable != null) {
                this.d.removeCallbacks(runnable);
                this.j = null;
            }
            this.k = false;
            this.h = true;
            s0 s0Var2 = this.b;
            if (s0Var2 != null && (t0Var = ((r0) s0Var2).f) != null && t0Var.j == UnitDisplayType.REWARDED && (f0Var = this.g) != null) {
                if (this.q && (fVar2 = this.f1378a) != null && (qVar2 = fVar2.f1617a) != null) {
                    int b = qVar2.b();
                    int c = qVar2.c() - b;
                    int j = j() * 1000;
                    if (c > 0 && b < j) {
                        this.y = true;
                    } else {
                        this.g.onCompleted();
                    }
                } else {
                    f0Var.onCompleted();
                }
            }
        }
        if (z) {
            boolean a2 = IAConfigManager.O.u.b.a("endcard").a();
            com.fyber.inneractive.sdk.player.f fVar5 = this.f1378a;
            if (fVar5 != null) {
                q qVar4 = fVar5.f1617a;
                if (qVar4 != null) {
                }
            }
            if (this.q) {
            }
        }
        y();
        f0 f0Var2 = this.g;
        if (f0Var2 != null && (this.f <= 0 || this.h || ((fVar = this.f1378a) != null && (qVar = fVar.f1617a) != null && qVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed))) {
            f0Var2.a(z);
        }
        f();
    }

    public void e() {
        q qVar;
        q qVar2;
        com.fyber.inneractive.sdk.measurement.f fVar;
        if (this.u == null) {
            com.fyber.inneractive.sdk.player.ui.g gVar = new com.fyber.inneractive.sdk.player.ui.g(this.d);
            this.u = gVar;
            gVar.setId(R.id.ia_inn_texture_view);
            com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
            if (fVar2 != null && (fVar = fVar2.e) != null) {
                com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
                View[] trackingFriendlyView = sVar.getTrackingFriendlyView();
                AdSession adSession = fVar.f1269a;
                if (adSession != null) {
                    try {
                        adSession.registerAdView(sVar);
                    } catch (Throwable th) {
                        fVar.a(th);
                    }
                }
                if (fVar.f1269a != null && trackingFriendlyView != null) {
                    for (View view : trackingFriendlyView) {
                        if (view != null) {
                            try {
                                fVar.f1269a.addFriendlyObstruction(view, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
                            } catch (Throwable th2) {
                                fVar.a(th2);
                            }
                        }
                    }
                }
                View[] trackingFriendlyViewObstructionPurposeOther = this.d.getTrackingFriendlyViewObstructionPurposeOther();
                if (fVar.f1269a != null) {
                    for (View view2 : trackingFriendlyViewObstructionPurposeOther) {
                        if (view2 != null) {
                            try {
                                fVar.f1269a.addFriendlyObstruction(view2, FriendlyObstructionPurpose.OTHER, null);
                            } catch (Throwable th3) {
                                fVar.a(th3);
                            }
                        }
                    }
                }
            }
        }
        IAlog.a("%sconnectToTextureView called %s", IAlog.a(this), this.d.getTextureHost());
        if (this.u != null && this.d.getTextureHost().equals(this.u.getParent())) {
            IAlog.a("%sconnectToTextureView called but already connected", IAlog.a(this));
            return;
        }
        com.fyber.inneractive.sdk.player.f fVar3 = this.f1378a;
        if (fVar3 != null && (qVar2 = fVar3.f1617a) != null) {
            qVar2.a(this.u);
        }
        com.fyber.inneractive.sdk.player.ui.g gVar2 = this.u;
        if (gVar2 != null && gVar2.getParent() == null) {
            IAlog.a("%supdateView adding texture to parent", IAlog.a(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.d.getTextureHost().addView(this.u, layoutParams);
        }
        this.l = false;
        x xVar = new x(this);
        this.e = xVar;
        com.fyber.inneractive.sdk.player.f fVar4 = this.f1378a;
        if (fVar4 == null || (qVar = fVar4.f1617a) == null) {
            return;
        }
        qVar.d = xVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void b(boolean z) {
        IAlog.a("%sinitUI", IAlog.a(this));
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || fVar.f1617a == null) {
            return;
        }
        this.d.setUnitConfig(this.b);
        this.d.a(this.n, this.f1378a.f1617a.f(), this.f1378a.f1617a.e());
        if (w()) {
            this.f = l();
        } else {
            this.d.g(false);
        }
        if (!z) {
            a(this.f1378a.f1617a.b());
            a(this.f1378a.f1617a.e, false);
        }
        this.d.setMuteButtonState(m());
    }

    public final void g() {
        if (w()) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.d dVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class) : null;
            if (dVar != null) {
                dVar.d(IAConfigManager.O.o);
                com.fyber.inneractive.sdk.model.vast.a aVar = dVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.b;
                }
            }
            if (TextUtils.isEmpty(this.v) && str != null) {
                this.d.setSkipText(str);
            } else {
                com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
                sVar.setSkipText(sVar.getContext().getString(R.string.ia_video_skip_text));
            }
            this.d.f();
            this.f = 0;
            f0 f0Var = this.g;
            if (f0Var != null) {
                f0Var.c();
            }
        }
    }

    public final void b(int i) {
        if (this.d != null) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.d dVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class) : null;
            if (dVar != null) {
                dVar.d(IAConfigManager.O.o);
                com.fyber.inneractive.sdk.model.vast.a aVar = dVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.c;
                }
            }
            if (TextUtils.isEmpty(this.v) && str != null) {
                this.d.setSkipText(str.replaceFirst("\\[TIME\\]", Integer.toString(i)));
            } else {
                this.d.setSkipText(String.valueOf(i));
            }
        }
    }

    public final void b(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null) {
            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
            if (nVar.v != null) {
                com.fyber.inneractive.sdk.flow.storepromo.b bVar = nVar.v;
                bVar.getClass();
                synchronized (com.fyber.inneractive.sdk.flow.storepromo.b.k) {
                    bVar.h.remove(aVar);
                }
                return;
            }
        }
        IAlog.f("Unable to remove store promo observer, promo manager is unavailable", new Object[0]);
    }

    public final com.fyber.inneractive.sdk.player.ui.c a(com.fyber.inneractive.sdk.player.ui.c cVar) {
        String string;
        cVar.h = this.f1378a != null && com.fyber.inneractive.sdk.player.f.a(this.c, this.t);
        com.fyber.inneractive.sdk.config.global.r rVar = this.c;
        com.fyber.inneractive.sdk.config.global.features.n nVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.n) rVar.a(com.fyber.inneractive.sdk.config.global.features.n.class) : null;
        if (nVar != null) {
            string = nVar.a("app_info_button_text", "App Info");
            if (string != null && string.length() > 30) {
                string = string.substring(0, 30);
            }
        } else {
            string = this.d.getContext().getString(R.string.ia_video_app_info_text);
        }
        cVar.i = string;
        cVar.g = this.t;
        return cVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("%sonPlayerStateChanged with %s", IAlog.a(this), bVar);
        a(bVar, true);
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar, boolean z) {
        f0 f0Var;
        String str;
        com.fyber.inneractive.sdk.player.ui.s sVar;
        switch (y.f1377a[bVar.ordinal()]) {
            case 1:
                boolean z2 = this.w;
                if (z2) {
                    IAlog.a("IAVideoUIControllerBase playerStateUpdated=%s mBuffering=%s", bVar, String.valueOf(z2));
                    n();
                    break;
                }
                break;
            case 2:
                if (this.o) {
                    z();
                    s();
                    break;
                }
                break;
            case 3:
                if (this.o) {
                    this.w = true;
                    n();
                    break;
                }
                break;
            case 4:
                if (this.w) {
                    this.w = false;
                }
                if (this.o) {
                    t();
                    break;
                }
                break;
            case 5:
                q();
                break;
            case 6:
                if (!this.o) {
                    com.fyber.inneractive.sdk.flow.endcard.k i = i();
                    if (i != null) {
                        com.fyber.inneractive.sdk.response.g gVar = i.f1189a.d;
                        if (!((gVar == null || (str = gVar.E) == null || !TextUtils.equals(str, "1")) ? false : true)) {
                        }
                    }
                    if (this.s) {
                    }
                }
                this.s = true;
                if (!this.d.h()) {
                    this.d.a(false);
                    Runnable runnable = this.j;
                    if (runnable != null) {
                        this.d.removeCallbacks(runnable);
                        this.j = null;
                    }
                    z();
                    y();
                    this.k = false;
                    this.h = true;
                }
                if (z && (f0Var = this.g) != null) {
                    f0Var.onCompleted();
                    break;
                }
                break;
            case 7:
                if (this.o || ((sVar = this.d) != null && sVar.isShown())) {
                    f(false);
                    break;
                }
                break;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.o
    public final void a(int i) {
        s0 s0Var;
        t0 t0Var;
        q qVar;
        q qVar2;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || fVar.f1617a == null) {
            return;
        }
        float k = k();
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
        if (fVar2 != null && (qVar = fVar2.f1617a) != null && qVar.h()) {
            float f = this.i;
            if (k != f) {
                if (k > 0.0f && f >= 0.0f && m()) {
                    com.fyber.inneractive.sdk.player.f fVar3 = this.f1378a;
                    if (fVar3 != null && (qVar2 = fVar3.f1617a) != null) {
                        qVar2.d(true);
                    }
                    this.d.setMuteButtonState(false);
                } else if (k == 0.0d) {
                    e(true);
                }
            }
            this.d.setMuteButtonState(m());
        }
        this.i = k;
        int c = this.f1378a.f1617a.c();
        int b = this.f1378a.f1617a.b();
        int i2 = b / 1000;
        int i3 = c / 1000;
        int i4 = i3 - i2;
        if (i4 < 0 || (!this.f1378a.f1617a.h() && b == c)) {
            i4 = 0;
        }
        if (this.d.l()) {
            return;
        }
        this.d.setRemainingTime(Integer.toString(i4));
        if (this.f < i3) {
            if (w()) {
                int c2 = this.f1378a.f1617a.c();
                com.fyber.inneractive.sdk.player.f fVar4 = this.f1378a;
                if (com.fyber.inneractive.sdk.player.f.a(c2, com.fyber.inneractive.sdk.player.f.a(fVar4), ((com.fyber.inneractive.sdk.player.n) fVar4).s) && !this.h) {
                    int i5 = this.f;
                    if (i2 < i5) {
                        b(i5 - i2);
                    } else {
                        this.f = 0;
                        g();
                    }
                    this.d.g(true);
                }
            }
            this.d.g(false);
        } else {
            this.d.g(false);
            b(i4);
        }
        if (this.f1378a.f1617a.e != com.fyber.inneractive.sdk.player.enums.b.Paused) {
            this.d.a(c, b);
            int j = j();
            if (i3 > j && i2 > j && (s0Var = this.b) != null && (t0Var = ((r0) s0Var).f) != null && t0Var.j == UnitDisplayType.REWARDED) {
                g();
                this.d.g(true);
            }
        }
        f0 f0Var = this.g;
        if (f0Var != null) {
            f0Var.onProgress(c, b);
        }
    }

    public void a(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        x xVar;
        com.fyber.inneractive.sdk.player.ui.s sVar;
        Application application;
        if (this.o == z || (fVar = this.f1378a) == null || fVar.f1617a == null) {
            return;
        }
        IAlog.a("%sonVisibilityChanged: %s my video view is%s", IAlog.a(this), Boolean.valueOf(z), this.d);
        if (z) {
            this.o = true;
            com.fyber.inneractive.sdk.player.enums.b bVar = this.f1378a.f1617a.e;
            if (bVar != com.fyber.inneractive.sdk.player.enums.b.Completed && !this.d.h()) {
                if (bVar != com.fyber.inneractive.sdk.player.enums.b.Error) {
                    if (bVar == com.fyber.inneractive.sdk.player.enums.b.Idle) {
                        this.f1378a.getClass();
                    } else {
                        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Start_in_progress || bVar == com.fyber.inneractive.sdk.player.enums.b.Playing) {
                            t();
                        }
                        com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
                        if (!fVar2.j) {
                            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar2;
                            nVar.a(nVar.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_CREATIVE_VIEW);
                            fVar2.j = true;
                        }
                        e();
                        if (this.m != null || (application = com.fyber.inneractive.sdk.util.o.f1770a) == null) {
                            return;
                        }
                        u uVar = new u(this);
                        this.m = uVar;
                        application.registerActivityLifecycleCallbacks(uVar);
                        return;
                    }
                }
                f(false);
                return;
            }
            if (!this.s) {
                this.s = true;
                if (!this.y) {
                    if (!this.d.h()) {
                        this.d.a(false);
                        Runnable runnable = this.j;
                        if (runnable != null) {
                            this.d.removeCallbacks(runnable);
                            this.j = null;
                        }
                        z();
                        y();
                        this.k = false;
                        this.h = true;
                    }
                    f0 f0Var = this.g;
                    if (f0Var != null) {
                        f0Var.onCompleted();
                    }
                }
            }
            com.fyber.inneractive.sdk.player.ui.s sVar2 = this.d;
            if (sVar2 != null) {
                sVar2.k();
                return;
            }
            return;
        }
        this.o = false;
        com.fyber.inneractive.sdk.player.f fVar3 = this.f1378a;
        if (fVar3 != null && (qVar = fVar3.f1617a) != null && (xVar = qVar.d) != null && xVar.equals(this.e)) {
            IAlog.a("%sonVisibilityChanged pausing video", IAlog.a(this));
            v();
            if (this.f1378a.f1617a.e == com.fyber.inneractive.sdk.player.enums.b.Completed || ((sVar = this.d) != null && sVar.h())) {
                this.d.j();
            }
        }
        com.fyber.inneractive.sdk.player.ui.s sVar3 = this.d;
        if (sVar3 == null || !sVar3.h) {
            f();
        }
    }

    public final void a(String str) {
        x0 x0Var = IAConfigManager.O.x;
        s0 s0Var = this.b;
        if (s0Var != null) {
            r0 r0Var = (r0) s0Var;
            if (r0Var.f != null) {
                x0Var.a(r0Var.f.j, "LAST_VAST_CLICKED_TYPE", str);
            }
        }
    }

    public final void a(int i, e1 e1Var) {
        q qVar;
        IAlog.a("onClicked called with %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                if (m()) {
                    com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
                    if (fVar != null && (qVar = fVar.f1617a) != null) {
                        qVar.d(true);
                    }
                    this.d.setMuteButtonState(false);
                    com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
                    if (fVar2 != null) {
                        com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar2;
                        nVar.a(nVar.p, VideoClickOrigin.MUTE, com.fyber.inneractive.sdk.model.vast.x.EVENT_UNMUTE);
                    }
                } else {
                    e(true);
                    com.fyber.inneractive.sdk.player.f fVar3 = this.f1378a;
                    if (fVar3 != null) {
                        com.fyber.inneractive.sdk.player.n nVar2 = (com.fyber.inneractive.sdk.player.n) fVar3;
                        nVar2.a(nVar2.p, VideoClickOrigin.MUTE, com.fyber.inneractive.sdk.model.vast.x.EVENT_MUTE);
                    }
                }
                this.d.setMuteButtonState(m());
                break;
            case 2:
                r();
                break;
            case 3:
                a(w0.CTA_BUTTON.a());
                a(false, VideoClickOrigin.CTA, e1Var);
                break;
            case 4:
                a(w0.COMPANION.a());
                com.fyber.inneractive.sdk.player.f fVar4 = this.f1378a;
                String str = null;
                if (fVar4 != null) {
                    com.fyber.inneractive.sdk.player.n nVar3 = (com.fyber.inneractive.sdk.player.n) fVar4;
                    com.fyber.inneractive.sdk.flow.endcard.b a2 = nVar3.t.b.a();
                    if (a2 instanceof com.fyber.inneractive.sdk.flow.endcard.c) {
                        com.fyber.inneractive.sdk.flow.endcard.c cVar = (com.fyber.inneractive.sdk.flow.endcard.c) a2;
                        String str2 = cVar.g.g;
                        if (TextUtils.isEmpty(str2)) {
                            com.fyber.inneractive.sdk.model.vast.b bVar = nVar3.p;
                            if (bVar != null) {
                                str = bVar.b;
                            }
                        } else {
                            str = str2;
                        }
                        fVar4.a(cVar, VideoClickOrigin.COMPANION, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                    }
                }
                com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
                if (sVar != null) {
                    sVar.e();
                }
                f0 f0Var = this.g;
                if (f0Var != null) {
                    f0Var.a(str, e1Var, false);
                    break;
                }
                break;
            case 5:
                p();
                break;
            case 6:
                f(true);
                break;
            case 7:
                b(e1Var);
                break;
            case 8:
                a(w0.COMPANION.a());
                a(true, VideoClickOrigin.COMPANION, e1Var);
                break;
            case 9:
                com.fyber.inneractive.sdk.player.f fVar5 = this.f1378a;
                if (fVar5 != null && !this.d.h) {
                    fVar5.g = true;
                    g(false);
                    break;
                }
                break;
            case 10:
                a(w0.APP_INFO.a());
                a(false, VideoClickOrigin.APP_INFO, e1Var);
                break;
            case 11:
                a(w0.STORE_PROMO.a());
                a(false, VideoClickOrigin.STORE_PROMO, e1Var);
                break;
        }
    }

    public final boolean a(boolean z, VideoClickOrigin videoClickOrigin, e1 e1Var) {
        com.fyber.inneractive.sdk.util.g gVar;
        com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
        if (sVar != null) {
            sVar.e();
        }
        f0 f0Var = this.g;
        boolean z2 = false;
        if (f0Var != null) {
            if (z) {
                com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
                if (fVar != null) {
                    com.fyber.inneractive.sdk.model.vast.b bVar = ((com.fyber.inneractive.sdk.player.n) fVar).p;
                    f0Var.a(bVar != null ? bVar.b : null, e1Var, true);
                    com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) this.f1378a;
                    nVar.a(nVar.p, videoClickOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                }
            } else {
                int i = y.b[videoClickOrigin.ordinal()];
                if (i == 1) {
                    gVar = com.fyber.inneractive.sdk.util.g.STORE_PROMO_CTA;
                } else if (i == 2) {
                    gVar = com.fyber.inneractive.sdk.util.g.VIDEO_CLICK;
                } else if (i != 3) {
                    gVar = com.fyber.inneractive.sdk.util.g.VIDEO_CTA;
                } else {
                    gVar = com.fyber.inneractive.sdk.util.g.VIDEO_APP_INFO;
                }
                com.fyber.inneractive.sdk.util.b0 a2 = this.g.a(e1Var, gVar);
                com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
                if (fVar2 != null) {
                    com.fyber.inneractive.sdk.player.n nVar2 = (com.fyber.inneractive.sdk.player.n) fVar2;
                    nVar2.a(nVar2.p, videoClickOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                    com.fyber.inneractive.sdk.measurement.f fVar3 = this.f1378a.e;
                    if (fVar3 != null && fVar3.c != null) {
                        IAlog.a("%s click", "OMVideo");
                        try {
                            fVar3.c.adUserInteraction(InteractionType.CLICK);
                        } catch (Throwable th) {
                            fVar3.a(th);
                        }
                    }
                }
                if (a2.f1751a != com.fyber.inneractive.sdk.util.e0.FAILED) {
                    z2 = true;
                }
            }
        }
        if (videoClickOrigin == VideoClickOrigin.VIDEO) {
            a(w0.VIDEO.a());
        }
        return z2;
    }

    public final boolean a(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null) {
            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
            if (nVar.v != null) {
                com.fyber.inneractive.sdk.flow.storepromo.b bVar = nVar.v;
                bVar.getClass();
                synchronized (com.fyber.inneractive.sdk.flow.storepromo.b.k) {
                    bVar.h.add(aVar);
                }
                return true;
            }
        }
        IAlog.f("Unable to add store promo observer, promo manager is unavailable", new Object[0]);
        return false;
    }
}
