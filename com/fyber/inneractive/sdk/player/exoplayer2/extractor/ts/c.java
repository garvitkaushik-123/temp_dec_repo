package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* loaded from: classes4.dex */
public final class c implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final int e = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("ID3");

    /* renamed from: a, reason: collision with root package name */
    public final long f1479a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(200);
    public d c;
    public boolean d;

    public c(long j) {
        this.f1479a = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(10);
        com.fyber.inneractive.sdk.player.exoplayer2.util.m mVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(nVar.f1591a);
        int i = 0;
        while (true) {
            bVar.a(nVar.f1591a, 0, 10, false);
            nVar.e(0);
            if (nVar.l() != e) {
                break;
            }
            nVar.e(nVar.b + 3);
            int i2 = nVar.i();
            i += i2 + 10;
            bVar.a(i2, false);
        }
        bVar.e = 0;
        bVar.a(i, false);
        int i3 = 0;
        int i4 = 0;
        int i5 = i;
        while (true) {
            bVar.a(nVar.f1591a, 0, 2, false);
            nVar.e(0);
            if ((nVar.o() & 65526) != 65520) {
                bVar.e = 0;
                i5++;
                if (i5 - i >= 8192) {
                    return false;
                }
                bVar.a(i5, false);
                i3 = 0;
                i4 = 0;
            } else {
                i3++;
                if (i3 >= 4 && i4 > 188) {
                    return true;
                }
                bVar.a(nVar.f1591a, 0, 4, false);
                mVar.b(14);
                int a2 = mVar.a(13);
                if (a2 <= 6) {
                    return false;
                }
                bVar.a(a2 - 6, false);
                i4 += a2;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        d dVar = new d(true, null);
        this.c = dVar;
        dVar.a(jVar, new e0(Integer.MIN_VALUE, 0, 1));
        jVar.b();
        jVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.d = false;
        d dVar = this.c;
        dVar.h = 0;
        dVar.i = 0;
        dVar.j = 256;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) {
        int min;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2;
        byte[] bArr = this.b.f1591a;
        int i = bVar.f;
        if (i == 0) {
            min = 0;
        } else {
            min = Math.min(i, 200);
            System.arraycopy(bVar.d, 0, bArr, 0, min);
            bVar.b(min);
        }
        if (min == 0) {
            bVar2 = bVar;
            min = bVar2.a(bArr, 0, 200, 0, true);
        } else {
            bVar2 = bVar;
        }
        if (min != -1) {
            bVar2.c += min;
        }
        if (min == -1) {
            return -1;
        }
        this.b.e(0);
        this.b.d(min);
        if (!this.d) {
            this.c.o = this.f1479a;
            this.d = true;
        }
        this.c.a(this.b);
        return 0;
    }
}
