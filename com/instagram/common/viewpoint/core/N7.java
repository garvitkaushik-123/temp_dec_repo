package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public final class N7 {
    public static byte[] A03;
    public static String[] A04 = {"yonrCQ0uoeCYCSmT5ejKLJLtf9VOp321", "NDuBqnzzJqzb1WeHMragxAHoyIt26Von", "hWL4zdMk8yywijkAtqHNVn2pZmfj34f9", "9i7qyia1evnFwuCuocWilq3mxIKRQ8Gt", "sdkV7vC", "3a", "fP", "wcot"};
    public final LinkedHashSet<String> A01 = new LinkedHashSet<>();
    public JSONObject A00 = new JSONObject();
    public final AtomicReference<String> A02 = new AtomicReference<>(A01(0, 2, 32));

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 66);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-67, -65, -63, -65, -50, -3, 6, -5, 10, 17, 8, Ascii.FF, -3, -4, -9, -7, -4, -9, 1, -4, -9, 7, 10, 1, -1, 1, 6, -7, 4, -19, -10, -21, -6, 1, -8, -4, -19, -20, -25, -15, -20, Ascii.EM, Ascii.CR, 36, Ascii.VT, Ascii.SI, Ascii.CR, Ascii.FS, Ascii.FS, 17, Ascii.DLE, Ascii.VT, Ascii.CR, Ascii.RS, Ascii.RS, Ascii.CR, 37, Ascii.VT, Ascii.CAN, 17, Ascii.SUB, 19, 32, Ascii.DC4, 47, 35, 35, 53, 50, 50, 37, 46, 35, 37, 51, -1, -12, 1, -8, -2, -13, 37, Ascii.FS, 34, 33, Ascii.FF, Ascii.FS, Ascii.DLE, Ascii.DLE, 34, Ascii.US, Ascii.US, Ascii.DC2, Ascii.ESC, Ascii.DLE, Ascii.DC2, Ascii.FF, 32, Ascii.DC2, Ascii.DLE, 32, Ascii.RS, Ascii.NAK, Ascii.ESC, Ascii.SUB, 5, Ascii.SYN, Ascii.VT, Ascii.CAN, Ascii.SI, Ascii.NAK, 10};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized void A0A(@Nullable String str) throws JSONException, C1342Te {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                this.A00 = new JSONObject(str);
                HashMap hashMap = new HashMap();
                Iterator<String> keys = this.A00.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (this.A00.get(next) instanceof String) {
                        hashMap.put(next, A00(next, new JSONObject((String) this.A00.get(next))));
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    this.A00.put((String) entry.getKey(), entry.getValue());
                }
            }
        }
    }

    static {
        A02();
    }

    private final synchronized C1192Nf A00(String str, JSONObject jSONObject) throws JSONException, C1342Te {
        C1192Nf frequencyCappingData;
        if (str.equals(jSONObject.optString(A01(29, 12, 70), null))) {
            frequencyCappingData = new C1192Nf(str);
            A03(frequencyCappingData, jSONObject);
        } else {
            C1342Te c1342Te = new C1342Te(new IllegalArgumentException());
            jSONObject.put(A01(5, 24, 86), str);
            c1342Te.A07(jSONObject);
            c1342Te.A05(1);
            throw c1342Te;
        }
        return frequencyCappingData;
    }

    private void A03(C1192Nf c1192Nf, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt(A01(75, 6, 77));
        int optInt2 = jSONObject.optInt(A01(101, 11, 100));
        int maxCappedArrayLength = jSONObject.optInt(A01(41, 23, 106), 50);
        long optLong = jSONObject.optLong(A01(2, 3, 28));
        String A01 = A01(64, 11, 126);
        if (jSONObject.has(A01)) {
            c1192Nf.A06((JSONArray) jSONObject.get(A01));
        }
        String A012 = A01(81, 20, 107);
        if (jSONObject.has(A012)) {
            int cappingTimeSecs = jSONObject.optInt(A012);
            c1192Nf.A04(cappingTimeSecs);
        }
        c1192Nf.A05(optInt, optInt2, optLong, maxCappedArrayLength);
    }

    public final String A04() {
        String list = this.A02.get();
        if (list != null) {
            return list;
        }
        if (A04[0].charAt(21) != 'J') {
            throw new RuntimeException();
        }
        A04[7] = "Yd8WV87KlA8AS9IbyfadEkj";
        return A01(0, 2, 32);
    }

    public final synchronized JSONObject A05() {
        return this.A00;
    }

    public final synchronized void A06() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.A01.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        this.A02.set(jSONArray.toString());
    }

    public final synchronized void A07(String str) {
        if (this.A01.size() >= C1192Nf.A00()) {
            Iterator<String> it = this.A01.iterator();
            if (it.hasNext()) {
                this.A01.remove(it.next());
            }
        }
        this.A01.add(str);
        C1326So.A03();
    }

    public final synchronized void A08(@Nullable String str) throws JSONException {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length() && i < C1192Nf.A00(); i++) {
                    this.A01.add(jSONArray.getString(i));
                }
            }
        }
    }

    public final synchronized void A09(String str) {
        this.A01.remove(str);
        C1326So.A03();
    }

    public final synchronized void A0B(JSONObject jSONObject) throws JSONException {
        C1192Nf frequencyCappingData;
        String optString = jSONObject.optString(A01(29, 12, 70), null);
        if (optString == null) {
            return;
        }
        if (this.A00.has(optString) && (this.A00.get(optString) instanceof C1192Nf)) {
            frequencyCappingData = (C1192Nf) this.A00.get(optString);
        } else {
            frequencyCappingData = new C1192Nf(optString);
        }
        A03(frequencyCappingData, jSONObject);
        this.A00.put(optString, frequencyCappingData);
    }
}
