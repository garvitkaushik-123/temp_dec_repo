package com.ironsource;

import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class D1 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2823a;
    private final HashSet<String> b;
    private final String c;
    private final String d;
    private final boolean e;
    private final int f;
    private final boolean g;

    public D1(JSONObject applicationCrashReporterSettings) {
        Intrinsics.checkNotNullParameter(applicationCrashReporterSettings, "applicationCrashReporterSettings");
        this.f2823a = applicationCrashReporterSettings.optBoolean("enabled", false);
        List<String> b = V9.b(applicationCrashReporterSettings.optJSONArray(F1.b));
        this.b = b != null ? CollectionsKt.toHashSet(b) : null;
        String optString = applicationCrashReporterSettings.optString(F1.c);
        Intrinsics.checkNotNullExpressionValue(optString, "applicationCrashReporter…(CRASHREPORTER_URL_FIELD)");
        this.c = optString;
        String optString2 = applicationCrashReporterSettings.optString(F1.d);
        Intrinsics.checkNotNullExpressionValue(optString2, "applicationCrashReporter…SHREPORTER_KEYWORD_FIELD)");
        this.d = optString2;
        this.e = applicationCrashReporterSettings.optBoolean(F1.e, false);
        this.f = applicationCrashReporterSettings.optInt("timeout", 5000);
        this.g = applicationCrashReporterSettings.optBoolean(F1.g, false);
    }

    public final int a() {
        return this.f;
    }

    public final HashSet<String> b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.c;
    }

    public final boolean e() {
        return this.e;
    }

    public final boolean f() {
        return this.f2823a;
    }

    public final boolean g() {
        return this.g;
    }
}
