package com.ironsource;

import com.ironsource.C3172l1;
import com.ironsource.InterfaceC3122i1;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.t5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3311t5 {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3240p1 f3844a;

    public C3311t5(InterfaceC3240p1 analytics, String adRequestAdId, InterfaceC3100gd adRequestProviderName) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(adRequestAdId, "adRequestAdId");
        Intrinsics.checkNotNullParameter(adRequestProviderName, "adRequestProviderName");
        this.f3844a = analytics;
        analytics.a(new C3172l1.s(adRequestProviderName.value()), new C3172l1.b(adRequestAdId));
    }

    public final void a() {
        InterfaceC3122i1.c.f3351a.a().a(this.f3844a);
    }

    public final void a(IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        InterfaceC3122i1.c.f3351a.a(new C3172l1.j(error.getErrorCode()), new C3172l1.k(error.getErrorMessage()), new C3172l1.f(0L)).a(this.f3844a);
    }
}
