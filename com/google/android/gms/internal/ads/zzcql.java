package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcql implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcql(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzcql zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcql(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcqk zzb() {
        return new zzcqk(((zzcpq) this.zza).zza(), (Executor) this.zzb.zzb());
    }
}
