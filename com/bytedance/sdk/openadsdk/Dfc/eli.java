package com.bytedance.sdk.openadsdk.Dfc;

import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.aGH.eli.MGA;
import com.bytedance.sdk.openadsdk.core.gG;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class eli {
    public static void eli() {
        if (cyF.MGA()) {
            cyF.eli(new wC("DailyTaskHelper") { // from class: com.bytedance.sdk.openadsdk.Dfc.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    eli.Os();
                }
            });
        } else {
            Os();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Os() {
        com.bytedance.sdk.openadsdk.aGH.eli.eli.DbA();
        MGA.eli();
        gG.eli();
    }
}
