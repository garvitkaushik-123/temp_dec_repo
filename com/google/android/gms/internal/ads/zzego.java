package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzego extends zzegq {
    private final zzche zza;
    private final zzdgw zzb;
    private final zzcvf zzc;
    private final zzdbw zzd;
    private final zzehb zze;
    private final zzedr zzf;

    public zzego(zzche zzcheVar, zzdgw zzdgwVar, zzcvf zzcvfVar, zzdbw zzdbwVar, zzehb zzehbVar, zzedr zzedrVar) {
        this.zza = zzcheVar;
        this.zzb = zzdgwVar;
        this.zzc = zzcvfVar;
        this.zzd = zzdbwVar;
        this.zze = zzehbVar;
        this.zzf = zzedrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    protected final ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar) {
        zzcvf zzcvfVar = this.zzc;
        zzcvfVar.zzk(zzfcwVar);
        zzcvfVar.zzg(bundle);
        zzcvfVar.zzh(new zzcuy(zzfcnVar, zzfcaVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdR)).booleanValue()) {
            zzcvfVar.zze(this.zzf);
        }
        zzdha zzg = this.zza.zzg();
        zzg.zzf(zzcvfVar.zzl());
        zzg.zze(this.zzd);
        zzg.zzd(this.zzb);
        zzg.zzc(new zzcop(null));
        zzcse zza = zzg.zzg().zza();
        return zza.zzh(zza.zzi());
    }
}
