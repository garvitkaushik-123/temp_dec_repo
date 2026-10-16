package com.fyber.inneractive.sdk.config;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1106a = new HashMap();

    public m() {
    }

    public m(JSONObject jSONObject) {
        JSONArray names;
        JSONArray names2 = jSONObject.names();
        for (int i = 0; i < names2.length(); i++) {
            String optString = names2.optString(i, null);
            JSONObject optJSONObject = jSONObject.optJSONObject(optString);
            l lVar = new l();
            if (optJSONObject != null && (names = optJSONObject.names()) != null) {
                for (int i2 = 0; i2 < names.length(); i2++) {
                    String optString2 = names.optString(i2, null);
                    String optString3 = optJSONObject.optString(optString2, null);
                    if (optString2 != null && optString3 != null) {
                        lVar.f1104a.put(optString2, optString3);
                    }
                }
            }
            this.f1106a.put(optString, lVar);
        }
    }
}
