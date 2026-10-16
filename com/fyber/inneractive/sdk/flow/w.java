package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.v0;
import com.fyber.inneractive.sdk.web.w0;

/* loaded from: classes4.dex */
public abstract class w extends x {
    public v0 g;
    public final v h;

    public w(com.fyber.inneractive.sdk.config.s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(s0Var, rVar);
        this.h = new v(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void a(String str) {
        com.fyber.inneractive.sdk.ignite.m mVar;
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.ignite.m mVar2 = com.fyber.inneractive.sdk.ignite.m.NONE;
        com.fyber.inneractive.sdk.response.e eVar2 = this.b;
        if (eVar2 != null) {
            com.fyber.inneractive.sdk.ignite.m mVar3 = eVar2.H;
            mVar3.getClass();
            mVar = com.fyber.inneractive.sdk.ignite.m.SINGLE_TAP;
            if (mVar3 != mVar) {
                com.fyber.inneractive.sdk.ignite.m mVar4 = this.b.H;
                mVar4.getClass();
                if (mVar4 != com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP || isVideoAd()) {
                    mVar = this.b.H;
                } else {
                    this.h.a(com.fyber.inneractive.sdk.network.t.IGNITE_FLOW_MODE_NOT_COMPATIBLE, null, null, null);
                }
            }
        } else {
            mVar = mVar2;
        }
        com.fyber.inneractive.sdk.ignite.h hVar = IAConfigManager.O.E;
        if (!hVar.f || (eVar = this.b) == null || !eVar.a() || !hVar.n()) {
            com.fyber.inneractive.sdk.response.e eVar3 = this.b;
            if (eVar3 != null) {
                eVar3.H = mVar2;
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.response.e eVar4 = this.b;
        String str2 = eVar4 != null ? eVar4.A : null;
        w0 w0Var = new w0();
        w0Var.f1828a = str2;
        w0Var.b = mVar;
        w0Var.c = str;
        w0Var.d = this.c;
        w0Var.e = eVar4 != null ? eVar4.G : null;
        w0Var.f = eVar4 != null ? eVar4.I : null;
        w0Var.g = this.h;
        v0 v0Var = new v0(w0Var);
        this.g = v0Var;
        com.fyber.inneractive.sdk.config.global.features.q qVar = (com.fyber.inneractive.sdk.config.global.features.q) this.c.a(com.fyber.inneractive.sdk.config.global.features.q.class);
        if (qVar == null || str2 == null) {
            return;
        }
        String a2 = qVar.a("detail_url", "https://cdn2.inner-active.mobi/app-detail-page-v0/[BUNDLE_ID].html");
        v0Var.e(a2 == null ? "" : a2.replace("[BUNDLE_ID]", str2));
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final v0 b() {
        return this.g;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean e() {
        v0 v0Var = this.g;
        return v0Var != null && v0Var.l;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void g() {
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.response.e eVar2;
        com.fyber.inneractive.sdk.ignite.h hVar = IAConfigManager.O.E;
        if (!hVar.f || (eVar = this.b) == null || !eVar.a() || !hVar.n() || e() || (eVar2 = this.b) == null) {
            return;
        }
        com.fyber.inneractive.sdk.ignite.m mVar = eVar2.H;
        com.fyber.inneractive.sdk.ignite.m mVar2 = com.fyber.inneractive.sdk.ignite.m.NONE;
        if (mVar != mVar2) {
            IAlog.a("ignite webpage was not loaded yet, stopping the loading process", new Object[0]);
            com.fyber.inneractive.sdk.response.e eVar3 = this.b;
            if (mVar2 == null) {
                eVar3.getClass();
            }
            eVar3.H = mVar2;
            v0 v0Var = this.g;
            if (v0Var != null) {
                com.fyber.inneractive.sdk.web.n0 n0Var = v0Var.p;
                if (n0Var != null) {
                    com.fyber.inneractive.sdk.util.r.b.removeCallbacks(n0Var);
                    v0Var.p = null;
                }
                if (!v0Var.y) {
                    v0Var.f1826a.stopLoading();
                }
                this.h.a(com.fyber.inneractive.sdk.network.t.IGNITE_FLOW_FAILED_TO_LOAD_WEBPAGE, this.g.k, com.fyber.inneractive.sdk.ignite.j.WEBPAGE_NOT_LOADED_BEFORE_SHOW.a(), this.b.H);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean a(boolean z, com.fyber.inneractive.sdk.util.g gVar) {
        com.fyber.inneractive.sdk.ignite.m mVar;
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        if (eVar != null) {
            mVar = eVar.H;
        } else {
            mVar = com.fyber.inneractive.sdk.ignite.m.NONE;
        }
        if (z || mVar == null || mVar != com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP) {
            return false;
        }
        return gVar == com.fyber.inneractive.sdk.util.g.VIDEO_CTA || gVar == com.fyber.inneractive.sdk.util.g.DEFAULT_ENDCARD;
    }
}
