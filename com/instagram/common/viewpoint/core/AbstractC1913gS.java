package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.math.ElementTypesAreNonnullByDefault;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.gS, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1913gS {
    public static byte[] A00;
    public static String[] A01 = {"AE3RQ6SjoFsrAp99H6Zd4spKw", "3Pq1cGGFUNEEXAchrVP3Xf", "yX", "SQjo6b3iOf0URtZXiBRUVHbWf8EnkAui", "00", "u726MkM70Dw3XEWQiRy0H2gvugSd8Tre", "3sVZHBX6ZyruD1ikbvJFjqJz5AcrXt3h", "iwn02HMEBncjK0hVIYdCKaY5g2oqtZ"};

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            if (A01[7].length() == 5) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "H9pmIUr4yhuwQEnoSmBFmn";
            strArr[0] = "tMM9GmlwKAk4hf8HM9GRHGRZ0";
            copyOfRange[i4] = (byte) ((b - i3) - 100);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{45, 47, 36, 37, -32, 55, 33, 51, -32, Ascii.NAK, Ascii.SO, Ascii.SO, 5, 3, 5, 19, 19, 1, Ascii.DC2, Ascii.EM, -20, -32, 34, 53, 52, -32, 50, 47, 53, 46, 36, 41, 46, 39, -32, 55, 33, 51, -32, 46, 37, 35, 37, 51, 51, 33, 50, 57};
    }

    static {
        A01();
    }

    public static void A02(boolean condition) {
        if (condition) {
        } else {
            throw new ArithmeticException(A00(0, 48, 92));
        }
    }
}
