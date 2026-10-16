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
public class nn extends FrameLayout {
    private ImageView DbA;
    private TextView MGA;
    private aGH Os;
    private AnimatorSet aGH;
    private Context eli;
    private boolean ui;

    public nn(Context context) {
        super(context);
        this.ui = true;
        this.eli = context;
        this.aGH = new AnimatorSet();
        Os();
        aGH();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.nn.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) nn.this.DbA.getLayoutParams();
                layoutParams.topMargin = ((int) ((nn.this.Os.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.aGH.kb.eli(nn.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(nn.this.eli, 20.0f));
                layoutParams.leftMargin = ((int) ((nn.this.Os.getMeasuredWidth() / 2.0f) - com.bytedance.sdk.component.adexpress.aGH.kb.eli(nn.this.getContext(), 5.0f))) + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(nn.this.eli, 20.0f));
                layoutParams.bottomMargin = (int) (((-nn.this.Os.getMeasuredHeight()) / 2.0f) + com.bytedance.sdk.component.adexpress.aGH.kb.eli(nn.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-nn.this.Os.getMeasuredWidth()) / 2.0f) + com.bytedance.sdk.component.adexpress.aGH.kb.eli(nn.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                nn.this.DbA.setLayoutParams(layoutParams);
            }
        });
    }

    private void Os() {
        this.Os = new aGH(this.eli);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 80.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 80.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 20.0f);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 20.0f);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.Os, layoutParams);
        this.Os.eli();
        this.DbA = new ImageView(this.eli);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 80.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 80.0f));
        this.DbA.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(this.eli, "tt_splash_hand"));
        addView(this.DbA, layoutParams2);
        TextView textView = new TextView(this.eli);
        this.MGA = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 10.0f);
        addView(this.MGA, layoutParams3);
    }

    private void aGH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.DbA, "scaleX", 1.0f, 0.8f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.nn.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(nn.this.DbA, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                nn.this.DbA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (nn.this.ui) {
                    nn.this.Os.eli();
                    nn.this.Os.setAlpha(1.0f);
                } else {
                    nn.this.Os.DbA();
                    nn.this.Os.setAlpha(0.0f);
                }
                nn.this.ui = !r2.ui;
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.DbA, "scaleY", 1.0f, 0.8f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.aGH.playTogether(ofFloat, ofFloat2);
    }

    public void setGuideText(String str) {
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
        aGH agh = this.Os;
        if (agh != null) {
            agh.DbA();
        }
    }
}
