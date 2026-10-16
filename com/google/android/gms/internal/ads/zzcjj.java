package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcjj implements zzfag {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    final zzhha zzg;
    private final zzcio zzh;

    zzcjj(zzcio zzcioVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzh = zzcioVar;
        zzhgr zza = zzhgs.zza(context);
        this.zza = zza;
        zzhgr zza2 = zzhgs.zza(zzrVar);
        this.zzb = zza2;
        zzhgr zza3 = zzhgs.zza(str);
        this.zzc = zza3;
        zzhha zzhhaVar = zzcioVar.zzl;
        zzhha zzc = zzhgq.zzc(zzekz.zza(zzhhaVar));
        this.zzd = zzc;
        zzhha zzc2 = zzhgq.zzc(zzfbe.zza(zzcioVar.zzbh));
        this.zze = zzc2;
        zzhha zzc3 = zzhgq.zzc(zzfae.zza(zza, zzcioVar.zza, zzcioVar.zzS, zzc, zzc2, zzfcy.zza()));
        this.zzf = zzc3;
        this.zzg = zzhgq.zzc(zzelh.zza(zza, zza2, zza3, zzc3, zzc, zzc2, zzcioVar.zzi, zzcioVar.zzU, zzhhaVar));
    }

    @Override // com.google.android.gms.internal.ads.zzfag
    public final zzelg zza() {
        return (zzelg) this.zzg.zzb();
    }
}
