package com.fyber.inneractive.sdk.player.controller;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;

/* loaded from: classes4.dex */
public final class s extends z {
    public final float A;
    public float B;
    public boolean C;
    public boolean D;
    public boolean E;
    public r z;

    public s(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.i iVar, r0 r0Var, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, String str) {
        super(fVar, iVar, r0Var, rVar, z, str);
        this.B = 0.0f;
        this.C = false;
        this.D = false;
        this.E = false;
        this.A = ((r0) this.b).g.b.intValue() / 100.0f;
        D();
    }

    public final void A() {
        if (this.g == null || this.E) {
            return;
        }
        C();
        super.f();
        com.fyber.inneractive.sdk.renderers.n nVar = (com.fyber.inneractive.sdk.renderers.n) ((a0) this.g);
        com.fyber.inneractive.sdk.renderers.o oVar = nVar.f1721a;
        InneractiveUnitController.EventsListener eventsListener = oVar.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdExpanded(oVar.f1175a);
        }
        ViewGroup viewGroup = nVar.f1721a.p;
        if (viewGroup != null && viewGroup.getContext() != null) {
            com.fyber.inneractive.sdk.renderers.o oVar2 = nVar.f1721a;
            com.fyber.inneractive.sdk.display.a bVar = oVar2.b instanceof com.fyber.inneractive.sdk.dv.a ? new com.fyber.inneractive.sdk.display.b() : new com.fyber.inneractive.sdk.display.c();
            if (bVar instanceof com.fyber.inneractive.sdk.display.c) {
                Context context = oVar2.p.getContext();
                InneractiveAdSpot inneractiveAdSpot = nVar.f1721a.f1175a;
                Intent intent = new Intent(context, (Class<?>) InneractiveFullscreenAdActivity.class);
                intent.putExtra("spotId", inneractiveAdSpot.getLocalUniqueId());
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                try {
                    IAlog.a("%sIAInterstitialUtil: Opening interstitial for spot id: %s", IAlog.a(context), inneractiveAdSpot.getLocalUniqueId());
                    context.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    IAlog.c("%sIAInterstitialUtil: InneractiveFullscreenAdActivity.class not found. Did you declare InneractiveFullscreenAdActivity in your manifest?", IAlog.a(context));
                }
            }
        }
        IAlog.a("%sopening fullscreen", IAlog.a(this));
        this.E = true;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null) {
            com.fyber.inneractive.sdk.player.n nVar2 = (com.fyber.inneractive.sdk.player.n) fVar;
            nVar2.a(nVar2.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_FULLSCREEN, com.fyber.inneractive.sdk.model.vast.x.EVENT_EXPAND);
        }
    }

    public final void B() {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        com.fyber.inneractive.sdk.player.ui.s sVar;
        if (this.B < this.A || (fVar = this.f1378a) == null || (qVar = fVar.f1617a) == null || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed || (sVar = this.d) == null || sVar.h() || this.f1378a.f1617a.j == null) {
            return;
        }
        if (((r0) this.b).f.f1126a.booleanValue() || this.C) {
            c(IAConfigManager.O.i.f1103a);
        }
    }

    public final void C() {
        if (this.z != null) {
            IAlog.a("%sCancelling play runnable", IAlog.a(this));
            this.d.removeCallbacks(this.z);
            this.z = null;
        }
    }

    public final void D() {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || (qVar = fVar.f1617a) == null || qVar.n) {
            return;
        }
        if (((r0) this.b).f.d.booleanValue()) {
            this.f1378a.f1617a.b(false);
        } else {
            if (m()) {
                return;
            }
            this.f1378a.f1617a.d(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.ui.n
    public final void a(boolean z) {
        if (z) {
            a(this.B);
        }
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.b
    public final boolean b() {
        return true;
    }

    public final void c(int i) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || (qVar = fVar.f1617a) == null || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Playing || this.z != null) {
            return;
        }
        IAlog.a("%splayVideo %s", IAlog.a(this), this.d);
        if (i == 0) {
            g(false);
            return;
        }
        r rVar = new r(this);
        this.z = rVar;
        this.d.postDelayed(rVar, i);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.b
    public final void destroy() {
        C();
        this.g = null;
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void e() {
        super.e();
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null && fVar.f1617a != null) {
            IAlog.a("%sconnectToTextureView playing state = %s", IAlog.a(this), this.f1378a.f1617a.e);
            if (this.f1378a.f1617a.h()) {
                this.d.e(!this.f1378a.g);
                D();
            }
        }
        a(this.B);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void f() {
        C();
        super.f();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void g(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || fVar.f1617a == null) {
            return;
        }
        D();
        super.g(false);
    }

    public final void h(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        this.D = z;
        if (!z || (fVar = this.f1378a) == null || (qVar = fVar.f1617a) == null || qVar.j != null || !this.d.e || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed) {
            return;
        }
        e();
        a(this.B);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int l() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void p() {
        A();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void q() {
        super.q();
        C();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void r() {
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || fVar.f1617a == null) {
            return;
        }
        e();
        g(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void s() {
        B();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void t() {
        super.t();
        if (((r0) this.b).f.i != TapAction.FULLSCREEN) {
            this.d.n();
        }
        x();
        this.C = true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void v() {
        C();
        super.v();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final boolean w() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.b
    public final void b(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null && (qVar = fVar.f1617a) != null && qVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed) {
            if (((r0) this.b).f.i != TapAction.FULLSCREEN) {
                this.d.n();
            }
            x();
        }
        super.b(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void o() {
        IAlog.a("%s onBufferingTimeout reached. Skipping to end card", IAlog.a(this));
        if (this.d.e) {
            this.r = true;
            f(false);
        }
    }

    public final void a(float f) {
        q qVar;
        this.B = f;
        if (IAlog.f1749a >= 3) {
            IAlog.c("%sonVisibilityChanged called with: %s vfpl = %s vfpa = %s", IAlog.a(this), Float.valueOf(f), Float.valueOf(this.A), Float.valueOf(1.0f - this.A));
        }
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || (qVar = fVar.f1617a) == null) {
            return;
        }
        if (qVar.e != com.fyber.inneractive.sdk.player.enums.b.Playing) {
            B();
            return;
        }
        if (f <= this.A) {
            IAlog.e("%sonVisibilityChanged pausing player", IAlog.a(this));
            if (this.f1378a.f1617a.j != null) {
                this.C = false;
                C();
                super.v();
                e(false);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int h() {
        return IAConfigManager.O.u.b.a("VideoAdBufferingTimeout", 5, 1) * 1000;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void b(e1 e1Var) {
        q qVar;
        TapAction tapAction = ((r0) this.b).f.i;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || fVar.f1617a == null || this.B >= this.A) {
            if (tapAction == TapAction.CTR) {
                a(false, VideoClickOrigin.CTA, e1Var);
                return;
            }
            if (tapAction == TapAction.FULLSCREEN) {
                A();
                return;
            }
            if (tapAction != TapAction.DO_NOTHING) {
                IAlog.a("%sonVideoClicked called, but we recieved an unknown tap action %s", IAlog.a(this), tapAction);
                return;
            }
            if (fVar == null || (qVar = fVar.f1617a) == null) {
                return;
            }
            com.fyber.inneractive.sdk.player.enums.b bVar = qVar.e;
            if (bVar != com.fyber.inneractive.sdk.player.enums.b.Completed && bVar != com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                qVar.j();
            } else {
                qVar.a(1, true);
            }
        }
    }
}
