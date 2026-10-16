package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* renamed from: com.facebook.ads.redexgen.X.iz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2063iz extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C2116jz A00;
    public final /* synthetic */ O8 A01;
    public final /* synthetic */ C08027j A02;

    public C2063iz(C08027j c08027j, O8 o8, C2116jz c2116jz) {
        this.A02 = c08027j;
        this.A01 = o8;
        this.A00 = c2116jz;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        this.A02.A0T(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.A00 = null;
        C1401Vm A00 = C1401Vm.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0F().A5g(A00.A03().getErrorCode(), A00.A04());
        this.A02.A07.A0G(A00);
    }
}
