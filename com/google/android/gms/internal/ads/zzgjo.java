package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgjo extends zzgfz {
    private final zzgjt zza;
    private final zzgxf zzb;
    private final zzgxe zzc;

    @Nullable
    private final Integer zzd;

    private zzgjo(zzgjt zzgjtVar, zzgxf zzgxfVar, zzgxe zzgxeVar, @Nullable Integer num) {
        this.zza = zzgjtVar;
        this.zzb = zzgxfVar;
        this.zzc = zzgxeVar;
        this.zzd = num;
    }

    public static zzgjo zzc(zzgjt zzgjtVar, zzgxf zzgxfVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgxe zzb;
        zzgjs zzc = zzgjtVar.zzc();
        zzgjs zzgjsVar = zzgjs.zzb;
        if (zzc != zzgjsVar && num == null) {
            throw new GeneralSecurityException("For given Variant " + zzgjtVar.zzc().toString() + " the value of idRequirement must be non-null");
        }
        if (zzgjtVar.zzc() == zzgjsVar && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgxfVar.zza() != 32) {
            throw new GeneralSecurityException("XAesGcmKey key must be constructed with key of length 32 bytes, not " + zzgxfVar.zza());
        }
        if (zzgjtVar.zzc() == zzgjsVar) {
            zzb = zzgnz.zza;
        } else {
            if (zzgjtVar.zzc() != zzgjs.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzgjtVar.zzc().toString()));
            }
            zzb = zzgnz.zzb(num.intValue());
        }
        return new zzgjo(zzgjtVar, zzgxfVar, zzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgfz, com.google.android.gms.internal.ads.zzgez
    public final /* synthetic */ zzgfm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final zzgxe zzb() {
        return this.zzc;
    }

    public final zzgjt zzd() {
        return this.zza;
    }

    public final zzgxf zze() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzf() {
        return this.zzd;
    }
}
