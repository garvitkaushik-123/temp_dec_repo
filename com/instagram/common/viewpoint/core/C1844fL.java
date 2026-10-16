package com.instagram.common.viewpoint.core;

import android.animation.Animator;

/* renamed from: com.facebook.ads.redexgen.X.fL, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1844fL implements Animator.AnimatorListener {
    public final /* synthetic */ DR A00;

    public C1844fL(DR dr) {
        this.A00 = dr;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A07(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.A00.A01 = null;
        this.A00.A02 = EnumC1842fJ.A02;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
