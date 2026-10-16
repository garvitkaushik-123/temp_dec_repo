package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfbk implements zzgdj {
    final /* synthetic */ zzeln zza;
    final /* synthetic */ zzfhu zzb;
    final /* synthetic */ zzfhj zzc;
    final /* synthetic */ zzfbl zzd;
    final /* synthetic */ zzfbn zze;

    zzfbk(zzfbn zzfbnVar, zzeln zzelnVar, zzfhu zzfhuVar, zzfhj zzfhjVar, zzfbl zzfblVar) {
        this.zza = zzelnVar;
        this.zzb = zzfhuVar;
        this.zzc = zzfhjVar;
        this.zzd = zzfblVar;
        Objects.requireNonNull(zzfbnVar);
        this.zze = zzfbnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzezr zzezrVar;
        zzfbd zzfbdVar;
        zzdor zzk;
        zzfhx zzfhxVar;
        zzfhu zzfhuVar;
        Executor executor;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzga)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Rewarded ad failed to load", th);
        }
        zzfbn zzfbnVar = this.zze;
        zzezrVar = zzfbnVar.zze;
        zzdos zzdosVar = (zzdos) zzezrVar.zzd();
        final com.google.android.gms.ads.internal.client.zze zzb = zzdosVar == null ? zzfdx.zzb(th, null) : zzdosVar.zzb().zza(th);
        synchronized (zzfbnVar) {
            if (zzdosVar != null) {
                zzdosVar.zza().zzdD(zzb);
                executor = zzfbnVar.zzb;
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbi
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzfbd zzfbdVar2;
                        zzfbdVar2 = zzfbk.this.zze.zzd;
                        zzfbdVar2.zzdD(zzb);
                    }
                });
            } else {
                zzfbdVar = zzfbnVar.zzd;
                zzfbdVar.zzdD(zzb);
                zzk = zzfbnVar.zzk(this.zzd);
                zzk.zzh().zzb().zzc().zzh();
            }
            zzfdt.zzb(zzb.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                zzfhxVar = zzfbnVar.zzg;
                zzfhj zzfhjVar = this.zzc;
                zzfhjVar.zza(zzb);
                zzfhjVar.zzh(th);
                zzfhjVar.zzg(false);
                zzfhxVar.zzc(zzfhjVar.zzm());
            } else {
                zzfhuVar.zzc(zzb);
                zzfhj zzfhjVar2 = this.zzc;
                zzfhjVar2.zzh(th);
                zzfhjVar2.zzg(false);
                zzfhuVar.zza(zzfhjVar2);
                zzfhuVar.zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfbd zzfbdVar;
        Executor executor;
        final zzfbd zzfbdVar2;
        zzfbd zzfbdVar3;
        zzfhx zzfhxVar;
        zzfhu zzfhuVar;
        zzfbn zzfbnVar = this.zze;
        zzdon zzdonVar = (zzdon) obj;
        synchronized (zzfbnVar) {
            zzdaj zzo = zzdonVar.zzo();
            zzfbdVar = zzfbnVar.zzd;
            zzo.zzd(zzfbdVar);
            this.zza.zzb(zzdonVar);
            executor = zzfbnVar.zzb;
            zzfbdVar2 = zzfbnVar.zzd;
            Objects.requireNonNull(zzfbdVar2);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbj
                @Override // java.lang.Runnable
                public final void run() {
                    zzfbd.this.zzu();
                }
            });
            zzfbdVar3 = zzfbnVar.zzd;
            zzfbdVar3.onAdMetadataChanged();
            if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                zzfhxVar = zzfbnVar.zzg;
                zzfhj zzfhjVar = this.zzc;
                zzfhjVar.zzb(zzdonVar.zzq().zzb);
                zzfhjVar.zzd(zzdonVar.zzm().zzg());
                zzfhjVar.zzg(true);
                zzfhxVar.zzc(zzfhjVar.zzm());
            } else {
                zzfhuVar.zzg(zzdonVar.zzq().zzb);
                zzfhuVar.zze(zzdonVar.zzm().zzg());
                zzfhj zzfhjVar2 = this.zzc;
                zzfhjVar2.zzg(true);
                zzfhuVar.zza(zzfhjVar2);
                zzfhuVar.zzh();
            }
        }
    }
}
