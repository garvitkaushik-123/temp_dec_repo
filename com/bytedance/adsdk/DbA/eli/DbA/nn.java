package com.bytedance.adsdk.DbA.eli.DbA;

import android.graphics.PointF;
import java.util.Collections;

/* loaded from: classes3.dex */
public class nn extends eli<PointF, PointF> {
    private final eli<Float, Float> FC;
    private final PointF MGA;
    protected com.bytedance.adsdk.DbA.kb.DbA<Float> aGH;
    private final PointF kb;
    protected com.bytedance.adsdk.DbA.kb.DbA<Float> ui;
    private final eli<Float, Float> wC;

    public nn(eli<Float, Float> eliVar, eli<Float, Float> eliVar2) {
        super(Collections.emptyList());
        this.MGA = new PointF();
        this.kb = new PointF();
        this.wC = eliVar;
        this.FC = eliVar2;
        eli(wC());
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    public void eli(float f) {
        this.wC.eli(f);
        this.FC.eli(f);
        this.MGA.set(this.wC.kb().floatValue(), this.FC.kb().floatValue());
        for (int i = 0; i < this.eli.size(); i++) {
            this.eli.get(i).eli();
        }
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: FC, reason: merged with bridge method [inline-methods] */
    public PointF kb() {
        return eli(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public PointF eli(com.bytedance.adsdk.DbA.kb.eli<PointF> eliVar, float f) {
        com.bytedance.adsdk.DbA.kb.eli<Float> Os;
        com.bytedance.adsdk.DbA.kb.eli<Float> Os2;
        if (this.aGH != null && (Os2 = this.wC.Os()) != null) {
            this.wC.ui();
            Float f2 = Os2.kb;
            if (f2 == null) {
                throw null;
            }
            f2.floatValue();
            throw null;
        }
        if (this.ui != null && (Os = this.FC.Os()) != null) {
            this.FC.ui();
            Float f3 = Os.kb;
            if (f3 == null) {
                throw null;
            }
            f3.floatValue();
            throw null;
        }
        this.kb.set(this.MGA.x, 0.0f);
        PointF pointF = this.kb;
        pointF.set(pointF.x, this.MGA.y);
        return this.kb;
    }
}
