package com.bytedance.sdk.openadsdk.eli.DbA;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class ui implements PAGNativeAdLoadListener {
    private final PAGNativeAdLoadListener eli;

    public ui(PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        this.eli = pAGNativeAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
    public void onError(final int i, final String str) {
        if (this.eli == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.ui.1
            @Override // java.lang.Runnable
            public void run() {
                if (ui.this.eli != null) {
                    ui.this.eli.onError(i, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* renamed from: eli, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGNativeAd pAGNativeAd) {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.DbA.ui.2
            @Override // java.lang.Runnable
            public void run() {
                if (ui.this.eli != null) {
                    ui.this.eli.onAdLoaded(pAGNativeAd);
                }
            }
        });
    }
}
