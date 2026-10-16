package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgwy implements zzgro {
    private static final ThreadLocal zza = new zzgwx();
    private final SecretKey zzb;
    private final byte[] zzc;
    private final byte[] zzd;

    public zzgwy(byte[] bArr) throws GeneralSecurityException {
        zzgxc.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzb = secretKeySpec;
        Cipher zzb = zzb();
        zzb.init(1, secretKeySpec);
        byte[] zza2 = zzgrf.zza(zzb.doFinal(new byte[16]));
        this.zzc = zza2;
        this.zzd = zzgrf.zza(zza2);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzgmg.zza(1)) {
            return (Cipher) zza.get();
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    private static void zzc(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2 + i]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgro
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        byte[] zzc;
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        SecretKey secretKey = this.zzb;
        Cipher zzb = zzb();
        zzb.init(1, secretKey);
        int length = bArr.length;
        int i2 = length != 0 ? 1 + ((length - 1) >> 4) : 1;
        int i3 = i2 - 1;
        int i4 = i3 * 16;
        if (i2 * 16 == length) {
            zzc = zzgwe.zzc(bArr, i4, this.zzc, 0, 16);
        } else {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i4, length);
            int length2 = copyOfRange.length;
            if (length2 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] copyOf = Arrays.copyOf(copyOfRange, 16);
            copyOf[length2] = Byte.MIN_VALUE;
            byte[] bArr2 = this.zzd;
            if (copyOf.length != 16) {
                throw new IllegalArgumentException("The lengths of x and y should match.");
            }
            zzc = zzgwe.zzc(copyOf, 0, bArr2, 0, 16);
        }
        byte[] bArr3 = new byte[16];
        byte[] bArr4 = new byte[16];
        for (int i5 = 0; i5 < i3; i5++) {
            zzc(bArr3, bArr, i5 * 16, bArr4);
            if (zzb.doFinal(bArr4, 0, 16, bArr3) != 16) {
                throw new IllegalStateException("Cipher didn't write full block");
            }
        }
        zzc(bArr3, zzc, 0, bArr4);
        if (zzb.doFinal(bArr4, 0, 16, bArr3) == 16) {
            return i == 16 ? bArr3 : Arrays.copyOf(bArr3, i);
        }
        throw new IllegalStateException("Cipher didn't write full block");
    }
}
