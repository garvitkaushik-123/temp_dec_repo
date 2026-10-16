package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Kc {

    /* renamed from: a, reason: collision with root package name */
    private final Boolean f2928a;
    private final Integer b;
    private final O3 c;

    public Kc(JSONObject features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.f2928a = features.has("enabled") ? Boolean.valueOf(features.getBoolean("enabled")) : null;
        this.b = features.has("numOfSeconds") ? Integer.valueOf(features.getInt("numOfSeconds")) : null;
        this.c = O3.Second;
    }

    public final Boolean a() {
        return this.f2928a;
    }

    public final Integer b() {
        return this.b;
    }

    public final O3 c() {
        return this.c;
    }
}
