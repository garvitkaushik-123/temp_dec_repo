package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzciy implements zzeyp {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    private final Context zzg;
    private final com.google.android.gms.ads.internal.client.zzr zzh;
    private final String zzi;
    private final zzcio zzj;

    zzciy(zzcio zzcioVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzj = zzcioVar;
        this.zzg = context;
        this.zzh = zzrVar;
        this.zzi = str;
        zzhgr zza = zzhgs.zza(context);
        this.zza = zza;
        zzhgr zza2 = zzhgs.zza(zzrVar);
        this.zzb = zza2;
        zzhha zzc = zzhgq.zzc(zzekz.zza(zzcioVar.zzl));
        this.zzc = zzc;
        zzhha zzc2 = zzhgq.zzc(zzele.zza());
        this.zzd = zzc2;
        zzhha zzc3 = zzhgq.zzc(zzdbd.zza());
        this.zze = zzc3;
        this.zzf = zzhgq.zzc(zzeyn.zza(zza, zzcioVar.zza, zza2, zzcioVar.zzS, zzc, zzc2, zzfcy.zza(), zzc3));
    }

    @Override // com.google.android.gms.internal.ads.zzeyp
    public final zzeke zza() {
        zzchh zzchhVar;
        zzeym zzeymVar = (zzeym) this.zzf.zzb();
        zzeky zzekyVar = (zzeky) this.zzc.zzb();
        zzcio zzcioVar = this.zzj;
        zzchhVar = zzcioVar.zzbp;
        return new zzeke(this.zzg, this.zzh, this.zzi, zzeymVar, zzekyVar, zzchz.zzc(zzchhVar), (zzdsj) zzcioVar.zzl.zzb());
    }
}
