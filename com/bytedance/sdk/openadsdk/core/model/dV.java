package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class dV {
    private eli eli;

    public dV(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("easy_playable")) == null) {
            return;
        }
        this.eli = new eli(optJSONObject.optJSONObject("components"));
    }

    public static boolean eli(ev evVar) {
        dV ehi;
        eli eliVar;
        return (evVar == null || (ehi = evVar.ehi()) == null || (eliVar = ehi.eli) == null || !eliVar.eli()) ? false : true;
    }

    public static eli DbA(ev evVar) {
        dV ehi;
        if (evVar == null || (ehi = evVar.ehi()) == null) {
            return null;
        }
        return ehi.eli;
    }

    public static class eli {
        C0193eli DbA;
        C0193eli eli;

        public eli(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            if (jSONObject.has("vertical")) {
                this.eli = new C0193eli(jSONObject.optJSONObject("vertical"));
            }
            if (jSONObject.has("horizontal")) {
                this.DbA = new C0193eli(jSONObject.optJSONObject("horizontal"));
            }
        }

        public boolean eli() {
            C0193eli c0193eli = this.DbA;
            if (c0193eli != null && c0193eli.eli()) {
                return true;
            }
            C0193eli c0193eli2 = this.eli;
            return c0193eli2 != null && c0193eli2.eli();
        }

        public String eli(boolean z) {
            if (z) {
                C0193eli c0193eli = this.eli;
                if (c0193eli != null) {
                    return c0193eli.eli;
                }
                return "";
            }
            C0193eli c0193eli2 = this.DbA;
            if (c0193eli2 != null) {
                return c0193eli2.eli;
            }
            return "";
        }

        /* renamed from: com.bytedance.sdk.openadsdk.core.model.dV$eli$eli, reason: collision with other inner class name */
        public static class C0193eli {
            String eli;

            public C0193eli(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.eli = jSONObject.optString("entry");
            }

            public boolean eli() {
                return !TextUtils.isEmpty(this.eli);
            }
        }
    }
}
