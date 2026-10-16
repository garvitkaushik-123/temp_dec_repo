package com.bytedance.adsdk.DbA.Os.DbA;

/* loaded from: classes3.dex */
public class nlS implements Os {
    private final com.bytedance.adsdk.DbA.Os.eli.DbA DbA;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA Os;
    private final com.bytedance.adsdk.DbA.Os.eli.nlS aGH;
    private final String eli;
    private final boolean ui;

    public nlS(String str, com.bytedance.adsdk.DbA.Os.eli.DbA dbA, com.bytedance.adsdk.DbA.Os.eli.DbA dbA2, com.bytedance.adsdk.DbA.Os.eli.nlS nls, boolean z) {
        this.eli = str;
        this.DbA = dbA;
        this.Os = dbA2;
        this.aGH = nls;
        this.ui = z;
    }

    public String eli() {
        return this.eli;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA DbA() {
        return this.DbA;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA Os() {
        return this.Os;
    }

    public com.bytedance.adsdk.DbA.Os.eli.nlS aGH() {
        return this.aGH;
    }

    public boolean ui() {
        return this.ui;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.aqO(fc, eliVar, this);
    }
}
