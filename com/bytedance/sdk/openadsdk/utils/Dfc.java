package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.nlS;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Dfc implements com.bytedance.sdk.openadsdk.oem.eli {
    private static com.bytedance.sdk.openadsdk.component.reward.eli.eli DbA;
    private static boolean Os;
    private static final Dfc eli = new Dfc();

    public static void eli(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        com.bytedance.sdk.openadsdk.core.model.Ue Mn = eliVar.DbA.Mn();
        if (Mn == null || !Mn.kb()) {
            return;
        }
        DbA = eliVar;
        IPMiBroadcastReceiver eli2 = IPMiBroadcastReceiver.eli(eliVar.FS);
        if (eli2 != null) {
            eli2.eli(eli);
        }
    }

    public static void eli() {
        if (DbA == null) {
            return;
        }
        DbA = null;
        IPMiBroadcastReceiver eli2 = IPMiBroadcastReceiver.eli(com.bytedance.sdk.openadsdk.core.dV.eli());
        if (eli2 != null) {
            eli2.eli();
        }
        Os = false;
    }

    public static void DbA() {
        Os = true;
    }

    @Override // com.bytedance.sdk.openadsdk.oem.eli
    public void eli(String str, final int i) {
        com.bytedance.sdk.openadsdk.core.model.MGA pu;
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = DbA;
        if (eliVar == null || (pu = eliVar.DbA.pu()) == null) {
            return;
        }
        String Os2 = pu.Os();
        if (TextUtils.isEmpty(Os2) || !Os2.equals(str)) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.Dfc.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                if (Dfc.DbA == null || (i2 = i) <= 0 || i2 > 5) {
                    return;
                }
                boolean z = true;
                boolean z2 = i2 == 1;
                if (Dfc.Os) {
                    Dfc.DbA.Uv.MGA();
                    HashMap hashMap = new HashMap();
                    hashMap.put("click_scence", 4);
                    com.bytedance.sdk.openadsdk.aGH.Os.eli("click", Dfc.DbA.DbA, new nlS.eli().eli(), Dfc.DbA.ui, true, (Map<String, Object>) hashMap, 1);
                } else {
                    z = z2;
                }
                if (z) {
                    Dfc.eli();
                }
            }
        });
    }
}
