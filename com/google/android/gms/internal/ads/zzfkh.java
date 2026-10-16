package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfkh extends com.google.android.gms.ads.internal.client.zzbm {
    final /* synthetic */ zzgeh zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzbx zzb;
    final /* synthetic */ zzfki zzc;

    zzfkh(zzfki zzfkiVar, zzgeh zzgehVar, com.google.android.gms.ads.internal.client.zzbx zzbxVar) {
        this.zza = zzgehVar;
        this.zzb = zzbxVar;
        Objects.requireNonNull(zzfkiVar);
        this.zzc = zzfkiVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String adError = zzeVar.zzb().toString();
        zzfki zzfkiVar = this.zzc;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to load interstitial ad with error: " + adError + " for ad unit: " + zzfkiVar.zze.zza);
        Objects.requireNonNull(zzfkiVar);
        zzfkiVar.zzL(zzeVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzc() {
        Objects.requireNonNull(this.zzc);
        zzfkb.zza(this.zzb, this.zza);
    }
}
