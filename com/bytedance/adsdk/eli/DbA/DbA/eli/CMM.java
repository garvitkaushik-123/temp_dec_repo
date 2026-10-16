package com.bytedance.adsdk.eli.DbA.DbA.eli;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CMM implements com.bytedance.adsdk.eli.DbA.DbA.eli {
    private final String eli;

    public CMM(String str) {
        this.eli = str;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        Object eli;
        if (map == null || map.size() <= 0 || (eli = eli(this.eli, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return eli;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public com.bytedance.adsdk.eli.DbA.aGH.ui eli() {
        return com.bytedance.adsdk.eli.DbA.aGH.MGA.VARIABLE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.eli + C3040d4.i.e;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public String DbA() {
        return this.eli;
    }

    public Object eli(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return eli(str.split("\\."), 0, jSONObject);
    }

    private Object eli(String[] strArr, int i, JSONObject jSONObject) {
        Object opt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int indexOf = str.indexOf(C3040d4.i.d);
            int indexOf2 = str.indexOf(C3040d4.i.e);
            if (indexOf < 0 || indexOf2 < 0 || indexOf > indexOf2) {
                opt = jSONObject.opt(str);
            } else {
                String substring = str.substring(0, indexOf);
                try {
                    int parseInt = Integer.parseInt(str.substring(indexOf + 1, indexOf2));
                    Object opt2 = jSONObject.opt(substring);
                    opt = opt2 instanceof JSONArray ? ((JSONArray) opt2).opt(parseInt) : null;
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            if (i != strArr.length - 1) {
                if (opt instanceof String) {
                    try {
                        return eli(strArr, i + 1, new JSONObject((String) opt));
                    } catch (JSONException unused2) {
                    }
                } else if (opt instanceof JSONObject) {
                    return eli(strArr, i + 1, (JSONObject) opt);
                }
            }
            return opt;
        }
        return null;
    }
}
