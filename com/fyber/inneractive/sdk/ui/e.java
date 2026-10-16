package com.fyber.inneractive.sdk.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes4.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FyberAdIdentifierLocal f1743a;

    public e(FyberAdIdentifierLocal fyberAdIdentifierLocal) {
        this.f1743a = fyberAdIdentifierLocal;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        FyberAdIdentifierLocal fyberAdIdentifierLocal = this.f1743a;
        fyberAdIdentifierLocal.p = null;
        fyberAdIdentifierLocal.o = !fyberAdIdentifierLocal.o;
    }
}
