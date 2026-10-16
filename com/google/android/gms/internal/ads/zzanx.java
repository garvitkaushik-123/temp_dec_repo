package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzanx {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzeu zza = new zzeu(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzen zzb = new zzen();

    zzanx() {
    }

    public static long zzc(zzen zzenVar) {
        int zzc = zzenVar.zzc();
        if (zzenVar.zza() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzenVar.zzH(bArr, 0, 9);
        zzenVar.zzL(zzc);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return -9223372036854775807L;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return -9223372036854775807L;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j = b;
        long j2 = b2;
        long j3 = (248 & j2) >> 3;
        long j4 = (j2 & 3) << 13;
        return j4 | ((bArr[1] & 255) << 20) | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (j3 << 15) | ((bArr[3] & 255) << 5) | ((b3 & 248) >> 3);
    }

    private final int zzf(zzadw zzadwVar) {
        byte[] bArr = zzex.zzb;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
        this.zzc = true;
        zzadwVar.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final int zza(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        long j = -9223372036854775807L;
        if (!this.zze) {
            long zzd = zzadwVar.zzd();
            int min = (int) Math.min(20000L, zzd);
            long j2 = zzd - min;
            if (zzadwVar.zzf() != j2) {
                zzaerVar.zza = j2;
                return 1;
            }
            zzen zzenVar = this.zzb;
            zzenVar.zzI(min);
            zzadwVar.zzj();
            zzadwVar.zzh(zzenVar.zzN(), 0, min);
            int zzc = zzenVar.zzc();
            int zzd2 = zzenVar.zzd() - 4;
            while (true) {
                if (zzd2 < zzc) {
                    break;
                }
                if (zzg(zzenVar.zzN(), zzd2) == 442) {
                    zzenVar.zzL(zzd2 + 4);
                    long zzc2 = zzc(zzenVar);
                    if (zzc2 != -9223372036854775807L) {
                        j = zzc2;
                        break;
                    }
                }
                zzd2--;
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        }
        if (this.zzg == -9223372036854775807L) {
            zzf(zzadwVar);
            return 0;
        }
        if (this.zzd) {
            long j3 = this.zzf;
            if (j3 == -9223372036854775807L) {
                zzf(zzadwVar);
                return 0;
            }
            zzeu zzeuVar = this.zza;
            this.zzh = zzeuVar.zzc(this.zzg) - zzeuVar.zzb(j3);
            zzf(zzadwVar);
            return 0;
        }
        int min2 = (int) Math.min(20000L, zzadwVar.zzd());
        if (zzadwVar.zzf() != 0) {
            zzaerVar.zza = 0L;
            return 1;
        }
        zzen zzenVar2 = this.zzb;
        zzenVar2.zzI(min2);
        zzadwVar.zzj();
        zzadwVar.zzh(zzenVar2.zzN(), 0, min2);
        int zzc3 = zzenVar2.zzc();
        int zzd3 = zzenVar2.zzd();
        while (true) {
            if (zzc3 >= zzd3 - 3) {
                break;
            }
            if (zzg(zzenVar2.zzN(), zzc3) == 442) {
                zzenVar2.zzL(zzc3 + 4);
                long zzc4 = zzc(zzenVar2);
                if (zzc4 != -9223372036854775807L) {
                    j = zzc4;
                    break;
                }
            }
            zzc3++;
        }
        this.zzf = j;
        this.zzd = true;
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzeu zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
