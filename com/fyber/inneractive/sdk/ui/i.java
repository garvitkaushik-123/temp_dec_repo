package com.fyber.inneractive.sdk.ui;

import android.animation.ValueAnimator;

/* loaded from: classes4.dex */
public final class i implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAsmoothProgressBar f1747a;

    public i(IAsmoothProgressBar iAsmoothProgressBar) {
        this.f1747a = iAsmoothProgressBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        super/*android.widget.ProgressBar*/.setSecondaryProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
