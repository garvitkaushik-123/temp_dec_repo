package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcqs {
    private final zzcyv zza;
    private final zzdbb zzb;

    public zzcqs(zzcyv zzcyvVar, zzdbb zzdbbVar) {
        this.zza = zzcyvVar;
        this.zzb = zzdbbVar;
    }

    public final zzcyv zza() {
        return this.zza;
    }

    final zzdbb zzb() {
        return this.zzb;
    }

    final zzddv zzc() {
        zzdbb zzdbbVar = this.zzb;
        return zzdbbVar != null ? new zzddv(zzdbbVar, zzcaf.zzg) : new zzddv(new zzcqr(this), zzcaf.zzg);
    }
}
