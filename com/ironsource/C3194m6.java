package com.ironsource;

import android.app.Activity;
import com.ironsource.C3110h6;
import com.ironsource.InterfaceC3121i0;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.m6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3194m6 implements InterfaceC3245p6 {

    /* renamed from: a, reason: collision with root package name */
    private final Na f3478a;
    private final InterfaceC3293s4 b;
    private final long c;
    private final LevelPlayAdInfo d;

    public C3194m6(Na adInternal, InterfaceC3293s4 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(adInternal, "adInternal");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.f3478a = adInternal;
        this.b = currentTimeProvider;
        this.c = currentTimeProvider.a();
        String uuid = adInternal.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
        this.d = new LevelPlayAdInfo(uuid, adInternal.h(), adInternal.d().toString(), null, null, null, null, 120, null);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String uuid = this.f3478a.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
        this.f3478a.a(new LevelPlayAdError(uuid, this.f3478a.h(), LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, "Show is called while loading ad"), this.d);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public LevelPlayAdInfo b() {
        return this.d;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public InterfaceC3121i0 c() {
        return new InterfaceC3121i0.a("Ad is loading");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void loadAd() {
        String uuid = this.f3478a.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
        this.f3478a.a(new LevelPlayAdError(uuid, this.f3478a.h(), LevelPlayAdError.ERROR_CODE_LOAD_FAILED_ALREADY_CALLED, "Load is already called"), this.b.a() - this.c);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClicked() {
        this.f3478a.a("onAdClicked on loading state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClosed() {
        this.f3478a.a("onAdClosed on loading state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3478a.a("onAdDisplayed on loading state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3478a.a("onAdInfoChanged on loading state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoadFailed(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3478a.a(error, this.b.a() - this.c);
        this.f3478a.a(C3110h6.a.LoadFailed);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Na na = this.f3478a;
        na.a(new C3177l6(na, adInfo, this.b));
        this.f3478a.a(adInfo);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a() {
        this.f3478a.a("onAdExpired on loading state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3478a.a("onAdDisplayFailed on loading state with error: " + error.getErrorMessage());
    }
}
