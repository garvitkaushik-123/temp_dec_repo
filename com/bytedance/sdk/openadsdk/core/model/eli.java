package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private int DbA;
    private int FC;
    private Vy MGA;
    private String Os;
    private CMM aAs;
    private String du;
    private String eli;
    private ev nlS;
    private ev ui;
    private List<ev> aGH = new ArrayList();
    private JSONObject kb = new JSONObject();
    private volatile boolean wC = false;

    public JSONObject eli() {
        return this.kb;
    }

    public void eli(JSONObject jSONObject) {
        this.kb = jSONObject;
    }

    public String DbA() {
        ev MGA = MGA();
        if (MGA != null) {
            return MGA.fO();
        }
        return "";
    }

    public void eli(String str) {
        this.eli = str;
    }

    public int Os() {
        return this.DbA;
    }

    public void eli(int i) {
        this.DbA = i;
    }

    public void DbA(String str) {
        this.Os = str;
    }

    public List<ev> aGH() {
        return this.aGH;
    }

    public void eli(ev evVar) {
        this.aGH.add(evVar);
        if (this.nlS == null) {
            this.nlS = evVar;
        }
    }

    public void eli(List<ev> list) {
        this.aGH = list;
        if (list.isEmpty()) {
            return;
        }
        this.nlS = list.get(0);
    }

    public static Map<String, ev> eli(eli eliVar) {
        if (eliVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (ev evVar : eliVar.aGH()) {
            if (!TextUtils.isEmpty(evVar.QxD())) {
                hashMap.put(evVar.QxD(), evVar);
            }
        }
        if (hashMap.size() != 0) {
            return hashMap;
        }
        return null;
    }

    public boolean ui() {
        List<ev> list = this.aGH;
        return list != null && list.size() > 0;
    }

    public ev MGA() {
        if (this.aGH.size() > 0) {
            return this.aGH.get(0);
        }
        return null;
    }

    public CMM kb() {
        return this.aAs;
    }

    public void eli(CMM cmm) {
        this.aAs = cmm;
    }

    public boolean wC() {
        return this.wC;
    }

    public void FC() {
        this.wC = false;
    }

    public void DbA(int i) {
        this.FC = i;
    }

    public boolean aAs() {
        return this.FC == 1;
    }

    public ev du() {
        return this.nlS;
    }

    public void eli(Vy vy) {
        this.MGA = vy;
    }

    public Vy nlS() {
        return this.MGA;
    }

    public JSONObject NU() {
        try {
            JSONObject jSONObject = new JSONObject();
            CMM kb = kb();
            if (kb != null) {
                jSONObject.put("loop_config", kb.du());
            }
            Vy nlS = nlS();
            if (nlS != null) {
                jSONObject.put("multi_ad_config", nlS.dV());
            }
            List<ev> list = this.aGH;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.aGH.size(); i++) {
                    jSONArray.put(this.aGH.get(i).iOb());
                }
                jSONObject.put("creatives", jSONArray);
            }
            jSONObject.put("multi_ad_style", this.FC);
            jSONObject.put("request_id", this.eli);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.eli("AdInfo", "toJsonObj: ", th);
            return null;
        }
    }

    public static eli DbA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            eli eliVar = new eli();
            eliVar.eli(CMM.eli(jSONObject.optJSONObject("loop_config")));
            eliVar.DbA(jSONObject.optInt("multi_ad_style", 0));
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ev eli = com.bytedance.sdk.openadsdk.core.DbA.eli(optJSONArray.optJSONObject(i), null, null, eliVar, i);
                    if (eli != null) {
                        arrayList.add(eli);
                    }
                }
                eliVar.eli(arrayList);
            }
            eliVar.eli(jSONObject.optString("request_id", ""));
            String optString = jSONObject.optString("multi_ad_config");
            if (!TextUtils.isEmpty(optString)) {
                eliVar.eli(Vy.eli(optString));
            }
            return eliVar;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.eli("AdInfo", "fromJson: ", th);
            return null;
        }
    }

    public void Os(String str) {
        this.du = str;
    }

    public String nn() {
        return this.du;
    }

    public ev Dfc() {
        return this.ui;
    }

    public void DbA(ev evVar) {
        this.ui = evVar;
    }
}
