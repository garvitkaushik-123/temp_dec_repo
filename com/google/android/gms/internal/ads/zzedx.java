package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzedx implements zzedm {
    private final zzcog zza;
    private final Context zzb;
    private final zzdpj zzc;
    private final zzfcw zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbki zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjo)).booleanValue();
    private final zzecl zzi;
    private final zzdsd zzj;
    private final zzdsj zzk;

    public zzedx(zzcog zzcogVar, Context context, Executor executor, zzdpj zzdpjVar, zzfcw zzfcwVar, VersionInfoParcel versionInfoParcel, zzbki zzbkiVar, zzecl zzeclVar, zzdsd zzdsdVar, zzdsj zzdsjVar) {
        this.zzb = context;
        this.zza = zzcogVar;
        this.zze = executor;
        this.zzc = zzdpjVar;
        this.zzd = zzfcwVar;
        this.zzf = versionInfoParcel;
        this.zzg = zzbkiVar;
        this.zzi = zzeclVar;
        this.zzj = zzdsdVar;
        this.zzk = zzdsjVar;
    }

    public static /* synthetic */ ListenableFuture zzc(final zzedx zzedxVar, final zzfca zzfcaVar, zzfcn zzfcnVar, zzdpn zzdpnVar, Object obj) {
        zzbcv zzbcvVar = zzbde.zzct;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzedxVar.zzj.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzdpj zzdpjVar = zzedxVar.zzc;
        zzfcw zzfcwVar = zzedxVar.zzd;
        final zzcfg zza = zzdpjVar.zza(zzfcwVar.zze, zzfcaVar, zzfcnVar.zzb.zzb);
        zza.zzac(zzfcaVar.zzW);
        zzdpnVar.zza(zzedxVar.zzb, zza.zzF());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzedxVar.zzj.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzcak zzcakVar = new zzcak();
        zzcog zzcogVar = zzedxVar.zza;
        zzcrq zzcrqVar = new zzcrq(zzfcnVar, zzfcaVar, null);
        VersionInfoParcel versionInfoParcel = zzedxVar.zzf;
        boolean z = zzedxVar.zzh;
        zzbki zzbkiVar = zzedxVar.zzg;
        final zzcod zza2 = zzcogVar.zza(zzcrqVar, new zzdff(new zzedz(versionInfoParcel, zzcakVar, zzfcaVar, zza, zzfcwVar, z, zzbkiVar, zzedxVar.zzi, zzedxVar.zzk), zza), new zzcoe(zzfcaVar.zzaa));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzedxVar.zzj.zza().putLong(zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzdpi zzh = zza2.zzh();
        zzbki zzbkiVar2 = true == z ? zzbkiVar : null;
        zzdsd zzdsdVar = zzedxVar.zzj;
        zzh.zzi(zza, false, zzbkiVar2, zzdsdVar.zza());
        zzcakVar.zzc(zza2);
        zza2.zzc().zzo(new zzcws() { // from class: com.google.android.gms.internal.ads.zzedv
            @Override // com.google.android.gms.internal.ads.zzcws
            public final void zzt() {
                zzcfg zzcfgVar = zzcfg.this;
                if (zzcfgVar.zzN() != null) {
                    zzcfgVar.zzN().zzs();
                }
            }
        }, zzcaf.zzg);
        zzfcf zzfcfVar = zzfcaVar.zzs;
        String str = zzfcfVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfC)).booleanValue() && zza2.zzi().zze(true)) {
            str = zzcgr.zzb(str, zzcgr.zza(zzfcaVar));
        }
        zza2.zzh();
        return zzgdn.zzm(zzdpi.zzj(zza, zzfcfVar.zzb, str, zzdsdVar.zza(), zzcogVar.zzg()), new zzfve(zzedxVar) { // from class: com.google.android.gms.internal.ads.zzedw
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj2) {
                zzcfg zzcfgVar = zza;
                if (zzfcaVar.zzM) {
                    zzcfgVar.zzah();
                }
                zzcod zzcodVar = zza2;
                zzcfgVar.zzab();
                zzcfgVar.onPause();
                return zzcodVar.zza();
            }
        }, zzedxVar.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        final zzdpn zzdpnVar = new zzdpn();
        ListenableFuture zzh = zzgdn.zzh(null);
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzedt
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzedx.zzc(zzedx.this, zzfcaVar, zzfcnVar, zzdpnVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture zzn = zzgdn.zzn(zzh, zzgcuVar, executor);
        Objects.requireNonNull(zzdpnVar);
        zzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedu
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
