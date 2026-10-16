package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdhc implements zzhgr {
    private final zzhha zza;

    private zzdhc(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdhc zza(zzhha zzhhaVar) {
        return new zzdhc(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = ((zzdgz) this.zza).zzc().zze() != null ? Collections.singleton("banner") : Collections.emptySet();
        zzhgz.zzb(singleton);
        return singleton;
    }
}
