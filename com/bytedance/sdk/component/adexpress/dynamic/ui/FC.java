package com.bytedance.sdk.component.adexpress.dynamic.ui;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FC {
    public static void eli(String str, JSONObject jSONObject) {
        JSONObject eEH = com.bytedance.sdk.component.adexpress.DbA.eEH(str);
        if (eEH == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = eEH.optJSONObject("values");
        if (optJSONObject == null) {
            return;
        }
        eli(optJSONObject, jSONObject);
    }

    public static JSONObject eli(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject eEH = com.bytedance.sdk.component.adexpress.DbA.eEH(str);
        if (eEH == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return eli(jSONObject2, eEH.optJSONObject("themeValues"), jSONObject);
    }

    private static void eli(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static JSONObject eli(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String eli(String str) {
        JSONObject optJSONObject;
        JSONObject eEH = com.bytedance.sdk.component.adexpress.DbA.eEH(str);
        if (eEH == null || (optJSONObject = eEH.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString("data");
    }

    public static String eli(String str, String str2) {
        JSONObject optJSONObject;
        JSONObject eEH = com.bytedance.sdk.component.adexpress.DbA.eEH(str);
        if (eEH == null || (optJSONObject = eEH.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString(str2);
    }

    public static JSONObject eli(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (optJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return optJSONObject.optJSONObject("values");
    }

    public static String DbA(String str, String str2) {
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            if (str.indexOf(46) < 0) {
                str = str + ".png";
            }
            return str2 + "static/images/" + str;
        }
        return eli.eli(str);
    }
}
