package com.bytedance.sdk.openadsdk.core.model;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private String DbA;
    private String Os;
    private String aGH;
    private String eli;
    private boolean ui;

    public void eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.eli = jSONObject.optString("icon");
        this.DbA = jSONObject.optString("text");
        this.Os = jSONObject.optString(CampaignEx.JSON_KEY_PRIVACY_URL);
        this.aGH = jSONObject.optString("privacy_title");
    }

    public String eli() {
        return this.eli;
    }

    public String DbA() {
        return this.DbA;
    }

    public String Os() {
        return this.Os;
    }

    public String aGH() {
        return this.aGH;
    }

    public boolean ui() {
        return this.ui;
    }

    public void eli(boolean z) {
        this.ui = z;
    }

    public JSONObject MGA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_PRIVACY_URL, this.Os);
            jSONObject.put("privacy_title", this.aGH);
            jSONObject.put("text", this.DbA);
            jSONObject.put("icon", this.eli);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
