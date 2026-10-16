package com.ironsource.adapters.applovin;

import android.widget.FrameLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class AppLovinBannerListener implements AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {
    private final WeakReference<AppLovinAdapter> mAdapter;
    private final FrameLayout.LayoutParams mBannerLayout;
    private final BannerSmashListener mListener;
    private final String mZoneId;

    public AppLovinBannerListener(AppLovinAdapter appLovinAdapter, BannerSmashListener bannerSmashListener, String str, FrameLayout.LayoutParams layoutParams) {
        this.mAdapter = new WeakReference<>(appLovinAdapter);
        this.mZoneId = str;
        this.mListener = bannerSmashListener;
        this.mBannerLayout = layoutParams;
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(final AppLovinAd appLovinAd) {
        IronLog.ADAPTER_CALLBACK.verbose("zoneId = " + this.mZoneId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        if (this.mAdapter.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        if (this.mBannerLayout == null) {
            IronLog.INTERNAL.verbose("banner layout is null");
            return;
        }
        final AppLovinAdView appLovinAdView = this.mAdapter.get().mZoneIdToBannerAd.get(this.mZoneId);
        if (appLovinAdView == null) {
            IronLog.INTERNAL.verbose("adView is null");
        } else {
            AppLovinAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.applovin.AppLovinBannerListener.1
                @Override // java.lang.Runnable
                public void run() {
                    appLovinAdView.renderAd(appLovinAd);
                    AppLovinBannerListener.this.mListener.onBannerAdLoaded(appLovinAdView, AppLovinBannerListener.this.mBannerLayout);
                }
            });
        }
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        IronLog.ADAPTER_CALLBACK.verbose("zoneId = " + this.mZoneId + ", errorCode = " + i);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else if (this.mAdapter.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mListener.onBannerAdLoadFailed(new IronSourceError(i == 204 ? 606 : i, this.mAdapter.get().getErrorString(i)));
        }
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        IronLog.ADAPTER_CALLBACK.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdShown();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        IronLog.ADAPTER_CALLBACK.verbose("zoneId = " + this.mZoneId);
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        IronLog.ADAPTER_CALLBACK.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        IronLog.ADAPTER_CALLBACK.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenPresented();
        }
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        IronLog.ADAPTER_CALLBACK.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenDismissed();
        }
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        IronLog.ADAPTER_CALLBACK.verbose("zoneId = " + this.mZoneId);
    }

    @Override // com.applovin.adview.AppLovinAdViewEventListener
    public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        IronLog.ADAPTER_CALLBACK.verbose("zoneId = " + this.mZoneId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdLeftApplication();
        }
    }
}
