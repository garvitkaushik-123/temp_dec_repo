package com.ironsource;

import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Q3 implements U5 {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f3006a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3007a = new a();
        public static final boolean b = false;
        public static final String c = "curlError";

        private a() {
        }
    }

    public Q3(JSONObject jSONObject) {
        this.f3006a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.ironsource.U5
    public boolean b() {
        return this.f3006a.optBoolean("enabled", false);
    }

    public final boolean d() {
        return this.f3006a.optBoolean("closeActivity", true);
    }

    public final boolean e() {
        return this.f3006a.optBoolean("reportController", true);
    }
}
