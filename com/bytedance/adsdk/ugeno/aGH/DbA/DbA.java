package com.bytedance.adsdk.ugeno.aGH.DbA;

import com.bytedance.adsdk.ugeno.aGH.MGA;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class DbA extends eli {
    private List<com.bytedance.adsdk.ugeno.aGH.eli.aGH> FC;

    public DbA(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
        super(os, str, eliVar);
        this.FC = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.DbA.eli
    public void eli() {
        com.bytedance.adsdk.ugeno.aGH.eli.Os eli;
        if (this.MGA == null || this.MGA.size() <= 0) {
            return;
        }
        String str = this.MGA.get("name");
        com.bytedance.adsdk.ugeno.aGH.eli.eli Uv = this.Os.Uv();
        if (Uv == null || (eli = Uv.eli(str)) == null) {
            return;
        }
        eli.eli(str);
    }
}
