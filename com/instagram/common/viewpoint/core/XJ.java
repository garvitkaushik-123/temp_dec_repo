package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public enum XJ {
    A04,
    A03,
    A02;

    public static byte[] A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 44);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{99, 100, 99, 126, 99, 107, 102, 99, 112, 111, 110, Ascii.DC2, Ascii.NAK, Ascii.DC2, Ascii.SI, Ascii.DC2, Ascii.SUB, Ascii.ETB, Ascii.DC2, 1, Ascii.DC2, Ascii.NAK, Ascii.FS, Ascii.CAN, Ascii.EM, 2, 9, Ascii.US, Ascii.CAN, Ascii.US, 2, Ascii.US, Ascii.ETB, Ascii.SUB, Ascii.US, Ascii.FF, 19, Ascii.DC2};
    }

    static {
        A01();
    }
}
