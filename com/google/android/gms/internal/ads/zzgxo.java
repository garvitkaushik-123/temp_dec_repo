package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgxo {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzgxn zzgxnVar) throws zzgzw {
        int zzh = zzh(bArr, i, zzgxnVar);
        int i2 = zzgxnVar.zza;
        if (i2 < 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - zzh) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzgxnVar.zzc = zzgxz.zzb;
            return zzh;
        }
        zzgxnVar.zzc = zzgxz.zzv(bArr, zzh, i2);
        return zzh + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzhbl zzhblVar, byte[] bArr, int i, int i2, int i3, zzgxn zzgxnVar) throws IOException {
        Object zze = zzhblVar.zze();
        int zzl = zzl(zze, zzhblVar, bArr, i, i2, i3, zzgxnVar);
        zzhblVar.zzf(zze);
        zzgxnVar.zzc = zze;
        return zzl;
    }

    static int zzd(zzhbl zzhblVar, byte[] bArr, int i, int i2, zzgxn zzgxnVar) throws IOException {
        Object zze = zzhblVar.zze();
        int zzm = zzm(zze, zzhblVar, bArr, i, i2, zzgxnVar);
        zzhblVar.zzf(zze);
        zzgxnVar.zzc = zze;
        return zzm;
    }

    static int zze(zzhbl zzhblVar, int i, byte[] bArr, int i2, int i3, zzgzt zzgztVar, zzgxn zzgxnVar) throws IOException {
        int zzd = zzd(zzhblVar, bArr, i2, i3, zzgxnVar);
        zzgztVar.add(zzgxnVar.zzc);
        while (zzd < i3) {
            int zzh = zzh(bArr, zzd, zzgxnVar);
            if (i != zzgxnVar.zza) {
                break;
            }
            zzd = zzd(zzhblVar, bArr, zzh, i3, zzgxnVar);
            zzgztVar.add(zzgxnVar.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzgzt zzgztVar, zzgxn zzgxnVar) throws IOException {
        zzgzi zzgziVar = (zzgzi) zzgztVar;
        int zzh = zzh(bArr, i, zzgxnVar);
        int i2 = zzgxnVar.zza + zzh;
        while (zzh < i2) {
            zzh = zzh(bArr, zzh, zzgxnVar);
            zzgziVar.zzi(zzgxnVar.zza);
        }
        if (zzh == i2) {
            return zzh;
        }
        throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzhby zzhbyVar, zzgxn zzgxnVar) throws zzgzw {
        if ((i >>> 3) == 0) {
            throw new zzgzw("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int zzk = zzk(bArr, i2, zzgxnVar);
            zzhbyVar.zzj(i, Long.valueOf(zzgxnVar.zzb));
            return zzk;
        }
        if (i4 == 1) {
            zzhbyVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int zzh = zzh(bArr, i2, zzgxnVar);
            int i5 = zzgxnVar.zza;
            if (i5 < 0) {
                throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - zzh) {
                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzhbyVar.zzj(i, zzgxz.zzb);
            } else {
                zzhbyVar.zzj(i, zzgxz.zzv(bArr, zzh, i5));
            }
            return zzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzgzw("Protocol message contained an invalid tag (zero).");
            }
            zzhbyVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzhby zzf = zzhby.zzf();
        int i7 = zzgxnVar.zze + 1;
        zzgxnVar.zze = i7;
        zzo(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int zzh2 = zzh(bArr, i2, zzgxnVar);
            int i9 = zzgxnVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = zzh2;
                break;
            }
            i2 = zzg(i9, bArr, zzh2, i3, zzf, zzgxnVar);
            i8 = i9;
        }
        zzgxnVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzgzw("Failed to parse the message.");
        }
        zzhbyVar.zzj(i, zzf);
        return i2;
    }

    static int zzh(byte[] bArr, int i, zzgxn zzgxnVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzgxnVar);
        }
        zzgxnVar.zza = b;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzgxn zzgxnVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzgxnVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgxnVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgxnVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgxnVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgxnVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzgzt zzgztVar, zzgxn zzgxnVar) {
        zzgzi zzgziVar = (zzgzi) zzgztVar;
        int zzh = zzh(bArr, i2, zzgxnVar);
        zzgziVar.zzi(zzgxnVar.zza);
        while (zzh < i3) {
            int zzh2 = zzh(bArr, zzh, zzgxnVar);
            if (i != zzgxnVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzgxnVar);
            zzgziVar.zzi(zzgxnVar.zza);
        }
        return zzh;
    }

    static int zzk(byte[] bArr, int i, zzgxn zzgxnVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgxnVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        zzgxnVar.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzhbl zzhblVar, byte[] bArr, int i, int i2, int i3, zzgxn zzgxnVar) throws IOException {
        int i4 = zzgxnVar.zze + 1;
        zzgxnVar.zze = i4;
        zzo(i4);
        int zzc = ((zzhav) zzhblVar).zzc(obj, bArr, i, i2, i3, zzgxnVar);
        zzgxnVar.zze--;
        zzgxnVar.zzc = obj;
        return zzc;
    }

    static int zzm(Object obj, zzhbl zzhblVar, byte[] bArr, int i, int i2, zzgxn zzgxnVar) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = zzi(i4, bArr, i3, zzgxnVar);
            i4 = zzgxnVar.zza;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = zzgxnVar.zze + 1;
        zzgxnVar.zze = i6;
        zzo(i6);
        int i7 = i5 + i4;
        zzhblVar.zzi(obj, bArr, i5, i7, zzgxnVar);
        zzgxnVar.zze--;
        zzgxnVar.zzc = obj;
        return i7;
    }

    static long zzn(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    private static void zzo(int i) throws zzgzw {
        if (i >= zzb) {
            throw new zzgzw("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
