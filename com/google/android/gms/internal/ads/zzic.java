package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzic implements zzma, zzmd {
    private final int zzb;
    private zzme zzd;
    private int zze;
    private zzph zzf;
    private zzdj zzg;
    private int zzh;
    private zzwz zzi;
    private zzz[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;
    private zzvh zzq;
    private zzmc zzr;
    private final Object zza = new Object();
    private final zzkv zzc = new zzkv();
    private long zzm = Long.MIN_VALUE;
    private zzbl zzp = zzbl.zza;

    public zzic(int i) {
        this.zzb = i;
    }

    private final void zzaa(long j, boolean z) throws zzin {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzA(j, z);
    }

    protected void zzA(long j, boolean z) throws zzin {
        throw null;
    }

    protected void zzB() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzC() {
        zzmc zzmcVar;
        synchronized (this.zza) {
            zzmcVar = this.zzr;
        }
        if (zzmcVar != null) {
            zzmcVar.zza(this);
        }
    }

    protected void zzD() {
    }

    protected void zzE() throws zzin {
    }

    protected void zzF() {
    }

    protected void zzG(zzz[] zzzVarArr, long j, long j2, zzvh zzvhVar) throws zzin {
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzH() {
        zzdd.zzf(this.zzh == 0);
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzI(zzz[] zzzVarArr, zzwz zzwzVar, long j, long j2, zzvh zzvhVar) throws zzin {
        zzdd.zzf(!this.zzn);
        this.zzi = zzwzVar;
        this.zzq = zzvhVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzzVarArr;
        this.zzk = j2;
        zzG(zzzVarArr, j, j2, zzvhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzJ() {
        zzdd.zzf(this.zzh == 0);
        zzkv zzkvVar = this.zzc;
        zzkvVar.zzb = null;
        zzkvVar.zza = null;
        zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzK(long j) throws zzin {
        zzaa(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzL() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzmd
    public final void zzM(zzmc zzmcVar) {
        synchronized (this.zza) {
            this.zzr = zzmcVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public /* synthetic */ void zzN(float f, float f2) {
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzO(zzbl zzblVar) {
        if (Objects.equals(this.zzp, zzblVar)) {
            return;
        }
        this.zzp = zzblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzP() throws zzin {
        zzdd.zzf(this.zzh == 1);
        this.zzh = 2;
        zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzQ() {
        zzdd.zzf(this.zzh == 2);
        this.zzh = 1;
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final boolean zzR() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final boolean zzS() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzma, com.google.android.gms.internal.ads.zzmd
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final int zzcU() {
        return this.zzh;
    }

    protected final int zzcV(zzkv zzkvVar, zzhs zzhsVar, int i) {
        zzwz zzwzVar = this.zzi;
        zzwzVar.getClass();
        int zza = zzwzVar.zza(zzkvVar, zzhsVar, i);
        if (zza == -4) {
            if (zzhsVar.zzf()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzhsVar.zze + this.zzk;
            zzhsVar.zze = j;
            this.zzm = Math.max(this.zzm, j);
            return zza;
        }
        if (zza == -5) {
            zzz zzzVar = zzkvVar.zza;
            zzzVar.getClass();
            long j2 = zzzVar.zzt;
            if (j2 != Long.MAX_VALUE) {
                zzx zzb = zzzVar.zzb();
                zzb.zzal(j2 + this.zzk);
                zzkvVar.zza = zzb.zzan();
                return -5;
            }
        }
        return zza;
    }

    protected final long zzcW() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzmd
    public int zze() throws zzin {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public /* synthetic */ long zzf(long j, long j2) {
        return 10000L;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final long zzh() {
        return this.zzm;
    }

    protected final zzbl zzi() {
        return this.zzp;
    }

    protected final zzin zzk(Throwable th, zzz zzzVar, boolean z, int i) {
        int i2 = 4;
        if (zzzVar != null && !this.zzo) {
            this.zzo = true;
            try {
                i2 = zzZ(zzzVar) & 7;
            } catch (zzin unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzin.zzb(th, zzV(), this.zze, zzzVar, i2, this.zzq, z, i);
    }

    protected final zzkv zzl() {
        zzkv zzkvVar = this.zzc;
        zzkvVar.zzb = null;
        zzkvVar.zza = null;
        return zzkvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public zzlb zzm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final zzmd zzn() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final zzwz zzq() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzmd
    public final void zzr() {
        synchronized (this.zza) {
            this.zzr = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzs() {
        zzdd.zzf(this.zzh == 1);
        zzkv zzkvVar = this.zzc;
        zzkvVar.zzb = null;
        zzkvVar.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzy();
        this.zzq = null;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzt(zzme zzmeVar, zzz[] zzzVarArr, zzwz zzwzVar, long j, boolean z, boolean z2, long j2, long j3, zzvh zzvhVar) throws zzin {
        zzdd.zzf(this.zzh == 0);
        this.zzd = zzmeVar;
        this.zzq = zzvhVar;
        this.zzh = 1;
        zzz(z, z2);
        zzI(zzzVarArr, zzwzVar, j2, j3, zzvhVar);
        zzaa(j2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public /* synthetic */ void zzu() {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public void zzv(int i, Object obj) throws zzin {
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzw(int i, zzph zzphVar, zzdj zzdjVar) {
        this.zze = i;
        this.zzf = zzphVar;
        this.zzg = zzdjVar;
    }

    protected void zzy() {
        throw null;
    }

    protected void zzz(boolean z, boolean z2) throws zzin {
    }

    protected final boolean zzT() {
        if (zzR()) {
            return this.zzn;
        }
        zzwz zzwzVar = this.zzi;
        zzwzVar.getClass();
        return zzwzVar.zze();
    }

    protected final zzz[] zzU() {
        zzz[] zzzVarArr = this.zzj;
        zzzVarArr.getClass();
        return zzzVarArr;
    }

    protected final zzdj zzcX() {
        zzdj zzdjVar = this.zzg;
        zzdjVar.getClass();
        return zzdjVar;
    }

    protected final int zzd(long j) {
        zzwz zzwzVar = this.zzi;
        zzwzVar.getClass();
        return zzwzVar.zzb(j - this.zzk);
    }

    protected final zzme zzo() {
        zzme zzmeVar = this.zzd;
        zzmeVar.getClass();
        return zzmeVar;
    }

    protected final zzph zzp() {
        zzph zzphVar = this.zzf;
        zzphVar.getClass();
        return zzphVar;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzx() throws IOException {
        zzwz zzwzVar = this.zzi;
        zzwzVar.getClass();
        zzwzVar.zzd();
    }
}
