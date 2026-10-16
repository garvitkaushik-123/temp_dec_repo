package com.bytedance.sdk.component.wC.DbA;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    public int DbA;
    public int Os;
    public int aGH;
    public int eli;

    public eli(int i, int i2, int i3, int i4) {
        this.eli = i;
        this.DbA = i2;
        this.Os = i3;
        this.aGH = i4;
    }

    public JSONObject eli() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_thread_num", this.eli);
            jSONObject.put("sdk_max_thread_num", this.DbA);
            jSONObject.put("app_thread_num", this.Os);
            jSONObject.put("app_max_thread_num", this.aGH);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
