package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.aM, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public enum EnumC1537aM {
    A03,
    A02,
    A07,
    A06,
    A04,
    A05;

    public static byte[] A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 1);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{35, 40, 34, 57, 37, 39, 52, 34, 2, Ascii.CR, Ascii.SYN, Ascii.ETB, Ascii.DLE, Ascii.ESC, 7, 5, Ascii.SYN, 0, 37, 45, 44, 33, Base64.padSymbol, 37, 55, 58, 45, 43, 60, 41, 38, 47, 36, 45, 78, 65, 84, 73, 86, 69, 33, 35, 52, 46, 35, 52, 38, 48, 35, 53, 46, 34, 50, 35, 52, 52, 63, 87, SignedBytes.MAX_POWER_OF_TWO, 82, 68, 87, 65, 90, 86, 80, 70, 70, SignedBytes.MAX_POWER_OF_TWO, 86, 86, 90, 86, 70, 87, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 75};
    }

    static {
        A01();
    }
}
