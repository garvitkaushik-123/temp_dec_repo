package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class D6 implements I6 {

    /* renamed from: a, reason: collision with root package name */
    private final C6 f2826a;
    private final C3262q6 b;
    private final boolean c;

    public D6(C6 strategy, C3262q6 c3262q6, boolean z) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.f2826a = strategy;
        this.b = c3262q6;
        this.c = z;
    }

    @Override // com.ironsource.I6
    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f2826a.d().b(new IronSourceError(LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, this.c ? "Show called on expired ad" : "Show called before load success"));
    }

    @Override // com.ironsource.I6
    public void b(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2826a.a(this.c ? "load with better ad on expired ad" : "load success with better ad before load success");
    }

    @Override // com.ironsource.I6
    public void c(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2826a.a(this.c ? "load success on expired ad" : "load success before load called");
    }

    @Override // com.ironsource.I6
    public void loadAd() {
        C3262q6 a2 = this.f2826a.b().a(true, this.f2826a.c());
        C6 c6 = this.f2826a;
        c6.a(new H6(c6, a2));
        a2.a(this.f2826a);
    }

    @Override // com.ironsource.I6
    public void b(IronSourceError ironSourceError) {
        this.f2826a.a(this.c ? "show failed on expired ad" : "show failed before load called");
    }

    public /* synthetic */ D6(C6 c6, C3262q6 c3262q6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c6, c3262q6, (i & 4) != 0 ? false : z);
    }

    @Override // com.ironsource.I6
    public void a(IronSourceError ironSourceError) {
        this.f2826a.a(this.c ? "load failed on expired ad" : "load failed before load called");
    }

    @Override // com.ironsource.I6
    public void a() {
        this.f2826a.a(this.c ? "ad expired on expired ad" : "ad expired before load called");
    }

    @Override // com.ironsource.I6
    public void a(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f2826a.a(this.c ? "show success on expired ad" : "show success before load called");
    }
}
