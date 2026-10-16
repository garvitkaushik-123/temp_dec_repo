package com.ironsource;

import org.json.JSONObject;

/* renamed from: com.ironsource.i4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3125i4 {

    /* renamed from: a, reason: collision with root package name */
    private String f3355a;
    private JSONObject b;
    private String c;
    private String d;

    public C3125i4(String str) {
        this.f3355a = str;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.f3355a;
    }

    public JSONObject c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public C3125i4(String str, JSONObject jSONObject) {
        this.f3355a = str;
        this.b = jSONObject;
    }

    public C3125i4(String str, String str2, String str3) {
        this.f3355a = str;
        this.c = str2;
        this.d = str3;
    }

    public C3125i4(String str, JSONObject jSONObject, String str2, String str3) {
        this.f3355a = str;
        this.b = jSONObject;
        this.c = str2;
        this.d = str3;
    }
}
