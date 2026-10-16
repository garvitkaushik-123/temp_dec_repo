package com.instagram.common.viewpoint.core;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: assets/audience_network/classes2.dex */
public final class DR implements InterfaceC1843fK {
    public int A00;
    public ValueAnimator A01;
    public EnumC1842fJ A02 = EnumC1842fJ.A04;
    public final int A03;
    public final int A04;
    public final View A05;

    public DR(View view, int i, int i2, int i3) {
        this.A05 = view;
        this.A03 = i;
        this.A00 = i2;
        this.A04 = i3;
    }

    private ValueAnimator A00(int i, int i2, View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(this.A03);
        ofInt.addUpdateListener(new C1846fN(this, view));
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(boolean z) {
        if (z) {
            this.A02 = EnumC1842fJ.A05;
            this.A01 = A00(this.A00, this.A04, this.A05);
            this.A01.addListener(new C1845fM(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A04;
        this.A05.setLayoutParams(layoutParams);
        YB.A0H(this.A05);
        this.A02 = EnumC1842fJ.A04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z) {
        YB.A0L(this.A05);
        if (z) {
            this.A02 = EnumC1842fJ.A03;
            this.A01 = A00(this.A04, this.A00, this.A05);
            this.A01.addListener(new C1844fL(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A00;
        this.A05.setLayoutParams(layoutParams);
        this.A02 = EnumC1842fJ.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1843fK
    public final void A4A(boolean z, boolean z2) {
        if (z2) {
            A07(z);
        } else {
            A08(z);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1843fK
    public final EnumC1842fJ A9B() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1843fK
    public final void cancel() {
        if (this.A01 != null) {
            this.A01.cancel();
        }
    }
}
