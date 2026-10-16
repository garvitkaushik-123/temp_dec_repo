package com.bytedance.adsdk.DbA.Os.DbA;

import android.graphics.Path;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class Dfc implements Os {
    private final Path.FillType DbA;
    private final boolean MGA;
    private final String Os;
    private final com.bytedance.adsdk.DbA.Os.eli.eli aGH;
    private final boolean eli;
    private final com.bytedance.adsdk.DbA.Os.eli.aGH ui;

    public Dfc(String str, boolean z, Path.FillType fillType, com.bytedance.adsdk.DbA.Os.eli.eli eliVar, com.bytedance.adsdk.DbA.Os.eli.aGH agh, boolean z2) {
        this.Os = str;
        this.eli = z;
        this.DbA = fillType;
        this.aGH = eliVar;
        this.ui = agh;
        this.MGA = z2;
    }

    public String eli() {
        return this.Os;
    }

    public com.bytedance.adsdk.DbA.Os.eli.eli DbA() {
        return this.aGH;
    }

    public com.bytedance.adsdk.DbA.Os.eli.aGH Os() {
        return this.ui;
    }

    public Path.FillType aGH() {
        return this.DbA;
    }

    public boolean ui() {
        return this.MGA;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.kb(fc, eliVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.eli + AbstractJsonLexerKt.END_OBJ;
    }
}
