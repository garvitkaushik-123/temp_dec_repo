package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes5.dex */
final class zzac extends zzab {
    final /* synthetic */ zzae zza;
    private final com.google.android.gms.internal.measurement.zzfr zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzac(zzae zzaeVar, String str, int i, com.google.android.gms.internal.measurement.zzfr zzfrVar) {
        super(str, i);
        this.zza = zzaeVar;
        this.zzh = zzfrVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final int zza() {
        return this.zzh.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean zzc() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzio zzioVar, boolean z) {
        com.google.android.gms.internal.measurement.zzpq.zzb();
        zzio zzioVar2 = this.zza.zzu;
        boolean zzx = zzioVar2.zzf().zzx(this.zzb, zzgi.zzaC);
        com.google.android.gms.internal.measurement.zzfr zzfrVar = this.zzh;
        boolean zzg = zzfrVar.zzg();
        boolean zzh = zzfrVar.zzh();
        boolean zzi = zzfrVar.zzi();
        Object[] objArr = zzg || zzh || zzi;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z && objArr != true) {
            zzioVar2.zzaW().zzj().zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), zzfrVar.zzj() ? Integer.valueOf(zzfrVar.zza()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzfl zzb = zzfrVar.zzb();
        boolean zzg2 = zzb.zzg();
        if (zzioVar.zzt()) {
            if (zzb.zzi()) {
                bool = zzj(zzh(zzioVar.zzc(), zzb.zzc()), zzg2);
            } else {
                zzioVar2.zzaW().zzk().zzb("No number filter for long property. property", zzioVar2.zzj().zzf(zzioVar.zzg()));
            }
        } else if (zzioVar.zzr()) {
            if (zzb.zzi()) {
                bool = zzj(zzg(zzioVar.zza(), zzb.zzc()), zzg2);
            } else {
                zzioVar2.zzaW().zzk().zzb("No number filter for double property. property", zzioVar2.zzj().zzf(zzioVar.zzg()));
            }
        } else if (!zzioVar.zzv()) {
            zzioVar2.zzaW().zzk().zzb("User property has no value, property", zzioVar2.zzj().zzf(zzioVar.zzg()));
        } else if (zzb.zzk()) {
            bool = zzj(zzf(zzioVar.zzh(), zzb.zzd(), zzioVar2.zzaW()), zzg2);
        } else if (!zzb.zzi()) {
            zzioVar2.zzaW().zzk().zzb("No string or number filter defined. property", zzioVar2.zzj().zzf(zzioVar.zzg()));
        } else if (zzqa.zzA(zzioVar.zzh())) {
            bool = zzj(zzi(zzioVar.zzh(), zzb.zzc()), zzg2);
        } else {
            zzioVar2.zzaW().zzk().zzc("Invalid user property value for Numeric number filter. property, value", zzioVar2.zzj().zzf(zzioVar.zzg()), zzioVar.zzh());
        }
        zzioVar2.zzaW().zzj().zzb("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.zzd = true;
        if (zzi && !bool.booleanValue()) {
            return true;
        }
        if (!z || zzfrVar.zzg()) {
            this.zze = bool;
        }
        if (bool.booleanValue() && objArr != false && zzioVar.zzu()) {
            long zzd = zzioVar.zzd();
            if (l != null) {
                zzd = l.longValue();
            }
            if (zzx && zzfrVar.zzg() && !zzfrVar.zzh() && l2 != null) {
                zzd = l2.longValue();
            }
            if (zzfrVar.zzh()) {
                this.zzg = Long.valueOf(zzd);
            } else {
                this.zzf = Long.valueOf(zzd);
            }
        }
        return true;
    }
}
