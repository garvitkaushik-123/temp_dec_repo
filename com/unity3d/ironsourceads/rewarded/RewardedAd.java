package com.unity3d.ironsourceads.rewarded;

import android.app.Activity;
import com.ironsource.C3336ud;
import com.ironsource.InterfaceC3353vd;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class RewardedAd implements InterfaceC3353vd {

    /* renamed from: a, reason: collision with root package name */
    private final C3336ud f6435a;
    private RewardedAdListener b;

    public RewardedAd(C3336ud rewardedAdInternal) {
        Intrinsics.checkNotNullParameter(rewardedAdInternal, "rewardedAdInternal");
        this.f6435a = rewardedAdInternal;
        rewardedAdInternal.a(this);
    }

    public final RewardedAdInfo getAdInfo() {
        return this.f6435a.b();
    }

    public final RewardedAdListener getListener() {
        return this.b;
    }

    public final boolean isReadyToShow() {
        IronLog.API.info();
        return this.f6435a.d();
    }

    @Override // com.ironsource.InterfaceC3353vd
    public void onAdInstanceDidBecomeVisible() {
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdShown adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdShown(this);
        }
    }

    @Override // com.ironsource.InterfaceC3353vd
    public void onRewardedAdClicked() {
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdClicked adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdClicked(this);
        }
    }

    @Override // com.ironsource.InterfaceC3353vd
    public void onRewardedAdDismissed() {
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdDismissed adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdDismissed(this);
        }
    }

    @Override // com.ironsource.InterfaceC3353vd
    public void onRewardedAdFailedToShow(IronSourceError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdFailedToShow error: " + error + " adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdFailedToShow(this, error);
        }
    }

    @Override // com.ironsource.InterfaceC3353vd
    public void onRewardedAdShown() {
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdShown adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdShown(this);
        }
    }

    @Override // com.ironsource.InterfaceC3353vd
    public void onUserEarnedReward() {
        IronLog.CALLBACK.info("RewardedAdListener onUserEarnedReward adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onUserEarnedReward(this);
        }
    }

    public final void setListener(RewardedAdListener rewardedAdListener) {
        this.b = rewardedAdListener;
    }

    public final void show(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IronLog.API.info();
        this.f6435a.a(activity);
    }
}
