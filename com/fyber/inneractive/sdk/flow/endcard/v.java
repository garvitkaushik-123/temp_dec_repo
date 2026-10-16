package com.fyber.inneractive.sdk.flow.endcard;

import com.fyber.inneractive.sdk.flow.u0;

/* loaded from: classes4.dex */
public final class v extends c {
    public final com.fyber.inneractive.sdk.model.vast.k h;

    public v(u0 u0Var, com.fyber.inneractive.sdk.model.vast.c cVar, int i) {
        super(u0Var, cVar, i);
        this.h = cVar.b;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final n c() {
        return new w(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.c, com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean l() {
        return super.l() && ((w) f()).c != null;
    }
}
