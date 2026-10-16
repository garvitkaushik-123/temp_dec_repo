package com.instagram.common.viewpoint.core;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.cf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1680cf implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C1092Ji A00;

    public C1680cf(C1092Ji c1092Ji) {
        this.A00 = c1092Ji;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        View view;
        View view2;
        View view3;
        view = this.A00.A0T;
        if (view != null) {
            view2 = this.A00.A0T;
            view2.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            view3 = this.A00.A0T;
            view3.requestLayout();
        }
    }
}
