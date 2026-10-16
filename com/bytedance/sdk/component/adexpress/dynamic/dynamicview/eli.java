package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: classes3.dex */
public class eli extends DbA {
    private final Bitmap Os;
    private final Rect DbA = new Rect();
    private final Paint aGH = new Paint(1);

    public eli(Bitmap bitmap, DbA dbA) {
        this.Os = bitmap;
        if (dbA != null) {
            this.eli = dbA.eli;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int height = rect.height();
        int width = rect.width();
        int width2 = this.Os.getWidth();
        int height2 = this.Os.getHeight();
        this.DbA.set(0, 0, width2, height2);
        if (height2 >= height && width2 >= width) {
            if (width2 > width) {
                this.DbA.left = (width2 - width) / 2;
                Rect rect2 = this.DbA;
                rect2.right = rect2.left + width;
            }
            if (height2 > height) {
                this.DbA.top = (height2 - height) / 2;
                Rect rect3 = this.DbA;
                rect3.bottom = rect3.top + height;
                return;
            }
            return;
        }
        float f = height;
        float f2 = f * 1.0f;
        float f3 = height2;
        float f4 = f2 / f3;
        float f5 = width;
        float f6 = 1.0f * f5;
        float f7 = width2;
        if (Math.max(f4, f6 / f7) > f4) {
            int i = (int) ((f2 / f5) * f7);
            this.DbA.top = (height2 - i) / 2;
            Rect rect4 = this.DbA;
            rect4.bottom = rect4.top + i;
            return;
        }
        int i2 = (int) ((f6 / f) * f3);
        this.DbA.left = (width2 - i2) / 2;
        Rect rect5 = this.DbA;
        rect5.right = rect5.left + i2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DbA
    protected void eli(Canvas canvas) {
        canvas.drawBitmap(this.Os, this.DbA, getBounds(), this.aGH);
    }
}
