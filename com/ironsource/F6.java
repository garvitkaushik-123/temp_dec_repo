package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class F6 implements I6 {

    /* renamed from: a, reason: collision with root package name */
    private final C6 f2863a;
    private final C3262q6 b;
    private final C3262q6 c;

    public F6(C6 strategy, C3262q6 currentAdUnit, C3262q6 progressiveAdUnit) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        Intrinsics.checkNotNullParameter(progressiveAdUnit, "progressiveAdUnit");
        this.f2863a = strategy;
        this.b = currentAdUnit;
        this.c = progressiveAdUnit;
    }

    @Override // com.ironsource.I6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f2863a.d().b(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_WHILE_LOAD, "Show called while progressive loading another ad"));
    }

    @Override // com.ironsource.I6
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2863a.a("load success with better ad before progressive load success");
    }

    @Override // com.ironsource.I6
    public void c(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C6 c6 = this.f2863a;
        c6.a(new E6(c6, this.b, this.c, adInfo));
    }

    @Override // com.ironsource.I6
    public void loadAd() {
        C6 c6 = this.f2863a;
        c6.a(new H6(c6, this.c));
    }

    @Override // com.ironsource.I6
    public void b(IronSourceError ironSourceError) {
        this.f2863a.a("show failed before progressive load success");
    }

    @Override // com.ironsource.I6
    public void a(IronSourceError ironSourceError) {
        C6 c6 = this.f2863a;
        c6.a(new D6(c6, this.b, false, 4, null));
    }

    @Override // com.ironsource.I6
    public void a() {
        this.f2863a.a("ad expired before progressive load success");
    }

    @Override // com.ironsource.I6
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2863a.a("show success before progressive load success");
    }
}
