package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes4.dex */
public final class p implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i, com.fyber.inneractive.sdk.player.exoplayer2.extractor.q {
    public static final int p = z.a("qt  ");
    public int e;
    public int f;
    public long g;
    public int h;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.n i;
    public int j;
    public int k;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j l;
    public o[] m;
    public long n;
    public boolean o;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(16);
    public final Stack d = new Stack();

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f1454a = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(com.fyber.inneractive.sdk.player.exoplayer2.util.l.f1589a);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(4);

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.n;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return r.a(bVar, false);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e2 A[Catch: all -> 0x024e, TryCatch #0 {all -> 0x024e, blocks: (B:43:0x00ae, B:45:0x00b2, B:47:0x00c1, B:49:0x00d5, B:51:0x00da, B:53:0x00e2, B:60:0x00e9, B:62:0x00cd, B:63:0x00f1, B:65:0x00f5, B:67:0x00fc, B:69:0x0100, B:70:0x0107, B:72:0x010b, B:73:0x0115, B:75:0x0119, B:76:0x0120, B:78:0x0124, B:79:0x012a, B:81:0x012e, B:82:0x0135, B:84:0x0139, B:85:0x0140, B:87:0x0144, B:88:0x014b, B:90:0x014f, B:91:0x0156, B:93:0x015a, B:94:0x0161, B:96:0x0165, B:97:0x016c, B:99:0x0170, B:100:0x0178, B:102:0x017c, B:103:0x0184, B:105:0x0188, B:106:0x018f, B:108:0x0193, B:109:0x019b, B:111:0x019f, B:112:0x0219, B:119:0x01a5, B:121:0x01ad, B:122:0x01b3, B:124:0x01b7, B:127:0x01bd, B:129:0x01c1, B:132:0x01c7, B:134:0x01cb, B:135:0x01d3, B:137:0x01d7, B:138:0x01df, B:140:0x01e3, B:141:0x01eb, B:143:0x01ef, B:144:0x01f7, B:146:0x01fb, B:147:0x0203, B:149:0x0207, B:150:0x020d, B:152:0x0211, B:153:0x0232, B:154:0x023a), top: B:42:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x024a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e9 A[Catch: all -> 0x024e, TryCatch #0 {all -> 0x024e, blocks: (B:43:0x00ae, B:45:0x00b2, B:47:0x00c1, B:49:0x00d5, B:51:0x00da, B:53:0x00e2, B:60:0x00e9, B:62:0x00cd, B:63:0x00f1, B:65:0x00f5, B:67:0x00fc, B:69:0x0100, B:70:0x0107, B:72:0x010b, B:73:0x0115, B:75:0x0119, B:76:0x0120, B:78:0x0124, B:79:0x012a, B:81:0x012e, B:82:0x0135, B:84:0x0139, B:85:0x0140, B:87:0x0144, B:88:0x014b, B:90:0x014f, B:91:0x0156, B:93:0x015a, B:94:0x0161, B:96:0x0165, B:97:0x016c, B:99:0x0170, B:100:0x0178, B:102:0x017c, B:103:0x0184, B:105:0x0188, B:106:0x018f, B:108:0x0193, B:109:0x019b, B:111:0x019f, B:112:0x0219, B:119:0x01a5, B:121:0x01ad, B:122:0x01b3, B:124:0x01b7, B:127:0x01bd, B:129:0x01c1, B:132:0x01c7, B:134:0x01cb, B:135:0x01d3, B:137:0x01d7, B:138:0x01df, B:140:0x01e3, B:141:0x01eb, B:143:0x01ef, B:144:0x01f7, B:146:0x01fb, B:147:0x0203, B:149:0x0207, B:150:0x020d, B:152:0x0211, B:153:0x0232, B:154:0x023a), top: B:42:0x00ae }] */
    /* JADX WARN: Type inference failed for: r2v105, types: [com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j] */
    /* JADX WARN: Type inference failed for: r2v127, types: [com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.j] */
    /* JADX WARN: Type inference failed for: r2v133, types: [com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o] */
    /* JADX WARN: Type inference failed for: r2v135, types: [com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o] */
    /* JADX WARN: Type inference failed for: r2v149, types: [com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o] */
    /* JADX WARN: Type inference failed for: r2v151, types: [com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o] */
    /* JADX WARN: Type inference failed for: r3v49, types: [com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVar;
        s a2;
        e hVar;
        boolean z;
        long j2;
        int i;
        int i2;
        int i3;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar;
        boolean z2;
        a aVar;
        long j3;
        ArrayList arrayList;
        long[] jArr;
        int[] iArr;
        int[] iArr2;
        long[] jArr2;
        int i4;
        long j4;
        long[] jArr3;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar;
        int i5;
        v vVar;
        v vVar2;
        int i6;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar2;
        int[] iArr3;
        long j5;
        int i7;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar3;
        int i8;
        int i9;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar4;
        ArrayList arrayList2;
        int i10;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s sVar;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s sVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s sVar3;
        int i11;
        String str;
        while (!this.d.isEmpty() && ((a) this.d.peek()).P0 == j) {
            a aVar2 = (a) this.d.pop();
            if (aVar2.f1442a == c.C) {
                ArrayList arrayList3 = new ArrayList();
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar5 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.m();
                b c = aVar2.c(c.A0);
                int i12 = 12;
                boolean z3 = true;
                if (c != null) {
                    boolean z4 = this.o;
                    int i13 = i.f1447a;
                    if (!z4) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = c.P0;
                        char c2 = '\b';
                        nVar2.e(8);
                        while (true) {
                            int i14 = nVar2.c;
                            int i15 = nVar2.b;
                            if (i14 - i15 < 8) {
                                break;
                            }
                            int b = nVar2.b();
                            if (nVar2.b() == c.B0) {
                                nVar2.e(i15);
                                int i16 = i15 + b;
                                nVar2.e(nVar2.b + i12);
                                while (true) {
                                    int i17 = nVar2.b;
                                    if (i17 >= i16) {
                                        break;
                                    }
                                    int b2 = nVar2.b();
                                    char c3 = c2;
                                    if (nVar2.b() == c.C0) {
                                        nVar2.e(i17);
                                        int i18 = i17 + b2;
                                        nVar2.e(nVar2.b + 8);
                                        ArrayList arrayList4 = new ArrayList();
                                        while (true) {
                                            int i19 = nVar2.b;
                                            if (i19 >= i18) {
                                                break;
                                            }
                                            int i20 = n.f1452a;
                                            int b3 = nVar2.b() + i19;
                                            int b4 = nVar2.b();
                                            int i21 = (b4 >> 24) & 255;
                                            if (i21 == 169 || i21 == 65533) {
                                                int i22 = 16777215 & b4;
                                                if (i22 == n.c) {
                                                    sVar2 = n.a(b4, nVar2);
                                                } else {
                                                    if (i22 != n.f1452a && i22 != n.b) {
                                                        if (i22 != n.h && i22 != n.i) {
                                                            if (i22 == n.d) {
                                                                sVar2 = n.b(b4, nVar2, "TDRC");
                                                            } else if (i22 == n.e) {
                                                                sVar2 = n.b(b4, nVar2, "TPE1");
                                                            } else if (i22 == n.f) {
                                                                sVar2 = n.b(b4, nVar2, "TSSE");
                                                            } else if (i22 == n.g) {
                                                                sVar2 = n.b(b4, nVar2, "TALB");
                                                            } else if (i22 == n.j) {
                                                                sVar2 = n.b(b4, nVar2, "USLT");
                                                            } else if (i22 == n.k) {
                                                                sVar2 = n.b(b4, nVar2, "TCON");
                                                            } else {
                                                                if (i22 == n.n) {
                                                                    sVar2 = n.b(b4, nVar2, "TIT1");
                                                                }
                                                                Log.d("MetadataUtil", "Skipped unknown metadata entry: " + c.a(b4));
                                                                nVar2.e(b3);
                                                                sVar = null;
                                                                if (sVar == null) {
                                                                    arrayList4.add(sVar);
                                                                }
                                                            }
                                                        }
                                                        sVar2 = n.b(b4, nVar2, "TCOM");
                                                    }
                                                    sVar2 = n.b(b4, nVar2, "TIT2");
                                                }
                                                sVar3 = sVar2;
                                                nVar2.e(b3);
                                                sVar = sVar3;
                                                if (sVar == null) {
                                                }
                                            } else {
                                                try {
                                                    if (b4 == n.m) {
                                                        nVar2.e(nVar2.b + 4);
                                                        if (nVar2.b() == c.F0) {
                                                            nVar2.e(nVar2.b + 8);
                                                            i11 = nVar2.j();
                                                        } else {
                                                            Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
                                                            i11 = -1;
                                                        }
                                                        if (i11 > 0) {
                                                            String[] strArr = n.D;
                                                            if (i11 <= strArr.length) {
                                                                str = strArr[i11 - 1];
                                                                if (str == null) {
                                                                    sVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.s("TCON", null, str);
                                                                } else {
                                                                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                                                                    sVar3 = null;
                                                                }
                                                            }
                                                        }
                                                        str = null;
                                                        if (str == null) {
                                                        }
                                                    } else {
                                                        if (b4 == n.o) {
                                                            sVar2 = n.a(b4, nVar2, "TPOS");
                                                        } else if (b4 == n.p) {
                                                            sVar2 = n.a(b4, nVar2, "TRCK");
                                                        } else if (b4 == n.q) {
                                                            sVar2 = n.a(b4, "TBPM", nVar2, true, false);
                                                        } else if (b4 == n.r) {
                                                            sVar2 = n.a(b4, "TCMP", nVar2, true, true);
                                                        } else if (b4 == n.l) {
                                                            sVar3 = n.a(nVar2);
                                                        } else if (b4 == n.s) {
                                                            sVar2 = n.b(b4, nVar2, "TPE2");
                                                        } else if (b4 == n.t) {
                                                            sVar2 = n.b(b4, nVar2, "TSOT");
                                                        } else if (b4 == n.u) {
                                                            sVar2 = n.b(b4, nVar2, "TSO2");
                                                        } else if (b4 == n.v) {
                                                            sVar2 = n.b(b4, nVar2, "TSOA");
                                                        } else if (b4 == n.w) {
                                                            sVar2 = n.b(b4, nVar2, "TSOP");
                                                        } else if (b4 == n.x) {
                                                            sVar2 = n.b(b4, nVar2, "TSOC");
                                                        } else if (b4 == n.y) {
                                                            sVar2 = n.a(b4, "ITUNESADVISORY", nVar2, false, false);
                                                        } else if (b4 == n.z) {
                                                            sVar2 = n.a(b4, "ITUNESGAPLESS", nVar2, false, true);
                                                        } else if (b4 == n.A) {
                                                            sVar2 = n.b(b4, nVar2, "TVSHOWSORT");
                                                        } else if (b4 == n.B) {
                                                            sVar2 = n.b(b4, nVar2, "TVSHOW");
                                                        } else {
                                                            if (b4 == n.C) {
                                                                sVar2 = n.b(b3, nVar2);
                                                            }
                                                            Log.d("MetadataUtil", "Skipped unknown metadata entry: " + c.a(b4));
                                                            nVar2.e(b3);
                                                            sVar = null;
                                                            if (sVar == null) {
                                                            }
                                                        }
                                                        sVar3 = sVar2;
                                                    }
                                                    nVar2.e(b3);
                                                    sVar = sVar3;
                                                    if (sVar == null) {
                                                    }
                                                } catch (Throwable th) {
                                                    nVar2.e(b3);
                                                    throw th;
                                                }
                                            }
                                        }
                                        if (!arrayList4.isEmpty()) {
                                            bVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.b(arrayList4);
                                        }
                                    } else {
                                        nVar2.e(nVar2.b + (b2 - 8));
                                        c2 = c3;
                                    }
                                }
                            } else {
                                nVar2.e(nVar2.b + (b - 8));
                                i12 = 12;
                            }
                        }
                    }
                    bVar2 = null;
                    if (bVar2 != null) {
                        mVar5.a(bVar2);
                    }
                    bVar = bVar2;
                } else {
                    bVar = null;
                }
                long j6 = -9223372036854775807L;
                long j7 = Long.MAX_VALUE;
                int i23 = 0;
                while (i23 < aVar2.R0.size()) {
                    a aVar3 = (a) aVar2.R0.get(i23);
                    if (aVar3.f1442a == c.E && (a2 = i.a(aVar3, aVar2.c(c.D), -9223372036854775807L, (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) null, this.o)) != null) {
                        a b5 = aVar3.b(c.F).b(c.G).b(c.H);
                        b c4 = b5.c(c.q0);
                        if (c4 != null) {
                            hVar = new g(c4);
                        } else {
                            b c5 = b5.c(c.r0);
                            if (c5 == null) {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Track has no sample table size information");
                            }
                            hVar = new h(c5);
                        }
                        int a3 = hVar.a();
                        if (a3 == 0) {
                            aVar = aVar2;
                            j3 = j6;
                            arrayList = arrayList3;
                            mVar = mVar5;
                            i5 = i23;
                            j2 = j7;
                            vVar2 = new v(new long[0], new int[0], 0, new long[0], new int[0]);
                        } else {
                            b c6 = b5.c(c.s0);
                            if (c6 == null) {
                                c6 = b5.c(c.t0);
                                z = z3;
                            } else {
                                z = false;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = c6.P0;
                            boolean z5 = z3;
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = b5.c(c.p0).P0;
                            j2 = j7;
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar5 = b5.c(c.m0).P0;
                            b c7 = b5.c(c.n0);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar6 = c7 != null ? c7.P0 : null;
                            e eVar = hVar;
                            b c8 = b5.c(c.o0);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar7 = c8 != null ? c8.P0 : null;
                            d dVar = new d(nVar4, nVar3, z);
                            nVar5.e(12);
                            int m = nVar5.m() - 1;
                            int m2 = nVar5.m();
                            int m3 = nVar5.m();
                            if (nVar7 != null) {
                                nVar7.e(12);
                                i = nVar7.m();
                            } else {
                                i = 0;
                            }
                            if (nVar6 != null) {
                                nVar6.e(12);
                                i2 = nVar6.m();
                                if (i2 > 0) {
                                    i3 = nVar6.m() - 1;
                                    if (eVar.c()) {
                                        nVar = nVar7;
                                    } else {
                                        nVar = nVar7;
                                        if ("audio/raw".equals(a2.f.f) && m == 0 && i == 0 && i2 == 0) {
                                            z2 = z5 ? 1 : 0;
                                            if (z2) {
                                                aVar = aVar2;
                                                j3 = j6;
                                                arrayList = arrayList3;
                                                int i24 = dVar.f1443a;
                                                long[] jArr4 = new long[i24];
                                                int[] iArr4 = new int[i24];
                                                while (dVar.a()) {
                                                    int i25 = dVar.b;
                                                    jArr4[i25] = dVar.d;
                                                    iArr4[i25] = dVar.c;
                                                }
                                                int b6 = eVar.b();
                                                long j8 = m3;
                                                int i26 = 8192 / b6;
                                                int i27 = 0;
                                                for (int i28 = 0; i28 < i24; i28++) {
                                                    int i29 = iArr4[i28];
                                                    int i30 = z.f1599a;
                                                    i27 += ((i29 + i26) - 1) / i26;
                                                }
                                                long[] jArr5 = new long[i27];
                                                int[] iArr5 = new int[i27];
                                                long[] jArr6 = new long[i27];
                                                int[] iArr6 = new int[i27];
                                                int i31 = 0;
                                                int i32 = 0;
                                                int i33 = 0;
                                                int i34 = 0;
                                                while (i31 < i24) {
                                                    int i35 = iArr4[i31];
                                                    long j9 = jArr4[i31];
                                                    int[] iArr7 = iArr4;
                                                    int i36 = i35;
                                                    int i37 = i24;
                                                    int i38 = i32;
                                                    int i39 = i31;
                                                    int i40 = i34;
                                                    while (i36 > 0) {
                                                        int min = Math.min(i26, i36);
                                                        jArr5[i33] = j9;
                                                        int i41 = i36;
                                                        int i42 = b6 * min;
                                                        iArr5[i33] = i42;
                                                        int max = Math.max(i40, i42);
                                                        jArr6[i33] = i38 * j8;
                                                        iArr6[i33] = z5 ? 1 : 0;
                                                        j9 += iArr5[i33];
                                                        i38 += min;
                                                        i36 = i41 - min;
                                                        i33++;
                                                        i40 = max;
                                                    }
                                                    int i43 = i39 + 1;
                                                    i32 = i38;
                                                    i34 = i40;
                                                    i31 = i43;
                                                    iArr4 = iArr7;
                                                    i24 = i37;
                                                }
                                                jArr = jArr5;
                                                iArr = iArr6;
                                                iArr2 = iArr5;
                                                jArr2 = jArr6;
                                                i4 = i34;
                                                j4 = 0;
                                            } else {
                                                long[] jArr7 = new long[a3];
                                                int[] iArr8 = new int[a3];
                                                long[] jArr8 = new long[a3];
                                                int[] iArr9 = new int[a3];
                                                int i44 = m2;
                                                int i45 = m3;
                                                int i46 = m;
                                                aVar = aVar2;
                                                arrayList = arrayList3;
                                                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar8 = nVar6;
                                                int i47 = i;
                                                int i48 = i2;
                                                int i49 = i3;
                                                long j10 = 0;
                                                j4 = 0;
                                                int i50 = 0;
                                                int i51 = 0;
                                                int i52 = 0;
                                                int i53 = 0;
                                                int i54 = 0;
                                                while (i53 < a3) {
                                                    while (i54 == 0) {
                                                        if (!dVar.a()) {
                                                            throw new IllegalStateException();
                                                        }
                                                        long j11 = j6;
                                                        long j12 = dVar.d;
                                                        i54 = dVar.c;
                                                        j10 = j12;
                                                        j6 = j11;
                                                    }
                                                    long j13 = j6;
                                                    if (nVar != null) {
                                                        while (i51 == 0 && i47 > 0) {
                                                            i51 = nVar.m();
                                                            i52 = nVar.b();
                                                            i47--;
                                                        }
                                                        i51--;
                                                    }
                                                    int i55 = i52;
                                                    jArr7[i53] = j10;
                                                    int b7 = eVar.b();
                                                    iArr8[i53] = b7;
                                                    int i56 = b7 > i50 ? b7 : i50;
                                                    int i57 = i54;
                                                    jArr8[i53] = j4 + i55;
                                                    iArr9[i53] = nVar8 == null ? z5 ? 1 : 0 : (char) 0;
                                                    if (i53 == i49) {
                                                        iArr9[i53] = z5 ? 1 : 0;
                                                        i48--;
                                                        if (i48 > 0) {
                                                            i49 = nVar8.m() - 1;
                                                        }
                                                    }
                                                    j4 += i45;
                                                    i44--;
                                                    if (i44 == 0 && i46 > 0) {
                                                        i44 = nVar5.m();
                                                        i46--;
                                                        i45 = nVar5.m();
                                                    }
                                                    j10 += iArr8[i53];
                                                    i54 = i57 - 1;
                                                    i53++;
                                                    i50 = i56;
                                                    i52 = i55;
                                                    j6 = j13;
                                                }
                                                j3 = j6;
                                                if (i51 != 0) {
                                                    throw new IllegalArgumentException();
                                                }
                                                while (i47 > 0) {
                                                    if (nVar.m() != 0) {
                                                        throw new IllegalArgumentException();
                                                    }
                                                    nVar.b();
                                                    i47--;
                                                }
                                                if (i48 != 0 || i44 != 0 || i54 != 0 || i46 != 0) {
                                                    Log.w("AtomParsers", "Inconsistent stbl box for track " + a2.f1456a + ": remainingSynchronizationSamples " + i48 + ", remainingSamplesAtTimestampDelta " + i44 + ", remainingSamplesInChunk " + i54 + ", remainingTimestampDeltaChanges " + i46);
                                                }
                                                i4 = i50;
                                                iArr = iArr9;
                                                iArr2 = iArr8;
                                                jArr2 = jArr8;
                                                jArr = jArr7;
                                            }
                                            jArr3 = a2.i;
                                            if (jArr3 == null && (mVar5.f1430a == -1 || mVar5.b == -1)) {
                                                if (jArr3.length == z5 && a2.b == z5 && jArr2.length >= 2) {
                                                    long j14 = a2.j[0];
                                                    long a4 = z.a(jArr3[0], a2.c, a2.d) + j14;
                                                    long j15 = jArr2[0];
                                                    if (j15 <= j14 && j14 < jArr2[1] && jArr2[jArr2.length - 1] < a4 && a4 <= j4) {
                                                        long a5 = z.a(j14 - j15, a2.f.s, a2.c);
                                                        long a6 = z.a(j4 - a4, a2.f.s, a2.c);
                                                        if ((a5 != 0 || a6 != 0) && a5 <= 2147483647L && a6 <= 2147483647L) {
                                                            mVar5.f1430a = (int) a5;
                                                            mVar5.b = (int) a6;
                                                            z.a(jArr2, a2.c);
                                                            vVar = new v(jArr, iArr2, i4, jArr2, iArr);
                                                            mVar = mVar5;
                                                            i5 = i23;
                                                        }
                                                    }
                                                }
                                                long[] jArr9 = jArr2;
                                                long[] jArr10 = a2.i;
                                                if (jArr10.length == 1) {
                                                    char c9 = 0;
                                                    if (jArr10[0] == 0) {
                                                        int i58 = 0;
                                                        while (i58 < jArr9.length) {
                                                            jArr9[i58] = z.a(jArr9[i58] - a2.j[c9], 1000000L, a2.c);
                                                            i58++;
                                                            c9 = 0;
                                                        }
                                                        vVar = new v(jArr, iArr2, i4, jArr9, iArr);
                                                        mVar = mVar5;
                                                        i5 = i23;
                                                    }
                                                }
                                                long[] jArr11 = jArr;
                                                int[] iArr10 = iArr2;
                                                int[] iArr11 = iArr;
                                                boolean z6 = a2.b == 1;
                                                int i59 = 0;
                                                int i60 = 0;
                                                int i61 = 0;
                                                boolean z7 = false;
                                                while (true) {
                                                    long[] jArr12 = a2.i;
                                                    if (i59 >= jArr12.length) {
                                                        break;
                                                    }
                                                    boolean z8 = z7;
                                                    long j16 = a2.j[i59];
                                                    if (j16 != -1) {
                                                        mVar3 = mVar5;
                                                        i8 = i23;
                                                        long a7 = z.a(jArr12[i59], a2.c, a2.d);
                                                        i7 = i59;
                                                        int a8 = z.a(jArr9, j16, true, true);
                                                        int a9 = z.a(jArr9, j16 + a7, z6, false);
                                                        int i62 = (a9 - a8) + i60;
                                                        z7 = z8 | (i61 != a8);
                                                        i61 = a9;
                                                        i60 = i62;
                                                    } else {
                                                        i7 = i59;
                                                        mVar3 = mVar5;
                                                        i8 = i23;
                                                        z7 = z8;
                                                    }
                                                    i59 = i7 + 1;
                                                    mVar5 = mVar3;
                                                    i23 = i8;
                                                }
                                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar6 = mVar5;
                                                i5 = i23;
                                                boolean z9 = z7 | (i60 != a3);
                                                long[] jArr13 = z9 ? new long[i60] : jArr11;
                                                int[] iArr12 = z9 ? new int[i60] : iArr10;
                                                if (z9) {
                                                    i4 = 0;
                                                }
                                                int[] iArr13 = z9 ? new int[i60] : iArr11;
                                                long[] jArr14 = new long[i60];
                                                long j17 = 0;
                                                int i63 = i4;
                                                int i64 = 0;
                                                int i65 = 0;
                                                while (true) {
                                                    long[] jArr15 = a2.i;
                                                    boolean z10 = z9;
                                                    if (i64 >= jArr15.length) {
                                                        break;
                                                    }
                                                    long[] jArr16 = jArr14;
                                                    long j18 = a2.j[i64];
                                                    long j19 = jArr15[i64];
                                                    if (j18 != -1) {
                                                        int[] iArr14 = iArr11;
                                                        j5 = j19;
                                                        long a10 = z.a(j19, a2.c, a2.d) + j18;
                                                        i6 = i64;
                                                        mVar2 = mVar6;
                                                        int a11 = z.a(jArr9, j18, true, true);
                                                        int a12 = z.a(jArr9, a10, z6, false);
                                                        if (z10) {
                                                            int i66 = a12 - a11;
                                                            System.arraycopy(jArr11, a11, jArr13, i65, i66);
                                                            System.arraycopy(iArr10, a11, iArr12, i65, i66);
                                                            iArr3 = iArr14;
                                                            System.arraycopy(iArr3, a11, iArr13, i65, i66);
                                                        } else {
                                                            iArr3 = iArr14;
                                                        }
                                                        int i67 = i63;
                                                        while (a11 < a12) {
                                                            long j20 = j18;
                                                            jArr16[i65] = z.a(j17, 1000000L, a2.d) + z.a(jArr9[a11] - j20, 1000000L, a2.c);
                                                            if (z10 && iArr12[i65] > i67) {
                                                                i67 = iArr10[a11];
                                                            }
                                                            i65++;
                                                            a11++;
                                                            j18 = j20;
                                                        }
                                                        i63 = i67;
                                                    } else {
                                                        i6 = i64;
                                                        mVar2 = mVar6;
                                                        iArr3 = iArr11;
                                                        j5 = j19;
                                                    }
                                                    j17 += j5;
                                                    i64 = i6 + 1;
                                                    iArr11 = iArr3;
                                                    z9 = z10;
                                                    jArr14 = jArr16;
                                                    mVar6 = mVar2;
                                                }
                                                long[] jArr17 = jArr14;
                                                mVar = mVar6;
                                                boolean z11 = false;
                                                for (int i68 = 0; i68 < iArr13.length && !z11; i68++) {
                                                    z11 |= (iArr13[i68] & 1) != 0;
                                                }
                                                if (!z11) {
                                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("The edited sample sequence does not contain a sync sample.");
                                                }
                                                vVar2 = new v(jArr13, iArr12, i63, jArr17, iArr13);
                                            } else {
                                                mVar = mVar5;
                                                i5 = i23;
                                                long[] jArr18 = jArr2;
                                                z.a(jArr18, a2.c);
                                                vVar = new v(jArr, iArr2, i4, jArr18, iArr);
                                            }
                                            vVar2 = vVar;
                                        }
                                    }
                                    z2 = false;
                                    if (z2) {
                                    }
                                    jArr3 = a2.i;
                                    if (jArr3 == null) {
                                    }
                                    mVar = mVar5;
                                    i5 = i23;
                                    long[] jArr182 = jArr2;
                                    z.a(jArr182, a2.c);
                                    vVar = new v(jArr, iArr2, i4, jArr182, iArr);
                                    vVar2 = vVar;
                                } else {
                                    nVar6 = null;
                                }
                            } else {
                                i2 = 0;
                            }
                            i3 = -1;
                            if (eVar.c()) {
                            }
                            z2 = false;
                            if (z2) {
                            }
                            jArr3 = a2.i;
                            if (jArr3 == null) {
                            }
                            mVar = mVar5;
                            i5 = i23;
                            long[] jArr1822 = jArr2;
                            z.a(jArr1822, a2.c);
                            vVar = new v(jArr, iArr2, i4, jArr1822, iArr);
                            vVar2 = vVar;
                        }
                        if (vVar2.f1459a != 0) {
                            int i69 = i5;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a13 = this.l.a(i69, a2.b);
                            o oVar = new o(a2, vVar2, a13);
                            int i70 = vVar2.d + 30;
                            com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = a2.f;
                            String str2 = oVar2.f1523a;
                            String str3 = oVar2.e;
                            String str4 = oVar2.f;
                            String str5 = oVar2.c;
                            int i71 = oVar2.b;
                            int i72 = oVar2.j;
                            int i73 = oVar2.k;
                            float f = oVar2.l;
                            int i74 = oVar2.m;
                            i9 = i69;
                            float f2 = oVar2.n;
                            byte[] bArr = oVar2.p;
                            int i75 = oVar2.o;
                            com.fyber.inneractive.sdk.player.exoplayer2.video.c cVar = oVar2.q;
                            int i76 = oVar2.r;
                            int i77 = oVar2.s;
                            int i78 = oVar2.t;
                            int i79 = oVar2.u;
                            int i80 = oVar2.v;
                            int i81 = oVar2.x;
                            String str6 = oVar2.y;
                            int i82 = oVar2.z;
                            long j21 = oVar2.w;
                            com.fyber.inneractive.sdk.player.exoplayer2.o oVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.o(str2, str3, str4, str5, i71, i70, i72, i73, f, i74, f2, bArr, i75, cVar, i76, i77, i78, i79, i80, i81, str6, i82, j21, oVar2.h, oVar2.i, oVar2.d);
                            mVar4 = mVar;
                            if (a2.b == 1) {
                                int i83 = mVar4.f1430a;
                                if (i83 != -1 && (i10 = mVar4.b) != -1) {
                                    oVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.o(str2, str3, str4, str5, i71, i70, i72, i73, f, i74, f2, bArr, i75, cVar, i76, i77, i78, i83, i10, i81, str6, i82, j21, oVar3.h, oVar3.i, oVar3.d);
                                }
                                if (bVar != null) {
                                    oVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.o(oVar3.f1523a, oVar3.e, oVar3.f, oVar3.c, oVar3.b, oVar3.g, oVar3.j, oVar3.k, oVar3.l, oVar3.m, oVar3.n, oVar3.p, oVar3.o, oVar3.q, oVar3.r, oVar3.s, oVar3.t, oVar3.u, oVar3.v, oVar3.x, oVar3.y, oVar3.z, oVar3.w, oVar3.h, oVar3.i, bVar);
                                }
                            }
                            a13.a(oVar3);
                            long max2 = Math.max(j3, a2.e);
                            arrayList2 = arrayList;
                            arrayList2.add(oVar);
                            long j22 = vVar2.b[0];
                            j6 = max2;
                            j7 = j22 < j2 ? j22 : j2;
                            i23 = i9 + 1;
                            arrayList3 = arrayList2;
                            mVar5 = mVar4;
                            aVar2 = aVar;
                            z3 = true;
                        }
                    } else {
                        aVar = aVar2;
                        j3 = j6;
                        arrayList = arrayList3;
                        mVar = mVar5;
                        i5 = i23;
                        j2 = j7;
                    }
                    mVar4 = mVar;
                    j7 = j2;
                    arrayList2 = arrayList;
                    j6 = j3;
                    i9 = i5;
                    i23 = i9 + 1;
                    arrayList3 = arrayList2;
                    mVar5 = mVar4;
                    aVar2 = aVar;
                    z3 = true;
                }
                ArrayList arrayList5 = arrayList3;
                this.n = j6;
                this.m = (o[]) arrayList5.toArray(new o[arrayList5.size()]);
                this.l.b();
                this.l.a(this);
                this.d.clear();
                this.e = 2;
            } else if (!this.d.isEmpty()) {
                ((a) this.d.peek()).R0.add(aVar2);
            }
        }
        if (this.e != 2) {
            this.e = 0;
            this.h = 0;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.l = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        int i;
        this.d.clear();
        this.h = 0;
        this.j = 0;
        this.k = 0;
        if (j == 0) {
            this.e = 0;
            this.h = 0;
            return;
        }
        o[] oVarArr = this.m;
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                v vVar = oVar.b;
                int a2 = z.a(vVar.e, j2, false);
                while (true) {
                    i = -1;
                    if (a2 < 0) {
                        a2 = -1;
                        break;
                    } else if ((vVar.f[a2] & 1) != 0) {
                        break;
                    } else {
                        a2--;
                    }
                }
                if (a2 == -1) {
                    a2 = z.a(vVar.e, j2, true, false);
                    while (a2 < vVar.e.length) {
                        if ((vVar.f[a2] & 1) == 0) {
                            a2++;
                        }
                    }
                    oVar.d = i;
                }
                i = a2;
                oVar.d = i;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) {
        o[] oVarArr;
        boolean z;
        while (true) {
            int i = this.e;
            boolean z2 = false;
            if (i == 0) {
                if (this.h == 0) {
                    if (!bVar.b(this.c.f1591a, 0, 8, true)) {
                        return -1;
                    }
                    this.h = 8;
                    this.c.e(0);
                    this.g = this.c.k();
                    this.f = this.c.b();
                }
                if (this.g == 1) {
                    bVar.b(this.c.f1591a, 8, 8, false);
                    this.h += 8;
                    this.g = this.c.n();
                }
                int i2 = this.f;
                if (i2 != c.C && i2 != c.E && i2 != c.F && i2 != c.G && i2 != c.H && i2 != c.Q) {
                    if (i2 != c.S && i2 != c.D && i2 != c.T && i2 != c.U && i2 != c.m0 && i2 != c.n0 && i2 != c.o0 && i2 != c.R && i2 != c.p0 && i2 != c.q0 && i2 != c.r0 && i2 != c.s0 && i2 != c.t0 && i2 != c.P && i2 != c.b && i2 != c.A0) {
                        this.i = null;
                        this.e = 1;
                    } else if (this.h == 8) {
                        long j = this.g;
                        if (j <= 2147483647L) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n((int) j);
                            this.i = nVar;
                            System.arraycopy(this.c.f1591a, 0, nVar.f1591a, 0, 8);
                            this.e = 1;
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    long j2 = (bVar.c + this.g) - this.h;
                    this.d.add(new a(this.f, j2));
                    if (this.g == this.h) {
                        c(j2);
                    } else {
                        this.e = 0;
                        this.h = 0;
                    }
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException();
                    }
                    long j3 = Long.MAX_VALUE;
                    int i3 = -1;
                    int i4 = 0;
                    while (true) {
                        oVarArr = this.m;
                        if (i4 >= oVarArr.length) {
                            break;
                        }
                        o oVar2 = oVarArr[i4];
                        int i5 = oVar2.d;
                        v vVar = oVar2.b;
                        if (i5 != vVar.f1459a) {
                            long j4 = vVar.b[i5];
                            if (j4 < j3) {
                                i3 = i4;
                                j3 = j4;
                            }
                        }
                        i4++;
                    }
                    if (i3 == -1) {
                        return -1;
                    }
                    o oVar3 = oVarArr[i3];
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = oVar3.c;
                    int i6 = oVar3.d;
                    v vVar2 = oVar3.b;
                    long j5 = vVar2.b[i6];
                    int i7 = vVar2.c[i6];
                    if (oVar3.f1453a.g == 1) {
                        j5 += 8;
                        i7 -= 8;
                    }
                    long j6 = (j5 - bVar.c) + this.j;
                    if (j6 >= 0 && j6 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        bVar.a((int) j6);
                        int i8 = oVar3.f1453a.k;
                        if (i8 == 0) {
                            while (true) {
                                int i9 = this.j;
                                if (i9 >= i7) {
                                    break;
                                }
                                int a2 = rVar.a(bVar, i7 - i9, false);
                                this.j += a2;
                                this.k -= a2;
                            }
                        } else {
                            byte[] bArr = this.b.f1591a;
                            bArr[0] = 0;
                            bArr[1] = 0;
                            bArr[2] = 0;
                            int i10 = 4 - i8;
                            while (this.j < i7) {
                                int i11 = this.k;
                                if (i11 == 0) {
                                    bVar.b(this.b.f1591a, i10, i8, false);
                                    this.b.e(0);
                                    this.k = this.b.m();
                                    this.f1454a.e(0);
                                    rVar.a(4, this.f1454a);
                                    this.j += 4;
                                    i7 += i10;
                                } else {
                                    int a3 = rVar.a(bVar, i11, false);
                                    this.j += a3;
                                    this.k -= a3;
                                }
                            }
                        }
                        v vVar3 = oVar3.b;
                        rVar.a(vVar3.e[i6], vVar3.f[i6], i7, 0, null);
                        oVar3.d++;
                        this.j = 0;
                        this.k = 0;
                        return 0;
                    }
                    oVar.f1461a = j5;
                    return 1;
                }
                long j7 = this.g;
                int i12 = this.h;
                long j8 = j7 - i12;
                long j9 = bVar.c + j8;
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.i;
                if (nVar2 != null) {
                    bVar.b(nVar2.f1591a, i12, (int) j8, false);
                    if (this.f == c.b) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.i;
                        nVar3.e(8);
                        if (nVar3.b() != p) {
                            nVar3.e(nVar3.b + 4);
                            while (nVar3.c - nVar3.b > 0) {
                                if (nVar3.b() == p) {
                                }
                            }
                            z = false;
                            this.o = z;
                        }
                        z = true;
                        this.o = z;
                    } else if (!this.d.isEmpty()) {
                        ((a) this.d.peek()).Q0.add(new b(this.f, this.i));
                    }
                } else if (j8 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    bVar.a((int) j8);
                } else {
                    oVar.f1461a = j9;
                    z2 = true;
                }
                c(j9);
                if (z2 && this.e != 2) {
                    return 1;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048 A[SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(long j) {
        int i;
        long j2;
        long j3 = Long.MAX_VALUE;
        for (o oVar : this.m) {
            v vVar = oVar.b;
            int a2 = z.a(vVar.e, j, false);
            while (true) {
                i = -1;
                if (a2 < 0) {
                    a2 = -1;
                    break;
                }
                if ((vVar.f[a2] & 1) != 0) {
                    break;
                }
                a2--;
            }
            if (a2 == -1) {
                a2 = z.a(vVar.e, j, true, false);
                while (a2 < vVar.e.length) {
                    if ((vVar.f[a2] & 1) == 0) {
                        a2++;
                    }
                }
                j2 = vVar.b[i];
                if (j2 >= j3) {
                    j3 = j2;
                }
            }
            i = a2;
            j2 = vVar.b[i];
            if (j2 >= j3) {
            }
        }
        return j3;
    }
}
