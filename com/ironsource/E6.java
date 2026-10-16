package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class E6 implements I6 {

    /* renamed from: a, reason: collision with root package name */
    private final C6 f2841a;
    private final C3262q6 b;
    private final C3262q6 c;
    private LevelPlayAdInfo d;

    public E6(C6 strategy, C3262q6 currentAdUnit, C3262q6 progressiveAdUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        Intrinsics.checkNotNullParameter(progressiveAdUnit, "progressiveAdUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2841a = strategy;
        this.b = currentAdUnit;
        this.c = progressiveAdUnit;
        this.d = adInfo;
    }

    @Override // com.ironsource.I6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f2841a.d().b(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, "Show called before load success"));
    }

    @Override // com.ironsource.I6
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.d = adInfo;
    }

    @Override // com.ironsource.I6
    public void c(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2841a.a("load success on progressive ad unit is already loaded");
    }

    @Override // com.ironsource.I6
    public void loadAd() {
        this.f2841a.d().b(this.d);
        C6 c6 = this.f2841a;
        c6.a(new G6(c6, this.c));
    }

    @Override // com.ironsource.I6
    public void b(IronSourceError ironSourceError) {
        this.f2841a.a("show failed on progressive ad unit that already loaded");
    }

    @Override // com.ironsource.I6
    public void a(IronSourceError ironSourceError) {
        this.f2841a.a("load failed on progressive ad unit that already loaded");
    }

    @Override // com.ironsource.I6
    public void a() {
        C6 c6 = this.f2841a;
        c6.a(new D6(c6, this.b, true));
    }

    @Override // com.ironsource.I6
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2841a.a("show success on progressive ad unit that already loaded");
    }
}
