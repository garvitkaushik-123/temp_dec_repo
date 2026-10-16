package com.bytedance.adsdk.DbA.Os.DbA;

import android.graphics.Path;

/* loaded from: classes3.dex */
public class ui implements Os {
    private final Path.FillType DbA;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA FC;
    private final com.bytedance.adsdk.DbA.Os.eli.MGA MGA;
    private final com.bytedance.adsdk.DbA.Os.eli.Os Os;
    private final boolean aAs;
    private final com.bytedance.adsdk.DbA.Os.eli.aGH aGH;
    private final kb eli;
    private final String kb;
    private final com.bytedance.adsdk.DbA.Os.eli.MGA ui;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA wC;

    public ui(String str, kb kbVar, Path.FillType fillType, com.bytedance.adsdk.DbA.Os.eli.Os os, com.bytedance.adsdk.DbA.Os.eli.aGH agh, com.bytedance.adsdk.DbA.Os.eli.MGA mga, com.bytedance.adsdk.DbA.Os.eli.MGA mga2, com.bytedance.adsdk.DbA.Os.eli.DbA dbA, com.bytedance.adsdk.DbA.Os.eli.DbA dbA2, boolean z) {
        this.eli = kbVar;
        this.DbA = fillType;
        this.Os = os;
        this.aGH = agh;
        this.ui = mga;
        this.MGA = mga2;
        this.kb = str;
        this.wC = dbA;
        this.FC = dbA2;
        this.aAs = z;
    }

    public String eli() {
        return this.kb;
    }

    public kb DbA() {
        return this.eli;
    }

    public Path.FillType Os() {
        return this.DbA;
    }

    public com.bytedance.adsdk.DbA.Os.eli.Os aGH() {
        return this.Os;
    }

    public com.bytedance.adsdk.DbA.Os.eli.aGH ui() {
        return this.aGH;
    }

    public com.bytedance.adsdk.DbA.Os.eli.MGA MGA() {
        return this.ui;
    }

    public com.bytedance.adsdk.DbA.Os.eli.MGA kb() {
        return this.MGA;
    }

    public boolean wC() {
        return this.aAs;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.wC(fc, kbVar, eliVar, this);
    }
}
