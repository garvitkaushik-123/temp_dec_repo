package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.mn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2275mn implements HY {
    public final long A00;
    public final HX A01;

    public C2275mn(long j) {
        this(j, 0L);
    }

    public C2275mn(long j, long j2) {
        this.A00 = j;
        this.A01 = new HX(j2 == 0 ? HZ.A04 : new HZ(0L, j2));
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final long A7t() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final HX A91(long j) {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final boolean AAj() {
        return false;
    }
}
