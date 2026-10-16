package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbtd {
    private final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;
    private final NativeCustomFormatAd.OnCustomClickListener zzb;
    private NativeCustomFormatAd zzc;

    public zzbtd(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomFormatAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized NativeCustomFormatAd zzf(zzbhj zzbhjVar) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzbte zzbteVar = new zzbte(zzbhjVar);
        this.zzc = zzbteVar;
        return zzbteVar;
    }

    public final zzbht zza() {
        zzbtc zzbtcVar = null;
        if (this.zzb == null) {
            return null;
        }
        return new zzbta(this, zzbtcVar);
    }

    public final zzbhw zzb() {
        return new zzbtb(this, null);
    }
}
