package com.fyber.inneractive.sdk.player.controller;

import android.view.View;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.w0;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.h0;
import java.util.List;

/* loaded from: classes4.dex */
public final class w extends h0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f1375a;

    public w(z zVar) {
        this.f1375a = zVar;
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        z zVar = this.f1375a;
        zVar.getClass();
        IAlog.a(sb.append(IAlog.a(zVar)).append("web view callback: onSuspiciousNoUserWebActionDetected").toString(), new Object[0]);
        f0 f0Var = this.f1375a.g;
        if (f0Var != null) {
            f0Var.a(str, str2);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void b() {
        z zVar = this.f1375a;
        if (zVar.g != null) {
            com.fyber.inneractive.sdk.player.ui.s sVar = zVar.d;
            this.f1375a.g.a(sVar != null ? sVar.getEndCardView() : null);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void c() {
        z zVar = this.f1375a;
        if (zVar.g != null) {
            com.fyber.inneractive.sdk.player.ui.s sVar = zVar.d;
            this.f1375a.g.a(sVar != null ? sVar.getEndCardView() : null);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void d() {
        z zVar = this.f1375a;
        zVar.getClass();
        IAlog.a("%sweb view callback: onClickedAndOpen", IAlog.a(zVar));
        this.f1375a.a(w0.COMPANION.a());
        z zVar2 = this.f1375a;
        if (zVar2.g != null) {
            com.fyber.inneractive.sdk.player.f fVar = zVar2.f1378a;
            if (fVar != null) {
                com.fyber.inneractive.sdk.flow.endcard.b a2 = ((com.fyber.inneractive.sdk.player.n) fVar).t.b.a();
                if (a2 instanceof com.fyber.inneractive.sdk.flow.endcard.c) {
                    fVar.a((com.fyber.inneractive.sdk.flow.endcard.c) a2, VideoClickOrigin.COMPANION, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                }
            }
            IAlog.d("AD_CLICKED", new Object[0]);
            this.f1375a.g.e();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void onClose() {
        f0 f0Var = this.f1375a.g;
        if (f0Var != null) {
            f0Var.i();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void b(boolean z) {
        z zVar = this.f1375a;
        zVar.getClass();
        IAlog.a("%sonCustomCloseButtonAvailableEnabled : %s", IAlog.a(zVar), Boolean.valueOf(z));
        f0 f0Var = this.f1375a.g;
        if (f0Var == null || !z) {
            return;
        }
        f0Var.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.web.j1
    public final com.fyber.inneractive.sdk.util.b0 a(String str, e1 e1Var) {
        z zVar = this.f1375a;
        zVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a(zVar));
        this.f1375a.a(w0.COMPANION.a());
        z zVar2 = this.f1375a;
        if (zVar2.g != null) {
            com.fyber.inneractive.sdk.player.f fVar = zVar2.f1378a;
            if (fVar != null) {
                com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
                com.fyber.inneractive.sdk.flow.endcard.k kVar = nVar.t;
                com.fyber.inneractive.sdk.flow.endcard.b a2 = kVar.b.a();
                com.fyber.inneractive.sdk.flow.endcard.c cVar = a2;
                if (a2 != 0) {
                    boolean j = a2.j();
                    cVar = a2;
                    if (j) {
                        com.fyber.inneractive.sdk.flow.endcard.c cVar2 = (com.fyber.inneractive.sdk.flow.endcard.c) kVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Other);
                        cVar = cVar2;
                        if (cVar2 == null) {
                            com.fyber.inneractive.sdk.flow.endcard.c cVar3 = (com.fyber.inneractive.sdk.flow.endcard.c) kVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Html);
                            cVar = cVar3;
                            if (cVar3 == null) {
                                com.fyber.inneractive.sdk.flow.endcard.c cVar4 = (com.fyber.inneractive.sdk.flow.endcard.c) kVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Iframe);
                                cVar = cVar4;
                                if (cVar4 == null) {
                                    cVar = (com.fyber.inneractive.sdk.flow.endcard.c) kVar.b.a(com.fyber.inneractive.sdk.model.vast.i.Static);
                                }
                            }
                        }
                    }
                }
                com.fyber.inneractive.sdk.flow.endcard.b a3 = nVar.t.b.a();
                com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK;
                com.fyber.inneractive.sdk.flow.endcard.c cVar5 = cVar instanceof com.fyber.inneractive.sdk.response.i ? cVar : null;
                List a4 = cVar5 != null ? cVar5.a(xVar) : null;
                if (a4 != null && !a4.isEmpty()) {
                    fVar.a(cVar, VideoClickOrigin.COMPANION, xVar);
                } else {
                    this.f1375a.getClass();
                    if ((a3 instanceof com.fyber.inneractive.sdk.flow.endcard.o) && ((com.fyber.inneractive.sdk.flow.endcard.o) a3).h.b > 0) {
                        nVar.a(nVar.p, VideoClickOrigin.COMPANION, xVar);
                    }
                }
            }
            IAlog.d("AD_CLICKED", new Object[0]);
            com.fyber.inneractive.sdk.player.ui.s sVar = this.f1375a.d;
            if (sVar != null) {
                sVar.e();
            }
            return this.f1375a.g.a(str, e1Var, false);
        }
        return new com.fyber.inneractive.sdk.util.b0(com.fyber.inneractive.sdk.util.e0.FAILED, new Exception("mListener is null, internal SDK fatal error"));
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a() {
        f0 f0Var = this.f1375a.g;
        if (f0Var != null) {
            f0Var.h();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final boolean a(String str) {
        View endCardView = this.f1375a.d.getEndCardView();
        f0 f0Var = this.f1375a.g;
        if (f0Var == null) {
            return false;
        }
        f0Var.a(endCardView, str);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void a(IAmraidWebViewController.MraidVideoFailedToDisplayError mraidVideoFailedToDisplayError) {
        f0 f0Var = this.f1375a.g;
        if (f0Var != null) {
            f0Var.onPlayerError();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void a(boolean z, Orientation orientation) {
        z zVar = this.f1375a;
        zVar.getClass();
        IAlog.a("%sonOrientationProperties: allowOrientationChange: %s, forceOrientationType: %s", IAlog.a(zVar), Boolean.valueOf(z), orientation.toString());
        f0 f0Var = this.f1375a.g;
        if (f0Var != null) {
            f0Var.a(z, orientation);
        }
    }
}
