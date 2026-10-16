package com.instagram.common.viewpoint.core;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class DL {
    public static String[] A07 = {"1TUPUvqjuckMieKxy618dXqeho2I2nXO", "1tw", "Rv8BHxt03y9lIrpcW4kHhbfWsqmFKBVK", "r8Px", "D2vXeeTjlCXB4Odv", "hN", "uuD40", "TpLNmCJV5wG1YwTXf3toM93vl9iWeWk7"};
    public long A00;
    public C2331ni A01;
    public C2331ni A02;
    public C2331ni A03;
    public final int A04;
    public final C07364v A05 = new C07364v(32);
    public final F0 A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2331ni A04(C2331ni c2331ni, C2410p0 c2410p0, DN dn, C07364v c07364v) {
        int i;
        long j = dn.A01;
        c07364v.A0d(1);
        C2331ni A03 = A03(c2331ni, j, c07364v.A0l(), 1);
        long j2 = j + 1;
        byte b = c07364v.A0l()[0];
        boolean z = (b & 128) != 0;
        int i2 = b & Byte.MAX_VALUE;
        C07665z c07665z = c2410p0.A05;
        if (c07665z.A04 == null) {
            c07665z.A04 = new byte[16];
        } else {
            Arrays.fill(c07665z.A04, (byte) 0);
        }
        C2331ni A032 = A03(A03, j2, c07665z.A04, i2);
        long j3 = j2 + i2;
        if (z) {
            c07364v.A0d(2);
            A032 = A03(A032, j3, c07364v.A0l(), 2);
            j3 += 2;
            i = c07364v.A0M();
        } else {
            i = 1;
            if (A07[7].charAt(5) == 'i') {
                throw new RuntimeException();
            }
            A07[7] = "Hpyz1f8ALnZx1iP9R6alck8MxH3P54oK";
        }
        int[] iArr = c07665z.A06;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = c07665z.A07;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            c07364v.A0d(i3);
            A032 = A03(A032, j3, c07364v.A0l(), i3);
            j3 += i3;
            c07364v.A0f(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = c07364v.A0M();
                iArr2[i4] = c07364v.A0L();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = dn.A00 - ((int) (j3 - dn.A01));
        }
        C1034Hb c1034Hb = (C1034Hb) C5C.A0f(dn.A02);
        c07665z.A02(i, iArr, iArr2, c1034Hb.A03, c07665z.A04, c1034Hb.A01, c1034Hb.A02, c1034Hb.A00);
        int i5 = (int) (j3 - dn.A01);
        dn.A01 += i5;
        if (A07[0].charAt(1) == 'T') {
            A07[0] = "nTpP9ibfF3cbwjVbkTA4UIhNPpZui5fl";
            dn.A00 -= i5;
            return A032;
        }
        String[] strArr = A07;
        strArr[3] = "b8i1";
        strArr[6] = "bRWrT";
        dn.A00 -= i5;
        return A032;
    }

    public DL(F0 f0) {
        this.A06 = f0;
        this.A04 = f0.A8I();
        this.A01 = new C2331ni(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
    }

    private int A00(int i) {
        if (this.A03.A03 == null) {
            this.A03.A03(this.A06.A49(), new C2331ni(this.A03.A00, this.A04));
        }
        return Math.min(i, (int) (this.A03.A00 - this.A00));
    }

    public static C2331ni A01(C2331ni c2331ni, long j) {
        while (j >= c2331ni.A00) {
            c2331ni = c2331ni.A02;
        }
        return c2331ni;
    }

    public static C2331ni A02(C2331ni c2331ni, long j, ByteBuffer byteBuffer, int i) {
        C2331ni A01 = A01(c2331ni, j);
        while (i > 0) {
            int remaining = (int) (A01.A00 - j);
            int min = Math.min(i, remaining);
            byte[] bArr = A01.A03.A01;
            int remaining2 = A01.A00(j);
            byteBuffer.put(bArr, remaining2, min);
            i -= min;
            j += min;
            if (j == A01.A00) {
                A01 = A01.A02;
            }
        }
        return A01;
    }

    public static C2331ni A03(C2331ni c2331ni, long j, byte[] bArr, int i) {
        C2331ni A01 = A01(c2331ni, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (A01.A00 - j));
            byte[] bArr2 = A01.A03.A01;
            int toCopy = A01.A00(j);
            int remaining = i - i2;
            System.arraycopy(bArr2, toCopy, bArr, remaining, min);
            i2 -= min;
            j += min;
            if (j == A01.A00) {
                A01 = A01.A02;
            }
        }
        return A01;
    }

    public static C2331ni A05(C2331ni c2331ni, C2410p0 c2410p0, DN dn, C07364v c07364v) {
        if (c2410p0.A0E()) {
            c2331ni = A04(c2331ni, c2410p0, dn, c07364v);
        }
        if (c2410p0.A03()) {
            c07364v.A0d(4);
            C2331ni A03 = A03(c2331ni, dn.A01, c07364v.A0l(), 4);
            int A0L = c07364v.A0L();
            dn.A01 += 4;
            dn.A00 -= 4;
            c2410p0.A0C(A0L);
            C2331ni A02 = A02(A03, dn.A01, c2410p0.A02, A0L);
            dn.A01 += A0L;
            dn.A00 -= A0L;
            c2410p0.A0D(dn.A00);
            return A02(A02, dn.A01, c2410p0.A03, dn.A00);
        }
        c2410p0.A0C(dn.A00);
        return A02(c2331ni, dn.A01, c2410p0.A02, dn.A00);
    }

    private void A06(int i) {
        this.A00 += i;
        if (this.A00 == this.A03.A00) {
            this.A03 = this.A03.A02;
        }
    }

    private void A07(C2331ni c2331ni) {
        if (c2331ni.A03 == null) {
            return;
        }
        this.A06.AHe(c2331ni);
        c2331ni.A01();
    }

    public final int A08(InterfaceC06692c interfaceC06692c, int i, boolean z) throws IOException {
        int read = interfaceC06692c.read(this.A03.A03.A01, this.A03.A00(this.A00), A00(i));
        if (read == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        A06(read);
        return read;
    }

    public final long A09() {
        return this.A00;
    }

    public final void A0A() {
        A07(this.A01);
        this.A01.A02(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
        this.A00 = 0L;
        this.A06.AKT();
    }

    public final void A0B() {
        this.A02 = this.A01;
    }

    public final void A0C(long j) {
        if (j == -1) {
            return;
        }
        while (j >= this.A01.A00) {
            this.A06.AHd(this.A01.A03);
            this.A01 = this.A01.A01();
        }
        long j2 = this.A02.A01;
        long j3 = this.A01.A01;
        String[] strArr = A07;
        if (strArr[3].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[3] = "kTcq";
        strArr2[6] = "Dj6YZ";
        if (j2 < j3) {
            this.A02 = this.A01;
        }
    }

    public final void A0D(C07364v c07364v, int i) {
        while (i > 0) {
            int A00 = A00(i);
            byte[] bArr = this.A03.A03.A01;
            int bytesAppended = this.A03.A00(this.A00);
            c07364v.A0k(bArr, bytesAppended, A00);
            i -= A00;
            A06(A00);
        }
    }

    public final void A0E(C2410p0 c2410p0, DN dn) {
        A05(this.A02, c2410p0, dn, this.A05);
    }

    public final void A0F(C2410p0 c2410p0, DN dn) {
        this.A02 = A05(this.A02, c2410p0, dn, this.A05);
    }
}
