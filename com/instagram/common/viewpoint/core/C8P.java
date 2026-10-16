package com.instagram.common.viewpoint.core;

import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.8P, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class C8P extends AbstractC2409oz implements InterfaceC1093Jj {
    public long A00;
    public InterfaceC1093Jj A01;

    @Override // com.instagram.common.viewpoint.core.AbstractC2409oz
    public abstract void A0B();

    @Override // com.instagram.common.viewpoint.core.AbstractC07615u
    public final void A0A() {
        super.A0A();
        this.A01 = null;
    }

    public final void A0C(long j, InterfaceC1093Jj interfaceC1093Jj, long j2) {
        super.A01 = j;
        this.A01 = interfaceC1093Jj;
        if (j2 == Long.MAX_VALUE) {
            j2 = super.A01;
        }
        this.A00 = j2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1093Jj
    public final List<C2439pT> A7X(long j) {
        return ((InterfaceC1093Jj) AbstractC07133y.A01(this.A01)).A7X(j - this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1093Jj
    public final long A83(int i) {
        return ((InterfaceC1093Jj) AbstractC07133y.A01(this.A01)).A83(i) + this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1093Jj
    public final int A84() {
        return ((InterfaceC1093Jj) AbstractC07133y.A01(this.A01)).A84();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1093Jj
    public final int A8a(long j) {
        return ((InterfaceC1093Jj) AbstractC07133y.A01(this.A01)).A8a(j - this.A00);
    }
}
