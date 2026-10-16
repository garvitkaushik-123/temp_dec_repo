package com.bytedance.adsdk.DbA.eli.eli;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* loaded from: classes3.dex */
public class Xb extends eli {
    private final boolean MGA;
    private final com.bytedance.adsdk.DbA.Os.Os.eli aGH;
    private final com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> kb;
    private final String ui;
    private com.bytedance.adsdk.DbA.eli.DbA.eli<ColorFilter, ColorFilter> wC;

    public Xb(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.Os.Os.eli eliVar, com.bytedance.adsdk.DbA.Os.DbA.nGm ngm) {
        super(fc, eliVar, ngm.kb().eli(), ngm.wC().eli(), ngm.FC(), ngm.Os(), ngm.aGH(), ngm.ui(), ngm.MGA());
        this.aGH = eliVar;
        this.ui = ngm.eli();
        this.MGA = ngm.aAs();
        com.bytedance.adsdk.DbA.eli.DbA.eli<Integer, Integer> eli = ngm.DbA().eli();
        this.kb = eli;
        eli.eli(this);
        eliVar.eli(eli);
    }

    @Override // com.bytedance.adsdk.DbA.eli.eli.eli, com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(Canvas canvas, Matrix matrix, int i) {
        if (this.MGA) {
            return;
        }
        this.DbA.setColor(((com.bytedance.adsdk.DbA.eli.DbA.DbA) this.kb).FC());
        if (this.wC != null) {
            this.DbA.setColorFilter(this.wC.kb());
        }
        super.eli(canvas, matrix, i);
    }
}
