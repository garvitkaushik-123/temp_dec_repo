package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.z1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3409z1 {

    /* renamed from: a, reason: collision with root package name */
    private final C3233ob f3956a;
    private final boolean b;
    private final D1 c;
    private final K1 d;
    private final C3375x1 e;

    public C3409z1(JSONObject applicationConfigurations) {
        Intrinsics.checkNotNullParameter(applicationConfigurations, "applicationConfigurations");
        JSONObject optJSONObject = applicationConfigurations.optJSONObject(B1.f2797a);
        this.f3956a = new C3233ob(optJSONObject == null ? new JSONObject() : optJSONObject);
        this.b = applicationConfigurations.optBoolean(B1.g, false);
        JSONObject optJSONObject2 = applicationConfigurations.optJSONObject(B1.h);
        this.c = new D1(optJSONObject2 == null ? new JSONObject() : optJSONObject2);
        JSONObject optJSONObject3 = applicationConfigurations.optJSONObject("settings");
        this.d = new K1(optJSONObject3 == null ? new JSONObject() : optJSONObject3);
        JSONObject optJSONObject4 = applicationConfigurations.optJSONObject(B1.f);
        this.e = new C3375x1(optJSONObject4 == null ? new JSONObject() : optJSONObject4);
    }

    public final C3375x1 a() {
        return this.e;
    }

    public final D1 b() {
        return this.c;
    }

    public final K1 c() {
        return this.d;
    }

    public final boolean d() {
        return this.b;
    }

    public final C3233ob e() {
        return this.f3956a;
    }
}
