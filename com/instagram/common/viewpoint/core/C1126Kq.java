package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Kq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1126Kq extends AbstractRunnableC1416Wc {
    public final /* synthetic */ AbstractC1614bb A00;

    public C1126Kq(AbstractC1614bb abstractC1614bb) {
        this.A00 = abstractC1614bb;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        Runnable runnable;
        int i;
        if (this.A00.isPressed()) {
            AbstractC1614bb abstractC1614bb = this.A00;
            i = this.A00.A08;
            abstractC1614bb.postDelayed(this, i);
        } else {
            this.A00.setPressed(true);
            AbstractC1614bb abstractC1614bb2 = this.A00;
            runnable = this.A00.A0A;
            abstractC1614bb2.postOnAnimationDelayed(runnable, 250L);
        }
    }
}
