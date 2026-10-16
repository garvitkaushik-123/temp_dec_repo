package com.instagram.common.viewpoint.core;

import android.animation.Animator;

/* renamed from: com.facebook.ads.redexgen.X.fR, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1850fR implements Animator.AnimatorListener {
    public final /* synthetic */ DA A00;

    public C1850fR(DA da) {
        this.A00 = da;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.A00.A08(false);
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.A00.A00 = null;
        this.A00.A01 = EnumC1842fJ.A02;
        this.A00.A04();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
