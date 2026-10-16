package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzwy implements zzafb {
    private boolean zzA;
    private zzsi zzB;
    private final zzws zza;
    private final zzsh zzd;
    private final zzsc zze;
    private zzww zzf;
    private zzz zzg;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private boolean zzv;
    private zzz zzy;
    private final zzwu zzb = new zzwu();
    private int zzh = 1000;
    private long[] zzi = new long[1000];
    private long[] zzj = new long[1000];
    private long[] zzm = new long[1000];
    private int[] zzl = new int[1000];
    private int[] zzk = new int[1000];
    private zzafa[] zzn = new zzafa[1000];
    private final zzxf zzc = new zzxf(new zzdn() { // from class: com.google.android.gms.internal.ads.zzwt
        @Override // com.google.android.gms.internal.ads.zzdn
        public final void zza(Object obj) {
            zzsg zzsgVar = ((zzwv) obj).zzb;
        }
    });
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private boolean zzx = true;
    private boolean zzw = true;
    private boolean zzz = true;

    protected zzwy(zzzm zzzmVar, zzsh zzshVar, zzsc zzscVar) {
        this.zzd = zzshVar;
        this.zze = zzscVar;
        this.zza = new zzws(zzzmVar);
    }

    private final int zzB(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.zzm[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.zzl[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.zzh) {
                i = 0;
            }
        }
        return i3;
    }

    private final int zzC(int i) {
        int i2 = this.zzq + i;
        int i3 = this.zzh;
        return i2 < i3 ? i2 : i2 - i3;
    }

    private final synchronized int zzD(zzkv zzkvVar, zzhs zzhsVar, boolean z, boolean z2, zzwu zzwuVar) {
        zzhsVar.zzd = false;
        if (!zzL()) {
            if (!z2 && !this.zzv) {
                zzz zzzVar = this.zzy;
                if (zzzVar == null || (!z && zzzVar == this.zzg)) {
                    return -3;
                }
                zzz zzzVar2 = zzzVar;
                zzI(zzzVar, zzkvVar);
                return -5;
            }
            zzhsVar.zzc(4);
            zzhsVar.zze = Long.MIN_VALUE;
            return -4;
        }
        zzz zzzVar3 = ((zzwv) this.zzc.zza(this.zzp + this.zzr)).zza;
        if (!z && zzzVar3 == this.zzg) {
            int zzC = zzC(this.zzr);
            if (!zzM(zzC)) {
                zzhsVar.zzd = true;
                return -3;
            }
            zzhsVar.zzc(this.zzl[zzC]);
            if (this.zzr == this.zzo - 1 && (z2 || this.zzv)) {
                zzhsVar.zza(536870912);
            }
            zzhsVar.zze = this.zzm[zzC];
            zzwuVar.zza = this.zzk[zzC];
            zzwuVar.zzb = this.zzj[zzC];
            zzwuVar.zzc = this.zzn[zzC];
            return -4;
        }
        zzI(zzzVar3, zzkvVar);
        return -5;
    }

    private final synchronized long zzE(long j, boolean z, boolean z2) {
        Throwable th;
        try {
            try {
                int i = this.zzo;
                if (i != 0) {
                    long[] jArr = this.zzm;
                    int i2 = this.zzq;
                    if (j >= jArr[i2]) {
                        if (z2) {
                            try {
                                int i3 = this.zzr;
                                if (i3 != i) {
                                    i = i3 + 1;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        int zzB = zzB(i2, i, j, false);
                        if (zzB != -1) {
                            return zzG(zzB);
                        }
                        return -1L;
                    }
                }
                return -1L;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private final synchronized long zzF() {
        int i = this.zzo;
        if (i == 0) {
            return -1L;
        }
        return zzG(i);
    }

    private final synchronized void zzH(long j, int i, long j2, int i2, zzafa zzafaVar) {
        int i3 = this.zzo;
        if (i3 > 0) {
            int zzC = zzC(i3 - 1);
            zzdd.zzd(this.zzj[zzC] + ((long) this.zzk[zzC]) <= j2);
        }
        this.zzv = (536870912 & i) != 0;
        this.zzu = Math.max(this.zzu, j);
        int zzC2 = zzC(this.zzo);
        this.zzm[zzC2] = j;
        this.zzj[zzC2] = j2;
        this.zzk[zzC2] = i2;
        this.zzl[zzC2] = i;
        this.zzn[zzC2] = zzafaVar;
        this.zzi[zzC2] = 0;
        zzxf zzxfVar = this.zzc;
        if (zzxfVar.zzf() || !((zzwv) zzxfVar.zzb()).zza.equals(this.zzy)) {
            zzz zzzVar = this.zzy;
            if (zzzVar == null) {
                throw null;
            }
            zzz zzzVar2 = zzzVar;
            zzxfVar.zzc(this.zzp + this.zzo, new zzwv(zzzVar, this.zzd.zzb(this.zze, zzzVar), null));
        }
        int i4 = this.zzo + 1;
        this.zzo = i4;
        int i5 = this.zzh;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            zzafa[] zzafaVarArr = new zzafa[i6];
            int i7 = this.zzq;
            int i8 = i5 - i7;
            System.arraycopy(this.zzj, i7, jArr2, 0, i8);
            System.arraycopy(this.zzm, this.zzq, jArr3, 0, i8);
            System.arraycopy(this.zzl, this.zzq, iArr, 0, i8);
            System.arraycopy(this.zzk, this.zzq, iArr2, 0, i8);
            System.arraycopy(this.zzn, this.zzq, zzafaVarArr, 0, i8);
            System.arraycopy(this.zzi, this.zzq, jArr, 0, i8);
            int i9 = this.zzq;
            System.arraycopy(this.zzj, 0, jArr2, i8, i9);
            System.arraycopy(this.zzm, 0, jArr3, i8, i9);
            System.arraycopy(this.zzl, 0, iArr, i8, i9);
            System.arraycopy(this.zzk, 0, iArr2, i8, i9);
            System.arraycopy(this.zzn, 0, zzafaVarArr, i8, i9);
            System.arraycopy(this.zzi, 0, jArr, i8, i9);
            this.zzj = jArr2;
            this.zzm = jArr3;
            this.zzl = iArr;
            this.zzk = iArr2;
            this.zzn = zzafaVarArr;
            this.zzi = jArr;
            this.zzq = 0;
            this.zzh = i6;
        }
    }

    private final void zzI(zzz zzzVar, zzkv zzkvVar) {
        zzz zzzVar2 = this.zzg;
        zzs zzsVar = zzzVar2 == null ? null : zzzVar2.zzs;
        this.zzg = zzzVar;
        zzs zzsVar2 = zzzVar.zzs;
        zzsh zzshVar = this.zzd;
        zzkvVar.zza = zzzVar.zzc(zzshVar.zza(zzzVar));
        zzkvVar.zzb = this.zzB;
        if (zzzVar2 == null || !Objects.equals(zzsVar, zzsVar2)) {
            zzsi zzc = zzshVar.zzc(this.zze, zzzVar);
            this.zzB = zzc;
            zzkvVar.zzb = zzc;
        }
    }

    private final void zzJ() {
        if (this.zzB != null) {
            this.zzB = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzK() {
        this.zzr = 0;
        this.zza.zzg();
    }

    private final boolean zzL() {
        return this.zzr != this.zzo;
    }

    private final boolean zzM(int i) {
        if (this.zzB == null) {
            return true;
        }
        int i2 = this.zzl[i];
        return false;
    }

    private final synchronized boolean zzN(zzz zzzVar) {
        this.zzx = false;
        if (Objects.equals(zzzVar, this.zzy)) {
            return false;
        }
        zzxf zzxfVar = this.zzc;
        if (zzxfVar.zzf() || !((zzwv) zzxfVar.zzb()).zza.equals(zzzVar)) {
            this.zzy = zzzVar;
        } else {
            this.zzy = ((zzwv) zzxfVar.zzb()).zza;
        }
        boolean z = this.zzz;
        zzz zzzVar2 = this.zzy;
        this.zzz = z & zzay.zzf(zzzVar2.zzo, zzzVar2.zzk);
        this.zzA = false;
        return true;
    }

    public final synchronized boolean zzA(long j, boolean z) {
        Throwable th;
        zzwy zzwyVar;
        long j2;
        int i;
        try {
            try {
                zzK();
                int i2 = this.zzr;
                int zzC = zzC(i2);
                if (zzL() && j >= this.zzm[zzC]) {
                    if (j > this.zzu) {
                        if (z) {
                            z = true;
                        }
                    }
                    if (this.zzz) {
                        try {
                            int i3 = this.zzo - i2;
                            int i4 = 0;
                            while (true) {
                                if (i4 < i3) {
                                    if (this.zzm[zzC] >= j) {
                                        zzwyVar = this;
                                        j2 = j;
                                        i = i4;
                                        break;
                                    }
                                    zzC++;
                                    if (zzC == this.zzh) {
                                        zzC = 0;
                                    }
                                    i4++;
                                } else if (z) {
                                    j2 = j;
                                    i = i3;
                                    zzwyVar = this;
                                } else {
                                    zzwyVar = this;
                                    j2 = j;
                                    i = -1;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } else {
                        zzwyVar = this;
                        j2 = j;
                        i = zzwyVar.zzB(zzC, this.zzo - i2, j2, true);
                    }
                    if (i == -1) {
                        return false;
                    }
                    zzwyVar.zzs = j2;
                    zzwyVar.zzr += i;
                    return true;
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final int zza() {
        return this.zzp;
    }

    public final int zzb() {
        return this.zzp + this.zzr;
    }

    public final synchronized int zzc(long j, boolean z) {
        Throwable th;
        try {
            try {
                int i = this.zzr;
                int zzC = zzC(i);
                if (zzL() && j >= this.zzm[zzC]) {
                    if (j <= this.zzu || !z) {
                        int zzB = zzB(zzC, this.zzo - i, j, true);
                        if (zzB == -1) {
                            return 0;
                        }
                        return zzB;
                    }
                    try {
                        return this.zzo - i;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                return 0;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final int zzd() {
        return this.zzp + this.zzo;
    }

    public final int zze(zzkv zzkvVar, zzhs zzhsVar, int i, boolean z) {
        boolean z2 = (i & 2) != 0;
        zzwu zzwuVar = this.zzb;
        int zzD = zzD(zzkvVar, zzhsVar, z2, z, zzwuVar);
        if (zzD != -4) {
            return zzD;
        }
        if (!zzhsVar.zzf()) {
            int i2 = i & 1;
            if ((i & 4) == 0) {
                if (i2 != 0) {
                    this.zza.zzd(zzhsVar, zzwuVar);
                    return -4;
                }
                this.zza.zze(zzhsVar, zzwuVar);
            } else if (i2 != 0) {
                return -4;
            }
            this.zzr++;
        }
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ int zzf(zzl zzlVar, int i, boolean z) {
        return zzaez.zza(this, zzlVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final int zzg(zzl zzlVar, int i, boolean z, int i2) throws IOException {
        return this.zza.zza(zzlVar, i, z);
    }

    public final synchronized long zzh() {
        return this.zzu;
    }

    public final synchronized zzz zzi() {
        if (this.zzx) {
            return null;
        }
        return this.zzy;
    }

    public final void zzj(long j, boolean z, boolean z2) {
        this.zza.zzc(zzE(j, false, z2));
    }

    public final void zzk() {
        this.zza.zzc(zzF());
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ void zzl(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzm(zzz zzzVar) {
        boolean zzN = zzN(zzzVar);
        zzww zzwwVar = this.zzf;
        if (zzwwVar == null || !zzN) {
            return;
        }
        zzwwVar.zzN(zzzVar);
    }

    public final void zzn() throws IOException {
        zzsi zzsiVar = this.zzB;
        if (zzsiVar != null) {
            throw zzsiVar.zza();
        }
    }

    public final void zzo() {
        zzk();
        zzJ();
    }

    public final void zzp() {
        zzq(true);
        zzJ();
    }

    public final void zzq(boolean z) {
        this.zza.zzf();
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzw = true;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = false;
        this.zzc.zzd();
        if (z) {
            this.zzy = null;
            this.zzx = true;
            this.zzz = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ void zzr(zzen zzenVar, int i) {
        zzaez.zzb(this, zzenVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzs(zzen zzenVar, int i, int i2) {
        this.zza.zzh(zzenVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzt(long j, int i, int i2, int i3, zzafa zzafaVar) {
        if (this.zzw) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.zzw = false;
            }
        }
        if (this.zzz) {
            if (j < this.zzs) {
                return;
            }
            if ((i & 1) == 0) {
                if (!this.zzA) {
                    zzea.zzf("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(String.valueOf(this.zzy))));
                    this.zzA = true;
                }
                i |= 1;
            }
        }
        zzH(j, i, (this.zza.zzb() - i2) - i3, i2, zzafaVar);
    }

    public final void zzu(long j) {
        this.zzs = j;
    }

    public final void zzv(zzww zzwwVar) {
        this.zzf = zzwwVar;
    }

    public final synchronized void zzw(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzr + i <= this.zzo) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzdd.zzd(z);
        this.zzr += i;
    }

    public final synchronized boolean zzx() {
        return this.zzv;
    }

    public final synchronized boolean zzy(boolean z) {
        boolean z2 = true;
        if (zzL()) {
            if (((zzwv) this.zzc.zza(this.zzp + this.zzr)).zza != this.zzg) {
                return true;
            }
            return zzM(zzC(this.zzr));
        }
        if (!z && !this.zzv) {
            zzz zzzVar = this.zzy;
            if (zzzVar == null) {
                z2 = false;
            } else if (zzzVar == this.zzg) {
                return false;
            }
        }
        return z2;
    }

    public final synchronized boolean zzz(int i) {
        zzK();
        int i2 = this.zzp;
        if (i >= i2 && i <= this.zzo + i2) {
            this.zzs = Long.MIN_VALUE;
            this.zzr = i - i2;
            return true;
        }
        return false;
    }

    private final long zzG(int i) {
        long j = this.zzt;
        long j2 = Long.MIN_VALUE;
        if (i != 0) {
            int zzC = zzC(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                j2 = Math.max(j2, this.zzm[zzC]);
                if ((this.zzl[zzC] & 1) != 0) {
                    break;
                }
                zzC--;
                if (zzC == -1) {
                    zzC = this.zzh - 1;
                }
            }
        }
        this.zzt = Math.max(j, j2);
        this.zzo -= i;
        int i3 = this.zzp + i;
        this.zzp = i3;
        int i4 = this.zzq + i;
        this.zzq = i4;
        int i5 = this.zzh;
        if (i4 >= i5) {
            this.zzq = i4 - i5;
        }
        int i6 = this.zzr - i;
        this.zzr = i6;
        if (i6 < 0) {
            this.zzr = 0;
        }
        this.zzc.zze(i3);
        if (this.zzo != 0) {
            return this.zzj[this.zzq];
        }
        int i7 = this.zzq;
        if (i7 == 0) {
            i7 = this.zzh;
        }
        return this.zzj[i7 - 1] + this.zzk[r11];
    }
}
