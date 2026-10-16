package com.bytedance.adsdk.ugeno.aGH;

import com.bytedance.adsdk.ugeno.aGH.MGA;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ui implements Os {
    @Override // com.bytedance.adsdk.ugeno.aGH.Os
    public List<DbA> eli() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DbA("update") { // from class: com.bytedance.adsdk.ugeno.aGH.ui.1
            @Override // com.bytedance.adsdk.ugeno.aGH.DbA
            public com.bytedance.adsdk.ugeno.aGH.DbA.eli eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
                return new com.bytedance.adsdk.ugeno.aGH.DbA.ui(os, str, eliVar);
            }
        });
        arrayList.add(new DbA("emit") { // from class: com.bytedance.adsdk.ugeno.aGH.ui.2
            @Override // com.bytedance.adsdk.ugeno.aGH.DbA
            public com.bytedance.adsdk.ugeno.aGH.DbA.eli eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
                return new com.bytedance.adsdk.ugeno.aGH.DbA.DbA(os, str, eliVar);
            }
        });
        arrayList.add(new DbA("startAnimate") { // from class: com.bytedance.adsdk.ugeno.aGH.ui.3
            @Override // com.bytedance.adsdk.ugeno.aGH.DbA
            public com.bytedance.adsdk.ugeno.aGH.DbA.eli eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
                return new com.bytedance.adsdk.ugeno.aGH.DbA.aGH(os, str, eliVar);
            }
        });
        return arrayList;
    }
}
