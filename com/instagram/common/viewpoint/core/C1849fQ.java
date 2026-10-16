package com.instagram.common.viewpoint.core;

import android.animation.Animator;
import android.animation.ValueAnimator;

/* renamed from: com.facebook.ads.redexgen.X.fQ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1849fQ implements Animator.AnimatorListener {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ DB A02;

    public C1849fQ(DB db, int i, int i2) {
        this.A02 = db;
        this.A01 = i;
        this.A00 = i2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        this.A02.A07(this.A00, this.A01, false);
        valueAnimator = this.A02.A00;
        if (valueAnimator != null) {
            valueAnimator2 = this.A02.A00;
            valueAnimator2.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i;
        EnumC1842fJ enumC1842fJ;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        DB db = this.A02;
        int i2 = this.A01;
        i = this.A02.A04;
        if (i2 == i) {
            enumC1842fJ = EnumC1842fJ.A02;
        } else {
            enumC1842fJ = EnumC1842fJ.A04;
        }
        db.A01 = enumC1842fJ;
        valueAnimator = this.A02.A00;
        if (valueAnimator != null) {
            valueAnimator2 = this.A02.A00;
            valueAnimator2.removeAllListeners();
            this.A02.A00 = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
