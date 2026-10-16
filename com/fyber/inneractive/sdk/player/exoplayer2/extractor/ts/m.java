package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class m implements h {

    /* renamed from: a, reason: collision with root package name */
    public final x f1491a;
    public final boolean b;
    public final boolean c;
    public long g;
    public String i;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r j;
    public l k;
    public boolean l;
    public long m;
    public final boolean[] h = new boolean[3];
    public final r d = new r(7);
    public final r e = new r(8);
    public final r f = new r(6);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n n = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();

    public m(x xVar, boolean z, boolean z2) {
        this.f1491a = xVar;
        this.b = z;
        this.c = z2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(this.h);
        r rVar = this.d;
        rVar.b = false;
        rVar.c = false;
        r rVar2 = this.e;
        rVar2.b = false;
        rVar2.c = false;
        r rVar3 = this.f;
        rVar3.b = false;
        rVar3.c = false;
        l lVar = this.k;
        lVar.k = false;
        lVar.o = false;
        k kVar = lVar.n;
        kVar.b = false;
        kVar.f1489a = false;
        this.g = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.i = e0Var.e;
        e0Var.b();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a2 = jVar.a(e0Var.d, 2);
        this.j = a2;
        this.k = new l(a2, this.b, this.c);
        this.f1491a.a(jVar, e0Var);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.m = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x01f5, code lost:
    
        if (r2.j != r3.j) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01ff, code lost:
    
        if (r10 == 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0217, code lost:
    
        if (r2.n != r3.n) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x022c, code lost:
    
        if (r2.p != r3.p) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x023c, code lost:
    
        if (r2.l != r3.l) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0282, code lost:
    
        if (r3 == 2) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02b3 A[ADDED_TO_REGION] */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int i;
        int i2;
        l lVar;
        int i3;
        int i4;
        boolean z;
        l lVar2;
        int i5 = nVar.b;
        int i6 = nVar.c;
        byte[] bArr = nVar.f1591a;
        int i7 = i6 - i5;
        this.g += i7;
        this.j.a(i7, nVar);
        while (true) {
            int a2 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(bArr, i5, i6, this.h);
            if (a2 == i6) {
                break;
            }
            int i8 = a2 + 3;
            int i9 = bArr[i8] & Ascii.US;
            int i10 = a2 - i5;
            if (i10 > 0) {
                if (!this.l || this.k.c) {
                    this.d.a(bArr, i5, a2);
                    this.e.a(bArr, i5, a2);
                }
                this.f.a(bArr, i5, a2);
                this.k.a(bArr, i5, a2);
            }
            int i11 = i6 - a2;
            long j = this.g - i11;
            int i12 = i10 < 0 ? -i10 : 0;
            long j2 = this.m;
            if (!this.l || this.k.c) {
                this.d.a(i12);
                this.e.a(i12);
                if (!this.l) {
                    if (this.d.c && this.e.c) {
                        ArrayList arrayList = new ArrayList();
                        r rVar = this.d;
                        arrayList.add(Arrays.copyOf(rVar.d, rVar.e));
                        r rVar2 = this.e;
                        arrayList.add(Arrays.copyOf(rVar2.d, rVar2.e));
                        r rVar3 = this.d;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.k a3 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar3.d, 3, rVar3.e);
                        r rVar4 = this.e;
                        i = i11;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.o oVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.o(rVar4.d, 3, rVar4.e);
                        oVar.d(8);
                        int d = oVar.d();
                        int d2 = oVar.d();
                        oVar.f();
                        com.fyber.inneractive.sdk.player.exoplayer2.util.j jVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.j(oVar.c(), d, d2);
                        i2 = i6;
                        this.j.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(this.i, "video/avc", -1, a3.b, a3.c, arrayList, -1, a3.d, null, -1, null, null));
                        this.l = true;
                        this.k.d.append(a3.f1588a, a3);
                        this.k.e.append(d, jVar);
                        r rVar5 = this.d;
                        rVar5.b = false;
                        rVar5.c = false;
                        r rVar6 = this.e;
                        rVar6.b = false;
                        rVar6.c = false;
                    }
                } else {
                    i = i11;
                    i2 = i6;
                    r rVar7 = this.d;
                    if (rVar7.c) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.k a4 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar7.d, 3, rVar7.e);
                        this.k.d.append(a4.f1588a, a4);
                        r rVar8 = this.d;
                        rVar8.b = false;
                        rVar8.c = false;
                    } else {
                        r rVar9 = this.e;
                        if (rVar9.c) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.o oVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.o(rVar9.d, 3, rVar9.e);
                            oVar2.d(8);
                            int d3 = oVar2.d();
                            int d4 = oVar2.d();
                            oVar2.f();
                            this.k.e.append(d3, new com.fyber.inneractive.sdk.player.exoplayer2.util.j(oVar2.c(), d3, d4));
                            r rVar10 = this.e;
                            rVar10.b = false;
                            rVar10.c = false;
                        }
                    }
                }
                if (this.f.a(i12)) {
                    r rVar11 = this.f;
                    int a5 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(rVar11.e, rVar11.d);
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.n;
                    nVar2.f1591a = this.f.d;
                    nVar2.c = a5;
                    nVar2.b = 0;
                    nVar2.e(4);
                    com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(j2, this.n, this.f1491a.b);
                }
                lVar = this.k;
                if (lVar.i != 9) {
                    if (lVar.c) {
                        k kVar = lVar.n;
                        k kVar2 = lVar.m;
                        if (kVar.f1489a) {
                            if (kVar2.f1489a) {
                                if (kVar.f == kVar2.f) {
                                    if (kVar.g == kVar2.g) {
                                        if (kVar.h == kVar2.h) {
                                            if (kVar.i) {
                                                if (kVar2.i) {
                                                }
                                            }
                                            int i13 = kVar.d;
                                            int i14 = kVar2.d;
                                            if (i13 != i14) {
                                                if (i13 != 0) {
                                                }
                                            }
                                            int i15 = kVar.c.h;
                                            if (i15 == 0) {
                                                if (kVar2.c.h == 0) {
                                                    if (kVar.m == kVar2.m) {
                                                    }
                                                }
                                            }
                                            if (i15 == 1) {
                                                if (kVar2.c.h == 1) {
                                                    if (kVar.o == kVar2.o) {
                                                    }
                                                }
                                            }
                                            boolean z2 = kVar.k;
                                            boolean z3 = kVar2.k;
                                            if (z2 == z3) {
                                                if (z2) {
                                                    if (z3) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i3 = 1;
                    boolean z4 = lVar.r;
                    i4 = lVar.i;
                    if (i4 != 5) {
                        if (lVar.b && i4 == i3) {
                            k kVar3 = lVar.n;
                            if (kVar3.b) {
                                int i16 = kVar3.e;
                                if (i16 != 7) {
                                }
                            }
                        }
                        z = false;
                        lVar.r = z4 | z;
                        long j3 = this.m;
                        if (this.l || this.k.c) {
                            this.d.b(i9);
                            this.e.b(i9);
                        }
                        this.f.b(i9);
                        lVar2 = this.k;
                        lVar2.i = i9;
                        lVar2.l = j3;
                        lVar2.j = j;
                        if ((lVar2.b && i9 == 1) || (lVar2.c && (i9 == 5 || i9 == 1 || i9 == 2))) {
                            k kVar4 = lVar2.m;
                            lVar2.m = lVar2.n;
                            lVar2.n = kVar4;
                            kVar4.b = false;
                            kVar4.f1489a = false;
                            lVar2.h = 0;
                            lVar2.k = true;
                        }
                        i5 = i8;
                        i6 = i2;
                    }
                    z = true;
                    lVar.r = z4 | z;
                    long j32 = this.m;
                    if (this.l) {
                    }
                    this.d.b(i9);
                    this.e.b(i9);
                    this.f.b(i9);
                    lVar2 = this.k;
                    lVar2.i = i9;
                    lVar2.l = j32;
                    lVar2.j = j;
                    if (lVar2.b) {
                        k kVar42 = lVar2.m;
                        lVar2.m = lVar2.n;
                        lVar2.n = kVar42;
                        kVar42.b = false;
                        kVar42.f1489a = false;
                        lVar2.h = 0;
                        lVar2.k = true;
                        i5 = i8;
                        i6 = i2;
                    }
                    k kVar422 = lVar2.m;
                    lVar2.m = lVar2.n;
                    lVar2.n = kVar422;
                    kVar422.b = false;
                    kVar422.f1489a = false;
                    lVar2.h = 0;
                    lVar2.k = true;
                    i5 = i8;
                    i6 = i2;
                }
                if (lVar.o) {
                    long j4 = lVar.j;
                    lVar.f1490a.a(lVar.q, lVar.r ? 1 : 0, (int) (j4 - lVar.p), i + ((int) (j - j4)), null);
                }
                lVar.p = lVar.j;
                lVar.q = lVar.l;
                lVar.r = false;
                i3 = 1;
                lVar.o = true;
                boolean z42 = lVar.r;
                i4 = lVar.i;
                if (i4 != 5) {
                }
                z = true;
                lVar.r = z42 | z;
                long j322 = this.m;
                if (this.l) {
                }
                this.d.b(i9);
                this.e.b(i9);
                this.f.b(i9);
                lVar2 = this.k;
                lVar2.i = i9;
                lVar2.l = j322;
                lVar2.j = j;
                if (lVar2.b) {
                }
                k kVar4222 = lVar2.m;
                lVar2.m = lVar2.n;
                lVar2.n = kVar4222;
                kVar4222.b = false;
                kVar4222.f1489a = false;
                lVar2.h = 0;
                lVar2.k = true;
                i5 = i8;
                i6 = i2;
            }
            i = i11;
            i2 = i6;
            if (this.f.a(i12)) {
            }
            lVar = this.k;
            if (lVar.i != 9) {
            }
            if (lVar.o) {
            }
            lVar.p = lVar.j;
            lVar.q = lVar.l;
            lVar.r = false;
            i3 = 1;
            lVar.o = true;
            boolean z422 = lVar.r;
            i4 = lVar.i;
            if (i4 != 5) {
            }
            z = true;
            lVar.r = z422 | z;
            long j3222 = this.m;
            if (this.l) {
            }
            this.d.b(i9);
            this.e.b(i9);
            this.f.b(i9);
            lVar2 = this.k;
            lVar2.i = i9;
            lVar2.l = j3222;
            lVar2.j = j;
            if (lVar2.b) {
            }
            k kVar42222 = lVar2.m;
            lVar2.m = lVar2.n;
            lVar2.n = kVar42222;
            kVar42222.b = false;
            kVar42222.f1489a = false;
            lVar2.h = 0;
            lVar2.k = true;
            i5 = i8;
            i6 = i2;
        }
        if (!this.l || this.k.c) {
            this.d.a(bArr, i5, i6);
            this.e.a(bArr, i5, i6);
        }
        this.f.a(bArr, i5, i6);
        this.k.a(bArr, i5, i6);
    }
}
