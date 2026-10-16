package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdfg implements zzhgr {
    private final zzhha zza;

    private zzdfg(zzdff zzdffVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdfg zza(zzdff zzdffVar, zzhha zzhhaVar) {
        return new zzdfg(zzdffVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzddv((zzcur) this.zza.zzb(), zzcaf.zzg));
        zzhgz.zzb(singleton);
        return singleton;
    }
}
