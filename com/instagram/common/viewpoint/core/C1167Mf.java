package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Mf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1167Mf {
    public final long A00;
    public final long A01;

    public C1167Mf(long j, long j2) {
        this.A01 = j;
        this.A00 = j2;
    }

    public final boolean A00(long j, long j2) {
        return this.A00 == -1 ? j >= this.A01 : j2 != -1 && this.A01 <= j && j + j2 <= this.A01 + this.A00;
    }

    public final boolean A01(long j, long j2) {
        return this.A01 <= j ? this.A00 == -1 || this.A01 + this.A00 > j : j2 == -1 || j + j2 > this.A01;
    }
}
