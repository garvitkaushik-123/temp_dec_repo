package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.ky, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2174ky implements HY {
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final LN A04;

    public C2174ky(LN ln, int i, long j, long j2) {
        this.A04 = ln;
        this.A00 = i;
        this.A03 = j;
        this.A01 = (j2 - j) / ln.A02;
        this.A02 = A00(this.A01);
    }

    private long A00(long j) {
        return C5C.A0U(j * this.A00, 1000000L, this.A04.A04);
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final long A7t() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final HX A91(long j) {
        long A0T = C5C.A0T((this.A04.A04 * j) / (this.A00 * 1000000), 0L, this.A01 - 1);
        long j2 = this.A03 + (this.A04.A02 * A0T);
        long A00 = A00(A0T);
        HZ hz = new HZ(A00, j2);
        if (A00 >= j || A0T == this.A01 - 1) {
            return new HX(hz);
        }
        long j3 = 1 + A0T;
        return new HX(hz, new HZ(A00(j3), this.A03 + (this.A04.A02 * j3)));
    }

    @Override // com.instagram.common.viewpoint.core.HY
    public final boolean AAj() {
        return true;
    }
}
