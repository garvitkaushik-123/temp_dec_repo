package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.hk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1992hk implements InterfaceC1283Qw {
    public final /* synthetic */ C7M A00;

    public C1992hk(C7M c7m) {
        this.A00 = c7m;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1283Qw
    public final void ACv(RK rk) {
        boolean A0G;
        rk.A0d(true);
        if (rk.A06 != null && rk.A07 == null) {
            rk.A06 = null;
        }
        rk.A07 = null;
        A0G = rk.A0G();
        if (!A0G && !this.A00.A1x(rk.A0H) && rk.A0i()) {
            this.A00.removeDetachedView(rk.A0H, false);
        }
    }
}
