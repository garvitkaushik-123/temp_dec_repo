package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class kb implements eli.InterfaceC0115eli, du, ui {
    private final Path DbA;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> FC;
    private final boolean MGA;
    private com.bytedance.adsdk.DbA.eli.DbA.Os NU;
    private final Paint Os;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> aAs;
    private final com.bytedance.adsdk.DbA.Os.Os.eli aGH;
    private final com.bytedance.adsdk.DbA.FC du;
    float eli;
    private final List<NU> kb;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> nlS;
    private final String ui;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> wC;

    public kb(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.Dfc dfc) {
        Path path = new Path();
        this.DbA = path;
        this.Os = new com.bytedance.adsdk.DbA.eli.eli(1);
        this.kb = new ArrayList();
        this.aGH = eliVar;
        this.ui = dfc.eli();
        this.MGA = dfc.ui();
        this.du = fc;
        if (eliVar.aAs() != null) {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli = eliVar.aAs().eli().eli();
            this.nlS = eli;
            eli.eli(this);
            eliVar.eli(this.nlS);
        }
        if (eliVar.du() != null) {
            this.NU = new com.bytedance.adsdk.DbA.eli.DbA.Os(this, eliVar, eliVar.du());
        }
        if (dfc.DbA() == null || dfc.Os() == null) {
            this.wC = null;
            this.FC = null;
            return;
        }
        path.setFillType(dfc.aGH());
        com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eli2 = dfc.DbA().eli();
        this.wC = eli2;
        eli2.eli(this);
        eliVar.eli(eli2);
        com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eli3 = dfc.Os().eli();
        this.FC = eli3;
        eli3.eli(this);
        eliVar.eli(eli3);
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        this.du.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Os os = list2.get(i);
            if (os instanceof NU) {
                this.kb.add((NU) os);
            }
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(Canvas canvas, Matrix matrix, int i) {
        if (this.MGA) {
            return;
        }
        com.bytedance.adsdk.DbA.ui.eli("FillContent#draw");
        this.Os.setColor((com.bytedance.adsdk.DbA.MGA.ui.eli((int) ((((i / 255.0f) * this.FC.kb().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.DbA.eli.DbA.DbA) this.wC).FC() & ViewCompat.MEASURED_SIZE_MASK));
        com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> eliVar = this.aAs;
        if (eliVar != null) {
            this.Os.setColorFilter(eliVar.kb());
        }
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar2 = this.nlS;
        if (eliVar2 != null) {
            float floatValue = eliVar2.kb().floatValue();
            if (floatValue == 0.0f) {
                this.Os.setMaskFilter(null);
            } else if (floatValue != this.eli) {
                this.Os.setMaskFilter(this.aGH.DbA(floatValue));
            }
            this.eli = floatValue;
        }
        com.bytedance.adsdk.DbA.eli.DbA.Os os = this.NU;
        if (os != null) {
            os.eli(this.Os);
        }
        this.DbA.reset();
        for (int i2 = 0; i2 < this.kb.size(); i2++) {
            this.DbA.addPath(this.kb.get(i2).aGH(), matrix);
        }
        canvas.drawPath(this.DbA, this.Os);
        com.bytedance.adsdk.DbA.ui.DbA("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        this.DbA.reset();
        for (int i = 0; i < this.kb.size(); i++) {
            this.DbA.addPath(this.kb.get(i).aGH(), matrix);
        }
        this.DbA.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
