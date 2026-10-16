package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzegt extends zzegq {
    private final zzche zza;
    private final zzcvf zzb;
    private final zzejh zzc;
    private final zzdbw zzd;
    private final zzdgw zze;
    private final zzcyv zzf;
    private final ViewGroup zzg;
    private final zzdbb zzh;
    private final zzehb zzi;
    private final zzedr zzj;

    public zzegt(zzche zzcheVar, zzcvf zzcvfVar, zzejh zzejhVar, zzdbw zzdbwVar, zzdgw zzdgwVar, zzcyv zzcyvVar, ViewGroup viewGroup, zzdbb zzdbbVar, zzehb zzehbVar, zzedr zzedrVar) {
        this.zza = zzcheVar;
        this.zzb = zzcvfVar;
        this.zzc = zzejhVar;
        this.zzd = zzdbwVar;
        this.zze = zzdgwVar;
        this.zzf = zzcyvVar;
        this.zzg = viewGroup;
        this.zzh = zzdbbVar;
        this.zzi = zzehbVar;
        this.zzj = zzedrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    protected final ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar) {
        zzcvf zzcvfVar = this.zzb;
        zzcvfVar.zzk(zzfcwVar);
        zzcvfVar.zzg(bundle);
        zzcvfVar.zzh(new zzcuy(zzfcnVar, zzfcaVar, this.zzi));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdR)).booleanValue()) {
            zzcvfVar.zze(this.zzj);
        }
        zzcpw zzd = this.zza.zzd();
        zzd.zzi(zzcvfVar.zzl());
        zzd.zzf(this.zzd);
        zzd.zze(this.zzc);
        zzd.zzd(this.zze);
        zzd.zzg(new zzcqs(this.zzf, this.zzh));
        zzd.zzc(new zzcop(this.zzg));
        zzcse zzc = zzd.zzk().zzc();
        return zzc.zzh(zzc.zzi());
    }
}
