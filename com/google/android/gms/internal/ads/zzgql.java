package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgql extends zzgqo {
    private final int zza;
    private final int zzb;
    private final zzgqj zzc;
    private final zzgqi zzd;

    /* synthetic */ zzgql(int i, int i2, zzgqj zzgqjVar, zzgqi zzgqiVar, zzgqk zzgqkVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgqjVar;
        this.zzd = zzgqiVar;
    }

    public static zzgqh zze() {
        return new zzgqh(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgql)) {
            return false;
        }
        zzgql zzgqlVar = (zzgql) obj;
        return zzgqlVar.zza == this.zza && zzgqlVar.zzd() == zzd() && zzgqlVar.zzc == this.zzc && zzgqlVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzgql.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        zzgqi zzgqiVar = this.zzd;
        return "HMAC Parameters (variant: " + String.valueOf(this.zzc) + ", hashType: " + String.valueOf(zzgqiVar) + ", " + this.zzb + "-byte tags, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzc != zzgqj.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        zzgqj zzgqjVar = this.zzc;
        if (zzgqjVar == zzgqj.zzd) {
            return this.zzb;
        }
        if (zzgqjVar == zzgqj.zza || zzgqjVar == zzgqj.zzb || zzgqjVar == zzgqj.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgqi zzf() {
        return this.zzd;
    }

    public final zzgqj zzg() {
        return this.zzc;
    }
}
