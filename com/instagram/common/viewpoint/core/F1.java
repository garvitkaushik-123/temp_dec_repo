package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class F1 extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C0976Eu A00;

    public F1(C0976Eu c0976Eu) {
        this.A00 = c0976Eu;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        C1803eg c1803eg;
        C0966Ek c0966Ek;
        E4 e4;
        EA ea;
        c1803eg = this.A00.A03;
        c1803eg.A07();
        c0966Ek = this.A00.A04;
        UM<UN, UL> eventBus = c0966Ek.getEventBus();
        e4 = this.A00.A06;
        ea = this.A00.A05;
        eventBus.A04(e4, ea);
    }
}
