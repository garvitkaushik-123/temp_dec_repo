package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaec {
    public static int zza(zzen zzenVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzenVar.zzm() + 1;
            case 7:
                return zzenVar.zzq() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzadw zzadwVar, zzaeg zzaegVar) throws IOException {
        zzadwVar.zzj();
        zzadwVar.zzg(1);
        byte[] bArr = new byte[1];
        zzadwVar.zzh(bArr, 0, 1);
        int i = bArr[0] & 1;
        boolean z = 1 == i;
        zzadwVar.zzg(2);
        int i2 = 1 != i ? 6 : 7;
        zzen zzenVar = new zzen(i2);
        zzenVar.zzK(zzadz.zzb(zzadwVar, zzenVar.zzN(), 0, i2));
        zzadwVar.zzj();
        zzaeb zzaebVar = new zzaeb();
        if (zzd(zzenVar, zzaegVar, z, zzaebVar)) {
            return zzaebVar.zza;
        }
        throw zzaz.zza(null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
    
        if (r3 != r24.zzf) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008a, code lost:
    
        if ((r23.zzm() * 1000) == r5) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
    
        if (r4 == r5) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zzc(zzen zzenVar, zzaeg zzaegVar, int i, zzaeb zzaebVar) {
        int zza;
        int zzc = zzenVar.zzc();
        long zzu = zzenVar.zzu();
        long j = zzu >>> 16;
        if (j != i) {
            return false;
        }
        boolean z = (j & 1) == 1;
        long j2 = zzu >> 12;
        long j3 = zzu >> 8;
        long j4 = zzu >> 4;
        long j5 = zzu >> 1;
        long j6 = zzu & 1;
        int i2 = (int) (j4 & 15);
        if (i2 > 7 ? !(i2 > 10 || zzaegVar.zzg != 2) : i2 == zzaegVar.zzg - 1) {
            int i3 = (int) (j5 & 7);
            if ((i3 == 0 || i3 == zzaegVar.zzi) && j6 != 1 && zzd(zzenVar, zzaegVar, z, zzaebVar) && (zza = zza(zzenVar, (int) (j2 & 15))) != -1 && zza <= zzaegVar.zzb) {
                int i4 = zzaegVar.zze;
                int i5 = (int) (j3 & 15);
                if (i5 != 0) {
                    if (i5 > 11) {
                        if (i5 != 12) {
                            if (i5 <= 14) {
                                int zzq = zzenVar.zzq();
                                if (i5 == 14) {
                                    zzq *= 10;
                                }
                            }
                        }
                    }
                }
                if (zzenVar.zzm() == zzex.zzg(zzenVar.zzN(), zzc, zzenVar.zzc() - 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzd(zzen zzenVar, zzaeg zzaegVar, boolean z, zzaeb zzaebVar) {
        try {
            long zzx = zzenVar.zzx();
            if (!z) {
                zzx *= zzaegVar.zzb;
            }
            zzaebVar.zza = zzx;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
