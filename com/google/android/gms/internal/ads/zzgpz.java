package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgpz {

    @Nullable
    private zzgql zza = null;

    @Nullable
    private zzgxf zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgpz() {
    }

    /* synthetic */ zzgpz(zzgqa zzgqaVar) {
    }

    public final zzgpz zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgpz zzb(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzgpz zzc(zzgql zzgqlVar) {
        this.zza = zzgqlVar;
        return this;
    }

    public final zzgqb zzd() throws GeneralSecurityException {
        zzgxf zzgxfVar;
        zzgxe zza;
        zzgql zzgqlVar = this.zza;
        if (zzgqlVar == null || (zzgxfVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgqlVar.zzc() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgqlVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzg() == zzgqj.zzd) {
            zza = zzgnz.zza;
        } else if (this.zza.zzg() == zzgqj.zzc || this.zza.zzg() == zzgqj.zzb) {
            zza = zzgnz.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzg() != zzgqj.zza) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzg()))));
            }
            zza = zzgnz.zzb(this.zzc.intValue());
        }
        return new zzgqb(this.zza, this.zzb, zza, this.zzc, null);
    }
}
