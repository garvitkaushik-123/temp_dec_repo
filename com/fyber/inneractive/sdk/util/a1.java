package com.fyber.inneractive.sdk.util;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class a1 {
    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof z0) {
                    jSONObject.putOpt(str, ((z0) obj).a());
                } else {
                    jSONObject.putOpt(str, obj);
                }
            } catch (JSONException unused) {
            }
        }
    }
}
