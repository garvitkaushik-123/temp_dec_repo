package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class U6 {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 65);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-74, -72, -85, -84, -59, -71, -86, -79, -59, -87, -89, -87, -82, -85, -35, -33, -46, -45, -20, -32, -47, -40, -20, -38, -50, -37, -50, -44, -46, -47, -20, -48, -50, -48, -43, -46, -54, -56, -54, -49, -52, -28, -31, -12, -27, -33, -13, -27, -12, 33, 52, 44, 37, 46, 33, 47, Ascii.ESC, 37, 42, -40, -61, -50, -41, -57};
    }

    public static String A01(C1925ge c1925ge) {
        return WN.A00(c1925ge).getString(A00(0, 14, 37), null);
    }

    public static Map<String, String> A02(C1925ge c1925ge) {
        String sdkCache = WN.A00(c1925ge).getString(A00(14, 22, 76), null);
        if (sdkCache == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(sdkCache);
            HashSet hashSet = new HashSet();
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (jSONObject2.getLong(A00(41, 8, 63)) + (jSONObject2.getInt(A00(49, 10, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE)) * 1000) < System.currentTimeMillis()) {
                    hashSet.add(next);
                } else {
                    hashMap.put(next, jSONObject2.getString(A00(59, 5, 33)));
                }
            }
            if (!hashSet.isEmpty()) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    jSONObject.remove((String) it.next());
                }
                A06(c1925ge, jSONObject);
            }
            return hashMap;
        } catch (JSONException e) {
            c1925ge.A08().ABC(A00(36, 5, 38), AbstractC1341Td.A2U, new C1342Te(e));
            return null;
        }
    }

    public static void A04(C1925ge c1925ge, String str) {
        WN.A00(c1925ge).edit().putString(A00(0, 14, 37), str).apply();
    }

    public static void A05(C1925ge c1925ge, String str) {
        if (str == null) {
            return;
        }
        String sdkCache = WN.A00(c1925ge).getString(A00(14, 22, 76), null);
        try {
            JSONObject jSONObject = sdkCache == null ? new JSONObject() : new JSONObject(sdkCache);
            JSONObject jSONObject2 = new JSONObject(str);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(key);
                jSONObject3.put(A00(41, 8, 63), System.currentTimeMillis());
                jSONObject.put(key, jSONObject3);
            }
            A06(c1925ge, jSONObject);
        } catch (JSONException e) {
            c1925ge.A08().ABC(A00(36, 5, 38), AbstractC1341Td.A2V, new C1342Te(e));
        }
    }

    public static void A06(C1925ge c1925ge, JSONObject jSONObject) {
        WN.A00(c1925ge).edit().putString(A00(14, 22, 76), jSONObject.toString()).apply();
    }
}
