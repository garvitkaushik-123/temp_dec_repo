package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f {

    public static final class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f6011a;
        public final /* synthetic */ float b;

        public a(View view, float f) {
            this.f6011a = view;
            this.b = f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            this.f6011a.setScaleX(this.b);
            this.f6011a.setScaleY(this.b);
            this.f6011a.setVisibility(0);
        }
    }

    public static final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.05f);
        ofFloat.setDuration(750L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.05f);
        ofFloat2.setDuration(750L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 1.05f, 1.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 1.05f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.05f);
        ofFloat5.setDuration(250L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 1.05f);
        ofFloat6.setDuration(250L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat5).with(ofFloat6);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ofFloat3).with(ofFloat4);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.play(ofFloat).with(ofFloat2);
        AnimatorSet animatorSet4 = new AnimatorSet();
        animatorSet4.addListener(new a(view, 0.0f));
        animatorSet4.playSequentially(animatorSet, animatorSet2, animatorSet3);
        animatorSet4.setStartDelay(1000L);
        animatorSet4.start();
    }
}
