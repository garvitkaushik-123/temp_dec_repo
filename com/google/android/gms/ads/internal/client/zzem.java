package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
final class zzem extends zzbc {
    final /* synthetic */ zzen zza;

    zzem(zzen zzenVar) {
        Objects.requireNonNull(zzenVar);
        this.zza = zzenVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbc, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        VideoController videoController;
        zzen zzenVar = this.zza;
        videoController = zzenVar.zze;
        videoController.zzb(zzenVar.zzj());
        super.onAdFailedToLoad(loadAdError);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbc, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        VideoController videoController;
        zzen zzenVar = this.zza;
        videoController = zzenVar.zze;
        videoController.zzb(zzenVar.zzj());
        super.onAdLoaded();
    }
}
