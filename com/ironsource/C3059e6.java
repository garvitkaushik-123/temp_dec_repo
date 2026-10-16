package com.ironsource;

import android.app.Activity;
import com.ironsource.InterfaceC3346v6;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.e6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3059e6 extends AbstractC3187m implements InterfaceC3312t6, InterfaceC3329u6 {
    private final InterfaceC3093g6 b;
    private final C3070f0 c;
    private final InterfaceC3346v6 d;

    public /* synthetic */ C3059e6(InterfaceC3093g6 interfaceC3093g6, C3205n0 c3205n0, C3070f0 c3070f0, InterfaceC3346v6.b bVar, InterfaceC3278r6 interfaceC3278r6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC3093g6, c3205n0, c3070f0, (i & 8) != 0 ? new InterfaceC3346v6.b() : bVar, interfaceC3278r6);
    }

    public final void a(Activity activity, Placement placement) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.c.a(placement);
        this.d.a(activity);
    }

    @Override // com.ironsource.InterfaceC3329u6
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.b.onAdLoaded(adInfo);
    }

    @Override // com.ironsource.J0
    public void g() {
        this.b.onAdClicked();
    }

    @Override // com.ironsource.InterfaceC3329u6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.b.onAdInfoChanged(adInfo);
    }

    @Override // com.ironsource.InterfaceC3312t6
    public void onClosed() {
        this.b.onAdClosed();
    }

    public final void p() {
        this.d.loadAd();
    }

    @Override // com.ironsource.InterfaceC3329u6
    public void b(IronSourceError ironSourceError) {
        InterfaceC3093g6 interfaceC3093g6 = this.b;
        String uuid = this.c.b().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adProperties.adId.toString()");
        interfaceC3093g6.a(new LevelPlayAdError(ironSourceError, uuid, this.c.c()));
    }

    public C3059e6(InterfaceC3093g6 listener, C3205n0 adTools, C3070f0 adProperties, InterfaceC3346v6.b adUnitStrategyFactory, InterfaceC3278r6 fullscreenAdUnitFactory) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adProperties, "adProperties");
        Intrinsics.checkNotNullParameter(adUnitStrategyFactory, "adUnitStrategyFactory");
        Intrinsics.checkNotNullParameter(fullscreenAdUnitFactory, "fullscreenAdUnitFactory");
        this.b = listener;
        this.c = adProperties;
        this.d = adUnitStrategyFactory.a(adTools, adTools.b(adProperties.e(), adProperties.c()), fullscreenAdUnitFactory, this, this);
    }

    @Override // com.ironsource.InterfaceC3329u6
    public void a(IronSourceError ironSourceError) {
        InterfaceC3093g6 interfaceC3093g6 = this.b;
        String uuid = this.c.b().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adProperties.adId.toString()");
        interfaceC3093g6.onAdLoadFailed(new LevelPlayAdError(ironSourceError, uuid, this.c.c()));
    }

    @Override // com.ironsource.InterfaceC3329u6
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.b.onAdDisplayed(adInfo);
    }

    @Override // com.ironsource.InterfaceC3312t6
    public void a(LevelPlayReward reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        this.b.a(reward);
    }

    @Override // com.ironsource.InterfaceC3329u6
    public void a() {
        this.b.a();
    }
}
