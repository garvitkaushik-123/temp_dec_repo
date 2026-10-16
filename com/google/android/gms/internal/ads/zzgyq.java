package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgyq {
    private final Object zza;
    private final int zzb;

    zzgyq(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgyq)) {
            return false;
        }
        zzgyq zzgyqVar = (zzgyq) obj;
        return this.zza == zzgyqVar.zza && this.zzb == zzgyqVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
