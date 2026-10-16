package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: classes3.dex */
public class dV extends com.bytedance.sdk.openadsdk.core.ui.aGH {
    private int DbA;
    private BitmapShader MGA;
    private int Os;
    private final Matrix aGH;
    private final Paint eli;
    private final RectF ui;

    public dV(Context context) {
        this(context, null);
    }

    public dV(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public dV(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DbA = 25;
        this.Os = 25;
        this.ui = new RectF();
        Paint paint = new Paint();
        this.eli = paint;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        this.aGH = new Matrix();
    }

    public void setXRound(int i) {
        this.DbA = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.Os = i;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.ui.set(0.0f, 0.0f, i, i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap eli;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        if (drawable instanceof AnimatedImageDrawable) {
            super.onDraw(canvas);
            return;
        }
        if (this.MGA == null && (eli = eli(drawable)) != null) {
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.MGA = new BitmapShader(eli, tileMode, tileMode);
            float max = (eli.getWidth() == getWidth() && eli.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / eli.getWidth(), (getHeight() * 1.0f) / eli.getHeight());
            this.aGH.setScale(max, max);
            this.MGA.setLocalMatrix(this.aGH);
        }
        BitmapShader bitmapShader = this.MGA;
        if (bitmapShader != null) {
            this.eli.setShader(bitmapShader);
            canvas.drawRoundRect(this.ui, this.DbA, this.Os, this.eli);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        this.MGA = null;
    }

    private Bitmap eli(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return createBitmap;
    }
}
