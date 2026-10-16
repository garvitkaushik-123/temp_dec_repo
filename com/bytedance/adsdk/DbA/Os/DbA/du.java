package com.bytedance.adsdk.DbA.Os.DbA;

import android.graphics.PointF;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class du implements Os {
    private final com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> DbA;
    private final com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> Os;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA aGH;
    private final String eli;
    private final boolean ui;

    public du(String str, com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> nu, com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> nu2, com.bytedance.adsdk.DbA.Os.eli.DbA dbA, boolean z) {
        this.eli = str;
        this.DbA = nu;
        this.Os = nu2;
        this.aGH = dbA;
        this.ui = z;
    }

    public String eli() {
        return this.eli;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA DbA() {
        return this.aGH;
    }

    public com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> Os() {
        return this.Os;
    }

    public com.bytedance.adsdk.DbA.Os.eli.NU<PointF, PointF> aGH() {
        return this.DbA;
    }

    public boolean ui() {
        return this.ui;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.Dfc(fc, eliVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.DbA + ", size=" + this.Os + AbstractJsonLexerKt.END_OBJ;
    }
}
