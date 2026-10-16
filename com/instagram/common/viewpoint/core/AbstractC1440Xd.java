package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Xd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1440Xd {
    public static byte[] A00;
    public static String[] A01 = {"k0KWJrtOeyRtx2YSOmZ2S9sZBWRzRtzR", "FhSJWxdRwKLMP9JOn6q1b2qMo", "vd4", "prNs3YfRmQWdH9Q7PHydrBddu2xVDtuC", "TQMlXyI0yqbHfDCacucNcvBBb28", "i9ckL4hGn3OwY3VfnpnVreAjs5dC9GVS", "Iva6FryQGZnTk8EX70gQNR0ykk5ruyon", ""};

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{9, Ascii.DC2, Ascii.VT, Ascii.VT};
    }

    static {
        A05();
    }

    public static String A01(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                if (A01[7].length() == 0) {
                    A01[6] = "jcZWkwS564qIWYGPRhtwMiRcu2uJOsmN";
                    if (!hasNext) {
                        break;
                    }
                    Map.Entry<String, String> next = it.next();
                    try {
                        jSONObject.put(next.getKey(), next.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return jSONObject.toString();
    }

    public static String A02(JSONObject jSONObject, String str) {
        return A03(jSONObject, str, null);
    }

    public static String A03(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString(str, str2);
        String value = A00(0, 4, 26);
        if (value.equals(optString)) {
            return null;
        }
        return optString;
    }

    public static List<String> A04(JSONArray jSONArray) {
        if (jSONArray == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }
}
