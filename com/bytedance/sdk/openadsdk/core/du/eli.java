package com.bytedance.sdk.openadsdk.core.du;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.ev;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    DbA DbA;
    private int FC;
    private String MGA;
    Os Os;
    private int aAs;
    private String aGH;
    private String kb;
    private String nlS;
    private String ui;
    private double wC;
    final com.bytedance.sdk.openadsdk.core.model.aGH eli = new com.bytedance.sdk.openadsdk.core.model.aGH();
    private String du = "VAST_ACTION_BUTTON";

    public aGH eli() {
        return this.eli.eli();
    }

    public DbA DbA() {
        return this.DbA;
    }

    public Os Os() {
        return this.Os;
    }

    public String aGH() {
        return this.aGH;
    }

    public String ui() {
        return this.ui;
    }

    public String MGA() {
        return this.MGA;
    }

    public String kb() {
        return this.kb;
    }

    public void eli(DbA dbA) {
        if (dbA != null) {
            dbA.eli(this.kb);
        }
        this.DbA = dbA;
    }

    public void eli(Os os) {
        if (os != null) {
            os.eli(this.kb);
        }
        this.Os = os;
    }

    public void eli(String str) {
        this.aGH = str;
    }

    public void DbA(String str) {
        this.ui = str;
    }

    public void Os(String str) {
        this.MGA = str;
    }

    public void aGH(String str) {
        this.kb = str;
    }

    public double wC() {
        return this.wC;
    }

    public void eli(double d) {
        this.wC = d;
    }

    public String FC() {
        Os os;
        String str = this.MGA;
        if (!TextUtils.isEmpty(this.nlS)) {
            String str2 = this.nlS;
            this.nlS = null;
            return str2;
        }
        String str3 = this.du;
        str3.hashCode();
        if (str3.equals("VAST_ICON")) {
            DbA dbA = this.DbA;
            if (dbA != null && !TextUtils.isEmpty(dbA.wC)) {
                str = this.DbA.wC;
            }
        } else if (str3.equals("VAST_END_CARD") && (os = this.Os) != null && !TextUtils.isEmpty(os.wC)) {
            str = this.Os.wC;
        }
        this.du = "VAST_ACTION_BUTTON";
        return str;
    }

    public void ui(String str) {
        this.du = str;
    }

    public JSONObject aAs() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        aGH eli = this.eli.eli();
        if (eli != null) {
            jSONObject.put("videoTrackers", eli.eli());
        }
        DbA dbA = this.DbA;
        if (dbA != null) {
            jSONObject.put("vastIcon", dbA.eli());
        }
        Os os = this.Os;
        if (os != null) {
            jSONObject.put("endCard", os.eli());
        }
        jSONObject.put("title", this.aGH);
        jSONObject.put("description", this.ui);
        jSONObject.put("clickThroughUrl", this.MGA);
        jSONObject.put(UnifiedMediationParams.KEY_VIDEO_URL, this.kb);
        jSONObject.put("videDuration", this.wC);
        jSONObject.put("videoWidth", this.FC);
        jSONObject.put("videoHeight", this.aAs);
        jSONObject.put("viewabilityVendor", Dfc());
        return jSONObject;
    }

    private JSONArray Dfc() {
        Set<aAs> DbA = this.eli.DbA();
        if (DbA == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (aAs aas : DbA) {
            if (aas != null) {
                jSONArray.put(aas.aGH());
            }
        }
        return jSONArray;
    }

    public static eli eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        eli eliVar = new eli();
        aGH eli = eliVar.eli.eli();
        if (eli == null) {
            eli = new aGH();
            eliVar.eli.eli(eli);
        }
        eli.eli(jSONObject.optJSONObject("videoTrackers"));
        eliVar.DbA = DbA.eli(jSONObject.optJSONObject("vastIcon"));
        eliVar.Os = Os.DbA(jSONObject.optJSONObject("endCard"));
        eliVar.aGH = jSONObject.optString("title");
        eliVar.ui = jSONObject.optString("description");
        eliVar.MGA = jSONObject.optString("clickThroughUrl");
        eliVar.kb = jSONObject.optString(UnifiedMediationParams.KEY_VIDEO_URL);
        eliVar.wC = jSONObject.optDouble("videDuration");
        eliVar.FC = jSONObject.optInt("videoWidth");
        eliVar.FC = jSONObject.optInt("videoHeight");
        Set<aAs> DbA = eliVar.eli.DbA();
        if (DbA == null) {
            DbA = new HashSet<>();
            eliVar.eli.eli(DbA);
        }
        DbA.addAll(aAs.eli(jSONObject.optJSONArray("viewabilityVendor")));
        return eliVar;
    }

    public void eli(ev evVar) {
        this.eli.eli(evVar);
        DbA dbA = this.DbA;
        if (dbA != null) {
            dbA.eli(evVar);
        }
        Os os = this.Os;
        if (os != null) {
            os.eli(evVar);
        }
    }

    public void eli(int i) {
        this.FC = i;
    }

    public void DbA(int i) {
        this.aAs = i;
    }

    public int du() {
        return this.FC;
    }

    public int nlS() {
        return this.aAs;
    }

    public void eli(Set<aAs> set) {
        this.eli.DbA(set);
    }

    public Set<aAs> NU() {
        return this.eli.DbA();
    }

    public void MGA(String str) {
        this.nlS = str;
    }

    public com.bytedance.sdk.openadsdk.core.model.aGH nn() {
        return this.eli;
    }
}
