package com.apm.insight.entity;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.apm.insight.e;
import com.apm.insight.l.m;
import com.ironsource.C3040d4;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashBody.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f239a;
    private Header b;

    public a() {
        JSONObject jSONObject = new JSONObject();
        this.f239a = jSONObject;
        try {
            jSONObject.put("apm_id", "20000001");
        } catch (JSONException unused) {
        }
    }

    public a(JSONObject jSONObject) {
        this.f239a = jSONObject;
    }

    public static a a(long j, Context context, Throwable th) {
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.a("isJava", (Object) 1);
        aVar.a("data", (Object) m.a(th));
        aVar.a("crash_time", Long.valueOf(j));
        aVar.a("process_name", (Object) com.apm.insight.l.a.b());
        if (!com.apm.insight.l.a.b(context)) {
            aVar.a("remote_process", (Object) 1);
        }
        return aVar;
    }

    public final void b() {
        a("has_logcat", String.valueOf(a()));
    }

    public static boolean a(String str) {
        return ((long) com.apm.insight.nativecrash.b.c(str)) > com.apm.insight.nativecrash.a.g();
    }

    public static boolean b(String str) {
        return com.apm.insight.nativecrash.b.a(str) > 960;
    }

    public static boolean c(String str) {
        return com.apm.insight.nativecrash.b.b(str) > 350;
    }

    public final JSONObject c() {
        return this.f239a;
    }

    public final a a(Header header) {
        a("header", header.f());
        this.b = header;
        return this;
    }

    public final a a(JSONObject jSONObject) {
        a("header", jSONObject);
        return this;
    }

    public final Header d() {
        if (this.b == null) {
            Header header = new Header(e.g());
            this.b = header;
            a(header);
        }
        return this.b;
    }

    public static void a(JSONObject jSONObject, Map<? extends String, ? extends String> map) {
        if (map != null) {
            try {
                for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, Throwable th) {
        try {
            if (jSONObject.opt("npth_err_info") == null) {
                jSONObject.put("npth_err_info", m.a(th));
                return;
            }
            for (int i = 0; i < 5; i++) {
                if (jSONObject.opt("npth_err_info" + i) == null) {
                    jSONObject.put("npth_err_info" + i, m.a(th));
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final a a(long j) {
        try {
            a("app_start_time", Long.valueOf(j));
            a("app_start_time_readable", (Object) new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }
    }

    public final a a(com.apm.insight.runtime.a.b bVar) {
        a("activity_trace", bVar.g());
        a("activity_track", bVar.i());
        return this;
    }

    public final a a(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.f239a.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("package_name", str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.f239a.put("plugin_info", jSONArray);
        return this;
    }

    public final a b(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e) {
                    com.apm.insight.a.b((Throwable) e);
                }
            }
            try {
                this.f239a.put("sdk_info", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public final a a(int i, String str) {
        try {
            this.f239a.put("miniapp_id", i);
            this.f239a.put("miniapp_version", str);
            return this;
        } catch (JSONException e) {
            e.printStackTrace();
            return this;
        }
    }

    public final a a(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            a("patch_info", (Object) jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        a("patch_info", (Object) jSONArray);
        return this;
    }

    public final a b(JSONObject jSONObject) {
        a(this.f239a, jSONObject);
        return this;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        String str2;
        try {
            jSONObject.put(C3040d4.a.k, jSONObject2);
        } catch (Throwable unused) {
        }
        long optLong = jSONObject2.optLong("inner_free");
        long optLong2 = jSONObject2.optLong("sdcard_free");
        long optLong3 = jSONObject2.optLong("inner_free_real");
        String str3 = "1M - 64M";
        if (optLong <= 1024) {
            str = "0 - 1K";
        } else if (optLong <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            str = "1K - 64K";
        } else if (optLong <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            str = "64K - 512K";
        } else if (optLong <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            str = "512K - 1M";
        } else {
            str = optLong <= 67108864 ? "1M - 64M" : "64M - ";
        }
        if (optLong3 <= 1024) {
            str2 = "0 - 1K";
        } else if (optLong3 <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            str2 = "1K - 64K";
        } else if (optLong3 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            str2 = "64K - 512K";
        } else if (optLong3 <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            str2 = "512K - 1M";
        } else {
            str2 = optLong3 <= 67108864 ? "1M - 64M" : "64M - ";
        }
        if (optLong2 <= 1024) {
            str3 = "0 - 1K";
        } else if (optLong2 <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            str3 = "1K - 64K";
        } else if (optLong2 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
            str3 = "64K - 512K";
        } else if (optLong2 <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            str3 = "512K - 1M";
        } else if (optLong2 > 67108864) {
            str3 = "64M - ";
        }
        a(jSONObject, "filters", "inner_free", str);
        a(jSONObject, "filters", "inner_free_real", str2);
        a(jSONObject, "filters", "sdcard_free", str3);
    }

    public static void a(JSONObject jSONObject, String str, String str2, String str3) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            try {
                optJSONObject = new JSONObject();
                jSONObject.put(str, optJSONObject);
            } catch (Throwable unused) {
                return;
            }
        }
        optJSONObject.put(str2, str3);
    }

    public final void c(JSONObject jSONObject) {
        b(this.f239a, jSONObject);
    }

    public static void b(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt == null) {
                    jSONObject.put(next, jSONObject2.opt(next));
                } else if (opt instanceof JSONObject) {
                    b(jSONObject.getJSONObject(next), jSONObject2.getJSONObject(next));
                } else if (opt instanceof JSONArray) {
                    JSONArray optJSONArray = jSONObject2.optJSONArray(next);
                    if (optJSONArray != null) {
                        JSONArray jSONArray = (JSONArray) opt;
                        if (jSONArray.length() == 1 && (jSONArray.opt(0) instanceof JSONObject) && (optJSONArray.opt(0) instanceof JSONObject)) {
                            b(jSONArray.getJSONObject(0), optJSONArray.getJSONObject(0));
                        } else {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                jSONArray.put(optJSONArray.get(i));
                            }
                        }
                    }
                } else {
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void a(String str, Object obj) {
        try {
            this.f239a.put(str, obj);
        } catch (Exception e) {
            com.apm.insight.a.b((Throwable) e);
        }
    }

    public final boolean a() {
        Object opt = this.f239a.opt("data");
        return opt instanceof JSONArray ? !com.apm.insight.a.a(((JSONArray) opt).optJSONObject(0), "logcat") : !com.apm.insight.a.a(this.f239a, "logcat");
    }

    private a a(String str, JSONArray jSONArray) {
        JSONObject optJSONObject = this.f239a.optJSONObject("custom_long");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            a("custom_long", optJSONObject);
        }
        try {
            optJSONObject.put(str, jSONArray);
        } catch (JSONException unused) {
        }
        return this;
    }

    public final a c(Map<? extends String, ? extends String> map) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        if (map != null) {
            Object opt = this.f239a.opt("data");
            if (opt instanceof JSONArray) {
                jSONObject = ((JSONArray) opt).optJSONObject(0);
            } else {
                jSONObject = this.f239a;
            }
            if (jSONObject == null) {
                optJSONObject = new JSONObject();
            } else {
                optJSONObject = jSONObject.optJSONObject("filters");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    a("filters", optJSONObject);
                }
            }
            for (Map.Entry<? extends String, ? extends String> entry : map.entrySet()) {
                try {
                    optJSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
            a("filters", optJSONObject);
        }
        return this;
    }

    public final a a(String str, String str2) {
        Object opt = this.f239a.opt("data");
        if (opt instanceof JSONArray) {
            a(((JSONArray) opt).optJSONObject(0), "filters", str, str2);
            return this;
        }
        a(this.f239a, "filters", str, str2);
        return this;
    }

    public final a b(String str, String str2) {
        Object opt = this.f239a.opt("data");
        if (opt instanceof JSONArray) {
            a(((JSONArray) opt).optJSONObject(0), "custom", str, str2);
            return this;
        }
        a(this.f239a, "custom", str, str2);
        return this;
    }
}
