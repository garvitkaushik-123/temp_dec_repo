package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final int f1395a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final short[] f;
    public int g;
    public short[] h;
    public int i;
    public short[] j;
    public int k;
    public short[] l;
    public int q;
    public int r;
    public int s;
    public int t;
    public int v;
    public int w;
    public int x;
    public int m = 0;
    public int n = 0;
    public int u = 0;
    public float o = 1.0f;
    public float p = 1.0f;

    public w(int i, int i2) {
        this.f1395a = i;
        this.b = i2;
        this.c = i / 400;
        int i3 = i / 65;
        this.d = i3;
        int i4 = i3 * 2;
        this.e = i4;
        this.f = new short[i4];
        this.g = i4;
        int i5 = i2 * i4;
        this.h = new short[i5];
        this.i = i4;
        this.j = new short[i5];
        this.k = i4;
        this.l = new short[i5];
    }

    public final void a(int i) {
        int i2 = this.q + i;
        int i3 = this.g;
        if (i2 > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.g = i4;
            this.h = Arrays.copyOf(this.h, i4 * this.b);
        }
    }

    public final void b(int i) {
        int i2 = this.r + i;
        int i3 = this.i;
        if (i2 > i3) {
            int i4 = (i3 / 2) + i + i3;
            this.i = i4;
            this.j = Arrays.copyOf(this.j, i4 * this.b);
        }
    }

    public final void a(short[] sArr, int i, int i2) {
        int i3 = this.e / i2;
        int i4 = this.b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.f[i7] = (short) (i8 / i5);
        }
    }

    public final int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.b;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i7 < i6 * i2) {
                i7 = i2;
                i6 = i9;
            }
            if (i9 * i5 > i8 * i2) {
                i5 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.w = i6 / i7;
        this.x = i8 / i5;
        return i7;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0253 A[LOOP:4: B:56:0x0048->B:62:0x0253, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0175 A[EDGE_INSN: B:63:0x0175->B:64:0x0175 BREAK  A[LOOP:4: B:56:0x0048->B:62:0x0253], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        int i;
        int i2;
        float f;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9 = this.r;
        float f3 = this.o / this.p;
        double d = f3;
        float f4 = 1.0f;
        int i10 = 1;
        if (d <= 1.00001d && d >= 0.99999d) {
            short[] sArr = this.h;
            int i11 = this.q;
            b(i11);
            int i12 = this.b;
            System.arraycopy(sArr, 0, this.j, this.r * i12, i12 * i11);
            this.r += i11;
            this.q = 0;
        } else {
            int i13 = this.q;
            if (i13 >= this.e) {
                int i14 = 0;
                while (true) {
                    int i15 = this.t;
                    if (i15 > 0) {
                        i4 = Math.min(this.e, i15);
                        short[] sArr2 = this.h;
                        b(i4);
                        int i16 = this.b;
                        System.arraycopy(sArr2, i14 * i16, this.j, this.r * i16, i16 * i4);
                        this.r += i4;
                        this.t -= i4;
                        f = f4;
                        i3 = i10;
                    } else {
                        short[] sArr3 = this.h;
                        int i17 = this.f1395a;
                        int i18 = i17 > 4000 ? i17 / 4000 : i10;
                        if (this.b == i10 && i18 == i10) {
                            i = a(sArr3, i14, this.c, this.d);
                        } else {
                            a(sArr3, i14, i18);
                            int a2 = a(this.f, 0, this.c / i18, this.d / i18);
                            if (i18 != i10) {
                                int i19 = a2 * i18;
                                int i20 = i18 * 4;
                                int i21 = i19 - i20;
                                int i22 = i19 + i20;
                                int i23 = this.c;
                                if (i21 < i23) {
                                    i21 = i23;
                                }
                                int i24 = this.d;
                                if (i22 > i24) {
                                    i22 = i24;
                                }
                                if (this.b == i10) {
                                    i = a(sArr3, i14, i21, i22);
                                } else {
                                    a(sArr3, i14, i10);
                                    i = a(this.f, 0, i21, i22);
                                }
                            } else {
                                i = a2;
                            }
                        }
                        int i25 = this.w;
                        int i26 = (i25 == 0 || (i6 = this.u) == 0 || this.x > i25 * 3 || i25 * 2 <= this.v * 3) ? i : i6;
                        this.v = i25;
                        this.u = i;
                        if (d > 1.0d) {
                            short[] sArr4 = this.h;
                            if (f3 >= 2.0f) {
                                i5 = (int) (i26 / (f3 - f4));
                            } else {
                                this.t = (int) (((2.0f - f3) * i26) / (f3 - f4));
                                i5 = i26;
                            }
                            b(i5);
                            int i27 = i26;
                            a(i5, this.b, this.j, this.r, sArr4, i14, sArr4, i14 + i27);
                            this.r += i5;
                            f = f4;
                            i3 = i10;
                            i14 = i27 + i5 + i14;
                            if (this.e + i14 <= i13) {
                                break;
                            }
                            f4 = f;
                            i10 = i3;
                        } else {
                            int i28 = i26;
                            short[] sArr5 = this.h;
                            if (f3 < 0.5f) {
                                i2 = (int) ((i28 * f3) / (f4 - f3));
                            } else {
                                this.t = (int) ((((2.0f * f3) - f4) * i28) / (f4 - f3));
                                i2 = i28;
                            }
                            int i29 = i28 + i2;
                            b(i29);
                            int i30 = this.b;
                            f = f4;
                            i3 = i10;
                            System.arraycopy(sArr5, i14 * i30, this.j, this.r * i30, i30 * i28);
                            int i31 = i14;
                            a(i2, this.b, this.j, this.r + i28, sArr5, i14 + i28, sArr5, i31);
                            i14 = i31;
                            this.r += i29;
                            i4 = i2;
                        }
                    }
                    i14 += i4;
                    if (this.e + i14 <= i13) {
                    }
                }
                int i32 = this.q - i14;
                short[] sArr6 = this.h;
                int i33 = this.b;
                System.arraycopy(sArr6, i14 * i33, sArr6, 0, i33 * i32);
                this.q = i32;
                f2 = this.p;
                if (f2 != f || this.r == i9) {
                }
                int i34 = this.f1395a;
                int i35 = (int) (i34 / f2);
                while (true) {
                    if (i35 <= 16384 && i34 <= 16384) {
                        break;
                    }
                    i35 /= 2;
                    i34 /= 2;
                }
                int i36 = this.r - i9;
                int i37 = this.s + i36;
                int i38 = this.k;
                if (i37 > i38) {
                    int i39 = (i38 / 2) + i36 + i38;
                    this.k = i39;
                    this.l = Arrays.copyOf(this.l, i39 * this.b);
                }
                short[] sArr7 = this.j;
                int i40 = this.b;
                System.arraycopy(sArr7, i9 * i40, this.l, this.s * i40, i40 * i36);
                this.r = i9;
                this.s += i36;
                int i41 = 0;
                while (true) {
                    int i42 = this.s;
                    int i43 = i42 - 1;
                    if (i41 >= i43) {
                        if (i43 == 0) {
                            return;
                        }
                        short[] sArr8 = this.l;
                        int i44 = this.b;
                        System.arraycopy(sArr8, i43 * i44, sArr8, 0, (i42 - i43) * i44);
                        this.s -= i43;
                        return;
                    }
                    while (true) {
                        i7 = this.m + 1;
                        int i45 = i7 * i35;
                        i8 = this.n;
                        if (i45 <= i8 * i34) {
                            break;
                        }
                        b(i3);
                        int i46 = 0;
                        while (true) {
                            int i47 = this.b;
                            if (i46 < i47) {
                                short[] sArr9 = this.j;
                                int i48 = (this.r * i47) + i46;
                                short[] sArr10 = this.l;
                                int i49 = (i41 * i47) + i46;
                                short s = sArr10[i49];
                                short s2 = sArr10[i49 + i47];
                                int i50 = this.n * i34;
                                int i51 = this.m;
                                int i52 = i51 * i35;
                                int i53 = (i51 + 1) * i35;
                                int i54 = i53 - i50;
                                int i55 = i53 - i52;
                                sArr9[i48] = (short) ((((i55 - i54) * s2) + (s * i54)) / i55);
                                i46++;
                            }
                        }
                        i3 = 1;
                        this.n++;
                        this.r++;
                    }
                    this.m = i7;
                    if (i7 == i34) {
                        this.m = 0;
                        if (i8 == i35) {
                            this.n = 0;
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                    i41++;
                }
            }
        }
        f = 1.0f;
        i3 = 1;
        f2 = this.p;
        if (f2 != f) {
        }
    }

    public static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
