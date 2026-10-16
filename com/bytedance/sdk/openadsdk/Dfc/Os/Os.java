package com.bytedance.sdk.openadsdk.Dfc.Os;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {

    public static class eli {
        public final JSONObject DbA;
        public final String eli;

        public eli(String str, JSONObject jSONObject) {
            this.eli = str;
            this.DbA = jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("device_info");
            if (optJSONObject != null) {
                try {
                    optJSONObject.put("gaid", com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA());
                    jSONObject.put("device_info", optJSONObject);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static DbA eli() {
        return aGH.eli();
    }
}
