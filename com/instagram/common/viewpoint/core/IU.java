package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class IU implements XN {
    public final /* synthetic */ C5S A00;

    public IU(C5S c5s) {
        this.A00 = c5s;
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void ADS() {
        InterfaceC1749dm interfaceC1749dm;
        int i;
        InterfaceC1749dm interfaceC1749dm2;
        interfaceC1749dm = this.A00.A0P;
        i = this.A00.A0F;
        interfaceC1749dm.ADc(i);
        interfaceC1749dm2 = this.A00.A0P;
        interfaceC1749dm2.ADA();
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void AFV(float f) {
        int i;
        boolean z;
        C0966Ek c0966Ek;
        int duration;
        boolean z2;
        int i2;
        InterfaceC1749dm interfaceC1749dm;
        i = this.A00.A0F;
        float f2 = i - f;
        z = this.A00.A0d;
        if (z) {
            duration = 0;
        } else {
            c0966Ek = this.A00.A0S;
            duration = c0966Ek.getDuration();
        }
        float totalForce = f2 + duration;
        z2 = this.A00.A0d;
        if (z2) {
            i2 = this.A00.A0F;
        } else {
            i2 = this.A00.A0E;
        }
        float seenTime = i2;
        float totalForce2 = totalForce / seenTime;
        interfaceC1749dm = this.A00.A0P;
        interfaceC1749dm.AKd(totalForce2);
    }
}
