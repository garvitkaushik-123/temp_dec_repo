package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdnu {
    private final zzcvw zza;
    private final zzcxf zzb;
    private final zzcxs zzc;
    private final zzcye zzd;
    private final zzdaz zze;
    private final zzfca zzf;
    private final zzfcd zzg;
    private final zzcmq zzh;

    public zzdnu(zzcvw zzcvwVar, zzcxf zzcxfVar, zzcxs zzcxsVar, zzcye zzcyeVar, zzdaz zzdazVar, zzfca zzfcaVar, zzfcd zzfcdVar, zzcmq zzcmqVar) {
        this.zza = zzcvwVar;
        this.zzb = zzcxfVar;
        this.zzc = zzcxsVar;
        this.zzd = zzcyeVar;
        this.zze = zzdazVar;
        this.zzf = zzfcaVar;
        this.zzg = zzfcdVar;
        this.zzh = zzcmqVar;
    }

    public final void zza(zzdny zzdnyVar) {
        zzdnl zzdnlVar;
        final zzcxf zzcxfVar = this.zzb;
        zzdnlVar = zzdnyVar.zza;
        Objects.requireNonNull(zzcxfVar);
        zzdnlVar.zzh(this.zza, this.zzc, this.zzd, this.zze, new com.google.android.gms.ads.internal.overlay.zzad() { // from class: com.google.android.gms.internal.ads.zzdnt
            @Override // com.google.android.gms.ads.internal.overlay.zzad
            public final void zzg() {
                zzcxf.this.zzb();
            }
        });
        zzdnyVar.zzh(this.zzf, this.zzg, this.zzh);
    }
}
