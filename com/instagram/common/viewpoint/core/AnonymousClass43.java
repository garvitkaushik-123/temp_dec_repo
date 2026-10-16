package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.os.IBinder;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.43, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AnonymousClass43 {
    public static Method A00;
    public static byte[] A01;
    public static String[] A02 = {"rt6CjKtQUOFxarnmkWqgGWje", "3nuh3b0J3kR9pkmWbi6mdwRc069ydG03", "vgqSEb59pwcvKw9WdixQFoz3Va18KFsr", "h35Isj3aZViVWltuKEoucz22tQqncTnx", "yJGJRoZVng69n9xQNPvqaXzNAukE8cwJ", "ZigbL863Rtw4tWoi2mLflUon", "c977rkHkuANnZfYHmbWrwArrI1mgRqhG", "I5ankwGA25juUPMFKSRh1H9yjdqc0trO"};

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 112);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{107, 92, 71, 77, 69, 76, 124, 93, SignedBytes.MAX_POWER_OF_TWO, 69, 44, Ascii.VT, 3, 6, Ascii.SI, Ascii.SO, 74, Ascii.RS, 5, 74, 3, 4, Ascii.FS, 5, 1, Ascii.SI, 74, Ascii.CR, Ascii.SI, Ascii.RS, 35, 40, 3, 4, Ascii.SO, Ascii.SI, Ascii.CAN, 74, Ascii.FS, 3, Ascii.VT, 74, Ascii.CAN, Ascii.SI, Ascii.FF, 6, Ascii.SI, 9, Ascii.RS, 3, 5, 4, 99, 68, 76, 73, SignedBytes.MAX_POWER_OF_TWO, 65, 5, 81, 74, 5, 87, SignedBytes.MAX_POWER_OF_TWO, 81, 87, 76, SignedBytes.MAX_POWER_OF_TWO, 83, SignedBytes.MAX_POWER_OF_TWO, 5, 66, SignedBytes.MAX_POWER_OF_TWO, 81, 108, 103, 76, 75, 65, SignedBytes.MAX_POWER_OF_TWO, 87, 5, 72, SignedBytes.MAX_POWER_OF_TWO, 81, 77, 74, 65, 120, 122, 107, 86, 93, 118, 113, 123, 122, 109};
    }

    static {
        A03();
    }

    public static IBinder A00(Bundle bundle, String str) {
        if (C5C.A02 >= 18) {
            return bundle.getBinder(str);
        }
        IBinder A012 = A01(bundle, str);
        if (A02[7].charAt(19) == 'S') {
            throw new RuntimeException();
        }
        A02[7] = "R1pRDUJQUvAtWdszhYbqbgNcOgXvgcSI";
        return A012;
    }

    public static IBinder A01(Bundle bundle, String str) {
        Method method = A00;
        String A022 = A02(0, 10, 89);
        if (method == null) {
            try {
                Method getIBinder = Bundle.class.getMethod(A02(88, 10, 111), String.class);
                A00 = getIBinder;
                Method getIBinder2 = A00;
                getIBinder2.setAccessible(true);
                method = A00;
            } catch (NoSuchMethodException e) {
                AbstractC07214g.A09(A022, A02(52, 36, 85), e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            AbstractC07214g.A09(A022, A02(10, 42, 26), e2);
            return null;
        }
    }
}
