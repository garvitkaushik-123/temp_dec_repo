package com.moloco.sdk.internal.services;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.internal.services.j, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3446j {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5714a;
    public final String b;
    public final String c;

    public C3446j(String applicationName, String packageName, String version) {
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(version, "version");
        this.f5714a = applicationName;
        this.b = packageName;
        this.c = version;
    }

    public final String a() {
        return this.f5714a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}
