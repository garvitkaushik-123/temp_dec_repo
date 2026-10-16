package com.bytedance.sdk.component.adexpress.MGA;

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
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class gG extends ImageView {
    private int DbA;
    private int Os;
    private Matrix aGH;
    private Paint eli;

    public gG(Context context) {
        this(context, null);
    }

    public gG(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public gG(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DbA = 25;
        this.Os = 25;
        Paint paint = new Paint();
        this.eli = paint;
        paint.setAntiAlias(true);
        this.eli.setFilterBitmap(true);
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

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable instanceof AnimatedImageDrawable) {
            super.onDraw(canvas);
            return;
        }
        if (drawable != null) {
            Bitmap eli = eli(drawable);
            if (eli != null) {
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                BitmapShader bitmapShader = new BitmapShader(eli, tileMode, tileMode);
                float max = (eli.getWidth() == getWidth() && eli.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / eli.getWidth(), (getHeight() * 1.0f) / eli.getHeight());
                this.aGH.setScale(max, max);
                bitmapShader.setLocalMatrix(this.aGH);
                this.eli.setShader(bitmapShader);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.DbA, this.Os, this.eli);
                return;
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
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
