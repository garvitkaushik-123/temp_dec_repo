package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes3.dex */
public class FC extends View {
    private int DbA;
    private int MGA;
    private final RectF Os;
    private Paint aGH;
    private int eli;
    private Paint kb;
    private Paint ui;
    private int wC;

    public FC(Context context) {
        super(context);
        this.Os = new RectF();
        eli();
    }

    private void eli() {
        Paint paint = new Paint();
        this.aGH = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.kb = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.ui = paint3;
        paint3.setAntiAlias(true);
    }

    public void setRadius(int i) {
        this.MGA = i;
    }

    public void setDislikeColor(int i) {
        this.kb.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.kb.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.aGH.setStyle(Paint.Style.STROKE);
        this.aGH.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.aGH.setStrokeWidth(i);
        this.wC = i;
    }

    public void setBgColor(int i) {
        this.ui.setStyle(Paint.Style.FILL);
        this.ui.setColor(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.Os;
        int i = this.MGA;
        canvas.drawRoundRect(rectF, i, i, this.ui);
        RectF rectF2 = this.Os;
        int i2 = this.MGA;
        canvas.drawRoundRect(rectF2, i2, i2, this.aGH);
        int i3 = this.eli;
        int i4 = this.DbA;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.kb);
        int i5 = this.eli;
        int i6 = this.DbA;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.kb);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.eli = i;
        this.DbA = i2;
        RectF rectF = this.Os;
        int i5 = this.wC;
        rectF.set(i5, i5, i - i5, i2 - i5);
    }
}
