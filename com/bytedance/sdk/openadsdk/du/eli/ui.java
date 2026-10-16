package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.dV;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui extends com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject> {
    private JSONObject eli;

    public ui(JSONObject jSONObject) {
        this.eli = jSONObject;
    }

    public static void eli(dV dVVar, JSONObject jSONObject) {
        dVVar.eli("getData", new ui(jSONObject));
    }

    @Override // com.bytedance.sdk.component.eli.ui
    public JSONObject eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        return com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(this.eli, jSONObject);
    }
}
