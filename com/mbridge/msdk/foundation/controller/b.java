package com.mbridge.msdk.foundation.controller;

import android.util.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CandidateController.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, com.mbridge.msdk.foundation.cache.d> f4206a;

    /* compiled from: CandidateController.java */
    /* renamed from: com.mbridge.msdk.foundation.controller.b$b, reason: collision with other inner class name */
    static class C0330b {

        /* renamed from: a, reason: collision with root package name */
        static b f4207a = new b();
    }

    public static b a() {
        return C0330b.f4207a;
    }

    public com.mbridge.msdk.foundation.cache.d b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        Exception e;
        if (this.f4206a == null) {
            this.f4206a = new HashMap<>();
        }
        if (this.f4206a.containsKey(str)) {
            return this.f4206a.get(str);
        }
        if (jSONArray == null) {
            try {
                jSONArray2 = new JSONArray();
            } catch (Exception e2) {
                jSONArray2 = jSONArray;
                e = e2;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("c_cb", 0);
                jSONObject.put("t_disc", 0.95d);
                jSONObject.put("u_disc", 0.95d);
                jSONObject.put("max_ecppv_diff", 0);
                jSONObject.put("max_cache_num", 20);
                jSONObject.put("max_usage_limit", 10);
                jSONObject.put("time_interval", 7200);
                jSONArray2.put(jSONObject);
            } catch (Exception e3) {
                e = e3;
                Log.e("CandidateController", e.getMessage());
                jSONArray = jSONArray2;
                return a(str, jSONArray);
            }
            jSONArray = jSONArray2;
        }
        return a(str, jSONArray);
    }

    private b() {
        this.f4206a = new HashMap<>();
    }

    public com.mbridge.msdk.foundation.cache.d a(String str, JSONArray jSONArray) {
        if (this.f4206a == null) {
            this.f4206a = new HashMap<>();
        }
        if (this.f4206a.containsKey(str)) {
            return this.f4206a.get(str);
        }
        com.mbridge.msdk.foundation.cache.d dVar = new com.mbridge.msdk.foundation.cache.d(str, jSONArray);
        this.f4206a.put(str, dVar);
        return dVar;
    }
}
