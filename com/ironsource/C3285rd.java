package com.ironsource;

import com.unity3d.ironsourceads.rewarded.RewardedAd;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.rd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3285rd implements InterfaceC3016c0<RewardedAd> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3240p1 f3681a;
    private final Executor b;

    public C3285rd(InterfaceC3240p1 analytics, Executor callbackExecutor) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(callbackExecutor, "callbackExecutor");
        this.f3681a = analytics;
        this.b = callbackExecutor;
    }

    @Override // com.ironsource.InterfaceC3016c0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RewardedAd a(B9 adInstance, W1 auctionDataReporter) {
        ConcurrentHashMap concurrentHashMap;
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(auctionDataReporter, "auctionDataReporter");
        C2999b0 c2999b0 = new C2999b0(new C3166kc());
        InterfaceC3240p1 interfaceC3240p1 = this.f3681a;
        concurrentHashMap = C3302sd.f3695a;
        return new RewardedAd(new C3336ud(adInstance, c2999b0, auctionDataReporter, interfaceC3240p1, null, null, null, null, concurrentHashMap, 240, null));
    }
}
