package com.bytedance.adsdk.DbA.eli.DbA;

import java.util.List;

/* loaded from: classes3.dex */
public class aGH extends kb<Float> {
    public aGH(List<com.bytedance.adsdk.DbA.kb.eli<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public Float eli(com.bytedance.adsdk.DbA.kb.eli<Float> eliVar, float f) {
        return Float.valueOf(Os(eliVar, f));
    }

    float Os(com.bytedance.adsdk.DbA.kb.eli<Float> eliVar, float f) {
        if (eliVar.eli == null || eliVar.DbA == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.Os != null) {
            eliVar.kb.floatValue();
            aGH();
            wC();
            throw null;
        }
        return com.bytedance.adsdk.DbA.MGA.ui.eli(eliVar.MGA(), eliVar.kb(), f);
    }

    public float FC() {
        return Os(Os(), ui());
    }
}
