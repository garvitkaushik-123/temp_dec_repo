package com.bytedance.adsdk.DbA.Os.Os;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: classes3.dex */
public class aGH extends eli {
    private final Rect FC;
    private final Rect aAs;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> du;
    protected final com.bytedance.adsdk.DbA.aAs kb;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Bitmap, Bitmap> nlS;
    private final Paint wC;

    aGH(com.bytedance.adsdk.DbA.FC fc, ui uiVar) {
        super(fc, uiVar);
        this.wC = new com.bytedance.adsdk.DbA.eli.eli(3);
        this.FC = new Rect();
        this.aAs = new Rect();
        this.kb = fc.MGA(uiVar.kb());
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public void DbA(Canvas canvas, Matrix matrix, int i) {
        super.DbA(canvas, matrix, i);
        Bitmap nlS = nlS();
        if (nlS == null || nlS.isRecycled() || this.kb == null) {
            return;
        }
        float eli = com.bytedance.adsdk.DbA.MGA.MGA.eli();
        this.wC.setAlpha(i);
        com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> eliVar = this.du;
        if (eliVar != null) {
            this.wC.setColorFilter(eliVar.kb());
        }
        canvas.save();
        canvas.concat(matrix);
        this.FC.set(0, 0, nlS.getWidth(), nlS.getHeight());
        if (this.DbA.ui()) {
            this.aAs.set(0, 0, (int) (this.kb.eli() * eli), (int) (this.kb.DbA() * eli));
        } else {
            this.aAs.set(0, 0, (int) (nlS.getWidth() * eli), (int) (nlS.getHeight() * eli));
        }
        canvas.drawBitmap(nlS, this.FC, this.aAs, this.wC);
        canvas.restore();
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli, com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        super.eli(rectF, matrix, z);
        if (this.kb != null) {
            float eli = com.bytedance.adsdk.DbA.MGA.MGA.eli();
            rectF.set(0.0f, 0.0f, this.kb.eli() * eli, this.kb.DbA() * eli);
            this.eli.mapRect(rectF);
        }
    }

    private Bitmap nlS() {
        Bitmap kb;
        com.bytedance.adsdk.DbA.eli.DbA.eli<Bitmap, Bitmap> eliVar = this.nlS;
        if (eliVar != null && (kb = eliVar.kb()) != null) {
            return kb;
        }
        Bitmap ui = this.DbA.ui(this.Os.kb());
        if (ui != null) {
            return ui;
        }
        com.bytedance.adsdk.DbA.aAs aas = this.kb;
        if (aas != null) {
            return aas.du();
        }
        return null;
    }
}
