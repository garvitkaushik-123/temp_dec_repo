package com.ironsource;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.rf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3287rf implements LevelPlayInterstitialAdListener {
    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
    public void onAdClicked(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3024c8.a().b(C3406yf.f3954a.a(adInfo));
    }

    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
    public void onAdClosed(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3024c8.a().c(C3406yf.f3954a.a(adInfo));
    }

    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
    public void onAdDisplayFailed(LevelPlayAdError error, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3024c8 a2 = C3024c8.a();
        C3406yf c3406yf = C3406yf.f3954a;
        a2.a(c3406yf.a(error), c3406yf.a(adInfo));
    }

    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3024c8.a().f(C3406yf.f3954a.a(adInfo));
    }

    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
    public void onAdLoadFailed(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        C3024c8.a().a(C3406yf.f3954a.a(error));
    }

    @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3024c8.a().e(C3406yf.f3954a.a(adInfo));
    }
}
