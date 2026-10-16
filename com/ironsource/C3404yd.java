package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.yd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3404yd implements T<RewardedAd> {

    /* renamed from: a, reason: collision with root package name */
    private final Cf f3952a;
    private final RewardedAdLoaderListener b;

    public C3404yd(Cf threadManager, RewardedAdLoaderListener publisherListener) {
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(publisherListener, "publisherListener");
        this.f3952a = threadManager;
        this.b = publisherListener;
    }

    @Override // com.ironsource.T
    public void onAdLoadFailed(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.CALLBACK.info("RewardedAdLoaderListener.onRewardedAdLoadFailed error: " + error);
        this.f3952a.a(new Runnable() { // from class: com.ironsource.yd$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3404yd.a(C3404yd.this, error);
            }
        });
    }

    @Override // com.ironsource.T
    public void a(final RewardedAd adObject) {
        Intrinsics.checkNotNullParameter(adObject, "adObject");
        this.f3952a.a(new Runnable() { // from class: com.ironsource.yd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3404yd.a(RewardedAd.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RewardedAd adObject, C3404yd this$0) {
        Intrinsics.checkNotNullParameter(adObject, "$adObject");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("RewardedAdLoaderListener.onRewardedAdLoaded adInfo: " + adObject.getAdInfo());
        this$0.b.onRewardedAdLoaded(adObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3404yd this$0, IronSourceError error) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "$error");
        this$0.b.onRewardedAdLoadFailed(error);
    }
}
