package com.ironsource;

import android.app.Activity;
import com.ironsource.C3110h6;
import com.ironsource.InterfaceC3121i0;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.o6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3228o6 implements InterfaceC3245p6 {

    /* renamed from: a, reason: collision with root package name */
    private final Na f3612a;
    private final LevelPlayAdInfo b;

    public C3228o6(Na adInternal, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInternal, "adInternal");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3612a = adInternal;
        this.b = adInfo;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String uuid = this.f3612a.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
        this.f3612a.a(new LevelPlayAdError(uuid, this.f3612a.h(), LevelPlayAdError.ERROR_CODE_SHOW_WHILE_SHOW, "Ad is already shown"), this.b);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public LevelPlayAdInfo b() {
        return this.b;
    }

    @Override // com.ironsource.InterfaceC3245p6
    public InterfaceC3121i0 c() {
        return new InterfaceC3121i0.a("ad is shown");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void loadAd() {
        String uuid = this.f3612a.e().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "adInternal.adId.toString()");
        Na.a(this.f3612a, new LevelPlayAdError(uuid, this.f3612a.h(), LevelPlayAdError.ERROR_CODE_LOAD_WHILE_SHOW, "Load is called while ad is shown"), 0L, 2, null);
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClicked() {
        IronLog.INTERNAL.verbose(C3205n0.a(this.f3612a.f(), "onAdClicked adInfo: " + this.b, (String) null, 2, (Object) null));
        this.f3612a.f().e(new Runnable() { // from class: com.ironsource.o6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3228o6.a(C3228o6.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdClosed() {
        IronLog.INTERNAL.verbose(C3205n0.a(this.f3612a.f(), "onAdClosed adInfo: " + this.b, (String) null, 2, (Object) null));
        this.f3612a.f().d(new Runnable() { // from class: com.ironsource.o6$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3228o6.b(C3228o6.this);
            }
        });
        this.f3612a.f().e(new Runnable() { // from class: com.ironsource.o6$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C3228o6.c(C3228o6.this);
            }
        });
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3612a.a("onAdDisplayed on shown state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3612a.a("onAdInfoChanged on shown state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoadFailed(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3612a.a("onAdLoadFailed on shown state with error: " + error.getErrorMessage());
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        this.f3612a.a("onAdLoaded on shown state");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C3228o6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f3612a.a(C3110h6.a.Closed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C3228o6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Oa k = this$0.f3612a.k();
        if (k != null) {
            k.onAdClosed(this$0.b);
        }
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a() {
        this.f3612a.a("onAdExpired on shown state");
    }

    @Override // com.ironsource.InterfaceC3245p6
    public void a(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3612a.a("onAdDisplayFailed on shown state with error: " + error.getErrorMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3228o6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Oa k = this$0.f3612a.k();
        if (k != null) {
            k.onAdClicked(this$0.b);
        }
    }
}
