package com.bytedance.adsdk.DbA.eli.DbA;

import java.util.List;

/* loaded from: classes3.dex */
public class MGA extends kb<Integer> {
    public MGA(List<com.bytedance.adsdk.DbA.kb.eli<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public Integer eli(com.bytedance.adsdk.DbA.kb.eli<Integer> eliVar, float f) {
        return Integer.valueOf(Os(eliVar, f));
    }

    int Os(com.bytedance.adsdk.DbA.kb.eli<Integer> eliVar, float f) {
        if (eliVar.eli == null || eliVar.DbA == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.Os != null) {
            eliVar.kb.floatValue();
            aGH();
            wC();
            throw null;
        }
        return com.bytedance.adsdk.DbA.MGA.ui.eli(eliVar.wC(), eliVar.FC(), f);
    }

    public int FC() {
        return Os(Os(), ui());
    }
}
