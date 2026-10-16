package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbtf extends zzbic {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbtf(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbid
    public final void zze(zzbij zzbijVar) {
        this.zza.onNativeAdLoaded(new zzbsz(zzbijVar));
    }
}
