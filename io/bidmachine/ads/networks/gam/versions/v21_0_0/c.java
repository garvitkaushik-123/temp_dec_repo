package io.bidmachine.ads.networks.gam.versions.v21_0_0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam.GAMLoader;
import io.bidmachine.ads.networks.gam.GAMUnitData;
import io.bidmachine.ads.networks.gam.InternalGAMAd;
import io.bidmachine.ads.networks.gam.InternalGAMAdPresentListener;
import io.bidmachine.ads.networks.gam.InternalGAMBannerAd;
import io.bidmachine.ads.networks.gam.InternalLoadListener;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class c extends InternalGAMBannerAd {

    /* renamed from: a, reason: collision with root package name */
    private final AdSize f6590a;
    private AdManagerAdView b;

    private static final class b extends AdListener {

        /* renamed from: a, reason: collision with root package name */
        private final InternalGAMAd f6591a;
        private final InternalLoadListener b;

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClicked() {
            InternalGAMAdPresentListener adPresentListener = this.f6591a.getAdPresentListener();
            if (adPresentListener != null) {
                adPresentListener.onAdClicked();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            this.b.onAdLoadFailed(this.f6591a, new BMError(BMError.NoFill, loadAdError.getCode(), loadAdError.getMessage()));
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            InternalGAMAdPresentListener adPresentListener = this.f6591a.getAdPresentListener();
            if (adPresentListener != null) {
                adPresentListener.onAdShown();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            this.f6591a.onAdLoaded();
            this.b.onAdLoaded(this.f6591a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
        }

        private b(InternalGAMAd internalGAMAd, InternalLoadListener loadListener) {
            this.f6591a = internalGAMAd;
            this.b = loadListener;
        }
    }

    c(GAMLoader gamLoader, AdsFormat adsFormat, GAMUnitData gamUnitData, AdSize adSize) {
        super(gamLoader, adsFormat, gamUnitData);
        this.f6590a = adSize;
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAd
    protected void destroyAd() {
        AdManagerAdView adManagerAdView = this.b;
        if (adManagerAdView != null) {
            adManagerAdView.destroy();
            this.b = null;
        }
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMBannerAd
    protected View getAdView() {
        return this.b;
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAd
    public void loadAd(Context applicationContext, InternalLoadListener loadListener) {
        AdManagerAdView adManagerAdView = new AdManagerAdView(applicationContext);
        this.b = adManagerAdView;
        adManagerAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.b.setAdUnitId(getAdUnitId());
        this.b.setAdListener(new b(this, loadListener));
        this.b.setAdSize(this.f6590a);
        this.b.loadAd(io.bidmachine.ads.networks.gam.versions.v21_0_0.a.a(getGamLoader(), getGamUnitData()));
    }
}
