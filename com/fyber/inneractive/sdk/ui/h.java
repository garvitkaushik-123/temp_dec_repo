package com.fyber.inneractive.sdk.ui;

import android.animation.ValueAnimator;

/* loaded from: classes4.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAsmoothProgressBar f1746a;

    public h(IAsmoothProgressBar iAsmoothProgressBar) {
        this.f1746a = iAsmoothProgressBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        super/*android.widget.ProgressBar*/.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
