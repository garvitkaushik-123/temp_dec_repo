package com.apm.insight.runtime;

import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: ConfigAid.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, d> f325a = new HashMap<>();
    private JSONObject b = null;
    private JSONObject c = null;
    private boolean d = false;
    private String e;

    private d(JSONObject jSONObject, String str) {
        this.e = str;
        a(jSONObject);
        f325a.put(this.e, this);
        com.apm.insight.a.a((Object) "after update aid ".concat(String.valueOf(str)));
    }

    private void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.b = jSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("error_module")) == null) {
            return;
        }
        this.d = optJSONObject.optInt("switcher") == 1 && optJSONObject.optInt("err_sampling_rate") == 1;
    }

    public final boolean a() {
        if (this.b == null) {
            return false;
        }
        return this.d;
    }

    public static boolean a(String str) {
        return f325a.get(str) != null;
    }

    public static void a(String str, JSONObject jSONObject) {
        d dVar = f325a.get(str);
        if (dVar != null) {
            dVar.a(jSONObject);
        } else {
            new d(jSONObject, str);
        }
    }

    public static JSONObject b(String str) {
        d dVar = f325a.get(str);
        if (dVar != null) {
            return dVar.b;
        }
        return null;
    }

    public static d c(String str) {
        return f325a.get(str);
    }

    public static long d(String str) {
        d dVar = f325a.get(str);
        if (dVar == null) {
            return 3600000L;
        }
        try {
            return Long.decode(com.apm.insight.a.a(dVar.b, "over_all", "get_settings_interval")).longValue() * 1000;
        } catch (Throwable unused) {
            return 3600000L;
        }
    }

    public static boolean e(String str) {
        JSONObject jSONObject;
        d dVar = f325a.get(str);
        return (dVar == null || (jSONObject = dVar.b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public static boolean f(String str) {
        JSONObject jSONObject;
        d dVar = f325a.get(str);
        return (dVar == null || (jSONObject = dVar.b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public static boolean g(String str) {
        JSONObject jSONObject;
        d dVar = f325a.get(str);
        return (dVar == null || (jSONObject = dVar.b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }
}
