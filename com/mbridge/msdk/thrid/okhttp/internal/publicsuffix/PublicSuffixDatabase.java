package com.mbridge.msdk.thrid.okhttp.internal.publicsuffix;

import com.mbridge.msdk.thrid.okhttp.internal.c;
import com.mbridge.msdk.thrid.okhttp.internal.platform.g;
import com.mbridge.msdk.thrid.okio.e;
import com.mbridge.msdk.thrid.okio.j;
import com.mbridge.msdk.thrid.okio.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public final class PublicSuffixDatabase {
    private static final byte[] e = {42};
    private static final String[] f = new String[0];
    private static final String[] g = {"*"};
    private static final PublicSuffixDatabase h = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f4872a = new AtomicBoolean(false);
    private final CountDownLatch b = new CountDownLatch(1);
    private byte[] c;
    private byte[] d;

    public static PublicSuffixDatabase a() {
        return h;
    }

    private void b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        e a2 = l.a(new j(l.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[a2.readInt()];
            a2.readFully(bArr);
            byte[] bArr2 = new byte[a2.readInt()];
            a2.readFully(bArr2);
            synchronized (this) {
                this.c = bArr;
                this.d = bArr2;
            }
            this.b.countDown();
        } finally {
            c.a(a2);
        }
    }

    private void c() {
        boolean z = false;
        while (true) {
            try {
                try {
                    b();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e2) {
                    g.d().a(5, "Failed to read public suffix list", e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public String a(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a2 = a(split);
        if (split.length == a2.length && a2[0].charAt(0) != '!') {
            return null;
        }
        if (a2[0].charAt(0) == '!') {
            length = split.length;
            length2 = a2.length;
        } else {
            length = split.length;
            length2 = a2.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int i = length - length2; i < split2.length; i++) {
            sb.append(split2[i]).append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i = 0;
        if (!this.f4872a.get() && this.f4872a.compareAndSet(false, true)) {
            c();
        } else {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        synchronized (this) {
            if (this.c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(c.j);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = a(this.c, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = e;
                str3 = a(this.c, bArr2, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String a2 = a(this.d, bArr, i);
                if (a2 != null) {
                    str = a2;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (str2 == null && str3 == null) {
            return g;
        }
        String[] split = str2 != null ? str2.split("\\.") : f;
        String[] split2 = str3 != null ? str3.split("\\.") : f;
        return split.length > split2.length ? split : split2;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        i11 = -1;
                        z2 = true;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, c.j);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i6;
        }
        return null;
    }
}
