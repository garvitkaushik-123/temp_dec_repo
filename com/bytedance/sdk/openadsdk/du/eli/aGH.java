package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.openadsdk.core.qj;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH extends com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject> {
    private final qj eli;

    public aGH(qj qjVar) {
        this.eli = qjVar;
    }

    public static void eli(dV dVVar, qj qjVar) {
        dVVar.eli("expressAdViewStartZoom", new aGH(qjVar));
    }

    @Override // com.bytedance.sdk.component.eli.ui
    public JSONObject eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        this.eli.aGH(jSONObject);
        return null;
    }
}
