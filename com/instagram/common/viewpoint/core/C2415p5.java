package com.instagram.common.viewpoint.core;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.p5, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2415p5 extends C07425b {
    public static byte[] A02;
    public final int A00;
    public final C07495i A01;

    static {
        A06();
    }

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 56);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A02 = new byte[]{-39, -30, -37, -41, -24, -22, -37, -18, -22, -92, -96, -28, -27, -22, -106, -26, -37, -24, -29, -33, -22, -22, -37, -38, -92, -96};
    }

    public C2415p5(C07495i c07495i, int i, int i2) {
        super(A03(i, i2));
        this.A01 = c07495i;
        this.A00 = i2;
    }

    public C2415p5(IOException iOException, C07495i c07495i, int i, int i2) {
        super(iOException, A03(i, i2));
        this.A01 = c07495i;
        this.A00 = i2;
    }

    public C2415p5(String str, C07495i c07495i, int i, int i2) {
        super(str, A03(i, i2));
        this.A01 = c07495i;
        this.A00 = i2;
    }

    public C2415p5(String str, IOException iOException, C07495i c07495i, int i, int i2) {
        super(str, iOException, A03(i, i2));
        this.A01 = c07495i;
        this.A00 = i2;
    }

    public static int A03(int i, int i2) {
        if (i == 2000 && i2 == 1) {
            return 2001;
        }
        return i;
    }

    public static C2415p5 A04(IOException iOException, C07495i c07495i, int i) {
        int errorCode;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            errorCode = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            errorCode = 1004;
        } else {
            if (message != null) {
                String A01 = AbstractC2124k7.A01(message);
                String message2 = A05(0, 26, 62);
                if (A01.matches(message2)) {
                    errorCode = 2007;
                }
            }
            errorCode = 2001;
        }
        if (errorCode == 2007) {
            return new AM(iOException, c07495i);
        }
        return new C2415p5(iOException, c07495i, errorCode, i);
    }
}
