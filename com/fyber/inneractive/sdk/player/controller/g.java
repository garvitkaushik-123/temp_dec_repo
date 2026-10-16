package com.fyber.inneractive.sdk.player.controller;

import android.media.AudioManager;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.config.t0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class g extends z implements com.fyber.inneractive.sdk.flow.storepromo.loader.b {
    public boolean A;
    public final boolean B;
    public final boolean z;

    public g(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.i iVar, s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, boolean z2, String str) {
        super(fVar, iVar, s0Var, rVar, z, str);
        com.fyber.inneractive.sdk.flow.storepromo.b bVar;
        this.z = false;
        this.A = false;
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
        if (fVar2 != null && (bVar = ((com.fyber.inneractive.sdk.player.n) fVar2).v) != null) {
            bVar.e = this;
        }
        this.z = false;
        this.B = z2;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.ui.n
    public final void a() {
        if (!this.h) {
            e();
            return;
        }
        if (this.d.h()) {
            return;
        }
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

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.b
    public final void b(boolean z) {
        super.b(z);
        if (this.z) {
            this.d.m();
            this.d.g(false);
            this.f = 0;
        }
        x();
        this.d.e(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void e() {
        int i;
        int i2;
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        AudioManager audioManager;
        super.e();
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1378a;
        if (fVar2 != null && fVar2.f1617a != null && !this.A) {
            try {
                audioManager = (AudioManager) this.d.getContext().getSystemService("audio");
                i = audioManager.getRingerMode();
            } catch (Throwable unused) {
                i = 0;
            }
            try {
                i2 = audioManager.getStreamVolume(2);
            } catch (Throwable unused2) {
                i2 = 0;
                if (this.z) {
                }
                if (i2 > 0) {
                    IAlog.a("%s setting default volume. unmuting player", IAlog.a(this));
                    fVar = this.f1378a;
                    if (fVar != null) {
                        qVar.d(false);
                    }
                    this.d.setMuteButtonState(false);
                }
                this.d.setMuteButtonState(m());
                this.A = true;
                g(false);
            }
            if ((this.z && ((r0) this.b).f.d.booleanValue()) || this.B || m()) {
                e(false);
            } else if (i2 > 0 && i == 2) {
                IAlog.a("%s setting default volume. unmuting player", IAlog.a(this));
                fVar = this.f1378a;
                if (fVar != null && (qVar = fVar.f1617a) != null) {
                    qVar.d(false);
                }
                this.d.setMuteButtonState(false);
            }
            this.d.setMuteButtonState(m());
            this.A = true;
        }
        g(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int h() {
        return IAConfigManager.O.u.b.a("VideoFullscreenBufferingTimeout", 12, 1) * 1000;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|(2:3|(13:5|6|(3:8|(1:10)(1:52)|(1:51))(1:53)|13|14|15|(6:17|18|(1:23)|(1:(1:(2:34|(1:39)(2:37|38)))(2:27|28))(1:(2:43|(1:45)(2:46|47)))|32|33)|49|18|(2:21|23)|(0)(0)|32|33))|54|6|(0)(0)|13|14|15|(0)|49|18|(0)|(0)(0)|32|33) */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[Catch: Exception -> 0x0076, TRY_LEAVE, TryCatch #0 {Exception -> 0x0076, blocks: (B:15:0x0061, B:17:0x0069), top: B:14:0x0061 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    @Override // com.fyber.inneractive.sdk.player.controller.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int l() {
        com.fyber.inneractive.sdk.config.global.features.c cVar;
        int i;
        Skip skip;
        boolean isCurrentUserAChild;
        com.fyber.inneractive.sdk.config.l a2;
        int i2;
        t0 t0Var;
        com.fyber.inneractive.sdk.config.global.r rVar = this.c;
        if (rVar != null) {
            com.fyber.inneractive.sdk.config.global.features.c cVar2 = (com.fyber.inneractive.sdk.config.global.features.c) rVar.a(com.fyber.inneractive.sdk.config.global.features.c.class);
            cVar2.getClass();
            if (new ArrayList(cVar2.c.values()).size() > 0) {
                cVar = (com.fyber.inneractive.sdk.config.global.features.c) this.c.a(com.fyber.inneractive.sdk.config.global.features.c.class);
                if (cVar == null) {
                    Integer a3 = cVar.a("skip_time_sec");
                    i = a3 != null ? a3.intValue() : 5;
                    if (i < 0 || i > 8) {
                        i = 5;
                    }
                } else {
                    i = -1;
                }
                com.fyber.inneractive.sdk.config.o oVar = IAConfigManager.O.u.b;
                s0 s0Var = this.b;
                skip = this.x;
                isCurrentUserAChild = InneractiveAdManager.isCurrentUserAChild();
                a2 = oVar.a("vast_configuration");
                a2.getClass();
                if (a2.f1104a.containsKey("skip_d")) {
                    i2 = Integer.parseInt((String) a2.f1104a.get("skip_d"));
                    int max = Math.max(i2, -1);
                    if (skip == null && s0Var != null && (t0Var = ((r0) s0Var).f) != null) {
                        skip = t0Var.h;
                    }
                    if (isCurrentUserAChild) {
                        if (i > -1 && i <= 8) {
                            return i;
                        }
                        if (max <= -1 || max > 8) {
                            int intValue = skip.value().intValue();
                            if (intValue <= -1 || intValue > 8) {
                                return 5;
                            }
                            return skip.value().intValue();
                        }
                    } else if (max <= -1 || max > 5) {
                        return skip == Skip.DEFAULT ? DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE : skip.value().intValue();
                    }
                    return max;
                }
                i2 = -1;
                int max2 = Math.max(i2, -1);
                if (skip == null) {
                    skip = t0Var.h;
                }
                if (isCurrentUserAChild) {
                }
                return max2;
            }
        }
        cVar = null;
        if (cVar == null) {
        }
        com.fyber.inneractive.sdk.config.o oVar2 = IAConfigManager.O.u.b;
        s0 s0Var2 = this.b;
        skip = this.x;
        isCurrentUserAChild = InneractiveAdManager.isCurrentUserAChild();
        a2 = oVar2.a("vast_configuration");
        a2.getClass();
        if (a2.f1104a.containsKey("skip_d")) {
        }
        i2 = -1;
        int max22 = Math.max(i2, -1);
        if (skip == null) {
        }
        if (isCurrentUserAChild) {
        }
        return max22;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void o() {
        this.r = true;
        IAlog.a("%s onBufferingTimeout reached. Skipping to end card", IAlog.a(this));
        f(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void p() {
        f0 f0Var = this.g;
        if (f0Var != null) {
            f0Var.i();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void r() {
        this.d.g(true);
        x();
        g();
        e();
        g(true);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void t() {
        super.t();
        if (this.z) {
            this.d.m();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final boolean w() {
        return !this.z;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void z() {
        q qVar;
        super.z();
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar == null || (qVar = fVar.f1617a) == null || qVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed || !this.z) {
            return;
        }
        this.d.m();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.ui.n
    public final void a(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1378a;
        if (fVar != null && (qVar = fVar.f1617a) != null) {
            com.fyber.inneractive.sdk.player.enums.b bVar = qVar.e;
            if (z && bVar != com.fyber.inneractive.sdk.player.enums.b.Completed && !this.d.h()) {
                g(false);
            } else if (!z && bVar == com.fyber.inneractive.sdk.player.enums.b.Paused && this.d.h()) {
                int b = qVar.b();
                int c = qVar.c();
                if (b > 0 && b <= c) {
                    qVar.a(b - 1, false);
                    qVar.a(b, false);
                }
            }
        }
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void b(e1 e1Var) {
        com.fyber.inneractive.sdk.player.ui.s sVar;
        TapAction tapAction = ((r0) this.b).f.i;
        if (tapAction == TapAction.CTR) {
            a(false, VideoClickOrigin.VIDEO, e1Var);
            return;
        }
        if (tapAction != TapAction.FULLSCREEN && tapAction != TapAction.DO_NOTHING) {
            IAlog.a("% sonVideoClicked called, but we recieved an unknown tap action %s", IAlog.a(this), tapAction);
            return;
        }
        if (((com.fyber.inneractive.sdk.config.global.features.u) this.c.a(com.fyber.inneractive.sdk.config.global.features.u.class)).c().equals(com.fyber.inneractive.sdk.config.global.features.t.OPEN) || ((this.t != com.fyber.inneractive.sdk.ignite.m.NONE && IAConfigManager.O.E.n()) || ((sVar = this.d) != null && sVar.a()))) {
            a(false, VideoClickOrigin.VIDEO, e1Var);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.loader.b
    public final void a(e1 e1Var) {
        a(11, e1Var);
    }
}
