package com.bytedance.adsdk.DbA.Os.DbA;

import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class aqO implements Os {
    private final List<Os> DbA;
    private final boolean Os;
    private final String eli;

    public aqO(String str, List<Os> list, boolean z) {
        this.eli = str;
        this.DbA = list;
        this.Os = z;
    }

    public String eli() {
        return this.eli;
    }

    public List<Os> DbA() {
        return this.DbA;
    }

    public boolean Os() {
        return this.Os;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.aGH(fc, eliVar, this, kbVar);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.eli + "' Shapes: " + Arrays.toString(this.DbA.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}
