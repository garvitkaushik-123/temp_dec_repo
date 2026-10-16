package com.ironsource;

import com.ironsource.C3040d4;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class Ze {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f3167a;

    public Ze(JSONObject jSONObject) {
        this.f3167a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public boolean a() {
        return this.f3167a.optBoolean("uxt", false);
    }

    public boolean b() {
        return this.f3167a.optBoolean(C3040d4.a.o, false);
    }

    public boolean c() {
        return this.f3167a.optBoolean(C3040d4.a.p, false);
    }

    public boolean d() {
        return this.f3167a.optBoolean(C3040d4.a.l, false);
    }

    public boolean e() {
        return this.f3167a.optBoolean(C3040d4.a.n, false);
    }
}
