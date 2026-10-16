package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdum extends zzbmg {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfhj zzd;
    final /* synthetic */ zzcak zze;
    final /* synthetic */ zzdun zzf;

    zzdum(zzdun zzdunVar, Object obj, String str, long j, zzfhj zzfhjVar, zzcak zzcakVar) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfhjVar;
        this.zze = zzcakVar;
        Objects.requireNonNull(zzdunVar);
        this.zzf = zzdunVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zze(String str) {
        zzdsu zzdsuVar;
        zzddc zzddcVar;
        zzfhx zzfhxVar;
        synchronized (this.zza) {
            zzdun zzdunVar = this.zzf;
            String str2 = this.zzb;
            zzdunVar.zzv(str2, false, str, (int) (com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - this.zzc));
            zzdsuVar = zzdunVar.zzl;
            zzdsuVar.zzb(str2, "error");
            zzddcVar = zzdunVar.zzo;
            zzddcVar.zzb(str2, "error");
            zzfhxVar = zzdunVar.zzp;
            zzfhj zzfhjVar = this.zzd;
            zzfhjVar.zzc(str);
            zzfhjVar.zzg(false);
            zzfhxVar.zzc(zzfhjVar.zzm());
            this.zze.zzc(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbmh
    public final void zzf() {
        zzdsu zzdsuVar;
        zzddc zzddcVar;
        zzfhx zzfhxVar;
        synchronized (this.zza) {
            zzdun zzdunVar = this.zzf;
            String str = this.zzb;
            zzdunVar.zzv(str, true, "", (int) (com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - this.zzc));
            zzdsuVar = zzdunVar.zzl;
            zzdsuVar.zzd(str);
            zzddcVar = zzdunVar.zzo;
            zzddcVar.zzd(str);
            zzfhxVar = zzdunVar.zzp;
            zzfhj zzfhjVar = this.zzd;
            zzfhjVar.zzg(true);
            zzfhxVar.zzc(zzfhjVar.zzm());
            this.zze.zzc(true);
        }
    }
}
