package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class H6 implements I6 {

    /* renamed from: a, reason: collision with root package name */
    private final C6 f2896a;
    private final C3262q6 b;

    public H6(C6 strategy, C3262q6 adUnit) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f2896a = strategy;
        this.b = adUnit;
    }

    @Override // com.ironsource.I6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f2896a.d().b(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, "Show called before load success"));
    }

    @Override // com.ironsource.I6
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2896a.a("load success with better ad while loading");
    }

    @Override // com.ironsource.I6
    public void c(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C6 c6 = this.f2896a;
        c6.a(new G6(c6, this.b));
        this.f2896a.d().b(adInfo);
    }

    @Override // com.ironsource.I6
    public void loadAd() {
        this.f2896a.d().a(new IronSourceError(LevelPlayAdError.ERROR_CODE_LOAD_FAILED_ALREADY_CALLED, "Load called before load success"));
    }

    @Override // com.ironsource.I6
    public void b(IronSourceError ironSourceError) {
        this.f2896a.a("show failed while loading");
    }

    @Override // com.ironsource.I6
    public void a(IronSourceError ironSourceError) {
        C6 c6 = this.f2896a;
        c6.a(new D6(c6, this.b, false, 4, null));
        this.f2896a.d().a(ironSourceError);
    }

    @Override // com.ironsource.I6
    public void a() {
        this.f2896a.a("ad expired while loading");
    }

    @Override // com.ironsource.I6
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2896a.a("show success while loading");
    }
}
