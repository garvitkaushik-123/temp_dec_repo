package com.fyber.inneractive.sdk.flow.endcard.loaders.fmp;

import com.fyber.inneractive.sdk.flow.endcard.j;
import com.fyber.inneractive.sdk.flow.endcard.o;
import com.fyber.inneractive.sdk.flow.u0;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class a implements com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a {

    /* renamed from: a, reason: collision with root package name */
    public final u0 f1195a;
    public final j b;
    public final com.fyber.inneractive.sdk.flow.endcard.loaders.b c;
    public o d;

    public a(j jVar, u0 u0Var, com.fyber.inneractive.sdk.flow.endcard.loaders.b bVar) {
        this.b = jVar;
        this.f1195a = u0Var;
        this.c = bVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a
    public final void a() {
        com.fyber.inneractive.sdk.flow.endcard.loaders.b bVar = this.c;
        o oVar = this.d;
        bVar.getClass();
        if (oVar != null) {
            IAlog.a("%s : onCompanionLoadSuccess: endcard type: %s", "EndCardLoader", oVar.i());
            bVar.d.a(oVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a
    public final void a(String str) {
        this.c.getClass();
        IAlog.a("%s : onCompanionLoadFailure: error: %s", "EndCardLoader", str);
    }
}
