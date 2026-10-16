package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdns implements zzgdj {
    final /* synthetic */ zzfca zza;
    final /* synthetic */ zzfcd zzb;
    final /* synthetic */ zzcmq zzc;
    final /* synthetic */ zzdny zzd;

    zzdns(zzdny zzdnyVar, zzfca zzfcaVar, zzfcd zzfcdVar, zzcmq zzcmqVar) {
        this.zza = zzfcaVar;
        this.zzb = zzfcdVar;
        this.zzc = zzcmqVar;
        Objects.requireNonNull(zzdnyVar);
        this.zzd = zzdnyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeca zzecaVar;
        zzfjy zzfjyVar;
        zzeca zzecaVar2;
        zzdsj zzdsjVar;
        zzcfg zzcfgVar = (zzcfg) obj;
        zzfca zzfcaVar = this.zza;
        zzcfgVar.zzW(zzfcaVar, this.zzb);
        zzcgy zzN = zzcfgVar.zzN();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkB)).booleanValue() && zzN != null) {
            zzcmq zzcmqVar = this.zzc;
            zzdny zzdnyVar = this.zzd;
            zzecaVar = zzdnyVar.zzi;
            zzfjyVar = zzdnyVar.zzj;
            zzN.zzM(zzcmqVar, zzecaVar, zzfjyVar);
            zzecaVar2 = zzdnyVar.zzi;
            zzdsjVar = zzdnyVar.zzd;
            zzN.zzO(zzcmqVar, zzecaVar2, zzdsjVar);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznt)).booleanValue() || zzN == null) {
            return;
        }
        zzN.zzP(zzfcaVar);
    }
}
