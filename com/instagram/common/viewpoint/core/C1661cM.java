package com.instagram.common.viewpoint.core;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.cM, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1661cM implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ KE A00;

    public C1661cM(KE ke) {
        this.A00 = ke;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        View view3;
        Integer num = (Integer) valueAnimator.getAnimatedValue();
        view = this.A00.A09;
        if (view != null) {
            view2 = this.A00.A09;
            view2.getLayoutParams().height = num.intValue();
            view3 = this.A00.A09;
            view3.requestLayout();
        }
    }
}
