package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzggs {

    @Nullable
    private zzghb zza = null;

    @Nullable
    private zzgxf zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzggs() {
    }

    /* synthetic */ zzggs(zzggt zzggtVar) {
    }

    public final zzggs zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzggs zzb(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzggs zzc(zzghb zzghbVar) {
        this.zza = zzghbVar;
        return this;
    }

    public final zzggu zzd() throws GeneralSecurityException {
        zzgxf zzgxfVar;
        zzgxe zzb;
        zzghb zzghbVar = this.zza;
        if (zzghbVar == null || (zzgxfVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzghbVar.zzc() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzghbVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zze() == zzggz.zzc) {
            zzb = zzgnz.zza;
        } else if (this.zza.zze() == zzggz.zzb) {
            zzb = zzgnz.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzggz.zza) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zze()))));
            }
            zzb = zzgnz.zzb(this.zzc.intValue());
        }
        return new zzggu(this.zza, this.zzb, zzb, this.zzc, null);
    }
}
