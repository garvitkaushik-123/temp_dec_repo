package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzghc {

    @Nullable
    private zzghm zza = null;

    @Nullable
    private zzgxf zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzghc() {
    }

    /* synthetic */ zzghc(zzghd zzghdVar) {
    }

    public final zzghc zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzghc zzb(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzghc zzc(zzghm zzghmVar) {
        this.zza = zzghmVar;
        return this;
    }

    public final zzghe zzd() throws GeneralSecurityException {
        zzgxf zzgxfVar;
        zzgxe zzb;
        zzghm zzghmVar = this.zza;
        if (zzghmVar == null || (zzgxfVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzghmVar.zzb() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzghmVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzghk.zzc) {
            zzb = zzgnz.zza;
        } else if (this.zza.zzd() == zzghk.zzb) {
            zzb = zzgnz.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzghk.zza) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzd()))));
            }
            zzb = zzgnz.zzb(this.zzc.intValue());
        }
        return new zzghe(this.zza, this.zzb, zzb, this.zzc, null);
    }
}
