package com.instagram.common.viewpoint.core;

import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class U5 {
    public static byte[] A00;

    static {
        A04();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_PARENTAL_CONTROL_RESTRICTED);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{6, 6, 19, -9, 3, 2, -6, -3, -5, 19, 8, 7, 19, 1, 7, -5, -5, 8, -4, -18, -5, -1, -14, -20, -18, 8, -18, 1, -3, -5, -22, -4, -16, -16, -3, -15, -29, -16, -12, -25, -31, -29, -3, -15, -30, -23, -3, -12, -29, -16, -15, -25, -19, -20};
    }

    public static String A01(C1925ge c1925ge) {
        return WN.A00(c1925ge).getString(A00(0, 15, 75), null);
    }

    public static String A02(C1925ge c1925ge) {
        return WN.A00(c1925ge).getString(A00(15, 17, 64), null);
    }

    public static String A03(C1925ge c1925ge) {
        return WN.A00(c1925ge).getString(A00(32, 22, 53), null);
    }

    public static void A05(C1925ge c1925ge) {
        WN.A00(c1925ge).edit().remove(A00(32, 22, 53)).apply();
    }

    public static void A06(C1925ge c1925ge, String str, String str2) {
        WN.A00(c1925ge).edit().putString(A00(32, 22, 53), str).putString(A00(15, 17, 64), str2).putString(A00(0, 15, 75), Y1.A07(Y1.A00())).apply();
    }
}
