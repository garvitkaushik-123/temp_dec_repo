package io.bidmachine.ads.networks.gam.versions.v21_0_0;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam.GAMLoader;
import io.bidmachine.ads.networks.gam.GAMUnitData;
import io.bidmachine.ads.networks.gam.InternalGAMFullscreenAdPresentListener;
import io.bidmachine.ads.networks.gam.InternalGAMRewardedAd;
import io.bidmachine.ads.networks.gam.InternalLoadListener;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class e extends InternalGAMRewardedAd {

    /* renamed from: a, reason: collision with root package name */
    private RewardedAd f6594a;

    private static final class b extends RewardedAdLoadCallback {

        /* renamed from: a, reason: collision with root package name */
        private final e f6595a;
        private final InternalLoadListener b;

        public b(e gamRewardedAd, InternalLoadListener loadListener) {
            this.f6595a = gamRewardedAd;
            this.b = loadListener;
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            this.b.onAdLoadFailed(this.f6595a, new BMError(BMError.NoFill, loadAdError.getCode(), loadAdError.getMessage()));
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(RewardedAd rewardedAd) {
            this.f6595a.f6594a = rewardedAd;
            this.f6595a.onAdLoaded();
            this.b.onAdLoaded(this.f6595a);
        }
    }

    private static final class c implements OnUserEarnedRewardListener {
        private c() {
        }

        @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
        public void onUserEarnedReward(RewardItem rewardItem) {
        }
    }

    e(GAMLoader gamLoader, AdsFormat adsFormat, GAMUnitData gamUnitData) {
        super(gamLoader, adsFormat, gamUnitData);
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAd
    protected void destroyAd() {
        RewardedAd rewardedAd = this.f6594a;
        if (rewardedAd != null) {
            rewardedAd.setFullScreenContentCallback(null);
            this.f6594a = null;
        }
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAd
    protected void loadAd(Context applicationContext, InternalLoadListener loadListener) {
        RewardedAd.load(applicationContext, getAdUnitId(), io.bidmachine.ads.networks.gam.versions.v21_0_0.a.a(getGamLoader(), getGamUnitData()), (RewardedAdLoadCallback) new b(this, loadListener));
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMFullscreenAd
    protected void showAd(Activity activity, InternalGAMFullscreenAdPresentListener showListener) {
        RewardedAd rewardedAd = this.f6594a;
        if (rewardedAd == null) {
            showListener.onAdShowFailed(BMError.internal("InternalGAM rewarded object is null or not loaded"));
        } else {
            rewardedAd.setFullScreenContentCallback(new io.bidmachine.ads.networks.gam.versions.v21_0_0.b(showListener));
            this.f6594a.show(activity, new c());
        }
    }
}
