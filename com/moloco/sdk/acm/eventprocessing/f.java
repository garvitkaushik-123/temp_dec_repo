package com.moloco.sdk.acm.eventprocessing;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.services.g f5332a;
    public final long b;

    public f(com.moloco.sdk.acm.services.g timeProviderService, long j) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.f5332a = timeProviderService;
        this.b = j;
    }

    public final boolean a(com.moloco.sdk.acm.db.b eventEntity) {
        Intrinsics.checkNotNullParameter(eventEntity, "eventEntity");
        return this.f5332a.invoke() - eventEntity.l() >= this.b * ((long) 1000);
    }
}
