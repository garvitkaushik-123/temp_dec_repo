package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzun implements zzvs, zzsd {
    final /* synthetic */ zzup zza;
    private final Object zzb;
    private zzvr zzc;
    private zzsc zzd;

    public zzun(zzup zzupVar, Object obj) {
        Objects.requireNonNull(zzupVar);
        this.zza = zzupVar;
        this.zzc = zzupVar.zze(null);
        this.zzd = zzupVar.zzc(null);
        this.zzb = obj;
    }

    private final zzvd zzf(zzvd zzvdVar, zzvh zzvhVar) {
        zzup zzupVar = this.zza;
        Object obj = this.zzb;
        zzupVar.zzx(obj, zzvdVar.zzc, zzvhVar);
        zzupVar.zzx(obj, zzvdVar.zzd, zzvhVar);
        return zzvdVar;
    }

    private final boolean zzg(int i, zzvh zzvhVar) {
        zzvh zzvhVar2;
        if (zzvhVar != null) {
            zzvhVar2 = this.zza.zzy(this.zzb, zzvhVar);
            if (zzvhVar2 == null) {
                return false;
            }
        } else {
            zzvhVar2 = null;
        }
        zzup zzupVar = this.zza;
        zzupVar.zzw(this.zzb, 0);
        zzvr zzvrVar = this.zzc;
        int i2 = zzvrVar.zza;
        if (!Objects.equals(zzvrVar.zzb, zzvhVar2)) {
            this.zzc = zzupVar.zzf(0, zzvhVar2);
        }
        zzsc zzscVar = this.zzd;
        int i3 = zzscVar.zza;
        if (Objects.equals(zzscVar.zzb, zzvhVar2)) {
            return true;
        }
        this.zzd = zzupVar.zzd(0, zzvhVar2);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzag(int i, zzvh zzvhVar, zzvd zzvdVar) {
        if (zzg(0, zzvhVar)) {
            zzvr zzvrVar = this.zzc;
            zzf(zzvdVar, zzvhVar);
            zzvrVar.zzd(zzvdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzah(int i, zzvh zzvhVar, zzuy zzuyVar, zzvd zzvdVar) {
        if (zzg(0, zzvhVar)) {
            zzvr zzvrVar = this.zzc;
            zzf(zzvdVar, zzvhVar);
            zzvrVar.zze(zzuyVar, zzvdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzai(int i, zzvh zzvhVar, zzuy zzuyVar, zzvd zzvdVar) {
        if (zzg(0, zzvhVar)) {
            zzvr zzvrVar = this.zzc;
            zzf(zzvdVar, zzvhVar);
            zzvrVar.zzf(zzuyVar, zzvdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzaj(int i, zzvh zzvhVar, zzuy zzuyVar, zzvd zzvdVar, IOException iOException, boolean z) {
        if (zzg(0, zzvhVar)) {
            zzvr zzvrVar = this.zzc;
            zzf(zzvdVar, zzvhVar);
            zzvrVar.zzg(zzuyVar, zzvdVar, iOException, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvs
    public final void zzak(int i, zzvh zzvhVar, zzuy zzuyVar, zzvd zzvdVar, int i2) {
        if (zzg(0, zzvhVar)) {
            zzvr zzvrVar = this.zzc;
            zzf(zzvdVar, zzvhVar);
            zzvrVar.zzh(zzuyVar, zzvdVar, i2);
        }
    }
}
