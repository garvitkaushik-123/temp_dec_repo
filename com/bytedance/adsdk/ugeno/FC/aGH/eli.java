package com.bytedance.adsdk.ugeno.FC.aGH;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.aGH;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.eli.kb;
import com.bytedance.adsdk.ugeno.eli.wC;

/* loaded from: classes3.dex */
public class eli extends ImageView implements IAnimation, kb {
    static final /* synthetic */ boolean DbA = true;
    private int Dfc;
    private ColorFilter FC;
    private Drawable MGA;
    private boolean NU;
    private float Os;
    private Shader.TileMode QX;
    private aGH Xb;
    private boolean aAs;
    private int aqO;
    private wC bf;
    private ImageView.ScaleType dV;
    private Drawable du;
    private ColorStateList kb;
    private Shader.TileMode nGm;
    private boolean nlS;
    private boolean nn;
    private final float[] ui;
    private float wC;
    public static final Shader.TileMode eli = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] aGH = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    public eli(Context context) {
        super(context);
        this.ui = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.kb = ColorStateList.valueOf(-16777216);
        this.wC = 0.0f;
        this.FC = null;
        this.aAs = false;
        this.nlS = false;
        this.NU = false;
        this.nn = false;
        Shader.TileMode tileMode = eli;
        this.nGm = tileMode;
        this.QX = tileMode;
        this.bf = new wC(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.dV;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!DbA && scaleType == null) {
            throw new AssertionError();
        }
        if (this.dV != scaleType) {
            this.dV = scaleType;
            int i = AnonymousClass1.eli[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            Os();
            eli(false);
            invalidate();
        }
    }

    /* renamed from: com.bytedance.adsdk.ugeno.FC.aGH.eli$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eli;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            eli = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                eli[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                eli[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                eli[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                eli[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                eli[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                eli[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.Dfc = 0;
        this.du = DbA.eli(drawable);
        Os();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.Dfc = 0;
        this.du = DbA.eli(bitmap);
        Os();
        super.setImageDrawable(this.du);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.Dfc != i) {
            this.Dfc = i;
            this.du = eli();
            Os();
            super.setImageDrawable(this.du);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable eli() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.Dfc;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.Dfc, e);
                this.Dfc = 0;
            }
        }
        return DbA.eli(drawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.aqO != i) {
            this.aqO = i;
            Drawable DbA2 = DbA();
            this.MGA = DbA2;
            setBackgroundDrawable(DbA2);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.MGA = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    private Drawable DbA() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.aqO;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.aqO, e);
                this.aqO = 0;
            }
        }
        return DbA.eli(drawable);
    }

    private void Os() {
        eli(this.du, this.dV);
    }

    private void eli(boolean z) {
        if (this.nn) {
            if (z) {
                this.MGA = DbA.eli(this.MGA);
            }
            eli(this.MGA, ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.FC != colorFilter) {
            this.FC = colorFilter;
            this.nlS = true;
            this.aAs = true;
            aGH();
            invalidate();
        }
    }

    private void aGH() {
        Drawable drawable = this.du;
        if (drawable == null || !this.aAs) {
            return;
        }
        Drawable mutate = drawable.mutate();
        this.du = mutate;
        if (this.nlS) {
            mutate.setColorFilter(this.FC);
        }
    }

    private void eli(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof DbA) {
            DbA dbA = (DbA) drawable;
            dbA.eli(scaleType).eli(this.wC).eli(this.kb).eli(this.NU).eli(this.nGm).DbA(this.QX);
            float[] fArr = this.ui;
            if (fArr != null) {
                dbA.eli(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            aGH();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                eli(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.MGA = drawable;
        eli(true);
        super.setBackgroundDrawable(this.MGA);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f = 0.0f;
        for (float f2 : this.ui) {
            f = Math.max(f2, f);
        }
        return f;
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        eli(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadius(float f) {
        eli(f, f, f, f);
    }

    public void eli(float f, float f2, float f3, float f4) {
        float[] fArr = this.ui;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        Os();
        eli(false);
        invalidate();
    }

    public float getBorderWidth() {
        return this.wC;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.wC == f) {
            return;
        }
        this.wC = f;
        Os();
        eli(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.kb.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.kb;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.kb.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.kb = colorStateList;
        Os();
        eli(false);
        if (this.wC > 0.0f) {
            invalidate();
        }
    }

    public void setOval(boolean z) {
        this.NU = z;
        Os();
        eli(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.nGm;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.nGm == tileMode) {
            return;
        }
        this.nGm = tileMode;
        Os();
        eli(false);
        invalidate();
    }

    public Shader.TileMode getTileModeY() {
        return this.QX;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.QX == tileMode) {
            return;
        }
        this.QX = tileMode;
        Os();
        eli(false);
        invalidate();
    }

    public void eli(aGH agh) {
        this.Xb = agh;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        aGH agh = this.Xb;
        if (agh != null) {
            int[] eli2 = agh.eli(i, i2);
            super.onMeasure(eli2[0], eli2[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        aGH agh = this.Xb;
        if (agh != null) {
            agh.eli(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aGH agh = this.Xb;
        if (agh != null) {
            agh.eli(canvas, this);
            this.Xb.eli(canvas);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        aGH agh = this.Xb;
        if (agh != null) {
            agh.DbA(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aGH agh = this.Xb;
        if (agh != null) {
            agh.DbA(i, i2, i3, i3);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGH agh = this.Xb;
        if (agh != null) {
            agh.kb();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGH agh = this.Xb;
        if (agh != null) {
            agh.wC();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation, com.bytedance.adsdk.ugeno.eli.kb
    public float getRipple() {
        return this.Os;
    }

    public void setShine(float f) {
        wC wCVar = this.bf;
        if (wCVar != null) {
            wCVar.Os(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getShine() {
        return this.bf.getShine();
    }

    public void setStretch(float f) {
        wC wCVar = this.bf;
        if (wCVar != null) {
            wCVar.aGH(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getStretch() {
        return this.bf.getStretch();
    }

    public void setRubIn(float f) {
        wC wCVar = this.bf;
        if (wCVar != null) {
            wCVar.ui(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getRubIn() {
        return this.bf.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f) {
        this.Os = f;
        wC wCVar = this.bf;
        if (wCVar != null) {
            wCVar.DbA(f);
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setBorderRadius(float f) {
        wC wCVar = this.bf;
        if (wCVar != null) {
            wCVar.eli(f);
        }
    }

    public float getBorderRadius() {
        return this.bf.eli();
    }
}
