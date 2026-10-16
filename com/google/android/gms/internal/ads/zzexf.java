package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzexf implements zzgdj {
    final /* synthetic */ zzeln zza;
    final /* synthetic */ zzfhu zzb;
    final /* synthetic */ zzfhj zzc;
    final /* synthetic */ zzexg zzd;
    final /* synthetic */ zzexi zze;

    zzexf(zzexi zzexiVar, zzeln zzelnVar, zzfhu zzfhuVar, zzfhj zzfhjVar, zzexg zzexgVar) {
        this.zza = zzelnVar;
        this.zzb = zzfhuVar;
        this.zzc = zzfhjVar;
        this.zzd = zzexgVar;
        Objects.requireNonNull(zzexiVar);
        this.zze = zzexiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzezr zzezrVar;
        zzexy zzexyVar;
        zzcvd zzm;
        zzfhx zzfhxVar;
        zzfhu zzfhuVar;
        Executor executor;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzga)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("App open ad failed to load", th);
        }
        zzexi zzexiVar = this.zze;
        zzezrVar = zzexiVar.zze;
        zzcoc zzcocVar = (zzcoc) zzezrVar.zzd();
        final com.google.android.gms.ads.internal.client.zze zzb = zzcocVar == null ? zzfdx.zzb(th, null) : zzcocVar.zzb().zza(th);
        synchronized (zzexiVar) {
            zzexiVar.zzj = null;
            if (zzcocVar != null) {
                zzcocVar.zzc().zzdD(zzb);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziB)).booleanValue()) {
                    executor = zzexiVar.zzc;
                    executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexe
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzexy zzexyVar2;
                            zzexyVar2 = zzexf.this.zze.zzd;
                            zzexyVar2.zzdD(zzb);
                        }
                    });
                }
            } else {
                zzexyVar = zzexiVar.zzd;
                zzexyVar.zzdD(zzb);
                zzm = zzexiVar.zzm(this.zzd);
                ((zzcoc) zzm.zzh()).zzb().zzc().zzh();
            }
            zzfdt.zzb(zzb.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                zzfhxVar = zzexiVar.zzh;
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
        zzfhx zzfhxVar;
        zzfhu zzfhuVar;
        zzexy zzexyVar;
        zzcra zzcraVar = (zzcra) obj;
        zzexi zzexiVar = this.zze;
        synchronized (zzexiVar) {
            zzexiVar.zzj = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziB)).booleanValue()) {
                zzdaj zzo = zzcraVar.zzo();
                zzexyVar = zzexiVar.zzd;
                zzo.zzb(zzexyVar);
            }
            this.zza.zzb(zzcraVar);
            if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                zzfhxVar = zzexiVar.zzh;
                zzfhj zzfhjVar = this.zzc;
                zzfhjVar.zzb(zzcraVar.zzq().zzb);
                zzfhjVar.zzd(zzcraVar.zzm().zzg());
                zzfhjVar.zzg(true);
                zzfhxVar.zzc(zzfhjVar.zzm());
            } else {
                zzfhuVar.zzg(zzcraVar.zzq().zzb);
                zzfhuVar.zze(zzcraVar.zzm().zzg());
                zzfhj zzfhjVar2 = this.zzc;
                zzfhjVar2.zzg(true);
                zzfhuVar.zza(zzfhjVar2);
                zzfhuVar.zzh();
            }
        }
    }
}
