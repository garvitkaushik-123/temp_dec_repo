package com.ironsource;

import android.app.Activity;
import com.ironsource.Na;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Qa {

    /* renamed from: a, reason: collision with root package name */
    private final H7 f3012a;
    private final Na b;

    public static final class a implements InterfaceC3357w0 {
        a() {
        }

        @Override // com.ironsource.InterfaceC3357w0
        public AbstractC3340v0 a(boolean z, C3070f0 adProperties) {
            Intrinsics.checkNotNullParameter(adProperties, "adProperties");
            return C3332u9.z.a(adProperties, Qa.this.f3012a.e().a(), z);
        }
    }

    public Qa(String adUnitId, Na.b config, C3205n0 adTools, C3076f6 adControllerFactory, H7 provider, InterfaceC3293s4 currentTimeProvider, C3347v7 idFactory) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(idFactory, "idFactory");
        this.f3012a = provider;
        this.b = new Na(LevelPlay.AdFormat.INTERSTITIAL, adUnitId, config, adTools, adControllerFactory, a(), provider, currentTimeProvider, idFactory);
    }

    public final String b() {
        String uuid = this.b.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "fullScreenAdInternal.adId.toString()");
        return uuid;
    }

    public final boolean c() {
        IronLog.API.info("LevelPlayInterstitialAd.isAdReady()");
        return this.b.m();
    }

    public final void d() {
        IronLog.API.info("LevelPlayInterstitialAd.loadAd()");
        this.b.n();
    }

    public final void a(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
        IronLog.API.info("LevelPlayInterstitialAd.setListener()");
        this.b.a(levelPlayInterstitialAdListener != null ? Ra.b(levelPlayInterstitialAdListener) : null);
    }

    public final void a(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IronLog.API.info("LevelPlayInterstitialAd.showAd() placementName: " + str);
        this.b.a(activity, str);
    }

    private final InterfaceC3357w0 a() {
        return new a();
    }
}
