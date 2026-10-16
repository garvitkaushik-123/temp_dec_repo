package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.0E, reason: invalid class name */
/* loaded from: assets/audience_network/classes.dex */
public enum C0E {
    A07,
    A0A,
    A0F,
    A04,
    A0E,
    A0D,
    A0G,
    A03,
    A0B,
    A05,
    A08,
    A0H,
    A06,
    A09,
    A0C,
    A02;

    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 2);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{116, 121, 121, 35, 47, 46, 51, 52, 50, 53, 35, 52, 47, 50, 63, 50, 37, 51, 53, 44, 52, 117, 104, 115, 117, 96, 100, 121, Byte.MAX_VALUE, 126, 111, 96, 113, 98, 113, 125, 117, 100, 117, 98, 123, 102, 110, 114, 119, 125, 119, 106, 97, 114, 113, 105, 123, 108, 97, 124, 113, 107, 112, 122, 122, 103, 111, 115, 118, 124, 118, 107, 96, 106, 111, 111, 122, 109, 96, 125, 112, 106, 113, 123, 4, Ascii.VT, 7, Ascii.SO, 6, 5, 1, Ascii.FS, 0, 5, Ascii.SI, 5, Ascii.CAN, 19, 0, 3, Ascii.ESC, 9, Ascii.RS, 19, Ascii.SO, 3, Ascii.EM, 2, 8, Ascii.ESC, Ascii.US, 2, Ascii.RS, Ascii.ESC, 17, Ascii.ESC, 6, Ascii.CR, 7, 2, 2, Ascii.ETB, 0, Ascii.CR, Ascii.DLE, Ascii.GS, 7, Ascii.FS, Ascii.SYN, 85, 86, 90, 88, 85, 70, 79, 88, 75, 80, 88, 91, 85, 92, 51, 48, 40, 58, 45, 32, Base64.padSymbol, 48, 42, 49, 59, Ascii.VT, Ascii.DLE, Ascii.FF, 1, Ascii.SYN, 19, Ascii.CR, Ascii.ETB, 1, 90, 75, 88, 75, 71, 79, 94, 79, 88, 4, 19, Ascii.NAK, 19, Ascii.US, 0, 19, 4, 49, 38, 48, 44, 54, 49, 32, 38, 60, 53, 34, 49, 42, 34, 33, 47, 38, Ascii.RS, 9, Ascii.CAN, Ascii.EM, Ascii.RS, 2, 54, 51, 51, 38, 49, 60, 33, 44, 54, 45, 39};
    }
}
