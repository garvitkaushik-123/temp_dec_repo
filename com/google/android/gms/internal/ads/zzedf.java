package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzedf {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzfca zzc;
    private final zzcfg zzd;
    private final zzdsj zze;
    private zzflw zzf;

    zzedf(Context context, VersionInfoParcel versionInfoParcel, zzfca zzfcaVar, zzcfg zzcfgVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfcaVar;
        this.zzd = zzcfgVar;
        this.zze = zzdsjVar;
    }

    public final synchronized void zza(View view) {
        zzflw zzflwVar = this.zzf;
        if (zzflwVar != null) {
            com.google.android.gms.ads.internal.zzv.zzC().zzh(zzflwVar, view);
        }
    }

    public final synchronized void zzb() {
        zzcfg zzcfgVar;
        if (this.zzf == null || (zzcfgVar = this.zzd) == null) {
            return;
        }
        zzcfgVar.zzd("onSdkImpression", zzfyt.zzd());
    }

    public final synchronized void zzc() {
        zzcfg zzcfgVar;
        zzflw zzflwVar = this.zzf;
        if (zzflwVar == null || (zzcfgVar = this.zzd) == null) {
            return;
        }
        Iterator it = zzcfgVar.zzV().iterator();
        while (it.hasNext()) {
            com.google.android.gms.ads.internal.zzv.zzC().zzh(zzflwVar, (View) it.next());
        }
        zzcfgVar.zzd("onSdkLoaded", zzfyt.zzd());
    }

    public final synchronized boolean zzd() {
        return this.zzf != null;
    }

    public final synchronized boolean zze(boolean z) {
        zzcfg zzcfgVar;
        zzfca zzfcaVar = this.zzc;
        if (zzfcaVar.zzT) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfz)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfC)).booleanValue() && (zzcfgVar = this.zzd) != null) {
                    if (this.zzf != null) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Omid javascript session service already started for ad.");
                        return false;
                    }
                    if (!com.google.android.gms.ads.internal.zzv.zzC().zzl(this.zza)) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to initialize omid.");
                        return false;
                    }
                    if (zzfcaVar.zzV.zzb()) {
                        zzflw zze = com.google.android.gms.ads.internal.zzv.zzC().zze(this.zzb, zzcfgVar.zzG(), true);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfD)).booleanValue()) {
                            zzdsj zzdsjVar = this.zze;
                            String str = zze != null ? "1" : "0";
                            zzdsi zza = zzdsjVar.zza();
                            zza.zzb("omid_js_session_success", str);
                            zza.zzj();
                        }
                        if (zze == null) {
                            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to create javascript session service.");
                            return false;
                        }
                        int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Created omid javascript session service.");
                        this.zzf = zze;
                        zzcfgVar.zzas(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final synchronized void zzf(zzcfx zzcfxVar) {
        zzcfg zzcfgVar;
        zzflw zzflwVar = this.zzf;
        if (zzflwVar == null || (zzcfgVar = this.zzd) == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzC().zzm(zzflwVar, zzcfxVar);
        this.zzf = null;
        zzcfgVar.zzas(null);
    }
}
