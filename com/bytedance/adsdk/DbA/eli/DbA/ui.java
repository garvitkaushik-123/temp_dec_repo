package com.bytedance.adsdk.DbA.eli.DbA;

import java.util.List;

/* loaded from: classes3.dex */
public class ui extends kb<com.bytedance.adsdk.DbA.Os.DbA.aGH> {
    private final com.bytedance.adsdk.DbA.Os.DbA.aGH aGH;

    public ui(List<com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH>> list) {
        super(list);
        com.bytedance.adsdk.DbA.Os.DbA.aGH agh = list.get(0).eli;
        int Os = agh != null ? agh.Os() : 0;
        this.aGH = new com.bytedance.adsdk.DbA.Os.DbA.aGH(new float[Os], new int[Os]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.DbA.eli.DbA.eli
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.DbA.Os.DbA.aGH eli(com.bytedance.adsdk.DbA.kb.eli<com.bytedance.adsdk.DbA.Os.DbA.aGH> eliVar, float f) {
        this.aGH.eli(eliVar.eli, eliVar.DbA, f);
        return this.aGH;
    }
}
