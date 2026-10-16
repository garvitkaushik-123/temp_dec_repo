package com.unity3d.services.ads.operation.show;

import android.app.Activity;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class ShowOperationState extends OperationState {
    public WeakReference<Activity> activity;
    public IUnityAdsShowListener listener;
    public UnityAdsShowOptions showOptions;

    public ShowOperationState(String str, IUnityAdsShowListener iUnityAdsShowListener, Activity activity, UnityAdsShowOptions unityAdsShowOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsShowListener;
        this.activity = new WeakReference<>(activity);
        this.showOptions = unityAdsShowOptions;
    }

    public void onUnityAdsShowFailure(final UnityAds.UnityAdsShowError unityAdsShowError, final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperationState$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ShowOperationState.this.m9268xb9c9007a(unityAdsShowError, str);
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsShowFailure$0$com-unity3d-services-ads-operation-show-ShowOperationState, reason: not valid java name */
    /* synthetic */ void m9268xb9c9007a(UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        this.listener.onUnityAdsShowFailure(this.placementId, unityAdsShowError, str);
    }

    public void onUnityAdsShowClick() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperationState$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ShowOperationState.this.m9266x2e86f59b();
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsShowClick$1$com-unity3d-services-ads-operation-show-ShowOperationState, reason: not valid java name */
    /* synthetic */ void m9266x2e86f59b() {
        this.listener.onUnityAdsShowClick(this.placementId);
    }

    public void onUnityAdsShowStart(final String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperationState$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ShowOperationState.this.m9269xce119060(str);
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsShowStart$2$com-unity3d-services-ads-operation-show-ShowOperationState, reason: not valid java name */
    /* synthetic */ void m9269xce119060(String str) {
        this.listener.onUnityAdsShowStart(str);
    }

    public void onUnityAdsShowComplete(final UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.services.ads.operation.show.ShowOperationState$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ShowOperationState.this.m9267x43b2ea60(unityAdsShowCompletionState);
                }
            });
        }
    }

    /* renamed from: lambda$onUnityAdsShowComplete$3$com-unity3d-services-ads-operation-show-ShowOperationState, reason: not valid java name */
    /* synthetic */ void m9267x43b2ea60(UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        this.listener.onUnityAdsShowComplete(this.placementId, unityAdsShowCompletionState);
    }
}
