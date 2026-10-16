package io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdListener;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdLoadData;
import io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAdPresentListener;
import io.bidmachine.ads.networks.gam_dynamic.InternalInterstitialAd;
import io.bidmachine.ads.networks.gam_dynamic.InternalLoadListener;
import io.bidmachine.ads.networks.gam_dynamic.NetworkParams;
import io.bidmachine.ads.networks.gam_dynamic.TaskExecutor;
import io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.c;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class c extends InternalInterstitialAd {

    /* renamed from: a, reason: collision with root package name */
    private AdManagerInterstitialAd f6628a;

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends AdManagerInterstitialAdLoadCallback {

        /* renamed from: a, reason: collision with root package name */
        private final c f6629a;
        private final InternalLoadListener b;

        public b(c versionInterstitialAd, InternalLoadListener loadListener) {
            this.f6629a = versionInterstitialAd;
            this.b = loadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(AdManagerInterstitialAd adManagerInterstitialAd) {
            InternalAdLoadData a2 = e.a(adManagerInterstitialAd);
            this.f6629a.onAdLoaded(a2);
            this.b.onAdLoaded(this.f6629a, a2);
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(final LoadAdError loadAdError) {
            this.f6629a.onBackground(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.c$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.this.a(loadAdError);
                }
            });
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(final AdManagerInterstitialAd adManagerInterstitialAd) {
            adManagerInterstitialAd.setOnPaidEventListener(new C0591c());
            this.f6629a.f6628a = adManagerInterstitialAd;
            this.f6629a.onBackground(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.c$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.this.a(adManagerInterstitialAd);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LoadAdError loadAdError) {
            this.b.onAdLoadFailed(this.f6629a, e.a(BMError.NoFill, loadAdError));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.c$c, reason: collision with other inner class name */
    static final class C0591c implements OnPaidEventListener {

        /* renamed from: a, reason: collision with root package name */
        private final c f6630a;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(AdValue adValue) {
            this.f6630a.onPaidEvent(e.a(adValue));
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(final AdValue adValue) {
            this.f6630a.onBackground(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.c$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    c.C0591c.this.a(adValue);
                }
            });
        }

        private C0591c(c versionInterstitialAd) {
            this.f6630a = versionInterstitialAd;
        }
    }

    c(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener) {
        super(networkParams, taskExecutor, adsFormat, adUnit, internalAdListener);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAd
    protected void destroyAd() {
        AdManagerInterstitialAd adManagerInterstitialAd = this.f6628a;
        if (adManagerInterstitialAd != null) {
            adManagerInterstitialAd.setFullScreenContentCallback(null);
            this.f6628a.setOnPaidEventListener(null);
            this.f6628a = null;
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAd
    protected void loadAd(Context applicationContext, InternalLoadListener internalLoadListener) {
        AdManagerInterstitialAd.load(applicationContext, getAdUnitId(), e.a(getAdUnit()), new b(this, internalLoadListener));
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAd
    protected void showAd(Activity activity, InternalFullscreenAdPresentListener showListener) {
        AdManagerInterstitialAd adManagerInterstitialAd = this.f6628a;
        if (adManagerInterstitialAd == null) {
            showListener.onAdShowFailed(BMError.internal("Internal GAM interstitial object is null or not loaded"));
        } else {
            adManagerInterstitialAd.setFullScreenContentCallback(new io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.b(showListener));
            this.f6628a.show(activity);
        }
    }
}
