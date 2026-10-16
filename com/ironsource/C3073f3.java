package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.banner.BannerAdLoaderListener;
import com.unity3d.ironsourceads.banner.BannerAdView;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.f3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3073f3 implements T<BannerAdView> {

    /* renamed from: a, reason: collision with root package name */
    private final Cf f3292a;
    private final BannerAdLoaderListener b;

    public C3073f3(Cf threadManager, BannerAdLoaderListener publisherListener) {
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(publisherListener, "publisherListener");
        this.f3292a = threadManager;
        this.b = publisherListener;
    }

    @Override // com.ironsource.T
    public void onAdLoadFailed(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3292a.a(new Runnable() { // from class: com.ironsource.f3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3073f3.a(IronSourceError.this, this);
            }
        });
    }

    @Override // com.ironsource.T
    public void a(final BannerAdView adObject) {
        Intrinsics.checkNotNullParameter(adObject, "adObject");
        this.f3292a.a(new Runnable() { // from class: com.ironsource.f3$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3073f3.a(BannerAdView.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BannerAdView adObject, C3073f3 this$0) {
        Intrinsics.checkNotNullParameter(adObject, "$adObject");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("BannerAdLoaderListener.onBannerAdLoaded adInfo: " + adObject.getAdInfo());
        this$0.b.onBannerAdLoaded(adObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError error, C3073f3 this$0) {
        Intrinsics.checkNotNullParameter(error, "$error");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("BannerAdLoaderListener.onBannerAdLoadFailed error: " + error);
        this$0.b.onBannerAdLoadFailed(error);
    }
}
