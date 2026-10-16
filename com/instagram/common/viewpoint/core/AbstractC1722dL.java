package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.dL, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1722dL {
    public static byte[] A00;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1721dK A00(C1929gi c1929gi, JSONObject jSONObject, C1335Sx c1335Sx, VI vi, C1700cz c1700cz, boolean z) {
        boolean z2;
        String str;
        boolean z3 = z;
        String A01 = A01(101, 3, 41);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String optString = jSONObject.optString(A01(51, 26, 104));
        arrayList3.add(optString);
        if (z3) {
            str = c1335Sx.A0S(optString);
            if (optString.equals(str)) {
                z3 = false;
                z2 = false;
            } else {
                z2 = z3;
            }
        } else {
            z2 = z3;
            str = optString;
        }
        vi.A04(VH.A0P, null);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(A01(92, 4, 49));
            if (optJSONObject != null && optJSONObject.optString(A01) != null) {
                arrayList.add(optJSONObject.optString(A01));
                if (z2) {
                    optJSONObject.put(A01, c1335Sx.A0R(optJSONObject.optString(A01)));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(A01(77, 15, 113));
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString2 = optJSONArray.optString(i);
                    arrayList.add(optString2);
                    if (z2) {
                        optJSONArray.put(i, c1335Sx.A0R(optString2));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(A01(43, 8, 37));
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    A03(arrayList, arrayList2, optJSONArray2.optJSONObject(i2), c1335Sx, z2);
                }
            } else {
                A03(arrayList, arrayList2, jSONObject, c1335Sx, z2);
            }
        } catch (JSONException unused) {
            c1700cz.A04(AbstractC1341Td.A15, A01(0, 43, 35));
        }
        return new C1721dK(jSONObject, str, arrayList, arrayList2, arrayList3, z3);
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 65);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-87, -42, -42, -45, -42, -124, -40, -42, -59, -46, -41, -54, -45, -42, -47, -51, -46, -53, -124, -82, -73, -77, -78, -124, -51, -46, -124, -39, -44, -56, -59, -40, -55, -89, -59, -57, -52, -55, -56, -71, -42, -48, -41, -55, -57, -40, -43, -37, -39, -53, -46, Ascii.CR, 34, Ascii.ETB, 10, Ascii.SYN, Ascii.DC2, Ascii.FF, 8, Ascii.FS, Ascii.CR, Ascii.DC4, 8, Ascii.NAK, 10, 34, Ascii.SO, Ascii.ESC, 8, 17, Ascii.GS, Ascii.SYN, Ascii.NAK, 8, Ascii.RS, Ascii.ESC, Ascii.NAK, Ascii.ETB, 32, Ascii.SYN, 17, Ascii.NAK, 19, 36, Ascii.SYN, 17, Ascii.ESC, Ascii.US, 19, Ascii.EM, Ascii.ETB, 37, -37, -43, -31, -32, -35, -31, -43, -37, -39, -33, -36, -42, -32, -45, -50, -49, -39, -55, -33, -36, -42};
    }

    public static void A03(ArrayList<String> imageUrls, ArrayList<String> videoUrls, JSONObject jSONObject, C1335Sx c1335Sx, boolean z) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(A01(96, 5, 51));
        if (optJSONObject != null) {
            String A01 = A01(101, 3, 41);
            if (optJSONObject.optString(A01) != null) {
                String optString = optJSONObject.optString(A01);
                imageUrls.add(optString);
                if (z) {
                    optJSONObject.put(A01, c1335Sx.A0R(optString));
                }
            }
        }
        String A012 = A01(104, 9, 41);
        if (!TextUtils.isEmpty(jSONObject.optString(A012))) {
            String optString2 = jSONObject.optString(A012);
            videoUrls.add(optString2);
            if (z) {
                jSONObject.put(A012, c1335Sx.A0S(optString2));
            }
        }
    }
}
