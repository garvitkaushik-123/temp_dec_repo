package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: assets/audience_network/classes2.dex */
public final class DQ implements InterfaceC1843fK {
    public ViewPropertyAnimator A00;
    public EnumC1842fJ A01 = EnumC1842fJ.A04;
    public final int A02;
    public final View A03;
    public final boolean A04;

    public DQ(View view, int i, boolean z) {
        this.A02 = i;
        this.A03 = view;
        this.A04 = z;
    }

    private void A04(boolean z) {
        this.A01 = EnumC1842fJ.A03;
        if (this.A04) {
            YB.A0L(this.A03);
        }
        if (!z) {
            this.A03.setAlpha(1.0f);
            this.A01 = EnumC1842fJ.A02;
        } else {
            this.A00 = this.A03.animate().alpha(1.0f).setDuration(this.A02).setListener(new C1847fO(this));
        }
    }

    private void A05(boolean z) {
        this.A01 = EnumC1842fJ.A05;
        if (!z) {
            this.A03.setAlpha(0.0f);
            this.A01 = EnumC1842fJ.A04;
        } else {
            this.A00 = this.A03.animate().alpha(0.0f).setDuration(this.A02).setListener(new C1848fP(this));
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1843fK
    public final void A4A(boolean z, boolean z2) {
        if (z2) {
            A05(z);
        } else {
            A04(z);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1843fK
    public final EnumC1842fJ A9B() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1843fK
    public final void cancel() {
        this.A03.clearAnimation();
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
