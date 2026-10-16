package com.bytedance.adsdk.DbA.eli.DbA;

import android.graphics.Path;
import com.bytedance.adsdk.DbA.eli.eli.QX;
import java.util.List;

/* loaded from: classes3.dex */
public class NU extends eli<com.bytedance.adsdk.DbA.Os.DbA.nn, Path> {
    private List<QX> MGA;
    private final com.bytedance.adsdk.DbA.Os.DbA.nn aGH;
    private final Path ui;

    public NU(List<com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.Os.DbA.nn>> list) {
        super(list);
        this.aGH = new com.bytedance.adsdk.DbA.Os.DbA.nn();
        this.ui = new Path();
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public Path eli(com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.Os.DbA.nn> eliVar, float f) {
        this.aGH.eli(eliVar.eli, eliVar.DbA, f);
        com.bytedance.adsdk.DbA.Os.DbA.nn nnVar = this.aGH;
        List<QX> list = this.MGA;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                nnVar = this.MGA.get(size).eli(nnVar);
            }
        }
        com.bytedance.adsdk.DbA.MGA.ui.eli(nnVar, this.ui);
        return this.ui;
    }

    public void eli(List<QX> list) {
        this.MGA = list;
    }
}
