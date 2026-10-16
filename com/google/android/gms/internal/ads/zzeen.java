package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeen implements zzedm {
    private final zzcpx zza;
    private final Context zzb;
    private final zzdpj zzc;
    private final zzfcw zzd;
    private final Executor zze;
    private final zzfve zzf;
    private final zzdsd zzg;

    public zzeen(zzcpx zzcpxVar, Context context, Executor executor, zzdpj zzdpjVar, zzfcw zzfcwVar, zzfve zzfveVar, zzdsd zzdsdVar) {
        this.zzb = context;
        this.zza = zzcpxVar;
        this.zze = executor;
        this.zzc = zzdpjVar;
        this.zzd = zzfcwVar;
        this.zzf = zzfveVar;
        this.zzg = zzdsdVar;
    }

    public static /* synthetic */ ListenableFuture zzc(final zzeen zzeenVar, zzfcn zzfcnVar, zzfca zzfcaVar, Object obj) {
        zzbcv zzbcvVar = zzbde.zzct;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzeenVar.zzg.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        Context context = zzeenVar.zzb;
        com.google.android.gms.ads.internal.client.zzr zza = zzfdc.zza(context, zzfcaVar.zzu);
        final zzcfg zza2 = zzeenVar.zzc.zza(zza, zzfcaVar, zzfcnVar.zzb.zzb);
        zza2.zzac(zzfcaVar.zzW);
        View zza3 = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzij)).booleanValue() && zzfcaVar.zzag) ? zzcqm.zza(context, zza2.zzF(), zzfcaVar) : new zzdpm(context, zza2.zzF(), (com.google.android.gms.ads.internal.util.zzau) zzeenVar.zzf.apply(zzfcaVar));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzeenVar.zzg.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzcpx zzcpxVar = zzeenVar.zza;
        zzcrq zzcrqVar = new zzcrq(zzfcnVar, zzfcaVar, null);
        Objects.requireNonNull(zza2);
        final zzcot zza4 = zzcpxVar.zza(zzcrqVar, new zzcoz(zza3, zza2, new zzcqy() { // from class: com.google.android.gms.internal.ads.zzeeh
            @Override // com.google.android.gms.internal.ads.zzcqy
            public final com.google.android.gms.ads.internal.client.zzed zza() {
                return zzcfg.this.zzq();
            }
        }, zzfdc.zzb(zza)));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzeenVar.zzg.zza().putLong(zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzdpi zzi = zza4.zzi();
        zzdsd zzdsdVar = zzeenVar.zzg;
        zzi.zzi(zza2, false, null, zzdsdVar.zza());
        zzcwq zzc = zza4.zzc();
        zzcws zzcwsVar = new zzcws() { // from class: com.google.android.gms.internal.ads.zzeei
            @Override // com.google.android.gms.internal.ads.zzcws
            public final void zzt() {
                zzcfg zzcfgVar = zzcfg.this;
                if (zzcfgVar.zzN() != null) {
                    zzcfgVar.zzN().zzs();
                }
            }
        };
        zzgdy zzgdyVar = zzcaf.zzg;
        zzc.zzo(zzcwsVar, zzgdyVar);
        zzfcf zzfcfVar = zzfcaVar.zzs;
        String str = zzfcfVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfC)).booleanValue() && zza4.zzl().zze(true)) {
            str = zzcgr.zzb(str, zzcgr.zza(zzfcaVar));
        }
        zza4.zzi();
        ListenableFuture zzj = zzdpi.zzj(zza2, zzfcfVar.zzb, str, zzdsdVar.zza(), zzcpxVar.zzh());
        if (zzfcaVar.zzM) {
            Objects.requireNonNull(zza2);
            zzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeej
                @Override // java.lang.Runnable
                public final void run() {
                    zzcfg.this.zzah();
                }
            }, zzeenVar.zze);
        }
        zzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeek
            @Override // java.lang.Runnable
            public final void run() {
                zzeen.zzd(zzeen.this, zza2);
            }
        }, zzeenVar.zze);
        return zzgdn.zzm(zzj, new zzfve() { // from class: com.google.android.gms.internal.ads.zzeel
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj2) {
                return zzcot.this.zza();
            }
        }, zzgdyVar);
    }

    public static /* synthetic */ void zzd(zzeen zzeenVar, zzcfg zzcfgVar) {
        zzcfgVar.zzab();
        zzfcw zzfcwVar = zzeenVar.zzd;
        zzcgi zzq = zzcfgVar.zzq();
        com.google.android.gms.ads.internal.client.zzgc zzgcVar = zzfcwVar.zza;
        if (zzgcVar != null && zzq != null) {
            zzq.zzs(zzgcVar);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbv)).booleanValue() || zzcfgVar.isAttachedToWindow()) {
            return;
        }
        zzcfgVar.onPause();
        zzcfgVar.zzav(true);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        return zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeem
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzeen.zzc(zzeen.this, zzfcnVar, zzfcaVar, obj);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzfcf zzfcfVar = zzfcaVar.zzs;
        return (zzfcfVar == null || zzfcfVar.zza == null) ? false : true;
    }
}
