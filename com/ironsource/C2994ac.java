package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ac, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C2994ac {

    /* renamed from: a, reason: collision with root package name */
    private final Le f3182a;
    private final String b;
    private final S7 c;
    private final String d;

    public C2994ac(Le recordType, String advertiserBundleId, S7 adProvider, String adInstanceId) {
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        Intrinsics.checkNotNullParameter(advertiserBundleId, "advertiserBundleId");
        Intrinsics.checkNotNullParameter(adProvider, "adProvider");
        Intrinsics.checkNotNullParameter(adInstanceId, "adInstanceId");
        this.f3182a = recordType;
        this.b = advertiserBundleId;
        this.c = adProvider;
        this.d = adInstanceId;
    }

    public final String a() {
        return this.d;
    }

    public final S7 b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public final Le d() {
        return this.f3182a;
    }

    public final C3071f1 a(InterfaceC3317tb<C2994ac, C3071f1> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return mapper.a(this);
    }
}
