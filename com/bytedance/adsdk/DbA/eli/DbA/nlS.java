package com.bytedance.adsdk.DbA.eli.DbA;

import java.util.List;

/* loaded from: classes3.dex */
public class nlS extends kb<com.bytedance.adsdk.DbA.kb.Os> {
    private final com.bytedance.adsdk.DbA.kb.Os aGH;

    public nlS(List<com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.kb.Os>> list) {
        super(list);
        this.aGH = new com.bytedance.adsdk.DbA.kb.Os();
    }

    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.DbA.kb.Os eli(com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.kb.Os> eliVar, float f) {
        if (eliVar.eli == null || eliVar.DbA == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.DbA.kb.Os os = eliVar.eli;
        com.bytedance.adsdk.DbA.kb.Os os2 = eliVar.DbA;
        if (this.Os != null) {
            eliVar.kb.floatValue();
            aGH();
            wC();
            throw null;
        }
        this.aGH.eli(com.bytedance.adsdk.DbA.MGA.ui.eli(os.eli(), os2.eli(), f), com.bytedance.adsdk.DbA.MGA.ui.eli(os.DbA(), os2.DbA(), f));
        return this.aGH;
    }
}
