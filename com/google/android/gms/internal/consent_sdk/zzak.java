package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
final class zzak implements zzax {
    final zzdr zza;
    final zzdr zzb;
    final zzdr zzc;
    final zzdr zzd;
    final zzdr zze;
    private final zzah zzf;

    zzak(zzah zzahVar, zzbq zzbqVar) {
        this.zzf = zzahVar;
        zzdr zzb = zzdn.zzb(new zzby(zzahVar.zza));
        this.zza = zzb;
        zzdo zzb2 = zzdp.zzb(zzbqVar);
        this.zzb = zzb2;
        zzdm zzdmVar = new zzdm();
        this.zzc = zzdmVar;
        zzdr zzdrVar = zzahVar.zza;
        zzat zzatVar = zzas.zza;
        zzav zzavVar = zzau.zza;
        zzdr zzdrVar2 = zzahVar.zzg;
        zzdr zzdrVar3 = zzahVar.zzj;
        zzdr zzdrVar4 = zzahVar.zzb;
        zzcc zzccVar = new zzcc(zzdrVar, zzb, zzatVar, zzavVar, zzdrVar2, zzdrVar3, zzdmVar, zzdrVar4);
        this.zzd = zzccVar;
        zzbw zzbwVar = new zzbw(zzb, zzatVar, zzccVar);
        this.zze = zzbwVar;
        zzdm.zzb(zzdmVar, zzdn.zzb(new zzbd(zzdrVar, zzahVar.zzc, zzb, zzdrVar4, zzb2, zzbwVar)));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzax
    public final zzbc zza() {
        return (zzbc) this.zzc.zza();
    }
}
