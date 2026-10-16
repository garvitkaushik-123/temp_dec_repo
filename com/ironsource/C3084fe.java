package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.fe, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3084fe {

    /* renamed from: a, reason: collision with root package name */
    private final Ud f3304a;
    private final C3013be b;

    public C3084fe(Ud error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3304a = error;
        this.b = null;
    }

    public final Ud a() {
        return this.f3304a;
    }

    public final C3013be b() {
        return this.b;
    }

    public final boolean c() {
        C3013be c3013be;
        if (this.f3304a == null && (c3013be = this.b) != null) {
            return c3013be.c().p();
        }
        return false;
    }

    public C3084fe(C3013be sdkInitResponse) {
        Intrinsics.checkNotNullParameter(sdkInitResponse, "sdkInitResponse");
        this.b = sdkInitResponse;
        this.f3304a = null;
    }
}
