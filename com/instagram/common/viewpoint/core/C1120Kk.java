package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Kk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1120Kk implements Comparable<C1120Kk> {
    public final int A00;
    public final C1111Kb A01;

    public C1120Kk(int i, C1111Kb c1111Kb) {
        this.A00 = i;
        this.A01 = c1111Kb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C1120Kk c1120Kk) {
        return Integer.compare(this.A00, c1120Kk.A00);
    }
}
