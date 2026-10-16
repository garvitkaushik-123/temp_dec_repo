package com.bytedance.adsdk.DbA.Os.DbA;

import com.bytedance.adsdk.DbA.Os.DbA.nGm;
import java.util.List;

/* loaded from: classes3.dex */
public class MGA implements Os {
    private final kb DbA;
    private final nGm.DbA FC;
    private final com.bytedance.adsdk.DbA.Os.eli.MGA MGA;
    private final boolean NU;
    private final com.bytedance.adsdk.DbA.Os.eli.Os Os;
    private final float aAs;
    private final com.bytedance.adsdk.DbA.Os.eli.aGH aGH;
    private final List<com.bytedance.adsdk.DbA.Os.eli.DbA> du;
    private final String eli;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA kb;
    private final com.bytedance.adsdk.DbA.Os.eli.DbA nlS;
    private final com.bytedance.adsdk.DbA.Os.eli.MGA ui;
    private final nGm.eli wC;

    public MGA(String str, kb kbVar, com.bytedance.adsdk.DbA.Os.eli.Os os, com.bytedance.adsdk.DbA.Os.eli.aGH agh, com.bytedance.adsdk.DbA.Os.eli.MGA mga, com.bytedance.adsdk.DbA.Os.eli.MGA mga2, com.bytedance.adsdk.DbA.Os.eli.DbA dbA, nGm.eli eliVar, nGm.DbA dbA2, float f, List<com.bytedance.adsdk.DbA.Os.eli.DbA> list, com.bytedance.adsdk.DbA.Os.eli.DbA dbA3, boolean z) {
        this.eli = str;
        this.DbA = kbVar;
        this.Os = os;
        this.aGH = agh;
        this.ui = mga;
        this.MGA = mga2;
        this.kb = dbA;
        this.wC = eliVar;
        this.FC = dbA2;
        this.aAs = f;
        this.du = list;
        this.nlS = dbA3;
        this.NU = z;
    }

    public String eli() {
        return this.eli;
    }

    public kb DbA() {
        return this.DbA;
    }

    public com.bytedance.adsdk.DbA.Os.eli.Os Os() {
        return this.Os;
    }

    public com.bytedance.adsdk.DbA.Os.eli.aGH aGH() {
        return this.aGH;
    }

    public com.bytedance.adsdk.DbA.Os.eli.MGA ui() {
        return this.ui;
    }

    public com.bytedance.adsdk.DbA.Os.eli.MGA MGA() {
        return this.MGA;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA kb() {
        return this.kb;
    }

    public nGm.eli wC() {
        return this.wC;
    }

    public nGm.DbA FC() {
        return this.FC;
    }

    public List<com.bytedance.adsdk.DbA.Os.eli.DbA> aAs() {
        return this.du;
    }

    public com.bytedance.adsdk.DbA.Os.eli.DbA du() {
        return this.nlS;
    }

    public float nlS() {
        return this.aAs;
    }

    public boolean NU() {
        return this.NU;
    }

    @Override // com.bytedance.adsdk.DbA.Os.DbA.Os
    public com.bytedance.adsdk.DbA.eli.eli.Os eli(com.bytedance.adsdk.DbA.FC fc, com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.Os.Os.eli eliVar) {
        return new com.bytedance.adsdk.DbA.eli.eli.FC(fc, eliVar, this);
    }
}
