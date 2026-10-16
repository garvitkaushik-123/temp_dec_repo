package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class K6 extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C1092Ji A00;
    public final /* synthetic */ boolean A01;

    public K6(C1092Ji c1092Ji, boolean z) {
        this.A00 = c1092Ji;
        this.A01 = z;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        C1646c7 c1646c7;
        c1646c7 = this.A00.A0b;
        AbstractC1464Yb A0B = c1646c7.A0B();
        if (A0B == null) {
            return;
        }
        A0B.setPageDetailsVisible((this.A01 || A0B.A0E()) ? false : true);
        A0B.setToolbarActionMode(this.A00.getCloseButtonStyle());
    }
}
