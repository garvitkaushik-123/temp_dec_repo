package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.dV;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aAs extends com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.component.FC.MGA> eli;

    public static void eli(dV dVVar, com.bytedance.sdk.component.FC.MGA mga) {
        dVVar.eli("preventTouchEvent", new aAs(mga));
    }

    public aAs(com.bytedance.sdk.component.FC.MGA mga) {
        this.eli = new WeakReference<>(mga);
    }

    @Override // com.bytedance.sdk.component.eli.ui
    public JSONObject eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean optBoolean = jSONObject.optBoolean("isPrevent", false);
            com.bytedance.sdk.component.FC.MGA mga2 = this.eli.get();
            if (mga2 != null) {
                mga2.setIsPreventTouchEvent(optBoolean);
                jSONObject2.put("success", true);
                return jSONObject2;
            }
            jSONObject2.put("success", false);
            return jSONObject2;
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
            return jSONObject2;
        }
    }
}
