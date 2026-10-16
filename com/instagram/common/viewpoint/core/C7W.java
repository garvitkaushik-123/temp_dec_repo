package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@MetaExoPlayerCustomization(type = {"NEW_CLASS"}, value = "D63737392: Class for performance negative testing")
/* renamed from: com.facebook.ads.redexgen.X.7W, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C7W {
    public static byte[] A01;
    public static String[] A02 = {"uumaDejXtY9QuA71Txc6KqwcrEMmZNPm", "", "Dsya3x18X7BukkIokO15GhTYLGiL2hRr", "RNehmKATQ4InJCkQYMjQTj", "eAq9FO9dhgnzxwHSxHo7MGMv1ckJfF3W", "", "rfJrIe", ""};
    public final Map<Integer, C7V> A00 = new HashMap();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = copyOfRange[i4] ^ i3;
            String[] strArr = A02;
            if (strArr[2].charAt(3) != strArr[0].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "";
            strArr2[7] = "";
            copyOfRange[i4] = (byte) (i5 ^ 1);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{42, 9, Ascii.ESC, Ascii.CR, 36, 9, Ascii.FS, Ascii.CR, 6, Ascii.VT, 17, Ascii.FS, 63, 34, 34, 51, 36, 95, 96, 124, 102, 123, 102, 96, 97, Ascii.FF, 62, 50, 47, 51, 54, 49, 56, Ascii.CR, 62, 43, 58};
    }

    static {
        A01();
    }

    public C7W(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int jitter = 0; jitter < jSONArray.length(); jitter++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(jitter);
                        int i = jSONObject.getInt(A00(17, 8, 14));
                        int samplingRate = jSONObject.getInt(A00(0, 11, 105));
                        int position = jSONObject.getInt(A00(11, 6, 87));
                        this.A00.put(Integer.valueOf(i), new C7V(this, samplingRate, position, jSONObject.getInt(A00(25, 12, 94))));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final C7V A02() {
        if (this.A00.containsKey(0)) {
            return this.A00.get(0);
        }
        return null;
    }
}
