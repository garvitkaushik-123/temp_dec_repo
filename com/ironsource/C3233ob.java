package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.ob, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3233ob {

    /* renamed from: a, reason: collision with root package name */
    private final int f3620a;
    private final int b;
    private final int c;
    private final boolean d;

    public C3233ob(JSONObject applicationLogger) {
        Intrinsics.checkNotNullParameter(applicationLogger, "applicationLogger");
        this.f3620a = applicationLogger.optInt(C3250pb.f3639a, 3);
        this.b = applicationLogger.optInt(C3250pb.b, 3);
        this.c = applicationLogger.optInt("console", 3);
        this.d = applicationLogger.optBoolean(C3250pb.d, false);
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.f3620a;
    }

    public final boolean d() {
        return this.d;
    }
}
