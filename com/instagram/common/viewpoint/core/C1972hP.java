package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdListener;

/* renamed from: com.facebook.ads.redexgen.X.hP, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1972hP extends WP {
    public final /* synthetic */ C1969hM A00;

    public C1972hP(C1969hM c1969hM) {
        this.A00 = c1969hM;
    }

    @Override // com.instagram.common.viewpoint.core.WP
    public final void A01() {
        C1290Rd c1290Rd;
        C1290Rd c1290Rd2;
        C1290Rd c1290Rd3;
        c1290Rd = this.A00.A01;
        if (c1290Rd.A06() != null) {
            c1290Rd2 = this.A00.A01;
            AdListener A06 = c1290Rd2.A06();
            c1290Rd3 = this.A00.A01;
            A06.onAdLoaded(c1290Rd3.A07());
        }
    }
}
