package com.unity3d.ads;

import com.unity3d.ads.UnityAds;

/* loaded from: classes5.dex */
public interface IUnityAdsInitializationListener {
    void onInitializationComplete();

    void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str);
}
