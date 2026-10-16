package com.bytedance.sdk.component.adexpress.dynamic.aGH;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    public String DbA;
    public String Os;
    public String aGH;
    public List<eli> eli;

    public static class eli {
        public JSONObject DbA;
        public int eli;
    }

    public static aGH eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        aGH agh = new aGH();
        String optString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    eli eliVar = new eli();
                    eliVar.eli = optJSONObject.optInt("id");
                    eliVar.DbA = new JSONObject(optJSONObject.optString("componentLayout"));
                    arrayList.add(eliVar);
                }
            }
        } catch (JSONException unused) {
        }
        agh.eli = arrayList;
        agh.DbA = jSONObject.optString("diff_data");
        agh.Os = jSONObject.optString("style_diff");
        agh.aGH = jSONObject.optString("tag_diff");
        return agh;
    }
}
