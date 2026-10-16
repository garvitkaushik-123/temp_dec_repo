package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzen {
    private static final char[] zza = {'\r', '\n'};
    private static final char[] zzb = {'\n'};
    private static final zzfyv zzc = zzfyv.zzr(StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzen() {
        this.zzd = zzex.zzb;
    }

    public zzen(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
    }

    private final char zzO(ByteOrder byteOrder, int i) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.zzd;
            int i2 = this.zze + i;
            return zzgbq.zza(bArr[i2], bArr[i2 + 1]);
        }
        byte[] bArr2 = this.zzd;
        int i3 = this.zze + i;
        return zzgbq.zza(bArr2[i3 + 1], bArr2[i3]);
    }

    private final char zzP(Charset charset, char[] cArr) {
        int zzS;
        if (zza() >= zzR(charset) && (zzS = zzS(charset)) != 0) {
            if (!Character.isSupplementaryCodePoint(r0)) {
                long j = r0;
                char c = (char) j;
                zzfvp.zzh(((long) c) == j, "Out of range: %s", j);
                for (char c2 : cArr) {
                    if (c2 == c) {
                        this.zze += zzgbt.zzb(zzS & 255);
                        return c;
                    }
                }
            }
        }
        return (char) 0;
    }

    private static int zzQ(int i, int i2, int i3, int i4) {
        return zzgbt.zze((byte) 0, zzgbx.zza(((i & 7) << 2) | ((i2 & 48) >> 4)), zzgbx.zza(((i3 & 60) >> 2) | ((i2 & 15) << 4)), zzgbx.zza((i4 & 63) | ((i3 & 3) << 6)));
    }

    private static int zzR(Charset charset) {
        zzdd.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    private final int zzS(Charset charset) {
        int i;
        int i2;
        int i3;
        zzdd.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
        if (zza() < zzR(charset)) {
            throw new IndexOutOfBoundsException("position=" + this.zze + ", limit=" + this.zzf);
        }
        int i4 = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b = this.zzd[this.zze];
            if ((b & 128) == 0) {
                i = b & 255;
                return (i << 8) | i4;
            }
            return 0;
        }
        if (charset.equals(StandardCharsets.UTF_8)) {
            byte b2 = this.zzd[this.zze];
            if ((b2 & 128) == 0) {
                i2 = 1;
            } else if ((b2 & 224) == 192 && zza() >= 2 && zzT(this.zzd[this.zze + 1])) {
                i2 = 2;
            } else {
                if ((this.zzd[this.zze] & 240) == 224 && zza() >= 3) {
                    byte[] bArr = this.zzd;
                    int i5 = this.zze;
                    if (zzT(bArr[i5 + 1]) && zzT(bArr[i5 + 2])) {
                        i2 = 3;
                    }
                }
                if ((this.zzd[this.zze] & 248) == 240 && zza() >= 4) {
                    byte[] bArr2 = this.zzd;
                    int i6 = this.zze;
                    if (zzT(bArr2[i6 + 1]) && zzT(bArr2[i6 + 2]) && zzT(bArr2[i6 + 3])) {
                        i2 = 4;
                    }
                }
                i2 = 0;
            }
            if (i2 == 1) {
                i3 = this.zzd[this.zze] & 255;
            } else if (i2 == 2) {
                byte[] bArr3 = this.zzd;
                int i7 = this.zze;
                i3 = zzQ(0, 0, bArr3[i7], bArr3[i7 + 1]);
            } else {
                if (i2 != 3) {
                    if (i2 == 4) {
                        byte[] bArr4 = this.zzd;
                        int i8 = this.zze;
                        i3 = zzQ(bArr4[i8], bArr4[i8 + 1], bArr4[i8 + 2], bArr4[i8 + 3]);
                    }
                    return 0;
                }
                byte[] bArr5 = this.zzd;
                int i9 = this.zze;
                i3 = zzQ(0, bArr5[i9] & Ascii.SI, bArr5[i9 + 1], bArr5[i9 + 2]);
            }
            i4 = i2;
            i = i3;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char zzO = zzO(byteOrder, 0);
            if (!Character.isHighSurrogate(zzO) || zza() < 4) {
                i = zzO;
                i4 = 2;
            } else {
                i = Character.toCodePoint(zzO, zzO(byteOrder, 2));
                i4 = 4;
            }
        }
        return (i << 8) | i4;
    }

    private static boolean zzT(byte b) {
        return (b & 192) == 128;
    }

    public final String zzA(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.zze;
        int i3 = (i2 + i) - 1;
        String zzC = zzex.zzC(this.zzd, i2, (i3 >= this.zzf || this.zzd[i3] != 0) ? i : i - 1);
        this.zze += i;
        return zzC;
    }

    public final String zzB(int i, Charset charset) {
        byte[] bArr = this.zzd;
        int i2 = this.zze;
        String str = new String(bArr, i2, i, charset);
        this.zze = i2 + i;
        return str;
    }

    public final Charset zzC() {
        if (zza() >= 3) {
            byte[] bArr = this.zzd;
            int i = this.zze;
            if (bArr[i] == -17 && bArr[i + 1] == -69 && bArr[i + 2] == -65) {
                this.zze = i + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (zza() < 2) {
            return null;
        }
        byte[] bArr2 = this.zzd;
        int i2 = this.zze;
        byte b = bArr2[i2];
        if (b == -2) {
            if (bArr2[i2 + 1] != -1) {
                return null;
            }
            this.zze = i2 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b != -1 || bArr2[i2 + 1] != -2) {
            return null;
        }
        this.zze = i2 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public final short zzD() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public final short zzE() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return (short) ((bArr[i2] & 255) | (i3 << 8));
    }

    public final void zzF(int i) {
        byte[] bArr = this.zzd;
        if (i > bArr.length) {
            this.zzd = Arrays.copyOf(bArr, i);
        }
    }

    public final void zzG(zzem zzemVar, int i) {
        zzH(zzemVar.zza, 0, i);
        zzemVar.zzl(0);
    }

    public final void zzH(byte[] bArr, int i, int i2) {
        System.arraycopy(this.zzd, this.zze, bArr, i, i2);
        this.zze += i2;
    }

    public final void zzI(int i) {
        byte[] bArr = this.zzd;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        zzJ(bArr, i);
    }

    public final void zzJ(byte[] bArr, int i) {
        this.zzd = bArr;
        this.zzf = i;
        this.zze = 0;
    }

    public final void zzK(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzd.length) {
            z = true;
        }
        zzdd.zzd(z);
        this.zzf = i;
    }

    public final void zzL(int i) {
        boolean z = false;
        if (i >= 0 && i <= this.zzf) {
            z = true;
        }
        zzdd.zzd(z);
        this.zze = i;
    }

    public final void zzM(int i) {
        zzL(this.zze + i);
    }

    public final byte[] zzN() {
        return this.zzd;
    }

    public final int zza() {
        return Math.max(this.zzf - this.zze, 0);
    }

    public final int zzb() {
        return this.zzd.length;
    }

    public final int zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final int zze(Charset charset) {
        if (zzS(charset) != 0) {
            return zzgbt.zzb(r3 >>> 8);
        }
        return 1114112;
    }

    public final int zzf() {
        return this.zzd[this.zze] & 255;
    }

    public final int zzg() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.zze = i4;
        int i5 = bArr[i2] & 255;
        int i6 = i + 3;
        this.zze = i6;
        int i7 = bArr[i4] & 255;
        this.zze = i + 4;
        return (bArr[i6] & 255) | (i3 << 24) | (i5 << 16) | (i7 << 8);
    }

    public final int zzh() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.zze = i4;
        int i5 = bArr[i2] & 255;
        this.zze = i + 3;
        return (bArr[i4] & 255) | ((i3 << 24) >> 8) | (i5 << 8);
    }

    public final int zzi() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.zze = i4;
        int i5 = bArr[i2] & 255;
        int i6 = i + 3;
        this.zze = i6;
        int i7 = bArr[i4] & 255;
        this.zze = i + 4;
        return ((bArr[i6] & 255) << 24) | (i5 << 8) | i3 | (i7 << 16);
    }

    public final int zzj() {
        int zzi = zzi();
        if (zzi >= 0) {
            return zzi;
        }
        throw new IllegalStateException("Top bit not zero: " + zzi);
    }

    public final int zzk() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public final int zzl() {
        return (zzm() << 21) | (zzm() << 14) | (zzm() << 7) | zzm();
    }

    public final int zzm() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        this.zze = i + 1;
        return bArr[i] & 255;
    }

    public final int zzn() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        int i4 = bArr[i2] & 255;
        this.zze = i + 4;
        return i4 | (i3 << 8);
    }

    public final int zzo() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.zze = i4;
        int i5 = bArr[i2] & 255;
        this.zze = i + 3;
        return (bArr[i4] & 255) | (i3 << 16) | (i5 << 8);
    }

    public final int zzp() {
        int zzg = zzg();
        if (zzg >= 0) {
            return zzg;
        }
        throw new IllegalStateException("Top bit not zero: " + zzg);
    }

    public final int zzq() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        int i3 = bArr[i] & 255;
        this.zze = i + 2;
        return (bArr[i2] & 255) | (i3 << 8);
    }

    public final long zzr() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        long j = bArr[i];
        int i3 = i + 2;
        this.zze = i3;
        long j2 = bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        long j3 = bArr[i3];
        int i5 = i + 4;
        this.zze = i5;
        long j4 = bArr[i4];
        int i6 = i + 5;
        this.zze = i6;
        long j5 = bArr[i5];
        int i7 = i + 6;
        this.zze = i7;
        long j6 = bArr[i6];
        this.zze = i + 7;
        long j7 = bArr[i7];
        this.zze = i + 8;
        return ((bArr[r3] & 255) << 56) | (255 & j) | ((j2 & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((j5 & 255) << 32) | ((j6 & 255) << 40) | ((j7 & 255) << 48);
    }

    public final long zzs() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        long j = bArr[i];
        int i3 = i + 2;
        this.zze = i3;
        long j2 = bArr[i2];
        this.zze = i + 3;
        long j3 = bArr[i3];
        this.zze = i + 4;
        return ((bArr[r2] & 255) << 24) | (j & 255) | ((j2 & 255) << 8) | ((j3 & 255) << 16);
    }

    public final long zzt() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        long j = bArr[i];
        int i3 = i + 2;
        this.zze = i3;
        long j2 = bArr[i2];
        int i4 = i + 3;
        this.zze = i4;
        long j3 = bArr[i3];
        int i5 = i + 4;
        this.zze = i5;
        long j4 = bArr[i4];
        int i6 = i + 5;
        this.zze = i6;
        long j5 = bArr[i5];
        int i7 = i + 6;
        this.zze = i7;
        long j6 = bArr[i6];
        this.zze = i + 7;
        long j7 = bArr[i7];
        this.zze = i + 8;
        return (bArr[r3] & 255) | ((j & 255) << 56) | ((j2 & 255) << 48) | ((j3 & 255) << 40) | ((j4 & 255) << 32) | ((j5 & 255) << 24) | ((j6 & 255) << 16) | ((j7 & 255) << 8);
    }

    public final long zzu() {
        byte[] bArr = this.zzd;
        int i = this.zze;
        int i2 = i + 1;
        this.zze = i2;
        long j = bArr[i];
        int i3 = i + 2;
        this.zze = i3;
        long j2 = bArr[i2];
        this.zze = i + 3;
        long j3 = bArr[i3];
        this.zze = i + 4;
        return (bArr[r2] & 255) | ((j & 255) << 24) | ((j2 & 255) << 16) | ((j3 & 255) << 8);
    }

    public final long zzw() {
        long zzt = zzt();
        if (zzt >= 0) {
            return zzt;
        }
        throw new IllegalStateException("Top bit not zero: " + zzt);
    }

    public final long zzx() {
        int i;
        int i2;
        long j = this.zzd[this.zze];
        int i3 = 7;
        while (true) {
            i = 0;
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= r7 - 1;
                i = 7 - i3;
            } else if (i3 == 7) {
                i = 1;
            }
        }
        if (i == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
        }
        for (i2 = 1; i2 < i; i2++) {
            if ((this.zzd[this.zze + i2] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
            }
            j = (j << 6) | (r2 & 63);
        }
        this.zze += i;
        return j;
    }

    public final String zzy(char c) {
        if (zza() == 0) {
            return null;
        }
        int i = this.zze;
        while (i < this.zzf && this.zzd[i] != 0) {
            i++;
        }
        byte[] bArr = this.zzd;
        int i2 = this.zze;
        String zzC = zzex.zzC(bArr, i2, i - i2);
        this.zze = i;
        if (i < this.zzf) {
            this.zze = i + 1;
        }
        return zzC;
    }

    public final String zzz(Charset charset) {
        zzdd.zze(zzc.contains(charset), "Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
        if (zza() == 0) {
            return null;
        }
        if (!charset.equals(StandardCharsets.US_ASCII)) {
            zzC();
        }
        int i = 1;
        if (!charset.equals(StandardCharsets.UTF_8) && !charset.equals(StandardCharsets.US_ASCII)) {
            i = 2;
            if (!charset.equals(StandardCharsets.UTF_16) && !charset.equals(StandardCharsets.UTF_16LE) && !charset.equals(StandardCharsets.UTF_16BE)) {
                throw new IllegalArgumentException("Unsupported charset: ".concat(String.valueOf(String.valueOf(charset))));
            }
        }
        int i2 = this.zze;
        while (true) {
            int i3 = this.zzf;
            if (i2 >= i3 - (i - 1)) {
                i2 = i3;
                break;
            }
            if ((charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) && zzex.zzM(this.zzd[i2])) {
                break;
            }
            if (charset.equals(StandardCharsets.UTF_16) || charset.equals(StandardCharsets.UTF_16BE)) {
                byte[] bArr = this.zzd;
                if (bArr[i2] == 0 && zzex.zzM(bArr[i2 + 1])) {
                    break;
                }
            }
            if (charset.equals(StandardCharsets.UTF_16LE)) {
                byte[] bArr2 = this.zzd;
                if (bArr2[i2 + 1] == 0 && zzex.zzM(bArr2[i2])) {
                    break;
                }
            }
            i2 += i;
        }
        String zzB = zzB(i2 - this.zze, charset);
        if (this.zze != this.zzf && zzP(charset, zza) == '\r') {
            zzP(charset, zzb);
        }
        return zzB;
    }

    public zzen(int i) {
        this.zzd = new byte[i];
        this.zzf = i;
    }

    public final long zzv() {
        long j = 0;
        for (int i = 0; i < 9; i++) {
            if (this.zze == this.zzf) {
                throw new IllegalStateException("Attempting to read a byte over the limit.");
            }
            long zzm = zzm();
            j |= (127 & zzm) << (i * 7);
            if ((zzm & 128) == 0) {
                return j;
            }
        }
        return j;
    }

    public zzen(byte[] bArr) {
        this.zzd = bArr;
        this.zzf = bArr.length;
    }
}
