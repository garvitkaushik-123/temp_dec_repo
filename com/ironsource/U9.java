package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class U9 extends AbstractC3052e {
    private final String i = "https://o-sdk.mediation.unity3d.com/mediation?adUnit=2";
    private final String j = "super.dwh.mediation_events";
    private final String k = D5.Q;
    private final String l = "data";

    U9(int i) {
        this.g = i;
    }

    @Override // com.ironsource.AbstractC3052e
    public String a() {
        return "https://o-sdk.mediation.unity3d.com/mediation?adUnit=2";
    }

    @Override // com.ironsource.AbstractC3052e
    public String c() {
        return "ironbeast";
    }

    @Override // com.ironsource.AbstractC3052e
    public String a(ArrayList<C3413z5> arrayList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            this.f = new JSONObject();
        } else {
            this.f = jSONObject;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<C3413z5> it = arrayList.iterator();
                while (it.hasNext()) {
                    JSONObject a2 = a(it.next());
                    if (a2 != null) {
                        jSONArray.put(a2);
                    }
                }
            }
            jSONObject2.put(D5.Q, "super.dwh.mediation_events");
            jSONObject2.put("data", a(jSONArray));
            return jSONObject2.toString();
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }
}
