package io.bidmachine.ads.networks.gam.versions.v23_0_0;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam.GAMLoader;
import io.bidmachine.ads.networks.gam.GAMUnitData;
import io.bidmachine.ads.networks.gam.InternalGAMFullscreenAdPresentListener;
import io.bidmachine.ads.networks.gam.InternalGAMInterstitialAd;
import io.bidmachine.ads.networks.gam.InternalLoadListener;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class d extends InternalGAMInterstitialAd {

    /* renamed from: a, reason: collision with root package name */
    private AdManagerInterstitialAd f6608a;

    private static final class a extends AdManagerInterstitialAdLoadCallback {

        /* renamed from: a, reason: collision with root package name */
        private final d f6609a;
        private final InternalLoadListener b;

        public a(d gamInterstitialAd, InternalLoadListener loadListener) {
            this.f6609a = gamInterstitialAd;
            this.b = loadListener;
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            this.b.onAdLoadFailed(this.f6609a, new BMError(BMError.NoFill, loadAdError.getCode(), loadAdError.getMessage()));
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(AdManagerInterstitialAd adManagerInterstitialAd) {
            this.f6609a.f6608a = adManagerInterstitialAd;
            this.f6609a.onAdLoaded();
            this.b.onAdLoaded(this.f6609a);
        }
    }

    d(GAMLoader gamLoader, AdsFormat adsFormat, GAMUnitData gamUnitData) {
        super(gamLoader, adsFormat, gamUnitData);
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAd
    protected void destroyAd() {
        AdManagerInterstitialAd adManagerInterstitialAd = this.f6608a;
        if (adManagerInterstitialAd != null) {
            adManagerInterstitialAd.setFullScreenContentCallback(null);
            this.f6608a = null;
        }
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAd
    protected void loadAd(Context applicationContext, InternalLoadListener loadListener) {
        AdManagerInterstitialAd.load(applicationContext, getAdUnitId(), io.bidmachine.ads.networks.gam.versions.v23_0_0.a.a(getGamLoader(), getGamUnitData()), new a(this, loadListener));
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMFullscreenAd
    protected void showAd(Activity activity, InternalGAMFullscreenAdPresentListener showListener) {
        AdManagerInterstitialAd adManagerInterstitialAd = this.f6608a;
        if (adManagerInterstitialAd == null) {
            showListener.onAdShowFailed(BMError.internal("InternalGAM interstitial object is null or not loaded"));
        } else {
            adManagerInterstitialAd.setFullScreenContentCallback(new b(showListener));
            this.f6608a.show(activity);
        }
    }
}
