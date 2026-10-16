package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgqh {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;
    private zzgqi zzc = null;
    private zzgqj zzd = zzgqj.zzd;

    private zzgqh() {
    }

    /* synthetic */ zzgqh(zzgqk zzgqkVar) {
    }

    public final zzgqh zza(zzgqi zzgqiVar) {
        this.zzc = zzgqiVar;
        return this;
    }

    public final zzgqh zzb(int i) throws GeneralSecurityException {
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzgqh zzc(int i) throws GeneralSecurityException {
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzgqh zzd(zzgqj zzgqjVar) {
        this.zzd = zzgqjVar;
        return this;
    }

    public final zzgql zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
        }
        int intValue = this.zzb.intValue();
        zzgqi zzgqiVar = this.zzc;
        if (intValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(intValue)));
        }
        if (zzgqiVar == zzgqi.zza) {
            if (intValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", Integer.valueOf(intValue)));
            }
        } else if (zzgqiVar == zzgqi.zzb) {
            if (intValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", Integer.valueOf(intValue)));
            }
        } else if (zzgqiVar == zzgqi.zzc) {
            if (intValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", Integer.valueOf(intValue)));
            }
        } else if (zzgqiVar == zzgqi.zzd) {
            if (intValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", Integer.valueOf(intValue)));
            }
        } else {
            if (zzgqiVar != zzgqi.zze) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (intValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(intValue)));
            }
        }
        return new zzgql(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
    }
}
