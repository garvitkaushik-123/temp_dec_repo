package com.ironsource;

import android.app.Activity;
import com.ironsource.C3110h6;
import com.ironsource.InterfaceC3121i0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.n6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3211n6 implements InterfaceC3245p6 {

    /* renamed from: a, reason: collision with root package name */
    private final Na f3599a;
    private final LevelPlayAdInfo b;

    public C3211n6(Na adInternal, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInternal, "adInternal");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3599a = adInternal;
        this.b = adInfo;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String uuid = this.f3599a.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
        this.f3599a.a(new LevelPlayAdError(uuid, this.f3599a.h(), LevelPlayAdError.ERROR_CODE_SHOW_WHILE_SHOW, "Ad is already showing"), this.b);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public LevelPlayAdInfo b() {
        return this.b;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public InterfaceC3121i0 c() {
        return new InterfaceC3121i0.a("ad is showing");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void loadAd() {
        String uuid = this.f3599a.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
        Na.a(this.f3599a, new LevelPlayAdError(uuid, this.f3599a.h(), LevelPlayAdError.ERROR_CODE_LOAD_WHILE_SHOW, "Load is called while ad is showing"), 0L, 2, null);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClicked() {
        this.f3599a.a("onAdClicked on showing state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClosed() {
        this.f3599a.a("onAdClosed on showing state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3205n0 f = this.f3599a.f();
        final LevelPlayAdInfo levelPlayAdInfo = new LevelPlayAdInfo(adInfo, this.b.getPlacementName());
        IronLog.INTERNAL.verbose(C3205n0.a(f, "onAdDisplayed adInfo: " + levelPlayAdInfo, (String) null, 2, (Object) null));
        f.e().h().e();
        Na na = this.f3599a;
        na.a(new C3228o6(na, levelPlayAdInfo));
        f.e(new Runnable() { // from class: com.ironsource.n6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3211n6.a(C3211n6.this, levelPlayAdInfo);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3599a.a("onAdInfoChanged on showing state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoadFailed(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3599a.a("onAdLoadFailed on showing state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3599a.a("onAdLoaded on showing state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3599a.a(a(error, this.b));
        this.f3599a.a(error, this.b);
    }

    private final InterfaceC3245p6 a(LevelPlayAdError levelPlayAdError, LevelPlayAdInfo levelPlayAdInfo) {
        if (C3021c5.f3211a.a(C3406yf.f3954a.a(levelPlayAdError))) {
            Na na = this.f3599a;
            return new C3177l6(na, levelPlayAdInfo, na.j());
        }
        return new C3110h6(this.f3599a, C3110h6.a.ShowFailed);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a() {
        this.f3599a.a("onAdExpired on showing state");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3211n6 this$0, LevelPlayAdInfo adInfoWithPlacement) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adInfoWithPlacement, "$adInfoWithPlacement");
        Oa k = this$0.f3599a.k();
        if (k != null) {
            k.onAdDisplayed(adInfoWithPlacement);
        }
    }
}
