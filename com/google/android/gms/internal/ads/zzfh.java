package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfh implements zzau {
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzfh(long j, long j2, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfh)) {
            return false;
        }
        zzfh zzfhVar = (zzfh) obj;
        return this.zza == zzfhVar.zza && this.zzb == zzfhVar.zzb && this.zzc == zzfhVar.zzc;
    }

    public final int hashCode() {
        long j = this.zza;
        long j2 = this.zzb;
        return ((((((int) (j ^ (j >>> 32))) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.zza + ", modification time=" + this.zzb + ", timescale=" + this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final /* synthetic */ void zza(zzar zzarVar) {
    }
}
