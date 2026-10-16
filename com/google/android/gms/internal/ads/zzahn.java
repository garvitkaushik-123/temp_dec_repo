package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzahn {
    public final long zza;
    public final long zzb;
    public final int zzc;

    public zzahn(long j, long j2, int i) {
        zzdd.zzd(j < j2);
        this.zza = j;
        this.zzb = j2;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzahn zzahnVar = (zzahn) obj;
            if (this.zza == zzahnVar.zza && this.zzb == zzahnVar.zzb && this.zzc == zzahnVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public final String toString() {
        Object[] objArr = {Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc)};
        String str = zzex.zza;
        return String.format(Locale.US, "Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", objArr);
    }
}
