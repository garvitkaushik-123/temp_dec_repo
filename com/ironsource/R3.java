package com.ironsource;

import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class R3 implements U5 {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f3020a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3021a = new a();
        public static final boolean b = false;

        private a() {
        }
    }

    public R3(JSONObject jSONObject) {
        this.f3020a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.ironsource.U5
    public boolean b() {
        return this.f3020a.optBoolean("clickCheck", false);
    }
}
