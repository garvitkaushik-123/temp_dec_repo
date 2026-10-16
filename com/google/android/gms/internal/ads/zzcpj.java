package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcpj implements zzhgr {
    private final zzcoz zza;
    private final zzhha zzb;

    private zzcpj(zzcoz zzcozVar, zzhha zzhhaVar) {
        this.zza = zzcozVar;
        this.zzb = zzhhaVar;
    }

    public static zzcpj zza(zzcoz zzcozVar, zzhha zzhhaVar) {
        return new zzcpj(zzcozVar, zzhhaVar);
    }

    public static Set zzc(zzcoz zzcozVar, zzcqp zzcqpVar) {
        Set singleton = Collections.singleton(new zzddv(zzcqpVar, zzcaf.zzg));
        zzhgz.zzb(singleton);
        return singleton;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (zzcqp) this.zzb.zzb());
    }
}
