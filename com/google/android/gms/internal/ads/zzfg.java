package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfg implements zzau {
    public final float zza;
    public final float zzb;

    public zzfg(float f, float f2) {
        boolean z = false;
        if (f >= -90.0f && f <= 90.0f && f2 >= -180.0f && f2 <= 180.0f) {
            z = true;
        }
        zzdd.zze(z, "Invalid latitude or longitude");
        this.zza = f;
        this.zzb = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzfg zzfgVar = (zzfg) obj;
            if (this.zza == zzfgVar.zza && this.zzb == zzfgVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToIntBits(this.zza) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + Float.floatToIntBits(this.zzb);
    }

    public final String toString() {
        return "xyz: latitude=" + this.zza + ", longitude=" + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final /* synthetic */ void zza(zzar zzarVar) {
    }
}
