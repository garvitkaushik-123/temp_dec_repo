package com.bytedance.sdk.openadsdk.Vy.DbA;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private final int DbA;
    private final float Os;
    private final int eli;

    public eli(int i, int i2, float f) {
        this.eli = i;
        this.DbA = i2;
        this.Os = f;
    }

    public static JSONObject eli(eli eliVar) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", eliVar.eli);
        jSONObject.put("height", eliVar.DbA);
        jSONObject.put("alpha", eliVar.Os);
        return jSONObject;
    }
}
