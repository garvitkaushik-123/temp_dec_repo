package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.hD, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1960hD implements XN {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1959hC A01;

    public C1960hD(C1959hC c1959hC, int i) {
        this.A01 = c1959hC;
        this.A00 = i;
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void ADS() {
        C1929gi c1929gi;
        c1929gi = this.A01.A0C;
        c1929gi.A0F().ABa();
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void AFV(float f) {
        C1610bX c1610bX;
        C1610bX c1610bX2;
        float f2 = 1.0f - (f / this.A00);
        c1610bX = this.A01.A0G;
        if (c1610bX != null) {
            c1610bX2 = this.A01.A0G;
            c1610bX2.setProgressWithAnimation(100.0f * f2);
        }
    }
}
