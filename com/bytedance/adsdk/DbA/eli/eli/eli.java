package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.DbA.Os.DbA.QX;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class eli implements eli.InterfaceC0115eli, du, ui {
    final Paint DbA;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> Dfc;
    private final List<com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float>> NU;
    float Os;
    private final float[] aAs;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> aqO;
    private com.bytedance.adsdk.DbA.eli.DbA.Os dV;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> du;
    protected final com.bytedance.adsdk.DbA.Os.Os.eli eli;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Integer> nlS;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> nn;
    private final com.bytedance.adsdk.DbA.FC wC;
    private final PathMeasure aGH = new PathMeasure();
    private final Path ui = new Path();
    private final Path MGA = new Path();
    private final RectF kb = new RectF();
    private final List<C0116eli> FC = new ArrayList();

    eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, Paint.Cap cap, Paint.Join join, float f, com.bytedance.adsdk.DbA.Os.eli.aGH agh, com.bytedance.adsdk.DbA.Os.eli.DbA dbA, List<com.bytedance.adsdk.DbA.Os.eli.DbA> list, com.bytedance.adsdk.DbA.Os.eli.DbA dbA2) {
        com.bytedance.adsdk.DbA.eli.eli eliVar2 = new com.bytedance.adsdk.DbA.eli.eli(1);
        this.DbA = eliVar2;
        this.Os = 0.0f;
        this.wC = fc;
        this.eli = eliVar;
        eliVar2.setStyle(Paint.Style.STROKE);
        eliVar2.setStrokeCap(cap);
        eliVar2.setStrokeJoin(join);
        eliVar2.setStrokeMiter(f);
        this.nlS = agh.eli();
        this.du = dbA.eli();
        if (dbA2 == null) {
            this.nn = null;
        } else {
            this.nn = dbA2.eli();
        }
        this.NU = new ArrayList(list.size());
        this.aAs = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.NU.add(list.get(i).eli());
        }
        eliVar.eli(this.nlS);
        eliVar.eli(this.du);
        for (int i2 = 0; i2 < this.NU.size(); i2++) {
            eliVar.eli(this.NU.get(i2));
        }
        com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> eliVar3 = this.nn;
        if (eliVar3 != null) {
            eliVar.eli(eliVar3);
        }
        this.nlS.eli(this);
        this.du.eli(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.NU.get(i3).eli(this);
        }
        com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> eliVar4 = this.nn;
        if (eliVar4 != null) {
            eliVar4.eli(this);
        }
        if (eliVar.aAs() != null) {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli = eliVar.aAs().eli().eli();
            this.aqO = eli;
            eli.eli(this);
            eliVar.eli(this.aqO);
        }
        if (eliVar.du() != null) {
            this.dV = new com.bytedance.adsdk.DbA.eli.DbA.Os(this, eliVar, eliVar.du());
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        this.wC.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        bf bfVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Os os = list.get(size);
            if (os instanceof bf) {
                bf bfVar2 = (bf) os;
                if (bfVar2.DbA() == QX.eli.INDIVIDUALLY) {
                    bfVar = bfVar2;
                }
            }
        }
        if (bfVar != null) {
            bfVar.eli(this);
        }
        C0116eli c0116eli = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Os os2 = list2.get(size2);
            if (os2 instanceof bf) {
                bf bfVar3 = (bf) os2;
                if (bfVar3.DbA() == QX.eli.INDIVIDUALLY) {
                    if (c0116eli != null) {
                        this.FC.add(c0116eli);
                    }
                    c0116eli = new C0116eli(bfVar3);
                    bfVar3.eli(this);
                }
            }
            if (os2 instanceof NU) {
                if (c0116eli == null) {
                    c0116eli = new C0116eli(bfVar);
                }
                c0116eli.eli.add((NU) os2);
            }
        }
        if (c0116eli != null) {
            this.FC.add(c0116eli);
        }
    }

    public void eli(Canvas canvas, Matrix matrix, int i) {
        com.bytedance.adsdk.DbA.ui.eli("StrokeContent#draw");
        if (com.bytedance.adsdk.DbA.MGA.MGA.DbA(matrix)) {
            com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#draw");
            return;
        }
        this.DbA.setAlpha(com.bytedance.adsdk.DbA.MGA.ui.eli((int) ((((i / 255.0f) * ((com.bytedance.adsdk.DbA.eli.DbA.MGA) this.nlS).FC()) / 100.0f) * 255.0f), 0, 255));
        this.DbA.setStrokeWidth(((com.bytedance.adsdk.DbA.eli.DbA.aGH) this.du).FC() * com.bytedance.adsdk.DbA.MGA.MGA.eli(matrix));
        if (this.DbA.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#draw");
            return;
        }
        eli(matrix);
        com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> eliVar = this.Dfc;
        if (eliVar != null) {
            this.DbA.setColorFilter(eliVar.kb());
        }
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar2 = this.aqO;
        if (eliVar2 != null) {
            float floatValue = eliVar2.kb().floatValue();
            if (floatValue == 0.0f) {
                this.DbA.setMaskFilter(null);
            } else if (floatValue != this.Os) {
                this.DbA.setMaskFilter(this.eli.DbA(floatValue));
            }
            this.Os = floatValue;
        }
        com.bytedance.adsdk.DbA.eli.DbA.Os os = this.dV;
        if (os != null) {
            os.eli(this.DbA);
        }
        for (int i2 = 0; i2 < this.FC.size(); i2++) {
            C0116eli c0116eli = this.FC.get(i2);
            if (c0116eli.DbA != null) {
                eli(canvas, c0116eli, matrix);
            } else {
                com.bytedance.adsdk.DbA.ui.eli("StrokeContent#buildPath");
                this.ui.reset();
                for (int size = c0116eli.eli.size() - 1; size >= 0; size--) {
                    this.ui.addPath(((NU) c0116eli.eli.get(size)).aGH(), matrix);
                }
                com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#buildPath");
                com.bytedance.adsdk.DbA.ui.eli("StrokeContent#drawPath");
                canvas.drawPath(this.ui, this.DbA);
                com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#draw");
    }

    private void eli(Canvas canvas, C0116eli c0116eli, Matrix matrix) {
        float f;
        float f2;
        com.bytedance.adsdk.DbA.ui.eli("StrokeContent#applyTrimPath");
        if (c0116eli.DbA == null) {
            com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#applyTrimPath");
            return;
        }
        this.ui.reset();
        for (int size = c0116eli.eli.size() - 1; size >= 0; size--) {
            this.ui.addPath(((NU) c0116eli.eli.get(size)).aGH(), matrix);
        }
        float floatValue = c0116eli.DbA.Os().kb().floatValue() / 100.0f;
        float floatValue2 = c0116eli.DbA.aGH().kb().floatValue() / 100.0f;
        float floatValue3 = c0116eli.DbA.ui().kb().floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.ui, this.DbA);
            com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#applyTrimPath");
            return;
        }
        this.aGH.setPath(this.ui, false);
        float length = this.aGH.getLength();
        while (this.aGH.nextContour()) {
            length += this.aGH.getLength();
        }
        float f3 = floatValue3 * length;
        float f4 = (floatValue * length) + f3;
        float min = Math.min((floatValue2 * length) + f3, (f4 + length) - 1.0f);
        float f5 = 0.0f;
        for (int size2 = c0116eli.eli.size() - 1; size2 >= 0; size2--) {
            this.MGA.set(((NU) c0116eli.eli.get(size2)).aGH());
            this.MGA.transform(matrix);
            this.aGH.setPath(this.MGA, false);
            float length2 = this.aGH.getLength();
            if (min > length) {
                float f6 = min - length;
                if (f6 < f5 + length2 && f5 < f6) {
                    f = f4 > length ? (f4 - length) / length2 : 0.0f;
                    f2 = Math.min(f6 / length2, 1.0f);
                    com.bytedance.adsdk.DbA.MGA.MGA.eli(this.MGA, f, f2, 0.0f);
                    canvas.drawPath(this.MGA, this.DbA);
                    f5 += length2;
                }
            }
            float f7 = f5 + length2;
            if (f7 >= f4 && f5 <= min) {
                if (f7 <= min && f4 < f5) {
                    canvas.drawPath(this.MGA, this.DbA);
                } else {
                    f = f4 < f5 ? 0.0f : (f4 - f5) / length2;
                    f2 = min > f7 ? 1.0f : (min - f5) / length2;
                    com.bytedance.adsdk.DbA.MGA.MGA.eli(this.MGA, f, f2, 0.0f);
                    canvas.drawPath(this.MGA, this.DbA);
                }
            }
            f5 += length2;
        }
        com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#applyTrimPath");
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        com.bytedance.adsdk.DbA.ui.eli("StrokeContent#getBounds");
        this.ui.reset();
        for (int i = 0; i < this.FC.size(); i++) {
            C0116eli c0116eli = this.FC.get(i);
            for (int i2 = 0; i2 < c0116eli.eli.size(); i2++) {
                this.ui.addPath(((NU) c0116eli.eli.get(i2)).aGH(), matrix);
            }
        }
        this.ui.computeBounds(this.kb, false);
        float FC = ((com.bytedance.adsdk.DbA.eli.DbA.aGH) this.du).FC();
        RectF rectF2 = this.kb;
        float f = FC / 2.0f;
        rectF2.set(rectF2.left - f, this.kb.top - f, this.kb.right + f, this.kb.bottom + f);
        rectF.set(this.kb);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#getBounds");
    }

    private void eli(Matrix matrix) {
        com.bytedance.adsdk.DbA.ui.eli("StrokeContent#applyDashPattern");
        if (this.NU.isEmpty()) {
            com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#applyDashPattern");
            return;
        }
        float eli = com.bytedance.adsdk.DbA.MGA.MGA.eli(matrix);
        for (int i = 0; i < this.NU.size(); i++) {
            this.aAs[i] = this.NU.get(i).kb().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.aAs;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.aAs;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.aAs;
            fArr3[i] = fArr3[i] * eli;
        }
        com.bytedance.adsdk.DbA.eli.DbA.eli<?, Float> eliVar = this.nn;
        this.DbA.setPathEffect(new DashPathEffect(this.aAs, eliVar == null ? 0.0f : eli * eliVar.kb().floatValue()));
        com.bytedance.adsdk.DbA.ui.DbA("StrokeContent#applyDashPattern");
    }

    /* renamed from: com.bytedance.adsdk.DbA.eli.eli.eli$eli, reason: collision with other inner class name */
    private static final class C0116eli {
        private final bf DbA;
        private final List<NU> eli;

        private C0116eli(bf bfVar) {
            this.eli = new ArrayList();
            this.DbA = bfVar;
        }
    }
}
