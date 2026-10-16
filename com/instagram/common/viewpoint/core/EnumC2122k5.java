package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.k5, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public enum EnumC2122k5 {
    A05,
    A04,
    A02,
    A03;

    public static byte[] A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 30);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-121, -110, -111, -120, Byte.MAX_VALUE, 122, -126, -123, 126, 125, -109, -108, -103, -92, -105, -118, -122, -119, -98, -43, -56, -60, -57, -36};
    }

    static {
        A01();
    }
}
