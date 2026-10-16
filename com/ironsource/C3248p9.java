package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.p9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3248p9 implements T<InterstitialAd> {

    /* renamed from: a, reason: collision with root package name */
    private final Cf f3637a;
    private final InterstitialAdLoaderListener b;

    public C3248p9(Cf threadManager, InterstitialAdLoaderListener publisherListener) {
        Intrinsics.checkNotNullParameter(threadManager, "threadManager");
        Intrinsics.checkNotNullParameter(publisherListener, "publisherListener");
        this.f3637a = threadManager;
        this.b = publisherListener;
    }

    @Override // com.ironsource.T
    public void onAdLoadFailed(final IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f3637a.a(new Runnable() { // from class: com.ironsource.p9$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3248p9.a(IronSourceError.this, this);
            }
        });
    }

    @Override // com.ironsource.T
    public void a(final InterstitialAd adObject) {
        Intrinsics.checkNotNullParameter(adObject, "adObject");
        this.f3637a.a(new Runnable() { // from class: com.ironsource.p9$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3248p9.a(InterstitialAd.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterstitialAd adObject, C3248p9 this$0) {
        Intrinsics.checkNotNullParameter(adObject, "$adObject");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("InterstitialAdLoaderListener.onInterstitialAdLoaded adInfo: " + adObject.getAdInfo());
        this$0.b.onInterstitialAdLoaded(adObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError error, C3248p9 this$0) {
        Intrinsics.checkNotNullParameter(error, "$error");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.CALLBACK.info("InterstitialAdLoaderListener.onInterstitialAdLoadFailed error: " + error);
        this$0.b.onInterstitialAdLoadFailed(error);
    }
}
