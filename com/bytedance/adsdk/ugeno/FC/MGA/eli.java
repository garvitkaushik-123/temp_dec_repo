package com.bytedance.adsdk.ugeno.FC.MGA;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.aGH;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.eli.kb;
import com.bytedance.adsdk.ugeno.eli.wC;

/* loaded from: classes3.dex */
public class eli extends TextView implements IAnimation, kb {
    private float DbA;
    private wC Os;
    private aGH eli;

    public eli(Context context) {
        super(context);
        this.Os = new wC(this);
    }

    public void eli(aGH agh) {
        this.eli = agh;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        aGH agh = this.eli;
        if (agh != null) {
            int[] eli = agh.eli(i, i2);
            super.onMeasure(eli[0], eli[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        aGH agh = this.eli;
        if (agh != null) {
            agh.eli(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation, com.bytedance.adsdk.ugeno.eli.kb
    public float getRipple() {
        return this.DbA;
    }

    public void setShine(float f) {
        wC wCVar = this.Os;
        if (wCVar != null) {
            wCVar.Os(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getShine() {
        return this.Os.getShine();
    }

    public void setStretch(float f) {
        wC wCVar = this.Os;
        if (wCVar != null) {
            wCVar.aGH(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getStretch() {
        return this.Os.getStretch();
    }

    public void setRubIn(float f) {
        wC wCVar = this.Os;
        if (wCVar != null) {
            wCVar.ui(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.kb
    public float getRubIn() {
        return this.Os.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f) {
        this.DbA = f;
        wC wCVar = this.Os;
        if (wCVar != null) {
            wCVar.DbA(f);
        }
        postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aGH agh = this.eli;
        if (agh != null) {
            agh.eli(canvas, this);
            this.eli.eli(canvas);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        aGH agh = this.eli;
        if (agh != null) {
            agh.DbA(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aGH agh = this.eli;
        if (agh != null) {
            agh.DbA(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGH agh = this.eli;
        if (agh != null) {
            agh.kb();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGH agh = this.eli;
        if (agh != null) {
            agh.wC();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setBorderRadius(float f) {
        wC wCVar = this.Os;
        if (wCVar != null) {
            wCVar.eli(f);
        }
    }

    public float getBorderRadius() {
        return this.Os.eli();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.Os.eli(i);
    }
}
