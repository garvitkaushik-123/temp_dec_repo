package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class G6 implements I6 {

    /* renamed from: a, reason: collision with root package name */
    private final C6 f2881a;
    private final C3262q6 b;

    public G6(C6 strategy, C3262q6 adUnit) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f2881a = strategy;
        this.b = adUnit;
    }

    @Override // com.ironsource.I6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b.a(activity, this.f2881a);
    }

    @Override // com.ironsource.I6
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2881a.d().onAdInfoChanged(adInfo);
    }

    @Override // com.ironsource.I6
    public void c(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2881a.a("Ad unit is already loaded");
    }

    @Override // com.ironsource.I6
    public void loadAd() {
        C6 c6 = this.f2881a;
        c6.a(new D6(c6, null, false, 4, null));
        this.f2881a.loadAd();
    }

    @Override // com.ironsource.I6
    public void a(IronSourceError ironSourceError) {
        this.f2881a.a("load failed after ad unit is already loaded");
    }

    @Override // com.ironsource.I6
    public void b(IronSourceError ironSourceError) {
        if (!C3021c5.f3211a.a(ironSourceError)) {
            C6 c6 = this.f2881a;
            c6.a(new D6(c6, null, false, 4, null));
        }
        this.f2881a.d().b(ironSourceError);
    }

    @Override // com.ironsource.I6
    public void a() {
        C6 c6 = this.f2881a;
        c6.a(new D6(c6, null, true));
        this.f2881a.d().a();
    }

    @Override // com.ironsource.I6
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2881a.d().a(adInfo);
        C3262q6 a2 = this.f2881a.b().a(false, this.f2881a.c());
        C6 c6 = this.f2881a;
        c6.a(new F6(c6, this.b, a2));
        a2.a(this.f2881a);
    }
}
