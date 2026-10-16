package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.ni, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2331ni implements InterfaceC0981Ez {
    public long A00;
    public long A01;
    public C2331ni A02;
    public C0980Ey A03;

    public C2331ni(long j, int i) {
        A02(j, i);
    }

    public final int A00(long j) {
        return ((int) (j - this.A01)) + this.A03.A00;
    }

    public final C2331ni A01() {
        this.A03 = null;
        C2331ni c2331ni = this.A02;
        this.A02 = null;
        return c2331ni;
    }

    public final void A02(long j, int i) {
        AbstractC07133y.A08(this.A03 == null);
        this.A01 = j;
        this.A00 = i + j;
    }

    public final void A03(C0980Ey c0980Ey, C2331ni c2331ni) {
        this.A03 = c0980Ey;
        this.A02 = c2331ni;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0981Ez
    public final C0980Ey A6u() {
        return (C0980Ey) AbstractC07133y.A01(this.A03);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0981Ez
    public final C2331ni ACc() {
        if (this.A02 == null || this.A02.A03 == null) {
            return null;
        }
        return this.A02;
    }
}
