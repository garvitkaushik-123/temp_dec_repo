package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class GE implements InterfaceC1759dx {
    public final /* synthetic */ C4V A00;

    public GE(C4V c4v) {
        this.A00 = c4v;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1759dx
    public final void A9l() {
        AbstractC1642c3 abstractC1642c3;
        AbstractC1642c3 abstractC1642c32;
        abstractC1642c3 = this.A00.A02;
        if (abstractC1642c3 instanceof C6H) {
            abstractC1642c32 = this.A00.A02;
            ((C6H) abstractC1642c32).A1X();
            VI.A02(VH.A0e, null, ((AbstractC1016Gj) this.A00).A03.A2E(), ((AbstractC1016Gj) this.A00).A05.A0A());
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1759dx
    public final void AJz() {
        AbstractC1642c3 abstractC1642c3;
        AbstractC1642c3 abstractC1642c32;
        C4L c4l;
        abstractC1642c3 = this.A00.A02;
        if (abstractC1642c3 instanceof C6H) {
            abstractC1642c32 = this.A00.A02;
            c4l = this.A00.A0N;
            ((C6H) abstractC1642c32).A1b(c4l);
            VI.A02(VH.A0e, null, ((AbstractC1016Gj) this.A00).A03.A2E(), ((AbstractC1016Gj) this.A00).A05.A0A());
        }
        this.A00.A0n();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1759dx
    public final void AKE() {
        AbstractC1642c3 abstractC1642c3;
        AbstractC1642c3 abstractC1642c32;
        this.A00.A0e();
        abstractC1642c3 = this.A00.A02;
        if (abstractC1642c3 instanceof C6H) {
            abstractC1642c32 = this.A00.A02;
            ((C6H) abstractC1642c32).getAdDetailsView().setVisibility(8);
        }
    }
}
