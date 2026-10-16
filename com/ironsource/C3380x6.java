package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.x6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3380x6 implements B6 {

    /* renamed from: a, reason: collision with root package name */
    private final C3363w6 f3931a;

    public C3380x6(C3363w6 strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.f3931a = strategy;
    }

    @Override // com.ironsource.B6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f3931a.a("show called before load success");
    }

    @Override // com.ironsource.B6
    public void b(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3931a.a("load success before load called");
    }

    @Override // com.ironsource.B6
    public void c(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3931a.a("load success with better ad before load called");
    }

    @Override // com.ironsource.B6
    public void loadAd() {
        C3262q6 a2 = this.f3931a.b().a(true, this.f3931a.c());
        this.f3931a.a(new C3414z6(this.f3931a, a2, true));
        a2.a(this.f3931a);
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3931a.a("ad expired before load called");
    }

    @Override // com.ironsource.B6
    public void b(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3931a.a("load failed before load called");
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3931a.a("ad display success before load called");
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3931a.a("ad display failed before load called");
    }
}
