package com.ironsource;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class K6 {
    public static final String b = "userId";
    public static final String c = "appKey";
    private static K6 d;

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f2925a = new JSONObject();

    private K6() {
    }

    public static synchronized K6 a() {
        K6 k6;
        synchronized (K6.class) {
            if (d == null) {
                d = new K6();
            }
            k6 = d;
        }
        return k6;
    }

    public synchronized JSONObject b() throws JSONException {
        if (C3334ub.U().g().f()) {
            return new JSONObject(this.f2925a.toString());
        }
        return this.f2925a;
    }

    public synchronized void a(Map<String, Object> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                a(str, map.get(str));
            }
        }
    }

    public synchronized void a(String str, Object obj) {
        try {
            this.f2925a.put(str, obj);
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
    }

    public synchronized String a(String str) {
        return this.f2925a.optString(str);
    }
}
