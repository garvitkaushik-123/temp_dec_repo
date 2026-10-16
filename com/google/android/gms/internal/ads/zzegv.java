package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzegv extends zzegq {
    private final zzche zza;
    private final zzcvf zzb;
    private final zzejh zzc;
    private final zzdbw zzd;
    private final zzehb zze;
    private final zzedr zzf;

    public zzegv(zzche zzcheVar, zzcvf zzcvfVar, zzejh zzejhVar, zzdbw zzdbwVar, zzehb zzehbVar, zzedr zzedrVar) {
        this.zza = zzcheVar;
        this.zzb = zzcvfVar;
        this.zzc = zzejhVar;
        this.zzd = zzdbwVar;
        this.zze = zzehbVar;
        this.zzf = zzedrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    protected final ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar) {
        zzcvf zzcvfVar = this.zzb;
        zzcvfVar.zzk(zzfcwVar);
        zzcvfVar.zzg(bundle);
        zzcvfVar.zzh(new zzcuy(zzfcnVar, zzfcaVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdR)).booleanValue()) {
            zzcvfVar.zze(this.zzf);
        }
        zzdge zzf = this.zza.zzf();
        zzf.zze(zzcvfVar.zzl());
        zzf.zzd(this.zzd);
        zzf.zzc(this.zzc);
        zzcse zza = zzf.zzf().zza();
        return zza.zzh(zza.zzi());
    }
}
