package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfsi extends zzgcb {
    Object zza;

    zzfsi(Object obj, Runnable runnable) {
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final String zza() {
        Object obj = this.zza;
        return obj == null ? "" : obj.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    protected final void zzb() {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final boolean zzc(Object obj) {
        return super.zzc(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final boolean zzd(Throwable th) {
        return super.zzd(th);
    }
}
