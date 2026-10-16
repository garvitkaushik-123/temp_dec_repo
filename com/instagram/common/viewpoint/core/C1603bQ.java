package com.instagram.common.viewpoint.core;

import android.animation.Animator;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.bQ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1603bQ implements Animator.AnimatorListener {
    public final /* synthetic */ C1604bR A00;

    public C1603bQ(C1604bR c1604bR) {
        this.A00 = c1604bR;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        RelativeLayout relativeLayout;
        C1929gi c1929gi;
        this.A00.A06();
        relativeLayout = this.A00.A05;
        YB.A0O(relativeLayout, 8);
        c1929gi = this.A00.A07;
        c1929gi.A0F().ADG();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.A00.A01 = true;
    }
}
