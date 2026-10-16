package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.u, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3322u {

    /* renamed from: a, reason: collision with root package name */
    private final Le f3852a;
    private final String b;
    private final String c;
    private final String d;
    private final S7 e;
    private final String f;

    public C3322u(Le recordType, String advertiserBundleId, String networkInstanceId, String adUnitId, S7 adProvider, String adInstanceId) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(advertiserBundleId, "advertiserBundleId");
        Intrinsics.checkNotNullParameter(networkInstanceId, "networkInstanceId");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adProvider, "adProvider");
        Intrinsics.checkNotNullParameter(adInstanceId, "adInstanceId");
        this.f3852a = recordType;
        this.b = advertiserBundleId;
        this.c = networkInstanceId;
        this.d = adUnitId;
        this.e = adProvider;
        this.f = adInstanceId;
    }

    public final String a() {
        return this.f;
    }

    public final S7 b() {
        return this.e;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.c;
    }

    public final Le f() {
        return this.f3852a;
    }

    public final E0 a(InterfaceC3317tb<C3322u, E0> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return mapper.a(this);
    }
}
