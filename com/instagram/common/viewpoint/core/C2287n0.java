package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.n0, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2287n0 implements HY {
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final InterfaceC1030Gx A06;

    public C2287n0(InterfaceC1030Gx interfaceC1030Gx, long j, long j2, long j3, long j4, long j5, long j6) {
        this.A06 = interfaceC1030Gx;
        this.A03 = j;
        this.A05 = j2;
        this.A02 = j3;
        this.A04 = j4;
        this.A01 = j5;
        this.A00 = j6;
    }

    public final long A05(long j) {
        return this.A06.AKQ(j);
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final long A7t() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final HX A91(long j) {
        return new HX(new HZ(j, C1029Gw.A05(this.A06.AKQ(j), this.A05, this.A02, this.A04, this.A01, this.A00)));
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final boolean AAj() {
        return true;
    }
}
