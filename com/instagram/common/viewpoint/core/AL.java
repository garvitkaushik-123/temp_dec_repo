package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class AL extends C2415p5 {
    public static byte[] A01;
    public final String A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 87);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-11, Ascii.SUB, 34, Ascii.CR, Ascii.CAN, Ascii.NAK, Ascii.DLE, -52, Ascii.SI, Ascii.ESC, Ascii.SUB, 32, 17, Ascii.SUB, 32, -52, 32, 37, Ascii.FS, 17, -26, -52};
    }

    public AL(String str, C07495i c07495i) {
        super(A01(0, 22, 85) + str, c07495i, 2003, 1);
        this.A00 = str;
    }
}
