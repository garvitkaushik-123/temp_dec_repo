package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.cz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1700cz {
    public static byte[] A03;
    public final int A00;
    public final String A01;
    public final String A02;

    static {
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 76);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{-88, -73, -80, -80, -45, -53, -53, -55, -42, -74, -49, -62, -61, -51, -58, -127, -43, -48, -127, -60, -45, -58, -62, -43, -58, -127, -62, -59, -59, -54, -43, -54, -48, -49, -62, -51, -86, -49, -57, -48, -28, -25, -30, -26, -11, -24, -28, -9, -20, -7, -24, -30, -9, -4, -13, -24, -44, -41, -46, -39, -30, -27, -32, -44, -25, -46, -25, -20, -29, -40, Ascii.DLE, 19, Ascii.SO, 33, Ascii.DC4, 32, 36, Ascii.DC4, 34, 35, Ascii.SO, Ascii.CAN, 19, -26, -11, -18, -39, -35, -47, -41, -43, -6, -19, -24, -23, -13};
    }

    public C1700cz(String str, String str2, int i) {
        String A01;
        this.A02 = str;
        this.A00 = i;
        if (!TextUtils.isEmpty(str2)) {
            A01 = A01(91, 5, 56);
        } else {
            A01 = A01(86, 5, 36);
        }
        this.A01 = A01;
    }

    private C1342Te A00(String str) {
        C1342Te c1342Te = new C1342Te(str);
        c1342Te.A07(A02());
        c1342Te.A05(1);
        return c1342Te;
    }

    private JSONObject A02() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A01(56, 14, 39), this.A00);
            jSONObject.put(A01(70, 13, 99), this.A02);
            jSONObject.put(A01(40, 16, 55), this.A01);
        } catch (JSONException e) {
            Log.w(A01(0, 9, 24), A01(9, 31, 21), e);
        }
        return jSONObject;
    }

    public final void A04(int i, String str) {
        C1925ge sdkContext = T7.A00();
        if (sdkContext != null) {
            sdkContext.A08().ABC(A01(83, 3, 54), i, A00(str));
        }
    }
}
