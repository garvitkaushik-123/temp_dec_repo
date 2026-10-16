package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcph implements zzhgr {
    private final zzhha zza;

    private zzcph(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcph zza(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcph(zzcozVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfyv zzo = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmY)).booleanValue() ? zzfyv.zzo(new zzddv(((zzcql) this.zza).zzb(), zzcaf.zza)) : zzfyv.zzn();
        zzhgz.zzb(zzo);
        return zzo;
    }
}
