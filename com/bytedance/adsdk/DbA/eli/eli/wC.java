package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.bytedance.adsdk.DbA.eli.DbA.eli;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class wC implements eli.InterfaceC0115eli, du, ui {
    private final String DbA;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> Dfc;
    private final RectF FC;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> NU;
    private final boolean Os;
    private final int QX;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> Xb;
    private final List<NU> aAs;
    private final com.bytedance.adsdk.DbA.Os.Os.eli aGH;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> aqO;
    private com.bytedance.adsdk.DbA.eli.DbA.Os bf;
    private com.bytedance.adsdk.DbA.eli.DbA.dV dV;
    private final com.bytedance.adsdk.DbA.Os.DbA.kb du;
    float eli;
    private final Path kb;
    private final com.bytedance.adsdk.DbA.FC nGm;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH, com.bytedance.adsdk.DbA.Os.DbA.aGH> nlS;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> nn;
    private final Paint wC;
    private final LongSparseArray<LinearGradient> ui = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> MGA = new LongSparseArray<>();

    public wC(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.ui uiVar) {
        Path path = new Path();
        this.kb = path;
        this.wC = new com.bytedance.adsdk.DbA.eli.eli(1);
        this.FC = new RectF();
        this.aAs = new ArrayList();
        this.eli = 0.0f;
        this.aGH = eliVar;
        this.DbA = uiVar.eli();
        this.Os = uiVar.wC();
        this.nGm = fc;
        this.du = uiVar.DbA();
        path.setFillType(uiVar.Os());
        this.QX = (int) (kbVar.ui() / 32.0f);
        com.bytedance.adsdk.DbA.eli.DbA.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH, com.bytedance.adsdk.DbA.Os.DbA.aGH> eli = uiVar.aGH().eli();
        this.nlS = eli;
        eli.eli(this);
        eliVar.eli(eli);
        com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eli2 = uiVar.ui().eli();
        this.NU = eli2;
        eli2.eli(this);
        eliVar.eli(eli2);
        com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli3 = uiVar.MGA().eli();
        this.nn = eli3;
        eli3.eli(this);
        eliVar.eli(eli3);
        com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli4 = uiVar.kb().eli();
        this.Dfc = eli4;
        eli4.eli(this);
        eliVar.eli(eli4);
        if (eliVar.aAs() != null) {
            com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eli5 = eliVar.aAs().eli().eli();
            this.Xb = eli5;
            eli5.eli(this);
            eliVar.eli(this.Xb);
        }
        if (eliVar.du() != null) {
            this.bf = new com.bytedance.adsdk.DbA.eli.DbA.Os(this, eliVar, eliVar.du());
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli.InterfaceC0115eli
    public void eli() {
        this.nGm.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.Os
    public void eli(List<Os> list, List<Os> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Os os = list2.get(i);
            if (os instanceof NU) {
                this.aAs.add((NU) os);
            }
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(Canvas canvas, Matrix matrix, int i) {
        Shader Os;
        if (this.Os) {
            return;
        }
        com.bytedance.adsdk.DbA.ui.eli("GradientFillContent#draw");
        this.kb.reset();
        for (int i2 = 0; i2 < this.aAs.size(); i2++) {
            this.kb.addPath(this.aAs.get(i2).aGH(), matrix);
        }
        this.kb.computeBounds(this.FC, false);
        if (this.du == com.bytedance.adsdk.DbA.Os.DbA.kb.LINEAR) {
            Os = DbA();
        } else {
            Os = Os();
        }
        Os.setLocalMatrix(matrix);
        this.wC.setShader(Os);
        com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> eliVar = this.aqO;
        if (eliVar != null) {
            this.wC.setColorFilter(eliVar.kb());
        }
        com.bytedance.adsdk.DbA.eli.DbA.eli<Float, Float> eliVar2 = this.Xb;
        if (eliVar2 != null) {
            float floatValue = eliVar2.kb().floatValue();
            if (floatValue == 0.0f) {
                this.wC.setMaskFilter(null);
            } else if (floatValue != this.eli) {
                this.wC.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.eli = floatValue;
        }
        com.bytedance.adsdk.DbA.eli.DbA.Os os = this.bf;
        if (os != null) {
            os.eli(this.wC);
        }
        this.wC.setAlpha(com.bytedance.adsdk.DbA.MGA.ui.eli((int) ((((i / 255.0f) * this.NU.kb().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.kb, this.wC);
        com.bytedance.adsdk.DbA.ui.DbA("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        this.kb.reset();
        for (int i = 0; i < this.aAs.size(); i++) {
            this.kb.addPath(this.aAs.get(i).aGH(), matrix);
        }
        this.kb.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private LinearGradient DbA() {
        long aGH = aGH();
        LinearGradient linearGradient = this.ui.get(aGH);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF kb = this.nn.kb();
        PointF kb2 = this.Dfc.kb();
        com.bytedance.adsdk.DbA.Os.DbA.aGH kb3 = this.nlS.kb();
        LinearGradient linearGradient2 = new LinearGradient(kb.x, kb.y, kb2.x, kb2.y, eli(kb3.DbA()), kb3.eli(), Shader.TileMode.CLAMP);
        this.ui.put(aGH, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient Os() {
        long aGH = aGH();
        RadialGradient radialGradient = this.MGA.get(aGH);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF kb = this.nn.kb();
        PointF kb2 = this.Dfc.kb();
        com.bytedance.adsdk.DbA.Os.DbA.aGH kb3 = this.nlS.kb();
        int[] eli = eli(kb3.DbA());
        float[] eli2 = kb3.eli();
        float f = kb.x;
        float f2 = kb.y;
        float hypot = (float) Math.hypot(kb2.x - f, kb2.y - f2);
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, hypot, eli, eli2, Shader.TileMode.CLAMP);
        this.MGA.put(aGH, radialGradient2);
        return radialGradient2;
    }

    private int aGH() {
        int round = Math.round(this.nn.wC() * this.QX);
        int round2 = Math.round(this.Dfc.wC() * this.QX);
        int round3 = Math.round(this.nlS.wC() * this.QX);
        int i = round != 0 ? round * IronSourceError.ERROR_NON_EXISTENT_INSTANCE : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private int[] eli(int[] iArr) {
        if (this.dV == null) {
            return iArr;
        }
        throw null;
    }
}
