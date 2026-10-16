package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Log;
import java.util.Arrays;

/* loaded from: classes4.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1589a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object c = new Object();
    public static int[] d = new int[10];

    public static int a(int i, byte[] bArr) {
        int i2;
        synchronized (c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    try {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = d;
                    if (iArr.length <= i4) {
                        d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i9 + 2;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static k a(byte[] bArr, int i, int i2) {
        int d2;
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        boolean c2;
        float f;
        int b2;
        o oVar = new o(bArr, i, i2);
        oVar.d(8);
        int b3 = oVar.b(8);
        oVar.d(16);
        int d3 = oVar.d();
        if (b3 == 100 || b3 == 110 || b3 == 122 || b3 == 244 || b3 == 44 || b3 == 83 || b3 == 86 || b3 == 118 || b3 == 128 || b3 == 138) {
            d2 = oVar.d();
            boolean c3 = d2 == 3 ? oVar.c() : false;
            oVar.d();
            oVar.d();
            oVar.f();
            if (oVar.c()) {
                int i4 = d2 != 3 ? 8 : 12;
                int i5 = 0;
                while (i5 < i4) {
                    if (oVar.c()) {
                        int i6 = i5 < 6 ? 16 : 64;
                        int i7 = 8;
                        int i8 = 8;
                        for (int i9 = 0; i9 < i6; i9++) {
                            if (i7 != 0) {
                                i7 = ((oVar.e() + i8) + 256) % 256;
                            }
                            if (i7 != 0) {
                                i8 = i7;
                            }
                        }
                    }
                    i5++;
                }
            }
            z = c3;
        } else {
            d2 = 1;
            z = false;
        }
        int d4 = oVar.d() + 4;
        int d5 = oVar.d();
        if (d5 == 0) {
            i3 = oVar.d() + 4;
            z2 = z;
        } else {
            if (d5 == 1) {
                boolean c4 = oVar.c();
                oVar.e();
                oVar.e();
                long d6 = oVar.d();
                z2 = z;
                for (int i10 = 0; i10 < d6; i10++) {
                    oVar.d();
                }
                z3 = c4;
                i3 = 0;
                oVar.d();
                oVar.f();
                int d7 = oVar.d() + 1;
                int d8 = oVar.d() + 1;
                c2 = oVar.c();
                int i11 = 2 - (c2 ? 1 : 0);
                int i12 = d8 * i11;
                if (!c2) {
                    oVar.f();
                }
                oVar.f();
                int i13 = d7 * 16;
                int i14 = i12 * 16;
                if (oVar.c()) {
                    int d9 = oVar.d();
                    int d10 = oVar.d();
                    int d11 = oVar.d();
                    int d12 = oVar.d();
                    if (d2 != 0) {
                        int i15 = d2 == 3 ? 1 : 2;
                        i11 *= d2 == 1 ? 2 : 1;
                        r7 = i15;
                    }
                    i13 -= (d9 + d10) * r7;
                    i14 -= (d11 + d12) * i11;
                }
                int i16 = i13;
                int i17 = i14;
                if (oVar.c() && oVar.c()) {
                    b2 = oVar.b(8);
                    if (b2 != 255) {
                        int b4 = oVar.b(16);
                        int b5 = oVar.b(16);
                        if (b4 != 0 && b5 != 0) {
                            f = b4 / b5;
                        }
                    } else {
                        float[] fArr = b;
                        if (b2 < 17) {
                            f = fArr[b2];
                        } else {
                            Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + b2);
                        }
                    }
                    return new k(d3, i16, i17, f, z2, c2, d4, d5, i3, z3);
                }
                f = 1.0f;
                return new k(d3, i16, i17, f, z2, c2, d4, d5, i3, z3);
            }
            z2 = z;
            i3 = 0;
        }
        z3 = false;
        oVar.d();
        oVar.f();
        int d72 = oVar.d() + 1;
        int d82 = oVar.d() + 1;
        c2 = oVar.c();
        int i112 = 2 - (c2 ? 1 : 0);
        int i122 = d82 * i112;
        if (!c2) {
        }
        oVar.f();
        int i132 = d72 * 16;
        int i142 = i122 * 16;
        if (oVar.c()) {
        }
        int i162 = i132;
        int i172 = i142;
        if (oVar.c()) {
            b2 = oVar.b(8);
            if (b2 != 255) {
            }
            return new k(d3, i162, i172, f, z2, c2, d4, d5, i3, z3);
        }
        f = 1.0f;
        return new k(d3, i162, i172, f, z2, c2, d4, d5, i3, z3);
    }

    public static int a(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalStateException();
        }
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            a(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            a(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            a(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b2 = bArr[i5];
            if ((b2 & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b2 == 1) {
                    a(zArr);
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
