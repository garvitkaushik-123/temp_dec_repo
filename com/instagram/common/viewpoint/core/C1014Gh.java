package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Gh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1014Gh implements InterfaceC1749dm {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1011Ge A01;

    public C1014Gh(C1011Ge c1011Ge, int i) {
        this.A01 = c1011Ge;
        this.A00 = i;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1749dm
    public final void ACQ() {
        this.A01.A0G();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1749dm
    public final void ADA() {
        this.A01.A0X(false, this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1749dm
    public final void ADc(int i) {
        C1011Ge.A03(this.A01, i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1749dm
    public final void ADw(float f) {
        boolean z;
        z = this.A01.A08;
        if (!z) {
            this.A01.A0L(f);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1749dm
    public final void AFw(boolean z) {
        this.A01.A0W(z);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1749dm
    public final void AGQ(String str) {
        C1929gi c1929gi;
        C2088jT c2088jT;
        InterfaceC1470Yh interfaceC1470Yh;
        ZU zu;
        int i;
        C2088jT c2088jT2;
        C1929gi c1929gi2;
        c1929gi = this.A01.A0D;
        c1929gi.A0F().A3a(str);
        c2088jT = this.A01.A0A;
        if (c2088jT.A2H()) {
            i = this.A01.A00;
            c2088jT2 = this.A01.A0A;
            if (i < c2088jT2.A23()) {
                c1929gi2 = this.A01.A0D;
                c1929gi2.A0F().AC2();
                this.A01.A0X(false, this.A00);
                return;
            }
        }
        interfaceC1470Yh = this.A01.A0I;
        zu = this.A01.A0J;
        interfaceC1470Yh.A4j(zu.A81());
        this.A01.A0M(3);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1749dm
    public final void AKc() {
        AbstractC1464Yb abstractC1464Yb;
        AbstractC1464Yb abstractC1464Yb2;
        this.A01.setUnskippableSecondsComplete(false);
        abstractC1464Yb = this.A01.A0H;
        abstractC1464Yb.setProgressImmediate(0.0f);
        abstractC1464Yb2 = this.A01.A0H;
        abstractC1464Yb2.setToolbarActionMode(2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1749dm
    public final void AKd(float f) {
        AbstractC1464Yb abstractC1464Yb;
        abstractC1464Yb = this.A01.A0H;
        abstractC1464Yb.setProgress(100.0f * f);
    }
}
