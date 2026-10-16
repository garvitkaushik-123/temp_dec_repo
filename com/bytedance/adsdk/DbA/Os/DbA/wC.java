package com.bytedance.adsdk.DbA.Os.DbA;

/* loaded from: classes3.dex */
public class wC {
    private final com.bytedance.adsdk.DbA.Os.eli.wC DbA;
    private final com.bytedance.adsdk.DbA.Os.eli.aGH Os;
    private final boolean aGH;
    private final eli eli;

    public enum eli {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public wC(eli eliVar, com.bytedance.adsdk.DbA.Os.eli.wC wCVar, com.bytedance.adsdk.DbA.Os.eli.aGH agh, boolean z) {
        this.eli = eliVar;
        this.DbA = wCVar;
        this.Os = agh;
        this.aGH = z;
    }

    public eli eli() {
        return this.eli;
    }

    public com.bytedance.adsdk.DbA.Os.eli.wC DbA() {
        return this.DbA;
    }

    public com.bytedance.adsdk.DbA.Os.eli.aGH Os() {
        return this.Os;
    }

    public boolean aGH() {
        return this.aGH;
    }
}
