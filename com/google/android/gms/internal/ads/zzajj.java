package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzajj implements zzadv, zzaeu {
    private long zzA;
    private int zzB;
    private zzahm zzC;
    private final zzakr zza;
    private final int zzb;
    private final zzen zzc;
    private final zzen zzd;
    private final zzen zze;
    private final zzen zzf;
    private final ArrayDeque zzg;
    private final zzajn zzh;
    private final List zzi;
    private zzfyq zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;
    private zzen zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private long zzv;
    private zzady zzw;
    private zzaji[] zzx;
    private long[][] zzy;
    private int zzz;

    @Deprecated
    public zzajj() {
        this(zzakr.zza, 16);
    }

    private static int zzj(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzk(zzajs zzajsVar, long j) {
        int zza = zzajsVar.zza(j);
        return zza == -1 ? zzajsVar.zzb(j) : zza;
    }

    private static long zzl(zzajs zzajsVar, long j, long j2) {
        int zzk = zzk(zzajsVar, j);
        return zzk == -1 ? j2 : Math.min(zzajsVar.zzc[zzk], j2);
    }

    private final void zzm() {
        this.zzk = 0;
        this.zzn = 0;
    }

    private final void zzn(long j) throws zzaz {
        zzav zzavVar;
        long j2;
        boolean z;
        int i;
        String str;
        ArrayDeque arrayDeque;
        List list;
        zzav[] zzavVarArr;
        zzaej zzaejVar;
        ArrayList arrayList;
        while (true) {
            ArrayDeque arrayDeque2 = this.zzg;
            if (arrayDeque2.isEmpty() || ((zzfc) arrayDeque2.peek()).zza != j) {
                break;
            }
            zzfc zzfcVar = (zzfc) arrayDeque2.pop();
            if (zzfcVar.zzd == 1836019574) {
                zzfc zza = zzfcVar.zza(1835365473);
                new ArrayList();
                zzav zzb = zza != null ? zzaix.zzb(zza) : null;
                ArrayList arrayList2 = new ArrayList();
                int i2 = 0;
                boolean z2 = this.zzB == 1;
                zzaej zzaejVar2 = new zzaej();
                zzfd zzb2 = zzfcVar.zzb(1969517665);
                if (zzb2 != null) {
                    zzav zzc = zzaix.zzc(zzb2);
                    zzaejVar2.zzb(zzc);
                    zzavVar = zzc;
                } else {
                    zzavVar = null;
                }
                zzfd zzb3 = zzfcVar.zzb(1836476516);
                zzb3.getClass();
                zzav zzavVar2 = new zzav(-9223372036854775807L, zzaix.zzd(zzb3.zza));
                int i3 = this.zzb;
                if (1 != (i3 & 1)) {
                    j2 = -9223372036854775807L;
                    z = false;
                } else {
                    j2 = -9223372036854775807L;
                    z = true;
                }
                ArrayList arrayList3 = arrayList2;
                List zzf = zzaix.zzf(zzfcVar, zzaejVar2, -9223372036854775807L, null, z, z2, new zzfve() { // from class: com.google.android.gms.internal.ads.zzajh
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        return (zzajp) obj;
                    }
                });
                String zza2 = zzajg.zza(zzf);
                long j3 = j2;
                long j4 = j3;
                int i4 = 0;
                int i5 = 0;
                int i6 = -1;
                while (i4 < zzf.size()) {
                    zzajs zzajsVar = (zzajs) zzf.get(i4);
                    int i7 = i2;
                    if (zzajsVar.zzb == 0) {
                        arrayDeque = arrayDeque2;
                        list = zzf;
                        zzaejVar = zzaejVar2;
                        i = i5;
                        arrayList = arrayList3;
                        str = zza2;
                    } else {
                        zzajp zzajpVar = zzajsVar.zza;
                        zzady zzadyVar = this.zzw;
                        i = i5 + 1;
                        int i8 = zzajpVar.zzb;
                        zzaji zzajiVar = new zzaji(zzajpVar, zzajsVar, zzadyVar.zzw(i5, i8));
                        str = zza2;
                        long j5 = zzajpVar.zze;
                        if (j5 == j4) {
                            j5 = zzajsVar.zzh;
                        }
                        arrayDeque = arrayDeque2;
                        zzafb zzafbVar = zzajiVar.zzc;
                        zzafbVar.zzl(j5);
                        long max = Math.max(j3, j5);
                        zzz zzzVar = zzajpVar.zzg;
                        int i9 = "audio/true-hd".equals(zzzVar.zzo) ? zzajsVar.zze * 16 : zzajsVar.zze + 30;
                        zzx zzb4 = zzzVar.zzb();
                        zzb4.zzX(i9);
                        if (i8 == 2) {
                            int i10 = zzzVar.zzf;
                            if ((i3 & 8) != 0) {
                                i10 |= i6 == -1 ? 1 : 2;
                            }
                            zzb4.zzaf(i10);
                            i8 = 2;
                        }
                        if (i8 == 1 && zzaejVar2.zza()) {
                            zzb4.zzM(zzaejVar2.zza);
                            zzb4.zzN(zzaejVar2.zzb);
                        }
                        zzav zzavVar3 = zzzVar.zzl;
                        List list2 = this.zzi;
                        list = zzf;
                        zzav[] zzavVarArr2 = new zzav[3];
                        zzavVarArr2[i7] = list2.isEmpty() ? null : new zzav(list2);
                        zzavVarArr2[1] = zzavVar;
                        zzavVarArr2[2] = zzavVar2;
                        if (zzavVar3 != null) {
                            zzavVarArr = zzavVarArr2;
                            zzaejVar = zzaejVar2;
                        } else {
                            zzavVarArr = zzavVarArr2;
                            zzaejVar = zzaejVar2;
                            zzavVar3 = new zzav(j4, new zzau[i7]);
                        }
                        if (zzb != null) {
                            for (int i11 = 0; i11 < zzb.zza(); i11++) {
                                zzau zzb5 = zzb.zzb(i11);
                                if (zzb5 instanceof zzfa) {
                                    zzfa zzfaVar = (zzfa) zzb5;
                                    if (!zzfaVar.zza.equals("com.android.capture.fps")) {
                                        zzavVar3 = zzavVar3.zzc(zzfaVar);
                                    } else if (i8 == 2) {
                                        zzavVar3 = zzavVar3.zzc(zzfaVar);
                                    }
                                }
                            }
                        }
                        for (int i12 = 0; i12 < 3; i12++) {
                            zzavVar3 = zzavVar3.zzd(zzavVarArr[i12]);
                        }
                        if (zzavVar3.zza() > 0) {
                            zzb4.zzaa(zzavVar3);
                        }
                        zzb4.zzG(str);
                        zzafbVar.zzm(zzb4.zzan());
                        if (i8 == 2 && i6 == -1) {
                            i6 = arrayList3.size();
                        }
                        arrayList = arrayList3;
                        arrayList.add(zzajiVar);
                        j3 = max;
                    }
                    i4++;
                    arrayList3 = arrayList;
                    zza2 = str;
                    i5 = i;
                    arrayDeque2 = arrayDeque;
                    zzf = list;
                    zzaejVar2 = zzaejVar;
                    i2 = 0;
                    j4 = -9223372036854775807L;
                }
                ArrayDeque arrayDeque3 = arrayDeque2;
                this.zzz = i6;
                this.zzA = j3;
                zzaji[] zzajiVarArr = (zzaji[]) arrayList3.toArray(new zzaji[0]);
                this.zzx = zzajiVarArr;
                int length = zzajiVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i13 = 0; i13 < zzajiVarArr.length; i13++) {
                    jArr[i13] = new long[zzajiVarArr[i13].zzb.zzb];
                    jArr2[i13] = zzajiVarArr[i13].zzb.zzf[0];
                }
                long j6 = 0;
                int i14 = 0;
                while (i14 < zzajiVarArr.length) {
                    long j7 = Long.MAX_VALUE;
                    int i15 = -1;
                    for (int i16 = 0; i16 < zzajiVarArr.length; i16++) {
                        if (!zArr[i16]) {
                            long j8 = jArr2[i16];
                            if (j8 <= j7) {
                                i15 = i16;
                                j7 = j8;
                            }
                        }
                    }
                    int i17 = iArr[i15];
                    long[] jArr3 = jArr[i15];
                    jArr3[i17] = j6;
                    zzajs zzajsVar2 = zzajiVarArr[i15].zzb;
                    j6 += zzajsVar2.zzd[i17];
                    int i18 = i17 + 1;
                    iArr[i15] = i18;
                    if (i18 < jArr3.length) {
                        jArr2[i15] = zzajsVar2.zzf[i18];
                    } else {
                        zArr[i15] = true;
                        i14++;
                    }
                }
                this.zzy = jArr;
                this.zzw.zzG();
                this.zzw.zzP(this);
                arrayDeque3.clear();
                this.zzk = 2;
            } else if (!arrayDeque2.isEmpty()) {
                ((zzfc) arrayDeque2.peek()).zzc(zzfcVar);
            }
        }
        if (this.zzk != 2) {
            zzm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        if ((this.zzb & 16) == 0) {
            zzadyVar = new zzaku(zzadyVar, this.zza);
        }
        this.zzw = zzadyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        this.zzg.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = false;
        if (j == 0) {
            if (this.zzk != 3) {
                zzm();
                return;
            } else {
                this.zzh.zzb();
                this.zzi.clear();
                return;
            }
        }
        for (zzaji zzajiVar : this.zzx) {
            zzajs zzajsVar = zzajiVar.zzb;
            int zza = zzajsVar.zza(j2);
            if (zza == -1) {
                zza = zzajsVar.zzb(j2);
            }
            zzajiVar.zze = zza;
            zzafc zzafcVar = zzajiVar.zzd;
            if (zzafcVar != null) {
                zzafcVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        int zzb;
        long j6 = j;
        zzaji[] zzajiVarArr = this.zzx;
        if (zzajiVarArr.length == 0) {
            zzaev zzaevVar = zzaev.zza;
            return new zzaes(zzaevVar, zzaevVar);
        }
        int i = this.zzz;
        if (i != -1) {
            zzajs zzajsVar = zzajiVarArr[i].zzb;
            int zzk = zzk(zzajsVar, j6);
            if (zzk == -1) {
                zzaev zzaevVar2 = zzaev.zza;
                return new zzaes(zzaevVar2, zzaevVar2);
            }
            long[] jArr = zzajsVar.zzf;
            long j7 = jArr[zzk];
            long[] jArr2 = zzajsVar.zzc;
            j2 = jArr2[zzk];
            if (j7 >= j6 || zzk >= zzajsVar.zzb - 1 || (zzb = zzajsVar.zzb(j6)) == -1 || zzb == zzk) {
                j5 = -9223372036854775807L;
                j4 = -1;
            } else {
                j5 = jArr[zzb];
                j4 = jArr2[zzb];
            }
            j3 = j5;
            j6 = j7;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
            j4 = -1;
        }
        int i2 = 0;
        while (true) {
            zzaji[] zzajiVarArr2 = this.zzx;
            if (i2 >= zzajiVarArr2.length) {
                break;
            }
            if (i2 != this.zzz) {
                zzajs zzajsVar2 = zzajiVarArr2[i2].zzb;
                long zzl = zzl(zzajsVar2, j6, j2);
                if (j3 != -9223372036854775807L) {
                    j4 = zzl(zzajsVar2, j3, j4);
                }
                j2 = zzl;
            }
            i2++;
        }
        zzaev zzaevVar3 = new zzaev(j6, j2);
        return j3 == -9223372036854775807L ? new zzaes(zzaevVar3, zzaevVar3) : new zzaes(zzaevVar3, new zzaev(j3, j4));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) throws IOException {
        zzaey zzb = zzajo.zzb(zzadwVar, (this.zzb & 2) != 0);
        this.zzj = zzb != null ? zzfyq.zzo(zzb) : zzfyq.zzn();
        return zzb == null;
    }

    public zzajj(zzakr zzakrVar, int i) {
        this.zza = zzakrVar;
        this.zzb = i;
        this.zzj = zzfyq.zzn();
        this.zzk = (i & 4) != 0 ? 3 : 0;
        this.zzh = new zzajn();
        this.zzi = new ArrayList();
        this.zzf = new zzen(16);
        this.zzg = new ArrayDeque();
        this.zzc = new zzen(zzfv.zza);
        this.zzd = new zzen(6);
        this.zze = new zzen();
        this.zzp = -1;
        this.zzw = zzady.zza;
        this.zzx = new zzaji[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x0454, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x009e A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzadv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws IOException {
        long j;
        char c;
        long j2;
        zzafb zzafbVar;
        int i;
        int i2;
        int i3;
        char c2;
        boolean z;
        boolean z2;
        boolean z3;
        while (true) {
            int i4 = this.zzk;
            long j3 = 0;
            char c3 = 2;
            if (i4 == 0) {
                if (this.zzn == 0) {
                    zzen zzenVar = this.zzf;
                    if (!zzadwVar.zzn(zzenVar.zzN(), 0, 8, true)) {
                        if (this.zzB != 2 || (this.zzb & 2) == 0) {
                            return -1;
                        }
                        zzafb zzw = this.zzw.zzw(0, 4);
                        zzahm zzahmVar = this.zzC;
                        zzav zzavVar = zzahmVar == null ? null : new zzav(-9223372036854775807L, zzahmVar);
                        zzx zzxVar = new zzx();
                        zzxVar.zzaa(zzavVar);
                        zzw.zzm(zzxVar.zzan());
                        this.zzw.zzG();
                        this.zzw.zzP(new zzaet(-9223372036854775807L, 0L));
                        return -1;
                    }
                    this.zzn = 8;
                    zzenVar.zzL(0);
                    this.zzm = zzenVar.zzu();
                    this.zzl = zzenVar.zzg();
                }
                long j4 = this.zzm;
                if (j4 == 1) {
                    zzen zzenVar2 = this.zzf;
                    zzadwVar.zzi(zzenVar2.zzN(), 8, 8);
                    this.zzn += 8;
                    this.zzm = zzenVar2.zzw();
                } else if (j4 == 0) {
                    long zzd = zzadwVar.zzd();
                    if (zzd == -1) {
                        zzfc zzfcVar = (zzfc) this.zzg.peek();
                        zzd = zzfcVar != null ? zzfcVar.zza : -1L;
                    }
                    if (zzd != -1) {
                        this.zzm = (zzd - zzadwVar.zzf()) + this.zzn;
                    }
                }
                long j5 = this.zzm;
                int i5 = this.zzn;
                if (j5 < i5) {
                    throw zzaz.zzc("Atom size less than header length (unsupported).");
                }
                int i6 = this.zzl;
                if (i6 == 1836019574 || i6 == 1953653099 || i6 == 1835297121 || i6 == 1835626086 || i6 == 1937007212 || i6 == 1701082227 || i6 == 1835365473 || i6 == 1635284069) {
                    long zzf = zzadwVar.zzf();
                    long j6 = this.zzm;
                    long j7 = zzf + j6;
                    long j8 = this.zzn;
                    if (j6 != j8 && this.zzl == 1835365473) {
                        zzen zzenVar3 = this.zze;
                        zzenVar3.zzI(8);
                        zzadwVar.zzh(zzenVar3.zzN(), 0, 8);
                        zzaix.zzg(zzenVar3);
                        zzadwVar.zzk(zzenVar3.zzc());
                        zzadwVar.zzj();
                    }
                    long j9 = j7 - j8;
                    this.zzg.push(new zzfc(this.zzl, j9));
                    if (this.zzm == this.zzn) {
                        zzn(j9);
                    } else {
                        zzm();
                    }
                } else if (i6 == 1835296868 || i6 == 1836476516 || i6 == 1751411826 || i6 == 1937011556 || i6 == 1937011827 || i6 == 1937011571 || i6 == 1668576371 || i6 == 1701606260 || i6 == 1937011555 || i6 == 1937011578 || i6 == 1937013298 || i6 == 1937007471 || i6 == 1668232756 || i6 == 1953196132 || i6 == 1718909296 || i6 == 1969517665 || i6 == 1801812339 || i6 == 1768715124) {
                    boolean z4 = false;
                    zzdd.zzf(z4);
                    zzdd.zzf(this.zzm <= 2147483647L);
                    zzen zzenVar4 = new zzen((int) this.zzm);
                    System.arraycopy(this.zzf.zzN(), 0, zzenVar4.zzN(), 0, 8);
                    this.zzo = zzenVar4;
                    this.zzk = 1;
                } else {
                    long zzf2 = zzadwVar.zzf();
                    long j10 = this.zzn;
                    long j11 = zzf2 - j10;
                    if (this.zzl == 1836086884) {
                        this.zzC = new zzahm(0L, j11, -9223372036854775807L, j11 + j10, this.zzm - j10);
                    }
                    this.zzo = null;
                    this.zzk = 1;
                }
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        this.zzh.zza(zzadwVar, zzaerVar, this.zzi);
                        if (zzaerVar.zza == 0) {
                            zzm();
                        }
                        return 1;
                    }
                    long zzf3 = zzadwVar.zzf();
                    int i7 = this.zzp;
                    if (i7 == -1) {
                        int i8 = -1;
                        int i9 = -1;
                        boolean z5 = true;
                        boolean z6 = true;
                        long j12 = Long.MAX_VALUE;
                        long j13 = Long.MAX_VALUE;
                        long j14 = Long.MAX_VALUE;
                        int i10 = 0;
                        j2 = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                        while (true) {
                            zzaji[] zzajiVarArr = this.zzx;
                            if (i10 >= zzajiVarArr.length) {
                                break;
                            }
                            zzaji zzajiVar = zzajiVarArr[i10];
                            int i11 = zzajiVar.zze;
                            zzajs zzajsVar = zzajiVar.zzb;
                            long j15 = j3;
                            if (i11 == zzajsVar.zzb) {
                                c2 = c3;
                            } else {
                                long j16 = zzajsVar.zzc[i11];
                                long[][] jArr = this.zzy;
                                String str = zzex.zza;
                                long j17 = jArr[i10][i11];
                                long j18 = j16 - zzf3;
                                if (j18 < j15 || j18 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                                    c2 = c3;
                                    z = true;
                                } else {
                                    c2 = c3;
                                    z = false;
                                }
                                if (z) {
                                    z2 = z6;
                                } else {
                                    if (!z6) {
                                        z2 = false;
                                    }
                                    j14 = j18;
                                    z6 = z;
                                    i9 = i10;
                                    j13 = j17;
                                    if (j17 < j12) {
                                        z5 = z;
                                        i8 = i10;
                                        j12 = j17;
                                    }
                                }
                                if (z != z2 || j18 >= j14) {
                                    z6 = z2;
                                    if (j17 < j12) {
                                    }
                                }
                                j14 = j18;
                                z6 = z;
                                i9 = i10;
                                j13 = j17;
                                if (j17 < j12) {
                                }
                            }
                            i10++;
                            j3 = j15;
                            c3 = c2;
                        }
                        j = j3;
                        c = c3;
                        i7 = (j12 == Long.MAX_VALUE || !z5 || j13 < j12 + 10485760) ? i9 : i8;
                        this.zzp = i7;
                        if (i7 == -1) {
                            return -1;
                        }
                    } else {
                        j = 0;
                        c = 2;
                        j2 = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    }
                    zzaji zzajiVar2 = this.zzx[i7];
                    zzafb zzafbVar2 = zzajiVar2.zzc;
                    int i12 = zzajiVar2.zze;
                    zzajs zzajsVar2 = zzajiVar2.zzb;
                    long j19 = this.zzv + zzajsVar2.zzc[i12];
                    int[] iArr = zzajsVar2.zzd;
                    int i13 = iArr[i12];
                    zzafc zzafcVar = zzajiVar2.zzd;
                    zzafb zzafbVar3 = zzafbVar2;
                    int i14 = 0;
                    long j20 = (j19 - zzf3) + this.zzq;
                    if (j20 < j || j20 >= j2) {
                        zzaerVar.zza = j19;
                        return 1;
                    }
                    zzajp zzajpVar = zzajiVar2.zza;
                    if (zzajpVar.zzh == 1) {
                        j20 += 8;
                        i13 -= 8;
                    }
                    int i15 = i13;
                    zzadwVar.zzk((int) j20);
                    zzz zzzVar = zzajpVar.zzg;
                    String str2 = zzzVar.zzo;
                    if (!Objects.equals(str2, "video/avc")) {
                        Objects.equals(str2, "video/hevc");
                    }
                    this.zzt = true;
                    int i16 = zzajpVar.zzk;
                    if (i16 == 0) {
                        zzafbVar = zzafbVar3;
                        if ("audio/ac4".equals(str2)) {
                            if (this.zzr == 0) {
                                zzen zzenVar5 = this.zze;
                                zzacy.zzc(i15, zzenVar5);
                                zzafbVar.zzr(zzenVar5, 7);
                                this.zzr += 7;
                            }
                            i15 += 7;
                        } else if (zzafcVar != null) {
                            zzafcVar.zzd(zzadwVar);
                        }
                        while (true) {
                            int i17 = this.zzr;
                            if (i17 >= i15) {
                                break;
                            }
                            int zzf4 = zzafbVar.zzf(zzadwVar, i15 - i17, false);
                            this.zzq += zzf4;
                            this.zzr += zzf4;
                            this.zzs -= zzf4;
                        }
                    } else {
                        zzen zzenVar6 = this.zzd;
                        byte[] zzN = zzenVar6.zzN();
                        zzN[0] = 0;
                        zzN[1] = 0;
                        zzN[c] = 0;
                        int i18 = 4 - i16;
                        i15 += i18;
                        while (this.zzr < i15) {
                            int i19 = this.zzs;
                            if (i19 == 0) {
                                if (this.zzt || zzfv.zzb(zzzVar) + i16 > iArr[i12] - this.zzq) {
                                    i2 = i16;
                                    i3 = i14;
                                } else {
                                    i3 = zzfv.zzb(zzzVar);
                                    i2 = i16 + i3;
                                }
                                zzadwVar.zzi(zzN, i18, i2);
                                this.zzq += i2;
                                int i20 = i14;
                                zzenVar6.zzL(i20);
                                int zzg = zzenVar6.zzg();
                                if (zzg < 0) {
                                    throw zzaz.zza("Invalid NAL length", null);
                                }
                                this.zzs = zzg - i3;
                                zzen zzenVar7 = this.zzc;
                                zzenVar7.zzL(i20);
                                i = i16;
                                zzafb zzafbVar4 = zzafbVar3;
                                zzafbVar4.zzr(zzenVar7, 4);
                                this.zzr += 4;
                                if (i3 > 0) {
                                    zzafbVar4.zzr(zzenVar6, i3);
                                    this.zzr += i3;
                                    if (zzfv.zzj(zzN, 4, i3, zzzVar)) {
                                        this.zzt = true;
                                        zzafbVar3 = zzafbVar4;
                                        i16 = i;
                                        i14 = 0;
                                    }
                                }
                                zzafbVar3 = zzafbVar4;
                            } else {
                                i = i16;
                                int zzf5 = zzafbVar3.zzf(zzadwVar, i19, i14);
                                this.zzq += zzf5;
                                this.zzr += zzf5;
                                this.zzs -= zzf5;
                            }
                            i16 = i;
                            i14 = 0;
                        }
                        zzafbVar = zzafbVar3;
                    }
                    int i21 = i15;
                    long j21 = zzajsVar2.zzf[i12];
                    int i22 = zzajsVar2.zzg[i12];
                    if (!this.zzt) {
                        i22 |= 67108864;
                    }
                    int i23 = i22;
                    if (zzafcVar != null) {
                        zzafb zzafbVar5 = zzafbVar;
                        zzafcVar.zzc(zzafbVar5, j21, i23, i21, 0, null);
                        if (i12 + 1 == zzajsVar2.zzb) {
                            zzafcVar.zza(zzafbVar5, null);
                        }
                    } else {
                        zzafbVar.zzt(j21, i23, i21, 0, null);
                    }
                    zzajiVar2.zze++;
                    this.zzp = -1;
                    this.zzq = 0;
                    this.zzr = 0;
                    this.zzs = 0;
                    this.zzt = false;
                    return 0;
                }
                long j22 = this.zzm - this.zzn;
                long zzf6 = zzadwVar.zzf() + j22;
                zzen zzenVar8 = this.zzo;
                if (zzenVar8 != null) {
                    zzadwVar.zzi(zzenVar8.zzN(), this.zzn, (int) j22);
                    if (this.zzl == 1718909296) {
                        this.zzu = true;
                        zzenVar8.zzL(8);
                        int zzj = zzj(zzenVar8.zzg());
                        if (zzj == 0) {
                            zzenVar8.zzM(4);
                            while (true) {
                                if (zzenVar8.zza() <= 0) {
                                    zzj = 0;
                                    break;
                                }
                                zzj = zzj(zzenVar8.zzg());
                                if (zzj != 0) {
                                    break;
                                }
                            }
                        }
                        this.zzB = zzj;
                    } else {
                        ArrayDeque arrayDeque = this.zzg;
                        if (!arrayDeque.isEmpty()) {
                            ((zzfc) arrayDeque.peek()).zzd(new zzfd(this.zzl, zzenVar8));
                        }
                    }
                } else {
                    if (!this.zzu && this.zzl == 1835295092) {
                        this.zzB = 1;
                    }
                    if (j22 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        zzadwVar.zzk((int) j22);
                    } else {
                        zzaerVar.zza = zzadwVar.zzf() + j22;
                        z3 = true;
                        zzn(zzf6);
                        if (z3 && this.zzk != 2) {
                            return 1;
                        }
                    }
                }
                z3 = false;
                zzn(zzf6);
                if (z3) {
                    return 1;
                }
                continue;
            }
        }
    }
}
