package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;

/* loaded from: classes3.dex */
public class DbA extends GradientDrawable {
    private final Paint DbA;
    protected Path eli;

    public DbA() {
        this.eli = new Path();
        Paint paint = new Paint(1);
        this.DbA = paint;
        paint.setColor(-1);
    }

    public DbA(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.eli = new Path();
        Paint paint = new Paint(1);
        this.DbA = paint;
        paint.setColor(-1);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.eli;
        if (path == null || path.isEmpty()) {
            eli(canvas);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.DbA, 31);
        eli(canvas);
        this.DbA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.eli, this.DbA);
        this.DbA.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    protected void eli(Canvas canvas) {
        super.draw(canvas);
    }

    public void eli(int i, int i2, int i3, int i4) {
        this.eli.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }
}
