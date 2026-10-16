package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.h7, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1954h7 extends WP {
    public final /* synthetic */ C1953h6 A00;

    public C1954h7(C1953h6 c1953h6) {
        this.A00 = c1953h6;
    }

    @Override // com.instagram.common.viewpoint.core.WP
    public final void A01() {
        S6 s6;
        S6 s62;
        s6 = this.A00.A01.A01;
        if (s6.A00() != null) {
            s62 = this.A00.A01.A01;
            s62.A00().onAdsLoaded();
        }
    }
}
