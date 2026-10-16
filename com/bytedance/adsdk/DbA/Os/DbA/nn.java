package com.bytedance.adsdk.DbA.Os.DbA;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class nn {
    private PointF DbA;
    private boolean Os;
    private final List<com.bytedance.adsdk.DbA.Os.eli> eli;

    public nn(PointF pointF, boolean z, List<com.bytedance.adsdk.DbA.Os.eli> list) {
        this.DbA = pointF;
        this.Os = z;
        this.eli = new ArrayList(list);
    }

    public nn() {
        this.eli = new ArrayList();
    }

    public void eli(float f, float f2) {
        if (this.DbA == null) {
            this.DbA = new PointF();
        }
        this.DbA.set(f, f2);
    }

    public PointF eli() {
        return this.DbA;
    }

    public void eli(boolean z) {
        this.Os = z;
    }

    public boolean DbA() {
        return this.Os;
    }

    public List<com.bytedance.adsdk.DbA.Os.eli> Os() {
        return this.eli;
    }

    public void eli(nn nnVar, nn nnVar2, float f) {
        if (this.DbA == null) {
            this.DbA = new PointF();
        }
        this.Os = nnVar.DbA() || nnVar2.DbA();
        if (nnVar.Os().size() != nnVar2.Os().size()) {
            nnVar.Os().size();
            nnVar2.Os().size();
        }
        int min = Math.min(nnVar.Os().size(), nnVar2.Os().size());
        if (this.eli.size() < min) {
            for (int size = this.eli.size(); size < min; size++) {
                this.eli.add(new com.bytedance.adsdk.DbA.Os.eli());
            }
        } else if (this.eli.size() > min) {
            for (int size2 = this.eli.size() - 1; size2 >= min; size2--) {
                List<com.bytedance.adsdk.DbA.Os.eli> list = this.eli;
                list.remove(list.size() - 1);
            }
        }
        PointF eli = nnVar.eli();
        PointF eli2 = nnVar2.eli();
        eli(com.bytedance.adsdk.DbA.MGA.ui.eli(eli.x, eli2.x, f), com.bytedance.adsdk.DbA.MGA.ui.eli(eli.y, eli2.y, f));
        for (int size3 = this.eli.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.DbA.Os.eli eliVar = nnVar.Os().get(size3);
            com.bytedance.adsdk.DbA.Os.eli eliVar2 = nnVar2.Os().get(size3);
            PointF eli3 = eliVar.eli();
            PointF DbA = eliVar.DbA();
            PointF Os = eliVar.Os();
            PointF eli4 = eliVar2.eli();
            PointF DbA2 = eliVar2.DbA();
            PointF Os2 = eliVar2.Os();
            this.eli.get(size3).eli(com.bytedance.adsdk.DbA.MGA.ui.eli(eli3.x, eli4.x, f), com.bytedance.adsdk.DbA.MGA.ui.eli(eli3.y, eli4.y, f));
            this.eli.get(size3).DbA(com.bytedance.adsdk.DbA.MGA.ui.eli(DbA.x, DbA2.x, f), com.bytedance.adsdk.DbA.MGA.ui.eli(DbA.y, DbA2.y, f));
            this.eli.get(size3).Os(com.bytedance.adsdk.DbA.MGA.ui.eli(Os.x, Os2.x, f), com.bytedance.adsdk.DbA.MGA.ui.eli(Os.y, Os2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.eli.size() + "closed=" + this.Os + AbstractJsonLexerKt.END_OBJ;
    }
}
