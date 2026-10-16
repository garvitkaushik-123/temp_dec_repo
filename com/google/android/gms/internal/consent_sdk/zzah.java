package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
final class zzah extends zza {
    final zzdr zza;
    final zzdr zzb;
    final zzdr zzc;
    final zzdr zzd;
    final zzdr zze;
    final zzdr zzf;
    final zzdr zzg;
    final zzdr zzh;
    final zzdr zzi;
    final zzdr zzj;
    final zzdr zzk;
    final zzdr zzl;
    final zzdr zzm;
    private final zzah zzn = this;

    zzah(Application application) {
        zzdo zzb = zzdp.zzb(application);
        this.zza = zzb;
        zzdr zzb2 = zzdn.zzb(new zzar(zzb));
        this.zzb = zzb2;
        zzdr zzb3 = zzdn.zzb(zzae.zza);
        this.zzc = zzb3;
        zzag zzagVar = new zzag(this);
        this.zzd = zzagVar;
        zzav zzavVar = zzau.zza;
        zzdr zzb4 = zzdn.zzb(new zzbp(zzagVar, zzavVar));
        this.zze = zzb4;
        zzq zzqVar = new zzq(zzb, zzb2);
        this.zzf = zzqVar;
        zzdr zzb5 = zzdn.zzb(new zzf(zzavVar));
        this.zzg = zzb5;
        zzdr zzb6 = zzdn.zzb(new zzan(zzb));
        this.zzh = zzb6;
        zzdr zzb7 = zzdn.zzb(new zzm(zzb, zzb6));
        this.zzi = zzb7;
        zzap zzapVar = new zzap(zzb, zzb2, zzb7, zzavVar);
        this.zzj = zzapVar;
        zzac zzacVar = new zzac(zzb5, zzapVar, zzb2);
        this.zzk = zzacVar;
        zzx zzxVar = new zzx(zzb, zzb3, zzas.zza, zzavVar, zzb2, zzb4, zzqVar, zzacVar, zzb5);
        this.zzl = zzxVar;
        this.zzm = zzdn.zzb(new zzk(zzb2, zzxVar, zzb4));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zza
    public final zzj zzb() {
        return (zzj) this.zzm.zza();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zza
    public final zzbo zzc() {
        return (zzbo) this.zze.zza();
    }
}
