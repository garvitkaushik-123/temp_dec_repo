package com.bytedance.adsdk.DbA.eli.DbA;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bytedance.adsdk.DbA.eli.DbA.eli;

/* loaded from: classes3.dex */
public class aqO {
    private final Matrix DbA;
    private eli<Float, Float> FC;
    private eli<PointF, PointF> MGA;
    private eli<?, Float> NU;
    private final Matrix Os;
    private eli<Integer, Integer> aAs;
    private final Matrix aGH;
    private aGH du;
    private final Matrix eli = new Matrix();
    private eli<?, PointF> kb;
    private aGH nlS;
    private eli<?, Float> nn;
    private final float[] ui;
    private eli<com.bytedance.adsdk.DbA.kb.Os, com.bytedance.adsdk.DbA.kb.Os> wC;

    public aqO(com.bytedance.adsdk.DbA.Os.eli.nlS nls) {
        this.MGA = nls.eli() == null ? null : nls.eli().eli();
        this.kb = nls.DbA() == null ? null : nls.DbA().eli();
        this.wC = nls.Os() == null ? null : nls.Os().eli();
        this.FC = nls.aGH() == null ? null : nls.aGH().eli();
        aGH agh = nls.wC() == null ? null : (aGH) nls.wC().eli();
        this.du = agh;
        if (agh != null) {
            this.DbA = new Matrix();
            this.Os = new Matrix();
            this.aGH = new Matrix();
            this.ui = new float[9];
        } else {
            this.DbA = null;
            this.Os = null;
            this.aGH = null;
            this.ui = null;
        }
        this.nlS = nls.FC() == null ? null : (aGH) nls.FC().eli();
        if (nls.ui() != null) {
            this.aAs = nls.ui().eli();
        }
        if (nls.MGA() != null) {
            this.NU = nls.MGA().eli();
        } else {
            this.NU = null;
        }
        if (nls.kb() != null) {
            this.nn = nls.kb().eli();
        } else {
            this.nn = null;
        }
    }

    public void eli(com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        eliVar.eli(this.aAs);
        eliVar.eli(this.NU);
        eliVar.eli(this.nn);
        eliVar.eli(this.MGA);
        eliVar.eli(this.kb);
        eliVar.eli(this.wC);
        eliVar.eli(this.FC);
        eliVar.eli(this.du);
        eliVar.eli(this.nlS);
    }

    public void eli(eli.InterfaceC0115eli interfaceC0115eli) {
        eli<Integer, Integer> eliVar = this.aAs;
        if (eliVar != null) {
            eliVar.eli(interfaceC0115eli);
        }
        eli<?, Float> eliVar2 = this.NU;
        if (eliVar2 != null) {
            eliVar2.eli(interfaceC0115eli);
        }
        eli<?, Float> eliVar3 = this.nn;
        if (eliVar3 != null) {
            eliVar3.eli(interfaceC0115eli);
        }
        eli<PointF, PointF> eliVar4 = this.MGA;
        if (eliVar4 != null) {
            eliVar4.eli(interfaceC0115eli);
        }
        eli<?, PointF> eliVar5 = this.kb;
        if (eliVar5 != null) {
            eliVar5.eli(interfaceC0115eli);
        }
        eli<com.bytedance.adsdk.DbA.kb.Os, com.bytedance.adsdk.DbA.kb.Os> eliVar6 = this.wC;
        if (eliVar6 != null) {
            eliVar6.eli(interfaceC0115eli);
        }
        eli<Float, Float> eliVar7 = this.FC;
        if (eliVar7 != null) {
            eliVar7.eli(interfaceC0115eli);
        }
        aGH agh = this.du;
        if (agh != null) {
            agh.eli(interfaceC0115eli);
        }
        aGH agh2 = this.nlS;
        if (agh2 != null) {
            agh2.eli(interfaceC0115eli);
        }
    }

    public void eli(float f) {
        eli<Integer, Integer> eliVar = this.aAs;
        if (eliVar != null) {
            eliVar.eli(f);
        }
        eli<?, Float> eliVar2 = this.NU;
        if (eliVar2 != null) {
            eliVar2.eli(f);
        }
        eli<?, Float> eliVar3 = this.nn;
        if (eliVar3 != null) {
            eliVar3.eli(f);
        }
        eli<PointF, PointF> eliVar4 = this.MGA;
        if (eliVar4 != null) {
            eliVar4.eli(f);
        }
        eli<?, PointF> eliVar5 = this.kb;
        if (eliVar5 != null) {
            eliVar5.eli(f);
        }
        eli<com.bytedance.adsdk.DbA.kb.Os, com.bytedance.adsdk.DbA.kb.Os> eliVar6 = this.wC;
        if (eliVar6 != null) {
            eliVar6.eli(f);
        }
        eli<Float, Float> eliVar7 = this.FC;
        if (eliVar7 != null) {
            eliVar7.eli(f);
        }
        aGH agh = this.du;
        if (agh != null) {
            agh.eli(f);
        }
        aGH agh2 = this.nlS;
        if (agh2 != null) {
            agh2.eli(f);
        }
    }

    public eli<?, Integer> eli() {
        return this.aAs;
    }

    public eli<?, Float> DbA() {
        return this.NU;
    }

    public eli<?, Float> Os() {
        return this.nn;
    }

    public Matrix aGH() {
        PointF kb;
        float FC;
        PointF kb2;
        this.eli.reset();
        eli<?, PointF> eliVar = this.kb;
        if (eliVar != null && (kb2 = eliVar.kb()) != null && (kb2.x != 0.0f || kb2.y != 0.0f)) {
            this.eli.preTranslate(kb2.x, kb2.y);
        }
        eli<Float, Float> eliVar2 = this.FC;
        if (eliVar2 != null) {
            if (eliVar2 instanceof dV) {
                FC = eliVar2.kb().floatValue();
            } else {
                FC = ((aGH) eliVar2).FC();
            }
            if (FC != 0.0f) {
                this.eli.preRotate(FC);
            }
        }
        if (this.du != null) {
            float cos = this.nlS == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.FC()) + 90.0f));
            float sin = this.nlS == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.FC()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(r0.FC()));
            ui();
            float[] fArr = this.ui;
            fArr[0] = cos;
            fArr[1] = sin;
            float f = -sin;
            fArr[3] = f;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.DbA.setValues(fArr);
            ui();
            float[] fArr2 = this.ui;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.Os.setValues(fArr2);
            ui();
            float[] fArr3 = this.ui;
            fArr3[0] = cos;
            fArr3[1] = f;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.aGH.setValues(fArr3);
            this.Os.preConcat(this.DbA);
            this.aGH.preConcat(this.Os);
            this.eli.preConcat(this.aGH);
        }
        eli<com.bytedance.adsdk.DbA.kb.Os, com.bytedance.adsdk.DbA.kb.Os> eliVar3 = this.wC;
        if (eliVar3 != null) {
            com.bytedance.adsdk.DbA.kb.Os kb3 = eliVar3.kb();
            if (kb3.eli() != 1.0f || kb3.DbA() != 1.0f) {
                this.eli.preScale(kb3.eli(), kb3.DbA());
            }
        }
        eli<PointF, PointF> eliVar4 = this.MGA;
        if (eliVar4 != null && (((kb = eliVar4.kb()) != null && kb.x != 0.0f) || kb.y != 0.0f)) {
            this.eli.preTranslate(-kb.x, -kb.y);
        }
        return this.eli;
    }

    private void ui() {
        for (int i = 0; i < 9; i++) {
            this.ui[i] = 0.0f;
        }
    }

    public Matrix DbA(float f) {
        eli<?, PointF> eliVar = this.kb;
        PointF kb = eliVar == null ? null : eliVar.kb();
        eli<com.bytedance.adsdk.DbA.kb.Os, com.bytedance.adsdk.DbA.kb.Os> eliVar2 = this.wC;
        com.bytedance.adsdk.DbA.kb.Os kb2 = eliVar2 == null ? null : eliVar2.kb();
        this.eli.reset();
        if (kb != null) {
            this.eli.preTranslate(kb.x * f, kb.y * f);
        }
        if (kb2 != null) {
            double d = f;
            this.eli.preScale((float) Math.pow(kb2.eli(), d), (float) Math.pow(kb2.DbA(), d));
        }
        eli<Float, Float> eliVar3 = this.FC;
        if (eliVar3 != null) {
            float floatValue = eliVar3.kb().floatValue();
            eli<PointF, PointF> eliVar4 = this.MGA;
            PointF kb3 = eliVar4 != null ? eliVar4.kb() : null;
            this.eli.preRotate(floatValue * f, kb3 == null ? 0.0f : kb3.x, kb3 != null ? kb3.y : 0.0f);
        }
        return this.eli;
    }
}
