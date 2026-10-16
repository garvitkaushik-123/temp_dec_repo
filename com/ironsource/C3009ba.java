package com.ironsource;

import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.ba, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3009ba {

    /* renamed from: a, reason: collision with root package name */
    private String f3202a;
    private JSONObject b;
    private String c;
    private String d;

    public C3009ba(JSONObject jSONObject) {
        this.f3202a = jSONObject.optString(C3040d4.f.b);
        this.b = jSONObject.optJSONObject(C3040d4.f.c);
        this.c = jSONObject.optString("success");
        this.d = jSONObject.optString(C3040d4.f.e);
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.f3202a;
    }

    public JSONObject c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C3040d4.f.b, this.f3202a);
            jSONObject.put(C3040d4.f.c, this.b);
            jSONObject.put("success", this.c);
            jSONObject.put(C3040d4.f.e, this.d);
            return jSONObject;
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }
}
