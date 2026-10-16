package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaed {
    public static zzaef zzb(zzen zzenVar) {
        zzenVar.zzM(1);
        int zzo = zzenVar.zzo();
        long zzc = zzenVar.zzc();
        long j = zzo;
        int i = zzo / 18;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long zzt = zzenVar.zzt();
            if (zzt == -1) {
                jArr = Arrays.copyOf(jArr, i2);
                jArr2 = Arrays.copyOf(jArr2, i2);
                break;
            }
            jArr[i2] = zzt;
            jArr2[i2] = zzenVar.zzt();
            zzenVar.zzM(2);
            i2++;
        }
        zzenVar.zzM((int) ((zzc + j) - zzenVar.zzc()));
        return new zzaef(jArr, jArr2);
    }

    public static zzav zza(zzadw zzadwVar, boolean z) throws IOException {
        zzav zza = new zzael().zza(zzadwVar, z ? null : zzahe.zza);
        if (zza == null || zza.zza() == 0) {
            return null;
        }
        return zza;
    }
}
