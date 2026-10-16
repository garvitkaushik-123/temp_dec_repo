package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbnu implements zzbkf {
    final /* synthetic */ zzbnd zza;
    final /* synthetic */ com.google.android.gms.ads.internal.util.zzby zzb;
    final /* synthetic */ zzboi zzc;

    zzbnu(zzboi zzboiVar, zzavu zzavuVar, zzbnd zzbndVar, com.google.android.gms.ads.internal.util.zzby zzbyVar) {
        this.zza = zzbndVar;
        this.zzb = zzbyVar;
        Objects.requireNonNull(zzboiVar);
        this.zzc = zzboiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        Object obj2;
        int i;
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        zzboi zzboiVar = this.zzc;
        obj2 = zzboiVar.zza;
        synchronized (obj2) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Lock acquired");
            com.google.android.gms.ads.internal.util.client.zzo.zzi("JS Engine is requesting an update");
            i = zzboiVar.zzi;
            if (i == 0) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Starting reload.");
                zzboiVar.zzi = 2;
                zzboiVar.zzd(null);
            }
            this.zza.zzr("/requestReload", (zzbkf) this.zzb.zza());
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
