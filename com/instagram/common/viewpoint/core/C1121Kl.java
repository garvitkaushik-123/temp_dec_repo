package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Kl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1121Kl extends AbstractRunnableC1416Wc {
    public final /* synthetic */ AbstractC1614bb A00;

    public C1121Kl(AbstractC1614bb abstractC1614bb) {
        this.A00 = abstractC1614bb;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        Runnable runnable;
        int i;
        this.A00.setPressed(false);
        AbstractC1614bb abstractC1614bb = this.A00;
        runnable = this.A00.A09;
        i = this.A00.A08;
        abstractC1614bb.postOnAnimationDelayed(runnable, i);
    }
}
