package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.o;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.p;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.q;
import com.fyber.inneractive.sdk.player.exoplayer2.m;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.firebase.FirebaseError;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class e implements i {
    public static final byte[] Z = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] a0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    public static final UUID b0 = new UUID(72057594037932032L, -9223371306706625679L);
    public long A;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.g B;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.g C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public byte S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public j Y;

    /* renamed from: a, reason: collision with root package name */
    public final b f1435a;
    public final g b;
    public final SparseArray c;
    public final boolean d;
    public final n e;
    public final n f;
    public final n g;
    public final n h;
    public final n i;
    public final n j;
    public final n k;
    public final n l;
    public final n m;
    public ByteBuffer n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public d t;
    public boolean u;
    public int v;
    public long w;
    public boolean x;
    public long y;
    public long z;

    public e() {
        b bVar = new b();
        this.p = -1L;
        this.q = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.y = -1L;
        this.z = -1L;
        this.A = -9223372036854775807L;
        this.f1435a = bVar;
        bVar.d = new c(this);
        this.d = true;
        this.b = new g();
        this.c = new SparseArray();
        this.g = new n(4);
        this.h = new n(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new n(4);
        this.e = new n(l.f1589a);
        this.f = new n(4);
        this.j = new n();
        this.k = new n();
        this.l = new n(8);
        this.m = new n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x009c, code lost:
    
        return false;
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        f fVar = new f();
        long j = bVar.b;
        long j2 = 1024;
        if (j != -1 && j <= 1024) {
            j2 = j;
        }
        int i = (int) j2;
        bVar.a(fVar.f1436a.f1591a, 0, 4, false);
        long k = fVar.f1436a.k();
        fVar.b = 4;
        while (true) {
            if (k != 440786851) {
                int i2 = fVar.b + 1;
                fVar.b = i2;
                if (i2 == i) {
                    break;
                }
                bVar.a(fVar.f1436a.f1591a, 0, 1, false);
                k = ((k << 8) & (-256)) | (fVar.f1436a.f1591a[0] & 255);
            } else {
                long a2 = fVar.a(bVar);
                long j3 = fVar.b;
                if (a2 != Long.MIN_VALUE && (j == -1 || j3 + a2 < j)) {
                    while (true) {
                        long j4 = fVar.b;
                        long j5 = j3 + a2;
                        if (j4 < j5) {
                            if (fVar.a(bVar) != Long.MIN_VALUE) {
                                long a3 = fVar.a(bVar);
                                if (a3 < 0 || a3 > 2147483647L) {
                                    break;
                                }
                                if (a3 != 0) {
                                    bVar.a((int) a3, false);
                                    fVar.b = (int) (fVar.b + a3);
                                }
                            } else {
                                break;
                            }
                        } else if (j4 == j5) {
                            return true;
                        }
                    }
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(j jVar) {
        this.Y = jVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.A = -9223372036854775807L;
        this.E = 0;
        b bVar = this.f1435a;
        bVar.e = 0;
        bVar.b.clear();
        g gVar = bVar.c;
        gVar.b = 0;
        gVar.c = 0;
        g gVar2 = this.b;
        gVar2.b = 0;
        gVar2.c = 0;
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        n nVar = this.j;
        nVar.b = 0;
        nVar.c = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x02fa, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x068a, code lost:
    
        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("EBML lacing sample size out of range.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:465:0x0841, code lost:
    
        if (r7 != 7) goto L516;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x05a0  */
    /* JADX WARN: Type inference failed for: r21v7 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.fyber.inneractive.sdk.player.exoplayer2.extractor.b] */
    /* JADX WARN: Type inference failed for: r3v109 */
    /* JADX WARN: Type inference failed for: r3v111, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v117 */
    /* JADX WARN: Type inference failed for: r3v179 */
    /* JADX WARN: Type inference failed for: r3v185 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v73, types: [com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.g] */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, o oVar) {
        boolean z;
        long j;
        int i;
        boolean z2;
        String str;
        boolean z3;
        int i2;
        int i3;
        int i4;
        char c;
        int i5;
        long j2;
        int i6;
        int i7;
        double longBitsToDouble;
        long j3;
        int i8;
        int a2;
        boolean z4;
        boolean z5;
        boolean z6;
        q pVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar;
        int i9;
        com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar2;
        boolean z7 = false;
        this.W = false;
        boolean z8 = true;
        while (z8 && !this.W) {
            b bVar2 = this.f1435a;
            ?? r3 = z7;
            if (bVar2.d == null) {
                throw new IllegalStateException();
            }
            while (true) {
                if (!bVar2.b.isEmpty() && bVar.c >= ((a) bVar2.b.peek()).b) {
                    c cVar = bVar2.d;
                    int i10 = ((a) bVar2.b.pop()).f1431a;
                    e eVar = cVar.f1433a;
                    if (i10 != 160) {
                        if (i10 == 174) {
                            z4 = r3 == true ? 1 : 0;
                            String str2 = eVar.t.f1434a;
                            if ("V_VP8".equals(str2) || "V_VP9".equals(str2) || "V_MPEG2".equals(str2) || "V_MPEG4/ISO/SP".equals(str2) || "V_MPEG4/ISO/ASP".equals(str2) || "V_MPEG4/ISO/AP".equals(str2) || "V_MPEG4/ISO/AVC".equals(str2) || "V_MPEGH/ISO/HEVC".equals(str2) || "V_MS/VFW/FOURCC".equals(str2) || "V_THEORA".equals(str2) || "A_OPUS".equals(str2) || "A_VORBIS".equals(str2) || "A_AAC".equals(str2) || "A_MPEG/L2".equals(str2) || "A_MPEG/L3".equals(str2) || "A_AC3".equals(str2) || "A_EAC3".equals(str2) || "A_TRUEHD".equals(str2) || "A_DTS".equals(str2) || "A_DTS/EXPRESS".equals(str2) || "A_DTS/LOSSLESS".equals(str2) || "A_FLAC".equals(str2) || "A_MS/ACM".equals(str2) || "A_PCM/INT/LIT".equals(str2) || "S_TEXT/UTF8".equals(str2) || "S_VOBSUB".equals(str2) || "S_HDMV/PGS".equals(str2) || "S_DVBSUB".equals(str2)) {
                                d dVar = eVar.t;
                                dVar.a(eVar.Y, dVar.b);
                                SparseArray sparseArray = eVar.c;
                                d dVar2 = eVar.t;
                                sparseArray.put(dVar2.b, dVar2);
                            }
                            eVar.t = null;
                        } else {
                            if (i10 == 19899) {
                                boolean z9 = r3 == true ? 1 : 0;
                                int i11 = eVar.v;
                                if (i11 != -1) {
                                    long j4 = eVar.w;
                                    z4 = z9;
                                    if (j4 != -1) {
                                        if (i11 == 475249515) {
                                            eVar.y = j4;
                                            z4 = z9;
                                        }
                                    }
                                }
                                throw new r("Mandatory element SeekID or SeekPosition not found");
                            }
                            if (i10 == 25152) {
                                ?? r21 = r3 == true ? 1 : 0;
                                d dVar3 = eVar.t;
                                z4 = r21;
                                if (dVar3.e) {
                                    byte[] bArr = dVar3.g;
                                    if (bArr != null) {
                                        com.fyber.inneractive.sdk.player.exoplayer2.drm.c[] cVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.drm.c[1];
                                        cVarArr[r21] = new com.fyber.inneractive.sdk.player.exoplayer2.drm.c(com.fyber.inneractive.sdk.player.exoplayer2.b.b, "video/webm", bArr);
                                        dVar3.i = new com.fyber.inneractive.sdk.player.exoplayer2.drm.d(true, cVarArr);
                                        z4 = r21;
                                    } else {
                                        throw new r("Encrypted Track found but ContentEncKeyID was not found");
                                    }
                                }
                            } else if (i10 == 28032) {
                                boolean z10 = r3 == true ? 1 : 0;
                                d dVar4 = eVar.t;
                                z4 = z10;
                                if (dVar4.e) {
                                    z4 = z10;
                                    if (dVar4.f != null) {
                                        throw new r("Combining encryption and compression is not supported");
                                    }
                                }
                            } else if (i10 == 357149030) {
                                boolean z11 = r3 == true ? 1 : 0;
                                if (eVar.q == -9223372036854775807L) {
                                    eVar.q = 1000000L;
                                }
                                long j5 = eVar.r;
                                z4 = z11;
                                if (j5 != -9223372036854775807L) {
                                    eVar.s = eVar.a(j5);
                                    z4 = z11;
                                }
                            } else if (i10 != 374648427) {
                                if (i10 != 475249515) {
                                    eVar.getClass();
                                    z5 = r3;
                                } else {
                                    z5 = r3;
                                    if (!eVar.u) {
                                        j jVar = eVar.Y;
                                        if (eVar.p != -1 && eVar.s != -9223372036854775807L && (gVar = eVar.B) != null && (i9 = gVar.f1586a) != 0 && (gVar2 = eVar.C) != null && gVar2.f1586a == i9) {
                                            int[] iArr = new int[i9];
                                            long[] jArr = new long[i9];
                                            long[] jArr2 = new long[i9];
                                            long[] jArr3 = new long[i9];
                                            int i12 = r3 == true ? 1 : 0;
                                            int i13 = r3;
                                            while (i12 < i9) {
                                                com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar3 = eVar.B;
                                                if (i12 >= 0) {
                                                    if (i12 < gVar3.f1586a) {
                                                        jArr3[i12] = gVar3.b[i12];
                                                        long j6 = eVar.p;
                                                        int i14 = i13 == true ? 1 : 0;
                                                        com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar4 = eVar.C;
                                                        if (i12 < 0) {
                                                            gVar4.getClass();
                                                        } else if (i12 < gVar4.f1586a) {
                                                            jArr[i12] = gVar4.b[i12] + j6;
                                                            i12++;
                                                            i13 = i14;
                                                        }
                                                        throw new IndexOutOfBoundsException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Invalid index ", i12, ", size is ").append(gVar4.f1586a).toString());
                                                    }
                                                } else {
                                                    gVar3.getClass();
                                                }
                                                throw new IndexOutOfBoundsException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Invalid index ", i12, ", size is ").append(gVar3.f1586a).toString());
                                            }
                                            z6 = i13 == true ? 1 : 0;
                                            int i15 = i13;
                                            while (true) {
                                                int i16 = i9 - 1;
                                                if (i15 < i16) {
                                                    int i17 = i15 + 1;
                                                    iArr[i15] = (int) (jArr[i17] - jArr[i15]);
                                                    jArr2[i15] = jArr3[i17] - jArr3[i15];
                                                    i15 = i17;
                                                } else {
                                                    iArr[i16] = (int) ((eVar.p + eVar.o) - jArr[i16]);
                                                    jArr2[i16] = eVar.s - jArr3[i16];
                                                    eVar.B = null;
                                                    eVar.C = null;
                                                    pVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3);
                                                }
                                            }
                                        } else {
                                            z6 = r3 == true ? 1 : 0;
                                            eVar.B = null;
                                            eVar.C = null;
                                            pVar = new p(eVar.s);
                                        }
                                        jVar.a(pVar);
                                        eVar.u = true;
                                        z4 = z6;
                                    }
                                }
                                z2 = z5;
                            } else {
                                z4 = r3 == true ? 1 : 0;
                                if (eVar.c.size() != 0) {
                                    eVar.Y.b();
                                } else {
                                    throw new r("No valid tracks were found");
                                }
                            }
                        }
                        z5 = z4;
                        z2 = z5;
                    } else {
                        boolean z12 = r3 == true ? 1 : 0;
                        z4 = z12;
                        if (eVar.E == 2) {
                            if (!eVar.X) {
                                eVar.M |= 1;
                            }
                            eVar.a((d) eVar.c.get(eVar.K), eVar.F);
                            boolean z13 = z12;
                            eVar.E = z13 ? 1 : 0;
                            z5 = z13;
                            z2 = z5;
                        }
                        z5 = z4;
                        z2 = z5;
                    }
                } else {
                    int i18 = 8;
                    if (bVar2.e == 0) {
                        long a3 = bVar2.c.a(bVar, true, r3, 4);
                        if (a3 == -2) {
                            bVar.e = r3 == true ? 1 : 0;
                            ?? r32 = r3;
                            while (true) {
                                bVar.a(bVar2.f1432a, r32, 4, r32);
                                byte b = bVar2.f1432a[r32];
                                i8 = 0;
                                while (true) {
                                    long[] jArr4 = g.d;
                                    if (i8 < 8) {
                                        j = 0;
                                        long j7 = jArr4[i8] & b;
                                        i8++;
                                        if (j7 != 0) {
                                        }
                                    } else {
                                        j = 0;
                                        i8 = -1;
                                    }
                                }
                                if (i8 != -1 && i8 <= 4) {
                                    a2 = (int) g.a(bVar2.f1432a, i8, false);
                                    bVar2.d.f1433a.getClass();
                                    if (a2 == 357149030 || a2 == 524531317 || a2 == 475249515 || a2 == 374648427) {
                                    }
                                }
                                bVar.a(1);
                                r32 = 0;
                            }
                            bVar.a(i8);
                            j3 = a2;
                        } else {
                            j = 0;
                            j3 = a3;
                        }
                        z = true;
                        if (j3 == -1) {
                            z8 = false;
                            z2 = false;
                        } else {
                            bVar2.f = (int) j3;
                            bVar2.e = 1;
                        }
                    } else {
                        z = true;
                        j = 0;
                    }
                    if (bVar2.e == z) {
                        bVar2.g = bVar2.c.a(bVar, false, z, 8);
                        bVar2.e = 2;
                    }
                    c cVar2 = bVar2.d;
                    int i19 = bVar2.f;
                    cVar2.f1433a.getClass();
                    switch (i19) {
                        case MRAID_JS_WRITE_FAILED_VALUE:
                        case 136:
                        case 155:
                        case 159:
                        case 176:
                        case 179:
                        case 186:
                        case AD_RESPONSE_EMPTY_VALUE:
                        case 231:
                        case 241:
                        case 251:
                        case 16980:
                        case 17029:
                        case 17143:
                        case 18401:
                        case 18408:
                        case 20529:
                        case 20530:
                        case 21420:
                        case 21432:
                        case 21680:
                        case 21682:
                        case 21690:
                        case 21930:
                        case 21945:
                        case 21946:
                        case 21947:
                        case 21948:
                        case 21949:
                        case 22186:
                        case 22203:
                        case 25188:
                        case 2352003:
                        case 2807729:
                            i = 2;
                            break;
                        case 134:
                        case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
                        case 2274716:
                            i = 3;
                            break;
                        case 160:
                        case 174:
                        case 183:
                        case 187:
                        case 224:
                        case BIDPAYLOAD_PLACEMENT_ID_MISMATCH_ERROR_VALUE:
                        case 18407:
                        case 19899:
                        case 20532:
                        case 20533:
                        case 21936:
                        case 21968:
                        case 25152:
                        case 28032:
                        case 30320:
                        case 290298740:
                        case 357149030:
                        case 374648427:
                        case 408125543:
                        case 440786851:
                        case 475249515:
                        case 524531317:
                            i = 1;
                            break;
                        case 161:
                        case 163:
                        case 16981:
                        case 18402:
                        case 21419:
                        case 25506:
                        case 30322:
                            i = 4;
                            break;
                        case 181:
                        case 17545:
                        case 21969:
                        case 21970:
                        case 21971:
                        case 21972:
                        case 21973:
                        case 21974:
                        case 21975:
                        case 21976:
                        case 21977:
                        case 21978:
                            i = 5;
                            break;
                        default:
                            i = 0;
                            break;
                    }
                    if (i == 0) {
                        bVar.a((int) bVar2.g);
                        bVar2.e = 0;
                        r3 = 0;
                    } else if (i != 1) {
                        char c2 = 6;
                        byte b2 = 255;
                        if (i == 2) {
                            long j8 = bVar2.g;
                            if (j8 <= 8) {
                                c cVar3 = bVar2.d;
                                int i20 = bVar2.f;
                                int i21 = (int) j8;
                                bVar.b(bVar2.f1432a, 0, i21, false);
                                long j9 = j;
                                for (int i22 = 0; i22 < i21; i22++) {
                                    j9 = (j9 << 8) | (bVar2.f1432a[i22] & 255);
                                }
                                e eVar2 = cVar3.f1433a;
                                eVar2.getClass();
                                if (i20 != 20529) {
                                    if (i20 != 20530) {
                                        switch (i20) {
                                            case MRAID_JS_WRITE_FAILED_VALUE:
                                                eVar2.t.c = (int) j9;
                                                break;
                                            case 136:
                                                eVar2.t.L = j9 == 1;
                                                break;
                                            case 155:
                                                eVar2.G = eVar2.a(j9);
                                                break;
                                            case 159:
                                                eVar2.t.G = (int) j9;
                                                break;
                                            case 176:
                                                eVar2.t.j = (int) j9;
                                                break;
                                            case 179:
                                                eVar2.B.a(eVar2.a(j9));
                                                break;
                                            case 186:
                                                eVar2.t.k = (int) j9;
                                                break;
                                            case AD_RESPONSE_EMPTY_VALUE:
                                                eVar2.t.b = (int) j9;
                                                break;
                                            case 231:
                                                eVar2.A = eVar2.a(j9);
                                                break;
                                            case 241:
                                                if (!eVar2.D) {
                                                    eVar2.C.a(j9);
                                                    eVar2.D = true;
                                                    break;
                                                }
                                                break;
                                            case 251:
                                                eVar2.X = true;
                                                break;
                                            case 16980:
                                                if (j9 != 3) {
                                                    throw new r("ContentCompAlgo " + j9 + " not supported");
                                                }
                                                break;
                                            case 17029:
                                                if (j9 < 1 || j9 > 2) {
                                                    throw new r("DocTypeReadVersion " + j9 + " not supported");
                                                }
                                                break;
                                            case 17143:
                                                if (j9 != 1) {
                                                    throw new r("EBMLReadVersion " + j9 + " not supported");
                                                }
                                                break;
                                            case 18401:
                                                if (j9 != 5) {
                                                    throw new r("ContentEncAlgo " + j9 + " not supported");
                                                }
                                                break;
                                            case 18408:
                                                if (j9 != 1) {
                                                    throw new r("AESSettingsCipherMode " + j9 + " not supported");
                                                }
                                                break;
                                            case 21420:
                                                eVar2.w = j9 + eVar2.p;
                                                break;
                                            case 21432:
                                                int i23 = (int) j9;
                                                if (i23 != 0) {
                                                    if (i23 != 1) {
                                                        if (i23 != 3) {
                                                            if (i23 == 15) {
                                                                eVar2.t.p = 3;
                                                                break;
                                                            }
                                                        } else {
                                                            eVar2.t.p = 1;
                                                            break;
                                                        }
                                                    } else {
                                                        eVar2.t.p = 2;
                                                        break;
                                                    }
                                                } else {
                                                    z2 = false;
                                                    eVar2.t.p = 0;
                                                    bVar2.e = z2 ? 1 : 0;
                                                    break;
                                                }
                                                break;
                                            case 21680:
                                                eVar2.t.l = (int) j9;
                                                break;
                                            case 21682:
                                                eVar2.t.n = (int) j9;
                                                break;
                                            case 21690:
                                                eVar2.t.m = (int) j9;
                                                break;
                                            case 21930:
                                                eVar2.t.M = j9 == 1;
                                                break;
                                            case 22186:
                                                eVar2.t.J = j9;
                                                break;
                                            case 22203:
                                                eVar2.t.K = j9;
                                                break;
                                            case 25188:
                                                eVar2.t.H = (int) j9;
                                                break;
                                            case 2352003:
                                                eVar2.t.d = (int) j9;
                                                break;
                                            case 2807729:
                                                eVar2.q = j9;
                                                break;
                                            default:
                                                switch (i20) {
                                                    case 21945:
                                                        int i24 = (int) j9;
                                                        if (i24 != 1) {
                                                            if (i24 == 2) {
                                                                eVar2.t.t = 1;
                                                                break;
                                                            }
                                                        } else {
                                                            eVar2.t.t = 2;
                                                            break;
                                                        }
                                                        break;
                                                    case 21946:
                                                        int i25 = (int) j9;
                                                        if (i25 != 1) {
                                                            if (i25 == 16) {
                                                                eVar2.t.s = 6;
                                                                break;
                                                            } else if (i25 == 18) {
                                                                eVar2.t.s = 7;
                                                                break;
                                                            } else if (i25 != 6) {
                                                            }
                                                        }
                                                        eVar2.t.s = 3;
                                                        break;
                                                    case 21947:
                                                        d dVar5 = eVar2.t;
                                                        dVar5.q = true;
                                                        int i26 = (int) j9;
                                                        if (i26 != 1) {
                                                            if (i26 != 9) {
                                                                if (i26 == 4 || i26 == 5 || i26 == 6 || i26 == 7) {
                                                                    dVar5.r = 2;
                                                                    break;
                                                                }
                                                            } else {
                                                                dVar5.r = 6;
                                                                break;
                                                            }
                                                        } else {
                                                            dVar5.r = 1;
                                                            break;
                                                        }
                                                    case 21948:
                                                        eVar2.t.u = (int) j9;
                                                        break;
                                                    case 21949:
                                                        eVar2.t.v = (int) j9;
                                                        break;
                                                }
                                                break;
                                        }
                                    } else if (j9 != 1) {
                                        throw new r("ContentEncodingScope " + j9 + " not supported");
                                    }
                                } else if (j9 != j) {
                                    throw new r("ContentEncodingOrder " + j9 + " not supported");
                                }
                                z2 = false;
                                bVar2.e = z2 ? 1 : 0;
                            } else {
                                throw new r("Invalid integer size: " + bVar2.g);
                            }
                        } else if (i == 3) {
                            long j10 = bVar2.g;
                            if (j10 <= 2147483647L) {
                                c cVar4 = bVar2.d;
                                int i27 = bVar2.f;
                                int i28 = (int) j10;
                                if (i28 == 0) {
                                    str = "";
                                } else {
                                    byte[] bArr2 = new byte[i28];
                                    bVar.b(bArr2, 0, i28, false);
                                    str = new String(bArr2);
                                }
                                e eVar3 = cVar4.f1433a;
                                eVar3.getClass();
                                if (i27 == 134) {
                                    eVar3.t.f1434a = str;
                                } else if (i27 != 17026) {
                                    if (i27 == 2274716) {
                                        eVar3.t.N = str;
                                    }
                                } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                                    throw new r("DocType " + str + " not supported");
                                }
                                z2 = false;
                                bVar2.e = 0;
                            } else {
                                throw new r("String element size: " + bVar2.g);
                            }
                        } else if (i != 4) {
                            if (i != 5) {
                                throw new r(m.a("Invalid element type ", i));
                            }
                            long j11 = bVar2.g;
                            if (j11 != 4 && j11 != 8) {
                                throw new r("Invalid float size: " + bVar2.g);
                            }
                            c cVar5 = bVar2.d;
                            int i29 = bVar2.f;
                            int i30 = (int) j11;
                            bVar.b(bVar2.f1432a, 0, i30, false);
                            long j12 = j;
                            int i31 = 0;
                            while (i31 < i30) {
                                j12 = (j12 << 8) | (bVar2.f1432a[i31] & b2);
                                i31++;
                                b2 = 255;
                            }
                            if (i30 == 4) {
                                longBitsToDouble = Float.intBitsToFloat((int) j12);
                            } else {
                                longBitsToDouble = Double.longBitsToDouble(j12);
                            }
                            e eVar4 = cVar5.f1433a;
                            if (i29 == 181) {
                                eVar4.t.I = (int) longBitsToDouble;
                            } else if (i29 != 17545) {
                                switch (i29) {
                                    case 21969:
                                        eVar4.t.w = (float) longBitsToDouble;
                                        break;
                                    case 21970:
                                        eVar4.t.x = (float) longBitsToDouble;
                                        break;
                                    case 21971:
                                        eVar4.t.y = (float) longBitsToDouble;
                                        break;
                                    case 21972:
                                        eVar4.t.z = (float) longBitsToDouble;
                                        break;
                                    case 21973:
                                        eVar4.t.A = (float) longBitsToDouble;
                                        break;
                                    case 21974:
                                        eVar4.t.B = (float) longBitsToDouble;
                                        break;
                                    case 21975:
                                        eVar4.t.C = (float) longBitsToDouble;
                                        break;
                                    case 21976:
                                        eVar4.t.D = (float) longBitsToDouble;
                                        break;
                                    case 21977:
                                        eVar4.t.E = (float) longBitsToDouble;
                                        break;
                                    case 21978:
                                        eVar4.t.F = (float) longBitsToDouble;
                                        break;
                                    default:
                                        eVar4.getClass();
                                        break;
                                }
                            } else {
                                eVar4.r = (long) longBitsToDouble;
                            }
                            z2 = false;
                            bVar2.e = 0;
                        } else {
                            c cVar6 = bVar2.d;
                            int i32 = bVar2.f;
                            int i33 = (int) bVar2.g;
                            e eVar5 = cVar6.f1433a;
                            if (i32 == 161 || i32 == 163) {
                                z3 = false;
                                if (eVar5.E == 0) {
                                    eVar5.K = (int) eVar5.b.a(bVar, false, true, 8);
                                    eVar5.L = eVar5.b.c;
                                    eVar5.G = -9223372036854775807L;
                                    eVar5.E = 1;
                                    n nVar = eVar5.g;
                                    nVar.b = 0;
                                    nVar.c = 0;
                                }
                                d dVar6 = (d) eVar5.c.get(eVar5.K);
                                if (dVar6 == null) {
                                    bVar.a(i33 - eVar5.L);
                                    eVar5.E = 0;
                                } else {
                                    if (eVar5.E == 1) {
                                        eVar5.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) bVar, 3);
                                        int i34 = (eVar5.g.f1591a[2] & 6) >> 1;
                                        if (i34 == 0) {
                                            eVar5.I = 1;
                                            int[] iArr2 = eVar5.J;
                                            if (iArr2 == null) {
                                                iArr2 = new int[1];
                                            } else if (iArr2.length < 1) {
                                                iArr2 = new int[Math.max(iArr2.length * 2, 1)];
                                            }
                                            eVar5.J = iArr2;
                                            iArr2[0] = (i33 - eVar5.L) - 3;
                                        } else if (i32 == 163) {
                                            eVar5.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) bVar, 4);
                                            int i35 = (eVar5.g.f1591a[3] & 255) + 1;
                                            eVar5.I = i35;
                                            int[] iArr3 = eVar5.J;
                                            if (iArr3 == null) {
                                                iArr3 = new int[i35];
                                            } else if (iArr3.length < i35) {
                                                i3 = 2;
                                                iArr3 = new int[Math.max(iArr3.length * 2, i35)];
                                                eVar5.J = iArr3;
                                                if (i34 != i3) {
                                                    int i36 = (i33 - eVar5.L) - 4;
                                                    int i37 = eVar5.I;
                                                    Arrays.fill(iArr3, 0, i37, i36 / i37);
                                                } else {
                                                    int i38 = 0;
                                                    int i39 = 1;
                                                    if (i34 == 1) {
                                                        int i40 = 0;
                                                        int i41 = 0;
                                                        int i42 = 4;
                                                        while (true) {
                                                            int i43 = eVar5.I - i39;
                                                            if (i40 < i43) {
                                                                eVar5.J[i40] = i38;
                                                                while (true) {
                                                                    i6 = i42 + 1;
                                                                    eVar5.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) bVar, i6);
                                                                    int i44 = eVar5.g.f1591a[i42] & 255;
                                                                    int[] iArr4 = eVar5.J;
                                                                    i7 = iArr4[i40] + i44;
                                                                    iArr4[i40] = i7;
                                                                    if (i44 != 255) {
                                                                        break;
                                                                    }
                                                                    i42 = i6;
                                                                }
                                                                i41 += i7;
                                                                i40++;
                                                                i42 = i6;
                                                                i38 = 0;
                                                                i39 = 1;
                                                            } else {
                                                                eVar5.J[i43] = ((i33 - eVar5.L) - i42) - i41;
                                                            }
                                                        }
                                                    } else {
                                                        if (i34 != 3) {
                                                            throw new r(m.a("Unexpected lacing value: ", i34));
                                                        }
                                                        int i45 = 0;
                                                        int i46 = 0;
                                                        int i47 = 4;
                                                        while (true) {
                                                            int i48 = eVar5.I - 1;
                                                            if (i45 < i48) {
                                                                eVar5.J[i45] = 0;
                                                                int i49 = i47 + 1;
                                                                eVar5.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) bVar, i49);
                                                                if (eVar5.g.f1591a[i47] == 0) {
                                                                    throw new r("No valid varint length mask found");
                                                                }
                                                                int i50 = 0;
                                                                while (true) {
                                                                    if (i50 < i18) {
                                                                        c = c2;
                                                                        int i51 = 1 << (7 - i50);
                                                                        if ((eVar5.g.f1591a[i47] & i51) != 0) {
                                                                            int i52 = i49 + i50;
                                                                            eVar5.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) bVar, i52);
                                                                            i5 = i18;
                                                                            int i53 = i50;
                                                                            j2 = (~i51) & eVar5.g.f1591a[i47] & 255;
                                                                            while (i49 < i52) {
                                                                                j2 = (j2 << i5) | (eVar5.g.f1591a[i49] & 255);
                                                                                i49++;
                                                                            }
                                                                            if (i45 > 0) {
                                                                                j2 -= (1 << ((i53 * 7) + 6)) - 1;
                                                                            }
                                                                            i47 = i52;
                                                                        } else {
                                                                            i50++;
                                                                            c2 = c;
                                                                        }
                                                                    } else {
                                                                        c = c2;
                                                                        i5 = i18;
                                                                        i47 = i49;
                                                                        j2 = j;
                                                                    }
                                                                }
                                                                if (j2 >= -2147483648L && j2 <= 2147483647L) {
                                                                    int i54 = (int) j2;
                                                                    int[] iArr5 = eVar5.J;
                                                                    if (i45 != 0) {
                                                                        i54 += iArr5[i45 - 1];
                                                                    }
                                                                    iArr5[i45] = i54;
                                                                    i46 += i54;
                                                                    i45++;
                                                                    c2 = c;
                                                                    i18 = i5;
                                                                }
                                                            } else {
                                                                i4 = i18;
                                                                eVar5.J[i48] = ((i33 - eVar5.L) - i47) - i46;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            i3 = 2;
                                            eVar5.J = iArr3;
                                            if (i34 != i3) {
                                            }
                                        } else {
                                            throw new r("Lacing only supported in SimpleBlocks.");
                                        }
                                        i4 = 8;
                                        byte[] bArr3 = eVar5.g.f1591a;
                                        eVar5.F = eVar5.a((bArr3[1] & 255) | (bArr3[0] << 8)) + eVar5.A;
                                        byte b3 = eVar5.g.f1591a[2];
                                        eVar5.M = ((dVar6.c == 2 || (i32 == 163 && (b3 & 128) == 128)) ? 1 : 0) | ((b3 & 8) == i4 ? Integer.MIN_VALUE : 0);
                                        eVar5.E = 2;
                                        eVar5.H = 0;
                                        i2 = 163;
                                    } else {
                                        i2 = 163;
                                    }
                                    if (i32 == i2) {
                                        while (true) {
                                            int i55 = eVar5.H;
                                            if (i55 < eVar5.I) {
                                                eVar5.a(bVar, dVar6, eVar5.J[i55]);
                                                eVar5.a(dVar6, eVar5.F + ((eVar5.H * dVar6.d) / 1000));
                                                eVar5.H++;
                                            } else {
                                                z2 = false;
                                                eVar5.E = 0;
                                            }
                                        }
                                    } else {
                                        z2 = false;
                                        eVar5.a(bVar, dVar6, eVar5.J[0]);
                                    }
                                    bVar2.e = z2 ? 1 : 0;
                                }
                            } else if (i32 == 16981) {
                                z3 = false;
                                byte[] bArr4 = new byte[i33];
                                eVar5.t.f = bArr4;
                                bVar.b(bArr4, 0, i33, false);
                            } else if (i32 == 18402) {
                                z3 = false;
                                byte[] bArr5 = new byte[i33];
                                eVar5.t.g = bArr5;
                                bVar.b(bArr5, 0, i33, false);
                            } else if (i32 == 21419) {
                                z3 = false;
                                Arrays.fill(eVar5.i.f1591a, (byte) 0);
                                bVar.b(eVar5.i.f1591a, 4 - i33, i33, false);
                                eVar5.i.e(0);
                                eVar5.v = (int) eVar5.i.k();
                            } else if (i32 != 25506) {
                                if (i32 != 30322) {
                                    eVar5.getClass();
                                    throw new r(m.a("Unexpected id: ", i32));
                                }
                                byte[] bArr6 = new byte[i33];
                                eVar5.t.o = bArr6;
                                z3 = false;
                                bVar.b(bArr6, 0, i33, false);
                            } else {
                                z3 = false;
                                byte[] bArr7 = new byte[i33];
                                eVar5.t.h = bArr7;
                                bVar.b(bArr7, 0, i33, false);
                            }
                            z2 = z3;
                            bVar2.e = z2 ? 1 : 0;
                        }
                    } else {
                        long j13 = bVar.c;
                        bVar2.b.add(new a(bVar2.f, bVar2.g + j13));
                        c cVar7 = bVar2.d;
                        int i56 = bVar2.f;
                        long j14 = bVar2.g;
                        e eVar6 = cVar7.f1433a;
                        eVar6.getClass();
                        if (i56 == 160) {
                            z2 = false;
                            eVar6.X = false;
                        } else if (i56 == 174) {
                            z2 = false;
                            eVar6.t = new d();
                        } else if (i56 != 187) {
                            if (i56 == 19899) {
                                eVar6.v = -1;
                                eVar6.w = -1L;
                            } else if (i56 == 20533) {
                                eVar6.t.e = true;
                            } else if (i56 == 21968) {
                                eVar6.t.q = true;
                            } else if (i56 == 408125543) {
                                long j15 = eVar6.p;
                                if (j15 != -1 && j15 != j13) {
                                    throw new r("Multiple Segment elements not supported");
                                }
                                eVar6.p = j13;
                                eVar6.o = j14;
                            } else if (i56 != 475249515) {
                                if (i56 == 524531317 && !eVar6.u) {
                                    if (eVar6.d && eVar6.y != -1) {
                                        eVar6.x = true;
                                    } else {
                                        eVar6.Y.a(new p(eVar6.s));
                                        eVar6.u = true;
                                    }
                                }
                            } else {
                                eVar6.B = new com.fyber.inneractive.sdk.player.exoplayer2.util.g();
                                eVar6.C = new com.fyber.inneractive.sdk.player.exoplayer2.util.g();
                            }
                            z2 = false;
                        } else {
                            z2 = false;
                            eVar6.D = false;
                        }
                        bVar2.e = z2 ? 1 : 0;
                    }
                }
            }
            if (z8) {
                long j16 = bVar.c;
                if (this.x) {
                    this.z = j16;
                    oVar.f1461a = this.y;
                    this.x = z2;
                    return 1;
                }
                if (this.u) {
                    long j17 = this.z;
                    if (j17 != -1) {
                        oVar.f1461a = j17;
                        this.z = -1L;
                        return 1;
                    }
                } else {
                    continue;
                }
            }
            z7 = false;
        }
        int i57 = z7 ? 1 : 0;
        if (z8) {
            return i57;
        }
        return -1;
    }

    public final void a(d dVar, long j) {
        byte[] b;
        if ("S_TEXT/UTF8".equals(dVar.f1434a)) {
            byte[] bArr = this.k.f1591a;
            long j2 = this.G;
            if (j2 == -9223372036854775807L) {
                b = a0;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (i * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - (60000000 * i2);
                b = z.b(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) (j4 / 1000000)), Integer.valueOf((int) ((j4 - (1000000 * r5)) / 1000))));
            }
            System.arraycopy(b, 0, bArr, 19, 12);
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = dVar.O;
            n nVar = this.k;
            rVar.a(nVar.c, nVar);
            this.V += this.k.c;
        }
        dVar.O.a(j, this.M, this.V, 0, dVar.g);
        this.W = true;
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = (byte) 0;
        this.Q = false;
        n nVar2 = this.j;
        nVar2.b = 0;
        nVar2.c = 0;
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, int i) {
        n nVar = this.g;
        if (nVar.c >= i) {
            return;
        }
        if (nVar.a() < i) {
            n nVar2 = this.g;
            byte[] bArr = nVar2.f1591a;
            byte[] copyOf = Arrays.copyOf(bArr, Math.max(bArr.length * 2, i));
            int i2 = this.g.c;
            nVar2.f1591a = copyOf;
            nVar2.c = i2;
            nVar2.b = 0;
        }
        n nVar3 = this.g;
        byte[] bArr2 = nVar3.f1591a;
        int i3 = nVar3.c;
        bVar.b(bArr2, i3, i - i3, false);
        this.g.d(i);
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, d dVar, int i) {
        int a2;
        int a3;
        int i2;
        if ("S_TEXT/UTF8".equals(dVar.f1434a)) {
            byte[] bArr = Z;
            int i3 = i + 32;
            if (this.k.a() < i3) {
                this.k.f1591a = Arrays.copyOf(bArr, i3 + i);
            }
            bVar.b(this.k.f1591a, 32, i, false);
            this.k.e(0);
            this.k.d(i3);
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = dVar.O;
        if (!this.O) {
            if (dVar.e) {
                this.M &= -1073741825;
                if (!this.P) {
                    bVar.b(this.g.f1591a, 0, 1, false);
                    this.N++;
                    byte b = this.g.f1591a[0];
                    if ((b & 128) != 128) {
                        this.S = b;
                        this.P = true;
                    } else {
                        throw new r("Extension bit is set in signal byte");
                    }
                }
                byte b2 = this.S;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.M |= 1073741824;
                    if (!this.Q) {
                        bVar.b(this.l.f1591a, 0, 8, false);
                        this.N += 8;
                        this.Q = true;
                        n nVar = this.g;
                        nVar.f1591a[0] = (byte) ((z ? 128 : 0) | 8);
                        nVar.e(0);
                        rVar.a(1, this.g);
                        this.V++;
                        this.l.e(0);
                        rVar.a(8, this.l);
                        this.V += 8;
                    }
                    if (z) {
                        if (!this.R) {
                            bVar.b(this.g.f1591a, 0, 1, false);
                            this.N++;
                            this.g.e(0);
                            this.T = this.g.j();
                            this.R = true;
                        }
                        int i4 = this.T * 4;
                        this.g.c(i4);
                        bVar.b(this.g.f1591a, 0, i4, false);
                        this.N += i4;
                        short s = (short) ((this.T / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.n;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.n = ByteBuffer.allocate(i5);
                        }
                        this.n.position(0);
                        this.n.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i2 = this.T;
                            if (i6 >= i2) {
                                break;
                            }
                            int m = this.g.m();
                            if (i6 % 2 == 0) {
                                this.n.putShort((short) (m - i7));
                            } else {
                                this.n.putInt(m - i7);
                            }
                            i6++;
                            i7 = m;
                        }
                        int i8 = (i - this.N) - i7;
                        if (i2 % 2 == 1) {
                            this.n.putInt(i8);
                        } else {
                            this.n.putShort((short) i8);
                            this.n.putInt(0);
                        }
                        n nVar2 = this.m;
                        nVar2.f1591a = this.n.array();
                        nVar2.c = i5;
                        nVar2.b = 0;
                        rVar.a(i5, this.m);
                        this.V += i5;
                    }
                }
            } else {
                byte[] bArr2 = dVar.f;
                if (bArr2 != null) {
                    n nVar3 = this.j;
                    int length = bArr2.length;
                    nVar3.f1591a = bArr2;
                    nVar3.c = length;
                    nVar3.b = 0;
                }
            }
            this.O = true;
        }
        int i9 = i + this.j.c;
        if (!"V_MPEG4/ISO/AVC".equals(dVar.f1434a) && !"V_MPEGH/ISO/HEVC".equals(dVar.f1434a)) {
            while (true) {
                int i10 = this.N;
                if (i10 >= i9) {
                    break;
                }
                int i11 = i9 - i10;
                n nVar4 = this.j;
                int i12 = nVar4.c - nVar4.b;
                if (i12 > 0) {
                    a3 = Math.min(i11, i12);
                    rVar.a(a3, this.j);
                } else {
                    a3 = rVar.a(bVar, i11, false);
                }
                this.N += a3;
                this.V += a3;
            }
        } else {
            byte[] bArr3 = this.f.f1591a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i13 = dVar.P;
            int i14 = 4 - i13;
            while (this.N < i9) {
                int i15 = this.U;
                if (i15 == 0) {
                    n nVar5 = this.j;
                    int min = Math.min(i13, nVar5.c - nVar5.b);
                    bVar.b(bArr3, i14 + min, i13 - min, false);
                    if (min > 0) {
                        this.j.a(bArr3, i14, min);
                    }
                    this.N += i13;
                    this.f.e(0);
                    this.U = this.f.m();
                    this.e.e(0);
                    rVar.a(4, this.e);
                    this.V += 4;
                } else {
                    n nVar6 = this.j;
                    int i16 = nVar6.c - nVar6.b;
                    if (i16 > 0) {
                        a2 = Math.min(i15, i16);
                        rVar.a(a2, this.j);
                    } else {
                        a2 = rVar.a(bVar, i15, false);
                    }
                    this.N += a2;
                    this.V += a2;
                    this.U = i15 - a2;
                }
            }
        }
        if ("A_VORBIS".equals(dVar.f1434a)) {
            this.h.e(0);
            rVar.a(4, this.h);
            this.V += 4;
        }
    }

    public final long a(long j) {
        long j2 = this.q;
        if (j2 != -9223372036854775807L) {
            return z.a(j, j2, 1000L);
        }
        throw new r("Can't scale timecode prior to timecodeScale being set.");
    }
}
