package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes3.dex */
public class FC extends eli {
    private final com.bytedance.adsdk.DbA.Os.DbA.kb FC;
    private final LongSparseArray<LinearGradient> MGA;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> NU;
    private final int aAs;
    private final String aGH;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH, com.bytedance.adsdk.DbA.Os.DbA.aGH> du;
    private final LongSparseArray<RadialGradient> kb;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> nlS;
    private com.bytedance.adsdk.DbA.eli.DbA.dV nn;
    private final boolean ui;
    private final RectF wC;

    public FC(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.MGA mga) {
        super(fc, eliVar, mga.wC().eli(), mga.FC().eli(), mga.nlS(), mga.aGH(), mga.kb(), mga.aAs(), mga.du());
        this.MGA = new LongSparseArray<>();
        this.kb = new LongSparseArray<>();
        this.wC = new RectF();
        this.aGH = mga.eli();
        this.FC = mga.DbA();
        this.ui = mga.NU();
        this.aAs = (int) (fc.ujq().ui() / 32.0f);
        com.bytedance.adsdk.DbA.eli.DbA.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH, com.bytedance.adsdk.DbA.Os.DbA.aGH> eli = mga.Os().eli();
        this.du = eli;
        eli.eli(this);
        eliVar.eli(eli);
        com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli2 = mga.ui().eli();
        this.nlS = eli2;
        eli2.eli(this);
        eliVar.eli(eli2);
        com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli3 = mga.MGA().eli();
        this.NU = eli3;
        eli3.eli(this);
        eliVar.eli(eli3);
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.eli, com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(Canvas canvas, Matrix matrix, int i) {
        Shader Os;
        if (this.ui) {
            return;
        }
        eli(this.wC, matrix, false);
        if (this.FC == com.bytedance.adsdk.DbA.Os.DbA.kb.LINEAR) {
            Os = DbA();
        } else {
            Os = Os();
        }
        Os.setLocalMatrix(matrix);
        this.DbA.setShader(Os);
        super.eli(canvas, matrix, i);
    }

    private LinearGradient DbA() {
        long aGH = aGH();
        LinearGradient linearGradient = this.MGA.get(aGH);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF kb = this.nlS.kb();
        PointF kb2 = this.NU.kb();
        com.bytedance.adsdk.DbA.Os.DbA.aGH kb3 = this.du.kb();
        LinearGradient linearGradient2 = new LinearGradient(kb.x, kb.y, kb2.x, kb2.y, eli(kb3.DbA()), kb3.eli(), Shader.TileMode.CLAMP);
        this.MGA.put(aGH, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient Os() {
        long aGH = aGH();
        RadialGradient radialGradient = this.kb.get(aGH);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF kb = this.nlS.kb();
        PointF kb2 = this.NU.kb();
        com.bytedance.adsdk.DbA.Os.DbA.aGH kb3 = this.du.kb();
        int[] eli = eli(kb3.DbA());
        float[] eli2 = kb3.eli();
        RadialGradient radialGradient2 = new RadialGradient(kb.x, kb.y, (float) Math.hypot(kb2.x - r7, kb2.y - r8), eli, eli2, Shader.TileMode.CLAMP);
        this.kb.put(aGH, radialGradient2);
        return radialGradient2;
    }

    private int aGH() {
        int round = Math.round(this.nlS.wC() * this.aAs);
        int round2 = Math.round(this.NU.wC() * this.aAs);
        int round3 = Math.round(this.du.wC() * this.aAs);
        int i = round != 0 ? round * IronSourceError.ERROR_NON_EXISTENT_INSTANCE : 17;
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        return round3 != 0 ? i * 31 * round3 : i;
    }

    private int[] eli(int[] iArr) {
        if (this.nn == null) {
            return iArr;
        }
        throw null;
    }
}
