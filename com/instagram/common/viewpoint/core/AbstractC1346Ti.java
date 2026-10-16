package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Ti, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1346Ti {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 112);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Ascii.ETB, 52, 60, 60, 50, 53, 60, 123, Ascii.NAK, 62, 47, 44, 52, 41, 48, 123, Ascii.RS, 45, 62, 53, 47, 34, 51, 52, 39, 50, 47, 41, 40, 96, 119, 119, 106, 119, 32, 60, 60, 56, Ascii.ETB, 59, 60, 41, 60, Base64.padSymbol, 59, Ascii.ETB, 43, 39, 44, 45, 98, 105, 120, 123, 99, 126, 103, 41, 56, 32, 53, 54, 56, Base64.padSymbol, 6, 42, 48, 35, 60, 55, 48, 37, 54, 48, Ascii.ESC, 48, 45, 41, 33, 40, 45, 49, 50, 60, 57, 2, 46, 52, 39, 56};
    }

    public static JSONObject A01(T8 t8, long j, long j2, long j3, long j4, int i, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(A00(69, 10, 52), j);
                try {
                    jSONObject.put(A00(21, 8, 54), j2 / 1000.0d);
                    try {
                        jSONObject.put(A00(57, 12, 41), j3);
                        try {
                            jSONObject.put(A00(79, 11, 45), j4);
                        } catch (JSONException e) {
                            e = e;
                        }
                    } catch (JSONException e2) {
                        e = e2;
                    }
                } catch (JSONException e3) {
                    e = e3;
                }
            } catch (JSONException e4) {
                e = e4;
            }
        } catch (JSONException e5) {
            e = e5;
        }
        try {
            jSONObject.put(A00(34, 16, 56), i);
            if (exc != null) {
                jSONObject.put(A00(29, 5, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), exc.getMessage());
            }
        } catch (JSONException e6) {
            e = e6;
            t8.A08().A4I(e);
            return jSONObject;
        }
        return jSONObject;
    }

    public static void A03(T8 t8, long j, long j2, long j3, long j4, int i, Exception exc) {
        C1342Te c1342Te = new C1342Te(A00(0, 21, 43));
        c1342Te.A05(1);
        c1342Te.A07(A01(t8, j, j2, j3, j4, i, exc));
        t8.A08().ACA(A00(50, 7, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), AbstractC1341Td.A20, c1342Te);
    }
}
