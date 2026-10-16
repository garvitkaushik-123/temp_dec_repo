package com.instagram.common.viewpoint.core;

import android.os.Handler;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.h0, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1947h0 extends AbstractRunnableC1416Wc {
    public static byte[] A01;
    public static String[] A02 = {"QJHZKkwEEt2XAA8qb811yZkloXTxKqNm", "0Eo8hyAH95ZWxpQDtz3kXr2Dg2BAnbpt", "yx1IzqDtrK1i7eGrpZodHZ", "KUuZPkausU2VOaHnsIAk0Hn07pOf06lA", "ddvRVBlQrtqHFM3JEeiDXs23nPXnVLtA", "0N8fJtCAvq63STI6q3YZ9dLrj33X3xUc", "d0kigy9sFkFC2aZLzfYLsKXCuWX9Z7p3", "u6xVOdZhMjB663K3VBvQukbaw71N5v3b"};
    public final /* synthetic */ SN A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE;
            if (A02[2].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[3] = "wsWgA7V3OPhtM2agFx6R9FkGRpDQ8hFC";
            strArr[5] = "5QDbKue07C6BH4ozhF9MSdyiVJUT25MO";
            copyOfRange[i4] = (byte) i5;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{43, 57, 57, 47, 62, 57};
    }

    static {
        A01();
    }

    public C1947h0(SN sn) {
        this.A00 = sn;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        Handler handler;
        JSONObject jSONObject;
        C1335Sx c1335Sx;
        String str;
        String str2;
        try {
            jSONObject = this.A00.A05;
            JSONArray jSONArray = jSONObject.getJSONArray(A00(0, 6, 48));
            for (int i = 0; i < jSONArray.length(); i++) {
                SL assetData = SL.A00(jSONArray.getJSONObject(i));
                this.A00.A09(assetData.A04, assetData);
            }
            c1335Sx = this.A00.A02;
            C1949h2 c1949h2 = new C1949h2(this);
            str = this.A00.A04;
            str2 = this.A00.A03;
            c1335Sx.A0X(c1949h2, new C1328Sq(str, str2));
        } catch (JSONException unused) {
            handler = this.A00.A00;
            handler.post(new C1948h1(this));
        }
    }
}
