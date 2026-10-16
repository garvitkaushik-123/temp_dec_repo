package com.bytedance.adsdk.DbA.eli.DbA;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* loaded from: classes3.dex */
public class aAs extends kb<PointF> {
    private final PathMeasure MGA;
    private final PointF aGH;
    private FC kb;
    private final float[] ui;

    public aAs(List<? extends com.bytedance.adsdk.DbA.kb.eli<PointF>> list) {
        super(list);
        this.aGH = new PointF();
        this.ui = new float[2];
        this.MGA = new PathMeasure();
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public PointF eli(com.bytedance.adsdk.DbA.kb.eli<PointF> eliVar, float f) {
        FC fc = (FC) eliVar;
        Path DbA = fc.DbA();
        if (DbA == null) {
            return eliVar.eli;
        }
        if (this.Os != null) {
            fc.kb.floatValue();
            aGH();
            wC();
            throw null;
        }
        if (this.kb != fc) {
            this.MGA.setPath(DbA, false);
            this.kb = fc;
        }
        PathMeasure pathMeasure = this.MGA;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.ui, null);
        PointF pointF = this.aGH;
        float[] fArr = this.ui;
        pointF.set(fArr[0], fArr[1]);
        return this.aGH;
    }
}
