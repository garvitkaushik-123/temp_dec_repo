package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.lk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public enum EnumC2222lk {
    A05,
    A04,
    A02,
    A03;

    public static byte[] A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 74);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{48, 59, 58, 49, 41, 46, 38, 35, 42, 43, 55, 54, 45, 38, 43, 60, 56, Base64.padSymbol, 32, 101, 114, 118, 115, 110};
    }

    static {
        A01();
    }
}
