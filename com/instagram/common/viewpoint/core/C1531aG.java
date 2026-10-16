package com.instagram.common.viewpoint.core;

import android.animation.Animator;
import android.widget.ImageView;

/* renamed from: com.facebook.ads.redexgen.X.aG, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1531aG implements Animator.AnimatorListener {
    public final /* synthetic */ C1534aJ A00;

    public C1531aG(C1534aJ c1534aJ) {
        this.A00 = c1534aJ;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.A00.A04 = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        EnumC1540aP enumC1540aP;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        enumC1540aP = this.A00.A0H;
        if (enumC1540aP == EnumC1540aP.A04) {
            imageView2 = this.A00.A01;
            imageView2.setPadding(XV.A0S, XV.A00, XV.A0S, XV.A00);
            imageView3 = this.A00.A01;
            imageView3.setVisibility(0);
            return;
        }
        imageView = this.A00.A01;
        imageView.setPadding(XV.A0I, XV.A00, XV.A0I, XV.A00);
    }
}
