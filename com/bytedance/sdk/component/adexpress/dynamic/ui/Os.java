package com.bytedance.sdk.component.adexpress.dynamic.ui;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.aGH.aGH;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    public JSONObject eli(List<aGH.eli> list, int i, JSONObject jSONObject) {
        aGH.eli eliVar;
        JSONObject jSONObject2;
        if (list == null || list.size() <= 0) {
            return null;
        }
        Iterator<aGH.eli> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                eliVar = null;
                break;
            }
            eliVar = it.next();
            if (eliVar != null && eliVar.eli == i) {
                break;
            }
        }
        if (eliVar == null || (jSONObject2 = eliVar.DbA) == null) {
            return null;
        }
        return eli(jSONObject2, jSONObject);
    }

    private static JSONObject eli(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("customComponentDefaultValues");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("values");
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                optJSONObject.put(next, optJSONObject2.opt(next));
            }
            Iterator<String> keys2 = jSONObject.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (!TextUtils.equals(next2, "customComponentDefaultValues")) {
                    if (TextUtils.equals(next2, "values")) {
                        jSONObject3.put(next2, optJSONObject);
                    } else {
                        jSONObject3.put(next2, jSONObject.opt(next2));
                    }
                }
            }
            jSONObject3.put("type", "vessel");
            JSONObject optJSONObject3 = jSONObject2.optJSONObject("values");
            JSONObject optJSONObject4 = jSONObject3.optJSONObject("values");
            if (optJSONObject3 != null && optJSONObject4 != null) {
                Iterator<String> keys3 = optJSONObject3.keys();
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    if (!"clickArea".equals(next3)) {
                        optJSONObject4.put(next3, optJSONObject3.opt(next3));
                    }
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject3;
    }
}
