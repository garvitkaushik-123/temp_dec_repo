package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdhu implements zzhgr {
    private final zzdhp zza;

    private zzdhu(zzdhp zzdhpVar) {
        this.zza = zzdhpVar;
    }

    public static zzdhu zza(zzdhp zzdhpVar) {
        return new zzdhu(zzdhpVar);
    }

    public static zzdny zzd(zzdhp zzdhpVar) {
        zzdny zzc = zzdhpVar.zzc();
        zzhgz.zzb(zzc);
        return zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final zzdny zzc() {
        return zzd(this.zza);
    }
}
