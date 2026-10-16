package com.ironsource;

import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.j9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3146j9 implements InterfaceC3016c0<InterstitialAd> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3240p1 f3376a;
    private final Executor b;

    public C3146j9(InterfaceC3240p1 analytics, Executor callbackExecutor) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(callbackExecutor, "callbackExecutor");
        this.f3376a = analytics;
        this.b = callbackExecutor;
    }

    @Override // com.ironsource.InterfaceC3016c0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterstitialAd a(B9 adInstance, W1 auctionDataReporter) {
        ConcurrentHashMap concurrentHashMap;
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        Intrinsics.checkNotNullParameter(auctionDataReporter, "auctionDataReporter");
        C2999b0 c2999b0 = new C2999b0(new C3166kc());
        InterfaceC3240p1 interfaceC3240p1 = this.f3376a;
        concurrentHashMap = C3163k9.f3406a;
        return new InterstitialAd(new C3180l9(adInstance, c2999b0, auctionDataReporter, interfaceC3240p1, null, null, null, null, concurrentHashMap, 240, null));
    }
}
