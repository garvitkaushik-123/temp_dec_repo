package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du implements Os {
    private final long DbA;
    private final String eli;

    public du(String str, long j) {
        this.eli = str;
        this.DbA = j;
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.ui.DbA.Os
    public void eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.eli);
            jSONObject.put("preload_size", this.DbA);
        } catch (Throwable th) {
            Xb.Os("LoadVideoStartModel", th.getMessage());
        }
    }
}
