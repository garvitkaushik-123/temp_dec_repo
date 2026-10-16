package com.ironsource;

import com.unity3d.ironsourceads.banner.BannerAdView;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class F2 implements E2 {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3240p1 f2857a;
    private final Executor b;

    public F2(InterfaceC3240p1 analytics, Executor callbackExecutor) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(callbackExecutor, "callbackExecutor");
        this.f2857a = analytics;
        this.b = callbackExecutor;
    }

    @Override // com.ironsource.E2
    public BannerAdView a(B9 adInstance, C3078f8 adContainer, W1 auctionDataReporter) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(auctionDataReporter, "auctionDataReporter");
        return new BannerAdView(new Q2(adInstance, adContainer, auctionDataReporter, this.f2857a, null, null, null, null, 240, null));
    }
}
