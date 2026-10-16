package com.ironsource.adapters.pangle;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.ironsource.C3355vf;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PangleInterstitialAdListener.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ironsource/adapters/pangle/PangleInterstitialAdListener;", "Lcom/bytedance/sdk/openadsdk/api/interstitial/PAGInterstitialAdLoadListener;", "Lcom/bytedance/sdk/openadsdk/api/interstitial/PAGInterstitialAdInteractionListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/pangle/PangleAdapter;", "mSlotId", "", "(Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", C3355vf.f, "", "onAdDismissed", C3355vf.j, "interstitialAd", "Lcom/bytedance/sdk/openadsdk/api/interstitial/PAGInterstitialAd;", "onAdShowed", "onError", "code", "", PglCryptUtils.KEY_MESSAGE, "pangleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PangleInterstitialAdListener implements PAGInterstitialAdLoadListener, PAGInterstitialAdInteractionListener {
    private final WeakReference<PangleAdapter> mAdapter;
    private final InterstitialSmashListener mListener;
    private final String mSlotId;

    public PangleInterstitialAdListener(InterstitialSmashListener interstitialSmashListener, WeakReference<PangleAdapter> weakReference, String mSlotId) {
        Intrinsics.checkNotNullParameter(mSlotId, "mSlotId");
        this.mListener = interstitialSmashListener;
        this.mAdapter = weakReference;
        this.mSlotId = mSlotId;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    public void onAdLoaded(PAGInterstitialAd interstitialAd) {
        PangleAdapter pangleAdapter;
        PangleAdapter pangleAdapter2;
        Intrinsics.checkNotNullParameter(interstitialAd, "interstitialAd");
        IronLog.ADAPTER_CALLBACK.verbose("slotId = " + this.mSlotId);
        WeakReference<PangleAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (pangleAdapter2 = weakReference.get()) != null) {
            pangleAdapter2.setInterstitialAd$pangleadapter_release(this.mSlotId, interstitialAd);
        }
        WeakReference<PangleAdapter> weakReference2 = this.mAdapter;
        if (weakReference2 != null && (pangleAdapter = weakReference2.get()) != null) {
            pangleAdapter.setInterstitialAdAvailability$pangleadapter_release(this.mSlotId, true);
        }
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdReady();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
    public void onError(int code, String message) {
        PangleAdapter pangleAdapter;
        Intrinsics.checkNotNullParameter(message, "message");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load slotId = " + this.mSlotId + ", error code = " + code + ", message = " + message);
        WeakReference<PangleAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (pangleAdapter = weakReference.get()) != null) {
            pangleAdapter.setInterstitialAdAvailability$pangleadapter_release(this.mSlotId, false);
        }
        if (code == 20001) {
            code = 1158;
        }
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(code, message));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdShowed() {
        IronLog.ADAPTER_CALLBACK.verbose("slotId = " + this.mSlotId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdOpened();
        }
        InterstitialSmashListener interstitialSmashListener2 = this.mListener;
        if (interstitialSmashListener2 != null) {
            interstitialSmashListener2.onInterstitialAdShowSucceeded();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose("slotId = " + this.mSlotId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdDismissed() {
        IronLog.ADAPTER_CALLBACK.verbose("slotId = " + this.mSlotId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdClosed();
        }
    }
}
