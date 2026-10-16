package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcit implements zzexb {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    private final zzcio zzg;

    zzcit(zzcio zzcioVar, Context context, String str) {
        this.zzg = zzcioVar;
        zzhgr zza = zzhgs.zza(context);
        this.zza = zza;
        zzhgr zza2 = zzhgs.zza(str);
        this.zzb = zza2;
        zzhha zzhhaVar = zzcioVar.zzbh;
        zzezt zzc = zzezt.zzc(zza, zzhhaVar, zzcioVar.zzbi);
        this.zzc = zzc;
        zzhha zzc2 = zzhgq.zzc(zzexz.zza(zzhhaVar));
        this.zzd = zzc2;
        zzhha zzhhaVar2 = zzcioVar.zza;
        zzhha zzhhaVar3 = zzcioVar.zzS;
        zzfcy zza3 = zzfcy.zza();
        zzhha zzhhaVar4 = zzcioVar.zzi;
        zzhha zzc3 = zzhgq.zzc(zzeyb.zza(zza, zzhhaVar2, zzhhaVar3, zzc, zzc2, zza3, zzhhaVar4));
        this.zze = zzc3;
        this.zzf = zzhgq.zzc(zzeyh.zza(zzhhaVar3, zza, zza2, zzc3, zzc2, zzhhaVar4, zzcioVar.zzl));
    }

    @Override // com.google.android.gms.internal.ads.zzexb
    public final zzeyg zza() {
        return (zzeyg) this.zzf.zzb();
    }
}
