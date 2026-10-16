package com.ironsource;

import android.content.Context;
import android.os.Handler;
import com.ironsource.C3102gf;
import com.ironsource.P8;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import com.unity3d.mediation.banner.LevelPlayBannerAdView;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAd;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAd;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.pf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3254pf implements C3102gf.c, C3102gf.d, C3102gf.b {

    /* renamed from: a, reason: collision with root package name */
    private final P8.a f3643a;
    private final WeakReference<TestSuiteActivity> b;
    private final Handler c;
    private final AtomicReference<LevelPlayBannerAdView> d;
    private final AtomicReference<LevelPlayInterstitialAd> e;
    private final AtomicReference<LevelPlayRewardedAd> f;

    public C3254pf(TestSuiteActivity activity, Handler handler) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f3643a = C3334ub.s.a().c();
        this.b = new WeakReference<>(activity);
        this.c = handler;
        this.d = new AtomicReference<>();
        this.e = new AtomicReference<>();
        this.f = new AtomicReference<>();
    }

    private final TestSuiteActivity f() {
        return this.b.get();
    }

    @Override // com.ironsource.C3102gf.d
    public void a(C3203mf loadAdConfig) {
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        this.f3643a.a(loadAdConfig);
        AtomicReference<LevelPlayRewardedAd> atomicReference = this.f;
        String a2 = loadAdConfig.a();
        if (a2 == null) {
            a2 = "";
        }
        LevelPlayRewardedAd levelPlayRewardedAd = new LevelPlayRewardedAd(a2);
        levelPlayRewardedAd.setListener(new C3304sf());
        levelPlayRewardedAd.loadAd();
        atomicReference.set(levelPlayRewardedAd);
    }

    @Override // com.ironsource.C3102gf.c
    public void b(C3203mf loadAdConfig) {
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        this.f3643a.a(loadAdConfig);
        AtomicReference<LevelPlayInterstitialAd> atomicReference = this.e;
        String a2 = loadAdConfig.a();
        if (a2 == null) {
            a2 = "";
        }
        LevelPlayInterstitialAd levelPlayInterstitialAd = new LevelPlayInterstitialAd(a2);
        levelPlayInterstitialAd.setListener(new C3287rf());
        levelPlayInterstitialAd.loadAd();
        atomicReference.set(levelPlayInterstitialAd);
    }

    @Override // com.ironsource.C3102gf.d
    public void c() {
        TestSuiteActivity f = f();
        if (f != null) {
            LevelPlayRewardedAd levelPlayRewardedAd = this.f.get();
            Intrinsics.checkNotNullExpressionValue(levelPlayRewardedAd, "rewardedAdRef.get()");
            LevelPlayRewardedAd.showAd$default(levelPlayRewardedAd, f, null, 2, null);
        }
    }

    @Override // com.ironsource.C3102gf.b
    public void d() {
        final LevelPlayBannerAdView andSet;
        final TestSuiteActivity f = f();
        if (f == null || (andSet = this.d.getAndSet(null)) == null) {
            return;
        }
        andSet.destroy();
        this.c.post(new Runnable() { // from class: com.ironsource.pf$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3254pf.b(TestSuiteActivity.this, andSet);
            }
        });
    }

    @Override // com.ironsource.C3102gf.c
    public boolean e() {
        LevelPlayInterstitialAd levelPlayInterstitialAd = this.e.get();
        if (levelPlayInterstitialAd != null) {
            return levelPlayInterstitialAd.isAdReady();
        }
        return false;
    }

    @Override // com.ironsource.C3102gf.d
    public boolean a() {
        LevelPlayRewardedAd levelPlayRewardedAd = this.f.get();
        if (levelPlayRewardedAd != null) {
            return levelPlayRewardedAd.isAdReady();
        }
        return false;
    }

    @Override // com.ironsource.C3102gf.c
    public void b() {
        TestSuiteActivity f = f();
        if (f != null) {
            LevelPlayInterstitialAd levelPlayInterstitialAd = this.e.get();
            Intrinsics.checkNotNullExpressionValue(levelPlayInterstitialAd, "interstitialAdRef.get()");
            LevelPlayInterstitialAd.showAd$default(levelPlayInterstitialAd, f, null, 2, null);
        }
    }

    @Override // com.ironsource.C3102gf.b
    public void a(C3203mf loadAdConfig, String description, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        Intrinsics.checkNotNullParameter(description, "description");
        d();
        TestSuiteActivity f = f();
        if (f != null) {
            this.f3643a.a(loadAdConfig);
            LevelPlayBannerAdView.Config build = new LevelPlayBannerAdView.Config.Builder().setAdSize(C3321tf.f3849a.b(description, i, i2)).build();
            AtomicReference<LevelPlayBannerAdView> atomicReference = this.d;
            String a2 = loadAdConfig.a();
            if (a2 == null) {
                a2 = "";
            }
            LevelPlayBannerAdView levelPlayBannerAdView = new LevelPlayBannerAdView(f, a2, build);
            levelPlayBannerAdView.setBannerListener(new C3271qf());
            levelPlayBannerAdView.pauseAutoRefresh();
            levelPlayBannerAdView.loadAd();
            atomicReference.set(levelPlayBannerAdView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TestSuiteActivity testSuiteActivity, LevelPlayBannerAdView it) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "$testSuiteActivity");
        Intrinsics.checkNotNullParameter(it, "$it");
        testSuiteActivity.getContainer().removeView(it);
    }

    @Override // com.ironsource.C3102gf.b
    public void a(double d) {
        final LevelPlayBannerAdView levelPlayBannerAdView;
        final TestSuiteActivity f = f();
        if (f == null || (levelPlayBannerAdView = this.d.get()) == null || levelPlayBannerAdView.getParent() != null) {
            return;
        }
        this.c.post(new Runnable() { // from class: com.ironsource.pf$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3254pf.a(TestSuiteActivity.this, levelPlayBannerAdView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TestSuiteActivity testSuiteActivity, LevelPlayBannerAdView banner) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "$testSuiteActivity");
        Intrinsics.checkNotNullParameter(banner, "$banner");
        testSuiteActivity.getContainer().addView(banner, C3406yf.f3954a.a((Context) testSuiteActivity));
    }
}
