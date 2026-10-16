package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;

/* loaded from: classes4.dex */
public final class s extends m {
    public final InneractiveAdRequest e;
    public final p0 f;

    public s(InneractiveAdRequest inneractiveAdRequest, String str, com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.flow.o oVar) {
        super(rVar, str, oVar);
        this.e = inneractiveAdRequest;
        p0 p0Var = new p0(new q(this), inneractiveAdRequest, rVar);
        this.f = p0Var;
        p0Var.d = new r(this);
    }

    @Override // com.fyber.inneractive.sdk.network.m
    public final void a() {
        this.b = true;
        this.f1330a = null;
        this.f.f1337a = true;
    }

    @Override // com.fyber.inneractive.sdk.network.m
    public final String b() {
        return this.f.p();
    }
}
