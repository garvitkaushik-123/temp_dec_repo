package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.PAGClientBidding;
import com.bytedance.sdk.openadsdk.api.PangleAd;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.common.ui;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class PAGNativeAd implements PAGClientBidding, PangleAd {
    public abstract PAGNativeAdData getNativeAdData();

    public abstract void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionCallback pAGNativeAdInteractionCallback);

    public abstract void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener);

    public abstract void showPrivacyActivity();

    public static void loadAd(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
        ISDKTypeFactory eli = ui.eli(pAGNativeAdLoadListener);
        if (eli != null) {
            eli.createADTypeLoaderFactory(str).createNativeAdLoader().loadAd(str, pAGNativeRequest, pAGNativeAdLoadListener);
        }
    }

    public static void loadAd(String str, PAGNativeRequest pAGNativeRequest, final PAGNativeAdLoadCallback pAGNativeAdLoadCallback) {
        loadAd(str, pAGNativeRequest, new PAGNativeAdLoadListener() { // from class: com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.MGA
            public void onError(int i, String str2) {
                PAGNativeAdLoadCallback.this.onError(new PAGErrorModel(i, str2));
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
            public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                PAGNativeAdLoadCallback.this.onAdLoaded(pAGNativeAd);
            }
        });
    }
}
