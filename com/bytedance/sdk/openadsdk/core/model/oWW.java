package com.bytedance.sdk.openadsdk.core.model;

import io.ktor.http.LinkHeader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class oWW {
    private String DbA;
    private eli MGA;
    private String Os;
    private String aGH;
    private String eli;
    private JSONObject ui;

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

    public JSONObject ui() {
        return this.ui;
    }

    public eli MGA() {
        return this.MGA;
    }

    public static oWW eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        oWW oww = new oWW();
        oww.eli = jSONObject.optString("id");
        oww.aGH = jSONObject.optString("data");
        oww.Os = jSONObject.optString("url");
        oww.DbA = jSONObject.optString("md5");
        oww.ui = jSONObject.optJSONObject("custom_components");
        JSONObject optJSONObject = jSONObject.optJSONObject(LinkHeader.Rel.PreLoad);
        if (optJSONObject != null) {
            oww.MGA = eli.eli(optJSONObject);
        }
        return oww;
    }

    public JSONObject kb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.eli);
            jSONObject.put("md5", this.DbA);
            jSONObject.put("url", this.Os);
            jSONObject.put("data", this.aGH);
            jSONObject.put("custom_components", this.ui);
            eli eliVar = this.MGA;
            if (eliVar != null) {
                jSONObject.put(LinkHeader.Rel.PreLoad, eliVar.aGH());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static class eli {
        private JSONArray DbA;
        private JSONArray Os;
        private JSONArray eli;

        public JSONArray eli() {
            return this.eli;
        }

        public void eli(JSONArray jSONArray) {
            this.eli = jSONArray;
        }

        public JSONArray DbA() {
            return this.DbA;
        }

        public void DbA(JSONArray jSONArray) {
            this.DbA = jSONArray;
        }

        public JSONArray Os() {
            return this.Os;
        }

        public void Os(JSONArray jSONArray) {
            this.Os = jSONArray;
        }

        public static eli eli(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("image");
            eli eliVar = new eli();
            eliVar.eli(optJSONArray);
            eliVar.DbA(jSONObject.optJSONArray("fetch"));
            eliVar.Os(jSONObject.optJSONArray("script"));
            return eliVar;
        }

        public JSONObject aGH() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("image", this.eli);
                jSONObject.put("fetch", this.DbA);
                jSONObject.put("script", this.Os);
                return jSONObject;
            } catch (JSONException e) {
                e.getMessage();
                return jSONObject;
            }
        }
    }
}
