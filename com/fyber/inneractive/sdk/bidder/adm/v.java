package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.b0;
import com.fyber.inneractive.sdk.flow.d0;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.network.e0;
import com.fyber.inneractive.sdk.network.i1;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class v implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f1026a;
    public final /* synthetic */ com.fyber.inneractive.sdk.response.e b;
    public final /* synthetic */ y c;

    public v(y yVar, b0 b0Var, com.fyber.inneractive.sdk.response.e eVar) {
        this.c = yVar;
        this.f1026a = b0Var;
        this.b = eVar;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        com.fyber.inneractive.sdk.response.e eVar = (com.fyber.inneractive.sdk.response.e) obj;
        if (exc != null) {
            com.fyber.inneractive.sdk.metrics.i b = com.fyber.inneractive.sdk.metrics.d.d.b(this.c.d);
            b.f1279a.put(new com.fyber.inneractive.sdk.metrics.h(exc.getMessage()), Long.valueOf(System.currentTimeMillis() - b.c));
            b0 b0Var = this.f1026a;
            if (b0Var != null) {
                this.c.getClass();
                b0Var.a(exc, ((exc instanceof i1) && ((i1) exc).f1324a == 404) ? InneractiveErrorCode.NO_FILL : InneractiveErrorCode.CONNECTION_ERROR, this.b);
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.metrics.d dVar = com.fyber.inneractive.sdk.metrics.d.d;
        com.fyber.inneractive.sdk.metrics.i b2 = dVar.b(this.c.d);
        b2.f1279a.put(new com.fyber.inneractive.sdk.metrics.h("success"), Long.valueOf(System.currentTimeMillis() - b2.c));
        b0 b0Var2 = this.f1026a;
        if (b0Var2 != null) {
            f0 f0Var = b0Var2.d;
            f0Var.getClass();
            IAlog.a("%s : InneractiveAdSpotImpl data available", IAlog.a(f0Var));
            f0 f0Var2 = b0Var2.d;
            com.fyber.inneractive.sdk.config.global.r rVar = b0Var2.b;
            d0 d0Var = f0Var2.d;
            com.fyber.inneractive.sdk.flow.p pVar = f0Var2.l;
            if (pVar != null) {
                pVar.b = d0Var;
                dVar.b(f0Var2.f1202a).d = System.currentTimeMillis();
                pVar.g = eVar;
                if (!IAConfigManager.e()) {
                    IAConfigManager.addListener(pVar);
                    IAConfigManager.a();
                } else {
                    pVar.c = rVar;
                    com.fyber.inneractive.sdk.network.p pVar2 = new com.fyber.inneractive.sdk.network.p(rVar, eVar, f0Var2.f1202a, pVar);
                    pVar.d = pVar2;
                    pVar2.c();
                }
            }
        }
    }
}
