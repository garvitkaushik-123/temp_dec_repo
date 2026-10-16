package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class F8 implements InterfaceC1899gE {
    public final /* synthetic */ C1797ea A00;

    public F8(C1797ea c1797ea) {
        this.A00 = c1797ea;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1899gE
    public final void AHA() {
        InterfaceC1470Yh interfaceC1470Yh;
        InterfaceC1470Yh interfaceC1470Yh2;
        ZU zu;
        interfaceC1470Yh = this.A00.A02;
        if (interfaceC1470Yh == null) {
            return;
        }
        interfaceC1470Yh2 = this.A00.A02;
        zu = this.A00.A03;
        interfaceC1470Yh2.A4j(zu.A94());
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1899gE
    public final void AHC(C1901gG c1901gG) {
        InterfaceC1470Yh interfaceC1470Yh;
        C1929gi c1929gi;
        InterfaceC1470Yh interfaceC1470Yh2;
        ZU zu;
        C1929gi c1929gi2;
        InterfaceC1470Yh interfaceC1470Yh3;
        ZU zu2;
        interfaceC1470Yh = this.A00.A02;
        if (interfaceC1470Yh == null) {
            return;
        }
        if (c1901gG == null || !c1901gG.A00()) {
            c1929gi = this.A00.A01;
            c1929gi.A0F().ABv();
            interfaceC1470Yh2 = this.A00.A02;
            zu = this.A00.A03;
            interfaceC1470Yh2.A4j(zu.A94());
            return;
        }
        c1929gi2 = this.A00.A01;
        c1929gi2.A0F().ABw();
        interfaceC1470Yh3 = this.A00.A02;
        zu2 = this.A00.A03;
        interfaceC1470Yh3.A4j(zu2.A95());
    }
}
