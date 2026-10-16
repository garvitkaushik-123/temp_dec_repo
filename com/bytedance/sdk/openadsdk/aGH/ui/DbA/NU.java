package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NU implements Os {
    public int DbA;
    public long Os;
    public long eli;

    public void eli(long j) {
        this.eli = j;
    }

    public void eli(int i) {
        this.DbA = i;
    }

    public void DbA(long j) {
        this.Os = j;
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.ui.DbA.Os
    public void eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.eli);
            jSONObject.put("buffers_count", this.DbA);
            jSONObject.put("total_duration", this.Os);
        } catch (Throwable th) {
            Xb.Os("PlayBufferModel", th.getMessage());
        }
    }
}
