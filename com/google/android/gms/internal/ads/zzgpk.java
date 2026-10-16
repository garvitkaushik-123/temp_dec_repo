package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgpk {

    @Nullable
    private zzgpu zza = null;

    @Nullable
    private zzgxf zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgpk() {
    }

    /* synthetic */ zzgpk(zzgpl zzgplVar) {
    }

    public final zzgpk zza(zzgxf zzgxfVar) throws GeneralSecurityException {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzgpk zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgpk zzc(zzgpu zzgpuVar) {
        this.zza = zzgpuVar;
        return this;
    }

    public final zzgpm zzd() throws GeneralSecurityException {
        zzgxf zzgxfVar;
        zzgxe zza;
        zzgpu zzgpuVar = this.zza;
        if (zzgpuVar == null || (zzgxfVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgpuVar.zzc() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgpuVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzgps.zzd) {
            zza = zzgnz.zza;
        } else if (this.zza.zzf() == zzgps.zzc || this.zza.zzf() == zzgps.zzb) {
            zza = zzgnz.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzgps.zza) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzf()))));
            }
            zza = zzgnz.zzb(this.zzc.intValue());
        }
        return new zzgpm(this.zza, this.zzb, zza, this.zzc, null);
    }
}
