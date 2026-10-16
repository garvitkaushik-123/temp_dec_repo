package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.google.common.base.Ascii;

/* loaded from: classes4.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.m f1477a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b;
    public final String c;
    public String d;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r e;
    public int f = 0;
    public int g;
    public boolean h;
    public long i;
    public com.fyber.inneractive.sdk.player.exoplayer2.o j;
    public int k;
    public long l;

    public b(String str) {
        byte[] bArr = new byte[8];
        this.f1477a = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(bArr);
        this.b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(bArr);
        this.c = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.f = 0;
        this.g = 0;
        this.h = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.d = e0Var.e;
        e0Var.b();
        this.e = jVar.a(e0Var.d, 1);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.l = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int a2;
        int i;
        String str;
        int i2;
        int i3;
        while (true) {
            int i4 = nVar.c - nVar.b;
            if (i4 <= 0) {
                return;
            }
            int i5 = this.f;
            if (i5 == 0) {
                while (true) {
                    if (nVar.c - nVar.b <= 0) {
                        break;
                    }
                    if (!this.h) {
                        this.h = nVar.j() == 11;
                    } else {
                        int j = nVar.j();
                        if (j == 119) {
                            this.h = false;
                            this.f = 1;
                            byte[] bArr = this.b.f1591a;
                            bArr[0] = Ascii.VT;
                            bArr[1] = 119;
                            this.g = 2;
                            break;
                        }
                        this.h = j == 11;
                    }
                }
            } else if (i5 == 1) {
                byte[] bArr2 = this.b.f1591a;
                int min = Math.min(i4, 8 - this.g);
                nVar.a(bArr2, this.g, min);
                int i6 = this.g + min;
                this.g = i6;
                if (i6 == 8) {
                    this.f1477a.b(0);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.m mVar = this.f1477a;
                    int i7 = (mVar.b * 8) + mVar.c;
                    mVar.c(40);
                    Object[] objArr = mVar.a(5) == 16;
                    mVar.b(i7);
                    int i8 = 6;
                    if (objArr != false) {
                        mVar.c(21);
                        i2 = (mVar.a(11) + 1) * 2;
                        int a3 = mVar.a(2);
                        if (a3 == 3) {
                            i = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.c[mVar.a(2)];
                        } else {
                            i8 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.f1381a[mVar.a(2)];
                            i = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b[a3];
                        }
                        i3 = i8 * 256;
                        a2 = mVar.a(3);
                        str = "audio/eac3";
                    } else {
                        mVar.c(32);
                        int a4 = mVar.a(2);
                        int a5 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.a(a4, mVar.a(6));
                        mVar.c(8);
                        a2 = mVar.a(3);
                        if ((a2 & 1) != 0 && a2 != 1) {
                            mVar.c(2);
                        }
                        if ((a2 & 4) != 0) {
                            mVar.c(2);
                        }
                        if (a2 == 2) {
                            mVar.c(2);
                        }
                        i = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b[a4];
                        str = "audio/ac3";
                        i2 = a5;
                        i3 = 1536;
                    }
                    int i9 = i;
                    String str2 = str;
                    int i10 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d[a2] + (mVar.b() ? 1 : 0);
                    com.fyber.inneractive.sdk.player.exoplayer2.o oVar = this.j;
                    if (oVar == null || i10 != oVar.r || i9 != oVar.s || str2 != oVar.f) {
                        com.fyber.inneractive.sdk.player.exoplayer2.o a6 = com.fyber.inneractive.sdk.player.exoplayer2.o.a(this.d, str2, -1, -1, i10, i9, null, null, this.c);
                        this.j = a6;
                        this.e.a(a6);
                    }
                    this.k = i2;
                    this.i = (i3 * 1000000) / this.j.s;
                    this.b.e(0);
                    this.e.a(8, this.b);
                    this.f = 2;
                }
            } else if (i5 == 2) {
                int min2 = Math.min(i4, this.k - this.g);
                this.e.a(min2, nVar);
                int i11 = this.g + min2;
                this.g = i11;
                int i12 = this.k;
                if (i11 == i12) {
                    this.e.a(this.l, 1, i12, 0, null);
                    this.l += this.i;
                    this.f = 0;
                }
            }
        }
    }
}
