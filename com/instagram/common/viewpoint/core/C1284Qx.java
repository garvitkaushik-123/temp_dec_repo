package com.instagram.common.viewpoint.core;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Qx, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1284Qx {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    private final C1284Qx A00(RK rk, int i) {
        View view = rk.A0H;
        this.A01 = view.getLeft();
        this.A03 = view.getTop();
        this.A02 = view.getRight();
        this.A00 = view.getBottom();
        return this;
    }

    public final C1284Qx A01(RK rk) {
        return A00(rk, 0);
    }
}
