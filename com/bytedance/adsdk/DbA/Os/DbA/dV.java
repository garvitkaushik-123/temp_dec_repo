package com.bytedance.adsdk.DbA.Os.DbA;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class dV implements Os {
    private final int DbA;
    private final com.bytedance.adsdk.DbA.Os.eli.wC Os;
    private final boolean aGH;
    private final String eli;

    public dV(String str, int i, com.bytedance.adsdk.DbA.Os.eli.wC wCVar, boolean z) {
        this.eli = str;
        this.DbA = i;
        this.Os = wCVar;
        this.aGH = z;
    }

    public String eli() {
        return this.eli;
    }

    public com.bytedance.adsdk.DbA.Os.eli.wC DbA() {
        return this.Os;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.nGm(fc, eliVar, this);
    }

    public boolean Os() {
        return this.aGH;
    }

    public String toString() {
        return "ShapePath{name=" + this.eli + ", index=" + this.DbA + AbstractJsonLexerKt.END_OBJ;
    }
}
