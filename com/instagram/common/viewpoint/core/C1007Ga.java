package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Ga, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1007Ga extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C07384x A00;

    public C1007Ga(C07384x c07384x) {
        this.A00 = c07384x;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        AbstractC1642c3 abstractC1642c3;
        int closeButtonStyle;
        AtomicBoolean atomicBoolean;
        AbstractC1642c3 abstractC1642c32;
        abstractC1642c3 = this.A00.A00;
        if (abstractC1642c3 != null) {
            abstractC1642c32 = this.A00.A00;
            abstractC1642c32.A1F();
        }
        AbstractC1464Yb abstractC1464Yb = this.A00.A09;
        closeButtonStyle = this.A00.getCloseButtonStyle();
        abstractC1464Yb.setToolbarActionMode(closeButtonStyle);
        this.A00.A09.A0A();
        atomicBoolean = this.A00.A06;
        atomicBoolean.set(true);
    }
}
