package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzglm implements zzget {
    private final zzget zza;
    private final byte[] zzb;

    private zzglm(zzget zzgetVar, byte[] bArr) {
        this.zza = zzgetVar;
        int length = bArr.length;
        if (length != 0 && length != 5) {
            throw new IllegalArgumentException("identifier has an invalid length");
        }
        this.zzb = bArr;
    }

    public static zzget zzb(zzgnd zzgndVar) throws GeneralSecurityException {
        byte[] zzd;
        zzgox zzb = zzgndVar.zzb(zzgey.zza());
        zzget zzgetVar = (zzget) zzgmp.zzc().zza(zzb.zzg(), zzget.class).zzc(zzb.zze());
        zzgvf zzc = zzb.zzc();
        int ordinal = zzc.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    zzd = zzgnz.zza.zzd();
                } else if (ordinal != 4) {
                    throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(String.valueOf(zzc))));
                }
            }
            zzd = zzgnz.zza(zzgndVar.zzd().intValue()).zzd();
        } else {
            zzd = zzgnz.zzb(zzgndVar.zzd().intValue()).zzd();
        }
        return new zzglm(zzgetVar, zzd);
    }

    public static zzget zzc(zzget zzgetVar, zzgxe zzgxeVar) {
        return new zzglm(zzgetVar, zzgxeVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzget
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        if (bArr3.length == 0) {
            return this.zza.zza(bArr, bArr2);
        }
        if (zzgpj.zzc(bArr3, bArr)) {
            return this.zza.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
