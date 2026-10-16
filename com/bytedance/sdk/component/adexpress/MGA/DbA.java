package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class DbA extends FrameLayout {
    private ObjectAnimator DbA;
    private int FC;
    private View MGA;
    private boolean Os;
    private Context aAs;
    private View aGH;
    private AnimatorSet eli;
    private ImageView kb;
    private View ui;
    private int wC;

    public DbA(Context context, int i, int i2) {
        super(context);
        this.Os = false;
        this.eli = new AnimatorSet();
        this.wC = i;
        this.FC = i2;
        this.aAs = context;
        Os();
        aGH();
    }

    private void Os() {
        View view = new View(this.aAs);
        this.aGH = view;
        view.setBackground(eli("#1A7BBEFF", "#337BBEFF"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (this.wC * 0.45d), (int) (this.FC * 0.45d));
        layoutParams.gravity = 17;
        this.aGH.setLayoutParams(layoutParams);
        addView(this.aGH);
        View view2 = new View(this.aAs);
        this.ui = view2;
        view2.setBackground(eli("#337BBEFF", "#807BBEFF"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (this.wC * 0.25d), (int) (this.FC * 0.25d));
        layoutParams2.gravity = 17;
        this.ui.setLayoutParams(layoutParams2);
        addView(this.ui);
        View view3 = new View(this.aAs);
        this.MGA = view3;
        view3.setBackground(eli("#807BBEFF", "#FF7BBEFF"));
        int i = this.wC;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (i * 0.25d), (int) (i * 0.25d));
        layoutParams3.gravity = 17;
        this.MGA.setLayoutParams(layoutParams3);
        addView(this.MGA);
        ImageView imageView = new ImageView(this.aAs);
        this.kb = imageView;
        imageView.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(getContext(), "tt_blue_hand"));
        this.kb.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (this.wC * 0.62d), (int) (this.FC * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.kb.setLayoutParams(layoutParams4);
        addView(this.kb);
    }

    private void aGH() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.aGH, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.aGH, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ui, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ui, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.MGA, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.MGA, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.kb, "rotation", 0.0f, -20.0f, 0.0f);
        this.DbA = ofFloat7;
        ofFloat7.setDuration(1000L);
        this.eli.setDuration(1500L);
        this.eli.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eli.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.eli.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.DbA.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (DbA.this.Os) {
                    return;
                }
                DbA.this.DbA.start();
                DbA.this.eli.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                DbA.this.Os = true;
            }
        });
    }

    private GradientDrawable eli(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void eli() {
        this.Os = false;
        ObjectAnimator objectAnimator = this.DbA;
        if (objectAnimator == null || this.eli == null) {
            return;
        }
        objectAnimator.start();
        this.eli.start();
    }

    public void DbA() {
        this.Os = true;
        ObjectAnimator objectAnimator = this.DbA;
        if (objectAnimator == null || this.eli == null) {
            return;
        }
        objectAnimator.cancel();
        this.eli.cancel();
    }
}
