package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class NZ {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 78);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Ascii.CAN, Ascii.SUB, 9, Ascii.DC4, Ascii.SO, 8, Ascii.RS, Ascii.ETB, 100, 117, 102, 103, 125, 122, 115, 85, 74, 71, 70, 76, 124, 86, 81, 79};
    }

    public static List<NR> A01(JSONArray jSONArray, JSONObject jSONObject, C1929gi c1929gi, InterfaceC1191Ne interfaceC1191Ne) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (i == 0) {
                    A03(jSONObject2, jSONObject);
                }
                NR A002 = NR.A00(jSONObject2);
                interfaceC1191Ne.A3y(A002, jSONObject2);
                arrayList.add(A002);
            } catch (JSONException e) {
                c1929gi.A08().ABC(A00(8, 7, 90), AbstractC1341Td.A2B, new C1342Te(e));
            }
        }
        return arrayList;
    }

    public static void A03(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!next.equals(A00(15, 9, 109)) && !next.equals(A00(0, 8, 53)) && !jSONObject.has(next)) {
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
    }
}
