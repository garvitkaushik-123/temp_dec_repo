package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class QI implements InterfaceC1454Xr {
    public int A00;
    public final InterfaceC1454Xr A01;

    public QI(InterfaceC1454Xr interfaceC1454Xr, int i) {
        this.A01 = interfaceC1454Xr;
        this.A00 = i;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1454Xr
    public final void AH8(String str) {
        if (this.A00 > 0) {
            this.A01.AH8(str);
            this.A00--;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1454Xr
    public final void flush() {
        this.A01.flush();
    }
}
