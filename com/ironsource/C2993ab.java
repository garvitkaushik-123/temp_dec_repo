package com.ironsource;

import android.app.Activity;
import com.ironsource.Na;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ab, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C2993ab {

    /* renamed from: a, reason: collision with root package name */
    private final Na f3180a;

    /* renamed from: com.ironsource.ab$a */
    public static final class a implements InterfaceC3357w0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ H7 f3181a;

        a(H7 h7) {
            this.f3181a = h7;
        }

        @Override // com.ironsource.InterfaceC3357w0
        public AbstractC3340v0 a(boolean z, C3070f0 adProperties) {
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            return Ad.z.a(adProperties, this.f3181a.e().a(), z);
        }
    }

    public C2993ab(String adUnitId, Na.b config, C3205n0 adTools, C3076f6 adControllerFactory, H7 provider, InterfaceC3293s4 currentTimeProvider, C3347v7 idFactory) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(idFactory, "idFactory");
        this.f3180a = new Na(LevelPlay.AdFormat.REWARDED, adUnitId, config, adTools, adControllerFactory, a(provider), provider, currentTimeProvider, idFactory);
    }

    public final String a() {
        String uuid = this.f3180a.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "fullScreenAdInternal.adId.toString()");
        return uuid;
    }

    public final boolean b() {
        IronLog.API.info("LevelPlayRewardedAd.isAdReady()");
        return this.f3180a.m();
    }

    public final void c() {
        IronLog.API.info("LevelPlayRewardedAd.loadAd()");
        this.f3180a.n();
    }

    public final void a(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IronLog.API.info("LevelPlayRewardedAd.showAd() placementName: " + str);
        this.f3180a.a(activity, str);
    }

    public final void a(LevelPlayRewardedAdListener levelPlayRewardedAdListener) {
        IronLog.API.info("LevelPlayRewardedAd.setListener()");
        this.f3180a.a(levelPlayRewardedAdListener != null ? C3010bb.b(levelPlayRewardedAdListener) : null);
    }

    private final a a(H7 h7) {
        return new a(h7);
    }
}
