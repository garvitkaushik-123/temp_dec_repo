package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import java.io.EOFException;

/* loaded from: classes4.dex */
public final class h implements r {
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(long j, int i, int i2, int i3, byte[] bArr) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        nVar.e(nVar.b + i);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final int a(b bVar, int i, boolean z) {
        b bVar2;
        int min = Math.min(bVar.f, i);
        bVar.b(min);
        if (min == 0) {
            bVar2 = bVar;
            min = bVar2.a(b.g, 0, Math.min(i, 4096), 0, true);
        } else {
            bVar2 = bVar;
        }
        if (min != -1) {
            bVar2.c += min;
        }
        if (min != -1) {
            return min;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }
}
