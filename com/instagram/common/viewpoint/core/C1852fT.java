package com.instagram.common.viewpoint.core;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.fT, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1852fT implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View A00;
    public final /* synthetic */ DA A01;

    public C1852fT(DA da, View view) {
        this.A01 = da;
        this.A00 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int value = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.A00.setTranslationY(value);
    }
}
