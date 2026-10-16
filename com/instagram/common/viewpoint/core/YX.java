package com.instagram.common.viewpoint.core;

import android.app.Activity;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class YX {
    public static byte[] A00;
    public static String[] A01 = {"fNLd7n7EkFNgLvt4vtbAtkfYXAQTEPRW", "T28d5tP6PdXMoXHWEuFSx", "qUncBokoif621v1GQ7gcKknRgizXPQsv", "IkdBxGtQCWxg3d0UA", "tTLCQWoYBdse5ixamGS9HTw2k7WXO8kY", "MyXxcbJBNTQUhn8S7mcX9rM3djOk", "ymwmgwOSW636xClV84tW2WEHiZAMdx7v", "xCAHRx5Y4"};

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            String[] strArr = A01;
            if (strArr[7].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A01[0] = "dZQs1GEaNPWr5rijC2ubsciPbAft3PPF";
            copyOfRange[i4] = (byte) ((b - i3) - 117);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Ascii.SI, Ascii.CR, Ascii.SYN, Ascii.CR, Ascii.SUB, 17, Ascii.VT};
    }

    static {
        A01();
    }

    public static void A02(Activity activity, int i, C1929gi c1929gi) {
        try {
            activity.setRequestedOrientation(i);
        } catch (IllegalStateException e) {
            c1929gi.A08().ABz(A00(0, 7, 51), AbstractC1341Td.A0H, new C1342Te(e));
        }
    }
}
