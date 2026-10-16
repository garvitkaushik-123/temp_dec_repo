package com.instagram.common.viewpoint.core;

import android.animation.Animator;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.fS, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1851fS implements Animator.AnimatorListener {
    public final /* synthetic */ DA A00;

    public C1851fS(DA da) {
        this.A00 = da;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A09(false);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        View view;
        this.A00.A01 = EnumC1842fJ.A04;
        view = this.A00.A05;
        YB.A0H(view);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
