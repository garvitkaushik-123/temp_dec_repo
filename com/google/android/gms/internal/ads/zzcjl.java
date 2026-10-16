package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcjl implements zzfbu {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    final zzhha zzg;
    final zzhha zzh;
    private final zzcio zzi;

    zzcjl(zzcio zzcioVar, Context context, String str) {
        this.zzi = zzcioVar;
        zzhgr zza = zzhgs.zza(context);
        this.zza = zza;
        zzhha zzhhaVar = zzcioVar.zzbh;
        zzezu zzc = zzezu.zzc(zza, zzhhaVar, zzcioVar.zzbi);
        this.zzb = zzc;
        zzhha zzc2 = zzhgq.zzc(zzfbe.zza(zzhhaVar));
        this.zzc = zzc2;
        zzhha zzc3 = zzhgq.zzc(zzfct.zza());
        this.zzd = zzc3;
        zzhha zzc4 = zzhgq.zzc(zzfbo.zza(zza, zzcioVar.zza, zzcioVar.zzS, zzc, zzc2, zzfcy.zza(), zzc3));
        this.zze = zzc4;
        this.zzf = zzhgq.zzc(zzfby.zza(zzc4, zzc2, zzc3));
        zzhgr zzc5 = zzhgs.zzc(str);
        this.zzg = zzc5;
        this.zzh = zzhgq.zzc(zzfbs.zza(zzc5, zzc4, zza, zzc2, zzc3, zzcioVar.zzi, zzcioVar.zzU, zzcioVar.zzl));
    }

    @Override // com.google.android.gms.internal.ads.zzfbu
    public final zzfbr zza() {
        return (zzfbr) this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfbu
    public final zzfbx zzb() {
        return (zzfbx) this.zzf.zzb();
    }
}
