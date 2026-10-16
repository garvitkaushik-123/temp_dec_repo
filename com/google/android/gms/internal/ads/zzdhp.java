package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdhp {
    private final JSONObject zza;
    private final zzdny zzb;
    private final com.google.android.gms.ads.internal.zzb zzc;
    private final zzbya zzd;

    public zzdhp(JSONObject jSONObject, zzdny zzdnyVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        this.zza = jSONObject;
        this.zzb = zzdnyVar;
        this.zzc = zzbVar;
        this.zzd = zzbyaVar;
    }

    final com.google.android.gms.ads.internal.zzb zza() {
        return this.zzc;
    }

    final zzbya zzb() {
        return this.zzd;
    }

    public final zzdny zzc() {
        return this.zzb;
    }

    public final JSONObject zzd() {
        return this.zza;
    }
}
