package com.bytedance.sdk.openadsdk.aAs;

import android.content.Context;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.QX.eli.eli.MGA;
import com.bytedance.sdk.openadsdk.QX.eli.eli.kb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli implements Os {
    private final DbA DbA;
    private final Map<String, MGA> Os = new HashMap();
    private final ev eli;

    private eli(DbA dbA, ev evVar) {
        this.DbA = dbA;
        this.eli = evVar;
    }

    public static eli eli(DbA dbA, ev evVar) {
        return new eli(dbA, evVar);
    }

    @Override // com.bytedance.sdk.openadsdk.aAs.Os
    public void eli() {
        this.Os.clear();
    }

    private ev eli(JSONObject jSONObject, String str) {
        String eli;
        if (jSONObject == null) {
            return null;
        }
        ev evVar = new ev();
        evVar.ui(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            evVar.ujq(str);
        }
        if (this.eli != null) {
            String eli2 = evVar.pu() != null ? evVar.pu().eli() : null;
            if (TextUtils.isEmpty(eli2)) {
                return this.eli;
            }
            com.bytedance.sdk.openadsdk.core.model.MGA pu = this.eli.pu();
            if (pu != null && eli2.equals(pu.eli())) {
                return this.eli;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (pu != null) {
                try {
                    eli = pu.eli();
                } catch (JSONException unused) {
                }
            } else {
                eli = "null";
            }
            jSONObject2.put("lu", eli);
            jSONObject2.put("ju", eli2);
            ev evVar2 = this.eli;
            com.bytedance.sdk.openadsdk.core.aGH.eli(evVar2, dZ.eli(evVar2), -5, jSONObject2);
            if (pu != null && eli2.contains("play.google.com/store") && !eli2.contains(Constants.REFERRER)) {
                evVar.pu().eli(pu.eli());
            }
        }
        return evVar;
    }

    @Override // com.bytedance.sdk.openadsdk.aAs.Os
    public void eli(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject optJSONObject;
        if (context == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        eli(context, eli(optJSONObject, str), optJSONObject, i, z);
    }

    private void eli(Context context, ev evVar, JSONObject jSONObject, int i, boolean z) {
        if (context == null || evVar == null || evVar.pu() == null || jSONObject == null || this.DbA == null || this.Os.get(evVar.pu().eli()) != null) {
            return;
        }
        String DbA = dZ.DbA(i);
        if (TextUtils.isEmpty(DbA)) {
            return;
        }
        this.Os.put(evVar.pu().eli(), eli(context, DbA));
    }

    @Override // com.bytedance.sdk.openadsdk.aAs.Os
    public void eli(Context context, JSONObject jSONObject, String str) {
        if (context == null || this.eli == null) {
            return;
        }
        kb.eli(context, str).Os(this.eli);
    }

    @Override // com.bytedance.sdk.openadsdk.aAs.Os
    public void eli(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        eli(eli(optJSONObject, (String) null), optJSONObject);
    }

    private void eli(ev evVar, JSONObject jSONObject) {
        if (this.DbA == null || evVar == null || evVar.pu() == null) {
            return;
        }
        String eli = evVar.pu().eli();
        if (this.Os.containsKey(eli)) {
            this.Os.remove(eli);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "success");
                jSONObject2.put("status", "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.DbA.eli("app_ad_event", jSONObject2);
            } catch (JSONException e) {
                Xb.Os("JsAppAdDownloadManager", e.getMessage());
            }
        }
    }

    private MGA eli(Context context, String str) {
        MGA eli = kb.eli(context, str);
        eli.eli(true);
        return eli;
    }
}
