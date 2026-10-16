package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzefk implements zzedm {
    private final Context zza;
    private final zzdpj zzb;
    private final zzdgf zzc;
    private final zzfcw zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbki zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjo)).booleanValue();
    private final zzecl zzi;
    private final zzdsd zzj;
    private final zzdsj zzk;

    public zzefk(Context context, VersionInfoParcel versionInfoParcel, zzfcw zzfcwVar, Executor executor, zzdgf zzdgfVar, zzdpj zzdpjVar, zzbki zzbkiVar, zzecl zzeclVar, zzdsd zzdsdVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzd = zzfcwVar;
        this.zzc = zzdgfVar;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdpjVar;
        this.zzg = zzbkiVar;
        this.zzi = zzeclVar;
        this.zzj = zzdsdVar;
        this.zzk = zzdsjVar;
    }

    public static /* synthetic */ ListenableFuture zzc(final zzefk zzefkVar, final zzfca zzfcaVar, zzfcn zzfcnVar, zzdpn zzdpnVar, Object obj) {
        zzbcv zzbcvVar = zzbde.zzct;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzefkVar.zzj.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzdpj zzdpjVar = zzefkVar.zzb;
        zzfcw zzfcwVar = zzefkVar.zzd;
        final zzcfg zza = zzdpjVar.zza(zzfcwVar.zze, zzfcaVar, zzfcnVar.zzb.zzb);
        zza.zzac(zzfcaVar.zzW);
        Context context = zzefkVar.zza;
        zzdpnVar.zza(context, zza.zzF());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzefkVar.zzj.zza().putLong(zzdrr.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzcak zzcakVar = new zzcak();
        zzdgf zzdgfVar = zzefkVar.zzc;
        zzcrq zzcrqVar = new zzcrq(zzfcnVar, zzfcaVar, null);
        VersionInfoParcel versionInfoParcel = zzefkVar.zzf;
        boolean z = zzefkVar.zzh;
        zzbki zzbkiVar = zzefkVar.zzg;
        final zzdfc zzd = zzdgfVar.zzd(zzcrqVar, new zzdff(new zzefj(context, versionInfoParcel, zzcakVar, zzfcaVar, zza, zzfcwVar, z, zzbkiVar, zzefkVar.zzi, zzefkVar.zzk), zza));
        zzcakVar.zzc(zzd);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
            zzefkVar.zzj.zza().putLong(zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        zzd.zzc().zzo(new zzcws() { // from class: com.google.android.gms.internal.ads.zzefh
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
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfC)).booleanValue() && zzd.zzl().zze(true)) {
            str = zzcgr.zzb(str, zzcgr.zza(zzfcaVar));
        }
        zzdpi zzi = zzd.zzi();
        zzbki zzbkiVar2 = true != z ? null : zzbkiVar;
        zzdsd zzdsdVar = zzefkVar.zzj;
        zzi.zzi(zza, true, zzbkiVar2, zzdsdVar.zza());
        zzd.zzi();
        return zzgdn.zzm(zzdpi.zzj(zza, zzfcfVar.zzb, str, zzdsdVar.zza(), zzdgfVar.zze()), new zzfve(zzefkVar) { // from class: com.google.android.gms.internal.ads.zzefi
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj2) {
                zzcfg zzcfgVar = zza;
                if (zzfcaVar.zzM) {
                    zzcfgVar.zzah();
                }
                zzdfc zzdfcVar = zzd;
                zzcfgVar.zzab();
                zzcfgVar.onPause();
                return zzdfcVar.zzg();
            }
        }, zzefkVar.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        final zzdpn zzdpnVar = new zzdpn();
        ListenableFuture zzh = zzgdn.zzh(null);
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeff
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzefk.zzc(zzefk.this, zzfcaVar, zzfcnVar, zzdpnVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture zzn = zzgdn.zzn(zzh, zzgcuVar, executor);
        Objects.requireNonNull(zzdpnVar);
        zzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefg
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
