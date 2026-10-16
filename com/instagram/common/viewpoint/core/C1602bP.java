package com.instagram.common.viewpoint.core;

import android.animation.Animator;

/* renamed from: com.facebook.ads.redexgen.X.bP, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1602bP implements Animator.AnimatorListener {
    public final /* synthetic */ C1604bR A00;

    public C1602bP(C1604bR c1604bR) {
        this.A00 = c1604bR;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        C1929gi c1929gi;
        this.A00.A06();
        this.A00.A02 = true;
        c1929gi = this.A00.A07;
        c1929gi.A0F().ADF();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
