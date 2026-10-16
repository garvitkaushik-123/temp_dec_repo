package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgnd extends zzgez {
    private final zzgox zza;
    private final zzgxe zzb;

    public zzgnd(zzgox zzgoxVar, @Nullable zzgfn zzgfnVar) throws GeneralSecurityException {
        zzgxe zza;
        zze(zzgoxVar, zzgfnVar);
        this.zza = zzgoxVar;
        if (zzgoxVar.zzc().equals(zzgvf.RAW)) {
            zza = zzgxe.zzb(new byte[0]);
        } else if (zzgoxVar.zzc().equals(zzgvf.TINK)) {
            zza = zzgnz.zzb(zzgoxVar.zzf().intValue());
        } else {
            if (!zzgoxVar.zzc().equals(zzgvf.LEGACY) && !zzgoxVar.zzc().equals(zzgvf.CRUNCHY)) {
                throw new GeneralSecurityException("Unknown output prefix type");
            }
            zza = zzgnz.zza(zzgoxVar.zzf().intValue());
        }
        this.zzb = zza;
    }

    private static void zze(zzgox zzgoxVar, @Nullable zzgfn zzgfnVar) throws GeneralSecurityException {
        int i = zzgna.zzb[zzgoxVar.zzb().ordinal()];
    }

    @Override // com.google.android.gms.internal.ads.zzgez
    public final zzgfm zza() {
        zzgox zzgoxVar = this.zza;
        return new zzgnb(zzgoxVar.zzg(), zzgoxVar.zzc(), null);
    }

    public final zzgox zzb(@Nullable zzgfn zzgfnVar) throws GeneralSecurityException {
        zzgox zzgoxVar = this.zza;
        zze(zzgoxVar, zzgfnVar);
        return zzgoxVar;
    }

    public final zzgxe zzc() {
        return this.zzb;
    }

    @Nullable
    public final Integer zzd() {
        return this.zza.zzf();
    }
}
