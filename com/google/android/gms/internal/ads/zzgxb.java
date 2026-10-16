package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgxb implements zzgfl {
    private static final byte[] zza = {0};
    private final zzgro zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzgxb(zzgpm zzgpmVar) throws GeneralSecurityException {
        this.zzb = new zzgwy(zzgpmVar.zze().zzd(zzgey.zza()));
        this.zzc = zzgpmVar.zzc().zzb();
        this.zzd = zzgpmVar.zzd().zzd();
        if (zzgpmVar.zzc().zzf().equals(zzgps.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzgfl zza(zzgpm zzgpmVar) throws GeneralSecurityException {
        return new zzgxb(zzgpmVar);
    }

    public static zzgfl zzb(zzgqb zzgqbVar) throws GeneralSecurityException {
        return new zzgxb(zzgqbVar);
    }

    public final byte[] zzc(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        return bArr2.length > 0 ? zzgwe.zzb(this.zzd, this.zzb.zza(zzgwe.zzb(bArr, bArr2), this.zzc)) : zzgwe.zzb(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zzgxb(zzgqb zzgqbVar) throws GeneralSecurityException {
        String valueOf = String.valueOf(String.valueOf(zzgqbVar.zzc().zzf()));
        this.zzb = new zzgxa("HMAC".concat(valueOf), new SecretKeySpec(zzgqbVar.zze().zzd(zzgey.zza()), "HMAC"));
        this.zzc = zzgqbVar.zzc().zzb();
        this.zzd = zzgqbVar.zzd().zzd();
        if (zzgqbVar.zzc().zzg().equals(zzgqj.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzgxb(zzgro zzgroVar, int i) throws GeneralSecurityException {
        this.zzb = zzgroVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzgroVar.zza(new byte[0], i);
    }
}
