package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA implements Os {
    private long DbA;
    private int Os = 0;
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

    @Override // com.bytedance.sdk.openadsdk.aGH.ui.DbA.Os
    public void eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.eli);
            jSONObject.put("buffers_time", this.DbA);
            jSONObject.put("video_backup", this.Os);
        } catch (Throwable th) {
            Xb.Os("FeedOverModel", th.getMessage());
        }
    }
}
