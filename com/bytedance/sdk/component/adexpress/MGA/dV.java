package com.bytedance.sdk.component.adexpress.MGA;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes3.dex */
public class dV extends View {
    private Paint DbA;
    private int MGA;
    private RectF Os;
    private float aGH;
    private Context eli;
    private boolean kb;
    private ValueAnimator ui;

    public dV(Context context) {
        super(context);
        this.MGA = 1500;
        this.eli = context;
        Paint paint = new Paint();
        this.DbA = paint;
        paint.setAntiAlias(true);
        this.DbA.setStyle(Paint.Style.STROKE);
        this.DbA.setStrokeWidth(10.0f);
        this.DbA.setColor(Color.parseColor("#80FFFFFF"));
        this.Os = new RectF();
    }

    public void eli() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.ui = ofFloat;
        ofFloat.setDuration(this.MGA);
        this.ui.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.dV.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dV.this.aGH = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                dV.this.requestLayout();
            }
        });
        this.ui.start();
    }

    public void DbA() {
        ValueAnimator valueAnimator = this.ui;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void Os() {
        this.kb = true;
        invalidate();
    }

    public void setDuration(int i) {
        this.MGA = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kb) {
            return;
        }
        canvas.drawArc(this.Os, 270.0f, this.aGH, false, this.DbA);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Os.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }
}
