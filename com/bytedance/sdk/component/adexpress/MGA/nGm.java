package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* loaded from: classes3.dex */
public class nGm extends View {
    private float DbA;
    private Animator.AnimatorListener FC;
    private long MGA;
    private ValueAnimator Os;
    private int aAs;
    private ValueAnimator aGH;
    private float eli;
    private float kb;
    private Paint ui;
    private float wC;

    public nGm(Context context, int i) {
        super(context);
        this.MGA = 300L;
        this.kb = 0.0f;
        this.aAs = i;
        eli();
    }

    public void eli() {
        Paint paint = new Paint(1);
        this.ui = paint;
        paint.setStyle(Paint.Style.FILL);
        this.ui.setColor(this.aAs);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.eli = i / 2.0f;
        this.DbA = i2 / 2.0f;
        this.wC = (float) (Math.hypot(i, i2) / 2.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.eli, this.DbA, this.kb, this.ui);
    }

    public void DbA() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, this.wC);
        this.Os = ofFloat;
        ofFloat.setDuration(this.MGA);
        this.Os.setInterpolator(new LinearInterpolator());
        this.Os.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.nGm.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                nGm.this.kb = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                nGm.this.invalidate();
            }
        });
        this.Os.start();
    }

    public void Os() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.wC, 0.0f);
        this.aGH = ofFloat;
        ofFloat.setDuration(this.MGA);
        this.aGH.setInterpolator(new LinearInterpolator());
        this.aGH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.nGm.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                nGm.this.kb = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                nGm.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.FC;
        if (animatorListener != null) {
            this.aGH.addListener(animatorListener);
        }
        this.aGH.start();
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.FC = animatorListener;
    }
}
