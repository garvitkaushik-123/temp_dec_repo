package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdhh implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;
    private final zzhha zzf;

    private zzdhh(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
        this.zzf = zzhhaVar6;
    }

    public static zzdhh zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5, zzhha zzhhaVar6) {
        return new zzdhh(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5, zzhhaVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzche zzcheVar = (zzche) this.zza.zzb();
        zzcvf zza = ((zzcvq) this.zzb).zza();
        zzdbw zza2 = ((zzdcr) this.zzc).zza();
        zzdgw zza3 = ((zzdgy) this.zzd).zza();
        zzcyv zzb = ((zzcor) this.zze).zzb();
        zzehb zzehbVar = (zzehb) this.zzf.zzb();
        zzcpw zzd = zzcheVar.zzd();
        zzd.zzi(zza.zzl());
        zzd.zzf(zza2);
        zzd.zzd(zza3);
        zzd.zze(new zzejh(null));
        zzd.zzg(new zzcqs(zzb, null));
        zzd.zzc(new zzcop(null));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdU)).booleanValue()) {
            zzd.zzj(zzehk.zzb(zzehbVar));
        }
        zzcrd zzb2 = zzd.zzh().zzb();
        zzhgz.zzb(zzb2);
        return zzb2;
    }
}
