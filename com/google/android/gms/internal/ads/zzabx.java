package com.google.android.gms.internal.ads;

import java.util.Queue;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzabx {
    private final zzabs zza;
    private long zzj;
    private final zzaap zzk;
    private final zzabq zzb = new zzabq();
    private final zzet zzc = new zzet(10);
    private final zzet zzd = new zzet(10);
    private final zzec zze = new zzec(16);
    private long zzf = -9223372036854775807L;
    private zzcd zzi = zzcd.zza;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    public zzabx(zzaap zzaapVar, zzabs zzabsVar) {
        this.zzk = zzaapVar;
        this.zza = zzabsVar;
    }

    private static Object zzh(zzet zzetVar) {
        zzdd.zzd(zzetVar.zza() > 0);
        while (zzetVar.zza() > 1) {
            zzetVar.zzb();
        }
        Object zzb = zzetVar.zzb();
        zzb.getClass();
        return zzb;
    }

    public final void zza() {
        this.zze.zzd();
        this.zzf = -9223372036854775807L;
        this.zzg = -9223372036854775807L;
        this.zzh = -9223372036854775807L;
        zzet zzetVar = this.zzd;
        if (zzetVar.zza() > 0) {
            this.zzj = ((Long) zzh(zzetVar)).longValue();
        }
        zzet zzetVar2 = this.zzc;
        if (zzetVar2.zza() > 0) {
            zzetVar2.zzd(0L, (zzcd) zzh(zzetVar2));
        }
    }

    public final void zzb(long j) {
        this.zze.zzc(j);
        this.zzf = j;
        this.zzh = -9223372036854775807L;
    }

    public final void zzc(int i, long j) {
        if (this.zze.zze()) {
            this.zza.zzf(i);
            this.zzj = j;
        } else {
            zzet zzetVar = this.zzd;
            long j2 = this.zzf;
            zzetVar.zzd(j2 == -9223372036854775807L ? -4611686018427387904L : j2 + 1, Long.valueOf(j));
        }
    }

    public final void zzd(int i, int i2) {
        long j = this.zzf;
        this.zzc.zzd(j == -9223372036854775807L ? 0L : j + 1, new zzcd(i, i2, 1.0f));
    }

    public final void zze(long j, long j2) throws zzin {
        Executor executor;
        Queue queue;
        while (true) {
            zzec zzecVar = this.zze;
            if (zzecVar.zze()) {
                return;
            }
            zzet zzetVar = this.zzd;
            long zza = zzecVar.zza();
            Long l = (Long) zzetVar.zzc(zza);
            if (l != null && l.longValue() != this.zzj) {
                this.zzj = l.longValue();
                this.zza.zzf(2);
            }
            zzabs zzabsVar = this.zza;
            long j3 = this.zzj;
            zzabq zzabqVar = this.zzb;
            int zza2 = zzabsVar.zza(zza, j, j2, j3, false, false, zzabqVar);
            if (zza2 == 0 || zza2 == 1) {
                this.zzg = zza;
                long zzb = zzecVar.zzb();
                zzcd zzcdVar = (zzcd) this.zzc.zzc(zzb);
                if (zzcdVar != null && !zzcdVar.equals(zzcd.zza) && !zzcdVar.equals(this.zzi)) {
                    this.zzi = zzcdVar;
                    this.zzk.zza(zzcdVar);
                }
                this.zzk.zzb(zza2 == 0 ? System.nanoTime() : zzabqVar.zzd(), zzb, zzabsVar.zzn());
            } else if (zza2 == 2 || zza2 == 3) {
                this.zzg = zza;
                zzecVar.zzb();
                final zzaap zzaapVar = this.zzk;
                zzaar zzaarVar = zzaapVar.zza;
                executor = zzaarVar.zzh;
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaan
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzacl zzaclVar;
                        zzaclVar = zzaap.this.zza.zzg;
                        zzaclVar.zzc();
                    }
                });
                queue = zzaarVar.zzc;
                ((zzacm) queue.remove()).zzb();
            } else if (zza2 != 4) {
                return;
            } else {
                this.zzg = zza;
            }
        }
    }

    public final void zzf() {
        long j = this.zzf;
        if (j == -9223372036854775807L) {
            j = Long.MIN_VALUE;
            this.zzf = Long.MIN_VALUE;
            this.zzg = Long.MIN_VALUE;
        }
        this.zzh = j;
    }

    public final boolean zzg() {
        long j = this.zzh;
        return j != -9223372036854775807L && this.zzg == j;
    }
}
