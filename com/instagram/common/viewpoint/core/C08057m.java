package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.7m, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08057m extends AbstractC2094jd {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772012L;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 49);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{52, 59, 46, 51, 44, 63};
    }

    public C08057m(List<NR> list) {
        super(list);
    }

    public static C08057m A00(JSONObject jSONObject, C1929gi c1929gi) {
        C08057m c08057m = new C08057m(AbstractC2094jd.A08(jSONObject, c1929gi, new C2086jR()));
        c08057m.A2I(jSONObject);
        c08057m.A1N(A01(0, 6, 107));
        return c08057m;
    }

    @Override // com.instagram.common.viewpoint.core.NQ
    public final int A0o() {
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.NQ
    public final int A0p() {
        return 0;
    }
}
