package com.instagram.common.viewpoint.core;

import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.g0, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1885g0 {
    public C1888g3 A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04;

    public C1885g0(C1888g3 c1888g3, boolean z, Set<String> pinnedPublicKeys, Set<String> pinnedCertificates, boolean z2) {
        this.A00 = c1888g3;
        this.A04 = z;
        this.A02 = pinnedPublicKeys;
        this.A01 = pinnedCertificates;
        this.A03 = z2;
    }

    public final C1888g3 A00() {
        return this.A00;
    }

    public final Set<String> A01() {
        return this.A01;
    }

    public final Set<String> A02() {
        return this.A02;
    }

    public final boolean A03() {
        return this.A04;
    }

    public final boolean A04() {
        return this.A03;
    }
}
