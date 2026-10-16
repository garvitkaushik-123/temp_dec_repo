package com.bytedance.sdk.openadsdk.core.aAs.wC;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private String DbA;
    private String Os;
    private String aGH;
    private String eli;
    private String ui;

    public String eli() {
        return this.eli;
    }

    public eli eli(String str) {
        this.eli = str;
        return this;
    }

    public String DbA() {
        return this.DbA;
    }

    public eli DbA(String str) {
        this.DbA = str;
        return this;
    }

    public String Os() {
        return this.Os;
    }

    public eli Os(String str) {
        this.Os = str;
        return this;
    }

    public String aGH() {
        return this.aGH;
    }

    public eli aGH(String str) {
        this.aGH = str;
        return this;
    }

    public String ui() {
        return this.ui;
    }

    public eli ui(String str) {
        this.ui = str;
        return this;
    }

    public JSONObject eli(eli eliVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.eli);
            jSONObject.put("md5", this.DbA);
            jSONObject.put("url", this.Os);
            if (eliVar != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", eliVar.eli());
                jSONObject2.put("md5", eliVar.DbA());
                jSONObject2.put("url", eliVar.Os());
                jSONObject.put("overlay", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
