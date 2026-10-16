package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzadh {
    public static void zza(long j, zzen zzenVar, zzafb[] zzafbVarArr) {
        int i;
        while (true) {
            if (zzenVar.zza() <= 1) {
                return;
            }
            int zzc = zzc(zzenVar);
            int zzc2 = zzc(zzenVar);
            int zzc3 = zzenVar.zzc() + zzc2;
            if (zzc2 == -1 || zzc2 > zzenVar.zza()) {
                zzea.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                zzc3 = zzenVar.zzd();
            } else if (zzc == 4 && zzc2 >= 8) {
                int zzm = zzenVar.zzm();
                int zzq = zzenVar.zzq();
                if (zzq == 49) {
                    i = zzenVar.zzg();
                    zzq = 49;
                } else {
                    i = 0;
                }
                int zzm2 = zzenVar.zzm();
                if (zzq == 47) {
                    zzenVar.zzM(1);
                    zzq = 47;
                }
                boolean z = zzm == 181 && (zzq == 49 || zzq == 47) && zzm2 == 3;
                if (zzq == 49) {
                    z &= i == 1195456820;
                }
                if (z) {
                    zzb(j, zzenVar, zzafbVarArr);
                }
            }
            zzenVar.zzL(zzc3);
        }
    }

    public static void zzb(long j, zzen zzenVar, zzafb[] zzafbVarArr) {
        int zzm = zzenVar.zzm();
        if ((zzm & 64) != 0) {
            int i = zzm & 31;
            zzenVar.zzM(1);
            int zzc = zzenVar.zzc();
            for (zzafb zzafbVar : zzafbVarArr) {
                int i2 = i * 3;
                zzenVar.zzL(zzc);
                zzafbVar.zzr(zzenVar, i2);
                zzdd.zzf(j != -9223372036854775807L);
                zzafbVar.zzt(j, 1, i2, 0, null);
            }
        }
    }

    private static int zzc(zzen zzenVar) {
        int i = 0;
        while (zzenVar.zza() != 0) {
            int zzm = zzenVar.zzm();
            i += zzm;
            if (zzm != 255) {
                return i;
            }
        }
        return -1;
    }
}
