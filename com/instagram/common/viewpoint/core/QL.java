package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class QL implements InterfaceC1454Xr {
    public int A00;
    public final InterfaceC1454Xr A01;
    public final InterfaceC1454Xr A02;

    public QL(InterfaceC1454Xr interfaceC1454Xr, int i, InterfaceC1454Xr interfaceC1454Xr2) {
        this.A01 = interfaceC1454Xr;
        this.A00 = i;
        this.A02 = interfaceC1454Xr2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1454Xr
    public final void AH8(String str) {
        if (this.A00 > 0) {
            this.A01.AH8(str);
            this.A01.flush();
            this.A00--;
            return;
        }
        this.A02.AH8(str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1454Xr
    public final void flush() {
        this.A02.flush();
    }
}
