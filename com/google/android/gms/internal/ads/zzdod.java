package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdod {
    private final zzcvw zza;
    private final zzcxf zzb;
    private final zzcxs zzc;
    private final zzcye zzd;
    private final zzdaz zze;
    private final zzdeb zzf;
    private final zzdsj zzg;
    private final zzfjy zzh;
    private final zzeca zzi;
    private final zzcmq zzj;

    zzdod(zzcvw zzcvwVar, zzcxf zzcxfVar, zzcxs zzcxsVar, zzcye zzcyeVar, zzdaz zzdazVar, zzdeb zzdebVar, zzdsj zzdsjVar, zzfjy zzfjyVar, zzeca zzecaVar, zzcmq zzcmqVar) {
        this.zza = zzcvwVar;
        this.zzb = zzcxfVar;
        this.zzc = zzcxsVar;
        this.zzd = zzcyeVar;
        this.zze = zzdazVar;
        this.zzf = zzdebVar;
        this.zzg = zzdsjVar;
        this.zzh = zzfjyVar;
        this.zzi = zzecaVar;
        this.zzj = zzcmqVar;
    }

    public final void zza(zzdoe zzdoeVar, zzcfg zzcfgVar) {
        zzdob zzdobVar;
        zzdobVar = zzdoeVar.zza;
        final zzcxf zzcxfVar = this.zzb;
        Objects.requireNonNull(zzcxfVar);
        zzdobVar.zzi(this.zza, this.zzc, this.zzd, this.zze, new com.google.android.gms.ads.internal.overlay.zzad() { // from class: com.google.android.gms.internal.ads.zzdoc
            @Override // com.google.android.gms.ads.internal.overlay.zzad
            public final void zzg() {
                zzcxf.this.zzb();
            }
        }, this.zzf);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkD)).booleanValue() || zzcfgVar == null || zzcfgVar.zzN() == null) {
            return;
        }
        zzcgy zzN = zzcfgVar.zzN();
        zzcmq zzcmqVar = this.zzj;
        zzeca zzecaVar = this.zzi;
        zzN.zzM(zzcmqVar, zzecaVar, this.zzh);
        zzN.zzO(zzcmqVar, zzecaVar, this.zzg);
    }
}
