package com.instagram.common.viewpoint.core;

import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.d2, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1703d2 implements Runnable {
    public static byte[] A01;
    public static String[] A02 = {"cNFcWbBTlC21yVLFwbr", "9GV2E8F9E2oE8CHXfnhYKiZsDK3egbEW", "QOwDSeu1r9UmOYKCJ4q7pu", "wLxLWw50lPgC4sAeZiCwv7pW84ixD2Ig", "u8mrTBG1NeFkrttZ2j0LSs7yOPehuw8f", "R35JTbeYnLlLSORxODVCOg1", "dSDMu8RDcGvfG7f91Jn", "vgGOrZScmi2DEwHan2nQobkknD6iF2"};
    public final /* synthetic */ C07535m A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 14);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{121, 70, 75, 74, SignedBytes.MAX_POWER_OF_TWO, Byte.MAX_VALUE, 67, 78, 86, 77, 78, 76, 68, 106, 93, 93, SignedBytes.MAX_POWER_OF_TWO, 93};
    }

    static {
        A01();
    }

    public RunnableC1703d2(C07535m c07535m) {
        this.A00 = c07535m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0I(A00(0, 18, 33));
        } catch (Throwable th) {
            WU.A00(th, this);
            if (A02[3].charAt(14) != 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "BiobfU8eOeDJTRwO1wDdFp";
            strArr[5] = "4fmLJ7Dm7W0RRBNKueLwAfq";
        }
    }
}
