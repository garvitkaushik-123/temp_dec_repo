package com.ironsource.adapters.bidmachine.interstitial;

import com.ironsource.C3355vf;
import com.ironsource.adapters.bidmachine.BidMachineAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import io.bidmachine.interstitial.InterstitialAd;
import io.bidmachine.interstitial.InterstitialListener;
import io.bidmachine.utils.BMError;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BidMachineInterstitialAdListener.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ironsource/adapters/bidmachine/interstitial/BidMachineInterstitialAdListener;", "Lio/bidmachine/interstitial/InterstitialListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/bidmachine/interstitial/BidMachineInterstitialAdapter;", "mListener", "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "(Ljava/lang/ref/WeakReference;Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;)V", C3355vf.f, "", "InterstitialAd", "Lio/bidmachine/interstitial/InterstitialAd;", C3355vf.g, "finished", "", "onAdExpired", "onAdImpression", C3355vf.b, "bmError", "Lio/bidmachine/utils/BMError;", C3355vf.j, C3355vf.e, "bidmachineadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BidMachineInterstitialAdListener implements InterstitialListener {
    private final WeakReference<BidMachineInterstitialAdapter> mAdapter;
    private final InterstitialSmashListener mListener;

    public BidMachineInterstitialAdListener(WeakReference<BidMachineInterstitialAdapter> mAdapter, InterstitialSmashListener mListener) {
        Intrinsics.checkNotNullParameter(mAdapter, "mAdapter");
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        this.mAdapter = mAdapter;
        this.mListener = mListener;
    }

    @Override // io.bidmachine.AdListener
    public void onAdLoaded(InterstitialAd InterstitialAd) {
        Intrinsics.checkNotNullParameter(InterstitialAd, "InterstitialAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        BidMachineInterstitialAdapter bidMachineInterstitialAdapter = this.mAdapter.get();
        if (bidMachineInterstitialAdapter != null) {
            bidMachineInterstitialAdapter.setInterstitialAd$bidmachineadapter_release(InterstitialAd);
        }
        BidMachineInterstitialAdapter bidMachineInterstitialAdapter2 = this.mAdapter.get();
        if (bidMachineInterstitialAdapter2 != null) {
            bidMachineInterstitialAdapter2.setInterstitialAdAvailability$bidmachineadapter_release(true);
        }
        this.mListener.onInterstitialAdReady();
    }

    @Override // io.bidmachine.AdListener
    public void onAdLoadFailed(InterstitialAd InterstitialAd, BMError bmError) {
        Intrinsics.checkNotNullParameter(InterstitialAd, "InterstitialAd");
        Intrinsics.checkNotNullParameter(bmError, "bmError");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load, errorCode = " + bmError.getCode() + ", errorMessage = " + bmError.getMessage());
        BidMachineInterstitialAdapter bidMachineInterstitialAdapter = this.mAdapter.get();
        if (bidMachineInterstitialAdapter != null) {
            bidMachineInterstitialAdapter.setInterstitialAdAvailability$bidmachineadapter_release(false);
        }
        this.mListener.onInterstitialAdLoadFailed(BidMachineAdapter.INSTANCE.getLoadErrorAndCheckNoFill(bmError, 1158));
        BidMachineInterstitialAdapter bidMachineInterstitialAdapter2 = this.mAdapter.get();
        if (bidMachineInterstitialAdapter2 != null) {
            bidMachineInterstitialAdapter2.destroyInterstitialAd$bidmachineadapter_release();
        }
    }

    @Override // io.bidmachine.AdListener
    public void onAdImpression(InterstitialAd InterstitialAd) {
        Intrinsics.checkNotNullParameter(InterstitialAd, "InterstitialAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onInterstitialAdOpened();
        this.mListener.onInterstitialAdShowSucceeded();
    }

    @Override // io.bidmachine.AdListener
    public void onAdShowFailed(InterstitialAd InterstitialAd, BMError bmError) {
        Intrinsics.checkNotNullParameter(InterstitialAd, "InterstitialAd");
        Intrinsics.checkNotNullParameter(bmError, "bmError");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load, errorCode = " + bmError.getCode() + ", errorMessage = " + bmError.getMessage());
        this.mListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", bmError.getMessage()));
    }

    @Override // io.bidmachine.AdListener
    public void onAdClicked(InterstitialAd InterstitialAd) {
        Intrinsics.checkNotNullParameter(InterstitialAd, "InterstitialAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onInterstitialAdClicked();
    }

    @Override // io.bidmachine.AdFullScreenListener
    public void onAdClosed(InterstitialAd InterstitialAd, boolean finished) {
        Intrinsics.checkNotNullParameter(InterstitialAd, "InterstitialAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onInterstitialAdClosed();
        BidMachineInterstitialAdapter bidMachineInterstitialAdapter = this.mAdapter.get();
        if (bidMachineInterstitialAdapter != null) {
            bidMachineInterstitialAdapter.destroyInterstitialAd$bidmachineadapter_release();
        }
    }

    @Override // io.bidmachine.AdListener
    public void onAdExpired(InterstitialAd InterstitialAd) {
        Intrinsics.checkNotNullParameter(InterstitialAd, "InterstitialAd");
        IronLog.ADAPTER_CALLBACK.verbose();
    }
}
