package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class QF implements InterfaceC1454Xr {
    public final C1453Xq A00;
    public final InterfaceC1454Xr A01;

    public QF(InterfaceC1454Xr interfaceC1454Xr, int i, int i2) {
        this.A01 = interfaceC1454Xr;
        this.A00 = new C1453Xq(i, i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1454Xr
    public final void AH8(String str) {
        boolean A08;
        this.A00.A04(str);
        if (this.A00.A02() == null) {
            return;
        }
        A08 = AbstractC1456Xt.A08(this.A00);
        if (A08) {
            this.A01.AH8(this.A00.A02());
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1454Xr
    public final void flush() {
        boolean A08;
        this.A00.A03();
        while (this.A00.A02() != null) {
            A08 = AbstractC1456Xt.A08(this.A00);
            if (A08) {
                this.A01.AH8(this.A00.A02());
            }
            this.A00.A03();
        }
    }
}
