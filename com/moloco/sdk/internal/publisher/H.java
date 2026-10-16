package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.internal.w;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class H implements RewardedInterstitialAdShowListener, AdShowListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdShowListener f5489a;
    public final RewardedInterstitialAdShowListener b;
    public final Function0<com.moloco.sdk.internal.ortb.model.r> c;
    public final com.moloco.sdk.internal.w d;

    public H(RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, Function0<com.moloco.sdk.internal.ortb.model.r> provideSdkEvents, com.moloco.sdk.internal.w sdkEventUrlTracker) {
        Intrinsics.checkNotNullParameter(provideSdkEvents, "provideSdkEvents");
        Intrinsics.checkNotNullParameter(sdkEventUrlTracker, "sdkEventUrlTracker");
        this.f5489a = i.a(rewardedInterstitialAdShowListener);
        this.b = rewardedInterstitialAdShowListener;
        this.c = provideSdkEvents;
        this.d = sdkEventUrlTracker;
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdClicked(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.f5489a.onAdClicked(molocoAd);
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdHidden(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.f5489a.onAdHidden(molocoAd);
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowFailed(MolocoAdError molocoAdError) {
        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener = this.b;
        if (rewardedInterstitialAdShowListener != null) {
            rewardedInterstitialAdShowListener.onAdShowFailed(molocoAdError);
        }
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowSuccess(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.f5489a.onAdShowSuccess(molocoAd);
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onRewardedVideoCompleted(MolocoAd molocoAd) {
        String o;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.r invoke = this.c.invoke();
        if (invoke != null && (o = invoke.o()) != null) {
            w.a.a(this.d, o, System.currentTimeMillis(), null, 4, null);
        }
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener = this.b;
        if (rewardedInterstitialAdShowListener != null) {
            rewardedInterstitialAdShowListener.onRewardedVideoCompleted(molocoAd);
        }
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onRewardedVideoStarted(MolocoAd molocoAd) {
        String q;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.r invoke = this.c.invoke();
        if (invoke != null && (q = invoke.q()) != null) {
            w.a.a(this.d, q, System.currentTimeMillis(), null, 4, null);
        }
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener = this.b;
        if (rewardedInterstitialAdShowListener != null) {
            rewardedInterstitialAdShowListener.onRewardedVideoStarted(molocoAd);
        }
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onUserRewarded(MolocoAd molocoAd) {
        String s;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.r invoke = this.c.invoke();
        if (invoke != null && (s = invoke.s()) != null) {
            w.a.a(this.d, s, System.currentTimeMillis(), null, 4, null);
        }
        RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener = this.b;
        if (rewardedInterstitialAdShowListener != null) {
            rewardedInterstitialAdShowListener.onUserRewarded(molocoAd);
        }
    }
}
