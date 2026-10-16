package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgpu extends zzgqo {
    private final int zza;
    private final int zzb;
    private final zzgps zzc;

    /* synthetic */ zzgpu(int i, int i2, zzgps zzgpsVar, zzgpt zzgptVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgpsVar;
    }

    public static zzgpr zze() {
        return new zzgpr(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpu)) {
            return false;
        }
        zzgpu zzgpuVar = (zzgpu) obj;
        return zzgpuVar.zza == this.zza && zzgpuVar.zzd() == zzd() && zzgpuVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(zzgpu.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + String.valueOf(this.zzc) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzc != zzgps.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgps zzgpsVar = this.zzc;
        if (zzgpsVar == zzgps.zzd) {
            return this.zzb;
        }
        if (zzgpsVar == zzgps.zza || zzgpsVar == zzgps.zzb || zzgpsVar == zzgps.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgps zzf() {
        return this.zzc;
    }
}
