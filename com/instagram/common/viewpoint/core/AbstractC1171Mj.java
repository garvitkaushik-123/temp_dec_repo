package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Mj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract /* synthetic */ class AbstractC1171Mj {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{9, Ascii.FS, 19, 3, Ascii.DLE, 9, Ascii.DC2, 17, 36, Ascii.ESC, Ascii.VT, Ascii.RS, 17, Ascii.DLE, Ascii.NAK, Ascii.RS};
    }

    public static long A00(InterfaceC1172Mk interfaceC1172Mk) {
        return interfaceC1172Mk.A6h(A02(0, 7, 111), -1L);
    }

    public static Uri A01(InterfaceC1172Mk interfaceC1172Mk) {
        String A6j = interfaceC1172Mk.A6j(A02(7, 9, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), null);
        if (A6j == null) {
            return null;
        }
        return Uri.parse(A6j);
    }
}
