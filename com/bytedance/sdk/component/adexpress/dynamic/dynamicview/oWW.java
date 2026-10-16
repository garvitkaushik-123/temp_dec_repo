package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class oWW extends MGA {
    private Runnable CMM;
    ObjectAnimator DbA;
    private int Xb;
    private boolean bf;
    ObjectAnimator eli;

    public oWW(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
        this.Xb = 0;
        this.bf = false;
        this.CMM = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.oWW.1
            @Override // java.lang.Runnable
            public void run() {
                oWW.this.eli();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli() {
        View childAt;
        final View view;
        final View childAt2 = getChildAt(this.Xb);
        int i = this.Xb;
        if (i == 0) {
            this.bf = false;
        }
        boolean z = i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.Xb + 1)).getChildCount() <= 0;
        if (!this.NU.aAs().ui().eli() && z) {
            this.bf = true;
            view = getChildAt(this.Xb - 1);
            this.eli = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (this.wC + getChildAt(this.Xb).getHeight()) / 2);
        } else {
            if (z) {
                childAt = getChildAt((this.Xb + 2) % getChildCount());
            } else {
                childAt = getChildAt((this.Xb + 1) % getChildCount());
            }
            this.eli = ObjectAnimator.ofFloat(childAt2, "translationY", 0.0f, (-(this.wC + getChildAt(this.Xb).getHeight())) / 2);
            if (z) {
                this.Xb++;
            }
            view = childAt;
        }
        this.eli.setInterpolator(new LinearInterpolator());
        this.eli.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.oWW.2
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
                childAt2.setVisibility(8);
            }
        });
        if (this.bf) {
            this.DbA = ObjectAnimator.ofFloat(view, "translationY", (-(this.wC + view.getHeight())) / 2, 0.0f);
        } else {
            this.DbA = ObjectAnimator.ofFloat(view, "translationY", (this.wC + view.getHeight()) / 2, 0.0f);
        }
        this.DbA.setInterpolator(new LinearInterpolator());
        this.DbA.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.oWW.3
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
                view.setVisibility(0);
            }
        });
        this.eli.setDuration(500L);
        this.DbA.setDuration(500L);
        this.eli.start();
        this.DbA.start();
        if (this.bf) {
            this.Xb--;
        } else {
            int i2 = this.Xb + 1;
            this.Xb = i2;
            this.Xb = i2 % getChildCount();
        }
        postDelayed(this.CMM, 3000L);
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
        postDelayed(this.CMM, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cp
    public void DbA() {
        removeCallbacks(this.CMM);
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
