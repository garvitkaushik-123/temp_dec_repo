package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* loaded from: classes3.dex */
public class Dfc extends com.bytedance.sdk.openadsdk.core.ui.wC {
    private RectF DbA;
    private int Os;
    private Paint eli;

    public Dfc(Context context) {
        this(context, null);
    }

    public Dfc(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Dfc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Os = 0;
        eli();
    }

    private void eli() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.eli = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.eli.setColor(Color.parseColor("#99333333"));
        this.eli.setAntiAlias(true);
        this.eli.setStrokeWidth(0.0f);
        this.DbA = new RectF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ui.wC, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int measureText = (int) getPaint().measureText("00");
            this.Os = measureText;
            if (measuredWidth < measureText) {
                measuredWidth = measureText;
            }
            int i3 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i3, measuredHeight);
            this.DbA.set(0.0f, 0.0f, i3, measuredHeight);
            return;
        }
        this.DbA.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.DbA;
        canvas.drawRoundRect(rectF, rectF.bottom / 2.0f, this.DbA.bottom / 2.0f, this.eli);
        canvas.translate((this.DbA.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
