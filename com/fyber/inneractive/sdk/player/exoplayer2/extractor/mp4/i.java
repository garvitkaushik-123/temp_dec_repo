package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.adjust.sdk.Constants;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1447a = z.a("vide");
    public static final int b = z.a("soun");
    public static final int c = z.a("text");
    public static final int d = z.a("sbtl");
    public static final int e = z.a("subt");
    public static final int f = z.a("clcp");
    public static final int g = z.a("cenc");
    public static final int h = z.a(Constants.REFERRER_API_META);

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009b, code lost:
    
        if (r13 == 0) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x07a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x07a6  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static s a(a aVar, b bVar, long j, com.fyber.inneractive.sdk.player.exoplayer2.drm.d dVar, boolean z) {
        long j2;
        int i;
        int i2;
        int b2;
        int i3;
        a b3;
        s sVar;
        Pair create;
        b c2;
        int i4;
        long j3;
        int i5;
        int i6;
        int i7;
        int i8;
        List list;
        int i9;
        int o;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        String str;
        long j4;
        List singletonList;
        a b4 = aVar.b(c.F);
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = b4.c(c.T).P0;
        nVar.e(16);
        int b5 = nVar.b();
        int i16 = b5 == b ? 1 : b5 == f1447a ? 2 : (b5 == c || b5 == d || b5 == e || b5 == f) ? 3 : b5 == h ? 4 : -1;
        if (i16 == -1) {
            return null;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = aVar.c(c.P).P0;
        int i17 = 8;
        nVar2.e(8);
        int b6 = (nVar2.b() >> 24) & 255;
        nVar2.e(nVar2.b + (b6 == 0 ? 8 : 16));
        int b7 = nVar2.b();
        nVar2.e(nVar2.b + 4);
        int i18 = nVar2.b;
        int i19 = b6 == 0 ? 4 : 8;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i21 >= i19) {
                nVar2.e(nVar2.b + i19);
                break;
            }
            if (nVar2.f1591a[i18 + i21] != -1) {
                j2 = b6 == 0 ? nVar2.k() : nVar2.n();
            } else {
                i21++;
            }
        }
        j2 = -9223372036854775807L;
        nVar2.e(nVar2.b + 16);
        int b8 = nVar2.b();
        int b9 = nVar2.b();
        nVar2.e(nVar2.b + 4);
        int b10 = nVar2.b();
        int b11 = nVar2.b();
        int i22 = 3;
        if (b8 == 0 && b9 == 65536 && b10 == -65536 && b11 == 0) {
            i2 = 90;
        } else if (b8 == 0 && b9 == -65536 && b10 == 65536 && b11 == 0) {
            i2 = 270;
        } else {
            if (b8 != -65536 || b9 != 0 || b10 != 0 || b11 != -65536) {
                i = 0;
                long j5 = j != -9223372036854775807L ? j2 : j;
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = bVar.P0;
                nVar3.e(8);
                int b12 = nVar3.b();
                int i23 = c.b;
                nVar3.e(nVar3.b + (((b12 >> 24) & 255) != 0 ? 8 : 16));
                long k = nVar3.k();
                long a2 = j5 != -9223372036854775807L ? z.a(j5, 1000000L, k) : -9223372036854775807L;
                long j6 = k;
                a b13 = b4.b(c.G).b(c.H);
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = b4.c(c.S).P0;
                nVar4.e(8);
                int b14 = (nVar4.b() >> 24) & 255;
                nVar4.e(nVar4.b + (b14 != 0 ? 8 : 16));
                long k2 = nVar4.k();
                nVar4.e(nVar4.b + (b14 != 0 ? 4 : 8));
                int o2 = nVar4.o();
                Pair create2 = Pair.create(Long.valueOf(k2), "" + ((char) (((o2 >> 10) & 31) + 96)) + ((char) (((o2 >> 5) & 31) + 96)) + ((char) ((o2 & 31) + 96)));
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar5 = b13.c(c.U).P0;
                String str2 = (String) create2.second;
                nVar5.e(12);
                b2 = nVar5.b();
                f fVar = new f(b2);
                i3 = 0;
                while (i3 < b2) {
                    int i24 = nVar5.b;
                    int b15 = nVar5.b();
                    int i25 = i17;
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(b15 > 0 ? 1 : i20, "childAtomSize should be positive");
                    int b16 = nVar5.b();
                    if (b16 == c.c || b16 == c.d || b16 == c.a0 || b16 == c.l0 || b16 == c.e || b16 == c.f || b16 == c.g || b16 == c.K0 || b16 == c.L0) {
                        i4 = i20;
                        j3 = j6;
                        i5 = b2;
                        nVar5.e(i24 + 16);
                        nVar5.e(nVar5.b + 16);
                        int o3 = nVar5.o();
                        int o4 = nVar5.o();
                        nVar5.e(nVar5.b + 50);
                        int i26 = nVar5.b;
                        if (b16 == c.a0) {
                            b16 = a(nVar5, i24, b15, fVar, i3);
                            nVar5.e(i26);
                        }
                        int i27 = -1;
                        float f2 = 1.0f;
                        int i28 = i4;
                        String str3 = null;
                        List list2 = null;
                        byte[] bArr = null;
                        while (i26 - i24 < b15) {
                            nVar5.e(i26);
                            int i29 = nVar5.b;
                            int b17 = nVar5.b();
                            if (b17 == 0 && nVar5.b - i24 == b15) {
                                break;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(b17 > 0 ? 1 : i4, "childAtomSize should be positive");
                            int b18 = nVar5.b();
                            int i30 = i26;
                            if (b18 == c.I) {
                                if (str3 != null) {
                                    throw new IllegalStateException();
                                }
                                nVar5.e(i29 + 8);
                                com.fyber.inneractive.sdk.player.exoplayer2.video.a a3 = com.fyber.inneractive.sdk.player.exoplayer2.video.a.a(nVar5);
                                list = a3.f1601a;
                                fVar.c = a3.b;
                                if (i28 == 0) {
                                    f2 = a3.e;
                                }
                                str3 = "video/avc";
                            } else if (b18 != c.J) {
                                if (b18 == c.M0) {
                                    if (str3 != null) {
                                        throw new IllegalStateException();
                                    }
                                    str3 = b16 == c.K0 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                } else if (b18 == c.h) {
                                    if (str3 != null) {
                                        throw new IllegalStateException();
                                    }
                                    str3 = "video/3gpp";
                                } else if (b18 != c.K) {
                                    if (b18 != c.j0) {
                                        if (b18 != c.I0) {
                                            i7 = i28;
                                            if (b18 == c.H0) {
                                                int j7 = nVar5.j();
                                                nVar5.e(nVar5.b + 3);
                                                if (j7 == 0) {
                                                    int j8 = nVar5.j();
                                                    if (j8 == 0) {
                                                        i8 = i22;
                                                        i27 = i4;
                                                    } else if (j8 != 1) {
                                                        i8 = i22;
                                                        if (j8 == 2) {
                                                            i27 = 2;
                                                        } else if (j8 == i8) {
                                                            i27 = i8;
                                                        }
                                                    } else {
                                                        i8 = i22;
                                                        i27 = 1;
                                                    }
                                                }
                                            }
                                            i8 = i22;
                                            break;
                                            break;
                                        }
                                        int i31 = i29 + 8;
                                        while (i31 - i29 < b17) {
                                            nVar5.e(i31);
                                            int b19 = nVar5.b();
                                            i7 = i28;
                                            if (nVar5.b() == c.J0) {
                                                bArr = Arrays.copyOfRange(nVar5.f1591a, i31, i31 + b19);
                                                i8 = i22;
                                                break;
                                            }
                                            i31 += b19;
                                            i28 = i7;
                                        }
                                        i7 = i28;
                                        i8 = i22;
                                        bArr = null;
                                    } else {
                                        nVar5.e(i29 + 8);
                                        f2 = nVar5.m() / nVar5.m();
                                        i8 = i22;
                                        i7 = 1;
                                    }
                                    i26 = i30 + b17;
                                    i22 = i8;
                                    i28 = i7;
                                } else {
                                    if (str3 != null) {
                                        throw new IllegalStateException();
                                    }
                                    Pair a4 = a(i29, nVar5);
                                    str3 = (String) a4.first;
                                    list2 = Collections.singletonList((byte[]) a4.second);
                                }
                                i7 = i28;
                                i8 = i22;
                                break;
                                i26 = i30 + b17;
                                i22 = i8;
                                i28 = i7;
                            } else {
                                if (str3 != null) {
                                    throw new IllegalStateException();
                                }
                                nVar5.e(i29 + 8);
                                com.fyber.inneractive.sdk.player.exoplayer2.video.d a5 = com.fyber.inneractive.sdk.player.exoplayer2.video.d.a(nVar5);
                                list = a5.f1603a;
                                fVar.c = a5.b;
                                str3 = "video/hevc";
                            }
                            list2 = list;
                            i7 = i28;
                            i8 = i22;
                            break;
                            i26 = i30 + b17;
                            i22 = i8;
                            i28 = i7;
                        }
                        i6 = i22;
                        if (str3 != null) {
                            fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(b7), str3, -1, o3, o4, list2, i, f2, bArr, i27, null, dVar);
                        }
                    } else {
                        if (b16 == c.j || b16 == c.b0 || b16 == c.o || b16 == c.q || b16 == c.s || b16 == c.v || b16 == c.t || b16 == c.u || b16 == c.y0 || b16 == c.z0 || b16 == c.m || b16 == c.n || b16 == c.k || b16 == c.O0) {
                            nVar5.e(i24 + 16);
                            if (z) {
                                i9 = nVar5.o();
                                nVar5.e(nVar5.b + 6);
                            } else {
                                nVar5.e(nVar5.b + 8);
                                i9 = 0;
                            }
                            if (i9 == 0 || i9 == 1) {
                                j3 = j6;
                                o = nVar5.o();
                                nVar5.e(nVar5.b + 6);
                                byte[] bArr2 = nVar5.f1591a;
                                int i32 = nVar5.b;
                                int i33 = i32 + 1;
                                nVar5.b = i33;
                                int i34 = (bArr2[i32] & 255) << 8;
                                nVar5.b = i32 + 2;
                                int i35 = i34 | (bArr2[i33] & 255);
                                nVar5.b = i32 + 4;
                                if (i9 == 1) {
                                    nVar5.e(i32 + 20);
                                }
                                i10 = i35;
                            } else if (i9 == 2) {
                                nVar5.e(nVar5.b + 16);
                                j3 = j6;
                                i10 = (int) Math.round(Double.longBitsToDouble(nVar5.g()));
                                o = nVar5.m();
                                nVar5.e(nVar5.b + 20);
                            } else {
                                j3 = j6;
                                i5 = b2;
                                i6 = i22;
                                i4 = 0;
                            }
                            int i36 = nVar5.b;
                            if (b16 == c.b0) {
                                b16 = a(nVar5, i24, b15, fVar, i3);
                                nVar5.e(i36);
                            }
                            int i37 = i10;
                            String str4 = b16 == c.o ? "audio/ac3" : b16 == c.q ? "audio/eac3" : b16 == c.s ? "audio/vnd.dts" : (b16 == c.t || b16 == c.u) ? "audio/vnd.dts.hd" : b16 == c.v ? "audio/vnd.dts.hd;profile=lbr" : b16 == c.y0 ? "audio/3gpp" : b16 == c.z0 ? "audio/amr-wb" : (b16 == c.m || b16 == c.n) ? "audio/raw" : b16 == c.k ? "audio/mpeg" : b16 == c.O0 ? "audio/alac" : null;
                            byte[] bArr3 = null;
                            int i38 = i36;
                            int i39 = o;
                            while (i38 - i24 < b15) {
                                nVar5.e(i38);
                                int b20 = nVar5.b();
                                int i40 = i39;
                                com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(b20 > 0, "childAtomSize should be positive");
                                int b21 = nVar5.b();
                                int i41 = b2;
                                int i42 = c.K;
                                if (b21 != i42) {
                                    String str5 = str4;
                                    if (z && b21 == c.l) {
                                        str4 = str5;
                                    } else {
                                        if (b21 == c.p) {
                                            nVar5.e(i38 + 8);
                                            String num = Integer.toString(b7);
                                            int i43 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b[(nVar5.j() & 192) >> 6];
                                            int j9 = nVar5.j();
                                            int i44 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d[(j9 & 56) >> 3];
                                            if ((j9 & 4) != 0) {
                                                i44++;
                                            }
                                            fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(num, "audio/ac3", -1, -1, i44, i43, null, dVar, str2);
                                        } else if (b21 == c.r) {
                                            nVar5.e(i38 + 8);
                                            String num2 = Integer.toString(b7);
                                            nVar5.e(nVar5.b + 2);
                                            int i45 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b[(nVar5.j() & 192) >> 6];
                                            int j10 = nVar5.j();
                                            int i46 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d[(j10 & 14) >> 1];
                                            if ((j10 & 1) != 0) {
                                                i46++;
                                            }
                                            fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(num2, "audio/eac3", -1, -1, i46, i45, null, dVar, str2);
                                        } else {
                                            if (b21 == c.w) {
                                                i11 = i37;
                                                i12 = i40;
                                                str4 = str5;
                                                fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(b7), str5, -1, -1, i12, i11, null, dVar, str2);
                                            } else {
                                                i11 = i37;
                                                i12 = i40;
                                                str4 = str5;
                                                if (b21 == c.O0) {
                                                    byte[] bArr4 = new byte[b20];
                                                    nVar5.e(i38);
                                                    nVar5.a(bArr4, 0, b20);
                                                    i13 = b20;
                                                    bArr3 = bArr4;
                                                    i39 = i12;
                                                    i38 += i13;
                                                    i37 = i11;
                                                    b2 = i41;
                                                }
                                            }
                                            i13 = b20;
                                            i39 = i12;
                                            i38 += i13;
                                            i37 = i11;
                                            b2 = i41;
                                        }
                                        i11 = i37;
                                        i13 = b20;
                                        i12 = i40;
                                        str4 = str5;
                                        i39 = i12;
                                        i38 += i13;
                                        i37 = i11;
                                        b2 = i41;
                                    }
                                }
                                i11 = i37;
                                i12 = i40;
                                if (b21 == i42) {
                                    i13 = b20;
                                    i15 = i38;
                                } else {
                                    int i47 = nVar5.b;
                                    while (i47 - i38 < b20) {
                                        nVar5.e(i47);
                                        int b22 = nVar5.b();
                                        i13 = b20;
                                        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(b22 > 0, "childAtomSize should be positive");
                                        int i48 = i47;
                                        if (nVar5.b() == c.K) {
                                            i15 = i48;
                                        } else {
                                            i47 = i48 + b22;
                                            b20 = i13;
                                        }
                                    }
                                    i13 = b20;
                                    i14 = -1;
                                    i15 = -1;
                                    if (i15 != i14) {
                                        Pair a6 = a(i15, nVar5);
                                        String str6 = (String) a6.first;
                                        bArr3 = (byte[]) a6.second;
                                        if ("audio/mp4a-latm".equals(str6)) {
                                            Pair a7 = com.fyber.inneractive.sdk.player.exoplayer2.util.d.a(bArr3);
                                            int intValue = ((Integer) a7.first).intValue();
                                            i39 = ((Integer) a7.second).intValue();
                                            i11 = intValue;
                                            str4 = str6;
                                            i38 += i13;
                                            i37 = i11;
                                            b2 = i41;
                                        } else {
                                            str4 = str6;
                                        }
                                    }
                                    i39 = i12;
                                    i38 += i13;
                                    i37 = i11;
                                    b2 = i41;
                                }
                                i14 = -1;
                                if (i15 != i14) {
                                }
                                i39 = i12;
                                i38 += i13;
                                i37 = i11;
                                b2 = i41;
                            }
                            int i49 = i37;
                            int i50 = i39;
                            i5 = b2;
                            i4 = 0;
                            if (fVar.b == null && str4 != null) {
                                String str7 = str2;
                                str2 = str7;
                                fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(b7), str4, -1, -1, i50, i49, "audio/raw".equals(str4) ? 2 : -1, -1, -1, bArr3 == null ? null : Collections.singletonList(bArr3), dVar, 0, str7, null);
                            }
                        } else {
                            int i51 = c.k0;
                            if (b16 == i51 || b16 == c.u0 || b16 == c.v0 || b16 == c.w0 || b16 == c.x0) {
                                nVar5.e(i24 + 16);
                                String str8 = "application/ttml+xml";
                                if (b16 != i51) {
                                    if (b16 == c.u0) {
                                        int i52 = b15 - 16;
                                        byte[] bArr5 = new byte[i52];
                                        nVar5.a(bArr5, i20, i52);
                                        singletonList = Collections.singletonList(bArr5);
                                        str = "application/x-quicktime-tx3g";
                                        j4 = Long.MAX_VALUE;
                                        String str9 = str2;
                                        str2 = str9;
                                        fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(b7), str, 0, str9, -1, dVar, j4, singletonList);
                                    } else if (b16 == c.v0) {
                                        str8 = "application/x-mp4-vtt";
                                    } else if (b16 == c.w0) {
                                        str = "application/ttml+xml";
                                        j4 = 0;
                                        singletonList = null;
                                        String str92 = str2;
                                        str2 = str92;
                                        fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(b7), str, 0, str92, -1, dVar, j4, singletonList);
                                    } else {
                                        if (b16 != c.x0) {
                                            throw new IllegalStateException();
                                        }
                                        fVar.d = 1;
                                        str8 = "application/x-mp4-cea-608";
                                    }
                                }
                                str = str8;
                                j4 = Long.MAX_VALUE;
                                singletonList = null;
                                String str922 = str2;
                                str2 = str922;
                                fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(b7), str, 0, str922, -1, dVar, j4, singletonList);
                            } else if (b16 == c.N0) {
                                fVar.b = com.fyber.inneractive.sdk.player.exoplayer2.o.a(Integer.toString(b7), "application/x-camera-motion", dVar);
                            }
                            i4 = i20;
                            j3 = j6;
                            i5 = b2;
                        }
                        i6 = i22;
                    }
                    nVar5.e(i24 + b15);
                    i3++;
                    i22 = i6;
                    i17 = i25;
                    i20 = i4;
                    b2 = i5;
                    j6 = j3;
                }
                int i53 = i20;
                long j11 = j6;
                int i54 = i17;
                b3 = aVar.b(c.Q);
                if (b3 != null || (c2 = b3.c(c.R)) == null) {
                    sVar = null;
                    create = Pair.create(null, null);
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar6 = c2.P0;
                    nVar6.e(i54);
                    int b23 = (nVar6.b() >> 24) & 255;
                    int m = nVar6.m();
                    long[] jArr = new long[m];
                    long[] jArr2 = new long[m];
                    for (int i55 = i53; i55 < m; i55++) {
                        jArr[i55] = b23 == 1 ? nVar6.n() : nVar6.k();
                        jArr2[i55] = b23 == 1 ? nVar6.g() : nVar6.b();
                        byte[] bArr6 = nVar6.f1591a;
                        int i56 = nVar6.b;
                        int i57 = i56 + 1;
                        nVar6.b = i57;
                        int i58 = (bArr6[i56] & 255) << 8;
                        nVar6.b = i56 + 2;
                        if (((short) ((bArr6[i57] & 255) | i58)) != 1) {
                            throw new IllegalArgumentException("Unsupported media rate.");
                        }
                        nVar6.e(i56 + 4);
                    }
                    create = Pair.create(jArr, jArr2);
                    sVar = null;
                }
                return fVar.b != null ? sVar : new s(b7, i16, ((Long) create2.first).longValue(), j11, a2, fVar.b, fVar.d, fVar.f1444a, fVar.c, (long[]) create.first, (long[]) create.second);
            }
            i2 = 180;
        }
        i = i2;
        if (j != -9223372036854775807L) {
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar32 = bVar.P0;
        nVar32.e(8);
        int b122 = nVar32.b();
        int i232 = c.b;
        nVar32.e(nVar32.b + (((b122 >> 24) & 255) != 0 ? 8 : 16));
        long k3 = nVar32.k();
        if (j5 != -9223372036854775807L) {
        }
        long j62 = k3;
        a b132 = b4.b(c.G).b(c.H);
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar42 = b4.c(c.S).P0;
        nVar42.e(8);
        int b142 = (nVar42.b() >> 24) & 255;
        nVar42.e(nVar42.b + (b142 != 0 ? 8 : 16));
        long k22 = nVar42.k();
        nVar42.e(nVar42.b + (b142 != 0 ? 4 : 8));
        int o22 = nVar42.o();
        Pair create22 = Pair.create(Long.valueOf(k22), "" + ((char) (((o22 >> 10) & 31) + 96)) + ((char) (((o22 >> 5) & 31) + 96)) + ((char) ((o22 & 31) + 96)));
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar52 = b132.c(c.U).P0;
        String str22 = (String) create22.second;
        nVar52.e(12);
        b2 = nVar52.b();
        f fVar2 = new f(b2);
        i3 = 0;
        while (i3 < b2) {
        }
        int i532 = i20;
        long j112 = j62;
        int i542 = i17;
        b3 = aVar.b(c.Q);
        if (b3 != null) {
        }
        sVar = null;
        create = Pair.create(null, null);
        if (fVar2.b != null) {
        }
    }

    public static int a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2, f fVar, int i3) {
        int i4 = nVar.b;
        while (true) {
            if (i4 - i >= i2) {
                return 0;
            }
            nVar.e(i4);
            int b2 = nVar.b();
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(b2 > 0, "childAtomSize should be positive");
            if (nVar.b() == c.W) {
                int i5 = i4 + 8;
                Pair pair = null;
                boolean z = false;
                Integer num = null;
                t tVar = null;
                while (i5 - i4 < b2) {
                    nVar.e(i5);
                    int b3 = nVar.b();
                    int b4 = nVar.b();
                    if (b4 == c.c0) {
                        num = Integer.valueOf(nVar.b());
                    } else if (b4 == c.X) {
                        nVar.e(nVar.b + 4);
                        z = nVar.b() == g;
                    } else if (b4 == c.Y) {
                        int i6 = i5 + 8;
                        while (true) {
                            if (i6 - i5 >= b3) {
                                tVar = null;
                                break;
                            }
                            nVar.e(i6);
                            int b5 = nVar.b();
                            if (nVar.b() == c.Z) {
                                nVar.e(nVar.b + 6);
                                nVar.j();
                                int j = nVar.j();
                                byte[] bArr = new byte[16];
                                nVar.a(bArr, 0, 16);
                                tVar = new t(j, bArr);
                                break;
                            }
                            i6 += b5;
                        }
                    }
                    i5 += b3;
                }
                if (z) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(num != null, "frma atom is mandatory");
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(tVar != null, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, tVar);
                }
                if (pair != null) {
                    fVar.f1444a[i3] = (t) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            i4 += b2;
        }
    }

    public static Pair a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        String str;
        nVar.e(i + 12);
        nVar.e(nVar.b + 1);
        a(nVar);
        nVar.e(nVar.b + 2);
        int j = nVar.j();
        if ((j & 128) != 0) {
            nVar.e(nVar.b + 2);
        }
        if ((j & 64) != 0) {
            nVar.e(nVar.b + nVar.o());
        }
        if ((j & 32) != 0) {
            nVar.e(nVar.b + 2);
        }
        nVar.e(nVar.b + 1);
        a(nVar);
        int j2 = nVar.j();
        if (j2 == 32) {
            str = "video/mp4v-es";
        } else if (j2 == 33) {
            str = "video/avc";
        } else if (j2 != 35) {
            if (j2 != 64) {
                str = null;
                if (j2 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (j2 == 165) {
                    str = "audio/ac3";
                } else if (j2 != 166) {
                    switch (j2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (j2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        nVar.e(nVar.b + 12);
        nVar.e(nVar.b + 1);
        int a2 = a(nVar);
        byte[] bArr = new byte[a2];
        nVar.a(bArr, 0, a2);
        return Pair.create(str, bArr);
    }

    public static int a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int j = nVar.j();
        int i = j & 127;
        while ((j & 128) == 128) {
            j = nVar.j();
            i = (i << 7) | (j & 127);
        }
        return i;
    }
}
