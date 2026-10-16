package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.upstream.o;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.t;

/* loaded from: classes4.dex */
public final class f implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.g {

    /* renamed from: a, reason: collision with root package name */
    public final l f1557a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.g c;
    public final d d;

    public f(l lVar, o oVar) {
        t tVar = new t();
        d dVar = new d(lVar);
        this.f1557a = lVar;
        this.b = oVar;
        this.c = tVar;
        this.d = dVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h a() {
        l lVar = this.f1557a;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h a2 = this.b.a();
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h a3 = this.c.a();
        d dVar = this.d;
        return new e(lVar, a2, a3, dVar != null ? new c(dVar.f1555a) : null);
    }
}
