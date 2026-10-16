package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzlf {
    private final zzmo zzc;
    private final zzdt zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzix zzh;
    private zzlc zzi;
    private zzlc zzj;
    private zzlc zzk;
    private zzlc zzl;
    private zzlc zzm;
    private int zzn;
    private Object zzo;
    private long zzp;
    private final zzkk zzr;
    private final zzbj zza = new zzbj();
    private final zzbk zzb = new zzbk();
    private List zzq = new ArrayList();

    public zzlf(zzmo zzmoVar, zzdt zzdtVar, zzkk zzkkVar, zzix zzixVar) {
        this.zzc = zzmoVar;
        this.zzd = zzdtVar;
        this.zzr = zzkkVar;
        this.zzh = zzixVar;
    }

    private final int zzA(zzbl zzblVar) {
        zzbl zzblVar2;
        zzlc zzlcVar = this.zzi;
        if (zzlcVar == null) {
            return 0;
        }
        int zza = zzblVar.zza(zzlcVar.zzb);
        while (true) {
            zzblVar2 = zzblVar;
            zza = zzblVar2.zzi(zza, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzlcVar.getClass();
                if (zzlcVar.zzg() == null || zzlcVar.zzg.zzh) {
                    break;
                }
                zzlcVar = zzlcVar.zzg();
            }
            zzlc zzg = zzlcVar.zzg();
            if (zza == -1 || zzg == null || zzblVar2.zza(zzg.zzb) != zza) {
                break;
            }
            zzlcVar = zzg;
            zzblVar = zzblVar2;
        }
        int zza2 = zza(zzlcVar);
        zzlcVar.zzg = zzp(zzblVar2, zzlcVar.zzg);
        return zza2;
    }

    private final long zzB(zzbl zzblVar, Object obj, int i) {
        zzbj zzbjVar = this.zza;
        zzblVar.zzn(obj, zzbjVar);
        zzbjVar.zzg(i);
        long j = zzbjVar.zzg.zza(i).zzh;
        return 0L;
    }

    private final long zzC(Object obj) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzlc zzlcVar = (zzlc) this.zzq.get(i);
            if (zzlcVar.zzb.equals(obj)) {
                return zzlcVar.zzg.zza.zzd;
            }
        }
        return -1L;
    }

    private final zzld zzD(zzbl zzblVar, zzlc zzlcVar, long j) {
        zzbl zzblVar2;
        long j2;
        zzbl zzblVar3;
        zzbj zzbjVar;
        zzbk zzbkVar;
        Object obj;
        long j3;
        long j4;
        long j5;
        zzld zzldVar = zzlcVar.zzg;
        long zze = zzlcVar.zze();
        long j6 = zzldVar.zze;
        long j7 = (zze + j6) - j;
        if (!zzldVar.zzh) {
            zzvh zzvhVar = zzldVar.zza;
            Object obj2 = zzvhVar.zza;
            zzbj zzbjVar2 = this.zza;
            zzblVar.zzn(obj2, zzbjVar2);
            boolean z = zzldVar.zzg;
            if (!zzvhVar.zzb()) {
                int i = zzvhVar.zze;
                if (i != -1) {
                    zzbjVar2.zzj(i);
                }
                int zze2 = zzbjVar2.zze(i);
                zzbjVar2.zzk(i);
                if (zze2 != zzbjVar2.zza(i)) {
                    return zzF(zzblVar, obj2, i, zze2, j6, zzvhVar.zzd, false);
                }
                zzB(zzblVar, obj2, i);
                return zzG(zzblVar, obj2, 0L, j6, zzvhVar.zzd, false);
            }
            int i2 = zzvhVar.zzb;
            if (zzbjVar2.zza(i2) == -1) {
                return null;
            }
            int zza = zzbjVar2.zzg.zza(i2).zza(zzvhVar.zzc);
            if (zza < 0) {
                return zzF(zzblVar, obj2, i2, zza, zzldVar.zzc, zzvhVar.zzd, false);
            }
            long j8 = zzldVar.zzc;
            if (j8 == -9223372036854775807L) {
                Pair zzm = zzblVar.zzm(this.zzb, zzbjVar2, zzbjVar2.zzc, -9223372036854775807L, Math.max(0L, j7));
                zzblVar2 = zzblVar;
                if (zzm == null) {
                    return null;
                }
                j8 = ((Long) zzm.second).longValue();
                j2 = -9223372036854775807L;
            } else {
                zzblVar2 = zzblVar;
                j2 = j8;
            }
            zzB(zzblVar2, obj2, i2);
            return zzG(zzblVar2, obj2, Math.max(0L, j8), j2, zzvhVar.zzd, false);
        }
        zzvh zzvhVar2 = zzldVar.zza;
        Object obj3 = zzvhVar2.zza;
        int zza2 = zzblVar.zza(obj3);
        int i3 = this.zzf;
        boolean z2 = this.zzg;
        zzbk zzbkVar2 = this.zzb;
        zzbj zzbjVar3 = this.zza;
        long j9 = 0;
        int zzi = zzblVar.zzi(zza2, zzbjVar3, zzbkVar2, i3, z2);
        if (zzi == -1) {
            return null;
        }
        int i4 = zzblVar.zzd(zzi, zzbjVar3, true).zzc;
        Object obj4 = zzbjVar3.zzb;
        obj4.getClass();
        long j10 = zzvhVar2.zzd;
        if (zzblVar.zze(i4, zzbkVar2, 0L).zzn == zzi) {
            Pair zzm2 = zzblVar.zzm(zzbkVar2, zzbjVar3, i4, -9223372036854775807L, Math.max(0L, j7));
            if (zzm2 == null) {
                return null;
            }
            Object obj5 = zzm2.first;
            long longValue = ((Long) zzm2.second).longValue();
            zzlc zzg = zzlcVar.zzg();
            if (zzg == null || !zzg.zzb.equals(obj5)) {
                long zzC = zzC(obj5);
                if (zzC == -1) {
                    zzC = this.zze;
                    this.zze = 1 + zzC;
                }
                j5 = zzC;
            } else {
                j5 = zzg.zzg.zza.zzd;
            }
            zzblVar3 = zzblVar;
            zzbkVar = zzbkVar2;
            zzbjVar = zzbjVar3;
            j3 = longValue;
            obj = obj5;
            j4 = j5;
            j9 = -9223372036854775807L;
        } else {
            zzblVar3 = zzblVar;
            zzbjVar = zzbjVar3;
            zzbkVar = zzbkVar2;
            obj = obj4;
            j3 = 0;
            j4 = j10;
        }
        zzvh zzH = zzH(zzblVar3, obj, j3, j4, zzbkVar, zzbjVar);
        long j11 = j3;
        zzbj zzbjVar4 = zzbjVar;
        if (j9 != -9223372036854775807L && zzldVar.zzc != -9223372036854775807L) {
            zzblVar3.zzn(obj3, zzbjVar4).zzb();
            int i5 = zzbjVar4.zzg.zzd;
        }
        return zzE(zzblVar3, zzH, j9, j11);
    }

    private final zzld zzE(zzbl zzblVar, zzvh zzvhVar, long j, long j2) {
        Object obj = zzvhVar.zza;
        zzblVar.zzn(obj, this.zza);
        return zzvhVar.zzb() ? zzF(zzblVar, obj, zzvhVar.zzb, zzvhVar.zzc, j, zzvhVar.zzd, false) : zzG(zzblVar, obj, j2, j, zzvhVar.zzd, false);
    }

    private final zzld zzF(zzbl zzblVar, Object obj, int i, int i2, long j, long j2, boolean z) {
        zzvh zzvhVar = new zzvh(obj, i, i2, j2);
        Object obj2 = zzvhVar.zza;
        int i3 = zzvhVar.zzb;
        int i4 = zzvhVar.zzc;
        zzbj zzbjVar = this.zza;
        long zzf = zzblVar.zzn(obj2, zzbjVar).zzf(i3, i4);
        if (i2 == zzbjVar.zze(i)) {
            zzbjVar.zzh();
        }
        zzbjVar.zzk(i3);
        long j3 = 0;
        if (zzf != -9223372036854775807L && zzf <= 0) {
            j3 = Math.max(0L, (-1) + zzf);
        }
        return new zzld(zzvhVar, j3, j, -9223372036854775807L, zzf, false, false, false, false, false);
    }

    private final zzld zzG(zzbl zzblVar, Object obj, long j, long j2, long j3, boolean z) {
        long j4;
        long j5;
        long j6;
        long j7 = j;
        zzbj zzbjVar = this.zza;
        zzblVar.zzn(obj, zzbjVar);
        int zzc = zzbjVar.zzc(j7);
        if (zzc == -1) {
            zzbjVar.zzb();
        } else {
            zzbjVar.zzk(zzc);
        }
        zzvh zzvhVar = new zzvh(obj, j3, zzc);
        boolean zzL = zzL(zzvhVar);
        boolean zzK = zzK(zzblVar, zzvhVar);
        boolean zzJ = zzJ(zzblVar, zzvhVar, zzL);
        if (zzc != -1) {
            zzbjVar.zzk(zzc);
        }
        if (zzc != -1) {
            zzbjVar.zzj(zzc);
        }
        if (zzc != -1) {
            zzbjVar.zzg(zzc);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j6 = j4;
            j5 = j6;
        } else {
            j5 = zzbjVar.zzd;
            j6 = -9223372036854775807L;
        }
        if (j5 != -9223372036854775807L && j7 >= j5) {
            j7 = Math.max(0L, j5 - 1);
        }
        return new zzld(zzvhVar, j7, j2, j6, j5, false, false, zzL, zzK, zzJ);
    }

    private static zzvh zzH(zzbl zzblVar, Object obj, long j, long j2, zzbk zzbkVar, zzbj zzbjVar) {
        zzblVar.zzn(obj, zzbjVar);
        zzblVar.zze(zzbjVar.zzc, zzbkVar, 0L);
        zzblVar.zza(obj);
        zzbjVar.zzb();
        zzblVar.zzn(obj, zzbjVar);
        int zzd = zzbjVar.zzd(j);
        return zzd == -1 ? new zzvh(obj, j2, zzbjVar.zzc(j)) : new zzvh(obj, zzd, zzbjVar.zze(zzd), j2);
    }

    private final void zzI() {
        int i = zzfyq.zzd;
        final zzfyn zzfynVar = new zzfyn();
        for (zzlc zzlcVar = this.zzi; zzlcVar != null; zzlcVar = zzlcVar.zzg()) {
            zzfynVar.zzf(zzlcVar.zzg.zza);
        }
        zzlc zzlcVar2 = this.zzj;
        final zzvh zzvhVar = zzlcVar2 == null ? null : zzlcVar2.zzg.zza;
        this.zzd.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzle
            @Override // java.lang.Runnable
            public final void run() {
                zzlf.this.zzc.zzU(zzfynVar.zzi(), zzvhVar);
            }
        });
    }

    private final boolean zzJ(zzbl zzblVar, zzvh zzvhVar, boolean z) {
        int zza = zzblVar.zza(zzvhVar.zza);
        zzbj zzbjVar = this.zza;
        int i = zzblVar.zzd(zza, zzbjVar, false).zzc;
        zzbk zzbkVar = this.zzb;
        return !zzblVar.zze(i, zzbkVar, 0L).zzi && zzblVar.zzi(zza, zzbjVar, zzbkVar, this.zzf, this.zzg) == -1 && z;
    }

    private final boolean zzK(zzbl zzblVar, zzvh zzvhVar) {
        if (!zzL(zzvhVar)) {
            return false;
        }
        Object obj = zzvhVar.zza;
        return zzblVar.zze(zzblVar.zzn(obj, this.zza).zzc, this.zzb, 0L).zzo == zzblVar.zza(obj);
    }

    private static final boolean zzL(zzvh zzvhVar) {
        return !zzvhVar.zzb() && zzvhVar.zze == -1;
    }

    public final int zza(zzlc zzlcVar) {
        zzdd.zzb(zzlcVar);
        int i = 0;
        if (zzlcVar.equals(this.zzl)) {
            return 0;
        }
        this.zzl = zzlcVar;
        while (zzlcVar.zzg() != null) {
            zzlcVar = zzlcVar.zzg();
            zzlcVar.getClass();
            if (zzlcVar == this.zzj) {
                zzlc zzlcVar2 = this.zzi;
                this.zzj = zzlcVar2;
                this.zzk = zzlcVar2;
                i = 3;
            }
            if (zzlcVar == this.zzk) {
                this.zzk = this.zzj;
                i |= 2;
            }
            zzlcVar.zzo();
            this.zzn--;
        }
        zzlc zzlcVar3 = this.zzl;
        zzlcVar3.getClass();
        zzlcVar3.zzp(null);
        zzI();
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a5, code lost:
    
        return zza(r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(zzbl zzblVar, long j, long j2, long j3) {
        zzld zzldVar;
        boolean z;
        int zza;
        zzlc zzlcVar = this.zzi;
        zzlc zzlcVar2 = null;
        while (true) {
            int i = 0;
            if (zzlcVar == null) {
                return 0;
            }
            zzld zzldVar2 = zzlcVar.zzg;
            if (zzlcVar2 == null) {
                zzldVar = zzp(zzblVar, zzldVar2);
            } else {
                zzld zzD = zzD(zzblVar, zzlcVar2, j);
                if (zzD == null || zzldVar2.zzb != zzD.zzb || !zzldVar2.zza.equals(zzD.zza)) {
                    break;
                }
                zzldVar = zzD;
            }
            zzlcVar.zzg = zzldVar.zza(zzldVar2.zzc);
            long j4 = zzldVar2.zze;
            long j5 = zzldVar.zze;
            if (j4 != j5) {
                zzlcVar.zzr();
                long zze = j5 == -9223372036854775807L ? Long.MAX_VALUE : j5 + zzlcVar.zze();
                if (zzlcVar == this.zzj) {
                    boolean z2 = zzlcVar.zzg.zzg;
                    if (j2 == Long.MIN_VALUE || j2 >= zze) {
                        z = true;
                        boolean z3 = zzlcVar != this.zzk && (j3 == Long.MIN_VALUE || j3 >= zze);
                        zza = zza(zzlcVar);
                        if (zza == 0) {
                            return zza;
                        }
                        if (j4 == -9223372036854775807L) {
                            long j6 = zzldVar2.zzd;
                            j4 = -9223372036854775807L;
                        }
                        if (z && j4 != -9223372036854775807L) {
                            i = 1;
                        }
                        return z3 ? i | 2 : i;
                    }
                }
                z = false;
                if (zzlcVar != this.zzk) {
                }
                zza = zza(zzlcVar);
                if (zza == 0) {
                }
            } else {
                zzlcVar2 = zzlcVar;
                zzlcVar = zzlcVar.zzg();
            }
        }
    }

    public final int zzc(zzbl zzblVar, int i) {
        this.zzf = i;
        return zzA(zzblVar);
    }

    public final int zzd(zzbl zzblVar, boolean z) {
        this.zzg = z;
        return zzA(zzblVar);
    }

    public final zzlc zze() {
        zzlc zzlcVar = this.zzi;
        if (zzlcVar == null) {
            return null;
        }
        if (zzlcVar == this.zzj) {
            this.zzj = zzlcVar.zzg();
        }
        if (zzlcVar == this.zzk) {
            this.zzk = zzlcVar.zzg();
        }
        zzlcVar.zzo();
        int i = this.zzn - 1;
        this.zzn = i;
        if (i == 0) {
            this.zzl = null;
            zzlc zzlcVar2 = this.zzi;
            this.zzo = zzlcVar2.zzb;
            this.zzp = zzlcVar2.zzg.zza.zzd;
        }
        this.zzi = this.zzi.zzg();
        zzI();
        return this.zzi;
    }

    public final zzlc zzf() {
        zzlc zzlcVar = this.zzk;
        zzdd.zzb(zzlcVar);
        this.zzk = zzlcVar.zzg();
        zzI();
        zzlc zzlcVar2 = this.zzk;
        zzdd.zzb(zzlcVar2);
        return zzlcVar2;
    }

    public final zzlc zzg() {
        zzlc zzlcVar = this.zzk;
        zzlc zzlcVar2 = this.zzj;
        if (zzlcVar == zzlcVar2) {
            zzdd.zzb(zzlcVar2);
            this.zzk = zzlcVar2.zzg();
        }
        zzlc zzlcVar3 = this.zzj;
        zzdd.zzb(zzlcVar3);
        this.zzj = zzlcVar3.zzg();
        zzI();
        zzlc zzlcVar4 = this.zzj;
        zzdd.zzb(zzlcVar4);
        return zzlcVar4;
    }

    public final zzlc zzi() {
        return this.zzl;
    }

    public final zzlc zzj() {
        return this.zzi;
    }

    public final zzlc zzk(zzvf zzvfVar) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzlc zzlcVar = (zzlc) this.zzq.get(i);
            if (zzlcVar.zza == zzvfVar) {
                return zzlcVar;
            }
        }
        return null;
    }

    public final zzlc zzl() {
        return this.zzm;
    }

    public final zzlc zzm() {
        return this.zzk;
    }

    public final zzlc zzn() {
        return this.zzj;
    }

    public final zzld zzo(long j, zzls zzlsVar) {
        zzlc zzlcVar = this.zzl;
        return zzlcVar == null ? zzE(zzlsVar.zza, zzlsVar.zzb, zzlsVar.zzc, zzlsVar.zzs) : zzD(zzlsVar.zza, zzlcVar, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzld zzp(zzbl zzblVar, zzld zzldVar) {
        long j;
        long j2;
        long j3;
        long j4;
        int i;
        zzvh zzvhVar = zzldVar.zza;
        boolean zzL = zzL(zzvhVar);
        boolean zzK = zzK(zzblVar, zzvhVar);
        boolean zzJ = zzJ(zzblVar, zzvhVar, zzL);
        Object obj = zzvhVar.zza;
        zzbj zzbjVar = this.zza;
        zzblVar.zzn(obj, zzbjVar);
        if (zzvhVar.zzb() || (i = zzvhVar.zze) == -1) {
            j = -9223372036854775807L;
        } else {
            zzbjVar.zzg(i);
            j = 0;
        }
        if (zzvhVar.zzb()) {
            j2 = zzbjVar.zzf(zzvhVar.zzb, zzvhVar.zzc);
        } else {
            if (j != -9223372036854775807L) {
                j3 = 0;
                j4 = 0;
                if (zzvhVar.zzb()) {
                    int i2 = zzvhVar.zze;
                    if (i2 != -1) {
                        zzbjVar.zzk(i2);
                    }
                } else {
                    zzbjVar.zzk(zzvhVar.zzb);
                }
                long j5 = zzldVar.zzb;
                long j6 = zzldVar.zzc;
                boolean z = zzldVar.zzf;
                return new zzld(zzvhVar, j5, j6, j4, j3, false, false, zzL, zzK, zzJ);
            }
            j2 = zzbjVar.zzd;
        }
        j3 = j2;
        j4 = j;
        if (zzvhVar.zzb()) {
        }
        long j52 = zzldVar.zzb;
        long j62 = zzldVar.zzc;
        boolean z2 = zzldVar.zzf;
        return new zzld(zzvhVar, j52, j62, j4, j3, false, false, zzL, zzK, zzJ);
    }

    public final zzvh zzq(zzbl zzblVar, Object obj, long j) {
        long zzC;
        int zza;
        zzbj zzbjVar = this.zza;
        int i = zzblVar.zzn(obj, zzbjVar).zzc;
        Object obj2 = this.zzo;
        if (obj2 == null || (zza = zzblVar.zza(obj2)) == -1 || zzblVar.zzd(zza, zzbjVar, false).zzc != i) {
            zzlc zzlcVar = this.zzi;
            while (true) {
                if (zzlcVar == null) {
                    zzlc zzlcVar2 = this.zzi;
                    while (true) {
                        if (zzlcVar2 != null) {
                            int zza2 = zzblVar.zza(zzlcVar2.zzb);
                            if (zza2 != -1 && zzblVar.zzd(zza2, zzbjVar, false).zzc == i) {
                                zzC = zzlcVar2.zzg.zza.zzd;
                                break;
                            }
                            zzlcVar2 = zzlcVar2.zzg();
                        } else {
                            zzC = zzC(obj);
                            if (zzC == -1) {
                                zzC = this.zze;
                                this.zze = 1 + zzC;
                                if (this.zzi == null) {
                                    this.zzo = obj;
                                    this.zzp = zzC;
                                }
                            }
                        }
                    }
                } else {
                    if (zzlcVar.zzb.equals(obj)) {
                        zzC = zzlcVar.zzg.zza.zzd;
                        break;
                    }
                    zzlcVar = zzlcVar.zzg();
                }
            }
        } else {
            zzC = this.zzp;
        }
        long j2 = zzC;
        zzblVar.zzn(obj, zzbjVar);
        int i2 = zzbjVar.zzc;
        zzbk zzbkVar = this.zzb;
        zzblVar.zze(i2, zzbkVar, 0L);
        Object obj3 = obj;
        for (int zza3 = zzblVar.zza(obj); zza3 >= zzbkVar.zzn; zza3--) {
            zzblVar.zzd(zza3, zzbjVar, true);
            zzbjVar.zzb();
            if (zzbjVar.zzd(zzbjVar.zzd) != -1) {
                Object obj4 = zzbjVar.zzb;
                obj4.getClass();
                obj3 = obj4;
            }
        }
        return zzH(zzblVar, obj3, j, j2, zzbkVar, zzbjVar);
    }

    public final void zzs() {
        if (this.zzn == 0) {
            return;
        }
        zzlc zzlcVar = this.zzi;
        zzdd.zzb(zzlcVar);
        this.zzo = zzlcVar.zzb;
        this.zzp = zzlcVar.zzg.zza.zzd;
        while (zzlcVar != null) {
            zzlcVar.zzo();
            zzlcVar = zzlcVar.zzg();
        }
        this.zzi = null;
        this.zzl = null;
        this.zzj = null;
        this.zzk = null;
        this.zzn = 0;
        zzI();
    }

    public final void zzt() {
        zzlc zzlcVar = this.zzm;
        if (zzlcVar == null || zzlcVar.zzt()) {
            this.zzm = null;
            for (int i = 0; i < this.zzq.size(); i++) {
                zzlc zzlcVar2 = (zzlc) this.zzq.get(i);
                if (!zzlcVar2.zzt()) {
                    this.zzm = zzlcVar2;
                    return;
                }
            }
        }
    }

    public final void zzu(long j) {
        zzlc zzlcVar = this.zzl;
        if (zzlcVar != null) {
            zzlcVar.zzn(j);
        }
    }

    public final void zzv() {
        if (this.zzq.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.zzq.size(); i++) {
            ((zzlc) this.zzq.get(i)).zzo();
        }
        this.zzq = arrayList;
        this.zzm = null;
        zzt();
    }

    public final void zzw(zzbl zzblVar, zzix zzixVar) {
        this.zzh = zzixVar;
        long j = zzixVar.zzb;
        zzv();
    }

    public final boolean zzx(zzvf zzvfVar) {
        zzlc zzlcVar = this.zzl;
        return zzlcVar != null && zzlcVar.zza == zzvfVar;
    }

    public final boolean zzy(zzvf zzvfVar) {
        zzlc zzlcVar = this.zzm;
        return zzlcVar != null && zzlcVar.zza == zzvfVar;
    }

    public final boolean zzz() {
        zzlc zzlcVar = this.zzl;
        if (zzlcVar != null) {
            return !zzlcVar.zzg.zzj && zzlcVar.zzs() && this.zzl.zzg.zze != -9223372036854775807L && this.zzn < 100;
        }
        return true;
    }

    public final zzlc zzh(zzld zzldVar) {
        zzlc zzlcVar;
        zzlc zzlcVar2 = this.zzl;
        long zze = zzlcVar2 == null ? 1000000000000L : (zzlcVar2.zze() + zzlcVar2.zzg.zze) - zzldVar.zzb;
        int i = 0;
        while (true) {
            if (i >= this.zzq.size()) {
                zzlcVar = null;
                break;
            }
            zzld zzldVar2 = ((zzlc) this.zzq.get(i)).zzg;
            long j = zzldVar2.zze;
            long j2 = zzldVar.zze;
            if ((j == -9223372036854775807L || j == j2) && zzldVar2.zzb == zzldVar.zzb && zzldVar2.zza.equals(zzldVar.zza)) {
                zzlcVar = (zzlc) this.zzq.remove(i);
                break;
            }
            i++;
        }
        if (zzlcVar == null) {
            zzlcVar = zzkt.zzg(this.zzr.zza, zzldVar, zze);
        } else {
            zzlcVar.zzg = zzldVar;
            zzlcVar.zzq(zze);
        }
        zzlc zzlcVar3 = this.zzl;
        if (zzlcVar3 != null) {
            zzlcVar3.zzp(zzlcVar);
        } else {
            this.zzi = zzlcVar;
            this.zzj = zzlcVar;
            this.zzk = zzlcVar;
        }
        this.zzo = null;
        this.zzl = zzlcVar;
        this.zzn++;
        zzI();
        return zzlcVar;
    }
}
