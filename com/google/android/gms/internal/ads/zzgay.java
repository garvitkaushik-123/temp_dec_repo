package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgay {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean[] zzh;
    private final boolean zzi;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    zzgay(String str, char[] cArr) {
        this(str, cArr, r1, false);
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            boolean z = true;
            zzfvp.zzg(c < 128, "Non-ASCII character: %s", c);
            if (bArr[c] != -1) {
                z = false;
            }
            zzfvp.zzg(z, "Duplicate character: %s", c);
            bArr[c] = (byte) i;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgay) {
            zzgay zzgayVar = (zzgay) obj;
            if (this.zzi == zzgayVar.zzi && Arrays.equals(this.zzf, zzgayVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + (true != this.zzi ? 1237 : 1231);
    }

    public final String toString() {
        return this.zze;
    }

    final char zza(int i) {
        return this.zzf[i];
    }

    final int zzb(char c) throws zzgbb {
        if (c > 127) {
            throw new zzgbb("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c))));
        }
        byte b = this.zzg[c];
        if (b != -1) {
            return b;
        }
        if (c <= ' ' || c == 127) {
            throw new zzgbb("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c))));
        }
        throw new zzgbb("Unrecognized character: " + c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    final zzgay zzc() {
        boolean z;
        int i = 0;
        while (true) {
            char[] cArr = this.zzf;
            int length = cArr.length;
            if (i >= length) {
                return this;
            }
            if (zzfuv.zze(cArr[i])) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    if (zzfuv.zzd(cArr[i2])) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                zzfvp.zzm(!z, "Cannot call lowerCase() on a mixed-case alphabet");
                char[] cArr2 = new char[cArr.length];
                for (int i3 = 0; i3 < cArr.length; i3++) {
                    char c = cArr[i3];
                    if (zzfuv.zze(c)) {
                        c ^= 32;
                    }
                    cArr2[i3] = (char) c;
                }
                zzgay zzgayVar = new zzgay(this.zze.concat(".lowerCase()"), cArr2);
                if (!this.zzi || zzgayVar.zzi) {
                    return zzgayVar;
                }
                byte[] bArr = zzgayVar.zzg;
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                for (int i4 = 65; i4 <= 90; i4++) {
                    int i5 = i4 | 32;
                    byte b = bArr[i4];
                    byte b2 = bArr[i5];
                    if (b == -1) {
                        copyOf[i4] = b2;
                    } else {
                        char c2 = (char) i4;
                        char c3 = (char) i5;
                        if (b2 != -1) {
                            throw new IllegalStateException(zzfwg.zzb("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c2), Character.valueOf(c3)));
                        }
                        copyOf[i5] = b;
                    }
                }
                return new zzgay(zzgayVar.zze.concat(".ignoreCase()"), zzgayVar.zzf, copyOf, true);
            }
            i++;
        }
    }

    final boolean zzd(int i) {
        return this.zzh[i % this.zzc];
    }

    public final boolean zze(char c) {
        byte[] bArr = this.zzg;
        return bArr.length > 61 && bArr[61] != -1;
    }

    private zzgay(String str, char[] cArr, byte[] bArr, boolean z) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int zzc = zzgbm.zzc(length, RoundingMode.UNNECESSARY);
            this.zzb = zzc;
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(zzc);
            int i = 1 << (3 - numberOfTrailingZeros);
            this.zzc = i;
            this.zzd = zzc >> numberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i];
            for (int i2 = 0; i2 < this.zzd; i2++) {
                zArr[zzgbm.zzb(i2 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = zArr;
            this.zzi = z;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
        }
    }
}
