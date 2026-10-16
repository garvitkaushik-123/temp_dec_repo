package com.bytedance.sdk.openadsdk.eli.aGH;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.cyF;

/* loaded from: classes3.dex */
public class eli implements PAGAppOpenAdLoadListener {
    private final PAGAppOpenAdLoadListener eli;

    public eli(PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
        this.eli = pAGAppOpenAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
    public void onError(final int i, final String str) {
        if (this.eli == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.aGH.eli.1
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
    public void onAdLoaded(final PAGAppOpenAd pAGAppOpenAd) {
        if (this.eli == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.eli.aGH.eli.2
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.eli != null) {
                    eli.this.eli.onAdLoaded(pAGAppOpenAd);
                }
            }
        });
    }
}
