package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdfy implements zzhgr {
    private final zzdff zza;
    private final zzhha zzb;

    private zzdfy(zzdff zzdffVar, zzhha zzhhaVar) {
        this.zza = zzdffVar;
        this.zzb = zzhhaVar;
    }

    public static zzdfy zza(zzdff zzdffVar, zzhha zzhhaVar) {
        return new zzdfy(zzdffVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzd((Executor) this.zzb.zzb());
    }
}
