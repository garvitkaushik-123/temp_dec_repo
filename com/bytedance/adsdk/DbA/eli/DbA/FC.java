package com.bytedance.adsdk.DbA.eli.DbA;

import android.graphics.Path;
import android.graphics.PointF;

/* loaded from: classes3.dex */
public class FC extends com.bytedance.adsdk.DbA.kb.eli<PointF> {
    private Path aAs;
    private final com.bytedance.adsdk.DbA.kb.eli<PointF> du;

    public FC(com.bytedance.adsdk.DbA.kb kbVar, com.bytedance.adsdk.DbA.kb.eli<PointF> eliVar) {
        super(kbVar, eliVar.eli, eliVar.DbA, eliVar.Os, eliVar.aGH, eliVar.ui, eliVar.MGA, eliVar.kb);
        this.du = eliVar;
        eli();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void eli() {
        boolean z = (this.DbA == 0 || this.eli == 0 || !((PointF) this.eli).equals(((PointF) this.DbA).x, ((PointF) this.DbA).y)) ? false : true;
        if (this.eli == 0 || this.DbA == 0 || z) {
            return;
        }
        this.aAs = com.bytedance.adsdk.DbA.MGA.MGA.eli((PointF) this.eli, (PointF) this.DbA, this.du.wC, this.du.FC);
    }

    Path DbA() {
        return this.aAs;
    }
}
