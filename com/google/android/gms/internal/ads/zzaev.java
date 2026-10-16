package com.google.android.gms.internal.ads;

import com.ironsource.C3040d4;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaev {
    public static final zzaev zza = new zzaev(0, 0);
    public final long zzb;
    public final long zzc;

    public zzaev(long j, long j2) {
        this.zzb = j;
        this.zzc = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaev zzaevVar = (zzaev) obj;
            if (this.zzb == zzaevVar.zzb && this.zzc == zzaevVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        return "[timeUs=" + this.zzb + ", position=" + this.zzc + C3040d4.i.e;
    }
}
