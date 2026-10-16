package io.bidmachine.iab.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes7.dex */
public final class CircularProgressBar extends ProgressBar implements IabElement {

    /* renamed from: a, reason: collision with root package name */
    CircularProgressDrawable f6842a;
    final Paint b;

    public CircularProgressBar(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(0);
        a(context);
    }

    void a(Context context) {
        float f = getResources().getDisplayMetrics().density;
        int dpToPx = Utils.dpToPx(context, 8.0f);
        setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        this.f6842a = circularProgressDrawable;
        circularProgressDrawable.setStrokeWidth(f * 4.0f);
        this.f6842a.setColorSchemeColors(-65536);
        this.f6842a.setStrokeCap(Paint.Cap.ROUND);
        setIndeterminateDrawable(this.f6842a);
        setIndeterminate(true);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, Math.min(getWidth(), getHeight()) / 2.0f, this.b);
        super.onDraw(canvas);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.f6842a.setCenterRadius((Math.min((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f) - this.f6842a.getStrokeWidth());
    }

    public void setColorSchemeColors(int... colors) {
        this.f6842a.setColorSchemeColors(colors);
    }

    public void setProgressBackgroundColor(int color) {
        this.b.setColor(color);
    }

    @Override // io.bidmachine.iab.utils.IabElement
    public void setStyle(IabElementStyle style) {
        this.f6842a.setStrokeWidth(style.getStrokeWidth(getContext()).floatValue());
        this.f6842a.setColorSchemeColors(style.getStrokeColor().intValue());
        this.b.setColor(style.getFillColor().intValue());
        postInvalidate();
    }

    public CircularProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(0);
        a(context);
    }

    public CircularProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setColor(0);
        a(context);
    }
}
