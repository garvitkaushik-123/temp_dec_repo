package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class d0 implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f1181a;

    public d0(f0 f0Var) {
        this.f1181a = f0Var;
    }

    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        com.fyber.inneractive.sdk.config.global.r rVar;
        if (this.f1181a.b != null) {
            if (inneractiveInfrastructureError.getErrorCode().shouldSendTimeMetric()) {
                this.f1181a.a(inneractiveAdRequest, eVar);
            }
            f0 f0Var = this.f1181a;
            if (!f0Var.j) {
                e0 e0Var = f0Var.i;
                if (e0Var != null) {
                    e0Var.onAdRefreshFailed(f0Var, inneractiveInfrastructureError.getErrorCode());
                    return;
                }
                return;
            }
            m mVar = f0Var.h;
            p pVar = f0Var.l;
            JSONArray jSONArray = null;
            com.fyber.inneractive.sdk.config.global.r rVar2 = pVar != null ? pVar.c : null;
            if (mVar != null && (rVar = mVar.c) != null) {
                jSONArray = rVar.b();
            } else if (rVar2 != null) {
                jSONArray = rVar2.b();
            }
            a.a(inneractiveAdRequest, inneractiveInfrastructureError, f0Var.e, eVar, jSONArray);
            f0 f0Var2 = this.f1181a;
            InneractiveAdSpot.RequestListener requestListener = f0Var2.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(f0Var2, inneractiveInfrastructureError.getErrorCode());
            }
        }
    }
}
