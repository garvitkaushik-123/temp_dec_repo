package com.instagram.common.viewpoint.core;

import android.util.SparseArray;

/* renamed from: com.facebook.ads.redexgen.X.dz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1761dz {
    public final SparseArray<int[]> A00 = new SparseArray<>();

    public final void A00(int i, int[] iArr) {
        this.A00.put(i, iArr);
    }

    public final boolean A01(int i) {
        return this.A00.indexOfKey(i) >= 0;
    }

    public final int[] A02(int i) {
        return this.A00.get(i);
    }
}
