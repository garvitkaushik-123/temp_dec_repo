package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbnx implements zzcao {
    final /* synthetic */ zzboh zza;
    final /* synthetic */ zzfhj zzb;
    final /* synthetic */ zzboi zzc;

    zzbnx(zzboi zzboiVar, zzboh zzbohVar, zzfhj zzfhjVar) {
        this.zza = zzbohVar;
        this.zzb = zzfhjVar;
        Objects.requireNonNull(zzboiVar);
        this.zzc = zzboiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcao
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Object obj2;
        zzboh zzbohVar;
        zzfhx zzfhxVar;
        zzfhx zzfhxVar2;
        zzboh zzbohVar2;
        zzboh zzbohVar3;
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Trying to acquire lock");
        zzboi zzboiVar = this.zzc;
        obj2 = zzboiVar.zza;
        synchronized (obj2) {
            com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock acquired");
            zzboiVar.zzi = 0;
            zzbohVar = zzboiVar.zzh;
            if (zzbohVar != null) {
                zzboh zzbohVar4 = this.zza;
                zzbohVar2 = zzboiVar.zzh;
                if (zzbohVar4 != zzbohVar2) {
                    com.google.android.gms.ads.internal.util.zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                    zzbohVar3 = zzboiVar.zzh;
                    zzbohVar3.zzb();
                }
            }
            zzboiVar.zzh = this.zza;
            if (((Boolean) zzbex.zzd.zze()).booleanValue()) {
                zzfhxVar = zzboiVar.zze;
                if (zzfhxVar != null) {
                    zzfhxVar2 = zzboiVar.zze;
                    zzfhj zzfhjVar = this.zzb;
                    zzfhjVar.zzg(true);
                    zzfhxVar2.zzc(zzfhjVar.zzm());
                }
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock released");
    }
}
