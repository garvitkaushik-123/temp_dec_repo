package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class FC implements com.bytedance.sdk.openadsdk.eli.ui.eli {
    private final PAGRewardedAdInteractionCallback DbA;
    private final AtomicBoolean Os;
    private final AtomicBoolean aGH;
    private final PAGRewardedAdInteractionListener eli;
    private final AtomicBoolean ui;

    public FC(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.Os = new AtomicBoolean(false);
        this.aGH = new AtomicBoolean(false);
        this.ui = new AtomicBoolean(false);
        this.eli = pAGRewardedAdInteractionListener;
        this.DbA = null;
    }

    public FC(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.Os = new AtomicBoolean(false);
        this.aGH = new AtomicBoolean(false);
        this.ui = new AtomicBoolean(false);
        this.DbA = pAGRewardedAdInteractionCallback;
        this.eli = null;
    }

    @Override // com.bytedance.sdk.openadsdk.eli.ui.eli
    public void eli() {
        if (this.Os.compareAndSet(false, true)) {
            PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.eli;
            if (pAGRewardedAdInteractionListener != null) {
                pAGRewardedAdInteractionListener.onAdShowed();
                return;
            }
            PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.DbA;
            if (pAGRewardedAdInteractionCallback != null) {
                pAGRewardedAdInteractionCallback.onAdShowed();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.eli;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdClicked();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.DbA;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.eli.ui.eli
    public void DbA() {
        if (this.aGH.compareAndSet(false, true)) {
            PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.eli;
            if (pAGRewardedAdInteractionListener != null) {
                pAGRewardedAdInteractionListener.onAdDismissed();
                return;
            }
            PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.DbA;
            if (pAGRewardedAdInteractionCallback != null) {
                pAGRewardedAdInteractionCallback.onAdDismissed();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.eli.ui.eli
    public void eli(boolean z, int i, String str, int i2, String str2) {
        if (this.ui.compareAndSet(false, true)) {
            PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.eli;
            if (pAGRewardedAdInteractionListener != null) {
                if (z) {
                    pAGRewardedAdInteractionListener.onUserEarnedReward(new PAGRewardItem(i, str));
                    return;
                } else {
                    pAGRewardedAdInteractionListener.onUserEarnedRewardFail(i2, str2);
                    return;
                }
            }
            PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.DbA;
            if (pAGRewardedAdInteractionCallback != null) {
                if (z) {
                    pAGRewardedAdInteractionCallback.onUserEarnedReward(new PAGRewardItem(i, str));
                } else {
                    pAGRewardedAdInteractionCallback.onUserEarnedRewardFail(new PAGErrorModel(i2, str2));
                }
            }
        }
    }
}
