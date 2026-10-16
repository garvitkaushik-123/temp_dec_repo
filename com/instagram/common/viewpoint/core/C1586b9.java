package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.b9, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1586b9 {
    public static byte[] A01;
    public final Map<String, String> A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 55);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-25, -6, -10, -12, -29, -31, -22, -21, -16, -10, -11, -37, -42, -36, -54, -49};
    }

    public C1586b9() {
        this.A00 = new HashMap();
    }

    public C1586b9(Map<String, String> extraData) {
        this.A00 = extraData;
    }

    public final C1586b9 A02(Y2 y2) {
        if (y2 != null) {
            this.A00.put(A00(11, 5, 48), AbstractC1440Xd.A01(y2.A04()));
        }
        return this;
    }

    public final C1586b9 A03(C1874fp c1874fp) {
        if (c1874fp != null) {
            this.A00.putAll(c1874fp.A0S());
        }
        return this;
    }

    public final C1586b9 A04(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.A00.put(A00(0, 11, 75), str);
        }
        return this;
    }

    public final Map<String, String> A05() {
        return this.A00;
    }
}
