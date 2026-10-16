package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Ku, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1130Ku implements YI {
    public final /* synthetic */ C1604bR A00;

    public C1130Ku(C1604bR c1604bR) {
        this.A00 = c1604bR;
    }

    @Override // com.instagram.common.viewpoint.core.YI
    public final void AFx() {
        boolean z;
        ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr;
        z = this.A00.A09;
        if (!z) {
            return;
        }
        viewOnClickListenerC1127Kr = this.A00.A08;
        viewOnClickListenerC1127Kr.performClick();
    }

    @Override // com.instagram.common.viewpoint.core.YI
    public final void AG8() {
        this.A00.A04();
    }
}
