package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.j1, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2065j1 extends AbstractRunnableC1416Wc {
    public final /* synthetic */ AbstractC2064j0 A00;
    public final /* synthetic */ C1401Vm A01;

    public C2065j1(AbstractC2064j0 abstractC2064j0, C1401Vm c1401Vm) {
        this.A00 = abstractC2064j0;
        this.A01 = c1401Vm;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        this.A00.A0B.A0F().A5g(this.A01.A03().getErrorCode(), this.A01.A04());
        if (this.A00.A07 != null) {
            this.A00.A07.A0G(this.A01);
        }
    }
}
