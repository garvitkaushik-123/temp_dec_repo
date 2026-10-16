package com.fyber.inneractive.sdk.config;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1108a = new HashMap();
    public final HashMap b = new HashMap();

    public final String a(String str, String str2) {
        return this.f1108a.containsKey(str) ? (String) this.f1108a.get(str) : str2;
    }

    public final int b(String str, int i, int i2) {
        int i3;
        try {
            i3 = Integer.parseInt(a(str, Integer.toString(i)));
        } catch (Throwable unused) {
            i3 = i;
        }
        return (i3 < i2 || i3 > 30) ? i : i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (this.f1108a.equals(oVar.f1108a) && this.b.equals(oVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f1108a.hashCode();
    }

    public static o a(JSONObject jSONObject) {
        o oVar = new o();
        JSONObject optJSONObject = jSONObject.optJSONObject("params");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("overrides");
        JSONArray names = optJSONObject.names();
        for (int i = 0; i < names.length(); i++) {
            String optString = names.optString(i, null);
            String optString2 = optJSONObject.optString(optString, null);
            if (optString != null && optString2 != null) {
                oVar.f1108a.put(optString, optString2);
            }
        }
        if (optJSONObject2 != null) {
            JSONArray names2 = optJSONObject2.names();
            for (int i2 = 0; i2 < names2.length(); i2++) {
                String optString3 = names2.optString(i2, null);
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(optString3);
                if (optString3 != null && optJSONObject3 != null) {
                    oVar.b.put(optString3, new m(optJSONObject3));
                }
            }
        }
        return oVar;
    }

    public final int a(String str, int i, int i2) {
        try {
            i = Integer.parseInt(a(str, Integer.toString(i)));
        } catch (Throwable unused) {
        }
        return Math.max(i, i2);
    }

    public final boolean a(boolean z, String str) {
        try {
            return Boolean.parseBoolean(a(str, Boolean.toString(z)));
        } catch (Throwable unused) {
            return z;
        }
    }

    public final l a(String str) {
        m mVar;
        String str2 = IAConfigManager.O.d;
        if (this.b.containsKey(str2)) {
            mVar = (m) this.b.get(str2);
        } else {
            mVar = new m();
        }
        mVar.getClass();
        return mVar.f1106a.containsKey(str) ? (l) mVar.f1106a.get(str) : new l();
    }
}
