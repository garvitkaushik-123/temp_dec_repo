package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzchl implements zzhgr {
    private final zzchh zza;

    private zzchl(zzchh zzchhVar) {
        this.zza = zzchhVar;
    }

    public static Context zzc(zzchh zzchhVar) {
        Context zzb = zzchhVar.zzb();
        zzhgz.zzb(zzb);
        return zzb;
    }

    public static zzchl zzd(zzchh zzchhVar) {
        return new zzchl(zzchhVar);
    }

    public final Context zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
