package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbcj;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdqi implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;
    private final zzhha zze;

    private zzdqi(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
        this.zze = zzhhaVar5;
    }

    public static zzdqi zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        return new zzdqi(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza = ((zzchl) this.zza).zza();
        final String zzb = ((zzdxh) this.zzb).zzb();
        VersionInfoParcel zza2 = ((zzchz) this.zzc).zza();
        final zzbcj.zza.EnumC0215zza enumC0215zza = (zzbcj.zza.EnumC0215zza) this.zzd.zzb();
        final String str = (String) this.zze.zzb();
        zzbcc zzbccVar = new zzbcc(new zzbci(zza));
        zzbcj.zzar.zza zzd = zzbcj.zzar.zzd();
        zzd.zzg(zza2.buddyApkVersion);
        zzd.zzi(zza2.clientJarVersion);
        zzd.zzh(true != zza2.isClientJar ? 2 : 0);
        final zzbcj.zzar zzbr = zzd.zzbr();
        zzbccVar.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqh
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzbcj.zza.zzb zzbM = zzaVar.zze().zzbM();
                zzbM.zzH(zzbcj.zza.EnumC0215zza.this);
                zzaVar.zzG(zzbM);
                zzbcj.zzm.zza zzbM2 = zzaVar.zzg().zzbM();
                zzbM2.zzm(zzb);
                zzbM2.zzw(zzbr);
                zzaVar.zzK(zzbM2);
                zzaVar.zzO(str);
            }
        });
        return zzbccVar;
    }
}
