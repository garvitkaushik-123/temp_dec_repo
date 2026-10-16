package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nn implements Os {
    private long DbA;
    private final int Os;
    private final int aGH;
    private long eli;
    private final String ui;

    public nn(com.bykv.vk.openvk.eli.eli.eli.Os.eli eliVar) {
        this.Os = eliVar.eli();
        this.aGH = eliVar.DbA();
        this.ui = eliVar.Os();
    }

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
            jSONObject.put(AndroidBridgeConstants.ERROR_CODE, this.Os);
            jSONObject.put("extra_error_code", this.aGH);
            jSONObject.put("error_message", this.ui);
        } catch (Throwable th) {
            Xb.Os("PlayErrorModel", th.getMessage());
        }
    }
}
