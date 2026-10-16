package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbyd {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    zzbyd(Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbyo zzbyoVar) {
        this.zza = zzgVar;
    }

    public final void zza(int i, long j) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaI)).booleanValue()) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zza;
        if (j - zzgVar.zzf() < 0) {
            com.google.android.gms.ads.internal.util.zze.zza("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaJ)).booleanValue()) {
            zzgVar.zzH(i);
            zzgVar.zzI(j);
        } else {
            zzgVar.zzH(-1);
            zzgVar.zzI(j);
        }
    }
}
