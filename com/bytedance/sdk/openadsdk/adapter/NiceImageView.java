package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import com.bytedance.sdk.openadsdk.core.ui.aGH;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class NiceImageView extends aGH {
    private final Paint CMM;
    private boolean DbA;
    private int Dfc;
    private int FC;
    private int MGA;
    private int NU;
    private boolean Os;
    private final float[] QX;
    private Path Vy;
    private RectF Xb;
    private int aAs;
    private int aGH;
    private int aqO;
    private final RectF bf;
    private float dV;
    private int du;
    private final Context eli;
    private final Path ev;
    private int kb;
    private final float[] nGm;
    private int nlS;
    private final Xfermode nn;
    private int ui;
    private int wC;

    public NiceImageView(Context context) {
        this(context, null);
    }

    public NiceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ui = -1;
        this.kb = -1;
        this.eli = context;
        this.wC = SSo.DbA(context, 10.0f);
        this.nGm = new float[8];
        this.QX = new float[8];
        this.bf = new RectF();
        this.Xb = new RectF();
        this.CMM = new Paint();
        this.ev = new Path();
        this.nn = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.Vy = new Path();
        Os();
        aGH();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Dfc = i;
        this.aqO = i2;
        eli();
        DbA();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.Xb, null, 31);
        if (!this.Os) {
            int i = this.Dfc;
            int i2 = this.aGH;
            int i3 = this.MGA;
            int i4 = this.aqO;
            canvas.scale((((i - (i2 * 2)) - (i3 * 2)) * 1.0f) / i, (((i4 - (i2 * 2)) - (i3 * 2)) * 1.0f) / i4, i / 2.0f, i4 / 2.0f);
        }
        super.onDraw(canvas);
        this.CMM.reset();
        this.ev.reset();
        if (this.DbA) {
            this.ev.addCircle(this.Dfc / 2.0f, this.aqO / 2.0f, this.dV, Path.Direction.CCW);
        } else {
            this.ev.addRoundRect(this.Xb, this.QX, Path.Direction.CCW);
        }
        this.CMM.setAntiAlias(true);
        this.CMM.setStyle(Paint.Style.FILL);
        this.CMM.setXfermode(this.nn);
        this.Vy.addRect(this.Xb, Path.Direction.CCW);
        this.Vy.op(this.ev, Path.Op.DIFFERENCE);
        canvas.drawPath(this.Vy, this.CMM);
        this.CMM.setXfermode(null);
        int i5 = this.NU;
        if (i5 != 0) {
            this.CMM.setColor(i5);
            canvas.drawPath(this.ev, this.CMM);
        }
        canvas.restore();
        eli(canvas);
    }

    private void eli(Canvas canvas) {
        if (this.DbA) {
            int i = this.aGH;
            if (i > 0) {
                eli(canvas, i, this.ui, this.dV - (i / 2.0f));
            }
            int i2 = this.MGA;
            if (i2 > 0) {
                eli(canvas, i2, this.kb, (this.dV - this.aGH) - (i2 / 2.0f));
                return;
            }
            return;
        }
        int i3 = this.aGH;
        if (i3 > 0) {
            eli(canvas, i3, this.ui, this.bf, this.nGm);
        }
    }

    private void eli(Canvas canvas, int i, int i2, float f) {
        eli(i, i2);
        this.ev.addCircle(this.Dfc / 2.0f, this.aqO / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.ev, this.CMM);
    }

    private void eli(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        eli(i, i2);
        this.ev.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.ev, this.CMM);
    }

    private void eli(int i, int i2) {
        this.ev.reset();
        this.CMM.setStrokeWidth(i);
        this.CMM.setColor(i2);
        this.CMM.setStyle(Paint.Style.STROKE);
    }

    private void eli() {
        if (this.DbA) {
            return;
        }
        RectF rectF = this.bf;
        int i = this.aGH;
        rectF.set(i / 2.0f, i / 2.0f, this.Dfc - (i / 2.0f), this.aqO - (i / 2.0f));
    }

    private void DbA() {
        if (this.DbA) {
            float min = Math.min(this.Dfc, this.aqO) / 2.0f;
            this.dV = min;
            RectF rectF = this.Xb;
            int i = this.Dfc;
            int i2 = this.aqO;
            rectF.set((i / 2.0f) - min, (i2 / 2.0f) - min, (i / 2.0f) + min, (i2 / 2.0f) + min);
            return;
        }
        this.Xb.set(0.0f, 0.0f, this.Dfc, this.aqO);
        if (this.Os) {
            this.Xb = this.bf;
        }
    }

    private void Os() {
        if (this.DbA) {
            return;
        }
        int i = 0;
        if (this.wC <= 0) {
            float[] fArr = this.nGm;
            int i2 = this.FC;
            float f = i2;
            fArr[1] = f;
            fArr[0] = f;
            int i3 = this.aAs;
            float f2 = i3;
            fArr[3] = f2;
            fArr[2] = f2;
            int i4 = this.nlS;
            float f3 = i4;
            fArr[5] = f3;
            fArr[4] = f3;
            int i5 = this.du;
            float f4 = i5;
            fArr[7] = f4;
            fArr[6] = f4;
            float[] fArr2 = this.QX;
            int i6 = this.aGH;
            float f5 = i2 - (i6 / 2.0f);
            fArr2[1] = f5;
            fArr2[0] = f5;
            float f6 = i3 - (i6 / 2.0f);
            fArr2[3] = f6;
            fArr2[2] = f6;
            float f7 = i4 - (i6 / 2.0f);
            fArr2[5] = f7;
            fArr2[4] = f7;
            float f8 = i5 - (i6 / 2.0f);
            fArr2[7] = f8;
            fArr2[6] = f8;
            return;
        }
        while (true) {
            float[] fArr3 = this.nGm;
            if (i >= fArr3.length) {
                return;
            }
            int i7 = this.wC;
            fArr3[i] = i7;
            this.QX[i] = i7 - (this.aGH / 2.0f);
            i++;
        }
    }

    private void eli(boolean z) {
        if (z) {
            this.wC = 0;
        }
        Os();
        eli();
        invalidate();
    }

    private void aGH() {
        if (this.DbA) {
            return;
        }
        this.MGA = 0;
    }

    public void isCoverSrc(boolean z) {
        this.Os = z;
        DbA();
        invalidate();
    }

    public void isCircle(boolean z) {
        this.DbA = z;
        aGH();
        DbA();
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.aGH = SSo.DbA(this.eli, i);
        eli(false);
    }

    public void setBorderColor(int i) {
        this.ui = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.MGA = SSo.DbA(this.eli, i);
        aGH();
        invalidate();
    }

    public void setInnerBorderColor(int i) {
        this.kb = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.wC = SSo.DbA(this.eli, i);
        eli(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.FC = SSo.DbA(this.eli, i);
        eli(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.aAs = SSo.DbA(this.eli, i);
        eli(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.du = SSo.DbA(this.eli, i);
        eli(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.nlS = SSo.DbA(this.eli, i);
        eli(true);
    }

    public void setMaskColor(int i) {
        this.NU = i;
        invalidate();
    }
}
