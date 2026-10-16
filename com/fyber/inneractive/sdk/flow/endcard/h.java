package com.fyber.inneractive.sdk.flow.endcard;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.config.o f1186a;
    public final int b;

    public h() {
        com.fyber.inneractive.sdk.config.o oVar = IAConfigManager.O.u.b;
        this.f1186a = oVar;
        this.b = oVar.a("vast_endcard_x_delay", 5, 0);
    }

    public final void a(b bVar, boolean z) {
        if (bVar == null) {
            IAlog.a("%sapplyVastCompanionEndCardTime was called with a null endcard", IAlog.a(this));
        } else {
            bVar.f = bVar.k() ? z ? this.f1186a.b("d_e_pl_dl_pl", this.b, 0) : this.f1186a.b("d_e_pl", this.b, 0) : z ? this.f1186a.b("d_e_npl_dl_npl", this.b, 0) : this.f1186a.b("d_e_npl", this.b, 0);
        }
    }

    public final void a(b bVar, boolean z, boolean z2) {
        int b;
        if (bVar == null) {
            IAlog.a("%sapplyNonVastCompanionEndCardTime was called with a null endcard", IAlog.a(this));
            return;
        }
        if (!z) {
            b = this.f1186a.b("d_e_def", this.b, 0);
        } else if (z2) {
            b = this.f1186a.b("d_e_pl_dl_dl", this.b, 0);
        } else {
            b = this.f1186a.b("d_e_npl_dl_dl", this.b, 0);
        }
        bVar.f = b;
    }
}
