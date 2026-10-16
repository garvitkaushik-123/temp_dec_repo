package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CMM {
    private String eli = "horizontal";
    private int DbA = 1;
    private int Os = 1;
    private int aGH = 0;
    private int ui = 0;
    private int MGA = 0;
    private int kb = 0;
    private int wC = 5000;
    private int FC = 500;
    private int aAs = 0;

    public String eli() {
        return this.eli;
    }

    public int DbA() {
        return this.DbA;
    }

    public int Os() {
        return this.Os;
    }

    public int aGH() {
        return this.aGH;
    }

    public int ui() {
        return this.ui;
    }

    public int MGA() {
        return this.MGA;
    }

    public int kb() {
        return this.kb;
    }

    public int wC() {
        return this.wC;
    }

    public int FC() {
        return this.FC;
    }

    public int aAs() {
        return this.aAs;
    }

    public static CMM eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new CMM();
        }
        CMM cmm = new CMM();
        cmm.eli = jSONObject.optString("direction", "horizontal");
        cmm.DbA = jSONObject.optInt("auto_loop", 1);
        cmm.Os = jSONObject.optInt("allow_manual_loop", 1);
        cmm.aGH = jSONObject.optInt("unlimited_loop", 0);
        cmm.ui = jSONObject.optInt("left_margin", 0);
        cmm.MGA = jSONObject.optInt("right_margin", 0);
        cmm.kb = jSONObject.optInt("ad_margin", 0);
        cmm.wC = jSONObject.optInt("loop_interval_time", 5000);
        cmm.FC = jSONObject.optInt("flip_speed", 500);
        cmm.aAs = jSONObject.optInt("stop_auto_loop", 0);
        return cmm;
    }

    public JSONObject du() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("direction", this.eli);
            jSONObject.put("auto_loop", this.DbA);
            jSONObject.put("allow_manual_loop", this.Os);
            jSONObject.put("unlimited_loop", this.aGH);
            jSONObject.put("left_margin", this.ui);
            jSONObject.put("right_margin", this.MGA);
            jSONObject.put("ad_margin", this.kb);
            jSONObject.put("loop_interval_time", this.wC);
            jSONObject.put("flip_speed", this.FC);
            jSONObject.put("stop_auto_loop", this.aAs);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
