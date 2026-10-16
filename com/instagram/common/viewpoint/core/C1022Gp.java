package com.instagram.common.viewpoint.core;

import android.widget.FrameLayout;

/* renamed from: com.facebook.ads.redexgen.X.Gp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1022Gp implements InterfaceC1468Yf {
    public final /* synthetic */ AbstractC1016Gj A00;

    public C1022Gp(AbstractC1016Gj abstractC1016Gj) {
        this.A00 = abstractC1016Gj;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1468Yf
    public final void AEZ(int i) {
        this.A00.A0d();
        if (this.A00.A01 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = i;
            this.A00.A01.setLayoutParams(layoutParams);
        }
    }
}
