package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbnt implements zzbkf {
    final /* synthetic */ long zza;
    final /* synthetic */ zzboh zzb;
    final /* synthetic */ zzbnd zzc;
    final /* synthetic */ zzboi zzd;

    zzbnt(zzboi zzboiVar, long j, zzboh zzbohVar, zzbnd zzbndVar) {
        this.zza = j;
        this.zzb = zzbohVar;
        this.zzc = zzbndVar;
        Objects.requireNonNull(zzboiVar);
        this.zzd = zzboiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        Object obj2;
        com.google.android.gms.ads.internal.util.zze.zza("onGmsg /jsLoaded. JsLoaded latency is " + (com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - this.zza) + " ms.");
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        zzboi zzboiVar = this.zzd;
        obj2 = zzboiVar.zza;
        synchronized (obj2) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            zzboh zzbohVar = this.zzb;
            if (zzbohVar.zze() != -1 && zzbohVar.zze() != 1) {
                zzboiVar.zzi = 0;
                zzbnd zzbndVar = this.zzc;
                zzbnd zzbndVar2 = zzbndVar;
                zzbndVar.zzq("/log", zzbke.zzg);
                zzbndVar.zzq("/result", zzbke.zzo);
                zzbohVar.zzi(zzbndVar);
                zzboiVar.zzh = zzbohVar;
                com.google.android.gms.ads.internal.util.zze.zza("Successfully loaded JS Engine.");
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
