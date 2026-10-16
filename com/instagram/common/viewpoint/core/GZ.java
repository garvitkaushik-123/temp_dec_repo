package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class GZ extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C07384x A00;

    public GZ(C07384x c07384x) {
        this.A00 = c07384x;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        AbstractC1642c3 abstractC1642c3;
        AbstractC1642c3 abstractC1642c32;
        abstractC1642c3 = this.A00.A00;
        if (abstractC1642c3 != null) {
            abstractC1642c32 = this.A00.A00;
            if (abstractC1642c32.A1N()) {
                ((AbstractC1016Gj) this.A00).A02 = true;
                this.A00.A09.setToolbarActionMode(8);
            }
        }
    }
}
