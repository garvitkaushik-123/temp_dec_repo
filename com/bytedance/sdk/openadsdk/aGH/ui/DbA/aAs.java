package com.bytedance.sdk.openadsdk.aGH.ui.DbA;

import com.bytedance.sdk.component.utils.Xb;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aAs implements Os {
    private long DbA;
    private String MGA;
    private long Os;
    private int aGH;
    private String eli;
    private String ui;

    public void eli(String str) {
        this.eli = str;
    }

    public void eli(long j) {
        this.DbA = j;
    }

    public void DbA(long j) {
        this.Os = j;
    }

    public void eli(int i) {
        this.aGH = i;
    }

    public void DbA(String str) {
        this.ui = str;
    }

    public void Os(String str) {
        this.MGA = str;
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
            jSONObject.put(AndroidBridgeConstants.ERROR_CODE, this.aGH);
            jSONObject.put("error_message", this.ui);
            jSONObject.put("error_message_server", this.MGA);
        } catch (Throwable th) {
            Xb.Os("LoadVideoErrorModel", th.getMessage());
        }
    }
}
