package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnUserEarnedRewardListener;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbxn extends zzbwx {
    private FullScreenContentCallback zza;
    private OnUserEarnedRewardListener zzb;

    public final void zzb(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
    }

    public final void zzc(OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzb = onUserEarnedRewardListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zze() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzf() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzg() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzh(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzeVar.zza());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzj() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzk(zzbws zzbwsVar) {
        OnUserEarnedRewardListener onUserEarnedRewardListener = this.zzb;
        if (onUserEarnedRewardListener != null) {
            onUserEarnedRewardListener.onUserEarnedReward(new zzbxf(zzbwsVar));
        }
    }
}
