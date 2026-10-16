package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class o extends l {
    public n n;
    public int o;
    public boolean p;
    public r q;
    public p r;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int i;
        byte b = nVar.f1591a[0];
        if ((b & 1) == 1) {
            return -1L;
        }
        n nVar2 = this.n;
        if (!nVar2.c[(b >> 1) & (255 >>> (8 - nVar2.d))].f1472a) {
            i = nVar2.f1471a.d;
        } else {
            i = nVar2.f1471a.e;
        }
        long j = this.p ? (this.o + i) / 4 : 0;
        nVar.d(nVar.c + 4);
        byte[] bArr = nVar.f1591a;
        int i2 = nVar.c;
        bArr[i2 - 4] = (byte) (j & 255);
        bArr[i2 - 3] = (byte) ((j >>> 8) & 255);
        bArr[i2 - 2] = (byte) ((j >>> 16) & 255);
        bArr[i2 - 1] = (byte) ((j >>> 24) & 255);
        this.p = true;
        this.o = i;
        return j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, long j, j jVar) {
        int i;
        int i2;
        long j2;
        int i3;
        if (this.n != null) {
            return false;
        }
        n nVar2 = null;
        int i4 = 1;
        if (this.q == null) {
            this.q = s.a(nVar);
        } else if (this.r == null) {
            s.a(3, nVar, false);
            nVar.b((int) nVar.e());
            long e = nVar.e();
            String[] strArr = new String[(int) e];
            for (int i5 = 0; i5 < e; i5++) {
                strArr[i5] = nVar.b((int) nVar.e());
            }
            if ((nVar.j() & 1) != 0) {
                this.r = new p();
            } else {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("framing bit expected to be set");
            }
        } else {
            int i6 = nVar.c;
            byte[] bArr = new byte[i6];
            System.arraycopy(nVar.f1591a, 0, bArr, 0, i6);
            int i7 = this.q.f1473a;
            int i8 = 5;
            s.a(5, nVar, false);
            int j3 = nVar.j() + 1;
            m mVar = new m(nVar.f1591a);
            int i9 = 8;
            mVar.b(nVar.b * 8);
            int i10 = 0;
            while (true) {
                int i11 = 4;
                int i12 = 16;
                if (i10 < j3) {
                    if (mVar.a(24) == 5653314) {
                        int a2 = mVar.a(16);
                        int a3 = mVar.a(24);
                        long[] jArr = new long[a3];
                        long j4 = 0;
                        if (!mVar.a()) {
                            boolean a4 = mVar.a();
                            i2 = i9;
                            int i13 = 0;
                            while (i13 < a3) {
                                if (a4) {
                                    if (mVar.a()) {
                                        i3 = i4;
                                        jArr[i13] = mVar.a(i8) + 1;
                                    } else {
                                        i3 = i4;
                                        jArr[i13] = 0;
                                    }
                                } else {
                                    i3 = i4;
                                    jArr[i13] = mVar.a(i8) + 1;
                                }
                                i13++;
                                i4 = i3;
                            }
                            i = i4;
                        } else {
                            i = i4;
                            i2 = i9;
                            int a5 = mVar.a(i8) + 1;
                            int i14 = 0;
                            while (i14 < a3) {
                                int i15 = 0;
                                for (int i16 = a3 - i14; i16 > 0; i16 >>>= 1) {
                                    i15++;
                                }
                                int a6 = mVar.a(i15);
                                int i17 = 0;
                                while (i17 < a6 && i14 < a3) {
                                    jArr[i14] = a5;
                                    i14++;
                                    i17++;
                                    j3 = j3;
                                }
                                a5++;
                                j3 = j3;
                            }
                        }
                        int i18 = j3;
                        int a7 = mVar.a(4);
                        if (a7 > 2) {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.m.a("lookup type greater than 2 not decodable: ", a7));
                        }
                        int i19 = i;
                        if (a7 == i19 || a7 == 2) {
                            mVar.b(32);
                            mVar.b(32);
                            int a8 = mVar.a(4) + i19;
                            mVar.b(i19);
                            if (a7 == i19) {
                                if (a2 != 0) {
                                    j2 = (long) Math.floor(Math.pow(a3, 1.0d / a2));
                                }
                                mVar.b((int) (a8 * j4));
                            } else {
                                j2 = a3 * a2;
                            }
                            j4 = j2;
                            mVar.b((int) (a8 * j4));
                        }
                        i10++;
                        i9 = i2;
                        j3 = i18;
                        i4 = 1;
                        i8 = 5;
                    } else {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("expected code book to start with [0x56, 0x43, 0x42] at " + ((mVar.c * 8) + mVar.d));
                    }
                } else {
                    int i20 = i9;
                    int i21 = 6;
                    int a9 = mVar.a(6) + 1;
                    for (int i22 = 0; i22 < a9; i22++) {
                        if (mVar.a(16) != 0) {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("placeholder of time domain transforms not zeroed out");
                        }
                    }
                    int i23 = 1;
                    int a10 = mVar.a(6) + 1;
                    int i24 = 0;
                    while (i24 < a10) {
                        int a11 = mVar.a(i12);
                        if (a11 == 0) {
                            int i25 = i20;
                            mVar.b(i25);
                            mVar.b(16);
                            mVar.b(16);
                            mVar.b(6);
                            mVar.b(i25);
                            int a12 = mVar.a(4) + 1;
                            int i26 = 0;
                            while (i26 < a12) {
                                mVar.b(i25);
                                i26++;
                                i25 = 8;
                            }
                        } else if (a11 == i23) {
                            int a13 = mVar.a(5);
                            int[] iArr = new int[a13];
                            int i27 = -1;
                            for (int i28 = 0; i28 < a13; i28++) {
                                int a14 = mVar.a(i11);
                                iArr[i28] = a14;
                                if (a14 > i27) {
                                    i27 = a14;
                                }
                            }
                            int i29 = i27 + 1;
                            int[] iArr2 = new int[i29];
                            int i30 = 0;
                            while (i30 < i29) {
                                iArr2[i30] = mVar.a(3) + 1;
                                int a15 = mVar.a(2);
                                int i31 = i20;
                                if (a15 > 0) {
                                    mVar.b(i31);
                                }
                                int i32 = 0;
                                for (int i33 = 1; i32 < (i33 << a15); i33 = 1) {
                                    mVar.b(i31);
                                    i32++;
                                    i31 = 8;
                                }
                                i30++;
                                i20 = 8;
                            }
                            mVar.b(2);
                            int a16 = mVar.a(4);
                            int i34 = 0;
                            int i35 = 0;
                            for (int i36 = 0; i36 < a13; i36++) {
                                i34 += iArr2[iArr[i36]];
                                while (i35 < i34) {
                                    mVar.b(a16);
                                    i35++;
                                }
                            }
                        } else {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r(com.fyber.inneractive.sdk.player.exoplayer2.m.a("floor type greater than 1 not decodable: ", a11));
                        }
                        i24++;
                        i20 = 8;
                        i21 = 6;
                        i23 = 1;
                        i11 = 4;
                        i12 = 16;
                    }
                    int i37 = i21;
                    int a17 = mVar.a(i37) + 1;
                    int i38 = 0;
                    while (i38 < a17) {
                        if (mVar.a(16) <= 2) {
                            mVar.b(24);
                            mVar.b(24);
                            mVar.b(24);
                            int a18 = mVar.a(i37) + 1;
                            int i39 = 8;
                            mVar.b(8);
                            int[] iArr3 = new int[a18];
                            for (int i40 = 0; i40 < a18; i40++) {
                                iArr3[i40] = ((mVar.a() ? mVar.a(5) : 0) * 8) + mVar.a(3);
                            }
                            int i41 = 0;
                            while (i41 < a18) {
                                int i42 = 0;
                                while (i42 < i39) {
                                    if ((iArr3[i41] & (1 << i42)) != 0) {
                                        mVar.b(i39);
                                    }
                                    i42++;
                                    i39 = 8;
                                }
                                i41++;
                                i39 = 8;
                            }
                            i38++;
                            i37 = 6;
                        } else {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("residueType greater than 2 is not decodable");
                        }
                    }
                    int a19 = mVar.a(i37) + 1;
                    for (int i43 = 0; i43 < a19; i43++) {
                        int a20 = mVar.a(16);
                        if (a20 != 0) {
                            Log.e("VorbisUtil", "mapping type other than 0 not supported: " + a20);
                        } else {
                            int a21 = mVar.a() ? mVar.a(4) + 1 : 1;
                            if (mVar.a()) {
                                int a22 = mVar.a(8) + 1;
                                for (int i44 = 0; i44 < a22; i44++) {
                                    int i45 = i7 - 1;
                                    int i46 = 0;
                                    for (int i47 = i45; i47 > 0; i47 >>>= 1) {
                                        i46++;
                                    }
                                    mVar.b(i46);
                                    int i48 = 0;
                                    while (i45 > 0) {
                                        i48++;
                                        i45 >>>= 1;
                                    }
                                    mVar.b(i48);
                                }
                            }
                            if (mVar.a(2) != 0) {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("to reserved bits must be zero after mapping coupling steps");
                            }
                            if (a21 > 1) {
                                for (int i49 = 0; i49 < i7; i49++) {
                                    mVar.b(4);
                                }
                            }
                            for (int i50 = 0; i50 < a21; i50++) {
                                mVar.b(8);
                                mVar.b(8);
                                mVar.b(8);
                            }
                        }
                    }
                    int a23 = mVar.a(6);
                    int i51 = a23 + 1;
                    q[] qVarArr = new q[i51];
                    for (int i52 = 0; i52 < i51; i52++) {
                        boolean a24 = mVar.a();
                        mVar.a(16);
                        mVar.a(16);
                        mVar.a(8);
                        qVarArr[i52] = new q(a24);
                    }
                    if (mVar.a()) {
                        int i53 = 0;
                        while (a23 > 0) {
                            i53++;
                            a23 >>>= 1;
                        }
                        nVar2 = new n(this.q, bArr, qVarArr, i53);
                    } else {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("framing bit after modes not set as expected");
                    }
                }
            }
        }
        this.n = nVar2;
        if (nVar2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n.f1471a.f);
        arrayList.add(this.n.b);
        r rVar = this.n.f1471a;
        jVar.f1468a = com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, "audio/vorbis", rVar.c, -1, rVar.f1473a, (int) rVar.b, arrayList, null, null);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final void a(long j) {
        this.g = j;
        this.p = j != 0;
        r rVar = this.q;
        this.o = rVar != null ? rVar.d : 0;
    }
}
