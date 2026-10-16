package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Ep, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0971Ep extends AbstractRunnableC1416Wc {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0966Ek A02;

    public C0971Ep(C0966Ek c0966Ek, int i, int i2) {
        this.A02 = c0966Ek;
        this.A00 = i;
        this.A01 = i2;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        UM um;
        um = this.A02.A0C;
        um.A02(new C0954Dy(this.A00, this.A01));
    }
}
