package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdnw implements zzbkf {
    final /* synthetic */ zzdny zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzbkf zzd;

    /* synthetic */ zzdnw(zzdny zzdnyVar, WeakReference weakReference, String str, zzbkf zzbkfVar, zzdnx zzdnxVar) {
        Objects.requireNonNull(zzdnyVar);
        this.zza = zzdnyVar;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbkfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zzn(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
