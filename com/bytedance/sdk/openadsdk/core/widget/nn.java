package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/* loaded from: classes3.dex */
public class nn extends com.bytedance.sdk.openadsdk.core.ui.aGH {
    private RectF DbA;
    private Paint eli;

    public nn(Context context) {
        super(context);
        eli();
    }

    private void eli() {
        Paint paint = new Paint();
        this.eli = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.eli.setColor(Color.parseColor("#99333333"));
        this.eli.setAntiAlias(true);
        this.eli.setStrokeWidth(0.0f);
        this.DbA = new RectF();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ui.aGH, android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.DbA.right == getMeasuredWidth() && this.DbA.bottom == getMeasuredHeight()) {
            return;
        }
        this.DbA.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.DbA;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.DbA.bottom / 2.0f, this.eli);
        super.onDraw(canvas);
    }
}
