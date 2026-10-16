package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzghb extends zzgga {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzggz zzd;

    /* synthetic */ zzghb(int i, int i2, int i3, zzggz zzggzVar, zzgha zzghaVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzggzVar;
    }

    public static zzggy zzd() {
        return new zzggy(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghb)) {
            return false;
        }
        zzghb zzghbVar = (zzghb) obj;
        if (zzghbVar.zza == this.zza && zzghbVar.zzb == this.zzb) {
            int i = zzghbVar.zzc;
            if (zzghbVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzghb.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        return "AesEax Parameters (variant: " + String.valueOf(this.zzd) + ", " + this.zzb + "-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzd != zzggz.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzggz zze() {
        return this.zzd;
    }
}
