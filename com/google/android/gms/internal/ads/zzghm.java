package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzghm extends zzgga {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzghk zzd;

    /* synthetic */ zzghm(int i, int i2, int i3, zzghk zzghkVar, zzghl zzghlVar) {
        this.zza = i;
        this.zzd = zzghkVar;
    }

    public static zzghj zzc() {
        return new zzghj(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghm)) {
            return false;
        }
        zzghm zzghmVar = (zzghm) obj;
        if (zzghmVar.zza == this.zza) {
            int i = zzghmVar.zzb;
            int i2 = zzghmVar.zzc;
            if (zzghmVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzghm.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        return "AesGcm Parameters (variant: " + String.valueOf(this.zzd) + ", 12-byte IV, 16-byte tag, and " + this.zza + "-byte key)";
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzd != zzghk.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzghk zzd() {
        return this.zzd;
    }
}
