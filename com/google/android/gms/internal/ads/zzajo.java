package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzajo {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static zzaey zza(zzadw zzadwVar) throws IOException {
        return zzc(zzadwVar, true, false);
    }

    public static zzaey zzb(zzadw zzadwVar, boolean z) throws IOException {
        return zzc(zzadwVar, false, z);
    }

    private static zzaey zzc(zzadw zzadwVar, boolean z, boolean z2) throws IOException {
        zzaey zzaeyVar;
        long j;
        zzen zzenVar;
        int i;
        int i2;
        int[] iArr;
        long zzd = zzadwVar.zzd();
        long j2 = -1;
        long j3 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (zzd != -1 && zzd <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j3 = zzd;
        }
        zzen zzenVar2 = new zzen(64);
        int i3 = (int) j3;
        int i4 = 0;
        int i5 = 0;
        boolean z3 = false;
        while (i5 < i3) {
            zzenVar2.zzI(8);
            boolean z4 = true;
            if (!zzadwVar.zzm(zzenVar2.zzN(), i4, 8, true)) {
                break;
            }
            long zzu = zzenVar2.zzu();
            int zzg = zzenVar2.zzg();
            if (zzu == 1) {
                j = j2;
                zzadwVar.zzh(zzenVar2.zzN(), 8, 8);
                i = 16;
                zzenVar2.zzK(16);
                zzu = zzenVar2.zzt();
                zzenVar = zzenVar2;
            } else {
                j = j2;
                if (zzu == 0) {
                    long zzd2 = zzadwVar.zzd();
                    if (zzd2 != j) {
                        zzu = (zzd2 - zzadwVar.zze()) + 8;
                    }
                }
                zzenVar = zzenVar2;
                i = 8;
            }
            long j4 = zzu;
            zzaeyVar = null;
            long j5 = i;
            if (j4 < j5) {
                return new zzaik(zzg, j4, i);
            }
            i5 += i;
            if (zzg == 1836019574) {
                i3 += (int) j4;
                if (zzd != -1 && i3 > zzd) {
                    i3 = (int) zzd;
                }
                zzenVar2 = zzenVar;
                j2 = j;
                i4 = 0;
            } else {
                if (zzg == 1836019558 || zzg == 1836475768) {
                    i4 = 1;
                    break;
                }
                z3 |= !(zzg != 1835295092);
                long j6 = zzd;
                if ((i5 + j4) - j5 >= i3) {
                    i4 = 0;
                    break;
                }
                int i6 = (int) (j4 - j5);
                i5 += i6;
                if (zzg != 1718909296) {
                    i2 = 0;
                    if (i6 != 0) {
                        zzadwVar.zzg(i6);
                    }
                } else {
                    if (i6 < 8) {
                        return new zzaik(1718909296, i6, 8);
                    }
                    zzenVar.zzI(i6);
                    i2 = 0;
                    zzadwVar.zzh(zzenVar.zzN(), 0, i6);
                    int zzg2 = zzenVar.zzg();
                    boolean zzd3 = zzd(zzg2, z2) | z3;
                    zzenVar.zzM(4);
                    int zza2 = zzenVar.zza() / 4;
                    if (!zzd3 && zza2 > 0) {
                        iArr = new int[zza2];
                        int i7 = 0;
                        while (true) {
                            if (i7 >= zza2) {
                                z4 = zzd3;
                                break;
                            }
                            int zzg3 = zzenVar.zzg();
                            iArr[i7] = zzg3;
                            if (zzd(zzg3, z2)) {
                                break;
                            }
                            i7++;
                        }
                    } else {
                        z4 = zzd3;
                        iArr = null;
                    }
                    if (!z4) {
                        return new zzajt(zzg2, iArr);
                    }
                    z3 = z4;
                }
                i4 = i2;
                zzenVar2 = zzenVar;
                j2 = j;
                zzd = j6;
            }
        }
        zzaeyVar = null;
        return !z3 ? zzajk.zza : z != i4 ? i4 != 0 ? zzaje.zza : zzaje.zzb : zzaeyVar;
    }

    private static boolean zzd(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579) {
            if (z) {
                return true;
            }
            i = 1751476579;
        }
        int[] iArr = zza;
        for (int i2 = 0; i2 < 29; i2++) {
            if (iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }
}
