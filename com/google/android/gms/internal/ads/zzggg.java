package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzggg {

    @Nullable
    private zzggr zza = null;

    @Nullable
    private zzgxf zzb = null;

    @Nullable
    private zzgxf zzc = null;

    @Nullable
    private Integer zzd = null;

    private zzggg() {
    }

    /* synthetic */ zzggg(zzggh zzgghVar) {
    }

    public final zzggg zza(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzggg zzb(zzgxf zzgxfVar) {
        this.zzc = zzgxfVar;
        return this;
    }

    public final zzggg zzc(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzggg zzd(zzggr zzggrVar) {
        this.zza = zzggrVar;
        return this;
    }

    public final zzggi zze() throws GeneralSecurityException {
        zzgxe zzb;
        zzggr zzggrVar = this.zza;
        if (zzggrVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        zzgxf zzgxfVar = this.zzb;
        if (zzgxfVar == null || this.zzc == null) {
            throw new GeneralSecurityException("Cannot build without key material");
        }
        if (zzggrVar.zzb() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("AES key size mismatch");
        }
        if (zzggrVar.zzc() != this.zzc.zza()) {
            throw new GeneralSecurityException("HMAC key size mismatch");
        }
        if (this.zza.zza() && this.zzd == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzd != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzh() == zzggp.zzc) {
            zzb = zzgnz.zza;
        } else if (this.zza.zzh() == zzggp.zzb) {
            zzb = zzgnz.zza(this.zzd.intValue());
        } else {
            if (this.zza.zzh() != zzggp.zza) {
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zzh()))));
            }
            zzb = zzgnz.zzb(this.zzd.intValue());
        }
        return new zzggi(this.zza, this.zzb, this.zzc, zzb, this.zzd, null);
    }
}
