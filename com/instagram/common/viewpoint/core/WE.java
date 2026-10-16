package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public final class WE {
    public static byte[] A00;
    public static String[] A01 = {"1xbaBrS", "A5o8L0K", "NCBBTtQ91bL4qNkC9", "VOiFjhrLKrSiOl", "IzdWV2mN1IZOPy8q", "dzpcam", "yMP3JjbsUfzn40YA", "FhpQzKItQmfQ6pj5K9dUgRwf2x"};
    public static final WE A02;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 36);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{118, 115, 72, 101, 114, 103, 120, 101, 99, 126, 121, 112, 72, 116, 120, 121, 113, 126, 112, 77, 72, 77, 92, 88, 73, 94, Ascii.CAN, Ascii.GS, 10, 100, 107, 90, 115, 100, 105, 108, 97, 100, 113, 108, 106, 107, 90, 112, 112, 108, 97, 44, 46, 44, 39, 42, 105, 98, 107, 99, 100, 85, 122, 107, 120, 107, 103, 121, 39, 43, 32, 33, 122, Byte.MAX_VALUE, 106, Byte.MAX_VALUE, Ascii.DLE, Ascii.NAK, 0, Ascii.NAK, 59, Ascii.SYN, Ascii.RS, 17, Ascii.ETB, 0, 84, Ascii.GS, 7, 84, Ascii.SUB, 1, Ascii.CAN, Ascii.CAN, 108, 105, 124, 105, 87, 101, 103, 108, 109, 100, 87, 124, 113, 120, 109, 120, 121, 126, 105, 123, 67, 122, 105, 114, 114, 121, 112, 67, Byte.MAX_VALUE, 115, 114, 122, 117, 123, Ascii.SUB, Ascii.ESC, Ascii.CAN, Ascii.ETB, Ascii.DLE, Ascii.ETB, 10, Ascii.ETB, 17, Ascii.DLE, Ascii.CAN, Ascii.SI, Ascii.SI, Ascii.DC2, Ascii.SI, 75, 72, 76, 89, 88, 95, 72, 114, 78, 66, 67, 75, 68, 74, 82, 88, 85, 71, 92, 107, 87, 91, 90, 82, 93, 83, 46, 45, 37, Ascii.GS, 33, 55, 48, 48, 39, 44, 54, Ascii.GS, 36, 55, 44, 44, 39, 46, 89, 81, 71, 71, 85, 83, 81, 121, 101, 104, 106, 108, 100, 108, 103, 125, 122, 115, 100, 107, 95, 99, 97, 99, 104, 101, 41, 47, 60, 62, 54, 56, 47, 46, 87, 90, 83, 70};
    }

    static {
        A05();
        A02 = new WE();
    }

    public static synchronized WE A00() {
        WE we;
        synchronized (WE.class) {
            we = A02;
        }
        return we;
    }

    private RG A01(C1929gi c1929gi, JSONObject data, long j) throws JSONException {
        JSONArray placements = data.getJSONArray(A04(190, 10, 45));
        JSONObject jSONObject = placements.getJSONObject(0);
        C1361Tx A002 = C1361Tx.A00(jSONObject.getJSONObject(A04(Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 10, 90)));
        String optString = jSONObject.optString(A04(TsExtractor.TS_STREAM_TYPE_DTS_UHD, 14, 9));
        String A04 = A04(47, 5, 107);
        String str = null;
        String flashConfig = jSONObject.has(A04) ? jSONObject.optString(A04) : null;
        String A042 = A04(200, 9, 36);
        String optString2 = jSONObject.has(A042) ? jSONObject.optString(A042) : null;
        String adReportingConfig = jSONObject.optString(A04(0, 19, 51));
        String A043 = A04(153, 12, 16);
        String cache = jSONObject.has(A043) ? jSONObject.optString(A043) : null;
        C1360Tw c1360Tw = new C1360Tw(A002, optString, adReportingConfig, cache, flashConfig, optString2, A06(jSONObject));
        String A044 = A04(26, 3, 93);
        if (jSONObject.has(A044)) {
            JSONArray jSONArray = jSONObject.getJSONArray(A044);
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                VK.A06(c1929gi, jSONObject2, j, str);
                String optString3 = jSONObject2.optString(A04(19, 7, 8));
                String optString4 = jSONObject2.optString(A04(90, 15, 44));
                JSONObject ad = jSONObject2.optJSONObject(A04(68, 4, 58));
                JSONArray optJSONArray = jSONObject2.optJSONArray(A04(209, 8, Sdk.SDKError.Reason.TPAT_ERROR_VALUE));
                if (ad != null) {
                    c1360Tw.A0F(new C1358Tu(optString3, optString4, ad, optJSONArray));
                } else {
                    InterfaceC1155Lt A0F = c1929gi.A0F();
                    int errorCode = AdErrorType.UNKNOWN_ERROR.getErrorCode();
                    String[] strArr = A01;
                    if (strArr[0].length() != strArr[1].length()) {
                        throw new RuntimeException();
                    }
                    A01[7] = "vhqatTRLHh1uNEmkPYajEb8nOj";
                    A0F.A5g(errorCode, A04(72, 18, 80));
                }
                i++;
                str = null;
            }
        }
        String A045 = A04(52, 12, 46);
        if (jSONObject.has(A045)) {
            c1360Tw.A0G(jSONObject.getJSONObject(A045));
        }
        String anValidationUuid = data.optString(A04(29, 18, 33));
        return new RG(c1360Tw, anValidationUuid);
    }

    private R4 A02(JSONObject jSONObject) {
        return new R4(jSONObject.optString(A04(183, 7, 16), A04(0, 0, 92)), jSONObject.optInt(A04(64, 4, 96), 0), null);
    }

    private R4 A03(JSONObject jSONObject) {
        String A04 = A04(200, 9, 36);
        String A042 = A04(47, 5, 107);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray(A04(190, 10, 45)).getJSONObject(0);
            C1361Tx A002 = C1361Tx.A00(jSONObject2.getJSONObject(A04(Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 10, 90)));
            String optString = jSONObject2.optString(A04(TsExtractor.TS_STREAM_TYPE_DTS_UHD, 14, 9));
            String optString2 = jSONObject2.has(A042) ? jSONObject2.optString(A042) : null;
            String cache = jSONObject2.has(A04) ? jSONObject2.optString(A04) : null;
            String featureConfig = jSONObject2.optString(A04(0, 19, 51));
            return new R4(jSONObject.optString(A04(183, 7, 16), A04(0, 0, 92)), jSONObject.optInt(A04(64, 4, 96), 0), new C1360Tw(A002, optString, featureConfig, null, optString2, cache, A06(jSONObject2)));
        } catch (JSONException unused) {
            return A02(jSONObject);
        }
    }

    public static boolean A06(JSONObject jSONObject) throws JSONException {
        String A04 = A04(105, 19, 56);
        if (jSONObject.has(A04)) {
            return jSONObject.getJSONObject(A04).optBoolean(A04(165, 18, 102), false);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final WG A07(C1929gi c1929gi, String str, long j) throws JSONException {
        char c;
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(A04(Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 4, 7));
            int hashCode = optString.hashCode();
            String A04 = A04(134, 5, 89);
            switch (hashCode) {
                case 96432:
                    if (optString.equals(A04(26, 3, 93))) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 96784904:
                    if (optString.equals(A04)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return A01(c1929gi, jSONObject, j);
                case 1:
                    return A03(jSONObject);
                default:
                    JSONObject jsonResponse = jSONObject.optJSONObject(A04);
                    if (jsonResponse != null) {
                        return A02(jsonResponse);
                    }
                    break;
            }
        }
        return new WG(WF.A04);
    }
}
