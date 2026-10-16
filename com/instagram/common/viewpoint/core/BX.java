package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class BX extends Exception {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 81);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{52, 19, Ascii.ESC, Ascii.RS, Ascii.ETB, Ascii.SYN, 82, 6, Ascii.GS, 82, 3, 7, Ascii.ETB, 0, Ascii.VT, 82, 7, Ascii.FS, Ascii.SYN, Ascii.ETB, 0, Ascii.RS, Ascii.VT, Ascii.ESC, Ascii.FS, Ascii.NAK, 82, Ascii.US, Ascii.ETB, Ascii.SYN, Ascii.ESC, 19, 82, 17, Ascii.GS, Ascii.SYN, Ascii.ETB, 17, 1};
    }

    public BX(Throwable th) {
        super(A00(0, 39, 35), th);
    }
}
