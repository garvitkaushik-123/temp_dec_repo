package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.jT, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2088jT extends NQ implements Serializable {
    public static byte[] A0E = null;
    public static final long serialVersionUID = 3751287062553772011L;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public boolean A08;
    public boolean A09;
    public final List<AbstractC2094jd> A0D;
    public final ArrayList<Integer> A0C = new ArrayList<>();
    public boolean A0A = false;
    public boolean A07 = false;
    public boolean A06 = false;
    public String A05 = A02(280, 2, 22);
    public final String A0B = UUID.randomUUID().toString();

    static {
        A05();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 37);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{93, 88, 79, 117, 126, 119, Byte.MAX_VALUE, 120, 73, 102, 119, 100, 119, 123, 101, 17, Ascii.SUB, 19, Ascii.ESC, Ascii.FS, Ascii.ETB, Ascii.SYN, 45, 19, Ascii.SYN, 1, 45, 17, Ascii.GS, 7, Ascii.FS, 6, 54, Base64.padSymbol, 52, 60, 59, 48, 49, 10, 52, 49, 38, 10, 56, 52, 45, 10, 49, 32, 39, 52, 33, 60, 58, 59, 73, 66, 75, 67, 68, 79, 78, 117, 75, 78, 89, 117, 92, 75, 88, 67, 79, 68, 94, 74, 65, 72, SignedBytes.MAX_POWER_OF_TWO, 71, SignedBytes.MAX_POWER_OF_TWO, 71, 78, 118, 79, 70, 91, 74, 76, 118, 95, SignedBytes.MAX_POWER_OF_TWO, 76, 94, 118, 93, SignedBytes.MAX_POWER_OF_TWO, 68, 76, 90, 110, 101, 111, 84, 104, 106, 121, 111, 84, 106, 126, Byte.MAX_VALUE, 100, 84, 104, 103, 100, 120, 110, 84, Byte.MAX_VALUE, 98, 102, 110, 118, 113, 123, 122, 103, SignedBytes.MAX_POWER_OF_TWO, 107, 112, SignedBytes.MAX_POWER_OF_TWO, 109, 122, 111, 112, 109, 107, SignedBytes.MAX_POWER_OF_TWO, 115, 112, 126, 123, 122, 123, 65, 86, 67, 92, 65, 71, 108, 85, 90, 65, SignedBytes.MAX_POWER_OF_TWO, 71, 108, 86, 80, 67, 94, 108, 92, 93, 95, 74, Ascii.FF, Ascii.ESC, Ascii.SO, 17, Ascii.FF, 10, 33, Ascii.CAN, Ascii.ETB, Ascii.FF, Ascii.CR, 10, 33, Ascii.ETB, 19, Ascii.SO, Ascii.FF, Ascii.ESC, Ascii.CR, Ascii.CR, Ascii.ETB, 17, Ascii.DLE, 33, 17, Ascii.DLE, Ascii.DC2, 7, 17, 10, Ascii.CR, Ascii.NAK, Base64.padSymbol, 17, 7, 1, Ascii.CR, Ascii.FF, 6, Base64.padSymbol, 3, 6, Base64.padSymbol, Ascii.CR, Ascii.FF, Base64.padSymbol, 3, 6, Base64.padSymbol, Ascii.DLE, 7, Ascii.DC2, Ascii.CR, Ascii.DLE, Ascii.SYN, Ascii.VT, Ascii.FF, 5, Ascii.SO, Ascii.NAK, Ascii.DC2, 10, 34, Ascii.SO, Ascii.CAN, Ascii.RS, Ascii.DC2, 19, Ascii.EM, 34, Ascii.FS, Ascii.EM, 34, Ascii.DC2, 19, 34, Ascii.VT, Ascii.DC4, Ascii.EM, Ascii.CAN, Ascii.DC2, 34, Ascii.CR, 17, Ascii.FS, 4, Ascii.US, Ascii.FS, Ascii.RS, Ascii.SYN, 34, Ascii.CAN, Ascii.SI, Ascii.SI, Ascii.DC2, Ascii.SI, 3, 0, Ascii.FS, Ascii.EM, 4, 47, Ascii.SYN, Ascii.US, 2, 19, Ascii.NAK, 47, 6, Ascii.EM, Ascii.NAK, 7, 72, 78};
    }

    public C2088jT(List<AbstractC2094jd> list) {
        this.A0D = list;
    }

    public static C2088jT A00(JSONObject jSONObject, C1929gi c1929gi) throws JSONException {
        return A01(jSONObject, c1929gi, false);
    }

    public static C2088jT A01(JSONObject jSONObject, C1929gi c1929gi, boolean z) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(A02(0, 3, 25));
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            if (z) {
                arrayList.add(C08067n.A00(jSONArray.getJSONObject(i), c1929gi));
            } else {
                arrayList.add(C08047l.A00(jSONArray.getJSONObject(i), c1929gi));
            }
        }
        C2088jT c2088jT = new C2088jT(arrayList);
        JSONObject chainingParams = jSONObject.getJSONObject(A02(3, 12, 51));
        c2088jT.A05 = chainingParams.toString();
        c2088jT.A01 = chainingParams.optInt(A02(15, 17, 87), arrayList.size());
        c2088jT.A04 = chainingParams.optInt(A02(32, 24, 112), 0);
        c2088jT.A02 = chainingParams.optInt(A02(100, 24, 46), 0);
        c2088jT.A03 = chainingParams.optInt(A02(Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, 22, 58), 0);
        c2088jT.A09 = chainingParams.optBoolean(A02(Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, 38, 88), true);
        c2088jT.A08 = chainingParams.optBoolean(A02(196, 30, 71), true);
        c2088jT.A00 = chainingParams.optInt(A02(56, 19, 15), 2);
        c2088jT.A1P(chainingParams);
        c2088jT.A0A = chainingParams.optBoolean(A02(264, 16, 85), false);
        c2088jT.A07 = chainingParams.optBoolean(A02(168, 28, 91), false);
        c2088jT.A06 = chainingParams.optBoolean(A02(146, 22, 22), false);
        JSONArray optJSONArray = chainingParams.optJSONArray(A02(75, 25, 12));
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                c2088jT.A0C.add(Integer.valueOf(optJSONArray.optInt(i2, 0)));
            }
        }
        return c2088jT;
    }

    @Override // com.instagram.common.viewpoint.core.NQ
    public final int A0o() {
        return 2;
    }

    @Override // com.instagram.common.viewpoint.core.NQ
    public final int A0p() {
        return this.A04 + this.A02;
    }

    public final int A22() {
        return this.A00;
    }

    public final int A23() {
        return this.A01;
    }

    public final int A24() {
        return this.A02;
    }

    public final int A25() {
        return this.A03;
    }

    public final AbstractC2094jd A26() {
        if (!this.A0D.isEmpty()) {
            return this.A0D.get(0);
        }
        return null;
    }

    public final AbstractC2094jd A27(int i) {
        return this.A0D.get(i);
    }

    public final String A28() {
        return this.A0B;
    }

    public final String A29() {
        return this.A05;
    }

    public final String A2A() {
        AbstractC2094jd firstAdDataBundle = A26();
        if (firstAdDataBundle != null) {
            return firstAdDataBundle.A2E();
        }
        return null;
    }

    public final ArrayList<Integer> A2B() {
        return this.A0C;
    }

    public final void A2C(int i) {
        this.A0D.remove(i);
        this.A01--;
    }

    public final boolean A2D() {
        return this.A00 == 0;
    }

    public final boolean A2E() {
        return this.A06;
    }

    public final boolean A2F() {
        return this.A07;
    }

    public final boolean A2G() {
        return this.A08;
    }

    public final boolean A2H() {
        return this.A09;
    }

    public final boolean A2I() {
        return this.A0A;
    }

    public final boolean A2J(int i) {
        return i >= 0 && i < this.A0D.size();
    }
}
