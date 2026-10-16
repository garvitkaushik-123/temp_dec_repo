package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class KM {
    private int DbA;
    private String Dfc;
    private int FC;
    private String MGA;
    private int NU;
    private boolean Os;
    private boolean aAs;
    private int aGH;
    private String aqO;
    private String dV;
    private int du;
    private int eli;
    private int kb;
    private int nlS;
    private int nn;
    private String ui;
    private int wC;

    private static int DbA(int i) {
        return i == 1 ? 10 : 5;
    }

    public static int eli(int i) {
        return i + 10;
    }

    public static boolean nn(ev evVar) {
        return true;
    }

    public int eli() {
        return this.du;
    }

    public int DbA() {
        return this.nlS;
    }

    public int Os() {
        return this.NU;
    }

    public int aGH() {
        return this.nn;
    }

    public String ui() {
        return this.Dfc;
    }

    public String MGA() {
        return this.aqO;
    }

    public String kb() {
        return this.dV;
    }

    public KM(JSONObject jSONObject) {
        this.du = 5;
        this.nlS = 5;
        this.NU = 10;
        this.nn = 20;
        this.Dfc = "Next Ad";
        this.aqO = "Next ad in %1$ds";
        this.dV = "Play Now";
        if (jSONObject == null) {
            return;
        }
        this.Os = jSONObject.optBoolean("is_playable");
        this.aGH = jSONObject.optInt("playable_type", 0);
        this.ui = jSONObject.optString("playable_style");
        JSONObject optJSONObject = jSONObject.optJSONObject("playable");
        if (optJSONObject != null) {
            this.MGA = optJSONObject.optString("playable_url", "");
            this.kb = optJSONObject.optInt("playable_orientation", 0);
            this.DbA = optJSONObject.optInt("new_style", 0);
            this.eli = optJSONObject.optInt("close_2_app", 0);
            int DbA = DbA(this.aGH);
            this.wC = optJSONObject.optInt("playable_webview_timeout", DbA);
            this.FC = optJSONObject.optInt("playable_js_timeout", DbA);
            this.aAs = optJSONObject.optInt("playable_backup_enable", 0) == 1;
            this.du = optJSONObject.optInt("wait_tips_time", 5);
            this.nlS = optJSONObject.optInt("auto_to_next_time", 5);
            this.NU = optJSONObject.optInt("next_ad_tips_show_time", 10);
            this.nn = optJSONObject.optInt("max_show_time", 20);
            this.aqO = optJSONObject.optString("next_ad_in_xs");
            this.Dfc = optJSONObject.optString("next_ad_text");
            this.dV = optJSONObject.optString("play_now_text");
        }
    }

    public static int eli(ev evVar) {
        int i;
        KM QI = evVar.QI();
        if (QI != null && (i = QI.eli) >= 0 && i <= 100) {
            return i;
        }
        return 0;
    }

    public void eli(JSONObject jSONObject) {
        try {
            jSONObject.put("is_playable", this.Os);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.Os("PlayableModel", e.getMessage());
        }
        if (!TextUtils.isEmpty(this.MGA)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("playable_url", this.MGA);
                jSONObject2.put("playable_orientation", this.kb);
                jSONObject2.put("new_style", this.DbA);
                jSONObject2.put("close_2_app", this.eli);
                jSONObject2.put("playable_webview_timeout", this.wC);
                jSONObject2.put("playable_js_timeout", this.FC);
                jSONObject2.put("playable_backup_enable", this.aAs ? 1 : 0);
                jSONObject2.put("wait_tips_time", this.du);
                jSONObject2.put("auto_to_next_time", this.nlS);
                jSONObject2.put("next_ad_tips_show_time", this.NU);
                jSONObject2.put("max_show_time", this.nn);
                jSONObject2.put("next_ad_in_xs", this.aqO);
                jSONObject2.put("play_now_text", this.dV);
                jSONObject2.put("next_ad_text", this.Dfc);
                jSONObject.put("playable", jSONObject2);
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.Xb.Os("PlayableModel", e2.getMessage());
            }
        }
        try {
            jSONObject.put("playable_type", this.aGH);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.Xb.Os("PlayableModel", e3.getMessage());
        }
        try {
            jSONObject.put("playable_style", this.ui);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.Xb.Os("PlayableModel", e4.getMessage());
        }
    }

    private static KM GB(ev evVar) {
        if (evVar == null) {
            return null;
        }
        return evVar.QI();
    }

    public static boolean DbA(ev evVar) {
        KM GB = GB(evVar);
        return (GB == null || !GB.Os || TextUtils.isEmpty(NU(evVar))) ? false : true;
    }

    public static boolean Os(ev evVar) {
        return DbA(evVar) && oWW(evVar) == 1;
    }

    public static boolean aGH(ev evVar) {
        return Os(evVar) && !FC(evVar);
    }

    public static boolean ui(ev evVar) {
        KM GB = GB(evVar);
        return GB != null && evVar.CQP() && GB.Os && !TextUtils.isEmpty(NU(evVar));
    }

    public static boolean MGA(ev evVar) {
        return ui(evVar) && oWW(evVar) == 1;
    }

    public static boolean kb(ev evVar) {
        KM GB = GB(evVar);
        return (GB == null || evVar.CQP() || !GB.Os || TextUtils.isEmpty(NU(evVar))) ? false : true;
    }

    public static boolean wC(ev evVar) {
        KM QI = evVar.QI();
        return QI != null && !evVar.CQP() && QI.Os && QI.DbA == 1;
    }

    public static boolean FC(ev evVar) {
        KM QI = evVar.QI();
        return QI != null && QI.Os && QI.DbA == 1;
    }

    public static boolean aAs(ev evVar) {
        KM QI = evVar.QI();
        return QI != null && evVar.CQP() && QI.Os && QI.DbA == 1;
    }

    private static int oWW(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return 0;
        }
        return GB.aGH;
    }

    public static String du(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return null;
        }
        return GB.ui;
    }

    public static String nlS(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return null;
        }
        return GB.MGA;
    }

    public static String NU(ev evVar) {
        if (evVar == null) {
            return null;
        }
        KM QI = evVar.QI();
        if (QI != null && QI.Os) {
            String str = QI.MGA;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        if (evVar.mm() == 20) {
            return evVar.dM();
        }
        if (evVar.nY() != null) {
            return evVar.nY().nlS();
        }
        return null;
    }

    public static boolean Dfc(ev evVar) {
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = evVar.nY();
        return nY != null && nY.Xb() == 1;
    }

    public static int aqO(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return 0;
        }
        return GB.kb;
    }

    public static boolean dV(ev evVar) {
        return kb(evVar) && oWW(evVar) == 1;
    }

    public static boolean nGm(ev evVar) {
        return kb(evVar) && oWW(evVar) == 0;
    }

    public int wC() {
        return this.wC;
    }

    public int FC() {
        return this.FC;
    }

    public boolean aAs() {
        return this.aAs;
    }

    public static long QX(ev evVar) {
        return Math.max(Xb(evVar), bf(evVar));
    }

    public static long Xb(ev evVar) {
        if (GB(evVar) == null) {
            return 5L;
        }
        return r2.wC();
    }

    public static long bf(ev evVar) {
        if (GB(evVar) == null) {
            return 5L;
        }
        return r2.FC();
    }

    public static boolean CMM(ev evVar) {
        KM GB = GB(evVar);
        return GB != null && GB.aAs();
    }

    public static int ev(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return 0;
        }
        return GB.eli();
    }

    public static String Vy(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return null;
        }
        return GB.ui();
    }

    public static String gG(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return null;
        }
        return GB.kb();
    }

    public static String ujq(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return null;
        }
        return GB.MGA();
    }

    public static int Ue(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return 0;
        }
        return GB.DbA();
    }

    public static int KM(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return 0;
        }
        return GB.Os();
    }

    public static int VM(ev evVar) {
        KM GB = GB(evVar);
        if (GB == null) {
            return 0;
        }
        return GB.aGH();
    }
}
