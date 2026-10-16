package com.bytedance.adsdk.DbA.Os.eli;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes3.dex */
public class ui implements NU<PointF, PointF> {
    private final List<com.bytedance.adsdk.DbA.kb.eli<PointF>> eli;

    public ui(List<com.bytedance.adsdk.DbA.kb.eli<PointF>> list) {
        this.eli = list;
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.NU
    public List<com.bytedance.adsdk.DbA.kb.eli<PointF>> Os() {
        return this.eli;
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.NU
    public boolean DbA() {
        return this.eli.size() == 1 && this.eli.get(0).ui();
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.NU
    public com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli() {
        if (this.eli.get(0).ui()) {
            return new com.bytedance.adsdk.DbA.eli.DbA.du(this.eli);
        }
        return new com.bytedance.adsdk.DbA.eli.DbA.aAs(this.eli);
    }
}
