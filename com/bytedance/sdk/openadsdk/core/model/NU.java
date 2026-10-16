package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NU {
    private String DbA;
    private int Os;
    private String eli;

    public String eli() {
        return this.eli;
    }

    public void eli(String str) {
        this.eli = str;
    }

    public String DbA() {
        return this.DbA;
    }

    public void DbA(String str) {
        this.DbA = str;
    }

    public int Os() {
        return this.Os;
    }

    public void eli(int i) {
        this.Os = i;
    }

    public JSONObject aGH() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("u", this.eli);
            jSONObject.put("ft", this.Os);
            jSONObject.put("fu", this.DbA);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
