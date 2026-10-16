package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdbx implements zzhgr {
    private final zzdbw zza;
    private final zzhha zzb;

    private zzdbx(zzdbw zzdbwVar, zzhha zzhhaVar) {
        this.zza = zzdbwVar;
        this.zzb = zzhhaVar;
    }

    public static zzdbx zza(zzdbw zzdbwVar, zzhha zzhhaVar) {
        return new zzdbx(zzdbwVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcwa zza = this.zza.zza(((zzhhd) this.zzb).zzb());
        zzhgz.zzb(zza);
        return zza;
    }
}
