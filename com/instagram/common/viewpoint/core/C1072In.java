package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.In, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1072In extends AbstractC1873fo {
    public static byte[] A01;
    public final /* synthetic */ AbstractC1068Ij A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-37, -32, -39, -31, -26, -35, -36, -41, -39, -36, -41, -31, -26, -36, -35, -16};
    }

    public C1072In(AbstractC1068Ij abstractC1068Ij) {
        this.A00 = abstractC1068Ij;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1873fo
    public final void A03() {
        int i;
        boolean z;
        boolean z2;
        if (!this.A00.A0A.A07()) {
            this.A00.A0A.A05();
            if (!TextUtils.isEmpty(this.A00.A06.A2E())) {
                Map<String, String> A05 = new C1586b9().A03(this.A00.A0D).A02(this.A00.A0A).A04(this.A00.A06.A0z()).A05();
                StringBuilder append = new StringBuilder().append(A00(0, 0, 96));
                i = this.A00.A02;
                A05.put(A00(0, 16, 42), append.append(i).toString());
                this.A00.A08.ABJ(this.A00.A06.A2E(), A05);
                C1425Wl.A00(this.A00.A07).A0E(this.A00.A0C.A8l(), this.A00.A06.A2E());
                C1193Ng.A07(this.A00.A06.A2A(), this.A00.A07);
                this.A00.A07.A0F().A3L();
                z = this.A00.A04;
                if (!z) {
                    AbstractC1213Oa.A02(this.A00.A06.A0y(), AbstractC1449Xm.A00(this.A00.A06.A10()));
                }
                z2 = this.A00.A05;
                if (!z2) {
                    this.A00.A0B.A4j(this.A00.A0C.A8G());
                }
            }
        }
    }
}
