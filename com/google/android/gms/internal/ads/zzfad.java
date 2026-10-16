package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfad implements zzelo {
    private final Context zza;
    private final Executor zzb;
    private final zzche zzc;
    private final zzeky zzd;
    private final zzfbd zze;
    private zzbdz zzf;
    private final zzfhx zzg;
    private final zzfcu zzh;
    private ListenableFuture zzi;

    public zzfad(Context context, Executor executor, zzche zzcheVar, zzeky zzekyVar, zzfbd zzfbdVar, zzfcu zzfcuVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcheVar;
        this.zzd = zzekyVar;
        this.zzh = zzfcuVar;
        this.zze = zzfbdVar;
        this.zzg = zzcheVar.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzi;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzelm zzelmVar, zzeln zzelnVar) {
        zzdgf zzh;
        zzfhu zzfhuVar;
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzezx
                @Override // java.lang.Runnable
                public final void run() {
                    zzfad.this.zzd.zzdD(zzfdx.zzd(6, null, null));
                }
            });
            return false;
        }
        if (zza()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue() && zzmVar.zzf) {
            this.zzc.zzk().zzo(true);
        }
        com.google.android.gms.ads.internal.client.zzr zzrVar = ((zzezw) zzelmVar).zza;
        Bundle zza = zzdrt.zza(new Pair(zzdrr.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz)), new Pair(zzdrr.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis())));
        zzfcu zzfcuVar = this.zzh;
        zzfcuVar.zzu(str);
        zzfcuVar.zzt(zzrVar);
        zzfcuVar.zzJ(zzmVar);
        zzfcuVar.zzB(zza);
        Context context = this.zza;
        zzfcw zzL = zzfcuVar.zzL();
        zzfhj zzb = zzfhi.zzb(context, zzfht.zzf(zzL), 4, zzmVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziC)).booleanValue()) {
            zzdge zzf = this.zzc.zzf();
            zzcvf zzcvfVar = new zzcvf();
            zzcvfVar.zzf(context);
            zzcvfVar.zzk(zzL);
            zzf.zze(zzcvfVar.zzl());
            zzdbu zzdbuVar = new zzdbu();
            zzeky zzekyVar = this.zzd;
            Executor executor = this.zzb;
            zzdbuVar.zzj(zzekyVar, executor);
            zzdbuVar.zzk(zzekyVar, executor);
            zzf.zzd(zzdbuVar.zzn());
            zzf.zzc(new zzejh(this.zzf));
            zzh = zzf.zzh();
        } else {
            zzdbu zzdbuVar2 = new zzdbu();
            zzfbd zzfbdVar = this.zze;
            if (zzfbdVar != null) {
                Executor executor2 = this.zzb;
                zzdbuVar2.zze(zzfbdVar, executor2);
                zzdbuVar2.zzf(zzfbdVar, executor2);
                zzdbuVar2.zzb(zzfbdVar, executor2);
            }
            zzdge zzf2 = this.zzc.zzf();
            zzcvf zzcvfVar2 = new zzcvf();
            zzcvfVar2.zzf(context);
            zzcvfVar2.zzk(zzL);
            zzf2.zze(zzcvfVar2.zzl());
            zzeky zzekyVar2 = this.zzd;
            Executor executor3 = this.zzb;
            zzdbuVar2.zzj(zzekyVar2, executor3);
            zzdbuVar2.zze(zzekyVar2, executor3);
            zzdbuVar2.zzf(zzekyVar2, executor3);
            zzdbuVar2.zzb(zzekyVar2, executor3);
            zzdbuVar2.zza(zzekyVar2, executor3);
            zzdbuVar2.zzl(zzekyVar2, executor3);
            zzdbuVar2.zzk(zzekyVar2, executor3);
            zzdbuVar2.zzi(zzekyVar2, executor3);
            zzdbuVar2.zzc(zzekyVar2, executor3);
            zzf2.zzd(zzdbuVar2.zzn());
            zzf2.zzc(new zzejh(this.zzf));
            zzh = zzf2.zzh();
        }
        zzdgf zzdgfVar = zzh;
        if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
            zzfhuVar = zzdgfVar.zze();
            zzfhuVar.zzi(4);
            zzfhuVar.zzb(zzmVar.zzp);
            zzfhuVar.zzf(zzmVar.zzm);
        } else {
            zzfhuVar = null;
        }
        zzcse zza2 = zzdgfVar.zza();
        ListenableFuture zzh2 = zza2.zzh(zza2.zzi());
        this.zzi = zzh2;
        zzgdn.zzr(zzh2, new zzfac(this, zzelnVar, zzfhuVar, zzb, zzdgfVar), this.zzb);
        return true;
    }

    public final void zzi(zzbdz zzbdzVar) {
        this.zzf = zzbdzVar;
    }
}
