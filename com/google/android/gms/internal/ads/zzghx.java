package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzghx extends zzgga {
    private final int zza;
    private final zzghv zzb;

    /* synthetic */ zzghx(int i, zzghv zzghvVar, zzghw zzghwVar) {
        this.zza = i;
        this.zzb = zzghvVar;
    }

    public static zzghu zzc() {
        return new zzghu(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghx)) {
            return false;
        }
        zzghx zzghxVar = (zzghx) obj;
        return zzghxVar.zza == this.zza && zzghxVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzghx.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        return "AesGcmSiv Parameters (variant: " + String.valueOf(this.zzb) + ", " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzb != zzghv.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzghv zzd() {
        return this.zzb;
    }
}
