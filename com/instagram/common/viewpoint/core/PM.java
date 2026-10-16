package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class PM implements XN {
    public final /* synthetic */ int A00;
    public final /* synthetic */ PJ A01;

    public PM(PJ pj, int i) {
        this.A01 = pj;
        this.A00 = i;
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void ADS() {
        InterfaceC1470Yh interfaceC1470Yh;
        this.A01.A05 = false;
        this.A01.A0c();
        this.A01.A0H.setToolbarActionMode(this.A01.getCloseButtonStyle());
        if (this.A01.A09 && this.A01.A08 != null) {
            this.A01.A08.A06();
            interfaceC1470Yh = this.A01.A0C;
            interfaceC1470Yh.A4j(new MG().A6l());
        }
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void AFV(float f) {
        this.A01.A0H.setProgress(100.0f * (1.0f - (f / this.A00)));
    }
}
