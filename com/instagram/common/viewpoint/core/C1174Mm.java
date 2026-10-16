package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Mm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1174Mm implements InterfaceC1297Rk {
    public static String[] A01 = {"OzZgVge9f1M6v6ECGvfzE2lelYGRNpcR", "wWE4h2nZ4zwlNyDcFF4AKhs", "2tlTz3YI6lX4F9BnCi72Ebdo8SjZZSMc", "OEQW3vRvYAQWgt7PHCfPR8E", "3OILw1bCaEkMk35ZNNqR0SRTWeQg1PRg", "i6GFbsYgPXu23Z4kIsNVdeySMROLxMHq", "jYSQemNdDQ7ZZ3K3t", "DXND3IEKe4RSyw4IFeihHP08ajxTSSoO"};
    public final /* synthetic */ MW A00;

    public C1174Mm(MW mw) {
        this.A00 = mw;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1297Rk
    public final boolean AAI() {
        boolean z;
        C1790eS c1790eS;
        C1790eS c1790eS2;
        VI vi;
        InterfaceC1470Yh interfaceC1470Yh;
        ZU zu;
        VI vi2;
        InterfaceC1470Yh interfaceC1470Yh2;
        ZU zu2;
        z = this.A00.A0E;
        if (z) {
            if (this.A00.A0U.getToolbarActionMode() == 1) {
                AbstractC1464Yb abstractC1464Yb = this.A00.A0U;
                if (A01[6].length() != 17) {
                    throw new RuntimeException();
                }
                A01[6] = "6SLOwM6DBUuyj18aF";
                abstractC1464Yb.setToolbarActionMode(2);
                this.A00.A0N();
            } else if (this.A00.A0U.getToolbarActionMode() == 0) {
                vi2 = this.A00.A0L;
                vi2.A04(VH.A07, null);
                interfaceC1470Yh2 = this.A00.A0O;
                zu2 = this.A00.A0P;
                interfaceC1470Yh2.A4j(zu2.A7w());
            } else {
                c1790eS = this.A00.A09;
                if (c1790eS != null) {
                    c1790eS2 = this.A00.A09;
                    if (c1790eS2.A0h()) {
                        vi = this.A00.A0L;
                        vi.A04(VH.A07, null);
                        interfaceC1470Yh = this.A00.A0O;
                        zu = this.A00.A0P;
                        interfaceC1470Yh.A4j(zu.A7w());
                    }
                }
            }
            return true;
        }
        return false;
    }
}
