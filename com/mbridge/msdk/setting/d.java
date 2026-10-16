package com.mbridge.msdk.setting;

import org.json.JSONObject;

/* compiled from: EventLibMonitorSetting.java */
/* loaded from: classes6.dex */
public class d {
    private String f;
    private String g;
    private int h;

    /* renamed from: a, reason: collision with root package name */
    private int f4701a = 1;
    private int b = 1;
    private int c = 0;
    private int d = 30;
    private int e = 0;
    private int i = 0;

    public static d a(String str) {
        Exception e;
        d dVar;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
            dVar = new d();
        } catch (Exception e2) {
            e = e2;
            dVar = null;
        }
        try {
            dVar.b(jSONObject.optString("h_d", com.mbridge.msdk.foundation.same.net.utils.d.h().f));
            dVar.c(jSONObject.optString("t_d", com.mbridge.msdk.foundation.same.net.utils.d.h().k));
            dVar.c(jSONObject.optInt("t_p", com.mbridge.msdk.foundation.same.net.utils.d.h().o));
            dVar.d(jSONObject.optInt("type", 1));
            dVar.b(jSONObject.optInt("d_t", 30));
            dVar.a(jSONObject.optInt("d_a", 0));
            return dVar;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return dVar;
        }
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(int i) {
        this.i = i;
    }

    public void b(String str) {
        this.f = str;
    }

    public void c(int i) {
        this.h = i;
    }

    public int a() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }
}
