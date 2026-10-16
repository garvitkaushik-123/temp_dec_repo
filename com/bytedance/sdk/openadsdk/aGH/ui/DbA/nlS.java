package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nlS implements Os {
    private long DbA;
    private long Os;
    private long aGH;
    private String eli;

    public void eli(String str) {
        this.eli = str;
    }

    public void eli(long j) {
        this.DbA = j;
    }

    public void DbA(long j) {
        this.Os = j;
    }

    public void Os(long j) {
        this.aGH = j;
    }

    @Override // com.bytedance.sdk.openadsdk.aGH.ui.DbA.Os
    public void eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.eli);
            jSONObject.put("preload_size", this.DbA);
            jSONObject.put("load_time", this.Os);
            jSONObject.put("local_cache", this.aGH);
        } catch (Throwable th) {
            Xb.Os("LoadVideoSuccessModel", th.getMessage());
        }
    }
}
