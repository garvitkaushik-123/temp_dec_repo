package com.google.android.gms.internal.ads;

import com.ironsource.C3040d4;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaes {
    public final zzaev zza;
    public final zzaev zzb;

    public zzaes(zzaev zzaevVar, zzaev zzaevVar2) {
        this.zza = zzaevVar;
        this.zzb = zzaevVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaes zzaesVar = (zzaes) obj;
            if (this.zza.equals(zzaesVar.zza) && this.zzb.equals(zzaesVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        zzaev zzaevVar = this.zza;
        zzaev zzaevVar2 = this.zzb;
        return C3040d4.i.d + zzaevVar.toString() + (zzaevVar.equals(zzaevVar2) ? "" : ", ".concat(zzaevVar2.toString())) + C3040d4.i.e;
    }
}
