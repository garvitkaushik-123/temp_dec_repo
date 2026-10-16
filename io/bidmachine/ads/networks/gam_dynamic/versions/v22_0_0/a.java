package io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdListener;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdLoadData;
import io.bidmachine.ads.networks.gam_dynamic.InternalAdPresentListener;
import io.bidmachine.ads.networks.gam_dynamic.InternalBannerAd;
import io.bidmachine.ads.networks.gam_dynamic.InternalLoadListener;
import io.bidmachine.ads.networks.gam_dynamic.NetworkParams;
import io.bidmachine.ads.networks.gam_dynamic.TaskExecutor;
import io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.a;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class a extends InternalBannerAd {

    /* renamed from: a, reason: collision with root package name */
    private final AdSize f6624a;
    private AdManagerAdView b;

    /* JADX INFO: Access modifiers changed from: private */
    static final class b extends AdListener {

        /* renamed from: a, reason: collision with root package name */
        private final a f6625a;
        private final InternalLoadListener b;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            InternalAdLoadData a2 = e.a(this.f6625a.b);
            this.f6625a.onAdLoaded(a2);
            this.b.onAdLoaded(this.f6625a, a2);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClicked() {
            InternalAdPresentListener adPresentListener = this.f6625a.getAdPresentListener();
            if (adPresentListener != null) {
                adPresentListener.onAdClicked();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(final LoadAdError loadAdError) {
            this.f6625a.onBackground(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.a$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.this.a(loadAdError);
                }
            });
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            InternalAdPresentListener adPresentListener = this.f6625a.getAdPresentListener();
            if (adPresentListener != null) {
                adPresentListener.onAdShown();
            }
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            this.f6625a.onBackground(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.a$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.this.a();
                }
            });
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
        }

        private b(a versionBannerAd, InternalLoadListener loadListener) {
            this.f6625a = versionBannerAd;
            this.b = loadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LoadAdError loadAdError) {
            this.b.onAdLoadFailed(this.f6625a, e.a(BMError.NoFill, loadAdError));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c implements OnPaidEventListener {

        /* renamed from: a, reason: collision with root package name */
        private final a f6626a;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(AdValue adValue) {
            this.f6626a.onPaidEvent(e.a(adValue));
        }

        @Override // com.google.android.gms.ads.OnPaidEventListener
        public void onPaidEvent(final AdValue adValue) {
            this.f6626a.onBackground(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.versions.v22_0_0.a$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.c.this.a(adValue);
                }
            });
        }

        private c(a versionBannerAd) {
            this.f6626a = versionBannerAd;
        }
    }

    a(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener, AdSize adSize) {
        super(networkParams, taskExecutor, adsFormat, adUnit, internalAdListener);
        this.f6624a = adSize;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAd
    protected void destroyAd() {
        AdManagerAdView adManagerAdView = this.b;
        if (adManagerAdView != null) {
            adManagerAdView.setOnPaidEventListener(null);
            this.b.destroy();
            this.b = null;
        }
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalBannerAd
    protected View getAdView() {
        return this.b;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAd
    public void loadAd(Context applicationContext, InternalLoadListener internalLoadListener) {
        AdManagerAdView adManagerAdView = new AdManagerAdView(applicationContext);
        this.b = adManagerAdView;
        adManagerAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.b.setAdUnitId(getAdUnitId());
        this.b.setAdListener(new b(internalLoadListener));
        this.b.setOnPaidEventListener(new c());
        this.b.setAdSize(this.f6624a);
        this.b.loadAd(e.a(getAdUnit()));
    }
}
