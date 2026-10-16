package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.m1, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2239m1 implements HY {
    public final /* synthetic */ C2238m0 A00;

    public C2239m1(C2238m0 c2238m0) {
        this.A00 = c2238m0;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final long A7t() {
        AbstractC1085Jb abstractC1085Jb;
        long j;
        abstractC1085Jb = this.A00.A0B;
        j = this.A00.A07;
        return abstractC1085Jb.A05(j);
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final HX A91(long j) {
        AbstractC1085Jb abstractC1085Jb;
        long j2;
        long j3;
        long targetGranule;
        long targetGranule2;
        long j4;
        long j5;
        abstractC1085Jb = this.A00.A0B;
        long A06 = abstractC1085Jb.A06(j);
        j2 = this.A00.A09;
        j3 = this.A00.A08;
        targetGranule = this.A00.A09;
        long j6 = (j3 - targetGranule) * A06;
        targetGranule2 = this.A00.A07;
        j4 = this.A00.A09;
        j5 = this.A00.A08;
        long estimatedPosition = C5C.A0T((j2 + (j6 / targetGranule2)) - 30000, j4, j5 - 1);
        return new HX(new HZ(j, estimatedPosition));
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final boolean AAj() {
        return true;
    }
}
