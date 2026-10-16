package com.instagram.common.viewpoint.core;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: assets/audience_network/classes2.dex */
public final class DA implements InterfaceC1843fK {
    public ValueAnimator A00;
    public EnumC1842fJ A01 = EnumC1842fJ.A04;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    public DA(View view, int i, int i2, int i3) {
        this.A05 = view;
        this.A02 = i;
        this.A04 = i2;
        this.A03 = i3;
    }

    private ValueAnimator A00(View view, int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration(this.A02);
        ofInt.addUpdateListener(new C1852fT(this, view));
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (this.A00 != null) {
            this.A00.removeAllListeners();
            this.A00 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z) {
        if (z) {
            this.A01 = EnumC1842fJ.A05;
            this.A00 = A00(this.A05, this.A03, this.A04);
            this.A00.addListener(new C1851fS(this));
            this.A00.start();
            return;
        }
        this.A05.setTranslationY(this.A04);
        YB.A0H(this.A05);
        this.A01 = EnumC1842fJ.A04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z) {
        YB.A0L(this.A05);
        if (z) {
            this.A01 = EnumC1842fJ.A03;
            this.A00 = A00(this.A05, this.A04, this.A03);
            this.A00.addListener(new C1850fR(this));
            this.A00.start();
            return;
        }
        this.A05.setTranslationY(this.A03);
        this.A01 = EnumC1842fJ.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1843fK
    public final void A4A(boolean z, boolean z2) {
        if (z2) {
            A08(z);
        } else {
            A09(z);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1843fK
    public final EnumC1842fJ A9B() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1843fK
    public final void cancel() {
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
