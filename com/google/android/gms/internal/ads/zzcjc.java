package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcjc implements zzdtm {
    private final Long zza;
    private final String zzb;
    private final zzcio zzc;
    private final zzcje zzd;

    zzcjc(zzcio zzcioVar, zzcje zzcjeVar, Long l, String str) {
        this.zzc = zzcioVar;
        this.zzd = zzcjeVar;
        this.zza = l;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final zzdtw zza() {
        Context context;
        zzcje zzcjeVar = this.zzd;
        long longValue = this.zza.longValue();
        context = zzcjeVar.zze;
        return zzdtx.zza(longValue, context, zzcjeVar.zzc(), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final zzdua zzb() {
        Context context;
        zzcje zzcjeVar = this.zzd;
        long longValue = this.zza.longValue();
        context = zzcjeVar.zze;
        return zzdub.zza(longValue, context, zzcjeVar.zzc(), this.zzc, this.zzb);
    }
}
