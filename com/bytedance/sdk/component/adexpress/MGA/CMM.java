package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes3.dex */
public class CMM extends RelativeLayout {
    private ImageView DbA;
    private AnimatorSet FC;
    private AnimatorSet MGA;
    private ImageView Os;
    private String aAs;
    private TextView aGH;
    private int du;
    private ImageView eli;
    private AnimatorSet kb;
    private TextView ui;
    private AnimatorSet wC;

    public CMM(Context context) {
        super(context);
        this.MGA = new AnimatorSet();
        this.kb = new AnimatorSet();
        this.wC = new AnimatorSet();
        this.FC = new AnimatorSet();
        this.du = 100;
        eli(context);
    }

    public CMM(Context context, String str) {
        super(context);
        this.MGA = new AnimatorSet();
        this.kb = new AnimatorSet();
        this.wC = new AnimatorSet();
        this.FC = new AnimatorSet();
        this.du = 100;
        setClipChildren(false);
        this.aAs = str;
        eli(context);
    }

    protected void eli(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.aGH.eli();
        }
        if (CampaignEx.CLICKMODE_ON.equals(this.aAs)) {
            addView(com.bytedance.sdk.component.adexpress.Os.eli.MGA(context));
            this.du = (int) (this.du * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.Os.eli.ui(context));
        }
        this.eli = (ImageView) findViewById(2097610734);
        this.DbA = (ImageView) findViewById(2097610735);
        this.aGH = (TextView) findViewById(2097610730);
        this.Os = (ImageView) findViewById(2097610733);
        this.ui = (TextView) findViewById(2097610731);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.MGA;
    }

    public void eli() {
        Os();
        this.MGA.start();
        this.MGA.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.MGA.CMM.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CMM.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.CMM.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CMM.this.MGA.start();
                    }
                }, 200L);
            }
        });
    }

    public void Os() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eli, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eli, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eli, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), -this.du));
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), this.du));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.CMM.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (CMM.this.Os != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CMM.this.Os.getLayoutParams();
                    layoutParams.height = num.intValue();
                    CMM.this.Os.setLayoutParams(layoutParams);
                }
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.Os, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.Os, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.DbA, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.DbA, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.DbA, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.DbA, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.DbA, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.aGH.kb.eli(getContext(), -this.du));
        ofFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.kb.setDuration(50L);
        this.FC.setDuration(1500L);
        this.wC.setDuration(50L);
        this.kb.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.wC.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.FC.playTogether(ofFloat3, ofInt, ofFloat10);
        this.MGA.playSequentially(this.wC, this.FC, this.kb);
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
            AnimatorSet animatorSet3 = this.kb;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.FC;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setGuideText(String str) {
        TextView textView = this.aGH;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.ui != null) {
            if (TextUtils.isEmpty(str)) {
                this.ui.setText("");
            } else {
                this.ui.setText(str);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DbA();
    }
}
