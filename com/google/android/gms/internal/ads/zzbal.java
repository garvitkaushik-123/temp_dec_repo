package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbal {
    final long zza;
    final String zzb;
    final int zzc;

    zzbal(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbal)) {
            return false;
        }
        zzbal zzbalVar = (zzbal) obj;
        return zzbalVar.zza == this.zza && zzbalVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
