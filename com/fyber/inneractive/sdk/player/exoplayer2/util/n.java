package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f1591a;
    public int b;
    public int c;

    public n() {
    }

    public final int a() {
        byte[] bArr = this.f1591a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int b() {
        byte[] bArr = this.f1591a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i + 2;
        this.b = i4;
        int i5 = ((bArr[i2] & 255) << 16) | i3;
        int i6 = i + 3;
        this.b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.b = i + 4;
        return (bArr[i6] & 255) | i7;
    }

    public final void c(int i) {
        this.f1591a = a() < i ? new byte[i] : this.f1591a;
        this.c = i;
        this.b = 0;
    }

    public final void d(int i) {
        if (i < 0 || i > this.f1591a.length) {
            throw new IllegalArgumentException();
        }
        this.c = i;
    }

    public final void e(int i) {
        if (i < 0 || i > this.c) {
            throw new IllegalArgumentException();
        }
        this.b = i;
    }

    public final int f() {
        byte[] bArr = this.f1591a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public final long g() {
        byte[] bArr = this.f1591a;
        int i = this.b;
        this.b = i + 1;
        this.b = i + 2;
        this.b = i + 3;
        long j = ((bArr[i] & 255) << 56) | ((bArr[r2] & 255) << 48) | ((bArr[r7] & 255) << 40);
        this.b = i + 4;
        long j2 = j | ((bArr[r4] & 255) << 32);
        this.b = i + 5;
        long j3 = j2 | ((bArr[r7] & 255) << 24);
        this.b = i + 6;
        long j4 = j3 | ((bArr[r4] & 255) << 16);
        this.b = i + 7;
        long j5 = j4 | ((bArr[r7] & 255) << 8);
        this.b = i + 8;
        return (bArr[r4] & 255) | j5;
    }

    public final void h() {
        int i = this.c;
        int i2 = this.b;
        if (i - i2 == 0) {
            return;
        }
        while (i2 < this.c && this.f1591a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f1591a;
        int i3 = this.b;
        new String(bArr, i3, i2 - i3);
        this.b = i2;
        if (i2 < this.c) {
            this.b = i2 + 1;
        }
    }

    public final int i() {
        return (j() << 21) | (j() << 14) | (j() << 7) | j();
    }

    public final int j() {
        byte[] bArr = this.f1591a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public final long k() {
        byte[] bArr = this.f1591a;
        int i = this.b;
        this.b = i + 1;
        this.b = i + 2;
        this.b = i + 3;
        long j = ((bArr[i] & 255) << 24) | ((bArr[r2] & 255) << 16) | ((bArr[r7] & 255) << 8);
        this.b = i + 4;
        return (bArr[r4] & 255) | j;
    }

    public final int l() {
        byte[] bArr = this.f1591a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = (bArr[i] & 255) << 16;
        int i4 = i + 2;
        this.b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        this.b = i + 3;
        return (bArr[i4] & 255) | i5;
    }

    public final int m() {
        int b = b();
        if (b >= 0) {
            return b;
        }
        throw new IllegalStateException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("Top bit not zero: ", b));
    }

    public final long n() {
        long g = g();
        if (g >= 0) {
            return g;
        }
        throw new IllegalStateException("Top bit not zero: " + g);
    }

    public final int o() {
        byte[] bArr = this.f1591a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (bArr[i2] & 255) | i3;
    }

    public n(int i) {
        this.f1591a = new byte[i];
        this.c = i;
    }

    public final void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f1591a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final String b(int i) {
        String str = new String(this.f1591a, this.b, i, Charset.defaultCharset());
        this.b += i;
        return str;
    }

    public final String a(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String str = new String(this.f1591a, i2, (i3 >= this.c || this.f1591a[i3] != 0) ? i : i - 1);
        this.b += i;
        return str;
    }

    public final int d() {
        byte[] bArr = this.f1591a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        int i6 = i + 3;
        this.b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.b = i + 4;
        return ((bArr[i6] & 255) << 24) | i7;
    }

    public final long e() {
        byte[] bArr = this.f1591a;
        int i = this.b;
        this.b = i + 1;
        this.b = i + 2;
        this.b = i + 3;
        long j = (bArr[i] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.b = i + 4;
        return ((bArr[r4] & 255) << 24) | j;
    }

    public n(byte[] bArr) {
        this.f1591a = bArr;
        this.c = bArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        if (r1 == r4) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c() {
        int i = this.c;
        int i2 = this.b;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.c) {
            byte b = this.f1591a[i2];
            int i3 = z.f1599a;
            if (b == 10 || b == 13) {
                break;
            }
            i2++;
        }
        int i4 = this.b;
        if (i2 - i4 >= 3) {
            byte[] bArr = this.f1591a;
            if (bArr[i4] == -17 && bArr[i4 + 1] == -69 && bArr[i4 + 2] == -65) {
                this.b = i4 + 3;
            }
        }
        byte[] bArr2 = this.f1591a;
        int i5 = this.b;
        String str = new String(bArr2, i5, i2 - i5);
        this.b = i2;
        int i6 = this.c;
        if (i2 != i6) {
            byte[] bArr3 = this.f1591a;
            if (bArr3[i2] == 13) {
                int i7 = i2 + 1;
                this.b = i7;
            }
            int i8 = this.b;
            if (bArr3[i8] == 10) {
                this.b = i8 + 1;
            }
        }
        return str;
    }

    public n(int i, byte[] bArr) {
        this.f1591a = bArr;
        this.c = i;
    }
}
