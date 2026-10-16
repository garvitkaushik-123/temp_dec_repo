package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
public class ev extends View {
    private static int Os = 50;
    private int DbA;
    private ObjectAnimator aGH;
    private Paint eli;

    public ev(Context context) {
        this(context, null);
    }

    public ev(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ev(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DbA = 10;
        Os();
    }

    private void Os() {
        Paint paint = new Paint();
        this.eli = paint;
        paint.setAntiAlias(true);
        this.eli.setColor(Color.parseColor("#FFFFFFFF"));
        this.eli.setStyle(Paint.Style.STROKE);
        this.eli.setStrokeWidth(18.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.aGH = ofFloat;
        ofFloat.setDuration(200L);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.eli.setShader(new LinearGradient(getMeasuredWidth() / 2, 0.0f, getMeasuredWidth() / 2, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.DbA, this.eli);
    }

    public void eli() {
        int min = ((int) Math.min(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f)) - 18;
        Os = min;
        ValueAnimator ofInt = ValueAnimator.ofInt(10, min);
        ofInt.setInterpolator(new PathInterpolator(0.0f, 0.2f, 0.3f, 1.0f));
        ofInt.setDuration(800L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.ev.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ev.this.DbA = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ev.this.invalidate();
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.ev.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ev.this.setVisibility(0);
                ev.this.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ev.this.aGH.start();
            }
        });
        ofInt.start();
    }

    public void DbA() {
        clearAnimation();
    }
}
