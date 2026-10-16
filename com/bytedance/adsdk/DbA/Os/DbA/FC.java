package com.bytedance.adsdk.DbA.Os.DbA;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class FC implements Os {
    private final eli DbA;
    private final boolean Os;
    private final String eli;

    public enum eli {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static eli eli(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }

    public FC(String str, eli eliVar, boolean z) {
        this.eli = str;
        this.DbA = eliVar;
        this.Os = z;
    }

    public String eli() {
        return this.eli;
    }

    public eli DbA() {
        return this.DbA;
    }

    public boolean Os() {
        return this.Os;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.nlS(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.DbA + AbstractJsonLexerKt.END_OBJ;
    }
}
