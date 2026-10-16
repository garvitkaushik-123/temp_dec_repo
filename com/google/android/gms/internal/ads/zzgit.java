package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgit extends zzgfz {
    private final zzgiy zza;
    private final zzgxe zzb;

    @Nullable
    private final Integer zzc;

    private zzgit(zzgiy zzgiyVar, zzgxe zzgxeVar, @Nullable Integer num) {
        this.zza = zzgiyVar;
        this.zzb = zzgxeVar;
        this.zzc = num;
    }

    public static zzgit zzc(zzgiy zzgiyVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgxe zzb;
        if (zzgiyVar.zzc() == zzgiw.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzb = zzgnz.zza;
        } else {
            if (zzgiyVar.zzc() != zzgiw.zza) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(String.valueOf(zzgiyVar.zzc()))));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzb = zzgnz.zzb(num.intValue());
        }
        return new zzgit(zzgiyVar, zzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgfz, com.google.android.gms.internal.ads.zzgez
    public final /* synthetic */ zzgfm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final zzgxe zzb() {
        return this.zzb;
    }

    public final zzgiy zzd() {
        return this.zza;
    }

    public final Integer zze() {
        return this.zzc;
    }
}
