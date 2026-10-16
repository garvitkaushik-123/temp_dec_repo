package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzxp {
    public final long zza;
    public final long zzb;

    public zzxp(long j, long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxp)) {
            return false;
        }
        zzxp zzxpVar = (zzxp) obj;
        return this.zza == zzxpVar.zza && this.zzb == zzxpVar.zzb;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
