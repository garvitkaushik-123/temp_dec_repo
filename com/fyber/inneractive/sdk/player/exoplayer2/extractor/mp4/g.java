package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

/* loaded from: classes4.dex */
public final class g implements e {

    /* renamed from: a, reason: collision with root package name */
    public final int f1445a;
    public final int b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c;

    public g(b bVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = bVar.P0;
        this.c = nVar;
        nVar.e(12);
        this.f1445a = nVar.m();
        this.b = nVar.m();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e
    public final int a() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e
    public final int b() {
        int i = this.f1445a;
        return i == 0 ? this.c.m() : i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.e
    public final boolean c() {
        return this.f1445a != 0;
    }
}
