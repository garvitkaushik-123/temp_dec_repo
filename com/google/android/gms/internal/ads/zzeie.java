package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeie implements zzedm {
    private final Context zza;
    private final zzdpj zzb;
    private final zzdos zzc;
    private final zzfcw zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbki zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjo)).booleanValue();
    private final zzecl zzi;
    private final zzdsd zzj;
    private final zzdsj zzk;

    public zzeie(Context context, VersionInfoParcel versionInfoParcel, zzfcw zzfcwVar, Executor executor, zzdos zzdosVar, zzdpj zzdpjVar, zzbki zzbkiVar, zzecl zzeclVar, zzdsd zzdsdVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzd = zzfcwVar;
        this.zzc = zzdosVar;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdpjVar;
        this.zzg = zzbkiVar;
        this.zzi = zzeclVar;
        this.zzj = zzdsdVar;
        this.zzk = zzdsjVar;
    }

    public static /* synthetic */ ListenableFuture zzc(final zzeie zzeieVar, final zzfca zzfcaVar, zzfcn zzfcnVar, zzdpn zzdpnVar, Object obj) {
        zzbcv zzbcvVar = zzbde.zzct;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzeieVar.zzj.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzdpj zzdpjVar = zzeieVar.zzb;
        zzfcw zzfcwVar = zzeieVar.zzd;
        final zzcfg zza = zzdpjVar.zza(zzfcwVar.zze, zzfcaVar, zzfcnVar.zzb.zzb);
        zza.zzac(zzfcaVar.zzW);
        Context context = zzeieVar.zza;
        zzdpnVar.zza(context, zza.zzF());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzeieVar.zzj.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzcak zzcakVar = new zzcak();
        zzdos zzdosVar = zzeieVar.zzc;
        zzcrq zzcrqVar = new zzcrq(zzfcnVar, zzfcaVar, null);
        VersionInfoParcel versionInfoParcel = zzeieVar.zzf;
        zzbki zzbkiVar = zzeieVar.zzg;
        boolean z = zzeieVar.zzh;
        zzecl zzeclVar = zzeieVar.zzi;
        zzdsd zzdsdVar = zzeieVar.zzj;
        final zzdoo zzd = zzdosVar.zzd(zzcrqVar, new zzdop(new zzeid(context, zzdpjVar, zzfcwVar, versionInfoParcel, zzfcaVar, zzcakVar, zza, zzbkiVar, z, zzeclVar, zzdsdVar, zzeieVar.zzk), zza));
        zzcakVar.zzc(zzd);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzdsdVar.zza().putLong(zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzbkx.zzb(zza, zzd.zzg());
        zzd.zzc().zzo(new zzcws() { // from class: com.google.android.gms.internal.ads.zzehx
            @Override // com.google.android.gms.internal.ads.zzcws
            public final void zzt() {
                zzcfg zzcfgVar = zzcfg.this;
                if (zzcfgVar.zzN() != null) {
                    zzcfgVar.zzN().zzs();
                }
            }
        }, zzcaf.zzg);
        zzdpi zzl = zzd.zzl();
        if (true != z) {
            zzbkiVar = null;
        }
        zzl.zzi(zza, true, zzbkiVar, zzdsdVar.zza());
        zzfcf zzfcfVar = zzfcaVar.zzs;
        String str = zzfcfVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfC)).booleanValue() && zzd.zzm().zze(true)) {
            str = zzcgr.zzb(str, zzcgr.zza(zzfcaVar));
        }
        zzd.zzl();
        return zzgdn.zzm(zzdpi.zzj(zza, zzfcfVar.zzb, str, zzdsdVar.zza(), zzdosVar.zzg()), new zzfve(zzeieVar) { // from class: com.google.android.gms.internal.ads.zzehy
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj2) {
                zzcfg zzcfgVar = zza;
                if (zzfcaVar.zzM) {
                    zzcfgVar.zzah();
                }
                zzdoo zzdooVar = zzd;
                zzcfgVar.zzab();
                zzcfgVar.onPause();
                return zzdooVar.zzi();
            }
        }, zzeieVar.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        final zzdpn zzdpnVar = new zzdpn();
        ListenableFuture zzh = zzgdn.zzh(null);
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzehz
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzeie.zzc(zzeie.this, zzfcaVar, zzfcnVar, zzdpnVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture zzn = zzgdn.zzn(zzh, zzgcuVar, executor);
        Objects.requireNonNull(zzdpnVar);
        zzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeia
            @Override // java.lang.Runnable
            public final void run() {
                zzdpn.this.zzb();
            }
        }, executor);
        return zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzfcf zzfcfVar = zzfcaVar.zzs;
        return (zzfcfVar == null || zzfcfVar.zza == null) ? false : true;
    }
}
