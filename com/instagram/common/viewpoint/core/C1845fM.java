package com.instagram.common.viewpoint.core;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.fM, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1845fM implements Animator.AnimatorListener {
    public final /* synthetic */ DR A00;

    public C1845fM(DR dr) {
        this.A00 = dr;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        this.A00.A08(false);
        valueAnimator = this.A00.A01;
        if (valueAnimator != null) {
            valueAnimator2 = this.A00.A01;
            valueAnimator2.removeAllListeners();
            this.A00.A01 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        View view;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        this.A00.A02 = EnumC1842fJ.A04;
        view = this.A00.A05;
        YB.A0H(view);
        valueAnimator = this.A00.A01;
        if (valueAnimator != null) {
            valueAnimator2 = this.A00.A01;
            valueAnimator2.removeAllListeners();
            this.A00.A01 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
