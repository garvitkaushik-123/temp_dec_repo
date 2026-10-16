package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class aqO extends FrameLayout {
    private ImageView DbA;
    private TextView MGA;
    private ev Os;
    private AnimatorSet aGH;
    private Context eli;
    private boolean ui;

    public aqO(Context context) {
        super(context);
        this.ui = true;
        this.eli = context;
        this.aGH = new AnimatorSet();
        Os();
        aGH();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.aqO.1
            @Override // java.lang.Runnable
            public void run() {
                int eli = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(aqO.this.eli, 50.0f);
                int eli2 = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(aqO.this.eli, 50.0f);
                if (aqO.this.Os.getMeasuredHeight() > 0) {
                    eli = aqO.this.Os.getMeasuredHeight();
                }
                if (aqO.this.Os.getMeasuredWidth() > 0) {
                    eli2 = aqO.this.Os.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aqO.this.DbA.getLayoutParams();
                layoutParams.topMargin = ((int) ((eli / 2.0f) - com.bytedance.sdk.component.adexpress.aGH.kb.eli(aqO.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(aqO.this.eli, 40.0f));
                layoutParams.leftMargin = ((int) ((eli2 / 2.0f) - com.bytedance.sdk.component.adexpress.aGH.kb.eli(aqO.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(aqO.this.eli, 20.0f));
                layoutParams.bottomMargin = (int) (((-eli) / 2.0f) + com.bytedance.sdk.component.adexpress.aGH.kb.eli(aqO.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-eli2) / 2.0f) + com.bytedance.sdk.component.adexpress.aGH.kb.eli(aqO.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                aqO.this.DbA.setLayoutParams(layoutParams);
            }
        });
    }

    private void Os() {
        this.Os = new ev(this.eli);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 50.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 40.0f);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.Os, layoutParams);
        this.DbA = new ImageView(this.eli);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 78.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 78.0f));
        this.DbA.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(this.eli, "tt_splash_hand"));
        addView(this.DbA, layoutParams2);
        TextView textView = new TextView(this.eli);
        this.MGA = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 10.0f);
        addView(this.MGA, layoutParams3);
        this.MGA.setVisibility(8);
    }

    private void aGH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.DbA, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat.setDuration(600L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.aqO.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aqO.this.DbA, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                aqO.this.DbA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (aqO.this.ui) {
                    aqO.this.Os.eli();
                }
                aqO.this.ui = !r2.ui;
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.DbA, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat2.setDuration(600L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.aGH.playTogether(ofFloat, ofFloat2);
    }

    public void setGuideText(String str) {
        this.MGA.setVisibility(0);
        this.MGA.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.MGA.setTextColor(i);
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
