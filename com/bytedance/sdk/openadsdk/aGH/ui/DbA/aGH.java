package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH implements Os {
    public long DbA;
    public int Os;
    public int aGH = 0;
    public long eli;

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
            jSONObject.put("total_duration", this.eli);
            jSONObject.put("buffers_time", this.DbA);
            jSONObject.put("break_reason", this.Os);
            jSONObject.put("video_backup", this.aGH);
        } catch (Throwable th) {
            Xb.Os("FeedBreakModel", th.getMessage());
        }
    }
}
