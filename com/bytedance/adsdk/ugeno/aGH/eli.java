package com.bytedance.adsdk.ugeno.aGH;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class eli implements wC {
    @Override // com.bytedance.adsdk.ugeno.aGH.wC
    public List<kb> eli() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new kb("slide") { // from class: com.bytedance.adsdk.ugeno.aGH.eli.1
            @Override // com.bytedance.adsdk.ugeno.aGH.kb
            public com.bytedance.adsdk.ugeno.aGH.aGH.Os eli(Context context) {
                return new com.bytedance.adsdk.ugeno.aGH.aGH.ui(context);
            }
        });
        arrayList.add(new kb("tap") { // from class: com.bytedance.adsdk.ugeno.aGH.eli.2
            @Override // com.bytedance.adsdk.ugeno.aGH.kb
            public com.bytedance.adsdk.ugeno.aGH.aGH.Os eli(Context context) {
                return new com.bytedance.adsdk.ugeno.aGH.aGH.FC(context);
            }
        });
        arrayList.add(new kb("timer") { // from class: com.bytedance.adsdk.ugeno.aGH.eli.3
            @Override // com.bytedance.adsdk.ugeno.aGH.kb
            public com.bytedance.adsdk.ugeno.aGH.aGH.Os eli(Context context) {
                return new com.bytedance.adsdk.ugeno.aGH.aGH.aAs(context);
            }
        });
        arrayList.add(new kb("touchStart") { // from class: com.bytedance.adsdk.ugeno.aGH.eli.4
            @Override // com.bytedance.adsdk.ugeno.aGH.kb
            public com.bytedance.adsdk.ugeno.aGH.aGH.Os eli(Context context) {
                return new com.bytedance.adsdk.ugeno.aGH.aGH.nlS(context);
            }
        });
        arrayList.add(new kb("touchEnd") { // from class: com.bytedance.adsdk.ugeno.aGH.eli.5
            @Override // com.bytedance.adsdk.ugeno.aGH.kb
            public com.bytedance.adsdk.ugeno.aGH.aGH.Os eli(Context context) {
                return new com.bytedance.adsdk.ugeno.aGH.aGH.du(context);
            }
        });
        arrayList.add(new kb("animateState") { // from class: com.bytedance.adsdk.ugeno.aGH.eli.6
            @Override // com.bytedance.adsdk.ugeno.aGH.kb
            public com.bytedance.adsdk.ugeno.aGH.aGH.Os eli(Context context) {
                return new com.bytedance.adsdk.ugeno.aGH.aGH.DbA(context);
            }
        });
        return arrayList;
    }
}
