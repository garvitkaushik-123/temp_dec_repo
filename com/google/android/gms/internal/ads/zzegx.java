package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzegx extends zzegq {
    private final zzche zza;
    private final zzcvf zzb;
    private final zzdbw zzc;
    private final zzehb zzd;

    @Nullable
    private final zzfco zze;
    private final zzedr zzf;

    public zzegx(zzche zzcheVar, zzcvf zzcvfVar, zzdbw zzdbwVar, @Nullable zzfco zzfcoVar, zzehb zzehbVar, zzedr zzedrVar) {
        this.zza = zzcheVar;
        this.zzb = zzcvfVar;
        this.zzc = zzdbwVar;
        this.zze = zzfcoVar;
        this.zzd = zzehbVar;
        this.zzf = zzedrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    protected final ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar) {
        zzfco zzfcoVar;
        zzcvf zzcvfVar = this.zzb;
        zzcvfVar.zzk(zzfcwVar);
        zzcvfVar.zzg(bundle);
        zzcvfVar.zzh(new zzcuy(zzfcnVar, zzfcaVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdQ)).booleanValue() && (zzfcoVar = this.zze) != null) {
            zzcvfVar.zzj(zzfcoVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdR)).booleanValue()) {
            zzcvfVar.zze(this.zzf);
        }
        zzdor zzh = this.zza.zzh();
        zzh.zzd(zzcvfVar.zzl());
        zzh.zzc(this.zzc);
        zzcse zzb = zzh.zze().zzb();
        return zzb.zzh(zzb.zzi());
    }
}
