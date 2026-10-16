package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.y5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3396y5 implements InterfaceC3148jb {

    /* renamed from: a, reason: collision with root package name */
    private final RewardedAdRequest f3947a;
    private final C3404yd b;
    private final InterfaceC3240p1 c;
    private final IronSourceError d;

    public C3396y5(RewardedAdRequest adRequest, C3404yd adLoadTaskListener, InterfaceC3240p1 analytics, IronSourceError error) {
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        Intrinsics.checkNotNullParameter(adLoadTaskListener, "adLoadTaskListener");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3947a = adRequest;
        this.b = adLoadTaskListener;
        this.c = analytics;
        this.d = error;
    }

    public final IronSourceError a() {
        return this.d;
    }

    @Override // com.ironsource.InterfaceC3148jb
    public void start() {
        C3311t5 c3311t5 = new C3311t5(this.c, this.f3947a.getAdId$mediationsdk_release(), this.f3947a.getProviderName$mediationsdk_release());
        c3311t5.a();
        c3311t5.a(this.d);
        this.b.onAdLoadFailed(this.d);
    }
}
