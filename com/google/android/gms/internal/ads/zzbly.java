package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbly implements zzgcu {
    final /* synthetic */ zzblq zza;

    zzbly(zzbmc zzbmcVar, zzblq zzblqVar) {
        this.zza = zzblqVar;
        Objects.requireNonNull(zzbmcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzcak zzcakVar = new zzcak();
        ((zzblw) obj).zze(this.zza, new zzblx(this, zzcakVar));
        return zzcakVar;
    }
}
