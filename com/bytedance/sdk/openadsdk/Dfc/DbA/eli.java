package com.bytedance.sdk.openadsdk.Dfc.DbA;

import com.bytedance.sdk.component.wC.Os;
import com.bytedance.sdk.openadsdk.Dfc.DbA;
import com.bytedance.sdk.openadsdk.Dfc.eli.aGH;
import com.bytedance.sdk.openadsdk.core.dV;

/* loaded from: classes3.dex */
public class eli implements Os {
    @Override // com.bytedance.sdk.component.wC.Os
    public void eli(final com.bytedance.sdk.component.wC.DbA.eli eliVar) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli();
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("stats_sdk_thread_num", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.DbA.eli.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                com.bytedance.sdk.component.wC.DbA.eli eliVar2;
                if (!dV.aGH().tGZ() || (eliVar2 = eliVar) == null || eliVar2.eli() == null) {
                    return null;
                }
                return aGH.DbA().eli("stats_sdk_thread_num").DbA(eliVar.eli().toString());
            }
        });
    }
}
