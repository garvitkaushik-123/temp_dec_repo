package com.bytedance.adsdk.DbA.Os.DbA;

import android.graphics.PointF;

/* loaded from: classes3.dex */
public class DbA implements Os {
    private final com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> DbA;
    private final com.bytedance.adsdk.DbA.Os.eli.MGA Os;
    private final boolean aGH;
    private final String eli;
    private final boolean ui;

    public DbA(String str, com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> nu, com.bytedance.adsdk.DbA.Os.eli.MGA mga, boolean z, boolean z2) {
        this.eli = str;
        this.DbA = nu;
        this.Os = mga;
        this.aGH = z;
        this.ui = z2;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.MGA(fc, eliVar, this);
    }

    public String eli() {
        return this.eli;
    }

    public com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> DbA() {
        return this.DbA;
    }

    public com.bytedance.adsdk.DbA.Os.eli.MGA Os() {
        return this.Os;
    }

    public boolean aGH() {
        return this.aGH;
    }

    public boolean ui() {
        return this.ui;
    }
}
