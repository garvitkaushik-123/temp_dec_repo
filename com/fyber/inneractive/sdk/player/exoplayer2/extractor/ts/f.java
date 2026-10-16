package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

/* loaded from: classes4.dex */
public final class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f1485a;
    public final String b;
    public String c;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r d;
    public int e;
    public int f;
    public int g;
    public long h;
    public com.fyber.inneractive.sdk.player.exoplayer2.o i;
    public int j;
    public long k;

    public f(String str) {
        byte[] bArr = new byte[15];
        this.f1485a = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(bArr);
        bArr[0] = Byte.MAX_VALUE;
        bArr[1] = -2;
        bArr[2] = Byte.MIN_VALUE;
        bArr[3] = 1;
        this.e = 0;
        this.b = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.c = e0Var.e;
        e0Var.b();
        this.d = jVar.a(e0Var.d, 1);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.k = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        char c;
        while (true) {
            int i = nVar.c - nVar.b;
            if (i <= 0) {
                return;
            }
            int i2 = this.e;
            if (i2 == 0) {
                while (true) {
                    if (nVar.c - nVar.b > 0) {
                        int i3 = this.g << 8;
                        this.g = i3;
                        int j = i3 | nVar.j();
                        this.g = j;
                        if (j == 2147385345) {
                            this.g = 0;
                            this.f = 4;
                            this.e = 1;
                            break;
                        }
                    }
                }
            } else if (i2 == 1) {
                byte[] bArr = this.f1485a.f1591a;
                int min = Math.min(i, 15 - this.f);
                nVar.a(bArr, this.f, min);
                int i4 = this.f + min;
                this.f = i4;
                if (i4 == 15) {
                    byte[] bArr2 = this.f1485a.f1591a;
                    if (this.i == null) {
                        String str = this.c;
                        String str2 = this.b;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.m mVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(bArr2);
                        mVar.c(60);
                        int i5 = com.fyber.inneractive.sdk.player.exoplayer2.audio.t.f1393a[mVar.a(6)];
                        int i6 = com.fyber.inneractive.sdk.player.exoplayer2.audio.t.b[mVar.a(4)];
                        int a2 = mVar.a(5);
                        c = 5;
                        int i7 = a2 >= 29 ? -1 : (com.fyber.inneractive.sdk.player.exoplayer2.audio.t.c[a2] * 1000) / 2;
                        mVar.c(10);
                        com.fyber.inneractive.sdk.player.exoplayer2.o a3 = com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "audio/vnd.dts", i7, -1, i5 + (mVar.a(2) > 0 ? 1 : 0), i6, null, null, str2);
                        this.i = a3;
                        this.d.a(a3);
                    } else {
                        c = 5;
                    }
                    this.j = (((bArr2[c] & 2) << 12) | ((bArr2[6] & 255) << 4) | ((bArr2[7] & 240) >> 4)) + 1;
                    this.h = (int) (((((((bArr2[4] & 1) << 6) | ((r3 & 252) >> 2)) + 1) * 32) * 1000000) / this.i.s);
                    this.f1485a.e(0);
                    this.d.a(15, this.f1485a);
                    this.e = 2;
                }
            } else if (i2 == 2) {
                int min2 = Math.min(i, this.j - this.f);
                this.d.a(min2, nVar);
                int i8 = this.f + min2;
                this.f = i8;
                int i9 = this.j;
                if (i8 == i9) {
                    this.d.a(this.k, 1, i9, 0, null);
                    this.k += this.h;
                    this.e = 0;
                }
            }
        }
    }
}
