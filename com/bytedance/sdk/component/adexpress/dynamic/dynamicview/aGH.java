package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class aGH extends MGA {
    ObjectAnimator DbA;
    private int Xb;
    private Runnable bf;
    ObjectAnimator eli;

    /* JADX INFO: Access modifiers changed from: private */
    public void eli() {
        final View childAt = getChildAt(this.Xb);
        final View childAt2 = getChildAt((this.Xb + 1) % getChildCount());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.wC + getChildAt(this.Xb).getHeight())) / 2);
        this.eli = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.eli.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.aGH.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.wC + childAt2.getHeight()) / 2, 0.0f);
        this.DbA = ofFloat2;
        ofFloat2.setInterpolator(new LinearInterpolator());
        this.DbA.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.aGH.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt2.setVisibility(0);
            }
        });
        this.eli.setDuration(500L);
        this.DbA.setDuration(500L);
        this.eli.start();
        this.DbA.start();
        int i = this.Xb + 1;
        this.Xb = i;
        this.Xb = i % getChildCount();
        postDelayed(this.bf, 2000L);
    }

    public aGH(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.Xb = 0;
        this.bf = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.aGH.1
            @Override // java.lang.Runnable
            public void run() {
                aGH.this.eli();
            }
        };
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.wC - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.bf, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cp
    public void DbA() {
        removeCallbacks(this.bf);
        ObjectAnimator objectAnimator = this.eli;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.eli.cancel();
        }
        ObjectAnimator objectAnimator2 = this.DbA;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.DbA.cancel();
        }
        super.DbA();
    }
}
