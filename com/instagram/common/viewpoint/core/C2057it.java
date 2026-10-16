package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* renamed from: com.facebook.ads.redexgen.X.it, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2057it extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C08157w A00;
    public final /* synthetic */ O8 A01;
    public final /* synthetic */ C07937a A02;

    public C2057it(C07937a c07937a, O8 o8, C08157w c08157w) {
        this.A02 = c07937a;
        this.A01 = o8;
        this.A00 = c08157w;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        this.A02.A0T(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.A00 = null;
        AdErrorType adErrorType = AdErrorType.RV_AD_TIMEOUT;
        this.A02.A0B.A0F().A5g(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
        this.A02.A07.A0G(new C1401Vm(adErrorType, ""));
    }
}
