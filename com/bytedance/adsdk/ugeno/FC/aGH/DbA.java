package com.bytedance.adsdk.ugeno.FC.aGH;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class DbA extends Drawable {
    private float Dfc;
    private final Paint FC;
    private final int MGA;
    private Shader.TileMode NU;
    private final RectF Os;
    private ColorStateList QX;
    private ImageView.ScaleType Xb;
    private final Matrix aAs;
    private final Bitmap aGH;
    private final boolean[] aqO;
    private boolean dV;
    private final RectF du;
    private final int kb;
    private float nGm;
    private Shader.TileMode nlS;
    private boolean nn;
    private final Paint ui;
    private final RectF wC;
    private final RectF eli = new RectF();
    private final RectF DbA = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public DbA(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.Os = rectF;
        this.wC = new RectF();
        this.aAs = new Matrix();
        this.du = new RectF();
        this.nlS = Shader.TileMode.CLAMP;
        this.NU = Shader.TileMode.CLAMP;
        this.nn = true;
        this.Dfc = 0.0f;
        this.aqO = new boolean[]{true, true, true, true};
        this.dV = false;
        this.nGm = 0.0f;
        this.QX = ColorStateList.valueOf(-16777216);
        this.Xb = ImageView.ScaleType.FIT_CENTER;
        this.aGH = bitmap;
        int width = bitmap.getWidth();
        this.MGA = width;
        int height = bitmap.getHeight();
        this.kb = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.ui = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.FC = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.QX.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.nGm);
    }

    public static DbA eli(Bitmap bitmap) {
        if (bitmap != null) {
            return new DbA(bitmap);
        }
        return null;
    }

    public static Drawable eli(Drawable drawable) {
        if (drawable != null) {
            if ((drawable instanceof DbA) || (drawable instanceof AnimatedImageDrawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), eli(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap DbA = DbA(drawable);
        return DbA != null ? new DbA(DbA) : drawable;
    }

    public static Bitmap DbA(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable unused) {
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.QX.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.QX.getColorForState(iArr, 0);
        if (this.FC.getColor() != colorForState) {
            this.FC.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    /* renamed from: com.bytedance.adsdk.ugeno.FC.aGH.DbA$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            eli = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eli[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eli[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                eli[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                eli[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                eli[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void eli() {
        float width;
        float height;
        int i = AnonymousClass1.eli[this.Xb.ordinal()];
        if (i == 1) {
            this.wC.set(this.eli);
            RectF rectF = this.wC;
            float f = this.nGm;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.aAs.reset();
            this.aAs.setTranslate((int) (((this.wC.width() - this.MGA) * 0.5f) + 0.5f), (int) (((this.wC.height() - this.kb) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.wC.set(this.eli);
            RectF rectF2 = this.wC;
            float f2 = this.nGm;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.aAs.reset();
            float f3 = 0.0f;
            if (this.MGA * this.wC.height() > this.wC.width() * this.kb) {
                width = this.wC.height() / this.kb;
                height = 0.0f;
                f3 = (this.wC.width() - (this.MGA * width)) * 0.5f;
            } else {
                width = this.wC.width() / this.MGA;
                height = (this.wC.height() - (this.kb * width)) * 0.5f;
            }
            this.aAs.setScale(width, width);
            Matrix matrix = this.aAs;
            float f4 = this.nGm;
            matrix.postTranslate(((int) (f3 + 0.5f)) + (f4 / 2.0f), ((int) (height + 0.5f)) + (f4 / 2.0f));
        } else if (i == 3) {
            this.aAs.reset();
            float min = (((float) this.MGA) > this.eli.width() || ((float) this.kb) > this.eli.height()) ? Math.min(this.eli.width() / this.MGA, this.eli.height() / this.kb) : 1.0f;
            float width2 = (int) (((this.eli.width() - (this.MGA * min)) * 0.5f) + 0.5f);
            float height2 = (int) (((this.eli.height() - (this.kb * min)) * 0.5f) + 0.5f);
            this.aAs.setScale(min, min);
            this.aAs.postTranslate(width2, height2);
            this.wC.set(this.Os);
            this.aAs.mapRect(this.wC);
            RectF rectF3 = this.wC;
            float f5 = this.nGm;
            rectF3.inset(f5 / 2.0f, f5 / 2.0f);
            this.aAs.setRectToRect(this.Os, this.wC, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.wC.set(this.Os);
            this.aAs.setRectToRect(this.Os, this.eli, Matrix.ScaleToFit.END);
            this.aAs.mapRect(this.wC);
            RectF rectF4 = this.wC;
            float f6 = this.nGm;
            rectF4.inset(f6 / 2.0f, f6 / 2.0f);
            this.aAs.setRectToRect(this.Os, this.wC, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.wC.set(this.Os);
            this.aAs.setRectToRect(this.Os, this.eli, Matrix.ScaleToFit.START);
            this.aAs.mapRect(this.wC);
            RectF rectF5 = this.wC;
            float f7 = this.nGm;
            rectF5.inset(f7 / 2.0f, f7 / 2.0f);
            this.aAs.setRectToRect(this.Os, this.wC, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.wC.set(this.Os);
            this.aAs.setRectToRect(this.Os, this.eli, Matrix.ScaleToFit.CENTER);
            this.aAs.mapRect(this.wC);
            RectF rectF6 = this.wC;
            float f8 = this.nGm;
            rectF6.inset(f8 / 2.0f, f8 / 2.0f);
            this.aAs.setRectToRect(this.Os, this.wC, Matrix.ScaleToFit.FILL);
        } else {
            this.wC.set(this.eli);
            RectF rectF7 = this.wC;
            float f9 = this.nGm;
            rectF7.inset(f9 / 2.0f, f9 / 2.0f);
            this.aAs.reset();
            this.aAs.setRectToRect(this.Os, this.wC, Matrix.ScaleToFit.FILL);
        }
        this.DbA.set(this.wC);
        this.nn = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.eli.set(rect);
        eli();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.nn) {
            BitmapShader bitmapShader = new BitmapShader(this.aGH, this.nlS, this.NU);
            if (this.nlS == Shader.TileMode.CLAMP && this.NU == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.aAs);
            }
            this.ui.setShader(bitmapShader);
            this.nn = false;
        }
        if (this.dV) {
            if (this.nGm > 0.0f) {
                canvas.drawOval(this.DbA, this.ui);
                canvas.drawOval(this.wC, this.FC);
                return;
            } else {
                canvas.drawOval(this.DbA, this.ui);
                return;
            }
        }
        if (eli(this.aqO)) {
            float f = this.Dfc;
            if (this.nGm > 0.0f) {
                canvas.drawRoundRect(this.DbA, f, f, this.ui);
                canvas.drawRoundRect(this.wC, f, f, this.FC);
                eli(canvas);
                DbA(canvas);
                return;
            }
            canvas.drawRoundRect(this.DbA, f, f, this.ui);
            eli(canvas);
            return;
        }
        canvas.drawRect(this.DbA, this.ui);
        if (this.nGm > 0.0f) {
            canvas.drawRect(this.wC, this.FC);
        }
    }

    private void eli(Canvas canvas) {
        if (DbA(this.aqO) || this.Dfc == 0.0f) {
            return;
        }
        float f = this.DbA.left;
        float f2 = this.DbA.top;
        float width = this.DbA.width() + f;
        float height = this.DbA.height() + f2;
        float f3 = this.Dfc;
        if (!this.aqO[0]) {
            this.du.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.du, this.ui);
        }
        if (!this.aqO[1]) {
            this.du.set(width - f3, f2, width, f3);
            canvas.drawRect(this.du, this.ui);
        }
        if (!this.aqO[2]) {
            this.du.set(width - f3, height - f3, width, height);
            canvas.drawRect(this.du, this.ui);
        }
        if (this.aqO[3]) {
            return;
        }
        this.du.set(f, height - f3, f3 + f, height);
        canvas.drawRect(this.du, this.ui);
    }

    private void DbA(Canvas canvas) {
        float f;
        float f2;
        if (DbA(this.aqO) || this.Dfc == 0.0f) {
            return;
        }
        float f3 = this.DbA.left;
        float f4 = this.DbA.top;
        float width = this.DbA.width() + f3;
        float height = f4 + this.DbA.height();
        float f5 = this.Dfc;
        float f6 = this.nGm / 2.0f;
        if (this.aqO[0]) {
            f = f4;
        } else {
            f = f4;
            canvas.drawLine(f3 - f6, f4, f3 + f5, f, this.FC);
            canvas.drawLine(f3, f - f6, f3, f + f5, this.FC);
        }
        if (!this.aqO[1]) {
            float f7 = f;
            canvas.drawLine((width - f5) - f6, f7, width, f, this.FC);
            canvas.drawLine(width, f7 - f6, width, f7 + f5, this.FC);
            width = width;
        }
        if (this.aqO[2]) {
            f2 = height;
        } else {
            canvas.drawLine((width - f5) - f6, height, width + f6, height, this.FC);
            float f8 = width;
            canvas.drawLine(f8, height - f5, width, height, this.FC);
            f2 = height;
        }
        if (this.aqO[3]) {
            return;
        }
        canvas.drawLine(f3 - f6, f2, f3 + f5, f2, this.FC);
        canvas.drawLine(f3, f2 - f5, f3, f2, this.FC);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.ui.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.ui.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.ui.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.ui.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.ui.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.ui.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.MGA;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.kb;
    }

    public DbA eli(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (!hashSet.isEmpty()) {
            float floatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(floatValue)));
            }
            this.Dfc = floatValue;
        } else {
            this.Dfc = 0.0f;
        }
        boolean[] zArr = this.aqO;
        zArr[0] = f > 0.0f;
        zArr[1] = f2 > 0.0f;
        zArr[2] = f3 > 0.0f;
        zArr[3] = f4 > 0.0f;
        return this;
    }

    public DbA eli(float f) {
        this.nGm = f;
        this.FC.setStrokeWidth(f);
        return this;
    }

    public DbA eli(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.QX = colorStateList;
        this.FC.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public DbA eli(boolean z) {
        this.dV = z;
        return this;
    }

    public DbA eli(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.Xb != scaleType) {
            this.Xb = scaleType;
            eli();
        }
        return this;
    }

    public DbA eli(Shader.TileMode tileMode) {
        if (this.nlS != tileMode) {
            this.nlS = tileMode;
            this.nn = true;
            invalidateSelf();
        }
        return this;
    }

    public DbA DbA(Shader.TileMode tileMode) {
        if (this.NU != tileMode) {
            this.NU = tileMode;
            this.nn = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean eli(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean DbA(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }
}
