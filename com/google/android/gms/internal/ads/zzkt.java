package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzkt implements Handler.Callback, zzve, zzzc, zzlq, zzik, zzlu, zzia, zzabp {
    private static final long zza = zzex.zzv(10000);
    private boolean zzB;
    private boolean zzC;
    private zzkr zzD;
    private zzls zzE;
    private zzkq zzF;
    private boolean zzG;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzL;
    private boolean zzO;
    private int zzP;
    private zzkr zzQ;
    private long zzR;
    private long zzS;
    private int zzT;
    private boolean zzU;
    private zzin zzV;
    private zzix zzX;
    private boolean zzZ;
    private final zzjj zzab;
    private final zzig zzac;
    private final zzmf[] zzb;
    private final zzmd[] zzc;
    private final boolean[] zzd;
    private final zzzd zze;
    private final zzze zzf;
    private final zzkx zzg;
    private final zzzl zzh;
    private final zzdt zzi;
    private final zzlt zzj;
    private final Looper zzk;
    private final zzbk zzl;
    private final zzbj zzm;
    private final long zzn;
    private final zzil zzo;
    private final ArrayList zzp;
    private final zzdj zzq;
    private final zzlf zzr;
    private final zzlr zzs;
    private final long zzt;
    private final zzph zzu;
    private final zzmo zzv;
    private final zzdt zzw;
    private final boolean zzx;
    private final zzib zzy;
    private zzmi zzz;
    private long zzY = -9223372036854775807L;
    private int zzM = 0;
    private boolean zzN = false;
    private boolean zzH = false;
    private float zzaa = 1.0f;
    private zzmh zzA = zzmh.zza;
    private long zzW = -9223372036854775807L;
    private long zzK = -9223372036854775807L;

    public zzkt(Context context, zzma[] zzmaVarArr, zzma[] zzmaVarArr2, zzzd zzzdVar, zzze zzzeVar, zzkx zzkxVar, zzzl zzzlVar, int i, boolean z, zzmo zzmoVar, zzmi zzmiVar, zzig zzigVar, long j, boolean z2, boolean z3, Looper looper, zzdj zzdjVar, zzjj zzjjVar, zzph zzphVar, zzlt zzltVar, zzix zzixVar, final zzabp zzabpVar) {
        this.zzab = zzjjVar;
        this.zze = zzzdVar;
        this.zzf = zzzeVar;
        this.zzg = zzkxVar;
        this.zzh = zzzlVar;
        int i2 = 0;
        this.zzz = zzmiVar;
        this.zzac = zzigVar;
        this.zzt = j;
        this.zzq = zzdjVar;
        this.zzu = zzphVar;
        this.zzX = zzixVar;
        this.zzv = zzmoVar;
        this.zzn = zzkxVar.zzb(zzphVar);
        zzkxVar.zzg(zzphVar);
        zzbl zzblVar = zzbl.zza;
        this.zzE = zzls.zzh(zzzeVar);
        this.zzF = new zzkq(this.zzE);
        int length = zzmaVarArr.length;
        this.zzc = new zzmd[2];
        this.zzd = new boolean[2];
        zzmc zze = zzzdVar.zze();
        this.zzb = new zzmf[2];
        boolean z4 = false;
        while (true) {
            int length2 = zzmaVarArr.length;
            if (i2 >= 2) {
                this.zzx = z4;
                this.zzo = new zzil(this, zzdjVar);
                this.zzp = new ArrayList();
                this.zzl = new zzbk();
                this.zzm = new zzbj();
                zzzdVar.zzr(this, zzzlVar);
                this.zzU = true;
                zzdt zzd = zzdjVar.zzd(looper, null);
                this.zzw = zzd;
                this.zzr = new zzlf(zzmoVar, zzd, new zzkk(this), zzixVar);
                this.zzs = new zzlr(this, zzmoVar, zzd, zzphVar);
                zzlt zzltVar2 = new zzlt(null);
                this.zzj = zzltVar2;
                Looper zza2 = zzltVar2.zza();
                this.zzk = zza2;
                zzdt zzd2 = zzdjVar.zzd(zza2, this);
                this.zzi = zzd2;
                this.zzy = new zzib(context, zza2, this);
                zzd2.zzc(35, new zzabp() { // from class: com.google.android.gms.internal.ads.zzkl
                    @Override // com.google.android.gms.internal.ads.zzabp
                    public final void zzcT(long j2, long j3, zzz zzzVar, MediaFormat mediaFormat) {
                        zzkt.this.zzcT(j2, j3, zzzVar, mediaFormat);
                    }
                }).zza();
                return;
            }
            zzmaVarArr[i2].zzw(i2, zzphVar, zzdjVar);
            this.zzc[i2] = zzmaVarArr[i2].zzn();
            this.zzc[i2].zzM(zze);
            zzma zzmaVar = zzmaVarArr2[i2];
            if (zzmaVar != null) {
                zzmaVar.zzw(i2, zzphVar, zzdjVar);
                z4 = true;
            }
            this.zzb[i2] = new zzmf(zzmaVarArr[i2], zzmaVarArr2[i2], i2);
            i2++;
        }
    }

    private final long zzA(zzlc zzlcVar) {
        if (zzlcVar == null) {
            return 0L;
        }
        long zze = zzlcVar.zze();
        if (zzlcVar.zze) {
            int i = 0;
            while (true) {
                zzmf[] zzmfVarArr = this.zzb;
                if (i >= 2) {
                    break;
                }
                if (zzmfVarArr[i].zzK(zzlcVar)) {
                    long zze2 = zzmfVarArr[i].zze(zzlcVar);
                    if (zze2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    zze = Math.max(zze2, zze);
                }
                i++;
            }
        }
        return zze;
    }

    private final long zzB() {
        return zzC(this.zzE.zzq);
    }

    private final long zzC(long j) {
        zzlc zzi = this.zzr.zzi();
        if (zzi == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzR - zzi.zze()));
    }

    private final long zzD(zzvh zzvhVar, long j, boolean z) throws zzin {
        zzlf zzlfVar = this.zzr;
        return zzE(zzvhVar, j, zzlfVar.zzj() != zzlfVar.zzn(), z);
    }

    private final long zzE(zzvh zzvhVar, long j, boolean z, boolean z2) throws zzin {
        zzan();
        zzav(false, true);
        if (z2 || this.zzE.zze == 3) {
            zzaj(2);
        }
        zzlf zzlfVar = this.zzr;
        zzlc zzj = zzlfVar.zzj();
        zzlc zzlcVar = zzj;
        while (zzlcVar != null && !zzvhVar.equals(zzlcVar.zzg.zza)) {
            zzlcVar = zzlcVar.zzg();
        }
        if (z || zzj != zzlcVar || (zzlcVar != null && zzlcVar.zze() + j < 0)) {
            zzK();
            if (zzlcVar != null) {
                while (zzlfVar.zzj() != zzlcVar) {
                    zzlfVar.zze();
                }
                zzlfVar.zza(zzlcVar);
                zzlcVar.zzq(1000000000000L);
                zzM();
                zzlcVar.zzh = true;
            }
        }
        zzJ();
        if (zzlcVar != null) {
            zzlfVar.zza(zzlcVar);
            if (!zzlcVar.zze) {
                zzlcVar.zzg = zzlcVar.zzg.zzb(j);
            } else if (zzlcVar.zzf) {
                zzvf zzvfVar = zzlcVar.zza;
                j = zzvfVar.zze(j);
                zzvfVar.zzh(j - this.zzn, false);
            }
            zzac(j);
            zzT();
        } else {
            zzlfVar.zzs();
            zzac(j);
        }
        zzP(false);
        this.zzi.zzj(2);
        return j;
    }

    private final Pair zzF(zzbl zzblVar) {
        long j = 0;
        if (zzblVar.zzo()) {
            return Pair.create(zzls.zzi(), 0L);
        }
        int zzg = zzblVar.zzg(this.zzN);
        zzbk zzbkVar = this.zzl;
        zzbj zzbjVar = this.zzm;
        Pair zzl = zzblVar.zzl(zzbkVar, zzbjVar, zzg, -9223372036854775807L);
        zzvh zzq = this.zzr.zzq(zzblVar, zzl.first, 0L);
        long longValue = ((Long) zzl.second).longValue();
        if (zzq.zzb()) {
            zzblVar.zzn(zzq.zza, zzbjVar);
            if (zzq.zzc == zzbjVar.zze(zzq.zzb)) {
                zzbjVar.zzh();
            }
        } else {
            j = longValue;
        }
        return Pair.create(zzq, Long.valueOf(j));
    }

    private static Pair zzG(zzbl zzblVar, zzkr zzkrVar, boolean z, int i, boolean z2, zzbk zzbkVar, zzbj zzbjVar) {
        Pair zzl;
        zzbl zzblVar2;
        zzbl zzblVar3 = zzkrVar.zza;
        if (zzblVar.zzo()) {
            return null;
        }
        if (true == zzblVar3.zzo()) {
            zzblVar3 = zzblVar;
        }
        try {
            zzl = zzblVar3.zzl(zzbkVar, zzbjVar, zzkrVar.zzb, zzkrVar.zzc);
            zzblVar2 = zzblVar3;
        } catch (IndexOutOfBoundsException unused) {
        }
        if (!zzblVar.equals(zzblVar2)) {
            if (zzblVar.zza(zzl.first) == -1) {
                int zzd = zzd(zzbkVar, zzbjVar, i, z2, zzl.first, zzblVar2, zzblVar);
                if (zzd != -1) {
                    return zzblVar.zzl(zzbkVar, zzbjVar, zzd, -9223372036854775807L);
                }
                return null;
            }
            if (zzblVar2.zzn(zzl.first, zzbjVar).zzf && zzblVar2.zze(zzbjVar.zzc, zzbkVar, 0L).zzn == zzblVar2.zza(zzl.first)) {
                return zzblVar.zzl(zzbkVar, zzbjVar, zzblVar.zzn(zzl.first, zzbjVar).zzc, zzkrVar.zzc);
            }
        }
        return zzl;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce A[EDGE_INSN: B:51:0x00ce->B:52:0x00ce BREAK  A[LOOP:1: B:39:0x00af->B:47:0x00cb], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzls zzH(zzvh zzvhVar, long j, long j2, long j3, boolean z, int i) {
        List list;
        zzze zzzeVar;
        zzlc zzj;
        int i2 = 0;
        this.zzU = (!this.zzU && j == this.zzE.zzs && zzvhVar.equals(this.zzE.zzb)) ? false : true;
        zzab();
        zzls zzlsVar = this.zzE;
        zzxk zzxkVar = zzlsVar.zzh;
        zzze zzzeVar2 = zzlsVar.zzi;
        List list2 = zzlsVar.zzj;
        if (this.zzs.zzj()) {
            zzlf zzlfVar = this.zzr;
            zzlc zzj2 = zzlfVar.zzj();
            zzxk zzh = zzj2 == null ? zzxk.zza : zzj2.zzh();
            zzze zzi = zzj2 == null ? this.zzf : zzj2.zzi();
            zzyw[] zzywVarArr = zzi.zzc;
            zzfyn zzfynVar = new zzfyn();
            boolean z2 = false;
            for (zzyw zzywVar : zzywVarArr) {
                if (zzywVar != null) {
                    zzav zzavVar = zzywVar.zza(0).zzl;
                    if (zzavVar == null) {
                        zzfynVar.zzf(new zzav(-9223372036854775807L, new zzau[0]));
                    } else {
                        zzfynVar.zzf(zzavVar);
                        z2 = true;
                    }
                }
            }
            zzfyq zzi2 = z2 ? zzfynVar.zzi() : zzfyq.zzn();
            if (zzj2 != null) {
                zzld zzldVar = zzj2.zzg;
                if (zzldVar.zzc != j2) {
                    zzj2.zzg = zzldVar.zza(j2);
                    if (zzlfVar.zzj() == zzlfVar.zzn() && (zzj = zzlfVar.zzj()) != null) {
                        zzze zzi3 = zzj.zzi();
                        while (true) {
                            zzmf[] zzmfVarArr = this.zzb;
                            if (i2 >= 2) {
                                break;
                            }
                            if (zzi3.zzb(i2)) {
                                if (zzmfVarArr[i2].zzb() != 1) {
                                    break;
                                }
                                int i3 = zzi3.zzb[i2].zzb;
                            }
                            i2++;
                        }
                    }
                    list = zzi2;
                    zzxkVar = zzh;
                    zzzeVar = zzi;
                }
            }
            if (zzlfVar.zzj() == zzlfVar.zzn()) {
                zzze zzi32 = zzj.zzi();
                while (true) {
                    zzmf[] zzmfVarArr2 = this.zzb;
                    if (i2 >= 2) {
                    }
                    i2++;
                }
            }
            list = zzi2;
            zzxkVar = zzh;
            zzzeVar = zzi;
        } else {
            if (!zzvhVar.equals(this.zzE.zzb)) {
                zzzeVar2 = this.zzf;
                zzxkVar = zzxk.zza;
                list2 = zzfyq.zzn();
            }
            list = list2;
            zzzeVar = zzzeVar2;
        }
        if (z) {
            this.zzF.zzc(i);
        }
        return this.zzE.zzc(zzvhVar, j, j2, j3, zzB(), zzxkVar, zzzeVar, list);
    }

    private final void zzI() throws zzin {
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzmfVarArr[i].zzv(this.zzB ? this.zzA : null);
            i++;
        }
    }

    private final void zzJ() {
        if (this.zzx && zzaw()) {
            zzmf[] zzmfVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                zzmf zzmfVar = zzmfVarArr[i];
                int zza2 = zzmfVar.zza();
                zzmfVar.zzg(this.zzo);
                this.zzP -= zza2 - zzmfVar.zza();
            }
            this.zzY = -9223372036854775807L;
        }
    }

    private final void zzK() throws zzin {
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                this.zzY = -9223372036854775807L;
                return;
            }
            int zza2 = zzmfVarArr[i].zza();
            zzmfVarArr[i].zzf(this.zzo);
            zzX(i, false);
            this.zzP -= zza2;
            i++;
        }
    }

    private final void zzL(zzlc zzlcVar, int i, boolean z, long j) throws zzin {
        zzmf zzmfVar = this.zzb[i];
        if (zzmfVar.zzL()) {
            return;
        }
        boolean z2 = zzlcVar == this.zzr.zzj();
        zzze zzi = zzlcVar.zzi();
        zzme zzmeVar = zzi.zzb[i];
        zzyw zzywVar = zzi.zzc[i];
        boolean z3 = zzaA() && this.zzE.zze == 3;
        boolean z4 = !z && z3;
        this.zzP++;
        zzmfVar.zzh(zzmeVar, zzywVar, zzlcVar.zzc[i], this.zzR, z4, z2, j, zzlcVar.zze(), zzlcVar.zzg.zza, this.zzo);
        zzmfVar.zzj(11, new zzkm(this), zzlcVar);
        if (z3 && z2) {
            zzmfVar.zzA();
        }
    }

    private final void zzM() throws zzin {
        zzN(new boolean[2], this.zzr.zzn().zzf());
    }

    private final void zzN(boolean[] zArr, long j) throws zzin {
        zzmf[] zzmfVarArr;
        long j2;
        zzlc zzn = this.zzr.zzn();
        zzze zzi = zzn.zzi();
        int i = 0;
        while (true) {
            zzmfVarArr = this.zzb;
            if (i >= 2) {
                break;
            }
            if (!zzi.zzb(i)) {
                zzmfVarArr[i].zzq();
            }
            i++;
        }
        int i2 = 0;
        while (i2 < 2) {
            if (!zzi.zzb(i2) || zzmfVarArr[i2].zzK(zzn)) {
                j2 = j;
            } else {
                j2 = j;
                zzL(zzn, i2, zArr[i2], j2);
            }
            i2++;
            j = j2;
        }
    }

    private final void zzO(IOException iOException, int i) {
        zzlf zzlfVar = this.zzr;
        zzin zzc = zzin.zzc(iOException, i);
        zzlc zzj = zzlfVar.zzj();
        if (zzj != null) {
            zzc = zzc.zza(zzj.zzg.zza);
        }
        zzea.zzd("ExoPlayerImplInternal", "Playback error", zzc);
        zzam(false, false);
        this.zzE = this.zzE.zze(zzc);
    }

    private final void zzP(boolean z) {
        zzlc zzi = this.zzr.zzi();
        zzvh zzvhVar = zzi == null ? this.zzE.zzb : zzi.zzg.zza;
        boolean equals = this.zzE.zzk.equals(zzvhVar);
        if (!equals) {
            this.zzE = this.zzE.zzb(zzvhVar);
        }
        zzls zzlsVar = this.zzE;
        zzlsVar.zzq = zzi == null ? zzlsVar.zzs : zzi.zzc();
        this.zzE.zzr = zzB();
        if ((!equals || z) && zzi != null && zzi.zze) {
            zzap(zzi.zzg.zza, zzi.zzh(), zzi.zzi());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0270 A[Catch: all -> 0x0332, TryCatch #0 {all -> 0x0332, blocks: (B:105:0x026c, B:106:0x0270, B:108:0x0273, B:50:0x028b, B:52:0x0293, B:54:0x029b, B:56:0x02a5, B:58:0x02b0, B:61:0x02b5), top: B:48:0x021b }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0369 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x034a  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzQ(zzbl zzblVar, boolean z) throws zzin {
        Object obj;
        long j;
        zzvh zzvhVar;
        zzbk zzbkVar;
        Object obj2;
        long j2;
        Object obj3;
        int i;
        long j3;
        long j4;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        boolean z5;
        zzbl zzblVar2;
        long j5;
        zzvh zzvhVar2;
        boolean z6;
        boolean z7;
        int i3;
        long longValue;
        Object obj4;
        int i4;
        boolean z8;
        Object obj5;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        zzbl zzblVar3;
        boolean z13;
        zzkr zzkrVar;
        zzvh zzvhVar3;
        zzkr zzkrVar2;
        boolean z14;
        zzkr zzkrVar3;
        long zzA;
        int i5;
        boolean z15;
        int zzb;
        boolean z16;
        zzls zzlsVar = this.zzE;
        zzkr zzkrVar4 = this.zzQ;
        int i6 = this.zzM;
        boolean z17 = this.zzN;
        ?? r10 = 4;
        long j6 = 0;
        int i7 = -1;
        if (zzblVar.zzo()) {
            zzblVar2 = zzblVar;
            zzvhVar2 = zzls.zzi();
            z6 = false;
            z7 = false;
            z3 = true;
            j2 = -9223372036854775807L;
            j4 = -9223372036854775807L;
        } else {
            zzbj zzbjVar = this.zzm;
            zzvh zzvhVar4 = zzlsVar.zzb;
            Object obj6 = zzvhVar4.zza;
            boolean zzaz = zzaz(zzlsVar, zzbjVar);
            if (zzvhVar4.zzb() || zzaz) {
                obj = obj6;
                j = zzlsVar.zzc;
            } else {
                obj = obj6;
                j = zzlsVar.zzs;
            }
            long j7 = j;
            zzbk zzbkVar2 = this.zzl;
            if (zzkrVar4 != null) {
                zzvhVar = zzvhVar4;
                obj2 = obj;
                j2 = -9223372036854775807L;
                Pair zzG = zzG(zzblVar, zzkrVar4, true, i6, z17, zzbkVar2, zzbjVar);
                if (zzG == null) {
                    i4 = zzblVar.zzg(z17);
                    obj5 = obj2;
                    longValue = j7;
                    z10 = false;
                    z11 = true;
                    z9 = false;
                } else {
                    if (zzkrVar4.zzc == -9223372036854775807L) {
                        i4 = zzblVar.zzn(zzG.first, zzbjVar).zzc;
                        obj4 = obj2;
                        longValue = j7;
                        z8 = false;
                    } else {
                        Object obj7 = zzG.first;
                        longValue = ((Long) zzG.second).longValue();
                        obj4 = obj7;
                        i4 = -1;
                        z8 = true;
                    }
                    obj5 = obj4;
                    z9 = z8;
                    z10 = zzlsVar.zze == 4;
                    z11 = false;
                }
                j4 = longValue;
                i = i4;
                zzbkVar = zzbkVar2;
                obj3 = obj5;
                z4 = z9;
                z3 = z11;
                z2 = z10;
            } else {
                zzvhVar = zzvhVar4;
                zzbkVar = zzbkVar2;
                obj2 = obj;
                j2 = -9223372036854775807L;
                zzbl zzblVar4 = zzlsVar.zza;
                if (zzblVar4.zzo()) {
                    i2 = zzblVar.zzg(z17);
                } else if (zzblVar.zza(obj2) == -1) {
                    int zzd = zzd(zzbkVar, zzbjVar, i6, z17, obj2, zzblVar4, zzblVar);
                    zzbkVar = zzbkVar;
                    zzbjVar = zzbjVar;
                    obj2 = obj2;
                    if (zzd == -1) {
                        zzd = zzblVar.zzg(z17);
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    i = zzd;
                    z3 = z5;
                    obj3 = obj2;
                    j4 = j7;
                    z2 = false;
                    z4 = false;
                } else if (j7 == -9223372036854775807L) {
                    i2 = zzblVar.zzn(obj2, zzbjVar).zzc;
                } else if (zzaz) {
                    zzblVar4.zzn(obj2, zzbjVar);
                    if (zzblVar4.zze(zzbjVar.zzc, zzbkVar, 0L).zzn == zzblVar4.zza(obj2)) {
                        Pair zzl = zzblVar.zzl(zzbkVar, zzbjVar, zzblVar.zzn(obj2, zzbjVar).zzc, j7);
                        obj3 = zzl.first;
                        j3 = ((Long) zzl.second).longValue();
                    } else {
                        obj3 = obj2;
                        j3 = j7;
                    }
                    j4 = j3;
                    i = -1;
                    z2 = false;
                    z3 = false;
                    z4 = true;
                } else {
                    obj3 = obj2;
                    i = -1;
                    j4 = j7;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                }
                i = i2;
                obj3 = obj2;
                j4 = j7;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            if (i != -1) {
                zzblVar2 = zzblVar;
                Pair zzl2 = zzblVar2.zzl(zzbkVar, zzbjVar, i, -9223372036854775807L);
                obj3 = zzl2.first;
                j5 = ((Long) zzl2.second).longValue();
                j4 = j2;
            } else {
                zzblVar2 = zzblVar;
                j5 = j4;
            }
            zzvh zzq = this.zzr.zzq(zzblVar2, obj3, j5);
            int i8 = zzq.zze;
            boolean z18 = obj2.equals(obj3) && !zzvhVar.zzb() && !zzq.zzb() && (i8 == -1 || ((i3 = zzvhVar.zze) != -1 && i8 >= i3));
            zzbj zzn = zzblVar2.zzn(obj3, zzbjVar);
            if (!zzaz && j7 == j4 && obj2.equals(zzq.zza)) {
                if (zzvhVar.zzb()) {
                    zzn.zzk(zzvhVar.zzb);
                }
                if (zzq.zzb()) {
                    zzn.zzk(zzq.zzb);
                }
            }
            if (true == z18) {
                zzq = zzvhVar;
            }
            if (zzq.zzb()) {
                if (zzq.equals(zzvhVar)) {
                    j5 = zzlsVar.zzs;
                } else {
                    zzblVar2.zzn(zzq.zza, zzbjVar);
                    if (zzq.zzc == zzbjVar.zze(zzq.zzb)) {
                        zzbjVar.zzh();
                    }
                    j5 = 0;
                }
            }
            j6 = j5;
            zzvhVar2 = zzq;
            z6 = z2;
            z7 = z4;
        }
        boolean z19 = (this.zzE.zzb.equals(zzvhVar2) && j6 == this.zzE.zzs) ? false : true;
        if (z3) {
            try {
                z12 = true;
                if (this.zzE.zze != 1) {
                    try {
                        zzaj(4);
                    } catch (Throwable th) {
                        th = th;
                        zzvh zzvhVar5 = zzvhVar2;
                        zzblVar3 = zzblVar2;
                        zzvhVar3 = zzvhVar5;
                        zzkrVar = null;
                        i7 = 2;
                        z13 = z12;
                        zzls zzlsVar2 = this.zzE;
                        zzbl zzblVar5 = zzlsVar2.zza;
                        zzvh zzvhVar6 = zzlsVar2.zzb;
                        zzvh zzvhVar7 = zzvhVar3;
                        zzau(zzblVar3, zzvhVar7, zzblVar5, zzvhVar6, z13 == z7 ? j2 : j6, false);
                        if (z19) {
                        }
                        zzls zzlsVar3 = this.zzE;
                        Object obj8 = zzlsVar3.zzb.zza;
                        zzbl zzblVar6 = zzlsVar3.zza;
                        if (z19) {
                        }
                        zzkrVar2 = zzkrVar;
                        z14 = false;
                        zzkrVar3 = zzkrVar2;
                        this.zzE = zzH(zzvhVar7, j6, j4, this.zzE.zzd, z14, zzblVar3.zza(obj8) != -1 ? 4 : 3);
                        zzab();
                        zzad(zzblVar3, this.zzE.zza);
                        this.zzE = this.zzE.zzg(zzblVar3);
                        if (!zzblVar3.zzo()) {
                        }
                        zzP(false);
                        this.zzi.zzj(i7);
                        throw th;
                    }
                }
                zzaa(false, false, false, true);
            } catch (Throwable th2) {
                th = th2;
                z12 = true;
                zzvh zzvhVar52 = zzvhVar2;
                zzblVar3 = zzblVar2;
                zzvhVar3 = zzvhVar52;
                zzkrVar = null;
                i7 = 2;
                z13 = z12;
                zzls zzlsVar22 = this.zzE;
                zzbl zzblVar52 = zzlsVar22.zza;
                zzvh zzvhVar62 = zzlsVar22.zzb;
                zzvh zzvhVar72 = zzvhVar3;
                zzau(zzblVar3, zzvhVar72, zzblVar52, zzvhVar62, z13 == z7 ? j2 : j6, false);
                if (z19) {
                }
                zzls zzlsVar32 = this.zzE;
                Object obj82 = zzlsVar32.zzb.zza;
                zzbl zzblVar62 = zzlsVar32.zza;
                if (z19) {
                }
                zzkrVar2 = zzkrVar;
                z14 = false;
                zzkrVar3 = zzkrVar2;
                this.zzE = zzH(zzvhVar72, j6, j4, this.zzE.zzd, z14, zzblVar3.zza(obj82) != -1 ? 4 : 3);
                zzab();
                zzad(zzblVar3, this.zzE.zza);
                this.zzE = this.zzE.zzg(zzblVar3);
                if (!zzblVar3.zzo()) {
                }
                zzP(false);
                this.zzi.zzj(i7);
                throw th;
            }
        } else {
            z12 = true;
        }
        zzmf[] zzmfVarArr = this.zzb;
        for (int i9 = 0; i9 < 2; i9++) {
            zzmfVarArr[i9].zzw(zzblVar2);
        }
        try {
            if (z19) {
                i7 = 2;
                boolean z20 = z12;
                z16 = z20;
                if (!zzblVar2.zzo()) {
                    zzlf zzlfVar = this.zzr;
                    for (zzlc zzj = zzlfVar.zzj(); zzj != null; zzj = zzj.zzg()) {
                        if (zzj.zzg.zza.equals(zzvhVar2)) {
                            zzj.zzg = zzlfVar.zzp(zzblVar2, zzj.zzg);
                            zzj.zzr();
                        }
                    }
                    j6 = zzD(zzvhVar2, j6, z6);
                    z16 = z20;
                }
            } else {
                try {
                    zzlf zzlfVar2 = this.zzr;
                    long zzA2 = zzlfVar2.zzn() == null ? 0L : zzA(zzlfVar2.zzn());
                    try {
                        try {
                            if (zzaw()) {
                                try {
                                    if (zzlfVar2.zzm() != null) {
                                        zzA = zzA(zzlfVar2.zzm());
                                        i5 = 2;
                                        z15 = z12;
                                        i7 = i5;
                                        r10 = z15;
                                        zzb = zzlfVar2.zzb(zzblVar, this.zzR, zzA2, zzA);
                                        zzblVar2 = zzblVar;
                                        if ((zzb & 1) == 0) {
                                            zzaf(false);
                                            z16 = r10;
                                        } else {
                                            z16 = r10;
                                            if ((zzb & i7) != 0) {
                                                zzJ();
                                                z16 = r10;
                                            }
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    zzkrVar = null;
                                    i7 = 2;
                                    z13 = z12;
                                    zzvhVar3 = zzvhVar2;
                                    zzblVar3 = zzblVar;
                                    zzls zzlsVar222 = this.zzE;
                                    zzbl zzblVar522 = zzlsVar222.zza;
                                    zzvh zzvhVar622 = zzlsVar222.zzb;
                                    zzvh zzvhVar722 = zzvhVar3;
                                    zzau(zzblVar3, zzvhVar722, zzblVar522, zzvhVar622, z13 == z7 ? j2 : j6, false);
                                    if (z19) {
                                    }
                                    zzls zzlsVar322 = this.zzE;
                                    Object obj822 = zzlsVar322.zzb.zza;
                                    zzbl zzblVar622 = zzlsVar322.zza;
                                    if (z19) {
                                    }
                                    zzkrVar2 = zzkrVar;
                                    z14 = false;
                                    zzkrVar3 = zzkrVar2;
                                    this.zzE = zzH(zzvhVar722, j6, j4, this.zzE.zzd, z14, zzblVar3.zza(obj822) != -1 ? 4 : 3);
                                    zzab();
                                    zzad(zzblVar3, this.zzE.zza);
                                    this.zzE = this.zzE.zzg(zzblVar3);
                                    if (!zzblVar3.zzo()) {
                                    }
                                    zzP(false);
                                    this.zzi.zzj(i7);
                                    throw th;
                                }
                            }
                            zzb = zzlfVar2.zzb(zzblVar, this.zzR, zzA2, zzA);
                            zzblVar2 = zzblVar;
                            if ((zzb & 1) == 0) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            zzblVar2 = zzblVar;
                            zzvh zzvhVar8 = zzvhVar2;
                            zzblVar3 = zzblVar2;
                            zzvhVar3 = zzvhVar8;
                            zzkrVar = null;
                            z13 = r10;
                            zzls zzlsVar2222 = this.zzE;
                            zzbl zzblVar5222 = zzlsVar2222.zza;
                            zzvh zzvhVar6222 = zzlsVar2222.zzb;
                            zzvh zzvhVar7222 = zzvhVar3;
                            zzau(zzblVar3, zzvhVar7222, zzblVar5222, zzvhVar6222, z13 == z7 ? j2 : j6, false);
                            if (z19 && j4 == this.zzE.zzc) {
                                zzkrVar3 = zzkrVar;
                            } else {
                                zzls zzlsVar3222 = this.zzE;
                                Object obj8222 = zzlsVar3222.zzb.zza;
                                zzbl zzblVar6222 = zzlsVar3222.zza;
                                if (z19 || !z || zzblVar6222.zzo() || zzblVar6222.zzn(obj8222, this.zzm).zzf) {
                                    zzkrVar2 = zzkrVar;
                                    z14 = false;
                                } else {
                                    zzkrVar2 = zzkrVar;
                                    z14 = z13;
                                }
                                zzkrVar3 = zzkrVar2;
                                this.zzE = zzH(zzvhVar7222, j6, j4, this.zzE.zzd, z14, zzblVar3.zza(obj8222) != -1 ? 4 : 3);
                            }
                            zzab();
                            zzad(zzblVar3, this.zzE.zza);
                            this.zzE = this.zzE.zzg(zzblVar3);
                            if (!zzblVar3.zzo()) {
                                this.zzQ = zzkrVar3;
                            }
                            zzP(false);
                            this.zzi.zzj(i7);
                            throw th;
                        }
                        i7 = i5;
                        r10 = z15;
                    } catch (Throwable th5) {
                        th = th5;
                        zzblVar2 = zzblVar;
                        i7 = i5;
                        r10 = z15;
                    }
                    i5 = 2;
                    z15 = z12;
                    zzA = 0;
                } catch (Throwable th6) {
                    th = th6;
                    zzblVar2 = zzblVar;
                    i7 = 2;
                    r10 = z12;
                }
            }
            zzls zzlsVar4 = this.zzE;
            zzvh zzvhVar9 = zzvhVar2;
            zzau(zzblVar2, zzvhVar9, zzlsVar4.zza, zzlsVar4.zzb, z16 != z7 ? j2 : j6, false);
            zzbl zzblVar7 = zzblVar2;
            if (z19 || j4 != this.zzE.zzc) {
                zzls zzlsVar5 = this.zzE;
                Object obj9 = zzlsVar5.zzb.zza;
                zzbl zzblVar8 = zzlsVar5.zza;
                this.zzE = zzH(zzvhVar9, j6, j4, this.zzE.zzd, (!z19 || !z || zzblVar8.zzo() || zzblVar8.zzn(obj9, this.zzm).zzf) ? false : z16, zzblVar7.zza(obj9) == -1 ? 4 : 3);
            }
            zzab();
            zzad(zzblVar7, this.zzE.zza);
            this.zzE = this.zzE.zzg(zzblVar7);
            if (!zzblVar7.zzo()) {
                this.zzQ = null;
            }
            zzP(false);
            this.zzi.zzj(i7);
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private final void zzR(zzbb zzbbVar, boolean z) throws zzin {
        zzS(zzbbVar, zzbbVar.zzb, true, z);
    }

    private final void zzS(zzbb zzbbVar, float f, boolean z, boolean z2) throws zzin {
        int i;
        if (z) {
            if (z2) {
                this.zzF.zza(1);
            }
            zzls zzlsVar = this.zzE;
            zzbl zzblVar = zzlsVar.zza;
            zzvh zzvhVar = zzlsVar.zzb;
            long j = zzlsVar.zzc;
            long j2 = zzlsVar.zzd;
            int i2 = zzlsVar.zze;
            zzin zzinVar = zzlsVar.zzf;
            boolean z3 = zzlsVar.zzg;
            zzxk zzxkVar = zzlsVar.zzh;
            zzze zzzeVar = zzlsVar.zzi;
            List list = zzlsVar.zzj;
            zzvh zzvhVar2 = zzlsVar.zzk;
            boolean z4 = zzlsVar.zzl;
            int i3 = zzlsVar.zzm;
            int i4 = zzlsVar.zzn;
            long j3 = zzlsVar.zzq;
            long j4 = zzlsVar.zzr;
            long j5 = zzlsVar.zzs;
            long j6 = zzlsVar.zzt;
            boolean z5 = zzlsVar.zzp;
            this.zzE = new zzls(zzblVar, zzvhVar, j, j2, i2, zzinVar, z3, zzxkVar, zzzeVar, list, zzvhVar2, z4, i3, i4, zzbbVar, j3, j4, j5, j6, false);
        }
        float f2 = zzbbVar.zzb;
        zzlc zzj = this.zzr.zzj();
        while (true) {
            i = 0;
            if (zzj == null) {
                break;
            }
            zzyw[] zzywVarArr = zzj.zzi().zzc;
            int length = zzywVarArr.length;
            while (i < length) {
                zzyw zzywVar = zzywVarArr[i];
                i++;
            }
            zzj = zzj.zzg();
        }
        zzmf[] zzmfVarArr = this.zzb;
        while (i < 2) {
            zzmfVarArr[i].zzu(f, f2);
            i++;
        }
    }

    private final void zzT() {
        long zze;
        long j;
        zzlf zzlfVar = this.zzr;
        boolean z = false;
        if (zzaC(zzlfVar.zzi())) {
            zzlc zzi = zzlfVar.zzi();
            long zzC = zzC(zzi.zzd());
            if (zzi == zzlfVar.zzj()) {
                zze = this.zzR;
                j = zzi.zze();
            } else {
                zze = this.zzR - zzi.zze();
                j = zzi.zzg.zzb;
            }
            zzkw zzkwVar = new zzkw(this.zzu, this.zzE.zza, zzi.zzg.zza, zze - j, zzC, this.zzo.zzc().zzb, this.zzE.zzl, this.zzJ, zzaB(this.zzE.zza, zzi.zzg.zza) ? this.zzac.zzb() : -9223372036854775807L, this.zzK);
            zzkx zzkxVar = this.zzg;
            boolean zzh = zzkxVar.zzh(zzkwVar);
            zzlc zzj = zzlfVar.zzj();
            if (zzh || !zzj.zze || zzC >= 500000 || this.zzn <= 0) {
                z = zzh;
            } else {
                zzj.zza.zzh(this.zzE.zzs, false);
                z = zzkxVar.zzh(zzkwVar);
            }
        }
        this.zzL = z;
        if (z) {
            zzlc zzi2 = zzlfVar.zzi();
            zzi2.getClass();
            zzky zzkyVar = new zzky();
            zzkyVar.zze(this.zzR - zzi2.zze());
            zzkyVar.zzf(this.zzo.zzc().zzb);
            zzkyVar.zzd(this.zzK);
            zzi2.zzk(new zzla(zzkyVar, null));
        }
        zzao();
    }

    private final void zzU() {
        zzlf zzlfVar = this.zzr;
        zzlfVar.zzt();
        zzlc zzl = zzlfVar.zzl();
        if (zzl != null) {
            if (!zzl.zzd || zzl.zze) {
                zzvf zzvfVar = zzl.zza;
                if (zzvfVar.zzp()) {
                    return;
                }
                if (this.zzg.zzi(this.zzE.zza, zzl.zzg.zza, zzl.zze ? zzvfVar.zzb() : 0L)) {
                    if (!zzl.zzd) {
                        zzl.zzm(this, zzl.zzg.zzb);
                        return;
                    }
                    zzky zzkyVar = new zzky();
                    zzkyVar.zze(this.zzR - zzl.zze());
                    zzkyVar.zzf(this.zzo.zzc().zzb);
                    zzkyVar.zzd(this.zzK);
                    zzl.zzk(new zzla(zzkyVar, null));
                }
            }
        }
    }

    private final void zzV() {
        boolean z;
        this.zzF.zzb(this.zzE);
        z = this.zzF.zze;
        if (z) {
            zzjj zzjjVar = this.zzab;
            zzjjVar.zza.zzab(this.zzF);
            this.zzF = new zzkq(this.zzE);
        }
    }

    private final void zzW(int i) throws IOException, zzin {
        zzmf zzmfVar = this.zzb[i];
        try {
            zzlc zzj = this.zzr.zzj();
            if (zzj == null) {
                throw null;
            }
            zzlc zzlcVar = zzj;
            zzmfVar.zzn(zzj);
        } catch (IOException | RuntimeException e) {
            zzmfVar.zzb();
            throw e;
        }
    }

    private final void zzX(final int i, final boolean z) {
        boolean[] zArr = this.zzd;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.zzw.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzki
                @Override // java.lang.Runnable
                public final void run() {
                    r0.zzv.zzJ(r1, zzkt.this.zzb[i].zzb(), z);
                }
            });
        }
    }

    private final void zzY() throws zzin {
        zzkt zzktVar;
        int i;
        boolean z;
        zzil zzilVar = this.zzo;
        float f = zzilVar.zzc().zzb;
        zzlf zzlfVar = this.zzr;
        zzlc zzj = zzlfVar.zzj();
        zzlc zzn = zzlfVar.zzn();
        zzze zzzeVar = null;
        boolean z2 = true;
        while (zzj != null && zzj.zze) {
            zzls zzlsVar = this.zzE;
            zzze zzj2 = zzj.zzj(f, zzlsVar.zza, zzlsVar.zzl);
            zzze zzzeVar2 = zzj == zzlfVar.zzj() ? zzj2 : zzzeVar;
            zzze zzi = zzj.zzi();
            boolean z3 = false;
            if (zzi != null) {
                zzyw[] zzywVarArr = zzj2.zzc;
                if (zzi.zzc.length == zzywVarArr.length) {
                    for (int i2 = 0; i2 < zzywVarArr.length; i2++) {
                        if (zzj2.zza(zzi, i2)) {
                        }
                    }
                    if (zzj != zzn) {
                        z3 = true;
                    }
                    z2 &= z3;
                    zzj = zzj.zzg();
                    zzzeVar = zzzeVar2;
                }
            }
            if (z2) {
                zzlc zzj3 = zzlfVar.zzj();
                int zza2 = zzlfVar.zza(zzj3) & 1;
                zzmf[] zzmfVarArr = this.zzb;
                boolean[] zArr = new boolean[2];
                zzzeVar2.getClass();
                long zzb = zzj3.zzb(zzzeVar2, this.zzE.zzs, 1 == zza2, zArr);
                zzls zzlsVar2 = this.zzE;
                if (zzlsVar2.zze == 4 || zzb == zzlsVar2.zzs) {
                    z = false;
                } else {
                    z = false;
                    z3 = true;
                }
                zzls zzlsVar3 = this.zzE;
                boolean z4 = z;
                i = 2;
                zzktVar = this;
                zzktVar.zzE = zzH(zzlsVar3.zzb, zzb, zzlsVar3.zzc, zzlsVar3.zzd, z3, 5);
                if (z3) {
                    zzktVar.zzac(zzb);
                }
                zzktVar.zzJ();
                boolean[] zArr2 = new boolean[2];
                for (int i3 = z4; i3 < 2; i3++) {
                    int zza3 = zzmfVarArr[i3].zza();
                    zArr2[i3] = zzmfVarArr[i3].zzL();
                    zzmfVarArr[i3].zzk(zzj3.zzc[i3], zzilVar, zzktVar.zzR, zArr[i3]);
                    if (zza3 - zzmfVarArr[i3].zza() > 0) {
                        zzktVar.zzX(i3, z4);
                    }
                    zzktVar.zzP -= zza3 - zzmfVarArr[i3].zza();
                }
                zzktVar.zzN(zArr2, zzktVar.zzR);
                zzj3.zzh = true;
            } else {
                zzktVar = this;
                i = 2;
                zzlfVar.zza(zzj);
                if (zzj.zze) {
                    long max = Math.max(zzj.zzg.zzb, zzktVar.zzR - zzj.zze());
                    if (zzktVar.zzx && zzktVar.zzaw() && zzlfVar.zzm() == zzj) {
                        zzktVar.zzJ();
                    }
                    zzj.zza(zzj2, max, false);
                }
            }
            zzktVar.zzP(true);
            if (zzktVar.zzE.zze != 4) {
                zzktVar.zzT();
                zzktVar.zzat();
                zzktVar.zzi.zzj(i);
                return;
            }
            return;
        }
    }

    private final void zzZ() throws zzin {
        zzY();
        zzaf(true);
    }

    private final boolean zzaA() {
        zzls zzlsVar = this.zzE;
        return zzlsVar.zzl && zzlsVar.zzn == 0;
    }

    private final boolean zzaB(zzbl zzblVar, zzvh zzvhVar) {
        if (!zzvhVar.zzb() && !zzblVar.zzo()) {
            int i = zzblVar.zzn(zzvhVar.zza, this.zzm).zzc;
            zzbk zzbkVar = this.zzl;
            zzblVar.zze(i, zzbkVar, 0L);
            if (zzbkVar.zzb() && zzbkVar.zzi && zzbkVar.zzf != -9223372036854775807L) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzaC(zzlc zzlcVar) {
        if (zzlcVar != null) {
            try {
                if (zzlcVar.zze) {
                    zzwz[] zzwzVarArr = zzlcVar.zzc;
                    for (int i = 0; i < 2; i++) {
                        zzwz zzwzVar = zzwzVarArr[i];
                        if (zzwzVar != null) {
                            zzwzVar.zzd();
                        }
                    }
                } else {
                    zzlcVar.zza.zzi();
                }
                if (zzlcVar.zzd() != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private static final void zzaD(zzlw zzlwVar) throws zzin {
        zzlwVar.zzi();
        try {
            zzlwVar.zzc().zzv(zzlwVar.zza(), zzlwVar.zzg());
        } finally {
            zzlwVar.zzh(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        if (r2.equals(r34.zzE.zzb) == false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzaa(boolean z, boolean z2, boolean z3, boolean z4) {
        zzvh zzvhVar;
        zzbl zzblVar;
        this.zzi.zzg(2);
        this.zzC = false;
        this.zzD = null;
        this.zzV = null;
        boolean z5 = true;
        zzav(false, true);
        this.zzo.zzi();
        this.zzR = 1000000000000L;
        try {
            zzK();
        } catch (zzin | RuntimeException e) {
            zzea.zzd("ExoPlayerImplInternal", "Disable failed.", e);
        }
        if (z) {
            zzmf[] zzmfVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                try {
                    zzmfVarArr[i].zzq();
                } catch (RuntimeException e2) {
                    zzea.zzd("ExoPlayerImplInternal", "Reset failed.", e2);
                }
            }
        }
        this.zzP = 0;
        zzls zzlsVar = this.zzE;
        zzvh zzvhVar2 = zzlsVar.zzb;
        long j = zzlsVar.zzs;
        long j2 = (this.zzE.zzb.zzb() || zzaz(this.zzE, this.zzm)) ? this.zzE.zzc : this.zzE.zzs;
        if (z2) {
            this.zzQ = null;
            Pair zzF = zzF(this.zzE.zza);
            zzvhVar2 = (zzvh) zzF.first;
            j = ((Long) zzF.second).longValue();
            j2 = -9223372036854775807L;
        }
        z5 = false;
        long j3 = j;
        long j4 = j2;
        zzlf zzlfVar = this.zzr;
        zzlfVar.zzs();
        this.zzL = false;
        zzbl zzblVar2 = this.zzE.zza;
        if (z3 && (zzblVar2 instanceof zzly)) {
            zzblVar2 = ((zzly) zzblVar2).zzx(this.zzs.zzq());
            if (zzvhVar2.zzb != -1) {
                Object obj = zzvhVar2.zza;
                zzbj zzbjVar = this.zzm;
                zzblVar2.zzn(obj, zzbjVar);
                zzbk zzbkVar = this.zzl;
                zzblVar2.zze(zzbjVar.zzc, zzbkVar, 0L);
                if (zzbkVar.zzb()) {
                    zzblVar = zzblVar2;
                    zzvhVar = new zzvh(obj, zzvhVar2.zzd);
                    zzls zzlsVar2 = this.zzE;
                    int i2 = zzlsVar2.zze;
                    zzin zzinVar = z4 ? null : zzlsVar2.zzf;
                    zzxk zzxkVar = !z5 ? zzxk.zza : zzlsVar2.zzh;
                    zzze zzzeVar = !z5 ? this.zzf : this.zzE.zzi;
                    List zzn = !z5 ? zzfyq.zzn() : this.zzE.zzj;
                    zzls zzlsVar3 = this.zzE;
                    this.zzE = new zzls(zzblVar, zzvhVar, j4, j3, i2, zzinVar, false, zzxkVar, zzzeVar, zzn, zzvhVar, zzlsVar3.zzl, zzlsVar3.zzm, zzlsVar3.zzn, zzlsVar3.zzo, j3, 0L, j3, 0L, false);
                    if (z3) {
                        return;
                    }
                    zzlfVar.zzv();
                    this.zzs.zzh();
                    return;
                }
            }
        }
        zzvhVar = zzvhVar2;
        zzblVar = zzblVar2;
        zzls zzlsVar22 = this.zzE;
        int i22 = zzlsVar22.zze;
        zzin zzinVar2 = z4 ? null : zzlsVar22.zzf;
        zzxk zzxkVar2 = !z5 ? zzxk.zza : zzlsVar22.zzh;
        zzze zzzeVar2 = !z5 ? this.zzf : this.zzE.zzi;
        List zzn2 = !z5 ? zzfyq.zzn() : this.zzE.zzj;
        zzls zzlsVar32 = this.zzE;
        this.zzE = new zzls(zzblVar, zzvhVar, j4, j3, i22, zzinVar2, false, zzxkVar2, zzzeVar2, zzn2, zzvhVar, zzlsVar32.zzl, zzlsVar32.zzm, zzlsVar32.zzn, zzlsVar32.zzo, j3, 0L, j3, 0L, false);
        if (z3) {
        }
    }

    private final void zzab() {
        zzlc zzj = this.zzr.zzj();
        boolean z = false;
        if (zzj != null && zzj.zzg.zzi && this.zzH) {
            z = true;
        }
        this.zzI = z;
    }

    private final void zzac(long j) throws zzin {
        zzlc zzj = this.zzr.zzj();
        long zze = j + (zzj == null ? 1000000000000L : zzj.zze());
        this.zzR = zze;
        this.zzo.zzf(zze);
        zzmf[] zzmfVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            zzmfVarArr[i].zzr(zzj, this.zzR);
        }
        for (zzlc zzj2 = r0.zzj(); zzj2 != null; zzj2 = zzj2.zzg()) {
            for (zzyw zzywVar : zzj2.zzi().zzc) {
            }
        }
    }

    private final void zzad(zzbl zzblVar, zzbl zzblVar2) {
        if (zzblVar.zzo() && zzblVar2.zzo()) {
            return;
        }
        ArrayList arrayList = this.zzp;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
            return;
        }
        zzkp zzkpVar = (zzkp) arrayList.get(size);
        Object obj = zzkpVar.zzb;
        zzlw zzlwVar = zzkpVar.zza;
        String str = zzex.zza;
        throw null;
    }

    private final void zzae(long j) {
        if (zzax()) {
            r2 = this.zzE.zze != 3 ? zza : 1000L;
            if (zzaA()) {
                zzmf[] zzmfVarArr = this.zzb;
                for (int i = 0; i < 2; i++) {
                    r2 = Math.min(r2, zzex.zzv(zzmfVarArr[i].zzd(this.zzR, this.zzS)));
                }
                zzlf zzlfVar = this.zzr;
                if ((zzlfVar.zzj() != null ? zzlfVar.zzj().zzg() : null) != null) {
                    if (this.zzR + (zzex.zzs(r2) * this.zzE.zzo.zzb) >= r0.zzf()) {
                        r2 = Math.min(r2, zza);
                    }
                }
            }
        } else if (this.zzE.zze != 3 || zzaA()) {
            r2 = zza;
        }
        this.zzi.zzk(2, j + r2);
    }

    private final void zzaf(boolean z) throws zzin {
        zzvh zzvhVar = this.zzr.zzj().zzg.zza;
        long zzE = zzE(zzvhVar, this.zzE.zzs, true, false);
        if (zzE != this.zzE.zzs) {
            zzls zzlsVar = this.zzE;
            this.zzE = zzH(zzvhVar, zzE, zzlsVar.zzc, zzlsVar.zzd, z, 5);
        }
    }

    private final void zzag(zzkr zzkrVar, boolean z) throws zzin {
        long longValue;
        long j;
        long j2;
        zzvh zzq;
        boolean z2;
        zzvh zzvhVar;
        long j3;
        boolean z3;
        long j4;
        long j5;
        zzvh zzvhVar2;
        long j6;
        long j7;
        boolean z4;
        zzls zzlsVar;
        int i;
        this.zzF.zza(z ? 1 : 0);
        if (this.zzC) {
            this.zzD = zzkrVar;
            return;
        }
        zzbl zzblVar = this.zzE.zza;
        int i2 = this.zzM;
        boolean z5 = this.zzN;
        zzbk zzbkVar = this.zzl;
        zzbj zzbjVar = this.zzm;
        Pair zzG = zzG(zzblVar, zzkrVar, true, i2, z5, zzbkVar, zzbjVar);
        if (zzG == null) {
            Pair zzF = zzF(this.zzE.zza);
            zzq = (zzvh) zzF.first;
            longValue = ((Long) zzF.second).longValue();
            z2 = !this.zzE.zza.zzo();
            j = -9223372036854775807L;
            j2 = 0;
        } else {
            Object obj = zzG.first;
            longValue = ((Long) zzG.second).longValue();
            long j8 = zzkrVar.zzc;
            j = j8 == -9223372036854775807L ? -9223372036854775807L : longValue;
            j2 = 0;
            zzq = this.zzr.zzq(this.zzE.zza, obj, longValue);
            if (zzq.zzb()) {
                this.zzE.zza.zzn(zzq.zza, zzbjVar);
                if (zzbjVar.zze(zzq.zzb) == zzq.zzc) {
                    zzbjVar.zzh();
                }
                z2 = true;
                longValue = 0;
            } else {
                z2 = j8 == -9223372036854775807L;
            }
        }
        try {
            if (this.zzE.zza.zzo()) {
                this.zzQ = zzkrVar;
            } else if (zzG == null) {
                if (this.zzE.zze != 1) {
                    zzaj(4);
                }
                zzaa(false, true, false, true);
            } else {
                if (zzq.equals(this.zzE.zzb)) {
                    zzlc zzj = this.zzr.zzj();
                    if (zzj == null || !zzj.zze || longValue == j2) {
                        j5 = longValue;
                    } else {
                        zzvf zzvfVar = zzj.zza;
                        long j9 = zzbkVar.zzm;
                        if (this.zzB && j9 != -9223372036854775807L) {
                            Double d = this.zzA.zzc;
                        }
                        j5 = zzvfVar.zza(longValue, this.zzz);
                    }
                    if (zzex.zzv(j5) == zzex.zzv(this.zzE.zzs) && ((i = (zzlsVar = this.zzE).zze) == 2 || i == 3)) {
                        longValue = zzlsVar.zzs;
                    }
                } else {
                    j5 = longValue;
                }
                this.zzC = this.zzB;
                long zzD = zzD(zzq, j5, this.zzE.zze == 4);
                boolean z6 = z2 | (longValue != zzD);
                try {
                    zzls zzlsVar2 = this.zzE;
                    zzbl zzblVar2 = zzlsVar2.zza;
                    zzvh zzvhVar3 = zzq;
                    long j10 = j;
                    try {
                        zzau(zzblVar2, zzvhVar3, zzblVar2, zzlsVar2.zzb, j10, true);
                        zzvhVar2 = zzvhVar3;
                        j6 = j10;
                        j7 = zzD;
                        z4 = z6;
                        this.zzE = zzH(zzvhVar2, j7, j6, j7, z4, 2);
                    } catch (Throwable th) {
                        th = th;
                        zzvhVar = zzvhVar3;
                        j3 = j10;
                        j4 = zzD;
                        z3 = z6;
                        this.zzE = zzH(zzvhVar, j4, j3, j4, z3, 2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zzvhVar = zzq;
                    j3 = j;
                }
            }
            z4 = z2;
            zzvhVar2 = zzq;
            j7 = longValue;
            j6 = j;
            this.zzE = zzH(zzvhVar2, j7, j6, j7, z4, 2);
        } catch (Throwable th3) {
            th = th3;
            zzvhVar = zzq;
            j3 = j;
            z3 = z2;
            j4 = longValue;
        }
    }

    private final void zzah(zzbb zzbbVar) {
        this.zzi.zzg(16);
        this.zzo.zzg(zzbbVar);
    }

    private final void zzai(boolean z, int i, boolean z2, int i2) throws zzin {
        this.zzF.zza(z2 ? 1 : 0);
        zzar(z, i, i2);
    }

    private final void zzaj(int i) {
        zzls zzlsVar = this.zzE;
        if (zzlsVar.zze != i) {
            if (i != 2) {
                this.zzW = -9223372036854775807L;
            }
            if (i != 3) {
                boolean z = zzlsVar.zzp;
            }
            this.zzE = this.zzE.zzf(i);
        }
    }

    private final void zzak(float f) throws zzin {
        this.zzaa = f;
        float zza2 = f * this.zzy.zza();
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzmfVarArr[i].zzz(zza2);
            i++;
        }
    }

    private final void zzal() throws zzin {
        zzlc zzj = this.zzr.zzj();
        if (zzj == null) {
            return;
        }
        zzze zzi = zzj.zzi();
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            if (zzi.zzb(i)) {
                zzmfVarArr[i].zzA();
            }
            i++;
        }
    }

    private final void zzam(boolean z, boolean z2) {
        zzaa(z || !this.zzO, false, true, false);
        this.zzF.zza(z2 ? 1 : 0);
        this.zzg.zze(this.zzu);
        this.zzy.zzb(this.zzE.zzl, 1);
        zzaj(1);
    }

    private final void zzan() throws zzin {
        this.zzo.zzi();
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzmfVarArr[i].zzC();
            i++;
        }
    }

    private final void zzao() {
        zzlc zzi = this.zzr.zzi();
        boolean z = true;
        if (!this.zzL && (zzi == null || !zzi.zza.zzp())) {
            z = false;
        }
        zzls zzlsVar = this.zzE;
        if (z != zzlsVar.zzg) {
            this.zzE = zzlsVar.zza(z);
        }
    }

    private final void zzap(zzvh zzvhVar, zzxk zzxkVar, zzze zzzeVar) {
        long zze;
        long j;
        zzlf zzlfVar = this.zzr;
        zzlc zzi = zzlfVar.zzi();
        zzi.getClass();
        if (zzi == zzlfVar.zzj()) {
            zze = this.zzR;
            j = zzi.zze();
        } else {
            zze = this.zzR - zzi.zze();
            j = zzi.zzg.zzb;
        }
        this.zzg.zzf(new zzkw(this.zzu, this.zzE.zza, zzvhVar, zze - j, zzC(zzi.zzc()), this.zzo.zzc().zzb, this.zzE.zzl, this.zzJ, zzaB(this.zzE.zza, zzi.zzg.zza) ? this.zzac.zzb() : -9223372036854775807L, this.zzK), zzxkVar, zzzeVar.zzc);
    }

    private final void zzaq() throws zzin {
        zzls zzlsVar = this.zzE;
        zzar(zzlsVar.zzl, zzlsVar.zzn, zzlsVar.zzm);
    }

    private final void zzar(boolean z, int i, int i2) throws zzin {
        zzas(z, this.zzy.zzb(z, this.zzE.zze), i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzas(boolean z, int i, int i2, int i3) throws zzin {
        boolean z2;
        zzls zzlsVar;
        zzlc zzj;
        if (z) {
            if (i != -1) {
                z2 = true;
                if (i != -1) {
                    i3 = 2;
                } else if (i3 == 2) {
                    i3 = 1;
                }
                if (i != 0) {
                    i2 = 1;
                } else if (i2 == 1) {
                    i2 = 0;
                }
                zzlsVar = this.zzE;
                if (zzlsVar.zzl != z2 && zzlsVar.zzn == i2 && zzlsVar.zzm == i3) {
                    return;
                }
                this.zzE = zzlsVar.zzd(z2, i3, i2);
                zzav(false, false);
                zzlf zzlfVar = this.zzr;
                for (zzj = zzlfVar.zzj(); zzj != null; zzj = zzj.zzg()) {
                    for (zzyw zzywVar : zzj.zzi().zzc) {
                    }
                }
                if (zzaA()) {
                    zzan();
                    zzat();
                    boolean z3 = this.zzE.zzp;
                    zzlfVar.zzu(this.zzR);
                    return;
                }
                int i4 = this.zzE.zze;
                if (i4 == 3) {
                    this.zzo.zzh();
                    zzal();
                    this.zzi.zzj(2);
                    return;
                } else {
                    if (i4 == 2) {
                        this.zzi.zzj(2);
                        return;
                    }
                    return;
                }
            }
            i = -1;
        }
        z2 = false;
        if (i != -1) {
        }
        if (i != 0) {
        }
        zzlsVar = this.zzE;
        if (zzlsVar.zzl != z2) {
        }
        this.zzE = zzlsVar.zzd(z2, i3, i2);
        zzav(false, false);
        zzlf zzlfVar2 = this.zzr;
        while (zzj != null) {
        }
        if (zzaA()) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00a9, code lost:
    
        r13 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzat() throws zzin {
        zzkp zzkpVar;
        zzlf zzlfVar = this.zzr;
        zzlc zzj = zzlfVar.zzj();
        if (zzj == null) {
            return;
        }
        long zzd = zzj.zze ? zzj.zza.zzd() : -9223372036854775807L;
        if (zzd != -9223372036854775807L) {
            if (!zzj.zzs()) {
                zzlfVar.zza(zzj);
                zzP(false);
                zzT();
            }
            zzac(zzd);
            if (zzd != this.zzE.zzs) {
                zzls zzlsVar = this.zzE;
                long j = zzd;
                this.zzE = zzH(zzlsVar.zzb, j, zzlsVar.zzc, j, true, 5);
            }
        } else {
            zzil zzilVar = this.zzo;
            long zzb = zzilVar.zzb(zzj != zzlfVar.zzn());
            this.zzR = zzb;
            long zze = zzb - zzj.zze();
            long j2 = this.zzE.zzs;
            ArrayList arrayList = this.zzp;
            if (!arrayList.isEmpty() && !this.zzE.zzb.zzb()) {
                if (this.zzU) {
                    j2--;
                    this.zzU = false;
                }
                zzls zzlsVar2 = this.zzE;
                int zza2 = zzlsVar2.zza.zza(zzlsVar2.zzb.zza);
                int min = Math.min(this.zzT, arrayList.size());
                if (min > 0) {
                    zzkpVar = (zzkp) arrayList.get(min - 1);
                    while (zzkpVar != null && (zza2 < 0 || (zza2 == 0 && j2 < 0))) {
                        int i = min - 1;
                        if (i > 0) {
                            zzkpVar = (zzkp) arrayList.get(min - 2);
                            min = i;
                        } else {
                            min = i;
                        }
                    }
                    if (min < arrayList.size()) {
                    }
                    this.zzT = min;
                }
                zzkpVar = null;
            }
            if (zzilVar.zzj()) {
                boolean z = !this.zzF.zzc;
                zzls zzlsVar3 = this.zzE;
                this.zzE = zzH(zzlsVar3.zzb, zze, zzlsVar3.zzc, zze, z, 6);
            } else {
                zzls zzlsVar4 = this.zzE;
                zzlsVar4.zzs = zze;
                zzlsVar4.zzt = SystemClock.elapsedRealtime();
            }
        }
        this.zzE.zzq = zzlfVar.zzi().zzc();
        this.zzE.zzr = zzB();
        zzls zzlsVar5 = this.zzE;
        if (zzlsVar5.zzl && zzlsVar5.zze == 3 && zzaB(zzlsVar5.zza, zzlsVar5.zzb)) {
            zzls zzlsVar6 = this.zzE;
            if (zzlsVar6.zzo.zzb == 1.0f) {
                float zza3 = this.zzac.zza(zzz(zzlsVar6.zza, zzlsVar6.zzb.zza, zzlsVar6.zzs), this.zzE.zzr);
                zzil zzilVar2 = this.zzo;
                if (zzilVar2.zzc().zzb != zza3) {
                    zzah(new zzbb(zza3, this.zzE.zzo.zzc));
                    zzS(this.zzE.zzo, zzilVar2.zzc().zzb, false, false);
                }
            }
        }
    }

    private final void zzau(zzbl zzblVar, zzvh zzvhVar, zzbl zzblVar2, zzvh zzvhVar2, long j, boolean z) throws zzin {
        if (!zzaB(zzblVar, zzvhVar)) {
            zzbb zzbbVar = zzvhVar.zzb() ? zzbb.zza : this.zzE.zzo;
            if (this.zzo.zzc().equals(zzbbVar)) {
                return;
            }
            zzah(zzbbVar);
            zzS(this.zzE.zzo, zzbbVar.zzb, false, false);
            return;
        }
        Object obj = zzvhVar.zza;
        zzbj zzbjVar = this.zzm;
        int i = zzblVar.zzn(obj, zzbjVar).zzc;
        zzbk zzbkVar = this.zzl;
        zzblVar.zze(i, zzbkVar, 0L);
        zzig zzigVar = this.zzac;
        zzaj zzajVar = zzbkVar.zzj;
        String str = zzex.zza;
        zzigVar.zzd(zzajVar);
        if (j != -9223372036854775807L) {
            zzigVar.zze(zzz(zzblVar, obj, j));
            return;
        }
        if (!Objects.equals(!zzblVar2.zzo() ? zzblVar2.zze(zzblVar2.zzn(zzvhVar2.zza, zzbjVar).zzc, zzbkVar, 0L).zzb : null, zzbkVar.zzb) || z) {
            zzigVar.zze(-9223372036854775807L);
        }
    }

    private final void zzav(boolean z, boolean z2) {
        this.zzJ = z;
        long j = -9223372036854775807L;
        if (z && !z2) {
            j = SystemClock.elapsedRealtime();
        }
        this.zzK = j;
    }

    private final boolean zzaw() {
        if (!this.zzx) {
            return false;
        }
        zzmf[] zzmfVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            if (zzmfVarArr[i].zzI()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzax() {
        if (!this.zzB) {
            return false;
        }
        boolean z = this.zzA.zzg;
        return true;
    }

    private final boolean zzay() {
        zzlc zzj = this.zzr.zzj();
        long j = zzj.zzg.zze;
        if (zzj.zze) {
            return j == -9223372036854775807L || this.zzE.zzs < j || !zzaA();
        }
        return false;
    }

    private static boolean zzaz(zzls zzlsVar, zzbj zzbjVar) {
        zzvh zzvhVar = zzlsVar.zzb;
        zzbl zzblVar = zzlsVar.zza;
        return zzblVar.zzo() || zzblVar.zzn(zzvhVar.zza, zzbjVar).zzf;
    }

    static int zzd(zzbk zzbkVar, zzbj zzbjVar, int i, boolean z, Object obj, zzbl zzblVar, zzbl zzblVar2) {
        zzbk zzbkVar2 = zzbkVar;
        zzbl zzblVar3 = zzblVar;
        Object obj2 = zzblVar3.zze(zzblVar3.zzn(obj, zzbjVar).zzc, zzbkVar, 0L).zzb;
        for (int i2 = 0; i2 < zzblVar2.zzc(); i2++) {
            if (zzblVar2.zze(i2, zzbkVar, 0L).zzb.equals(obj2)) {
                return i2;
            }
        }
        int zza2 = zzblVar3.zza(obj);
        int zzb = zzblVar3.zzb();
        int i3 = -1;
        int i4 = 0;
        while (true) {
            if (i4 >= zzb || i3 != -1) {
                break;
            }
            zzbl zzblVar4 = zzblVar3;
            int zzi = zzblVar4.zzi(zza2, zzbjVar, zzbkVar2, i, z);
            if (zzi == -1) {
                i3 = -1;
                break;
            }
            i3 = zzblVar2.zza(zzblVar4.zzf(zzi));
            i4++;
            zzblVar3 = zzblVar4;
            zza2 = zzi;
            zzbkVar2 = zzbkVar;
        }
        if (i3 == -1) {
            return -1;
        }
        return zzblVar2.zzd(i3, zzbjVar, false).zzc;
    }

    public static /* synthetic */ zzlc zzg(zzkt zzktVar, zzld zzldVar, long j) {
        zzzm zzk = zzktVar.zzg.zzk();
        long j2 = zzktVar.zzX.zzb;
        zzze zzzeVar = zzktVar.zzf;
        zzlr zzlrVar = zzktVar.zzs;
        return new zzlc(zzktVar.zzc, j, zzktVar.zze, zzk, zzlrVar, zzldVar, zzzeVar, -9223372036854775807L);
    }

    public static /* synthetic */ void zzh(zzkt zzktVar, zzlw zzlwVar) {
        try {
            zzaD(zzlwVar);
        } catch (zzin e) {
            zzea.zzd("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private final long zzz(zzbl zzblVar, Object obj, long j) {
        int i = zzblVar.zzn(obj, this.zzm).zzc;
        zzbk zzbkVar = this.zzl;
        zzblVar.zze(i, zzbkVar, 0L);
        if (zzbkVar.zzf == -9223372036854775807L || !zzbkVar.zzb() || !zzbkVar.zzi) {
            return -9223372036854775807L;
        }
        long j2 = zzbkVar.zzg;
        String str = zzex.zza;
        return zzex.zzs((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - zzbkVar.zzf) - j;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:144|145|146|147|(3:364|365|(1:367)(22:368|(1:645)(5:372|(2:374|375)(2:641|(1:643))|376|(1:378)|379)|380|(1:382)(1:640)|383|(1:639)(2:399|(2:401|(2:402|(3:404|(2:413|414)(2:410|411)|412)(18:415|416|(2:418|(1:420))|421|(16:511|(3:536|537|(1:539)(13:540|(2:542|(2:543|(2:545|(1:547)(1:548))(3:549|550|(8:559|560|561|(8:567|(3:571|(3:573|(2:575|(2:579|580))(1:584)|582)|585)|586|(1:588)|589|590|(1:592)|593)|596|(1:598)|599|593))))(1:601)|424|(2:431|(2:432|(1:434)(2:435|(4:437|(3:439|(2:443|444)|445)|448|449))))|450|(4:(1:464)|465|(10:467|(2:469|(2:471|(8:475|476|(3:480|(1:482)|483)|484|(1:486)|487|(2:488|(3:490|(2:492|493)(1:495)|494))|497)))(1:499)|498|476|(4:478|480|(0)|483)|484|(0)|487|(3:488|(1:1)(0)|494)|497)(3:500|501|502)|451)|504|505|150|151|(3:153|(2:157|(2:159|160)(18:161|162|(2:164|(2:165|(3:167|(3:169|170|171)(8:173|174|175|176|(1:190)(1:180)|181|(1:189)(1:184)|(2:186|187)(1:188))|172)(2:191|192)))(1:306)|193|(4:201|(1:203)|204|(10:206|207|(2:209|(2:210|(3:212|(2:214|215)(1:217)|216)(3:218|219|(7:227|(1:229)(2:247|(1:249)(2:250|251))|230|(1:246)(1:234)|235|(1:245)|238))))|252|230|(1:232)|246|235|(1:237)(1:245)|238))|253|(2:255|(1:257)(1:(13:264|(7:266|(1:268)(1:284)|269|(1:283)(1:273)|274|(1:282)(1:278)|(1:281))|259|(1:261)|207|(0)|252|230|(0)|246|235|(0)(0)|238)(1:263)))|285|(2:287|(2:289|(4:291|292|(4:294|(4:296|(1:298)|299|300)|301|302)|303))(0))|207|(0)|252|230|(0)|246|235|(0)(0)|238))(1:155)|156)|11|12))|513|(3:517|(3:519|(4:526|(1:533)(1:530)|531|532)|523)|535)|424|(4:426|428|431|(3:432|(0)(0)|434))|450|(9:453|455|457|459|461|(0)|465|(0)(0)|451)|510|504|505|150|151|(0)|11|12)|423|424|(0)|450|(1:451)|510|504|505|150|151|(0)|11|12)))(1:637))|638|421|(0)|423|424|(0)|450|(1:451)|510|504|505|150|151|(0)|11|12))|149|150|151|(0)|11|12) */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x09b1, code lost:
    
        if (r6 != false) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x09de, code lost:
    
        if (r7 == false) goto L515;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0aa1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x0aa6, code lost:
    
        r18 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0ac6, code lost:
    
        r12 = r17;
        r11 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0b99, code lost:
    
        r2 = r2.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0ba8, code lost:
    
        zzT();
        r41.zzi.zzj(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x0bb6, code lost:
    
        r2.addSuppressed(r0);
        r0 = r41.zzV;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0bc0, code lost:
    
        r2 = r41.zzr;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0bca, code lost:
    
        if (r2.zzj() != r2.zzn()) goto L651;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x0bd6, code lost:
    
        r2.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0bda, code lost:
    
        r2 = r2.zzj();
        r2.getClass();
        zzV();
        r2 = r2.zzg;
        r3 = r2.zza;
        r3 = r2.zzb;
        r41.zzE = zzH(r3, r3, r2.zzc, r3, true, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x0c0d, code lost:
    
        com.google.android.gms.internal.ads.zzea.zzg(r11, "Recoverable renderer error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0c14, code lost:
    
        if (r41.zzV == null) goto L665;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0c16, code lost:
    
        r41.zzV = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0c18, code lost:
    
        r2 = r41.zzi;
        r2.zzl(r2.zzc(25, r0));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0847  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0a17  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0a76 A[Catch: RuntimeException -> 0x0ac3, zzin -> 0x0ac5, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, TryCatch #36 {zzin -> 0x0ac5, RuntimeException -> 0x0ac3, blocks: (B:172:0x08c2, B:176:0x089f, B:178:0x08a6, B:181:0x08af, B:186:0x08bf, B:193:0x08db, B:195:0x08e1, B:199:0x08e9, B:201:0x08f1, B:203:0x08f5, B:204:0x0900, B:206:0x0906, B:207:0x0a11, B:210:0x0a18, B:212:0x0a1c, B:214:0x0a24, B:216:0x0a27, B:219:0x0a2a, B:221:0x0a30, B:223:0x0a39, B:225:0x0a43, B:227:0x0a49, B:229:0x0a4f, B:230:0x0a70, B:232:0x0a76, B:235:0x0a80, B:238:0x0a9a, B:243:0x0a93, B:245:0x0a97, B:247:0x0a56, B:250:0x0a64, B:251:0x0a6b, B:252:0x0a6c, B:253:0x090f, B:255:0x0915, B:257:0x0919, B:259:0x09b3, B:261:0x09bf, B:264:0x0923, B:266:0x0927, B:268:0x0939, B:269:0x0944, B:271:0x094e, B:274:0x0957, B:276:0x0961, B:281:0x096c, B:285:0x09cc, B:287:0x09d3, B:289:0x09d7, B:292:0x09e0, B:294:0x09ef, B:296:0x09f5, B:298:0x09ff, B:300:0x0a04, B:302:0x0a09, B:303:0x0a0e, B:306:0x08d0, B:654:0x0aa9, B:657:0x0ab4), top: B:4:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0a8b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0a8c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0b38  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0b51  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0b91 A[ADDED_TO_REGION, LOOP:8: B:330:0x0b91->B:333:0x0b99, LOOP_START, PHI: r2
      0x0b91: PHI (r2v33 com.google.android.gms.internal.ads.zzlc) = (r2v31 com.google.android.gms.internal.ads.zzlc), (r2v34 com.google.android.gms.internal.ads.zzlc) binds: [B:329:0x0b8e, B:333:0x0b99] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0ba8  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0bb6  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0bc0  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0bff  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x06f8 A[Catch: zzin -> 0x085b, RuntimeException -> 0x0a9f, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, TryCatch #15 {RuntimeException -> 0x0a9f, blocks: (B:375:0x0497, B:376:0x04ae, B:378:0x04b4, B:379:0x04b9, B:380:0x04bf, B:382:0x04c3, B:383:0x04d4, B:385:0x04d8, B:387:0x04dc, B:389:0x04e0, B:391:0x04e6, B:393:0x04ec, B:395:0x04f2, B:397:0x04f8, B:399:0x0500, B:401:0x050a, B:402:0x0510, B:404:0x0514, B:406:0x051a, B:408:0x0522, B:410:0x052a, B:412:0x0547, B:416:0x054c, B:418:0x0559, B:420:0x0567, B:421:0x057b, B:424:0x06f2, B:426:0x06f8, B:428:0x06fe, B:431:0x0703, B:432:0x070e, B:434:0x0712, B:439:0x0737, B:441:0x073d, B:443:0x0745, B:445:0x074d, B:449:0x0750, B:451:0x0759, B:505:0x0828, B:151:0x0840, B:157:0x084c, B:160:0x0856, B:162:0x085f, B:164:0x086b, B:165:0x0885, B:167:0x0889, B:169:0x0891, B:174:0x089b, B:453:0x0764, B:455:0x0768, B:457:0x076e, B:459:0x0774, B:461:0x077e, B:464:0x0784, B:465:0x0787, B:467:0x0790, B:469:0x07a5, B:471:0x07ae, B:473:0x07b6, B:476:0x07c0, B:478:0x07eb, B:480:0x07f1, B:482:0x07f6, B:484:0x07fe, B:486:0x0804, B:487:0x0807, B:488:0x0810, B:490:0x0814, B:492:0x081a, B:494:0x081f, B:502:0x0827, B:511:0x0587, B:545:0x05a0, B:552:0x05b1, B:556:0x05c3, B:561:0x0604, B:563:0x060b, B:565:0x060f, B:567:0x061f, B:569:0x0623, B:573:0x062a, B:575:0x0630, B:577:0x064d, B:582:0x0656, B:586:0x0659, B:588:0x0660, B:590:0x0668, B:592:0x066e, B:594:0x0615, B:598:0x067c, B:513:0x06b5, B:515:0x06bf, B:517:0x06c3, B:519:0x06c8, B:523:0x06ef, B:524:0x06d1, B:526:0x06d7, B:530:0x06e5, B:531:0x06ec, B:640:0x04d1, B:641:0x049d, B:643:0x04a3), top: B:147:0x046a }] */
    /* JADX WARN: Removed duplicated region for block: B:434:0x0712 A[Catch: zzin -> 0x085b, RuntimeException -> 0x0a9f, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, LOOP:11: B:432:0x070e->B:434:0x0712, LOOP_END, TryCatch #15 {RuntimeException -> 0x0a9f, blocks: (B:375:0x0497, B:376:0x04ae, B:378:0x04b4, B:379:0x04b9, B:380:0x04bf, B:382:0x04c3, B:383:0x04d4, B:385:0x04d8, B:387:0x04dc, B:389:0x04e0, B:391:0x04e6, B:393:0x04ec, B:395:0x04f2, B:397:0x04f8, B:399:0x0500, B:401:0x050a, B:402:0x0510, B:404:0x0514, B:406:0x051a, B:408:0x0522, B:410:0x052a, B:412:0x0547, B:416:0x054c, B:418:0x0559, B:420:0x0567, B:421:0x057b, B:424:0x06f2, B:426:0x06f8, B:428:0x06fe, B:431:0x0703, B:432:0x070e, B:434:0x0712, B:439:0x0737, B:441:0x073d, B:443:0x0745, B:445:0x074d, B:449:0x0750, B:451:0x0759, B:505:0x0828, B:151:0x0840, B:157:0x084c, B:160:0x0856, B:162:0x085f, B:164:0x086b, B:165:0x0885, B:167:0x0889, B:169:0x0891, B:174:0x089b, B:453:0x0764, B:455:0x0768, B:457:0x076e, B:459:0x0774, B:461:0x077e, B:464:0x0784, B:465:0x0787, B:467:0x0790, B:469:0x07a5, B:471:0x07ae, B:473:0x07b6, B:476:0x07c0, B:478:0x07eb, B:480:0x07f1, B:482:0x07f6, B:484:0x07fe, B:486:0x0804, B:487:0x0807, B:488:0x0810, B:490:0x0814, B:492:0x081a, B:494:0x081f, B:502:0x0827, B:511:0x0587, B:545:0x05a0, B:552:0x05b1, B:556:0x05c3, B:561:0x0604, B:563:0x060b, B:565:0x060f, B:567:0x061f, B:569:0x0623, B:573:0x062a, B:575:0x0630, B:577:0x064d, B:582:0x0656, B:586:0x0659, B:588:0x0660, B:590:0x0668, B:592:0x066e, B:594:0x0615, B:598:0x067c, B:513:0x06b5, B:515:0x06bf, B:517:0x06c3, B:519:0x06c8, B:523:0x06ef, B:524:0x06d1, B:526:0x06d7, B:530:0x06e5, B:531:0x06ec, B:640:0x04d1, B:641:0x049d, B:643:0x04a3), top: B:147:0x046a }] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0732 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0764 A[Catch: zzin -> 0x085b, RuntimeException -> 0x0a9f, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, TryCatch #15 {RuntimeException -> 0x0a9f, blocks: (B:375:0x0497, B:376:0x04ae, B:378:0x04b4, B:379:0x04b9, B:380:0x04bf, B:382:0x04c3, B:383:0x04d4, B:385:0x04d8, B:387:0x04dc, B:389:0x04e0, B:391:0x04e6, B:393:0x04ec, B:395:0x04f2, B:397:0x04f8, B:399:0x0500, B:401:0x050a, B:402:0x0510, B:404:0x0514, B:406:0x051a, B:408:0x0522, B:410:0x052a, B:412:0x0547, B:416:0x054c, B:418:0x0559, B:420:0x0567, B:421:0x057b, B:424:0x06f2, B:426:0x06f8, B:428:0x06fe, B:431:0x0703, B:432:0x070e, B:434:0x0712, B:439:0x0737, B:441:0x073d, B:443:0x0745, B:445:0x074d, B:449:0x0750, B:451:0x0759, B:505:0x0828, B:151:0x0840, B:157:0x084c, B:160:0x0856, B:162:0x085f, B:164:0x086b, B:165:0x0885, B:167:0x0889, B:169:0x0891, B:174:0x089b, B:453:0x0764, B:455:0x0768, B:457:0x076e, B:459:0x0774, B:461:0x077e, B:464:0x0784, B:465:0x0787, B:467:0x0790, B:469:0x07a5, B:471:0x07ae, B:473:0x07b6, B:476:0x07c0, B:478:0x07eb, B:480:0x07f1, B:482:0x07f6, B:484:0x07fe, B:486:0x0804, B:487:0x0807, B:488:0x0810, B:490:0x0814, B:492:0x081a, B:494:0x081f, B:502:0x0827, B:511:0x0587, B:545:0x05a0, B:552:0x05b1, B:556:0x05c3, B:561:0x0604, B:563:0x060b, B:565:0x060f, B:567:0x061f, B:569:0x0623, B:573:0x062a, B:575:0x0630, B:577:0x064d, B:582:0x0656, B:586:0x0659, B:588:0x0660, B:590:0x0668, B:592:0x066e, B:594:0x0615, B:598:0x067c, B:513:0x06b5, B:515:0x06bf, B:517:0x06c3, B:519:0x06c8, B:523:0x06ef, B:524:0x06d1, B:526:0x06d7, B:530:0x06e5, B:531:0x06ec, B:640:0x04d1, B:641:0x049d, B:643:0x04a3), top: B:147:0x046a }] */
    /* JADX WARN: Removed duplicated region for block: B:464:0x0784 A[Catch: zzin -> 0x085b, RuntimeException -> 0x0a9f, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, TryCatch #15 {RuntimeException -> 0x0a9f, blocks: (B:375:0x0497, B:376:0x04ae, B:378:0x04b4, B:379:0x04b9, B:380:0x04bf, B:382:0x04c3, B:383:0x04d4, B:385:0x04d8, B:387:0x04dc, B:389:0x04e0, B:391:0x04e6, B:393:0x04ec, B:395:0x04f2, B:397:0x04f8, B:399:0x0500, B:401:0x050a, B:402:0x0510, B:404:0x0514, B:406:0x051a, B:408:0x0522, B:410:0x052a, B:412:0x0547, B:416:0x054c, B:418:0x0559, B:420:0x0567, B:421:0x057b, B:424:0x06f2, B:426:0x06f8, B:428:0x06fe, B:431:0x0703, B:432:0x070e, B:434:0x0712, B:439:0x0737, B:441:0x073d, B:443:0x0745, B:445:0x074d, B:449:0x0750, B:451:0x0759, B:505:0x0828, B:151:0x0840, B:157:0x084c, B:160:0x0856, B:162:0x085f, B:164:0x086b, B:165:0x0885, B:167:0x0889, B:169:0x0891, B:174:0x089b, B:453:0x0764, B:455:0x0768, B:457:0x076e, B:459:0x0774, B:461:0x077e, B:464:0x0784, B:465:0x0787, B:467:0x0790, B:469:0x07a5, B:471:0x07ae, B:473:0x07b6, B:476:0x07c0, B:478:0x07eb, B:480:0x07f1, B:482:0x07f6, B:484:0x07fe, B:486:0x0804, B:487:0x0807, B:488:0x0810, B:490:0x0814, B:492:0x081a, B:494:0x081f, B:502:0x0827, B:511:0x0587, B:545:0x05a0, B:552:0x05b1, B:556:0x05c3, B:561:0x0604, B:563:0x060b, B:565:0x060f, B:567:0x061f, B:569:0x0623, B:573:0x062a, B:575:0x0630, B:577:0x064d, B:582:0x0656, B:586:0x0659, B:588:0x0660, B:590:0x0668, B:592:0x066e, B:594:0x0615, B:598:0x067c, B:513:0x06b5, B:515:0x06bf, B:517:0x06c3, B:519:0x06c8, B:523:0x06ef, B:524:0x06d1, B:526:0x06d7, B:530:0x06e5, B:531:0x06ec, B:640:0x04d1, B:641:0x049d, B:643:0x04a3), top: B:147:0x046a }] */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0790 A[Catch: zzin -> 0x085b, RuntimeException -> 0x0a9f, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, TryCatch #15 {RuntimeException -> 0x0a9f, blocks: (B:375:0x0497, B:376:0x04ae, B:378:0x04b4, B:379:0x04b9, B:380:0x04bf, B:382:0x04c3, B:383:0x04d4, B:385:0x04d8, B:387:0x04dc, B:389:0x04e0, B:391:0x04e6, B:393:0x04ec, B:395:0x04f2, B:397:0x04f8, B:399:0x0500, B:401:0x050a, B:402:0x0510, B:404:0x0514, B:406:0x051a, B:408:0x0522, B:410:0x052a, B:412:0x0547, B:416:0x054c, B:418:0x0559, B:420:0x0567, B:421:0x057b, B:424:0x06f2, B:426:0x06f8, B:428:0x06fe, B:431:0x0703, B:432:0x070e, B:434:0x0712, B:439:0x0737, B:441:0x073d, B:443:0x0745, B:445:0x074d, B:449:0x0750, B:451:0x0759, B:505:0x0828, B:151:0x0840, B:157:0x084c, B:160:0x0856, B:162:0x085f, B:164:0x086b, B:165:0x0885, B:167:0x0889, B:169:0x0891, B:174:0x089b, B:453:0x0764, B:455:0x0768, B:457:0x076e, B:459:0x0774, B:461:0x077e, B:464:0x0784, B:465:0x0787, B:467:0x0790, B:469:0x07a5, B:471:0x07ae, B:473:0x07b6, B:476:0x07c0, B:478:0x07eb, B:480:0x07f1, B:482:0x07f6, B:484:0x07fe, B:486:0x0804, B:487:0x0807, B:488:0x0810, B:490:0x0814, B:492:0x081a, B:494:0x081f, B:502:0x0827, B:511:0x0587, B:545:0x05a0, B:552:0x05b1, B:556:0x05c3, B:561:0x0604, B:563:0x060b, B:565:0x060f, B:567:0x061f, B:569:0x0623, B:573:0x062a, B:575:0x0630, B:577:0x064d, B:582:0x0656, B:586:0x0659, B:588:0x0660, B:590:0x0668, B:592:0x066e, B:594:0x0615, B:598:0x067c, B:513:0x06b5, B:515:0x06bf, B:517:0x06c3, B:519:0x06c8, B:523:0x06ef, B:524:0x06d1, B:526:0x06d7, B:530:0x06e5, B:531:0x06ec, B:640:0x04d1, B:641:0x049d, B:643:0x04a3), top: B:147:0x046a }] */
    /* JADX WARN: Removed duplicated region for block: B:482:0x07f6 A[Catch: zzin -> 0x085b, RuntimeException -> 0x0a9f, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, LOOP:14: B:481:0x07f4->B:482:0x07f6, LOOP_END, TryCatch #15 {RuntimeException -> 0x0a9f, blocks: (B:375:0x0497, B:376:0x04ae, B:378:0x04b4, B:379:0x04b9, B:380:0x04bf, B:382:0x04c3, B:383:0x04d4, B:385:0x04d8, B:387:0x04dc, B:389:0x04e0, B:391:0x04e6, B:393:0x04ec, B:395:0x04f2, B:397:0x04f8, B:399:0x0500, B:401:0x050a, B:402:0x0510, B:404:0x0514, B:406:0x051a, B:408:0x0522, B:410:0x052a, B:412:0x0547, B:416:0x054c, B:418:0x0559, B:420:0x0567, B:421:0x057b, B:424:0x06f2, B:426:0x06f8, B:428:0x06fe, B:431:0x0703, B:432:0x070e, B:434:0x0712, B:439:0x0737, B:441:0x073d, B:443:0x0745, B:445:0x074d, B:449:0x0750, B:451:0x0759, B:505:0x0828, B:151:0x0840, B:157:0x084c, B:160:0x0856, B:162:0x085f, B:164:0x086b, B:165:0x0885, B:167:0x0889, B:169:0x0891, B:174:0x089b, B:453:0x0764, B:455:0x0768, B:457:0x076e, B:459:0x0774, B:461:0x077e, B:464:0x0784, B:465:0x0787, B:467:0x0790, B:469:0x07a5, B:471:0x07ae, B:473:0x07b6, B:476:0x07c0, B:478:0x07eb, B:480:0x07f1, B:482:0x07f6, B:484:0x07fe, B:486:0x0804, B:487:0x0807, B:488:0x0810, B:490:0x0814, B:492:0x081a, B:494:0x081f, B:502:0x0827, B:511:0x0587, B:545:0x05a0, B:552:0x05b1, B:556:0x05c3, B:561:0x0604, B:563:0x060b, B:565:0x060f, B:567:0x061f, B:569:0x0623, B:573:0x062a, B:575:0x0630, B:577:0x064d, B:582:0x0656, B:586:0x0659, B:588:0x0660, B:590:0x0668, B:592:0x066e, B:594:0x0615, B:598:0x067c, B:513:0x06b5, B:515:0x06bf, B:517:0x06c3, B:519:0x06c8, B:523:0x06ef, B:524:0x06d1, B:526:0x06d7, B:530:0x06e5, B:531:0x06ec, B:640:0x04d1, B:641:0x049d, B:643:0x04a3), top: B:147:0x046a }] */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0804 A[Catch: zzin -> 0x085b, RuntimeException -> 0x0a9f, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, TryCatch #15 {RuntimeException -> 0x0a9f, blocks: (B:375:0x0497, B:376:0x04ae, B:378:0x04b4, B:379:0x04b9, B:380:0x04bf, B:382:0x04c3, B:383:0x04d4, B:385:0x04d8, B:387:0x04dc, B:389:0x04e0, B:391:0x04e6, B:393:0x04ec, B:395:0x04f2, B:397:0x04f8, B:399:0x0500, B:401:0x050a, B:402:0x0510, B:404:0x0514, B:406:0x051a, B:408:0x0522, B:410:0x052a, B:412:0x0547, B:416:0x054c, B:418:0x0559, B:420:0x0567, B:421:0x057b, B:424:0x06f2, B:426:0x06f8, B:428:0x06fe, B:431:0x0703, B:432:0x070e, B:434:0x0712, B:439:0x0737, B:441:0x073d, B:443:0x0745, B:445:0x074d, B:449:0x0750, B:451:0x0759, B:505:0x0828, B:151:0x0840, B:157:0x084c, B:160:0x0856, B:162:0x085f, B:164:0x086b, B:165:0x0885, B:167:0x0889, B:169:0x0891, B:174:0x089b, B:453:0x0764, B:455:0x0768, B:457:0x076e, B:459:0x0774, B:461:0x077e, B:464:0x0784, B:465:0x0787, B:467:0x0790, B:469:0x07a5, B:471:0x07ae, B:473:0x07b6, B:476:0x07c0, B:478:0x07eb, B:480:0x07f1, B:482:0x07f6, B:484:0x07fe, B:486:0x0804, B:487:0x0807, B:488:0x0810, B:490:0x0814, B:492:0x081a, B:494:0x081f, B:502:0x0827, B:511:0x0587, B:545:0x05a0, B:552:0x05b1, B:556:0x05c3, B:561:0x0604, B:563:0x060b, B:565:0x060f, B:567:0x061f, B:569:0x0623, B:573:0x062a, B:575:0x0630, B:577:0x064d, B:582:0x0656, B:586:0x0659, B:588:0x0660, B:590:0x0668, B:592:0x066e, B:594:0x0615, B:598:0x067c, B:513:0x06b5, B:515:0x06bf, B:517:0x06c3, B:519:0x06c8, B:523:0x06ef, B:524:0x06d1, B:526:0x06d7, B:530:0x06e5, B:531:0x06ec, B:640:0x04d1, B:641:0x049d, B:643:0x04a3), top: B:147:0x046a }] */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0814 A[Catch: zzin -> 0x085b, RuntimeException -> 0x0a9f, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, TryCatch #15 {RuntimeException -> 0x0a9f, blocks: (B:375:0x0497, B:376:0x04ae, B:378:0x04b4, B:379:0x04b9, B:380:0x04bf, B:382:0x04c3, B:383:0x04d4, B:385:0x04d8, B:387:0x04dc, B:389:0x04e0, B:391:0x04e6, B:393:0x04ec, B:395:0x04f2, B:397:0x04f8, B:399:0x0500, B:401:0x050a, B:402:0x0510, B:404:0x0514, B:406:0x051a, B:408:0x0522, B:410:0x052a, B:412:0x0547, B:416:0x054c, B:418:0x0559, B:420:0x0567, B:421:0x057b, B:424:0x06f2, B:426:0x06f8, B:428:0x06fe, B:431:0x0703, B:432:0x070e, B:434:0x0712, B:439:0x0737, B:441:0x073d, B:443:0x0745, B:445:0x074d, B:449:0x0750, B:451:0x0759, B:505:0x0828, B:151:0x0840, B:157:0x084c, B:160:0x0856, B:162:0x085f, B:164:0x086b, B:165:0x0885, B:167:0x0889, B:169:0x0891, B:174:0x089b, B:453:0x0764, B:455:0x0768, B:457:0x076e, B:459:0x0774, B:461:0x077e, B:464:0x0784, B:465:0x0787, B:467:0x0790, B:469:0x07a5, B:471:0x07ae, B:473:0x07b6, B:476:0x07c0, B:478:0x07eb, B:480:0x07f1, B:482:0x07f6, B:484:0x07fe, B:486:0x0804, B:487:0x0807, B:488:0x0810, B:490:0x0814, B:492:0x081a, B:494:0x081f, B:502:0x0827, B:511:0x0587, B:545:0x05a0, B:552:0x05b1, B:556:0x05c3, B:561:0x0604, B:563:0x060b, B:565:0x060f, B:567:0x061f, B:569:0x0623, B:573:0x062a, B:575:0x0630, B:577:0x064d, B:582:0x0656, B:586:0x0659, B:588:0x0660, B:590:0x0668, B:592:0x066e, B:594:0x0615, B:598:0x067c, B:513:0x06b5, B:515:0x06bf, B:517:0x06c3, B:519:0x06c8, B:523:0x06ef, B:524:0x06d1, B:526:0x06d7, B:530:0x06e5, B:531:0x06ec, B:640:0x04d1, B:641:0x049d, B:643:0x04a3), top: B:147:0x046a }] */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0826 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:511:0x0587 A[Catch: zzin -> 0x085b, RuntimeException -> 0x0a9f, IOException -> 0x0af9, zzuh -> 0x0b00, zzgk -> 0x0b07, zzaz -> 0x0b0e, zzsa -> 0x0b24, TRY_LEAVE, TryCatch #15 {RuntimeException -> 0x0a9f, blocks: (B:375:0x0497, B:376:0x04ae, B:378:0x04b4, B:379:0x04b9, B:380:0x04bf, B:382:0x04c3, B:383:0x04d4, B:385:0x04d8, B:387:0x04dc, B:389:0x04e0, B:391:0x04e6, B:393:0x04ec, B:395:0x04f2, B:397:0x04f8, B:399:0x0500, B:401:0x050a, B:402:0x0510, B:404:0x0514, B:406:0x051a, B:408:0x0522, B:410:0x052a, B:412:0x0547, B:416:0x054c, B:418:0x0559, B:420:0x0567, B:421:0x057b, B:424:0x06f2, B:426:0x06f8, B:428:0x06fe, B:431:0x0703, B:432:0x070e, B:434:0x0712, B:439:0x0737, B:441:0x073d, B:443:0x0745, B:445:0x074d, B:449:0x0750, B:451:0x0759, B:505:0x0828, B:151:0x0840, B:157:0x084c, B:160:0x0856, B:162:0x085f, B:164:0x086b, B:165:0x0885, B:167:0x0889, B:169:0x0891, B:174:0x089b, B:453:0x0764, B:455:0x0768, B:457:0x076e, B:459:0x0774, B:461:0x077e, B:464:0x0784, B:465:0x0787, B:467:0x0790, B:469:0x07a5, B:471:0x07ae, B:473:0x07b6, B:476:0x07c0, B:478:0x07eb, B:480:0x07f1, B:482:0x07f6, B:484:0x07fe, B:486:0x0804, B:487:0x0807, B:488:0x0810, B:490:0x0814, B:492:0x081a, B:494:0x081f, B:502:0x0827, B:511:0x0587, B:545:0x05a0, B:552:0x05b1, B:556:0x05c3, B:561:0x0604, B:563:0x060b, B:565:0x060f, B:567:0x061f, B:569:0x0623, B:573:0x062a, B:575:0x0630, B:577:0x064d, B:582:0x0656, B:586:0x0659, B:588:0x0660, B:590:0x0668, B:592:0x066e, B:594:0x0615, B:598:0x067c, B:513:0x06b5, B:515:0x06bf, B:517:0x06c3, B:519:0x06c8, B:523:0x06ef, B:524:0x06d1, B:526:0x06d7, B:530:0x06e5, B:531:0x06ec, B:640:0x04d1, B:641:0x049d, B:643:0x04a3), top: B:147:0x046a }] */
    /* JADX WARN: Removed duplicated region for block: B:606:0x0b14  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x0b1e  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x0ad7  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(Message message) {
        String str;
        String str2;
        String str3;
        zzin zzinVar;
        boolean z;
        zzlc zzn;
        zze zzeVar;
        boolean z2;
        long uptimeMillis;
        zzdt zzdtVar;
        long j;
        long j2;
        zzlc zzn2;
        int i;
        zzlf zzlfVar;
        boolean z3;
        zzlc zzn3;
        boolean z4;
        long j3;
        zzin zzinVar2;
        zzlc zzj;
        zzlc zzg;
        zzlc zze;
        char c;
        boolean z5;
        int i2;
        int i3;
        zzlc zzn4;
        zzze zzi;
        int i4;
        int i5;
        zzmf[] zzmfVarArr;
        zzlc zzm;
        long j4;
        zzld zzo;
        int i6;
        long j5;
        boolean z6;
        boolean z7;
        boolean zzj2;
        int i7;
        long j6;
        String str4;
        int i8;
        List list;
        zzxc zzxcVar;
        List list2;
        zzxc zzxcVar2;
        int i9;
        long j7;
        List list3;
        zzxc zzxcVar3;
        String str5 = "ExoPlayerImplInternal";
        try {
            try {
                try {
                    zzeVar = null;
                } catch (RuntimeException e) {
                    e = e;
                }
            } catch (zzin e2) {
                e = e2;
            }
            try {
            } catch (zzin e3) {
                e = e3;
            } catch (RuntimeException e4) {
                e = e4;
                zzin zzd = zzin.zzd(e, (!(e instanceof IllegalStateException) || (e instanceof IllegalArgumentException)) ? 1004 : 1000);
                zzea.zzd("ExoPlayerImplInternal", str, zzd);
                zzam(true, false);
                this.zzE = this.zzE.zze(zzd);
                z = true;
                zzV();
                return z;
            }
        } catch (zzaz e5) {
            e = e5;
        } catch (zzgk e6) {
            e = e6;
        } catch (zzsa e7) {
            e = e7;
        } catch (zzuh e8) {
            e = e8;
        } catch (IOException e9) {
            e = e9;
        }
        switch (message.what) {
            case 1:
                zzai(message.arg1 != 0, message.arg2 >> 4, true, message.arg2 & 15);
                z = true;
                zzV();
                return z;
            case 2:
                try {
                    uptimeMillis = SystemClock.uptimeMillis();
                    zzdtVar = this.zzi;
                    zzdtVar.zzg(2);
                    try {
                        try {
                        } catch (RuntimeException e10) {
                            e = e10;
                        }
                    } catch (zzin e11) {
                        e = e11;
                    }
                } catch (zzin e12) {
                    e = e12;
                    str = "Playback error";
                    break;
                }
                if (!this.zzE.zza.zzo()) {
                    try {
                    } catch (zzin e13) {
                        e = e13;
                        str = "Playback error";
                    }
                    if (this.zzs.zzj()) {
                        zzlf zzlfVar2 = this.zzr;
                        zzlfVar2.zzu(this.zzR);
                        if (!zzlfVar2.zzz() || (zzo = zzlfVar2.zzo(this.zzR, this.zzE)) == null) {
                            str = "Playback error";
                        } else {
                            zzlc zzh = zzlfVar2.zzh(zzo);
                            if (zzh.zzd) {
                                str = "Playback error";
                                if (zzh.zze) {
                                    zzdtVar.zzc(8, zzh.zza).zza();
                                }
                            } else {
                                str = "Playback error";
                                zzh.zzm(this, zzo.zzb);
                            }
                            if (zzlfVar2.zzj() == zzh) {
                                zzac(zzo.zzb);
                            }
                            zzP(false);
                        }
                        if (this.zzL) {
                            this.zzL = zzaC(zzlfVar2.zzi());
                            zzao();
                        } else {
                            zzT();
                        }
                        if (this.zzI || !this.zzx || this.zzZ || zzaw() || (zzm = zzlfVar2.zzm()) == null || zzm != zzlfVar2.zzn() || zzm.zzg() == null || !zzm.zzg().zze) {
                            j = uptimeMillis;
                        } else {
                            zzlfVar2.zzf();
                            zzlc zzm2 = zzlfVar2.zzm();
                            if (zzm2 != null) {
                                zzze zzi2 = zzm2.zzi();
                                long j8 = uptimeMillis;
                                int i10 = 0;
                                while (true) {
                                    zzmf[] zzmfVarArr2 = this.zzb;
                                    if (i10 >= 2) {
                                        j = j8;
                                        j2 = -9223372036854775807L;
                                        if (zzaw()) {
                                            this.zzY = zzm2.zza.zzd();
                                            if (!zzm2.zzs()) {
                                                zzlfVar2.zza(zzm2);
                                                zzP(false);
                                                zzT();
                                            }
                                        }
                                        zzn2 = zzlfVar2.zzn();
                                        if (zzn2 != null) {
                                            if (zzn2.zzg() != null) {
                                                try {
                                                } catch (zzaz e14) {
                                                    e = e14;
                                                    zzO(e, e.zzb != 1 ? true != e.zza ? 3003 : 3001 : 1000);
                                                    z = true;
                                                    zzV();
                                                    return z;
                                                } catch (zzgk e15) {
                                                    e = e15;
                                                    zzO(e, e.zza);
                                                    z = true;
                                                    zzV();
                                                    return z;
                                                } catch (zzin e16) {
                                                    e = e16;
                                                    str3 = "ExoPlayerImplInternal";
                                                    str2 = str;
                                                    if (e.zzc == 1) {
                                                        e = e.zza(zzn.zzg.zza);
                                                        break;
                                                    }
                                                    if (e.zzc == 1) {
                                                        int i11 = e.zze;
                                                        zzlf zzlfVar3 = this.zzr;
                                                        if (zzlfVar3.zzm() != null) {
                                                            this.zzZ = true;
                                                            zzJ();
                                                            zzlc zzm3 = zzlfVar3.zzm();
                                                            zzlc zzj3 = zzlfVar3.zzj();
                                                            if (zzlfVar3.zzj() != zzm3) {
                                                            }
                                                            zzlfVar3.zza(zzj3);
                                                            if (this.zzE.zze != 4) {
                                                            }
                                                            z = true;
                                                            zzV();
                                                            return z;
                                                        }
                                                        break;
                                                    }
                                                    zzinVar = this.zzV;
                                                    if (zzinVar != null) {
                                                    }
                                                    if (e.zzc == 1) {
                                                    }
                                                    if (e.zzi) {
                                                        break;
                                                    }
                                                    zzea.zzd(str3, str2, e);
                                                    z = true;
                                                    zzam(true, false);
                                                    this.zzE = this.zzE.zze(e);
                                                    zzV();
                                                    return z;
                                                } catch (zzsa e17) {
                                                    e = e17;
                                                    zzO(e, e.zza);
                                                    z = true;
                                                    zzV();
                                                    return z;
                                                } catch (zzuh e18) {
                                                    e = e18;
                                                    zzO(e, 1002);
                                                    z = true;
                                                    zzV();
                                                    return z;
                                                } catch (IOException e19) {
                                                    e = e19;
                                                    zzO(e, 2000);
                                                    z = true;
                                                    zzV();
                                                    return z;
                                                } catch (RuntimeException e20) {
                                                    e = e20;
                                                    if (e instanceof IllegalStateException) {
                                                        break;
                                                    }
                                                    zzin zzd2 = zzin.zzd(e, (!(e instanceof IllegalStateException) || (e instanceof IllegalArgumentException)) ? 1004 : 1000);
                                                    zzea.zzd("ExoPlayerImplInternal", str, zzd2);
                                                    zzam(true, false);
                                                    this.zzE = this.zzE.zze(zzd2);
                                                    z = true;
                                                    zzV();
                                                    return z;
                                                }
                                                if (!this.zzI) {
                                                    zzlc zzn5 = zzlfVar2.zzn();
                                                    if (zzn5.zze) {
                                                        int i12 = 0;
                                                        while (true) {
                                                            zzmf[] zzmfVarArr3 = this.zzb;
                                                            if (i12 < 2) {
                                                                if (zzmfVarArr3[i12].zzE(zzn5)) {
                                                                    i12++;
                                                                }
                                                            } else if ((!zzaw() || zzlfVar2.zzm() != zzlfVar2.zzn()) && (zzn2.zzg().zze || this.zzR >= zzn2.zzg().zzf())) {
                                                                zzze zzi3 = zzn2.zzi();
                                                                zzlc zzg2 = zzlfVar2.zzg();
                                                                zzze zzi4 = zzg2.zzi();
                                                                zzbl zzblVar = this.zzE.zza;
                                                                i = 1;
                                                                zzau(zzblVar, zzg2.zzg.zza, zzblVar, zzn2.zzg.zza, -9223372036854775807L, false);
                                                                if (zzg2.zze && (((z3 = this.zzx) && this.zzY != j2) || zzg2.zza.zzd() != j2)) {
                                                                    this.zzY = j2;
                                                                    if (z3 && !this.zzZ) {
                                                                        for (int i13 = 0; i13 < 2; i13++) {
                                                                            if (zzi4.zzb(i13)) {
                                                                                zzmfVarArr3[i13].zzb();
                                                                                zzyw[] zzywVarArr = zzi4.zzc;
                                                                                if (!zzay.zzf(zzywVarArr[i13].zzb().zzo, zzywVarArr[i13].zzb().zzk) && !zzmfVarArr3[i13].zzI()) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    long zzf = zzg2.zzf();
                                                                    for (int i14 = 0; i14 < 2; i14++) {
                                                                        zzmfVarArr3[i14].zzs(zzf);
                                                                    }
                                                                    if (!zzg2.zzs()) {
                                                                        zzlfVar2.zza(zzg2);
                                                                        zzP(false);
                                                                        zzT();
                                                                    }
                                                                    zzlfVar = zzlfVar2;
                                                                }
                                                                for (int i15 = 0; i15 < 2; i15++) {
                                                                    zzmfVarArr3[i15].zzm(zzi3, zzi4, zzg2.zzf());
                                                                }
                                                                zzlfVar = zzlfVar2;
                                                            }
                                                        }
                                                    } else {
                                                        i = 1;
                                                        zzlfVar = zzlfVar2;
                                                    }
                                                    zzn3 = zzlfVar.zzn();
                                                    if (zzn3 != null && zzlfVar.zzj() != zzn3 && !zzn3.zzh) {
                                                        zzn4 = zzlfVar.zzn();
                                                        zzi = zzn4.zzi();
                                                        i4 = i;
                                                        i5 = 0;
                                                        while (true) {
                                                            zzmfVarArr = this.zzb;
                                                            if (i5 >= 2) {
                                                                int zza2 = zzmfVarArr[i5].zza();
                                                                int zzc = zzmfVarArr[i5].zzc(zzn4, zzi, this.zzo);
                                                                this.zzP -= zza2 - zzmfVarArr[i5].zza();
                                                                i4 &= zzc & 1;
                                                                i5++;
                                                            } else if (i4 != 0) {
                                                                for (int i16 = 0; i16 < 2; i16++) {
                                                                    if (zzi.zzb(i16) && !zzmfVarArr[i16].zzK(zzn4)) {
                                                                        zzL(zzn4, i16, false, zzn4.zzf());
                                                                    }
                                                                }
                                                                zzlfVar.zzn().zzh = i;
                                                            }
                                                        }
                                                    }
                                                    z4 = false;
                                                    while (zzaA() && !this.zzI && (zzj = zzlfVar.zzj()) != null && (zzg = zzj.zzg()) != null && this.zzR >= zzg.zzf() && zzg.zzh) {
                                                        if (z4) {
                                                            zzV();
                                                        }
                                                        this.zzZ = false;
                                                        zze = zzlfVar.zze();
                                                        if (zze != null) {
                                                            throw null;
                                                        }
                                                        zzlc zzlcVar = zze;
                                                        if (this.zzE.zzb.zza.equals(zze.zzg.zza.zza)) {
                                                            zzvh zzvhVar = this.zzE.zzb;
                                                            c = 65535;
                                                            if (zzvhVar.zzb == -1) {
                                                                zzvh zzvhVar2 = zze.zzg.zza;
                                                                if (zzvhVar2.zzb == -1 && zzvhVar.zze != zzvhVar2.zze) {
                                                                    z5 = true;
                                                                    zzld zzldVar = zze.zzg;
                                                                    boolean z8 = z5;
                                                                    zzvh zzvhVar3 = zzldVar.zza;
                                                                    long j9 = zzldVar.zzb;
                                                                    long j10 = j2;
                                                                    this.zzE = zzH(zzvhVar3, j9, zzldVar.zzc, j9, !z8, 0);
                                                                    zzab();
                                                                    zzat();
                                                                    if (zzaw() && zze == zzlfVar.zzm()) {
                                                                        zzmf[] zzmfVarArr4 = this.zzb;
                                                                        for (i3 = 0; i3 < 2; i3++) {
                                                                            zzmfVarArr4[i3].zzl();
                                                                        }
                                                                    }
                                                                    if (this.zzE.zze == 3) {
                                                                        zzal();
                                                                    }
                                                                    zzze zzi5 = zzlfVar.zzj().zzi();
                                                                    i2 = 0;
                                                                    while (true) {
                                                                        zzmf[] zzmfVarArr5 = this.zzb;
                                                                        if (i2 >= 2) {
                                                                            if (zzi5.zzb(i2)) {
                                                                                zzmfVarArr5[i2].zzi();
                                                                            }
                                                                            i2++;
                                                                        }
                                                                    }
                                                                    j2 = j10;
                                                                    z4 = true;
                                                                }
                                                            }
                                                        } else {
                                                            c = 65535;
                                                        }
                                                        z5 = false;
                                                        zzld zzldVar2 = zze.zzg;
                                                        boolean z82 = z5;
                                                        zzvh zzvhVar32 = zzldVar2.zza;
                                                        long j92 = zzldVar2.zzb;
                                                        long j102 = j2;
                                                        this.zzE = zzH(zzvhVar32, j92, zzldVar2.zzc, j92, !z82, 0);
                                                        zzab();
                                                        zzat();
                                                        if (zzaw()) {
                                                            zzmf[] zzmfVarArr42 = this.zzb;
                                                            while (i3 < 2) {
                                                            }
                                                        }
                                                        if (this.zzE.zze == 3) {
                                                        }
                                                        zzze zzi52 = zzlfVar.zzj().zzi();
                                                        i2 = 0;
                                                        while (true) {
                                                            zzmf[] zzmfVarArr52 = this.zzb;
                                                            if (i2 >= 2) {
                                                                break;
                                                            }
                                                            i2++;
                                                        }
                                                        j2 = j102;
                                                        z4 = true;
                                                    }
                                                    j3 = j2;
                                                    zzinVar2 = null;
                                                    long j11 = this.zzX.zzb;
                                                    i6 = this.zzE.zze;
                                                    z = true;
                                                    if (i6 != 1) {
                                                        if (i6 != 4) {
                                                            zzlf zzlfVar4 = this.zzr;
                                                            zzlc zzj4 = zzlfVar4.zzj();
                                                            if (zzj4 == null) {
                                                                zzae(j);
                                                            } else {
                                                                long j12 = j;
                                                                Trace.beginSection("doSomeWork");
                                                                zzat();
                                                                if (zzj4.zze) {
                                                                    this.zzS = zzex.zzs(SystemClock.elapsedRealtime());
                                                                    boolean z9 = false;
                                                                    zzj4.zza.zzh(this.zzE.zzs - this.zzn, false);
                                                                    int i17 = 0;
                                                                    z6 = true;
                                                                    z7 = true;
                                                                    while (true) {
                                                                        zzmf[] zzmfVarArr6 = this.zzb;
                                                                        if (i17 < 2) {
                                                                            zzmf zzmfVar = zzmfVarArr6[i17];
                                                                            if (zzmfVar.zza() == 0) {
                                                                                zzX(i17, z9);
                                                                                str4 = str5;
                                                                                j6 = j3;
                                                                            } else {
                                                                                j6 = j3;
                                                                                str4 = str5;
                                                                                zzmfVar.zzp(this.zzR, this.zzS);
                                                                                z6 = z6 && zzmfVar.zzH();
                                                                                boolean zzD = zzmfVar.zzD(zzj4);
                                                                                zzX(i17, zzD);
                                                                                z7 = z7 && zzD;
                                                                                if (!zzD) {
                                                                                    zzW(i17);
                                                                                }
                                                                            }
                                                                            i17++;
                                                                            str5 = str4;
                                                                            j3 = j6;
                                                                            z9 = false;
                                                                        } else {
                                                                            j5 = j3;
                                                                        }
                                                                    }
                                                                } else {
                                                                    j5 = j3;
                                                                    zzj4.zza.zzi();
                                                                    z6 = true;
                                                                    z7 = true;
                                                                }
                                                                long j13 = zzj4.zzg.zze;
                                                                if (z6 && zzj4.zze && (j13 == j5 || j13 <= this.zzE.zzs)) {
                                                                    if (this.zzI) {
                                                                        this.zzI = false;
                                                                        zzai(false, this.zzE.zzn, false, 5);
                                                                    }
                                                                    if (zzj4.zzg.zzj) {
                                                                        zzaj(4);
                                                                        zzan();
                                                                        if (this.zzE.zze == 2) {
                                                                            int i18 = 0;
                                                                            while (true) {
                                                                                zzmf[] zzmfVarArr7 = this.zzb;
                                                                                if (i18 < 2) {
                                                                                    if (zzmfVarArr7[i18].zzK(zzj4)) {
                                                                                        zzW(i18);
                                                                                    }
                                                                                    i18++;
                                                                                } else {
                                                                                    zzls zzlsVar = this.zzE;
                                                                                    if (!zzlsVar.zzg && zzlsVar.zzr < 500000 && zzaC(zzlfVar4.zzi()) && zzaA()) {
                                                                                        if (this.zzW == j5) {
                                                                                            this.zzW = SystemClock.elapsedRealtime();
                                                                                        } else if (SystemClock.elapsedRealtime() - this.zzW >= 4000) {
                                                                                            throw new IllegalStateException("Playback stuck buffering and not loading");
                                                                                        }
                                                                                        boolean z10 = !zzaA() && this.zzE.zze == 3;
                                                                                        boolean z11 = this.zzE.zzp;
                                                                                        i7 = this.zzE.zze;
                                                                                        if (i7 != 4 && (z10 || i7 == 2 || (i7 == 3 && this.zzP != 0))) {
                                                                                            zzae(j12);
                                                                                        }
                                                                                        Trace.endSection();
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        this.zzW = j5;
                                                                        if (zzaA()) {
                                                                        }
                                                                        boolean z112 = this.zzE.zzp;
                                                                        i7 = this.zzE.zze;
                                                                        if (i7 != 4) {
                                                                            zzae(j12);
                                                                        }
                                                                        Trace.endSection();
                                                                    }
                                                                }
                                                                zzls zzlsVar2 = this.zzE;
                                                                if (zzlsVar2.zze == 2) {
                                                                    if (this.zzP == 0) {
                                                                        zzj2 = zzay();
                                                                        break;
                                                                    } else if (z7) {
                                                                        if (zzlsVar2.zzg) {
                                                                            zzlc zzj5 = zzlfVar4.zzj();
                                                                            long zzb = zzaB(this.zzE.zza, zzj5.zzg.zza) ? this.zzac.zzb() : j5;
                                                                            zzlc zzi6 = zzlfVar4.zzi();
                                                                            boolean z12 = zzi6.zzs() && zzi6.zzg.zzj;
                                                                            boolean z13 = zzi6.zzg.zza.zzb() && !zzi6.zze;
                                                                            if (!z12 && !z13) {
                                                                                zzj2 = this.zzg.zzj(new zzkw(this.zzu, this.zzE.zza, zzj5.zzg.zza, this.zzR - zzj5.zze(), zzC(zzi6.zzc()), this.zzo.zzc().zzb, this.zzE.zzl, this.zzJ, zzb, this.zzK));
                                                                                break;
                                                                            }
                                                                        }
                                                                        zzaj(3);
                                                                        this.zzV = zzinVar2;
                                                                        if (zzaA()) {
                                                                            zzav(false, false);
                                                                            this.zzo.zzh();
                                                                            zzal();
                                                                        }
                                                                        if (this.zzE.zze == 2) {
                                                                        }
                                                                        this.zzW = j5;
                                                                        if (zzaA()) {
                                                                        }
                                                                        boolean z1122 = this.zzE.zzp;
                                                                        i7 = this.zzE.zze;
                                                                        if (i7 != 4) {
                                                                        }
                                                                        Trace.endSection();
                                                                    }
                                                                }
                                                                if (this.zzE.zze == 3) {
                                                                    if (this.zzP == 0) {
                                                                        if (!zzay()) {
                                                                            zzav(zzaA(), false);
                                                                            zzaj(2);
                                                                            if (this.zzJ) {
                                                                                for (zzlc zzj6 = zzlfVar4.zzj(); zzj6 != null; zzj6 = zzj6.zzg()) {
                                                                                    for (zzyw zzywVar : zzj6.zzi().zzc) {
                                                                                    }
                                                                                }
                                                                                this.zzac.zzc();
                                                                            }
                                                                            zzan();
                                                                        }
                                                                    }
                                                                }
                                                                if (this.zzE.zze == 2) {
                                                                }
                                                                this.zzW = j5;
                                                                if (zzaA()) {
                                                                }
                                                                boolean z11222 = this.zzE.zzp;
                                                                i7 = this.zzE.zze;
                                                                if (i7 != 4) {
                                                                }
                                                                Trace.endSection();
                                                            }
                                                        }
                                                        z = true;
                                                    }
                                                    zzV();
                                                    return z;
                                                }
                                            }
                                            zzlfVar = zzlfVar2;
                                            i = 1;
                                            if (zzn2.zzg.zzj || this.zzI) {
                                                zzmf[] zzmfVarArr8 = this.zzb;
                                                for (int i19 = 0; i19 < 2; i19++) {
                                                    zzmf zzmfVar2 = zzmfVarArr8[i19];
                                                    if (zzmfVar2.zzK(zzn2) && zzmfVar2.zzF(zzn2)) {
                                                        long j14 = zzn2.zzg.zze;
                                                        zzmfVar2.zzt(zzn2, (j14 == j2 || j14 == Long.MIN_VALUE) ? j2 : j14 + zzn2.zze());
                                                    }
                                                }
                                            }
                                            zzn3 = zzlfVar.zzn();
                                            if (zzn3 != null) {
                                                zzn4 = zzlfVar.zzn();
                                                zzi = zzn4.zzi();
                                                i4 = i;
                                                i5 = 0;
                                                while (true) {
                                                    zzmfVarArr = this.zzb;
                                                    if (i5 >= 2) {
                                                    }
                                                    int zza22 = zzmfVarArr[i5].zza();
                                                    int zzc2 = zzmfVarArr[i5].zzc(zzn4, zzi, this.zzo);
                                                    this.zzP -= zza22 - zzmfVarArr[i5].zza();
                                                    i4 &= zzc2 & 1;
                                                    i5++;
                                                }
                                            }
                                            z4 = false;
                                            while (zzaA()) {
                                                if (z4) {
                                                }
                                                this.zzZ = false;
                                                zze = zzlfVar.zze();
                                                if (zze != null) {
                                                }
                                            }
                                            j3 = j2;
                                            zzinVar2 = null;
                                            long j112 = this.zzX.zzb;
                                            i6 = this.zzE.zze;
                                            z = true;
                                            if (i6 != 1) {
                                            }
                                            zzV();
                                            return z;
                                        }
                                        zzlfVar = zzlfVar2;
                                        i = 1;
                                        zzn3 = zzlfVar.zzn();
                                        if (zzn3 != null) {
                                        }
                                        z4 = false;
                                        while (zzaA()) {
                                        }
                                        j3 = j2;
                                        zzinVar2 = null;
                                        long j1122 = this.zzX.zzb;
                                        i6 = this.zzE.zze;
                                        z = true;
                                        if (i6 != 1) {
                                        }
                                        zzV();
                                        return z;
                                    }
                                    if (zzi2.zzb(i10) && zzmfVarArr2[i10].zzG() && !zzmfVarArr2[i10].zzI()) {
                                        zzmfVarArr2[i10].zzB();
                                        j4 = j8;
                                        zzL(zzm2, i10, false, zzm2.zzf());
                                    } else {
                                        j4 = j8;
                                    }
                                    i10++;
                                    j8 = j4;
                                }
                            } else {
                                j = uptimeMillis;
                            }
                        }
                        j2 = -9223372036854775807L;
                        zzn2 = zzlfVar2.zzn();
                        if (zzn2 != null) {
                        }
                        zzlfVar = zzlfVar2;
                        i = 1;
                        zzn3 = zzlfVar.zzn();
                        if (zzn3 != null) {
                        }
                        z4 = false;
                        while (zzaA()) {
                        }
                        j3 = j2;
                        zzinVar2 = null;
                        long j11222 = this.zzX.zzb;
                        i6 = this.zzE.zze;
                        z = true;
                        if (i6 != 1) {
                        }
                        zzV();
                        return z;
                    }
                }
                j = uptimeMillis;
                zzinVar2 = null;
                str = "Playback error";
                j3 = -9223372036854775807L;
                i6 = this.zzE.zze;
                z = true;
                if (i6 != 1) {
                }
                zzV();
                return z;
            case 3:
                z2 = true;
                zzag((zzkr) message.obj, true);
                z = z2;
                zzV();
                return z;
            case 4:
                z2 = true;
                zzah((zzbb) message.obj);
                zzR(this.zzo.zzc(), true);
                z = z2;
                zzV();
                return z;
            case 5:
                z2 = true;
                this.zzz = (zzmi) message.obj;
                z = z2;
                zzV();
                return z;
            case 6:
                z2 = true;
                zzam(false, true);
                z = z2;
                zzV();
                return z;
            case 7:
                zzdm zzdmVar = (zzdm) message.obj;
                try {
                    zzaa(true, false, true, false);
                    int i20 = 0;
                    while (true) {
                        zzmf[] zzmfVarArr9 = this.zzb;
                        if (i20 >= 2) {
                            this.zzg.zzd(this.zzu);
                            this.zzy.zzd();
                            this.zze.zzj();
                            zzaj(1);
                            return true;
                        }
                        this.zzc[i20].zzr();
                        zzmfVarArr9[i20].zzo();
                        i20++;
                    }
                } finally {
                    this.zzi.zzf(null);
                    this.zzj.zzb();
                    zzdmVar.zzf();
                }
            case 8:
                try {
                    zzvf zzvfVar = (zzvf) message.obj;
                    zzlf zzlfVar5 = this.zzr;
                    if (zzlfVar5.zzx(zzvfVar)) {
                        zzlc zzi7 = zzlfVar5.zzi();
                        if (zzi7 == null) {
                            throw null;
                        }
                        zzlc zzlcVar2 = zzi7;
                        if (!zzi7.zze) {
                            float f = this.zzo.zzc().zzb;
                            zzls zzlsVar3 = this.zzE;
                            zzi7.zzl(f, zzlsVar3.zza, zzlsVar3.zzl);
                        }
                        zzap(zzi7.zzg.zza, zzi7.zzh(), zzi7.zzi());
                        if (zzi7 == zzlfVar5.zzj()) {
                            zzac(zzi7.zzg.zzb);
                            zzM();
                            zzi7.zzh = true;
                            zzls zzlsVar4 = this.zzE;
                            try {
                                zzvh zzvhVar4 = zzlsVar4.zzb;
                                long j15 = zzi7.zzg.zzb;
                                z2 = true;
                                this.zzE = zzH(zzvhVar4, j15, zzlsVar4.zzc, j15, false, 5);
                            } catch (zzaz e21) {
                                e = e21;
                                zzO(e, e.zzb != 1 ? true != e.zza ? 3003 : 3001 : 1000);
                                z = true;
                                zzV();
                                return z;
                            } catch (zzgk e22) {
                                e = e22;
                                zzO(e, e.zza);
                                z = true;
                                zzV();
                                return z;
                            } catch (zzin e23) {
                                e = e23;
                                str2 = "Playback error";
                                str3 = "ExoPlayerImplInternal";
                                if (e.zzc == 1) {
                                }
                                if (e.zzc == 1) {
                                }
                                zzinVar = this.zzV;
                                if (zzinVar != null) {
                                }
                                if (e.zzc == 1) {
                                }
                                if (e.zzi) {
                                }
                                zzea.zzd(str3, str2, e);
                                z = true;
                                zzam(true, false);
                                this.zzE = this.zzE.zze(e);
                                zzV();
                                return z;
                            } catch (zzsa e24) {
                                e = e24;
                                zzO(e, e.zza);
                                z = true;
                                zzV();
                                return z;
                            } catch (zzuh e25) {
                                e = e25;
                                zzO(e, 1002);
                                z = true;
                                zzV();
                                return z;
                            } catch (IOException e26) {
                                e = e26;
                                zzO(e, 2000);
                                z = true;
                                zzV();
                                return z;
                            } catch (RuntimeException e27) {
                                e = e27;
                                str = "Playback error";
                                zzin zzd22 = zzin.zzd(e, (!(e instanceof IllegalStateException) || (e instanceof IllegalArgumentException)) ? 1004 : 1000);
                                zzea.zzd("ExoPlayerImplInternal", str, zzd22);
                                zzam(true, false);
                                this.zzE = this.zzE.zze(zzd22);
                                z = true;
                                zzV();
                                return z;
                            }
                        } else {
                            z2 = true;
                        }
                        zzT();
                    } else {
                        z2 = true;
                        zzlc zzk = zzlfVar5.zzk(zzvfVar);
                        if (zzk != null) {
                            zzdd.zzf(!zzk.zze);
                            float f2 = this.zzo.zzc().zzb;
                            zzls zzlsVar5 = this.zzE;
                            zzk.zzl(f2, zzlsVar5.zza, zzlsVar5.zzl);
                            if (zzlfVar5.zzy(zzvfVar)) {
                                zzU();
                            }
                        }
                    }
                    z = z2;
                } catch (zzaz e28) {
                    e = e28;
                } catch (zzgk e29) {
                    e = e29;
                } catch (zzin e30) {
                    e = e30;
                } catch (zzsa e31) {
                    e = e31;
                } catch (zzuh e32) {
                    e = e32;
                } catch (IOException e33) {
                    e = e33;
                } catch (RuntimeException e34) {
                    e = e34;
                }
                zzV();
                return z;
            case 9:
                zzvf zzvfVar2 = (zzvf) message.obj;
                zzlf zzlfVar6 = this.zzr;
                if (zzlfVar6.zzx(zzvfVar2)) {
                    zzlfVar6.zzu(this.zzR);
                    zzT();
                } else if (zzlfVar6.zzy(zzvfVar2)) {
                    zzU();
                }
                z = true;
                zzV();
                return z;
            case 10:
                zzY();
                z = true;
                zzV();
                return z;
            case 11:
                int i21 = message.arg1;
                this.zzM = i21;
                int zzc3 = this.zzr.zzc(this.zzE.zza, i21);
                if ((zzc3 & 1) != 0) {
                    zzaf(true);
                } else if ((zzc3 & 2) != 0) {
                    zzJ();
                }
                zzP(false);
                z = true;
                zzV();
                return z;
            case 12:
                boolean z14 = message.arg1 != 0;
                this.zzN = z14;
                int zzd3 = this.zzr.zzd(this.zzE.zza, z14);
                if ((zzd3 & 1) != 0) {
                    zzaf(true);
                } else if ((zzd3 & 2) != 0) {
                    zzJ();
                }
                zzP(false);
                z = true;
                zzV();
                return z;
            case 13:
                boolean z15 = message.arg1 != 0;
                zzdm zzdmVar2 = (zzdm) message.obj;
                if (this.zzO != z15) {
                    this.zzO = z15;
                    if (!z15) {
                        zzmf[] zzmfVarArr10 = this.zzb;
                        for (int i22 = 0; i22 < 2; i22++) {
                            zzmfVarArr10[i22].zzq();
                        }
                    }
                }
                if (zzdmVar2 != null) {
                    zzdmVar2.zzf();
                }
                z = true;
                zzV();
                return z;
            case 14:
                zzlw zzlwVar = (zzlw) message.obj;
                if (zzlwVar.zzb() == this.zzk) {
                    zzaD(zzlwVar);
                    int i23 = this.zzE.zze;
                    if (i23 == 3 || i23 == 2) {
                        this.zzi.zzj(2);
                    }
                } else {
                    this.zzi.zzc(15, zzlwVar).zza();
                }
                z = true;
                zzV();
                return z;
            case 15:
                final zzlw zzlwVar2 = (zzlw) message.obj;
                Looper zzb2 = zzlwVar2.zzb();
                if (zzb2.getThread().isAlive()) {
                    this.zzq.zzd(zzb2, null).zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkj
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzkt.zzh(zzkt.this, zzlwVar2);
                        }
                    });
                } else {
                    zzea.zzf("TAG", "Trying to send message on a dead thread.");
                    zzlwVar2.zzh(false);
                }
                z = true;
                zzV();
                return z;
            case 16:
                zzR((zzbb) message.obj, false);
                z = true;
                zzV();
                return z;
            case 17:
                zzkn zzknVar = (zzkn) message.obj;
                this.zzF.zza(1);
                i8 = zzknVar.zzb;
                if (i8 != -1) {
                    list2 = zzknVar.zza;
                    zzxcVar2 = zzknVar.zzd;
                    zzly zzlyVar = new zzly(list2, zzxcVar2);
                    i9 = zzknVar.zzb;
                    j7 = zzknVar.zzc;
                    this.zzQ = new zzkr(zzlyVar, i9, j7);
                }
                zzlr zzlrVar = this.zzs;
                list = zzknVar.zza;
                zzxcVar = zzknVar.zzd;
                zzQ(zzlrVar.zzn(list, zzxcVar), false);
                z = true;
                zzV();
                return z;
            case 18:
                zzkn zzknVar2 = (zzkn) message.obj;
                int i24 = message.arg1;
                this.zzF.zza(1);
                zzlr zzlrVar2 = this.zzs;
                if (i24 == -1) {
                    i24 = zzlrVar2.zza();
                }
                list3 = zzknVar2.zza;
                zzxcVar3 = zzknVar2.zzd;
                zzQ(zzlrVar2.zzk(i24, list3, zzxcVar3), false);
                z = true;
                zzV();
                return z;
            case 19:
                zzko zzkoVar = (zzko) message.obj;
                this.zzF.zza(1);
                zzlr zzlrVar3 = this.zzs;
                int i25 = zzkoVar.zza;
                int i26 = zzkoVar.zzb;
                int i27 = zzkoVar.zzc;
                zzxc zzxcVar4 = zzkoVar.zzd;
                zzQ(zzlrVar3.zzl(0, 0, 0, null), false);
                z = true;
                zzV();
                return z;
            case 20:
                int i28 = message.arg1;
                int i29 = message.arg2;
                zzxc zzxcVar5 = (zzxc) message.obj;
                this.zzF.zza(1);
                zzQ(this.zzs.zzm(i28, i29, zzxcVar5), false);
                z = true;
                zzV();
                return z;
            case 21:
                zzxc zzxcVar6 = (zzxc) message.obj;
                this.zzF.zza(1);
                zzQ(this.zzs.zzo(zzxcVar6), false);
                z = true;
                zzV();
                return z;
            case 22:
                zzQ(this.zzs.zzb(), true);
                z = true;
                zzV();
                return z;
            case 23:
                this.zzH = message.arg1 != 0;
                zzab();
                if (this.zzI) {
                    zzlf zzlfVar7 = this.zzr;
                    if (zzlfVar7.zzn() != zzlfVar7.zzj()) {
                        zzaf(true);
                        zzP(false);
                    }
                }
                z = true;
                zzV();
                return z;
            case 24:
            default:
                return false;
            case 25:
                zzZ();
                z = true;
                zzV();
                return z;
            case 26:
                zzZ();
                z = true;
                zzV();
                return z;
            case 27:
                int i30 = message.arg1;
                int i31 = message.arg2;
                List list4 = (List) message.obj;
                this.zzF.zza(1);
                zzQ(this.zzs.zzc(i30, i31, list4), false);
                z = true;
                zzV();
                return z;
            case 28:
                zzix zzixVar = (zzix) message.obj;
                this.zzX = zzixVar;
                this.zzr.zzw(this.zzE.zza, zzixVar);
                z = true;
                zzV();
                return z;
            case 29:
                this.zzF.zza(1);
                zzaa(false, false, false, true);
                this.zzg.zzc(this.zzu);
                zzaj(true != this.zzE.zza.zzo() ? 2 : 4);
                zzaq();
                this.zzs.zzg(this.zzh.zze());
                this.zzi.zzj(2);
                z = true;
                zzV();
                return z;
            case 30:
                Pair pair = (Pair) message.obj;
                Object obj = pair.first;
                zzdm zzdmVar3 = (zzdm) pair.second;
                zzmf[] zzmfVarArr11 = this.zzb;
                for (int i32 = 0; i32 < 2; i32++) {
                    zzmfVarArr11[i32].zzy(obj);
                }
                int i33 = this.zzE.zze;
                if (i33 == 3 || i33 == 2) {
                    this.zzi.zzj(2);
                }
                if (zzdmVar3 != null) {
                    zzdmVar3.zzf();
                }
                z = true;
                zzV();
                return z;
            case 31:
                zze zzeVar2 = (zze) message.obj;
                int i34 = message.arg1;
                this.zze.zzk(zzeVar2);
                zzib zzibVar = this.zzy;
                if (i34 != 0) {
                    zzeVar = zzeVar2;
                }
                zzibVar.zze(zzeVar);
                zzaq();
                z = true;
                zzV();
                return z;
            case 32:
                zzak(((Float) message.obj).floatValue());
                z = true;
                zzV();
                return z;
            case 33:
                int i35 = message.arg1;
                zzls zzlsVar6 = this.zzE;
                zzas(zzlsVar6.zzl, i35, zzlsVar6.zzn, zzlsVar6.zzm);
                z = true;
                zzV();
                return z;
            case 34:
                zzak(this.zzaa);
                z = true;
                zzV();
                return z;
            case 35:
                zzabp zzabpVar = (zzabp) message.obj;
                zzmf[] zzmfVarArr12 = this.zzb;
                for (int i36 = 0; i36 < 2; i36++) {
                    zzmfVarArr12[i36].zzx(zzabpVar);
                }
                z = true;
                zzV();
                return z;
            case 36:
                boolean booleanValue = ((Boolean) message.obj).booleanValue();
                if (!booleanValue) {
                    this.zzC = false;
                    this.zzi.zzg(37);
                    zzkr zzkrVar = this.zzD;
                    if (zzkrVar != null) {
                        zzag(zzkrVar, false);
                        this.zzD = null;
                    }
                }
                this.zzB = booleanValue;
                zzI();
                z = true;
                zzV();
                return z;
            case 37:
                this.zzC = false;
                zzkr zzkrVar2 = this.zzD;
                if (zzkrVar2 != null) {
                    zzag(zzkrVar2, false);
                    this.zzD = null;
                }
                z = true;
                zzV();
                return z;
            case 38:
                this.zzA = (zzmh) message.obj;
                zzI();
                z = true;
                zzV();
                return z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzia
    public final void zza(int i) {
        this.zzi.zzd(33, i, 0).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzia
    public final void zzb(float f) {
        this.zzi.zzj(34);
    }

    @Override // com.google.android.gms.internal.ads.zzik
    public final void zzc(zzbb zzbbVar) {
        this.zzi.zzc(16, zzbbVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzcT(long j, long j2, zzz zzzVar, MediaFormat mediaFormat) {
        if (this.zzC) {
            this.zzi.zzb(37).zza();
        }
    }

    public final Looper zze() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final /* bridge */ /* synthetic */ void zzj(zzxb zzxbVar) {
        this.zzi.zzc(9, (zzvf) zzxbVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzk() {
        zzdt zzdtVar = this.zzi;
        zzdtVar.zzg(2);
        zzdtVar.zzj(22);
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void zzl(zzvf zzvfVar) {
        this.zzi.zzc(8, zzvfVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzm() {
        this.zzi.zzj(10);
    }

    public final void zzn() {
        this.zzi.zzb(29).zza();
    }

    public final void zzo(zzbl zzblVar, int i, long j) {
        this.zzi.zzc(3, new zzkr(zzblVar, i, j)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzp(zzlw zzlwVar) {
        if (!this.zzG && this.zzk.getThread().isAlive()) {
            this.zzi.zzc(14, zzlwVar).zza();
        } else {
            zzea.zzf("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            zzlwVar.zzh(false);
        }
    }

    public final void zzq(zze zzeVar, boolean z) {
        this.zzi.zze(31, 0, 0, zzeVar).zza();
    }

    public final void zzr(boolean z, int i, int i2) {
        this.zzi.zzd(1, z ? 1 : 0, (i2 << 4) | 1).zza();
    }

    public final void zzs(zzmh zzmhVar) {
        this.zzi.zzc(38, zzmhVar).zza();
    }

    public final void zzt(float f) {
        this.zzi.zzc(32, Float.valueOf(f)).zza();
    }

    public final void zzu() {
        this.zzi.zzb(6).zza();
    }

    public final boolean zzw() {
        if (this.zzG || !this.zzk.getThread().isAlive()) {
            return true;
        }
        this.zzG = true;
        zzdm zzdmVar = new zzdm(this.zzq);
        this.zzi.zzc(7, zzdmVar).zza();
        return zzdmVar.zzc(this.zzt);
    }

    public final boolean zzx(Object obj, long j) {
        if (this.zzG || !this.zzk.getThread().isAlive()) {
            return true;
        }
        zzdm zzdmVar = new zzdm(this.zzq);
        this.zzi.zzc(30, new Pair(obj, zzdmVar)).zza();
        if (j != -9223372036854775807L) {
            return zzdmVar.zzc(j);
        }
        return true;
    }

    public final void zzy(List list, int i, long j, zzxc zzxcVar) {
        this.zzi.zzc(17, new zzkn(list, zzxcVar, i, j, null)).zza();
    }
}
