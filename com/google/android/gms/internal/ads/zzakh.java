package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzakh {
    private zzafb zzb;
    private zzady zzc;
    private zzakc zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzaka zza = new zzaka();
    private zzake zzj = new zzake();

    protected abstract long zza(zzen zzenVar);

    protected void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzake();
            this.zzf = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1L;
        this.zzg = 0L;
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean zzc(zzen zzenVar, long j, zzake zzakeVar) throws IOException;

    final int zze(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        zzdd.zzb(this.zzb);
        String str = zzex.zza;
        int i = this.zzh;
        if (i != 0) {
            if (i == 1) {
                zzadwVar.zzk((int) this.zzf);
                this.zzh = 2;
                return 0;
            }
            if (i != 2) {
                return -1;
            }
            long zzd = this.zzd.zzd(zzadwVar);
            if (zzd >= 0) {
                zzaerVar.zza = zzd;
                return 1;
            }
            if (zzd < -1) {
                zzi(-(zzd + 2));
            }
            if (!this.zzl) {
                zzaeu zze = this.zzd.zze();
                zzdd.zzb(zze);
                this.zzc.zzP(zze);
                this.zzb.zzl(zze.zza());
                this.zzl = true;
            }
            if (this.zzk <= 0 && !this.zza.zze(zzadwVar)) {
                this.zzh = 3;
                return -1;
            }
            this.zzk = 0L;
            zzen zza = this.zza.zza();
            long zza2 = zza(zza);
            if (zza2 >= 0) {
                long j = this.zzg;
                if (j + zza2 >= this.zze) {
                    long zzf = zzf(j);
                    this.zzb.zzr(zza, zza.zzd());
                    this.zzb.zzt(zzf, 1, zza.zzd(), 0, null);
                    this.zze = -1L;
                }
            }
            this.zzg += zza2;
            return 0;
        }
        while (true) {
            zzaka zzakaVar = this.zza;
            if (!zzakaVar.zze(zzadwVar)) {
                this.zzh = 3;
                return -1;
            }
            long zzf2 = zzadwVar.zzf();
            long j2 = this.zzf;
            this.zzk = zzf2 - j2;
            if (!zzc(zzakaVar.zza(), j2, this.zzj)) {
                zzz zzzVar = this.zzj.zza;
                this.zzi = zzzVar.zzH;
                if (!this.zzm) {
                    this.zzb.zzm(zzzVar);
                    this.zzm = true;
                }
                zzakc zzakcVar = this.zzj.zzb;
                if (zzakcVar != null) {
                    this.zzd = zzakcVar;
                } else if (zzadwVar.zzd() == -1) {
                    this.zzd = new zzakf(null);
                } else {
                    zzakb zzb = zzakaVar.zzb();
                    this.zzd = new zzajw(this, this.zzf, zzadwVar.zzd(), zzb.zzd + zzb.zze, zzb.zzb, (zzb.zza & 4) != 0);
                }
                this.zzh = 2;
                zzakaVar.zzd();
                return 0;
            }
            this.zzf = zzadwVar.zzf();
        }
    }

    protected final long zzf(long j) {
        return (j * 1000000) / this.zzi;
    }

    protected final long zzg(long j) {
        return (this.zzi * j) / 1000000;
    }

    final void zzh(zzady zzadyVar, zzafb zzafbVar) {
        this.zzc = zzadyVar;
        this.zzb = zzafbVar;
        zzb(true);
    }

    protected void zzi(long j) {
        this.zzg = j;
    }

    final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            this.zze = zzg(j2);
            zzakc zzakcVar = this.zzd;
            String str = zzex.zza;
            zzakcVar.zzg(this.zze);
            this.zzh = 2;
        }
    }
}
