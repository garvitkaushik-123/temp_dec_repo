package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgrn implements zzgfl {
    private zzgrn(zzgfl zzgflVar, zzgvf zzgvfVar, byte[] bArr) {
    }

    public static zzgfl zza(zzgnd zzgndVar) throws GeneralSecurityException {
        byte[] zzd;
        zzgox zzb = zzgndVar.zzb(zzgey.zza());
        zzgfl zzgflVar = (zzgfl) zzgmp.zzc().zza(zzb.zzg(), zzgfl.class).zzc(zzb.zze());
        zzgvf zzc = zzb.zzc();
        int ordinal = zzc.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    zzd = zzgnz.zza.zzd();
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type");
                }
            }
            zzd = zzgnz.zza(zzgndVar.zzd().intValue()).zzd();
        } else {
            zzd = zzgnz.zzb(zzgndVar.zzd().intValue()).zzd();
        }
        return new zzgrn(zzgflVar, zzc, zzd);
    }
}
