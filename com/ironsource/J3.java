package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class J3 {

    /* renamed from: a, reason: collision with root package name */
    private final Boolean f2914a;
    private final Integer b;
    private final O3 c;

    public J3(JSONObject features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.f2914a = features.has("enabled") ? Boolean.valueOf(features.getBoolean("enabled")) : null;
        this.b = features.has("maxImpressions") ? Integer.valueOf(features.getInt("maxImpressions")) : null;
        this.c = features.has("unit") ? O3.c.a(features.optString("unit")) : null;
    }

    public final Boolean a() {
        return this.f2914a;
    }

    public final Integer b() {
        return this.b;
    }

    public final O3 c() {
        return this.c;
    }
}
