package com.fyber.inneractive.sdk.player;

import android.app.Application;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.config.t0;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final r0 f1344a;
    public n b;

    public b(r0 r0Var) {
        this.f1344a = r0Var;
    }

    public final a a() {
        com.fyber.inneractive.sdk.measurement.e eVar;
        t0 t0Var;
        UnitDisplayType unitDisplayType;
        if (this.b == null) {
            Application application = com.fyber.inneractive.sdk.util.o.f1770a;
            r0 r0Var = this.f1344a;
            com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) r0Var.b;
            s0 s0Var = r0Var.d;
            InneractiveAdRequest inneractiveAdRequest = r0Var.f1249a;
            if (s0Var != null) {
                Boolean c = ((com.fyber.inneractive.sdk.config.global.features.l) r0Var.c.a(com.fyber.inneractive.sdk.config.global.features.l.class)).c(com.ironsource.mediationsdk.metadata.a.j);
                boolean booleanValue = c != null ? c.booleanValue() : false;
                IAlog.a("OMSDK AB %s", String.valueOf(booleanValue));
                if (booleanValue && (t0Var = ((com.fyber.inneractive.sdk.config.r0) this.f1344a.d).f) != null && ((unitDisplayType = t0Var.j) == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED)) {
                    eVar = IAConfigManager.O.K;
                    this.b = new n(application, gVar, s0Var, inneractiveAdRequest, r0Var, eVar);
                }
            }
            eVar = null;
            this.b = new n(application, gVar, s0Var, inneractiveAdRequest, r0Var, eVar);
        }
        return this.b;
    }
}
