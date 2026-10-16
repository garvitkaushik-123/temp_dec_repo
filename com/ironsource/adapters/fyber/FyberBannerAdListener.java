package com.ironsource.adapters.fyber;

import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class FyberBannerAdListener implements InneractiveAdSpot.RequestListener, InneractiveAdViewEventsListener {
    private WeakReference<FyberAdapter> mAdapter;
    private BannerSmashListener mListener;
    private String mSpotId;

    FyberBannerAdListener(FyberAdapter fyberAdapter, BannerSmashListener bannerSmashListener, String str) {
        this.mAdapter = new WeakReference<>(fyberAdapter);
        this.mListener = bannerSmashListener;
        this.mSpotId = str;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FyberAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        if (!inneractiveAdSpot.isReady()) {
            this.mListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError(this.mAdapter.get().getProviderName() + " banner failed to load, Spot not ready - " + this.mSpotId));
            return;
        }
        IronSourceBannerLayout ironSourceBannerLayout = this.mAdapter.get().mSpotIdToBannerLayout.get(this.mSpotId);
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            this.mListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Fyber loadBanner - banner ".concat(ironSourceBannerLayout == null ? "layout is null" : "is destroyed")));
            return;
        }
        FrameLayout.LayoutParams calculateLayoutParams = this.mAdapter.get().calculateLayoutParams(ironSourceBannerLayout.getSize());
        if (calculateLayoutParams == null) {
            this.mListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize("Fyber - size = " + ironSourceBannerLayout.getSize()));
            return;
        }
        FrameLayout frameLayout = new FrameLayout(ContextProvider.getInstance().getApplicationContext());
        this.mAdapter.get().mInneractiveAdViewUnitController.bindView(frameLayout);
        this.mListener.onBannerAdLoaded(frameLayout, calculateLayoutParams);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
        IronSourceError buildLoadFailedError;
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        if (inneractiveErrorCode == null) {
            buildLoadFailedError = ErrorBuilder.buildLoadFailedError("Banner failed to load (inneractiveErrorCode is null)");
        } else {
            IronLog.ADAPTER_CALLBACK.verbose("inneractiveErrorCode = " + inneractiveErrorCode);
            if (inneractiveErrorCode == InneractiveErrorCode.NO_FILL) {
                buildLoadFailedError = new IronSourceError(606, inneractiveErrorCode.toString());
            } else {
                buildLoadFailedError = ErrorBuilder.buildLoadFailedError(inneractiveErrorCode.toString());
            }
        }
        this.mListener.onBannerAdLoadFailed(buildLoadFailedError);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdShown();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenDismissed();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdLeftApplication();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
    public void onAdExpanded(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
    public void onAdResized(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
    public void onAdCollapsed(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
    }
}
