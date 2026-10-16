package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class m implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final int A = z.a("seig");
    public static final byte[] B = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.v f;
    public int l;
    public long m;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.n o;
    public long p;
    public int q;
    public l t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j y;
    public boolean z;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n g = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(16);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(com.fyber.inneractive.sdk.player.exoplayer2.util.l.f1589a);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(5);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n d = new com.fyber.inneractive.sdk.player.exoplayer2.util.n();
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n e = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(1);
    public final byte[] h = new byte[16];
    public final Stack i = new Stack();
    public final LinkedList j = new LinkedList();

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f1451a = new SparseArray();
    public long r = -9223372036854775807L;
    public long s = -9223372036854775807L;
    public int k = 0;
    public int n = 0;

    public m(com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar) {
        this.f = vVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return r.a(bVar, true);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.y = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        int size = this.f1451a.size();
        for (int i = 0; i < size; i++) {
            ((l) this.f1451a.valueAt(i)).a();
        }
        this.j.clear();
        this.q = 0;
        this.i.clear();
        this.k = 0;
        this.n = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:240:0x0083, code lost:
    
        r2 = r27.t;
        r3 = r2.f1450a;
        r4 = r3.h;
        r9 = r2.e;
        r27.u = r4[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0091, code lost:
    
        if (r3.l == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0093, code lost:
    
        r4 = r3.p;
        r10 = r3.f1458a.f1448a;
        r11 = r3.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x009b, code lost:
    
        if (r11 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x009e, code lost:
    
        r11 = r2.c.h[r10];
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x00a4, code lost:
    
        r10 = r11.f1457a;
        r3 = r3.m[r9];
        r9 = r27.e;
        r11 = r9.f1591a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x00ae, code lost:
    
        if (r3 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x00b0, code lost:
    
        r12 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x00b4, code lost:
    
        r11[0] = (byte) (r12 | r10);
        r9.e(0);
        r2 = r2.b;
        r2.a(1, r27.e);
        r2.a(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x00c5, code lost:
    
        if (r3 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x00c7, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x00dd, code lost:
    
        r27.v = r10;
        r27.u += r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x00ed, code lost:
    
        if (r27.t.c.g != 1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x00ef, code lost:
    
        r27.u -= 8;
        r28.a(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x00f7, code lost:
    
        r27.k = 4;
        r27.w = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x00fe, code lost:
    
        r2 = r27.t;
        r3 = r2.f1450a;
        r4 = r2.c;
        r9 = r2.b;
        r2 = r2.e;
        r5 = r4.k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x010a, code lost:
    
        if (r5 == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x010c, code lost:
    
        r12 = r27.c.f1591a;
        r12[0] = 0;
        r12[1] = 0;
        r12[r29] = 0;
        r13 = r5 + 1;
        r5 = 4 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x011e, code lost:
    
        if (r27.v >= r27.u) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0120, code lost:
    
        r14 = r27.w;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0122, code lost:
    
        if (r14 != 0) goto L311;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0154, code lost:
    
        if (r27.x == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0156, code lost:
    
        r27.d.c(r14);
        r28.b(r27.d.f1591a, r7 ? 1 : 0, r27.w, r7);
        r9.a(r27.w, r27.d);
        r14 = r27.w;
        r15 = r27.d;
        r18 = r8;
        r8 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(r15.c, r15.f1591a);
        r27.d.e("video/hevc".equals(r4.f.f) ? 1 : 0);
        r27.d.d(r8);
        r21 = r6;
        com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a((r3.j[r2] + r3.i[r2]) * 1000, r27.d, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x01af, code lost:
    
        r27.v += r14;
        r27.w -= r14;
        r8 = r18;
        r6 = r21;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x01a4, code lost:
    
        r21 = r6;
        r18 = r8;
        r14 = r9.a(r28, r14, r7 ? 1 : 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0124, code lost:
    
        r28.b(r12, r5, r13, r7);
        r27.c.e(r7 ? 1 : 0);
        r27.w = r27.c.m() - r6;
        r27.b.e(r7 ? 1 : 0);
        r9.a(r8, r27.b);
        r9.a(r6, r27.c);
        r27.x = r7;
        r27.v += 5;
        r27.u += r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x01c0, code lost:
    
        r19 = 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x01db, code lost:
    
        r5 = (r3.j[r2] + r3.i[r2]) * r19;
        r1 = r3.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x01e9, code lost:
    
        if (r1 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x01eb, code lost:
    
        r7 = 1073741824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x01ef, code lost:
    
        r12 = r7 | (r3.k[r2] ? 1 : 0);
        r2 = r3.f1458a.f1448a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x01f9, code lost:
    
        if (r1 == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x01fb, code lost:
    
        r1 = r3.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x01fd, code lost:
    
        if (r1 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x01ff, code lost:
    
        r1 = r1.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x0208, code lost:
    
        r15 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x020b, code lost:
    
        r1 = r27.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x020d, code lost:
    
        if (r1 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x020f, code lost:
    
        r5 = r1.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0213, code lost:
    
        r9.a(r5, r12, r27.u, 0, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0220, code lost:
    
        if (r27.j.isEmpty() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x0222, code lost:
    
        r1 = r27.t;
        r1.e++;
        r2 = r1.f + 1;
        r1.f = r2;
        r3 = r3.g;
        r4 = r1.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x0236, code lost:
    
        if (r2 != r3[r4]) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0238, code lost:
    
        r1.g = r4 + 1;
        r5 = 0;
        r1.f = 0;
        r27.t = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x0244, code lost:
    
        r27.k = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0247, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0243, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0248, code lost:
    
        r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.k) r27.j.removeFirst();
        r27.q -= r1.b;
        r1 = r1.f1449a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x025b, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0202, code lost:
    
        r1 = r4.h[r2].b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x020a, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x01ee, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x01c5, code lost:
    
        r19 = 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x01c9, code lost:
    
        r5 = r27.v;
        r6 = r27.u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x01cd, code lost:
    
        if (r5 >= r6) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x01cf, code lost:
    
        r27.v += r9.a(r28, r6 - r5, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x00c9, code lost:
    
        r3 = r4.o();
        r4.e(r4.b - 2);
        r3 = (r3 * 6) + 2;
        r2.a(r3, r4);
        r10 = (r10 + 1) + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x00b3, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x00e5, code lost:
    
        r27.v = 0;
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) {
        char c;
        long n;
        long n2;
        while (true) {
            int i = this.k;
            char c2 = 2;
            int i2 = 1;
            boolean z = false;
            if (i != 0) {
                int i3 = 4;
                if (i != 1) {
                    long j = Long.MAX_VALUE;
                    if (i != 2) {
                        if (i != 3) {
                            c = 2;
                            break;
                        }
                        if (this.t != null) {
                            c = 2;
                            break;
                        }
                        SparseArray sparseArray = this.f1451a;
                        int size = sparseArray.size();
                        int i4 = 0;
                        l lVar = null;
                        while (i4 < size) {
                            l lVar2 = (l) sparseArray.valueAt(i4);
                            char c3 = c2;
                            int i5 = lVar2.g;
                            u uVar = lVar2.f1450a;
                            if (i5 != uVar.d) {
                                long j2 = uVar.f[i5];
                                if (j2 < j) {
                                    j = j2;
                                    lVar = lVar2;
                                }
                            }
                            i4++;
                            c2 = c3;
                        }
                        c = c2;
                        if (lVar == null) {
                            int i6 = (int) (this.p - bVar.c);
                            if (i6 >= 0) {
                                bVar.a(i6);
                                this.k = 0;
                                this.n = 0;
                            } else {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Offset to end of mdat was negative.");
                            }
                        } else {
                            int i7 = (int) (lVar.f1450a.f[lVar.g] - bVar.c);
                            if (i7 < 0) {
                                Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                i7 = 0;
                            }
                            bVar.a(i7);
                            this.t = lVar;
                        }
                    } else {
                        int size2 = this.f1451a.size();
                        l lVar3 = null;
                        for (int i8 = 0; i8 < size2; i8++) {
                            u uVar2 = ((l) this.f1451a.valueAt(i8)).f1450a;
                            if (uVar2.q) {
                                long j3 = uVar2.c;
                                if (j3 < j) {
                                    lVar3 = (l) this.f1451a.valueAt(i8);
                                    j = j3;
                                }
                            }
                        }
                        if (lVar3 == null) {
                            this.k = 3;
                        } else {
                            int i9 = (int) (j - bVar.c);
                            if (i9 >= 0) {
                                bVar.a(i9);
                                u uVar3 = lVar3.f1450a;
                                bVar.b(uVar3.p.f1591a, 0, uVar3.o, false);
                                uVar3.p.e(0);
                                uVar3.q = false;
                            } else {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Offset to encryption data was negative.");
                            }
                        }
                    }
                } else {
                    int i10 = ((int) this.m) - this.n;
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.o;
                    if (nVar != null) {
                        bVar.b(nVar.f1591a, 8, i10, false);
                        int i11 = this.l;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.o;
                        b bVar2 = new b(i11, nVar2);
                        long j4 = bVar.c;
                        if (!this.i.isEmpty()) {
                            ((a) this.i.peek()).Q0.add(bVar2);
                        } else if (i11 == c.B) {
                            nVar2.e(8);
                            int b = (nVar2.b() >> 24) & 255;
                            nVar2.e(nVar2.b + 4);
                            long k = nVar2.k();
                            if (b == 0) {
                                n = nVar2.k();
                                n2 = nVar2.k();
                            } else {
                                n = nVar2.n();
                                n2 = nVar2.n();
                            }
                            long j5 = n2 + j4;
                            long j6 = n;
                            long j7 = j5;
                            long a2 = z.a(j6, 1000000L, k);
                            nVar2.e(nVar2.b + 2);
                            int o = nVar2.o();
                            int[] iArr = new int[o];
                            long[] jArr = new long[o];
                            long[] jArr2 = new long[o];
                            long[] jArr3 = new long[o];
                            long j8 = a2;
                            long j9 = j6;
                            int i12 = 0;
                            while (i12 < o) {
                                int b2 = nVar2.b();
                                if ((b2 & Integer.MIN_VALUE) == 0) {
                                    long k2 = nVar2.k();
                                    iArr[i12] = b2 & Integer.MAX_VALUE;
                                    jArr[i12] = j7;
                                    jArr3[i12] = j8;
                                    long j10 = j9 + k2;
                                    long[] jArr4 = jArr2;
                                    long[] jArr5 = jArr3;
                                    int i13 = i12;
                                    j8 = z.a(j10, 1000000L, k);
                                    jArr4[i13] = j8 - jArr5[i13];
                                    nVar2.e(nVar2.b + 4);
                                    long j11 = j7 + iArr[i13];
                                    i12 = i13 + 1;
                                    j9 = j10;
                                    jArr2 = jArr4;
                                    jArr3 = jArr5;
                                    j7 = j11;
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Unhandled indirect reference");
                                }
                            }
                            Pair create = Pair.create(Long.valueOf(a2), new com.fyber.inneractive.sdk.player.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3));
                            this.s = ((Long) create.first).longValue();
                            this.y.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.q) create.second);
                            this.z = true;
                        } else {
                            int i14 = c.G0;
                        }
                    } else {
                        bVar.a(i10);
                    }
                    a(bVar.c);
                }
            } else {
                if (this.n == 0) {
                    if (!bVar.b(this.g.f1591a, 0, 8, true)) {
                        return -1;
                    }
                    this.n = 8;
                    this.g.e(0);
                    this.m = this.g.k();
                    this.l = this.g.b();
                }
                if (this.m == 1) {
                    bVar.b(this.g.f1591a, 8, 8, false);
                    this.n += 8;
                    this.m = this.g.n();
                }
                long j12 = this.m;
                long j13 = this.n;
                if (j12 >= j13) {
                    long j14 = bVar.c - j13;
                    if (this.l == c.L) {
                        int size3 = this.f1451a.size();
                        for (int i15 = 0; i15 < size3; i15++) {
                            u uVar4 = ((l) this.f1451a.valueAt(i15)).f1450a;
                            uVar4.getClass();
                            uVar4.c = j14;
                            uVar4.b = j14;
                        }
                    }
                    int i16 = this.l;
                    if (i16 == c.i) {
                        this.t = null;
                        this.p = j14 + this.m;
                        if (!this.z) {
                            this.y.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(this.r));
                            this.z = true;
                        }
                        this.k = 2;
                    } else if (i16 != c.C && i16 != c.E && i16 != c.F && i16 != c.G && i16 != c.H && i16 != c.L && i16 != c.M && i16 != c.N && i16 != c.Q) {
                        if (i16 == c.T || i16 == c.S || i16 == c.D || i16 == c.B || i16 == c.U || i16 == c.x || i16 == c.y || i16 == c.P || i16 == c.z || i16 == c.A || i16 == c.V || i16 == c.d0 || i16 == c.e0 || i16 == c.i0 || i16 == c.h0 || i16 == c.f0 || i16 == c.g0 || i16 == c.R || i16 == c.O || i16 == c.G0) {
                            if (this.n == 8) {
                                long j15 = this.m;
                                if (j15 <= 2147483647L) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.util.n((int) j15);
                                    this.o = nVar3;
                                    System.arraycopy(this.g.f1591a, 0, nVar3.f1591a, 0, 8);
                                    this.k = 1;
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Leaf atom with length > 2147483647 (unsupported).");
                                }
                            } else {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Leaf atom defines extended atom size (unsupported).");
                            }
                        } else if (this.m <= 2147483647L) {
                            this.o = null;
                            this.k = 1;
                        } else {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Skipping atom with length > 2147483647 (unsupported).");
                        }
                    } else {
                        long j16 = (bVar.c + this.m) - 8;
                        this.i.add(new a(this.l, j16));
                        if (this.m == this.n) {
                            a(j16);
                        } else {
                            this.k = 0;
                            this.n = 0;
                        }
                    }
                } else {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Atom size less than header length (unsupported).");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:209:0x05b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(long j) {
        s a2;
        int i;
        SparseArray sparseArray;
        int i2;
        int i3;
        int i4;
        int i5;
        int size;
        int i6;
        int i7;
        int i8;
        ArrayList arrayList;
        long j2;
        int i9;
        boolean z;
        long j3;
        int i10;
        long j4;
        int i11;
        int i12;
        int i13;
        int i14;
        j jVar;
        int i15;
        while (!this.i.isEmpty() && ((a) this.i.peek()).P0 == j) {
            a aVar = (a) this.i.pop();
            int i16 = aVar.f1442a;
            int i17 = 12;
            int i18 = 8;
            int i19 = 1;
            if (i16 == c.C) {
                com.fyber.inneractive.sdk.player.exoplayer2.drm.d a3 = a(aVar.Q0);
                a b = aVar.b(c.N);
                SparseArray sparseArray2 = new SparseArray();
                int size2 = b.Q0.size();
                long j5 = -9223372036854775807L;
                int i20 = 0;
                while (i20 < size2) {
                    b bVar = (b) b.Q0.get(i20);
                    int i21 = bVar.f1442a;
                    if (i21 == c.z) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = bVar.P0;
                        nVar.e(i17);
                        i = i19;
                        Pair create = Pair.create(Integer.valueOf(nVar.b()), new j(nVar.m() - i19, nVar.m(), nVar.m(), nVar.b()));
                        sparseArray2.put(((Integer) create.first).intValue(), (j) create.second);
                    } else {
                        i = i19;
                        if (i21 == c.O) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = bVar.P0;
                            nVar2.e(8);
                            j5 = ((nVar2.b() >> 24) & 255) == 0 ? nVar2.k() : nVar2.n();
                        }
                    }
                    i20++;
                    i19 = i;
                    i17 = 12;
                }
                SparseArray sparseArray3 = new SparseArray();
                int size3 = aVar.R0.size();
                for (int i22 = 0; i22 < size3; i22++) {
                    a aVar2 = (a) aVar.R0.get(i22);
                    if (aVar2.f1442a == c.E && (a2 = i.a(aVar2, aVar.c(c.D), j5, a3, false)) != null) {
                        sparseArray3.put(a2.f1456a, a2);
                    }
                }
                int size4 = sparseArray3.size();
                if (this.f1451a.size() == 0) {
                    for (int i23 = 0; i23 < size4; i23++) {
                        s sVar = (s) sparseArray3.valueAt(i23);
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a4 = this.y.a(i23, sVar.b);
                        l lVar = new l(a4);
                        j jVar2 = (j) sparseArray2.get(sVar.f1456a);
                        lVar.c = sVar;
                        jVar2.getClass();
                        lVar.d = jVar2;
                        a4.a(sVar.f);
                        lVar.a();
                        this.f1451a.put(sVar.f1456a, lVar);
                        this.r = Math.max(this.r, sVar.e);
                    }
                    this.y.b();
                } else {
                    if (this.f1451a.size() != size4) {
                        throw new IllegalStateException();
                    }
                    for (int i24 = 0; i24 < size4; i24++) {
                        s sVar2 = (s) sparseArray3.valueAt(i24);
                        l lVar2 = (l) this.f1451a.get(sVar2.f1456a);
                        j jVar3 = (j) sparseArray2.get(sVar2.f1456a);
                        lVar2.getClass();
                        lVar2.c = sVar2;
                        jVar3.getClass();
                        lVar2.d = jVar3;
                        lVar2.b.a(sVar2.f);
                        lVar2.a();
                    }
                }
            } else {
                int i25 = 1;
                if (i16 == c.L) {
                    SparseArray sparseArray4 = this.f1451a;
                    byte[] bArr = this.h;
                    int size5 = aVar.R0.size();
                    int i26 = 0;
                    while (i26 < size5) {
                        a aVar3 = (a) aVar.R0.get(i26);
                        if (aVar3.f1442a == c.M) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = aVar3.c(c.y).P0;
                            nVar3.e(i18);
                            int b2 = nVar3.b();
                            l lVar3 = (l) sparseArray4.get(nVar3.b());
                            if (lVar3 == null) {
                                lVar3 = null;
                            } else {
                                if ((b2 & 1) != 0) {
                                    long n = nVar3.n();
                                    u uVar = lVar3.f1450a;
                                    uVar.b = n;
                                    uVar.c = n;
                                }
                                j jVar4 = lVar3.d;
                                lVar3.f1450a.f1458a = new j((b2 & 2) != 0 ? nVar3.m() - 1 : jVar4.f1448a, (b2 & 8) != 0 ? nVar3.m() : jVar4.b, (b2 & 16) != 0 ? nVar3.m() : jVar4.c, (b2 & 32) != 0 ? nVar3.m() : jVar4.d);
                            }
                            if (lVar3 != null) {
                                u uVar2 = lVar3.f1450a;
                                long j6 = uVar2.r;
                                lVar3.a();
                                int i27 = c.x;
                                if (aVar3.c(i27) != null) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = aVar3.c(i27).P0;
                                    nVar4.e(i18);
                                    j6 = ((nVar4.b() >> 24) & 255) == i25 ? nVar4.n() : nVar4.k();
                                }
                                ArrayList arrayList2 = aVar3.Q0;
                                int size6 = arrayList2.size();
                                int i28 = 0;
                                int i29 = 0;
                                int i30 = 0;
                                while (i29 < size6) {
                                    SparseArray sparseArray5 = sparseArray4;
                                    b bVar2 = (b) arrayList2.get(i29);
                                    int i31 = size5;
                                    int i32 = i26;
                                    if (bVar2.f1442a == c.A) {
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar5 = bVar2.P0;
                                        nVar5.e(12);
                                        int m = nVar5.m();
                                        if (m > 0) {
                                            i28 += m;
                                            i30++;
                                        }
                                    }
                                    i29++;
                                    size5 = i31;
                                    sparseArray4 = sparseArray5;
                                    i26 = i32;
                                }
                                sparseArray = sparseArray4;
                                i2 = size5;
                                i3 = i26;
                                lVar3.g = 0;
                                lVar3.f = 0;
                                lVar3.e = 0;
                                u uVar3 = lVar3.f1450a;
                                uVar3.d = i30;
                                uVar3.e = i28;
                                int[] iArr = uVar3.g;
                                if (iArr == null || iArr.length < i30) {
                                    uVar3.f = new long[i30];
                                    uVar3.g = new int[i30];
                                }
                                int[] iArr2 = uVar3.h;
                                if (iArr2 == null || iArr2.length < i28) {
                                    int i33 = (i28 * Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) / 100;
                                    uVar3.h = new int[i33];
                                    uVar3.i = new int[i33];
                                    uVar3.j = new long[i33];
                                    uVar3.k = new boolean[i33];
                                    uVar3.m = new boolean[i33];
                                }
                                int i34 = 0;
                                int i35 = 0;
                                int i36 = 0;
                                while (i34 < size6) {
                                    long j7 = 0;
                                    b bVar3 = (b) arrayList2.get(i34);
                                    if (bVar3.f1442a == c.A) {
                                        int i37 = i35 + 1;
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar6 = bVar3.P0;
                                        nVar6.e(8);
                                        int b3 = nVar6.b();
                                        i8 = i34;
                                        s sVar3 = lVar3.c;
                                        u uVar4 = lVar3.f1450a;
                                        int i38 = i35;
                                        j jVar5 = uVar4.f1458a;
                                        int i39 = i36;
                                        uVar4.g[i38] = nVar6.m();
                                        long[] jArr = uVar4.f;
                                        j2 = j6;
                                        long j8 = uVar4.b;
                                        jArr[i38] = j8;
                                        if ((b3 & 1) != 0) {
                                            jArr[i38] = j8 + nVar6.b();
                                        }
                                        boolean z2 = (b3 & 4) != 0;
                                        int i40 = jVar5.d;
                                        if (z2) {
                                            i40 = nVar6.m();
                                        }
                                        boolean z3 = (b3 & 256) != 0;
                                        boolean z4 = z2;
                                        boolean z5 = (b3 & 512) != 0;
                                        boolean z6 = (b3 & 1024) != 0;
                                        boolean z7 = (b3 & 2048) != 0;
                                        boolean z8 = z6;
                                        long[] jArr2 = sVar3.i;
                                        arrayList = arrayList2;
                                        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
                                            i9 = i40;
                                            z = z3;
                                            j7 = z.a(sVar3.j[0], 1000L, sVar3.c);
                                        } else {
                                            i9 = i40;
                                            z = z3;
                                        }
                                        int[] iArr3 = uVar4.h;
                                        int[] iArr4 = uVar4.i;
                                        int i41 = i9;
                                        long[] jArr3 = uVar4.j;
                                        boolean[] zArr = uVar4.k;
                                        int i42 = i39 + uVar4.g[i38];
                                        long j9 = sVar3.c;
                                        if (i38 > 0) {
                                            j3 = j9;
                                            j4 = uVar4.r;
                                            i10 = i39;
                                        } else {
                                            j3 = j9;
                                            i10 = i39;
                                            j4 = j2;
                                        }
                                        while (i10 < i42) {
                                            if (z) {
                                                i11 = nVar6.m();
                                            } else {
                                                i11 = jVar5.b;
                                            }
                                            int m2 = z5 ? nVar6.m() : jVar5.c;
                                            if (i10 == 0 && z4) {
                                                i12 = i10;
                                                i13 = i41;
                                            } else if (z8) {
                                                i12 = i10;
                                                i13 = nVar6.b();
                                            } else {
                                                i12 = i10;
                                                i13 = jVar5.d;
                                            }
                                            if (z7) {
                                                i14 = i13;
                                                jVar = jVar5;
                                                i15 = i42;
                                                iArr4[i12] = (int) ((nVar6.b() * 1000) / j3);
                                            } else {
                                                i14 = i13;
                                                jVar = jVar5;
                                                i15 = i42;
                                                iArr4[i12] = 0;
                                            }
                                            long j10 = j4;
                                            jArr3[i12] = z.a(j4, 1000L, j3) - j7;
                                            iArr3[i12] = m2;
                                            zArr[i12] = ((i14 >> 16) & 1) == 0;
                                            j4 = j10 + i11;
                                            i10 = i12 + 1;
                                            jVar5 = jVar;
                                            i42 = i15;
                                        }
                                        uVar4.r = j4;
                                        i35 = i37;
                                        i36 = i42;
                                    } else {
                                        i8 = i34;
                                        arrayList = arrayList2;
                                        j2 = j6;
                                    }
                                    i34 = i8 + 1;
                                    j6 = j2;
                                    arrayList2 = arrayList;
                                }
                                b c = aVar3.c(c.d0);
                                if (c != null) {
                                    t tVar = lVar3.c.h[uVar2.f1458a.f1448a];
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar7 = c.P0;
                                    int i43 = tVar.f1457a;
                                    nVar7.e(8);
                                    if ((nVar7.b() & 1) == 1) {
                                        nVar7.e(nVar7.b + 8);
                                    }
                                    int j11 = nVar7.j();
                                    int m3 = nVar7.m();
                                    if (m3 == uVar2.e) {
                                        if (j11 == 0) {
                                            boolean[] zArr2 = uVar2.m;
                                            i7 = 0;
                                            for (int i44 = 0; i44 < m3; i44++) {
                                                int j12 = nVar7.j();
                                                i7 += j12;
                                                zArr2[i44] = j12 > i43;
                                            }
                                        } else {
                                            i7 = j11 * m3;
                                            Arrays.fill(uVar2.m, 0, m3, j11 > i43);
                                        }
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar8 = uVar2.p;
                                        if (nVar8 == null || nVar8.c < i7) {
                                            uVar2.p = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(i7);
                                        }
                                        uVar2.o = i7;
                                        uVar2.l = true;
                                        uVar2.q = true;
                                    } else {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Length mismatch: ", m3, ", ").append(uVar2.e).toString());
                                    }
                                }
                                b c2 = aVar3.c(c.e0);
                                if (c2 != null) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar9 = c2.P0;
                                    nVar9.e(8);
                                    int b4 = nVar9.b();
                                    if ((b4 & 1) == 1) {
                                        nVar9.e(nVar9.b + 8);
                                    }
                                    int m4 = nVar9.m();
                                    if (m4 != 1) {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.m.a("Unexpected saio entry count: ", m4));
                                    }
                                    uVar2.c += ((b4 >> 24) & 255) == 0 ? nVar9.k() : nVar9.n();
                                }
                                b c3 = aVar3.c(c.i0);
                                if (c3 != null) {
                                    a(c3.P0, 0, uVar2);
                                }
                                b c4 = aVar3.c(c.f0);
                                b c5 = aVar3.c(c.g0);
                                if (c4 != null && c5 != null) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar10 = c4.P0;
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar11 = c5.P0;
                                    nVar10.e(8);
                                    int b5 = nVar10.b();
                                    int b6 = nVar10.b();
                                    int i45 = A;
                                    if (b6 == i45) {
                                        i5 = 1;
                                        if (((b5 >> 24) & 255) == 1) {
                                            nVar10.e(nVar10.b + 4);
                                        }
                                        if (nVar10.b() == 1) {
                                            nVar11.e(8);
                                            int b7 = nVar11.b();
                                            if (nVar11.b() == i45) {
                                                int i46 = (b7 >> 24) & 255;
                                                if (i46 == 1) {
                                                    if (nVar11.k() == 0) {
                                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Variable length decription in sgpd found (unsupported)");
                                                    }
                                                } else if (i46 >= 2) {
                                                    nVar11.e(nVar11.b + 4);
                                                }
                                                if (nVar11.k() == 1) {
                                                    nVar11.e(nVar11.b + 2);
                                                    i5 = 1;
                                                    if (nVar11.j() == 1) {
                                                        int j13 = nVar11.j();
                                                        byte[] bArr2 = new byte[16];
                                                        nVar11.a(bArr2, 0, 16);
                                                        uVar2.l = true;
                                                        uVar2.n = new t(j13, bArr2);
                                                    }
                                                } else {
                                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Entry count in sgpd != 1 (unsupported).");
                                                }
                                            }
                                            size = aVar3.Q0.size();
                                            for (i6 = 0; i6 < size; i6++) {
                                                b bVar4 = (b) aVar3.Q0.get(i6);
                                                if (bVar4.f1442a == c.h0) {
                                                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar12 = bVar4.P0;
                                                    nVar12.e(8);
                                                    nVar12.a(bArr, 0, 16);
                                                    if (Arrays.equals(bArr, B)) {
                                                        a(nVar12, 16, uVar2);
                                                    }
                                                }
                                            }
                                            i4 = 8;
                                            i26 = i3 + 1;
                                            i25 = i5;
                                            i18 = i4;
                                            size5 = i2;
                                            sparseArray4 = sparseArray;
                                        } else {
                                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Entry count in sbgp != 1 (unsupported).");
                                        }
                                    }
                                }
                                i5 = 1;
                                size = aVar3.Q0.size();
                                while (i6 < size) {
                                }
                                i4 = 8;
                                i26 = i3 + 1;
                                i25 = i5;
                                i18 = i4;
                                size5 = i2;
                                sparseArray4 = sparseArray;
                            }
                        }
                        sparseArray = sparseArray4;
                        i2 = size5;
                        i3 = i26;
                        i4 = i18;
                        i5 = i25;
                        i26 = i3 + 1;
                        i25 = i5;
                        i18 = i4;
                        size5 = i2;
                        sparseArray4 = sparseArray;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.drm.d a5 = a(aVar.Q0);
                    if (a5 != null) {
                        int i47 = 0;
                        for (int size7 = this.f1451a.size(); i47 < size7; size7 = size7) {
                            l lVar4 = (l) this.f1451a.valueAt(i47);
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = lVar4.b;
                            com.fyber.inneractive.sdk.player.exoplayer2.o oVar = lVar4.c.f;
                            rVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.o(oVar.f1523a, oVar.e, oVar.f, oVar.c, oVar.b, oVar.g, oVar.j, oVar.k, oVar.l, oVar.m, oVar.n, oVar.p, oVar.o, oVar.q, oVar.r, oVar.s, oVar.t, oVar.u, oVar.v, oVar.x, oVar.y, oVar.z, oVar.w, oVar.h, a5, oVar.d));
                            i47++;
                        }
                    }
                } else if (!this.i.isEmpty()) {
                    ((a) this.i.peek()).R0.add(aVar);
                }
            }
        }
        this.k = 0;
        this.n = 0;
    }

    public static void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, u uVar) {
        nVar.e(i + 8);
        int b = nVar.b();
        int i2 = c.b;
        if ((b & 1) == 0) {
            boolean z = (b & 2) != 0;
            int m = nVar.m();
            if (m == uVar.e) {
                Arrays.fill(uVar.m, 0, m, z);
                int i3 = nVar.c - nVar.b;
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = uVar.p;
                if (nVar2 == null || nVar2.c < i3) {
                    uVar.p = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(i3);
                }
                uVar.o = i3;
                uVar.l = true;
                uVar.q = true;
                nVar.a(uVar.p.f1591a, 0, i3);
                uVar.p.e(0);
                uVar.q = false;
                return;
            }
            throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Length mismatch: ", m, ", ").append(uVar.e).toString());
        }
        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.drm.d a(ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i = 0; i < size; i++) {
            b bVar = (b) arrayList.get(i);
            if (bVar.f1442a == c.V) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArr = bVar.P0.f1591a;
                UUID a2 = q.a(bArr);
                if (a2 == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new com.fyber.inneractive.sdk.player.exoplayer2.drm.c(a2, "video/mp4", bArr));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.drm.d(false, (com.fyber.inneractive.sdk.player.exoplayer2.drm.c[]) arrayList2.toArray(new com.fyber.inneractive.sdk.player.exoplayer2.drm.c[arrayList2.size()]));
    }
}
