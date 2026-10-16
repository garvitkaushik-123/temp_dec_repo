package com.mbridge.msdk.foundation.tools;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import java.nio.charset.StandardCharsets;

/* compiled from: FastBuffer.java */
/* loaded from: classes6.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f4349a;
    public int b;
    private char[] c;

    public a0(int i) {
        this(new byte[i], 0);
    }

    public static int b(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (charAt < 128) {
                i2++;
            } else if (charAt < 2048) {
                i2 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i2 += 3;
            } else {
                i += 2;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    public static int f(int i) {
        if ((i >> 7) == 0) {
            return 1;
        }
        if ((i >> 14) == 0) {
            return 2;
        }
        if ((i >> 21) == 0) {
            return 3;
        }
        return (i >> 28) == 0 ? 4 : 5;
    }

    public byte a() {
        byte[] bArr = this.f4349a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i];
    }

    public float c() {
        return Float.intBitsToFloat(d());
    }

    public long d(int i) {
        byte[] bArr = this.f4349a;
        int i2 = i + 6;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i2] & 255) << 48) | (bArr[i + 7] << 56);
    }

    public long e() {
        long d = d(this.b);
        this.b += 8;
        return d;
    }

    public short f() {
        byte[] bArr = this.f4349a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return (short) ((bArr[i2] << 8) | i3);
    }

    public int g() {
        byte[] bArr = this.f4349a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        byte b = bArr[i];
        if ((b >> 7) == 0) {
            return b;
        }
        int i3 = i + 2;
        this.b = i3;
        int i4 = (bArr[i2] << 7) | (b & Byte.MAX_VALUE);
        if ((i4 >> 14) == 0) {
            return i4;
        }
        int i5 = i + 3;
        this.b = i5;
        int i6 = (i4 & 16383) | (bArr[i3] << Ascii.SO);
        if ((i6 >> 21) == 0) {
            return i6;
        }
        int i7 = i + 4;
        this.b = i7;
        int i8 = (i6 & 2097151) | (bArr[i5] << Ascii.NAK);
        if ((i8 >> 28) == 0) {
            return i8;
        }
        this.b = i + 5;
        return (bArr[i7] << Ascii.FS) | (i8 & 268435455);
    }

    public void h(int i) {
        this.b = c(this.b, i);
    }

    public a0(byte[] bArr, int i) {
        this.c = null;
        this.f4349a = bArr;
        this.b = i;
    }

    private char[] c(int i) {
        char[] cArr = this.c;
        if (cArr == null) {
            if (i <= 256) {
                this.c = new char[256];
            } else {
                this.c = new char[2048];
            }
        } else if (cArr.length < i) {
            this.c = new char[2048];
        }
        return this.c;
    }

    long a(int i, int i2) {
        long j = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            j ^= d(i6);
            i6 += 8;
        }
        while (i5 < (i4 << 3)) {
            j ^= (this.f4349a[i6] & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i8 = (i & 7) << 3;
        return (j >>> (64 - i8)) | (j << i8);
    }

    public int d() {
        byte[] bArr = this.f4349a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 16);
        this.b = i + 4;
        return (bArr[i3] << Ascii.CAN) | i4;
    }

    public String e(int i) {
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        String a2 = a(i);
        this.b += i;
        return a2;
    }

    public byte[] b(int i) {
        byte[] bArr = new byte[i];
        System.arraycopy(this.f4349a, this.b, bArr, 0, i);
        this.b += i;
        return bArr;
    }

    public double b() {
        return Double.longBitsToDouble(e());
    }

    public void b(int i, int i2) {
        byte[] bArr = this.f4349a;
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private String a(int i) {
        if (i > 2048) {
            return new String(this.f4349a, this.b, i, StandardCharsets.UTF_8);
        }
        char[] c = c(i);
        byte[] bArr = this.f4349a;
        int i2 = this.b;
        int i3 = i + i2;
        int i4 = 0;
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b > 0) {
                c[i4] = (char) b;
                i4++;
                i2 = i5;
            } else if (b < -32) {
                i2 += 2;
                c[i4] = (char) ((bArr[i5] & 63) | ((b & Ascii.US) << 6));
                i4++;
            } else if (b < -16) {
                int i6 = i2 + 2;
                i2 += 3;
                c[i4] = (char) (((bArr[i5] & 63) << 6) | ((b & Ascii.SI) << 12) | (bArr[i6] & 63));
                i4++;
            } else {
                byte b2 = bArr[i5];
                int i7 = i2 + 3;
                byte b3 = bArr[i2 + 2];
                i2 += 4;
                int i8 = ((b2 & 63) << 12) | ((b & 7) << 18) | ((b3 & 63) << 6) | (bArr[i7] & 63);
                int i9 = i4 + 1;
                c[i4] = (char) ((i8 >>> 10) + 55232);
                i4 += 2;
                c[i9] = (char) ((i8 & 1023) + 56320);
            }
        }
        if (i2 <= i3) {
            return new String(c, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    public void g(int i) {
        byte[] bArr = this.f4349a;
        int i2 = this.b;
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        this.b = i2 + 4;
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    public a0(byte[] bArr) {
        this(bArr, 0);
    }

    public void c(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        a(str);
    }

    public int c(int i, int i2) {
        while ((i2 & RangingPosition.RSSI_UNKNOWN) != 0) {
            this.f4349a[i] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i++;
        }
        int i3 = i + 1;
        this.f4349a[i] = (byte) i2;
        return i3;
    }

    public final void a(byte b) {
        byte[] bArr = this.f4349a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    public void a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.f4349a, this.b, length);
            this.b += length;
        }
    }

    public void a(long j) {
        a(this.b, j);
        this.b += 8;
    }

    public void a(int i, long j) {
        byte[] bArr = this.f4349a;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
    }

    public void a(short s) {
        byte[] bArr = this.f4349a;
        int i = this.b;
        bArr[i] = (byte) s;
        this.b = i + 2;
        bArr[i + 1] = (byte) (s >> 8);
    }

    private void a(String str) {
        byte[] bArr = this.f4349a;
        int i = this.b;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                bArr[i] = (byte) charAt;
                i++;
            } else if (charAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((charAt >>> 6) | 192);
                i += 2;
                bArr[i4] = (byte) ((charAt & '?') | 128);
            } else if (charAt >= 55296 && charAt <= 57343) {
                i2 += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i3)) - 56613888;
                bArr[i] = (byte) ((charAt2 >>> 18) | 240);
                bArr[i + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i5 = i + 3;
                bArr[i + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i += 4;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else {
                bArr[i] = (byte) ((charAt >>> '\f') | 224);
                int i6 = i + 2;
                bArr[i + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                i += 3;
                bArr[i6] = (byte) ((charAt & '?') | 128);
            }
            i2 = i3;
        }
        this.b = i;
    }
}
