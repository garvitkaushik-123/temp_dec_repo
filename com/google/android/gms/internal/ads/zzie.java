package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzie {
    public final String zza;
    public final zzz zzb;
    public final zzz zzc;
    public final int zzd;
    public final int zze;

    public zzie(String str, zzz zzzVar, zzz zzzVar2, int i, int i2) {
        boolean z = true;
        if (i != 0) {
            if (i2 == 0) {
                i2 = 0;
            } else {
                z = false;
            }
        }
        zzdd.zzd(z);
        zzdd.zzc(str);
        this.zza = str;
        this.zzb = zzzVar;
        zzzVar2.getClass();
        this.zzc = zzzVar2;
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzie zzieVar = (zzie) obj;
            if (this.zzd == zzieVar.zzd && this.zze == zzieVar.zze && this.zza.equals(zzieVar.zza) && this.zzb.equals(zzieVar.zzb) && this.zzc.equals(zzieVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzd + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
