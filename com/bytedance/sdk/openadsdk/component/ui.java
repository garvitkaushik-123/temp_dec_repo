package com.bytedance.sdk.openadsdk.component;

import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class ui implements com.bytedance.sdk.openadsdk.eli.aGH.DbA {
    private final AtomicBoolean DbA = new AtomicBoolean(false);
    private final PAGAppOpenAdInteractionListener eli;

    public ui(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.eli = pAGAppOpenAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.eli.aGH.DbA
    public void eli() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.eli;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener = this.eli;
        if (pAGAppOpenAdInteractionListener != null) {
            pAGAppOpenAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.eli.aGH.DbA
    public void DbA() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (this.DbA.getAndSet(true) || (pAGAppOpenAdInteractionListener = this.eli) == null) {
            return;
        }
        pAGAppOpenAdInteractionListener.onAdDismissed();
    }

    @Override // com.bytedance.sdk.openadsdk.eli.aGH.DbA
    public void Os() {
        PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener;
        if (this.DbA.getAndSet(true) || (pAGAppOpenAdInteractionListener = this.eli) == null) {
            return;
        }
        pAGAppOpenAdInteractionListener.onAdDismissed();
    }
}
