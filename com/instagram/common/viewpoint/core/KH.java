package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class KH extends AbstractRunnableC1416Wc {
    public final /* synthetic */ KE A00;

    public KH(KE ke) {
        this.A00 = ke;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        boolean z;
        C1678cd c1678cd;
        z = this.A00.A0Y;
        if (!z) {
            c1678cd = this.A00.A0K;
            YB.A0F(1000, c1678cd);
        }
        this.A00.postDelayed(this, 2000L);
    }
}
