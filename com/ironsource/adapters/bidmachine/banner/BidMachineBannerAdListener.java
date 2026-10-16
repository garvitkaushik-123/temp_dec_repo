package com.ironsource.adapters.bidmachine.banner;

import android.widget.FrameLayout;
import com.ironsource.C3355vf;
import com.ironsource.adapters.bidmachine.BidMachineAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import io.bidmachine.banner.BannerListener;
import io.bidmachine.banner.BannerView;
import io.bidmachine.utils.BMError;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BidMachineBannerAdListener.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ironsource/adapters/bidmachine/banner/BidMachineBannerAdListener;", "Lio/bidmachine/banner/BannerListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/bidmachine/banner/BidMachineBannerAdapter;", "mLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "(Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;Ljava/lang/ref/WeakReference;Landroid/widget/FrameLayout$LayoutParams;)V", C3355vf.f, "", "ad", "Lio/bidmachine/banner/BannerView;", "onAdExpired", "onAdImpression", C3355vf.b, "error", "Lio/bidmachine/utils/BMError;", C3355vf.j, C3355vf.e, "bidmachineadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BidMachineBannerAdListener implements BannerListener {
    private final WeakReference<BidMachineBannerAdapter> mAdapter;
    private final FrameLayout.LayoutParams mLayoutParams;
    private final BannerSmashListener mListener;

    public BidMachineBannerAdListener(BannerSmashListener mListener, WeakReference<BidMachineBannerAdapter> mAdapter, FrameLayout.LayoutParams mLayoutParams) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        Intrinsics.checkNotNullParameter(mAdapter, "mAdapter");
        Intrinsics.checkNotNullParameter(mLayoutParams, "mLayoutParams");
        this.mListener = mListener;
        this.mAdapter = mAdapter;
        this.mLayoutParams = mLayoutParams;
    }

    @Override // io.bidmachine.AdListener
    public void onAdLoaded(BannerView ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        BidMachineBannerAdapter bidMachineBannerAdapter = this.mAdapter.get();
        if (bidMachineBannerAdapter != null) {
            bidMachineBannerAdapter.setBannerView$bidmachineadapter_release(ad);
        }
        this.mListener.onBannerAdLoaded(ad, this.mLayoutParams);
    }

    @Override // io.bidmachine.AdListener
    public void onAdLoadFailed(BannerView ad, BMError error) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load, errorCode = " + error.getCode() + ", errorMessage = " + error.getMessage());
        this.mListener.onBannerAdLoadFailed(BidMachineAdapter.INSTANCE.getLoadErrorAndCheckNoFill(error, 606));
    }

    @Override // io.bidmachine.AdListener
    public void onAdImpression(BannerView ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onBannerAdShown();
    }

    @Override // io.bidmachine.AdListener
    public void onAdShowFailed(BannerView ad, BMError error) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to show, errorCode = " + error.getCode() + ", errorMessage = " + error.getMessage());
    }

    @Override // io.bidmachine.AdListener
    public void onAdClicked(BannerView ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onBannerAdClicked();
    }

    @Override // io.bidmachine.AdListener
    public void onAdExpired(BannerView ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
    }
}
