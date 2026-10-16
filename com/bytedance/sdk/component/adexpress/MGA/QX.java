package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class QX extends LinearLayout {
    private TextView DbA;
    private int FC;
    private TextView MGA;
    private ImageView Os;
    private int aAs;
    private com.bytedance.sdk.component.utils.Vy aGH;
    private int du;
    private TextView eli;
    private eli kb;
    private JSONObject nlS;
    private TextView ui;
    private LinearLayout wC;

    public interface eli {
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
    }

    public QX(Context context, View view, int i, int i2, int i3, JSONObject jSONObject) {
        super(context);
        this.FC = i;
        this.aAs = i2;
        this.du = i3;
        this.nlS = jSONObject;
        eli(context, view);
    }

    protected void eli(Context context, View view) {
        addView(view);
        this.wC = (LinearLayout) findViewById(2097610727);
        this.Os = (ImageView) findViewById(2097610725);
        this.eli = (TextView) findViewById(2097610724);
        this.DbA = (TextView) findViewById(2097610726);
        this.ui = (TextView) findViewById(2097610723);
        this.MGA = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.wC.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ui.setVisibility(8);
            this.MGA.setVisibility(8);
        } else {
            this.ui.setText(str);
        }
    }

    public LinearLayout getShakeLayout() {
        return this.wC;
    }

    public void setOnShakeViewListener(eli eliVar) {
        this.kb = eliVar;
    }

    public void eli() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.MGA.QX$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QX.this.Os != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new DbA(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.QX.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        QX.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.MGA.QX.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QX.this.Os.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }
                });
                QX.this.Os.startAnimation(rotateAnimation);
            }
        }
    }

    private static class DbA implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * (-2.0f)) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }

        private DbA() {
        }

        /* synthetic */ DbA(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.aGH == null) {
                this.aGH = new com.bytedance.sdk.component.utils.Vy(getContext().getApplicationContext(), 1);
            }
            new Object() { // from class: com.bytedance.sdk.component.adexpress.MGA.QX.2
            };
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
