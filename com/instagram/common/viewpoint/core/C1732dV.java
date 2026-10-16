package com.instagram.common.viewpoint.core;

import android.animation.ValueAnimator;

/* renamed from: com.facebook.ads.redexgen.X.dV, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1732dV implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C5F A00;

    public C1732dV(C5F c5f) {
        this.A00 = c5f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        C0966Ek c0966Ek;
        C0966Ek c0966Ek2;
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        c0966Ek = this.A00.A0b;
        c0966Ek.getLayoutParams().height = num.intValue();
        c0966Ek2 = this.A00.A0b;
        c0966Ek2.requestLayout();
    }
}
