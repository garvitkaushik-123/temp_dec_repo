package com.instagram.common.viewpoint.core;

import com.google.common.primitives.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.pN, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2433pN {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 49);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{0, 58, 59, 111, 32, 41, 111, Base64.padSymbol, 46, 33, 40, 42, 117, 111, 106, 60};
    }

    public static char A00(byte b1, byte b2) {
        return (char) ((b1 << 8) | (b2 & 255));
    }

    public static char A01(long value) {
        char c = (char) value;
        AbstractC2159ki.A0H(((long) c) == value, A02(0, 16, 126), value);
        return c;
    }

    public static boolean A04(char[] array, char target) {
        for (char c : array) {
            if (c == target) {
                return true;
            }
        }
        return false;
    }
}
