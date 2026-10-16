package com.bytedance.sdk.openadsdk.component.Os;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class eli implements com.bytedance.sdk.openadsdk.eli.Os.DbA {
    private final AtomicBoolean DbA = new AtomicBoolean(false);
    private final AtomicBoolean Os = new AtomicBoolean(false);
    private final PAGInterstitialAdInteractionListener eli;

    public eli(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.eli = pAGInterstitialAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.eli.Os.DbA
    public void eli() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener;
        if (this.DbA.compareAndSet(false, true) && (pAGInterstitialAdInteractionListener = this.eli) != null) {
            pAGInterstitialAdInteractionListener.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.eli.Os.DbA
    public void DbA() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener;
        if (this.Os.compareAndSet(false, true) && (pAGInterstitialAdInteractionListener = this.eli) != null) {
            pAGInterstitialAdInteractionListener.onAdDismissed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener = this.eli;
        if (pAGInterstitialAdInteractionListener != null) {
            pAGInterstitialAdInteractionListener.onAdClicked();
        }
    }
}
