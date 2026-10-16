package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzchz implements zzhgr {
    private final zzchh zza;

    private zzchz(zzchh zzchhVar) {
        this.zza = zzchhVar;
    }

    public static VersionInfoParcel zzc(zzchh zzchhVar) {
        VersionInfoParcel zze = zzchhVar.zze();
        zzhgz.zzb(zze);
        return zze;
    }

    public static zzchz zzd(zzchh zzchhVar) {
        return new zzchz(zzchhVar);
    }

    public final VersionInfoParcel zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
