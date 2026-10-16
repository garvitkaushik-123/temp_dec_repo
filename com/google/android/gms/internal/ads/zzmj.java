package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@Deprecated
/* loaded from: classes5.dex */
public final class zzmj {
    private final zziw zza;

    @Deprecated
    public zzmj(Context context, zzcem zzcemVar) {
        this.zza = new zziw(context, zzcemVar);
    }

    @Deprecated
    public final zzmj zza(final zzkx zzkxVar) {
        zziw zziwVar = this.zza;
        zzdd.zzf(!zziwVar.zzs);
        zzkxVar.getClass();
        zziwVar.zzf = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzio
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return zzkx.this;
            }
        };
        return this;
    }

    @Deprecated
    public final zzmj zzb(final zzzd zzzdVar) {
        zziw zziwVar = this.zza;
        zzdd.zzf(!zziwVar.zzs);
        zzzdVar.getClass();
        zziwVar.zze = new zzfwh() { // from class: com.google.android.gms.internal.ads.zziv
            @Override // com.google.android.gms.internal.ads.zzfwh
            public final Object zza() {
                return zzzd.this;
            }
        };
        return this;
    }

    @Deprecated
    public final zzmk zzc() {
        zziw zziwVar = this.zza;
        zzdd.zzf(!zziwVar.zzs);
        zziwVar.zzs = true;
        return new zzmk(zziwVar);
    }
}
