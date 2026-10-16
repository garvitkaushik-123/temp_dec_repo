package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class bf extends FrameLayout {
    private ImageView DbA;
    private AnimatorSet FC;
    private AnimatorSet MGA;
    private ImageView Os;
    private ImageView aGH;
    private Context eli;
    private AnimatorSet kb;
    private TextView ui;
    private AnimatorSet wC;

    public bf(Context context) {
        super(context);
        this.MGA = new AnimatorSet();
        this.kb = new AnimatorSet();
        this.wC = new AnimatorSet();
        this.FC = new AnimatorSet();
        this.eli = context;
        Os();
    }

    private void Os() {
        ImageView imageView = new ImageView(this.eli);
        this.aGH = imageView;
        imageView.setBackgroundResource(com.bytedance.sdk.component.utils.ev.aGH(this.eli, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 30.0f);
        addView(this.aGH, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.eli);
        this.Os = imageView2;
        imageView2.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(this.eli, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 50.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 30.0f);
        addView(this.Os, layoutParams2);
        ImageView imageView3 = new ImageView(this.eli);
        this.DbA = imageView3;
        imageView3.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(this.eli, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 80.0f), (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.eli, 30.0f);
        addView(this.DbA, layoutParams3);
        TextView textView = new TextView(this.eli);
        this.ui = textView;
        textView.setTextColor(-1);
        this.ui.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.ui, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.bf.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) bf.this.DbA.getLayoutParams();
                layoutParams5.topMargin = (int) ((bf.this.Os.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.aGH.kb.eli(bf.this.getContext(), 7.0f));
                layoutParams5.leftMargin = (-bf.this.Os.getMeasuredWidth()) + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(bf.this.eli, 30.0f));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                bf.this.DbA.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) bf.this.aGH.getLayoutParams();
                layoutParams6.topMargin = (int) ((bf.this.Os.getMeasuredHeight() / 2.0f) - com.bytedance.sdk.component.adexpress.aGH.kb.eli(bf.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((bf.this.Os.getMeasuredWidth() / 2.0f) + ((int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(bf.this.eli, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                bf.this.aGH.setLayoutParams(layoutParams6);
            }
        });
    }

    private void aGH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.DbA, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.Os, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.Os, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.aGH, "alpha", 0.0f, 1.0f);
        this.wC.setDuration(300L);
        this.wC.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.DbA, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), 90.0f));
        ofFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), 90.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.bf.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bf.this.aGH.getLayoutParams();
                layoutParams.width = num.intValue();
                bf.this.aGH.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.Os, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), 90.0f));
        ofFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.FC.setDuration(1500L);
        this.FC.playTogether(ofFloat5, ofInt, ofFloat6);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.DbA, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.aGH, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.Os, "alpha", 1.0f, 0.0f);
        this.kb.setDuration(50L);
        this.kb.playTogether(ofFloat7, ofFloat8, ofFloat9);
        this.MGA.playSequentially(this.wC, this.FC, this.kb);
    }

    public void eli() {
        aGH();
        this.MGA.start();
        this.MGA.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.MGA.bf.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                bf.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.bf.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        bf.this.MGA.start();
                    }
                }, 200L);
            }
        });
    }

    public void DbA() {
        try {
            AnimatorSet animatorSet = this.MGA;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.wC;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.FC;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.kb;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }

    public void setGuideText(String str) {
        this.ui.setText(str);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
