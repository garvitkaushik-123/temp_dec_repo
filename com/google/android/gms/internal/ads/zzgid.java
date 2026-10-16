package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgid extends zzgga {
    private final zzgic zza;

    private zzgid(zzgic zzgicVar) {
        this.zza = zzgicVar;
    }

    public static zzgid zzc(zzgic zzgicVar) {
        return new zzgid(zzgicVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgid) && ((zzgid) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzgid.class, this.zza);
    }

    public final String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.zza.toString() + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zza != zzgic.zzc;
    }

    public final zzgic zzb() {
        return this.zza;
    }
}
