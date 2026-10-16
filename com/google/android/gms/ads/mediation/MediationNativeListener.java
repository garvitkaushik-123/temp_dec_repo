package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.internal.ads.zzbhk;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface MediationNativeListener {
    void onAdClicked(MediationNativeAdapter mediationNativeAdapter);

    void onAdClosed(MediationNativeAdapter mediationNativeAdapter);

    @Deprecated
    void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i);

    void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, AdError adError);

    void onAdImpression(MediationNativeAdapter mediationNativeAdapter);

    void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter);

    void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper);

    void onAdOpened(MediationNativeAdapter mediationNativeAdapter);

    void onVideoEnd(MediationNativeAdapter mediationNativeAdapter);

    void zzd(MediationNativeAdapter mediationNativeAdapter, zzbhk zzbhkVar);

    void zze(MediationNativeAdapter mediationNativeAdapter, zzbhk zzbhkVar, String str);
}
