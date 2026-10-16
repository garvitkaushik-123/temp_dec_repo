package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaoy {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 0, Ascii.DLE, 0, Byte.MIN_VALUE, 0, 0, -86, 0, 56, -101, 113};
    private static final byte[] zzc = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static Pair zza(zzadw zzadwVar) throws IOException {
        zzadwVar.zzj();
        zzaox zzd = zzd(1684108385, zzadwVar, new zzen(8));
        zzadwVar.zzk(8);
        return Pair.create(Long.valueOf(zzadwVar.zzf()), Long.valueOf(zzd.zzb));
    }

    public static zzaow zzb(zzadw zzadwVar) throws IOException {
        byte[] bArr;
        int i;
        byte[] bArr2;
        zzen zzenVar = new zzen(16);
        long j = zzd(1718449184, zzadwVar, zzenVar).zzb;
        zzdd.zzf(j >= 16);
        zzadwVar.zzh(zzenVar.zzN(), 0, 16);
        zzenVar.zzL(0);
        int zzk = zzenVar.zzk();
        int zzk2 = zzenVar.zzk();
        int zzj = zzenVar.zzj();
        int zzj2 = zzenVar.zzj();
        int zzk3 = zzenVar.zzk();
        int zzk4 = zzenVar.zzk();
        int i2 = ((int) j) - 16;
        if (i2 > 0) {
            bArr = new byte[i2];
            zzadwVar.zzh(bArr, 0, i2);
            if (zzk == 65534) {
                if (i2 != 24) {
                    bArr2 = bArr;
                    i = 65534;
                    zzadwVar.zzk((int) (zzadwVar.zze() - zzadwVar.zzf()));
                    return new zzaow(i, zzk2, zzj, zzj2, zzk3, zzk4, bArr2);
                }
                zzen zzenVar2 = new zzen(bArr);
                zzenVar2.zzk();
                int zzk5 = zzenVar2.zzk();
                if (zzk5 != 0 && zzk5 != zzk4) {
                    throw zzaz.zzc("validBits ( " + zzk5 + ")  != bitsPerSample( " + zzk4 + ") are not supported");
                }
                int zzj3 = zzenVar2.zzj();
                if ((zzj3 >> 18) != 0) {
                    throw zzaz.zzc("invalid channel mask " + zzj3);
                }
                if (zzj3 != 0 && Integer.bitCount(zzj3) != zzk2) {
                    throw zzaz.zzc("invalid number of channels (" + Integer.bitCount(zzj3) + ") in channel mask " + zzj3);
                }
                zzk = zzenVar2.zzk();
                byte[] bArr3 = new byte[14];
                zzenVar2.zzH(bArr3, 0, 14);
                if (!Arrays.equals(bArr3, zzb) && !Arrays.equals(bArr3, zzc)) {
                    throw zzaz.zzc("invalid wav format extension guid");
                }
            }
        } else {
            bArr = zzex.zzb;
        }
        i = zzk;
        bArr2 = bArr;
        zzadwVar.zzk((int) (zzadwVar.zze() - zzadwVar.zzf()));
        return new zzaow(i, zzk2, zzj, zzj2, zzk3, zzk4, bArr2);
    }

    public static boolean zzc(zzadw zzadwVar) throws IOException {
        zzen zzenVar = new zzen(8);
        int i = zzaox.zza(zzadwVar, zzenVar).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        zzadwVar.zzh(zzenVar.zzN(), 0, 4);
        zzenVar.zzL(0);
        int zzg = zzenVar.zzg();
        if (zzg == 1463899717) {
            return true;
        }
        zzea.zzc("WavHeaderReader", "Unsupported form type: " + zzg);
        return false;
    }

    private static zzaox zzd(int i, zzadw zzadwVar, zzen zzenVar) throws IOException {
        zzaox zza2 = zzaox.zza(zzadwVar, zzenVar);
        while (true) {
            int i2 = zza2.zza;
            if (i2 == i) {
                return zza2;
            }
            zzea.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i2);
            long j = zza2.zzb;
            long j2 = 8 + j;
            if ((1 & j) != 0) {
                j2 = 9 + j;
            }
            if (j2 > 2147483647L) {
                throw zzaz.zzc("Chunk is too large (~2GB+) to skip; id: " + i2);
            }
            zzadwVar.zzk((int) j2);
            zza2 = zzaox.zza(zzadwVar, zzenVar);
        }
    }
}
