package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzlc {
    public final zzvf zza;
    public final Object zzb;
    public boolean zzd;
    public boolean zze;
    public boolean zzf;
    public zzld zzg;
    public boolean zzh;
    private final zzmd[] zzj;
    private final zzzd zzk;
    private final zzlr zzl;
    private zzlc zzm;
    private zzze zzo;
    private long zzp;
    private zzxk zzn = zzxk.zza;
    public final zzwz[] zzc = new zzwz[2];
    private final boolean[] zzi = new boolean[2];

    public zzlc(zzmd[] zzmdVarArr, long j, zzzd zzzdVar, zzzm zzzmVar, zzlr zzlrVar, zzld zzldVar, zzze zzzeVar, long j2) {
        this.zzj = zzmdVarArr;
        this.zzp = j;
        this.zzk = zzzdVar;
        this.zzl = zzlrVar;
        this.zzb = zzldVar.zza.zza;
        this.zzg = zzldVar;
        this.zzo = zzzeVar;
        zzvh zzvhVar = zzldVar.zza;
        long j3 = zzldVar.zzb;
        long j4 = zzldVar.zzd;
        zzvf zzp = zzlrVar.zzp(zzvhVar, zzzmVar, j3);
        this.zza = j4 != -9223372036854775807L ? new zzul(zzp, true, 0L, j4) : zzp;
    }

    private final void zzu() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzze zzzeVar = this.zzo;
            if (i >= zzzeVar.zza) {
                return;
            }
            zzzeVar.zzb(i);
            zzyw zzywVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final void zzv() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzze zzzeVar = this.zzo;
            if (i >= zzzeVar.zza) {
                return;
            }
            zzzeVar.zzb(i);
            zzyw zzywVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final boolean zzw() {
        return this.zzm == null;
    }

    public final long zza(zzze zzzeVar, long j, boolean z) {
        return zzb(zzzeVar, j, false, new boolean[2]);
    }

    public final long zzb(zzze zzzeVar, long j, boolean z, boolean[] zArr) {
        zzmd[] zzmdVarArr;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzzeVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzi;
            if (z || !zzzeVar.zza(this.zzo, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzmdVarArr = this.zzj;
            if (i2 >= 2) {
                break;
            }
            zzmdVarArr[i2].zzb();
            i2++;
        }
        zzu();
        this.zzo = zzzeVar;
        zzv();
        zzvf zzvfVar = this.zza;
        zzyw[] zzywVarArr = zzzeVar.zzc;
        boolean[] zArr3 = this.zzi;
        zzwz[] zzwzVarArr = this.zzc;
        long zzf = zzvfVar.zzf(zzywVarArr, zArr3, zzwzVarArr, zArr, j);
        for (int i3 = 0; i3 < 2; i3++) {
            zzmdVarArr[i3].zzb();
        }
        this.zzf = false;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzwzVarArr[i4] != null) {
                zzdd.zzf(zzzeVar.zzb(i4));
                zzmdVarArr[i4].zzb();
                this.zzf = true;
            } else {
                zzdd.zzf(zzywVarArr[i4] == null);
            }
        }
        return zzf;
    }

    public final long zzc() {
        if (!this.zze) {
            return this.zzg.zzb;
        }
        long zzb = this.zzf ? this.zza.zzb() : Long.MIN_VALUE;
        return zzb == Long.MIN_VALUE ? this.zzg.zze : zzb;
    }

    public final long zzd() {
        if (this.zze) {
            return this.zza.zzc();
        }
        return 0L;
    }

    public final long zze() {
        return this.zzp;
    }

    public final long zzf() {
        return this.zzg.zzb + this.zzp;
    }

    public final zzlc zzg() {
        return this.zzm;
    }

    public final zzxk zzh() {
        return this.zzn;
    }

    public final zzze zzi() {
        return this.zzo;
    }

    public final zzze zzj(float f, zzbl zzblVar, boolean z) throws zzin {
        zzxk zzxkVar = this.zzn;
        zzvh zzvhVar = this.zzg.zza;
        zzzd zzzdVar = this.zzk;
        zzmd[] zzmdVarArr = this.zzj;
        zzze zzo = zzzdVar.zzo(zzmdVarArr, zzxkVar, zzvhVar, zzblVar);
        for (int i = 0; i < zzo.zza; i++) {
            if (zzo.zzb(i)) {
                if (zzo.zzc[i] == null) {
                    zzmdVarArr[i].zzb();
                    r2 = false;
                }
                zzdd.zzf(r2);
            } else {
                zzdd.zzf(zzo.zzc[i] == null);
            }
        }
        for (zzyw zzywVar : zzo.zzc) {
        }
        return zzo;
    }

    public final void zzk(zzla zzlaVar) {
        zzdd.zzf(zzw());
        this.zza.zzo(zzlaVar);
    }

    public final void zzl(float f, zzbl zzblVar, boolean z) throws zzin {
        this.zze = true;
        this.zzn = this.zza.zzg();
        zzze zzj = zzj(f, zzblVar, z);
        zzld zzldVar = this.zzg;
        long j = zzldVar.zzb;
        long j2 = zzldVar.zze;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        long zza = zza(zzj, j, false);
        long j3 = this.zzp;
        zzld zzldVar2 = this.zzg;
        this.zzp = j3 + (zzldVar2.zzb - zza);
        this.zzg = zzldVar2.zzb(zza);
    }

    public final void zzm(zzve zzveVar, long j) {
        this.zzd = true;
        this.zza.zzk(zzveVar, j);
    }

    public final void zzn(long j) {
        zzdd.zzf(zzw());
        if (this.zze) {
            this.zza.zzm(j - this.zzp);
        }
    }

    public final void zzo() {
        zzu();
        zzvf zzvfVar = this.zza;
        try {
            boolean z = zzvfVar instanceof zzul;
            zzlr zzlrVar = this.zzl;
            if (z) {
                zzlrVar.zzi(((zzul) zzvfVar).zza);
            } else {
                zzlrVar.zzi(zzvfVar);
            }
        } catch (RuntimeException e) {
            zzea.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzp(zzlc zzlcVar) {
        if (zzlcVar == this.zzm) {
            return;
        }
        zzu();
        this.zzm = zzlcVar;
        zzv();
    }

    public final void zzq(long j) {
        this.zzp = j;
    }

    public final void zzr() {
        zzvf zzvfVar = this.zza;
        if (zzvfVar instanceof zzul) {
            long j = this.zzg.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zzul) zzvfVar).zzn(0L, j);
        }
    }

    public final boolean zzs() {
        if (this.zze) {
            return !this.zzf || this.zza.zzb() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean zzt() {
        if (this.zze) {
            return zzs() || zzc() - this.zzg.zzb >= -9223372036854775807L;
        }
        return false;
    }
}
