package com.google.android.gms.internal.ads;

import android.util.Pair;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzvc extends zzxm {
    private final boolean zzb;
    private final zzbk zzc;
    private final zzbj zzd;
    private zzva zze;
    private zzuz zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzvc(zzvj zzvjVar, boolean z) {
        super(zzvjVar);
        boolean z2;
        if (z) {
            zzvjVar.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzbk();
        this.zzd = new zzbj();
        zzvjVar.zzM();
        this.zze = zzva.zzq(zzvjVar.zzJ());
    }

    private final Object zzK(Object obj) {
        Object obj2;
        Object obj3;
        obj2 = this.zze.zze;
        if (obj2 == null || !obj.equals(zzva.zzc)) {
            return obj;
        }
        obj3 = this.zze.zze;
        return obj3;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final boolean zzL(long j) {
        zzuz zzuzVar = this.zzf;
        int zza = this.zze.zza(zzuzVar.zza.zza);
        if (zza == -1) {
            return false;
        }
        zzva zzvaVar = this.zze;
        zzbj zzbjVar = this.zzd;
        zzvaVar.zzd(zza, zzbjVar, false);
        long j2 = zzbjVar.zzd;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        zzuzVar.zzs(j);
        return true;
    }

    public final zzbl zzC() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    protected final zzvh zzD(zzvh zzvhVar) {
        Object obj;
        Object obj2;
        obj = this.zze.zze;
        Object obj3 = zzvhVar.zza;
        if (obj != null) {
            obj2 = this.zze.zze;
            if (obj2.equals(obj3)) {
                obj3 = zzva.zzc;
            }
        }
        return zzvhVar.zza(obj3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        if (r6 != 0) goto L20;
     */
    @Override // com.google.android.gms.internal.ads.zzxm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzE(zzbl zzblVar) {
        long j;
        zzvh zzvhVar = null;
        if (this.zzh) {
            this.zze = this.zze.zzp(zzblVar);
            zzuz zzuzVar = this.zzf;
            if (zzuzVar != null) {
                zzL(zzuzVar.zzn());
            }
        } else if (zzblVar.zzo()) {
            this.zze = this.zzi ? this.zze.zzp(zzblVar) : zzva.zzr(zzblVar, zzbk.zza, zzva.zzc);
        } else {
            zzbk zzbkVar = this.zzc;
            zzblVar.zze(0, zzbkVar, 0L);
            Object obj = zzbkVar.zzb;
            zzuz zzuzVar2 = this.zzf;
            if (zzuzVar2 != null) {
                j = zzuzVar2.zzq();
                this.zze.zzn(zzuzVar2.zza.zza, this.zzd);
                this.zze.zze(0, zzbkVar, 0L);
            }
            j = 0;
            Pair zzl = zzblVar.zzl(zzbkVar, this.zzd, 0, j);
            Object obj2 = zzl.first;
            long longValue = ((Long) zzl.second).longValue();
            this.zze = this.zzi ? this.zze.zzp(zzblVar) : zzva.zzr(zzblVar, obj, obj2);
            zzuz zzuzVar3 = this.zzf;
            if (zzuzVar3 != null && zzL(longValue)) {
                zzvh zzvhVar2 = zzuzVar3.zza;
                zzvhVar = zzvhVar2.zza(zzK(zzvhVar2.zza));
            }
        }
        this.zzi = true;
        this.zzh = true;
        zzo(this.zze);
        if (zzvhVar != null) {
            zzuz zzuzVar4 = this.zzf;
            zzuzVar4.getClass();
            zzuzVar4.zzr(zzvhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzF() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzB(null, ((zzxm) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzxm, com.google.android.gms.internal.ads.zzvj
    public final void zzG(zzvf zzvfVar) {
        ((zzuz) zzvfVar).zzt();
        if (zzvfVar == this.zzf) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxm, com.google.android.gms.internal.ads.zzvj
    /* renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final zzuz zzI(zzvh zzvhVar, zzzm zzzmVar, long j) {
        zzuz zzuzVar = new zzuz(zzvhVar, zzzmVar, j);
        zzuzVar.zzu(this.zza);
        if (this.zzh) {
            zzuzVar.zzr(zzvhVar.zza(zzK(zzvhVar.zza)));
            return zzuzVar;
        }
        this.zzf = zzuzVar;
        if (!this.zzg) {
            this.zzg = true;
            zzB(null, ((zzxm) this).zza);
        }
        return zzuzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzug
    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzvj
    public final void zzt(zzap zzapVar) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzxi(this.zze.zzb, zzapVar));
        } else {
            this.zze = zzva.zzq(zzapVar);
        }
        this.zza.zzt(zzapVar);
    }
}
