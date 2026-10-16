package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.h8, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1955h8 extends WP {
    public final /* synthetic */ C1952h5 A00;
    public final /* synthetic */ C1401Vm A01;

    public C1955h8(C1952h5 c1952h5, C1401Vm c1401Vm) {
        this.A00 = c1952h5;
        this.A01 = c1401Vm;
    }

    @Override // com.instagram.common.viewpoint.core.WP
    public final void A01() {
        S6 s6;
        S6 s62;
        s6 = this.A00.A01;
        if (s6.A00() != null) {
            s62 = this.A00.A01;
            s62.A00().onAdError(XE.A00(this.A01));
        }
    }
}
