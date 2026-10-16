package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui implements Os {
    private long DbA;
    private long eli;

    public void eli(long j) {
        this.eli = j;
    }

    public void DbA(long j) {
        this.DbA = j;
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.ui.DbA.Os
    public void eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.eli);
            jSONObject.put("total_duration", this.DbA);
        } catch (Throwable th) {
            Xb.Os("FeedContinueModel", th.getMessage());
        }
    }
}
