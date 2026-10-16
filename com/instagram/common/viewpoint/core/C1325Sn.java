package com.instagram.common.viewpoint.core;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Sn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1325Sn {
    public static byte[] A00;
    public static String[] A01 = {"OKQe8hXRO9IjIcE", "fZKFXGCnlijKRnd4C4GIjN8U9jomZ", "zd2g3FUlSdy4niS", "DQ1eYrU0vgUbRV2buV2T3UhVrDT8jNOj", "Q6rIf3Izbhrm2WD", "9gkLXGbOvBYKsW5YBwzKkub2Nn3K8ZPa", "2O7yMssiHcBFdM45gqp1TjJS", "Fkq1E5"};

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[3].charAt(10) == 'G') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "GMwx2CjIRojg5Fd";
            strArr[4] = "kdR397QSXvrHcnb";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 100);
            i4++;
        }
    }

    public static void A02() {
        A00 = new byte[]{74, 92, 119, 77, 80, 92, 90, 73, 91, Ascii.CAN, Ascii.DC4, Ascii.SYN, 85, Ascii.GS, Ascii.SUB, Ascii.CAN, Ascii.RS, Ascii.EM, Ascii.DC4, Ascii.DC4, Ascii.DLE, 85, Ascii.SUB, Ascii.US, 8, 85, Ascii.DC2, Ascii.NAK, Ascii.SI, Ascii.RS, 9, Ascii.NAK, Ascii.SUB, Ascii.ETB, 85, Ascii.EM, Ascii.SI, Ascii.RS, 3, Ascii.SI, 9, Ascii.SUB, 8};
    }

    static {
        A02();
    }

    public static SharedPreferences A00(T8 t8) {
        return t8.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(9, 34, 31), t8), 0);
    }

    public final String A03(T8 t8) {
        return A00(t8).getString(A01(0, 9, 76), null);
    }

    public final void A04(T8 t8, String str) {
        SharedPreferences btSP = A00(t8);
        btSP.edit().putString(A01(0, 9, 76), str).apply();
    }
}
