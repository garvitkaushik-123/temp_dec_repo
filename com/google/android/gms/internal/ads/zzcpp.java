package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcpp implements zzhgr {
    private final zzhha zza;

    private zzcpp(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcpp zza(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcpp(zzcozVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        final zzcyv zzc = ((zzcqv) this.zza).zzc();
        return new zzddv(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcoy
            @Override // com.google.android.gms.internal.ads.zzdas
            public final void zza() {
                zzcyv.this.zza();
            }
        }, zzcaf.zzg);
    }
}
