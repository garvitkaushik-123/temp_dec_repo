package com.bytedance.sdk.openadsdk.eli.DbA;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class kb implements MGA {
    private final PAGNativeAdInteractionListener eli;

    public kb(PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        this.eli = pAGNativeAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.kb.1
            @Override // java.lang.Runnable
            public void run() {
                if (kb.this.eli != null) {
                    kb.this.eli.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.eli.DbA.MGA
    public void eli(PAGNativeAd pAGNativeAd) {
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.kb.2
            @Override // java.lang.Runnable
            public void run() {
                if (kb.this.eli != null) {
                    kb.this.eli.onAdShowed();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.eli.DbA.MGA
    public void eli() {
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.kb.3
            @Override // java.lang.Runnable
            public void run() {
                if (kb.this.eli != null) {
                    kb.this.eli.onAdDismissed();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.eli.DbA.MGA
    public boolean DbA() {
        return this.eli != null;
    }
}
