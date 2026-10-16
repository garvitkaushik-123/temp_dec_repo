package com.bytedance.sdk.openadsdk.core.settings;

import com.bytedance.sdk.openadsdk.core.settings.nlS;
import com.bytedance.sdk.openadsdk.core.settings.ui;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli extends nlS {
    public eli() {
        super("tt_set_apm.prop", new nlS.eli() { // from class: com.bytedance.sdk.openadsdk.core.settings.eli.1
            @Override // com.bytedance.sdk.openadsdk.core.settings.nlS.eli
            public void DbA() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.nlS.eli
            public void eli() {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.ui
    public void eli(JSONObject jSONObject) {
        ui.eli eli = eli();
        if (jSONObject.has("apm_url")) {
            eli.eli("apm_url", jSONObject.optString("apm_url"));
        }
        if (jSONObject.has("perf_con")) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("perf_con");
                if (optJSONObject != null && optJSONObject.has("perf_con_apm")) {
                    eli.eli("perf_con_apm", optJSONObject.optInt("perf_con_apm"));
                }
            } catch (Exception unused) {
            }
        }
        eli.eli();
        aGH();
    }
}
