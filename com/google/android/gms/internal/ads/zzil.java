package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzil implements zzlb {
    private final zzml zza;
    private final zzik zzb;
    private zzma zzc;
    private zzlb zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzil(zzik zzikVar, zzdj zzdjVar) {
        this.zzb = zzikVar;
        this.zza = new zzml(zzdjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final long zza() {
        if (this.zze) {
            return this.zza.zza();
        }
        zzlb zzlbVar = this.zzd;
        zzlbVar.getClass();
        return zzlbVar.zza();
    }

    public final long zzb(boolean z) {
        zzma zzmaVar = this.zzc;
        if (zzmaVar == null || zzmaVar.zzX() || ((z && this.zzc.zzcU() != 2) || (!this.zzc.zzY() && (z || this.zzc.zzR())))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzlb zzlbVar = this.zzd;
            zzlbVar.getClass();
            long zza = zzlbVar.zza();
            if (this.zze) {
                zzml zzmlVar = this.zza;
                if (zza < zzmlVar.zza()) {
                    zzmlVar.zze();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        zzmlVar.zzd();
                    }
                }
            }
            zzml zzmlVar2 = this.zza;
            zzmlVar2.zzb(zza);
            zzbb zzc = zzlbVar.zzc();
            if (!zzc.equals(zzmlVar2.zzc())) {
                zzmlVar2.zzg(zzc);
                this.zzb.zzc(zzc);
            }
        }
        return zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final zzbb zzc() {
        zzlb zzlbVar = this.zzd;
        return zzlbVar != null ? zzlbVar.zzc() : this.zza.zzc();
    }

    public final void zzd(zzma zzmaVar) {
        if (zzmaVar == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzma zzmaVar) throws zzin {
        zzlb zzlbVar;
        zzlb zzm = zzmaVar.zzm();
        if (zzm == null || zzm == (zzlbVar = this.zzd)) {
            return;
        }
        if (zzlbVar != null) {
            throw zzin.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.zzd = zzm;
        this.zzc = zzmaVar;
        zzm.zzg(this.zza.zzc());
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final void zzg(zzbb zzbbVar) {
        zzlb zzlbVar = this.zzd;
        if (zzlbVar != null) {
            zzlbVar.zzg(zzbbVar);
            zzbbVar = this.zzd.zzc();
        }
        this.zza.zzg(zzbbVar);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzlb
    public final boolean zzj() {
        if (this.zze) {
            return false;
        }
        zzlb zzlbVar = this.zzd;
        zzlbVar.getClass();
        return zzlbVar.zzj();
    }
}
