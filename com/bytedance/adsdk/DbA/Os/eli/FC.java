package com.bytedance.adsdk.DbA.Os.eli;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes3.dex */
public class FC implements NU<PointF, PointF> {
    private final DbA DbA;
    private final DbA eli;

    public FC(DbA dbA, DbA dbA2) {
        this.eli = dbA;
        this.DbA = dbA2;
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.NU
    public List<com.bytedance.adsdk.DbA.kb.eli<PointF>> Os() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.NU
    public boolean DbA() {
        return this.eli.DbA() && this.DbA.DbA();
    }

    @Override // com.bytedance.adsdk.DbA.Os.eli.NU
    public com.bytedance.adsdk.DbA.eli.DbA.eli<PointF, PointF> eli() {
        return new com.bytedance.adsdk.DbA.eli.DbA.nn(this.eli.eli(), this.DbA.eli());
    }
}
