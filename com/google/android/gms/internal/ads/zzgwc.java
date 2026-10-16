package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgwc implements zzget {
    private static final ThreadLocal zza = new zzgwa();
    private static final ThreadLocal zzb = new zzgwb();
    private final byte[] zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final SecretKeySpec zzf;
    private final int zzg;

    private zzgwc(byte[] bArr, int i, byte[] bArr2) throws GeneralSecurityException {
        if (!zzgmg.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzg = i;
        zzgxc.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzf = secretKeySpec;
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, secretKeySpec);
        byte[] zzd = zzd(cipher.doFinal(new byte[16]));
        this.zzc = zzd;
        this.zzd = zzd(zzd);
        this.zze = bArr2;
    }

    public static zzget zzb(zzggu zzgguVar) throws GeneralSecurityException {
        if (zzgmg.zza(1)) {
            return new zzgwc(zzgguVar.zze().zzd(zzgey.zza()), zzgguVar.zzd().zzb(), zzgguVar.zzb().zzd());
        }
        throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
    }

    private static void zzc(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    private static byte[] zzd(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            byte b = bArr[i];
            int i2 = i + 1;
            bArr2[i] = (byte) (((b + b) ^ ((bArr[i2] & 255) >>> 7)) & 255);
            i = i2;
        }
        byte b2 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (b2 + b2));
        return bArr2;
    }

    private final byte[] zze(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int length;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i3 == 0) {
            zzc(bArr2, this.zzc);
            return cipher.doFinal(bArr2);
        }
        byte[] bArr3 = new byte[16];
        cipher.doFinal(bArr2, 0, 16, bArr3);
        byte[] bArr4 = bArr3;
        byte[] bArr5 = bArr2;
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArr4[i5] = (byte) (bArr[(i2 + i4) + i5] ^ bArr4[i5]);
            }
            cipher.doFinal(bArr4, 0, 16, bArr5);
            i4 += 16;
            byte[] bArr6 = bArr4;
            bArr4 = bArr5;
            bArr5 = bArr6;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            zzc(copyOfRange, this.zzc);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzd, 16);
            int i6 = 0;
            while (true) {
                length = copyOfRange.length;
                if (i6 >= length) {
                    break;
                }
                copyOf[i6] = (byte) (copyOf[i6] ^ copyOfRange[i6]);
                i6++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ 128);
            copyOfRange = copyOf;
        }
        zzc(bArr4, copyOfRange);
        cipher.doFinal(bArr4, 0, 16, bArr5);
        return bArr5;
    }

    @Override // com.google.android.gms.internal.ads.zzget
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zze;
        int length = bArr.length;
        int length2 = bArr3.length;
        int i = this.zzg;
        int i2 = ((length - length2) - i) - 16;
        if (i2 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzgpj.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher cipher = (Cipher) zza.get();
        SecretKeySpec secretKeySpec = this.zzf;
        cipher.init(1, secretKeySpec);
        byte[] zze = zze(cipher, 0, bArr, length2, i);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] zze2 = zze(cipher, 1, bArr4, 0, bArr4.length);
        byte[] zze3 = zze(cipher, 2, bArr, length2 + i, i2);
        int i3 = length - 16;
        byte b = 0;
        for (int i4 = 0; i4 < 16; i4++) {
            b = (byte) (b | (((bArr[i3 + i4] ^ zze2[i4]) ^ zze[i4]) ^ zze3[i4]));
        }
        if (b != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) zzb.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(zze));
        return cipher2.doFinal(bArr, bArr3.length + i, i2);
    }
}
