package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.api.NativeAdImageApi;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Vb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1391Vb implements NativeAdImageApi {
    public static byte[] A03;
    public static String[] A04 = {"", "VJJRZ", "cZdb6ZeXWXZ9VUL9rLCw743uVGQUpxOO", "", "", "", "WdMLtMmdaAcYUdhsZ0J", "wLMa4MLdUcqpCAe5uR"};
    public final int A00;
    public final int A01;
    public final String A02;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A04;
            if (strArr[0].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A04[7] = "EG8fSiCn7c4UcgqXgi";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            byte b = (byte) ((copyOfRange[i4] ^ i3) ^ 66);
            if (A04[7].length() != 18) {
                String[] strArr2 = A04;
                strArr2[4] = "";
                strArr2[3] = "";
                copyOfRange[i4] = b;
                i4 += 0;
            } else {
                A04[7] = "dmTYix46cwH5S26Htz";
                copyOfRange[i4] = b;
                i4++;
            }
        }
    }

    public static void A02() {
        A03 = new byte[]{118, 123, 119, 121, 118, 106, 124, 123, 101, 72, 86, 91, 75, 87};
    }

    static {
        A02();
    }

    public C1391Vb(String str, int i, int i2) {
        this.A02 = str;
        this.A01 = i;
        this.A00 = i2;
    }

    public static C1391Vb A00(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null || (optString = jSONObject.optString(A01(6, 3, 75))) == null) {
            return null;
        }
        return new C1391Vb(optString, jSONObject.optInt(A01(9, 5, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), 0), jSONObject.optInt(A01(0, 6, 92), 0));
    }

    @Override // com.facebook.ads.internal.api.NativeAdImageApi
    public final int getHeight() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.NativeAdImageApi
    public final String getUrl() {
        return this.A02;
    }

    @Override // com.facebook.ads.internal.api.NativeAdImageApi
    public final int getWidth() {
        return this.A01;
    }
}
