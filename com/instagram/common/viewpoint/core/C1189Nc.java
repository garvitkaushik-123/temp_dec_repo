package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.io.Serializable;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Nc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1189Nc implements Serializable {
    public static byte[] A04 = null;
    public static final long serialVersionUID = -4041915335826065133L;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;

    static {
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{-3, 4, -5, -5, -21, -24, -30};
    }

    public C1189Nc(String str, String str2, JSONObject jSONObject, String str3) {
        this.A03 = A01(str);
        this.A02 = A01(str2);
        this.A00 = A01(str3);
        this.A01 = A02(jSONObject);
    }

    public static String A01(String str) {
        if (A00(0, 4, 65).equalsIgnoreCase(str)) {
            return A00(0, 0, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        }
        return str;
    }

    private String A02(JSONObject jSONObject) {
        String A00 = A00(0, 0, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        if (jSONObject == null) {
            return A00;
        }
        return jSONObject.optString(A00(4, 3, 40), A00);
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final boolean A06() {
        return !TextUtils.isEmpty(this.A01);
    }
}
