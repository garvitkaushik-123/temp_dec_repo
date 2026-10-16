package com.moloco.sdk.acm.services;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final g f5361a;
    public final AtomicLong b;

    public f(g timeProviderService) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.f5361a = timeProviderService;
        this.b = new AtomicLong(0L);
    }

    public final long a() {
        return this.f5361a.invoke() - this.b.get();
    }

    public final AtomicLong b() {
        return this.b;
    }

    public final void c() {
        this.b.set(this.f5361a.invoke());
    }
}
