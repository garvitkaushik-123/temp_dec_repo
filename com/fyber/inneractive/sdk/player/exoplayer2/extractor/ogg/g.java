package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;

/* loaded from: classes4.dex */
public final class g {
    public static final int h = z.a("OggS");

    /* renamed from: a, reason: collision with root package name */
    public int f1467a;
    public long b;
    public int c;
    public int d;
    public int e;
    public final int[] f = new int[255];
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n g = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(255);

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.g;
        nVar.b = 0;
        nVar.c = 0;
        this.f1467a = 0;
        this.b = 0L;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        long j = bVar.b;
        if ((j != -1 && j - (bVar.c + bVar.e) < 27) || !bVar.a(nVar.f1591a, 0, 27, true)) {
            if (z) {
                return false;
            }
            throw new EOFException();
        }
        if (this.g.k() != h) {
            if (z) {
                return false;
            }
            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("expected OggS capture pattern at begin of page");
        }
        if (this.g.j() != 0) {
            if (z) {
                return false;
            }
            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("unsupported bit stream revision");
        }
        this.f1467a = this.g.j();
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.g;
        byte[] bArr = nVar2.f1591a;
        int i = nVar2.b;
        nVar2.b = i + 1;
        nVar2.b = i + 2;
        nVar2.b = i + 3;
        long j2 = (bArr[i] & 255) | ((bArr[r4] & 255) << 8) | ((bArr[r9] & 255) << 16);
        nVar2.b = i + 4;
        long j3 = j2 | ((bArr[r10] & 255) << 24);
        nVar2.b = i + 5;
        long j4 = j3 | ((bArr[r9] & 255) << 32);
        nVar2.b = i + 6;
        long j5 = j4 | ((bArr[r10] & 255) << 40);
        nVar2.b = i + 7;
        nVar2.b = i + 8;
        this.b = j5 | ((bArr[r9] & 255) << 48) | ((255 & bArr[r10]) << 56);
        nVar2.e();
        this.g.e();
        this.g.e();
        int j6 = this.g.j();
        this.c = j6;
        this.d = j6 + 27;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.g;
        nVar3.b = 0;
        nVar3.c = 0;
        bVar.a(nVar3.f1591a, 0, j6, false);
        for (int i2 = 0; i2 < this.c; i2++) {
            this.f[i2] = this.g.j();
            this.e += this.f[i2];
        }
        return true;
    }
}
