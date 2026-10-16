package com.bytedance.adsdk.DbA.Os.DbA;

import com.bytedance.adsdk.DbA.eli.eli.bf;

/* loaded from: classes3.dex */
public class QX implements Os {
    private final eli DbA;
    private final boolean MGA;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA Os;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA aGH;
    private final String eli;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA ui;

    public enum eli {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static eli eli(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public QX(String str, eli eliVar, com.bytedance.adsdk.DbA.Os.eli.DbA dbA, com.bytedance.adsdk.DbA.Os.eli.DbA dbA2, com.bytedance.adsdk.DbA.Os.eli.DbA dbA3, boolean z) {
        this.eli = str;
        this.DbA = eliVar;
        this.Os = dbA;
        this.aGH = dbA2;
        this.ui = dbA3;
        this.MGA = z;
    }

    public String eli() {
        return this.eli;
    }

    public eli DbA() {
        return this.DbA;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA Os() {
        return this.aGH;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA aGH() {
        return this.Os;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA ui() {
        return this.ui;
    }

    public boolean MGA() {
        return this.MGA;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new bf(eliVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.Os + ", end: " + this.aGH + ", offset: " + this.ui + "}";
    }
}
