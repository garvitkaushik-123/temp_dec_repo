package com.ironsource;

import android.webkit.JavascriptInterface;
import com.ironsource.mediationsdk.IronSource;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.kf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3169kf {

    /* renamed from: a, reason: collision with root package name */
    private final C3102gf f3411a;
    private final InterfaceC3186lf b;
    private final Q8 c;

    public C3169kf(C3102gf adsManager, Q8 uiLifeCycleListener, InterfaceC3186lf javaScriptEvaluator) {
        Intrinsics.checkNotNullParameter(adsManager, "adsManager");
        Intrinsics.checkNotNullParameter(uiLifeCycleListener, "uiLifeCycleListener");
        Intrinsics.checkNotNullParameter(javaScriptEvaluator, "javaScriptEvaluator");
        this.f3411a = adsManager;
        this.b = javaScriptEvaluator;
        this.c = uiLifeCycleListener;
    }

    private final void a(String str, IronSource.AD_UNIT ad_unit, List<? extends Object> list) {
        this.b.a(str, ad_unit, list);
    }

    @JavascriptInterface
    public final void addBannerAdToScreen(double d) {
        this.f3411a.a().a(d);
    }

    @JavascriptInterface
    public final void closeTestSuite() {
        destroyBannerAd();
        this.c.onClosed();
    }

    @JavascriptInterface
    public final void destroyBannerAd() {
        this.f3411a.a().d();
    }

    @JavascriptInterface
    public final void isInterstitialReady() {
        a("isInterstitialReady", IronSource.AD_UNIT.INTERSTITIAL, C3406yf.f3954a.a(Boolean.valueOf(this.f3411a.b().e())));
    }

    @JavascriptInterface
    public final void isRewardedVideoReady() {
        a("isRewardedVideoReady", IronSource.AD_UNIT.REWARDED_VIDEO, C3406yf.f3954a.a(Boolean.valueOf(this.f3411a.c().a())));
    }

    @JavascriptInterface
    public final void loadBannerAd(String adNetwork, boolean z, boolean z2, String description, int i, int i2) {
        Intrinsics.checkNotNullParameter(adNetwork, "adNetwork");
        Intrinsics.checkNotNullParameter(description, "description");
        loadBannerAd(null, adNetwork, z, z2, description, i, i2);
    }

    @JavascriptInterface
    public final void loadInterstitialAd(String adNetwork, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(adNetwork, "adNetwork");
        loadInterstitialAd(null, adNetwork, z, z2);
    }

    @JavascriptInterface
    public final void loadRewardedVideoAd(String adNetwork, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(adNetwork, "adNetwork");
        loadRewardedVideoAd(null, adNetwork, z, z2);
    }

    @JavascriptInterface
    public final void onDataLoaded() {
        this.c.onUIReady();
    }

    @JavascriptInterface
    public final void showInterstitialAd() {
        this.f3411a.b().b();
    }

    @JavascriptInterface
    public final void showRewardedVideoAd() {
        this.f3411a.c().c();
    }

    @JavascriptInterface
    public final void loadBannerAd(String str, String adNetwork, boolean z, boolean z2, String description, int i, int i2) {
        Intrinsics.checkNotNullParameter(adNetwork, "adNetwork");
        Intrinsics.checkNotNullParameter(description, "description");
        this.f3411a.a().a(new C3203mf(adNetwork, z, Boolean.valueOf(z2), str), description, i, i2);
    }

    @JavascriptInterface
    public final void loadInterstitialAd(String str, String adNetwork, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(adNetwork, "adNetwork");
        this.f3411a.b().b(new C3203mf(adNetwork, z, Boolean.valueOf(z2), str));
    }

    @JavascriptInterface
    public final void loadRewardedVideoAd(String str, String adNetwork, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(adNetwork, "adNetwork");
        this.f3411a.c().a(new C3203mf(adNetwork, z, Boolean.valueOf(z2), str));
    }
}
