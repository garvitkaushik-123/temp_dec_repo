package com.bytedance.sdk.openadsdk.api.open;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.common.ui;

/* loaded from: classes3.dex */
public abstract class PAGAppOpenAd implements PAGClientBidding, PangleAd {
    public abstract void setAdInteractionCallback(PAGAppOpenAdInteractionCallback pAGAppOpenAdInteractionCallback);

    public abstract void setAdInteractionListener(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener);

    public abstract void show(Activity activity);

    public static void loadAd(String str, PAGAppOpenRequest pAGAppOpenRequest, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
        ISDKTypeFactory eli = ui.eli(pAGAppOpenAdLoadListener);
        if (eli != null) {
            eli.createADTypeLoaderFactory(str).createOpenAdLoader().loadAd(str, pAGAppOpenRequest, pAGAppOpenAdLoadListener);
        }
    }

    public static void loadAd(String str, PAGAppOpenRequest pAGAppOpenRequest, final PAGAppOpenAdLoadCallback pAGAppOpenAdLoadCallback) {
        loadAd(str, pAGAppOpenRequest, new PAGAppOpenAdLoadListener() { // from class: com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
            public void onError(int i, String str2) {
                PAGAppOpenAdLoadCallback.this.onError(new PAGErrorModel(i, str2));
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGAppOpenAd pAGAppOpenAd) {
                PAGAppOpenAdLoadCallback.this.onAdLoaded(pAGAppOpenAd);
            }
        });
    }
}
