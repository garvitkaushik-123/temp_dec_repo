package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.e;

/* loaded from: classes2.dex */
public final class n extends e {
    private static final Paint c = new Paint(1);
    private static final Paint d = new Paint(1);
    private static final Paint e = new Paint(1);

    public n(Context context) {
        super(context);
        c.setColor(-1);
        d.setColor(-16777216);
        Paint paint = e;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    protected float getCenter() {
        return getSize() / 2.0f;
    }

    protected float getCrossOffset() {
        return this.f385a * 10.0f;
    }

    protected float getInnerCircleOffset() {
        return this.f385a * 2.0f;
    }

    protected float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    protected float getStrokeWidth() {
        return this.f385a * 3.0f;
    }

    @Override // com.applovin.impl.adview.e
    public e.a getStyle() {
        return e.a.WHITE_ON_BLACK;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, c);
        canvas.drawCircle(center, center, getInnerCircleRadius(), d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = e;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawLine(crossOffset, crossOffset, size, size, paint);
        canvas.drawLine(crossOffset, size, size, crossOffset, paint);
    }
}
