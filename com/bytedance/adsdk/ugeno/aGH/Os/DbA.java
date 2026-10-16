package com.bytedance.adsdk.ugeno.aGH.Os;

import com.bytedance.adsdk.ugeno.aGH.MGA;
import com.ironsource.C3040d4;

/* loaded from: classes3.dex */
public class DbA extends com.bytedance.adsdk.ugeno.aGH.DbA.eli {
    public DbA(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
        super(os, str, eliVar);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.DbA.eli
    public void eli() {
        if (this.Os == null) {
            return;
        }
        int eli = com.bytedance.adsdk.ugeno.kb.Os.eli(this.MGA.get(C3040d4.h.L), 0);
        com.bytedance.adsdk.ugeno.DbA.Os DbA = this.Os.DbA(this.Os);
        if (DbA == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.DbA.Os ui = DbA.ui("SwiperView");
        if (ui instanceof com.bytedance.adsdk.ugeno.DbA) {
            ((com.bytedance.adsdk.ugeno.DbA) ui).eli(eli);
        }
    }
}
