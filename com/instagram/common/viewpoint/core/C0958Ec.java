package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Ec, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0958Ec implements Comparable<C0958Ec> {
    public final boolean A00;
    public final boolean A01;

    public C0958Ec(C2489qI c2489qI, int i) {
        this.A00 = (c2489qI.A0H & 1) != 0;
        this.A01 = C08469h.A0S(i, false);
    }

    @Override // java.lang.Comparable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0958Ec c0958Ec) {
        return AbstractC2341ns.A01().A09(this.A01, c0958Ec.A01).A09(this.A00, c0958Ec.A00).A05();
    }
}
