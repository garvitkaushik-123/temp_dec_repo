package com.instagram.common.viewpoint.core;

import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* renamed from: com.facebook.ads.redexgen.X.lF, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2191lF implements L8 {
    public C2489qI A00;
    public AnonymousClass53 A01;
    public InterfaceC1036Hd A02;

    public C2191lF(String str) {
        this.A00 = new C06802p().A11(str).A14();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void A00() {
        AbstractC07133y.A02(this.A01);
    }

    @Override // com.instagram.common.viewpoint.core.L8
    public final void A5A(C07364v c07364v) {
        A00();
        long A03 = this.A01.A03();
        long A04 = this.A01.A04();
        if (A03 == -9223372036854775807L || A04 == -9223372036854775807L) {
            return;
        }
        if (A04 != this.A00.A0M) {
            this.A00 = this.A00.A07().A0s(A04).A14();
            this.A02.A6e(this.A00);
        }
        int A07 = c07364v.A07();
        this.A02.AIr(c07364v, A07);
        this.A02.AIu(A03, 1, A07, 0, null);
    }

    @Override // com.instagram.common.viewpoint.core.L8
    public final void AAA(AnonymousClass53 anonymousClass53, HA ha, LG lg) {
        this.A01 = anonymousClass53;
        lg.A05();
        this.A02 = ha.AKS(lg.A03(), 5);
        this.A02.A6e(this.A00);
    }
}
