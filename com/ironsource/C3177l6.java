package com.ironsource;

import android.app.Activity;
import com.ironsource.C3110h6;
import com.ironsource.InterfaceC3121i0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.l6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3177l6 implements InterfaceC3245p6 {

    /* renamed from: a, reason: collision with root package name */
    private final Na f3444a;
    private LevelPlayAdInfo b;
    private final InterfaceC3293s4 c;
    private final long d;

    public C3177l6(Na adInternal, LevelPlayAdInfo adInfo, InterfaceC3293s4 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(adInternal, "adInternal");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.f3444a = adInternal;
        this.b = adInfo;
        this.c = currentTimeProvider;
        this.d = currentTimeProvider.a();
    }

    private final long d() {
        return this.c.a() - this.d;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Placement a2 = this.f3444a.f().a(this.f3444a.d(), str);
        LevelPlayAdInfo levelPlayAdInfo = new LevelPlayAdInfo(this.b, str);
        this.b = levelPlayAdInfo;
        Na na = this.f3444a;
        na.a(new C3211n6(na, levelPlayAdInfo));
        this.f3444a.c().a(activity, a2);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public LevelPlayAdInfo b() {
        return this.b;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public InterfaceC3121i0 c() {
        N3 a2 = this.f3444a.l().f().a(this.f3444a.h());
        return a2.d() ? InterfaceC3121i0.a.c.a(a2.e()) : InterfaceC3121i0.b.f3347a;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void loadAd() {
        this.f3444a.f().e().h().a(Long.valueOf(d()));
        this.f3444a.a(this.b);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClicked() {
        this.f3444a.a("onAdClicked on loaded state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClosed() {
        this.f3444a.a("onAdClosed on loaded state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3444a.a("onAdDisplayed on loaded state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdInfoChanged(final LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3205n0 f = this.f3444a.f();
        IronLog.INTERNAL.verbose(C3205n0.a(f, "onAdInfoChanged adInfo: " + adInfo, (String) null, 2, (Object) null));
        f.e().h().a(this.b, adInfo);
        this.b = adInfo;
        f.e(new Runnable() { // from class: com.ironsource.l6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3177l6.a(C3177l6.this, adInfo);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoadFailed(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3444a.a("onAdLoadFailed on loaded state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3444a.a("onAdLoaded on loaded state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a() {
        IronLog.INTERNAL.verbose(C3205n0.a(this.f3444a.f(), "onAdExpired", (String) null, 2, (Object) null));
        this.f3444a.a(C3110h6.a.Expired);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3177l6 this$0, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfo, "$adInfo");
        Oa k = this$0.f3444a.k();
        if (k != null) {
            k.onAdInfoChanged(adInfo);
        }
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3444a.a("onAdDisplayFailed on loaded state with error: " + error.getErrorMessage());
    }
}
