package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Vy {
    private String FC;
    private int MGA;
    private int NU;
    private int Os;
    private int aGH;
    private boolean du;
    private int eli;
    private JSONObject kb;
    private oWW nGm;
    private JSONObject nlS;
    private int nn;
    private int ui;
    private int DbA = 10;
    private int wC = 1;
    private eli aAs = new eli();
    private int Dfc = 1;
    private String aqO = "Next Ad";
    private String dV = "Next ad in %1$ds";

    public static Vy eli(String str) {
        Vy vy = new Vy();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                vy.eli = jSONObject.optInt("auto_switch");
                vy.DbA = jSONObject.optInt("playable_preload_count");
                vy.Os = jSONObject.optInt("disable_on_interaction");
                vy.aGH = jSONObject.optInt("ceiling_type");
                vy.ui = jSONObject.optInt("can_loop");
                vy.MGA = jSONObject.optInt("multi_skip_time", -1);
                vy.wC = jSONObject.optInt("load_more_strategy");
                vy.Dfc = jSONObject.optInt("report_show_by_percent", 1);
                JSONObject optJSONObject = jSONObject.optJSONObject("gesture_tpl_info");
                vy.kb = optJSONObject;
                if (optJSONObject != null) {
                    oWW eli2 = oWW.eli(optJSONObject);
                    vy.nGm = eli2;
                    if (eli2 != null && !TextUtils.isEmpty(eli2.Os())) {
                        com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli(new com.bytedance.sdk.openadsdk.core.aAs.wC.eli().eli(vy.nGm.eli()).DbA(vy.nGm.DbA()).Os(vy.nGm.Os()).aGH(vy.nGm.aGH()), "guide");
                    }
                    int optInt = vy.kb.optInt("delay_show_time", 5);
                    vy.NU = optInt;
                    if (optInt < 0) {
                        vy.NU = 5;
                    }
                    int optInt2 = vy.kb.optInt("dismiss_after_idle_time", 3);
                    vy.nn = optInt2;
                    if (optInt2 <= 0) {
                        vy.nn = 3;
                    }
                }
                vy.FC = jSONObject.optString("agg_endcard_url");
                vy.du = jSONObject.optBoolean("has_more");
                vy.nlS = jSONObject.optJSONObject("session_params");
                vy.aAs = eli.eli(jSONObject.optJSONObject("layout_config"));
            } catch (JSONException unused) {
            }
        }
        return vy;
    }

    public boolean eli() {
        return this.Dfc == 1;
    }

    public JSONObject DbA() {
        oWW oww = this.nGm;
        if (oww == null) {
            return null;
        }
        try {
            String aGH = oww.aGH();
            if (!TextUtils.isEmpty(aGH)) {
                return new JSONObject(aGH);
            }
            String eli2 = com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli("guide", this.nGm.eli(), this.nGm.DbA());
            if (TextUtils.isEmpty(eli2)) {
                return null;
            }
            return new JSONObject(eli2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject Os() {
        oWW oww = this.nGm;
        if (oww == null) {
            return null;
        }
        return oww.ui();
    }

    public int aGH() {
        return this.NU;
    }

    public int ui() {
        return this.nn;
    }

    public eli MGA() {
        return this.aAs;
    }

    public String kb() {
        return this.FC;
    }

    public int wC() {
        return this.wC;
    }

    public int FC() {
        return this.MGA;
    }

    public boolean aAs() {
        return this.ui == 1;
    }

    public boolean du() {
        return this.aGH == 1;
    }

    public JSONObject nlS() {
        return this.nlS;
    }

    public boolean NU() {
        return this.du;
    }

    public boolean nn() {
        return this.Os == 1;
    }

    public boolean Dfc() {
        return this.eli == 1;
    }

    public int aqO() {
        return this.DbA;
    }

    public JSONObject dV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auto_switch", this.eli);
            jSONObject.put("playable_preload_count", this.DbA);
            jSONObject.put("disable_on_interaction", this.Os);
            jSONObject.put("ceiling_type", this.aGH);
            jSONObject.put("can_loop", this.ui);
            jSONObject.put("multi_skip_time", this.MGA);
            jSONObject.put("load_more_strategy", this.wC);
            jSONObject.put("report_show_by_percent", this.Dfc);
            jSONObject.put("gesture_tpl_info", this.kb);
            jSONObject.put("agg_endcard_url", this.FC);
            jSONObject.put("layoutConfig", this.aAs.MGA());
            jSONObject.put("has_more", this.du);
            jSONObject.put("session_params", this.nlS);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static class eli {
        private int DbA;
        private int Os;
        private int aGH;
        private int eli;
        private int ui;

        public static eli eli(JSONObject jSONObject) {
            eli eliVar = new eli();
            if (jSONObject == null) {
                return eliVar;
            }
            eliVar.eli = Math.max(0, jSONObject.optInt("padding_left", 0));
            eliVar.DbA = Math.max(0, jSONObject.optInt("padding_right", 0));
            eliVar.Os = Math.max(0, jSONObject.optInt("padding_top", 0));
            eliVar.aGH = Math.max(0, jSONObject.optInt("padding_bottom", 0));
            eliVar.ui = Math.max(0, jSONObject.optInt("card_spacing", 0));
            return eliVar;
        }

        public int eli() {
            return this.aGH;
        }

        public int DbA() {
            return this.Os;
        }

        public int Os() {
            return this.eli;
        }

        public int aGH() {
            return this.DbA;
        }

        public int ui() {
            return this.ui;
        }

        public JSONObject MGA() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("padding_left", this.eli);
                jSONObject.put("padding_right", this.DbA);
                jSONObject.put("padding_top", this.Os);
                jSONObject.put("padding_bottom", this.aGH);
                jSONObject.put("card_spacing", this.ui);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }
}
