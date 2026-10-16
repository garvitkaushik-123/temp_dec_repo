package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.f4, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1827f4 extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C1925ge A00;

    public C1827f4(C1925ge c1925ge) {
        this.A00 = c1925ge;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        for (TY ty : TX.A02()) {
            TX.A0A(this.A00, ty.A02(), ty.A00(), ty.A01(), false);
        }
        TX.A02().clear();
    }
}
