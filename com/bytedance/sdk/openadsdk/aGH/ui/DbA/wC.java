package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC implements Os {
    private long DbA;
    private int Os;
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
            jSONObject.put("video_start_duration", this.eli);
            jSONObject.put("video_cache_size", this.DbA);
            jSONObject.put("is_auto_play", this.Os);
        } catch (Throwable th) {
            Xb.Os("FeedPlayModel", th.getMessage());
        }
    }
}
