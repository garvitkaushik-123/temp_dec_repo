package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class aGH extends View {
    private int DbA;
    private List<Integer> FC;
    private int MGA;
    private float NU;
    private float Os;
    private Paint aAs;
    private int aGH;
    private Paint du;
    private int eli;
    private boolean kb;
    private float nlS;
    private int nn;
    private float ui;
    private List<Integer> wC;

    public aGH(Context context) {
        this(context, null);
    }

    public aGH(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public aGH(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eli = -1;
        this.DbA = -65536;
        this.Os = 18.0f;
        this.aGH = 3;
        this.ui = 50.0f;
        this.MGA = 2;
        this.kb = false;
        this.wC = new ArrayList();
        this.FC = new ArrayList();
        this.nn = 24;
        Os();
    }

    private void Os() {
        Paint paint = new Paint();
        this.aAs = paint;
        paint.setAntiAlias(true);
        this.aAs.setStrokeWidth(this.nn);
        this.wC.add(255);
        this.FC.add(0);
        Paint paint2 = new Paint();
        this.du = paint2;
        paint2.setAntiAlias(true);
        this.du.setColor(Color.parseColor("#0FFFFFFF"));
        this.du.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i / 2.0f;
        this.nlS = f;
        this.NU = i2 / 2.0f;
        float f2 = f - (this.nn / 2.0f);
        this.ui = f2;
        this.Os = f2 / 4.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.aAs.setShader(new LinearGradient(this.nlS, 0.0f, this.NU, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        int i = 0;
        while (true) {
            if (i >= this.wC.size()) {
                break;
            }
            Integer num = this.wC.get(i);
            this.aAs.setAlpha(num.intValue());
            Integer num2 = this.FC.get(i);
            if (this.Os + num2.intValue() < this.ui) {
                canvas.drawCircle(this.nlS, this.NU, this.Os + num2.intValue(), this.aAs);
            }
            if (num.intValue() > 0 && num2.intValue() < this.ui) {
                this.wC.set(i, Integer.valueOf(num.intValue() - this.MGA > 0 ? num.intValue() - (this.MGA * 3) : 1));
                this.FC.set(i, Integer.valueOf(num2.intValue() + this.MGA));
            }
            i++;
        }
        List<Integer> list = this.FC;
        if (list.get(list.size() - 1).intValue() >= this.ui / this.aGH) {
            this.wC.add(255);
            this.FC.add(0);
        }
        if (this.FC.size() >= 3) {
            this.FC.remove(0);
            this.wC.remove(0);
        }
        this.aAs.setAlpha(255);
        this.aAs.setColor(this.DbA);
        canvas.drawCircle(this.nlS, this.NU, this.Os, this.du);
        if (this.kb) {
            invalidate();
        }
    }

    public void eli() {
        this.kb = true;
        invalidate();
    }

    public void DbA() {
        this.kb = false;
        this.FC.clear();
        this.wC.clear();
        this.wC.add(255);
        this.FC.add(0);
        invalidate();
    }

    public void setColor(int i) {
        this.eli = i;
    }

    public void setCoreColor(int i) {
        this.DbA = i;
    }

    public void setCoreRadius(int i) {
        this.Os = i;
    }

    public void setDiffuseWidth(int i) {
        this.aGH = i;
    }

    public void setMaxWidth(int i) {
        this.ui = i;
    }

    public void setDiffuseSpeed(int i) {
        this.MGA = i;
    }
}
