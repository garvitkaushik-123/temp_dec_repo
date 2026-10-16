package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* loaded from: classes4.dex */
public final class y implements v {

    /* renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.exoplayer2.util.v f1502a;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r b;
    public boolean c;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        this.f1502a = vVar;
        e0Var.a();
        e0Var.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a2 = jVar.a(e0Var.d, 4);
        this.b = a2;
        e0Var.b();
        a2.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(e0Var.e, "application/x-scte35", (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) null));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        long j;
        long j2;
        long j3 = -9223372036854775807L;
        if (!this.c) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar = this.f1502a;
            long j4 = 0;
            if ((vVar.f1597a == Long.MAX_VALUE ? 0L : vVar.c == -9223372036854775807L ? -9223372036854775807L : vVar.b) == -9223372036854775807L) {
                return;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = this.b;
            com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar2 = this.f1502a;
            if (vVar2.f1597a != Long.MAX_VALUE) {
                if (vVar2.c == -9223372036854775807L) {
                    j2 = -9223372036854775807L;
                    rVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(null, null, "application/x-scte35", null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j2, null, null, null));
                    this.c = true;
                } else {
                    j4 = vVar2.b;
                }
            }
            j2 = j4;
            rVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(null, null, "application/x-scte35", null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j2, null, null, null));
            this.c = true;
        }
        int i = nVar.c - nVar.b;
        this.b.a(i, nVar);
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar2 = this.b;
        com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar3 = this.f1502a;
        if (vVar3.c != -9223372036854775807L) {
            j3 = vVar3.c;
        } else {
            long j5 = vVar3.f1597a;
            if (j5 != Long.MAX_VALUE) {
                j = j5;
                rVar2.a(j, 1, i, 0, null);
            }
        }
        j = j3;
        rVar2.a(j, 1, i, 0, null);
    }
}
