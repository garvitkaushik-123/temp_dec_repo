package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbnw implements Runnable {
    final /* synthetic */ zzboh zza;
    final /* synthetic */ zzbnd zzb;
    final /* synthetic */ ArrayList zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzboi zze;

    zzbnw(zzboi zzboiVar, zzboh zzbohVar, zzbnd zzbndVar, ArrayList arrayList, long j) {
        this.zza = zzbohVar;
        this.zzb = zzbndVar;
        this.zzc = arrayList;
        this.zzd = j;
        Objects.requireNonNull(zzboiVar);
        this.zze = zzboiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        int i;
        String str;
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Trying to acquire lock");
        zzboi zzboiVar = this.zze;
        obj = zzboiVar.zza;
        synchronized (obj) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock acquired");
            zzboh zzbohVar = this.zza;
            if (zzbohVar.zze() != -1 && zzbohVar.zze() != 1) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhZ)).booleanValue()) {
                    zzbohVar.zzh(new TimeoutException("Unable to fully load JS engine."), "SdkJavascriptFactory.loadJavascriptEngine.Runnable");
                } else {
                    zzbohVar.zzg();
                }
                zzgdy zzgdyVar = zzcaf.zzf;
                final zzbnd zzbndVar = this.zzb;
                Objects.requireNonNull(zzbndVar);
                zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnv
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbnd.this.zzc();
                    }
                });
                String valueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzd));
                int zze = zzbohVar.zze();
                i = zzboiVar.zzi;
                ArrayList arrayList = this.zzc;
                if (arrayList.isEmpty()) {
                    str = ". Still waiting for the engine to be loaded";
                } else {
                    str = ". While waiting for the /jsLoaded gmsg, observed the loadNewJavascriptEngine latency is " + String.valueOf(arrayList.get(0));
                }
                com.google.android.gms.ads.internal.util.zze.zza("Could not finish the full JS engine loading in " + valueOf + " ms. JS engine session reference status(fullLoadTimeout) is " + zze + ". Update status(fullLoadTimeout) is " + i + str + " ms. Total latency(fullLoadTimeout) is " + (com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - this.zzd) + " ms at timeout. Rejecting.");
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released, the promise is already settled");
        }
    }
}
