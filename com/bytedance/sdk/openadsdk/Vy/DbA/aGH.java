package com.bytedance.sdk.openadsdk.Vy.DbA;

import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.core.du.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    public static void eli(final ev evVar, final eli eliVar, final ui.eli eliVar2) {
        evVar.Spd();
        cyF.Os(new com.bytedance.sdk.component.wC.wC("mrc_report") { // from class: com.bytedance.sdk.openadsdk.Vy.DbA.aGH.1
            @Override // java.lang.Runnable
            public void run() {
                if (evVar.fa()) {
                    if (evVar.nie()) {
                        com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(evVar.tpZ(), new Os.DbA("show_urls", evVar));
                    } else {
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar);
                    }
                }
                String eli = dZ.eli(evVar);
                JSONObject jSONObject = new JSONObject();
                eli eliVar3 = eliVar;
                if (eliVar3 != null) {
                    try {
                        jSONObject.put("root_view", eli.eli(eliVar3));
                        ui.eli eliVar4 = eliVar2;
                        if (eliVar4 != null) {
                            if (eliVar4.eli != -1) {
                                jSONObject.put("dynamic_show_type", eliVar2.eli);
                            }
                            if (eliVar2.DbA != -1) {
                                com.bytedance.sdk.openadsdk.aGH.Os.eli(eliVar2.DbA + 1, jSONObject);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, eli, "mrc_show", jSONObject);
            }
        });
    }
}
