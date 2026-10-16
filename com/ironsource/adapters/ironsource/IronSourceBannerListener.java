package com.ironsource.adapters.ironsource;

import android.widget.FrameLayout;
import com.ironsource.B9;
import com.ironsource.C3044d8;
import com.ironsource.C3078f8;
import com.ironsource.InterfaceC3284rc;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
class IronSourceBannerListener implements InterfaceC3284rc {
    private WeakReference<IronSourceAdapter> mAdapter;
    private final String mDemandSourceName;
    private final BannerSmashListener mListener;

    IronSourceBannerListener(IronSourceAdapter ironSourceAdapter, BannerSmashListener bannerSmashListener, String str) {
        this.mDemandSourceName = str;
        this.mListener = bannerSmashListener;
        this.mAdapter = new WeakReference<>(ironSourceAdapter);
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerClick() {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " bannerListener");
        this.mListener.onBannerAdClicked();
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerInitFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " bannerListener");
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " bannerListener");
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerLoadFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " bannerListener");
        this.mListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("load failed - error = " + str));
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerLoadSuccess(B9 b9, C3078f8 c3078f8) {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " bannerListener");
        if (this.mAdapter.get() != null) {
            if (c3078f8 == null) {
                this.mListener.onBannerAdLoadFailed(ErrorBuilder.adContainerIsNull(this.mAdapter.get().getProviderName()));
                return;
            }
            ConcurrentHashMap<String, ArrayList<B9>> concurrentHashMap = this.mAdapter.get().mDemandSourceToBnAd;
            if (concurrentHashMap.get(this.mDemandSourceName) == null) {
                concurrentHashMap.put(this.mDemandSourceName, new ArrayList<>());
            }
            concurrentHashMap.get(this.mDemandSourceName).add(b9);
            C3044d8 size = c3078f8.getSize();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(size.c(), size.a());
            layoutParams.gravity = 17;
            this.mListener.onBannerAdLoaded(c3078f8, layoutParams);
        }
    }

    @Override // com.ironsource.InterfaceC3284rc
    public void onBannerShowSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " onBannerShowSuccess");
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdShown();
        }
    }
}
