package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzkh extends zzg implements zziy {
    public static final /* synthetic */ int zzd = 0;
    private final zzdi zzA;
    private int zzB;
    private int zzC;
    private boolean zzD;
    private zzmh zzE;
    private zzmi zzF;
    private zzix zzG;
    private zzbd zzH;
    private zzat zzI;
    private Object zzJ;
    private Surface zzK;
    private int zzL;
    private zzeo zzM;
    private zze zzN;
    private float zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private int zzS;
    private zzat zzT;
    private zzls zzU;
    private int zzV;
    private long zzW;
    private final zzjj zzX;
    private zzxc zzY;
    final zzze zzb;
    final zzbd zzc;
    private final zzdm zze = new zzdm(zzdj.zza);
    private final Context zzf;
    private final zzbh zzg;
    private final zzma[] zzh;
    private final zzma[] zzi;
    private final zzzd zzj;
    private final zzdt zzk;
    private final zzkt zzl;
    private final zzdz zzm;
    private final CopyOnWriteArraySet zzn;
    private final zzbj zzo;
    private final List zzp;
    private final boolean zzq;
    private final zzmo zzr;
    private final Looper zzs;
    private final zzzl zzt;
    private final zzdj zzu;
    private final zzkd zzv;
    private final zzke zzw;
    private final zzmm zzx;
    private final zzmn zzy;
    private final long zzz;

    static {
        zzaq.zzb("media3.exoplayer");
    }

    public zzkh(zziw zziwVar, zzbh zzbhVar) {
        try {
            zzea.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0-alpha01] [" + zzex.zza + C3040d4.i.e);
            this.zzf = zziwVar.zza.getApplicationContext();
            this.zzr = (zzmo) zziwVar.zzh.apply(zziwVar.zzb);
            this.zzS = zziwVar.zzj;
            this.zzN = zziwVar.zzk;
            this.zzL = zziwVar.zzl;
            this.zzP = false;
            this.zzz = zziwVar.zzq;
            zzkg zzkgVar = null;
            zzkd zzkdVar = new zzkd(this, zzkgVar);
            this.zzv = zzkdVar;
            this.zzw = new zzke(zzkgVar);
            Handler handler = new Handler(zziwVar.zzi);
            zzcem zzcemVar = ((zzip) zziwVar.zzc).zza;
            zzcem zzcemVar2 = zzcemVar;
            zzma[] zzac = zzceo.zzac(zzcemVar.zza, handler, zzkdVar, zzkdVar, zzkdVar, zzkdVar);
            this.zzh = zzac;
            int length = zzac.length;
            this.zzi = new zzma[2];
            int i = 0;
            while (true) {
                zzma[] zzmaVarArr = this.zzi;
                int length2 = zzmaVarArr.length;
                if (i >= 2) {
                    break;
                }
                zzma zzmaVar = this.zzh[i];
                zzmaVarArr[i] = null;
                i++;
            }
            zzzd zzzdVar = (zzzd) zziwVar.zze.zza();
            this.zzj = zzzdVar;
            zziw.zza(((zziq) zziwVar.zzd).zza);
            zzzp zzh = zzzp.zzh(((zzit) zziwVar.zzg).zza);
            this.zzt = zzh;
            this.zzq = zziwVar.zzm;
            this.zzF = zziwVar.zzn;
            this.zzE = zziwVar.zzo;
            Looper looper = zziwVar.zzi;
            this.zzs = looper;
            zzdj zzdjVar = zziwVar.zzb;
            this.zzu = zzdjVar;
            this.zzg = zzbhVar;
            zzdz zzdzVar = new zzdz(looper, zzdjVar, new zzdx(this) { // from class: com.google.android.gms.internal.ads.zzji
                @Override // com.google.android.gms.internal.ads.zzdx
                public final void zza(Object obj, zzv zzvVar) {
                }
            });
            this.zzm = zzdzVar;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzn = copyOnWriteArraySet;
            this.zzp = new ArrayList();
            this.zzY = new zzxc(0);
            this.zzG = zzix.zza;
            int length3 = this.zzh.length;
            zzze zzzeVar = new zzze(new zzme[2], new zzyw[2], zzbt.zza, null);
            this.zzb = zzzeVar;
            this.zzo = new zzbj();
            zzbc zzbcVar = new zzbc();
            zzbcVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzzdVar.zzn();
            zzbcVar.zzd(29, true);
            zzbcVar.zzd(23, false);
            zzbcVar.zzd(25, false);
            zzbcVar.zzd(33, false);
            zzbcVar.zzd(26, false);
            zzbcVar.zzd(34, false);
            zzbd zze = zzbcVar.zze();
            this.zzc = zze;
            zzbc zzbcVar2 = new zzbc();
            zzbcVar2.zzb(zze);
            zzbcVar2.zza(4);
            zzbcVar2.zza(10);
            this.zzH = zzbcVar2.zze();
            this.zzk = zzdjVar.zzd(looper, null);
            zzjj zzjjVar = new zzjj(this);
            this.zzX = zzjjVar;
            this.zzU = zzls.zzh(zzzeVar);
            this.zzr.zzT(zzbhVar, looper);
            final zzph zzphVar = new zzph(zziwVar.zzt);
            zzkt zzktVar = new zzkt(this.zzf, this.zzh, this.zzi, zzzdVar, zzzeVar, (zzkx) zziwVar.zzf.zza(), zzh, 0, false, this.zzr, this.zzF, zziwVar.zzu, zziwVar.zzp, false, false, looper, zzdjVar, zzjjVar, zzphVar, null, this.zzG, this.zzw);
            this.zzl = zzktVar;
            Looper zze2 = zzktVar.zze();
            this.zzO = 1.0f;
            zzat zzatVar = zzat.zza;
            this.zzI = zzatVar;
            this.zzT = zzatVar;
            this.zzV = -1;
            int i2 = zzcw.zza;
            this.zzQ = true;
            zzmo zzmoVar = this.zzr;
            if (zzmoVar == null) {
                throw null;
            }
            zzdzVar.zzb(zzmoVar);
            zzh.zzf(new Handler(looper), this.zzr);
            copyOnWriteArraySet.add(this.zzv);
            if (Build.VERSION.SDK_INT >= 31) {
                final Context context = this.zzf;
                final boolean z = zziwVar.zzr;
                zzdjVar.zzd(zzktVar.zze(), null).zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjx
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzpd zzb = zzpd.zzb(context);
                        if (zzb == null) {
                            zzea.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
                            return;
                        }
                        if (z) {
                            this.zzz(zzb);
                        }
                        zzphVar.zzb(zzb.zza());
                    }
                });
            }
            zzdi zzdiVar = new zzdi(0, zze2, looper, zzdjVar, new zzjk(this));
            this.zzA = zzdiVar;
            zzdiVar.zzd(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjl
                @Override // java.lang.Runnable
                public final void run() {
                    zzkh.zzJ(zzkh.this);
                }
            });
            new zzhx(zziwVar.zza, zze2, zziwVar.zzi, this.zzv, zzdjVar);
            this.zzx = new zzmm(zziwVar.zza, zze2, zzdjVar);
            this.zzy = new zzmn(zziwVar.zza, zze2, zzdjVar);
            int i3 = zzo.zza;
            zzcd zzcdVar = zzcd.zza;
            this.zzM = zzeo.zza;
            zzktVar.zzs(this.zzE);
            zzktVar.zzq(this.zzN, false);
            zzad(1, 3, this.zzN);
            zzad(2, 4, Integer.valueOf(this.zzL));
            zzad(2, 5, 0);
            zzad(1, 9, Boolean.valueOf(this.zzP));
            zzad(6, 8, this.zzw);
            zzad(-1, 16, Integer.valueOf(this.zzS));
        } finally {
            this.zze.zzf();
        }
    }

    public static /* synthetic */ void zzJ(zzkh zzkhVar) {
        String str = zzex.zza;
        zzkhVar.zzA.zze(Integer.valueOf(zzcj.zzc(zzkhVar.zzf).generateAudioSessionId()));
    }

    public static /* synthetic */ void zzK(zzkh zzkhVar, zzkq zzkqVar) {
        boolean z;
        int i = zzkhVar.zzB - zzkqVar.zzb;
        zzkhVar.zzB = i;
        boolean z2 = true;
        if (zzkqVar.zzc) {
            zzkhVar.zzC = zzkqVar.zzd;
            zzkhVar.zzD = true;
        }
        if (i == 0) {
            zzbl zzblVar = zzkqVar.zza.zza;
            if (!zzkhVar.zzU.zza.zzo() && zzblVar.zzo()) {
                zzkhVar.zzV = -1;
                zzkhVar.zzW = 0L;
            }
            if (!zzblVar.zzo()) {
                List zzw = ((zzly) zzblVar).zzw();
                int size = zzw.size();
                List list = zzkhVar.zzp;
                zzdd.zzf(size == list.size());
                for (int i2 = 0; i2 < zzw.size(); i2++) {
                    ((zzkf) list.get(i2)).zzc((zzbl) zzw.get(i2));
                }
            }
            long j = -9223372036854775807L;
            if (zzkhVar.zzD) {
                if (zzkqVar.zza.zzb.equals(zzkhVar.zzU.zzb) && zzkqVar.zza.zzd == zzkhVar.zzU.zzs) {
                    z2 = false;
                }
                if (z2) {
                    if (zzblVar.zzo() || zzkqVar.zza.zzb.zzb()) {
                        j = zzkqVar.zza.zzd;
                    } else {
                        zzls zzlsVar = zzkqVar.zza;
                        zzvh zzvhVar = zzlsVar.zzb;
                        long j2 = zzlsVar.zzd;
                        zzkhVar.zzW(zzblVar, zzvhVar, j2);
                        j = j2;
                    }
                }
                z = z2;
            } else {
                z = false;
            }
            zzkhVar.zzD = false;
            zzkhVar.zzag(zzkqVar.zza, 1, z, zzkhVar.zzC, j, -1, false);
        }
    }

    public static /* synthetic */ void zzL(zzkh zzkhVar, int i, final int i2) {
        zzkhVar.zzai();
        Integer valueOf = Integer.valueOf(i2);
        zzkhVar.zzad(1, 10, valueOf);
        zzkhVar.zzad(2, 10, valueOf);
        zzdw zzdwVar = new zzdw() { // from class: com.google.android.gms.internal.ads.zzjm
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i3 = zzkh.zzd;
                ((zzbe) obj).zza(i2);
            }
        };
        zzdz zzdzVar = zzkhVar.zzm;
        zzdzVar.zzd(21, zzdwVar);
        zzdzVar.zzc();
    }

    static /* bridge */ /* synthetic */ void zzP(zzkh zzkhVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzkhVar.zzae(surface);
        zzkhVar.zzK = surface;
    }

    private final int zzS(zzls zzlsVar) {
        zzbl zzblVar = zzlsVar.zza;
        return zzblVar.zzo() ? this.zzV : zzblVar.zzn(zzlsVar.zzb.zza, this.zzo).zzc;
    }

    private final long zzT(zzls zzlsVar) {
        zzvh zzvhVar = zzlsVar.zzb;
        if (!zzvhVar.zzb()) {
            return zzex.zzv(zzU(zzlsVar));
        }
        zzbl zzblVar = zzlsVar.zza;
        zzblVar.zzn(zzvhVar.zza, this.zzo);
        long j = zzlsVar.zzc;
        if (j != -9223372036854775807L) {
            return zzex.zzv(0L) + zzex.zzv(j);
        }
        long j2 = zzblVar.zze(zzS(zzlsVar), this.zza, 0L).zzl;
        return zzex.zzv(0L);
    }

    private final long zzU(zzls zzlsVar) {
        zzbl zzblVar = zzlsVar.zza;
        if (zzblVar.zzo()) {
            return zzex.zzs(this.zzW);
        }
        boolean z = zzlsVar.zzp;
        long j = zzlsVar.zzs;
        zzvh zzvhVar = zzlsVar.zzb;
        if (zzvhVar.zzb()) {
            return j;
        }
        zzW(zzblVar, zzvhVar, j);
        return j;
    }

    private static long zzV(zzls zzlsVar) {
        zzbk zzbkVar = new zzbk();
        zzbj zzbjVar = new zzbj();
        zzbl zzblVar = zzlsVar.zza;
        zzblVar.zzn(zzlsVar.zzb.zza, zzbjVar);
        long j = zzlsVar.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzblVar.zze(zzbjVar.zzc, zzbkVar, 0L).zzl;
        return 0L;
    }

    private final long zzW(zzbl zzblVar, zzvh zzvhVar, long j) {
        zzblVar.zzn(zzvhVar.zza, this.zzo);
        return j;
    }

    private final Pair zzX(zzbl zzblVar, int i, long j) {
        if (zzblVar.zzo()) {
            this.zzV = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzW = j;
            return null;
        }
        if (i == -1 || i >= zzblVar.zzc()) {
            i = zzblVar.zzg(false);
            long j2 = zzblVar.zze(i, this.zza, 0L).zzl;
            j = zzex.zzv(0L);
        }
        return zzblVar.zzl(this.zza, this.zzo, i, zzex.zzs(j));
    }

    private static zzls zzY(zzls zzlsVar, int i) {
        zzls zzf = zzlsVar.zzf(i);
        return (i == 1 || i == 4) ? zzf.zza(false) : zzf;
    }

    private final zzls zzZ(zzls zzlsVar, zzbl zzblVar, Pair pair) {
        zzdd.zzd(zzblVar.zzo() || pair != null);
        zzbl zzblVar2 = zzlsVar.zza;
        long zzT = zzT(zzlsVar);
        zzls zzg = zzlsVar.zzg(zzblVar);
        if (zzblVar.zzo()) {
            zzvh zzi = zzls.zzi();
            long zzs = zzex.zzs(this.zzW);
            zzls zzb = zzg.zzc(zzi, zzs, zzs, zzs, 0L, zzxk.zza, this.zzb, zzfyq.zzn()).zzb(zzi);
            zzb.zzq = zzb.zzs;
            return zzb;
        }
        zzvh zzvhVar = zzg.zzb;
        Object obj = zzvhVar.zza;
        String str = zzex.zza;
        boolean equals = obj.equals(pair.first);
        zzvh zzvhVar2 = !equals ? new zzvh(pair.first, -1L) : zzvhVar;
        long longValue = ((Long) pair.second).longValue();
        long zzs2 = zzex.zzs(zzT);
        if (!zzblVar2.zzo()) {
            zzblVar2.zzn(obj, this.zzo);
        }
        if (!equals || longValue < zzs2) {
            zzvh zzvhVar3 = zzvhVar2;
            zzdd.zzf(!zzvhVar3.zzb());
            zzls zzb2 = zzg.zzc(zzvhVar3, longValue, longValue, longValue, 0L, !equals ? zzxk.zza : zzg.zzh, !equals ? this.zzb : zzg.zzi, !equals ? zzfyq.zzn() : zzg.zzj).zzb(zzvhVar3);
            zzb2.zzq = longValue;
            return zzb2;
        }
        if (longValue != zzs2) {
            zzvh zzvhVar4 = zzvhVar2;
            zzdd.zzf(!zzvhVar4.zzb());
            long max = Math.max(0L, zzg.zzr - (longValue - zzs2));
            long j = zzg.zzq;
            if (zzg.zzk.equals(zzvhVar)) {
                j = longValue + max;
            }
            zzls zzc = zzg.zzc(zzvhVar4, longValue, longValue, longValue, max, zzg.zzh, zzg.zzi, zzg.zzj);
            zzc.zzq = j;
            return zzc;
        }
        int zza = zzblVar.zza(zzg.zzk.zza);
        if (zza != -1) {
            zzbj zzbjVar = this.zzo;
            if (zzblVar.zzd(zza, zzbjVar, false).zzc == zzblVar.zzn(zzvhVar2.zza, zzbjVar).zzc) {
                return zzg;
            }
        }
        Object obj2 = zzvhVar2.zza;
        zzbj zzbjVar2 = this.zzo;
        zzblVar.zzn(obj2, zzbjVar2);
        long zzf = zzvhVar2.zzb() ? zzbjVar2.zzf(zzvhVar2.zzb, zzvhVar2.zzc) : zzbjVar2.zzd;
        zzvh zzvhVar5 = zzvhVar2;
        zzls zzb3 = zzg.zzc(zzvhVar5, zzg.zzs, zzg.zzs, zzg.zzd, zzf - zzg.zzs, zzg.zzh, zzg.zzi, zzg.zzj).zzb(zzvhVar5);
        zzb3.zzq = zzf;
        return zzb3;
    }

    private final zzlw zzaa(zzlv zzlvVar) {
        int zzS = zzS(this.zzU);
        zzbl zzblVar = this.zzU.zza;
        if (zzS == -1) {
            zzS = 0;
        }
        zzdj zzdjVar = this.zzu;
        zzkt zzktVar = this.zzl;
        return new zzlw(zzktVar, zzlvVar, zzblVar, zzS, zzdjVar, zzktVar.zze());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ void zzab(final zzkq zzkqVar) {
        this.zzk.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjo
            @Override // java.lang.Runnable
            public final void run() {
                zzkh.zzK(zzkh.this, zzkqVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzac(final int i, final int i2) {
        if (i == this.zzM.zzb() && i2 == this.zzM.zza()) {
            return;
        }
        this.zzM = new zzeo(i, i2);
        zzdz zzdzVar = this.zzm;
        zzdzVar.zzd(24, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjf
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i3 = zzkh.zzd;
                ((zzbe) obj).zzp(i, i2);
            }
        });
        zzdzVar.zzc();
        zzad(2, 14, new zzeo(i, i2));
    }

    private final void zzad(int i, int i2, Object obj) {
        zzma[] zzmaVarArr = this.zzh;
        int length = zzmaVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzma zzmaVar = zzmaVarArr[i3];
            if (i == -1 || zzmaVar.zzb() == i) {
                zzlw zzaa = zzaa(zzmaVar);
                zzaa.zzf(i2);
                zzaa.zze(obj);
                zzaa.zzd();
            }
        }
        zzma[] zzmaVarArr2 = this.zzi;
        int length2 = zzmaVarArr2.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzma zzmaVar2 = zzmaVarArr2[i4];
            if (zzmaVar2 != null && (i == -1 || zzmaVar2.zzb() == i)) {
                zzlw zzaa2 = zzaa(zzmaVar2);
                zzaa2.zzf(i2);
                zzaa2.zze(obj);
                zzaa2.zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzae(Object obj) {
        Object obj2 = this.zzJ;
        boolean z = false;
        if (obj2 != null && obj2 != obj) {
            z = true;
        }
        boolean zzx = this.zzl.zzx(obj, z ? this.zzz : -9223372036854775807L);
        if (z) {
            Object obj3 = this.zzJ;
            Surface surface = this.zzK;
            if (obj3 == surface) {
                surface.release();
                this.zzK = null;
            }
        }
        this.zzJ = obj;
        if (zzx) {
            return;
        }
        zzaf(zzin.zzd(new zzku(3), 1003));
    }

    private final void zzaf(zzin zzinVar) {
        zzls zzlsVar = this.zzU;
        zzls zzb = zzlsVar.zzb(zzlsVar.zzb);
        zzb.zzq = zzb.zzs;
        zzb.zzr = 0L;
        zzls zzY = zzY(zzb, 1);
        if (zzinVar != null) {
            zzY = zzY.zze(zzinVar);
        }
        this.zzB++;
        this.zzl.zzu();
        zzag(zzY, 0, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x046d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0477 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0481 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0492 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x049e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00ed  */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzag(final zzls zzlsVar, final int i, boolean z, int i2, long j, int i3, boolean z2) {
        int i4;
        zzls zzlsVar2;
        zzbl zzblVar;
        final int i5;
        boolean z3;
        Pair pair;
        boolean z4;
        boolean z5;
        int i6;
        boolean booleanValue;
        final zzap zzapVar;
        List list;
        int i7;
        zzbl zzo;
        zzat zzw;
        int i8;
        int i9;
        int i10;
        boolean z6;
        zzin zzinVar;
        zzin zzinVar2;
        zzze zzzeVar;
        zzze zzzeVar2;
        zzg zzgVar;
        zzbl zzo2;
        zzbd zzbdVar;
        boolean z7;
        zzbl zzo3;
        ?? r15;
        int i11;
        boolean z8;
        zzbl zzo4;
        boolean z9;
        zzbl zzo5;
        zzbh zzbhVar;
        long j2;
        boolean z10;
        int i12;
        boolean z11;
        zzbd zze;
        int i13;
        Object obj;
        zzap zzapVar2;
        Object obj2;
        int i14;
        long j3;
        long zzV;
        Object obj3;
        zzap zzapVar3;
        Object obj4;
        int i15;
        int i16 = i2;
        zzls zzlsVar3 = this.zzU;
        this.zzU = zzlsVar;
        zzbl zzblVar2 = zzlsVar3.zza;
        zzbl zzblVar3 = zzlsVar.zza;
        boolean equals = zzblVar2.equals(zzblVar3);
        if (zzblVar3.zzo() && zzblVar2.zzo()) {
            pair = new Pair(false, -1);
        } else {
            if (zzblVar3.zzo() == zzblVar2.zzo()) {
                zzvh zzvhVar = zzlsVar3.zzb;
                Object obj5 = zzvhVar.zza;
                i4 = 0;
                zzbj zzbjVar = this.zzo;
                int i17 = zzblVar2.zzn(obj5, zzbjVar).zzc;
                zzbk zzbkVar = this.zza;
                Object obj6 = zzblVar2.zze(i17, zzbkVar, 0L).zzb;
                zzvh zzvhVar2 = zzlsVar.zzb;
                zzlsVar2 = zzlsVar3;
                zzblVar = zzblVar2;
                if (obj6.equals(zzblVar3.zze(zzblVar3.zzn(zzvhVar2.zza, zzbjVar).zzc, zzbkVar, 0L).zzb)) {
                    if (z) {
                        if (i16 != 0) {
                            i5 = i16;
                        } else if (zzvhVar.zzd < zzvhVar2.zzd) {
                            pair = new Pair(true, 0);
                            i5 = 0;
                            z3 = true;
                        } else {
                            i5 = 0;
                        }
                        z3 = true;
                    } else {
                        i5 = i16;
                        z3 = false;
                    }
                    pair = new Pair(false, -1);
                } else {
                    if (!z) {
                        z4 = false;
                        z5 = false;
                    } else if (i16 == 0) {
                        i16 = 0;
                        z4 = true;
                        i6 = 1;
                        Pair pair2 = new Pair(true, Integer.valueOf(i6));
                        boolean z12 = z4;
                        i5 = i16;
                        z3 = z12;
                        pair = pair2;
                    } else {
                        z4 = true;
                        z5 = true;
                    }
                    if (z4 && i16 == 1) {
                        z4 = z5;
                        i6 = 2;
                    } else {
                        if (equals) {
                            throw new IllegalStateException();
                        }
                        i6 = 3;
                    }
                    Pair pair22 = new Pair(true, Integer.valueOf(i6));
                    boolean z122 = z4;
                    i5 = i16;
                    z3 = z122;
                    pair = pair22;
                }
                booleanValue = ((Boolean) pair.first).booleanValue();
                final int intValue = ((Integer) pair.second).intValue();
                if (booleanValue) {
                    zzapVar = null;
                } else {
                    zzapVar = !zzblVar3.zzo() ? zzblVar3.zze(zzblVar3.zzn(zzlsVar.zzb.zza, this.zzo).zzc, this.zza, 0L).zzd : null;
                    this.zzT = zzat.zza;
                }
                if (!booleanValue || !zzlsVar2.zzj.equals(zzlsVar.zzj)) {
                    zzar zza = this.zzT.zza();
                    list = zzlsVar.zzj;
                    for (i7 = i4; i7 < list.size(); i7++) {
                        zzav zzavVar = (zzav) list.get(i7);
                        for (int i18 = i4; i18 < zzavVar.zza(); i18++) {
                            zzavVar.zzb(i18).zza(zza);
                        }
                    }
                    this.zzT = zza.zzw();
                }
                zzo = zzo();
                if (zzo.zzo()) {
                    zzap zzapVar4 = zzo.zze(zze(), this.zza, 0L).zzd;
                    zzar zza2 = this.zzT.zza();
                    zza2.zzb(zzapVar4.zzd);
                    zzw = zza2.zzw();
                } else {
                    zzw = this.zzT;
                }
                boolean equals2 = zzw.equals(this.zzI);
                this.zzI = zzw;
                int i19 = zzlsVar2.zzl == zzlsVar.zzl ? 1 : i4;
                i8 = zzlsVar2.zze == zzlsVar.zze ? 1 : i4;
                if (i8 == 0 || i19 != 0) {
                    zzah();
                }
                i9 = zzlsVar2.zzg == zzlsVar.zzg ? 1 : i4;
                if (!equals) {
                    this.zzm.zzd(i4, new zzdw() { // from class: com.google.android.gms.internal.ads.zziz
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj7) {
                            int i20 = zzkh.zzd;
                            ((zzbe) obj7).zzq(zzls.this.zza, i);
                        }
                    });
                }
                if (z3) {
                    i10 = i19;
                    z6 = equals2;
                } else {
                    zzbj zzbjVar2 = new zzbj();
                    if (zzblVar.zzo()) {
                        i10 = i19;
                        z6 = equals2;
                        i13 = i3;
                        obj = null;
                        zzapVar2 = null;
                        obj2 = null;
                        i14 = -1;
                    } else {
                        Object obj7 = zzlsVar2.zzb.zza;
                        zzbl zzblVar4 = zzblVar;
                        zzblVar4.zzn(obj7, zzbjVar2);
                        int i20 = zzbjVar2.zzc;
                        int zza3 = zzblVar4.zza(obj7);
                        zzbk zzbkVar2 = this.zza;
                        i10 = i19;
                        z6 = equals2;
                        Object obj8 = zzblVar4.zze(i20, zzbkVar2, 0L).zzb;
                        zzapVar2 = zzbkVar2.zzd;
                        i13 = i20;
                        obj = obj8;
                        obj2 = obj7;
                        i14 = zza3;
                    }
                    if (i5 == 0) {
                        zzvh zzvhVar3 = zzlsVar2.zzb;
                        if (zzvhVar3.zzb()) {
                            j3 = zzbjVar2.zzf(zzvhVar3.zzb, zzvhVar3.zzc);
                            zzV = zzV(zzlsVar2);
                            String str = zzex.zza;
                            zzvh zzvhVar4 = zzlsVar2.zzb;
                            final zzbf zzbfVar = new zzbf(obj, i13, zzapVar2, obj2, i14, zzex.zzv(j3), zzex.zzv(zzV), zzvhVar4.zzb, zzvhVar4.zzc);
                            int zze2 = zze();
                            if (this.zzU.zza.zzo()) {
                                zzls zzlsVar4 = this.zzU;
                                Object obj9 = zzlsVar4.zzb.zza;
                                zzlsVar4.zza.zzn(obj9, this.zzo);
                                int zza4 = this.zzU.zza.zza(obj9);
                                zzbl zzblVar5 = this.zzU.zza;
                                zzbk zzbkVar3 = this.zza;
                                i15 = zza4;
                                obj3 = zzblVar5.zze(zze2, zzbkVar3, 0L).zzb;
                                zzapVar3 = zzbkVar3.zzd;
                                obj4 = obj9;
                            } else {
                                obj3 = null;
                                zzapVar3 = null;
                                obj4 = null;
                                i15 = -1;
                            }
                            long zzv = zzex.zzv(j);
                            long zzv2 = !this.zzU.zzb.zzb() ? zzex.zzv(zzV(this.zzU)) : zzv;
                            zzvh zzvhVar5 = this.zzU.zzb;
                            final zzbf zzbfVar2 = new zzbf(obj3, zze2, zzapVar3, obj4, i15, zzv, zzv2, zzvhVar5.zzb, zzvhVar5.zzc);
                            this.zzm.zzd(11, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjs
                                @Override // com.google.android.gms.internal.ads.zzdw
                                public final void zza(Object obj10) {
                                    int i21 = zzkh.zzd;
                                    ((zzbe) obj10).zzn(zzbfVar, zzbfVar2, i5);
                                }
                            });
                        } else {
                            j3 = zzvhVar3.zze != -1 ? zzV(this.zzU) : zzbjVar2.zzd;
                            zzV = j3;
                            String str2 = zzex.zza;
                            zzvh zzvhVar42 = zzlsVar2.zzb;
                            final zzbf zzbfVar3 = new zzbf(obj, i13, zzapVar2, obj2, i14, zzex.zzv(j3), zzex.zzv(zzV), zzvhVar42.zzb, zzvhVar42.zzc);
                            int zze22 = zze();
                            if (this.zzU.zza.zzo()) {
                            }
                            long zzv3 = zzex.zzv(j);
                            if (!this.zzU.zzb.zzb()) {
                            }
                            zzvh zzvhVar52 = this.zzU.zzb;
                            final zzbf zzbfVar22 = new zzbf(obj3, zze22, zzapVar3, obj4, i15, zzv3, zzv2, zzvhVar52.zzb, zzvhVar52.zzc);
                            this.zzm.zzd(11, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjs
                                @Override // com.google.android.gms.internal.ads.zzdw
                                public final void zza(Object obj10) {
                                    int i21 = zzkh.zzd;
                                    ((zzbe) obj10).zzn(zzbfVar3, zzbfVar22, i5);
                                }
                            });
                        }
                    } else if (zzlsVar2.zzb.zzb()) {
                        j3 = zzlsVar2.zzs;
                        zzV = zzV(zzlsVar2);
                        String str22 = zzex.zza;
                        zzvh zzvhVar422 = zzlsVar2.zzb;
                        final zzbf zzbfVar32 = new zzbf(obj, i13, zzapVar2, obj2, i14, zzex.zzv(j3), zzex.zzv(zzV), zzvhVar422.zzb, zzvhVar422.zzc);
                        int zze222 = zze();
                        if (this.zzU.zza.zzo()) {
                        }
                        long zzv32 = zzex.zzv(j);
                        if (!this.zzU.zzb.zzb()) {
                        }
                        zzvh zzvhVar522 = this.zzU.zzb;
                        final zzbf zzbfVar222 = new zzbf(obj3, zze222, zzapVar3, obj4, i15, zzv32, zzv2, zzvhVar522.zzb, zzvhVar522.zzc);
                        this.zzm.zzd(11, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjs
                            @Override // com.google.android.gms.internal.ads.zzdw
                            public final void zza(Object obj10) {
                                int i21 = zzkh.zzd;
                                ((zzbe) obj10).zzn(zzbfVar32, zzbfVar222, i5);
                            }
                        });
                    } else {
                        j3 = zzlsVar2.zzs;
                        zzV = j3;
                        String str222 = zzex.zza;
                        zzvh zzvhVar4222 = zzlsVar2.zzb;
                        final zzbf zzbfVar322 = new zzbf(obj, i13, zzapVar2, obj2, i14, zzex.zzv(j3), zzex.zzv(zzV), zzvhVar4222.zzb, zzvhVar4222.zzc);
                        int zze2222 = zze();
                        if (this.zzU.zza.zzo()) {
                        }
                        long zzv322 = zzex.zzv(j);
                        if (!this.zzU.zzb.zzb()) {
                        }
                        zzvh zzvhVar5222 = this.zzU.zzb;
                        final zzbf zzbfVar2222 = new zzbf(obj3, zze2222, zzapVar3, obj4, i15, zzv322, zzv2, zzvhVar5222.zzb, zzvhVar5222.zzc);
                        this.zzm.zzd(11, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjs
                            @Override // com.google.android.gms.internal.ads.zzdw
                            public final void zza(Object obj10) {
                                int i21 = zzkh.zzd;
                                ((zzbe) obj10).zzn(zzbfVar322, zzbfVar2222, i5);
                            }
                        });
                    }
                }
                if (!booleanValue) {
                    this.zzm.zzd(1, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjt
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            ((zzbe) obj10).zze(zzap.this, intValue);
                        }
                    });
                }
                zzinVar = zzlsVar2.zzf;
                zzinVar2 = zzlsVar.zzf;
                if (zzinVar != zzinVar2) {
                    zzdz zzdzVar = this.zzm;
                    zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzju
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            ((zzbe) obj10).zzl(zzls.this.zzf);
                        }
                    });
                    if (zzinVar2 != null) {
                        zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjv
                            @Override // com.google.android.gms.internal.ads.zzdw
                            public final void zza(Object obj10) {
                                int i21 = zzkh.zzd;
                                ((zzbe) obj10).zzk(zzls.this.zzf);
                            }
                        });
                    }
                }
                zzzeVar = zzlsVar2.zzi;
                zzzeVar2 = zzlsVar.zzi;
                if (zzzeVar != zzzeVar2) {
                    this.zzj.zzp(zzzeVar2.zze);
                    this.zzm.zzd(2, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjw
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            ((zzbe) obj10).zzr(zzls.this.zzi.zzd);
                        }
                    });
                }
                if (!z6) {
                    final zzat zzatVar = this.zzI;
                    this.zzm.zzd(14, new zzdw() { // from class: com.google.android.gms.internal.ads.zzja
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            ((zzbe) obj10).zzf(zzat.this);
                        }
                    });
                }
                if (i9 != 0) {
                    this.zzm.zzd(3, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjb
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            ((zzbe) obj10).zzc(zzls.this.zzg);
                        }
                    });
                }
                if (i8 == 0 || i10 != 0) {
                    this.zzm.zzd(-1, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjc
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            zzls zzlsVar5 = zzls.this;
                            ((zzbe) obj10).zzm(zzlsVar5.zzl, zzlsVar5.zze);
                        }
                    });
                }
                if (i8 != 0) {
                    this.zzm.zzd(4, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjd
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            ((zzbe) obj10).zzi(zzls.this.zze);
                        }
                    });
                }
                if (i10 == 0 || zzlsVar2.zzm != zzlsVar.zzm) {
                    this.zzm.zzd(5, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjh
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            zzls zzlsVar5 = zzls.this;
                            ((zzbe) obj10).zzg(zzlsVar5.zzl, zzlsVar5.zzm);
                        }
                    });
                }
                if (zzlsVar2.zzn != zzlsVar.zzn) {
                    this.zzm.zzd(6, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjn
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            ((zzbe) obj10).zzj(zzls.this.zzn);
                        }
                    });
                }
                if (zzlsVar2.zzj() != zzlsVar.zzj()) {
                    this.zzm.zzd(7, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjq
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            ((zzbe) obj10).zzd(zzls.this.zzj());
                        }
                    });
                }
                if (!zzlsVar2.zzo.equals(zzlsVar.zzo)) {
                    this.zzm.zzd(12, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjr
                        @Override // com.google.android.gms.internal.ads.zzdw
                        public final void zza(Object obj10) {
                            int i21 = zzkh.zzd;
                            ((zzbe) obj10).zzh(zzls.this.zzo);
                        }
                    });
                }
                zzbd zzbdVar2 = this.zzH;
                zzbh zzbhVar2 = this.zzg;
                zzbd zzbdVar3 = this.zzc;
                String str3 = zzex.zza;
                boolean zzx = zzbhVar2.zzx();
                zzgVar = (zzg) zzbhVar2;
                zzo2 = zzgVar.zzo();
                if (zzo2.zzo()) {
                    zzbdVar = zzbdVar2;
                    if (zzo2.zze(zzgVar.zze(), zzgVar.zza, 0L).zzh) {
                        z7 = true;
                        zzo3 = zzgVar.zzo();
                        if (zzo3.zzo()) {
                            i11 = -1;
                            r15 = 0;
                            z8 = false;
                        } else {
                            int zze3 = zzgVar.zze();
                            zzgVar.zzi();
                            zzgVar.zzw();
                            r15 = 0;
                            r15 = 0;
                            int zzk = zzo3.zzk(zze3, 0, false);
                            i11 = -1;
                            z8 = zzk != -1;
                        }
                        zzo4 = zzgVar.zzo();
                        if (!zzo4.zzo()) {
                            int zze4 = zzgVar.zze();
                            zzgVar.zzi();
                            zzgVar.zzw();
                            if (zzo4.zzj(zze4, r15, r15) != i11) {
                                z9 = true;
                                zzo5 = zzgVar.zzo();
                                if (zzo5.zzo()) {
                                    zzbhVar = zzbhVar2;
                                    j2 = 0;
                                    if (zzo5.zze(zzgVar.zze(), zzgVar.zza, 0L).zzb()) {
                                        z10 = true;
                                        zzbl zzo6 = zzgVar.zzo();
                                        boolean z13 = zzo6.zzo() && zzo6.zze(zzgVar.zze(), zzgVar.zza, j2).zzi;
                                        boolean zzo7 = zzbhVar.zzo().zzo();
                                        zzbc zzbcVar = new zzbc();
                                        zzbcVar.zzb(zzbdVar3);
                                        boolean z14 = !zzx;
                                        zzbcVar.zzd(4, z14);
                                        zzbcVar.zzd(5, (z7 || zzx) ? false : true);
                                        zzbcVar.zzd(6, (z8 || zzx) ? false : true);
                                        zzbcVar.zzd(7, zzo7 && (z8 || !z10 || z7) && !zzx);
                                        zzbcVar.zzd(8, (z9 || zzx) ? false : true);
                                        zzbcVar.zzd(9, zzo7 && (z9 || (z10 && z13)) && !zzx);
                                        zzbcVar.zzd(10, z14);
                                        zzbcVar.zzd(11, (z7 || zzx) ? false : true);
                                        if (z7 || zzx) {
                                            i12 = 12;
                                            z11 = false;
                                        } else {
                                            i12 = 12;
                                            z11 = true;
                                        }
                                        zzbcVar.zzd(i12, z11);
                                        zze = zzbcVar.zze();
                                        this.zzH = zze;
                                        if (!zze.equals(zzbdVar)) {
                                            this.zzm.zzd(13, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjp
                                                @Override // com.google.android.gms.internal.ads.zzdw
                                                public final void zza(Object obj10) {
                                                    ((zzbe) obj10).zzb(zzkh.this.zzH);
                                                }
                                            });
                                        }
                                        this.zzm.zzc();
                                        boolean z15 = zzlsVar2.zzp;
                                        boolean z16 = zzlsVar.zzp;
                                    }
                                } else {
                                    zzbhVar = zzbhVar2;
                                    j2 = 0;
                                }
                                z10 = false;
                                zzbl zzo62 = zzgVar.zzo();
                                if (zzo62.zzo()) {
                                }
                                boolean zzo72 = zzbhVar.zzo().zzo();
                                zzbc zzbcVar2 = new zzbc();
                                zzbcVar2.zzb(zzbdVar3);
                                boolean z142 = !zzx;
                                zzbcVar2.zzd(4, z142);
                                zzbcVar2.zzd(5, (z7 || zzx) ? false : true);
                                zzbcVar2.zzd(6, (z8 || zzx) ? false : true);
                                zzbcVar2.zzd(7, zzo72 && (z8 || !z10 || z7) && !zzx);
                                zzbcVar2.zzd(8, (z9 || zzx) ? false : true);
                                zzbcVar2.zzd(9, zzo72 && (z9 || (z10 && z13)) && !zzx);
                                zzbcVar2.zzd(10, z142);
                                zzbcVar2.zzd(11, (z7 || zzx) ? false : true);
                                if (z7) {
                                }
                                i12 = 12;
                                z11 = false;
                                zzbcVar2.zzd(i12, z11);
                                zze = zzbcVar2.zze();
                                this.zzH = zze;
                                if (!zze.equals(zzbdVar)) {
                                }
                                this.zzm.zzc();
                                boolean z152 = zzlsVar2.zzp;
                                boolean z162 = zzlsVar.zzp;
                            }
                        }
                        z9 = r15;
                        zzo5 = zzgVar.zzo();
                        if (zzo5.zzo()) {
                        }
                        z10 = false;
                        zzbl zzo622 = zzgVar.zzo();
                        if (zzo622.zzo()) {
                        }
                        boolean zzo722 = zzbhVar.zzo().zzo();
                        zzbc zzbcVar22 = new zzbc();
                        zzbcVar22.zzb(zzbdVar3);
                        boolean z1422 = !zzx;
                        zzbcVar22.zzd(4, z1422);
                        zzbcVar22.zzd(5, (z7 || zzx) ? false : true);
                        zzbcVar22.zzd(6, (z8 || zzx) ? false : true);
                        zzbcVar22.zzd(7, zzo722 && (z8 || !z10 || z7) && !zzx);
                        zzbcVar22.zzd(8, (z9 || zzx) ? false : true);
                        zzbcVar22.zzd(9, zzo722 && (z9 || (z10 && z13)) && !zzx);
                        zzbcVar22.zzd(10, z1422);
                        zzbcVar22.zzd(11, (z7 || zzx) ? false : true);
                        if (z7) {
                        }
                        i12 = 12;
                        z11 = false;
                        zzbcVar22.zzd(i12, z11);
                        zze = zzbcVar22.zze();
                        this.zzH = zze;
                        if (!zze.equals(zzbdVar)) {
                        }
                        this.zzm.zzc();
                        boolean z1522 = zzlsVar2.zzp;
                        boolean z1622 = zzlsVar.zzp;
                    }
                } else {
                    zzbdVar = zzbdVar2;
                }
                z7 = false;
                zzo3 = zzgVar.zzo();
                if (zzo3.zzo()) {
                }
                zzo4 = zzgVar.zzo();
                if (!zzo4.zzo()) {
                }
                z9 = r15;
                zzo5 = zzgVar.zzo();
                if (zzo5.zzo()) {
                }
                z10 = false;
                zzbl zzo6222 = zzgVar.zzo();
                if (zzo6222.zzo()) {
                }
                boolean zzo7222 = zzbhVar.zzo().zzo();
                zzbc zzbcVar222 = new zzbc();
                zzbcVar222.zzb(zzbdVar3);
                boolean z14222 = !zzx;
                zzbcVar222.zzd(4, z14222);
                zzbcVar222.zzd(5, (z7 || zzx) ? false : true);
                zzbcVar222.zzd(6, (z8 || zzx) ? false : true);
                zzbcVar222.zzd(7, zzo7222 && (z8 || !z10 || z7) && !zzx);
                zzbcVar222.zzd(8, (z9 || zzx) ? false : true);
                zzbcVar222.zzd(9, zzo7222 && (z9 || (z10 && z13)) && !zzx);
                zzbcVar222.zzd(10, z14222);
                zzbcVar222.zzd(11, (z7 || zzx) ? false : true);
                if (z7) {
                }
                i12 = 12;
                z11 = false;
                zzbcVar222.zzd(i12, z11);
                zze = zzbcVar222.zze();
                this.zzH = zze;
                if (!zze.equals(zzbdVar)) {
                }
                this.zzm.zzc();
                boolean z15222 = zzlsVar2.zzp;
                boolean z16222 = zzlsVar.zzp;
            }
            pair = new Pair(true, 3);
        }
        zzlsVar2 = zzlsVar3;
        zzblVar = zzblVar2;
        i4 = 0;
        i5 = i16;
        z3 = z;
        booleanValue = ((Boolean) pair.first).booleanValue();
        final int intValue2 = ((Integer) pair.second).intValue();
        if (booleanValue) {
        }
        if (!booleanValue) {
        }
        zzar zza5 = this.zzT.zza();
        list = zzlsVar.zzj;
        while (i7 < list.size()) {
        }
        this.zzT = zza5.zzw();
        zzo = zzo();
        if (zzo.zzo()) {
        }
        boolean equals22 = zzw.equals(this.zzI);
        this.zzI = zzw;
        if (zzlsVar2.zzl == zzlsVar.zzl) {
        }
        if (zzlsVar2.zze == zzlsVar.zze) {
        }
        if (i8 == 0) {
        }
        zzah();
        if (zzlsVar2.zzg == zzlsVar.zzg) {
        }
        if (!equals) {
        }
        if (z3) {
        }
        if (!booleanValue) {
        }
        zzinVar = zzlsVar2.zzf;
        zzinVar2 = zzlsVar.zzf;
        if (zzinVar != zzinVar2) {
        }
        zzzeVar = zzlsVar2.zzi;
        zzzeVar2 = zzlsVar.zzi;
        if (zzzeVar != zzzeVar2) {
        }
        if (!z6) {
        }
        if (i9 != 0) {
        }
        if (i8 == 0) {
        }
        this.zzm.zzd(-1, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjc
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj10) {
                int i21 = zzkh.zzd;
                zzls zzlsVar5 = zzls.this;
                ((zzbe) obj10).zzm(zzlsVar5.zzl, zzlsVar5.zze);
            }
        });
        if (i8 != 0) {
        }
        if (i10 == 0) {
        }
        this.zzm.zzd(5, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjh
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj10) {
                int i21 = zzkh.zzd;
                zzls zzlsVar5 = zzls.this;
                ((zzbe) obj10).zzg(zzlsVar5.zzl, zzlsVar5.zzm);
            }
        });
        if (zzlsVar2.zzn != zzlsVar.zzn) {
        }
        if (zzlsVar2.zzj() != zzlsVar.zzj()) {
        }
        if (!zzlsVar2.zzo.equals(zzlsVar.zzo)) {
        }
        zzbd zzbdVar22 = this.zzH;
        zzbh zzbhVar22 = this.zzg;
        zzbd zzbdVar32 = this.zzc;
        String str32 = zzex.zza;
        boolean zzx2 = zzbhVar22.zzx();
        zzgVar = (zzg) zzbhVar22;
        zzo2 = zzgVar.zzo();
        if (zzo2.zzo()) {
        }
        z7 = false;
        zzo3 = zzgVar.zzo();
        if (zzo3.zzo()) {
        }
        zzo4 = zzgVar.zzo();
        if (!zzo4.zzo()) {
        }
        z9 = r15;
        zzo5 = zzgVar.zzo();
        if (zzo5.zzo()) {
        }
        z10 = false;
        zzbl zzo62222 = zzgVar.zzo();
        if (zzo62222.zzo()) {
        }
        boolean zzo72222 = zzbhVar.zzo().zzo();
        zzbc zzbcVar2222 = new zzbc();
        zzbcVar2222.zzb(zzbdVar32);
        boolean z142222 = !zzx2;
        zzbcVar2222.zzd(4, z142222);
        zzbcVar2222.zzd(5, (z7 || zzx2) ? false : true);
        zzbcVar2222.zzd(6, (z8 || zzx2) ? false : true);
        zzbcVar2222.zzd(7, zzo72222 && (z8 || !z10 || z7) && !zzx2);
        zzbcVar2222.zzd(8, (z9 || zzx2) ? false : true);
        zzbcVar2222.zzd(9, zzo72222 && (z9 || (z10 && z13)) && !zzx2);
        zzbcVar2222.zzd(10, z142222);
        zzbcVar2222.zzd(11, (z7 || zzx2) ? false : true);
        if (z7) {
        }
        i12 = 12;
        z11 = false;
        zzbcVar2222.zzd(i12, z11);
        zze = zzbcVar2222.zze();
        this.zzH = zze;
        if (!zze.equals(zzbdVar)) {
        }
        this.zzm.zzc();
        boolean z152222 = zzlsVar2.zzp;
        boolean z162222 = zzlsVar.zzp;
    }

    private final void zzah() {
        int zzg = zzg();
        if (zzg != 2 && zzg != 3) {
            this.zzx.zza(false);
            this.zzy.zza(false);
        } else {
            zzai();
            boolean z = this.zzU.zzp;
            this.zzx.zza(zzv());
            this.zzy.zza(zzv());
        }
    }

    private final void zzai() {
        this.zze.zzb();
        Looper looper = this.zzs;
        if (Thread.currentThread() != looper.getThread()) {
            Object[] objArr = {Thread.currentThread().getName(), looper.getThread().getName()};
            String str = zzex.zza;
            String format = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", objArr);
            if (this.zzQ) {
                throw new IllegalStateException(format);
            }
            zzea.zzg("ExoPlayerImpl", format, this.zzR ? null : new IllegalStateException());
            this.zzR = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzA() {
        zzea.zze("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0-alpha01] [" + zzex.zza + "] [" + zzaq.zza() + C3040d4.i.e);
        zzai();
        this.zzx.zza(false);
        this.zzy.zza(false);
        if (!this.zzl.zzw()) {
            zzdz zzdzVar = this.zzm;
            zzdzVar.zzd(10, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjg
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj) {
                    int i = zzkh.zzd;
                    ((zzbe) obj).zzk(zzin.zzd(new zzku(1), 1003));
                }
            });
            zzdzVar.zzc();
        }
        this.zzm.zze();
        this.zzk.zzf(null);
        zzzl zzzlVar = this.zzt;
        zzmo zzmoVar = this.zzr;
        zzzlVar.zzg(zzmoVar);
        boolean z = this.zzU.zzp;
        zzls zzY = zzY(this.zzU, 1);
        this.zzU = zzY;
        zzls zzb = zzY.zzb(zzY.zzb);
        this.zzU = zzb;
        zzb.zzq = zzb.zzs;
        this.zzU.zzr = 0L;
        zzmoVar.zzR();
        Surface surface = this.zzK;
        if (surface != null) {
            surface.release();
            this.zzK = null;
        }
        int i = zzcw.zza;
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzB(zzmr zzmrVar) {
        zzai();
        this.zzr.zzS(zzmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzC(zzvj zzvjVar) {
        zzai();
        List singletonList = Collections.singletonList(zzvjVar);
        zzai();
        zzai();
        zzS(this.zzU);
        zzl();
        this.zzB++;
        List list = this.zzp;
        if (!list.isEmpty()) {
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                list.remove(i);
            }
            this.zzY = this.zzY.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < singletonList.size(); i2++) {
            zzlp zzlpVar = new zzlp((zzvj) singletonList.get(i2), this.zzq);
            arrayList.add(zzlpVar);
            list.add(i2, new zzkf(zzlpVar.zzb, zzlpVar.zza));
        }
        this.zzY = this.zzY.zzg(0, arrayList.size());
        zzly zzlyVar = new zzly(list, this.zzY);
        if (!zzlyVar.zzo() && zzlyVar.zzc() < 0) {
            throw new zzaa(zzlyVar, -1, -9223372036854775807L);
        }
        int zzg = zzlyVar.zzg(false);
        zzls zzZ = zzZ(this.zzU, zzlyVar, zzX(zzlyVar, zzg, -9223372036854775807L));
        int i3 = zzZ.zze;
        if (zzg != -1 && i3 != 1) {
            i3 = 4;
            if (!zzlyVar.zzo() && zzg < zzlyVar.zzc()) {
                i3 = 2;
            }
        }
        zzls zzY = zzY(zzZ, i3);
        this.zzl.zzy(arrayList, zzg, zzex.zzs(-9223372036854775807L), this.zzY);
        zzag(zzY, 0, (this.zzU.zzb.zza.equals(zzY.zzb.zza) || this.zzU.zza.zzo()) ? false : true, 4, zzU(zzY), -1, false);
    }

    public final zzin zzF() {
        zzai();
        return this.zzU.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzg
    protected final void zzb(int i, long j, int i2, boolean z) {
        zzai();
        if (i == -1) {
            return;
        }
        zzdd.zzd(i >= 0);
        zzbl zzblVar = this.zzU.zza;
        if (zzblVar.zzo() || i < zzblVar.zzc()) {
            this.zzr.zzv();
            this.zzB++;
            if (zzx()) {
                zzea.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzkq zzkqVar = new zzkq(this.zzU);
                zzkqVar.zza(1);
                this.zzX.zza.zzab(zzkqVar);
                return;
            }
            zzls zzlsVar = this.zzU;
            int i3 = zzlsVar.zze;
            if (i3 == 3 || (i3 == 4 && !zzblVar.zzo())) {
                zzlsVar = zzY(this.zzU, 2);
            }
            int zze = zze();
            zzls zzZ = zzZ(zzlsVar, zzblVar, zzX(zzblVar, i, j));
            this.zzl.zzo(zzblVar, i, zzex.zzs(j));
            zzag(zzZ, 0, true, 1, zzU(zzZ), zze, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzc() {
        zzai();
        if (zzx()) {
            return this.zzU.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzd() {
        zzai();
        if (zzx()) {
            return this.zzU.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zze() {
        zzai();
        int zzS = zzS(this.zzU);
        if (zzS == -1) {
            return 0;
        }
        return zzS;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzf() {
        zzai();
        if (this.zzU.zza.zzo()) {
            return 0;
        }
        zzls zzlsVar = this.zzU;
        return zzlsVar.zza.zza(zzlsVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzg() {
        zzai();
        return this.zzU.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzh() {
        zzai();
        return this.zzU.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final int zzi() {
        zzai();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzj() {
        zzai();
        if (zzx()) {
            zzls zzlsVar = this.zzU;
            return zzlsVar.zzk.equals(zzlsVar.zzb) ? zzex.zzv(this.zzU.zzq) : zzm();
        }
        zzai();
        if (this.zzU.zza.zzo()) {
            return this.zzW;
        }
        zzls zzlsVar2 = this.zzU;
        long j = 0;
        if (zzlsVar2.zzk.zzd != zzlsVar2.zzb.zzd) {
            return zzex.zzv(zzlsVar2.zza.zze(zze(), this.zza, 0L).zzm);
        }
        long j2 = zzlsVar2.zzq;
        if (this.zzU.zzk.zzb()) {
            zzls zzlsVar3 = this.zzU;
            zzlsVar3.zza.zzn(zzlsVar3.zzk.zza, this.zzo).zzg(this.zzU.zzk.zzb);
        } else {
            j = j2;
        }
        zzls zzlsVar4 = this.zzU;
        zzW(zzlsVar4.zza, zzlsVar4.zzk, j);
        return zzex.zzv(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzk() {
        zzai();
        return zzT(this.zzU);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzl() {
        zzai();
        return zzex.zzv(zzU(this.zzU));
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzm() {
        zzai();
        if (!zzx()) {
            zzbl zzo = zzo();
            if (zzo.zzo()) {
                return -9223372036854775807L;
            }
            return zzex.zzv(zzo.zze(zze(), this.zza, 0L).zzm);
        }
        zzls zzlsVar = this.zzU;
        zzvh zzvhVar = zzlsVar.zzb;
        zzbl zzblVar = zzlsVar.zza;
        Object obj = zzvhVar.zza;
        zzbj zzbjVar = this.zzo;
        zzblVar.zzn(obj, zzbjVar);
        return zzex.zzv(zzbjVar.zzf(zzvhVar.zzb, zzvhVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final long zzn() {
        zzai();
        return zzex.zzv(this.zzU.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final zzbl zzo() {
        zzai();
        return this.zzU.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final zzbt zzp() {
        zzai();
        return this.zzU.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzq() {
        zzai();
        zzls zzlsVar = this.zzU;
        if (zzlsVar.zze != 1) {
            return;
        }
        zzls zze = zzlsVar.zze(null);
        zzls zzY = zzY(zze, true != zze.zza.zzo() ? 2 : 4);
        this.zzB++;
        this.zzl.zzn();
        zzag(zzY, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzr(boolean z) {
        zzai();
        zzls zzlsVar = this.zzU;
        int i = zzlsVar.zzn;
        int i2 = 0;
        if (i == 1) {
            if (z) {
                i = 1;
            } else {
                i = 1;
                i2 = 1;
            }
        }
        if (zzlsVar.zzl == z && i == i2 && zzlsVar.zzm == 1) {
            return;
        }
        this.zzB++;
        boolean z2 = zzlsVar.zzp;
        zzls zzd2 = zzlsVar.zzd(z, 1, i2);
        this.zzl.zzr(z, 1, i2);
        zzag(zzd2, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzs(Surface surface) {
        zzai();
        zzae(surface);
        int i = surface == null ? 0 : -1;
        zzac(i, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzt(float f) {
        zzai();
        String str = zzex.zza;
        final float max = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzO == max) {
            return;
        }
        this.zzO = max;
        this.zzl.zzt(max);
        zzdz zzdzVar = this.zzm;
        zzdzVar.zzd(22, new zzdw() { // from class: com.google.android.gms.internal.ads.zzje
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i = zzkh.zzd;
                ((zzbe) obj).zzt(max);
            }
        });
        zzdzVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final void zzu() {
        zzai();
        zzaf(null);
        new zzcw(zzfyq.zzn(), this.zzU.zzs);
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzv() {
        zzai();
        return this.zzU.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzw() {
        zzai();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbh
    public final boolean zzx() {
        zzai();
        return this.zzU.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final int zzy() {
        zzai();
        int length = this.zzh.length;
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zziy
    public final void zzz(zzmr zzmrVar) {
        this.zzr.zzu(zzmrVar);
    }
}
