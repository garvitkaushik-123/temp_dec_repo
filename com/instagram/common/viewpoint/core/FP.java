package com.instagram.common.viewpoint.core;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class FP extends IOException {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-64, -90, -27, -2, -11, 8, 0, -11, -13, 4, -11, -12, -80};
    }

    public FP(Throwable th) {
        super(A00(2, 11, 91) + th.getClass().getSimpleName() + A00(0, 2, 81) + th.getMessage(), th);
    }
}
