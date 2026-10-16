package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaii {
    public final zzaen zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzaii(zzaen zzaenVar, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = new zzaen(zzaenVar);
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzaii zzb(zzaen zzaenVar, zzen zzenVar) {
        long[] jArr;
        int i;
        int i2;
        int zzg = zzenVar.zzg();
        int zzp = (zzg & 1) != 0 ? zzenVar.zzp() : -1;
        long zzu = (zzg & 2) != 0 ? zzenVar.zzu() : -1L;
        if ((zzg & 4) == 4) {
            jArr = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr[i3] = zzenVar.zzm();
            }
        } else {
            jArr = null;
        }
        long[] jArr2 = jArr;
        if ((zzg & 8) != 0) {
            zzenVar.zzM(4);
        }
        if (zzenVar.zza() >= 24) {
            zzenVar.zzM(21);
            int zzo = zzenVar.zzo();
            i2 = zzo & 4095;
            i = zzo >> 12;
        } else {
            i = -1;
            i2 = -1;
        }
        return new zzaii(zzaenVar, zzp, zzu, jArr2, i, i2);
    }

    public final long zza() {
        long j = this.zzb;
        if (j == -1 || j == 0) {
            return -9223372036854775807L;
        }
        return zzex.zzt((j * r4.zzg) - 1, this.zza.zzd);
    }
}
