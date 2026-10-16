package io.bidmachine.iab.vast.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import io.bidmachine.iab.utils.Assets;
import io.bidmachine.iab.utils.IabElement;
import io.bidmachine.iab.utils.IabElementStyle;
import io.bidmachine.iab.utils.Utils;

/* loaded from: classes7.dex */
public class LinearCountdownView extends View implements IabElement {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f6929a;
    private float b;
    private float c;
    private int d;
    private int e;

    public LinearCountdownView(Context context) {
        super(context);
        this.f6929a = new Paint(1);
        this.b = 0.0f;
        this.c = 15.0f;
        this.d = Assets.MAIN_ASSETS_COLOR;
        this.e = 0;
        a();
    }

    private void a() {
        this.c = Utils.dpToPx(getContext(), 4.0f);
    }

    public void changePercentage(float percent) {
        this.b = percent;
        postInvalidate();
    }

    public int getLineColor() {
        return this.d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        float measuredHeight = (getMeasuredHeight() / 2.0f) + getPaddingTop();
        this.f6929a.setStrokeWidth(this.c);
        this.f6929a.setColor(this.e);
        canvas.drawLine(getPaddingLeft(), measuredHeight, getPaddingLeft() + width, measuredHeight, this.f6929a);
        this.f6929a.setColor(this.d);
        canvas.drawLine(getPaddingLeft(), measuredHeight, getPaddingLeft() + ((width * this.b) / 100.0f), measuredHeight, this.f6929a);
    }

    @Override // io.bidmachine.iab.utils.IabElement
    public void setStyle(IabElementStyle style) {
        this.d = style.getStrokeColor().intValue();
        this.e = style.getFillColor().intValue();
        this.c = style.getStrokeWidth(getContext()).floatValue();
        setAlpha(style.getOpacity().floatValue());
        postInvalidate();
    }

    public LinearCountdownView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f6929a = new Paint(1);
        this.b = 0.0f;
        this.c = 15.0f;
        this.d = Assets.MAIN_ASSETS_COLOR;
        this.e = 0;
        a();
    }
}
