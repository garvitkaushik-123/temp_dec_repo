package com.bytedance.sdk.openadsdk.eli.ui;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class DbA implements PAGRewardedAdLoadListener {
    private final PAGRewardedAdLoadListener eli;

    public DbA(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.eli = pAGRewardedAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
    public void onError(final int i, final String str) {
        if (this.eli == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.ui.DbA.1
            @Override // java.lang.Runnable
            public void run() {
                if (DbA.this.eli != null) {
                    DbA.this.eli.onError(i, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGRewardedAd pAGRewardedAd) {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.ui.DbA.2
            @Override // java.lang.Runnable
            public void run() {
                if (DbA.this.eli != null) {
                    DbA.this.eli.onAdLoaded(pAGRewardedAd);
                }
            }
        });
    }
}
