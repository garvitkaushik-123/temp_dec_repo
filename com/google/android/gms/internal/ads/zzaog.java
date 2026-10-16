package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaog {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzeu zza = new zzeu(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzen zzb = new zzen();

    zzaog(int i) {
    }

    private final int zze(zzadw zzadwVar) {
        byte[] bArr = zzex.zzb;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
        this.zzc = true;
        zzadwVar.zzj();
        return 0;
    }

    public final int zza(zzadw zzadwVar, zzaer zzaerVar, int i) throws IOException {
        if (i <= 0) {
            zze(zzadwVar);
            return 0;
        }
        long j = -9223372036854775807L;
        if (this.zze) {
            if (this.zzg == -9223372036854775807L) {
                zze(zzadwVar);
                return 0;
            }
            if (this.zzd) {
                long j2 = this.zzf;
                if (j2 == -9223372036854775807L) {
                    zze(zzadwVar);
                    return 0;
                }
                zzeu zzeuVar = this.zza;
                this.zzh = zzeuVar.zzc(this.zzg) - zzeuVar.zzb(j2);
                zze(zzadwVar);
                return 0;
            }
            int min = (int) Math.min(112800L, zzadwVar.zzd());
            if (zzadwVar.zzf() != 0) {
                zzaerVar.zza = 0L;
                return 1;
            }
            zzen zzenVar = this.zzb;
            zzenVar.zzI(min);
            zzadwVar.zzj();
            zzadwVar.zzh(zzenVar.zzN(), 0, min);
            int zzc = zzenVar.zzc();
            int zzd = zzenVar.zzd();
            while (true) {
                if (zzc >= zzd) {
                    break;
                }
                if (zzenVar.zzN()[zzc] == 71) {
                    long zzb = zzaop.zzb(zzenVar, zzc, i);
                    if (zzb != -9223372036854775807L) {
                        j = zzb;
                        break;
                    }
                }
                zzc++;
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        }
        long zzd2 = zzadwVar.zzd();
        int min2 = (int) Math.min(112800L, zzd2);
        long j3 = zzd2 - min2;
        if (zzadwVar.zzf() != j3) {
            zzaerVar.zza = j3;
            return 1;
        }
        zzen zzenVar2 = this.zzb;
        zzenVar2.zzI(min2);
        zzadwVar.zzj();
        zzadwVar.zzh(zzenVar2.zzN(), 0, min2);
        int zzc2 = zzenVar2.zzc();
        int zzd3 = zzenVar2.zzd();
        int i2 = zzd3 - 188;
        while (true) {
            if (i2 < zzc2) {
                break;
            }
            byte[] zzN = zzenVar2.zzN();
            int i3 = -4;
            int i4 = 0;
            while (true) {
                if (i3 > 4) {
                    break;
                }
                int i5 = (i3 * 188) + i2;
                if (i5 < zzc2 || i5 >= zzd3 || zzN[i5] != 71) {
                    i4 = 0;
                } else {
                    i4++;
                    if (i4 == 5) {
                        long zzb2 = zzaop.zzb(zzenVar2, i2, i);
                        if (zzb2 != -9223372036854775807L) {
                            j = zzb2;
                            break;
                        }
                    }
                }
                i3++;
            }
            i2--;
        }
        this.zzg = j;
        this.zze = true;
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzeu zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
