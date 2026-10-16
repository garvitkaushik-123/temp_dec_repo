package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.o;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.EOFException;

/* loaded from: classes4.dex */
public final class c implements i {
    public static final int m = z.a("Xing");
    public static final int n = z.a("Info");
    public static final int o = z.a("VBRI");

    /* renamed from: a, reason: collision with root package name */
    public final long f1439a;
    public j e;
    public r f;
    public int g;
    public com.fyber.inneractive.sdk.player.exoplayer2.metadata.b h;
    public b i;
    public long k;
    public int l;
    public final n b = new n(10);
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.n c = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.n();
    public final m d = new m();
    public long j = -9223372036854775807L;

    public c(long j) {
        this.f1439a = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return a(bVar, true);
    }

    public final a b(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        bVar.a(this.b.f1591a, 0, 4, false);
        this.b.e(0);
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(this.b.b(), this.c);
        return new a(this.c.f, bVar.c, bVar.b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e2, code lost:
    
        if (r20 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e4, code lost:
    
        r19.a(r4 + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00eb, code lost:
    
        r18.g = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ed, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e9, code lost:
    
        r19.e = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, boolean z) {
        int i;
        int i2;
        int a2;
        int i3 = z ? 16384 : 131072;
        bVar.e = 0;
        if (bVar.c == 0) {
            int i4 = 0;
            while (true) {
                bVar.a(this.b.f1591a, 0, 10, false);
                this.b.e(0);
                if (this.b.l() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n.b) {
                    break;
                }
                n nVar = this.b;
                nVar.e(nVar.b + 3);
                int i5 = this.b.i();
                int i6 = i5 + 10;
                if (this.h == null) {
                    byte[] bArr = new byte[i6];
                    System.arraycopy(this.b.f1591a, 0, bArr, 0, 10);
                    bVar.a(bArr, 10, i5, false);
                    com.fyber.inneractive.sdk.player.exoplayer2.metadata.b a3 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n(null).a(i6, bArr);
                    this.h = a3;
                    if (a3 != null) {
                        this.d.a(a3);
                    }
                } else {
                    bVar.a(i5, false);
                }
                i4 += i6;
            }
            bVar.e = 0;
            bVar.a(i4, false);
            i = (int) (bVar.c + bVar.e);
            if (!z) {
                bVar.a(i);
            }
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i7 = i2;
        int i8 = i7;
        while (true) {
            if (!bVar.a(this.b.f1591a, 0, 4, i2 > 0)) {
                break;
            }
            this.b.e(0);
            int b = this.b.b();
            if ((i7 == 0 || ((-128000) & b) == (i7 & (-128000))) && (a2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(b)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(b, this.c);
                    i7 = b;
                }
                bVar.a(a2 - 4, false);
            } else {
                int i9 = i8 + 1;
                if (i8 == i3) {
                    if (z) {
                        return false;
                    }
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Searched too many bytes.");
                }
                if (z) {
                    bVar.e = 0;
                    bVar.a(i + i9, false);
                } else {
                    bVar.a(1);
                }
                i7 = 0;
                i8 = i9;
                i2 = 0;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(j jVar) {
        this.e = jVar;
        this.f = jVar.a(0, 1);
        this.e.b();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.g = 0;
        this.j = -9223372036854775807L;
        this.k = 0L;
        this.l = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        if (r12 != com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.c.n) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b1  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, o oVar) {
        long j;
        long j2;
        int i;
        int i2;
        int b;
        b bVar2;
        int m2;
        b eVar;
        int j3;
        long j4;
        long min;
        if (this.g == 0) {
            try {
                a(bVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        int i3 = 1;
        if (this.i == null) {
            n nVar = new n(this.c.c);
            bVar.a(nVar.f1591a, 0, this.c.c, false);
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar2 = this.c;
            if ((nVar2.f1460a & 1) != 0) {
                if (nVar2.e != 1) {
                    i = 36;
                    if (nVar.c >= i + 4) {
                        nVar.e(i);
                        i2 = nVar.b();
                        if (i2 != m) {
                        }
                        if (i2 == m && i2 != n) {
                            if (i2 == o) {
                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar3 = this.c;
                                long j5 = bVar.c;
                                j = 1000000;
                                long j6 = bVar.b;
                                nVar.e(nVar.b + 10);
                                int b2 = nVar.b();
                                if (b2 <= 0) {
                                    j2 = 0;
                                } else {
                                    j2 = 0;
                                    int i4 = nVar3.d;
                                    long j7 = j6;
                                    long a2 = z.a(b2, (i4 >= 32000 ? 1152 : 576) * 1000000, i4);
                                    int o2 = nVar.o();
                                    int o3 = nVar.o();
                                    int o4 = nVar.o();
                                    int i5 = 2;
                                    nVar.e(nVar.b + 2);
                                    long j8 = j5 + nVar3.c;
                                    int i6 = o2 + 1;
                                    long[] jArr = new long[i6];
                                    long[] jArr2 = new long[i6];
                                    jArr[0] = 0;
                                    jArr2[0] = j8;
                                    int i7 = 1;
                                    while (i7 < i6) {
                                        if (o4 == i3) {
                                            j3 = nVar.j();
                                        } else if (o4 == i5) {
                                            j3 = nVar.o();
                                        } else if (o4 == 3) {
                                            j3 = nVar.l();
                                        } else if (o4 == 4) {
                                            j3 = nVar.m();
                                        }
                                        int i8 = i6;
                                        j8 += j3 * o3;
                                        int i9 = o3;
                                        int i10 = o4;
                                        jArr[i7] = (i7 * a2) / o2;
                                        if (j7 == -1) {
                                            min = j8;
                                            j4 = j7;
                                        } else {
                                            j4 = j7;
                                            min = Math.min(j4, j8);
                                        }
                                        jArr2[i7] = min;
                                        i7++;
                                        j7 = j4;
                                        o3 = i9;
                                        i6 = i8;
                                        o4 = i10;
                                        i5 = 2;
                                        i3 = 1;
                                    }
                                    bVar2 = new d(jArr, jArr2, a2);
                                    bVar.a(this.c.c);
                                }
                                bVar2 = null;
                                bVar.a(this.c.c);
                            } else {
                                j = 1000000;
                                j2 = 0;
                                bVar.e = 0;
                                bVar2 = null;
                            }
                        } else {
                            j = 1000000;
                            j2 = 0;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar4 = this.c;
                            long j9 = bVar.c;
                            long j10 = bVar.b;
                            int i11 = nVar4.g;
                            int i12 = nVar4.d;
                            long j11 = j9 + nVar4.c;
                            b = nVar.b();
                            if ((b & 1) == 1 || (m2 = nVar.m()) == 0) {
                                bVar2 = null;
                            } else {
                                long a3 = z.a(m2, i11 * 1000000, i12);
                                if ((b & 6) != 6) {
                                    eVar = new e(j11, a3, j10, null, 0L, 0);
                                } else {
                                    long m3 = nVar.m();
                                    nVar.e(nVar.b + 1);
                                    long[] jArr3 = new long[99];
                                    for (int i13 = 0; i13 < 99; i13++) {
                                        jArr3[i13] = nVar.j();
                                    }
                                    eVar = new e(j11, a3, j10, jArr3, m3, nVar4.c);
                                }
                                bVar2 = eVar;
                            }
                            if (bVar2 != null) {
                                m mVar = this.d;
                                if (mVar.f1430a == -1 || mVar.b == -1) {
                                    bVar.e = 0;
                                    bVar.a(i + ModuleDescriptor.MODULE_VERSION, false);
                                    bVar.a(this.b.f1591a, 0, 3, false);
                                    this.b.e(0);
                                    m mVar2 = this.d;
                                    int l = this.b.l();
                                    mVar2.getClass();
                                    int i14 = l >> 12;
                                    int i15 = l & 4095;
                                    if (i14 > 0 || i15 > 0) {
                                        mVar2.f1430a = i14;
                                        mVar2.b = i15;
                                    }
                                }
                            }
                            bVar.a(this.c.c);
                            if (bVar2 != null && !bVar2.a() && i2 == n) {
                                bVar2 = b(bVar);
                            }
                        }
                        this.i = bVar2;
                        if (bVar2 == null) {
                            this.i = b(bVar);
                        }
                        this.e.a(this.i);
                        r rVar = this.f;
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar5 = this.c;
                        String str = nVar5.b;
                        int i16 = nVar5.e;
                        int i17 = nVar5.d;
                        m mVar3 = this.d;
                        rVar.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, str, -1, 4096, i16, i17, -1, mVar3.f1430a, mVar3.b, null, null, 0, null, this.h));
                    }
                    if (nVar.c >= 40) {
                        nVar.e(36);
                        int b3 = nVar.b();
                        int i18 = o;
                        if (b3 == i18) {
                            i2 = i18;
                            if (i2 == m) {
                            }
                            j = 1000000;
                            j2 = 0;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar42 = this.c;
                            long j92 = bVar.c;
                            long j102 = bVar.b;
                            int i112 = nVar42.g;
                            int i122 = nVar42.d;
                            long j112 = j92 + nVar42.c;
                            b = nVar.b();
                            if ((b & 1) == 1) {
                            }
                            bVar2 = null;
                            if (bVar2 != null) {
                            }
                            bVar.a(this.c.c);
                            if (bVar2 != null) {
                                bVar2 = b(bVar);
                            }
                            this.i = bVar2;
                            if (bVar2 == null) {
                            }
                            this.e.a(this.i);
                            r rVar2 = this.f;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar52 = this.c;
                            String str2 = nVar52.b;
                            int i162 = nVar52.e;
                            int i172 = nVar52.d;
                            m mVar32 = this.d;
                            rVar2.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, str2, -1, 4096, i162, i172, -1, mVar32.f1430a, mVar32.b, null, null, 0, null, this.h));
                        }
                    }
                    i2 = 0;
                    if (i2 == m) {
                    }
                    j = 1000000;
                    j2 = 0;
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar422 = this.c;
                    long j922 = bVar.c;
                    long j1022 = bVar.b;
                    int i1122 = nVar422.g;
                    int i1222 = nVar422.d;
                    long j1122 = j922 + nVar422.c;
                    b = nVar.b();
                    if ((b & 1) == 1) {
                    }
                    bVar2 = null;
                    if (bVar2 != null) {
                    }
                    bVar.a(this.c.c);
                    if (bVar2 != null) {
                    }
                    this.i = bVar2;
                    if (bVar2 == null) {
                    }
                    this.e.a(this.i);
                    r rVar22 = this.f;
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar522 = this.c;
                    String str22 = nVar522.b;
                    int i1622 = nVar522.e;
                    int i1722 = nVar522.d;
                    m mVar322 = this.d;
                    rVar22.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, str22, -1, 4096, i1622, i1722, -1, mVar322.f1430a, mVar322.b, null, null, 0, null, this.h));
                }
                i = 21;
                if (nVar.c >= i + 4) {
                }
                if (nVar.c >= 40) {
                }
                i2 = 0;
                if (i2 == m) {
                }
                j = 1000000;
                j2 = 0;
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar4222 = this.c;
                long j9222 = bVar.c;
                long j10222 = bVar.b;
                int i11222 = nVar4222.g;
                int i12222 = nVar4222.d;
                long j11222 = j9222 + nVar4222.c;
                b = nVar.b();
                if ((b & 1) == 1) {
                }
                bVar2 = null;
                if (bVar2 != null) {
                }
                bVar.a(this.c.c);
                if (bVar2 != null) {
                }
                this.i = bVar2;
                if (bVar2 == null) {
                }
                this.e.a(this.i);
                r rVar222 = this.f;
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar5222 = this.c;
                String str222 = nVar5222.b;
                int i16222 = nVar5222.e;
                int i17222 = nVar5222.d;
                m mVar3222 = this.d;
                rVar222.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, str222, -1, 4096, i16222, i17222, -1, mVar3222.f1430a, mVar3222.b, null, null, 0, null, this.h));
            } else {
                if (nVar2.e == 1) {
                    i = 13;
                    if (nVar.c >= i + 4) {
                    }
                    if (nVar.c >= 40) {
                    }
                    i2 = 0;
                    if (i2 == m) {
                    }
                    j = 1000000;
                    j2 = 0;
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar42222 = this.c;
                    long j92222 = bVar.c;
                    long j102222 = bVar.b;
                    int i112222 = nVar42222.g;
                    int i122222 = nVar42222.d;
                    long j112222 = j92222 + nVar42222.c;
                    b = nVar.b();
                    if ((b & 1) == 1) {
                    }
                    bVar2 = null;
                    if (bVar2 != null) {
                    }
                    bVar.a(this.c.c);
                    if (bVar2 != null) {
                    }
                    this.i = bVar2;
                    if (bVar2 == null) {
                    }
                    this.e.a(this.i);
                    r rVar2222 = this.f;
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar52222 = this.c;
                    String str2222 = nVar52222.b;
                    int i162222 = nVar52222.e;
                    int i172222 = nVar52222.d;
                    m mVar32222 = this.d;
                    rVar2222.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, str2222, -1, 4096, i162222, i172222, -1, mVar32222.f1430a, mVar32222.b, null, null, 0, null, this.h));
                }
                i = 21;
                if (nVar.c >= i + 4) {
                }
                if (nVar.c >= 40) {
                }
                i2 = 0;
                if (i2 == m) {
                }
                j = 1000000;
                j2 = 0;
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar422222 = this.c;
                long j922222 = bVar.c;
                long j1022222 = bVar.b;
                int i1122222 = nVar422222.g;
                int i1222222 = nVar422222.d;
                long j1122222 = j922222 + nVar422222.c;
                b = nVar.b();
                if ((b & 1) == 1) {
                }
                bVar2 = null;
                if (bVar2 != null) {
                }
                bVar.a(this.c.c);
                if (bVar2 != null) {
                }
                this.i = bVar2;
                if (bVar2 == null) {
                }
                this.e.a(this.i);
                r rVar22222 = this.f;
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar522222 = this.c;
                String str22222 = nVar522222.b;
                int i1622222 = nVar522222.e;
                int i1722222 = nVar522222.d;
                m mVar322222 = this.d;
                rVar22222.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, str22222, -1, 4096, i1622222, i1722222, -1, mVar322222.f1430a, mVar322222.b, null, null, 0, null, this.h));
            }
        } else {
            j = 1000000;
            j2 = 0;
        }
        if (this.l == 0) {
            bVar.e = 0;
            if (!bVar.a(this.b.f1591a, 0, 4, true)) {
                return -1;
            }
            this.b.e(0);
            int b4 = this.b.b();
            if (((-128000) & b4) == (this.g & (-128000)) && com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(b4) != -1) {
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.n.a(b4, this.c);
                if (this.j == -9223372036854775807L) {
                    this.j = this.i.b(bVar.c);
                    if (this.f1439a != -9223372036854775807L) {
                        this.j = (this.f1439a - this.i.b(j2)) + this.j;
                    }
                }
                this.l = this.c.c;
            } else {
                bVar.a(1);
                this.g = 0;
                return 0;
            }
        }
        int a4 = this.f.a(bVar, this.l, true);
        if (a4 == -1) {
            return -1;
        }
        int i19 = this.l - a4;
        this.l = i19;
        if (i19 > 0) {
            return 0;
        }
        this.f.a(((this.k * j) / r5.d) + this.j, 1, this.c.c, 0, null);
        this.k += this.c.g;
        this.l = 0;
        return 0;
    }
}
