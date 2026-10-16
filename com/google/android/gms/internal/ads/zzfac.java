package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfac implements zzgdj {
    final /* synthetic */ zzeln zza;
    final /* synthetic */ zzfhu zzb;
    final /* synthetic */ zzfhj zzc;
    final /* synthetic */ zzdgf zzd;
    final /* synthetic */ zzfad zze;

    zzfac(zzfad zzfadVar, zzeln zzelnVar, zzfhu zzfhuVar, zzfhj zzfhjVar, zzdgf zzdgfVar) {
        this.zza = zzelnVar;
        this.zzb = zzfhuVar;
        this.zzc = zzfhjVar;
        this.zzd = zzdgfVar;
        Objects.requireNonNull(zzfadVar);
        this.zze = zzfadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhx zzfhxVar;
        zzfhu zzfhuVar;
        Executor executor;
        Executor executor2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzga)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Interstitial ad failed to load", th);
        }
        zzdgf zzdgfVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zza = zzdgfVar.zza().zza(th);
        zzfad zzfadVar = this.zze;
        synchronized (zzfadVar) {
            zzfadVar.zzi = null;
            zzdgfVar.zzb().zzdD(zza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziC)).booleanValue()) {
                executor = zzfadVar.zzb;
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzezy
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeky zzekyVar;
                        zzekyVar = zzfac.this.zze.zzd;
                        zzekyVar.zzdD(zza);
                    }
                });
                executor2 = zzfadVar.zzb;
                executor2.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzezz
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzfbd zzfbdVar;
                        zzfbdVar = zzfac.this.zze.zze;
                        zzfbdVar.zzdD(zza);
                    }
                });
            }
            zzfdt.zzb(zza.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                zzfhxVar = zzfadVar.zzg;
                zzfhj zzfhjVar = this.zzc;
                zzfhjVar.zza(zza);
                zzfhjVar.zzh(th);
                zzfhjVar.zzg(false);
                zzfhxVar.zzc(zzfhjVar.zzm());
            } else {
                zzfhuVar.zzc(zza);
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
        Executor executor;
        Executor executor2;
        zzeky zzekyVar;
        zzfbd zzfbdVar;
        zzdfb zzdfbVar = (zzdfb) obj;
        zzfad zzfadVar = this.zze;
        synchronized (zzfadVar) {
            zzfadVar.zzi = null;
            zzbcv zzbcvVar = zzbde.zziC;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
                zzdaj zzo = zzdfbVar.zzo();
                zzekyVar = zzfadVar.zzd;
                zzo.zza(zzekyVar);
                zzfbdVar = zzfadVar.zze;
                zzo.zzd(zzfbdVar);
            }
            this.zza.zzb(zzdfbVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
                executor = zzfadVar.zzb;
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfaa
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeky zzekyVar2;
                        zzekyVar2 = zzfac.this.zze.zzd;
                        zzekyVar2.zzu();
                    }
                });
                executor2 = zzfadVar.zzb;
                executor2.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfab
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzfbd zzfbdVar2;
                        zzfbdVar2 = zzfac.this.zze.zze;
                        zzfbdVar2.zzu();
                    }
                });
            }
            if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                zzfhxVar = zzfadVar.zzg;
                zzfhj zzfhjVar = this.zzc;
                zzfhjVar.zzb(zzdfbVar.zzq().zzb);
                zzfhjVar.zzd(zzdfbVar.zzm().zzg());
                zzfhjVar.zzg(true);
                zzfhxVar.zzc(zzfhjVar.zzm());
            } else {
                zzfhuVar.zzg(zzdfbVar.zzq().zzb);
                zzfhuVar.zze(zzdfbVar.zzm().zzg());
                zzfhj zzfhjVar2 = this.zzc;
                zzfhjVar2.zzg(true);
                zzfhuVar.zza(zzfhjVar2);
                zzfhuVar.zzh();
            }
        }
    }
}
