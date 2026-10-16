package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class Dfc extends FrameLayout {
    private ImageView DbA;
    private ev Os;
    private AnimatorSet aGH;
    private Context eli;
    private boolean ui;

    public Dfc(Context context) {
        super(context);
        this.ui = true;
        this.eli = context;
        this.aGH = new AnimatorSet();
        Os();
        aGH();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.Dfc.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) Dfc.this.DbA.getLayoutParams();
                layoutParams.topMargin = (int) ((Dfc.this.Os.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.aGH.kb.eli(Dfc.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((Dfc.this.Os.getMeasuredWidth() / 2.0f) - com.bytedance.sdk.component.adexpress.aGH.kb.eli(Dfc.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-Dfc.this.Os.getMeasuredHeight()) / 2.0f) + com.bytedance.sdk.component.adexpress.aGH.kb.eli(Dfc.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-Dfc.this.Os.getMeasuredWidth()) / 2.0f) + com.bytedance.sdk.component.adexpress.aGH.kb.eli(Dfc.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                Dfc.this.DbA.setLayoutParams(layoutParams);
            }
        });
    }

    private void Os() {
        this.Os = new ev(this.eli);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 40.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.Os, layoutParams);
        this.DbA = new ImageView(this.eli);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 62.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 62.0f));
        layoutParams2.gravity = 16;
        this.DbA.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(this.eli, "tt_splash_hand"));
        addView(this.DbA, layoutParams2);
    }

    private void aGH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.DbA, "scaleX", 1.0f, 0.9f);
        ofFloat.setDuration(800L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.Dfc.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(Dfc.this.DbA, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat2.start();
                Dfc.this.DbA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (Dfc.this.ui) {
                    Dfc.this.Os.eli();
                }
                Dfc.this.ui = !r2.ui;
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.DbA, "scaleY", 1.0f, 0.9f);
        ofFloat2.setDuration(800L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aGH.playTogether(ofFloat, ofFloat2);
    }

    public void eli() {
        this.aGH.start();
    }

    public void DbA() {
        AnimatorSet animatorSet = this.aGH;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ev evVar = this.Os;
        if (evVar != null) {
            evVar.DbA();
        }
        ImageView imageView = this.DbA;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}
