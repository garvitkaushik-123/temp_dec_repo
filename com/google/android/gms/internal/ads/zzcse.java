package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcse {
    private final zzdyb zza;
    private final zzfcw zzb;
    private final zzfha zzc;
    private final zzcle zzd;
    private final zzehi zze;
    private final zzdbk zzf;
    private zzfcn zzg;
    private final zzdzj zzh;
    private final zzcvb zzi;
    private final Executor zzj;
    private final zzdyu zzk;
    private final zzedr zzl;

    zzcse(zzdyb zzdybVar, zzfcw zzfcwVar, zzfha zzfhaVar, zzcle zzcleVar, zzehi zzehiVar, zzdbk zzdbkVar, zzfcn zzfcnVar, zzdzj zzdzjVar, zzcvb zzcvbVar, Executor executor, zzdyu zzdyuVar, zzedr zzedrVar) {
        this.zza = zzdybVar;
        this.zzb = zzfcwVar;
        this.zzc = zzfhaVar;
        this.zzd = zzcleVar;
        this.zze = zzehiVar;
        this.zzf = zzdbkVar;
        this.zzg = zzfcnVar;
        this.zzh = zzdzjVar;
        this.zzi = zzcvbVar;
        this.zzj = executor;
        this.zzk = zzdyuVar;
        this.zzl = zzedrVar;
    }

    public static /* synthetic */ zzfcn zzd(zzcse zzcseVar, zzfcn zzfcnVar) {
        zzcseVar.zzd.zza(zzfcnVar);
        return zzfcnVar;
    }

    public static /* synthetic */ ListenableFuture zze(zzcse zzcseVar, zzfeq zzfeqVar, zzbvq zzbvqVar) {
        zzbvqVar.zzi = zzfeqVar;
        return zzcseVar.zzh.zze(zzbvqVar);
    }

    public final com.google.android.gms.ads.internal.client.zze zza(Throwable th) {
        return zzfdx.zzb(th, this.zzl);
    }

    public final zzdbk zzc() {
        return this.zzf;
    }

    public final ListenableFuture zzf(final zzfeq zzfeqVar) {
        zzfgg zza = this.zzc.zzb(zzfgu.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzgcu() { // from class: com.google.android.gms.internal.ads.zzcsa
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzcse.zze(zzcse.this, zzfeqVar, (zzbvq) obj);
            }
        }).zza();
        zzgdn.zzr(zza, new zzcsc(this), this.zzj);
        return zza;
    }

    public final ListenableFuture zzg(zzbvq zzbvqVar) {
        zzfgg zza = this.zzc.zzb(zzfgu.NOTIFY_CACHE_HIT, this.zzh.zzf(zzbvqVar)).zza();
        zzgdn.zzr(zza, new zzcsd(this), this.zzj);
        return zza;
    }

    public final ListenableFuture zzh(ListenableFuture listenableFuture) {
        zzfgq zzf = this.zzc.zzb(zzfgu.RENDERER, listenableFuture).zze(new zzfge() { // from class: com.google.android.gms.internal.ads.zzcrz
            @Override // com.google.android.gms.internal.ads.zzfge
            public final Object zza(Object obj) {
                zzfcn zzfcnVar = (zzfcn) obj;
                zzcse.zzd(zzcse.this, zzfcnVar);
                return zzfcnVar;
            }
        }).zzf(this.zze);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfR)).booleanValue()) {
            zzf = zzf.zzi(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfS)).intValue(), TimeUnit.SECONDS);
        }
        return zzf.zza();
    }

    public final ListenableFuture zzi() {
        com.google.android.gms.ads.internal.client.zzm zzmVar = this.zzb.zzd;
        if (zzmVar.zzx == null && zzmVar.zzs == null) {
            return zzj(this.zzi.zzc());
        }
        zzfha zzfhaVar = this.zzc;
        zzfgu zzfguVar = zzfgu.PRELOADED_LOADER;
        Objects.requireNonNull(zzfhaVar);
        return zzfgk.zzc(this.zza.zze(), zzfguVar, zzfhaVar).zza();
    }

    public final ListenableFuture zzj(ListenableFuture listenableFuture) {
        if (this.zzg != null) {
            zzfha zzfhaVar = this.zzc;
            zzfgu zzfguVar = zzfgu.SERVER_TRANSACTION;
            Objects.requireNonNull(zzfhaVar);
            return zzfgk.zzc(zzgdn.zzh(this.zzg), zzfguVar, zzfhaVar).zza();
        }
        com.google.android.gms.ads.internal.zzv.zzc().zzj();
        zzfgq zzb = this.zzc.zzb(zzfgu.SERVER_TRANSACTION, listenableFuture);
        final zzdyu zzdyuVar = this.zzk;
        Objects.requireNonNull(zzdyuVar);
        return zzb.zzf(new zzgcu() { // from class: com.google.android.gms.internal.ads.zzcsb
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdyu.this.zzc((zzbvq) obj);
            }
        }).zza();
    }

    public final void zzk(zzfcn zzfcnVar) {
        this.zzg = zzfcnVar;
    }
}
