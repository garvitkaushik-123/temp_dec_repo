package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Dfc {
    private final int DbA;
    private final int eli;

    public Dfc(JSONObject jSONObject) {
        this.eli = jSONObject.optInt("auto_click", 0);
        this.DbA = jSONObject.optInt("hidden_bar", 0);
    }

    public int eli() {
        return this.eli;
    }

    public boolean DbA() {
        return this.DbA == 1;
    }

    public JSONObject Os() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = this.eli;
            if (i == 1) {
                jSONObject.put("auto_click", i);
            }
            if (this.DbA == 1) {
                jSONObject.put("hidden_bar", 1);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean eli(ev evVar) {
        if (evVar == null || !evVar.Kv() || evVar.Pw() == null) {
            return false;
        }
        return evVar.Pw().DbA();
    }
}
