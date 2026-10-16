package com.bytedance.adsdk.DbA.Os.Os;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes3.dex */
public class wC extends eli {
    private final float[] FC;
    private final Path aAs;
    private final ui du;
    private final RectF kb;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> nlS;
    private final Paint wC;

    wC(com.bytedance.adsdk.DbA.FC fc, ui uiVar) {
        super(fc, uiVar);
        this.kb = new RectF();
        com.bytedance.adsdk.DbA.eli.eli eliVar = new com.bytedance.adsdk.DbA.eli.eli();
        this.wC = eliVar;
        this.FC = new float[8];
        this.aAs = new Path();
        this.du = uiVar;
        eliVar.setAlpha(0);
        eliVar.setStyle(Paint.Style.FILL);
        eliVar.setColor(uiVar.aqO());
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public void DbA(Canvas canvas, Matrix matrix, int i) {
        super.DbA(canvas, matrix, i);
        int alpha = Color.alpha(this.du.aqO());
        if (alpha == 0) {
            return;
        }
        int intValue = (int) ((i / 255.0f) * (((alpha / 255.0f) * (this.aGH.eli() == null ? 100 : this.aGH.eli().kb().intValue())) / 100.0f) * 255.0f);
        this.wC.setAlpha(intValue);
        com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> eliVar = this.nlS;
        if (eliVar != null) {
            this.wC.setColorFilter(eliVar.kb());
        }
        if (intValue > 0) {
            float[] fArr = this.FC;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.du.nGm();
            float[] fArr2 = this.FC;
            fArr2[3] = 0.0f;
            fArr2[4] = this.du.nGm();
            this.FC[5] = this.du.dV();
            float[] fArr3 = this.FC;
            fArr3[6] = 0.0f;
            fArr3[7] = this.du.dV();
            matrix.mapPoints(this.FC);
            this.aAs.reset();
            Path path = this.aAs;
            float[] fArr4 = this.FC;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.aAs;
            float[] fArr5 = this.FC;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.aAs;
            float[] fArr6 = this.FC;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.aAs;
            float[] fArr7 = this.FC;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.aAs;
            float[] fArr8 = this.FC;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.aAs.close();
            canvas.drawPath(this.aAs, this.wC);
        }
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli, com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        super.eli(rectF, matrix, z);
        this.kb.set(0.0f, 0.0f, this.du.nGm(), this.du.dV());
        this.eli.mapRect(this.kb);
        rectF.set(this.kb);
    }
}
