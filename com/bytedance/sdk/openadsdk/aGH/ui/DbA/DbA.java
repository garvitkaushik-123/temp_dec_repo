package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA implements Os {
    private long DbA;
    private int Os;
    private int aGH;
    private long eli;

    public void eli(long j) {
        this.eli = j;
    }

    public void DbA(long j) {
        this.DbA = j;
    }

    public void eli(int i) {
        this.Os = i;
    }

    public void DbA(int i) {
        this.aGH = i;
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.ui.DbA.Os
    public void eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.eli);
            jSONObject.put("total_duration", this.DbA);
            jSONObject.put("vbtt_skip_type", this.Os);
            jSONObject.put("skip_reason", this.aGH);
        } catch (Throwable th) {
            Xb.Os("EndcardSkipModel", th.getMessage());
        }
    }
}
