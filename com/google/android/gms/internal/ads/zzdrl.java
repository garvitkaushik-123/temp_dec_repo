package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdrl implements zzfhb {
    private final Map zza;
    private final zzbcc zzb;

    zzdrl(zzbcc zzbccVar, Map map) {
        this.zza = map;
        this.zzb = zzbccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzd(zzfgu zzfguVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfguVar)) {
            this.zzb.zzc(((zzdrk) map.get(zzfguVar)).zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdE(zzfgu zzfguVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdF(zzfgu zzfguVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzfguVar)) {
            this.zzb.zzc(((zzdrk) map.get(zzfguVar)).zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhb
    public final void zzdG(zzfgu zzfguVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfguVar)) {
            this.zzb.zzc(((zzdrk) map.get(zzfguVar)).zza);
        }
    }
}
