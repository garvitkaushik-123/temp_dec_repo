package com.bytedance.sdk.openadsdk.eli.eli;

import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class eli implements PAGBannerAdLoadListener {
    private final PAGBannerAdLoadListener eli;

    public eli(PAGBannerAdLoadListener pAGBannerAdLoadListener) {
        this.eli = pAGBannerAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
    public void onError(final int i, final String str) {
        if (this.eli == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.eli.eli.1
            @Override // java.lang.Runnable
            public void run() {
                eli.this.eli.onError(i, str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGBannerAd pAGBannerAd) {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.eli.eli.2
            @Override // java.lang.Runnable
            public void run() {
                eli.this.eli.onAdLoaded(pAGBannerAd);
            }
        });
    }
}
