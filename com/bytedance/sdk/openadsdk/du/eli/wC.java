package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.openadsdk.core.qj;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC extends com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject> {
    private final String DbA;
    private final qj eli;

    public wC(qj qjVar, String str) {
        this.eli = qjVar;
        this.DbA = str;
    }

    public static void eli(dV dVVar, qj qjVar) {
        dVVar.eli("endcardDynamicCreatives", new wC(qjVar, "endcardDynamicCreatives"));
        dVVar.eli("multiOpenCovert", new wC(qjVar, "multiOpenCovert"));
        dVVar.eli("skipToNextAd", new wC(qjVar, "skipToNextAd"));
        dVVar.eli("speedVideoOrTimer", new wC(qjVar, "speedVideoOrTimer"));
        dVVar.eli("openPlayable", new wC(qjVar, "openPlayable"));
    }

    @Override // com.bytedance.sdk.component.eli.ui
    public JSONObject eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        if ("endcardDynamicCreatives".equals(this.DbA)) {
            return this.eli.FC(jSONObject);
        }
        if ("multiOpenCovert".equals(this.DbA)) {
            this.eli.aAs(jSONObject);
            return null;
        }
        if ("skipToNextAd".equals(this.DbA)) {
            this.eli.eli(jSONObject, this.DbA);
            return null;
        }
        if ("speedVideoOrTimer".equals(this.DbA)) {
            return this.eli.wC(jSONObject);
        }
        if ("openPlayable".equals(this.DbA)) {
            return this.eli.kb(jSONObject);
        }
        return null;
    }
}
