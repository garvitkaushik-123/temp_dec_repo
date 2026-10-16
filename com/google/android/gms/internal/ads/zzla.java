package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzla {
    public final long zza;
    public final float zzb;
    public final long zzc;

    /* synthetic */ zzla(zzky zzkyVar, zzkz zzkzVar) {
        long j;
        float f;
        long j2;
        j = zzkyVar.zza;
        this.zza = j;
        f = zzkyVar.zzb;
        this.zzb = f;
        j2 = zzkyVar.zzc;
        this.zzc = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzla)) {
            return false;
        }
        zzla zzlaVar = (zzla) obj;
        return this.zza == zzlaVar.zza && this.zzb == zzlaVar.zzb && this.zzc == zzlaVar.zzc;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    public final zzky zza() {
        return new zzky(this, null);
    }
}
