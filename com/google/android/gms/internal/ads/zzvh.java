package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzvh {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    public zzvh(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    private zzvh(Object obj, int i, int i2, long j, int i3) {
        this.zza = obj;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = i3;
    }

    public zzvh(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvh)) {
            return false;
        }
        zzvh zzvhVar = (zzvh) obj;
        return this.zza.equals(zzvhVar.zza) && this.zzb == zzvhVar.zzb && this.zzc == zzvhVar.zzc && this.zzd == zzvhVar.zzd && this.zze == zzvhVar.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzvh zza(Object obj) {
        return this.zza.equals(obj) ? this : new zzvh(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzvh(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
