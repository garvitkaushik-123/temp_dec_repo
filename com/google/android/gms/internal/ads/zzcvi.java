package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcvi implements zzhgr {
    private final zzcvh zza;
    private final zzhha zzb;

    private zzcvi(zzcvh zzcvhVar, zzhha zzhhaVar) {
        this.zza = zzcvhVar;
        this.zzb = zzhhaVar;
    }

    public static zzcvi zza(zzcvh zzcvhVar, zzhha zzhhaVar) {
        return new zzcvi(zzcvhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return this.zza.zzf((String) this.zzb.zzb());
    }
}
