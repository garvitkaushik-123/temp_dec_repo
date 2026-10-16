package com.ironsource.adapters.admob.banner;

import android.widget.FrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.ironsource.adapters.admob.AdMobAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;

/* loaded from: classes6.dex */
public class AdMobBannerAdListener extends AdListener {
    private String mAdUnitId;
    private AdView mAdView;
    private BannerSmashListener mListener;

    AdMobBannerAdListener(BannerSmashListener bannerSmashListener, String str, AdView adView) {
        this.mListener = bannerSmashListener;
        this.mAdUnitId = str;
        this.mAdView = adView;
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + this.mAdUnitId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            if (this.mAdView == null) {
                IronLog.INTERNAL.verbose("adView is null");
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.mListener.onBannerAdLoaded(this.mAdView, layoutParams);
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(LoadAdError loadAdError) {
        String str;
        IronSourceError buildLoadFailedError;
        IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + this.mAdUnitId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        if (loadAdError != null) {
            str = loadAdError.getMessage() + "( " + loadAdError.getCode() + " ) ";
            if (loadAdError.getCause() != null) {
                str = str + " Caused by - " + loadAdError.getCause();
            }
            if (AdMobAdapter.isNoFillError(loadAdError.getCode())) {
                buildLoadFailedError = new IronSourceError(606, str);
            } else {
                buildLoadFailedError = ErrorBuilder.buildLoadFailedError(str);
            }
        } else {
            str = "Banner failed to load (loadAdError is null)";
            buildLoadFailedError = ErrorBuilder.buildLoadFailedError("Banner failed to load (loadAdError is null)");
        }
        IronLog.ADAPTER_CALLBACK.error(str + str);
        this.mListener.onBannerAdLoadFailed(buildLoadFailedError);
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdImpression() {
        IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + this.mAdUnitId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdShown();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + this.mAdUnitId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + this.mAdUnitId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenPresented();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + this.mAdUnitId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenDismissed();
        }
    }
}
