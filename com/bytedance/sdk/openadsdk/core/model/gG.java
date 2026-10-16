package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class gG {
    private int DbA;
    private String Os = "Next Ad";
    private int eli;

    public int eli() {
        return this.DbA;
    }

    public void eli(int i) {
        this.DbA = i;
    }

    public String DbA() {
        return this.Os;
    }

    public void eli(String str) {
        this.Os = str;
    }

    public int Os() {
        return this.eli;
    }

    public void DbA(int i) {
        this.eli = i;
    }

    public static gG eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        gG gGVar = new gG();
        try {
            int max = Math.max(jSONObject.optInt("endcard_show_time", 0), 0);
            int optInt = jSONObject.optInt("is_allow_pause", 0);
            String optString = jSONObject.optString("endcard_next_ad_text", "Next Ad");
            gGVar.DbA(max);
            gGVar.eli(optInt);
            gGVar.eli(optString);
        } catch (Throwable unused) {
        }
        return gGVar;
    }

    public JSONObject aGH() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i = this.eli;
            if (i != -1) {
                jSONObject.put("endcard_show_time", i);
            }
            jSONObject.put("is_allow_pause", this.DbA);
            if (!TextUtils.isEmpty(this.Os)) {
                jSONObject.put("endcard_next_ad_text", this.Os);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
