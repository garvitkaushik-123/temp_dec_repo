package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class E0 {

    /* renamed from: a, reason: collision with root package name */
    private final Le f2835a;
    private final String b;
    private final String c;
    private final S7 d;
    private final String e;

    public E0(Le recordType, String advertiserBundleId, String networkInstanceId, S7 adProvider, String adInstanceId) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(advertiserBundleId, "advertiserBundleId");
        Intrinsics.checkNotNullParameter(networkInstanceId, "networkInstanceId");
        Intrinsics.checkNotNullParameter(adProvider, "adProvider");
        Intrinsics.checkNotNullParameter(adInstanceId, "adInstanceId");
        this.f2835a = recordType;
        this.b = advertiserBundleId;
        this.c = networkInstanceId;
        this.d = adProvider;
        this.e = adInstanceId;
    }

    public final String a() {
        return this.e;
    }

    public final S7 b() {
        return this.d;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.c;
    }

    public final Le e() {
        return this.f2835a;
    }

    public final C2994ac a(InterfaceC3317tb<E0, C2994ac> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return mapper.a(this);
    }
}
