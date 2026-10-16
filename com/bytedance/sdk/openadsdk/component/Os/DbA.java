package com.bytedance.sdk.openadsdk.component.Os;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class DbA implements PAGInterstitialAdLoadListener {
    final PAGInterstitialAdLoadListener eli;

    public DbA(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.eli = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
    public void onError(final int i, final String str) {
        if (this.eli != null) {
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.Os.DbA.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DbA.this.eli != null) {
                        DbA.this.eli.onError(i, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGInterstitialAd pAGInterstitialAd) {
        if (this.eli != null) {
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.Os.DbA.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DbA.this.eli != null) {
                        DbA.this.eli.onAdLoaded(pAGInterstitialAd);
                    }
                }
            });
        }
    }
}
