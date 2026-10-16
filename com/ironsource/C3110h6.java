package com.ironsource;

import android.app.Activity;
import com.ironsource.InterfaceC3121i0;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.h6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3110h6 implements InterfaceC3245p6 {

    /* renamed from: a, reason: collision with root package name */
    private final Na f3331a;
    private final a b;
    private final LevelPlayAdInfo c;

    /* renamed from: com.ironsource.h6$a */
    public enum a {
        Created,
        Closed,
        Expired,
        ShowFailed,
        LoadFailed
    }

    public C3110h6(Na adInternal, a status) {
        Intrinsics.checkNotNullParameter(adInternal, "adInternal");
        Intrinsics.checkNotNullParameter(status, "status");
        this.f3331a = adInternal;
        this.b = status;
        String uuid = adInternal.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
        this.c = new LevelPlayAdInfo(uuid, adInternal.h(), adInternal.d().toString(), null, null, null, null, 120, null);
    }

    private final boolean d() {
        if (this.f3331a.h().length() == 0) {
            Na na = this.f3331a;
            String uuid = this.f3331a.e().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
            Na.a(na, new LevelPlayAdError(uuid, this.f3331a.h(), LevelPlayAdError.ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED, "Ad unit ID should be specified"), 0L, 2, null);
            return false;
        }
        if (!this.f3331a.f().g()) {
            Na na2 = this.f3331a;
            String uuid2 = this.f3331a.e().toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "adInternal.adId.toString()");
            Na.a(na2, new LevelPlayAdError(uuid2, this.f3331a.h(), LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, "Load must be called after init success callback"), 0L, 2, null);
            return false;
        }
        La a2 = this.f3331a.l().e().a();
        if (a2 != null && a2.a(this.f3331a.h(), this.f3331a.d())) {
            return true;
        }
        Na na3 = this.f3331a;
        String uuid3 = this.f3331a.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid3, "adInternal.adId.toString()");
        Na.a(na3, new LevelPlayAdError(uuid3, this.f3331a.h(), LevelPlayAdError.ERROR_CODE_INVALID_AD_UNIT_ID, "Invalid ad unit id"), 0L, 2, null);
        return false;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str2 = this.b == a.Expired ? "Show called on expired ad" : "Show called before load success";
        String uuid = this.f3331a.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
        this.f3331a.a(new LevelPlayAdError(uuid, this.f3331a.h(), LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, str2), this.c);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public LevelPlayAdInfo b() {
        return this.c;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public InterfaceC3121i0 c() {
        return new InterfaceC3121i0.a(this.b == a.Expired ? "ad is invalid due to loading time" : "load ad was not called");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void loadAd() {
        if (d()) {
            this.f3331a.o();
        }
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClicked() {
        this.f3331a.a("onAdClicked on " + this.b + " state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClosed() {
        this.f3331a.a("onAdClosed on " + this.b + " state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3331a.a("onAdDisplayed on " + this.b + " state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3331a.a("onAdInfoChanged on " + this.b + " state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoadFailed(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3331a.a("onAdLoadFailed on " + this.b + " state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3331a.a("onAdLoaded on " + this.b + " state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3331a.a("onAdDisplayFailed on " + this.b + " state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a() {
        this.f3331a.a("onAdExpired on " + this.b + " state");
    }

    public /* synthetic */ C3110h6(Na na, a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(na, (i & 2) != 0 ? a.Created : aVar);
    }
}
