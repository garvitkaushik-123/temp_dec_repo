package com.apm.insight.runtime;

import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ApmConfig.java */
/* loaded from: classes2.dex */
public final class a {
    private static JSONObject i() {
        return d.b(com.apm.insight.e.a().e());
    }

    public static boolean a(Object obj) {
        String b = com.apm.insight.entity.b.b(obj);
        if (b != null) {
            return d.a(b);
        }
        return false;
    }

    public static boolean b(Object obj) {
        d c;
        String b = com.apm.insight.entity.b.b(obj);
        if (b == null || (c = d.c(b)) == null) {
            return false;
        }
        return c.a();
    }

    public static void a(JSONArray jSONArray, boolean z) {
        if (jSONArray == null) {
            return;
        }
        com.apm.insight.a.a("apmconfig", "fromnet " + z + " : " + jSONArray);
        if (z) {
            com.apm.insight.k.j.f();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String next = optJSONObject.keys().next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                com.apm.insight.a.a((Object) ("update config " + next + " : " + optJSONObject2));
                d.a(next, optJSONObject2);
                if (z) {
                    com.apm.insight.k.j.a(next);
                }
            } catch (Throwable unused) {
            }
        }
        k.a(a(jSONArray, String.valueOf(com.apm.insight.e.a().e())));
        if (z) {
            com.apm.insight.k.j.a(jSONArray);
        }
    }

    private static JSONObject a(JSONArray jSONArray, String str) {
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i).optJSONObject(str);
                if (optJSONObject != null) {
                    return optJSONObject;
                }
            }
        }
        return null;
    }

    public static boolean a() {
        return l.e();
    }

    public static String a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("exception_modules")) == null) {
            return null;
        }
        return optJSONObject.optString("npth");
    }

    static {
        new ConcurrentLinkedQueue();
    }

    public static int a(String... strArr) {
        return com.apm.insight.a.a(i(), -1, strArr);
    }

    public static int a(int i, String... strArr) {
        return com.apm.insight.a.a(i(), i, strArr);
    }

    public static JSONArray b() {
        String[] strArr = {"custom_event_settings", "npth_simple_setting", "max_utm_thread_ignore"};
        JSONObject b = com.apm.insight.a.b(i(), strArr);
        if (b == null) {
            return null;
        }
        JSONArray optJSONArray = b.optJSONArray(strArr[2]);
        com.apm.insight.a.a("ApmConfig", "normal get configArray: " + strArr[2] + " : " + optJSONArray);
        return optJSONArray;
    }

    public static boolean c() {
        return a("custom_event_settings", "npth_simple_setting", "disable_looper_monitor") == 1;
    }

    public static boolean d() {
        return a("custom_event_settings", "npth_simple_setting", "enable_all_thread_stack_native") == 1;
    }

    public static boolean e() {
        return a("custom_event_settings", "npth_simple_setting", "anr_with_traces_txt") == 1;
    }

    public static boolean f() {
        return a("custom_event_settings", "npth_simple_setting", "upload_crash_crash") == 1;
    }

    public static boolean g() {
        return a("custom_event_settings", "npth_simple_setting", "force_apm_crash") == 1;
    }

    public static boolean h() {
        return a("custom_event_settings", "npth_simple_setting", "enable_anr_all_process_trace") == 1;
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            com.apm.insight.k.a.b();
        }
        return d.e(str);
    }

    public static boolean b(String str) {
        if (!d.a(str)) {
            com.apm.insight.k.a.b();
        }
        return d.g(str);
    }

    public static boolean c(String str) {
        if (!d.a(str)) {
            com.apm.insight.k.a.b();
        }
        return d.f(str);
    }
}
