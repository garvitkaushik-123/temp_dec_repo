package com.ironsource;

import com.ironsource.C3172l1;
import com.ironsource.InterfaceC3122i1;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.v5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3345v5 implements InterfaceC3148jb {

    /* renamed from: a, reason: collision with root package name */
    private final IronSourceError f3906a;
    private final C3073f3 b;
    private final InterfaceC3240p1 c;

    public C3345v5(IronSourceError error, C3073f3 adLoadTaskListener, InterfaceC3240p1 analytics) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(adLoadTaskListener, "adLoadTaskListener");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f3906a = error;
        this.b = adLoadTaskListener;
        this.c = analytics;
    }

    public final IronSourceError a() {
        return this.f3906a;
    }

    @Override // com.ironsource.InterfaceC3148jb
    public void start() {
        InterfaceC3122i1.c.a aVar = InterfaceC3122i1.c.f3351a;
        aVar.a().a(this.c);
        aVar.a(new C3172l1.j(this.f3906a.getErrorCode()), new C3172l1.k(this.f3906a.getErrorMessage()), new C3172l1.f(0L)).a(this.c);
        this.b.onAdLoadFailed(this.f3906a);
    }
}
