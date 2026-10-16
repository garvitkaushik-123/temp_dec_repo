package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.z6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3414z6 implements B6 {

    /* renamed from: a, reason: collision with root package name */
    private final C3363w6 f3960a;
    private final C3262q6 b;
    private boolean c;

    public C3414z6(C3363w6 strategy, C3262q6 currentAdUnit, boolean z) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        this.f3960a = strategy;
        this.b = currentAdUnit;
        this.c = z;
    }

    @Override // com.ironsource.B6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f3960a.a("show called while loading");
    }

    @Override // com.ironsource.B6
    public void b(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (!this.c) {
            this.f3960a.a(new C3397y6(this.f3960a, this.b, null, false));
            return;
        }
        C3262q6 a2 = this.f3960a.b().a(false, this.f3960a.c());
        this.f3960a.a(new C3397y6(this.f3960a, this.b, a2, true));
        this.f3960a.d().b(adInfo);
        a2.a(this.f3960a);
    }

    @Override // com.ironsource.B6
    public void c(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3960a.a("ad info changed while loading");
    }

    @Override // com.ironsource.B6
    public void loadAd() {
        if (this.c) {
            this.f3960a.a("load called while loading");
        }
        this.c = true;
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3960a.a("show success while loading");
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3960a.a("show failed while loading");
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3960a.a("ad expired while loading");
    }

    @Override // com.ironsource.B6
    public void b(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3960a.a(new C3380x6(this.f3960a));
        if (this.c) {
            this.f3960a.d().a(ironSourceError);
        }
    }
}
