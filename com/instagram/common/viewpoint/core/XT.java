package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public enum XT {
    A04(0),
    A05(1),
    A03(2);

    public static byte[] A01;
    public final int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 127);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{37, 56, 56, 35, 50, 51, 101, 126, 123, 126, Byte.MAX_VALUE, 103, 126, 86, 77, 81, 76, 76, 87, 70, 71};
    }

    static {
        A01();
    }

    XT(int i) {
        this.A00 = i;
    }
}
