package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.v0;
import com.iab.omid.library.fyber.adsession.AdSession;

/* loaded from: classes4.dex */
public final class o0 extends w {
    public IAmraidWebViewController i;

    public o0(com.fyber.inneractive.sdk.config.s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(s0Var, rVar);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void a() {
        AdSession adSession;
        if (this.g != null && d()) {
            v0 v0Var = this.g;
            v0Var.y = true;
            v0Var.D = false;
            v0Var.b.h.remove(v0Var);
            v0Var.i = null;
            IAlog.a("destroy internalStoreWebpageController", new Object[0]);
            this.g = null;
        }
        IAmraidWebViewController iAmraidWebViewController = this.i;
        if (iAmraidWebViewController != null) {
            com.fyber.inneractive.sdk.measurement.tracker.e eVar = iAmraidWebViewController.I;
            if (eVar != null && (adSession = eVar.f1273a) != null) {
                try {
                    adSession.finish();
                } catch (Throwable unused) {
                }
                com.fyber.inneractive.sdk.util.r.b.postDelayed(new com.fyber.inneractive.sdk.measurement.tracker.c(eVar), 1000);
                eVar.f1273a = null;
                eVar.b = null;
            }
            this.i.e();
            this.i = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean d() {
        com.fyber.inneractive.sdk.config.s0 s0Var = this.d;
        if (s0Var == null) {
            return false;
        }
        com.fyber.inneractive.sdk.config.r0 r0Var = (com.fyber.inneractive.sdk.config.r0) s0Var;
        if (r0Var.c == null || r0Var.c.b == null) {
            return false;
        }
        return r0Var.c.b.isFullscreenUnit();
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean f() {
        IAmraidWebViewController iAmraidWebViewController = this.i;
        return (iAmraidWebViewController == null || iAmraidWebViewController.b == null) ? false : true;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public boolean isVideoAd() {
        return false;
    }
}
