package com.mbridge.msdk.thrid.okio;

import com.google.common.base.Ascii;
import com.ironsource.C3040d4;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import io.ktor.util.date.GMTDateParser;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: ByteString.java */
/* loaded from: classes6.dex */
public class f implements Serializable, Comparable<f> {
    static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    public static final f e = a(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    final byte[] f4901a;
    transient int b;
    transient String c;

    f(byte[] bArr) {
        this.f4901a = bArr;
    }

    public static f a(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private f b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f4901a));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static f c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(u.f4915a));
        fVar.c = str;
        return fVar;
    }

    public f d() {
        return b("SHA-256");
    }

    public int e() {
        return this.f4901a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int e2 = fVar.e();
            byte[] bArr = this.f4901a;
            if (e2 == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public f f() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f4901a;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new f(bArr2);
            }
            i++;
        }
    }

    public byte[] g() {
        return (byte[]) this.f4901a.clone();
    }

    public String h() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f4901a, u.f4915a);
        this.c = str2;
        return str2;
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f4901a);
        this.b = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.f4901a.length == 0) {
            return "[size=0]";
        }
        String h = h();
        int a2 = a(h, 64);
        if (a2 == -1) {
            return this.f4901a.length <= 64 ? "[hex=" + b() + C3040d4.i.e : "[size=" + this.f4901a.length + " hex=" + a(0, 64).b() + "…]";
        }
        String replace = h.substring(0, a2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return a2 < h.length() ? "[size=" + this.f4901a.length + " text=" + replace + "…]" : "[text=" + replace + C3040d4.i.e;
    }

    public String a() {
        return b.a(this.f4901a);
    }

    public static f a(String str) {
        if (str != null) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
                }
                return a(bArr);
            }
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        throw new IllegalArgumentException("hex == null");
    }

    public String b() {
        byte[] bArr = this.f4901a;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = d;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public f c() {
        return b(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
    }

    public final boolean b(f fVar) {
        return a(0, fVar, 0, fVar.e());
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            throw new IllegalArgumentException("Unexpected hex digit: " + c);
        }
        return c - '7';
    }

    public f a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f4901a;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f4901a.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new f(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte a(int i) {
        return this.f4901a[i];
    }

    void a(c cVar) {
        byte[] bArr = this.f4901a;
        cVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        return fVar.a(i2, this.f4901a, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.f4901a;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && u.a(bArr2, i, bArr, i2, i3);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int e2 = e();
        int e3 = fVar.e();
        int min = Math.min(e2, e3);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & 255;
            int a3 = fVar.a(i) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (e2 == e3) {
            return 0;
        }
        return e2 < e3 ? -1 : 1;
    }

    static int a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
