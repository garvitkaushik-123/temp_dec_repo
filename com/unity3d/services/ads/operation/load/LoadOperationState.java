package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;

/* loaded from: classes7.dex */
public class LoadOperationState extends OperationState {
    public IUnityAdsLoadListener listener;
    public UnityAdsLoadOptions loadOptions;

    public LoadOperationState(String str, IUnityAdsLoadListener iUnityAdsLoadListener, UnityAdsLoadOptions unityAdsLoadOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsLoadListener;
        this.loadOptions = unityAdsLoadOptions;
    }

    public void onUnityAdsFailedToLoad(final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadOperationState$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LoadOperationState.this.m9265x5da5719b(unityAdsLoadError, str);
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsFailedToLoad$0$com-unity3d-services-ads-operation-load-LoadOperationState, reason: not valid java name */
    /* synthetic */ void m9265x5da5719b(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        this.listener.onUnityAdsFailedToLoad(this.placementId, unityAdsLoadError, str);
    }

    public void onUnityAdsAdLoaded() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadOperationState$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LoadOperationState.this.m9264xadf8d050();
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsAdLoaded$1$com-unity3d-services-ads-operation-load-LoadOperationState, reason: not valid java name */
    /* synthetic */ void m9264xadf8d050() {
        this.listener.onUnityAdsAdLoaded(this.placementId);
    }

    public boolean isBanner() {
        return this instanceof LoadBannerOperationState;
    }

    public boolean isHeaderBidding() {
        UnityAdsLoadOptions unityAdsLoadOptions = this.loadOptions;
        if (unityAdsLoadOptions == null || unityAdsLoadOptions.getData() == null) {
            return false;
        }
        return this.loadOptions.getData().has("adMarkup");
    }
}
