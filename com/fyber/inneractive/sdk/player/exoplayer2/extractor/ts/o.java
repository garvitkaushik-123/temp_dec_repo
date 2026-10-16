package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class o implements h {

    /* renamed from: a, reason: collision with root package name */
    public final x f1493a;
    public String b;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r c;
    public n d;
    public boolean e;
    public long l;
    public long m;
    public final boolean[] f = new boolean[3];
    public final r g = new r(32);
    public final r h = new r(33);
    public final r i = new r(34);
    public final r j = new r(39);
    public final r k = new r(40);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n n = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();

    public o(x xVar) {
        this.f1493a = xVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(this.f);
        r rVar = this.g;
        rVar.b = false;
        rVar.c = false;
        r rVar2 = this.h;
        rVar2.b = false;
        rVar2.c = false;
        r rVar3 = this.i;
        rVar3.b = false;
        rVar3.c = false;
        r rVar4 = this.j;
        rVar4.b = false;
        rVar4.c = false;
        r rVar5 = this.k;
        rVar5.b = false;
        rVar5.c = false;
        n nVar = this.d;
        nVar.f = false;
        nVar.g = false;
        nVar.h = false;
        nVar.i = false;
        nVar.j = false;
        this.l = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.b = e0Var.e;
        e0Var.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a2 = jVar.a(e0Var.d, 2);
        this.c = a2;
        this.d = new n(a2);
        this.f1493a.a(jVar, e0Var);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        byte[] bArr;
        int i5;
        int i6;
        float f;
        byte[] bArr2;
        long j2;
        int i7;
        boolean z;
        boolean z2;
        while (true) {
            int i8 = nVar.c;
            int i9 = nVar.b;
            int i10 = i8 - i9;
            if (i10 <= 0) {
                return;
            }
            byte[] bArr3 = nVar.f1591a;
            this.l += i10;
            this.c.a(i10, nVar);
            while (i9 < i8) {
                int a2 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(bArr3, i9, i8, this.f);
                if (a2 == i8) {
                    a(bArr3, i9, i8);
                    return;
                }
                int i11 = a2 + 3;
                int i12 = (bArr3[i11] & 126) >> 1;
                int i13 = a2 - i9;
                if (i13 > 0) {
                    a(bArr3, i9, a2);
                }
                int i14 = i8 - a2;
                long j3 = this.l - i14;
                int i15 = i13 < 0 ? -i13 : 0;
                long j4 = this.m;
                if (this.e) {
                    n nVar2 = this.d;
                    i2 = 5;
                    if (nVar2.j && nVar2.g) {
                        nVar2.m = nVar2.c;
                        nVar2.j = false;
                    } else if (nVar2.h || nVar2.g) {
                        j = j4;
                        if (nVar2.i) {
                            long j5 = nVar2.b;
                            i = i14;
                            i3 = i15;
                            nVar2.f1492a.a(nVar2.l, nVar2.m ? 1 : 0, (int) (j5 - nVar2.k), i + ((int) (j3 - j5)), null);
                        } else {
                            i = i14;
                            i3 = i15;
                        }
                        nVar2.k = nVar2.b;
                        nVar2.l = nVar2.e;
                        nVar2.i = true;
                        nVar2.m = nVar2.c;
                        i4 = i8;
                        bArr = bArr3;
                        i5 = i11;
                        i6 = 16;
                    }
                    i4 = i8;
                    bArr = bArr3;
                    i5 = i11;
                    j = j4;
                    i = i14;
                    i6 = 16;
                    i3 = i15;
                } else {
                    j = j4;
                    i = i14;
                    i2 = 5;
                    i3 = i15;
                    this.g.a(i3);
                    this.h.a(i3);
                    this.i.a(i3);
                    r rVar = this.g;
                    if (rVar.c) {
                        r rVar2 = this.h;
                        if (rVar2.c) {
                            r rVar3 = this.i;
                            if (rVar3.c) {
                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar4 = this.c;
                                String str = this.b;
                                int i16 = rVar.e;
                                byte[] bArr4 = new byte[rVar2.e + i16 + rVar3.e];
                                i4 = i8;
                                bArr = bArr3;
                                System.arraycopy(rVar.d, 0, bArr4, 0, i16);
                                i5 = i11;
                                System.arraycopy(rVar2.d, 0, bArr4, rVar.e, rVar2.e);
                                System.arraycopy(rVar3.d, 0, bArr4, rVar.e + rVar2.e, rVar3.e);
                                com.fyber.inneractive.sdk.player.exoplayer2.util.o oVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.o(rVar2.d, 0, rVar2.e);
                                oVar.d(44);
                                int i17 = 3;
                                int b = oVar.b(3);
                                oVar.f();
                                oVar.d(88);
                                oVar.d(8);
                                int i18 = 0;
                                for (int i19 = 0; i19 < b; i19++) {
                                    if (oVar.c()) {
                                        i18 += 89;
                                    }
                                    if (oVar.c()) {
                                        i18 += 8;
                                    }
                                }
                                oVar.d(i18);
                                int i20 = 2;
                                if (b > 0) {
                                    oVar.d((8 - b) * 2);
                                }
                                oVar.d();
                                int d = oVar.d();
                                if (d == 3) {
                                    oVar.f();
                                }
                                int d2 = oVar.d();
                                int d3 = oVar.d();
                                if (oVar.c()) {
                                    int d4 = oVar.d();
                                    int d5 = oVar.d();
                                    int d6 = oVar.d();
                                    int d7 = oVar.d();
                                    d2 -= (d4 + d5) * ((d == 1 || d == 2) ? 2 : 1);
                                    d3 -= (d6 + d7) * (d == 1 ? 2 : 1);
                                }
                                int i21 = d2;
                                int i22 = d3;
                                oVar.d();
                                oVar.d();
                                int d8 = oVar.d();
                                for (int i23 = oVar.c() ? 0 : b; i23 <= b; i23++) {
                                    oVar.d();
                                    oVar.d();
                                    oVar.d();
                                }
                                oVar.d();
                                oVar.d();
                                oVar.d();
                                oVar.d();
                                oVar.d();
                                oVar.d();
                                if (oVar.c() && oVar.c()) {
                                    int i24 = 0;
                                    while (i24 < 4) {
                                        for (int i25 = 0; i25 < 6; i25 += i24 == i17 ? i17 : 1) {
                                            if (!oVar.c()) {
                                                oVar.d();
                                            } else {
                                                int min = Math.min(64, 1 << ((i24 << 1) + 4));
                                                if (i24 > 1) {
                                                    oVar.e();
                                                }
                                                for (int i26 = 0; i26 < min; i26++) {
                                                    oVar.e();
                                                }
                                                i17 = 3;
                                            }
                                        }
                                        i24++;
                                        i20 = 2;
                                    }
                                }
                                oVar.d(i20);
                                if (oVar.c()) {
                                    oVar.d(8);
                                    oVar.d();
                                    oVar.d();
                                    oVar.f();
                                }
                                int d9 = oVar.d();
                                boolean z3 = false;
                                int i27 = 0;
                                int i28 = 0;
                                while (i28 < d9) {
                                    if (i28 != 0) {
                                        z3 = oVar.c();
                                    }
                                    if (z3) {
                                        oVar.f();
                                        oVar.d();
                                        for (int i29 = 0; i29 <= i27; i29++) {
                                            if (oVar.c()) {
                                                oVar.f();
                                            }
                                        }
                                        bArr2 = bArr4;
                                    } else {
                                        int d10 = oVar.d();
                                        int d11 = oVar.d();
                                        int i30 = d10 + d11;
                                        bArr2 = bArr4;
                                        for (int i31 = 0; i31 < d10; i31++) {
                                            oVar.d();
                                            oVar.f();
                                        }
                                        for (int i32 = 0; i32 < d11; i32++) {
                                            oVar.d();
                                            oVar.f();
                                        }
                                        i27 = i30;
                                    }
                                    i28++;
                                    bArr4 = bArr2;
                                }
                                byte[] bArr5 = bArr4;
                                if (oVar.c()) {
                                    for (int i33 = 0; i33 < oVar.d(); i33++) {
                                        oVar.d(d8 + 5);
                                    }
                                }
                                oVar.d(2);
                                if (oVar.c() && oVar.c()) {
                                    int b2 = oVar.b(8);
                                    if (b2 == 255) {
                                        i6 = 16;
                                        int b3 = oVar.b(16);
                                        int b4 = oVar.b(16);
                                        if (b3 != 0 && b4 != 0) {
                                            f = b3 / b4;
                                            rVar4.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/hevc", -1, i21, i22, Collections.singletonList(bArr5), -1, f, null, -1, null, null));
                                            this.e = true;
                                        }
                                    } else {
                                        i6 = 16;
                                        float[] fArr = com.fyber.inneractive.sdk.player.exoplayer2.util.l.b;
                                        if (b2 < 17) {
                                            f = fArr[b2];
                                            rVar4.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/hevc", -1, i21, i22, Collections.singletonList(bArr5), -1, f, null, -1, null, null));
                                            this.e = true;
                                        } else {
                                            Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + b2);
                                        }
                                    }
                                } else {
                                    i6 = 16;
                                }
                                f = 1.0f;
                                rVar4.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/hevc", -1, i21, i22, Collections.singletonList(bArr5), -1, f, null, -1, null, null));
                                this.e = true;
                            }
                        }
                    }
                    i4 = i8;
                    bArr = bArr3;
                    i5 = i11;
                    i6 = 16;
                }
                if (this.j.a(i3)) {
                    r rVar5 = this.j;
                    int a3 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar5.e, rVar5.d);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.n;
                    nVar3.f1591a = this.j.d;
                    nVar3.c = a3;
                    nVar3.b = 0;
                    nVar3.e(i2);
                    j2 = j;
                    com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j2, this.n, this.f1493a.b);
                } else {
                    j2 = j;
                }
                if (this.k.a(i3)) {
                    r rVar6 = this.k;
                    int a4 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar6.e, rVar6.d);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = this.n;
                    nVar4.f1591a = this.k.d;
                    nVar4.c = a4;
                    nVar4.b = 0;
                    nVar4.e(5);
                    com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j2, this.n, this.f1493a.b);
                }
                long j6 = this.m;
                if (this.e) {
                    n nVar5 = this.d;
                    nVar5.g = false;
                    nVar5.h = false;
                    nVar5.e = j6;
                    nVar5.d = 0;
                    nVar5.b = j3;
                    if (i12 >= 32) {
                        if (nVar5.j || !nVar5.i) {
                            i7 = i6;
                            z = false;
                        } else {
                            i7 = i6;
                            z = false;
                            nVar5.f1492a.a(nVar5.l, nVar5.m ? 1 : 0, (int) (j3 - nVar5.k), i, null);
                            nVar5.i = false;
                        }
                        if (i12 <= 34) {
                            z2 = true;
                            nVar5.h = !nVar5.j;
                            nVar5.j = true;
                            boolean z4 = (i12 >= i7 || i12 > 21) ? z : z2;
                            nVar5.c = z4;
                            nVar5.f = (!z4 || i12 <= 9) ? z2 : z;
                        }
                    } else {
                        i7 = i6;
                        z = false;
                    }
                    z2 = true;
                    if (i12 >= i7) {
                    }
                    nVar5.c = z4;
                    nVar5.f = (!z4 || i12 <= 9) ? z2 : z;
                } else {
                    this.g.b(i12);
                    this.h.b(i12);
                    this.i.b(i12);
                }
                this.j.b(i12);
                this.k.b(i12);
                i9 = i5;
                i8 = i4;
                bArr3 = bArr;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.m = j;
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (this.e) {
            n nVar = this.d;
            if (nVar.f) {
                int i3 = nVar.d;
                int i4 = (i + 2) - i3;
                if (i4 < i2) {
                    nVar.g = (bArr[i4] & 128) != 0;
                    nVar.f = false;
                } else {
                    nVar.d = (i2 - i) + i3;
                }
            }
        } else {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }
}
