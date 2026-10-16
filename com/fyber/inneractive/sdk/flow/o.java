package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class o implements com.fyber.inneractive.sdk.interfaces.a, com.fyber.inneractive.sdk.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.interfaces.c f1212a;
    public n b;
    public com.fyber.inneractive.sdk.config.global.r c;
    public com.fyber.inneractive.sdk.network.m d;
    public final String e;
    public boolean f = false;

    public o(String str) {
        this.e = str;
    }

    public void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
    }

    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        if (IAlog.f1749a <= 3) {
            Thread.dumpStack();
        }
        IAlog.e("%sgot onAdRequestFailed! with: %s", d(), inneractiveInfrastructureError.getErrorCode());
        if (this.b != null) {
            if (eVar != null && eVar.i != null) {
                inneractiveInfrastructureError.setCause(new Exception(eVar.i + ": " + eVar.j));
            }
            ((d0) this.b).a(inneractiveAdRequest, eVar, inneractiveInfrastructureError);
        }
    }

    public void b(InneractiveAdRequest inneractiveAdRequest) {
    }

    public final com.fyber.inneractive.sdk.response.e c() {
        com.fyber.inneractive.sdk.interfaces.c cVar = this.f1212a;
        if (cVar == null) {
            return null;
        }
        k kVar = (k) cVar;
        if (kVar.c != null) {
            return kVar.c.c();
        }
        return null;
    }

    public String d() {
        return IAlog.a(this);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a
    public void a(InneractiveAdRequest inneractiveAdRequest) {
        com.fyber.inneractive.sdk.response.e eVar;
        q0 q0Var;
        IAlog.e("%sgot onAdLoaded!", d());
        com.fyber.inneractive.sdk.interfaces.c cVar = this.f1212a;
        if (cVar != null) {
            n nVar = this.b;
            if (nVar != null) {
                x xVar = ((k) cVar).c;
                d0 d0Var = (d0) nVar;
                f0 f0Var = d0Var.f1181a;
                if (!f0Var.j && (q0Var = f0Var.f) != null && q0Var.supportsRefresh()) {
                    if (d0Var.f1181a.f.canRefreshAd()) {
                        f0 f0Var2 = d0Var.f1181a;
                        f0Var2.e = xVar;
                        xVar.f1249a = inneractiveAdRequest;
                        e0 e0Var = f0Var2.i;
                        if (e0Var != null) {
                            e0Var.onAdRefreshed(f0Var2);
                        } else {
                            q0 q0Var2 = f0Var2.f;
                            if (q0Var2 instanceof InneractiveAdViewUnitController) {
                                ((InneractiveAdViewUnitController) q0Var2).onAdRefreshed(f0Var2);
                            }
                        }
                    } else {
                        f0 f0Var3 = d0Var.f1181a;
                        f0Var3.getClass();
                        IAlog.a("%sad loaded successfully, but the selected unit controller has rejected the refresh!", IAlog.a(f0Var3));
                        f0 f0Var4 = d0Var.f1181a;
                        f0Var4.i.onAdRefreshFailed(f0Var4, InneractiveErrorCode.CANCELLED);
                    }
                } else {
                    f0 f0Var5 = d0Var.f1181a;
                    f0Var5.e = xVar;
                    xVar.f1249a = inneractiveAdRequest;
                    Iterator it = f0Var5.g.iterator();
                    while (it.hasNext()) {
                        q0 q0Var3 = (q0) it.next();
                        if (q0Var3.supports(f0Var5)) {
                            f0Var5.f = q0Var3;
                            f0 f0Var6 = d0Var.f1181a;
                            InneractiveAdSpot.RequestListener requestListener = f0Var6.b;
                            if (requestListener != null) {
                                requestListener.onInneractiveSuccessfulAdRequest(f0Var6);
                            }
                            d0Var.f1181a.j = false;
                        }
                    }
                    f0 f0Var7 = d0Var.f1181a;
                    f0Var7.getClass();
                    IAlog.a("%sCannot find appropriate unit controller for unit: %s", IAlog.a(f0Var7), d0Var.f1181a.e.d);
                    m mVar = d0Var.f1181a.h;
                    d0Var.a(inneractiveAdRequest, mVar != null ? mVar.c() : null, new InneractiveInfrastructureError(InneractiveErrorCode.INVALID_INPUT, i.COULD_NOT_SELECT_UNIT_CONTROLLER, new Exception("Cannot find appropriate unit controller for unit: " + d0Var.f1181a.e.d)));
                    f0 f0Var8 = d0Var.f1181a;
                    f0Var8.e = null;
                    f0Var8.j = false;
                }
                String str = d0Var.f1181a.f1202a;
                com.fyber.inneractive.sdk.metrics.d dVar = com.fyber.inneractive.sdk.metrics.d.d;
                dVar.a(str).e();
                dVar.a(str).b();
                f0 f0Var9 = d0Var.f1181a;
                x xVar2 = f0Var9.e;
                if (xVar2 != null && (eVar = xVar2.b) != null && eVar.p != null) {
                    x xVar3 = f0Var9.e;
                    com.fyber.inneractive.sdk.response.e eVar2 = xVar3.b;
                    new com.fyber.inneractive.sdk.metrics.c(eVar2, f0Var9.c, f0Var9.f1202a, eVar2.p, xVar3.c.b()).a();
                }
            }
            this.f1212a = null;
        }
        b(inneractiveAdRequest);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.a
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        x xVar;
        IAlog.e("%sgot onFailedLoading! with: %s", d(), inneractiveInfrastructureError);
        com.fyber.inneractive.sdk.interfaces.c cVar = this.f1212a;
        InneractiveAdRequest inneractiveAdRequest = (cVar == null || (xVar = ((k) cVar).c) == null) ? null : xVar.f1249a;
        com.fyber.inneractive.sdk.response.e c = c();
        IAlog.e("%sgot handleFailedLoading! with: %s", d(), inneractiveInfrastructureError);
        n nVar = this.b;
        if (nVar != null) {
            ((d0) nVar).a(inneractiveAdRequest, c, inneractiveInfrastructureError);
        }
        a(inneractiveAdRequest, c);
    }

    public void a(boolean z) {
        this.f = true;
        com.fyber.inneractive.sdk.interfaces.c cVar = this.f1212a;
        if (cVar == null || !z) {
            return;
        }
        cVar.cancel();
        k kVar = (k) this.f1212a;
        if (kVar.c != null) {
            kVar.c.a();
        }
        this.f1212a = null;
    }
}
