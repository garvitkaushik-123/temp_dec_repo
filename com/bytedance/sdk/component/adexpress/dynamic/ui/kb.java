package com.bytedance.sdk.component.adexpress.dynamic.ui;

import com.bytedance.sdk.component.adexpress.DbA.NU;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb implements wC {
    private com.bytedance.sdk.component.adexpress.dynamic.MGA.DbA eli;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ui.wC
    public void eli(com.bytedance.sdk.component.adexpress.dynamic.MGA.DbA dbA) {
        this.eli = dbA;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ui.wC
    public void eli(final NU nu) {
        if (nu.nlS() == 1) {
            DbA(nu);
        } else {
            com.bytedance.sdk.component.adexpress.aGH.aGH.eli(new com.bytedance.sdk.component.wC.wC("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.ui.kb.1
                @Override // java.lang.Runnable
                public void run() {
                    kb.this.DbA(nu);
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(NU nu) {
        try {
            JSONObject Os = nu.Os();
            JSONObject jSONObject = new JSONObject(Os.optString("template_Plugin"));
            JSONObject optJSONObject = Os.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.aGH.wC eli = new MGA(jSONObject, optJSONObject, Os.optJSONObject("AdSize"), new JSONObject(Os.optString("diff_template_Plugin"))).eli(nu.DbA(), nu.aAs(), optJSONObject.optDouble("score_exact_i18n"), optJSONObject.optString("comment_num_i18n"), nu);
            try {
                JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("dynamic_creative"));
                eli.eli(jSONObject2.optString("color"));
                eli.eli(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.eli.eli(eli);
        } catch (Exception unused2) {
        }
    }
}
