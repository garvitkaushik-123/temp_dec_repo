package com.instagram.common.viewpoint.core;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Nn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1200Nn {
    public static byte[] A00;

    static {
        A0H();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 121);
        }
        return new String(copyOfRange);
    }

    public static void A0H() {
        A00 = new byte[]{Ascii.SI, 56, 59, 63, 49, -20, Ascii.CR, 48, 57, 101, 100, 106, 95, 100, 107, 91, Ascii.SYN, 77, 87, 106, 89, 94, 95, 100, 93, 1, 45, 44, 50, 39, 44, 51, 35, -34, 39, 44, -34, Ascii.EM, 49, 35, 33, 49, Ascii.ESC, -34, 50, 45, -34, Ascii.EM, Ascii.US, 46, 46, Ascii.ESC, 0, 44, 43, 49, 38, 43, 50, 34, -35, 49, 44, -35, Ascii.CAN, Ascii.RS, 45, 45, Ascii.SUB, -40, 4, 3, 9, -2, 3, 10, -6, -75, Ascii.FF, -10, 9, -8, -3, -2, 3, -4, -75, 9, 4, -75, 7, -6, -8, -6, -2, Ascii.VT, -6, -75, -10, 3, -75, -2, 3, -62, -4, -10, 2, -6, -75, 7, -6, Ascii.FF, -10, 7, -7, -65, -21, -22, -16, -27, -22, -15, -31, -100, -13, -35, -16, -33, -28, -27, -22, -29, -100, -16, -21, -100, -18, -31, -33, -31, -27, -14, -31, -100, -9, -19, -15, -35, -22, -16, -27, -16, -11, -7, -9, -33, -15, -18, -18, -31, -22, -33, -11, -7, -42, -9, -20, -11, -16, -11, -18, -89, -16, -11, -89, -30, -6, -20, -22, -6, -28, -6, 40, 73, 62, 71, 66, 71, SignedBytes.MAX_POWER_OF_TWO, -7, 66, 71, 7, 7, 7, -24, -5, Ascii.CR, -9, 8, -6, -74, -1, 4, -74, -15, 9, -5, -7, 9, -13, 9, Ascii.SUB, 50, 48, 55, 68, 92, 90, 97, 17, 82, 85, Ascii.SI, 39, 37, 44, -36, Ascii.GS, 32, -36, 37, 42, -36, Ascii.ETB, 47, 33, Ascii.US, 47, Ascii.EM, 41, 70, 69, 68, 73, 69, 72, 59, 58, 45, 65, SignedBytes.MAX_POWER_OF_TWO, 59, 47, 56, 53, 47, 55, 43, 53, 58, 43, 68, 4, Ascii.CAN, Ascii.ETB, Ascii.DC2, 6, Ascii.SI, Ascii.FF, 6, Ascii.SO, 2, Ascii.DC2, 19, 8, 17, Ascii.FF, 17, 10, 65, 74, 77, 81, 67, Base64.padSymbol, 63, 66, -23, -11, -12, -6, -17, -12, -5, -21, -27, -6, -11, -27, -25, -10, -10, -31, -19, -20, -14, -25, -20, -13, -29, -35, -14, -19, -35, -33, -18, -18, -35, -25, -20, -35, -10, Ascii.SO, Ascii.SUB, Ascii.EM, Ascii.US, Ascii.DC4, Ascii.EM, 32, Ascii.DLE, 10, 34, Ascii.FF, Ascii.US, Ascii.SO, 19, Ascii.DC4, Ascii.EM, Ascii.DC2, 32, 44, 43, 49, 38, 43, 50, 34, Ascii.FS, 52, Ascii.RS, 49, 32, 37, 38, 43, 36, Ascii.FS, 35, 44, 47, Ascii.FS, 47, 34, 52, Ascii.RS, 47, 33, 95, 93, 102, 93, 106, 97, 91, 87, 106, 93, 111, 89, 106, 92, 17, Ascii.SI, Ascii.CAN, Ascii.SI, Ascii.FS, 19, Ascii.CR, 9, Ascii.RS, Ascii.SI, 34, Ascii.RS, -8, -2, -18, -23, -13, -19, -7, -8, -23, -3, -2, 3, -10, -17, 88, 94, 78, 73, 94, 79, 98, 94, 98, 85, 103, 81, 98, 84, 79, 89, 94, 79, 104, 1, -7, -9, -2, -6, -14, -16, -9, -26, -24, -21, 68, 60, 58, 65, 48, 58, 63, 48, 73, 44, 41, 40, 39, 44, 40, 43, Ascii.RS, Ascii.GS};
    }

    public static C1196Nj A00(JSONObject jSONObject) {
        return new C1195Ni().A06(A0A(jSONObject)).A07(A09(jSONObject)).A05(A0B(jSONObject)).A04(A06(jSONObject)).A08();
    }

    public static C1205Ns A01(JSONObject jSONObject) {
        return new C1204Nr().A0F(A0D(jSONObject)).A0J(A0G(jSONObject)).A0I(A0F(jSONObject)).A0H(A0E(jSONObject)).A0E(A08(jSONObject)).A0D(A07(jSONObject)).A0A(jSONObject.optInt(A02(394, 14, 17), 0)).A0G(A0C(jSONObject)).A0C(A05(jSONObject)).A0B(A04(jSONObject)).A0K();
    }

    public static String A03(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(240, 9, 93);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(447, 9, 64), A02);
    }

    public static String A04(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(164, 18, 14);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(249, 14, 83), A02);
    }

    public static String A05(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(182, 13, 96);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(263, 17, 42), A02);
    }

    public static String A06(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(0, 8, 83);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(280, 8, 101), A02);
    }

    public static String A07(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(25, 27, 69);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(303, 20, 5), A02);
    }

    public static String A08(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(52, 17, 68);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(288, 15, 13), A02);
    }

    public static String A09(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(115, 49, 3);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(340, 28, 68), A02);
    }

    public static String A0A(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(69, 46, 28);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(368, 14, 127), A02);
    }

    public static String A0B(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(8, 17, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(323, 17, 50), A02);
    }

    public static String A0C(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(0, 0, 60);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(408, 8, 113), A02);
    }

    public static String A0D(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(195, 17, 29);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(TTAdConstant.PACKAGE_NAME_CODE, 11, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), A02);
    }

    public static String A0E(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 17, 67);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(438, 9, 88), A02);
    }

    public static String A0F(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(Sdk.SDKError.Reason.AD_RESPONSE_INVALID_TEMPLATE_TYPE_VALUE, 7, 120);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(431, 7, 14), A02);
    }

    public static String A0G(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A02(382, 12, 49));
        String A02 = A02(212, 4, 78);
        return optJSONObject == null ? A02 : optJSONObject.optString(A02(427, 4, 21), A02);
    }
}
