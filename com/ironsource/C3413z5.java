package com.ironsource;

import com.ironsource.InterfaceC3293s4;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.z5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3413z5 {
    static final String e = "euid";
    static final String f = "esat";
    static final String g = "esfr";
    static final int h = 1;

    /* renamed from: a, reason: collision with root package name */
    private int f3959a;
    private long b;
    private int c;
    private final JSONObject d;

    public C3413z5(A5 a5, JSONObject jSONObject) {
        this(a5.b(), jSONObject);
    }

    public String a() {
        return this.d.toString();
    }

    public JSONObject b() {
        return this.d;
    }

    public int c() {
        return this.f3959a;
    }

    public long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3413z5 c3413z5 = (C3413z5) obj;
        return this.f3959a == c3413z5.f3959a && this.b == c3413z5.b && this.c == c3413z5.c && C3097ga.a(this.d, c3413z5.d);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f3959a) * 31) + Long.hashCode(this.b)) * 31) + this.d.toString().hashCode()) * 31) + this.c;
    }

    public String toString() {
        return ("{\"eventId\":" + c() + ",\"timestamp\":" + d() + "," + a().substring(1) + "}").replace(",", "\n");
    }

    public C3413z5(int i, JSONObject jSONObject) {
        this(i, new InterfaceC3293s4.a().a(), jSONObject);
    }

    public void a(int i) {
        this.f3959a = i;
    }

    public C3413z5(int i, long j, String str) throws JSONException {
        this(i, j, new JSONObject(str));
    }

    public void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        try {
            this.d.put(str, obj);
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    public C3413z5(A5 a5, long j, JSONObject jSONObject) {
        this(a5.b(), j, jSONObject);
    }

    public C3413z5(int i, long j, JSONObject jSONObject) {
        this.c = 1;
        this.f3959a = i;
        this.b = j;
        jSONObject = jSONObject == null ? new JSONObject() : jSONObject;
        this.d = jSONObject;
        if (!jSONObject.has(e)) {
            a(e, UUID.randomUUID().toString());
        }
        if (!jSONObject.has(f)) {
            a(f, Integer.valueOf(this.c));
        } else {
            this.c = jSONObject.optInt(f, 1);
        }
    }

    public void a(String str) {
        a(g, str);
        int i = this.c + 1;
        this.c = i;
        a(f, Integer.valueOf(i));
    }
}
