package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.openadsdk.core.qj;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NU extends com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject> {
    private qj eli;

    public NU(qj qjVar) {
        this.eli = qjVar;
    }

    public static void eli(dV dVVar, qj qjVar) {
        dVVar.eli("sendLogV3", new NU(qjVar));
    }

    @Override // com.bytedance.sdk.component.eli.ui
    public JSONObject eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        new Object[]{"SendLogV3Method, params is:", jSONObject};
        this.eli.du(jSONObject);
        return null;
    }
}
