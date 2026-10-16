package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdwa extends RewardedAdLoadCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdwf zzb;

    zzdwa(zzdwf zzdwfVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzdwfVar);
        this.zzb = zzdwfVar;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        String zzk;
        zzdwf zzdwfVar = this.zzb;
        zzk = zzdwf.zzk(loadAdError);
        zzdwfVar.zzl(zzk);
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void onAdLoaded(RewardedAd rewardedAd) {
        this.zzb.zzg(this.zza, rewardedAd);
    }
}
