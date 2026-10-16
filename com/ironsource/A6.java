package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class A6 implements B6, InterfaceC3312t6 {

    /* renamed from: a, reason: collision with root package name */
    private final C3363w6 f2789a;
    private final C3262q6 b;
    private C3262q6 c;

    public A6(C3363w6 strategy, C3262q6 currentAdUnit, C3262q6 c3262q6) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        this.f2789a = strategy;
        this.b = currentAdUnit;
        this.c = c3262q6;
        currentAdUnit.a(this);
    }

    @Override // com.ironsource.B6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f2789a.a("show called while showing");
    }

    @Override // com.ironsource.B6
    public void b(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (adUnit == this.b) {
            this.f2789a.a("load success while current ad is showing");
        }
    }

    @Override // com.ironsource.B6
    public void c(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (adUnit == this.b) {
            this.f2789a.a("ad info changed while current ad is showing");
        }
    }

    @Override // com.ironsource.J0
    public void g() {
        this.f2789a.c().g();
    }

    @Override // com.ironsource.B6
    public void loadAd() {
        this.f2789a.a("load called while showing");
    }

    @Override // com.ironsource.InterfaceC3312t6
    public void onClosed() {
        this.f2789a.a(a(this, null, 1, null));
        this.f2789a.c().onClosed();
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        if (Intrinsics.areEqual(adUnit, this.b)) {
            this.f2789a.d().a(adInfo);
        } else {
            this.f2789a.a("progressive show success while showing current ad");
        }
    }

    @Override // com.ironsource.B6
    public void b(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        if (adUnit == this.c) {
            this.c = null;
        } else {
            this.f2789a.a("load failed while current ad is showing");
        }
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit, IronSourceError ironSourceError) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        if (!Intrinsics.areEqual(adUnit, this.b)) {
            this.f2789a.a("progressive show failed while showing current ad");
            return;
        }
        this.f2789a.a(a(ironSourceError));
        this.f2789a.d().b(ironSourceError);
    }

    @Override // com.ironsource.B6
    public void a(C3262q6 adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        if (adUnit == this.c) {
            this.c = null;
        } else {
            this.f2789a.a("ad expired while current ad is showing");
        }
    }

    @Override // com.ironsource.InterfaceC3312t6
    public void a(LevelPlayReward reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        this.f2789a.c().a(reward);
    }

    static /* synthetic */ B6 a(A6 a6, IronSourceError ironSourceError, int i, Object obj) {
        if ((i & 1) != 0) {
            ironSourceError = null;
        }
        return a6.a(ironSourceError);
    }

    private final B6 a(IronSourceError ironSourceError) {
        if (C3021c5.f3211a.a(ironSourceError)) {
            return new C3397y6(this.f2789a, this.b, this.c, true);
        }
        C3262q6 c3262q6 = this.c;
        if (c3262q6 == null) {
            return new C3380x6(this.f2789a);
        }
        if (c3262q6.e() != null) {
            return new C3397y6(this.f2789a, c3262q6, null, false, 8, null);
        }
        return new C3414z6(this.f2789a, c3262q6, false);
    }
}
