package io.bidmachine.ads.networks.gam_dynamic.versions.v23_0_0;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdListener;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdLoadData;
import io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAdPresentListener;
import io.bidmachine.ads.networks.gam_dynamic.InternalLoadListener;
import io.bidmachine.ads.networks.gam_dynamic.InternalRewardedAd;
import io.bidmachine.ads.networks.gam_dynamic.NetworkParams;
import io.bidmachine.ads.networks.gam_dynamic.TaskExecutor;
import io.bidmachine.ads.networks.gam_dynamic.versions.v23_0_0.d;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class d extends InternalRewardedAd {

    /* renamed from: a, reason: collision with root package name */
    private RewardedAd f6642a;

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends RewardedAdLoadCallback {

        /* renamed from: a, reason: collision with root package name */
        private final d f6643a;
        private final InternalLoadListener b;

        public b(d versionRewardedAd, InternalLoadListener loadListener) {
            this.f6643a = versionRewardedAd;
            this.b = loadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(RewardedAd rewardedAd) {
            InternalAdLoadData a2 = e.a(rewardedAd);
            this.f6643a.onAdLoaded(a2);
            this.b.onAdLoaded(this.f6643a, a2);
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(final LoadAdError loadAdError) {
            this.f6643a.onBackground(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.versions.v23_0_0.d$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    d.b.this.a(loadAdError);
                }
            });
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(final RewardedAd rewardedAd) {
            rewardedAd.setOnPaidEventListener(new c());
            this.f6643a.f6642a = rewardedAd;
            this.f6643a.onBackground(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.versions.v23_0_0.d$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    d.b.this.a(rewardedAd);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LoadAdError loadAdError) {
            this.b.onAdLoadFailed(this.f6643a, e.a(BMError.NoFill, loadAdError));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c implements OnPaidEventListener {

        /* renamed from: a, reason: collision with root package name */
        private final d f6644a;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(AdValue adValue) {
            this.f6644a.onPaidEvent(e.a(adValue));
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(final AdValue adValue) {
            this.f6644a.onBackground(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.versions.v23_0_0.d$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    d.c.this.a(adValue);
                }
            });
        }

        private c(d versionRewardedAd) {
            this.f6644a = versionRewardedAd;
        }
    }

    /* renamed from: io.bidmachine.ads.networks.gam_dynamic.versions.v23_0_0.d$d, reason: collision with other inner class name */
    private static final class C0595d implements OnUserEarnedRewardListener {
        private C0595d() {
        }

        @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
        public void onUserEarnedReward(RewardItem rewardItem) {
        }
    }

    d(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener) {
        super(networkParams, taskExecutor, adsFormat, adUnit, internalAdListener);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAd
    protected void destroyAd() {
        RewardedAd rewardedAd = this.f6642a;
        if (rewardedAd != null) {
            rewardedAd.setFullScreenContentCallback(null);
            this.f6642a.setOnPaidEventListener(null);
            this.f6642a = null;
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAd
    protected void loadAd(Context applicationContext, InternalLoadListener internalLoadListener) {
        RewardedAd.load(applicationContext, getAdUnitId(), e.a(getAdUnit()), (RewardedAdLoadCallback) new b(this, internalLoadListener));
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAd
    protected void showAd(Activity activity, InternalFullscreenAdPresentListener showListener) {
        RewardedAd rewardedAd = this.f6642a;
        if (rewardedAd == null) {
            showListener.onAdShowFailed(BMError.internal("Internal GAM rewarded object is null or not loaded"));
        } else {
            rewardedAd.setFullScreenContentCallback(new io.bidmachine.ads.networks.gam_dynamic.versions.v23_0_0.b(showListener));
            this.f6642a.show(activity, new C0595d());
        }
    }
}
