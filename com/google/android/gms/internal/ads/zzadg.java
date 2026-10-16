package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzadg {
    protected final zzada zza;
    protected final zzadf zzb;
    protected zzadc zzc;
    private final int zzd;

    protected zzadg(zzadd zzaddVar, zzadf zzadfVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzadfVar;
        this.zzd = i;
        this.zza = new zzada(zzaddVar, j, 0L, j3, j4, j5, j6);
    }

    protected static final int zzf(zzadw zzadwVar, long j, zzaer zzaerVar) {
        if (j == zzadwVar.zzf()) {
            return 0;
        }
        zzaerVar.zza = j;
        return 1;
    }

    protected static final boolean zzg(zzadw zzadwVar, long j) throws IOException {
        long zzf = j - zzadwVar.zzf();
        if (zzf < 0 || zzf > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        zzadwVar.zzk((int) zzf);
        return true;
    }

    public final int zza(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        while (true) {
            zzadc zzadcVar = this.zzc;
            zzdd.zzb(zzadcVar);
            j = zzadcVar.zzf;
            j2 = zzadcVar.zzg;
            j3 = zzadcVar.zzh;
            if (j2 - j <= this.zzd) {
                zzc(false, j);
                return zzf(zzadwVar, j, zzaerVar);
            }
            if (!zzg(zzadwVar, j3)) {
                return zzf(zzadwVar, j3, zzaerVar);
            }
            zzadwVar.zzj();
            zzadf zzadfVar = this.zzb;
            j4 = zzadcVar.zzb;
            zzade zza = zzadfVar.zza(zzadwVar, j4);
            i = zza.zzb;
            if (i == -3) {
                zzc(false, j3);
                return zzf(zzadwVar, j3, zzaerVar);
            }
            if (i == -2) {
                j10 = zza.zzc;
                j11 = zza.zzd;
                zzadc.zzh(zzadcVar, j10, j11);
            } else {
                if (i != -1) {
                    j5 = zza.zzd;
                    zzg(zzadwVar, j5);
                    j6 = zza.zzd;
                    zzc(true, j6);
                    j7 = zza.zzd;
                    return zzf(zzadwVar, j7, zzaerVar);
                }
                j8 = zza.zzc;
                j9 = zza.zzd;
                zzadc.zzg(zzadcVar, j8, j9);
            }
        }
    }

    public final zzaeu zzb() {
        return this.zza;
    }

    protected final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        zzadc zzadcVar = this.zzc;
        if (zzadcVar != null) {
            j6 = zzadcVar.zza;
            if (j6 == j) {
                return;
            }
        }
        zzada zzadaVar = this.zza;
        long zzf = zzadaVar.zzf(j);
        j2 = zzadaVar.zzc;
        j3 = zzadaVar.zzd;
        j4 = zzadaVar.zze;
        j5 = zzadaVar.zzf;
        this.zzc = new zzadc(j, zzf, 0L, j2, j3, j4, j5);
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
