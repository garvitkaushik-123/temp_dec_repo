package com.bytedance.adsdk.DbA.eli.DbA;

import android.graphics.PointF;
import java.util.List;

/* loaded from: classes3.dex */
public class du extends kb<PointF> {
    private final PointF aGH;

    public du(List<com.bytedance.adsdk.DbA.kb.eli<PointF>> list) {
        super(list);
        this.aGH = new PointF();
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public PointF eli(com.bytedance.adsdk.DbA.kb.eli<PointF> eliVar, float f) {
        return eli(eliVar, f, f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public PointF eli(com.bytedance.adsdk.DbA.kb.eli<PointF> eliVar, float f, float f2, float f3) {
        if (eliVar.eli == null || eliVar.DbA == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = eliVar.eli;
        PointF pointF2 = eliVar.DbA;
        if (this.Os != null) {
            eliVar.kb.floatValue();
            aGH();
            wC();
            throw null;
        }
        this.aGH.set(pointF.x + (f2 * (pointF2.x - pointF.x)), pointF.y + (f3 * (pointF2.y - pointF.y)));
        return this.aGH;
    }
}
