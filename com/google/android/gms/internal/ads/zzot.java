package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.SparseArray;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzot implements zzmo {
    private final zzdj zza;
    private final zzbj zzb;
    private final zzbk zzc;
    private final zzos zzd;
    private final SparseArray zze;
    private zzdz zzf;
    private zzbh zzg;
    private zzdt zzh;
    private boolean zzi;

    public static /* synthetic */ void zzX(zzot zzotVar) {
        final zzmp zzV = zzotVar.zzV();
        zzotVar.zzaa(zzV, 1028, new zzdw(zzV) { // from class: com.google.android.gms.internal.ads.zzmt
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
        zzotVar.zzf.zze();
    }

    private final zzmp zzac(int i, zzvh zzvhVar) {
        zzbh zzbhVar = this.zzg;
        zzbhVar.getClass();
        if (zzvhVar != null) {
            return this.zzd.zza(zzvhVar) != null ? zzab(zzvhVar) : zzW(zzbl.zza, i, zzvhVar);
        }
        zzbl zzo = zzbhVar.zzo();
        if (i >= zzo.zzc()) {
            zzo = zzbl.zza;
        }
        return zzW(zzo, i, null);
    }

    private final zzmp zzad() {
        return zzab(this.zzd.zzd());
    }

    private final zzmp zzae() {
        return zzab(this.zzd.zze());
    }

    private final zzmp zzaf(zzba zzbaVar) {
        zzvh zzvhVar;
        return (!(zzbaVar instanceof zzin) || (zzvhVar = ((zzin) zzbaVar).zzh) == null) ? zzV() : zzab(zzvhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzA(final zzid zzidVar) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1007, new zzdw(zzae, zzidVar) { // from class: com.google.android.gms.internal.ads.zzmu
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzB(final zzz zzzVar, final zzie zzieVar) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1009, new zzdw() { // from class: com.google.android.gms.internal.ads.zzog
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zze(zzmp.this, zzzVar, zzieVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzC(final long j) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1010, new zzdw(zzae, j) { // from class: com.google.android.gms.internal.ads.zzni
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzD(final Exception exc) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1014, new zzdw(zzae, exc) { // from class: com.google.android.gms.internal.ads.zzoo
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzE(final zzqi zzqiVar) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1031, new zzdw(zzae, zzqiVar) { // from class: com.google.android.gms.internal.ads.zzoc
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzF(final zzqi zzqiVar) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1032, new zzdw(zzae, zzqiVar) { // from class: com.google.android.gms.internal.ads.zzon
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzG(final int i, final long j, final long j2) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1011, new zzdw(zzae, i, j, j2) { // from class: com.google.android.gms.internal.ads.zzne
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzH(final int i, final long j) {
        final zzmp zzad = zzad();
        zzaa(zzad, 1018, new zzdw() { // from class: com.google.android.gms.internal.ads.zzno
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zzh(zzmp.this, i, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzI(final Object obj, final long j) {
        final zzmp zzae = zzae();
        zzaa(zzae, 26, new zzdw() { // from class: com.google.android.gms.internal.ads.zzok
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj2) {
                ((zzmr) obj2).zzn(zzmp.this, obj, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzJ(final int i, final int i2, final boolean z) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1033, new zzdw(zzae, i, i2, z) { // from class: com.google.android.gms.internal.ads.zznr
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzK(final Exception exc) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1030, new zzdw(zzae, exc) { // from class: com.google.android.gms.internal.ads.zznd
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzL(final String str, final long j, final long j2) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1016, new zzdw(zzae, str, j2, j) { // from class: com.google.android.gms.internal.ads.zzom
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzM(final String str) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1019, new zzdw(zzae, str) { // from class: com.google.android.gms.internal.ads.zznn
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzN(final zzid zzidVar) {
        final zzmp zzad = zzad();
        zzaa(zzad, 1020, new zzdw() { // from class: com.google.android.gms.internal.ads.zzoa
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zzo(zzmp.this, zzidVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzO(final zzid zzidVar) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1015, new zzdw(zzae, zzidVar) { // from class: com.google.android.gms.internal.ads.zzoi
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzP(final long j, final int i) {
        final zzmp zzad = zzad();
        zzaa(zzad, 1021, new zzdw(zzad, j, i) { // from class: com.google.android.gms.internal.ads.zznu
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzQ(final zzz zzzVar, final zzie zzieVar) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1017, new zzdw() { // from class: com.google.android.gms.internal.ads.zzob
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zzp(zzmp.this, zzzVar, zzieVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzR() {
        zzdt zzdtVar = this.zzh;
        zzdd.zzb(zzdtVar);
        zzdtVar.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzoj
            @Override // java.lang.Runnable
            public final void run() {
                zzot.zzX(zzot.this);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzS(zzmr zzmrVar) {
        this.zzf.zzf(zzmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzT(final zzbh zzbhVar, Looper looper) {
        zzfyq zzfyqVar;
        boolean z = true;
        if (this.zzg != null) {
            zzfyqVar = this.zzd.zzb;
            if (!zzfyqVar.isEmpty()) {
                z = false;
            }
        }
        zzdd.zzf(z);
        zzbhVar.getClass();
        this.zzg = zzbhVar;
        this.zzh = this.zza.zzd(looper, null);
        this.zzf = this.zzf.zza(looper, new zzdx() { // from class: com.google.android.gms.internal.ads.zzng
            @Override // com.google.android.gms.internal.ads.zzdx
            public final void zza(Object obj, zzv zzvVar) {
                zzmr zzmrVar = (zzmr) obj;
                zzmrVar.zzi(zzbhVar, new zzmq(zzvVar, zzot.this.zze));
            }
        });
    }

    protected final zzmp zzV() {
        return zzab(this.zzd.zzb());
    }

    @RequiresNonNull({"player"})
    protected final zzmp zzW(zzbl zzblVar, int i, zzvh zzvhVar) {
        zzvh zzvhVar2 = true == zzblVar.zzo() ? null : zzvhVar;
        long zzb = this.zza.zzb();
        boolean z = zzblVar.equals(this.zzg.zzo()) && i == this.zzg.zze();
        long j = 0;
        if (zzvhVar2 == null || !zzvhVar2.zzb()) {
            if (z) {
                j = this.zzg.zzk();
            } else if (!zzblVar.zzo()) {
                long j2 = zzblVar.zze(i, this.zzc, 0L).zzl;
                j = zzex.zzv(0L);
            }
        } else if (z && this.zzg.zzc() == zzvhVar2.zzb && this.zzg.zzd() == zzvhVar2.zzc) {
            j = this.zzg.zzl();
        }
        return new zzmp(zzb, zzblVar, i, zzvhVar2, j, this.zzg.zzo(), this.zzg.zze(), this.zzd.zzb(), this.zzg.zzl(), this.zzg.zzn());
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzZ(final int i, final long j, final long j2) {
        final zzmp zzab = zzab(this.zzd.zzc());
        zzaa(zzab, 1006, new zzdw() { // from class: com.google.android.gms.internal.ads.zznb
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zzf(zzmp.this, i, j, j2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zza(final int i) {
        final zzmp zzae = zzae();
        zzaa(zzae, 21, new zzdw(zzae, i) { // from class: com.google.android.gms.internal.ads.zzod
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    protected final void zzaa(zzmp zzmpVar, int i, zzdw zzdwVar) {
        this.zze.put(i, zzmpVar);
        zzdz zzdzVar = this.zzf;
        zzdzVar.zzd(i, zzdwVar);
        zzdzVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzag(int i, zzvh zzvhVar, final zzvd zzvdVar) {
        final zzmp zzac = zzac(i, zzvhVar);
        zzaa(zzac, 1004, new zzdw() { // from class: com.google.android.gms.internal.ads.zznt
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zzg(zzmp.this, zzvdVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzah(int i, zzvh zzvhVar, final zzuy zzuyVar, final zzvd zzvdVar) {
        final zzmp zzac = zzac(i, zzvhVar);
        zzaa(zzac, 1002, new zzdw(zzac, zzuyVar, zzvdVar) { // from class: com.google.android.gms.internal.ads.zznv
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzai(int i, zzvh zzvhVar, final zzuy zzuyVar, final zzvd zzvdVar) {
        final zzmp zzac = zzac(i, zzvhVar);
        zzaa(zzac, 1001, new zzdw(zzac, zzuyVar, zzvdVar) { // from class: com.google.android.gms.internal.ads.zznz
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzaj(int i, zzvh zzvhVar, final zzuy zzuyVar, final zzvd zzvdVar, final IOException iOException, final boolean z) {
        final zzmp zzac = zzac(i, zzvhVar);
        zzaa(zzac, 1003, new zzdw() { // from class: com.google.android.gms.internal.ads.zznf
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zzj(zzmp.this, zzuyVar, zzvdVar, iOException, z);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzak(int i, zzvh zzvhVar, final zzuy zzuyVar, final zzvd zzvdVar, final int i2) {
        final zzmp zzac = zzac(i, zzvhVar);
        zzaa(zzac, 1000, new zzdw(zzac, zzuyVar, zzvdVar, i2) { // from class: com.google.android.gms.internal.ads.zzor
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzb(final zzbd zzbdVar) {
        final zzmp zzV = zzV();
        zzaa(zzV, 13, new zzdw(zzV, zzbdVar) { // from class: com.google.android.gms.internal.ads.zzmx
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzc(final boolean z) {
        final zzmp zzV = zzV();
        zzaa(zzV, 3, new zzdw(zzV, z) { // from class: com.google.android.gms.internal.ads.zzmv
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzd(final boolean z) {
        final zzmp zzV = zzV();
        zzaa(zzV, 7, new zzdw(zzV, z) { // from class: com.google.android.gms.internal.ads.zznj
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zze(final zzap zzapVar, final int i) {
        final zzmp zzV = zzV();
        zzaa(zzV, 1, new zzdw(zzV, zzapVar, i) { // from class: com.google.android.gms.internal.ads.zzmz
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzf(final zzat zzatVar) {
        final zzmp zzV = zzV();
        zzaa(zzV, 14, new zzdw(zzV, zzatVar) { // from class: com.google.android.gms.internal.ads.zzop
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzg(final boolean z, final int i) {
        final zzmp zzV = zzV();
        zzaa(zzV, 5, new zzdw(zzV, z, i) { // from class: com.google.android.gms.internal.ads.zznq
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzh(final zzbb zzbbVar) {
        final zzmp zzV = zzV();
        zzaa(zzV, 12, new zzdw(zzV, zzbbVar) { // from class: com.google.android.gms.internal.ads.zzms
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzi(final int i) {
        final zzmp zzV = zzV();
        zzaa(zzV, 4, new zzdw() { // from class: com.google.android.gms.internal.ads.zzny
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zzk(zzmp.this, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzj(final int i) {
        final zzmp zzV = zzV();
        zzaa(zzV, 6, new zzdw(zzV, i) { // from class: com.google.android.gms.internal.ads.zznm
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzk(final zzba zzbaVar) {
        final zzmp zzaf = zzaf(zzbaVar);
        zzaa(zzaf, 10, new zzdw() { // from class: com.google.android.gms.internal.ads.zznw
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zzl(zzmp.this, zzbaVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzl(final zzba zzbaVar) {
        final zzmp zzaf = zzaf(zzbaVar);
        zzaa(zzaf, 10, new zzdw(zzaf, zzbaVar) { // from class: com.google.android.gms.internal.ads.zznp
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzm(final boolean z, final int i) {
        final zzmp zzV = zzV();
        zzaa(zzV, -1, new zzdw(zzV, z, i) { // from class: com.google.android.gms.internal.ads.zznh
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzo(final boolean z) {
        final zzmp zzae = zzae();
        zzaa(zzae, 23, new zzdw(zzae, z) { // from class: com.google.android.gms.internal.ads.zzna
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzp(final int i, final int i2) {
        final zzmp zzae = zzae();
        zzaa(zzae, 24, new zzdw(zzae, i, i2) { // from class: com.google.android.gms.internal.ads.zzoq
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzr(final zzbt zzbtVar) {
        final zzmp zzV = zzV();
        zzaa(zzV, 2, new zzdw(zzV, zzbtVar) { // from class: com.google.android.gms.internal.ads.zznk
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzs(final zzcd zzcdVar) {
        final zzmp zzae = zzae();
        zzaa(zzae, 25, new zzdw() { // from class: com.google.android.gms.internal.ads.zzoe
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                zzmp zzmpVar = zzmp.this;
                zzcd zzcdVar2 = zzcdVar;
                ((zzmr) obj).zzq(zzmpVar, zzcdVar2);
                int i = zzcdVar2.zzb;
                int i2 = zzcdVar2.zzc;
                float f = zzcdVar2.zzd;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzt(final float f) {
        final zzmp zzae = zzae();
        zzaa(zzae, 22, new zzdw(zzae, f) { // from class: com.google.android.gms.internal.ads.zznc
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzu(zzmr zzmrVar) {
        this.zzf.zzb(zzmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzv() {
        if (this.zzi) {
            return;
        }
        final zzmp zzV = zzV();
        this.zzi = true;
        zzaa(zzV, -1, new zzdw(zzV) { // from class: com.google.android.gms.internal.ads.zzof
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzw(final Exception exc) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1029, new zzdw(zzae, exc) { // from class: com.google.android.gms.internal.ads.zzol
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzx(final String str, final long j, final long j2) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1008, new zzdw(zzae, str, j2, j) { // from class: com.google.android.gms.internal.ads.zznl
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzy(final String str) {
        final zzmp zzae = zzae();
        zzaa(zzae, 1012, new zzdw(zzae, str) { // from class: com.google.android.gms.internal.ads.zzmw
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzz(final zzid zzidVar) {
        final zzmp zzad = zzad();
        zzaa(zzad, 1013, new zzdw(zzad, zzidVar) { // from class: com.google.android.gms.internal.ads.zznx
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    private final zzmp zzab(zzvh zzvhVar) {
        this.zzg.getClass();
        zzbl zza = zzvhVar == null ? null : this.zzd.zza(zzvhVar);
        if (zzvhVar != null && zza != null) {
            return zzW(zza, zza.zzn(zzvhVar.zza, this.zzb).zzc, zzvhVar);
        }
        int zze = this.zzg.zze();
        zzbl zzo = this.zzg.zzo();
        if (zze >= zzo.zzc()) {
            zzo = zzbl.zza;
        }
        return zzW(zzo, zze, null);
    }

    @Override // com.google.android.gms.internal.ads.zzmo
    public final void zzU(List list, zzvh zzvhVar) {
        zzbh zzbhVar = this.zzg;
        zzbhVar.getClass();
        this.zzd.zzh(list, zzvhVar, zzbhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzn(final zzbf zzbfVar, final zzbf zzbfVar2, final int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zzos zzosVar = this.zzd;
        zzbh zzbhVar = this.zzg;
        zzbhVar.getClass();
        zzosVar.zzg(zzbhVar);
        final zzmp zzV = zzV();
        zzaa(zzV, 11, new zzdw() { // from class: com.google.android.gms.internal.ads.zzoh
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                ((zzmr) obj).zzm(zzmp.this, zzbfVar, zzbfVar2, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbe
    public final void zzq(zzbl zzblVar, final int i) {
        zzbh zzbhVar = this.zzg;
        zzbhVar.getClass();
        this.zzd.zzi(zzbhVar);
        final zzmp zzV = zzV();
        zzaa(zzV, 0, new zzdw(zzV, i) { // from class: com.google.android.gms.internal.ads.zzmy
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
            }
        });
    }

    public zzot(zzdj zzdjVar) {
        zzdjVar.getClass();
        this.zza = zzdjVar;
        this.zzf = new zzdz(zzex.zzz(), zzdjVar, new zzdx() { // from class: com.google.android.gms.internal.ads.zzns
            @Override // com.google.android.gms.internal.ads.zzdx
            public final void zza(Object obj, zzv zzvVar) {
            }
        });
        zzbj zzbjVar = new zzbj();
        this.zzb = zzbjVar;
        this.zzc = new zzbk();
        this.zzd = new zzos(zzbjVar);
        this.zze = new SparseArray();
    }
}
