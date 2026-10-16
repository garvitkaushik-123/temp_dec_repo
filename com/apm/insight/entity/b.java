package com.apm.insight.entity;

import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.l.f;
import com.apm.insight.l.m;
import com.ironsource.C3114ha;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CustomBody.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<com.apm.insight.d> f240a = new ConcurrentLinkedQueue<>();

    /* compiled from: CustomBody.java */
    public interface a {
        void a(JSONObject jSONObject);
    }

    static {
        new ConcurrentHashMap();
    }

    public static void a(com.apm.insight.d dVar) {
        f240a.add(dVar);
    }

    public static File a(File file) {
        return new File(file, "all_data.json");
    }

    public static JSONArray a(Throwable th, Thread thread, File file) {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] b = m.b(th);
        Iterator<com.apm.insight.d> it = f240a.iterator();
        while (true) {
            if (!it.hasNext() || (next = it.next()) == null) {
                break;
            }
            if (!com.apm.insight.runtime.a.a(next.b())) {
                com.apm.insight.a.a((Object) ("not enable javaCrash aid: " + next.b()));
            } else {
                JSONArray a2 = next.a(b, th, thread != null ? thread.getName() : null);
                if (!com.apm.insight.a.a(a2)) {
                    jSONArray.put(next.a(CrashType.JAVA, a2));
                }
            }
        }
        if (com.apm.insight.a.a(jSONArray)) {
            return null;
        }
        try {
            f.a(new File(file, "all_data.json"), jSONArray);
        } catch (IOException unused) {
        }
        return jSONArray;
    }

    public static JSONArray a(String str) {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        String[] split = str.split("\n");
        Iterator<com.apm.insight.d> it = f240a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (com.apm.insight.runtime.a.b(next.b())) {
                JSONArray a2 = next.a(split);
                if (!com.apm.insight.a.a(a2)) {
                    jSONArray.put(next.a(CrashType.ANR, a2));
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray a() {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        Iterator<com.apm.insight.d> it = f240a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.c());
        }
        return jSONArray;
    }

    public static JSONArray b() {
        com.apm.insight.d next;
        JSONArray jSONArray = new JSONArray();
        Iterator<com.apm.insight.d> it = f240a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.a((CrashType) null, (JSONArray) null));
        }
        return jSONArray;
    }

    public static int c() {
        return f240a.size();
    }

    public static List<String> d() {
        com.apm.insight.d next;
        ArrayList arrayList = new ArrayList();
        Iterator<com.apm.insight.d> it = f240a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next.b());
        }
        return arrayList;
    }

    public static JSONArray a(Object obj) {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.apm.insight.d> it = f240a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.apm.insight.d next = it.next();
            if (next != null && next.a(obj)) {
                jSONArray.put(next.a(CrashType.JAVA, (JSONArray) null));
                break;
            }
        }
        return jSONArray;
    }

    public static String b(Object obj) {
        Iterator<com.apm.insight.d> it = f240a.iterator();
        while (it.hasNext()) {
            com.apm.insight.d next = it.next();
            if (next != null && next.a(obj)) {
                return next.b();
            }
        }
        return null;
    }

    public static JSONArray a(Object obj, Throwable th, StackTraceElement[] stackTraceElementArr) {
        Iterator<com.apm.insight.d> it = f240a.iterator();
        while (it.hasNext()) {
            com.apm.insight.d next = it.next();
            if (next != null && next.a(obj)) {
                JSONArray a2 = next.a(stackTraceElementArr, th);
                JSONArray jSONArray = new JSONArray();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C3114ha.b, next.b());
                    jSONObject.put("lines", a2);
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
                return jSONArray;
            }
        }
        return null;
    }

    public static JSONArray a(String str, String str2, JSONArray jSONArray) {
        JSONObject optJSONObject;
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("header")) != null && com.apm.insight.runtime.a.c(String.valueOf(optJSONObject.opt(C3114ha.b)))) {
                if (TextUtils.isEmpty(optJSONObject.optString("package"))) {
                    jSONArray2.put(optJSONObject2);
                } else if (a(str, optJSONObject.optJSONArray("so_list"), str2, optJSONObject.optJSONArray("so_list"))) {
                    jSONArray2.put(optJSONObject2);
                }
            }
        }
        return jSONArray2;
    }

    public static boolean a(String str, JSONArray jSONArray, String str2, JSONArray jSONArray2) {
        if (!com.apm.insight.a.a(jSONArray)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (str.contains(jSONArray.optString(i))) {
                    return true;
                }
            }
        }
        if (!com.apm.insight.a.a(jSONArray2)) {
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                String optString = jSONArray2.optString(i2);
                if (optString != null && optString.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(JSONObject jSONObject, JSONArray jSONArray, a aVar) {
        JSONObject optJSONObject;
        com.apm.insight.a.a((Object) "uploadFromFile with allData ".concat(String.valueOf(jSONArray)));
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length() && (optJSONObject = jSONArray.optJSONObject(i)) != null; i++) {
            if (com.apm.insight.a.a(optJSONObject, 0, "header", "single_upload") == 1) {
                JSONObject jSONObject2 = new JSONObject();
                com.apm.insight.entity.a.b(jSONObject2, jSONObject);
                com.apm.insight.entity.a.b(jSONObject2, optJSONObject);
                aVar.a(jSONObject2);
            } else {
                jSONArray2.put(optJSONObject);
            }
        }
        if (jSONArray2.length() == 0) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        com.apm.insight.entity.a.b(jSONObject3, jSONObject);
        try {
            jSONObject3.put("all_data", jSONArray2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aVar.a(jSONObject3);
    }
}
