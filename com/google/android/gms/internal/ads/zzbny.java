package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbny implements zzcam {
    final /* synthetic */ zzboh zza;
    final /* synthetic */ zzfhj zzb;
    final /* synthetic */ zzboi zzc;

    zzbny(zzboi zzboiVar, zzboh zzbohVar, zzfhj zzfhjVar) {
        this.zza = zzbohVar;
        this.zzb = zzfhjVar;
        Objects.requireNonNull(zzboiVar);
        this.zzc = zzboiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza() {
        Object obj;
        zzfhx zzfhxVar;
        zzfhx zzfhxVar2;
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        zzboi zzboiVar = this.zzc;
        obj = zzboiVar.zza;
        synchronized (obj) {
            com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            zzboiVar.zzi = 1;
            com.google.android.gms.ads.internal.util.zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbex.zzd.zze()).booleanValue()) {
                zzfhxVar = zzboiVar.zze;
                if (zzfhxVar != null) {
                    zzfhxVar2 = zzboiVar.zze;
                    zzfhj zzfhjVar = this.zzb;
                    zzfhjVar.zzc("Failed loading new engine");
                    zzfhjVar.zzg(false);
                    zzfhxVar2.zzc(zzfhjVar.zzm());
                }
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
