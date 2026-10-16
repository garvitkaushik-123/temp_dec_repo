package com.bytedance.sdk.openadsdk.aGH.DbA;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os implements DbA {
    DbA eli;

    @Override // com.bytedance.sdk.openadsdk.aGH.DbA.DbA
    public void eli(JSONObject jSONObject, long j) throws JSONException {
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.eli(jSONObject, j);
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        jSONObject.put("event_ts", j);
    }
}
