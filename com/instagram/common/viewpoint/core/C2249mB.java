package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.mB, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2249mB implements InterfaceC1081Ix {
    public int A00;
    public int A01;
    public final int A02;
    public final int A03;
    public final C07364v A04;

    public C2249mB(C2251mD c2251mD) {
        this.A04 = c2251mD.A00;
        this.A04.A0f(12);
        this.A02 = this.A04.A0L() & 255;
        this.A03 = this.A04.A0L();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1081Ix
    public final int A8A() {
        return -1;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1081Ix
    public final int A8v() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1081Ix
    public final int AHS() {
        if (this.A02 == 8) {
            return this.A04.A0I();
        }
        if (this.A02 == 16) {
            return this.A04.A0M();
        }
        int i = this.A01;
        this.A01 = i + 1;
        if (i % 2 == 0) {
            this.A00 = this.A04.A0I();
            return (this.A00 & 240) >> 4;
        }
        return this.A00 & 15;
    }
}
