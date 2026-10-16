package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.8U, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C8U implements InterfaceC2253mF {
    public static byte[] A06;
    public static String[] A07 = {"QubeI9WU03qBZcNvE4IUkWvlw0NRrBK6", "F1d068LLA73yClDAGmhas6o", "9YpbVeLOd0f6m", "7Ycu3nAZXESMUbUrutcG9271koISuOhT", "QjcyZL4t35rbWMpE5hp6oYgD7sVhkS0D", "M48I8dHdEQTg0rHaHaNT6qI1", "cVfJzOsNywAlxLknvQSr1dDTMZn5TIAU", "kJeh17rnzHgOQ2HfO7oDpw4wPPnH7lFe"};
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long[] A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C8U A01(long j, long j2, HN hn, C07364v c07364v) {
        int A0L;
        int i = hn.A04;
        int i2 = hn.A03;
        int A0C = c07364v.A0C();
        if ((A0C & 1) != 1 || (A0L = c07364v.A0L()) == 0) {
            return null;
        }
        long A0U = C5C.A0U(A0L, i * 1000000, i2);
        if ((A0C & 6) != 6) {
            return new C8U(j2, hn.A02, A0U);
        }
        long A0Q = c07364v.A0Q();
        long[] jArr = new long[100];
        for (int i3 = 0; i3 < 100; i3++) {
            jArr[i3] = c07364v.A0I();
        }
        if (j != -1 && j != j2 + A0Q) {
            AbstractC07214g.A07(A02(27, 10, 78), A02(2, 25, 105) + j + A02(0, 2, 40) + (j2 + A0Q));
        }
        return new C8U(j2, hn.A02, A0U, A0Q, jArr);
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A07;
            if (strArr[1].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A07[2] = "La6";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 30);
            i4++;
        }
    }

    public static void A03() {
        A06 = new byte[]{114, 102, -33, -48, -43, -50, -89, -21, -24, -5, -24, -89, -6, -16, 1, -20, -89, -12, -16, -6, -12, -24, -5, -22, -17, -63, -89, -60, -43, -38, -45, -65, -47, -47, -41, -47, -34};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.HY
    public final HX A91(long j) {
        double d;
        if (!AAj()) {
            return new HX(new HZ(0L, this.A03 + this.A00));
        }
        long A0T = C5C.A0T(j, 0L, this.A04);
        double d2 = (A0T * 100.0d) / this.A04;
        if (d2 <= 0.0d) {
            d = 0.0d;
        } else if (d2 >= 100.0d) {
            d = 256.0d;
        } else {
            int i = (int) d2;
            double d3 = ((long[]) AbstractC07133y.A02(this.A05))[i];
            d = (((i == 99 ? 256.0d : r9[i + 1]) - d3) * (d2 - i)) + d3;
        }
        return new HX(new HZ(A0T, this.A03 + C5C.A0T(Math.round((d / 256.0d) * this.A02), this.A00, this.A02 - 1)));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC2253mF
    public final long A9H(long j) {
        long j2 = j - this.A03;
        if (!AAj() || j2 <= this.A00) {
            return 0L;
        }
        long[] jArr = (long[]) AbstractC07133y.A02(this.A05);
        double d = (j2 * 256.0d) / this.A02;
        int A0L = C5C.A0L(jArr, (long) d, true, true);
        long A00 = A00(A0L);
        long j3 = jArr[A0L];
        long A002 = A00(A0L + 1);
        long j4 = A0L == 99 ? 256L : jArr[A0L + 1];
        String[] strArr = A07;
        if (strArr[0].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A07[6] = "PlWtaQzxKmV3LAe12cSeUsJTirSwbfkK";
        return Math.round((A002 - A00) * (j3 == j4 ? 0.0d : (d - j3) / (j4 - j3))) + A00;
    }

    static {
        A03();
    }

    public C8U(long j, int i, long j2) {
        this(j, i, j2, -1L, null);
    }

    public C8U(long j, int i, long j2, long j3, long[] jArr) {
        this.A03 = j;
        this.A00 = i;
        this.A04 = j2;
        this.A05 = jArr;
        this.A02 = j3;
        this.A01 = j3 != -1 ? j + j3 : -1L;
    }

    private long A00(int i) {
        return (this.A04 * i) / 100;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2253mF
    public final long A7j() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final long A7t() {
        return this.A04;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final boolean AAj() {
        return this.A05 != null;
    }
}
