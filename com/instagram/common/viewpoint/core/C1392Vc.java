package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.api.NativeAdRatingApi;
import com.google.common.base.Ascii;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Vc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1392Vc implements NativeAdRatingApi {
    public static byte[] A02;
    public static String[] A03 = {"hUjcMotf6J7QgolLzfJFqEdJCj8", "g61DfN6A", "xfoiRdjW7FqaK", "7BIjRnWTmZFI6", "QawwIwJGbW4wV95frp", "JAocLFgZR1eZV5wbskPWRgC49zmLSQ48", "dTzZFi0gHRoFN0fz4IZK", "PRpOn4dc8EeXJ60LxB5o"};
    public final double A00;
    public final double A01;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {Ascii.DC4, 4, 2, Ascii.CR, 6, -68, -89, -78, -69, -85};
        if (A03[0].length() == 23) {
            throw new RuntimeException();
        }
        A03[2] = "JTw9XW";
        A02 = bArr;
    }

    static {
        A02();
    }

    public C1392Vc(double d, double d2) {
        this.A01 = d;
        this.A00 = d2;
    }

    public static C1392Vc A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble(A01(5, 5, 17), 0.0d);
        double optDouble2 = jSONObject.optDouble(A01(0, 5, 108), 0.0d);
        if (optDouble == 0.0d || optDouble2 == 0.0d) {
            return null;
        }
        return new C1392Vc(optDouble, optDouble2);
    }

    @Override // com.facebook.ads.internal.api.NativeAdRatingApi
    public final double getScale() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.NativeAdRatingApi
    public final double getValue() {
        return this.A01;
    }
}
