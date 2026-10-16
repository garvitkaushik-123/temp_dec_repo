package com.apm.insight.d;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.b.h;
import com.apm.insight.e;
import com.apm.insight.k.d;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.m;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DartCrash.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f233a;
    public long b;

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, h.a aVar) {
        a(str, map, map2, null, aVar);
    }

    public static void a(final String str, final Map<? extends String, ? extends String> map, final Map<String, String> map2, final Map<String, String> map3, final h.a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            m.a().a(new Runnable() { // from class: com.apm.insight.d.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Context g = e.g();
                        long j = currentTimeMillis;
                        String str2 = str;
                        com.apm.insight.entity.a aVar2 = new com.apm.insight.entity.a();
                        aVar2.a("is_dart", (Object) 1);
                        aVar2.a("crash_time", Long.valueOf(j));
                        aVar2.a("process_name", (Object) com.apm.insight.l.a.b());
                        aVar2.a("data", (Object) str2);
                        com.apm.insight.l.a.a(g, aVar2.c());
                        com.apm.insight.entity.a a2 = f.a().a(CrashType.DART, aVar2);
                        if (map != null) {
                            JSONObject optJSONObject = a2.c().optJSONObject("custom");
                            if (optJSONObject == null) {
                                optJSONObject = new JSONObject();
                            }
                            com.apm.insight.entity.a.a(optJSONObject, (Map<? extends String, ? extends String>) map);
                            a2.a("custom", optJSONObject);
                        }
                        if (map2 != null) {
                            JSONObject optJSONObject2 = a2.c().optJSONObject("custom_long");
                            if (optJSONObject2 == null) {
                                optJSONObject2 = new JSONObject();
                            }
                            com.apm.insight.entity.a.a(optJSONObject2, (Map<? extends String, ? extends String>) map2);
                            a2.a("custom_long", optJSONObject2);
                        }
                        if (map3 != null) {
                            JSONObject optJSONObject3 = a2.c().optJSONObject("filters");
                            if (optJSONObject3 == null) {
                                optJSONObject3 = new JSONObject();
                                a2.a("filters", optJSONObject3);
                            }
                            com.apm.insight.entity.a.a(optJSONObject3, (Map<? extends String, ? extends String>) map3);
                        }
                        d.a().a(a2.c());
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void a(String str) {
        a(str, null, null, null);
    }

    public static a b(String str) {
        a aVar = new a();
        aVar.f233a = str;
        aVar.b = System.currentTimeMillis();
        return aVar;
    }
}
