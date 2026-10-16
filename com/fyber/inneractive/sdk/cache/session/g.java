package com.fyber.inneractive.sdk.cache.session;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public int f1053a;
    public int b;
    public int c;
    public final long d;

    public g(int i, int i2, int i3, long j) {
        this.d = j;
        this.f1053a = i;
        this.b = i2;
        this.c = i3;
    }

    public final JSONObject a(boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                jSONObject.put("time", this.d);
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("imp", this.f1053a);
        if (z2) {
            jSONObject.put("com", this.c);
        }
        jSONObject.put("cli", this.b);
        return jSONObject;
    }

    public static g a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        long optLong = jSONObject.optLong("time");
        int optInt = jSONObject.optInt("cli", -1);
        int optInt2 = jSONObject.optInt("imp", -1);
        int optInt3 = jSONObject.optInt("com", -1);
        if (optLong == 0 || optInt < 0 || optInt2 < 0 || optInt3 < 0) {
            return null;
        }
        return new g(optInt2, optInt, optInt3, optLong);
    }
}
