package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class kb implements PAGRewardedAdLoadListener {
    final PAGRewardedAdLoadListener eli;

    public kb(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.eli = pAGRewardedAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
    public void onError(final int i, final String str) {
        if (this.eli != null) {
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.kb.1
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.eli != null) {
                        kb.this.eli.onError(i, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGRewardedAd pAGRewardedAd) {
        if (this.eli != null) {
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.kb.2
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.eli != null) {
                        kb.this.eli.onAdLoaded(pAGRewardedAd);
                    }
                }
            });
        }
    }
}
