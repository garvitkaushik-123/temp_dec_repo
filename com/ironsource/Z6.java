package com.ironsource;

import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Z6 implements V6 {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f3158a;

    public static final class a {
        public static final boolean b = false;
        public static final int d = 24;

        /* renamed from: a, reason: collision with root package name */
        public static final a f3159a = new a();
        private static final int c = EnumC2989a7.SendEvent.b();

        private a() {
        }

        public final int a() {
            return c;
        }
    }

    public Z6(JSONObject jSONObject) {
        this.f3158a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.ironsource.V6
    public long a() {
        return this.f3158a.optInt("timeout", 24) * 1000;
    }

    @Override // com.ironsource.U5
    public boolean b() {
        return this.f3158a.optBoolean(com.ironsource.mediationsdk.metadata.a.j, false);
    }

    @Override // com.ironsource.V6
    public EnumC2989a7 c() {
        return EnumC2989a7.b.a(this.f3158a.optInt("strategy", a.f3159a.a()));
    }
}
