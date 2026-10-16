package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* loaded from: classes4.dex */
public final class a implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final int e = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("ID3");

    /* renamed from: a, reason: collision with root package name */
    public final long f1475a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(2786);
    public b c;
    public boolean d;

    public a(long j) {
        this.f1475a = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        int a2;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(10);
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
        int i4 = i;
        while (true) {
            bVar.a(nVar.f1591a, 0, 5, false);
            nVar.e(0);
            if (nVar.o() != 2935) {
                bVar.e = 0;
                i4++;
                if (i4 - i >= 8192) {
                    return false;
                }
                bVar.a(i4, false);
                i3 = 0;
            } else {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArr = nVar.f1591a;
                if (bArr.length < 5) {
                    a2 = -1;
                } else {
                    byte b = bArr[4];
                    a2 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.a((b & 192) >> 6, b & 63);
                }
                if (a2 == -1) {
                    return false;
                }
                bVar.a(a2 - 5, false);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        b bVar = new b(null);
        this.c = bVar;
        bVar.d = "0";
        bVar.e = jVar.a(0, 1);
        jVar.b();
        jVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.d = false;
        this.c.a();
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
            min = Math.min(i, 2786);
            System.arraycopy(bVar.d, 0, bArr, 0, min);
            bVar.b(min);
        }
        if (min == 0) {
            bVar2 = bVar;
            min = bVar2.a(bArr, 0, 2786, 0, true);
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
            this.c.l = this.f1475a;
            this.d = true;
        }
        this.c.a(this.b);
        return 0;
    }
}
