package com.bytedance.adsdk.DbA.Os.Os;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* loaded from: classes3.dex */
public class aAs extends aGH {
    private int FC;
    private int aAs;
    private Path wC;

    public aAs(com.bytedance.adsdk.DbA.FC fc, ui uiVar, Context context) {
        super(fc, uiVar);
        this.wC = null;
        this.FC = -1;
        this.aAs = -1;
        if (this.kb != null) {
            float eli = com.bytedance.adsdk.DbA.MGA.MGA.eli();
            this.FC = (int) (this.kb.eli() * eli);
            this.aAs = (int) (this.kb.DbA() * eli);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.FC, this.aAs);
            Path path = new Path();
            this.wC = path;
            float f = eli * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.aGH, com.bytedance.adsdk.DbA.Os.Os.eli
    public void DbA(Canvas canvas, Matrix matrix, int i) {
        View eli = this.DbA.eli();
        if (this.FC <= 0 || eli == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        eli(i);
        float MGA = MGA();
        eli(eli, this.FC, this.aAs);
        eli.setAlpha(MGA);
        canvas.clipPath(this.wC);
        eli.draw(canvas);
        canvas.restore();
    }

    private static void eli(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
