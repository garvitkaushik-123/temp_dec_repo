package com.instagram.common.viewpoint.core;

import android.view.View;

/* loaded from: assets/audience_network/classes2.dex */
public final class EE implements InterfaceC1814er {
    public final View A00;
    public final C1929gi A01;

    public EE(C1929gi c1929gi, View view) {
        this.A01 = c1929gi;
        this.A00 = view;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1814er
    public final double A9V() {
        C1875fq result = C1874fp.A0E(this.A00, 0, this.A01);
        return result.A00();
    }
}
