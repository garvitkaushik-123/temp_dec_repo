package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.k3, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2120k3 extends AbstractRunnableC1416Wc {
    public final /* synthetic */ C2119k2 A00;
    public final /* synthetic */ AnonymousClass62 A01;

    public C2120k3(C2119k2 c2119k2, AnonymousClass62 anonymousClass62) {
        this.A00 = c2119k2;
        this.A01 = anonymousClass62;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        C1874fp c1874fp;
        C1874fp c1874fp2;
        C1874fp c1874fp3;
        this.A00.A00.A0A();
        c1874fp = this.A00.A00.A0B;
        if (c1874fp != null) {
            AnonymousClass62 anonymousClass62 = this.A01;
            c1874fp2 = this.A00.A00.A0B;
            anonymousClass62.setAdViewabilityChecker(c1874fp2);
            c1874fp3 = this.A00.A00.A0B;
            c1874fp3.A0U();
        }
    }
}
