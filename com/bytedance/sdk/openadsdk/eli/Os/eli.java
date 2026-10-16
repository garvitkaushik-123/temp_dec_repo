package com.bytedance.sdk.openadsdk.eli.Os;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class eli implements PAGInterstitialAdLoadListener {
    private final PAGInterstitialAdLoadListener eli;

    public eli(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.eli = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
    public void onError(final int i, final String str) {
        if (this.eli == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.Os.eli.1
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.eli != null) {
                    eli.this.eli.onError(i, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGInterstitialAd pAGInterstitialAd) {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.Os.eli.2
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.eli != null) {
                    eli.this.eli.onAdLoaded(pAGInterstitialAd);
                }
            }
        });
    }
}
