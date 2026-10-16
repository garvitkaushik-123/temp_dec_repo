package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class fg {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3306a = "errMsg";

    public static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", str);
            jSONObject.put("adViewId", str2);
            return jSONObject;
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }
}
