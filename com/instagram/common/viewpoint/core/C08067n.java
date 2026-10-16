package com.instagram.common.viewpoint.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.7n, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08067n extends AbstractC2094jd implements Serializable {
    public static byte[] A00 = null;
    public static String[] A01 = {"", "DwBpRdjhynFrlzLsBFrR", "QSeBoONoLaQYOKTzvkglRPiKzJDmlw8V", "7gQnCJoaPerIMpa6ilCeIjK7d9DzDLkx", "0G82UgBGsFbmab2LaOSe1R1N", "BET7yFkEMT8u6XlB2K", "", "QGCw11GNV2Lw2F7bA4MSMYlzIGOyIq"};
    public static final long serialVersionUID = 5751287062553772011L;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = (byte) ((copyOfRange[i4] ^ i3) ^ 54);
            if (A01[5].length() != 18) {
                throw new RuntimeException();
            }
            A01[4] = "xBe8M";
            copyOfRange[i4] = b;
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{86, 81, 75, 90, 77, 76, 75, 86, 75, 86, 94, 83};
    }

    static {
        A02();
    }

    public C08067n(List<NR> list) {
        super(list);
    }

    public static C08067n A00(JSONObject jSONObject, C1929gi c1929gi) {
        C08067n c08067n = new C08067n(AbstractC2094jd.A08(jSONObject, c1929gi, new C2087jS()));
        c08067n.A2I(jSONObject);
        c08067n.A1N(A01(0, 12, 9));
        return c08067n;
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
