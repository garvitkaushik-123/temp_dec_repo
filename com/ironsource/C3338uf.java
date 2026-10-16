package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.uf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3338uf {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3186lf f3898a;

    /* renamed from: com.ironsource.uf$a */
    public static final class a implements LevelPlayInterstitialListener {
        a() {
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdClicked(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.f, IronSource.AD_UNIT.INTERSTITIAL, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdClosed(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.g, IronSource.AD_UNIT.INTERSTITIAL, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdLoadFailed(IronSourceError ironSourceError) {
            C3338uf.this.a(C3355vf.b, IronSource.AD_UNIT.INTERSTITIAL, C3406yf.f3954a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdOpened(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.c, IronSource.AD_UNIT.INTERSTITIAL, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdReady(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.f3915a, IronSource.AD_UNIT.INTERSTITIAL, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo) {
            C3338uf.this.a(C3355vf.e, IronSource.AD_UNIT.INTERSTITIAL, C3406yf.f3954a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null, adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener
        public void onAdShowSucceeded(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.d, IronSource.AD_UNIT.INTERSTITIAL, C3406yf.f3954a.a(adInfo));
        }
    }

    /* renamed from: com.ironsource.uf$b */
    public static final class b implements LevelPlayRewardedVideoManualListener, LevelPlayRewardedVideoListener {
        b() {
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener
        public void onAdAvailable(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.h, IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdClicked(Placement placement, AdInfo adInfo) {
            C3338uf.this.a(C3355vf.f, IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(C3321tf.f3849a.a(placement), adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdClosed(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.g, IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener
        public void onAdLoadFailed(IronSourceError ironSourceError) {
            C3338uf.this.a(C3355vf.b, IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdOpened(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.c, IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener
        public void onAdReady(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.f3915a, IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdRewarded(Placement placement, AdInfo adInfo) {
            C3338uf.this.a(C3355vf.i, IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(C3321tf.f3849a.a(placement), adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener
        public void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo) {
            C3338uf.this.a(C3355vf.e, IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null, adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener
        public void onAdUnavailable() {
            C3338uf.this.a(C3355vf.n, IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(new Object[0]));
        }
    }

    /* renamed from: com.ironsource.uf$c */
    public static final class c implements LevelPlayBannerListener {
        c() {
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdClicked(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.f, IronSource.AD_UNIT.BANNER, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdLeftApplication(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.k, IronSource.AD_UNIT.BANNER, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdLoadFailed(IronSourceError ironSourceError) {
            C3338uf.this.a(C3355vf.b, IronSource.AD_UNIT.BANNER, C3406yf.f3954a.a(ironSourceError != null ? ironSourceError.getErrorMessage() : null));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdLoaded(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.j, IronSource.AD_UNIT.BANNER, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdScreenDismissed(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.m, IronSource.AD_UNIT.BANNER, C3406yf.f3954a.a(adInfo));
        }

        @Override // com.ironsource.mediationsdk.sdk.LevelPlayBannerListener
        public void onAdScreenPresented(AdInfo adInfo) {
            C3338uf.this.a(C3355vf.l, IronSource.AD_UNIT.BANNER, C3406yf.f3954a.a(adInfo));
        }
    }

    public C3338uf(InterfaceC3186lf javaScriptEvaluator) {
        Intrinsics.checkNotNullParameter(javaScriptEvaluator, "javaScriptEvaluator");
        this.f3898a = javaScriptEvaluator;
    }

    private final void b() {
        C3321tf c3321tf = C3321tf.f3849a;
        c3321tf.a((LevelPlayInterstitialListener) null);
        c3321tf.a((LevelPlayRewardedVideoBaseListener) null);
        c3321tf.a((LevelPlayBannerListener) null);
    }

    private final void c() {
        C3321tf.f3849a.i();
    }

    public final void d() {
        C3321tf c3321tf = C3321tf.f3849a;
        c3321tf.a(new a());
        c3321tf.a(new b());
        c3321tf.a(new c());
    }

    public final void a() {
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, IronSource.AD_UNIT ad_unit, List<? extends Object> list) {
        this.f3898a.a(str, ad_unit, list);
    }
}
